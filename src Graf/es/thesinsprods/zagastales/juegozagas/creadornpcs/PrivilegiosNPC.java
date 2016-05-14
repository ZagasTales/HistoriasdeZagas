package es.thesinsprods.zagastales.juegozagas.creadornpcs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Cursor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.atributes.AtributePoints;
import es.thesinsprods.zagastales.characters.atributes.Atributes;
import es.thesinsprods.zagastales.characters.blessings.Blessing;
import es.thesinsprods.zagastales.characters.equipment.Accesories;
import es.thesinsprods.zagastales.characters.equipment.Armor;
import es.thesinsprods.zagastales.characters.equipment.Equipment;
import es.thesinsprods.zagastales.characters.equipment.Misc;
import es.thesinsprods.zagastales.characters.equipment.Possesions;
import es.thesinsprods.zagastales.characters.equipment.Weapons;
import es.thesinsprods.zagastales.characters.privileges.PrivilegeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.privileges.Privileges;
import es.thesinsprods.zagastales.characters.privileges.Setbacks;
import es.thesinsprods.zagastales.characters.race.Race;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.KnowHowSkills;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.SkillPoints;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaPrivilegios;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class PrivilegiosNPC {

	private JFrame frmHistoriasDeZagas;
	public static int priv1 = 0;
	public static int priv2 = 0;
	public static int priv3 = 0;
	public static int priv4 = 0;
	public static int priv5 = 0;
	public static int rev1 = 0;
	public static int rev2 = 0;
	public static int rev3 = 0;
	public static int rev4 = 0;
	public static int posesiones = 0;
	public static int legendario = 0;
	MorpheusFont mf = new MorpheusFont();
	private JTextField txtpriv1;
	private JTextField txtpriv2;
	private JTextField txtpriv3;
	private JTextField txtpriv4;
	private JTextField txtpriv5;
	private JTextField txtrev1;
	private JTextField txtrev2;
	private JTextField txtrev3;
	private JTextField txtrev4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrivilegiosNPC window = new PrivilegiosNPC();
					window.frmHistoriasDeZagas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	/**
	 * Create the application.
	 */
	public PrivilegiosNPC() {
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
				ArmasNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setBounds(100, 100, 584, 532);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		final JButton btnContinuar = new JButton("");
		final ArrayList<String> priv = new ArrayList<String>();
		priv.add("");
		priv.add("");
		priv.add("");
		priv.add("");
		priv.add("");
		final ArrayList<String> res = new ArrayList<String>();
		res.add("");
		res.add("");
		res.add("");
		res.add("");
		final JComboBox privilegio1 = new JComboBox();
		final JComboBox privilegio2 = new JComboBox();
		final JComboBox privilegio3 = new JComboBox();
		final JComboBox privilegio4 = new JComboBox();
		final JComboBox privilegio5 = new JComboBox();
		final JComboBox reves1 = new JComboBox();
		final JComboBox reves2 = new JComboBox();
		final JComboBox reves3 = new JComboBox();
		final JComboBox reves4 = new JComboBox();

		privilegio1.setForeground(new Color(0, 0, 0));
		privilegio1.setBackground(Color.WHITE);
		privilegio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio1.getSelectedIndex() == 0 && priv.size() > 0) {
					priv.set(0, "");
					txtpriv1.setText("");

				}
				if (privilegio1.getSelectedIndex() == 1) {
					if (StartNPC.character.getRace().getRace() != ("Alto Elfo")) {

						priv.set(0, "Afinidad Arcana");

						String descrp = "-2 para cada nivel de magia.";
						txtpriv1.setText(descrp);

					} else {
						JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"Eres un alto elfo, la afinindad arcana es innata en ti",
										"", JOptionPane.ERROR_MESSAGE);
						privilegio1.setSelectedIndex(0);

					}
				}
				if (privilegio1.getSelectedIndex() == 2) {

					priv.set(0, "Torrente Arcano");

					String descrp = "+5 maná.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 3) {

					priv.set(0, "Duro");

					String descrp = "+3 vida";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 4) {

					priv.set(0, "Incansable");

					String descrp = "+ 5 energía";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 5) {

					priv.set(0, "Fornido");

					String descrp = "Elimina penalización de armaduras pesadas.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 6) {

					priv.set(0, "Mente Ágil");

					String descrp = "El coste para subir conocimientos se iguala al de combate.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 7) {

					priv.set(0, "Posesión");

					String descrp = "Permite llevar un objeto especial.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 8) {

					priv.set(0, "Experto");

					String descrp = "Permite subir a nivel 4 las habilidades.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 9) {

					priv.set(0, "Maestro");

					String descrp = "Permite subir a nivel 5 las habilidades.";
					txtpriv1.setText(descrp);
				}

				if (privilegio1.getSelectedIndex() == 10) {

					priv.set(0, "Noble");

					String descrp = "El personaje es de alta alcurnia y como tal obtiene ciertos beneficios.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 11) {

					priv.set(0, "Curación Rápida");

					String descrp = "Curación de heridas x2 al descansar.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 12) {

					priv.set(0, "Talento");

					String descrp = "+1 rango en combate contra oponentes con el mismo rango.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 13) {

					priv.set(0, "Aliado");

					String descrp = "Lleva un aliado contigo.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 14) {

					priv.set(0, "Buena Estrella");

					String descrp = "Los dioses han favorecido al personaje.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 15) {
					if (StartNPC.character.getCombatSkills().getOneHanded() == 5
							|| StartNPC.character.getCombatSkills()
									.getTwoHanded() == 5
							|| StartNPC.character.getCombatSkills().getPole() == 5
							|| StartNPC.character.getCombatSkills().getRanged() == 5
							|| StartNPC.character.getCombatSkills().getDodge() == 5
							|| StartNPC.character.getCombatSkills().getBlock() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getCombatSkills().getOneHanded() == 5) {
							maestro.add("Armas de Una Mano");
						}
						if (StartNPC.character.getCombatSkills().getTwoHanded() == 5) {
							maestro.add("Armas de Dos Manos");
						}
						if (StartNPC.character.getCombatSkills().getPole() == 5) {
							maestro.add("Armas de Asta");
						}
						if (StartNPC.character.getCombatSkills().getRanged() == 5) {
							maestro.add("Armas a Distancia");
						}
						if (StartNPC.character.getCombatSkills().getDodge() == 5) {
							maestro.add("Esquivar");
						}
						if (StartNPC.character.getCombatSkills().getBlock() == 5) {
							maestro.add("Bloquear");
						}

						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio1, "Seleccione opcion",
								"Maestro de Armas", JOptionPane.PLAIN_MESSAGE,
								null, // null para icono defecto
								maestros, "opcion 1");
						priv.set(0, "Maestro de Armas:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de combate.";
						txtpriv1.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de combate a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio1.setSelectedIndex(0);

					}

				}
				if (privilegio1.getSelectedIndex() == 16) {
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getDiplomacy() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getEtiquette() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getMedicine() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getNegotiation() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getOccultism() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getResearch() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getSecretKnowledge() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getKnowledgeSkills()
								.getArtofWar() == 5) {
							maestro.add("Arte de la Guerra");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() == 5) {
							maestro.add("Diplomacia");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getEtiquette() == 5) {
							maestro.add("Etiqueta");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getMedicine() == 5) {
							maestro.add("Medicina");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getOccultism() == 5) {
							maestro.add("Ocultismo");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getNegotiation() == 5) {
							maestro.add("Negociación");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getResearch() == 5) {
							maestro.add("Investigación");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getSecretKnowledge() == 5) {
							maestro.add("Conocimientos Secretos");
						}
						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio1, "Seleccione opcion", "Erudito",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(0, "Erudito:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de conocimientos.";
						txtpriv1.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de conocimientos a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio1.setSelectedIndex(0);

					}

				}
				if (privilegio1.getSelectedIndex() == 17) {
					if (StartNPC.character.getMagicSkills().getArcane() == 5
							|| StartNPC.character.getMagicSkills().getBlack() == 5
							|| StartNPC.character.getMagicSkills().getDruidic() == 5
							|| StartNPC.character.getMagicSkills().getEarth() == 5
							|| StartNPC.character.getMagicSkills().getFire() == 5
							|| StartNPC.character.getMagicSkills().getWater() == 5
							|| StartNPC.character.getMagicSkills().getWind() == 5
							|| StartNPC.character.getMagicSkills().getWhite() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getMagicSkills().getFire() == 5) {
							maestro.add("Fuego");
						}
						if (StartNPC.character.getMagicSkills().getWater() == 5) {
							maestro.add("Agua");
						}
						if (StartNPC.character.getMagicSkills().getEarth() == 5) {
							maestro.add("Tierra");
						}
						if (StartNPC.character.getMagicSkills().getWind() == 5) {
							maestro.add("Viento");
						}
						if (StartNPC.character.getMagicSkills().getDruidic() == 5) {
							maestro.add("Druídica");
						}
						if (StartNPC.character.getMagicSkills().getWhite() == 5) {
							maestro.add("Blanca");
						}
						if (StartNPC.character.getMagicSkills().getBlack() == 5) {
							maestro.add("Negra");
						}
						if (StartNPC.character.getMagicSkills().getArcane() == 5) {
							maestro.add("Arcana");
						}
						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio1, "Seleccione opcion", "Erudito",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(0, "Archimago:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de magia.";
						txtpriv1.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de magia a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio1.setSelectedIndex(0);

					}

				}
				if (privilegio1.getSelectedIndex() == 18) {
					if (StartNPC.character.getKnowhowSkills().getAthletics() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getEquitation() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getStealth() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getSurvival() == 5
							|| StartNPC.character.getKnowhowSkills().getTraps() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getKnowhowSkills()
								.getAthletics() == 5) {
							maestro.add("Atletismo");
						}
						if (StartNPC.character.getKnowhowSkills().getSurvival() == 5) {
							maestro.add("Supervivencia");
						}
						if (StartNPC.character.getKnowhowSkills().getTraps() == 5) {
							maestro.add("Trampas");
						}
						if (StartNPC.character.getKnowhowSkills()
								.getEquitation() == 5) {
							maestro.add("Equitación");
						}
						if (StartNPC.character.getKnowhowSkills().getStealth() == 5) {
							maestro.add("Sigilo");
						}

						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio1, "Seleccione opcion", "Virtuoso",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(0, "Virtuoso:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de destrezas.";
						txtpriv1.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de destrezas a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio1.setSelectedIndex(0);

					}

				}
				if (privilegio1.getSelectedIndex() == 19) {

					priv.set(0, "Berseker");

					String descrp = "El personaje se verá afectado de manera diferente a medida que pierde salud.";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 20) {

					priv.set(0, "Geiser Arcano");

					String descrp = "+10 Maná";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 21) {

					priv.set(0, "Enérgico");

					String descrp = "+10 Energía";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 22) {

					priv.set(0, "Hercúleo");

					String descrp = "+3 Fuerza";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 23) {

					priv.set(0, "Hábil");

					String descrp = "+3 Destreza";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 24) {

					priv.set(0, "Sólido");

					String descrp = "+3 Resistencia";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 25) {

					priv.set(0, "Anti-Magia");

					String descrp = "+3 Resistencia Mágica";
					txtpriv1.setText(descrp);
				}

				if (privilegio1.getSelectedIndex() == 26) {

					priv.set(0, "Gran Cerebro");

					String descrp = "+3 Inteligencia";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 27) {

					priv.set(0, "Ojo de Halcón");

					String descrp = "+3 Percepción";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 28) {

					priv.set(0, "Engatusador");

					String descrp = "+3 Carisma";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 29) {

					priv.set(0, "Artefacto Legendario");

					String descrp = "El personaje porta un artefacto legendario";
					txtpriv1.setText(descrp);
				}
				if (privilegio1.getSelectedIndex() == 30) {

					if (StartNPC.character.getMagicSkills().isUniversalista() == true) {
						priv.set(0, "Mago Universalista");

						String descrp = "El coste para subir habilidades mágicas se iguala al de combate.";
						txtpriv1.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Necesitas dos habilidades mágicas a nivel 3 y 4 a nivel 2 para poder asignar este privilegio.",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");
						privilegio1.setSelectedIndex(0);

					}
				}

				priv1 = privilegio1.getSelectedIndex();
				if (privilegio1.getSelectedIndex() == 0) {

					btnContinuar.setEnabled(false);

				}
				if (privilegio1.getSelectedIndex() != 0) {
					btnContinuar.setEnabled(true);

				}

			}

		});

		JLabel lblPrivilegios = new JLabel("Privilegios:");
		lblPrivilegios.setFont(mf.MyFont(0, 13));
		lblPrivilegios.setForeground(Color.WHITE);
		lblPrivilegios.setBounds(20, 90, 303, 20);
		frmHistoriasDeZagas.getContentPane().add(lblPrivilegios);

		JLabel lblReveses = new JLabel("Reveses:");
		lblReveses.setFont(mf.MyFont(0, 13));
		lblReveses.setForeground(Color.WHITE);
		lblReveses.setBounds(20, 276, 303, 20);
		frmHistoriasDeZagas.getContentPane().add(lblReveses);

		txtpriv1 = new JTextField();
		txtpriv1.setBackground(Color.WHITE);
		txtpriv1.setEditable(false);
		txtpriv1.setFont(mf.MyFont(0, 11));
		txtpriv1.setBounds(179, 121, 355, 20);
		frmHistoriasDeZagas.getContentPane().add(txtpriv1);
		txtpriv1.setColumns(10);

		txtpriv2 = new JTextField();
		txtpriv2.setBackground(Color.WHITE);
		txtpriv2.setEditable(false);
		txtpriv2.setFont(mf.MyFont(0, 11));
		txtpriv2.setColumns(10);
		txtpriv2.setBounds(179, 152, 355, 20);
		frmHistoriasDeZagas.getContentPane().add(txtpriv2);

		txtpriv3 = new JTextField();
		txtpriv3.setBackground(Color.WHITE);
		txtpriv3.setEditable(false);
		txtpriv3.setFont(mf.MyFont(0, 11));
		txtpriv3.setColumns(10);
		txtpriv3.setBounds(179, 183, 355, 20);
		frmHistoriasDeZagas.getContentPane().add(txtpriv3);

		txtpriv4 = new JTextField();
		txtpriv4.setBackground(Color.WHITE);
		txtpriv4.setEditable(false);
		txtpriv4.setFont(mf.MyFont(0, 11));
		txtpriv4.setColumns(10);
		txtpriv4.setBounds(179, 214, 355, 20);
		frmHistoriasDeZagas.getContentPane().add(txtpriv4);

		txtpriv5 = new JTextField();
		txtpriv5.setBackground(Color.WHITE);
		txtpriv5.setEditable(false);
		txtpriv5.setFont(mf.MyFont(0, 11));
		txtpriv5.setColumns(10);
		txtpriv5.setBounds(179, 245, 355, 20);
		frmHistoriasDeZagas.getContentPane().add(txtpriv5);

		txtrev1 = new JTextField();
		txtrev1.setEditable(false);
		txtrev1.setFont(mf.MyFont(0, 11));
		txtrev1.setColumns(10);
		txtrev1.setBackground(Color.WHITE);
		txtrev1.setBounds(179, 307, 355, 20);
		frmHistoriasDeZagas.getContentPane().add(txtrev1);

		txtrev2 = new JTextField();
		txtrev2.setEditable(false);
		txtrev2.setFont(mf.MyFont(0, 11));
		txtrev2.setColumns(10);
		txtrev2.setBackground(Color.WHITE);
		txtrev2.setBounds(179, 338, 355, 20);
		frmHistoriasDeZagas.getContentPane().add(txtrev2);

		txtrev3 = new JTextField();
		txtrev3.setEditable(false);
		txtrev3.setFont(mf.MyFont(0, 11));
		txtrev3.setColumns(10);
		txtrev3.setBackground(Color.WHITE);
		txtrev3.setBounds(179, 369, 355, 20);
		frmHistoriasDeZagas.getContentPane().add(txtrev3);

		txtrev4 = new JTextField();
		txtrev4.setEditable(false);
		txtrev4.setFont(mf.MyFont(0, 11));
		txtrev4.setColumns(10);
		txtrev4.setBackground(Color.WHITE);
		txtrev4.setBounds(179, 400, 355, 20);
		frmHistoriasDeZagas.getContentPane().add(txtrev4);
		privilegio1
				.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		privilegio1.setModel(new DefaultComboBoxModel(new String[] {
				"-Privilegio-", "Afinidad Arcana", "Torrente Arcano", "Duro",
				"Incansable", "Fornido", "Mente \u00E1gil", "Posesi\u00F3n",
				"Experto", "Maestro", "Noble ", "Curaci\u00F3n r\u00E1pida",
				"Talento", "Aliado", "Buena Estrella", "Maestro de Armas",
				"Erudito", "Archimago", "Virtuoso", "Berseker",
				"Geiser Arcano", "En\u00E9rgico", "Herc\u00FAleo",
				"H\u00E1bil", "S\u00F3lido", "Anti-Magia", "Gran Cerebro",
				"Ojo de Halc\u00F3n", "Engatusador", "Artefacto Legendario",
				"Mago Universalista" }));
		privilegio1.setFont(mf.MyFont(0, 11));
		privilegio1.setSelectedIndex(priv1);
		privilegio1.setBounds(20, 121, 149, 20);
		frmHistoriasDeZagas.getContentPane().add(privilegio1);

		privilegio2.setBackground(Color.WHITE);
		privilegio2.setForeground(new Color(0, 0, 0));
		privilegio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio2.getSelectedIndex() == 0) {
					priv.set(1, "");
					txtpriv2.setText("");

				}
				if (privilegio2.getSelectedIndex() == 1) {
					if (StartNPC.character.getRace().getRace() != ("Alto Elfo")) {

						priv.set(1, "Afinidad Arcana");

						String descrp = "-2 para cada nivel de magia.";
						txtpriv2.setText(descrp);
					} else {
						JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"Eres un alto elfo, la afinindad arcana es innata en ti",
										"", JOptionPane.ERROR_MESSAGE);
						privilegio2.setSelectedIndex(0);

					}
				}
				if (privilegio2.getSelectedIndex() == 2) {

					priv.set(1, "Torrente Arcano");

					String descrp = "+5 maná.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 3) {

					priv.set(1, "Duro");

					String descrp = "+3 vida";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 4) {

					priv.set(1, "Incansable");

					String descrp = "+ 5 energía";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 5) {

					priv.set(1, "Fornido");

					String descrp = "Elimina penalización de armaduras pesadas.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 6) {

					priv.set(1, "Mente Ágil");

					String descrp = "El coste para subir conocimientos se iguala al de combate.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 7) {

					priv.set(1, "Posesión");

					String descrp = "Permite llevar un objeto especial.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 8) {

					priv.set(1, "Experto");

					String descrp = "Permite subir a nivel 4 las habilidades.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 9) {

					priv.set(1, "Maestro");

					String descrp = "Permite subir a nivel 5 las habilidades.";
					txtpriv2.setText(descrp);
				}

				if (privilegio2.getSelectedIndex() == 10) {

					priv.set(1, "Noble");

					String descrp = "El personaje es de alta alcurnia y como tal obtiene ciertos beneficios.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 11) {

					priv.set(1, "Curación Rápida");

					String descrp = "Curación de heridas x2 al descansar.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 12) {

					priv.set(1, "Talento");

					String descrp = "+1 rango en combate contra oponentes con el mismo rango.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 13) {

					priv.set(1, "Aliado");

					String descrp = "Lleva un aliado contigo.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 14) {

					priv.set(1, "Buena Estrella");

					String descrp = "Los dioses han favorecido al personaje.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 15) {
					if (StartNPC.character.getCombatSkills().getOneHanded() == 5
							|| StartNPC.character.getCombatSkills()
									.getTwoHanded() == 5
							|| StartNPC.character.getCombatSkills().getPole() == 5
							|| StartNPC.character.getCombatSkills().getRanged() == 5
							|| StartNPC.character.getCombatSkills().getDodge() == 5
							|| StartNPC.character.getCombatSkills().getBlock() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getCombatSkills().getOneHanded() == 5) {
							maestro.add("Armas de Una Mano");
						}
						if (StartNPC.character.getCombatSkills().getTwoHanded() == 5) {
							maestro.add("Armas de Dos Manos");
						}
						if (StartNPC.character.getCombatSkills().getPole() == 5) {
							maestro.add("Armas de Asta");
						}
						if (StartNPC.character.getCombatSkills().getRanged() == 5) {
							maestro.add("Armas a Distancia");
						}
						if (StartNPC.character.getCombatSkills().getDodge() == 5) {
							maestro.add("Esquivar");
						}
						if (StartNPC.character.getCombatSkills().getBlock() == 5) {
							maestro.add("Bloquear");
						}

						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio2, "Seleccione opcion",
								"Maestro de Armas", JOptionPane.PLAIN_MESSAGE,
								null, // null para icono defecto
								maestros, "opcion 1");
						priv.set(1, "Maestro de Armas:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de combate.";
						txtpriv2.setText(descrp);
					} else {

						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de combate a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");
						privilegio2.setSelectedIndex(0);

					}

				}
				if (privilegio2.getSelectedIndex() == 16) {
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getDiplomacy() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getEtiquette() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getMedicine() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getNegotiation() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getOccultism() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getResearch() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getSecretKnowledge() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getKnowledgeSkills()
								.getArtofWar() == 5) {
							maestro.add("Arte de la Guerra");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() == 5) {
							maestro.add("Diplomacia");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getEtiquette() == 5) {
							maestro.add("Etiqueta");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getMedicine() == 5) {
							maestro.add("Medicina");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getOccultism() == 5) {
							maestro.add("Ocultismo");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getNegotiation() == 5) {
							maestro.add("Negociación");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getResearch() == 5) {
							maestro.add("Investigación");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getSecretKnowledge() == 5) {
							maestro.add("Conocimientos Secretos");
						}
						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio2, "Seleccione opcion", "Erudito",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(1, "Erudito:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de conocimientos.";
						txtpriv2.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de conocimientos a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio2.setSelectedIndex(0);

					}

				}
				if (privilegio2.getSelectedIndex() == 17) {
					if (StartNPC.character.getMagicSkills().getArcane() == 5
							|| StartNPC.character.getMagicSkills().getBlack() == 5
							|| StartNPC.character.getMagicSkills().getDruidic() == 5
							|| StartNPC.character.getMagicSkills().getEarth() == 5
							|| StartNPC.character.getMagicSkills().getFire() == 5
							|| StartNPC.character.getMagicSkills().getWater() == 5
							|| StartNPC.character.getMagicSkills().getWind() == 5
							|| StartNPC.character.getMagicSkills().getWhite() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getMagicSkills().getFire() == 5) {
							maestro.add("Fuego");
						}
						if (StartNPC.character.getMagicSkills().getWater() == 5) {
							maestro.add("Agua");
						}
						if (StartNPC.character.getMagicSkills().getEarth() == 5) {
							maestro.add("Tierra");
						}
						if (StartNPC.character.getMagicSkills().getWind() == 5) {
							maestro.add("Viento");
						}
						if (StartNPC.character.getMagicSkills().getDruidic() == 5) {
							maestro.add("Druídica");
						}
						if (StartNPC.character.getMagicSkills().getWhite() == 5) {
							maestro.add("Blanca");
						}
						if (StartNPC.character.getMagicSkills().getBlack() == 5) {
							maestro.add("Negra");
						}
						if (StartNPC.character.getMagicSkills().getArcane() == 5) {
							maestro.add("Arcana");
						}
						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio2, "Seleccione opcion", "Erudito",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(1, "Archimago:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de magia.";
						txtpriv2.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de magia a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio2.setSelectedIndex(0);

					}
				}
				if (privilegio2.getSelectedIndex() == 18) {
					if (StartNPC.character.getKnowhowSkills().getAthletics() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getEquitation() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getStealth() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getSurvival() == 5
							|| StartNPC.character.getKnowhowSkills().getTraps() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getKnowhowSkills()
								.getAthletics() == 5) {
							maestro.add("Atletismo");
						}
						if (StartNPC.character.getKnowhowSkills().getSurvival() == 5) {
							maestro.add("Supervivencia");
						}
						if (StartNPC.character.getKnowhowSkills().getTraps() == 5) {
							maestro.add("Trampas");
						}
						if (StartNPC.character.getKnowhowSkills()
								.getEquitation() == 5) {
							maestro.add("Equitación");
						}
						if (StartNPC.character.getKnowhowSkills().getStealth() == 5) {
							maestro.add("Sigilo");
						}

						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio2, "Seleccione opcion", "Virtuoso",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(1, "Virtuoso:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de destrezas.";
						txtpriv2.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de destrezas a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio2.setSelectedIndex(0);

					}

				}
				if (privilegio2.getSelectedIndex() == 19) {

					priv.set(1, "Berseker");

					String descrp = "El personaje se verá afectado de manera diferente a medida que pierde salud.";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 20) {

					priv.set(1, "Geiser Arcano");

					String descrp = "+10 Maná";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 21) {

					priv.set(1, "Enérgico");

					String descrp = "+10 Energía";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 22) {

					priv.set(1, "Hercúleo");

					String descrp = "+3 Fuerza";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 23) {

					priv.set(1, "Hábil");

					String descrp = "+3 Destreza";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 24) {

					priv.set(1, "Sólido");

					String descrp = "+3 Resistencia";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 25) {

					priv.set(1, "Anti-Magia");

					String descrp = "+3 Resistencia Mágica";
					txtpriv2.setText(descrp);
				}

				if (privilegio2.getSelectedIndex() == 26) {

					priv.set(1, "Gran Cerebro");

					String descrp = "+3 Inteligencia";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 27) {

					priv.set(1, "Ojo de Halcón");

					String descrp = "+3 Percepción";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 28) {

					priv.set(1, "Engatusador");

					String descrp = "+3 Carisma";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 29) {

					priv.set(1, "Artefacto Legendario");

					String descrp = "El personaje porta un artefacto legendario";
					txtpriv2.setText(descrp);
				}
				if (privilegio2.getSelectedIndex() == 30) {

					if (StartNPC.character.getMagicSkills().isUniversalista() == true) {
						priv.set(1, "Mago Universalista");

						String descrp = "El coste para subir habilidades mágicas se iguala al de combate.";
						txtpriv2.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Necesitas dos habilidades mágicas a nivel 3 y 4 a nivel 2 para poder asignar este privilegio.",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");
						privilegio2.setSelectedIndex(0);

					}
				}

				priv2 = privilegio2.getSelectedIndex();
			}
		});

		privilegio2.setModel(new DefaultComboBoxModel(new String[] {
				"-Privilegio-", "Afinidad Arcana", "Torrente Arcano", "Duro",
				"Incansable", "Fornido", "Mente \u00E1gil", "Posesi\u00F3n",
				"Experto", "Maestro", "Noble ", "Curaci\u00F3n r\u00E1pida",
				"Talento", "Aliado", "Buena Estrella", "Maestro de Armas",
				"Erudito", "Archimago", "Virtuoso", "Berseker",
				"Geiser Arcano", "En\u00E9rgico", "Herc\u00FAleo",
				"H\u00E1bil", "S\u00F3lido", "Anti-Magia", "Gran Cerebro",
				"Ojo de Halc\u00F3n", "Engatusador", "Artefacto Legendario",
				"Mago Universalista" }));
		privilegio2.setFont(mf.MyFont(0, 11));
		privilegio2.setBounds(20, 152, 149, 20);
		privilegio2.setSelectedIndex(priv2);

		frmHistoriasDeZagas.getContentPane().add(privilegio2);

		privilegio3.setForeground(new Color(0, 0, 0));
		privilegio3.setBackground(Color.WHITE);
		privilegio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio3.getSelectedIndex() == 0) {
					priv.set(2, "");
					txtpriv3.setText("");
				}
				if (privilegio3.getSelectedIndex() == 1) {
					if (StartNPC.character.getRace().getRace() != ("Alto Elfo")) {

						priv.set(2, "Afinidad Arcana");

						String descrp = "-2 para cada nivel de magia.";
						txtpriv3.setText(descrp);
					} else {
						JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"Eres un alto elfo, la afinindad arcana es innata en ti",
										"", JOptionPane.ERROR_MESSAGE);
						privilegio3.setSelectedIndex(0);
					}
				}
				if (privilegio3.getSelectedIndex() == 2) {

					priv.set(2, "Torrente Arcano");

					String descrp = "+5 maná.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 3) {

					priv.set(2, "Duro");

					String descrp = "+3 vida";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 4) {

					priv.set(2, "Incansable");

					String descrp = "+ 5 energía";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 5) {

					priv.set(2, "Fornido");

					String descrp = "Elimina penalización de armaduras pesadas.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 6) {

					priv.set(2, "Mente Ágil");

					String descrp = "El coste para subir conocimientos se iguala al de combate.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 7) {

					priv.set(2, "Posesión");

					String descrp = "Permite llevar un objeto especial.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 8) {

					priv.set(2, "Experto");

					String descrp = "Permite subir a nivel 4 las habilidades.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 9) {

					priv.set(2, "Maestro");

					String descrp = "Permite subir a nivel 5 las habilidades.";
					txtpriv3.setText(descrp);
				}

				if (privilegio3.getSelectedIndex() == 10) {

					priv.set(2, "Noble");

					String descrp = "El personaje es de alta alcurnia y como tal obtiene ciertos beneficios.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 11) {

					priv.set(2, "Curación Rápida");

					String descrp = "Curación de heridas x2 al descansar.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 12) {

					priv.set(2, "Talento");

					String descrp = "+1 rango en combate contra oponentes con el mismo rango.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 13) {

					priv.set(2, "Aliado");

					String descrp = "Lleva un aliado contigo.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 14) {

					priv.set(2, "Buena Estrella");

					String descrp = "Los dioses han favorecido al personaje.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 15) {
					if (StartNPC.character.getCombatSkills().getOneHanded() == 5
							|| StartNPC.character.getCombatSkills()
									.getTwoHanded() == 5
							|| StartNPC.character.getCombatSkills().getPole() == 5
							|| StartNPC.character.getCombatSkills().getRanged() == 5
							|| StartNPC.character.getCombatSkills().getDodge() == 5
							|| StartNPC.character.getCombatSkills().getBlock() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getCombatSkills().getOneHanded() == 5) {
							maestro.add("Armas de Una Mano");
						}
						if (StartNPC.character.getCombatSkills().getTwoHanded() == 5) {
							maestro.add("Armas de Dos Manos");
						}
						if (StartNPC.character.getCombatSkills().getPole() == 5) {
							maestro.add("Armas de Asta");
						}
						if (StartNPC.character.getCombatSkills().getRanged() == 5) {
							maestro.add("Armas a Distancia");
						}
						if (StartNPC.character.getCombatSkills().getDodge() == 5) {
							maestro.add("Esquivar");
						}
						if (StartNPC.character.getCombatSkills().getBlock() == 5) {
							maestro.add("Bloquear");
						}

						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio3, "Seleccione opcion",
								"Maestro de Armas", JOptionPane.PLAIN_MESSAGE,
								null, // null para icono defecto
								maestros, "opcion 1");
						priv.set(2, "Maestro de Armas:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de combate.";
						txtpriv3.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de combate a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio3.setSelectedIndex(0);

					}

				}
				if (privilegio3.getSelectedIndex() == 16) {
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getDiplomacy() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getEtiquette() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getMedicine() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getNegotiation() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getOccultism() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getResearch() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getSecretKnowledge() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getKnowledgeSkills()
								.getArtofWar() == 5) {
							maestro.add("Arte de la Guerra");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() == 5) {
							maestro.add("Diplomacia");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getEtiquette() == 5) {
							maestro.add("Etiqueta");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getMedicine() == 5) {
							maestro.add("Medicina");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getOccultism() == 5) {
							maestro.add("Ocultismo");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getNegotiation() == 5) {
							maestro.add("Negociación");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getResearch() == 5) {
							maestro.add("Investigación");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getSecretKnowledge() == 5) {
							maestro.add("Conocimientos Secretos");
						}
						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio3, "Seleccione opcion", "Erudito",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(2, "Erudito:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de conocimientos.";
						txtpriv3.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de conocimientos a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio3.setSelectedIndex(0);

					}

				}
				if (privilegio3.getSelectedIndex() == 17) {
					if (StartNPC.character.getMagicSkills().getArcane() == 5
							|| StartNPC.character.getMagicSkills().getBlack() == 5
							|| StartNPC.character.getMagicSkills().getDruidic() == 5
							|| StartNPC.character.getMagicSkills().getEarth() == 5
							|| StartNPC.character.getMagicSkills().getFire() == 5
							|| StartNPC.character.getMagicSkills().getWater() == 5
							|| StartNPC.character.getMagicSkills().getWind() == 5
							|| StartNPC.character.getMagicSkills().getWhite() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getMagicSkills().getFire() == 5) {
							maestro.add("Fuego");
						}
						if (StartNPC.character.getMagicSkills().getWater() == 5) {
							maestro.add("Agua");
						}
						if (StartNPC.character.getMagicSkills().getEarth() == 5) {
							maestro.add("Tierra");
						}
						if (StartNPC.character.getMagicSkills().getWind() == 5) {
							maestro.add("Viento");
						}
						if (StartNPC.character.getMagicSkills().getDruidic() == 5) {
							maestro.add("Druídica");
						}
						if (StartNPC.character.getMagicSkills().getWhite() == 5) {
							maestro.add("Blanca");
						}
						if (StartNPC.character.getMagicSkills().getBlack() == 5) {
							maestro.add("Negra");
						}
						if (StartNPC.character.getMagicSkills().getArcane() == 5) {
							maestro.add("Arcana");
						}
						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio3, "Seleccione opcion", "Erudito",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(2, "Archimago:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de magia.";
						txtpriv3.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de magia a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio3.setSelectedIndex(0);

					}
				}
				if (privilegio3.getSelectedIndex() == 18) {
					if (StartNPC.character.getKnowhowSkills().getAthletics() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getEquitation() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getStealth() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getSurvival() == 5
							|| StartNPC.character.getKnowhowSkills().getTraps() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getKnowhowSkills()
								.getAthletics() == 5) {
							maestro.add("Atletismo");
						}
						if (StartNPC.character.getKnowhowSkills().getSurvival() == 5) {
							maestro.add("Supervivencia");
						}
						if (StartNPC.character.getKnowhowSkills().getTraps() == 5) {
							maestro.add("Trampas");
						}
						if (StartNPC.character.getKnowhowSkills()
								.getEquitation() == 5) {
							maestro.add("Equitación");
						}
						if (StartNPC.character.getKnowhowSkills().getStealth() == 5) {
							maestro.add("Sigilo");
						}

						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio3, "Seleccione opcion", "Virtuoso",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(2, "Virtuoso:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de destrezas.";
						txtpriv3.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de destrezas a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio3.setSelectedIndex(0);

					}

				}
				if (privilegio3.getSelectedIndex() == 19) {

					priv.set(2, "Berseker");

					String descrp = "El personaje se verá afectado de manera diferente a medida que pierde salud.";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 20) {

					priv.set(2, "Geiser Arcano");

					String descrp = "+10 Maná";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 21) {

					priv.set(2, "Enérgico");

					String descrp = "+10 Energía";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 22) {

					priv.set(2, "Hercúleo");

					String descrp = "+3 Fuerza";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 23) {

					priv.set(2, "Hábil");

					String descrp = "+3 Destreza";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 24) {

					priv.set(2, "Sólido");

					String descrp = "+3 Resistencia";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 25) {

					priv.set(2, "Anti-Magia");

					String descrp = "+3 Resistencia Mágica";
					txtpriv3.setText(descrp);
				}

				if (privilegio3.getSelectedIndex() == 26) {

					priv.set(2, "Gran Cerebro");

					String descrp = "+3 Inteligencia";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 27) {

					priv.set(2, "Ojo de Halcón");

					String descrp = "+3 Percepción";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 28) {

					priv.set(2, "Engatusador");

					String descrp = "+3 Carisma";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 29) {

					priv.set(2, "Artefacto Legendario");

					String descrp = "El personaje porta un artefacto legendario";
					txtpriv3.setText(descrp);
				}
				if (privilegio3.getSelectedIndex() == 30) {

					if (StartNPC.character.getMagicSkills().isUniversalista() == true) {
						priv.set(2, "Mago Universalista");

						String descrp = "El coste para subir habilidades mágicas se iguala al de combate.";
						txtpriv3.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Necesitas dos habilidades mágicas a nivel 3 y 4 a nivel 2 para poder asignar este privilegio.",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");
						privilegio3.setSelectedIndex(0);

					}
				}

				priv3 = privilegio3.getSelectedIndex();
			}
		});

		privilegio3.setFont(mf.MyFont(0, 11));
		privilegio3.setModel(new DefaultComboBoxModel(new String[] {
				"-Privilegio-", "Afinidad Arcana", "Torrente Arcano", "Duro",
				"Incansable", "Fornido", "Mente \u00E1gil", "Posesi\u00F3n",
				"Experto", "Maestro", "Noble ", "Curaci\u00F3n r\u00E1pida",
				"Talento", "Aliado", "Buena Estrella", "Maestro de Armas",
				"Erudito", "Archimago", "Virtuoso", "Berseker",
				"Geiser Arcano", "En\u00E9rgico", "Herc\u00FAleo",
				"H\u00E1bil", "S\u00F3lido", "Anti-Magia", "Gran Cerebro",
				"Ojo de Halc\u00F3n", "Engatusador", "Artefacto Legendario",
				"Mago Universalista" }));
		privilegio3.setBounds(20, 183, 149, 20);
		privilegio3.setSelectedIndex(priv3);

		frmHistoriasDeZagas.getContentPane().add(privilegio3);

		privilegio4.setBackground(Color.WHITE);
		privilegio4.setForeground(new Color(0, 0, 0));
		privilegio4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio4.getSelectedIndex() == 0) {

					priv.set(3, "");
					txtpriv4.setText("");

				}
				if (privilegio4.getSelectedIndex() == 1) {
					if (StartNPC.character.getRace().getRace() != ("Alto Elfo")) {

						priv.set(3, "Afinidad Arcana");

						String descrp = "-2 para cada nivel de magia.";
						txtpriv4.setText(descrp);
					} else {
						JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"Eres un alto elfo, la afinindad arcana es innata en ti",
										"", JOptionPane.ERROR_MESSAGE);
						privilegio4.setSelectedIndex(0);

					}
				}
				if (privilegio4.getSelectedIndex() == 2) {

					priv.set(3, "Torrente Arcano");

					String descrp = "+5 maná.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 3) {

					priv.set(3, "Duro");

					String descrp = "+3 vida";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 4) {

					priv.set(3, "Incansable");

					String descrp = "+ 5 energía";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 5) {

					priv.set(3, "Fornido");

					String descrp = "Elimina penalización de armaduras pesadas.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 6) {

					priv.set(3, "Mente Ágil");

					String descrp = "El coste para subir conocimientos se iguala al de combate.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 7) {

					priv.set(3, "Posesión");

					String descrp = "Permite llevar un objeto especial.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 8) {

					priv.set(3, "Experto");

					String descrp = "Permite subir a nivel 4 las habilidades.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 9) {

					priv.set(3, "Maestro");

					String descrp = "Permite subir a nivel 5 las habilidades.";
					txtpriv4.setText(descrp);
				}

				if (privilegio4.getSelectedIndex() == 10) {

					priv.set(3, "Noble");

					String descrp = "El personaje es de alta alcurnia y como tal obtiene ciertos beneficios.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 11) {

					priv.set(3, "Curación Rápida");

					String descrp = "Curación de heridas x2 al descansar.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 12) {

					priv.set(3, "Talento");

					String descrp = "+1 rango en combate contra oponentes con el mismo rango.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 13) {

					priv.set(3, "Aliado");

					String descrp = "Lleva un aliado contigo.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 14) {

					priv.set(3, "Buena Estrella");

					String descrp = "Los dioses han favorecido al personaje.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 15) {
					if (StartNPC.character.getCombatSkills().getOneHanded() == 5
							|| StartNPC.character.getCombatSkills()
									.getTwoHanded() == 5
							|| StartNPC.character.getCombatSkills().getPole() == 5
							|| StartNPC.character.getCombatSkills().getRanged() == 5
							|| StartNPC.character.getCombatSkills().getDodge() == 5
							|| StartNPC.character.getCombatSkills().getBlock() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getCombatSkills().getOneHanded() == 5) {
							maestro.add("Armas de Una Mano");
						}
						if (StartNPC.character.getCombatSkills().getTwoHanded() == 5) {
							maestro.add("Armas de Dos Manos");
						}
						if (StartNPC.character.getCombatSkills().getPole() == 5) {
							maestro.add("Armas de Asta");
						}
						if (StartNPC.character.getCombatSkills().getRanged() == 5) {
							maestro.add("Armas a Distancia");
						}
						if (StartNPC.character.getCombatSkills().getDodge() == 5) {
							maestro.add("Esquivar");
						}
						if (StartNPC.character.getCombatSkills().getBlock() == 5) {
							maestro.add("Bloquear");
						}

						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio4, "Seleccione opcion",
								"Maestro de Armas", JOptionPane.PLAIN_MESSAGE,
								null, // null para icono defecto
								maestros, "opcion 1");
						priv.set(3, "Maestro de Armas:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de combate.";
						txtpriv4.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de combate a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio4.setSelectedIndex(0);

					}

				}
				if (privilegio4.getSelectedIndex() == 16) {
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getDiplomacy() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getEtiquette() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getMedicine() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getNegotiation() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getOccultism() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getResearch() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getSecretKnowledge() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getKnowledgeSkills()
								.getArtofWar() == 5) {
							maestro.add("Arte de la Guerra");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() == 5) {
							maestro.add("Diplomacia");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getEtiquette() == 5) {
							maestro.add("Etiqueta");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getMedicine() == 5) {
							maestro.add("Medicina");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getOccultism() == 5) {
							maestro.add("Ocultismo");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getNegotiation() == 5) {
							maestro.add("Negociación");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getResearch() == 5) {
							maestro.add("Investigación");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getSecretKnowledge() == 5) {
							maestro.add("Conocimientos Secretos");
						}
						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio4, "Seleccione opcion", "Erudito",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(3, "Erudito:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de conocimientos.";
						txtpriv4.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de conocimientos a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio4.setSelectedIndex(0);

					}

				}
				if (privilegio4.getSelectedIndex() == 17) {
					if (StartNPC.character.getMagicSkills().getArcane() == 5
							|| StartNPC.character.getMagicSkills().getBlack() == 5
							|| StartNPC.character.getMagicSkills().getDruidic() == 5
							|| StartNPC.character.getMagicSkills().getEarth() == 5
							|| StartNPC.character.getMagicSkills().getFire() == 5
							|| StartNPC.character.getMagicSkills().getWater() == 5
							|| StartNPC.character.getMagicSkills().getWind() == 5
							|| StartNPC.character.getMagicSkills().getWhite() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getMagicSkills().getFire() == 5) {
							maestro.add("Fuego");
						}
						if (StartNPC.character.getMagicSkills().getWater() == 5) {
							maestro.add("Agua");
						}
						if (StartNPC.character.getMagicSkills().getEarth() == 5) {
							maestro.add("Tierra");
						}
						if (StartNPC.character.getMagicSkills().getWind() == 5) {
							maestro.add("Viento");
						}
						if (StartNPC.character.getMagicSkills().getDruidic() == 5) {
							maestro.add("Druídica");
						}
						if (StartNPC.character.getMagicSkills().getWhite() == 5) {
							maestro.add("Blanca");
						}
						if (StartNPC.character.getMagicSkills().getBlack() == 5) {
							maestro.add("Negra");
						}
						if (StartNPC.character.getMagicSkills().getArcane() == 5) {
							maestro.add("Arcana");
						}
						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio4, "Seleccione opcion", "Erudito",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(3, "Archimago:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de magia.";
						txtpriv4.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de magia a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio4.setSelectedIndex(0);

					}
				}
				if (privilegio4.getSelectedIndex() == 18) {
					if (StartNPC.character.getKnowhowSkills().getAthletics() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getEquitation() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getStealth() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getSurvival() == 5
							|| StartNPC.character.getKnowhowSkills().getTraps() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getKnowhowSkills()
								.getAthletics() == 5) {
							maestro.add("Atletismo");
						}
						if (StartNPC.character.getKnowhowSkills().getSurvival() == 5) {
							maestro.add("Supervivencia");
						}
						if (StartNPC.character.getKnowhowSkills().getTraps() == 5) {
							maestro.add("Trampas");
						}
						if (StartNPC.character.getKnowhowSkills()
								.getEquitation() == 5) {
							maestro.add("Equitación");
						}
						if (StartNPC.character.getKnowhowSkills().getStealth() == 5) {
							maestro.add("Sigilo");
						}

						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio4, "Seleccione opcion", "Virtuoso",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(3, "Virtuoso:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de destrezas.";
						txtpriv4.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de destrezas a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio4.setSelectedIndex(0);

					}

				}
				if (privilegio4.getSelectedIndex() == 19) {

					priv.set(3, "Berseker");

					String descrp = "El personaje se verá afectado de manera diferente a medida que pierde salud.";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 20) {

					priv.set(3, "Geiser Arcano");

					String descrp = "+10 Maná";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 21) {

					priv.set(3, "Enérgico");

					String descrp = "+10 Energía";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 22) {

					priv.set(3, "Hercúleo");

					String descrp = "+3 Fuerza";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 23) {

					priv.set(3, "Hábil");

					String descrp = "+3 Destreza";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 24) {

					priv.set(3, "Sólido");

					String descrp = "+3 Resistencia";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 25) {

					priv.set(3, "Anti-Magia");

					String descrp = "+3 Resistencia Mágica";
					txtpriv4.setText(descrp);
				}

				if (privilegio4.getSelectedIndex() == 26) {

					priv.set(3, "Gran Cerebro");

					String descrp = "+3 Inteligencia";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 27) {

					priv.set(3, "Ojo de Halcón");

					String descrp = "+3 Percepción";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 28) {

					priv.set(3, "Engatusador");

					String descrp = "+3 Carisma";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 29) {

					priv.set(3, "Artefacto Legendario");

					String descrp = "El personaje porta un artefacto legendario";
					txtpriv4.setText(descrp);
				}
				if (privilegio4.getSelectedIndex() == 30) {

					if (StartNPC.character.getMagicSkills().isUniversalista() == true) {
						priv.set(3, "Mago Universalista");

						String descrp = "El coste para subir habilidades mágicas se iguala al de combate.";
						txtpriv4.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Necesitas dos habilidades mágicas a nivel 3 y 4 a nivel 2 para poder asignar este privilegio.",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");
						privilegio4.setSelectedIndex(0);

					}
				}

				priv4 = privilegio4.getSelectedIndex();
			}
		});

		privilegio4.setFont(mf.MyFont(0, 11));
		privilegio4.setModel(new DefaultComboBoxModel(new String[] {
				"-Privilegio-", "Afinidad Arcana", "Torrente Arcano", "Duro",
				"Incansable", "Fornido", "Mente \u00E1gil", "Posesi\u00F3n",
				"Experto", "Maestro", "Noble ", "Curaci\u00F3n r\u00E1pida",
				"Talento", "Aliado", "Buena Estrella", "Maestro de Armas",
				"Erudito", "Archimago", "Virtuoso", "Berseker",
				"Geiser Arcano", "En\u00E9rgico", "Herc\u00FAleo",
				"H\u00E1bil", "S\u00F3lido", "Anti-Magia", "Gran Cerebro",
				"Ojo de Halc\u00F3n", "Engatusador", "Artefacto Legendario",
				"Mago Universalista" }));
		privilegio4.setBounds(20, 214, 149, 20);
		privilegio4.setSelectedIndex(priv4);

		frmHistoriasDeZagas.getContentPane().add(privilegio4);

		privilegio5.setForeground(new Color(0, 0, 0));
		privilegio5.setBackground(Color.WHITE);
		privilegio5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (privilegio5.getSelectedIndex() == 0) {

					priv.set(4, "");
					txtpriv5.setText("");

				}
				if (privilegio5.getSelectedIndex() == 1) {
					if (StartNPC.character.getRace().getRace() != ("Alto Elfo")) {

						priv.set(4, "Afinidad Arcana");

						String descrp = "-2 para cada nivel de magia.";
						txtpriv5.setText(descrp);
					} else {
						JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"Eres un alto elfo, la afinindad arcana es innata en ti",
										"", JOptionPane.ERROR_MESSAGE);
						privilegio5.setSelectedIndex(0);

					}
				}
				if (privilegio5.getSelectedIndex() == 2) {

					priv.set(4, "Torrente Arcano");

					String descrp = "+5 maná.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 3) {

					priv.set(4, "Duro");

					String descrp = "+3 vida";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 4) {

					priv.set(4, "Incansable");

					String descrp = "+ 5 energía";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 5) {

					priv.set(4, "Fornido");

					String descrp = "Elimina penalización de armaduras pesadas.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 6) {

					priv.set(4, "Mente Ágil");

					String descrp = "El coste para subir conocimientos se iguala al de combate.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 7) {

					priv.set(4, "Posesión");

					String descrp = "Permite llevar un objeto especial.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 8) {

					priv.set(4, "Experto");

					String descrp = "Permite subir a nivel 4 las habilidades.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 9) {

					priv.set(4, "Maestro");

					String descrp = "Permite subir a nivel 5 las habilidades.";
					txtpriv5.setText(descrp);
				}

				if (privilegio5.getSelectedIndex() == 10) {

					priv.set(4, "Noble");

					String descrp = "El personaje es de alta alcurnia y como tal obtiene ciertos beneficios.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 11) {

					priv.set(4, "Curación Rápida");

					String descrp = "Curación de heridas x2 al descansar.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 12) {

					priv.set(4, "Talento");

					String descrp = "+1 rango en combate contra oponentes con el mismo rango.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 13) {

					priv.set(4, "Aliado");

					String descrp = "Lleva un aliado contigo.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 14) {

					priv.set(4, "Buena Estrella");

					String descrp = "Los dioses han favorecido al personaje.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 15) {
					if (StartNPC.character.getCombatSkills().getOneHanded() == 5
							|| StartNPC.character.getCombatSkills()
									.getTwoHanded() == 5
							|| StartNPC.character.getCombatSkills().getPole() == 5
							|| StartNPC.character.getCombatSkills().getRanged() == 5
							|| StartNPC.character.getCombatSkills().getDodge() == 5
							|| StartNPC.character.getCombatSkills().getBlock() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getCombatSkills().getOneHanded() == 5) {
							maestro.add("Armas de Una Mano");
						}
						if (StartNPC.character.getCombatSkills().getTwoHanded() == 5) {
							maestro.add("Armas de Dos Manos");
						}
						if (StartNPC.character.getCombatSkills().getPole() == 5) {
							maestro.add("Armas de Asta");
						}
						if (StartNPC.character.getCombatSkills().getRanged() == 5) {
							maestro.add("Armas a Distancia");
						}
						if (StartNPC.character.getCombatSkills().getDodge() == 5) {
							maestro.add("Esquivar");
						}
						if (StartNPC.character.getCombatSkills().getBlock() == 5) {
							maestro.add("Bloquear");
						}

						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio5, "Seleccione opcion",
								"Maestro de Armas", JOptionPane.PLAIN_MESSAGE,
								null, // null para icono defecto
								maestros, "opcion 1");
						priv.set(4, "Maestro de Armas:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de combate.";
						txtpriv5.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de combate a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio5.setSelectedIndex(0);

					}

				}
				if (privilegio5.getSelectedIndex() == 16) {
					if (StartNPC.character.getKnowledgeSkills().getArtofWar() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getDiplomacy() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getEtiquette() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getMedicine() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getNegotiation() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getOccultism() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getResearch() == 5
							|| StartNPC.character.getKnowledgeSkills()
									.getSecretKnowledge() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getKnowledgeSkills()
								.getArtofWar() == 5) {
							maestro.add("Arte de la Guerra");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() == 5) {
							maestro.add("Diplomacia");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getEtiquette() == 5) {
							maestro.add("Etiqueta");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getMedicine() == 5) {
							maestro.add("Medicina");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getOccultism() == 5) {
							maestro.add("Ocultismo");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getNegotiation() == 5) {
							maestro.add("Negociación");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getResearch() == 5) {
							maestro.add("Investigación");
						}
						if (StartNPC.character.getKnowledgeSkills()
								.getSecretKnowledge() == 5) {
							maestro.add("Conocimientos Secretos");
						}
						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio5, "Seleccione opcion", "Erudito",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(4, "Erudito:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de conocimientos.";
						txtpriv5.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de conocimientos a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio5.setSelectedIndex(0);

					}

				}
				if (privilegio5.getSelectedIndex() == 17) {
					if (StartNPC.character.getMagicSkills().getArcane() == 5
							|| StartNPC.character.getMagicSkills().getBlack() == 5
							|| StartNPC.character.getMagicSkills().getDruidic() == 5
							|| StartNPC.character.getMagicSkills().getEarth() == 5
							|| StartNPC.character.getMagicSkills().getFire() == 5
							|| StartNPC.character.getMagicSkills().getWater() == 5
							|| StartNPC.character.getMagicSkills().getWind() == 5
							|| StartNPC.character.getMagicSkills().getWhite() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getMagicSkills().getFire() == 5) {
							maestro.add("Fuego");
						}
						if (StartNPC.character.getMagicSkills().getWater() == 5) {
							maestro.add("Agua");
						}
						if (StartNPC.character.getMagicSkills().getEarth() == 5) {
							maestro.add("Tierra");
						}
						if (StartNPC.character.getMagicSkills().getWind() == 5) {
							maestro.add("Viento");
						}
						if (StartNPC.character.getMagicSkills().getDruidic() == 5) {
							maestro.add("Druídica");
						}
						if (StartNPC.character.getMagicSkills().getWhite() == 5) {
							maestro.add("Blanca");
						}
						if (StartNPC.character.getMagicSkills().getBlack() == 5) {
							maestro.add("Negra");
						}
						if (StartNPC.character.getMagicSkills().getArcane() == 5) {
							maestro.add("Arcana");
						}
						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio5, "Seleccione opcion", "Erudito",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(4, "Archimago:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de magia.";
						txtpriv5.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de magia a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio5.setSelectedIndex(0);

					}
				}
				if (privilegio5.getSelectedIndex() == 18) {
					if (StartNPC.character.getKnowhowSkills().getAthletics() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getEquitation() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getStealth() == 5
							|| StartNPC.character.getKnowhowSkills()
									.getSurvival() == 5
							|| StartNPC.character.getKnowhowSkills().getTraps() == 5) {
						ArrayList<Object> maestro = new ArrayList<Object>();
						if (StartNPC.character.getKnowhowSkills()
								.getAthletics() == 5) {
							maestro.add("Atletismo");
						}
						if (StartNPC.character.getKnowhowSkills().getSurvival() == 5) {
							maestro.add("Supervivencia");
						}
						if (StartNPC.character.getKnowhowSkills().getTraps() == 5) {
							maestro.add("Trampas");
						}
						if (StartNPC.character.getKnowhowSkills()
								.getEquitation() == 5) {
							maestro.add("Equitación");
						}
						if (StartNPC.character.getKnowhowSkills().getStealth() == 5) {
							maestro.add("Sigilo");
						}

						Object[] maestros = maestro.toArray();
						Object seleccion = JOptionPane.showInputDialog(
								privilegio5, "Seleccione opcion", "Virtuoso",
								JOptionPane.PLAIN_MESSAGE, null, // null para
																	// icono
																	// defecto
								maestros, "opcion 1");
						priv.set(4, "Virtuoso:" + seleccion);

						String descrp = "+1 automático y acumulativo en una habilidad de destrezas.";
						txtpriv5.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Este privilegio precisa de al menos una habilidad de destrezas a nivel 5",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");

						privilegio5.setSelectedIndex(0);

					}

				}
				if (privilegio5.getSelectedIndex() == 19) {

					priv.set(4, "Berseker");

					String descrp = "El personaje se verá afectado de manera diferente a medida que pierde salud.";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 20) {

					priv.set(4, "Geiser Arcano");

					String descrp = "+10 Maná";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 21) {

					priv.set(4, "Enérgico");

					String descrp = "+10 Energía";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 22) {

					priv.set(4, "Hercúleo");

					String descrp = "+3 Fuerza";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 23) {

					priv.set(4, "Hábil");

					String descrp = "+3 Destreza";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 24) {

					priv.set(4, "Sólido");

					String descrp = "+3 Resistencia";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 25) {

					priv.set(4, "Anti-Magia");

					String descrp = "+3 Resistencia Mágica";
					txtpriv5.setText(descrp);
				}

				if (privilegio5.getSelectedIndex() == 26) {

					priv.set(4, "Gran Cerebro");

					String descrp = "+3 Inteligencia";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 27) {

					priv.set(4, "Ojo de Halcón");

					String descrp = "+3 Percepción";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 28) {

					priv.set(4, "Engatusador");

					String descrp = "+3 Carisma";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 29) {

					priv.set(4, "Artefacto Legendario");

					String descrp = "El personaje porta un artefacto legendario";
					txtpriv5.setText(descrp);
				}
				if (privilegio5.getSelectedIndex() == 30) {

					if (StartNPC.character.getMagicSkills().isUniversalista() == true) {
						priv.set(4, "Mago Universalista");

						String descrp = "El coste para subir habilidades mágicas se iguala al de combate.";
						txtpriv5.setText(descrp);
					} else {
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Necesitas dos habilidades mágicas a nivel 3 y 4 a nivel 2 para poder asignar este privilegio.",
										"¡Atención!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
										"opcion 1");
						privilegio5.setSelectedIndex(0);

					}
				}
				priv5 = privilegio5.getSelectedIndex();
			}
		});
		privilegio5.setFont(mf.MyFont(0, 11));
		privilegio5.setModel(new DefaultComboBoxModel(new String[] {
				"-Privilegio-", "Afinidad Arcana", "Torrente Arcano", "Duro",
				"Incansable", "Fornido", "Mente \u00E1gil", "Posesi\u00F3n",
				"Experto", "Maestro", "Noble ", "Curaci\u00F3n r\u00E1pida",
				"Talento", "Aliado", "Buena Estrella", "Maestro de Armas",
				"Erudito", "Archimago", "Virtuoso", "Berseker",
				"Geiser Arcano", "En\u00E9rgico", "Herc\u00FAleo",
				"H\u00E1bil", "S\u00F3lido", "Anti-Magia", "Gran Cerebro",
				"Ojo de Halc\u00F3n", "Engatusador", "Artefacto Legendario",
				"Mago Universalista" }));
		privilegio5.setBounds(20, 245, 149, 20);
		privilegio5.setSelectedIndex(priv5);

		frmHistoriasDeZagas.getContentPane().add(privilegio5);

		reves1.setBackground(Color.WHITE);
		reves1.setForeground(new Color(0, 0, 0));
		reves1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (reves1.getSelectedIndex() == 0 && res.size() > 0) {

					res.set(0, "");
					txtrev1.setText("");

				}
				if (reves1.getSelectedIndex() == 1) {

					res.set(0, "Inutilidad Arcana");

					String descrp = "+2 para cada nivel de magia.";
					txtrev1.setText(descrp);

				}
				if (reves1.getSelectedIndex() == 2) {

					res.set(0, "Debilidad Arcana");

					String descrp = "-5 maná.";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 3) {

					res.set(0, "Frágil");

					String descrp = "-3 vida.";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 4) {

					res.set(0, "Baja Forma");

					String descrp = "-5 energía.";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 5) {

					res.set(0, "Debilidad");

					String descrp = "Otorga penalización a armaduras ligeras y doble a armaduras pesadas.";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 6) {

					res.set(0, "Mente Lenta");

					String descrp = "El coste para subir conocimientos se duplica.";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 7) {

					res.set(0, "Aprendiz");

					String descrp = "Solo se permite subir a nivel 2 las habilidades.";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 8) {

					res.set(0, "Descastado");

					String descrp = "El personaje era de alta alcurnia y fue descastado y repudiado.";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 9) {

					res.set(0, "Curación Lenta");

					String descrp = "Curación de heridas x0.5 al descansar.";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 10) {

					res.set(0, "Inútil");

					String descrp = "-1 rango en combate contra oponentes con el mismo rango.";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 11) {

					res.set(0, "Enemigo");

					String descrp = "El personaje tiene un enemigo acérrimo.";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 12) {

					res.set(0, "Mala Estrella");

					String descrp = "La existencia del personaje es un propio pecado para los dioses. ";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 13) {

					res.set(0, "Buscado por la Ley");

					String descrp = "El personaje es un delincuente perseguido";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 14) {

					res.set(0, "Imposibilidad Arcana");

					String descrp = "-10 Maná";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 15) {

					res.set(0, "Enclenque");

					String descrp = "-3 Fuerza";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 16) {

					res.set(0, "Incompetente");

					String descrp = "-3 Destreza";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 17) {

					res.set(0, "Quebradizo");

					String descrp = "-3 Resistencia";
					txtrev1.setText(descrp);
				}

				if (reves1.getSelectedIndex() == 18) {

					res.set(0, "Perdición Arcana");

					String descrp = "-3 Resistencia Mágica";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 19) {

					res.set(0, "Estúpido");

					String descrp = "-3 Inteligencia";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 20) {

					res.set(0, "Ceguera");

					String descrp = "-3 Percepción";
					txtrev1.setText(descrp);
				}
				if (reves1.getSelectedIndex() == 21) {

					res.set(0, "Tímido");

					String descrp = "-3 Carisma";
					txtrev1.setText(descrp);
				}
				rev1 = reves1.getSelectedIndex();
			}
		});

		reves1.setModel(new DefaultComboBoxModel(new String[] { "-Rev\u00E9s-",
				"Inutilidad Arcana", "Debilidad Arcana", "Fr\u00E1gil",
				"Baja forma", "Debilidad", "Mente lenta", "Aprendiz",
				"Descastado ", "Curaci\u00F3n lenta", "In\u00FAtil", "Enemigo",
				"Mala Estrella", "Buscado por la Ley", "Imposibilidad Arcana",
				"Enclenque", "Incompetente", "Quebradizo",
				"Perdici\u00F3n Arcana", "Est\u00FApido", "Ceguera",
				"T\u00EDmido" }));
		reves1.setSelectedIndex(rev1);

		reves1.setFont(mf.MyFont(0, 11));
		reves1.setBounds(20, 307, 149, 20);
		frmHistoriasDeZagas.getContentPane().add(reves1);

		reves2.setForeground(new Color(0, 0, 0));
		reves2.setBackground(Color.WHITE);
		reves2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (reves2.getSelectedIndex() == 0 && res.size() > 1) {

					res.set(1, "");
					txtrev2.setText("");
				}
				if (reves2.getSelectedIndex() == 1) {

					res.set(1, "Inutilidad Arcana");

					String descrp = "+2 para cada nivel de magia.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 2) {

					res.set(1, "Debilidad Arcana");

					String descrp = "-5 maná.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 3) {

					res.set(1, "Frágil");

					String descrp = "-3 vida.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 4) {

					res.set(1, "Baja Forma");

					String descrp = "-5 energía.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 5) {

					res.set(1, "Debilidad");

					String descrp = "Otorga penalización a armaduras ligeras y doble a armaduras pesadas.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 6) {

					res.set(1, "Mente Lenta");

					String descrp = "El coste para subir conocimientos se duplica.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 7) {

					res.set(1, "Aprendiz");

					String descrp = "Solo se permite subir a nivel 2 las habilidades.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 8) {

					res.set(1, "Descastado");

					String descrp = "El personaje era de alta alcurnia y fue descastado y repudiado.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 9) {

					res.set(1, "Curación Lenta");

					String descrp = "Curación de heridas x0.5 al descansar.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 10) {

					res.set(1, "Inútil");

					String descrp = "-1 rango en combate contra oponentes con el mismo rango.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 11) {

					res.set(1, "Enemigo");

					String descrp = "El personaje tiene un enemigo acérrimo.";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 12) {

					res.set(1, "Mala Estrella");

					String descrp = "La existencia del personaje es un propio pecado para los dioses. ";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 13) {

					res.set(1, "Buscado por la Ley");

					String descrp = "El personaje es un delincuente perseguido";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 14) {

					res.set(1, "Imposibilidad Arcana");

					String descrp = "-10 Maná";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 15) {

					res.set(1, "Enclenque");

					String descrp = "-3 Fuerza";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 16) {

					res.set(1, "Incompetente");

					String descrp = "-3 Destreza";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 17) {

					res.set(1, "Quebradizo");

					String descrp = "-3 Resistencia";
					txtrev2.setText(descrp);
				}

				if (reves2.getSelectedIndex() == 18) {

					res.set(1, "Perdición Arcana");

					String descrp = "-3 Resistencia Mágica";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 19) {

					res.set(1, "Estúpido");

					String descrp = "-3 Inteligencia";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 20) {

					res.set(1, "Ceguera");

					String descrp = "-3 Percepción";
					txtrev2.setText(descrp);
				}
				if (reves2.getSelectedIndex() == 21) {

					res.set(1, "Tímido");

					String descrp = "-3 Carisma";
					txtrev2.setText(descrp);
				}

				rev2 = reves2.getSelectedIndex();
			}
		});

		reves2.setFont(mf.MyFont(0, 11));
		reves2.setModel(new DefaultComboBoxModel(new String[] { "-Rev\u00E9s-",
				"Inutilidad Arcana", "Debilidad Arcana", "Fr\u00E1gil",
				"Baja forma", "Debilidad", "Mente lenta", "Aprendiz",
				"Descastado ", "Curaci\u00F3n lenta", "In\u00FAtil", "Enemigo",
				"Mala Estrella", "Buscado por la Ley", "Imposibilidad Arcana",
				"Enclenque", "Incompetente", "Quebradizo",
				"Perdici\u00F3n Arcana", "Est\u00FApido", "Ceguera",
				"T\u00EDmido" }));
		reves2.setBounds(20, 338, 149, 20);
		reves2.setSelectedIndex(rev2);

		frmHistoriasDeZagas.getContentPane().add(reves2);

		reves3.setBackground(Color.WHITE);
		reves3.setForeground(new Color(0, 0, 0));
		reves3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (reves3.getSelectedIndex() == 0) {
					res.set(2, "");
					txtrev3.setText("");
				}
				if (reves3.getSelectedIndex() == 1) {

					res.set(2, "Inutilidad Arcana");

					String descrp = "+2 para cada nivel de magia.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 2) {

					res.set(2, "Debilidad Arcana");

					String descrp = "-5 maná.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 3) {

					res.set(2, "Frágil");

					String descrp = "-3 vida.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 4) {

					res.set(2, "Baja Forma");

					String descrp = "-5 energía.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 5) {

					res.set(2, "Debilidad");

					String descrp = "Otorga penalización a armaduras ligeras y doble a armaduras pesadas.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 6) {

					res.set(2, "Mente Lenta");

					String descrp = "El coste para subir conocimientos se duplica.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 7) {

					res.set(2, "Aprendiz");

					String descrp = "Solo se permite subir a nivel 2 las habilidades.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 8) {

					res.set(2, "Descastado");

					String descrp = "El personaje era de alta alcurnia y fue descastado y repudiado.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 9) {

					res.set(2, "Curación Lenta");

					String descrp = "Curación de heridas x0.5 al descansar.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 10) {

					res.set(2, "Inútil");

					String descrp = "-1 rango en combate contra oponentes con el mismo rango.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 11) {

					res.set(2, "Enemigo");

					String descrp = "El personaje tiene un enemigo acérrimo.";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 12) {

					res.set(2, "Mala Estrella");

					String descrp = "La existencia del personaje es un propio pecado para los dioses. ";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 13) {

					res.set(2, "Buscado por la Ley");

					String descrp = "El personaje es un delincuente perseguido";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 14) {

					res.set(2, "Imposibilidad Arcana");

					String descrp = "-10 Maná";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 15) {

					res.set(2, "Enclenque");

					String descrp = "-3 Fuerza";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 16) {

					res.set(2, "Incompetente");

					String descrp = "-3 Destreza";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 17) {

					res.set(2, "Quebradizo");

					String descrp = "-3 Resistencia";
					txtrev3.setText(descrp);
				}

				if (reves3.getSelectedIndex() == 18) {

					res.set(2, "Perdición Arcana");

					String descrp = "-3 Resistencia Mágica";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 19) {

					res.set(2, "Estúpido");

					String descrp = "-3 Inteligencia";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 20) {

					res.set(2, "Ceguera");

					String descrp = "-3 Percepción";
					txtrev3.setText(descrp);
				}
				if (reves3.getSelectedIndex() == 21) {

					res.set(2, "Tímido");

					String descrp = "-3 Carisma";
					txtrev3.setText(descrp);
				}

				rev3 = reves3.getSelectedIndex();
			}
		});
		reves3.setModel(new DefaultComboBoxModel(new String[] { "-Rev\u00E9s-",
				"Inutilidad Arcana", "Debilidad Arcana", "Fr\u00E1gil",
				"Baja forma", "Debilidad", "Mente lenta", "Aprendiz",
				"Descastado ", "Curaci\u00F3n lenta", "In\u00FAtil", "Enemigo",
				"Mala Estrella", "Buscado por la Ley", "Imposibilidad Arcana",
				"Enclenque", "Incompetente", "Quebradizo",
				"Perdici\u00F3n Arcana", "Est\u00FApido", "Ceguera",
				"T\u00EDmido" }));
		reves3.setFont(mf.MyFont(0, 11));
		reves3.setSelectedIndex(rev3);

		reves3.setBounds(20, 369, 149, 20);
		frmHistoriasDeZagas.getContentPane().add(reves3);

		reves4.setForeground(new Color(0, 0, 0));
		reves4.setBackground(Color.WHITE);
		reves4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (reves4.getSelectedIndex() == 0) {

					res.set(3, "");
					txtrev4.setText("");

				}
				if (reves4.getSelectedIndex() == 1) {

					res.set(3, "Inutilidad Arcana");

					String descrp = "+2 para cada nivel de magia.";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 2) {

					res.set(3, "Debilidad Arcana");

					String descrp = "-5 maná.";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 3) {

					res.set(3, "Frágil");

					String descrp = "-3 vida.";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 4) {

					res.set(3, "Baja Forma");

					String descrp = "-5 energía.";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 5) {

					res.set(3, "Debilidad");

					String descrp = "Otorga penalización a armaduras ligeras y doble a armaduras pesadas.";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 6) {

					res.set(3, "Mente Lenta");

					String descrp = "El coste para subir conocimientos se duplica.";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 7) {

					res.set(3, "Aprendiz");

					String descrp = "Solo se permite subir a nivel 2 las habilidades.";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 8) {

					res.set(3, "Descastado");

					String descrp = "El personaje era de alta alcurnia y fue descastado y repudiado.";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 9) {

					res.set(3, "Curación Lenta");

					String descrp = "Curación de heridas x0.5 al descansar.";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 10) {

					res.set(3, "Inútil");

					String descrp = "-1 rango en combate contra oponentes con el mismo rango.";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 11) {

					res.set(3, "Enemigo");

					String descrp = "El personaje tiene un enemigo acérrimo.";
					txtrev4.setText(descrp);
				}

				if (reves4.getSelectedIndex() == 12) {

					res.set(3, "Mala Estrella");

					String descrp = "La existencia del personaje es un propio pecado para los dioses. ";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 13) {

					res.set(3, "Buscado por la Ley");

					String descrp = "El personaje es un delincuente perseguido";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 14) {

					res.set(3, "Imposibilidad Arcana");

					String descrp = "-10 Maná";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 15) {

					res.set(3, "Enclenque");

					String descrp = "-3 Fuerza";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 16) {

					res.set(3, "Incompetente");

					String descrp = "-3 Destreza";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 17) {

					res.set(3, "Quebradizo");

					String descrp = "-3 Resistencia";
					txtrev4.setText(descrp);
				}

				if (reves4.getSelectedIndex() == 18) {

					res.set(3, "Perdición Arcana");

					String descrp = "-3 Resistencia Mágica";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 19) {

					res.set(3, "Estúpido");

					String descrp = "-3 Inteligencia";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 20) {

					res.set(3, "Ceguera");

					String descrp = "-3 Percepción";
					txtrev4.setText(descrp);
				}
				if (reves4.getSelectedIndex() == 21) {

					res.set(3, "Tímido");

					String descrp = "-3 Carisma";
					txtrev4.setText(descrp);
				}
				rev4 = reves4.getSelectedIndex();
			}
		});
		reves4.setFont(mf.MyFont(0, 11));
		reves4.setModel(new DefaultComboBoxModel(new String[] { "-Rev\u00E9s-",
				"Inutilidad Arcana", "Debilidad Arcana", "Fr\u00E1gil",
				"Baja forma", "Debilidad", "Mente lenta", "Aprendiz",
				"Descastado ", "Curaci\u00F3n lenta", "In\u00FAtil", "Enemigo",
				"Mala Estrella", "Buscado por la Ley", "Imposibilidad Arcana",
				"Enclenque", "Incompetente", "Quebradizo",
				"Perdici\u00F3n Arcana", "Est\u00FApido", "Ceguera",
				"T\u00EDmido" }));
		reves4.setBounds(20, 400, 149, 20);
		reves4.setSelectedIndex(rev4);

		frmHistoriasDeZagas.getContentPane().add(reves4);

		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/boton continuar2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/boton continuar.png")));
			}
		});
		btnContinuar.setIcon(new ImageIcon(PrivilegiosNPC.class
				.getResource("/images/boton continuar.png")));
		btnContinuar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnContinuar.setBackground(new Color(139, 69, 19));
		btnContinuar.setForeground(new Color(255, 255, 255));
		btnContinuar.setBorderPainted(false);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setFocusPainted(false);
		btnContinuar.setOpaque(false);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Privileges privilegio = new Privileges();
				Setbacks reves = new Setbacks();
				int contador = 0;
				int error = 0;
				posesiones = 0;
				legendario = 0;
				int privpos = 0;
				int privleg = 0;

				for (int i = 0; i < priv.size(); i++) {
					if (priv.get(i).equals("Posesión")) {
						privpos = privpos + 1;
					}
				}
				
				for (int i = 0; i < priv.size(); i++) {
					if (priv.get(i).equals("Artefacto Legendario")) {
						privleg = privleg + 1;
					}
				}

				if (EquipoNPC.weapon1.isPosesion()) {

					posesiones = posesiones + 1;
				}

				if (EquipoNPC.weapon2.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.weapon3.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.weapon4.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.armor1.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.accesories1.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.accesories2.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.accesories3.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.accesories4.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.misc1.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.misc2.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.misc3.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.misc4.isPosesion()) {

					posesiones = posesiones + 1;
				}
				if (EquipoNPC.weapon1.isLegendaria()) {

					legendario = legendario + 1;
				}

				if (EquipoNPC.weapon2.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.weapon3.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.weapon4.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.armor1.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.accesories1.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.accesories2.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.accesories3.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.accesories4.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.misc1.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.misc2.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.misc3.isLegendaria()) {

					legendario = legendario + 1;
				}
				if (EquipoNPC.misc4.isLegendaria()) {

					legendario = legendario + 1;
				}

				if (privpos < posesiones) {
					error += 1;
					JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"Tienes "
											+ posesiones
											+ " posesión(es) ,por lo que necesitas al menos ese número de privilegios 'Posesion'",
									"Error!", JOptionPane.ERROR_MESSAGE);

				}
				if (privleg < legendario) {
					error += 1;
					JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"Tienes "
											+ legendario
											+ " artefacto(s) legendario(s) ,por lo que necesitas al menos ese número de privilegios 'Artefacto Legendario'",
									"Error!", JOptionPane.ERROR_MESSAGE);

				}

				
				if (StartNPC.character.getCombatSkills().getOneHanded() == 4
						|| StartNPC.character.getCombatSkills().getTwoHanded() == 4
						|| StartNPC.character.getCombatSkills().getPole() == 4
						|| StartNPC.character.getCombatSkills().getRanged() == 4
						|| StartNPC.character.getCombatSkills().getDodge() == 4
						|| StartNPC.character.getCombatSkills().getBlock() == 4
						|| StartNPC.character.getKnowledgeSkills()
								.getArtofWar() == 4
						|| StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() == 4
						|| StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() == 4
						|| StartNPC.character.getKnowledgeSkills()
								.getEtiquette() == 4
						|| StartNPC.character.getKnowledgeSkills()
								.getMedicine() == 4
						|| StartNPC.character.getKnowledgeSkills()
								.getNegotiation() == 4
						|| StartNPC.character.getKnowledgeSkills()
								.getOccultism() == 4
						|| StartNPC.character.getKnowledgeSkills()
								.getResearch() == 4
						|| StartNPC.character.getKnowledgeSkills()
								.getSecretKnowledge() == 4
						|| StartNPC.character.getKnowhowSkills().getAthletics() == 4
						|| StartNPC.character.getKnowhowSkills()
								.getEquitation() == 4
						|| StartNPC.character.getKnowhowSkills().getStealth() == 4
						|| StartNPC.character.getKnowhowSkills().getSurvival() == 4
						|| StartNPC.character.getKnowhowSkills().getTraps() == 4
						|| StartNPC.character.getMagicSkills().getArcane() == 4
						|| StartNPC.character.getMagicSkills().getBlack() == 4
						|| StartNPC.character.getMagicSkills().getDruidic() == 4
						|| StartNPC.character.getMagicSkills().getEarth() == 4
						|| StartNPC.character.getMagicSkills().getFire() == 4
						|| StartNPC.character.getMagicSkills().getWater() == 4
						|| StartNPC.character.getMagicSkills().getWhite() == 4
						|| StartNPC.character.getMagicSkills().getWind() == 4) {

					for (int i = 0; i < priv.size(); i++) {
						if (priv.get(i).equals("Experto")) {
							contador = contador + 1;
						}
					}
					if (contador != 0) {
					} else {
						JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"Tienes habilidades a nivel 4 por lo que no puedes avanzar sin el privilegio Experto.",
										"", JOptionPane.ERROR_MESSAGE);
						error += 1;

					}

				}

				if (StartNPC.character.getCombatSkills().getOneHanded() == 5
						|| StartNPC.character.getCombatSkills().getTwoHanded() == 5
						|| StartNPC.character.getCombatSkills().getPole() == 5
						|| StartNPC.character.getCombatSkills().getRanged() == 5
						|| StartNPC.character.getCombatSkills().getDodge() == 5
						|| StartNPC.character.getCombatSkills().getBlock() == 5
						|| StartNPC.character.getKnowledgeSkills()
								.getArtofWar() == 5
						|| StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() == 5
						|| StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() == 5
						|| StartNPC.character.getKnowledgeSkills()
								.getEtiquette() == 5
						|| StartNPC.character.getKnowledgeSkills()
								.getMedicine() == 5
						|| StartNPC.character.getKnowledgeSkills()
								.getNegotiation() == 5
						|| StartNPC.character.getKnowledgeSkills()
								.getOccultism() == 5
						|| StartNPC.character.getKnowledgeSkills()
								.getResearch() == 5
						|| StartNPC.character.getKnowledgeSkills()
								.getSecretKnowledge() == 5
						|| StartNPC.character.getKnowhowSkills().getAthletics() == 5
						|| StartNPC.character.getKnowhowSkills()
								.getEquitation() == 5
						|| StartNPC.character.getKnowhowSkills().getStealth() == 5
						|| StartNPC.character.getKnowhowSkills().getSurvival() == 5
						|| StartNPC.character.getKnowhowSkills().getTraps() == 5
						|| StartNPC.character.getMagicSkills().getArcane() == 5
						|| StartNPC.character.getMagicSkills().getBlack() == 5
						|| StartNPC.character.getMagicSkills().getDruidic() == 5
						|| StartNPC.character.getMagicSkills().getEarth() == 5
						|| StartNPC.character.getMagicSkills().getFire() == 5
						|| StartNPC.character.getMagicSkills().getWater() == 5
						|| StartNPC.character.getMagicSkills().getWhite() == 5
						|| StartNPC.character.getMagicSkills().getWind() == 5) {

					for (int i = 0; i < priv.size(); i++) {
						if (priv.get(i).equals("Experto")) {
							for (int j = 0; j < priv.size(); j++) {

								if (priv.get(j).equals("Maestro")) {
									contador = contador + 1;
								}

							}
						}
					}
					if (contador != 0) {
					} else {
						JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"Tienes habilidades a nivel 5 por lo que no puedes avanzar sin los privilegios Experto y Maestro.",
										"", JOptionPane.ERROR_MESSAGE);
						error += 1;

					}

				}

				if (StartNPC.character.getCombatSkills().getOneHanded() > 2
						|| StartNPC.character.getCombatSkills().getTwoHanded() > 2
						|| StartNPC.character.getCombatSkills().getPole() > 2
						|| StartNPC.character.getCombatSkills().getRanged() > 2
						|| StartNPC.character.getCombatSkills().getDodge() > 2
						|| StartNPC.character.getCombatSkills().getBlock() > 2
						|| StartNPC.character.getKnowledgeSkills()
								.getArtofWar() > 2
						|| StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() > 2
						|| StartNPC.character.getKnowledgeSkills()
								.getDiplomacy() > 2
						|| StartNPC.character.getKnowledgeSkills()
								.getEtiquette() > 2
						|| StartNPC.character.getKnowledgeSkills()
								.getMedicine() > 2
						|| StartNPC.character.getKnowledgeSkills()
								.getNegotiation() > 2
						|| StartNPC.character.getKnowledgeSkills()
								.getOccultism() > 2
						|| StartNPC.character.getKnowledgeSkills()
								.getResearch() > 2
						|| StartNPC.character.getKnowledgeSkills()
								.getSecretKnowledge() > 2
						|| StartNPC.character.getKnowhowSkills().getAthletics() > 2
						|| StartNPC.character.getKnowhowSkills()
								.getEquitation() > 2
						|| StartNPC.character.getKnowhowSkills().getStealth() > 2
						|| StartNPC.character.getKnowhowSkills().getSurvival() > 2
						|| StartNPC.character.getKnowhowSkills().getTraps() > 2
						|| StartNPC.character.getMagicSkills().getArcane() > 2
						|| StartNPC.character.getMagicSkills().getBlack() > 2
						|| StartNPC.character.getMagicSkills().getDruidic() > 2
						|| StartNPC.character.getMagicSkills().getEarth() > 2
						|| StartNPC.character.getMagicSkills().getFire() > 2
						|| StartNPC.character.getMagicSkills().getWater() > 2
						|| StartNPC.character.getMagicSkills().getWhite() > 2
						|| StartNPC.character.getMagicSkills().getWind() > 2) {
					int cont = 0;
					for (int i = 0; i < res.size(); i++) {
						if (res.get(i).equals("Aprendiz")) {
							cont = cont + 1;
						}
					}
					if (cont == 0) {
					} else {
						JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"Tienes habilidades a nivel 3 o superior por lo que no puedes avanzar sin quitarte el reves Aprendiz.",
										"", JOptionPane.ERROR_MESSAGE);
						error += 1;

					}

				}

				for (int i = 0; i < priv.size(); i++) {

					StartNPC.character.getPrivileges().getPrivilegio()
							.add(i, priv.get(i));

				}
				for (int i = 0; i < res.size(); i++) {

					StartNPC.character.getSetbacks().getReves()
							.add(i, res.get(i));

				}
				if (error == 0) {
					try {
						StartNPC.character.getPrivileges().CalculoPrivilegios(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						StartNPC.character.getSetbacks().CalculoReveses(
								StartNPC.character);
					} catch (AtributeOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					StartNPC.contadorPosesion = StartNPC.character
							.getPrivileges().ContarPosesiones() - posesiones;
					StartNPC.contadorLegendario = StartNPC.character
							.getPrivileges().ContarLegendario() - legendario;

					frmHistoriasDeZagas.dispose();
					AtributosNPC window = new AtributosNPC();
					window.getFrame().setVisible(true);
				}

			}
		});
		btnContinuar.setFont(mf.MyFont(0, 12));
		btnContinuar.setBounds(435, 447, 99, 46);
		frmHistoriasDeZagas.getContentPane().add(btnContinuar);

		final JButton btnAtras = new JButton("");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/boton atras2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/boton atras.png")));
			}
		});
		btnAtras.setIcon(new ImageIcon(PrivilegiosNPC.class
				.getResource("/images/boton atras.png")));
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAtras.setBackground(new Color(139, 69, 19));
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setFocusPainted(false);
		btnAtras.setOpaque(false);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean contador = true;
				try {
					StartNPC.character.getBlessing().calculoExtrasInv(
							StartNPC.character);

					if (StartNPC.character.isCampeon() == true) {

						if (StartNPC.character.getBlessing().getBlessing()
								.equals("Arcanista de Sylendyl")) {

							int seleccion = JOptionPane
									.showOptionDialog(
											frmHistoriasDeZagas,
											"El personaje es campeón de Sylendyl, si vuelves atras se reiniciarán las habilidades mágicas.",
											"¡Atención!",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.PLAIN_MESSAGE, null,
											new Object[] { "Aceptar",
													"Cancelar" }, // null
																	// para
																	// YES,
																	// NO y
																	// CANCEL
											"opcion 1");
							if (JOptionPane.YES_OPTION == seleccion) {

								StartNPC.character.getBlessing()
										.calculoCampeonInv(StartNPC.character);
							} else {

								contador = false;
							}

						}

						else {
							StartNPC.character.getBlessing().calculoCampeonInv(
									StartNPC.character);
						}
					}
				} catch (SkillOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (contador == true) {
					frmHistoriasDeZagas.dispose();
					BendicionesNPC window = new BendicionesNPC();
					window.getFrame().setVisible(true);
				}
			}
		});
		btnAtras.setFont(mf.MyFont(0, 12));
		btnAtras.setBounds(45, 447, 99, 46);
		frmHistoriasDeZagas.getContentPane().add(btnAtras);

		final JButton btnInfo = new JButton("Ayuda");
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnInfo.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/botones-inicio-ayuda2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				btnInfo.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AyudaPrivilegios window = new AyudaPrivilegios();
				window.getFrame().setVisible(true);
			}
		});
		btnInfo.setIcon(new ImageIcon(PrivilegiosNPC.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnInfo.setOpaque(false);
		btnInfo.setForeground(Color.WHITE);
		btnInfo.setFont(mf.MyFont(0, 15));
		btnInfo.setFocusPainted(false);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setBorderPainted(false);
		btnInfo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		btnInfo.setBackground(new Color(139, 69, 19));
		btnInfo.setBounds(299, 453, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnInfo);

		final JButton btnInicio = new JButton("Inicio");
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnInicio.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/botones-inicio-ayuda2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				btnInicio.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

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
					EquipoNPC.weapon1 = new Weapons("", "", false, false,
							EquipoNPC.posss,"");
					EquipoNPC.weapon2 = new Weapons("", "", false, false,
							EquipoNPC.posss,"");
					EquipoNPC.weapon3 = new Weapons("", "", false, false,
							EquipoNPC.posss,"");
					EquipoNPC.weapon4 = new Weapons("", "", false, false,
							EquipoNPC.posss,"");
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
		btnInicio.setIcon(new ImageIcon(PrivilegiosNPC.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnInicio.setOpaque(false);
		btnInicio.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(mf.MyFont(0, 15));
		btnInicio.setFocusPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null,

				null));
		btnInicio.setBackground(new Color(139, 69, 19));
		btnInicio.setBounds(161, 453, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnInicio);

		JLabel lblPrivRev = new JLabel("Privilegios y Reveses");
		lblPrivRev.setFont(mf.MyFont(1, 36));
		lblPrivRev.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrivRev.setForeground(Color.WHITE);
		lblPrivRev.setBounds(10, 11, 558, 68);
		frmHistoriasDeZagas.getContentPane().add(lblPrivRev);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PrivilegiosNPC.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 578, 504);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);

	}
}
