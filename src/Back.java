import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import sun.audio.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.Icon;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;

public class Back extends JFrame {

	float fontGrootte = 35;
	int HP_user = 99;
	int HP_ai = 99;
	JLabel label_1 = new JLabel(Integer.toString(HP_ai));
	JLabel label = new JLabel(Integer.toString(HP_user));
	JLabel hit = new JLabel();
	JLabel hitt = new JLabel();
	boolean spek = true;
	boolean spekk = true;
	JLabel label_2 = new JLabel();
	JButton btnAgs = new JButton("AGS (50)");
	JProgressBar progressBar = new JProgressBar();
	int spek_user = 100;
	int spek_ai = 100;
	JLabel lblNewLabel_4 = new JLabel(Integer.toString(spek_user));
	JLabel lblNewLabel = new JLabel("");
	JProgressBar progressBar_1 = new JProgressBar();
	JTextPane stakeamount = new JTextPane();
	private JLabel lblCurrentAmount = new JLabel("Current Amount:");
	int MONEY = 10;
	JLabel money = new JLabel(Integer.toString(MONEY));
	int STAKED;
	JButton startStake = new JButton("Start");
	boolean STAKING;
	JLabel label_3 = new JLabel();
	int tussengeld;
	int stakePet = 1998;
	JLabel label_pet = new JLabel();

	int shark_ai = 5;
	int shark_user = 5;
	private JLabel shark1 = new JLabel(Integer.toString(shark_user));
	private JLabel shark2 = new JLabel(Integer.toString(shark_ai));
	private JLabel lblNewLabel_1 = new JLabel();
	ImageIcon image1;
	ImageIcon image2 = new ImageIcon(getClass().getResource("pet.png"));
	ImageIcon image3 = new ImageIcon(getClass().getResource("pett.png"));
	ImageIcon image4 = new ImageIcon(getClass().getResource("pettt.png"));
	ImageIcon image5 = new ImageIcon(getClass().getResource("petttt.png"));
	ImageIcon image6 = new ImageIcon(getClass().getResource("pettttt.png"));
	private final JButton btnReset = new JButton("Restart");
	private JLabel lblNewLabel_2 = new JLabel();
	ImageIcon icon = new ImageIcon(getClass().getResource("bandos.png"));
	ImageIcon coins = new ImageIcon(getClass().getResource("coins.png"));
	private final JLabel lblBergJewsypoes = new JLabel("Berg jewsypoes");
	private final JLabel lblBuild = new JLabel("Build: 0.2");
	private JLabel label_4 = new JLabel();
	private JLabel ddspic = new JLabel();
	private final JLabel agspic = new JLabel();
	private final JLabel dhpic = new JLabel();
	private final JLabel sharkpic = new JLabel();

	public Back() {
		super("Staker");
		setSize(700, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		image1 = new ImageIcon(getClass().getResource("RS_logo_old.png"));
		lblNewLabel_1 = new JLabel(image1);

		ImageIcon whipimg = new ImageIcon(getClass().getResource("whip.png"));
		JLabel whippic = new JLabel(whipimg);

		ImageIcon ddsimg = new ImageIcon(getClass().getResource("dds.png"));
		JLabel ddspic = new JLabel(ddsimg);

		ImageIcon agsimg = new ImageIcon(getClass().getResource("ags.png"));
		JLabel agspic = new JLabel(agsimg);

		ImageIcon dhimg = new ImageIcon(getClass().getResource("dh.png"));
		JLabel dhpic = new JLabel(dhimg);

		ImageIcon sharkimg = new ImageIcon(getClass().getResource("shark.png"));
		JLabel sharkpic = new JLabel(sharkimg);

		// tabbedPane.addTab("Stake", coins, null, "Does nothing");
		// tabbedPane.addTab("Bandos", icon, null, "dsf");

		label.setFont(new Font("Tahoma", Font.PLAIN, 28));
		label.setBounds(167, 293, 140, 55);
		getContentPane().add(label);

		label_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		label_1.setBounds(372, 293, 140, 55);
		getContentPane().add(label_1);

		JLabel lblYourHp = new JLabel("Your HP");
		lblYourHp.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblYourHp.setBounds(157, 241, 132, 31);
		getContentPane().add(lblYourHp);

		JLabel lblEnemyHp = new JLabel("Enemy HP");
		lblEnemyHp.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblEnemyHp.setBounds(362, 236, 176, 41);
		getContentPane().add(lblEnemyHp);

		JButton btnDds = new JButton("DDS (25)");
		btnDds.addActionListener(ev -> actionDDS(ev));
		btnDds.setToolTipText("Uses 25% Special-bar");
		btnDds.setBounds(34, 413, 89, 23);
		getContentPane().add(btnDds);

		JButton btnWhip = new JButton("Whip");
		btnWhip.addActionListener(iv -> actionWhip(iv));
		btnWhip.setToolTipText("Hit quite accurate");
		btnWhip.setBounds(34, 346, 89, 23);
		getContentPane().add(btnWhip);

		JButton btnEatShark = new JButton("Eat Shark");
		btnEatShark.addActionListener(ov -> actionShark(ov));
		btnEatShark.setToolTipText("Heals 20 hp");
		btnEatShark.setBounds(157, 445, 89, 23);
		getContentPane().add(btnEatShark);

		hit.setForeground(Color.BLACK);
		hit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hit.setBounds(166, 328, 132, 41);
		getContentPane().add(hit);

		hitt.setForeground(Color.BLACK);
		hitt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hitt.setBounds(362, 335, 150, 31);
		getContentPane().add(hitt);

		label_2.setBounds(234, 309, 89, 39);
		getContentPane().add(label_2);

		btnAgs.setBounds(34, 479, 89, 23);
		getContentPane().add(btnAgs);
		btnAgs.setToolTipText("Hit hard!");
		btnAgs.addActionListener(ags -> actionAgs(ags));

		progressBar.setForeground(new Color(50, 205, 50));
		progressBar.setValue(100);
		progressBar.setBounds(148, 557, 146, 14);
		getContentPane().add(progressBar);

		lblNewLabel.setBounds(142, 573, 146, 23);
		getContentPane().add(lblNewLabel);
		progressBar_1.setForeground(new Color(50, 205, 50));
		progressBar_1.setBounds(397, 557, 146, 14);
		progressBar_1.setValue(100);

		getContentPane().add(progressBar_1);

		stakeamount.setBounds(305, 445, 89, 23);
		getContentPane().add(stakeamount);

		JLabel lblStakeAmount = new JLabel("Stake Amount:");
		lblStakeAmount.setBounds(305, 415, 107, 19);
		getContentPane().add(lblStakeAmount);
		lblCurrentAmount.setBounds(405, 415, 107, 19);

		getContentPane().add(lblCurrentAmount);
		money.setBounds(405, 449, 107, 19);

		getContentPane().add(money);

		startStake.addActionListener(st -> startStake(st));

		startStake.setToolTipText("");
		startStake.setBounds(305, 479, 89, 23);
		getContentPane().add(startStake);

		JButton btnMasterRestart = new JButton("Master Restart");
		btnMasterRestart.addActionListener(mr -> masterRes(mr));
		btnMasterRestart.setBounds(283, 583, 150, 23);
		getContentPane().add(btnMasterRestart);

		label_3.setBounds(405, 483, 80, 19);
		getContentPane().add(label_3);

		label_pet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_pet.setBounds(213, 617, 345, 33);
		getContentPane().add(label_pet);
		shark1.setBounds(142, 441, 18, 31);

		getContentPane().add(shark1);
		shark2.setBounds(256, 449, 18, 14);

		getContentPane().add(shark2);
		lblNewLabel_1.setBounds(171, 2, 438, 142);

		getContentPane().add(lblNewLabel_1);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}

		});
		btnReset.setBounds(305, 517, 89, 23);

		getContentPane().add(btnReset);
		lblNewLabel_2.setBounds(24, 561, 120, 89);

		getContentPane().add(lblNewLabel_2);

		JButton dharokbtn = new JButton("Dharok");
		dharokbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent dh) {
				dharok();
			}
		});
		dharokbtn.setToolTipText("Hit higher when less hp");
		dharokbtn.setBounds(34, 548, 89, 23);
		getContentPane().add(dharokbtn);

		JLabel lblNewLabel_3 = new JLabel("Al-zuq yadik");
		lblNewLabel_3.setBounds(167, 213, 140, 26);
		getContentPane().add(lblNewLabel_3);
		lblBergJewsypoes.setBounds(372, 213, 140, 26);

		getContentPane().add(lblBergJewsypoes);
		lblBuild.setBounds(593, 636, 81, 14);

		getContentPane().add(lblBuild);

		lblNewLabel_4.setBounds(201, 537, 79, 23);
		getContentPane().add(lblNewLabel_4);
		label_4.setText("100");
		label_4.setBounds(457, 536, 79, 23);

		getContentPane().add(label_4);

		whippic.setBounds(56, 306, 40, 39);
		getContentPane().add(whippic);
		ddspic.setBounds(56, 374, 40, 39);

		getContentPane().add(ddspic);
		agspic.setBounds(59, 438, 40, 39);

		getContentPane().add(agspic);
		dhpic.setBounds(57, 505, 40, 39);

		getContentPane().add(dhpic);
		sharkpic.setBounds(181, 400, 40, 39);

		getContentPane().add(sharkpic);

		JButton btnBandos = new JButton("Bandos");
		btnBandos.addActionListener(ba -> launchBandos(ba));
		btnBandos.setBounds(24, 11, 89, 23);
		getContentPane().add(btnBandos);
		initComponents();
		layoutComponents();

		if (HP_user <= 0) {
			HP_user = 0;
			label_2.setText("");
			label.setText("You Lost");
		}
		if (HP_ai <= 0) {

			HP_ai = 0;
			label.setText("You Won");
		}

	}

	private void startStake(ActionEvent st) {

		reset();
		STAKING = true;
		STAKED = Integer.parseInt(stakeamount.getText());
		if (STAKED <= 0) {
			STAKED = Integer.parseInt(stakeamount.getText());
			System.out.println("DIkke 0");
		}

		if (STAKED < 0) {
			stakeamount.setText("Invalid");
			STAKED = 0;
			STAKING = false;
		} else if (STAKED == 0) {
			STAKING = false;
			STAKED = 0;
		} else if (STAKED > MONEY) {
			stakeamount.setText("Invalid");
			STAKED = 0;
			STAKING = false;
		} else {
			tussengeld = MONEY;
			MONEY = MONEY - STAKED;
			STAKING = true;
			money.setText(Integer.toString(MONEY));
			STAKING = true;
		}
		stakeamount.setText("");
	}

	public void masterRes(ActionEvent mr) {
		reset();
		MONEY = 10;
		money.setText(Integer.toString(MONEY));

		tussengeld = 0;
		STAKED = 0;
		label_3.setText("");

	}

	public void launchBandos(ActionEvent ba) {
		this.dispose();
		Bandos ban = new Bandos();

	}

	private void reset() {
		label_1.setText("99");
		label.setText("99");
		hitt.setText("");
		hit.setText("");
		label_2.setText("");
		HP_ai = 99;
		HP_user = 99;
		spek_user = 100;
		spek_ai = 100;
		progressBar_1.setValue(100);
		progressBar.setValue(100);
		tussengeld = 0;
		shark_ai = 5;
		shark_user = 5;
		shark1.setText(Integer.toString(shark_user));
		shark2.setText(Integer.toString(shark_ai));
		lblNewLabel.setText("");
		STAKED = 0;
		lblNewLabel_4.setText(Integer.toString(spek_user));
		label_4.setText(Integer.toString(spek_ai));
		STAKING = false;

	}

	private void dharok() {
		int dharockhit = 0;
		if (HP_ai <= 0) {
			return;
		}
		checkDead();
		if (HP_ai > 0 && HP_user > 0) {
			if (HP_user <= 99 && HP_user > 80) {
				dharockhit = randInt(0, 20);
			} else if (HP_user <= 80 && HP_user > 60) {
				dharockhit = randInt(0, 25);
			} else if (HP_user <= 60 && HP_user > 45) {
				dharockhit = randInt(0, 30);
			} else if (HP_user <= 45 && HP_user > 35) {
				dharockhit = randInt(0, 35);
			} else if (HP_user <= 35 && HP_user > 10) {
				dharockhit = randInt(0, 45);
			} else if (HP_user <= 10 && HP_user > 5) {
				dharockhit = randInt(0, 55);
			} else if (HP_user <= 5 && HP_user > 3) {
				dharockhit = randInt(0, 60);
			} else if (HP_user <= 3 && HP_user > 1) {
				dharockhit = randInt(0, 65);
			} else if (HP_user <= 1) {
				dharockhit = randInt(0, 85);
			}
			HP_ai = HP_ai - dharockhit;
			hitt.setForeground(Color.red);
			hitt.setText("You hit: " + "-" + Integer.toString(dharockhit));
			label_1.setText(Integer.toString(HP_ai));
		}
		if (HP_ai <= 0) {
			label_1.setText("0");
			checkDead();
			return;
		}
		if (HP_user > 0) {
			if (spek_user < 100) {
				spek_user = spek_user + 5;
				progressBar.setValue(spek_user);
				lblNewLabel_4.setText(Integer.toString(spek_user));
			}
			AIAttack();
		}
		checkDead();
	}

	public void actionDDS(ActionEvent ev) {
		label_2.setText("");
		if (HP_ai <= 0) {
			return;
		}
		checkDead();
		if (!checkDead() && spek_user >= 25) {
			int Special = randInt(0, 30);
			int Speciall = randInt(0, 30);
			int total = Special + Speciall;

			HP_ai = HP_ai - total;
			hitt.setForeground(Color.red);
			hitt.setText("You hit: " + "-" + Integer.toString(Special) + " -" + Integer.toString(Speciall));
			if (HP_ai <= 0) {
				label_1.setText("0");
			}
			label_1.setText(Integer.toString(HP_ai));

		} else {
			return;
		}
		spek_user = spek_user - 25;
		progressBar.setValue(spek_user);
		if (spek_user < 100) {
			spek_user = spek_user + 5;
			progressBar.setValue(spek_user);
		}
		lblNewLabel_4.setText(Integer.toString(spek_user));
		AIAttack();
		checkDead();
	}

	public void actionAgs(ActionEvent ags) {
		label_2.setText("");
		checkDead();
		if (HP_ai <= 0) {
			return;
		}
		if (HP_ai > 0 && HP_user > 0) {
			int agss;
			if (!checkDead() && spek_user >= 50 && HP_ai > 0) {
				agss = randInt(0, 68);

				HP_ai = HP_ai - agss;
				if (HP_ai == 0) {
					label_1.setText("0");
				}
				label_1.setText(Integer.toString(HP_ai));
				if (agss < 1) {
					hit.setText("Missed!");
				} else {
					hitt.setForeground(Color.red);
					hitt.setText("You hit: " + "-" + Integer.toString(agss));
				}
				AIAttack();
			} else if (HP_ai > 0 && spek_user < 50) {
				lblNewLabel.setText("Not enough special!");
				return;
			}
			spek_user = spek_user - 50;
			progressBar.setValue(spek_user);
			if (spek_user < 100) {
				spek_user = spek_user + 5;
				progressBar.setValue(spek_user);
				lblNewLabel_4.setText(Integer.toString(spek_user));
			}

			checkDead();

		}
	}

	public void actionWhip(ActionEvent iv) {
		lblNewLabel_4.setText(Integer.toString(spek_user));
		label_2.setText("");
		checkDead();
		if (HP_ai <= 0) {
			return;
		}
		if (!checkDead()) {
			int whip = randInt(0, 35);

			if (spek_user < 100) {
				spek_user = spek_user + 5;
				progressBar.setValue(spek_user);
				lblNewLabel_4.setText(Integer.toString(spek_user));
			}
			HP_ai = HP_ai - whip;
			if (HP_ai == 0) {
				label_1.setText("0");
			}
			label_1.setText(Integer.toString(HP_ai));
			if (whip < 1) {
				hit.setText("Missed!");
			} else {
				hitt.setForeground(Color.red);
				hitt.setText("You hit: " + "-" + Integer.toString(whip));
			}
			AIAttack();
		} else {
			return;
		}
		checkDead();
	}

	public void AIAttack() {
		checkDead();
		if (HP_ai >= 15) {
			int A = randInt(0, 10);
			if (A <= 8 && spek_ai >= 50) {
				AIAgs();
			} else if (spek_ai >= 25) {
				AIDds();
			} else {
				int a = randInt(0, 10);
				if (HP_ai < 20) {
					AIShark();
				} else if (a >= 5) {
					aidharok();
				} else {
					AIWhip();
				}
			}
		} else {
			aidharok();
		}
		if (spek_ai < 100) {
			spek_ai = spek_ai + 5;
			progressBar_1.setValue(spek_ai);
			label_4.setText(Integer.toString(spek_ai));
		}
		checkDead();
	}

	private void aidharok() {
		int dharockhit = 0;
		int hpnu = HP_user;
		if (HP_user <= 0 || HP_ai <= 0) {
			return;
		}

		if (HP_ai > 0 && HP_user > 0) {
			if (HP_ai <= 99 && HP_ai > 80) {
				dharockhit = randInt(0, 20);
			} else if (HP_ai <= 80 && HP_ai > 60) {
				dharockhit = randInt(0, 25);
			} else if (HP_ai <= 60 && HP_ai > 45) {
				dharockhit = randInt(0, 30);
			} else if (HP_ai <= 45 && HP_ai > 35) {
				dharockhit = randInt(0, 35);
			} else if (HP_ai <= 35 && HP_ai > 10) {
				dharockhit = randInt(0, 40);
			} else if (HP_ai <= 10 && HP_ai > 5) {
				dharockhit = randInt(0, 45);
			} else if (HP_ai <= 5 && HP_ai > 3) {
				dharockhit = randInt(0, 55);
			} else if (HP_ai <= 3 && HP_ai > 1) {
				dharockhit = randInt(0, 60);
			} else if (HP_ai <= 1) {
				dharockhit = randInt(0, 65);
			}

			hit.setForeground(Color.red);
			HP_user = HP_user - dharockhit;
			if (HP_user <= 0) {
				hit.setText("Dharok: " + "-" + hpnu);
				label.setText(Integer.toString(HP_user));
				checkDead();
				return;
			} else {
				label.setText(Integer.toString(HP_user));
				hit.setText("Dharok: " + "-" + Integer.toString(dharockhit));
			}
		}
		checkDead();

	}

	private void AIShark() {
		checkDead();
		shark_ai = shark_ai - 1;
		shark2.setText(Integer.toString(shark_ai));
		HP_ai = HP_ai + 40;
		if (HP_ai >= 99) {
			HP_ai = 99;
		}
		hitt.setForeground(Color.green);
		hitt.setText("+40");
		label_1.setText(Integer.toString(HP_ai));
		hit.setText("");
		checkDead();

	}

	private void AIAgs() {
		checkDead();
		int hpnu = HP_user;
		int specialAgs;
		if (!checkDead() && spek_ai >= 50) {
			if (HP_user < 40) {
				specialAgs = randInt(0, 50);
			} else {
				specialAgs = randInt(0, 68);
			}
			hit.setForeground(Color.red);
			HP_user = HP_user - specialAgs;
			if (HP_user <= 0) {
				hit.setText("AGS:- " + hpnu);
				label.setText(Integer.toString(HP_user));
				checkDead();
				return;
			} else {
				label.setText(Integer.toString(HP_user));
				hit.setText("AGS:- " + Integer.toString(specialAgs));
			}
		}

		spek_ai = spek_ai - 50;
		progressBar_1.setValue(spek_ai);
		checkDead();
	}

	private void AIDds() {
		checkDead();
		int hpnu = HP_user;
		if (spek_ai >= 25) {
			int Special = randInt(0, 30);
			int Speciall = randInt(0, 30);
			int total = Special + Speciall;

			HP_user = HP_user - total;
			hit.setForeground(Color.red);
			if (HP_user <= 0) {
				hit.setText("DDS:-" + hpnu + " - 0");
				label.setText(Integer.toString(HP_user));
				checkDead();
				return;
			} else {
				hit.setText("DDS:- " + Integer.toString(Special) + " - " + Integer.toString(Speciall));
				label.setText(Integer.toString(HP_user));
			}

		}
		spek_ai = spek_ai - 25;
		progressBar_1.setValue(spek_ai);
		checkDead();
	}

	public void AIWhip() {
		checkDead();
		int hpnu = HP_user;
		if (HP_user > 0) {
			int whip = randInt(0, 26);

			hit.setForeground(Color.red);
			if (whip < 1) {
				hit.setText("Whip: " + whip);
			} else {
				hit.setText("Whip:- " + Integer.toString(whip));
				HP_user = HP_user - whip;
				if (HP_user <= 0) {
					hit.setText("Whip:- " + hpnu);
					label.setText(Integer.toString(HP_user));
					checkDead();
					return;
				} else {
					label.setText(Integer.toString(HP_user));
					hit.setText("Whip:- " + Integer.toString(whip));
				}
			}

		} else {
			return;
		}
	}

	public void actionShark(ActionEvent ov) {

		checkDead();
		if (shark_user > 0) {
			shark_user = shark_user - 1;
			if (HP_user > 0 && HP_user < 99) {
				if (spek_user < 100) {
					spek_user = spek_user + 5;
					progressBar.setValue(spek_user);
					lblNewLabel_4.setText(Integer.toString(spek_user));
				}
				if (!checkDead()) {
					HP_user = HP_user + 40;
				} else {
					return;
				}
				if (HP_user >= 99) {
					HP_user = 99;
				}
				label_2.setForeground(Color.green);
				label_2.setText("+40");
				label.setText(Integer.toString(HP_user));
				AIAttack();
				shark1.setText(Integer.toString(shark_user));
			} else {
				hit.setText("You're full");
			}

			if (HP_user <= 0) {
				HP_user = 0;
				label_2.setText("");
				label.setText("You Lost");
			}

		}
	}

	public static int randInt(int min, int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public boolean checkDead() {
		if (HP_ai == 0 && HP_user == 0) {
			label.setText("Tie");
			label_1.setText("Tie");
			STAKING = false;

		}
		if (HP_ai <= 0 || HP_user <= 0) {
			if (HP_ai <= 0) {
				label_1.setText("0");
				label.setText("You Won");
				tussengeld = MONEY;
				System.out.println(tussengeld);
				MONEY = (STAKED * 2) + tussengeld;
				money.setText(Integer.toString(MONEY));

				int won = STAKED;
				label_3.setText("Won: " + Integer.toString(won) + " mill");
				checkPet();
				STAKING = false;
				STAKED = 0;
			} else if (HP_user <= 0) {
				label.setText("You Lost");
				int won = STAKED;
				label_3.setText("Lost: " + Integer.toString(won) + " mill");
				STAKING = false;
			}
			return true;
		}
		return false;
	}

	private void layoutComponents() {

	}

	private void checkPet() {
		int petLuck = randInt(0, 2000);
		System.out.println(stakePet + "  " + petLuck);
		System.out.println(STAKING);
		if (petLuck == stakePet && STAKED > 0) {
			label_pet.setText("You received a staking pet!");
			int welke = randInt(0, 5);
			if (welke == 0) {
				lblNewLabel_2.setIcon(image2);
				System.out.println("Lander");
			} else if (welke == 1) {
				lblNewLabel_2.setIcon(image3);
				System.out.println("Bandos");
			} else if (welke == 2) {
				lblNewLabel_2.setIcon(image4);
				System.out.println("Dagg");
			} else if (welke == 3) {
				lblNewLabel_2.setIcon(image5);
				System.out.println("Zilly");
			} else if (welke == 4) {
				System.out.println("Jad");
				lblNewLabel_2.setIcon(image6);
			}

		}
	}

	private void initComponents() {
		// setSize(500, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// float fontGrootte = 35;

		setVisible(true);
		setResizable(true);
	}
}
