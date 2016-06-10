package be.staker.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import be.staker.ui.Bandos;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JProgressBar;

public class Staker extends JFrame {

	float fontGrootte = 35;
	
	int HP_user = 99;
	int HP_ai = 99;
	
	int shark_ai = 5;
	int shark_user = 5;
	
	int spek_user = 100;
	int spek_ai = 100;
	
	int MONEY = 10;
	int STAKED;
	int tussengeld;
	
	int stakePet = 1998;
	
	JLabel lblLogoHeader;
	
	//user
	JLabel lblUserHp = new JLabel(Integer.toString(HP_user));
	JLabel lblUserReceivedDmg = new JLabel();
	JLabel lblUserHealing = new JLabel();
	JLabel lblUserSpecTextAmount = new JLabel(Integer.toString(spek_user));
	JLabel playerSharkAmount = new JLabel(Integer.toString(shark_user));
	
	//opponent
	JLabel lblOpponentHp = new JLabel(Integer.toString(HP_ai));
	JLabel lblOpponentReceivedDmg = new JLabel();
	JLabel OpponentSharkAmount = new JLabel(Integer.toString(shark_ai));
	JLabel lblOpponentName = new JLabel("Berg jewsypoes");
	JLabel lblOpponentSpecTextAmount = new JLabel();
	
	//stake
	JLabel lblTextCurrentAmount = new JLabel("Current Amount:");
	JLabel lblStakeAmountCurrent = new JLabel(Integer.toString(MONEY));
	JLabel lblStakeWinLoss = new JLabel();
	
	JLabel lblBuildVersion = new JLabel("Build: 0.2");
	
	//specbalks
	JProgressBar userSpecialBar = new JProgressBar();
	JProgressBar OpponentSpecialBar = new JProgressBar();
	
	//pet
	JLabel lblPet = new JLabel();
	JLabel label_Pet = new JLabel();
	
	
	//buttons
	JButton btnReset = new JButton("Restart");
	JButton btnAgs = new JButton("AGS (50)");
	JButton btnStartStake = new JButton("Start");

	//invoerveld
	JTextPane stakeAmountInputField = new JTextPane();
	
	//geenflauwidee :doge:
	JLabel lblNewLabel_1 = new JLabel();
	JLabel lblNewLabel = new JLabel("");
	
	//labelsvooricons
	JLabel ddspic = new JLabel();
	JLabel agspic = new JLabel();
	JLabel dhpic = new JLabel();
	JLabel sharkpic = new JLabel();

	//alleicons
	ImageIcon header_RS_Logo; 
	ImageIcon pet_Lander = new ImageIcon(getClass().getResource("pet_Lander.png"));
	ImageIcon pet_Bandos = new ImageIcon(getClass().getResource("pet_Bandos.png"));
	ImageIcon pet_Dks = new ImageIcon(getClass().getResource("pet_Dks.png"));
	ImageIcon pet_Sara = new ImageIcon(getClass().getResource("pet_Sara.png"));
	ImageIcon pet_Jad = new ImageIcon(getClass().getResource("pet_Jad.png"));
	ImageIcon icon = new ImageIcon(getClass().getResource("bandos.png"));
	ImageIcon coins = new ImageIcon(getClass().getResource("coins.png"));
	
	//randombooleans
	boolean spek = true;
	boolean spekk = true;
	boolean STAKING;

	public Staker() {
		super("Staker");
		setSize(700, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		header_RS_Logo = new ImageIcon(getClass().getResource("RS_logo_old.png"));
		lblLogoHeader = new JLabel(header_RS_Logo);

		ImageIcon whipimg = new ImageIcon(getClass().getResource("whip.png"));
		JLabel lblWeaponWhipImg = new JLabel(whipimg);

		ImageIcon ddsimg = new ImageIcon(getClass().getResource("dds.png"));
		JLabel lblWeaponDdsImg = new JLabel(ddsimg);

		ImageIcon agsimg = new ImageIcon(getClass().getResource("ags.png"));
		JLabel lblWeaponAgsImg = new JLabel(agsimg);

		ImageIcon dhimg = new ImageIcon(getClass().getResource("dh.png"));
		JLabel lblWeaponDhImg = new JLabel(dhimg);

		ImageIcon sharkimg = new ImageIcon(getClass().getResource("shark.png"));
		JLabel lblSharkImg = new JLabel(sharkimg);

		lblUserHp.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblUserHp.setBounds(167, 293, 140, 55);
		getContentPane().add(lblUserHp);

		lblOpponentHp.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblOpponentHp.setBounds(372, 293, 140, 55);
		getContentPane().add(lblOpponentHp);

		JLabel lblPlayerYourHp = new JLabel("Your HP");
		lblPlayerYourHp.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblPlayerYourHp.setBounds(157, 241, 132, 31);
		getContentPane().add(lblPlayerYourHp);

		JLabel lblOpponentYourHp = new JLabel("Enemy HP");
		lblOpponentYourHp.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblOpponentYourHp.setBounds(362, 236, 176, 41);
		getContentPane().add(lblOpponentYourHp);

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

		lblUserReceivedDmg.setForeground(Color.BLACK);
		lblUserReceivedDmg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserReceivedDmg.setBounds(166, 328, 132, 41);
		getContentPane().add(lblUserReceivedDmg);

		lblOpponentReceivedDmg.setForeground(Color.BLACK);
		lblOpponentReceivedDmg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOpponentReceivedDmg.setBounds(362, 335, 150, 31);
		getContentPane().add(lblOpponentReceivedDmg);

		lblUserHealing.setBounds(234, 309, 89, 39);
		getContentPane().add(lblUserHealing);

		btnAgs.setBounds(34, 479, 89, 23);
		getContentPane().add(btnAgs);
		btnAgs.setToolTipText("Hit hard!");
		btnAgs.addActionListener(ags -> actionAgs(ags));

		userSpecialBar.setForeground(new Color(50, 205, 50));
		userSpecialBar.setValue(100);
		userSpecialBar.setBounds(148, 557, 146, 14);
		getContentPane().add(userSpecialBar);

		lblNewLabel.setBounds(142, 573, 146, 23);
		getContentPane().add(lblNewLabel);
		OpponentSpecialBar.setForeground(new Color(50, 205, 50));
		OpponentSpecialBar.setBounds(397, 557, 146, 14);
		OpponentSpecialBar.setValue(100);

		getContentPane().add(OpponentSpecialBar);

		stakeAmountInputField.setBounds(305, 445, 89, 23);
		getContentPane().add(stakeAmountInputField);

		JLabel lblTextStakeAmount = new JLabel("Stake Amount:");
		lblTextStakeAmount.setBounds(305, 415, 107, 19);
		getContentPane().add(lblTextStakeAmount);
		lblTextCurrentAmount.setBounds(405, 415, 107, 19);

		getContentPane().add(lblTextCurrentAmount);
		lblStakeAmountCurrent.setBounds(405, 449, 107, 19);

		getContentPane().add(lblStakeAmountCurrent);

		btnStartStake.addActionListener(st -> startStake(st));

		btnStartStake.setToolTipText("");
		btnStartStake.setBounds(305, 479, 89, 23);
		getContentPane().add(btnStartStake);

		JButton btnMasterRestart = new JButton("Master Restart");
		btnMasterRestart.addActionListener(mr -> masterRes(mr));
		btnMasterRestart.setBounds(283, 583, 150, 23);
		getContentPane().add(btnMasterRestart);

		lblStakeWinLoss.setBounds(405, 483, 80, 19);
		getContentPane().add(lblStakeWinLoss);

		label_Pet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_Pet.setBounds(213, 617, 345, 33);
		getContentPane().add(label_Pet);
		playerSharkAmount.setBounds(142, 441, 18, 31);

		getContentPane().add(playerSharkAmount);
		OpponentSharkAmount.setBounds(256, 449, 18, 14);

		getContentPane().add(OpponentSharkAmount);
		lblLogoHeader.setBounds(171, 2, 438, 142);

		getContentPane().add(lblLogoHeader);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}

		});
		btnReset.setBounds(305, 517, 89, 23);

		getContentPane().add(btnReset);
		lblPet.setBounds(24, 561, 120, 89);

		getContentPane().add(lblPet);

		JButton btnDh = new JButton("Dharok");
		btnDh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent dh) {
				dharok();
			}
		});
		btnDh.setToolTipText("Hit higher when less hp");
		btnDh.setBounds(34, 548, 89, 23);
		getContentPane().add(btnDh);

		JLabel lblPlayerName = new JLabel("Al-zuq yadik");
		lblPlayerName.setBounds(167, 213, 140, 26);
		getContentPane().add(lblPlayerName);
		lblOpponentName.setBounds(372, 213, 140, 26);

		getContentPane().add(lblOpponentName);
		lblBuildVersion.setBounds(593, 636, 81, 14);

		getContentPane().add(lblBuildVersion);

		lblUserSpecTextAmount.setBounds(201, 537, 79, 23);
		getContentPane().add(lblUserSpecTextAmount);
		lblOpponentSpecTextAmount.setText("100");
		lblOpponentSpecTextAmount.setBounds(457, 536, 79, 23);

		getContentPane().add(lblOpponentSpecTextAmount);

		lblWeaponWhipImg.setBounds(56, 306, 40, 39);
		getContentPane().add(lblWeaponWhipImg);
		lblWeaponDdsImg.setBounds(56, 374, 40, 39);

		getContentPane().add(lblWeaponDdsImg);
		lblWeaponAgsImg.setBounds(59, 438, 40, 39);

		getContentPane().add(lblWeaponAgsImg);
		lblWeaponDhImg.setBounds(57, 505, 40, 39);

		getContentPane().add(lblWeaponDhImg);
		lblSharkImg.setBounds(181, 400, 40, 39);

		getContentPane().add(lblSharkImg);

		JButton btnBandos = new JButton("Bandos");
		btnBandos.addActionListener(ba -> launchBandos(ba));
		btnBandos.setBounds(24, 11, 89, 23);
		getContentPane().add(btnBandos);
		initComponents();
		layoutComponents();

		if (HP_user <= 0) {
			HP_user = 0;
			lblUserHealing.setText("");
			lblUserHp.setText("You Lost");
		}
		if (HP_ai <= 0) {

			HP_ai = 0;
			lblUserHp.setText("You Won");
		}

	}

	private void startStake(ActionEvent st) {

		reset();
		STAKING = true;
		STAKED = Integer.parseInt(stakeAmountInputField.getText());
		if (STAKED <= 0) {
			STAKED = Integer.parseInt(stakeAmountInputField.getText());
			System.out.println("DIkke 0");
		}

		if (STAKED < 0) {
			stakeAmountInputField.setText("Invalid");
			STAKED = 0;
			STAKING = false;
		} else if (STAKED == 0) {
			STAKING = false;
			STAKED = 0;
		} else if (STAKED > MONEY) {
			stakeAmountInputField.setText("Invalid");
			STAKED = 0;
			STAKING = false;
		} else {
			tussengeld = MONEY;
			MONEY = MONEY - STAKED;
			STAKING = true;
			lblStakeAmountCurrent.setText(Integer.toString(MONEY));
			STAKING = true;
		}
		stakeAmountInputField.setText("");
	}

	public void masterRes(ActionEvent mr) {
		reset();
		MONEY = 10;
		lblStakeAmountCurrent.setText(Integer.toString(MONEY));

		tussengeld = 0;
		STAKED = 0;
		lblStakeWinLoss.setText("");

	}

	public void launchBandos(ActionEvent ba) {
		this.dispose();
		Bandos ban = new Bandos();

	}

	private void reset() {
		lblOpponentHp.setText("99");
		lblUserHp.setText("99");
		lblOpponentReceivedDmg.setText("");
		lblUserReceivedDmg.setText("");
		lblUserHealing.setText("");
		HP_ai = 99;
		HP_user = 99;
		spek_user = 100;
		spek_ai = 100;
		OpponentSpecialBar.setValue(100);
		userSpecialBar.setValue(100);
		tussengeld = 0;
		shark_ai = 5;
		shark_user = 5;
		playerSharkAmount.setText(Integer.toString(shark_user));
		OpponentSharkAmount.setText(Integer.toString(shark_ai));
		lblNewLabel.setText("");
		STAKED = 0;
		lblUserSpecTextAmount.setText(Integer.toString(spek_user));
		lblOpponentSpecTextAmount.setText(Integer.toString(spek_ai));
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
			lblOpponentReceivedDmg.setForeground(Color.red);
			lblOpponentReceivedDmg.setText("You hit: " + "-" + Integer.toString(dharockhit));
			lblOpponentHp.setText(Integer.toString(HP_ai));
		}
		if (HP_ai <= 0) {
			lblOpponentHp.setText("0");
			checkDead();
			return;
		}
		if (HP_user > 0) {
			if (spek_user < 100) {
				spek_user = spek_user + 5;
				userSpecialBar.setValue(spek_user);
				lblUserSpecTextAmount.setText(Integer.toString(spek_user));
			}
			AIAttack();
		}
		checkDead();
	}

	public void actionDDS(ActionEvent ev) {
		lblUserHealing.setText("");
		if (HP_ai <= 0) {
			return;
		}
		checkDead();
		if (!checkDead() && spek_user >= 25) {
			int Special = randInt(0, 30);
			int Speciall = randInt(0, 30);
			int total = Special + Speciall;

			HP_ai = HP_ai - total;
			lblOpponentReceivedDmg.setForeground(Color.red);
			lblOpponentReceivedDmg.setText("You hit: " + "-" + Integer.toString(Special) + " -" + Integer.toString(Speciall));
			if (HP_ai <= 0) {
				lblOpponentHp.setText("0");
			}
			lblOpponentHp.setText(Integer.toString(HP_ai));

		} else {
			return;
		}
		spek_user = spek_user - 25;
		userSpecialBar.setValue(spek_user);
		if (spek_user < 100) {
			spek_user = spek_user + 5;
			userSpecialBar.setValue(spek_user);
		}
		lblUserSpecTextAmount.setText(Integer.toString(spek_user));
		AIAttack();
		checkDead();
	}

	public void actionAgs(ActionEvent ags) {
		lblUserHealing.setText("");
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
					lblOpponentHp.setText("0");
				}
				lblOpponentHp.setText(Integer.toString(HP_ai));
				if (agss < 1) {
					lblUserReceivedDmg.setText("Missed!");
				} else {
					lblOpponentReceivedDmg.setForeground(Color.red);
					lblOpponentReceivedDmg.setText("You hit: " + "-" + Integer.toString(agss));
				}
				AIAttack();
			} else if (HP_ai > 0 && spek_user < 50) {
				lblNewLabel.setText("Not enough special!");
				return;
			}
			spek_user = spek_user - 50;
			userSpecialBar.setValue(spek_user);
			if (spek_user < 100) {
				spek_user = spek_user + 5;
				userSpecialBar.setValue(spek_user);
				lblUserSpecTextAmount.setText(Integer.toString(spek_user));
			}

			checkDead();

		}
	}

	public void actionWhip(ActionEvent iv) {
		lblUserSpecTextAmount.setText(Integer.toString(spek_user));
		lblUserHealing.setText("");
		checkDead();
		if (HP_ai <= 0) {
			return;
		}
		if (!checkDead()) {
			int whip = randInt(0, 35);

			if (spek_user < 100) {
				spek_user = spek_user + 5;
				userSpecialBar.setValue(spek_user);
				lblUserSpecTextAmount.setText(Integer.toString(spek_user));
			}
			HP_ai = HP_ai - whip;
			if (HP_ai == 0) {
				lblOpponentHp.setText("0");
			}
			lblOpponentHp.setText(Integer.toString(HP_ai));
			if (whip < 1) {
				lblUserReceivedDmg.setText("Missed!");
			} else {
				lblOpponentReceivedDmg.setForeground(Color.red);
				lblOpponentReceivedDmg.setText("You hit: " + "-" + Integer.toString(whip));
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
			OpponentSpecialBar.setValue(spek_ai);
			lblOpponentSpecTextAmount.setText(Integer.toString(spek_ai));
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

			lblUserReceivedDmg.setForeground(Color.red);
			HP_user = HP_user - dharockhit;
			if (HP_user <= 0) {
				lblUserReceivedDmg.setText("Dharok: " + "-" + hpnu);
				lblUserHp.setText(Integer.toString(HP_user));
				checkDead();
				return;
			} else {
				lblUserHp.setText(Integer.toString(HP_user));
				lblUserReceivedDmg.setText("Dharok: " + "-" + Integer.toString(dharockhit));
			}
		}
		checkDead();

	}

	private void AIShark() {
		checkDead();
		shark_ai = shark_ai - 1;
		OpponentSharkAmount.setText(Integer.toString(shark_ai));
		HP_ai = HP_ai + 40;
		if (HP_ai >= 99) {
			HP_ai = 99;
		}
		lblOpponentReceivedDmg.setForeground(Color.green);
		lblOpponentReceivedDmg.setText("+40");
		lblOpponentHp.setText(Integer.toString(HP_ai));
		lblUserReceivedDmg.setText("");
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
			lblUserReceivedDmg.setForeground(Color.red);
			HP_user = HP_user - specialAgs;
			if (HP_user <= 0) {
				lblUserReceivedDmg.setText("AGS:- " + hpnu);
				lblUserHp.setText(Integer.toString(HP_user));
				checkDead();
				return;
			} else {
				lblUserHp.setText(Integer.toString(HP_user));
				lblUserReceivedDmg.setText("AGS:- " + Integer.toString(specialAgs));
			}
		}

		spek_ai = spek_ai - 50;
		OpponentSpecialBar.setValue(spek_ai);
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
			lblUserReceivedDmg.setForeground(Color.red);
			if (HP_user <= 0) {
				lblUserReceivedDmg.setText("DDS:-" + hpnu + " - 0");
				lblUserHp.setText(Integer.toString(HP_user));
				checkDead();
				return;
			} else {
				lblUserReceivedDmg.setText("DDS:- " + Integer.toString(Special) + " - " + Integer.toString(Speciall));
				lblUserHp.setText(Integer.toString(HP_user));
			}

		}
		spek_ai = spek_ai - 25;
		OpponentSpecialBar.setValue(spek_ai);
		checkDead();
	}

	public void AIWhip() {
		checkDead();
		int hpnu = HP_user;
		if (HP_user > 0) {
			int whip = randInt(0, 26);

			lblUserReceivedDmg.setForeground(Color.red);
			if (whip < 1) {
				lblUserReceivedDmg.setText("Whip: " + whip);
			} else {
				lblUserReceivedDmg.setText("Whip:- " + Integer.toString(whip));
				HP_user = HP_user - whip;
				if (HP_user <= 0) {
					lblUserReceivedDmg.setText("Whip:- " + hpnu);
					lblUserHp.setText(Integer.toString(HP_user));
					checkDead();
					return;
				} else {
					lblUserHp.setText(Integer.toString(HP_user));
					lblUserReceivedDmg.setText("Whip:- " + Integer.toString(whip));
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
					userSpecialBar.setValue(spek_user);
					lblUserSpecTextAmount.setText(Integer.toString(spek_user));
				}
				if (!checkDead()) {
					HP_user = HP_user + 40;
				} else {
					return;
				}
				if (HP_user >= 99) {
					HP_user = 99;
				}
				lblUserHealing.setForeground(Color.green);
				lblUserHealing.setText("+40");
				lblUserHp.setText(Integer.toString(HP_user));
				AIAttack();
				playerSharkAmount.setText(Integer.toString(shark_user));
			} else {
				lblUserReceivedDmg.setText("You're full");
			}

			if (HP_user <= 0) {
				HP_user = 0;
				lblUserHealing.setText("");
				lblUserHp.setText("You Lost");
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
			lblUserHp.setText("Tie");
			lblOpponentHp.setText("Tie");
			STAKING = false;

		}
		if (HP_ai <= 0 || HP_user <= 0) {
			if (HP_ai <= 0) {
				lblOpponentHp.setText("0");
				lblUserHp.setText("You Won");
				tussengeld = MONEY;
				System.out.println(tussengeld);
				MONEY = (STAKED * 2) + tussengeld;
				lblStakeAmountCurrent.setText(Integer.toString(MONEY));

				int won = STAKED;
				lblStakeWinLoss.setText("Won: " + Integer.toString(won) + " mill");
				checkPet();
				STAKING = false;
				STAKED = 0;
			} else if (HP_user <= 0) {
				lblUserHp.setText("You Lost");
				int won = STAKED;
				lblStakeWinLoss.setText("Lost: " + Integer.toString(won) + " mill");
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
			label_Pet.setText("You received a staking pet!");
			int welke = randInt(0, 5);
			if (welke == 0) {
				lblPet.setIcon(pet_Lander);
			} else if (welke == 1) {
				lblPet.setIcon(pet_Bandos);
			} else if (welke == 2) {
				lblPet.setIcon(pet_Dks);
			} else if (welke == 3) {
				lblPet.setIcon(pet_Sara);
			} else if (welke == 4) {
				lblPet.setIcon(pet_Jad);
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
