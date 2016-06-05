package es.thesinsprods.zagastales.juegozagas.jugar.master;


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

import es.thesinsprods.resources.db.ConexionDBOnline;
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
import es.thesinsprods.zagastales.juegozagas.jugar.master.jugador1.Personaje1;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ModificarEquipo {

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
	public static Characters personaje;
	public static int pweap;
	public static int pmisc;
	public static int posPuestas;
	public static int legPuesto;
	public static int armasPuestas;
	public static int objetosPuestos;
	public static String tipopj="";
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
					ModificarEquipo window = new ModificarEquipo();
					window.frmHistoriasDeZagas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public ModificarEquipo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.getContentPane().setBackground(
				new Color(205, 133, 63));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ModificarEquipo.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setBounds(100, 100, 584, 532);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.getContentPane().setLayout(null);

		final ConexionDBOnline con = new ConexionDBOnline();
		final Connection p = con.accederDB();
		final Statement tabla=p.createStatement();
		
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
				btnAadirArmadura.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton a\u00F1adir armadura2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				btnAadirArmadura.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton a\u00F1adir armadura.png")));
			}
		});
		btnAadirArmadura.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirArmadura.setIcon(new ImageIcon(ModificarEquipo.class
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
					ArmaduraNPC window;
					try {
						window = new ArmaduraNPC();
						window.getFrame().setVisible(true);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
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
		if(!armor1.getArmor().equals("null")){
		txtArmadura.setText(armor1.getArmor());
		}
		txtArmadura.setFont(mf.MyFont(0, 11));
		txtArmadura.setEditable(false);
		txtArmadura.setBounds(40, 91, 205, 20);
		pnlArmadura.add(txtArmadura);
		txtArmadura.setColumns(10);

		final JButton btnInfoArm = new JButton("Info");
		btnInfoArm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoArm.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones armaduras2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoArm.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones armaduras.png")));

			}
		});
		btnInfoArm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoArm.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnQuitarArm.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones armaduras2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarArm.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones armaduras.png")));

			}
		});
		btnQuitarArm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarArm.setIcon(new ImageIcon(ModificarEquipo.class
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
									personaje);
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
									personaje);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (armor1.getArmor().equals("Armadura Ligera")
							&& personaje.getAtributes().getStrength() > 8) {
						try {
							armor1.getPossesion().CalculoPosesionInv(
									personaje);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					if (armor1.getArmor().equals("Armadura Ligera")
							&& personaje.getAtributes().getStrength() <= 8) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 1);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
							&& personaje.getAtributes().getStrength() > 12
							&& personaje.getPrivileges().Search(
									"Fornido") == false) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 1);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
							&& personaje.getAtributes().getStrength() > 12
							&& personaje.getPrivileges().Search(
									"Fornido") == true) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes()
									.setDexterity(dexN);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
							&& personaje.getAtributes().getStrength() <= 12
							&& personaje.getAtributes().getStrength() > 10) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 2);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
							&& personaje.getAtributes().getStrength() <= 10
							&& personaje.getAtributes().getStrength() > 8) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 3);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
							&& personaje.getAtributes().getStrength() <= 8
							&& personaje.getAtributes().getStrength() > 6) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 4);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
					
					txtArmadura.setText("");
					armor1 = new Armor("", "", false, false,posss);

				} 
				
				if (armor1.isLegendaria() == true) {
					if (armor1.getArmor().equals("Tela")) {
						try {
							armor1.getPossesion().CalculoPosesionInv(
									personaje);
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
									personaje);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (armor1.getArmor().equals("Armadura Ligera")
							&& personaje.getAtributes().getStrength() > 8) {
						try {
							armor1.getPossesion().CalculoPosesionInv(
									personaje);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					if (armor1.getArmor().equals("Armadura Ligera")
							&& personaje.getAtributes().getStrength() <= 8) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 1);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
							&& personaje.getAtributes().getStrength() > 12
							&& personaje.getPrivileges().Search(
									"Fornido") == false) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 1);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
							&& personaje.getAtributes().getStrength() > 12
							&& personaje.getPrivileges().Search(
									"Fornido") == true) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes()
									.setDexterity(dexN);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
							&& personaje.getAtributes().getStrength() <= 12
							&& personaje.getAtributes().getStrength() > 10) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 2);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
							&& personaje.getAtributes().getStrength() <= 10
							&& personaje.getAtributes().getStrength() > 8) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 3);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
							&& personaje.getAtributes().getStrength() <= 8
							&& personaje.getAtributes().getStrength() > 6) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 4);
							try {
								armor1.getPossesion().CalculoPosesionInv(
										personaje);
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
					
					}
					txtArmadura.setText("");
					armor1 = new Armor("", "", false, false,posss);

				} 
				
				else {
					if (armor1.getArmor().equals("Armadura Ligera")
							&& personaje.getAtributes().getStrength() > 8) {

					}
					if (armor1.getArmor().equals("Armadura Ligera")
							&& personaje.getAtributes().getStrength() <= 8) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
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
							&& personaje.getAtributes().getStrength() > 12
							&& personaje.getPrivileges().Search(
									"Fornido") == false) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
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
							&& personaje.getAtributes().getStrength() > 12
							&& personaje.getPrivileges().Search(
									"Fornido") == true) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes()
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
							&& personaje.getAtributes().getStrength() <= 12
							&& personaje.getAtributes().getStrength() > 10) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
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
							&& personaje.getAtributes().getStrength() <= 10
							&& personaje.getAtributes().getStrength() > 8) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
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
							&& personaje.getAtributes().getStrength() <= 8
							&& personaje.getAtributes().getStrength() > 6) {
						int dexN = personaje.getAtributes()
								.getDexterity();
						try {
							personaje.getAtributes().setDexterity(
									dexN + 4);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
						}

					}
					
					txtArmadura.setText("");
					armor1 = new Armor("", "", false,false, null);
					try {
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET ARMADURA='"+ModificarEquipo.armor1.getArmor()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_ARMADURA='"+ModificarEquipo.armor1.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_ARMADURA='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_ARMADURA='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_ARMADURA='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_ARMADURA='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						
						
						if(personaje.getName().equals(JugarOnline.personaje1.getName())){
							
							JugarOnline.personaje1.setArmor(personaje.getArmor());
							JugarOnline.writer.println("Server:"+JugarOnline.personaje1.getName()+":QuitarArm");
							JugarOnline.writer.flush();
							JugarOnline.writer.println("Server:Se ha quitado "+personaje.getArmor().getArmor()+" a "+personaje.getName()+":Chat");
							JugarOnline.writer.flush();}
						else if(personaje.getName().equals(JugarOnline.personaje2.getName())){
							
							JugarOnline.personaje2.setArmor(personaje.getArmor());
							JugarOnline.writer.println("Server:"+JugarOnline.personaje2.getName()+":QuitarArm");
							JugarOnline.writer.flush();
							JugarOnline.writer.println("Server:Se ha quitado "+personaje.getArmor().getArmor()+" a "+personaje.getName()+":Chat");
							JugarOnline.writer.flush();
							}

						else if(personaje.getName().equals(JugarOnline.personaje3.getName())){
							
							JugarOnline.personaje3.setArmor(personaje.getArmor());
							JugarOnline.writer.println("Server:"+JugarOnline.personaje3.getName()+":QuitarArm");
							JugarOnline.writer.flush();
							JugarOnline.writer.println("Server:Se ha quitado "+personaje.getArmor().getArmor()+" a "+personaje.getName()+":Chat");
							JugarOnline.writer.flush();
							}

						else if(personaje.getName().equals(JugarOnline.personaje4.getName())){
							
							
							JugarOnline.personaje4.setArmor(personaje.getArmor());
							JugarOnline.writer.println("Server:"+JugarOnline.personaje4.getName()+":QuitarArm");
							JugarOnline.writer.flush();
							JugarOnline.writer.println("Server:Se ha quitado "+personaje.getArmor().getArmor()+" a "+personaje.getName()+":Chat");
							JugarOnline.writer.flush();
						}

						else if(personaje.getName().equals(JugarOnline.personaje5.getName())){
							
							JugarOnline.personaje5.setArmor(personaje.getArmor());
							JugarOnline.writer.println("Server:"+JugarOnline.personaje5.getName()+":QuitarArm");
							JugarOnline.writer.flush();
							JugarOnline.writer.println("Server:Se ha quitado "+personaje.getArmor().getArmor()+" a "+personaje.getName()+":Chat");
							JugarOnline.writer.flush();
						}

						else if(personaje.getName().equals(JugarOnline.personaje6.getName())){
							
							JugarOnline.personaje6.setArmor(personaje.getArmor());
							JugarOnline.writer.println("Server:"+JugarOnline.personaje6.getName()+":QuitarArm");
							JugarOnline.writer.flush();
							JugarOnline.writer.println("Server:Se ha quitado "+personaje.getArmor().getArmor()+" a "+personaje.getName()+":Chat");
							JugarOnline.writer.flush();
							}

						else if(personaje.getName().equals(JugarOnline.personaje7.getName())){
							
							JugarOnline.personaje7.setArmor(personaje.getArmor());
							JugarOnline.writer.println("Server:"+JugarOnline.personaje7.getName()+":QuitarArm");
							JugarOnline.writer.flush();
							JugarOnline.writer.println("Server:Se ha quitado "+personaje.getArmor().getArmor()+" a "+personaje.getName()+":Chat");
							JugarOnline.writer.flush();
							}

						else if(personaje.getName().equals(JugarOnline.personaje8.getName())){
							
							JugarOnline.personaje8.setArmor(personaje.getArmor());
							JugarOnline.writer.println("Server:"+JugarOnline.personaje8.getName()+":QuitarArm");
							JugarOnline.writer.flush();
							JugarOnline.writer.println("Server:Se ha quitado "+personaje.getArmor().getArmor()+" a "+personaje.getName()+":Chat");
							JugarOnline.writer.flush();
							}

						else if(personaje.getName().equals(JugarOnline.personaje9.getName())){
							
							JugarOnline.personaje9.setArmor(personaje.getArmor());
							JugarOnline.writer.println("Server:"+JugarOnline.personaje9.getName()+":QuitarArm");
							JugarOnline.writer.flush();
							JugarOnline.writer.println("Server:Se ha quitado "+personaje.getArmor().getArmor()+" a "+personaje.getName()+":Chat");
							JugarOnline.writer.flush();
							}

						else if(personaje.getName().equals(JugarOnline.npc1.getName())){
							
							JugarOnline.npc1.setArmor(personaje.getArmor());
						}


						else if(personaje.getName().equals(JugarOnline.npc2.getName())){
							
							JugarOnline.npc2.setArmor(personaje.getArmor());
						}

						else if(personaje.getName().equals(JugarOnline.npc3.getName())){
							
							JugarOnline.npc3.setArmor(personaje.getArmor());
							
							}

						else if(personaje.getName().equals(JugarOnline.npc4.getName())){
							
							JugarOnline.npc4.setArmor(personaje.getArmor());
							
							}

						else if(personaje.getName().equals(JugarOnline.npc5.getName())){
							
							JugarOnline.npc5.setArmor(personaje.getArmor());
						}

						else if(personaje.getName().equals(JugarOnline.npc6.getName())){
							
							JugarOnline.npc6.setArmor(personaje.getArmor());
						}


						else if(personaje.getName().equals(JugarOnline.npc7.getName())){
							
							JugarOnline.npc7.setArmor(personaje.getArmor());
						}

						else if(personaje.getName().equals(JugarOnline.npc8.getName())){
							
							JugarOnline.npc8.setArmor(personaje.getArmor());
							}

						else if(personaje.getName().equals(JugarOnline.npc9.getName())){
							
							JugarOnline.npc9.setArmor(personaje.getArmor());
							}
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
						ModificarEquipo.class
								.getResource("/images/botones a\u00F1adir armasyobj2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnAadirArmas.setIcon(new ImageIcon(
						ModificarEquipo.class
								.getResource("/images/botones a\u00F1adir armasyobj.png")));

			}
		});
		btnAadirArmas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirArmas.setIcon(new ImageIcon(ModificarEquipo.class
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
		if(!weapon1.getWeapon().equals("null")){
		txtW1.setText(weapon1.getWeapon());}
		txtW1.setEditable(false);
		txtW1.setFont(mf.MyFont(0, 11));
		txtW1.setBounds(10, 49, 123, 20);
		pnlArmas.add(txtW1);
		txtW1.setColumns(10);

		txtW2 = new JTextField();
		txtW2.setForeground(new Color(0, 0, 0));
		txtW2.setBackground(Color.WHITE);
		if(!weapon2.getWeapon().equals("null")){
		txtW2.setText(weapon2.getWeapon());}
		txtW2.setFont(mf.MyFont(0, 11));
		txtW2.setEditable(false);
		txtW2.setColumns(10);
		txtW2.setBounds(10, 80, 123, 20);
		pnlArmas.add(txtW2);

		txtW3 = new JTextField();
		txtW3.setForeground(new Color(0, 0, 0));
		txtW3.setBackground(Color.WHITE);
		if(!weapon3.getWeapon().equals("null")){;
		txtW3.setText(weapon3.getWeapon());}
		txtW3.setFont(mf.MyFont(0, 11));
		txtW3.setEditable(false);
		txtW3.setColumns(10);
		txtW3.setBounds(10, 111, 123, 20);
		pnlArmas.add(txtW3);

		txtW4 = new JTextField();
		txtW4.setForeground(new Color(0, 0, 0));
		txtW4.setBackground(Color.WHITE);
		if(!weapon4.getWeapon().equals("null")){
		txtW4.setText(weapon4.getWeapon());}
		txtW4.setFont(mf.MyFont(0, 11));
		txtW4.setEditable(false);
		txtW4.setColumns(10);
		txtW4.setBounds(10, 142, 123, 20);
		pnlArmas.add(txtW4);

		btnInfoW1 = new JButton("Info");
		btnInfoW1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInfoW1.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoW1.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoW1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoW1.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnInfo_W2.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfo_W2.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfo_W2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfo_W2.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnInfoW3.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoW3.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoW3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoW3.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnInfoW4.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoW4.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoW4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoW4.setIcon(new ImageIcon(ModificarEquipo.class
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
		btnQuitarW1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtW1.setText("");
				weapon1 = new Weapons("", "", false, false, posss,"");
				try {
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET ARMA1='"+ModificarEquipo.weapon1.getWeapon()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_ARMA1='"+ModificarEquipo.weapon1.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_ARMA1='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_ARMA1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_ARMA1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_ARMA1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET TIPOARMA1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET SUBCLASE_ARMA1='"+ModificarEquipo.weapon1.getTipo()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					
					
					if(personaje.getName().equals(JugarOnline.personaje1.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje1.getName()+ ":QuitarWeap1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon1().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje1.setWeapon1(weapon1);
						}
					else if(personaje.getName().equals(JugarOnline.personaje2.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje2.getName()+ ":QuitarWeap1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon1().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje2.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje3.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje3.getName()+ ":QuitarWeap1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon1().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje3.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje4.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje4.getName()+ ":QuitarWeap1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon1().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje4.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje5.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje5.getName()+ ":QuitarWeap1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon1().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje5.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje6.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje6.getName()+ ":QuitarWeap1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon1().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje6.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje7.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje7.getName()+ ":QuitarWeap1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon1().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje7.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje8.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje8.getName()+ ":QuitarWeap1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon1().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje8.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje9.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje9.getName()+ ":QuitarWeap1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon1().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje9.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.npc1.getName())){
						
						JugarOnline.npc1.setWeapon1(weapon1);
						}


					else if(personaje.getName().equals(JugarOnline.npc2.getName())){
						
						JugarOnline.npc2.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.npc3.getName())){
						
						JugarOnline.npc3.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.npc4.getName())){
						
						JugarOnline.npc4.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.npc5.getName())){
						
						JugarOnline.npc5.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.npc6.getName())){
						
						JugarOnline.npc6.setWeapon1(weapon1);
						}


					else if(personaje.getName().equals(JugarOnline.npc7.getName())){
						
						JugarOnline.npc7.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.npc8.getName())){
						
						JugarOnline.npc8.setWeapon1(weapon1);
						}

					else if(personaje.getName().equals(JugarOnline.npc9.getName())){
						
						JugarOnline.npc9.setWeapon1(weapon1);
						}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				armasPuestas--;
			}
		});
		btnQuitarW1.setBounds(221, 46, 53, 23);
		pnlArmas.add(btnQuitarW1);

		final JButton btnQuitarW2 = new JButton("-");
		btnQuitarW2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarW2.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarW2.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarW2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarW2.setIcon(new ImageIcon(ModificarEquipo.class
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
				
				txtW2.setText("");
				weapon2 = new Weapons("", "", false, false, posss,"");
				try {
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET ARMA2='"+ModificarEquipo.weapon2.getWeapon()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_ARMA2='"+ModificarEquipo.weapon2.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_ARMA2='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_ARMA2='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_ARMA2='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_ARMA2='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET TIPOARMA2='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET SUBCLASE_ARMA2='"+ModificarEquipo.weapon1.getTipo()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
				
					if(personaje.getName().equals(JugarOnline.personaje1.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje1.getName()+ ":QuitarWeap2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon2().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje1.setWeapon2(weapon2);
						}
					else if(personaje.getName().equals(JugarOnline.personaje2.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje2.getName()+ ":QuitarWeap2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon2().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje2.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje3.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje3.getName()+ ":QuitarWeap2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon2().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje3.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje4.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje4.getName()+ ":QuitarWeap2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon2().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje4.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje5.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje5.getName()+ ":QuitarWeap2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon2().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje5.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje6.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje6.getName()+ ":QuitarWeap2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon2().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje6.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje7.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje7.getName()+ ":QuitarWeap2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon2().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje7.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje8.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje8.getName()+ ":QuitarWeap2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon2().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje8.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje9.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje9.getName()+ ":QuitarWeap2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon2().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje9.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.npc1.getName())){
						
						JugarOnline.npc1.setWeapon2(weapon2);
						}


					else if(personaje.getName().equals(JugarOnline.npc2.getName())){
						
						JugarOnline.npc2.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.npc3.getName())){
						
						JugarOnline.npc3.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.npc4.getName())){
						
						JugarOnline.npc4.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.npc5.getName())){
						
						JugarOnline.npc5.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.npc6.getName())){
						
						JugarOnline.npc6.setWeapon2(weapon2);
						}


					else if(personaje.getName().equals(JugarOnline.npc7.getName())){
						
						JugarOnline.npc7.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.npc8.getName())){
						
						JugarOnline.npc8.setWeapon2(weapon2);
						}

					else if(personaje.getName().equals(JugarOnline.npc9.getName())){
						
						JugarOnline.npc9.setWeapon2(weapon2);
						}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				armasPuestas--;
			}
		});
		btnQuitarW2.setBounds(221, 77, 53, 23);
		pnlArmas.add(btnQuitarW2);

		final JButton btnQuitarW3 = new JButton("-");
		btnQuitarW3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarW3.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarW3.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarW3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarW3.setIcon(new ImageIcon(ModificarEquipo.class
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
				
				txtW3.setText("");
				weapon3 = new Weapons("", "", false, false, posss,"");
				try {
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET ARMA3='"+ModificarEquipo.weapon3.getWeapon()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_ARMA3='"+ModificarEquipo.weapon3.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_ARMA3='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_ARMA3='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_ARMA3='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_ARMA3='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET TIPOARMA3='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET SUBCLASE_ARMA3='"+ModificarEquipo.weapon1.getTipo()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					
					if(personaje.getName().equals(JugarOnline.personaje1.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje1.getName()+ ":QuitarWeap3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon3().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje1.setWeapon3(weapon3);
						}
					else if(personaje.getName().equals(JugarOnline.personaje2.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje2.getName()+ ":QuitarWeap3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon3().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje2.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje3.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje3.getName()+ ":QuitarWeap3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon3().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje3.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje4.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje4.getName()+ ":QuitarWeap3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon3().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje4.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje5.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje5.getName()+ ":QuitarWeap3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon3().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje5.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje6.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje6.getName()+ ":QuitarWeap3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon3().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje6.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje7.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje7.getName()+ ":QuitarWeap3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon3().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje7.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje8.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje8.getName()+ ":QuitarWeap3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon3().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje8.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje9.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje9.getName()+ ":QuitarWeap3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon3().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje9.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.npc1.getName())){
						
						JugarOnline.npc1.setWeapon3(weapon3);
						}


					else if(personaje.getName().equals(JugarOnline.npc2.getName())){
						
						JugarOnline.npc2.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.npc3.getName())){
						
						JugarOnline.npc3.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.npc4.getName())){
						
						JugarOnline.npc4.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.npc5.getName())){
						
						JugarOnline.npc5.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.npc6.getName())){
						
						JugarOnline.npc6.setWeapon3(weapon3);
						}


					else if(personaje.getName().equals(JugarOnline.npc7.getName())){
						
						JugarOnline.npc7.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.npc8.getName())){
						
						JugarOnline.npc8.setWeapon3(weapon3);
						}

					else if(personaje.getName().equals(JugarOnline.npc9.getName())){
						
						JugarOnline.npc9.setWeapon3(weapon3);
						}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				armasPuestas--;
			}
		});
		btnQuitarW3.setBounds(221, 108, 53, 23);
		pnlArmas.add(btnQuitarW3);

		final JButton btnQuitarW4 = new JButton("-");
		btnQuitarW4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarW4.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarW4.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarW4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarW4.setIcon(new ImageIcon(ModificarEquipo.class
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
				
				txtW4.setText("");
				weapon4 = new Weapons("", "", false, false, posss,"");
				try {
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET ARMA4='"+ModificarEquipo.weapon4.getWeapon()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_ARMA4='"+ModificarEquipo.weapon4.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_ARMA4='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_ARMA4='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_ARMA4='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_ARMA4='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET TIPOARMA1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET SUBCLASE_ARMA4='"+ModificarEquipo.weapon1.getTipo()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					
					if(personaje.getName().equals(JugarOnline.personaje1.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje1.getName()+ ":QuitarWeap4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon4().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje1.setWeapon4(weapon4);
						}
					else if(personaje.getName().equals(JugarOnline.personaje2.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje2.getName()+ ":QuitarWeap4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon4().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje2.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje3.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje3.getName()+ ":QuitarWeap4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon4().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje3.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje4.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje4.getName()+ ":QuitarWeap4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon4().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje4.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje5.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje5.getName()+ ":QuitarWeap4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon4().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje5.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje6.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje6.getName()+ ":QuitarWeap4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon4().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje6.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje7.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje7.getName()+ ":QuitarWeap4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon4().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje7.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje8.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje8.getName()+ ":QuitarWeap4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon4().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje8.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje9.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje9.getName()+ ":QuitarWeap4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getWeapon4().getWeapon()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje9.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.npc1.getName())){
						
						JugarOnline.npc1.setWeapon4(weapon4);
						}


					else if(personaje.getName().equals(JugarOnline.npc2.getName())){
						
						JugarOnline.npc2.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.npc3.getName())){
						
						JugarOnline.npc3.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.npc4.getName())){
						
						JugarOnline.npc4.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.npc5.getName())){
						
						JugarOnline.npc5.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.npc6.getName())){
						
						JugarOnline.npc6.setWeapon4(weapon4);
						}


					else if(personaje.getName().equals(JugarOnline.npc7.getName())){
						
						JugarOnline.npc7.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.npc8.getName())){
						
						JugarOnline.npc8.setWeapon4(weapon4);
						}

					else if(personaje.getName().equals(JugarOnline.npc9.getName())){
						
						JugarOnline.npc9.setWeapon4(weapon4);
						} 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
					ArmasNPC window;
					try {
						window = new ArmasNPC();
						window.getFrame().setVisible(true);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				} else {
					if (txtW2.getText().equals("") && pweap >= 2) {
						ArmasNPC window;
						try {
							window = new ArmasNPC();
							window.getFrame().setVisible(true);
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
								| SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} else {
						if (txtW3.getText().equals("") && pweap >= 3) {
							ArmasNPC window;
							try {
								window = new ArmasNPC();
								window.getFrame().setVisible(true);
							} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
									| IOException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						} else {
							if (txtW4.getText().equals("") && pweap >= 4) {
								ArmasNPC window;
								try {
									window = new ArmasNPC();
									window.getFrame().setVisible(true);
								} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
										| IOException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								

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
		if(!misc1.getMisc().equals("null")){
		txtObj1.setText(misc1.getMisc());}
		txtObj1.setFont(mf.MyFont(0, 11));
		txtObj1.setColumns(10);
		txtObj1.setBounds(10, 49, 123, 20);
		pnlObjetos.add(txtObj1);

		txtObj2 = new JTextField();
		txtObj2.setForeground(new Color(0, 0, 0));
		txtObj2.setBackground(Color.WHITE);
		txtObj2.setEditable(false);
		if(!misc2.getMisc().equals("null")){
		txtObj2.setText(misc2.getMisc());}
		txtObj2.setFont(mf.MyFont(0, 11));
		txtObj2.setColumns(10);
		txtObj2.setBounds(10, 80, 123, 20);
		pnlObjetos.add(txtObj2);

		txtObj3 = new JTextField();
		txtObj3.setForeground(new Color(0, 0, 0));
		txtObj3.setBackground(Color.WHITE);
		if(!misc3.getMisc().equals("null")){
		txtObj3.setText(misc3.getMisc());}
		txtObj3.setEditable(false);
		txtObj3.setFont(mf.MyFont(0, 11));
		txtObj3.setColumns(10);
		txtObj3.setBounds(10, 111, 123, 20);
		pnlObjetos.add(txtObj3);

		txtObj4 = new JTextField();
		txtObj4.setForeground(new Color(0, 0, 0));
		txtObj4.setBackground(Color.WHITE);
		txtObj4.setEditable(false);
		if(!misc4.getMisc().equals("null")){
		txtObj4.setText(misc4.getMisc());}
		txtObj4.setFont(mf.MyFont(0, 11));
		txtObj4.setColumns(10);
		txtObj4.setBounds(10, 142, 123, 20);
		pnlObjetos.add(txtObj4);

		final JButton btnAadirObjetos = new JButton("A\u00F1adir Objetos");
		btnAadirObjetos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadirObjetos.setIcon(new ImageIcon(
						ModificarEquipo.class
								.getResource("/images/botones a\u00F1adir armasyobj2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnAadirObjetos.setIcon(new ImageIcon(
						ModificarEquipo.class
								.getResource("/images/botones a\u00F1adir armasyobj.png")));

			}
		});
		btnAadirObjetos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirObjetos.setIcon(new ImageIcon(ModificarEquipo.class
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
				if (ModificarEquipo.getTextField_4().getText().equals("")
						&& ModificarEquipo.pmisc >= 1) {
					ObjetosNPC window;
					try {
						window = new ObjetosNPC();
						window.getFrame().setVisible(true);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				} else {
					if (ModificarEquipo.getTextField_5().getText().equals("")
							&& ModificarEquipo.pmisc >= 2) {
						ObjetosNPC window;
						try {
							window = new ObjetosNPC();
							window.getFrame().setVisible(true);
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException
								| IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					} else {
						if (ModificarEquipo.getTextField_6().getText().equals("")
								&& ModificarEquipo.pmisc >= 3) {
							ObjetosNPC window;
							try {
								window = new ObjetosNPC();
								window.getFrame().setVisible(true);
							} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
									| SQLException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else {
							if (ModificarEquipo.getTextField_7().getText().equals("")
									&& ModificarEquipo.pmisc >= 4) {
								ObjetosNPC window;
								try {
									window = new ObjetosNPC();
									window.getFrame().setVisible(true);
								} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
										| SQLException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							
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
				btnInfoObj1.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoObj1.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoObj1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoObj1.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnInfoObj2.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoObj2.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoObj2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoObj2.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnInfoObj3.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoObj3.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoObj3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoObj3.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnInfoObj4.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoObj4.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoObj4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoObj4.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnQuitarObj1.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarObj1.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarObj1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarObj1.setIcon(new ImageIcon(ModificarEquipo.class
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
				
				txtObj1.setText("");
				misc1 = new Misc("", "", false,false, posss);
				try {
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET OBJETO1='"+ModificarEquipo.misc1.getMisc()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_OBJETO1='"+ModificarEquipo.misc1.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_OBJETO1='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_OBJETO1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_OBJETO1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_OBJETO1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
				
					if(personaje.getName().equals(JugarOnline.personaje1.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje1.getName()+ ":QuitarObj1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc1().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje1.setMisc1(misc1);
						}
					else if(personaje.getName().equals(JugarOnline.personaje2.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje2.getName()+ ":QuitarObj1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc1().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje2.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje3.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje3.getName()+ ":QuitarObj1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc1().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje3.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje4.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje4.getName()+ ":QuitarObj1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc1().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje4.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje5.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje5.getName()+ ":QuitarObj1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc1().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje5.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje6.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje6.getName()+ ":QuitarObj1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc1().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje6.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje7.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje7.getName()+ ":QuitarObj1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc1().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje7.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje8.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje8.getName()+ ":QuitarObj1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc1().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje8.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.personaje9.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje9.getName()+ ":QuitarObj1");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc1().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje9.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.npc1.getName())){
						
						JugarOnline.npc1.setMisc1(misc1);
						}


					else if(personaje.getName().equals(JugarOnline.npc2.getName())){
						
						JugarOnline.npc2.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.npc3.getName())){
						
						JugarOnline.npc3.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.npc4.getName())){
						
						JugarOnline.npc4.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.npc5.getName())){
						
						JugarOnline.npc5.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.npc6.getName())){
						
						JugarOnline.npc6.setMisc1(misc1);
						}


					else if(personaje.getName().equals(JugarOnline.npc7.getName())){
						
						JugarOnline.npc7.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.npc8.getName())){
						
						JugarOnline.npc8.setMisc1(misc1);
						}

					else if(personaje.getName().equals(JugarOnline.npc9.getName())){
						
						JugarOnline.npc9.setMisc1(misc1);
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				objetosPuestos--;
			}
		});
		btnQuitarObj1.setBounds(222, 46, 53, 23);
		pnlObjetos.add(btnQuitarObj1);

		final JButton btnQuitarObj2 = new JButton("-");
		btnQuitarObj2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarObj2.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarObj2.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarObj2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarObj2.setIcon(new ImageIcon(ModificarEquipo.class
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
				
				txtObj2.setText("");
				misc2 = new Misc("", "", false,false, posss);
				try {
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET OBJETO2='"+ModificarEquipo.misc2.getMisc()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_OBJETO2='"+ModificarEquipo.misc2.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_OBJETO2='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_OBJETO2='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_OBJETO2='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_OBJETO2='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
				
					if(personaje.getName().equals(JugarOnline.personaje1.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje1.getName()+ ":QuitarObj2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc2().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje1.setMisc2(misc2);
						}
					else if(personaje.getName().equals(JugarOnline.personaje2.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje2.getName()+ ":QuitarObj2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc2().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje2.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje3.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje3.getName()+ ":QuitarObj2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc2().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje3.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje4.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje4.getName()+ ":QuitarObj2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc2().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje4.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje5.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje5.getName()+ ":QuitarObj2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc2().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje5.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje6.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje6.getName()+ ":QuitarObj2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc2().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje6.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje7.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje7.getName()+ ":QuitarObj2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc2().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje7.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje8.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje8.getName()+ ":QuitarObj2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc2().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje8.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.personaje9.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje9.getName()+ ":QuitarObj2");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc2().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje9.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.npc1.getName())){
						
						JugarOnline.npc1.setMisc2(misc2);
						}


					else if(personaje.getName().equals(JugarOnline.npc2.getName())){
						
						JugarOnline.npc2.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.npc3.getName())){
						
						JugarOnline.npc3.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.npc4.getName())){
						
						JugarOnline.npc4.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.npc5.getName())){
						
						JugarOnline.npc5.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.npc6.getName())){
						
						JugarOnline.npc6.setMisc2(misc2);
						}


					else if(personaje.getName().equals(JugarOnline.npc7.getName())){
						
						JugarOnline.npc7.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.npc8.getName())){
						
						JugarOnline.npc8.setMisc2(misc2);
						}

					else if(personaje.getName().equals(JugarOnline.npc9.getName())){
						
						JugarOnline.npc9.setMisc2(misc2);
						}
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				objetosPuestos--;
			}
		});
		btnQuitarObj2.setBounds(222, 77, 53, 23);
		pnlObjetos.add(btnQuitarObj2);

		final JButton btnQuitarObj3 = new JButton("-");
		btnQuitarObj3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarObj3.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarObj3.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarObj3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarObj3.setIcon(new ImageIcon(ModificarEquipo.class
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
				
				txtObj3.setText("");
				misc3 = new Misc("", "", false,false, posss);
				try {
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET OBJETO3='"+ModificarEquipo.misc3.getMisc()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_OBJETO3='"+ModificarEquipo.misc3.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_OBJETO3='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_OBJETO3='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_OBJETO3='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_OBJETO3='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
				
					if(personaje.getName().equals(JugarOnline.personaje1.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje1.getName()+ ":QuitarObj3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc3().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje1.setMisc3(misc3);
						}
					else if(personaje.getName().equals(JugarOnline.personaje2.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje2.getName()+ ":QuitarObj3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc3().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje2.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje3.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje3.getName()+ ":QuitarObj3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc3().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje3.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje4.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje4.getName()+ ":QuitarObj3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc3().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje4.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje5.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje5.getName()+ ":QuitarObj3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc3().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje5.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje6.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje6.getName()+ ":QuitarObj3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc3().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje6.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje7.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje7.getName()+ ":QuitarObj3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc3().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje7.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje8.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje8.getName()+ ":QuitarObj3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc3().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje8.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.personaje9.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje9.getName()+ ":QuitarObj3");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc3().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje9.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.npc1.getName())){
						
						JugarOnline.npc1.setMisc3(misc3);
						}


					else if(personaje.getName().equals(JugarOnline.npc2.getName())){
						
						JugarOnline.npc2.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.npc3.getName())){
						
						JugarOnline.npc3.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.npc4.getName())){
						
						JugarOnline.npc4.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.npc5.getName())){
						
						JugarOnline.npc5.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.npc6.getName())){
						
						JugarOnline.npc6.setMisc3(misc3);
						}


					else if(personaje.getName().equals(JugarOnline.npc7.getName())){
						
						JugarOnline.npc7.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.npc8.getName())){
						
						JugarOnline.npc8.setMisc3(misc3);
						}

					else if(personaje.getName().equals(JugarOnline.npc9.getName())){
						
						JugarOnline.npc9.setMisc3(misc3);
						}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				objetosPuestos--;
			}
		});
		btnQuitarObj3.setBounds(222, 108, 53, 23);
		pnlObjetos.add(btnQuitarObj3);

		final JButton btnQuitarObj4 = new JButton("-");
		btnQuitarObj4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarObj4.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnQuitarObj4.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/botones-.png")));

			}
		});
		btnQuitarObj4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarObj4.setIcon(new ImageIcon(ModificarEquipo.class
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
				
				txtObj4.setText("");
				misc4 = new Misc("", "", false,false, posss);
				try {
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET OBJETO4='"+ModificarEquipo.misc4.getMisc()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_OBJETO4='"+ModificarEquipo.misc4.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_OBJETO4='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_OBJETO4='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_OBJETO4='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_OBJETO4='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
				
					if(personaje.getName().equals(JugarOnline.personaje1.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje1.getName()+ ":QuitarObj4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc4().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje1.setMisc4(misc4);
						}
					else if(personaje.getName().equals(JugarOnline.personaje2.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje2.getName()+ ":QuitarObj4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc4().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje2.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje3.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje3.getName()+ ":QuitarObj4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc4().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje3.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje4.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje4.getName()+ ":QuitarObj4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc4().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje4.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje5.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje5.getName()+ ":QuitarObj4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc4().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje5.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje6.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje6.getName()+ ":QuitarObj4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc4().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje6.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje7.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje7.getName()+ ":QuitarObj4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc4().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje7.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje8.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje8.getName()+ ":QuitarObj4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc4().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje8.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.personaje9.getName())){
						
						
						JugarOnline.writer.println("Server:"+ JugarOnline.personaje9.getName()+ ":QuitarObj4");
						JugarOnline.writer.flush();
						JugarOnline.writer.println("Server:Se ha quitado "+personaje.getMisc4().getMisc()+" a "+personaje.getName()+":Chat");
						JugarOnline.writer.flush();
						JugarOnline.personaje9.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.npc1.getName())){
						
						JugarOnline.npc1.setMisc4(misc4);
						}


					else if(personaje.getName().equals(JugarOnline.npc2.getName())){
						
						JugarOnline.npc2.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.npc3.getName())){
						
						JugarOnline.npc3.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.npc4.getName())){
						
						JugarOnline.npc4.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.npc5.getName())){
						
						JugarOnline.npc5.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.npc6.getName())){
						
						JugarOnline.npc6.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.npc7.getName())){
						
						JugarOnline.npc7.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.npc8.getName())){
						
						JugarOnline.npc8.setMisc4(misc4);
						}

					else if(personaje.getName().equals(JugarOnline.npc9.getName())){
						
						JugarOnline.npc9.setMisc4(misc4);
						}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				objetosPuestos--;
			
		}});
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
		if(!accesories1.getAccesory().equals("null")){
		txtAcc1.setText(accesories1.getAccesory());}
		txtAcc1.setFont(mf.MyFont(0, 11));
		txtAcc1.setEditable(false);
		txtAcc1.setColumns(10);
		txtAcc1.setBounds(10, 49, 123, 20);
		pnlAccesorios.add(txtAcc1);

		txtAcc2 = new JTextField();
		txtAcc2.setForeground(new Color(0, 0, 0));
		txtAcc2.setBackground(Color.WHITE);
		if(!accesories2.getAccesory().equals("null")){
		txtAcc2.setText(accesories2.getAccesory());}
		txtAcc2.setFont(mf.MyFont(0, 11));
		txtAcc2.setEditable(false);
		txtAcc2.setColumns(10);
		txtAcc2.setBounds(10, 80, 123, 20);
		pnlAccesorios.add(txtAcc2);

		txtAcc3 = new JTextField();
		txtAcc3.setForeground(new Color(0, 0, 0));
		txtAcc3.setBackground(Color.WHITE);
		if(!accesories3.getAccesory().equals("null")){
		txtAcc3.setText(accesories3.getAccesory());
		}
		txtAcc3.setFont(mf.MyFont(0, 11));
		txtAcc3.setEditable(false);
		txtAcc3.setColumns(10);
		txtAcc3.setBounds(10, 111, 123, 20);
		pnlAccesorios.add(txtAcc3);

		txtAcc4 = new JTextField();
		txtAcc4.setForeground(new Color(0, 0, 0));
		txtAcc4.setBackground(Color.WHITE);
		if(!accesories1.getAccesory().equals("null")){
		txtAcc4.setText(accesories4.getAccesory());}
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
				btnInfoAcc1.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoAcc1.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoAcc1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoAcc1.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnInfoAcc2.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoAcc2.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoAcc2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoAcc2.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnInfoAcc3.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoAcc3.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));
			}
		});
		btnInfoAcc3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoAcc3.setIcon(new ImageIcon(ModificarEquipo.class
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
				btnInfoAcc4.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnInfoAcc4.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton info.png")));

			}
		});
		btnInfoAcc4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoAcc4.setIcon(new ImageIcon(ModificarEquipo.class
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

		btnAtras = new JButton("");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton atras2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(ModificarEquipo.class
						.getResource("/images/boton atras.png")));

			}
		});
		btnAtras.setIcon(new ImageIcon(ModificarEquipo.class
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
				
				if(personaje.getName().equals(JugarOnline.personaje1.getName())){
					
					JugarOnline.personaje1.setArmor(personaje.getArmor());
					JugarOnline.personaje1.setWeapon1(personaje.getWeapon1());
					JugarOnline.personaje1.setWeapon2(personaje.getWeapon2());
					JugarOnline.personaje1.setWeapon3(personaje.getWeapon3());
					JugarOnline.personaje1.setWeapon4(personaje.getWeapon4());
					JugarOnline.personaje1.setMisc1(personaje.getMisc1());
					JugarOnline.personaje1.setMisc2(personaje.getMisc2());
					JugarOnline.personaje1.setMisc3(personaje.getMisc3());
					JugarOnline.personaje1.setMisc4(personaje.getMisc4());
					
					
				}
				
				frmHistoriasDeZagas.dispose();
	
			}
		});
		btnAtras.setFont(mf.MyFont(0, 13));
		btnAtras.setBounds(0, 438, 99, 41);
		frmHistoriasDeZagas.getContentPane().add(btnAtras);

		lblEquipo = new JLabel("Equipo");
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setFont(mf.MyFont(1, 36));
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setBounds(0, 0, 575, 48);
		frmHistoriasDeZagas.getContentPane().add(lblEquipo);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ModificarEquipo.class
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
