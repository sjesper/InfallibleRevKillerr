package InfallibleRevKiller;

import java.awt.ItemSelectable;

import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.node.SceneObject;

import com.sun.org.apache.xml.internal.utils.StopParseException;

import InfallibleRevKiller.Container.*;

public class IRK_Bank extends Strategy implements Runnable {

	public void Withdraw() {
		Bank.depositInventory();
		if (Equipment.getAppearanceIds() == null) {
			for (int iID : Const.EQUIPED)
				Bank.withdraw(iID, 1);
			Bank.close();
			for (int iID : Const.EQUIPED)
				Inventory.getItem(iID).getWidgetChild().interact("Wear");
		}
		if (Equipment.getAppearanceId(Equipment.Slot.NECK) == Const.GLORY_0_ID
				| Equipment.getAppearanceId(Equipment.Slot.NECK) == -1) {
			Const.STATUS = "Taking a new amulet of glory";
			Bank.withdraw(Const.GLORY_4_ID, 1);
			long endTime = System.currentTimeMillis() + 3000;
			while (!Inventory.contains(Const.GLORY_4_ID)) {
				if (System.currentTimeMillis() > endTime) {
					break;
				}
				Time.sleep(500, 800);
			}
			Time.sleep(500, 600);
			Item Glory = Inventory.getItem(Const.GLORY_4_ID);
			Glory.getWidgetChild().interact("Wear");

		}
		int USE_ID = 0;
		if (System.currentTimeMillis() > Const.UseForrin) {
			if (Bank.getItemCount(Const.FORINTHRY_BRACE_ID.get(1)) < 1) {
				if (Bank.getItemCount(Const.FORINTHRY_BRACE_ID.get(2)) < 1) {
					if (Bank.getItemCount(Const.FORINTHRY_BRACE_ID.get(3)) < 1) {
						if (Bank.getItemCount(Const.FORINTHRY_BRACE_ID.get(4)) < 1) {
							if (Bank.getItemCount(Const.FORINTHRY_BRACE_ID
									.get(5)) < 1) {
								while (0 == 0) {
									Time.sleep(500);
								}
							} else {
								USE_ID = 5;
							}
						} else {
							USE_ID = 4;
						}
					} else {
						USE_ID = 3;
					}
				} else {
					USE_ID = 2;
				}
			} else {
				USE_ID = 1;
			}
			Bank.withdraw(Const.FORINTHRY_BRACE_ID.get(USE_ID), 1);
			long endTime = System.currentTimeMillis() + 3000;
			while (!Inventory.contains(Const.FORINTHRY_BRACE_ID.get(USE_ID))) {
				if (System.currentTimeMillis() > endTime) {
					break;
				}
				Time.sleep(500, 800);
			}

			Bank.close();
			Time.sleep(400, 500);
			Item Fori = Inventory.getItem(Const.FORINTHRY_BRACE_ID.get(USE_ID));
			Fori.getWidgetChild().interact("Repel");
			Const.UsedForrin = System.currentTimeMillis();
			Const.UseForrin = Const.UsedForrin * (40 * 60 * 1000);
		}
		if (Const.PRAYER_POTS_AMOUNT != -1) {
			Bank.withdraw(Const.PRAYER_POT_ID[0], Const.PRAYER_POTS_AMOUNT);
		}
		if (Const.SUPER_ATT_POTS_AMOUNT != -1) {
			Bank.withdraw(Const.SUPER_ATT_ID[0], Const.SUPER_ATT_POTS_AMOUNT);
		}
		if (Const.SUPER_STR_POTS_AMOUNT != -1) {
			Bank.withdraw(Const.SUPER_STR_ID[0], Const.SUPER_STR_POTS_AMOUNT);
		}
		if (Const.EXTREME_ATT_POTS_AMOUNT != -1) {
			Bank.withdraw(Const.EXTREME_ATT_ID[0],
					Const.EXTREME_ATT_POTS_AMOUNT);
		}
		if (Const.EXTREME_STR_POTS_AMOUNT != -1) {
			Bank.withdraw(Const.EXTREME_STR_ID[0],
					Const.EXTREME_STR_POTS_AMOUNT);
		}
		if (Const.FOOD_AMOUNT != -1) {
			Bank.withdraw(Const.FOOD_TYPE, Const.FOOD_AMOUNT);
		}
		Bank.close();
	}

	public void run() {
		Const.STATUS = "Banking";
		if (Bank.isOpen()) {
			Withdraw();
		} else {
			SceneObject BankBooths = SceneEntities
					.getNearest(Bank.BANK_COUNTER_IDS);
			if (!Players.getLocal().isMoving()) {
				if (BankBooths != null) {
					if (BankBooths.isOnScreen()) {
						if (!Bank.isOpen()) {
							Bank.open();
							long endTime = System.currentTimeMillis() + 4000;
							while (!Bank.isOpen()) {
								if (System.currentTimeMillis() > endTime) {
									break;
								}
								Time.sleep(300, 600);
							}
						} else {
							Withdraw();
						}
					} else {
						Walking.walk(BankBooths.getLocation());
					}
				} else {
					if (!Const.bankArea.contains(Players.getLocal()
							.getLocation())) {
						Walking.walk(Const.bankTile);
					}
				}
			}
		}
	}

	public boolean validate() {
		if (Walking.getEnergy() > 50 && !Walking.isRunEnabled())
			Walking.setRun(true);
		if (Const.FirstTime)
			function.SetRevIDS();
			Const.FirstTime = false;
		return Game.getClientState() != 12
				&& function.GotAllItems() == false
				&& !function.inCave()
				&& Const.edgevileArea
						.contains(Players.getLocal().getLocation());
	}
}