package es.thesinsprods.zagastales.juegozagas.creadornpcs;

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
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Equipo;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Start;
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

public class HabilidadesNPC {

	private JFrame frmHistoriasDeZagas;
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HabilidadesNPC window = new HabilidadesNPC();
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
	public HabilidadesNPC() {
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
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArmasNPC.class
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
				btnCombate.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton habilidades2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnCombate.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton habilidades.png")));

			}
		});
		btnCombate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCombate.setIcon(new ImageIcon(HabilidadesNPC.class
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
				CombateNPC window = new CombateNPC();
				window.getFrame().setVisible(true);

			}
		});
		btnCombate.setFont(mf.MyFont(0, 13));
		btnCombate.setBounds(10, 11, 171, 106);
		pnlHabilidades.add(btnCombate);

		final JButton btnMagia = new JButton("Magia");
		btnMagia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMagia.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton habilidades2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnMagia.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton habilidades.png")));

			}

		});
		btnMagia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMagia.setIcon(new ImageIcon(HabilidadesNPC.class
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
				MagiaNPC window = new MagiaNPC();
				window.getFrame().setVisible(true);

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
				btnConocimientos.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton habilidades2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnConocimientos.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton habilidades.png")));

			}
		});
		btnConocimientos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConocimientos.setIcon(new ImageIcon(HabilidadesNPC.class
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
				ConocimientosNPC window = new ConocimientosNPC();
				window.getFrame().setVisible(true);

			}
		});
		btnConocimientos.setFont(mf.MyFont(0, 13));
		btnConocimientos.setBounds(263, 11, 171, 106);
		pnlHabilidades.add(btnConocimientos);

		final JButton btnDestrezas = new JButton("Destrezas");
		btnDestrezas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnDestrezas.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton habilidades2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnDestrezas.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton habilidades.png")));

			}
		});
		btnDestrezas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDestrezas.setIcon(new ImageIcon(HabilidadesNPC.class
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
				DestrezasNPC window = new DestrezasNPC();
				window.getFrame().setVisible(true);

			}
		});
		btnDestrezas.setFont(mf.MyFont(0, 13));
		btnDestrezas.setBounds(263, 190, 171, 106);
		pnlHabilidades.add(btnDestrezas);

		final JButton btnContinuar = new JButton("");
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton continuar2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton continuar.png")));
			}
		});
		btnContinuar.setIcon(new ImageIcon(HabilidadesNPC.class
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
				if(EquipoNPC.weapon1.getTipo().equals("Arma de Fuego")|| EquipoNPC.weapon2.getTipo().equals("Arma de Fuego")|| EquipoNPC.weapon3.getTipo().equals("Arma de Fuego")|| EquipoNPC.weapon4.getTipo().equals("Arma de Fuego")){
				
					if(StartNPC.character.getKnowledgeSkills().getSecretKnowledge()<2){
						
						error++;
					}
				
				}
				
				if (error==0){

					frmHistoriasDeZagas.dispose();
					EquipoNPC window = new EquipoNPC();
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

		final JButton btnAtras = new JButton("");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAtras.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton atras2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				btnAtras.setIcon(new ImageIcon(HabilidadesNPC.class
						.getResource("/images/boton atras.png")));
			}
		});
		btnAtras.setIcon(new ImageIcon(HabilidadesNPC.class
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
				AtributosNPC window = new AtributosNPC();
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
		btnInicio.setIcon(new ImageIcon(PrivilegiosNPC.class
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
		btnAyuda.setIcon(new ImageIcon(PrivilegiosNPC.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnAyuda.setOpaque(false);
		btnAyuda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setFont(new Font("Morpheus", Font.PLAIN, 15));
		btnAyuda.setFocusPainted(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAyuda.setIcon(new ImageIcon(PrivilegiosNPC.class
						.getResource("/images/botones-inicio-ayuda2.png")));
			}

			public void mouseReleased(MouseEvent arg0) {
				btnAyuda.setIcon(new ImageIcon(PrivilegiosNPC.class
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
		lblNewLabel.setIcon(new ImageIcon(HabilidadesNPC.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 578, 504);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);

	}

}
