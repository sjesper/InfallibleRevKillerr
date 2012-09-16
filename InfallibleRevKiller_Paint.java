package InfallibleRevKiller;

import java.awt.*;
import javax.imageio.ImageIO;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.GroundItem;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import InfallibleRevKiller.Container.*;

public class InfallibleRevKiller_Paint {
	// START: Code generated using Enfilade's Easel
	private final static RenderingHints antialiasing = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	private static Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}

	private final static Color color1 = new Color(0, 0, 0);
	
	private final static Color color2 = new Color(0, 0, 0);
	
	private final static Color color3 = new Color(200, 25, 25);

	private final static Font font1 = new Font("Elephant", 0, 18);
	
	private final static Font font2 = new Font("Elephant", 0, 16);
	
	private final static Font font3 = new Font("Elephant", 0, 13);

	private final static Image img1 = getImage("http://i45.tinypic.com/na0l5.jpg");
	
	public static void onRepaint(Graphics g1) {
		long runTime = System.currentTimeMillis() - Const.startTime;
		
		Const.XP_EARNED = function.GetXPMulti();
		
		Const.XP_EARNED = Const.XP_EARNED - Const.XP_START;
		Const.XP_EARNED_H = (int) ((Const.XP_EARNED) * 3600000D / (System.currentTimeMillis() - Const.startTime));
		Const.PROFIT_H = (int) ((Const.PROFIT) * 3600000D / (System.currentTimeMillis() - Const.startTime));
		
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHints(antialiasing);
		g.drawImage(img1, 1, 387, null);
		g.setFont(font2);
		g.setColor(color2);
		//Draw Mouse
		g.setColor(color3);
		g.fillOval(Mouse.getX() - 6, Mouse.getY() - 6, 10, 10);
		g.setColor(color2);
		
		g.fillRect(Mouse.getPressX() - 4, Mouse.getPressY() - 4, 5, 5);
		g.setColor(color2);
		//Draw loot		
		for (int i = 0; i < Const.LAST_LOOTS.size(); i++) {
			g.drawString("Last looted: ", 5, 75);
			g.drawString(" - " + Const.LAST_LOOTS.get(i), 5, 95 + (i * 15));
		}
		
		//Draw PKers
		int PKers = function.AmountOfPkers();
		if (PKers < 3) {
			g.drawString("Number of pk'ers: " + function.AmountOfPkers(), 5, 383);
		} else {
			g.drawString("Number of pk'ers: " + function.AmountOfPkers() + ". Teleporting away", 5, 383);
		}
		//Getting npcs
		g.setFont(font3);
		String[] S = function.GetAllNpcs();
		for (int i = 0; i < 10; i++) {
			if (i > S.length - 1)
				break;
			g.drawString(S[i], 280, 65 + (i * 13));
		}
		
		g.setFont(font1);
		g.setColor(color1);
		
		g.drawString("Time running:", 20, 455);
		g.drawString("Xp earned", 21, 485);
		g.drawString("Xp earned/h:", 20, 514);
		g.drawString("Profit:", 293, 455);
		g.drawString("Profit/h:", 293, 484);
		g.drawString("Status:", 220, 515);
		g.drawString(Time.format(runTime), 155, 456);
		g.drawString(Integer.toString(Const.XP_EARNED), 123, 485);
		g.drawString(Integer.toString(Const.XP_EARNED_H), 140, 514);
		g.drawString(function.SetCommas(Const.PROFIT) + " gp", 355, 456);
		g.drawString(function.SetCommas(Const.PROFIT_H) + " gp", 374, 485);
		g.drawString(Const.STATUS, 285, 515);
	}
	// END: Code generated using Enfilade's Easel
}
