package InfallibleRevKiller;


import java.awt.Graphics;

import javax.swing.SwingUtilities;

import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.bot.Context;
import org.powerbot.game.bot.event.listener.PaintListener;

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import InfallibleRevKiller.Container.*;

@Manifest(authors = { "sjesper" }, name = "UltraRevKiller", description = "Kills Revenants For Money", version = 1.0)
public class InfallibleRevKiller extends ActiveScript implements PaintListener {
	
	private static void SetupGUI() {
		try {
            SwingUtilities.invokeLater(new Runnable() {
            	public void run() {
            		InfallibleRevKiller_GUI g = new InfallibleRevKiller_GUI();
            		g.setVisible(true);
            	}
            });
		} catch (Throwable e) {
			//Error
        }
	}
	
	@Override
	protected void setup() {
		function.SetRevIDS();
		Const.EQUIPED = Equipment.getAppearanceIds();		
		Const.startTime = System.currentTimeMillis();
		Const.XP_START = function.GetXPMulti();
		SetupGUI();
	}
	
	public static void provideStrategy(final Strategy s) {
		((InfallibleRevKiller)Context.get().getActiveScript()).provide(s);
	}

	
	public void onRepaint(Graphics g1) {
		InfallibleRevKiller_Paint.onRepaint(g1);
	}

}