package es.thesinsprods.zagastales.juegozagas.jugar.jugador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
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
import es.thesinsprods.zagastales.characters.privileges.Setbacks;
import es.thesinsprods.zagastales.characters.race.Race;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.KnowHowSkills;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.SkillPoints;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaBendicion;
import es.thesinsprods.zagastales.juegozagas.creadornpcs.AvanzadoNPC;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;

public class ExtrasJugadores {

	private JFrame frmHistoriasDeZagas;
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExtrasJugadores window = new ExtrasJugadores();
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
	public ExtrasJugadores() {
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
				AvanzadoNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setBounds(100, 100, 584, 532);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frmHistoriasDeZagas.getContentPane().setLayout(null);
		frmHistoriasDeZagas.setResizable(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 175, 325);
		frmHistoriasDeZagas.getContentPane().add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setText(VentanaJugadores.personaje.getPoderes());
		scrollPane.setViewportView(textArea);
		textArea.setFont(mf.MyFont(0, 12));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(201, 123, 175, 325);
		frmHistoriasDeZagas.getContentPane().add(scrollPane_1);
		
		final JTextArea textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		textArea.setText(VentanaJugadores.personaje.getExtras());
		textArea_2.setFont(mf.MyFont(0, 12));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(393, 123, 175, 325);
		frmHistoriasDeZagas.getContentPane().add(scrollPane_2);
		
		final JTextArea textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
		textArea_1.setFont(mf.MyFont(0, 12));
		textArea.setText(VentanaJugadores.personaje.getModificadores());

		final JButton btnAtras = new JButton("");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				btnAtras.setIcon(new ImageIcon(ExtrasJugadores.class
						.getResource("/images/boton atras2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {

				btnAtras.setIcon(new ImageIcon(ExtrasJugadores.class
						.getResource("/images/boton atras.png")));
			}
		});
		btnAtras.setIcon(new ImageIcon(ExtrasJugadores.class
				.getResource("/images/boton atras.png")));
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAtras.setBackground(new Color(139, 69, 19));
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setFocusPainted(false);
		btnAtras.setOpaque(false);
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				frmHistoriasDeZagas.dispose();
				
			}
		});
		btnAtras.setFont(mf.MyFont(0, 14));
		btnAtras.setBounds(10, 459, 99, 34);
		frmHistoriasDeZagas.getContentPane().add(btnAtras);

		JLabel lblSeleccionBendicion = new JLabel(
				"Poderes, Extras y Modificadores");
		lblSeleccionBendicion.setForeground(Color.WHITE);
		lblSeleccionBendicion.setFont(mf.MyFont(1, 36));
		lblSeleccionBendicion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSeleccionBendicion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionBendicion.setBounds(10, 0, 558, 60);
		frmHistoriasDeZagas.getContentPane().add(lblSeleccionBendicion);
		
		
		JLabel lblPoderes = new JLabel("Poderes");
		lblPoderes.setFont(mf.MyFont(0,24));
		lblPoderes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoderes.setForeground(Color.WHITE);
		lblPoderes.setBounds(10, 84, 175, 28);
		frmHistoriasDeZagas.getContentPane().add(lblPoderes);
		
		JLabel lblModificadores = new JLabel("Modificadores");
		lblModificadores.setFont(mf.MyFont(0,24));
		lblModificadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificadores.setForeground(Color.WHITE);
		lblModificadores.setBounds(393, 84, 175, 28);
		frmHistoriasDeZagas.getContentPane().add(lblModificadores);
		
		JLabel lblExtras = new JLabel("Extras");
		lblExtras.setFont(mf.MyFont(0,24));
		lblExtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblExtras.setForeground(Color.WHITE);
		lblExtras.setBounds(201, 84, 175, 28);
		frmHistoriasDeZagas.getContentPane().add(lblExtras);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ExtrasJugadores.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 578, 504);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);

	}

	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}
}
