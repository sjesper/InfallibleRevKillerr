package InfallibleRevKiller;

import java.util.Map;

import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.TilePath;
import org.powerbot.game.api.wrappers.node.SceneObject;

import InfallibleRevKiller.Container.*;

public class IRK_Walk_To_Cave extends Strategy implements Runnable {

	public void run() {
		if (Const.edgevileArea.contains(Players.getLocal().getLocation())) {
			if (!Const.wallTile.isOnScreen()) {

				Const.STATUS = "" + Skills.getLevelAt(Skills.ATTACK);
				Walking.walk(Const.wallTile);
				Time.sleep(1500, 2000);
			}
			//Getting the wall
			SceneObject Wall = null;
			SceneObject[] Walls = SceneEntities.getLoaded(Const.WALLS_ID);
			for (int i = 0; i < Walls.length; i++) {
				if (Const.wildernessWallArea.contains(Walls[i].getLocation())) {
					if (Calculations.distanceTo(Walls[i]) < 6) {
						Wall = Walls[i];
						Const.STATUS = "Clicking on the wall";
					}
				}
			}
			
		//Clicking/Walking to the wall
			if (Wall != null) {
				if (!Wall.isOnScreen()) {
					Walking.walk(Wall.getLocation());
					Time.sleep(1000, 1200);
				} else {
					if (Players.getLocal().isIdle()) {
						Wall.interact("Cross");
						long endTime = System.currentTimeMillis() + 4000;
						while (Players.getLocal().getAnimation() != 6703) {
							if (System.currentTimeMillis() > endTime) {
								break;
							}
							Time.sleep(300, 600);
						}
					}
				}
			}
		} else if (!Const.edgevileArea.contains(Players.getLocal().getLocation())) {
			Const.STATUS = "Walking to the cave";
			if (!Const.caveTile.isOnScreen()) {
				if (Walking.newTilePath(Const.toCave).traverse() == false) {
					Walking.walk(Const.caveTile);
				}
				Time.sleep(2000, 2500);
			} else {
				try {
					SceneObject Cave = SceneEntities.getNearest(Const.CAVE_ID);
						if (Cave != null) {
							Cave.interact("Enter");
							long endTime = System.currentTimeMillis() + 2000;
							while (Cave.isOnScreen()) {
								if (System.currentTimeMillis() > endTime)
									break;
								Time.sleep(300, 600);
							}
						}
				} catch(Exception e){
					SceneObject Cave = SceneEntities.getNearest(Const.CAVE_ID);
					Camera.turnTo(Cave);
				}
			}
			function.AntiPK();
		}
	}

	public boolean validate() {
		return Game.getClientState() != 12
				&& function.GotAllItems()
				&& !function.inCave();
	}

}