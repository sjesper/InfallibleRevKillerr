package InfallibleRevKiller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import org.powerbot.concurrent.strategy.Strategy;

import InfallibleRevKiller.Container.*;


public class InfallibleRevKiller_GUI extends JFrame {	
	
	public InfallibleRevKiller_GUI() {
		initComponents();
	}

	private void Start_ScriptActionPerformed(ActionEvent e) {
		Const.ATT_CYCLOPS = Cyclops_Box.isSelected();
		Const.ATT_DARK_BEAST = Dark_Beast_Box.isSelected();
		Const.ATT_DEMON = Demon_Box.isSelected();
		Const.ATT_GOBLIN = Goblin_Box.isSelected();
		Const.ATT_HELLHOUND = Hellhound_Box.isSelected();
		Const.ATT_HOBGOBLIN = Hobgoblin_Box.isSelected();
		Const.ATT_ICEFIEND  = Icefiend_Box.isSelected();
		Const.ATT_IMP = Imp_Box.isSelected();
		Const.ATT_ORK = Ork_Box.isSelected();
		Const.ATT_PYREFIEND = Pyrefiend_Box.isSelected();
		Const.ATT_VAMPYRE = Vampyre_Box.isSelected();
		Const.ATT_WEREWOLF = Werewolf_Box.isSelected();
		Const.ATTACK_ATTACKED = Attack_Attacked_Box.isSelected();
		Const.PRAYER_POTS_AMOUNT = function.JTFToStr(Prayer_Potion_Text);
		Const.SUPER_ATT_POTS_AMOUNT = function.JTFToStr(Super_Attack_Text);
		Const.SUPER_PRAYER_POTS_AMOUNT = function.JTFToStr(Super_Prayer_Text);
		Const.SUPER_STR_POTS_AMOUNT = function.JTFToStr(SuperStrengthText);
		Const.EXTREME_ATT_POTS_AMOUNT = function.JTFToStr(Extreme_Attack_Text);
		Const.EXTREME_STR_POTS_AMOUNT = function.JTFToStr(Extreme_Strength_Text);
		Const.FOOD_TYPE = Food_ComboBox.getSelectedIndex();
		Const.FOOD_AMOUNT = function.JTFToStr(Food_Text);
		switch (Const.FOOD_TYPE) {
			case 0: Const.FOOD_TYPE = Const.SHARK_ID;
				break;
			case 1: Const.FOOD_TYPE = Const.MONK_FISH_ID;
				break;
			case 2: Const.FOOD_TYPE = Const.SWORD_FISH_ID;
				break;
			case 3: Const.FOOD_TYPE = Const.TUNA_ID;
				break;
		}
		InfallibleRevKiller.provideStrategy(new IRK_Kill_Revenants());
		InfallibleRevKiller.provideStrategy(new IRK_Bank());
		InfallibleRevKiller.provideStrategy(new IRK_Walk_To_Cave());
		Const.guiWait = false;
		setVisible(false);
		this.dispose();
	}

	private void initComponents() {
		label1 = new JLabel();
		tabbedPane1 = new JTabbedPane();
		panel1 = new JPanel();
		panel2 = new JPanel();
		Food_ComboBox = new JComboBox<>();
		label8 = new JLabel();
		Food_Text = new JTextField();
		panel3 = new JPanel();
		Extreme_Strength_Text = new JTextField();
		label2 = new JLabel();
		Prayer_Potion_Text = new JTextField();
		Super_Attack_Text = new JTextField();
		label3 = new JLabel();
		label4 = new JLabel();
		SuperStrengthText = new JTextField();
		Super_Prayer_Text = new JTextField();
		Extreme_Attack_Text = new JTextField();
		label7 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		panel7 = new JPanel();
		Forinthry_Box = new JCheckBox();
		panel4 = new JPanel();
		panel5 = new JPanel();
		label9 = new JLabel();
		Imp_Box = new JCheckBox();
		Goblin_Box = new JCheckBox();
		Icefiend_Box = new JCheckBox();
		Pyrefiend_Box = new JCheckBox();
		Hobgoblin_Box = new JCheckBox();
		Vampyre_Box = new JCheckBox();
		Werewolf_Box = new JCheckBox();
		Cyclops_Box = new JCheckBox();
		Hellhound_Box = new JCheckBox();
		Demon_Box = new JCheckBox();
		Ork_Box = new JCheckBox();
		Dark_Beast_Box = new JCheckBox();
		panel6 = new JPanel();
		Attack_Attacked_Box = new JCheckBox();
		Start_Script = new JButton();

		//======== this ========
		setTitle("UltraRevKiller");
		setMinimumSize(new Dimension(410, 300));
		Container contentPane = getContentPane();

		//---- label1 ----
		label1.setText("UltraRevKiller");
		label1.setFont(new Font("Tekton Pro", Font.BOLD, 31));

		//======== tabbedPane1 ========
		{

			//======== panel1 ========
			{

				// JFormDesigner evaluation mark
				panel1.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


				//======== panel2 ========
				{
					panel2.setBorder(new TitledBorder("Food"));

					//---- Food_ComboBox ----
					Food_ComboBox.setPrototypeDisplayValue("Choose food");
					Food_ComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
						"Shark",
						"Monkfish",
						"Swordfish",
						"Tuna"
					}));

					//---- label8 ----
					label8.setText("Number of food to bring:");

					GroupLayout panel2Layout = new GroupLayout(panel2);
					panel2.setLayout(panel2Layout);
					panel2Layout.setHorizontalGroup(
						panel2Layout.createParallelGroup()
							.addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(panel2Layout.createParallelGroup()
									.addComponent(Food_ComboBox)
									.addGroup(panel2Layout.createSequentialGroup()
										.addComponent(label8)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(Food_Text, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap())
					);
					panel2Layout.setVerticalGroup(
						panel2Layout.createParallelGroup()
							.addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(Food_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(label8)
									.addComponent(Food_Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
					);
				}

				//======== panel3 ========
				{
					panel3.setBorder(new TitledBorder("Potions"));

					//---- label2 ----
					label2.setText("Number of Prayer Potions:");

					//---- label3 ----
					label3.setText("Number of Super Attack:");

					//---- label4 ----
					label4.setText("Number of Super Strength:");

					//---- label7 ----
					label7.setText("Number of Super Prayer:");

					//---- label5 ----
					label5.setText("Number of Extreme Attack:");

					//---- label6 ----
					label6.setText("Number of Extreme Strength:");

					GroupLayout panel3Layout = new GroupLayout(panel3);
					panel3.setLayout(panel3Layout);
					panel3Layout.setHorizontalGroup(
						panel3Layout.createParallelGroup()
							.addGroup(panel3Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(panel3Layout.createParallelGroup()
									.addComponent(label2)
									.addComponent(label3)
									.addComponent(label4))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(panel3Layout.createParallelGroup()
									.addGroup(panel3Layout.createSequentialGroup()
										.addComponent(Prayer_Potion_Text, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(label7)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Super_Prayer_Text, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
									.addGroup(panel3Layout.createSequentialGroup()
										.addGroup(panel3Layout.createParallelGroup()
											.addComponent(Super_Attack_Text, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
											.addComponent(SuperStrengthText, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(panel3Layout.createParallelGroup()
											.addGroup(panel3Layout.createSequentialGroup()
												.addComponent(label5)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(Extreme_Attack_Text, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
											.addGroup(panel3Layout.createSequentialGroup()
												.addComponent(label6)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(Extreme_Strength_Text, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))))
								.addContainerGap())
					);
					panel3Layout.setVerticalGroup(
						panel3Layout.createParallelGroup()
							.addGroup(panel3Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(panel3Layout.createParallelGroup()
									.addComponent(label2)
									.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(Prayer_Potion_Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label7))
									.addComponent(Super_Prayer_Text, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel3Layout.createParallelGroup()
									.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(Super_Attack_Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label5)
										.addComponent(Extreme_Attack_Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(label3))
								.addGroup(panel3Layout.createParallelGroup()
									.addGroup(panel3Layout.createSequentialGroup()
										.addGap(5, 5, 5)
										.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(label6)
											.addComponent(Extreme_Strength_Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(SuperStrengthText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(panel3Layout.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(label4)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
				}

				//======== panel7 ========
				{
					panel7.setBorder(new TitledBorder("Brace"));

					//---- Forinthry_Box ----
					Forinthry_Box.setText("Use Forinthry Brace (One charge every banking)");

					GroupLayout panel7Layout = new GroupLayout(panel7);
					panel7.setLayout(panel7Layout);
					panel7Layout.setHorizontalGroup(
						panel7Layout.createParallelGroup()
							.addGroup(panel7Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(Forinthry_Box)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
					panel7Layout.setVerticalGroup(
						panel7Layout.createParallelGroup()
							.addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addComponent(Forinthry_Box))
					);
				}

				GroupLayout panel1Layout = new GroupLayout(panel1);
				panel1.setLayout(panel1Layout);
				panel1Layout.setHorizontalGroup(
					panel1Layout.createParallelGroup()
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
							.addComponent(panel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
				);
				panel1Layout.setVerticalGroup(
					panel1Layout.createParallelGroup()
						.addGroup(panel1Layout.createSequentialGroup()
							.addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(4, Short.MAX_VALUE))
				);
			}
			tabbedPane1.addTab("Bank settings", panel1);


			//======== panel4 ========
			{

				//======== panel5 ========
				{
					panel5.setBorder(new TitledBorder("Monsters"));

					//---- label9 ----
					label9.setText("Attack the monsters:");

					//---- Imp_Box ----
					Imp_Box.setText("Revenant Imp (Level 7)");
					Imp_Box.setSelected(true);

					//---- Goblin_Box ----
					Goblin_Box.setText("Revenant Goblin (Level 15/22/30/37)");
					Goblin_Box.setSelected(true);

					//---- Icefiend_Box ----
					Icefiend_Box.setText("Revenant Icefiend (Level 45)");
					Icefiend_Box.setSelected(true);

					//---- Pyrefiend_Box ----
					Pyrefiend_Box.setText("Revenants Pyrefiend (Level 52)");
					Pyrefiend_Box.setSelected(true);

					//---- Hobgoblin_Box ----
					Hobgoblin_Box.setText("Revenant Hobgoblin (Level 60)");
					Hobgoblin_Box.setSelected(true);

					//---- Vampyre_Box ----
					Vampyre_Box.setText("Revenant Vampyre (Level 68)");
					Vampyre_Box.setSelected(true);

					//---- Werewolf_Box ----
					Werewolf_Box.setText("Revenant Werewolf (Level 75)");
					Werewolf_Box.setSelected(true);

					//---- Cyclops_Box ----
					Cyclops_Box.setText("Revenant Cyclops (Level 82)");
					Cyclops_Box.setSelected(true);

					//---- Hellhound_Box ----
					Hellhound_Box.setText("Revenant Hellhound (Level 90)");
					Hellhound_Box.setSelected(true);

					//---- Demon_Box ----
					Demon_Box.setText("Revenant Demon (Level 98)");
					Demon_Box.setSelected(true);

					//---- Ork_Box ----
					Ork_Box.setText("Revenant Ork (Level 105)");
					Ork_Box.setSelected(true);

					//---- Dark_Beast_Box ----
					Dark_Beast_Box.setText("Revenant Dark Beast (Lvl120)");
					Dark_Beast_Box.setSelected(true);

					GroupLayout panel5Layout = new GroupLayout(panel5);
					panel5.setLayout(panel5Layout);
					panel5Layout.setHorizontalGroup(
						panel5Layout.createParallelGroup()
							.addGroup(panel5Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(panel5Layout.createParallelGroup()
									.addComponent(Goblin_Box)
									.addComponent(Imp_Box)
									.addComponent(Icefiend_Box)
									.addComponent(Pyrefiend_Box)
									.addComponent(label9)
									.addComponent(Hobgoblin_Box)
									.addComponent(Vampyre_Box))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(panel5Layout.createParallelGroup()
									.addComponent(Werewolf_Box)
									.addComponent(Cyclops_Box)
									.addComponent(Demon_Box)
									.addComponent(Hellhound_Box)
									.addComponent(Ork_Box)
									.addComponent(Dark_Beast_Box))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
					panel5Layout.setVerticalGroup(
						panel5Layout.createParallelGroup()
							.addGroup(panel5Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(label9)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(Imp_Box)
									.addComponent(Werewolf_Box))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(Goblin_Box)
									.addComponent(Cyclops_Box))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(Icefiend_Box)
									.addComponent(Hellhound_Box))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(Pyrefiend_Box)
									.addComponent(Demon_Box))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(Hobgoblin_Box)
									.addComponent(Ork_Box))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(Vampyre_Box)
									.addComponent(Dark_Beast_Box))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
				}

				//======== panel6 ========
				{
					panel6.setBorder(new TitledBorder("Combat settings"));

					//---- Attack_Attacked_Box ----
					Attack_Attacked_Box.setText("Attack attacked monsters");

					GroupLayout panel6Layout = new GroupLayout(panel6);
					panel6.setLayout(panel6Layout);
					panel6Layout.setHorizontalGroup(
						panel6Layout.createParallelGroup()
							.addGroup(panel6Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(Attack_Attacked_Box)
								.addContainerGap(207, Short.MAX_VALUE))
					);
					panel6Layout.setVerticalGroup(
						panel6Layout.createParallelGroup()
							.addGroup(panel6Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(Attack_Attacked_Box)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
				}

				GroupLayout panel4Layout = new GroupLayout(panel4);
				panel4.setLayout(panel4Layout);
				panel4Layout.setHorizontalGroup(
					panel4Layout.createParallelGroup()
						.addComponent(panel5, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
						.addGroup(panel4Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
				);
				panel4Layout.setVerticalGroup(
					panel4Layout.createParallelGroup()
						.addGroup(panel4Layout.createSequentialGroup()
							.addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
				);
			}
			tabbedPane1.addTab("Combat", panel4);

		}

		//---- Start_Script ----
		Start_Script.setText("Start");
		Start_Script.setFont(Start_Script.getFont().deriveFont(Start_Script.getFont().getSize() + 9f));
		Start_Script.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Start_ScriptActionPerformed(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(tabbedPane1, GroupLayout.Alignment.TRAILING)
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(97, 97, 97)
					.addComponent(label1)
					.addContainerGap())
				.addComponent(Start_Script, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label1)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(Start_Script, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jesper Jensen
	private JLabel label1;
	private JTabbedPane tabbedPane1;
	private JPanel panel1;
	private JPanel panel2;
	private JComboBox<String> Food_ComboBox;
	private JLabel label8;
	private JTextField Food_Text;
	private JPanel panel3;
	private JTextField Extreme_Strength_Text;
	private JLabel label2;
	private JTextField Prayer_Potion_Text;
	private JTextField Super_Attack_Text;
	private JLabel label3;
	private JLabel label4;
	private JTextField SuperStrengthText;
	private JTextField Super_Prayer_Text;
	private JTextField Extreme_Attack_Text;
	private JLabel label7;
	private JLabel label5;
	private JLabel label6;
	private JPanel panel7;
	private JCheckBox Forinthry_Box;
	private JPanel panel4;
	private JPanel panel5;
	private JLabel label9;
	private JCheckBox Imp_Box;
	private JCheckBox Goblin_Box;
	private JCheckBox Icefiend_Box;
	private JCheckBox Pyrefiend_Box;
	private JCheckBox Hobgoblin_Box;
	private JCheckBox Vampyre_Box;
	private JCheckBox Werewolf_Box;
	private JCheckBox Cyclops_Box;
	private JCheckBox Hellhound_Box;
	private JCheckBox Demon_Box;
	private JCheckBox Ork_Box;
	private JCheckBox Dark_Beast_Box;
	private JPanel panel6;
	private JCheckBox Attack_Attacked_Box;
	private JButton Start_Script;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
