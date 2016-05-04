package es.thesinsprods.zagastales.juegozagas.creadornpcs;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

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
import es.thesinsprods.zagastales.characters.privileges.Privileges;
import es.thesinsprods.zagastales.characters.privileges.Setbacks;
import es.thesinsprods.zagastales.characters.race.Race;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.KnowHowSkills;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.SkillPoints;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaStart;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Atributos;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Bendiciones;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Combate;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Conocimientos;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Destrezas;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Equipo;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Magia;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Privilegios;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Start;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import java.awt.Toolkit;
import java.awt.Color;
import java.util.ArrayList;
import java.io.IOException;

import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartNPC {

	private JFrame frmHistoriasDeZagas;
	private JLabel LblNombre;
	private JLabel LblEdad;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JLabel LblRaza;
	private JScrollPane scrollPaneDescRaza;
	public static Characters character;
	public static Atributes atributos;
	public static CombatSkills combatSkills;
	public static KnowledgeSkills knowledgeSkills;
	public static MagicSkills magicSkills;
	public static KnowHowSkills knowhowSkills;
	public static AtributePoints atrpoints;
	public static SkillPoints skpoints;
	public static int contadorBEktra;
	public static int contadorPosesion;
	public static int contadorLegendario;
	public static String nombre = "";
	public static int edad = 0;
	public static int raza = 0;
	public static String descrpF;
	public static String ektraapp;
	public static String razaAnt="";
	public static ArrayList<String> pos1 = new ArrayList<String>();
	MorpheusFont mf = new MorpheusFont();
	private JButton btnVolver;
	private JLabel txtDescripcinFsica;
	private JButton btnAyuda;
	private JLabel lblAspectosGenerales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartNPC window = new StartNPC();
					window.frmHistoriasDeZagas.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public StartNPC() throws IOException {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {

		contadorPosesion = 0;
		contadorBEktra = 0;

		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.getContentPane().setBackground(
				new Color(205, 133, 63));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setBounds(100, 100, 584, 532);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHistoriasDeZagas.setResizable(false);

		frmHistoriasDeZagas.getContentPane().setLayout(null);
		scrollPaneDescRaza = new JScrollPane();
		scrollPaneDescRaza.setBounds(285, 96, 276, 324);
		frmHistoriasDeZagas.getContentPane().add(scrollPaneDescRaza);

		final JTextArea RazaDescrp = new JTextArea();
		RazaDescrp.setSelectionColor(UIManager.getColor("textHighlight"));
		RazaDescrp.setBackground(Color.WHITE);
		RazaDescrp.setForeground(new Color(0, 0, 0));
		RazaDescrp.setFont(mf.MyFont(0, 13));
		RazaDescrp.setLineWrap(true);
		RazaDescrp.setWrapStyleWord(true);
		scrollPaneDescRaza.setViewportView(RazaDescrp);
		RazaDescrp.setEditable(false);

		LblNombre = new JLabel();
		LblNombre.setForeground(Color.WHITE);
		LblNombre.setOpaque(false);
		LblNombre.setBackground(new Color(255, 255, 255));
		LblNombre.setBorder(null);
		LblNombre.setFont(mf.MyFont(0, 13));
		LblNombre.setText("Nombre:");
		LblNombre.setBounds(10, 91, 64, 27);
		frmHistoriasDeZagas.getContentPane().add(LblNombre);

		LblEdad = new JLabel();
		LblEdad.setForeground(Color.WHITE);
		LblEdad.setOpaque(false);
		LblEdad.setBackground(new Color(255, 255, 255));
		LblEdad.setText("Edad:");
		LblEdad.setFont(mf.MyFont(0, 13));
		LblEdad.setBorder(null);
		LblEdad.setBounds(10, 130, 50, 27);
		frmHistoriasDeZagas.getContentPane().add(LblEdad);

		txtNombre = new JTextField();
		final JButton btnContinuar = new JButton("");
		final JComboBox<String> cmbxRaza = new JComboBox<String>();
		cmbxRaza.setMaximumRowCount(10);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtNombre.getText().length() != 0
						&& txtEdad.getText().length() != 0
						&& cmbxRaza.getSelectedIndex() != 0) {

					btnContinuar.setEnabled(true);

				}
				if (txtNombre.getText().length() == 0
						|| txtEdad.getText().length() == 0
						|| cmbxRaza.getSelectedIndex() == 0) {

					btnContinuar.setEnabled(false);

				}
			}
		});
		txtNombre.setSelectionColor(UIManager.getColor("textHighlight"));
		txtNombre.setForeground(new Color(0, 0, 0));
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setText(nombre);
		txtNombre.setFont(mf.MyFont(0, 13));
		txtNombre.setBounds(70, 96, 164, 20);
		frmHistoriasDeZagas.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtNombre.getText().length() != 0
						&& txtEdad.getText().length() != 0
						&& cmbxRaza.getSelectedIndex() != 0) {

					btnContinuar.setEnabled(true);

				}
				if (txtNombre.getText().length() == 0
						|| txtEdad.getText().length() == 0
						|| cmbxRaza.getSelectedIndex() == 0) {

					btnContinuar.setEnabled(false);

				}

			}
		});
		txtEdad.setSelectionColor(UIManager.getColor("textHighlight"));
		txtEdad.setForeground(new Color(0, 0, 0));
		txtEdad.setBackground(Color.WHITE);
		if (edad == 0) {
			txtEdad.setText("");
		} else {
			txtEdad.setText("" + edad);
		}
		txtEdad.setFont(mf.MyFont(0, 13));
		txtEdad.setBounds(70, 135, 50, 20);
		frmHistoriasDeZagas.getContentPane().add(txtEdad);
		txtEdad.setColumns(10);

		cmbxRaza.setForeground(new Color(0, 0, 0));
		cmbxRaza.setBackground(Color.WHITE);

		cmbxRaza.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (cmbxRaza.getSelectedIndex() == 0) {
					RazaDescrp.setText(null);
					Race race = new Race("");
					character.setRace(race);
					if (txtNombre.getText().length() != 0
							&& txtEdad.getText().length() != 0
							&& cmbxRaza.getSelectedIndex() != 0) {

						btnContinuar.setEnabled(true);

					}
					if (txtNombre.getText().length() == 0
							|| txtEdad.getText().length() == 0
							|| cmbxRaza.getSelectedIndex() == 0) {

						btnContinuar.setEnabled(false);

					}

				}
				if (cmbxRaza.getSelectedIndex() == 1) {
					Race race = new Race("Alto Elfo");
					if (PrivilegiosNPC.priv1 == 1 || PrivilegiosNPC.priv2 == 1
							|| PrivilegiosNPC.priv3 == 1
							|| PrivilegiosNPC.priv4 == 1) {
						character.getRace().setRace("");
						JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"Eres un alto elfo, la afinindad arcana es innata en ti",
										"", JOptionPane.ERROR_MESSAGE);
						cmbxRaza.setSelectedIndex(0);
					} else {
						character.setRace(race);
						if (character.getRace().equals(race)) {
							String descr = "Creados por Sylendyl, el cual les otorgó su longevidad y su habilidad para manejar las artes arcanas. Se consideran la raza más noble sobre todo Zagas y realmente lo son, lamentablemente debido a esto son arrogantes y terriblemente racistas.\n"
									+ "\nSi eliges un Alto Elfo, el personaje tendrá una mayor facilidad para subir tus destrezas mágicas(-2 para subir de nivel cualquier magia)";
							RazaDescrp.setText(descr);
							if (txtNombre.getText().length() != 0
									&& txtEdad.getText().length() != 0
									&& cmbxRaza.getSelectedIndex() != 0) {

								btnContinuar.setEnabled(true);

							}
							if (txtNombre.getText().length() == 0
									|| txtEdad.getText().length() == 0
									|| cmbxRaza.getSelectedIndex() == 0) {

								btnContinuar.setEnabled(false);

							}
						}

					}

				}
				if (cmbxRaza.getSelectedIndex() == 2) {
					Race race = new Race("Elfo Silvano");
					character.setRace(race);
					if (character.getRace().equals(race)) {
						String descr = "Creados por Yamirem, al igual que Sylendyl con los altos elfos, ella otorgó a sus creaciones su longevidad y les inculcó desde el momento de su nacimiento cómo proteger la naturaleza, enseñándolos a vivir en armonía con ella y jurándoles que si nunca le fallaban a la naturaleza, ella nunca les fallaría.\n \nSi elijes un elfo silvano, el personaje gozará de sus grandes sentidos y su agilidad natural.(+1 destreza y +1 percepción)";
						RazaDescrp.setText(descr);
						if (txtNombre.getText().length() != 0
								&& txtEdad.getText().length() != 0
								&& cmbxRaza.getSelectedIndex() != 0) {

							btnContinuar.setEnabled(true);

						}
						if (txtNombre.getText().length() == 0
								|| txtEdad.getText().length() == 0
								|| cmbxRaza.getSelectedIndex() == 0) {

							btnContinuar.setEnabled(false);

						}
					}

				}
				if (cmbxRaza.getSelectedIndex() == 3) {
					Race race = new Race("Elfo Oscuro");
					character.setRace(race);
					if (character.getRace().equals(race)) {
						String descr = "Se dice de ellos que fueron una creación conjunta entre Sylendyl y Yanirem, pero fueron tentados por las criaturas de Tarterus para obtener los dones del sigilo y las artes arcanas prohibidas, por lo que abandonaron a sus padres. Esta traición no quedo impune, Sylendyl borro todo rastro de luz en su cuerpo, volviendo su tez completamente negra mientras que Yamirem les prohibió disfrutar de los dones de la naturaleza, desterrándolos a Tasartis, las profundas cavernas que recorren las profundidades del mundo.\n \nSi elijes un elfo oscuro, gracias a la traición de sus antepasados, el personaje tendrá una habilidad innata para el sigilo.(+2 sigilo) así como el don de la visión en la oscuridad";
						RazaDescrp.setText(descr);
						if (txtNombre.getText().length() != 0
								&& txtEdad.getText().length() != 0
								&& cmbxRaza.getSelectedIndex() != 0) {

							btnContinuar.setEnabled(true);

						}
						if (txtNombre.getText().length() == 0
								|| txtEdad.getText().length() == 0
								|| cmbxRaza.getSelectedIndex() == 0) {

							btnContinuar.setEnabled(false);

						}
					}

				}

				if (cmbxRaza.getSelectedIndex() == 4) {
					Race race = new Race("Enano");
					character.setRace(race);
					if (character.getRace().equals(race)) {
						String descr = "Ariscos, tozudos y trabajadores, así son los seres creados por Gralnach, ellos conocen todos los secretos de la tierra y sus minerales y poseen la misma resistencia que las mismas rocas que trabajan.\n \nSi elijes un enano, el personaje obtendrá su gran resistencia, tanto física como mágica.(+1 resistencia y +1 resistencia mágica)";

						RazaDescrp.setText(descr);
						if (txtNombre.getText().length() != 0
								&& txtEdad.getText().length() != 0
								&& cmbxRaza.getSelectedIndex() != 0) {

							btnContinuar.setEnabled(true);

						}
						if (txtNombre.getText().length() == 0
								|| txtEdad.getText().length() == 0
								|| cmbxRaza.getSelectedIndex() == 0) {

							btnContinuar.setEnabled(false);

						}
					}

				}
				if (cmbxRaza.getSelectedIndex() == 5) {
					Race race = new Race("Gnomo");
					character.setRace(race);
					if (character.getRace().equals(race)) {
						String descr = "Pequeñas criaturas ávidas de conocimiento y con su personalidad reflejada perfectamente en un refrán popular: “La curiosidad mató al gnomo”. Por suerte para ellos, son hijos de Bodvar y eso les facilita mucho la obtención de conocimientos.\n \nSi elijes un gnomo, el personaje gozará de una buena base de conocimientos secretos.(+2 conocimientos secretos)";
						RazaDescrp.setText(descr);
						if (txtNombre.getText().length() != 0
								&& txtEdad.getText().length() != 0
								&& cmbxRaza.getSelectedIndex() != 0) {

							btnContinuar.setEnabled(true);

						}
						if (txtNombre.getText().length() == 0
								|| txtEdad.getText().length() == 0
								|| cmbxRaza.getSelectedIndex() == 0) {

							btnContinuar.setEnabled(false);

						}
					}

				}
				if (cmbxRaza.getSelectedIndex() == 6) {
					Race race = new Race("Orco");
					character.setRace(race);
					if (character.getRace().equals(race)) {
						String descr = "Salvajes, indisciplinados, fisicamente perfectos y, por suerte para el resto de razas, no muy inteligentes. Así son los hijos de Éktra, y como hijos de la diosa de la guerra se dice que solo viven para matar y saquear, si bien parece verdad también se han registrado casos de orcos pacíficos.\n \nSi elijes un orco, su gran fuerza física y su capacidad para la guerra se verá reflejada en el personaje.(+1 fuerza y +1 arte de la guerra)";
						RazaDescrp.setText(descr);
						if (txtNombre.getText().length() != 0
								&& txtEdad.getText().length() != 0
								&& cmbxRaza.getSelectedIndex() != 0) {

							btnContinuar.setEnabled(true);

						}
						if (txtNombre.getText().length() == 0
								|| txtEdad.getText().length() == 0
								|| cmbxRaza.getSelectedIndex() == 0) {

							btnContinuar.setEnabled(false);

						}
					}

				}
				if (cmbxRaza.getSelectedIndex() == 7) {
					Race race = new Race("Humano");
					character.setRace(race);
					if (character.getRace().equals(race)) {
						String descr = "Miembros de la mayor población de Zagas, de naturaleza luchadora y gran capacidad de adaptación, portan el estigma de ser los hijos de Tenerus, algo que hace que las otras razas no acaben de confiar en ellos. Pese a no destacar en nada de forma natural, son capaces de grandes cosas si se lo proponen.\n \nSi eliges un humano el personaje se verá influenciado por su gran capacidad de adaptación y su instinto de supervivencia.(+2 supervivencia)";
						RazaDescrp.setText(descr);
						if (txtNombre.getText().length() != 0
								&& txtEdad.getText().length() != 0
								&& cmbxRaza.getSelectedIndex() != 0) {

							btnContinuar.setEnabled(true);

						}
						if (txtNombre.getText().length() == 0
								|| txtEdad.getText().length() == 0
								|| cmbxRaza.getSelectedIndex() == 0) {

							btnContinuar.setEnabled(false);

						}
					}

				}
				if (cmbxRaza.getSelectedIndex() == 8) {
					Race race = new Race("Naga");
					character.setRace(race);
					if (character.getRace().equals(race)) {
						String descr = "Seres acuáticos mitológicos, de aspecto humanoide con la parte inferior de su cuerpo como la cola de un reptil que han abierto sus fronteras a el resto de civilizaciones tras milenios de silencio.\n \nSi elijes uno de los misteriosos hijos de Sérpos el personaje se verá beneficiado por sus duras escamas y por su afinidad natural con la magia de agua (+1 Resistencia y +1 Magia de Agua)";
						RazaDescrp.setText(descr);
						if (txtNombre.getText().length() != 0
								&& txtEdad.getText().length() != 0
								&& cmbxRaza.getSelectedIndex() != 0) {

							btnContinuar.setEnabled(true);

						}
						if (txtNombre.getText().length() == 0
								|| txtEdad.getText().length() == 0
								|| cmbxRaza.getSelectedIndex() == 0) {

							btnContinuar.setEnabled(false);

						}
					}

				}
				if (cmbxRaza.getSelectedIndex() == 9) {
					Race race = new Race("Addar Meddwl");
					character.setRace(race);
					if (character.getRace().equals(race)) {
						String descr = "Pérfidos seres con poderes mentales, creados por Bodvar, solamente viven para acumular poder y conocimientos esclavizando a las demás razas.\n\nEl coste para subir habilidades de combate se iguala al de magia. +1 Inteligencia y Carisma. Además de obtener el poder de la Telepatía.";
						RazaDescrp.setText(descr);
						if (txtNombre.getText().length() != 0
								&& txtEdad.getText().length() != 0
								&& cmbxRaza.getSelectedIndex() != 0) {

							btnContinuar.setEnabled(true);

						}
						if (txtNombre.getText().length() == 0
								|| txtEdad.getText().length() == 0
								|| cmbxRaza.getSelectedIndex() == 0) {

							btnContinuar.setEnabled(false);

						}
					}

				}

				raza = cmbxRaza.getSelectedIndex();
			}
		});
		cmbxRaza.setModel(new DefaultComboBoxModel(new String[] {
				"-Seleccione una raza-", "Alto Elfo", "Elfo Silvano",
				"Elfo Oscuro", "Enano", "Gnomo", "Orco", "Humano", "Naga",
				"Addar Meddwl" }));
		cmbxRaza.setSelectedIndex(raza);
		cmbxRaza.setFont(mf.MyFont(0, 13));
		cmbxRaza.setBounds(71, 175, 163, 20);
		frmHistoriasDeZagas.getContentPane().add(cmbxRaza);

		LblRaza = new JLabel();
		LblRaza.setForeground(Color.WHITE);
		LblRaza.setOpaque(false);
		LblRaza.setBackground(new Color(255, 255, 255));
		LblRaza.setText("Raza:");
		LblRaza.setFont(mf.MyFont(0, 13));
		LblRaza.setBorder(null);
		LblRaza.setBounds(10, 168, 50, 27);
		frmHistoriasDeZagas.getContentPane().add(LblRaza);
		JScrollPane scrollPaneDescF = new JScrollPane();
		scrollPaneDescF.setBounds(10, 244, 256, 176);
		frmHistoriasDeZagas.getContentPane().add(scrollPaneDescF);

		final JTextArea txtDesc = new JTextArea();
		txtDesc.setText(descrpF);
		txtDesc.setLineWrap(true);
		txtDesc.setWrapStyleWord(true);
		txtDesc.setBackground(Color.WHITE);
		txtDesc.setFont(mf.MyFont(0, 13));
		scrollPaneDescF.setViewportView(txtDesc);

		btnContinuar.setEnabled(false);
		btnContinuar.setIcon(new ImageIcon(StartNPC.class
				.getResource("/images/boton continuar.png")));
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(StartNPC.class
						.getResource("/images/boton continuar2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(StartNPC.class
						.getResource("/images/boton continuar.png")));
			}
		});
		btnContinuar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnContinuar.setOpaque(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBorderPainted(false);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setFocusPainted(false);
		btnContinuar.setOpaque(false);
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setBackground(new Color(255, 255, 255));
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nombre = txtNombre.getText();
				character.setName(txtNombre.getText());
				descrpF = txtDesc.getText();
				character.setDescription(descrpF);
				if(razaAnt.equals("")){
					
				razaAnt=character.getRace().getRace();
				try {
					int edad = Integer.parseInt(txtEdad.getText());
					StartNPC.edad = edad;
					character.setAge(edad);
					character.getRace().CalculoRaza(character);
					frmHistoriasDeZagas.dispose();
					BendicionesNPC window = new BendicionesNPC();
					window.getFrame().setVisible(true);

				} catch (NumberFormatException e1) {
					JOptionPane
							.showMessageDialog(
									frmHistoriasDeZagas,
									"Valor invalido para la edad, introduce un número.",
									"", JOptionPane.ERROR_MESSAGE);
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SkillOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else{
					if(!razaAnt.equals(character.getRace().getRace())){
						
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"Has cambiado la raza de tu personaje, si continuas se reiniciara todo el proceso de creación. ¿Quieres continuar?",
										"¡Atención!", JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null, new Object[] {
												"Aceptar", "Cancelar" }, // null
																			// para
																			// YES,
																			// NO y
																			// CANCEL
										"opcion 1");
						if (JOptionPane.YES_OPTION == seleccion) {
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
							PrivilegiosNPC.posesiones = 0;
							StartNPC.atrpoints = new AtributePoints();
							StartNPC.skpoints = new SkillPoints();
							StartNPC.atributos = new Atributes(Start.atrpoints);
							StartNPC.combatSkills = new CombatSkills(Start.skpoints);
							StartNPC.knowledgeSkills = new KnowledgeSkills(Start.skpoints);
							StartNPC.magicSkills = new MagicSkills(Start.skpoints);
							StartNPC.knowhowSkills = new KnowHowSkills(Start.skpoints);
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
							EquipoNPC.weapon1 = new Weapons("", "", false,false,
									EquipoNPC.posss,"");
							EquipoNPC.weapon2 = new Weapons("", "", false,false,
									EquipoNPC.posss,"");
							EquipoNPC.weapon3 = new Weapons("", "", false,false,
									EquipoNPC.posss,"");
							EquipoNPC.weapon4 = new Weapons("", "", false,false,
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
							Privileges privileges=new Privileges();
							Setbacks setbacks = new Setbacks();
							Race race = new Race("");
							Equipment equipment = new Equipment();
							ArrayList<String> posarm = new ArrayList<String>();
							Possesions posss = new Possesions(posarm);
							Armor armor = new Armor("", "", false,false, posss);
							
							
							try {
								int edad = Integer.parseInt(txtEdad.getText());
								StartNPC.edad = edad;
								StartNPC.character = new Characters(nombre, race, descrpF, 0, 2, 10,
										20, 20, Start.atributos, Start.combatSkills,
										Start.knowledgeSkills, Start.magicSkills,
										Start.knowhowSkills, blessing, privileges, setbacks,
										false, armor, equipment,null,null,null,null,null,null,null,null,null,null,null,null, 0, 1,0,"","","");
								
								character.setAge(edad);
								character.getRace().CalculoRaza(character);
								frmHistoriasDeZagas.dispose();
								BendicionesNPC window = new BendicionesNPC();
								window.getFrame().setVisible(true);

							} catch (NumberFormatException e1) {
								JOptionPane
										.showMessageDialog(
												frmHistoriasDeZagas,
												"Valor invalido para la edad, introduce un número.",
												"", JOptionPane.ERROR_MESSAGE);
							} catch (AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
					
					else{
						try {
							int edad = Integer.parseInt(txtEdad.getText());
							StartNPC.edad = edad;
							character.setAge(edad);
							character.getRace().CalculoRaza(character);
							frmHistoriasDeZagas.dispose();
							BendicionesNPC window = new BendicionesNPC();
							window.getFrame().setVisible(true);

						} catch (NumberFormatException e1) {
							JOptionPane
									.showMessageDialog(
											frmHistoriasDeZagas,
											"Valor invalido para la edad, introduce un número.",
											"", JOptionPane.ERROR_MESSAGE);
						} catch (AtributeOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				}
			}

		});
		btnContinuar.setFont(mf.MyFont(0, 15));
		btnContinuar.setBounds(462, 455, 99, 38);
		frmHistoriasDeZagas.getContentPane().add(btnContinuar);

		btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(StartNPC.class
				.getResource("/images/boton atras.png")));
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				btnVolver.setIcon(new ImageIcon(StartNPC.class
						.getResource("/images/boton atras2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(StartNPC.class
						.getResource("/images/boton atras.png")));
			}
		});
		btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolver.setOpaque(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setBorder(null);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = JOptionPane
						.showOptionDialog(
								frmHistoriasDeZagas,
								"Si vuelves atras se perderán todos los datos no guardados.",
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
					nombre = "";
					edad = 0;
					raza = 0;
					descrpF = "";
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
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(mf.MyFont(0, 15));
		btnVolver.setBackground(new Color(139, 69, 19));
		btnVolver.setBounds(10, 455, 99, 38);
		frmHistoriasDeZagas.getContentPane().add(btnVolver);

		btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaStart window = new AyudaStart();
				window.getFrame().setVisible(true);
			}
		});
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAyuda.setIcon(new ImageIcon(StartNPC.class
						.getResource("/images/botones-inicio-ayuda2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnAyuda.setIcon(new ImageIcon(StartNPC.class
						.getResource("/images/botones-inicio-ayuda.png")));

			}
		});
		btnAyuda.setIcon(new ImageIcon(StartNPC.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnAyuda.setOpaque(false);
		btnAyuda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setFont(mf.MyFont(0, 13));
		btnAyuda.setFocusPainted(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBounds(234, 455, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnAyuda);

		txtDescripcinFsica = new JLabel();
		txtDescripcinFsica.setForeground(Color.WHITE);
		txtDescripcinFsica.setOpaque(false);
		txtDescripcinFsica.setText("Descripci\u00F3n F\u00EDsica:");
		txtDescripcinFsica.setFont(mf.MyFont(0, 13));
		txtDescripcinFsica.setBorder(null);
		txtDescripcinFsica.setBackground(new Color(255, 255, 255));
		txtDescripcinFsica.setBounds(10, 206, 129, 27);
		frmHistoriasDeZagas.getContentPane().add(txtDescripcinFsica);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setBorder(null);

		if (txtNombre.getText().length() != 0
				&& txtEdad.getText().length() != 0
				&& cmbxRaza.getSelectedIndex() != 0) {

			btnContinuar.setEnabled(true);

		}
		if (txtNombre.getText().length() == 0
				|| txtEdad.getText().length() == 0
				|| cmbxRaza.getSelectedIndex() == 0) {

			btnContinuar.setEnabled(false);

		}

		lblAspectosGenerales = new JLabel("Aspectos Generales");
		lblAspectosGenerales.setForeground(Color.WHITE);
		lblAspectosGenerales.setFont(mf.MyFont(1, 36));
		lblAspectosGenerales.setHorizontalAlignment(SwingConstants.CENTER);
		lblAspectosGenerales.setBounds(10, 0, 551, 73);
		frmHistoriasDeZagas.getContentPane().add(lblAspectosGenerales);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StartNPC.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 578, 504);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);

		Image image = new ImageIcon(("/logo.jpg")).getImage();
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(
				StartNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));

	}

	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}
}
