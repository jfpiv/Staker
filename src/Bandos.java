import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.plaf.ProgressBarUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Bandos extends JFrame {
	int HP_boss = 255;
	int spek_user = 100;
	int hp_user = 99;
	int user_damage;
	int shark_user = 10;

	JLabel lbluserdamage = new JLabel();
	JLabel lblhpboss = new JLabel(Integer.toString(HP_boss), JLabel.CENTER);
	JLabel notenougspek = new JLabel("");
	JLabel spekint = new JLabel("100");
	JLabel lblhpuser = new JLabel(Integer.toString(hp_user));
	JProgressBar spekuser = new JProgressBar();
	JProgressBar progressBar = new JProgressBar();
	JLabel label_3 = new JLabel();
	JLabel lblsharkamount = new JLabel("10");
	
	JLabel lblYouReceived = new JLabel();
	
	ImageIcon hilt = new ImageIcon(getClass().getResource("hilt.png"));
	ImageIcon pet = new ImageIcon(getClass().getResource("pett.png"));
	ImageIcon tassets = new ImageIcon(getClass().getResource("tassets.png"));
	ImageIcon bcp = new ImageIcon(getClass().getResource("bcp.png"));
	ImageIcon shard = new ImageIcon(getClass().getResource("shard.png"));
	ImageIcon boots = new ImageIcon(getClass().getResource("bandosboots.png"));
	ImageIcon clue = new ImageIcon(getClass().getResource("clue.png"));
	ImageIcon plate = new ImageIcon(getClass().getResource("runeplate.png"));
	ImageIcon magic = new ImageIcon(getClass().getResource("magic.png"));
	ImageIcon niks = new ImageIcon();
	JLabel label_4 = new JLabel();

	public Bandos() {
		super("Bandos");
		setSize(900, 900);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		ImageIcon rsheader = new ImageIcon(getClass().getResource("RS_logo_old.png"));

		ImageIcon bandosboss = new ImageIcon(getClass().getResource("bandosboss.png"));
		JLabel lblbandosboss = new JLabel(bandosboss);
		lblbandosboss.setBounds(158, 89, 559, 698);
		getContentPane().add(lblbandosboss);

		JButton button = new JButton("Whip");
		button.addActionListener(iv -> actionWhip(iv));
		button.setToolTipText("Hit quite accurate");
		button.setBounds(630, 827, 89, 23);
		getContentPane().add(button);
		ImageIcon whip = new ImageIcon(getClass().getResource("whip.png"));
		JLabel lblwhip = new JLabel(whip);
		lblwhip.setBounds(652, 787, 40, 39);
		getContentPane().add(lblwhip);

		JButton button_1 = new JButton("DDS (25)");
		button_1.addActionListener(ev -> actionDDS(ev));
		button_1.setToolTipText("Uses 25% Special-bar");
		button_1.setBounds(452, 827, 89, 23);
		getContentPane().add(button_1);
		ImageIcon dds = new ImageIcon(getClass().getResource("dds.png"));
		JLabel lbldds = new JLabel(dds);
		lbldds.setBounds(474, 788, 40, 39);
		getContentPane().add(lbldds);

		JButton button_2 = new JButton("AGS (50)");
		button_2.addActionListener(ags -> actionAGS(ags));
		button_2.setToolTipText("Hit hard!");
		button_2.setBounds(289, 827, 89, 23);
		getContentPane().add(button_2);
		ImageIcon ags = new ImageIcon(getClass().getResource("ags.png"));
		JLabel label = new JLabel(ags);
		label.setBounds(314, 786, 40, 39);
		getContentPane().add(label);

		JButton button_3 = new JButton("Dharok");
		button_3.addActionListener(dh -> dhAttack(dh));
		button_3.setToolTipText("Hit higher when less hp");
		button_3.setBounds(123, 827, 89, 23);
		getContentPane().add(button_3);
		ImageIcon dh = new ImageIcon(getClass().getResource("dh.png"));
		JLabel label_1 = new JLabel(dh);
		label_1.setBounds(146, 784, 40, 39);
		getContentPane().add(label_1);
		progressBar.setMaximum(255);

		progressBar.setForeground(Color.RED);
		progressBar.setValue(HP_boss);
		progressBar.setBounds(172, 11, 477, 34);
		getContentPane().add(progressBar);

		lblhpboss.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblhpboss.setBounds(342, 50, 123, 20);
		getContentPane().add(lblhpboss);

		lblhpuser.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblhpuser.setBounds(45, 700, 40, 41);
		getContentPane().add(lblhpuser);

		lbluserdamage.setForeground(Color.RED);
		lbluserdamage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbluserdamage.setBounds(468, 51, 153, 19);
		getContentPane().add(lbluserdamage);

		spekuser.setValue(100);
		spekuser.setForeground(new Color(50, 205, 50));
		spekuser.setBounds(2, 786, 146, 14);
		getContentPane().add(spekuser);

		notenougspek.setBounds(1, 806, 146, 23);
		getContentPane().add(notenougspek);

		spekint.setBounds(57, 764, 79, 23);
		getContentPane().add(spekint);

		JButton btnStaker = new JButton("Staker");
		btnStaker.setBounds(23, 11, 89, 23);
		btnStaker.addActionListener(re -> backToStaker(re));
		getContentPane().add(btnStaker);

		JButton btnRestart = new JButton("Restart");
		btnRestart.setBounds(709, 14, 89, 23);
		getContentPane().add(btnRestart);

		JButton button_4 = new JButton("Eat Shark");
		button_4.addActionListener(sh -> actionShark(sh));
		button_4.setToolTipText("Heals 20 hp");
		button_4.setBounds(774, 827, 89, 23);
		getContentPane().add(button_4);
		ImageIcon shark = new ImageIcon(getClass().getResource("shark.png"));
		JLabel label_2 = new JLabel(shark);
		label_2.setBounds(798, 782, 40, 39);
		getContentPane().add(label_2);

		lblsharkamount.setBounds(775, 787, 18, 31);
		getContentPane().add(lblsharkamount);

		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(4, 725, 124, 56);
		getContentPane().add(label_3);
		
		
		label_4.setBounds(23, 114, 120, 89);
		getContentPane().add(label_4);
		
		
		lblYouReceived.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYouReceived.setBounds(27, 84, 153, 45);
		getContentPane().add(lblYouReceived);
		btnRestart.addActionListener(restart -> restartBandos(restart));

		setVisible(true);
	}

	private void actionShark(ActionEvent sh) {
		checkDead();
		if (shark_user > 0) {
			if (hp_user < 99 && HP_boss > 0) {
				shark_user = shark_user - 1;
				if (hp_user > 0 && hp_user < 99) {
					if (spek_user < 100) {
						spek_user = spek_user + 5;
						spekuser.setValue(spek_user);
						spekint.setText(Integer.toString(spek_user));
					}
					hp_user = hp_user + 35;

					if (hp_user >= 99) {
						hp_user = 99;
					}
					label_3.setForeground(Color.green);
					label_3.setText("+40");
					lblhpuser.setText(Integer.toString(hp_user));
					AIAttack();

				} else {
					label_3.setText("You're full");
				}

				if (hp_user <= 0) {
					hp_user = 0;
					lblhpuser.setText("0");
				}

			} else {
				label_3.setForeground(Color.black);
				label_3.setText("You're full!");
				return;
			}
		} else {
			label_3.setText("0 left");
		}
		lblsharkamount.setText(Integer.toString(shark_user));
	}

	private void actionAGS(ActionEvent ags) {
		checkDead();
		notenougspek.setText("");
		if (HP_boss <= 0) {
			return;
		}
		if (HP_boss > 0 && hp_user > 0) {
			int agss;
			if (!checkDead() && spek_user >= 50 && HP_boss > 0) {
				agss = randInt(0, 68);

				HP_boss = HP_boss - agss;
				if (HP_boss == 0) {
					lblhpboss.setText("0");
				}
				lblhpboss.setText(Integer.toString(HP_boss));
				if (agss < 1) {
					lbluserdamage.setText("0");
				} else {
					lbluserdamage.setForeground(Color.red);
					lbluserdamage.setText("You hit: " + "-" + Integer.toString(agss));
					progressBar.setValue(HP_boss);
				}

			} else if (HP_boss > 0 && spek_user < 50) {
				notenougspek.setText("Not enough special!");
				return;
			}
			spek_user = spek_user - 50;
			spekuser.setValue(spek_user);
			if (spek_user < 100) {
				spek_user = spek_user + 5;
				spekuser.setValue(spek_user);
				spekint.setText(Integer.toString(spek_user));
			}
			
			AIAttack();
			checkDead();
			progressBar.setValue(HP_boss);
			if (HP_boss <= 0) {
				HP_boss = 0;
				lblhpboss.setText("0");
				progressBar.setValue(HP_boss);
				return;
			}

		}
	}

	private void restartBandos(ActionEvent restart) {
		HP_boss = 255;
		spek_user = 100;
		hp_user = 99;
		spek_user = 100;
		spekint.setText(Integer.toString(spek_user));
		spekuser.setValue(spek_user);
		progressBar.setValue(HP_boss);
		lblhpboss.setText(Integer.toString(HP_boss));
		lblhpuser.setText(Integer.toString(hp_user));
		lbluserdamage.setText("");
		notenougspek.setText("");
		shark_user = 10;
		lblsharkamount.setText("10");
		label_3.setText("");
		lblYouReceived.setText("");
		label_4.setIcon(niks);
	}

	private void dhAttack(ActionEvent dh) {
		notenougspek.setText("");
		int dharockhit = 0;
		if (hp_user <= 0) {
			return;
		}
		checkDead();
		if (HP_boss > 0 && hp_user > 0) {
			if (hp_user <= 99 && hp_user > 80) {
				dharockhit = randInt(0, 20);
			} else if (hp_user <= 80 && hp_user > 60) {
				dharockhit = randInt(0, 25);
			} else if (hp_user <= 60 && hp_user > 45) {
				dharockhit = randInt(0, 30);
			} else if (hp_user <= 45 && hp_user > 35) {
				dharockhit = randInt(0, 35);
			} else if (hp_user <= 35 && hp_user > 10) {
				dharockhit = randInt(0, 45);
			} else if (hp_user <= 10 && hp_user > 5) {
				dharockhit = randInt(0, 55);
			} else if (hp_user <= 5 && hp_user > 3) {
				dharockhit = randInt(0, 60);
			} else if (hp_user <= 3 && hp_user > 1) {
				dharockhit = randInt(0, 65);
			} else if (hp_user <= 1) {
				dharockhit = randInt(0, 85);
			}
			HP_boss = HP_boss - dharockhit;
			lbluserdamage.setForeground(Color.red);
			lbluserdamage.setText("You hit: " + "-" + Integer.toString(dharockhit));
			lblhpboss.setText(Integer.toString(HP_boss));
			progressBar.setValue(HP_boss);
			AIAttack();
		}
		if (HP_boss <= 0) {
			lblhpboss.setText("0");
			checkDead();
			return;
		}
		
			if (spek_user < 100) {
				spek_user = spek_user + 5;
				spekuser.setValue(spek_user);
				spekint.setText(Integer.toString(spek_user));
			}
			
		
		if (HP_boss <= 0) {
			HP_boss = 0;
			lblhpboss.setText("0");
			progressBar.setValue(HP_boss);
			return;
		}
		progressBar.setValue(HP_boss);
		
		checkDead();

	}

	private Object backToStaker(ActionEvent re) {
		this.dispose();
		new Back();
		return null;
	}

	public void actionWhip(ActionEvent iv) {
		notenougspek.setText("");
		if (HP_boss <= 0) {
			return;
		}
		if (hp_user <= 0) {
			hp_user = 0;
			lblhpuser.setText("0");
			return;
		}
		checkDead();
		if (HP_boss > 0) {
			int whip = randInt(0, 35);

			if (spek_user < 100) {
				spek_user = spek_user + 5;
				spekuser.setValue(spek_user);
				spekint.setText(Integer.toString(spek_user));
			}
			HP_boss = HP_boss - whip;

			if (whip < 1) {
				lbluserdamage.setText("0");
			} else {
				lbluserdamage.setForeground(Color.red);
				lbluserdamage.setText("You hit: " + "-" + Integer.toString(whip));

			}
			progressBar.setValue(HP_boss - whip);
			lblhpboss.setText(Integer.toString(HP_boss));
			if (HP_boss == 0) {
				lblhpboss.setText("0");
			}
			if (hp_user <= 0) {
				hp_user = 0;
				lblhpuser.setText("0");
				return;
			} else {
				AIAttack();
			}
		} else {
			return;
		}
		if (HP_boss <= 0) {
			HP_boss = 0;
			lblhpboss.setText("0");
			progressBar.setValue(HP_boss);
			return;
		}
		progressBar.setValue(HP_boss);
		checkDead();
	}

	public void actionDDS(ActionEvent ev) {
		notenougspek.setText("");
		if (HP_boss <= 0) {
			return;
		}
		if (hp_user <= 0) {
			hp_user = 0;
			lblhpuser.setText("0");
			return;
		}
		checkDead();
		if (HP_boss > 0 && spek_user >= 25) {
			int Special = randInt(0, 30);
			int Speciall = randInt(0, 30);
			int total = Special + Speciall;

			HP_boss = HP_boss - total;
			lbluserdamage.setForeground(Color.red);
			lbluserdamage.setText("DDS: " + "-" + Integer.toString(Special) + " -" + Integer.toString(Speciall));
			if (HP_boss <= 0) {
				lblhpboss.setText("0/255");
			}
			progressBar.setValue(HP_boss - total);
			lblhpboss.setText(Integer.toString(HP_boss));
		} else {
			notenougspek.setText("Not enough special!");
			;
			return;
		}
		spek_user = spek_user - 25;
		if (spek_user < 100) {
			spek_user = spek_user + 5;
			spekuser.setValue(spek_user);
			spekint.setText(Integer.toString(spek_user));
		}

		if (hp_user <= 0) {
			hp_user = 0;
			lblhpuser.setText("0");
			return;
		} else {
			AIAttack();
		}
		if (HP_boss <= 0) {
			HP_boss = 0;
			lblhpboss.setText("0");
			progressBar.setValue(HP_boss);
			return;
		}
		progressBar.setValue(HP_boss);
		checkDead();
	}

	private void AIAttack() {
		int a = randInt(0, 100);
		label_3.setForeground(Color.red);
		if(HP_boss <= 0 && hp_user >0){
			int itemroll = randInt(0, 500);
			if(itemroll >= 1 && itemroll <= 175){
				lblYouReceived.setText("You received:");
				label_4.setIcon(magic);
			}else if(itemroll > 175 && itemroll <= 300){
				lblYouReceived.setText("You received:");
				label_4.setIcon(plate);
			}else if(itemroll > 300 && itemroll <= 475){
				lblYouReceived.setText("You received:");
				label_4.setIcon(clue);
			}else if(itemroll == 493){
				lblYouReceived.setText("You received:");
				label_4.setIcon(boots);
			}else if(itemroll == 494){
				lblYouReceived.setText("You received:");
				label_4.setIcon(hilt);
			}else if(itemroll == 495){
				lblYouReceived.setText("You received:");
				label_4.setIcon(tassets);
			}else if(itemroll == 496){
				lblYouReceived.setText("You received:");
				label_4.setIcon(bcp);
			}else if(itemroll == 497){
				lblYouReceived.setText("You received:");
				label_4.setIcon(shard);
			}else{
				lblYouReceived.setText("You received: nothing");
			}
			int petroll = randInt(0, 2000);
			if(petroll == 1000){
				lblYouReceived.setText("You received:");
				label_4.setIcon(pet);
			}
			System.out.println("ItemRoll: "+ itemroll + "\nPetRoll: "+petroll);
		}
		if (hp_user > 0) {
			if (a > 75) {
				int range = randInt(0, 24);
				hp_user = hp_user - range;
				label_3.setText("Range attack:- " + range);
			} else if (a <= 75 && a > 50) {
				int melee = randInt(0, 33);
				hp_user = hp_user - melee;
				label_3.setText("Range attack:- " + melee);
			} else if (a <= 50 && a > 25) {
				int melee = randInt(0, 37);
				hp_user = hp_user - melee;
				label_3.setText("Mage attack:- " + melee);
			} else if (a <= 25 && a > 0) {
				int range = randInt(0, 45);
				hp_user = hp_user - range;
				label_3.setText("Range attack:- " + range);
			}
			lblhpuser.setText(Integer.toString(hp_user));
		} else {
			hp_user = 0;
			lblhpuser.setText(Integer.toString(hp_user));
			return;
		}
		if (hp_user <= 0) {
			lblhpuser.setText("0");
			lblYouReceived.setText("");
			label_4.setIcon(niks);
		}

	}

	public boolean userdood() {
		if (hp_user <= 0) {
			hp_user = 0;
			lblhpuser.setText(Integer.toString(hp_user));
			return true;
		}
		return false;
	}

	public static int randInt(int min, int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public boolean checkDead() {
		if (HP_boss == 0) {
			return true;
		}
		return false;
	}
}
