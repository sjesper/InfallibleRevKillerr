package InfallibleRevKiller.Container;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JTextField;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Equipment.Slot;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.methods.widget.Bank.Tab;
import org.powerbot.game.api.methods.widget.Lobby;
import org.powerbot.game.api.methods.widget.Lobby.World;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.interactive.Player;
import org.powerbot.game.api.wrappers.widget.Widget;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import InfallibleRevKiller.Container.*;

public class function {

	public static int JTFToStr(JTextField JTF) {
		String s = JTF.getText();
		if (s == null) {
			return -1;
		} else {
			try {
				return Integer.parseInt(s);
			} catch (NumberFormatException e) {
				return -1;
			}

		}
	}

	public static void SetRevIDS() {
		if (Const.ATT_CYCLOPS == true)
			Const.Rev[0] = Const.CYCLOPS_ID;
		if (Const.ATT_DARK_BEAST == true)
			Const.Rev[1] = Const.DARK_BEAST_ID;
		if (Const.ATT_DEMON == true)
			Const.Rev[2] = Const.DEMON_ID;
		if (Const.ATT_GOBLIN == true)
			Const.Rev[3] = Const.GOBLIN_ID[0];
		if (Const.ATT_GOBLIN == true)
			Const.Rev[4] = Const.GOBLIN_ID[1];
		if (Const.ATT_GOBLIN == true)
			Const.Rev[5] = Const.GOBLIN_ID[2];
		if (Const.ATT_HELLHOUND == true)
			Const.Rev[6] = Const.HELLHOUND_ID;
		if (Const.ATT_HOBGOBLIN == true)
			Const.Rev[7] = Const.HOBGOBLIN_ID;
		if (Const.ATT_ICEFIEND == true)
			Const.Rev[8] = Const.ICEFIEND_ID;
		if (Const.ATT_IMP == true)
			Const.Rev[9] = Const.IMP_ID;
		if (Const.ATT_ORK == true)
			Const.Rev[10] = Const.ORK_ID;
		if (Const.ATT_PYREFIEND == true)
			Const.Rev[11] = Const.PYREFIEND_ID;
		if (Const.ATT_VAMPYRE == true)
			Const.Rev[12] = Const.VAMPYRE_ID;
		if (Const.ATT_WEREWOLF == true)
			Const.Rev[13] = Const.WEREWOLF_ID;
		Const.FORINTHRY_BRACE_ID.put(1, 11103);
		Const.FORINTHRY_BRACE_ID.put(2, 11101);
		Const.FORINTHRY_BRACE_ID.put(3, 11099);
		Const.FORINTHRY_BRACE_ID.put(4, 11097);
		Const.FORINTHRY_BRACE_ID.put(5, 11095);
	}

	public static String[] GetAllNpcs() {
		NPC[] Rev = NPCs.getLoaded();
		List<String> S = new ArrayList<String>();

		for (NPC N : Rev) {
			S.add("NPC Name: " + N.getName() + ". ID: " + N.getId());
		}
		String[] ToArray = S.toArray(new String[S.size()]);
		return ToArray;
	}

	public static void switch_World() {
		Game.logout(true);
		Time.sleep(2000, 2500);
		Widgets.get(906, 28).click(true);
		World[] worlds = Lobby.getWorlds();
		for (int i = 0; i > 139; i++) {
			if (worlds[i].isMembers() == true) {
				worlds[i].click();
				Const.STATUS = "Clicking";
			}
		}
	}

	public static boolean AtRevs() {
		NPC rev = NPCs.getNearest(Const.Rev);
		if (rev != null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean inCave() {
		Tile currentTile = Players.getLocal().getLocation();
		return (currentTile.getY() > 9000);
	}

	public static int getWildernessLevel() {
		Widget W = Widgets.get(381);
		if (W.validate()) {
			String s = Widgets.get(381).getText();
			String s2 = s.substring(9, 10);
			return Integer.parseInt(s2);
		}
		return 0;
	}

	public static void getEquiped() {

	}

	public static void TP_Away() {
		if (!Tabs.EQUIPMENT.isOpen())
			Tabs.EQUIPMENT.open();
		Equipment.getItem(Slot.NECK).getWidgetChild().interact("Edgeville");
	}

	public static void AntiPK() {
		if (AmountOfPkers() >= 3 && getWildernessLevel() > 0) {
			TP_Away();
		}
		if (Players.getLocal().isInCombat()) {
			Player[] AllPlayers = Players.getLoaded();
			if (AllPlayers != null) {
				for (Player p : AllPlayers) {
					if (p.getModel() == Players.getLocal().getModel()) {
						Const.STATUS = "A player is attacking us";
						TP_Away();
					}
				}
			}
		}
	}

	public static int getRealLvl() {
		WidgetChild CBLvl = Widgets.get(884).getChild(1);
		String s = CBLvl.getText();
		String s2 = s.substring(12, 15);
		if (s2.endsWith("+"))
			s2 = s2.substring(0, 2);
		return Integer.parseInt(s2);
	}

	public static int AmountOfPkers() {
		Player[] AllPlayers = Players.getLoaded();
		int Amount = 0;
		int WildCBLvl = Players.getLocal().getLevel();
		if (AllPlayers != null) {
			for (Player p : AllPlayers) {
				if (p.getName() != Players.getLocal().getName()) {
					// Const.STATUS = "Lvl:" + (p.getLevel() -
					// getWildernessLevel());
					if (WildCBLvl - 1 < p.getLevel()
							+ getWildernessLevel())
						if (WildCBLvl + 1 > p.getLevel()
								- getWildernessLevel()
								&& p.getSkullIcon() == 0
								&& Calculations.distanceTo(p.getLocation()) < 2
								&& WildCBLvl < p.getLevel()
										+ getWildernessLevel()) {
							Amount = Amount + 1;
						}
				}
				p.getLevel();
			}
			return Amount;
		}
		return -1;
	}

	public static int GetXPMulti() {
		int[] XP = new int[4];
		int Total = 0;
		XP[0] = Skills.getExperience(Skills.CONSTITUTION);
		XP[1] = Skills.getExperience(Skills.ATTACK);
		XP[2] = Skills.getExperience(Skills.STRENGTH);
		XP[3] = Skills.getExperience(Skills.DEFENSE);
		for (int i = 0; i < 4; i++) {
			Total = Total + XP[i];
		}
		return Total;
	}

	public static boolean GotAllItems() {
		if (Const.FOOD_AMOUNT == Inventory.getCount(Const.FOOD_TYPE)
				| Const.FOOD_AMOUNT == -1) {
			if (Const.PRAYER_POTS_AMOUNT == Inventory
					.getCount(Const.PRAYER_POT_ID)
					| Const.PRAYER_POTS_AMOUNT == -1) {
				if (Const.SUPER_ATT_POTS_AMOUNT == Inventory
						.getCount(Const.SUPER_ATT_ID)
						| Const.SUPER_ATT_POTS_AMOUNT == -1) {
					if (Const.SUPER_STR_POTS_AMOUNT == Inventory
							.getCount(Const.SUPER_STR_ID)
							| Const.SUPER_STR_POTS_AMOUNT == -1) {
						if (Const.EXTREME_ATT_POTS_AMOUNT == Inventory
								.getCount(Const.EXTREME_ATT_ID)
								| Const.EXTREME_ATT_POTS_AMOUNT == -1) {
							if (Const.EXTREME_STR_POTS_AMOUNT == Inventory
									.getCount(Const.EXTREME_STR_ID)
									| Const.EXTREME_STR_POTS_AMOUNT == -1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public static String SetCommas(Integer I) {
		return NumberFormat.getNumberInstance(Locale.US).format(I);
	}

}
