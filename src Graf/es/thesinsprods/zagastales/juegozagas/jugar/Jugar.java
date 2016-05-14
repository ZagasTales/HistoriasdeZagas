package es.thesinsprods.zagastales.juegozagas.jugar;

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
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;
import es.thesinsprods.zagastales.jugar.minijuegos.Minijuegos;
import es.thesinsprods.zagastales.perfil.Perfil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Jugar {

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
					Jugar window = new Jugar();
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
	public Jugar() {
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
		frmHistoriasDeZagas.setBounds(100, 100, 439, 272);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.setResizable(false);

		final JButton btnNewButton = new JButton("CREAR  PARTIDA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CrearPartida window;
				try {
					window = new CrearPartida();
					window.getFrame().setVisible(true);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				frmHistoriasDeZagas.dispose();
				
			}
		});

		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(Jugar.class
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
				btnNewButton.setIcon(new ImageIcon(Jugar.class
						.getResource("/images/botonesInicio2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						btnNewButton.setIcon(new ImageIcon(Jugar.class
								.getResource("/images/botonesInicio.png")));
					}
				});
			}
		});
		final JButton btnCreadorDeNpcs = new JButton("BUSCAR PARTIDA");
		btnCreadorDeNpcs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Loader.usuario.equals("")){
				
					
				}
				
				else{
					
					BuscarPartida window;
					try {
						window = new BuscarPartida();
						window.getFrame().setVisible(true);
						frmHistoriasDeZagas.dispose();
					} catch (ClassNotFoundException | InstantiationException
							| IllegalAccessException | IOException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}

			}
		});
		btnCreadorDeNpcs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCreadorDeNpcs.setIcon(new ImageIcon(Jugar.class
						.getResource("/images/botonesInicio2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnCreadorDeNpcs.setIcon(new ImageIcon(Jugar.class
						.getResource("/images/botonesInicio.png")));
			}
		});
		btnCreadorDeNpcs.setHorizontalTextPosition(SwingConstants.CENTER);

		btnCreadorDeNpcs.setIcon(new ImageIcon(Jugar.class
				.getResource("/images/botonesInicio.png")));
		btnCreadorDeNpcs.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnCreadorDeNpcs.setForeground(Color.WHITE);
		btnCreadorDeNpcs.setBackground(new Color(139, 69, 19));
		btnCreadorDeNpcs.setFont(mf.MyFont(0, 17));
		btnCreadorDeNpcs.setBounds(10, 96, 414, 34);
		btnCreadorDeNpcs.setBorderPainted(false);
		btnCreadorDeNpcs.setContentAreaFilled(false);
		btnCreadorDeNpcs.setFocusPainted(false);
		btnCreadorDeNpcs.setOpaque(false);
		frmHistoriasDeZagas.getContentPane().add(btnCreadorDeNpcs);

		final JButton btnCreadorDePersonajes = new JButton("MINIJUEGOS");
		btnCreadorDePersonajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCreadorDePersonajes.setIcon(new ImageIcon(Jugar.class
						.getResource("/images/botonesInicio2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnCreadorDePersonajes.setIcon(new ImageIcon(Jugar.class
						.getResource("/images/botonesInicio.png")));
			}
		});
		btnCreadorDePersonajes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCreadorDePersonajes.setIcon(new ImageIcon(Jugar.class
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
				Minijuegos window = new Minijuegos();
				window.getFrmHistoriasDeZagas().setVisible(true);
				frmHistoriasDeZagas.dispose();

			}
		});
		btnCreadorDePersonajes.setFont(mf.MyFont(0, 17));
		btnCreadorDePersonajes.setBounds(10, 141, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnCreadorDePersonajes);

		final JButton btnHistoria = new JButton("VOLVER AL INICIO");
		btnHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Inicio window = new Inicio();
				window.getFrmHistoriasDeZagas().setVisible(true);
				frmHistoriasDeZagas.dispose();
			}
		});
		btnHistoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnHistoria.setIcon(new ImageIcon(Jugar.class
						.getResource("/images/botonesInicio2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnHistoria.setIcon(new ImageIcon(Jugar.class
						.getResource("/images/botonesInicio.png")));

			}
		});
		btnHistoria.setIcon(new ImageIcon(Jugar.class
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
		btnHistoria.setBounds(10, 186, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnHistoria);

		txtBienvenidoSeleccioneA = new JLabel();
		txtBienvenidoSeleccioneA.setOpaque(false);
		txtBienvenidoSeleccioneA.setForeground(Color.WHITE);
		txtBienvenidoSeleccioneA.setBackground(new Color(205, 133, 63));
		txtBienvenidoSeleccioneA.setBorder(null);
		txtBienvenidoSeleccioneA.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenidoSeleccioneA.setFont(mf.MyFont(0, 13));
		txtBienvenidoSeleccioneA.setText("Seleccione un modo de juego");
		txtBienvenidoSeleccioneA.setBounds(0, 0, 444, 40);
		frmHistoriasDeZagas.getContentPane().add(txtBienvenidoSeleccioneA);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Jugar.class
				.getResource("/images/background-inicio.jpg")));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 444, 472);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);

	}
}
