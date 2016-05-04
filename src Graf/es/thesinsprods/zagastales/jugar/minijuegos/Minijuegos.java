package es.thesinsprods.zagastales.jugar.minijuegos;

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
import es.thesinsprods.resources.db.ConexionDBOnline;
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
import es.thesinsprods.zagastales.juegozagas.jugar.Jugar;
import es.thesinsprods.zagastales.perfil.Perfil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Minijuegos {

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
					Minijuegos window = new Minijuegos();
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
	public Minijuegos() {
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

		final JButton btnHistoria = new JButton("VOLVER");
		btnHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Jugar window = new Jugar();
				window.getFrmHistoriasDeZagas().setVisible(true);
				frmHistoriasDeZagas.dispose();
			}
		});
		btnHistoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnHistoria.setIcon(new ImageIcon(Minijuegos.class
						.getResource("/images/botonesInicio2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnHistoria.setIcon(new ImageIcon(Minijuegos.class
						.getResource("/images/botonesInicio.png")));

			}
		});
		btnHistoria.setIcon(new ImageIcon(Minijuegos.class
				.getResource("/images/botonesInicio.png")));
		btnHistoria.setOpaque(false);
		btnHistoria.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHistoria.setForeground(Color.WHITE);
		btnHistoria.setFont(new Font("Morpheus", Font.PLAIN, 17));
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
		txtBienvenidoSeleccioneA.setFont(mf.MyFont(0, 15));
		txtBienvenidoSeleccioneA.setText("Seleccione un minijuego");
		txtBienvenidoSeleccioneA.setBounds(0, 0, 444, 40);
		frmHistoriasDeZagas.getContentPane().add(txtBienvenidoSeleccioneA);

		final JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				button.setIcon(new ImageIcon(Minijuegos.class
						.getResource("/images/sombrerito atacando.png")));

			}

			public void mouseReleased(MouseEvent e) {

				button.setIcon(new ImageIcon(Minijuegos.class
						.getResource("/images/sombrerito sprite prueba.png")));

			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String definitivo = "./minijuegos/Corre Sombre Corre!.exe";
				File file = new File(definitivo);
				try {
					if (!file.exists()) {
						throw new IllegalArgumentException("The file "
								+ definitivo + " does not exist");
					}
					Process p = Runtime.getRuntime().exec(
							file.getAbsolutePath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button.setIcon(new ImageIcon(Minijuegos.class
				.getResource("/images/sombrerito sprite prueba.png")));
		button.setOpaque(false);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Morpheus", Font.PLAIN, 17));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null,

		null, null, null));
		button.setBackground(new Color(139, 69, 19));
		button.setBounds(56, 51, 45, 80);
		frmHistoriasDeZagas.getContentPane().add(button);

		JLabel lblcorreSombreCorre = new JLabel("\u00A1Corre, Sombre, corre!");
		lblcorreSombreCorre.setForeground(Color.WHITE);
		lblcorreSombreCorre.setFont(mf.MyFont(0, 13));
		lblcorreSombreCorre.setHorizontalAlignment(SwingConstants.CENTER);
		lblcorreSombreCorre.setBounds(10, 139, 148, 14);
		frmHistoriasDeZagas.getContentPane().add(lblcorreSombreCorre);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Minijuegos.class
				.getResource("/images/background-inicio.jpg")));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 444, 472);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);

	}
}
