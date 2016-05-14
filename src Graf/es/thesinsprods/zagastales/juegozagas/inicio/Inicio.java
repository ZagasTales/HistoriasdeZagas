package es.thesinsprods.zagastales.juegozagas.inicio;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import es.thesinsprods.juegozagas.administracion.AdministracionPrinc;
import es.thesinsprods.juegozagas.gestorpartidas.GestorMain;
import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.atributes.AtributePoints;
import es.thesinsprods.zagastales.characters.atributes.Atributes;
import es.thesinsprods.zagastales.characters.blessings.Blessing;
import es.thesinsprods.zagastales.characters.equipment.Armor;
import es.thesinsprods.zagastales.characters.equipment.Equipment;
import es.thesinsprods.zagastales.characters.equipment.Possesions;
import es.thesinsprods.zagastales.characters.privileges.Privileges;
import es.thesinsprods.zagastales.characters.privileges.Setbacks;
import es.thesinsprods.zagastales.characters.race.Race;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.KnowHowSkills;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.characters.skills.SkillPoints;

import es.thesinsprods.zagastales.juegozagas.ayuda.AyudaPrincipal;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.StartNPC;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Armas;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Start;
import es.thesinsprods.zagastales.juegozagas.jugar.Jugar;
import es.thesinsprods.zagastales.perfil.Perfil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inicio {

	private JFrame frmHistoriasDeZagas;

	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}

	private JLabel txtBienvenidoSeleccioneA;
	public static String crear = "";
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
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
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.getContentPane().setBackground(Color.BLACK);
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setBackground(Color.WHITE);
		frmHistoriasDeZagas
				.setIconImage(Toolkit
						.getDefaultToolkit()
						.getImage(
								Armas.class
										.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setBounds(100, 100, 439, 462);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.setResizable(false);

		final JButton btnNewButton = new JButton("JUGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugar window = new Jugar();
				window.getFrmHistoriasDeZagas().setVisible(true);
				frmHistoriasDeZagas.dispose();

			}
		});

		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(Inicio.class
				.getResource("/images/botonesInicio.png")));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setFont(mf.MyFont(0, 17));
		btnNewButton.setBounds(10, 51, 414, 34);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						btnNewButton.setIcon(new ImageIcon(Inicio.class
								.getResource("/images/botonesInicio.png")));
					}
				});
			}
		});
		final JButton btnCreadorDeNpcs = new JButton("CREADOR DE NPCs");
		btnCreadorDeNpcs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StartNPC.atrpoints = new AtributePoints();
				StartNPC.skpoints = new SkillPoints();
				StartNPC.atributos = new Atributes(StartNPC.atrpoints);
				StartNPC.combatSkills = new CombatSkills(StartNPC.skpoints);
				StartNPC.knowledgeSkills = new KnowledgeSkills(
						StartNPC.skpoints);
				StartNPC.magicSkills = new MagicSkills(StartNPC.skpoints);
				StartNPC.knowhowSkills = new KnowHowSkills(StartNPC.skpoints);
				Blessing blessing = new Blessing("");
				Setbacks setbacks = new Setbacks();
				Privileges privileges = new Privileges();
				Race race = new Race("");
				Equipment equipment = new Equipment();
				ArrayList<String> posarm = new ArrayList<String>();
				Possesions posss = new Possesions(posarm);
				Armor armor = new Armor("", "", false,false, posss);
				StartNPC.character = new Characters(null, race, "", 0, 2, 10,
						20, 20, StartNPC.atributos, StartNPC.combatSkills,
						StartNPC.knowledgeSkills, StartNPC.magicSkills,
						StartNPC.knowhowSkills, blessing, privileges, setbacks,
						false, armor, equipment,null,null,null,null,null,null,null,null,null,null,null,null, 0, 1,0,"","","");
				frmHistoriasDeZagas.dispose();
				StartNPC window;
				try {
					window = new StartNPC();
					window.getFrmHistoriasDeZagas().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCreadorDeNpcs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCreadorDeNpcs.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnCreadorDeNpcs.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio.png")));
			}
		});
		btnCreadorDeNpcs.setHorizontalTextPosition(SwingConstants.CENTER);

		btnCreadorDeNpcs.setIcon(new ImageIcon(Inicio.class
				.getResource("/images/botonesInicio.png")));
		btnCreadorDeNpcs.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnCreadorDeNpcs.setForeground(Color.WHITE);
		btnCreadorDeNpcs.setBackground(new Color(139, 69, 19));
		btnCreadorDeNpcs.setFont(mf.MyFont(0, 17));
		btnCreadorDeNpcs.setBounds(10, 141, 414, 34);
		btnCreadorDeNpcs.setBorderPainted(false);
		btnCreadorDeNpcs.setContentAreaFilled(false);
		btnCreadorDeNpcs.setFocusPainted(false);
		btnCreadorDeNpcs.setOpaque(false);
		frmHistoriasDeZagas.getContentPane().add(btnCreadorDeNpcs);

		final JButton btnCreadorDePersonajes = new JButton(
				"CREADOR DE PERSONAJES");
		btnCreadorDePersonajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCreadorDePersonajes.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnCreadorDePersonajes.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio.png")));
			}
		});
		btnCreadorDePersonajes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCreadorDePersonajes.setIcon(new ImageIcon(Inicio.class
				.getResource("/images/botonesInicio.png")));
		btnCreadorDePersonajes.setBorder(new BevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btnCreadorDePersonajes.setForeground(Color.WHITE);
		btnCreadorDePersonajes.setBackground(new Color(139, 69, 19));
		btnCreadorDePersonajes.setBorderPainted(false);
		btnCreadorDePersonajes.setContentAreaFilled(false);
		btnCreadorDePersonajes.setFocusPainted(false);
		btnCreadorDePersonajes.setOpaque(false);
		btnCreadorDePersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear = "pj";
				Start.atrpoints = new AtributePoints();
				Start.skpoints = new SkillPoints();
				Start.atributos = new Atributes(Start.atrpoints);
				Start.combatSkills = new CombatSkills(Start.skpoints);
				Start.knowledgeSkills = new KnowledgeSkills(Start.skpoints);
				Start.magicSkills = new MagicSkills(Start.skpoints);
				Start.knowhowSkills = new KnowHowSkills(Start.skpoints);
				Blessing blessing = new Blessing("");
				Setbacks setbacks = new Setbacks();
				Privileges privileges = new Privileges();
				Race race = new Race("");
				Equipment equipment = new Equipment();
				ArrayList<String> posarm = new ArrayList<String>();
				Possesions posss = new Possesions(posarm);
				Armor armor = new Armor("", "", false,false, posss);
				Start.character = new Characters(null, race, "", 0, 2, 10, 20,
						20, Start.atributos, Start.combatSkills,
						Start.knowledgeSkills, Start.magicSkills,
						Start.knowhowSkills, blessing, privileges, setbacks,
						false, armor, equipment,null,null,null,null,null,null,null,null,null,null,null,null, 0, 1,0,"","","");
				frmHistoriasDeZagas.dispose();
				Start window;
				try {
					window = new Start();
					window.getFrmHistoriasDeZagas().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCreadorDePersonajes.setFont(mf.MyFont(0, 17));
		btnCreadorDePersonajes.setBounds(10, 186, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnCreadorDePersonajes);

		final JButton btnCreditos = new JButton("CRÉDITOS");
		btnCreditos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCreditos.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnCreditos.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio.png")));
			}
		});
		btnCreditos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCreditos.setIcon(new ImageIcon(Inicio.class
				.getResource("/images/botonesInicio.png")));
		btnCreditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Creditos window = new Creditos();
				window.getFrame().setVisible(true);
			}
		});

		final JButton btnHistoria = new JButton("GESTOR DE PARTIDAS");
		btnHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestorMain window = new GestorMain();
				window.getFrmHistoriasDeZagas().setVisible(true);
				frmHistoriasDeZagas.dispose();

			
			}
		});
		btnHistoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnHistoria.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnHistoria.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio.png")));

			}
		});
		btnHistoria.setIcon(new ImageIcon(Inicio.class
				.getResource("/images/botonesInicio.png")));
		btnHistoria.setOpaque(false);
		btnHistoria.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHistoria.setForeground(Color.WHITE);
		btnHistoria.setFont(mf.MyFont(0, 17));
		btnHistoria.setFocusPainted(false);
		btnHistoria.setContentAreaFilled(false);
		btnHistoria.setBorderPainted(false);
		btnHistoria.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

		null, null));
		btnHistoria.setBackground(new Color(139, 69, 19));
		btnHistoria.setBounds(10, 96, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnHistoria);
		btnCreditos.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnCreditos.setForeground(Color.WHITE);
		btnCreditos.setBackground(new Color(139, 69, 19));
		btnCreditos.setFont(mf.MyFont(0, 17));
		btnCreditos.setBounds(10, 321, 414, 34);
		btnCreditos.setBorderPainted(false);
		btnCreditos.setContentAreaFilled(false);
		btnCreditos.setFocusPainted(false);
		btnCreditos.setOpaque(false);
		frmHistoriasDeZagas.getContentPane().add(btnCreditos);

		final JButton button = new JButton("SALIR");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				button.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio.png")));
			}
		});
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Estás seguro de querer cerrar el programa?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					System.exit(0);
				}
			}
		});

		txtBienvenidoSeleccioneA = new JLabel();
		txtBienvenidoSeleccioneA.setOpaque(false);
		txtBienvenidoSeleccioneA.setForeground(Color.WHITE);
		txtBienvenidoSeleccioneA.setBackground(new Color(205, 133, 63));
		txtBienvenidoSeleccioneA.setBorder(null);
		txtBienvenidoSeleccioneA.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenidoSeleccioneA.setFont(mf.MyFont(0, 13));
		txtBienvenidoSeleccioneA
				.setText("Bienvenido, seleccione a qué servicio desea acceder.");
		txtBienvenidoSeleccioneA.setBounds(0, 0, 444, 40);
		frmHistoriasDeZagas.getContentPane().add(txtBienvenidoSeleccioneA);
		button.setIcon(new ImageIcon(Inicio.class
				.getResource("/images/botonesInicio.png")));
		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFont(mf.MyFont(0, 17));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(10, 366, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(button);

		final JButton btnAyuda = new JButton("AYUDA");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPrincipal window = new AyudaPrincipal();
				window.getFrame().setVisible(true);
			}
		});
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAyuda.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnAyuda.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio.png")));

			}
		});
		btnAyuda.setIcon(new ImageIcon(Inicio.class
				.getResource("/images/botonesInicio.png")));
		btnAyuda.setOpaque(false);
		btnAyuda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setFont(mf.MyFont(0, 17));
		btnAyuda.setFocusPainted(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

		null, null));
		btnAyuda.setBackground(new Color(139, 69, 19));
		btnAyuda.setBounds(10, 276, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnAyuda);

		final JButton btnPerfil = new JButton("PERFIL");
		if (Loader.usuario.equals("")) {
			btnPerfil.setEnabled(false);

		}
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnPerfil.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnPerfil.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio.png")));

			}
		});
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					frmHistoriasDeZagas.dispose();
					Perfil window = new Perfil();
					window.getFrmHistoriasDeZagas().setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnPerfil.setIcon(new ImageIcon(Inicio.class
				.getResource("/images/botonesInicio.png")));
		btnPerfil.setOpaque(false);
		btnPerfil.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setFont(mf.MyFont(0, 17));
		btnPerfil.setFocusPainted(false);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

		null, null));
		btnPerfil.setBackground(new Color(139, 69, 19));
		btnPerfil.setBounds(10, 231, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnPerfil);

		final JButton btnAdministracin = new JButton("ADMINISTRACI\u00D3N");
		btnAdministracin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdministracionPrinc window = new AdministracionPrinc();
				window.getFrame().setVisible(true);
				frmHistoriasDeZagas.dispose();
			}
		});
		btnAdministracin.setVisible(false);
		btnAdministracin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAdministracin.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnAdministracin.setIcon(new ImageIcon(Inicio.class
						.getResource("/images/botonesInicio.png")));
			}
		});
		btnAdministracin.setIcon(new ImageIcon(Inicio.class
				.getResource("/images/botonesInicio.png")));
		btnAdministracin.setOpaque(false);
		btnAdministracin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdministracin.setForeground(Color.WHITE);
		btnAdministracin.setFont(mf.MyFont(0, 17));
		btnAdministracin.setFocusPainted(false);
		btnAdministracin.setContentAreaFilled(false);
		btnAdministracin.setBorderPainted(false);
		btnAdministracin.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null,

				null, null));
		btnAdministracin.setBackground(new Color(139, 69, 19));
		btnAdministracin.setBounds(10, 321, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnAdministracin);
	

		final JButton btnNewButton_1 = new JButton("(Desconectar)");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Estás seguro de querer desconectarte?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					try {
						if (Loader.usuario.length() == 0) {
							frmHistoriasDeZagas.dispose();
							Loader window = new Loader();
							window.getFrmHistoriasDeZagas().setVisible(true);

						} else {

							Loader.usuario = "";
							frmHistoriasDeZagas.dispose();
							Loader window = new Loader();
							window.getFrmHistoriasDeZagas().setVisible(true);
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_1.setForeground(Color.BLUE);
			}

			public void mouseReleased(MouseEvent e) {
				btnNewButton_1.setForeground(Color.WHITE);
			}
		});
		btnNewButton_1.setFont(mf.MyFont(3, 11));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(-10, 416, 125, 17);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel(Loader.usuario);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(mf.MyFont(0, 11));
		lblNewLabel_1.setBounds(104, 416, 86, 17);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inicio.class
				.getResource("/images/background-inicio.jpg")));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 444, 472);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
		if (Loader.admin==1) {
			frmHistoriasDeZagas.setBounds(100, 100, 439, 500);
			frmHistoriasDeZagas.setLocationRelativeTo(null);
			btnCreditos.setBounds(10, 365, 414, 34);
			button.setBounds(10, 410, 414, 34);
			lblNewLabel_1.setBounds(104, 455, 86, 17);
			btnNewButton_1.setBounds(-10, 455, 125, 17);
			btnAdministracin.setVisible(true);
		}
	}
}
