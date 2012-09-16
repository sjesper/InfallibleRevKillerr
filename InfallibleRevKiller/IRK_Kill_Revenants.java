package InfallibleRevKiller;

import java.awt.ItemSelectable;
import java.io.IOException;
import java.util.HashMap;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Prayer;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.GroundItem;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.node.SceneObject;

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import InfallibleRevKiller.Container.Const;
import InfallibleRevKiller.Container.function;

public class IRK_Kill_Revenants extends Strategy implements Runnable {

	static String id = "";

	private static int getPrice(int itemID) {
		try {
			final URL url = new URL(
					"http://open.tip.it/json/ge_single_item?item=" + itemID);
			URLConnection con = url.openConnection();
			final BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String line = "";
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				line += inputLine;
				if (inputLine.contains("mark_price")) {
					line = line.substring(line.indexOf("mark_price\":\"")
							+ "mark_price\":\"".length());
					line = line.substring(0, line.indexOf("\""));
					return Integer.parseInt(line.replaceAll(",", ""));
				}
			}
			in.close();
		} catch (Exception e) {
		}
		return -1;
	}

	private void usePrayer() {
		if (!Prayer.isQuickOn() && Inventory.contains(Const.PRAYER_POTS_AMOUNT))
			Prayer.flashQuick();
		Time.sleep(1000, 1500);
	}

	private void Loot() {
		GroundItem[] item = GroundItems.getLoaded();
		if (item != null) {
			for (GroundItem I : item) {
				if (I != null) {
					if (I.getId() == 995)
						continue;
					if (!Const.Items.containsKey(I.getId())) {
						Const.Items.put(I.getId(), getPrice(I.getId()));
						if (Const.Items.get(I.getId()) > 10) {
							if (I.isOnScreen()) {
								I.interact("Take");
								Const.LAST_LOOTS.add(I.getGroundItem()
										.getName()
										+ " (Id: "
										+ I.getId()
										+ "). "
										+ " Value: "
										+ function.SetCommas(Const.Items.get(I
												.getId())));
								Const.STATUS = "Looting an item";
							} else {
								while (I != null && !I.isOnScreen())
									Walking.walk(I.getLocation());
							}

						}
					}
				}
			}
		}
	}

	private void Eat() {
		if (Players.getLocal().getHpPercent() < 60) {
			if (Inventory.contains(Const.FOOD_TYPE)) {
				Const.STATUS = "Eating";
				Inventory.getItem(Const.FOOD_TYPE).getWidgetChild()
						.interact("Eat");
				Time.sleep(2000, 2500);
			} else {
				function.TP_Away();
				Time.sleep(1000, 1500);
			}
		}
	}

	public void usePotions() {
		// Prayer
		if (Prayer.getPoints() < Skills.getLevel(Skills.PRAYER) * 100 * 0.4) {
			Item pot = Inventory.getItem(Const.PRAYER_POT_ID);
			if (pot != null) {
				pot.getWidgetChild().interact("Drink");
			} else {
				function.TP_Away();
			}
		}
		// Super Attack		
	}

	public void run() {
		Eat();
		Loot();
		function.AntiPK();
		NPC Revenant = NPCs.getNearest(Const.Rev);
		if (Revenant != null && Players.getLocal().getLocation().getY() > 10110) {
			usePrayer();
			if (Revenant.isOnScreen()) {
				if (Players.getLocal().isIdle()) {
					if (Const.ATTACK_ATTACKED) {
						if (!Players.getLocal().isInCombat()) {
							Revenant.click(false);
							Revenant.interact("Attack");
							Time.sleep(1500, 2000);
							Const.STATUS = "Killing revenants";
						}
					} else {
						if (Revenant.getInteracting().getLocation() != Players
								.getLocal().getLocation()) {
							if (!Players.getLocal().isInCombat()) {
								Revenant.click(false);
								Revenant.interact("Attack");
								Time.sleep(1500, 2000);
								Const.STATUS = "Killing revenants";
							}
						}
					}
				}
			} else {
				Walking.walk(Revenant.getLocation());

			}
		} else {
			// Const.STATUS = "Walking to a rev: " + function.AmountOfPkers();
			Walking.walk(Const.revTile);
			Time.sleep(2000, 2500);
		}
	}

	public boolean validate() {
		return Game.getClientState() != 12 && function.inCave();
	}

}
