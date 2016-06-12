package be.staker.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import be.staker.pojo.Shark;
import be.staker.pojo.User;
import be.staker.pojo.Weapon;
import be.staker.ui.Bandos;
import be.staker.util.Util;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JProgressBar;

public class Staker extends JFrame {

	int stakePet = 1998;

	JLabel lblLogoHeader = new JLabel();;

	// user
	JLabel lblPlayerHpText = new JLabel();
	JLabel lblPlayerHpValue = new JLabel();
	JLabel lblPlayerReceivedDmg = new JLabel();
	JLabel lblPlayerSharkAmount = new JLabel();
	JLabel lblPlayerSpecTextAmount = new JLabel();
	JProgressBar pgrPlayerSpecialBar = new JProgressBar();

	// opponent
	JLabel lblOpponentHpText = new JLabel();
	JLabel lblOpponentHpValue = new JLabel();
	JLabel lblOpponentReceivedDmg = new JLabel();
	JLabel lblOpponentSharkAmount = new JLabel();
	JLabel lblOpponentSpecTextAmount = new JLabel();
	JProgressBar pgrOpponentSpecialBar = new JProgressBar();

	// stake
	final JLabel lblStakeAmountText = new JLabel("Current Amount:");
	JLabel lblStakeAmountValue = new JLabel();
	JTextPane txtStakeAmountInputField = new JTextPane();
	JLabel lblStakeWinLoss = new JLabel();

	JLabel lblBuildVersion = new JLabel("Build: 0.2");

	// pet
	JLabel lblPet = new JLabel();
	JLabel label_Pet = new JLabel();

	// buttons
	final JButton btnReset = new JButton("Restart");
	final JButton btnStartStake = new JButton("Start");

	// labelsvooricons
	JLabel ddspic = new JLabel();
	JLabel agspic = new JLabel();
	JLabel dhpic = new JLabel();
	JLabel sharkpic = new JLabel();

	// alleicons
	ImageIcon header_RS_Logo;
	ImageIcon pet_Lander = new ImageIcon(getClass().getResource("pet_Lander.png"));
	ImageIcon pet_Bandos = new ImageIcon(getClass().getResource("pet_Bandos.png"));
	ImageIcon pet_Dks = new ImageIcon(getClass().getResource("pet_Dks.png"));
	ImageIcon pet_Sara = new ImageIcon(getClass().getResource("pet_Sara.png"));
	ImageIcon pet_Jad = new ImageIcon(getClass().getResource("pet_Jad.png"));
	ImageIcon icon = new ImageIcon(getClass().getResource("bandos.png"));
	ImageIcon coins = new ImageIcon(getClass().getResource("coins.png"));

	// randombooleans
	boolean STAKING;

	User player = new User(99, new Shark(5, 20, 5), 100, 10);
	User ai = new User(99, new Shark(5, 20, 5), 100, 10);

	public Staker() {
		super("Staker");

		setSize(700, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		header_RS_Logo = new ImageIcon(getClass().getResource("RS_logo_old.png"));
		lblLogoHeader = new JLabel(header_RS_Logo);
		lblLogoHeader.setBounds(171, 2, 438, 142);
		getContentPane().add(lblLogoHeader);

		lblPlayerHpText.setText("Your HP");
		lblPlayerHpText.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblPlayerHpText.setBounds(157, 241, 132, 31);
		getContentPane().add(lblPlayerHpText);

		lblOpponentHpText.setText("Enemy HP");
		lblOpponentHpText.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblOpponentHpText.setBounds(362, 236, 176, 41);
		getContentPane().add(lblOpponentHpText);

		lblPlayerHpValue.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblPlayerHpValue.setText(player.getHp() + "");
		lblPlayerHpValue.setBounds(167, 293, 140, 55);
		getContentPane().add(lblPlayerHpValue);

		lblOpponentHpValue.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblOpponentHpValue.setText(ai.getHp() + "");
		lblOpponentHpValue.setBounds(372, 293, 146, 55);
		getContentPane().add(lblOpponentHpValue);

		lblPlayerReceivedDmg.setForeground(Color.BLACK);
		lblPlayerReceivedDmg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayerReceivedDmg.setBounds(166, 328, 132, 41);
		getContentPane().add(lblPlayerReceivedDmg);

		lblOpponentReceivedDmg.setForeground(Color.BLACK);
		lblOpponentReceivedDmg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOpponentReceivedDmg.setBounds(371, 332, 132, 41);
		getContentPane().add(lblOpponentReceivedDmg);

		pgrPlayerSpecialBar.setForeground(new Color(50, 205, 50));
		pgrPlayerSpecialBar.setValue(100);
		pgrPlayerSpecialBar.setBounds(148, 557, 146, 14);
		getContentPane().add(pgrPlayerSpecialBar);

		pgrOpponentSpecialBar.setForeground(new Color(50, 205, 50));
		pgrOpponentSpecialBar.setValue(100);
		pgrOpponentSpecialBar.setBounds(397, 557, 146, 14);
		getContentPane().add(pgrOpponentSpecialBar);

		/*
		 * Buttons
		 */
		JButton btnWhip = new JButton("Whip");
		btnWhip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.isDead()) {
					return;
				} else {
					player.doAttack(Weapon.WHIP, ai);
					lblOpponentReceivedDmg.setText("WHIP: -" + Integer.toString(player.getWhip().getHit()));
					lblPlayerSpecTextAmount.setText(player.getSpec() + "");
					AIAttack();
					if (ai.isDead()) {
						lblOpponentHpValue.setText("You Won!");
					} else {
						lblOpponentHpValue.setText(Integer.toString(ai.getHp()));
					}
				}
			}
		});
		btnWhip.setToolTipText("Hit quite accurate");
		btnWhip.setBounds(34, 346, 89, 23);
		getContentPane().add(btnWhip);

		ImageIcon whipimg = new ImageIcon(getClass().getResource("whip.png"));
		JLabel lblWeaponWhipImg = new JLabel(whipimg);

		JButton btnDh = new JButton("Dharok");
		btnDh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.isDead()) {
					return;
				} else {
					player.doAttack(Weapon.DHAROK, ai);
					lblOpponentReceivedDmg.setText("DH: -" + Integer.toString(player.getDharok().getHit()));
					lblOpponentHpValue.setText(Integer.toString(ai.getHp()));
					lblPlayerSpecTextAmount.setText(player.getSpec() + "");
					AIAttack();
					if (ai.isDead()) {
						lblOpponentHpValue.setText("You Won!");
					} else {
						lblOpponentHpValue.setText(Integer.toString(ai.getHp()));
					}
				}
			}
		});
		btnDh.setToolTipText("Hit higher when less hp");
		btnDh.setBounds(34, 548, 89, 23);
		getContentPane().add(btnDh);

		ImageIcon dhimg = new ImageIcon(getClass().getResource("dh.png"));
		JLabel lblWeaponDhImg = new JLabel(dhimg);

		JButton btnDds = new JButton("DDS (25)");
		btnDds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.isDead()) {
					return;
				} else {
					player.doAttack(Weapon.DDS, ai);
					lblOpponentReceivedDmg.setText("DDS: -" + Integer.toString(player.getDds().getHit()) + " -"
							+ Integer.toString(player.getDds().getHit()));
					pgrPlayerSpecialBar.setValue(player.getSpec());
					lblPlayerSpecTextAmount.setText(player.getSpec() + "");
					AIAttack();
					if (ai.isDead()) {
						lblOpponentHpValue.setText("You Won!");
					} else {
						lblOpponentHpValue.setText(Integer.toString(ai.getHp()));
					}
				}
			}
		});
		btnDds.setToolTipText("Uses 25% Special-bar");
		btnDds.setBounds(34, 413, 89, 23);
		getContentPane().add(btnDds);

		ImageIcon ddsimg = new ImageIcon(getClass().getResource("dds.png"));
		JLabel lblWeaponDdsImg = new JLabel(ddsimg);

		JButton btnAgs = new JButton("AGS (50)");
		btnAgs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.isDead()) {
					return;
				} else {
					player.doAttack(Weapon.AGS, ai);
					lblOpponentReceivedDmg.setText("AGS: -" + Integer.toString(player.getAgs().getHit()));
					pgrPlayerSpecialBar.setValue(player.getSpec());
					lblPlayerSpecTextAmount.setText(player.getSpec() + "");
					AIAttack();
					if (ai.isDead()) {
						lblOpponentHpValue.setText("You Won!");
					} else {
						lblOpponentHpValue.setText(Integer.toString(ai.getHp()));
					}
				}
			}
		});
		btnAgs.setToolTipText("Hit hard!");
		btnAgs.setBounds(34, 479, 89, 23);
		getContentPane().add(btnAgs);

		ImageIcon agsimg = new ImageIcon(getClass().getResource("ags.png"));
		JLabel lblWeaponAgsImg = new JLabel(agsimg);

		JButton btnEatShark = new JButton("Eat Shark");
		btnEatShark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.isDead() || player.getShark().getAmount() == 0){
					return;
				} else {
					player.eatShark();
					lblPlayerReceivedDmg.setText("SHARK: +" + Integer.toString(player.getShark().getHealing()));
					lblPlayerHpValue.setText(Integer.toString(player.getHp()));
					pgrPlayerSpecialBar.setValue(player.getSpec());
					lblPlayerSpecTextAmount.setText(player.getSpec() + "");
					lblPlayerSharkAmount.setText(Integer.toString(player.getShark().getAmount()));
					lblOpponentSharkAmount.setText(Integer.toString(ai.getShark().getAmount()));
					
					AIAttack();
				}
			}
		});
		btnEatShark.setToolTipText("Heals 20 hp");
		btnEatShark.setBounds(157, 445, 89, 23);
		getContentPane().add(btnEatShark);

		ImageIcon sharkimg = new ImageIcon(getClass().getResource("shark.png"));
		JLabel lblSharkImg = new JLabel(sharkimg);

		/*
		 * Stake amount fields & buttons
		 */
		txtStakeAmountInputField.setBounds(305, 445, 89, 23);
		getContentPane().add(txtStakeAmountInputField);

		JLabel lblTextStakeAmount = new JLabel("Stake Amount:");
		lblTextStakeAmount.setBounds(305, 415, 107, 19);
		getContentPane().add(lblTextStakeAmount);

		lblStakeAmountText.setBounds(405, 415, 107, 19);
		getContentPane().add(lblStakeAmountText);
		lblStakeAmountValue.setBounds(405, 449, 107, 19);
		getContentPane().add(lblStakeAmountValue);

		btnStartStake.addActionListener(st -> startStake(st));
		btnStartStake.setToolTipText("");
		btnStartStake.setBounds(305, 479, 89, 23);
		getContentPane().add(btnStartStake);

		/*
		 * Master restart buttons
		 */
		JButton btnMasterRestart = new JButton("Master Restart");
		btnMasterRestart.addActionListener(mr -> masterRes(mr));
		btnMasterRestart.setBounds(283, 583, 150, 23);
		getContentPane().add(btnMasterRestart);

		lblStakeWinLoss.setBounds(405, 483, 80, 19);
		getContentPane().add(lblStakeWinLoss);

		label_Pet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_Pet.setBounds(213, 617, 345, 33);
		getContentPane().add(label_Pet);

		lblPlayerSharkAmount.setBounds(142, 441, 18, 31);
		lblPlayerSharkAmount.setText(5 + "");
		getContentPane().add(lblPlayerSharkAmount);

		lblOpponentSharkAmount.setBounds(256, 449, 18, 14);
		lblOpponentSharkAmount.setText(5 + "");
		getContentPane().add(lblOpponentSharkAmount);

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

		lblBuildVersion.setBounds(593, 636, 81, 14);
		getContentPane().add(lblBuildVersion);

		lblPlayerSpecTextAmount.setBounds(201, 537, 79, 23);
		lblPlayerSpecTextAmount.setText(100 + "");
		getContentPane().add(lblPlayerSpecTextAmount);

		lblOpponentSpecTextAmount.setBounds(457, 536, 79, 23);
		lblOpponentSpecTextAmount.setText(100 + "");
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

	}

	private void startStake(ActionEvent st) {
		player.setStake(Integer.parseInt(txtStakeAmountInputField.getText()));

		if (player.getStake() <= 0) {
			lblStakeAmountValue.setText("Invalid");
			player.setStake(0);
		} else if (player.getStake() > player.getMoney()) {
			lblStakeAmountValue.setText("Invalid");
			player.setStake(0);
		} else {
			player.setMoney(player.getMoney() - player.getStake());
			lblStakeAmountValue.setText(Integer.toString(player.getStake()));
		}
	}

	public void masterRes(ActionEvent mr) {
		reset();
		player.setStake(10);
		lblStakeAmountValue.setText(Integer.toString(player.getStake()));
	}

	public void launchBandos(ActionEvent ba) {
		this.dispose();
		new Bandos();

	}

	private void reset() {
		this.dispose();
		new Staker();
	}

	private void layoutComponents() {

	}

	public void AIAttack() {
		if (ai.getHp() == 0) {
			return;
		} else if (ai.getHp() >= 15) { // dharok check
			int A = Util.randInt(0, 10);
			if (A <= 8 && ai.getSpec() >= 50) {
				ai.doAttack(Weapon.AGS, player);
				lblPlayerReceivedDmg.setText("AGS: -" + player.getWeaponHitFrom().getHit());

				lblOpponentSpecTextAmount.setText(ai.getSpec() + "");
				pgrPlayerSpecialBar.setValue(player.getSpec());
				pgrOpponentSpecialBar.setValue(ai.getSpec());
			} else if (ai.getSpec() >= 25) {
				ai.doAttack(Weapon.DDS, player);
				lblPlayerReceivedDmg.setText(
						"DDS: -" + player.getWeaponHitFrom().getHit() + " -" + player.getWeaponHitFrom().getHit2());

				lblOpponentSpecTextAmount.setText(ai.getSpec() + "");
				pgrPlayerSpecialBar.setValue(player.getSpec());
				pgrOpponentSpecialBar.setValue(ai.getSpec());
			} else {
				int a = Util.randInt(0, 10);
				if (ai.getHp() < 20) {
					ai.eatShark();
					lblOpponentSharkAmount.setText(ai.getShark().getAmount() + "");
				} else if (a >= 5) {
					ai.doAttack(Weapon.DHAROK, player);
					lblPlayerReceivedDmg.setText("DH: -" + player.getWeaponHitFrom().getHit());

					lblOpponentSpecTextAmount.setText(ai.getSpec() + "");
					pgrPlayerSpecialBar.setValue(player.getSpec());
					pgrOpponentSpecialBar.setValue(ai.getSpec());
				} else {
					ai.doAttack(Weapon.WHIP, player);
					lblPlayerReceivedDmg.setText("WHIP: -" + player.getWeaponHitFrom().getHit());

					lblOpponentSpecTextAmount.setText(ai.getSpec() + "");
					pgrPlayerSpecialBar.setValue(player.getSpec());
					pgrOpponentSpecialBar.setValue(ai.getSpec());
				}
			}
		} else {
			ai.doAttack(Weapon.DHAROK, player);
			lblPlayerReceivedDmg.setText("DH: -" + player.getWeaponHitFrom().getHit());

			lblOpponentSpecTextAmount.setText(ai.getSpec() + "");
			pgrPlayerSpecialBar.setValue(player.getSpec());
			pgrOpponentSpecialBar.setValue(ai.getSpec());
		}
		if (ai.getSpec() < 100) {
			ai.setSpecFive();
			lblOpponentSpecTextAmount.setText(ai.getSpec() + "");
			pgrOpponentSpecialBar.setValue(ai.getSpec());
		}
		if (player.isDead()) {
			lblPlayerHpValue.setText("You Lost!");
		} else {
			lblPlayerHpValue.setText(Integer.toString(player.getHp()));
		}
	}

	private void checkPet() {
		int petLuck = Util.randInt(0, 2000);
		System.out.println(stakePet + "  " + petLuck);
		System.out.println(STAKING);
		if (petLuck == stakePet && player.getStake() > 0) {
			label_Pet.setText("You received a staking pet!");
			int welke = Util.randInt(0, 5);
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
