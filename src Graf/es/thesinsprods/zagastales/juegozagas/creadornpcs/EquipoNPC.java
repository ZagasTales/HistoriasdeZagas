package es.thesinsprods.zagastales.juegozagas.creadornpcs;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.SwingConstants;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.atributes.AtributePoints;
import es.thesinsprods.zagastales.characters.atributes.Atributes;
import es.thesinsprods.zagastales.characters.blessings.Blessing;
import es.thesinsprods.zagastales.characters.equipment.Accesories;
import es.thesinsprods.zagastales.characters.equipment.Armor;
import es.thesinsprods.zagastales.characters.equipment.Equipment;
import es.thesinsprods.zagastales.characters.equipment.Inventory;
import es.thesinsprods.zagastales.characters.equipment.Misc;
import es.thesinsprods.zagastales.characters.equipment.Possesions;
import es.thesinsprods.zagastales.characters.equipment.Weapons;
import es.thesinsprods.zagastales.characters.privileges.Setbacks;
import es.thesinsprods.zagastales.characters.race.Race;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.KnowHowSkills;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.SkillPoints;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaEquipo;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EquipoNPC {

	private JFrame frmHistoriasDeZagas;
	private static JTextField txtW1;
	private static JTextField txtW2;
	private static JTextField txtW3;
	private static JTextField txtW4;
	private static JTextField txtObj1;
	private static JTextField txtObj2;
	private static JTextField txtObj3;
	private static JTextField txtObj4;
	private static JTextField txtAcc1;
	private static JTextField txtAcc2;
	private static JTextField txtAcc3;
	private static JTextField txtAcc4;
	private JTextField txtAccesorios;
	public static int pweap;
	public static int pmisc;
	public static int posPuestas;
	public static int legPuesto;
	public static int armasPuestas;
	public static int objetosPuestos;
	static ArrayList<String> posarm = new ArrayList<String>();
	static Possesions posss = new Possesions(posarm);
	public static Weapons weapon1 = new Weapons("", "", false, false, posss,"");
	public static Weapons weapon2 = new Weapons("", "", false, false, posss,"");
	public static Weapons weapon3 = new Weapons("", "", false, false, posss,"");
	public static Weapons weapon4 = new Weapons("", "", false, false, posss,"");
	public static Armor armor1 = new Armor("", "", false,false, posss);
	public static Misc misc1 = new Misc("", "", false,false, posss);
	public static Misc misc2 = new Misc("", "", false,false, posss);
	public static Misc misc3 = new Misc("", "", false, false,posss);
	public static Misc misc4 = new Misc("", "", false,false, posss);
	public static Accesories accesories1 = new Accesories("", "", false,false, posss);
	public static Accesories accesories2 = new Accesories("", "", false,false, posss);
	public static Accesories accesories3 = new Accesories("", "", false,false, posss);
	public static Accesories accesories4 = new Accesories("", "", false,false, posss);
	public static int contexcusa = 0;
	MorpheusFont mf = new MorpheusFont();
	private JButton btnInfoW1;
	private JButton btnInfo_W2;
	private JButton btnInfoW3;
	private JButton btnInfoW4;
	private JButton btnInfoObj1;
	private JButton btnInfoObj2;
	private JButton btnInfoObj3;
	private JButton btnInfoObj4;
	private JButton btnInfoAcc1;
	private JButton btnInfoAcc2;
	private JButton btnInfoAcc3;
	private JButton btnInfoAcc4;
	private JButton btnAtras;
	private JButton btnAadirArmadura;
	private static JTextField txtArmadura;
	private JButton btnAyuda;
	private JButton btnInicio;
	private JLabel lblMaxArmas;
	private JTextField txtMaxArmas;
	private JLabel lblMaxObj;
	private JTextField txtMaxObj;
	private JLabel lblEquipo;
	private JLabel lblDinero;
	private JTextField textField_13;
	public static int dinero=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipoNPC window = new EquipoNPC();
					window.frmHistoriasDeZagas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EquipoNPC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.getContentPane().setBackground(
				new Color(205, 133, 63));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(
				EquipoNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setBounds(100, 100, 584, 532);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.getContentPane().setLayout(null);

		JPanel pnlArmadura = new JPanel();
		pnlArmadura.setOpaque(false);
		pnlArmadura.setBackground(new Color(205, 133, 63));
		pnlArmadura.setBounds(0, 46, 575, 180);
		frmHistoriasDeZagas.getContentPane().add(pnlArmadura);
		pnlArmadura.setLayout(null);

		btnAadirArmadura = new JButton("A\u00F1adir Armadura");
		btnAadirArmadura.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAadirArmadura.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton a\u00F1adir armadura2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				btnAadirArmadura.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton a\u00F1adir armadura.png")));
			}
		});
		btnAadirArmadura.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirArmadura.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton a\u00F1adir armadura.png")));
		btnAadirArmadura.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnAadirArmadura.setForeground(new Color(255, 255, 255));
		btnAadirArmadura.setBackground(new Color(139, 69, 19));
		btnAadirArmadura.setBorderPainted(false);
		btnAadirArmadura.setContentAreaFilled(false);
		btnAadirArmadura.setFocusPainted(false);
		btnAadirArmadura.setOpaque(false);
		btnAadirArmadura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtArmadura.getText().equals("")) {
					ArmaduraNPC window = new ArmaduraNPC();
					window.getFrame().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frmHistoriasDeZagas,
							"No puedes llevar más armaduras.", "",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAadirArmadura.setFont(mf.MyFont(0, 13));
		btnAadirArmadura.setBounds(59, 11, 159, 56);
		pnlArmadura.add(btnAadirArmadura);

		txtArmadura = new JTextField();
		txtArmadura.setForeground(new Color(0, 0, 0));
		txtArmadura.setBackground(Color.WHITE);
		txtArmadura.setText(armor1.getArmor());
		txtArmadura.setFont(mf.MyFont(0, 11));
		txtArmadura.setEditable(false);
		txtArmadura.setBounds(40, 91, 205, 20);
		pnlArmadura.add(txtArmadura);
		txtArmadura.setColumns(10);

		final JButton btnInfoArm = new JButton("Info");
		btnInfoArm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoArm.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones armaduras2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoArm.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones armaduras.png")));

			}
		});
		btnInfoArm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoArm.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones armaduras.png")));
		btnInfoArm.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoArm.setForeground(new Color(255, 255, 255));
		btnInfoArm.setBackground(new Color(139, 69, 19));
		btnInfoArm.setBorderPainted(false);
		btnInfoArm.setContentAreaFilled(false);
		btnInfoArm.setFocusPainted(false);
		btnInfoArm.setOpaque(false);
		btnInfoArm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoArm1NPC window = new InfoArm1NPC();
				window.getFrame().setVisible(true);

			}
		});
		btnInfoArm.setFont(mf.MyFont(0, 13));
		btnInfoArm.setBounds(10, 122, 124, 47);
		pnlArmadura.add(btnInfoArm);

		final JButton btnQuitarArm = new JButton("-");
		btnQuitarArm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarArm.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones armaduras2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarArm.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones armaduras.png")));

			}
		});
		btnQuitarArm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarArm.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones armaduras.png")));
		btnQuitarArm.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarArm.setForeground(new Color(255, 255, 255));
		btnQuitarArm.setBackground(new Color(139, 69, 19));
		btnQuitarArm.setBorderPainted(false);
		btnQuitarArm.setContentAreaFilled(false);
		btnQuitarArm.setFocusPainted(false);
		btnQuitarArm.setOpaque(false);
		btnQuitarArm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (armor1.isPosesion() == true) {
					if (armor1.getArmor().equals("Tela")) {
						try {
							armor1.getPossesion().CalculoPosesionInv(
									StartNPC.character);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (armor1.getArmor().equals("Armadura Ligera")) {
						try {
							armor1.getPossesion().CalculoPosesionInv(
									StartNPC.character);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (armor1.getArmor().equals("Armadura Ligera")
							&& StartNPC.character.getAtributes().getStrength() > 8) {
						try {
							armor1.getPossesion().CalculoPosesionInv(
									StartNPC.character);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					if (armor1.getArmor().equals("Armadura Ligera")
							&& StartNPC.character.getAtributes().getStrength() <= 8) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 1);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura ligera dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() > 12
							&& StartNPC.character.getPrivileges().Search(
									"Fornido") == false) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 1);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() > 12
							&& StartNPC.character.getPrivileges().Search(
									"Fornido") == true) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes()
									.setDexterity(dexN);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() <= 12
							&& StartNPC.character.getAtributes().getStrength() > 10) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 2);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() <= 10
							&& StartNPC.character.getAtributes().getStrength() > 8) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 3);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() <= 8
							&& StartNPC.character.getAtributes().getStrength() > 6) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 4);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.isPosesion() == true) {
						StartNPC.contadorPosesion += 1;
						PrivilegiosNPC.posesiones -= 1;
					}
					txtArmadura.setText("");
					armor1 = new Armor("", "", false, false,posss);

				} 
				
				if (armor1.isLegendaria() == true) {
					if (armor1.getArmor().equals("Tela")) {
						try {
							armor1.getPossesion().CalculoPosesionInv(
									StartNPC.character);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (armor1.getArmor().equals("Armadura Ligera")) {
						try {
							armor1.getPossesion().CalculoPosesionInv(
									StartNPC.character);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (armor1.getArmor().equals("Armadura Ligera")
							&& StartNPC.character.getAtributes().getStrength() > 8) {
						try {
							armor1.getPossesion().CalculoPosesionInv(
									StartNPC.character);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					if (armor1.getArmor().equals("Armadura Ligera")
							&& StartNPC.character.getAtributes().getStrength() <= 8) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 1);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura ligera dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() > 12
							&& StartNPC.character.getPrivileges().Search(
									"Fornido") == false) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 1);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() > 12
							&& StartNPC.character.getPrivileges().Search(
									"Fornido") == true) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes()
									.setDexterity(dexN);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() <= 12
							&& StartNPC.character.getAtributes().getStrength() > 10) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 2);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() <= 10
							&& StartNPC.character.getAtributes().getStrength() > 8) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 3);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() <= 8
							&& StartNPC.character.getAtributes().getStrength() > 6) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 4);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										StartNPC.character);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.isLegendaria() == true) {
						StartNPC.contadorLegendario += 1;
						PrivilegiosNPC.legendario -= 1;
					}
					txtArmadura.setText("");
					armor1 = new Armor("", "", false, false,posss);

				} 
				
				else {
					if (armor1.getArmor().equals("Armadura Ligera")
							&& StartNPC.character.getAtributes().getStrength() > 8) {

					}
					if (armor1.getArmor().equals("Armadura Ligera")
							&& StartNPC.character.getAtributes().getStrength() <= 8) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 1);

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura ligera dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() > 12
							&& StartNPC.character.getPrivileges().Search(
									"Fornido") == false) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 1);

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() > 12
							&& StartNPC.character.getPrivileges().Search(
									"Fornido") == true) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes()
									.setDexterity(dexN);

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() <= 12
							&& StartNPC.character.getAtributes().getStrength() > 10) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 2);

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() <= 10
							&& StartNPC.character.getAtributes().getStrength() > 8) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 3);

						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.getArmor().equals("Armadura Pesada")
							&& StartNPC.character.getAtributes().getStrength() <= 8
							&& StartNPC.character.getAtributes().getStrength() > 6) {
						int dexN = StartNPC.character.getAtributes()
								.getDexterity();
						try {
							StartNPC.character.getAtributes().setDexterity(
									dexN + 4);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (armor1.isPosesion() == true) {
						StartNPC.contadorPosesion += 1;
						PrivilegiosNPC.posesiones -= 1;
					}
					txtArmadura.setText("");
					armor1 = new Armor("", "", false,false, null);
				}
			}
		});
		btnQuitarArm.setFont(mf.MyFont(0, 13));
		btnQuitarArm.setBounds(151, 122, 124, 47);
		pnlArmadura.add(btnQuitarArm);
		JPanel pnlArmas = new JPanel();
		pnlArmas.setOpaque(false);
		pnlArmas.setBackground(new Color(205, 133, 63));
		pnlArmas.setBounds(288, 0, 287, 190);
		pnlArmadura.add(pnlArmas);
		pnlArmas.setLayout(null);

		final JButton btnAadirArmas = new JButton("A\u00F1adir Armas");
		btnAadirArmas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadirArmas.setIcon(new ImageIcon(
						EquipoNPC.class
								.getResource("/images/botones a\u00F1adir armasyobj2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnAadirArmas.setIcon(new ImageIcon(
						EquipoNPC.class
								.getResource("/images/botones a\u00F1adir armasyobj.png")));

			}
		});
		btnAadirArmas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirArmas.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones a\u00F1adir armasyobj.png")));
		btnAadirArmas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAadirArmas.setForeground(new Color(255, 255, 255));
		btnAadirArmas.setBackground(new Color(139, 69, 19));
		btnAadirArmas.setBorderPainted(false);
		btnAadirArmas.setContentAreaFilled(false);
		btnAadirArmas.setFocusPainted(false);
		btnAadirArmas.setOpaque(false);

		btnAadirArmas.setFont(mf.MyFont(0, 13));
		btnAadirArmas.setBounds(10, 13, 123, 23);
		pnlArmas.add(btnAadirArmas);

		txtW1 = new JTextField();
		txtW1.setForeground(new Color(0, 0, 0));
		txtW1.setBackground(Color.WHITE);
		txtW1.setText(weapon1.getWeapon());
		txtW1.setEditable(false);
		txtW1.setFont(mf.MyFont(0, 11));
		txtW1.setBounds(10, 49, 123, 20);
		pnlArmas.add(txtW1);
		txtW1.setColumns(10);

		txtW2 = new JTextField();
		txtW2.setForeground(new Color(0, 0, 0));
		txtW2.setBackground(Color.WHITE);
		txtW2.setText(weapon2.getWeapon());
		txtW2.setFont(mf.MyFont(0, 11));
		txtW2.setEditable(false);
		txtW2.setColumns(10);
		txtW2.setBounds(10, 80, 123, 20);
		pnlArmas.add(txtW2);

		txtW3 = new JTextField();
		txtW3.setForeground(new Color(0, 0, 0));
		txtW3.setBackground(Color.WHITE);
		txtW3.setText(weapon3.getWeapon());
		txtW3.setFont(mf.MyFont(0, 11));
		txtW3.setEditable(false);
		txtW3.setColumns(10);
		txtW3.setBounds(10, 111, 123, 20);
		pnlArmas.add(txtW3);

		txtW4 = new JTextField();
		txtW4.setForeground(new Color(0, 0, 0));
		txtW4.setBackground(Color.WHITE);
		txtW4.setText(weapon4.getWeapon());
		txtW4.setFont(mf.MyFont(0, 11));
		txtW4.setEditable(false);
		txtW4.setColumns(10);
		txtW4.setBounds(10, 142, 123, 20);
		pnlArmas.add(txtW4);

		btnInfoW1 = new JButton("Info");
		btnInfoW1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoW1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoW1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoW1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoW1.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoW1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoW1.setForeground(new Color(255, 255, 255));
		btnInfoW1.setBackground(new Color(139, 69, 19));
		btnInfoW1.setBorderPainted(false);
		btnInfoW1.setContentAreaFilled(false);
		btnInfoW1.setFocusPainted(false);
		btnInfoW1.setOpaque(false);
		btnInfoW1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoWeap1NPC window = new InfoWeap1NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoW1.setFont(mf.MyFont(0, 13));
		btnInfoW1.setBounds(143, 46, 68, 23);
		pnlArmas.add(btnInfoW1);

		btnInfo_W2 = new JButton("Info");
		btnInfo_W2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfo_W2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfo_W2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfo_W2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfo_W2.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfo_W2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfo_W2.setForeground(new Color(255, 255, 255));
		btnInfo_W2.setBackground(new Color(139, 69, 19));
		btnInfo_W2.setBorderPainted(false);
		btnInfo_W2.setContentAreaFilled(false);
		btnInfo_W2.setFocusPainted(false);
		btnInfo_W2.setOpaque(false);
		btnInfo_W2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoWeap2NPC window = new InfoWeap2NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfo_W2.setFont(mf.MyFont(0, 13));
		btnInfo_W2.setBounds(143, 77, 68, 23);
		pnlArmas.add(btnInfo_W2);

		btnInfoW3 = new JButton("Info");
		btnInfoW3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoW3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoW3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoW3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoW3.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoW3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoW3.setForeground(new Color(255, 255, 255));
		btnInfoW3.setBackground(new Color(139, 69, 19));
		btnInfoW3.setBorderPainted(false);
		btnInfoW3.setContentAreaFilled(false);
		btnInfoW3.setFocusPainted(false);
		btnInfoW3.setOpaque(false);
		btnInfoW3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoWeap3NPC window = new InfoWeap3NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoW3.setFont(mf.MyFont(0, 13));
		btnInfoW3.setBounds(143, 108, 68, 23);
		pnlArmas.add(btnInfoW3);

		btnInfoW4 = new JButton("Info");
		btnInfoW4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoW4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoW4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoW4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoW4.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoW4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoW4.setForeground(new Color(255, 255, 255));
		btnInfoW4.setBackground(new Color(139, 69, 19));
		btnInfoW4.setBorderPainted(false);
		btnInfoW4.setContentAreaFilled(false);
		btnInfoW4.setFocusPainted(false);
		btnInfoW4.setOpaque(false);
		btnInfoW4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoWeap4NPC window = new InfoWeap4NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoW4.setFont(mf.MyFont(0, 13));
		btnInfoW4.setBounds(143, 142, 68, 23);
		pnlArmas.add(btnInfoW4);

		final JButton btnQuitarW1 = new JButton("-");
		btnQuitarW1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarW1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarW1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarW1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarW1.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarW1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarW1.setForeground(new Color(255, 255, 255));
		btnQuitarW1.setBackground(new Color(139, 69, 19));
		btnQuitarW1.setBorderPainted(false);
		btnQuitarW1.setContentAreaFilled(false);
		btnQuitarW1.setFocusPainted(false);
		btnQuitarW1.setOpaque(false);
		btnQuitarW1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtW1.setText("");
				if (weapon1.isPosesion() == true) {
					try {
						weapon1.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SkillOutOfBoundsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
				}
				if (weapon1.isLegendaria() == true) {
					try {
						weapon1.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SkillOutOfBoundsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					StartNPC.contadorLegendario += 1;
					PrivilegiosNPC.legendario -= 1;
					legPuesto--;
				}
				weapon1 = new Weapons("", "", false, false, posss,"");
				armasPuestas--;
			}
		});
		btnQuitarW1.setBounds(221, 46, 53, 23);
		pnlArmas.add(btnQuitarW1);

		final JButton btnQuitarW2 = new JButton("-");
		btnQuitarW2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarW2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarW2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarW2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarW2.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarW2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarW2.setForeground(new Color(255, 255, 255));
		btnQuitarW2.setBackground(new Color(139, 69, 19));
		btnQuitarW2.setBorderPainted(false);
		btnQuitarW2.setContentAreaFilled(false);
		btnQuitarW2.setFocusPainted(false);
		btnQuitarW2.setOpaque(false);
		btnQuitarW2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weapon2.isPosesion() == true) {
					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						weapon2.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (weapon2.isLegendaria() == true) {
					try {
						weapon2.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					StartNPC.contadorLegendario += 1;
					PrivilegiosNPC.legendario -= 1;
					legPuesto--;
				}
				txtW2.setText("");
				weapon2 = new Weapons("", "", false, false, posss,"");
				armasPuestas--;
			}
		});
		btnQuitarW2.setBounds(221, 77, 53, 23);
		pnlArmas.add(btnQuitarW2);

		final JButton btnQuitarW3 = new JButton("-");
		btnQuitarW3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarW3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarW3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarW3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarW3.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarW3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarW3.setForeground(new Color(255, 255, 255));
		btnQuitarW3.setBackground(new Color(139, 69, 19));
		btnQuitarW3.setBorderPainted(false);
		btnQuitarW3.setContentAreaFilled(false);
		btnQuitarW3.setFocusPainted(false);
		btnQuitarW3.setOpaque(false);
		btnQuitarW3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weapon3.isPosesion() == true) {
					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						weapon3.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (weapon3.isLegendaria() == true) {
					try {
						weapon3.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					StartNPC.contadorLegendario += 1;
					PrivilegiosNPC.legendario -= 1;
					legPuesto--;
				}
				txtW3.setText("");
				weapon3 = new Weapons("", "", false, false, posss,"");
				armasPuestas--;
			}
		});
		btnQuitarW3.setBounds(221, 108, 53, 23);
		pnlArmas.add(btnQuitarW3);

		final JButton btnQuitarW4 = new JButton("-");
		btnQuitarW4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarW4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarW4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarW4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarW4.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarW4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarW4.setForeground(new Color(255, 255, 255));
		btnQuitarW4.setBackground(new Color(139, 69, 19));
		btnQuitarW4.setBorderPainted(false);
		btnQuitarW4.setContentAreaFilled(false);
		btnQuitarW4.setFocusPainted(false);
		btnQuitarW4.setOpaque(false);
		btnQuitarW4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weapon4.isPosesion() == true) {
					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						weapon4.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (weapon4.isLegendaria() == true) {
					try {
						weapon4.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					StartNPC.contadorLegendario += 1;
					PrivilegiosNPC.legendario -= 1;
					legPuesto--;
				}
				txtW4.setText("");
				weapon4 = new Weapons("", "", false, false, posss,"");
				armasPuestas--;
			}
		});
		btnQuitarW4.setBounds(221, 142, 53, 23);
		pnlArmas.add(btnQuitarW4);

		lblMaxArmas = new JLabel("M\u00E1ximo:");
		lblMaxArmas.setForeground(Color.WHITE);
		lblMaxArmas.setBounds(143, 13, 68, 14);
		lblMaxArmas.setFont(mf.MyFont(0, 13));
		pnlArmas.add(lblMaxArmas);

		txtMaxArmas = new JTextField();
		txtMaxArmas.setText("" + pweap);
		txtMaxArmas.setEditable(false);
		txtMaxArmas.setBackground(Color.WHITE);
		txtMaxArmas.setBounds(196, 11, 32, 20);
		pnlArmas.add(txtMaxArmas);
		txtMaxArmas.setColumns(10);
		btnAadirArmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtW1.getText().equals("") && pweap >= 1) {
					ArmasNPC window = new ArmasNPC();
					window.getFrame().setVisible(true);
				} else {
					if (txtW2.getText().equals("") && pweap >= 2) {
						ArmasNPC window = new ArmasNPC();
						window.getFrame().setVisible(true);
					} else {
						if (txtW3.getText().equals("") && pweap >= 3) {
							ArmasNPC window = new ArmasNPC();
							window.getFrame().setVisible(true);
						} else {
							if (txtW4.getText().equals("") && pweap >= 4) {
								ArmasNPC window = new ArmasNPC();
								window.getFrame().setVisible(true);

							} else {
								JOptionPane.showMessageDialog(
										frmHistoriasDeZagas,
										"No puedes llevar más armas.", "",
										JOptionPane.ERROR_MESSAGE);

							}

						}

					}

				}

			}
		});

		JPanel pnlObjetos = new JPanel();
		pnlObjetos.setOpaque(false);
		pnlObjetos.setBackground(new Color(205, 133, 63));
		pnlObjetos.setLayout(null);
		pnlObjetos.setBounds(0, 226, 290, 190);
		frmHistoriasDeZagas.getContentPane().add(pnlObjetos);

		txtObj1 = new JTextField();
		txtObj1.setForeground(new Color(0, 0, 0));
		txtObj1.setBackground(Color.WHITE);
		txtObj1.setEditable(false);
		txtObj1.setText(misc1.getMisc());
		txtObj1.setFont(mf.MyFont(0, 11));
		txtObj1.setColumns(10);
		txtObj1.setBounds(10, 49, 123, 20);
		pnlObjetos.add(txtObj1);

		txtObj2 = new JTextField();
		txtObj2.setForeground(new Color(0, 0, 0));
		txtObj2.setBackground(Color.WHITE);
		txtObj2.setEditable(false);
		txtObj2.setText(misc2.getMisc());
		txtObj2.setFont(mf.MyFont(0, 11));
		txtObj2.setColumns(10);
		txtObj2.setBounds(10, 80, 123, 20);
		pnlObjetos.add(txtObj2);

		txtObj3 = new JTextField();
		txtObj3.setForeground(new Color(0, 0, 0));
		txtObj3.setBackground(Color.WHITE);
		txtObj3.setText(misc3.getMisc());
		txtObj3.setEditable(false);
		txtObj3.setFont(mf.MyFont(0, 11));
		txtObj3.setColumns(10);
		txtObj3.setBounds(10, 111, 123, 20);
		pnlObjetos.add(txtObj3);

		txtObj4 = new JTextField();
		txtObj4.setForeground(new Color(0, 0, 0));
		txtObj4.setBackground(Color.WHITE);
		txtObj4.setEditable(false);
		txtObj4.setText(misc4.getMisc());
		txtObj4.setFont(mf.MyFont(0, 11));
		txtObj4.setColumns(10);
		txtObj4.setBounds(10, 142, 123, 20);
		pnlObjetos.add(txtObj4);

		final JButton btnAadirObjetos = new JButton("A\u00F1adir Objetos");
		btnAadirObjetos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadirObjetos.setIcon(new ImageIcon(
						EquipoNPC.class
								.getResource("/images/botones a\u00F1adir armasyobj2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnAadirObjetos.setIcon(new ImageIcon(
						EquipoNPC.class
								.getResource("/images/botones a\u00F1adir armasyobj.png")));

			}
		});
		btnAadirObjetos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirObjetos.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones a\u00F1adir armasyobj.png")));
		btnAadirObjetos.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnAadirObjetos.setForeground(new Color(255, 255, 255));
		btnAadirObjetos.setBackground(new Color(139, 69, 19));
		btnAadirObjetos.setBorderPainted(false);
		btnAadirObjetos.setContentAreaFilled(false);
		btnAadirObjetos.setFocusPainted(false);
		btnAadirObjetos.setOpaque(false);
		btnAadirObjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (EquipoNPC.getTextField_4().getText().equals("")
						&& EquipoNPC.pmisc >= 1) {
					ObjetosNPC window = new ObjetosNPC();
					window.getFrame().setVisible(true);
				} else {
					if (EquipoNPC.getTextField_5().getText().equals("")
							&& EquipoNPC.pmisc >= 2) {
						ObjetosNPC window = new ObjetosNPC();
						window.getFrame().setVisible(true);
					} else {
						if (EquipoNPC.getTextField_6().getText().equals("")
								&& EquipoNPC.pmisc >= 3) {
							ObjetosNPC window = new ObjetosNPC();
							window.getFrame().setVisible(true);
						} else {
							if (EquipoNPC.getTextField_7().getText().equals("")
									&& EquipoNPC.pmisc >= 4) {
								ObjetosNPC window = new ObjetosNPC();
								window.getFrame().setVisible(true);
							} else {

								JOptionPane.showMessageDialog(
										frmHistoriasDeZagas,
										"No puedes llevar más objetos.", "",
										JOptionPane.ERROR_MESSAGE);

							}
						}
					}

				}

			}
		});
		btnAadirObjetos.setFont(mf.MyFont(0, 13));
		btnAadirObjetos.setBounds(10, 15, 123, 23);
		pnlObjetos.add(btnAadirObjetos);

		btnInfoObj1 = new JButton("Info");
		btnInfoObj1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoObj1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoObj1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoObj1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoObj1.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoObj1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoObj1.setForeground(new Color(255, 255, 255));
		btnInfoObj1.setBackground(new Color(139, 69, 19));
		btnInfoObj1.setBorderPainted(false);
		btnInfoObj1.setContentAreaFilled(false);
		btnInfoObj1.setFocusPainted(false);
		btnInfoObj1.setOpaque(false);
		btnInfoObj1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InfoMisc1NPC window = new InfoMisc1NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoObj1.setFont(mf.MyFont(0, 13));
		btnInfoObj1.setBounds(143, 46, 69, 23);
		pnlObjetos.add(btnInfoObj1);

		btnInfoObj2 = new JButton("Info");
		btnInfoObj2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoObj2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoObj2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoObj2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoObj2.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoObj2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoObj2.setForeground(new Color(255, 255, 255));
		btnInfoObj2.setBackground(new Color(139, 69, 19));
		btnInfoObj2.setBorderPainted(false);
		btnInfoObj2.setContentAreaFilled(false);
		btnInfoObj2.setFocusPainted(false);
		btnInfoObj2.setOpaque(false);
		btnInfoObj2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoMisc2NPC window = new InfoMisc2NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoObj2.setFont(mf.MyFont(0, 13));
		btnInfoObj2.setBounds(143, 77, 69, 23);
		pnlObjetos.add(btnInfoObj2);

		btnInfoObj3 = new JButton("Info");
		btnInfoObj3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoObj3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoObj3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoObj3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoObj3.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoObj3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoObj3.setForeground(new Color(255, 255, 255));
		btnInfoObj3.setBackground(new Color(139, 69, 19));
		btnInfoObj3.setBorderPainted(false);
		btnInfoObj3.setContentAreaFilled(false);
		btnInfoObj3.setFocusPainted(false);
		btnInfoObj3.setOpaque(false);
		btnInfoObj3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoMisc3NPC window = new InfoMisc3NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoObj3.setFont(mf.MyFont(0, 13));
		btnInfoObj3.setBounds(143, 108, 69, 23);
		pnlObjetos.add(btnInfoObj3);

		btnInfoObj4 = new JButton("Info");
		btnInfoObj4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoObj4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoObj4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoObj4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoObj4.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoObj4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoObj4.setForeground(new Color(255, 255, 255));
		btnInfoObj4.setBackground(new Color(139, 69, 19));
		btnInfoObj4.setBorderPainted(false);
		btnInfoObj4.setContentAreaFilled(false);
		btnInfoObj4.setFocusPainted(false);
		btnInfoObj4.setOpaque(false);
		btnInfoObj4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoMisc4NPC window = new InfoMisc4NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoObj4.setFont(mf.MyFont(0, 13));
		btnInfoObj4.setBounds(143, 139, 69, 23);
		pnlObjetos.add(btnInfoObj4);

		final JButton btnQuitarObj1 = new JButton("-");
		btnQuitarObj1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarObj1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarObj1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarObj1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarObj1.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarObj1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarObj1.setForeground(new Color(255, 255, 255));
		btnQuitarObj1.setBackground(new Color(139, 69, 19));
		btnQuitarObj1.setBorderPainted(false);
		btnQuitarObj1.setContentAreaFilled(false);
		btnQuitarObj1.setFocusPainted(false);
		btnQuitarObj1.setOpaque(false);
		btnQuitarObj1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (misc1.isPosesion() == true) {
					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						misc1.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (misc1.isLegendaria() == true) {
					try {
						misc1.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					StartNPC.contadorLegendario += 1;
					PrivilegiosNPC.legendario -= 1;
					legPuesto--;
				}
				txtObj1.setText("");
				misc1 = new Misc("", "", false,false, posss);
				objetosPuestos--;
			}
		});
		btnQuitarObj1.setBounds(222, 46, 53, 23);
		pnlObjetos.add(btnQuitarObj1);

		final JButton btnQuitarObj2 = new JButton("-");
		btnQuitarObj2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarObj2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarObj2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarObj2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarObj2.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarObj2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarObj2.setForeground(new Color(255, 255, 255));
		btnQuitarObj2.setBackground(new Color(139, 69, 19));
		btnQuitarObj2.setBorderPainted(false);
		btnQuitarObj2.setContentAreaFilled(false);
		btnQuitarObj2.setFocusPainted(false);
		btnQuitarObj2.setOpaque(false);
		btnQuitarObj2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (misc2.isPosesion() == true) {
					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						misc2.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (misc2.isLegendaria() == true) {
					try {
						misc2.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					StartNPC.contadorLegendario += 1;
					PrivilegiosNPC.legendario -= 1;
					legPuesto--;
				}
				txtObj2.setText("");
				misc2 = new Misc("", "", false,false, posss);
				objetosPuestos--;
			}
		});
		btnQuitarObj2.setBounds(222, 77, 53, 23);
		pnlObjetos.add(btnQuitarObj2);

		final JButton btnQuitarObj3 = new JButton("-");
		btnQuitarObj3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarObj3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarObj3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarObj3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarObj3.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarObj3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarObj3.setForeground(new Color(255, 255, 255));
		btnQuitarObj3.setBackground(new Color(139, 69, 19));
		btnQuitarObj3.setBorderPainted(false);
		btnQuitarObj3.setContentAreaFilled(false);
		btnQuitarObj3.setFocusPainted(false);
		btnQuitarObj3.setOpaque(false);
		btnQuitarObj3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (misc3.isPosesion() == true) {
					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						misc3.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (misc3.isLegendaria() == true) {
					try {
						misc3.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					StartNPC.contadorLegendario += 1;
					PrivilegiosNPC.legendario -= 1;
					legPuesto--;
				}
				txtObj3.setText("");
				misc3 = new Misc("", "", false,false, posss);
				objetosPuestos--;
			}
		});
		btnQuitarObj3.setBounds(222, 108, 53, 23);
		pnlObjetos.add(btnQuitarObj3);

		final JButton btnQuitarObj4 = new JButton("-");
		btnQuitarObj4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarObj4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarObj4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarObj4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarObj4.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarObj4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarObj4.setForeground(new Color(255, 255, 255));
		btnQuitarObj4.setBackground(new Color(139, 69, 19));
		btnQuitarObj4.setBorderPainted(false);
		btnQuitarObj4.setContentAreaFilled(false);
		btnQuitarObj4.setFocusPainted(false);
		btnQuitarObj4.setOpaque(false);
		btnQuitarObj4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (misc4.isPosesion() == true) {
					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						misc4.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (misc4.isLegendaria() == true) {
					try {
						misc4.getPossesion().CalculoPosesionInv(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					StartNPC.contadorLegendario += 1;
					PrivilegiosNPC.legendario -= 1;
					legPuesto--;
				}
				txtObj4.setText("");
				misc4 = new Misc("", "", false,false, posss);
				objetosPuestos--;
			}
		});
		btnQuitarObj4.setBounds(222, 139, 53, 23);
		pnlObjetos.add(btnQuitarObj4);

		JPanel pnlAccesorios = new JPanel();
		pnlAccesorios.setOpaque(false);
		pnlAccesorios.setBackground(new Color(205, 133, 63));
		pnlAccesorios.setLayout(null);
		pnlAccesorios.setBounds(285, 226, 290, 190);
		frmHistoriasDeZagas.getContentPane().add(pnlAccesorios);

		txtAcc1 = new JTextField();
		txtAcc1.setForeground(new Color(0, 0, 0));
		txtAcc1.setBackground(Color.WHITE);
		txtAcc1.setText(accesories1.getAccesory());
		txtAcc1.setFont(mf.MyFont(0, 11));
		txtAcc1.setEditable(false);
		txtAcc1.setColumns(10);
		txtAcc1.setBounds(10, 49, 123, 20);
		pnlAccesorios.add(txtAcc1);

		txtAcc2 = new JTextField();
		txtAcc2.setForeground(new Color(0, 0, 0));
		txtAcc2.setBackground(Color.WHITE);
		txtAcc2.setText(accesories2.getAccesory());
		txtAcc2.setFont(mf.MyFont(0, 11));
		txtAcc2.setEditable(false);
		txtAcc2.setColumns(10);
		txtAcc2.setBounds(10, 80, 123, 20);
		pnlAccesorios.add(txtAcc2);

		txtAcc3 = new JTextField();
		txtAcc3.setForeground(new Color(0, 0, 0));
		txtAcc3.setBackground(Color.WHITE);
		txtAcc3.setText(accesories3.getAccesory());
		txtAcc3.setFont(mf.MyFont(0, 11));
		txtAcc3.setEditable(false);
		txtAcc3.setColumns(10);
		txtAcc3.setBounds(10, 111, 123, 20);
		pnlAccesorios.add(txtAcc3);

		txtAcc4 = new JTextField();
		txtAcc4.setForeground(new Color(0, 0, 0));
		txtAcc4.setBackground(Color.WHITE);
		txtAcc4.setText(accesories4.getAccesory());
		txtAcc4.setFont(mf.MyFont(0, 11));
		txtAcc4.setEditable(false);
		txtAcc4.setColumns(10);
		txtAcc4.setBounds(10, 142, 123, 20);
		pnlAccesorios.add(txtAcc4);

		txtAccesorios = new JTextField();
		txtAccesorios.setOpaque(false);
		txtAccesorios.setForeground(Color.WHITE);
		txtAccesorios.setBackground(new Color(205, 133, 63));
		txtAccesorios.setText("Accesorios:");
		txtAccesorios.setFont(mf.MyFont(0, 13));
		txtAccesorios.setEditable(false);
		txtAccesorios.setColumns(10);
		txtAccesorios.setBorder(null);
		txtAccesorios.setBounds(37, 18, 69, 20);
		pnlAccesorios.add(txtAccesorios);
		

		lblDinero = new JLabel("Dinero:");
		lblDinero.setForeground(Color.WHITE);
		lblDinero.setFont(mf.MyFont(0, 13));
		lblDinero.setBounds(143, 20, 68, 14);
		pnlAccesorios.add(lblDinero);
		
		textField_13 = new JTextField();
		textField_13.setText(""+dinero);
		textField_13.setColumns(10);
		textField_13.setBackground(Color.WHITE);
		textField_13.setBounds(196, 18, 32, 20);
		pnlAccesorios.add(textField_13);

		btnInfoAcc1 = new JButton("Info");
		btnInfoAcc1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoAcc1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoAcc1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoAcc1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoAcc1.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoAcc1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoAcc1.setForeground(new Color(255, 255, 255));
		btnInfoAcc1.setBackground(new Color(139, 69, 19));
		btnInfoAcc1.setBorderPainted(false);
		btnInfoAcc1.setContentAreaFilled(false);
		btnInfoAcc1.setFocusPainted(false);
		btnInfoAcc1.setOpaque(false);
		btnInfoAcc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoAcc1NPC window = new InfoAcc1NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoAcc1.setFont(mf.MyFont(0, 13));
		btnInfoAcc1.setBounds(143, 46, 69, 23);
		pnlAccesorios.add(btnInfoAcc1);

		btnInfoAcc2 = new JButton("Info");
		btnInfoAcc2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoAcc2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoAcc2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoAcc2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoAcc2.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoAcc2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoAcc2.setForeground(new Color(255, 255, 255));
		btnInfoAcc2.setBackground(new Color(139, 69, 19));
		btnInfoAcc2.setBorderPainted(false);
		btnInfoAcc2.setContentAreaFilled(false);
		btnInfoAcc2.setFocusPainted(false);
		btnInfoAcc2.setOpaque(false);
		btnInfoAcc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoAcc2NPC window = new InfoAcc2NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoAcc2.setFont(mf.MyFont(0, 13));
		btnInfoAcc2.setBounds(143, 77, 69, 23);
		pnlAccesorios.add(btnInfoAcc2);

		btnInfoAcc3 = new JButton("Info");
		btnInfoAcc3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoAcc3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoAcc3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoAcc3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoAcc3.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoAcc3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoAcc3.setForeground(new Color(255, 255, 255));
		btnInfoAcc3.setBackground(new Color(139, 69, 19));
		btnInfoAcc3.setBorderPainted(false);
		btnInfoAcc3.setContentAreaFilled(false);
		btnInfoAcc3.setFocusPainted(false);
		btnInfoAcc3.setOpaque(false);
		btnInfoAcc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoAcc3NPC window = new InfoAcc3NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoAcc3.setFont(mf.MyFont(0, 13));
		btnInfoAcc3.setBounds(143, 108, 69, 23);
		pnlAccesorios.add(btnInfoAcc3);

		btnInfoAcc4 = new JButton("Info");
		btnInfoAcc4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoAcc4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoAcc4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton info.png")));

			}
		});
		btnInfoAcc4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoAcc4.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton info.png")));
		btnInfoAcc4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnInfoAcc4.setForeground(new Color(255, 255, 255));
		btnInfoAcc4.setBackground(new Color(139, 69, 19));
		btnInfoObj1.setBorderPainted(false);

		lblMaxObj = new JLabel("M\u00E1ximo:");
		lblMaxObj.setForeground(Color.WHITE);
		lblMaxObj.setFont(mf.MyFont(0, 13));
		lblMaxObj.setBounds(143, 17, 68, 14);
		pnlObjetos.add(lblMaxObj);

		txtMaxObj = new JTextField();
		txtMaxObj.setText("" + pmisc);
		txtMaxObj.setEditable(false);
		txtMaxObj.setColumns(10);
		txtMaxObj.setBackground(Color.WHITE);
		txtMaxObj.setBounds(196, 15, 32, 20);
		pnlObjetos.add(txtMaxObj);
		btnInfoAcc4.setBorderPainted(false);
		btnInfoAcc4.setContentAreaFilled(false);
		btnInfoAcc4.setFocusPainted(false);
		btnInfoAcc4.setOpaque(false);
		btnInfoAcc4.setContentAreaFilled(false);
		btnInfoAcc4.setFocusPainted(false);
		btnInfoAcc4.setOpaque(false);
		btnInfoAcc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoAcc4NPC window = new InfoAcc4NPC();
				window.getFrame().setVisible(true);
			}
		});
		btnInfoAcc4.setFont(mf.MyFont(0, 13));
		btnInfoAcc4.setBounds(143, 139, 69, 23);
		pnlAccesorios.add(btnInfoAcc4);

		final JButton btnQuitarAcc1 = new JButton("-");
		btnQuitarAcc1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarAcc1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarAcc1.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarAcc1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarAcc1.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarAcc1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarAcc1.setForeground(new Color(255, 255, 255));
		btnQuitarAcc1.setBackground(new Color(139, 69, 19));
		btnQuitarAcc1.setBorderPainted(false);
		btnQuitarAcc1.setContentAreaFilled(false);
		btnQuitarAcc1.setFocusPainted(false);
		btnQuitarAcc1.setOpaque(false);
		btnQuitarAcc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtAcc1.getText().equals("")) {
				} else {
					if(accesories1.isPosesion()==true){
					txtAcc1.setText("");

					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						accesories1.getPossesion().CalculoPosesionInv(
								StartNPC.character);
						accesories1 = new Accesories("", "", false,false, posss);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}}
					
					if(accesories1.isLegendaria()==true){
						txtAcc1.setText("");

						StartNPC.contadorLegendario += 1;
						PrivilegiosNPC.legendario -= 1;
						posPuestas--;
						try {
							accesories1.getPossesion().CalculoPosesionInv(
									StartNPC.character);
							accesories1 = new Accesories("", "", false,false, posss);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}
				}
			}
		});
		btnQuitarAcc1.setBounds(222, 46, 53, 23);
		pnlAccesorios.add(btnQuitarAcc1);

		final JButton btnQuitarAcc2 = new JButton("-");
		btnQuitarAcc2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarAcc2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarAcc2.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarAcc2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarAcc2.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarAcc2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarAcc2.setForeground(new Color(255, 255, 255));
		btnQuitarAcc2.setBackground(new Color(139, 69, 19));
		btnQuitarAcc2.setBorderPainted(false);
		btnQuitarAcc2.setContentAreaFilled(false);
		btnQuitarAcc2.setFocusPainted(false);
		btnQuitarAcc2.setOpaque(false);
		btnQuitarAcc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtAcc2.getText().equals("")) {
				} else {
					if(accesories2.isPosesion()==true){
					txtAcc2.setText("");

					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						accesories2.getPossesion().CalculoPosesionInv(
								StartNPC.character);
						accesories2 = new Accesories("", "", false,false, posss);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}}
					
					if(accesories2.isLegendaria()==true){
						txtAcc2.setText("");

						StartNPC.contadorLegendario += 1;
						PrivilegiosNPC.legendario -= 1;
						posPuestas--;
						try {
							accesories2.getPossesion().CalculoPosesionInv(
									StartNPC.character);
							accesories2 = new Accesories("", "", false,false, posss);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}
				}
			}
		});
		btnQuitarAcc2.setBounds(222, 77, 53, 23);
		pnlAccesorios.add(btnQuitarAcc2);

		final JButton btnQuitarAcc3 = new JButton("-");
		btnQuitarAcc3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarAcc3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarAcc3.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarAcc3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarAcc3.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarAcc3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarAcc3.setForeground(new Color(255, 255, 255));
		btnQuitarAcc3.setBackground(new Color(139, 69, 19));
		btnQuitarAcc3.setBorderPainted(false);
		btnQuitarAcc3.setContentAreaFilled(false);
		btnQuitarAcc3.setFocusPainted(false);
		btnQuitarAcc3.setOpaque(false);
		btnQuitarAcc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtAcc3.getText().equals("")) {
				} else {
					if(accesories3.isPosesion()==true){
					txtAcc3.setText("");

					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						accesories3.getPossesion().CalculoPosesionInv(
								StartNPC.character);
						accesories3 = new Accesories("", "", false,false, posss);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}}
					
					if(accesories3.isLegendaria()==true){
						txtAcc3.setText("");

						StartNPC.contadorLegendario += 1;
						PrivilegiosNPC.legendario -= 1;
						posPuestas--;
						try {
							accesories3.getPossesion().CalculoPosesionInv(
									StartNPC.character);
							accesories3 = new Accesories("", "", false,false, posss);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}
				}
			}
		});
		btnQuitarAcc3.setBounds(222, 108, 53, 23);
		pnlAccesorios.add(btnQuitarAcc3);

		final JButton btnQuitarAcc4 = new JButton("-");
		btnQuitarAcc4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarAcc4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarAcc4.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarAcc4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarAcc4.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-.png")));
		btnQuitarAcc4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnQuitarAcc4.setForeground(new Color(255, 255, 255));
		btnQuitarAcc4.setBackground(new Color(139, 69, 19));
		btnQuitarAcc4.setBorderPainted(false);
		btnQuitarAcc4.setContentAreaFilled(false);
		btnQuitarAcc4.setFocusPainted(false);
		btnQuitarAcc4.setOpaque(false);
		btnQuitarAcc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtAcc4.getText().equals("")) {
				} else {
					if(accesories4.isPosesion()==true){
					txtAcc4.setText("");

					StartNPC.contadorPosesion += 1;
					PrivilegiosNPC.posesiones -= 1;
					posPuestas--;
					try {
						accesories4.getPossesion().CalculoPosesionInv(
								StartNPC.character);
						accesories4 = new Accesories("", "", false,false, posss);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SkillOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}}
					
					if(accesories4.isLegendaria()==true){
						txtAcc4.setText("");

						StartNPC.contadorLegendario += 1;
						PrivilegiosNPC.legendario -= 1;
						posPuestas--;
						try {
							accesories4.getPossesion().CalculoPosesionInv(
									StartNPC.character);
							accesories4 = new Accesories("", "", false,false, posss);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}
				}
			}
		});
		btnQuitarAcc4.setBounds(222, 139, 53, 23);
		pnlAccesorios.add(btnQuitarAcc4);
		final JButton btnPosesiones = new JButton("Posesiones/Artefactos");
		btnPosesiones.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnPosesiones.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton posesiones2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnPosesiones.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton posesiones.png")));

			}
		});
		btnPosesiones.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPosesiones.setIcon(new ImageIcon(EquipoNPC.class.getResource("/images/boton posesiones.png")));
		btnPosesiones.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnPosesiones.setForeground(new Color(255, 255, 255));
		btnPosesiones.setBackground(new Color(139, 69, 19));
		btnPosesiones.setBorderPainted(false);
		btnPosesiones.setContentAreaFilled(false);
		btnPosesiones.setFocusPainted(false);
		btnPosesiones.setOpaque(false);
		btnPosesiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int seleccion = JOptionPane.showOptionDialog(
						   frmHistoriasDeZagas,
						   "Selecciona que quieres añadir al inventario:", 
						   "Artefactos y Posesiones",
						   JOptionPane.YES_NO_CANCEL_OPTION,
						   JOptionPane.PLAIN_MESSAGE,
						   null,    // null para icono por defecto.
						   new Object[] { "Posesiones", "Artefactos", "Cancelar" },   // null para YES, NO y CANCEL
						   "opcion 1");
						 
						if (seleccion == 0){
							if (StartNPC.contadorPosesion > PrivilegiosNPC.posesiones) {
								PosesionesNPC.ppos = 3;
								PosesionesNPC.ppos1 = 0;
								PosesionesNPC.ppos2 = 0;
								PosesionesNPC.ppos3 = 0;
								PosesionesNPC window = new PosesionesNPC();
								window.getFrame().setVisible(true);
							}
							if (StartNPC.contadorPosesion <= PrivilegiosNPC.posesiones ) {
								JOptionPane.showMessageDialog(frmHistoriasDeZagas,
								"No puedes llevar más posesiones.", "",
								JOptionPane.ERROR_MESSAGE);}
						}
						if(seleccion == 1){
							if (StartNPC.contadorLegendario>PrivilegiosNPC.legendario ) {
								ArtefactosNPC.ppos = 3;
								ArtefactosNPC window = new ArtefactosNPC();
								window.getFrame().setVisible(true);
							} 
							if (StartNPC.contadorLegendario <= PrivilegiosNPC.legendario ) {
								JOptionPane.showMessageDialog(frmHistoriasDeZagas,
								"No puedes llevar artefactos legendarios.", "",
								JOptionPane.ERROR_MESSAGE);}
						}
						   	
				
		
			}
		});

		btnPosesiones.setFont(mf.MyFont(0, 12));
		if (pweap >= 1) {
			txtW1.setVisible(true);
			btnInfoW1.setVisible(true);
			btnQuitarW1.setVisible(true);
		}
		if (pweap >= 2) {
			txtW2.setVisible(true);
			btnInfo_W2.setVisible(true);
			btnQuitarW2.setVisible(true);
		}
		if (pweap >= 3) {
			txtW3.setVisible(true);
			btnInfoW3.setVisible(true);
			btnQuitarW3.setVisible(true);
		}
		if (pweap >= 4) {
			txtW4.setVisible(true);
			btnInfoW4.setVisible(true);
			btnQuitarW4.setVisible(true);
		}
		if (pmisc >= 1) {
			txtObj1.setVisible(true);
			btnInfoObj1.setVisible(true);
			btnQuitarObj1.setVisible(true);
		}
		if (pmisc >= 2) {
			txtObj2.setVisible(true);
			btnInfoObj2.setVisible(true);
			btnQuitarObj2.setVisible(true);
		}
		if (pmisc >= 3) {
			txtObj3.setVisible(true);
			btnInfoObj3.setVisible(true);
			btnQuitarObj3.setVisible(true);
		}
		if (pmisc >= 4) {
			txtObj4.setVisible(true);
			btnInfoObj4.setVisible(true);
			btnQuitarObj4.setVisible(true);
		}

		btnPosesiones.setBounds(225, 438, 127, 32);
		frmHistoriasDeZagas.getContentPane().add(btnPosesiones);

		final JButton btnContinuar = new JButton("");
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton continuar2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton continuar.png")));
			}
		});
		btnContinuar.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton continuar.png")));
		btnContinuar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnContinuar.setForeground(new Color(255, 255, 255));
		btnContinuar.setBackground(new Color(139, 69, 19));
		btnContinuar.setBorderPainted(false);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setFocusPainted(false);
		btnContinuar.setOpaque(false);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Inventory> equipo = new ArrayList<Inventory>();
				StartNPC.character.setArmor(armor1);
				equipo.add(weapon1);
				equipo.add(weapon2);
				equipo.add(weapon3);
				equipo.add(weapon4);
				equipo.add(misc1);
				equipo.add(misc2);
				equipo.add(misc3);
				equipo.add(misc4);
				equipo.add(accesories1);
				equipo.add(accesories2);
				equipo.add(accesories3);
				equipo.add(accesories4);
				dinero=Integer.parseInt(textField_13.getText());
				Equipment equipoo = new Equipment();
				StartNPC.character.setEquipment(equipoo);
				StartNPC.character.getEquipment().setInventory(equipo);
				frmHistoriasDeZagas.dispose();

				AvanzadoNPC window = new AvanzadoNPC();
				window.getFrmHistoriasDeZagas().setVisible(true);

			}
		});
		btnContinuar.setFont(mf.MyFont(0, 13));
		btnContinuar.setBounds(479, 438, 99, 41);
		frmHistoriasDeZagas.getContentPane().add(btnContinuar);

		btnAtras = new JButton("");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton atras2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/boton atras.png")));

			}
		});
		btnAtras.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/boton atras.png")));
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.setBackground(new Color(139, 69, 19));
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setFocusPainted(false);
		btnAtras.setOpaque(false);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHistoriasDeZagas.dispose();
				HabilidadesNPC window = new HabilidadesNPC();
				window.getFrame().setVisible(true);
			}
		});
		btnAtras.setFont(mf.MyFont(0, 13));
		btnAtras.setBounds(0, 438, 99, 41);
		frmHistoriasDeZagas.getContentPane().add(btnAtras);

		btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaEquipo window = new AyudaEquipo();
				window.getFrame().setVisible(true);
			}
		});
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAyuda.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-inicio-ayuda2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnAyuda.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-inicio-ayuda.png")));

			}
		});
		btnAyuda.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnAyuda.setOpaque(false);
		btnAyuda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setFont(mf.MyFont(0, 15));
		btnAyuda.setFocusPainted(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

		null, null));
		btnAyuda.setBackground(new Color(139, 69, 19));
		btnAyuda.setBounds(362, 438, 111, 32);
		frmHistoriasDeZagas.getContentPane().add(btnAyuda);

		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int seleccion = JOptionPane
						.showOptionDialog(
								frmHistoriasDeZagas,
								"Si vuelves al inicio se perderán todos los datos no guardados.",
								"¡Atención!", JOptionPane.YES_NO_OPTION,
								JOptionPane.PLAIN_MESSAGE, null, new Object[] {
										"Aceptar", "Cancelar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
								"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					StartNPC.razaAnt="";
					StartNPC.nombre = "";
					StartNPC.edad = 0;
					StartNPC.raza = 0;
					StartNPC.descrpF = "";
					BendicionesNPC.bendicion = 0;
					PrivilegiosNPC.priv1 = 0;
					PrivilegiosNPC.priv2 = 0;
					PrivilegiosNPC.priv3 = 0;
					PrivilegiosNPC.priv4 = 0;
					PrivilegiosNPC.priv5 = 0;
					PrivilegiosNPC.rev1 = 0;
					PrivilegiosNPC.rev2 = 0;
					PrivilegiosNPC.rev3 = 0;
					PrivilegiosNPC.rev4 = 0;
					StartNPC.contadorLegendario = 0;
					PrivilegiosNPC.legendario = 0;
					PrivilegiosNPC.posesiones = 0;
					StartNPC.atrpoints = new AtributePoints();
					StartNPC.skpoints = new SkillPoints();
					StartNPC.atributos = new Atributes(StartNPC.atrpoints);
					StartNPC.combatSkills = new CombatSkills(StartNPC.skpoints);
					StartNPC.knowledgeSkills = new KnowledgeSkills(
							StartNPC.skpoints);
					StartNPC.magicSkills = new MagicSkills(StartNPC.skpoints);
					StartNPC.knowhowSkills = new KnowHowSkills(
							StartNPC.skpoints);
					AtributosNPC.minFuerza = 6;
					AtributosNPC.minDestreza = 6;
					AtributosNPC.minResistencia = 6;
					AtributosNPC.minResistenciaM = 6;
					AtributosNPC.minCarisma = 6;
					AtributosNPC.minPercepcion = 6;
					AtributosNPC.minInteligencia = 6;
					CombateNPC.minAsta = 0;
					CombateNPC.minBloq = 0;
					CombateNPC.minDist = 0;
					CombateNPC.minDos = 0;
					CombateNPC.minEsq = 0;
					CombateNPC.minUna = 0;
					ConocimientosNPC.minAG = 0;
					ConocimientosNPC.minCS = 0;
					ConocimientosNPC.minDip = 0;
					ConocimientosNPC.minEt = 0;
					ConocimientosNPC.minInv = 0;
					ConocimientosNPC.minMed = 0;
					ConocimientosNPC.minNeg = 0;
					ConocimientosNPC.minOc = 0;
					MagiaNPC.minAgua = 0;
					MagiaNPC.minArcana = 0;
					MagiaNPC.minBlanca = 0;
					MagiaNPC.minDruidica = 0;
					MagiaNPC.minFuego = 0;
					MagiaNPC.minNegra = 0;
					MagiaNPC.minTierra = 0;
					MagiaNPC.minViento = 0;
					DestrezasNPC.minAtl = 0;
					DestrezasNPC.minEq = 0;
					DestrezasNPC.minSig = 0;
					DestrezasNPC.minSup = 0;
					DestrezasNPC.minTra = 0;
					EquipoNPC.contexcusa = 0;
					EquipoNPC.weapon1 = new Weapons("", "", false, false, posss,"");
					EquipoNPC.weapon2 = new Weapons("", "", false, false, posss,"");
					EquipoNPC.weapon3 = new Weapons("", "", false, false, posss,"");
					EquipoNPC.weapon4 = new Weapons("", "", false, false, posss,"");
					EquipoNPC.armor1 = new Armor("", "", false,false, EquipoNPC.posss);
					EquipoNPC.accesories1 = new Accesories("", "", false,false,
							EquipoNPC.posss);
					EquipoNPC.accesories2 = new Accesories("", "", false,false,
							EquipoNPC.posss);
					EquipoNPC.accesories3 = new Accesories("", "", false,false,
							EquipoNPC.posss);
					EquipoNPC.accesories4 = new Accesories("", "", false,false,
							EquipoNPC.posss);
					EquipoNPC.misc1 = new Misc("", "", false,false, EquipoNPC.posss);
					EquipoNPC.misc2 = new Misc("", "", false,false, EquipoNPC.posss);
					EquipoNPC.misc3 = new Misc("", "", false,false, EquipoNPC.posss);
					EquipoNPC.misc4 = new Misc("", "", false,false, EquipoNPC.posss);
					EquipoNPC.pweap = 0;
					EquipoNPC.pmisc = 0;
					StartNPC.contadorBEktra = 0;
					StartNPC.contadorPosesion = 0;
					Blessing blessing = new Blessing("");
					Setbacks setbacks = new Setbacks();
					Race race = new Race("");
					Equipment equipment = new Equipment();
					ArrayList<String> posarm = new ArrayList<String>();
					Possesions posss = new Possesions(posarm);
					Armor armor = new Armor("", "", false,false, posss);
					StartNPC.character = new Characters(null, race, "", 0, 2,
							10, 20, 20, StartNPC.atributos,
							StartNPC.combatSkills, StartNPC.knowledgeSkills,
							StartNPC.magicSkills, StartNPC.knowhowSkills,
							blessing, null, setbacks, false, armor, equipment,null,null,null,null,null,null,null,null,null,null,null,null,
							0, 1,0,"","","");
					frmHistoriasDeZagas.dispose();
					Inicio window = new Inicio();
					window.getFrmHistoriasDeZagas().setVisible(true);
				}

			}
		});
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInicio.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-inicio-ayuda2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnInicio.setIcon(new ImageIcon(EquipoNPC.class
						.getResource("/images/botones-inicio-ayuda.png")));

			}
		});
		btnInicio.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnInicio.setOpaque(false);
		btnInicio.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(mf.MyFont(0, 15));
		btnInicio.setFocusPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

		null, null));
		btnInicio.setBackground(new Color(139, 69, 19));
		btnInicio.setBounds(104, 438, 111, 32);
		frmHistoriasDeZagas.getContentPane().add(btnInicio);

		lblEquipo = new JLabel("Equipo");
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setFont(mf.MyFont(1, 36));
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setBounds(0, 0, 575, 48);
		frmHistoriasDeZagas.getContentPane().add(lblEquipo);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EquipoNPC.class
				.getResource("/images/background-creadornpcs.jpg")));
		label.setBounds(0, 0, 584, 504);
		frmHistoriasDeZagas.getContentPane().add(label);

	}

	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}

	public static JTextField getTextField_12() {
		return txtArmadura;
	}

	public void setTextField_12(JTextField textField_12) {
		this.txtArmadura = textField_12;
	}

	public static JTextField getTextField_5() {
		return txtObj2;
	}

	public void setTextField_5(JTextField textField_5) {
		this.txtObj2 = textField_5;
	}

	public static JTextField getTextField_6() {
		return txtObj3;
	}

	public void setTextField_6(JTextField textField_6) {
		this.txtObj3 = textField_6;
	}

	public static JTextField getTextField_7() {
		return txtObj4;
	}

	public void setTextField_7(JTextField textField_7) {
		this.txtObj4 = textField_7;
	}

	public static JTextField getTextField_8() {
		return txtAcc1;
	}

	public void setTextField_8(JTextField textField_8) {
		this.txtAcc1 = textField_8;
	}

	public static JTextField getTextField_9() {
		return txtAcc2;
	}

	public void setTextField_9(JTextField textField_9) {
		this.txtAcc2 = textField_9;
	}

	public static JTextField getTextField_10() {
		return txtAcc3;
	}

	public void setTextField_10(JTextField textField_10) {
		this.txtAcc3 = textField_10;
	}

	public static JTextField getTextField_11() {
		return txtAcc4;
	}

	public void setTextField_11(JTextField textField_11) {
		this.txtAcc4 = textField_11;
	}

	public static JTextField getTextField() {
		return txtW1;
	}

	public void setTextField(JTextField textField) {
		this.txtW1 = textField;
	}

	public static JTextField getTextField_1() {
		return txtW2;
	}

	public void setTextField_1(JTextField textField_1) {
		this.txtW2 = textField_1;
	}

	public static JTextField getTextField_2() {
		return txtW3;
	}

	public void setTextField_2(JTextField textField_2) {
		this.txtW3 = textField_2;
	}

	public static JTextField getTextField_3() {
		return txtW4;
	}

	public void setTextField_3(JTextField textField_3) {
		this.txtW4 = textField_3;
	}

	public static JTextField getTextField_4() {
		return txtObj1;
	}

	public void setTextField_4(JTextField textField_4) {
		this.txtObj1 = textField_4;
	}

	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}
}
