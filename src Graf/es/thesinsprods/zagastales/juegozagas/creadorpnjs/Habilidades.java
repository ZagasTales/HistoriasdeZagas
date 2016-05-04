package es.thesinsprods.zagastales.juegozagas.creadorpnjs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributePoints;
import es.thesinsprods.zagastales.characters.atributes.Atributes;
import es.thesinsprods.zagastales.characters.blessings.Blessing;
import es.thesinsprods.zagastales.characters.equipment.Accesories;
import es.thesinsprods.zagastales.characters.equipment.Armor;
import es.thesinsprods.zagastales.characters.equipment.Equipment;
import es.thesinsprods.zagastales.characters.equipment.Misc;
import es.thesinsprods.zagastales.characters.equipment.Possesions;
import es.thesinsprods.zagastales.characters.equipment.Weapons;
import es.thesinsprods.zagastales.characters.privileges.Setbacks;
import es.thesinsprods.zagastales.characters.race.Race;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.KnowHowSkills;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.characters.skills.SkillPoints;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaHabilidades;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class Habilidades {

	private JFrame frmHistoriasDeZagas;
	private JLabel lblPuntos;
	MorpheusFont mf = new MorpheusFont();
	private static JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Habilidades window = new Habilidades();
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
	public Habilidades() {
		initialize();
	}

	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.getContentPane().setBackground(
				new Color(205, 133, 63));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas
				.setIconImage(Toolkit
						.getDefaultToolkit()
						.getImage(
								Armas.class
										.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setBounds(100, 100, 584, 532);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.getContentPane().setLayout(null);

		JPanel pnlHabilidades = new JPanel();
		pnlHabilidades.setOpaque(false);
		pnlHabilidades.setBounds(67, 90, 444, 334);
		frmHistoriasDeZagas.getContentPane().add(pnlHabilidades);
		pnlHabilidades.setLayout(null);

		final JButton btnCombate = new JButton("Combate");
		btnCombate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCombate.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton habilidades2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnCombate.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton habilidades.png")));

			}
		});
		btnCombate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCombate.setIcon(new ImageIcon(Habilidades.class
				.getResource("/images/boton habilidades.png")));
		btnCombate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnCombate.setForeground(new Color(255, 255, 255));
		btnCombate.setBackground(new Color(139, 69, 19));
		btnCombate.setBorderPainted(false);
		btnCombate.setContentAreaFilled(false);
		btnCombate.setFocusPainted(false);
		btnCombate.setOpaque(false);
		btnCombate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combate window = new Combate();
				window.getFrame().setVisible(true);
				getTextField().setText("" + Start.skpoints.getPoints());
			}
		});
		btnCombate.setFont(mf.MyFont(0, 13));
		btnCombate.setBounds(10, 11, 171, 106);
		pnlHabilidades.add(btnCombate);

		final JButton btnMagia = new JButton("Magia");
		btnMagia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMagia.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton habilidades2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnMagia.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton habilidades.png")));

			}

		});
		btnMagia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMagia.setIcon(new ImageIcon(Habilidades.class
				.getResource("/images/boton habilidades.png")));
		btnMagia.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnMagia.setForeground(new Color(255, 255, 255));
		btnMagia.setBackground(new Color(139, 69, 19));
		btnMagia.setBorderPainted(false);
		btnMagia.setContentAreaFilled(false);
		btnMagia.setFocusPainted(false);
		btnMagia.setOpaque(false);
		btnMagia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Magia window = new Magia();
				window.getFrame().setVisible(true);
				getTextField().setText("" + Start.skpoints.getPoints());
			}
		});
		btnMagia.setFont(mf.MyFont(0, 13));
		btnMagia.setBounds(10, 190, 171, 106);
		pnlHabilidades.add(btnMagia);

		final JButton btnConocimientos = new JButton("Conocimientos");
		btnConocimientos.setOpaque(false);
		btnConocimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnConocimientos.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton habilidades2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnConocimientos.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton habilidades.png")));

			}
		});
		btnConocimientos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConocimientos.setIcon(new ImageIcon(Habilidades.class
				.getResource("/images/boton habilidades.png")));
		btnConocimientos.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnConocimientos.setForeground(new Color(255, 255, 255));
		btnConocimientos.setBackground(new Color(139, 69, 19));
		btnConocimientos.setBorderPainted(false);
		btnConocimientos.setContentAreaFilled(false);
		btnConocimientos.setFocusPainted(false);
		btnConocimientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conocimientos window = new Conocimientos();
				window.getFrame().setVisible(true);
				getTextField().setText("" + Start.skpoints.getPoints());
			}
		});
		btnConocimientos.setFont(mf.MyFont(0, 13));
		btnConocimientos.setBounds(263, 11, 171, 106);
		pnlHabilidades.add(btnConocimientos);

		final JButton btnDestrezas = new JButton("Destrezas");
		btnDestrezas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnDestrezas.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton habilidades2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnDestrezas.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton habilidades.png")));

			}
		});
		btnDestrezas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDestrezas.setIcon(new ImageIcon(Habilidades.class
				.getResource("/images/boton habilidades.png")));
		btnDestrezas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnDestrezas.setForeground(new Color(255, 255, 255));
		btnDestrezas.setBackground(new Color(139, 69, 19));
		btnDestrezas.setBorderPainted(false);
		btnDestrezas.setContentAreaFilled(false);
		btnDestrezas.setFocusPainted(false);
		btnDestrezas.setOpaque(false);
		btnDestrezas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Destrezas window = new Destrezas();
				window.getFrame().setVisible(true);
				getTextField().setText("" + Start.skpoints.getPoints());
			}
		});
		btnDestrezas.setFont(mf.MyFont(0, 13));
		btnDestrezas.setBounds(263, 190, 171, 106);
		pnlHabilidades.add(btnDestrezas);

		final JButton btnContinuar = new JButton("");
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton continuar2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton continuar.png")));
			}
		});
		btnContinuar.setIcon(new ImageIcon(Habilidades.class
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
				int error=0;
				if(Equipo.weapon1.getTipo().equals("Arma de Fuego")|| Equipo.weapon2.getTipo().equals("Arma de Fuego")|| Equipo.weapon3.getTipo().equals("Arma de Fuego")|| Equipo.weapon4.getTipo().equals("Arma de Fuego")){
				
					if(Start.character.getKnowledgeSkills().getSecretKnowledge()<2){
						
						error++;
					}
				
				}
				
				if (error==0){

					frmHistoriasDeZagas.dispose();
					Equipo window = new Equipo();
					window.getFrame().setVisible(true);
				}
				
				if(error!=0){
					int seleccion = JOptionPane
							.showOptionDialog(
									frmHistoriasDeZagas,
									"Llevas un arma de fuego, por lo que necesitas como minimo Conocimientos Secretos a nivel 2.",
									"¡Atención!", JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, // null
																// para
																// YES,
																// NO y
																// CANCEL
									"opcion 1");
					
				}
			}
		});
		btnContinuar.setFont(mf.MyFont(0, 13));
		btnContinuar.setBounds(457, 457, 99, 36);
		frmHistoriasDeZagas.getContentPane().add(btnContinuar);

		lblPuntos = new JLabel();
		lblPuntos.setForeground(Color.WHITE);
		lblPuntos.setOpaque(false);
		lblPuntos.setBackground(new Color(205, 133, 63));
		lblPuntos.setFont(mf.MyFont(0, 13));
		lblPuntos.setText("Puntos:");
		lblPuntos.setBorder(null);
		lblPuntos.setBounds(10, 467, 43, 20);
		frmHistoriasDeZagas.getContentPane().add(lblPuntos);

		setTextField(new JTextField());
		getTextField().setEditable(false);
		getTextField().setText("" + Start.skpoints.getPoints());
		getTextField().setFont(mf.MyFont(0, 13));
		getTextField().setBounds(63, 467, 29, 20);
		getTextField().setBackground(new Color(211, 211, 211));
		getTextField().setForeground(new Color(0, 0, 0));
		frmHistoriasDeZagas.getContentPane().add(getTextField());

		final JButton btnAtras = new JButton("");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAtras.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton atras2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				btnAtras.setIcon(new ImageIcon(Habilidades.class
						.getResource("/images/boton atras.png")));
			}
		});
		btnAtras.setIcon(new ImageIcon(Habilidades.class
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
			public void actionPerformed(ActionEvent arg0) {
				frmHistoriasDeZagas.dispose();
				Atributos window = new Atributos();
				window.getFrame().setVisible(true);

			}
		});
		btnAtras.setFont(mf.MyFont(0, 13));
		btnAtras.setBounds(106, 457, 99, 36);
		frmHistoriasDeZagas.getContentPane().add(btnAtras);

		final JButton btnInicio = new JButton("Inicio");
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
					Start.razaAnt="";
					Start.nombre = "";
					Start.edad = 0;
					Start.raza = 0;
					Start.descrpF = "";
					Bendiciones.bendicion = 0;
					Privilegios.priv1 = 0;
					Privilegios.priv2 = 0;
					Privilegios.priv3 = 0;
					Privilegios.priv4 = 0;
					Privilegios.priv5 = 0;
					Privilegios.rev1 = 0;
					Privilegios.rev2 = 0;
					Privilegios.rev3 = 0;
					Privilegios.rev4 = 0;
					Privilegios.posesiones = 0;
					Start.atrpoints = new AtributePoints();
					Start.skpoints = new SkillPoints();
					Start.atributos = new Atributes(Start.atrpoints);
					Start.combatSkills = new CombatSkills(Start.skpoints);
					Start.knowledgeSkills = new KnowledgeSkills(Start.skpoints);
					Start.magicSkills = new MagicSkills(Start.skpoints);
					Start.knowhowSkills = new KnowHowSkills(Start.skpoints);
					Atributos.minFuerza = 6;
					Atributos.minDestreza = 6;
					Atributos.minResistencia = 6;
					Atributos.minResistenciaM = 6;
					Atributos.minCarisma = 6;
					Atributos.minPercepcion = 6;
					Atributos.minInteligencia = 6;
					Combate.minAsta = 0;
					Combate.minBloq = 0;
					Combate.minDist = 0;
					Combate.minDos = 0;
					Combate.minEsq = 0;
					Combate.minUna = 0;
					Conocimientos.minAG = 0;
					Conocimientos.minCS = 0;
					Conocimientos.minDip = 0;
					Conocimientos.minEt = 0;
					Conocimientos.minInv = 0;
					Conocimientos.minMed = 0;
					Conocimientos.minNeg = 0;
					Conocimientos.minOc = 0;
					Magia.minAgua = 0;
					Magia.minArcana = 0;
					Magia.minBlanca = 0;
					Magia.minDruidica = 0;
					Magia.minFuego = 0;
					Magia.minNegra = 0;
					Magia.minTierra = 0;
					Magia.minViento = 0;
					Destrezas.minAtl = 0;
					Destrezas.minEq = 0;
					Destrezas.minSig = 0;
					Destrezas.minSup = 0;
					Destrezas.minTra = 0;
					Equipo.contexcusa = 0;
					Equipo.weapon1 = new Weapons("", "", false,false,
							Equipo.posss,"");
					Equipo.weapon2 = new Weapons("", "", false,false,
							Equipo.posss,"");
					Equipo.weapon3 = new Weapons("", "", false,false,
							Equipo.posss,"");
					Equipo.weapon4 = new Weapons("", "", false,false,
							Equipo.posss,"");
					Equipo.armor1 = new Armor("", "", false,false, Equipo.posss);
					Equipo.accesories1 = new Accesories("", "", false,false,
							Equipo.posss);
					Equipo.accesories2 = new Accesories("", "", false,false,
							Equipo.posss);
					Equipo.accesories3 = new Accesories("", "", false,false,
							Equipo.posss);
					Equipo.accesories4 = new Accesories("", "", false,false,
							Equipo.posss);
					Equipo.misc1 = new Misc("", "", false,false, Equipo.posss);
					Equipo.misc2 = new Misc("", "", false,false, Equipo.posss);
					Equipo.misc3 = new Misc("", "", false,false, Equipo.posss);
					Equipo.misc4 = new Misc("", "", false,false, Equipo.posss);
					Equipo.pweap = 0;
					Equipo.pmisc = 0;
					Start.contadorBEktra = 0;
					Start.contadorPosesion = 0;
					Blessing blessing = new Blessing("");
					Setbacks setbacks = new Setbacks();
					Race race = new Race("");
					Equipment equipment = new Equipment();
					ArrayList<String> posarm = new ArrayList<String>();
					Possesions posss = new Possesions(posarm);
					Armor armor = new Armor("", "", false,false, posss);
					Start.character = new Characters(null, race, "", 0, 2, 10,
							20, 20, Start.atributos, Start.combatSkills,
							Start.knowledgeSkills, Start.magicSkills,
							Start.knowhowSkills, blessing, null, setbacks,
							false, armor, equipment,null,null,null,null,null,null,null,null,null,null,null,null, 0, 1,0,"","","");
					frmHistoriasDeZagas.dispose();
					Inicio window = new Inicio();
					window.getFrmHistoriasDeZagas().setVisible(true);
				}

			}
		});
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnInicio.setIcon(new ImageIcon(Privilegios.class
						.getResource("/images/botones-inicio-ayuda2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				btnInicio.setIcon(new ImageIcon(Privilegios.class
						.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnInicio.setIcon(new ImageIcon(Privilegios.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnInicio.setOpaque(false);
		btnInicio.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(mf.MyFont(0, 15));
		btnInicio.setFocusPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setBounds(215, 457, 111, 36);
		frmHistoriasDeZagas.getContentPane().add(btnInicio);

		final JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaHabilidades window = new AyudaHabilidades();
				window.getFrame().setVisible(true);

			}
		});
		btnAyuda.setIcon(new ImageIcon(Privilegios.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnAyuda.setOpaque(false);
		btnAyuda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setFont(mf.MyFont(0, 15));
		btnAyuda.setFocusPainted(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAyuda.setIcon(new ImageIcon(Privilegios.class
						.getResource("/images/botones-inicio-ayuda2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				btnAyuda.setIcon(new ImageIcon(Privilegios.class
						.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnAyuda.setBounds(336, 457, 111, 36);
		frmHistoriasDeZagas.getContentPane().add(btnAyuda);

		JLabel lblHabilidades = new JLabel("Habilidades");
		lblHabilidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidades.setForeground(Color.WHITE);
		lblHabilidades.setFont(mf.MyFont(1, 36));
		lblHabilidades.setBounds(10, 11, 558, 68);
		frmHistoriasDeZagas.getContentPane().add(lblHabilidades);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Habilidades.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 578, 504);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
		getTextField().setColumns(10);

	}

	public static JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
