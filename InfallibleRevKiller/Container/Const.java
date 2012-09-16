package InfallibleRevKiller.Container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

import InfallibleRevKiller.InfallibleRevKiller_GUI;

public class Const {
	//Equiped
	public static int[] EQUIPED = null;
	
	// Other
	public static boolean FirstTime = true;
	public static long UseForrin = 0;
	public static long UsedForrin = 1;
	
	// Paths
	public static final Tile[] toCave = new Tile[] { new Tile(3086, 3524, 0), new Tile(3086, 3528, 0), new Tile(3083, 3531, 0), 
		new Tile(3081, 3535, 0), new Tile(3080, 3539, 0), new Tile(3078, 3543, 0), 
		new Tile(3077, 3547, 0), new Tile(3075, 3551, 0), new Tile(3074, 3555, 0), 
		new Tile(3074, 3559, 0), new Tile(3074, 3563, 0), new Tile(3074, 3567, 0), 
		new Tile(3074, 3571, 0), new Tile(3073, 3575, 0), new Tile(3073, 3579, 0), 
		new Tile(3073, 3583, 0), new Tile(3073, 3587, 0), new Tile(3073, 3591, 0), 
		new Tile(3073, 3595, 0), new Tile(3073, 3599, 0), new Tile(3073, 3603, 0), 
		new Tile(3073, 3607, 0), new Tile(3072, 3611, 0), new Tile(3072, 3615, 0), 
		new Tile(3072, 3619, 0), new Tile(3072, 3623, 0), new Tile(3072, 3627, 0), 
		new Tile(3072, 3631, 0), new Tile(3072, 3635, 0), new Tile(3071, 3639, 0), 
		new Tile(3071, 3643, 0), new Tile(3071, 3648, 0) };

	// Paint
	public static List<Tile> TILES = new ArrayList<Tile>();
	public static List<String> LAST_LOOTS = new ArrayList<String>();
	public static int[] XP = new int[4];
	public static int XP_START;
	public static int XP_EARNED;
	public static int XP_EARNED_H;
	public static int PROFIT;
	public static int PROFIT_H;
	public static String STATUS = "Loading";
	public static long startTime;

	// Objects
	public static int[] WALLS_ID = { 65086, 65079, 65077, 65094, 65084 };
	public static int CAVE_ID = 20600;

	// Items ID
	public static HashMap<Integer, Integer> Items = new HashMap<Integer, Integer>();
	public static final int GLORY_4_ID = 1712;
	public static final int GLORY_0_ID = 1708;
	public static final int FORTUNE_ID = 2554;
	public static final int[] PRAYER_POT_ID = {143, 141, 139, 2434};
	public static final int[] SUPER_PRAYER_ID = {15331, 15330, 15329, 15328};
	public static final int[] SUPER_ATT_ID = {149, 147, 145, 2436};
	public static final int[] SUPER_STR_ID = {161, 159, 157, 2440};
	public static final int[] EXTREME_ATT_ID = {15311, 15310, 15309, 15308};
	public static final int[] EXTREME_STR_ID = {15315, 15314, 15313, 15312};
	public static final int SHARK_ID = 385;
	public static final int MONK_FISH_ID = 7946;
	public static final int SWORD_FISH_ID = 373;
	public static final int TUNA_ID = 361;
	public static HashMap<Integer, Integer> FORINTHRY_BRACE_ID = new HashMap<Integer, Integer>();

	// Monster ID
	public static int[] Rev = new int[14];	
	public static Boolean GOT_REV_ID = false;
	public static final int IMP_ID = 13465; //Yes
	public static final int[] GOBLIN_ID = {13466, 13466, 13469, 13468};
	public static final int ICEFIEND_ID = 13470;
	public static final int PYREFIEND_ID = 13471; //Yes
	public static final int HOBGOBLIN_ID = 13472;// Yes
	public static final int VAMPYRE_ID = 13473; // Yes
	public static final int WEREWOLF_ID = 13474; //Yes
	public static final int CYCLOPS_ID = 13475; // Yes
	public static final int HELLHOUND_ID = 13476; // Yes
	public static final int DEMON_ID = 13477; //Yes
	public static final int ORK_ID = 13478; //Yes
	public static final int DARK_BEAST_ID = 13479; //Yes

	// Tiles
	public static final Tile caveTile = new Tile(3071, 3647, 0);
	public static final Tile bankTile = new Tile(3094, 3497, 0);
	public static Random random = new Random();
	static int i = random.nextInt(5);
	public static final Tile wallTile = new Tile(3087 + i, 3519, 0);
	public static final Tile revTile = new Tile(3107 + i, 10141 + i, 0);
	// Areas
	public static Area lowerCaveArea = new Area(new Tile[] {
			new Tile(3010, 10040, 0), new Tile(3170, 10040, 0),
			new Tile(3080, 10136, 0), new Tile(3150, 10137, 0) });
	public static Area wildernessWallArea = new Area(new Tile[] {
			new Tile(3040, 3521, 0), new Tile(3040, 3522, 0),
			new Tile(3123, 3522, 0), new Tile(3123, 3521, 0) });
	public static Area edgevileArea = new Area(new Tile[] {
			new Tile(3040, 3521, 0), new Tile(3125, 3521, 0),
			new Tile(3125, 3477, 0), new Tile(3040, 3476, 0) });
	public static Area bankArea = new Area(new Tile[] {
			new Tile(3099, 3486, 0), new Tile(3099, 3500, 0),
			new Tile(3089, 3500, 0), new Tile(3089, 3486, 0),
			new Tile(3099, 3486, 0) });

	// States
	public static boolean bankNow = true;

	// GUI
	public static boolean guiWait = true;
	// Potions
	public static int PRAYER_POTS_AMOUNT;
	public static int SUPER_PRAYER_POTS_AMOUNT;
	public static int SUPER_ATT_POTS_AMOUNT;
	public static int SUPER_STR_POTS_AMOUNT;
	public static int EXTREME_ATT_POTS_AMOUNT;
	public static int EXTREME_STR_POTS_AMOUNT;
	// Food
	public static int FOOD_TYPE;
	public static int FOOD_AMOUNT;
	// Brace
	public static boolean USE_FORINTHRY;
	// Monsters
	public static boolean ATT_IMP;
	public static boolean ATT_GOBLIN;
	public static boolean ATT_ICEFIEND;
	public static boolean ATT_PYREFIEND;
	public static boolean ATT_HOBGOBLIN;
	public static boolean ATT_VAMPYRE;
	public static boolean ATT_WEREWOLF;
	public static boolean ATT_CYCLOPS;
	public static boolean ATT_HELLHOUND;
	public static boolean ATT_DEMON;
	public static boolean ATT_ORK;
	public static boolean ATT_DARK_BEAST;
	// Combat settings
	public static boolean ATTACK_ATTACKED;

}
