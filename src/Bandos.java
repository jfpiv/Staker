import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Bandos extends JFrame {
	int HP_boss = 255;
	int spek_user = 100;
	int hp_user = 99;
	int user_damage;

	JLabel lbluserdamage = new JLabel();
	JLabel lblhpboss = new JLabel(Integer.toString(HP_boss), JLabel.CENTER);
	JLabel notenougspek = new JLabel("");
	JLabel spekint = new JLabel("100");
	JLabel lblhpuser = new JLabel(Integer.toString(hp_user));

	JProgressBar spekuser = new JProgressBar();
	JProgressBar progressBar = new JProgressBar();

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
		button_2.setToolTipText("Hit hard!");
		button_2.setBounds(289, 827, 89, 23);
		getContentPane().add(button_2);
		ImageIcon ags = new ImageIcon(getClass().getResource("ags.png"));
		JLabel label = new JLabel(ags);
		label.setBounds(314, 786, 40, 39);
		getContentPane().add(label);

		JButton button_3 = new JButton("Dharok");
		button_3.setToolTipText("Hit higher when less hp");
		button_3.setBounds(123, 827, 89, 23);
		getContentPane().add(button_3);
		ImageIcon dh = new ImageIcon(getClass().getResource("dh.png"));
		JLabel label_1 = new JLabel(dh);
		label_1.setBounds(146, 784, 40, 39);
		getContentPane().add(label_1);
		progressBar.setMaximum(255);

		progressBar.setForeground(Color.RED);
		progressBar.setValue(255);
		progressBar.setBounds(172, 11, 477, 34);
		getContentPane().add(progressBar);

		lblhpboss.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblhpboss.setBounds(342, 50, 123, 20);
		getContentPane().add(lblhpboss);

		lblhpuser.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblhpuser.setBounds(46, 721, 40, 41);
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

		setVisible(true);
	}

	public void actionWhip(ActionEvent iv) {

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
				progressBar.setValue(spek_user);
				spekint.setText(Integer.toString(spek_user));
			}
			HP_boss = HP_boss - whip;
			lblhpboss.setText(Integer.toString(HP_boss));
			if (HP_boss == 0) {
				lblhpboss.setText("0");
			}
			lblhpboss.setText(Integer.toString(HP_boss));
			if (whip < 1) {
				lbluserdamage.setText("Missed!");
			} else {
				lbluserdamage.setForeground(Color.red);
				lbluserdamage.setText("You hit: " + "-" + Integer.toString(whip));
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
		checkDead();
	}

	public void actionDDS(ActionEvent ev) {

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
		progressBar.setValue(spek_user);
		if (spek_user < 100) {
			spek_user = spek_user + 5;
			progressBar.setValue(spek_user);
		}
		spekuser.setValue(spek_user);
		;
		
		if (hp_user <= 0) {
			hp_user = 0;
			lblhpuser.setText("0");
			return;
		} else {
			AIAttack();
		}
		checkDead();
	}

	private void AIAttack() {
		int a = randInt(0, 100);
		if (!userdood()) {
			if (a > 75) {
				hp_user = hp_user - 5;

			} else if (a <= 75 && a > 50) {
				hp_user = hp_user - 10;
			} else if (a <= 50 && a > 25) {
				hp_user = hp_user - 15;
			} else if (a <= 25 && a > 0) {
				hp_user = hp_user - 20;
			}
			lblhpuser.setText(Integer.toString(hp_user));
		} else {
			hp_user = 0;
			lblhpuser.setText(Integer.toString(hp_user));
			return;
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
