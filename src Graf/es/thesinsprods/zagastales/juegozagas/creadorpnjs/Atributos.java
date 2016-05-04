package es.thesinsprods.zagastales.juegozagas.creadorpnjs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.OutOfPointsException;
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
import es.thesinsprods.zagastales.characters.skills.SkillPoints;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaAtributos;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Atributos {

	private JFrame frmHistoriasDeZagas;
	private JLabel lblFuerza;
	private JLabel lblDestreza;
	private JLabel lblResistencia;
	private JLabel lblResistenciaM;
	private JLabel lblInteligencia;
	private JLabel lblPercepcion;
	private JLabel lblCarisma;
	private JTextField txtResistenciaM;
	private JTextField txtResistencia;
	private JTextField txtDestreza;
	private JTextField txtFuerza;
	private JTextField txtInteligencia;
	private JTextField txtPercepcion;
	private JTextField txtCarisma;
	private JLabel lblPuntos;
	private JTextField txtPuntos;
	public static int minFuerza = 6;
	public static int minDestreza = 6;
	public static int minResistencia = 6;
	public static int minResistenciaM = 6;
	public static int minInteligencia = 6;
	public static int minPercepcion = 6;
	public static int minCarisma = 6;
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atributos window = new Atributos();
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
	public Atributos() {
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

		lblFuerza = new JLabel();
		lblFuerza.setForeground(Color.WHITE);
		lblFuerza.setOpaque(false);
		lblFuerza.setBackground(new Color(205, 133, 63));
		lblFuerza.setText("Fuerza:");
		lblFuerza.setBorder(null);
		lblFuerza.setFont(mf.MyFont(0, 15));
		lblFuerza.setBounds(10, 90, 165, 20);
		frmHistoriasDeZagas.getContentPane().add(lblFuerza);

		lblDestreza = new JLabel();
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setOpaque(false);
		lblDestreza.setBackground(new Color(205, 133, 63));
		lblDestreza.setText("Destreza:");
		lblDestreza.setFont(mf.MyFont(0, 15));
		lblDestreza.setBorder(null);
		lblDestreza.setBounds(10, 140, 165, 20);
		frmHistoriasDeZagas.getContentPane().add(lblDestreza);

		lblResistencia = new JLabel();
		lblResistencia.setForeground(Color.WHITE);
		lblResistencia.setOpaque(false);
		lblResistencia.setBackground(new Color(205, 133, 63));
		lblResistencia.setText("Resistencia:");
		lblResistencia.setFont(mf.MyFont(0, 15));
		lblResistencia.setBorder(null);
		lblResistencia.setBounds(10, 190, 165, 20);
		frmHistoriasDeZagas.getContentPane().add(lblResistencia);

		lblResistenciaM = new JLabel();
		lblResistenciaM.setForeground(Color.WHITE);
		lblResistenciaM.setOpaque(false);
		lblResistenciaM.setBackground(new Color(205, 133, 63));
		lblResistenciaM.setText("Resistencia M\u00E1gica:");
		lblResistenciaM.setFont(mf.MyFont(0, 15));
		lblResistenciaM.setBorder(null);
		lblResistenciaM.setBounds(10, 240, 165, 20);
		frmHistoriasDeZagas.getContentPane().add(lblResistenciaM);

		lblInteligencia = new JLabel();
		lblInteligencia.setForeground(Color.WHITE);
		lblInteligencia.setOpaque(false);
		lblInteligencia.setBackground(new Color(205, 133, 63));
		lblInteligencia.setText("Inteligencia:");
		lblInteligencia.setFont(mf.MyFont(0, 15));
		lblInteligencia.setBorder(null);
		lblInteligencia.setBounds(10, 290, 165, 20);
		frmHistoriasDeZagas.getContentPane().add(lblInteligencia);

		lblPercepcion = new JLabel();
		lblPercepcion.setForeground(Color.WHITE);
		lblPercepcion.setOpaque(false);
		lblPercepcion.setBackground(new Color(205, 133, 63));
		lblPercepcion.setText("Percepci\u00F3n:");
		lblPercepcion.setFont(mf.MyFont(0, 15));
		lblPercepcion.setBorder(null);
		lblPercepcion.setBounds(10, 340, 165, 20);
		frmHistoriasDeZagas.getContentPane().add(lblPercepcion);

		lblCarisma = new JLabel();
		lblCarisma.setForeground(Color.WHITE);
		lblCarisma.setOpaque(false);
		lblCarisma.setBackground(new Color(205, 133, 63));
		lblCarisma.setText("Carisma:");
		lblCarisma.setFont(mf.MyFont(0, 15));
		lblCarisma.setBorder(null);
		lblCarisma.setBounds(10, 390, 165, 20);
		frmHistoriasDeZagas.getContentPane().add(lblCarisma);

		txtResistenciaM = new JTextField();
		txtResistenciaM.setBackground(Color.WHITE);
		txtResistenciaM.setForeground(new Color(0, 0, 0));
		txtResistenciaM.setEditable(false);
		txtResistenciaM.setHorizontalAlignment(SwingConstants.CENTER);
		txtResistenciaM.setFont(mf.MyFont(0, 15));
		txtResistenciaM.setBounds(167, 240, 29, 21);
		txtResistenciaM.setText(""
				+ Start.character.getAtributes().getMagicres());
		frmHistoriasDeZagas.getContentPane().add(txtResistenciaM);
		txtResistenciaM.setColumns(10);

		txtResistencia = new JTextField();
		txtResistencia.setBackground(Color.WHITE);
		txtResistencia.setForeground(new Color(0, 0, 0));
		txtResistencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtResistencia.setFont(mf.MyFont(0, 15));
		txtResistencia.setEditable(false);
		txtResistencia.setColumns(10);
		txtResistencia.setBounds(167, 190, 29, 21);
		txtResistencia.setText(""
				+ Start.character.getAtributes().getResistance());
		frmHistoriasDeZagas.getContentPane().add(txtResistencia);

		txtDestreza = new JTextField();
		txtDestreza.setForeground(new Color(0, 0, 0));
		txtDestreza.setBackground(Color.WHITE);
		txtDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		txtDestreza.setFont(mf.MyFont(0, 15));
		txtDestreza.setEditable(false);
		txtDestreza.setColumns(10);
		txtDestreza.setBounds(167, 140, 29, 21);
		txtDestreza.setText("" + Start.character.getAtributes().getDexterity());
		frmHistoriasDeZagas.getContentPane().add(txtDestreza);

		txtFuerza = new JTextField();
		txtFuerza.setBackground(Color.WHITE);
		txtFuerza.setForeground(new Color(0, 0, 0));
		txtFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		txtFuerza.setFont(mf.MyFont(0, 15));
		txtFuerza.setEditable(false);
		txtFuerza.setColumns(10);
		txtFuerza.setBounds(167, 90, 29, 21);
		txtFuerza.setText("" + Start.character.getAtributes().getStrength());
		frmHistoriasDeZagas.getContentPane().add(txtFuerza);

		txtInteligencia = new JTextField();
		txtInteligencia.setBackground(Color.WHITE);
		txtInteligencia.setForeground(new Color(0, 0, 0));
		txtInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtInteligencia.setFont(mf.MyFont(0, 15));
		txtInteligencia.setEditable(false);
		txtInteligencia.setColumns(10);
		txtInteligencia.setBounds(167, 290, 29, 21);
		txtInteligencia.setText(""
				+ Start.character.getAtributes().getIntelligence());
		frmHistoriasDeZagas.getContentPane().add(txtInteligencia);

		txtPercepcion = new JTextField();
		txtPercepcion.setBackground(Color.WHITE);
		txtPercepcion.setForeground(new Color(0, 0, 0));
		txtPercepcion.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercepcion.setFont(mf.MyFont(0, 15));
		txtPercepcion.setEditable(false);
		txtPercepcion.setColumns(10);
		txtPercepcion.setBounds(167, 340, 29, 21);
		txtPercepcion.setText(""
				+ Start.character.getAtributes().getPerception());
		frmHistoriasDeZagas.getContentPane().add(txtPercepcion);

		txtCarisma = new JTextField();
		txtCarisma.setBackground(Color.WHITE);
		txtCarisma.setForeground(new Color(0, 0, 0));
		txtCarisma.setHorizontalAlignment(SwingConstants.CENTER);
		txtCarisma.setFont(mf.MyFont(0, 15));
		txtCarisma.setEditable(false);
		txtCarisma.setColumns(10);
		txtCarisma.setBounds(167, 390, 29, 21);
		txtCarisma.setText("" + Start.character.getAtributes().getCharisma());
		frmHistoriasDeZagas.getContentPane().add(txtCarisma);

		final JButton btnAadirF = new JButton("+");
		btnAadirF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadirF.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAadirF.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnAadirF.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirF.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnAadirF.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAadirF.setForeground(new Color(255, 255, 255));
		btnAadirF.setBackground(new Color(139, 69, 19));
		btnAadirF.setBorderPainted(false);
		btnAadirF.setContentAreaFilled(false);
		btnAadirF.setFocusPainted(false);
		btnAadirF.setOpaque(false);
		final JButton btnAadirD = new JButton("+");
		btnAadirD.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				btnAadirD.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAadirD.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnAadirD.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirD.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnAadirD.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAadirD.setForeground(new Color(255, 255, 255));
		btnAadirD.setBackground(new Color(139, 69, 19));
		btnAadirD.setBorderPainted(false);
		btnAadirD.setContentAreaFilled(false);
		btnAadirD.setFocusPainted(false);
		btnAadirD.setOpaque(false);
		final JButton btnAadirResistencia = new JButton("+");
		btnAadirResistencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadirResistencia.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAadirResistencia.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnAadirResistencia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirResistencia.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnAadirResistencia.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnAadirResistencia.setForeground(new Color(255, 255, 255));
		btnAadirResistencia.setBackground(new Color(139, 69, 19));
		btnAadirResistencia.setBorderPainted(false);
		btnAadirResistencia.setContentAreaFilled(false);
		btnAadirResistencia.setFocusPainted(false);
		btnAadirResistencia.setOpaque(false);
		final JButton btnAadirResistenciaM = new JButton("+");
		btnAadirResistenciaM.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadirResistenciaM.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAadirResistenciaM.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnAadirResistenciaM.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirResistenciaM.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnAadirResistenciaM.setBorder(new BevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btnAadirResistenciaM.setForeground(new Color(255, 255, 255));
		btnAadirResistenciaM.setBackground(new Color(139, 69, 19));
		btnAadirResistenciaM.setBorderPainted(false);
		btnAadirResistenciaM.setContentAreaFilled(false);
		btnAadirResistenciaM.setFocusPainted(false);
		btnAadirResistenciaM.setOpaque(false);
		final JButton btnAadirInteligencia = new JButton("+");
		btnAadirInteligencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadirInteligencia.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAadirInteligencia.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnAadirInteligencia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirInteligencia.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnAadirInteligencia.setBorder(new BevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btnAadirInteligencia.setForeground(new Color(255, 255, 255));
		btnAadirInteligencia.setBackground(new Color(139, 69, 19));
		btnAadirInteligencia.setBorderPainted(false);
		btnAadirInteligencia.setContentAreaFilled(false);
		btnAadirInteligencia.setFocusPainted(false);
		btnAadirInteligencia.setOpaque(false);
		final JButton btnAadirPercepcion = new JButton("+");
		btnAadirPercepcion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadirPercepcion.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAadirPercepcion.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnAadirPercepcion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirPercepcion.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnAadirPercepcion.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnAadirPercepcion.setForeground(new Color(255, 255, 255));
		btnAadirPercepcion.setBackground(new Color(139, 69, 19));
		btnAadirPercepcion.setBorderPainted(false);
		btnAadirPercepcion.setContentAreaFilled(false);
		btnAadirPercepcion.setFocusPainted(false);
		btnAadirPercepcion.setOpaque(false);
		final JButton btnAadirCarisma = new JButton("+");
		btnAadirCarisma.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadirCarisma.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAadirCarisma.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnAadirCarisma.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadirCarisma.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnAadirCarisma.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnAadirCarisma.setForeground(new Color(255, 255, 255));
		btnAadirCarisma.setBackground(new Color(139, 69, 19));
		btnAadirCarisma.setBorderPainted(false);
		btnAadirCarisma.setContentAreaFilled(false);
		btnAadirCarisma.setFocusPainted(false);
		btnAadirCarisma.setOpaque(false);
		final JButton btnQuitarFuerza = new JButton("-");
		btnQuitarFuerza.setBorderPainted(false);
		btnQuitarFuerza.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarFuerza.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnQuitarFuerza.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnQuitarFuerza.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarFuerza.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnQuitarFuerza.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnQuitarFuerza.setForeground(new Color(255, 255, 255));
		btnQuitarFuerza.setBackground(new Color(139, 69, 19));
		btnQuitarFuerza.setContentAreaFilled(false);
		btnQuitarFuerza.setFocusPainted(false);
		btnQuitarFuerza.setOpaque(false);
		final JButton btnQuitarDestreza = new JButton("-");
		btnQuitarDestreza.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarDestreza.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnQuitarDestreza.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnQuitarDestreza.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarDestreza.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnQuitarDestreza.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnQuitarDestreza.setForeground(new Color(255, 255, 255));
		btnQuitarDestreza.setBackground(new Color(139, 69, 19));
		btnQuitarDestreza.setBorderPainted(false);
		btnQuitarDestreza.setContentAreaFilled(false);
		btnQuitarDestreza.setFocusPainted(false);
		btnQuitarDestreza.setOpaque(false);
		final JButton btnQuitarResistencia = new JButton("-");
		btnQuitarResistencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarResistencia.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnQuitarResistencia.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnQuitarResistencia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarResistencia.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnQuitarResistencia.setBorder(new BevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btnQuitarResistencia.setForeground(new Color(255, 255, 255));
		btnQuitarResistencia.setBackground(new Color(139, 69, 19));
		btnQuitarResistencia.setBorderPainted(false);
		btnQuitarResistencia.setContentAreaFilled(false);
		btnQuitarResistencia.setFocusPainted(false);
		btnQuitarResistencia.setOpaque(false);
		final JButton btnQuitarResistenciaM = new JButton("-");
		btnQuitarResistenciaM.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarResistenciaM.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnQuitarResistenciaM.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnQuitarResistenciaM.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarResistenciaM.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnQuitarResistenciaM.setBorder(new BevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btnQuitarResistenciaM.setForeground(new Color(255, 255, 255));
		btnQuitarResistenciaM.setBackground(new Color(139, 69, 19));
		btnQuitarResistenciaM.setBorderPainted(false);
		btnQuitarResistenciaM.setContentAreaFilled(false);
		btnQuitarResistenciaM.setFocusPainted(false);
		btnQuitarResistenciaM.setOpaque(false);
		final JButton btnQuitarInteligencia = new JButton("-");
		btnQuitarInteligencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarInteligencia.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnQuitarInteligencia.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnQuitarInteligencia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarInteligencia.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnQuitarInteligencia.setBorder(new BevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btnQuitarInteligencia.setForeground(new Color(255, 255, 255));
		btnQuitarInteligencia.setBackground(new Color(139, 69, 19));
		btnQuitarInteligencia.setBorderPainted(false);
		btnQuitarInteligencia.setContentAreaFilled(false);
		btnQuitarInteligencia.setFocusPainted(false);
		btnQuitarInteligencia.setOpaque(false);
		final JButton btnQuitarPercepcion = new JButton("-");
		btnQuitarPercepcion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarPercepcion.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnQuitarPercepcion.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnQuitarPercepcion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarPercepcion.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnQuitarPercepcion.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnQuitarPercepcion.setForeground(new Color(255, 255, 255));
		btnQuitarPercepcion.setBackground(new Color(139, 69, 19));
		btnQuitarPercepcion.setBorderPainted(false);
		btnQuitarPercepcion.setContentAreaFilled(false);
		btnQuitarPercepcion.setFocusPainted(false);
		btnQuitarPercepcion.setOpaque(false);
		final JButton btnQuitarCarisma = new JButton("-");
		btnQuitarCarisma.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuitarCarisma.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +- 2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnQuitarCarisma.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atrib +-.png")));

			}

		});
		btnQuitarCarisma.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarCarisma.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atrib +-.png")));
		btnQuitarCarisma.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnQuitarCarisma.setForeground(new Color(255, 255, 255));
		btnQuitarCarisma.setBackground(new Color(139, 69, 19));
		btnQuitarCarisma.setBorderPainted(false);
		btnQuitarCarisma.setContentAreaFilled(false);
		btnQuitarCarisma.setFocusPainted(false);
		btnQuitarCarisma.setOpaque(false);
		btnAadirF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (Start.character.getAtributes().getStrength() >= minFuerza) {
						btnQuitarFuerza.setEnabled(true);
					}
					Start.character.getAtributes().increaseStrength(
							Start.atrpoints);
					txtFuerza.setText(""
							+ Start.character.getAtributes().getStrength());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getStrength() >= 17) {
						btnAadirF.setEnabled(false);
					}

				} catch (OutOfPointsException e1) {
					JOptionPane.showMessageDialog(frmHistoriasDeZagas,
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		btnAadirF.setBounds(256, 90, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnAadirF);

		btnAadirD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (Start.character.getAtributes().getDexterity() >= minDestreza) {
						btnQuitarDestreza.setEnabled(true);
					}
					Start.character.getAtributes().increaseDexterity(
							Start.atrpoints);
					txtDestreza.setText(""
							+ Start.character.getAtributes().getDexterity());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getDexterity() >= 17) {
						btnAadirD.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					JOptionPane.showMessageDialog(frmHistoriasDeZagas,
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnAadirD.setBounds(256, 140, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnAadirD);

		btnAadirResistencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getResistance() >= minResistencia) {
						btnQuitarResistencia.setEnabled(true);
					}
					Start.character.getAtributes().increaseResistance(
							Start.atrpoints);
					txtResistencia.setText(""
							+ Start.character.getAtributes().getResistance());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getResistance() >= 17) {
						btnAadirResistencia.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					JOptionPane.showMessageDialog(frmHistoriasDeZagas,
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAadirResistencia.setBounds(256, 190, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnAadirResistencia);

		btnAadirResistenciaM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getMagicres() >= minResistenciaM) {
						btnQuitarResistenciaM.setEnabled(true);
					}
					Start.character.getAtributes().increaseMagicRes(
							Start.atrpoints);
					txtResistenciaM.setText(""
							+ Start.character.getAtributes().getMagicres());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getMagicres() >= 17) {
						btnAadirResistenciaM.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					JOptionPane.showMessageDialog(frmHistoriasDeZagas,
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAadirResistenciaM.setBounds(256, 240, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnAadirResistenciaM);

		btnAadirInteligencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getIntelligence() >= minInteligencia) {
						btnQuitarInteligencia.setEnabled(true);
					}
					Start.character.getAtributes().increaseIntelligence(
							Start.atrpoints);
					txtInteligencia.setText(""
							+ Start.character.getAtributes().getIntelligence());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getIntelligence() >= 17) {
						btnAadirInteligencia.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					JOptionPane.showMessageDialog(frmHistoriasDeZagas,
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAadirInteligencia.setBounds(256, 290, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnAadirInteligencia);

		btnAadirPercepcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getPerception() >= minPercepcion) {
						btnQuitarPercepcion.setEnabled(true);
					}
					Start.character.getAtributes().increasePerception(
							Start.atrpoints);
					txtPercepcion.setText(""
							+ Start.character.getAtributes().getPerception());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getPerception() >= 17) {
						btnAadirPercepcion.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					JOptionPane.showMessageDialog(frmHistoriasDeZagas,
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAadirPercepcion.setBounds(256, 340, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnAadirPercepcion);

		btnAadirCarisma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getCharisma() >= minCarisma) {
						btnQuitarCarisma.setEnabled(true);
					}
					Start.character.getAtributes().increaseCharisma(
							Start.atrpoints);
					txtCarisma.setText(""
							+ Start.character.getAtributes().getCharisma());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getCharisma() >= 17) {
						btnAadirCarisma.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					JOptionPane.showMessageDialog(frmHistoriasDeZagas,
							"No tienes suficientes puntos", "",
							JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAadirCarisma.setBounds(256, 390, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnAadirCarisma);

		btnQuitarFuerza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getStrength() <= 20) {
						btnAadirF.setEnabled(true);
					}
					Start.character.getAtributes().decreaseStrength(
							Start.atrpoints);
					txtFuerza.setText(""
							+ Start.character.getAtributes().getStrength());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getStrength() <= minFuerza) {
						btnQuitarFuerza.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuitarFuerza.setBounds(417, 90, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnQuitarFuerza);
		btnQuitarDestreza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getDexterity() <= 20) {
						btnAadirD.setEnabled(true);
					}
					Start.character.getAtributes().decreaseDexterity(
							Start.atrpoints);
					txtDestreza.setText(""
							+ Start.character.getAtributes().getDexterity());
					txtPuntos.setText("" + Start.atrpoints.getPoints());

					if ((Start.character.getAtributes().getDexterity() <= minDestreza)) {
						btnQuitarDestreza.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuitarDestreza.setBounds(417, 140, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnQuitarDestreza);

		btnQuitarResistencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getResistance() <= 17) {
						btnAadirResistencia.setEnabled(true);
					}
					Start.character.getAtributes().decreaseResistance(
							Start.atrpoints);
					txtResistencia.setText(""
							+ Start.character.getAtributes().getResistance());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getResistance() <= minResistencia) {
						btnQuitarResistencia.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuitarResistencia.setBounds(417, 190, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnQuitarResistencia);

		btnQuitarResistenciaM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getMagicres() <= 17) {
						btnAadirResistenciaM.setEnabled(true);
					}
					Start.character.getAtributes().decreaseMagicRes(
							Start.atrpoints);
					txtResistenciaM.setText(""
							+ Start.character.getAtributes().getMagicres());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getMagicres() <= minResistenciaM) {
						btnQuitarResistenciaM.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuitarResistenciaM.setBounds(417, 240, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnQuitarResistenciaM);

		btnQuitarInteligencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getIntelligence() <= 17) {
						btnAadirInteligencia.setEnabled(true);
					}
					Start.character.getAtributes().decreaseIntelligence(
							Start.atrpoints);
					txtInteligencia.setText(""
							+ Start.character.getAtributes().getIntelligence());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getIntelligence() <= minInteligencia) {
						btnQuitarInteligencia.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuitarInteligencia.setBounds(417, 290, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnQuitarInteligencia);

		btnQuitarPercepcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getPerception() <= 17) {
						btnAadirPercepcion.setEnabled(true);
					}
					Start.character.getAtributes().decreasePerception(
							Start.atrpoints);
					txtPercepcion.setText(""
							+ Start.character.getAtributes().getPerception());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getPerception() <= minPercepcion) {
						btnQuitarPercepcion.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuitarPercepcion.setBounds(417, 340, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnQuitarPercepcion);

		btnQuitarCarisma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Start.character.getAtributes().getCharisma() <= 17) {
						btnAadirCarisma.setEnabled(true);
					}
					Start.character.getAtributes().decreaseCharisma(
							Start.atrpoints);
					txtCarisma.setText(""
							+ Start.character.getAtributes().getCharisma());
					txtPuntos.setText("" + Start.atrpoints.getPoints());
					if (Start.character.getAtributes().getCharisma() <= minCarisma) {
						btnQuitarCarisma.setEnabled(false);
					}
				} catch (OutOfPointsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQuitarCarisma.setBounds(417, 390, 125, 23);
		frmHistoriasDeZagas.getContentPane().add(btnQuitarCarisma);

		final JButton btnContinuar = new JButton("");
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton continuar2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnContinuar.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton continuar2.png")));
			}
		});
		btnContinuar.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton continuar.png")));
		btnContinuar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnContinuar.setForeground(new Color(255, 255, 255));
		btnContinuar.setBorderPainted(false);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setFocusPainted(false);
		btnContinuar.setOpaque(false);
		btnContinuar.setBackground(new Color(139, 69, 19));
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipo.pweap = Start.character.getEquipment()
						.CalculoPesoWeapons(
								Start.character.getAtributes().getStrength());
				Equipo.pmisc = Start.character.getEquipment().CalculoPesoMisc(
						Start.character.getAtributes().getStrength());
				if (Equipo.pweap < Equipo.armasPuestas) {
					int seleccion = JOptionPane
							.showOptionDialog(
									frmHistoriasDeZagas,
									"Llevas más armas de las permitidas por tu fuerza, quitate armas y vuelve a modificar tu atributo.",
									"¡Atención!", JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, // null
																// para
																// YES,
																// NO y
																// CANCEL
									"opcion 1");

				} else if (Equipo.pmisc < Equipo.objetosPuestos) {
					int seleccion = JOptionPane
							.showOptionDialog(
									frmHistoriasDeZagas,
									"Llevas más objetos de los permitidos por tu fuerza, quitate objetos y vuelve a modificar tu atributo.",
									"¡Atención!", JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, // null
																// para
																// YES,
																// NO y
																// CANCEL
									"opcion 1");
				} else {
					int error=0;
					int minimo=0;
					if(Equipo.weapon1.getTipo().equals("Espadón") || Equipo.weapon1.getTipo().equals("Hacha de Guerra") || Equipo.weapon2.getTipo().equals("Espadón") || Equipo.weapon2.getTipo().equals("Hacha de Guerra") || Equipo.weapon3.getTipo().equals("Espadón") || Equipo.weapon3.getTipo().equals("Hacha de Guerra") || Equipo.weapon4.getTipo().equals("Espadón") || Equipo.weapon4.getTipo().equals("Hacha de Guerra"))
					{
					if(Start.character.getAtributes().getStrength()<10)	{
						error++;
						minimo=10;
					}
					}
					if(Equipo.weapon1.getTipo().equals("Martillo de Guerra") || Equipo.weapon2.getTipo().equals("Martillo de Guerra") || Equipo.weapon3.getTipo().equals("Martillo de Guerra") || Equipo.weapon4.getTipo().equals("Martillo de Guerra")){
						
						if(Start.character.getAtributes().getStrength()<12){
							
							error++;
							minimo=12;
						}
					}
					if(Equipo.weapon1.getTipo().equals("Ultra-Espadón") || Equipo.weapon2.getTipo().equals("Ultra-Espadón") || Equipo.weapon3.getTipo().equals("Ultra-Espadón") || Equipo.weapon4.getTipo().equals("Ultra-Espadón")){
						if(Start.character.getAtributes().getStrength()<15){
						error++;
						minimo=15;
						}
						
					}
					
					if(Equipo.weapon1.getTipo().equals("Escudo Medio") || Equipo.weapon2.getTipo().equals("Escudo Medio") || Equipo.weapon3.getTipo().equals("Escudo Medio") || Equipo.weapon4.getTipo().equals("Escudo Medio")){
						
						if(Start.character.getAtributes().getStrength()<10){
							
							error++;
							minimo=10;
						}
					}
					
					if(Equipo.weapon1.getTipo().equals("Escudo de Torre") || Equipo.weapon2.getTipo().equals("Escudo de Torre") || Equipo.weapon3.getTipo().equals("Escudo de Torre") || Equipo.weapon4.getTipo().equals("Escudo de Torre")){
						if(Start.character.getAtributes().getStrength()<15){
						error++;
						minimo=15;
						}
						
					}
					
					if(error==0){
					frmHistoriasDeZagas.dispose();
					Habilidades window = new Habilidades();
					window.getFrame().setVisible(true);
					}
					if(error!=0){
						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"No cumples los requisitos mínimos de fuerza para las armas que llevas. Fuerza minima necesaria="+minimo,
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
			}
		});
		btnContinuar.setFont(mf.MyFont(0, 13));
		btnContinuar.setBounds(473, 458, 105, 35);
		frmHistoriasDeZagas.getContentPane().add(btnContinuar);

		txtPuntos = new JTextField();
		txtPuntos.setForeground(new Color(0, 0, 0));
		txtPuntos.setBackground(Color.WHITE);
		txtPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntos.setFont(mf.MyFont(0, 15));
		txtPuntos.setEditable(false);
		txtPuntos.setColumns(10);
		txtPuntos.setBounds(64, 461, 29, 21);
		int test = Start.atrpoints.getPoints();
		txtPuntos.setText("" + test);
		frmHistoriasDeZagas.getContentPane().add(txtPuntos);

		lblPuntos = new JLabel();
		lblPuntos.setForeground(Color.WHITE);
		lblPuntos.setOpaque(false);
		lblPuntos.setBackground(new Color(205, 133, 63));
		lblPuntos.setText("Puntos:");
		lblPuntos.setFont(mf.MyFont(0, 15));
		lblPuntos.setBorder(null);
		lblPuntos.setBounds(10, 461, 80, 20);
		frmHistoriasDeZagas.getContentPane().add(lblPuntos);

		final JButton btnAtras = new JButton("");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atras2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnAtras.setIcon(new ImageIcon(Atributos.class
						.getResource("/images/boton atras.png")));
			}
		});
		btnAtras.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/boton atras.png")));
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setFocusPainted(false);
		btnAtras.setOpaque(false);
		btnAtras.setBackground(new Color(139, 69, 19));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHistoriasDeZagas.dispose();
				Privilegios window = new Privilegios();
				try {
					Start.character.getPrivileges().CalculoPrivilegiosInv(
							Start.character);
				} catch (AtributeOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (Start.character.getSetbacks().getReves().size() != 0) {
					try {
						Start.character.getSetbacks().CalculoRevesesInv(
								Start.character);
					} catch (AtributeOutOfBoundsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Privileges privilegio = new Privileges();
				Setbacks reves = new Setbacks();
				Start.character.setPrivileges(privilegio);
				Start.character.setSetbacks(reves);
				window.getFrame().setVisible(true);
			}
		});
		btnAtras.setFont(mf.MyFont(0, 13));
		btnAtras.setBounds(103, 458, 105, 35);
		frmHistoriasDeZagas.getContentPane().add(btnAtras);

		final JButton btnInicio = new JButton("Inicio");
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
		btnInicio.setBounds(218, 458, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnInicio);

		final JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaAtributos window = new AyudaAtributos();
				window.getFrame().setVisible(true);
			}
		});
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
		btnAyuda.setIcon(new ImageIcon(Privilegios.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnAyuda.setOpaque(false);
		btnAyuda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setFont(mf.MyFont(0, 15));
		btnAyuda.setFocusPainted(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBounds(352, 458, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnAyuda);

		JLabel lblAtributos = new JLabel("Atributos");
		lblAtributos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtributos.setFont(mf.MyFont(1, 36));
		lblAtributos.setForeground(Color.WHITE);
		lblAtributos.setBounds(10, 0, 558, 66);
		frmHistoriasDeZagas.getContentPane().add(lblAtributos);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Atributos.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 578, 504);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
		if (Start.character.getAtributes().getStrength() > minFuerza) {
			btnQuitarFuerza.setEnabled(true);
		}
		if (Start.character.getAtributes().getDexterity() > minDestreza) {
			btnQuitarDestreza.setEnabled(true);
		}
		if (Start.character.getAtributes().getResistance() > minResistencia) {
			btnQuitarResistencia.setEnabled(true);
		}
		if (Start.character.getAtributes().getMagicres() > minResistenciaM) {
			btnQuitarResistenciaM.setEnabled(true);
		}
		if (Start.character.getAtributes().getIntelligence() > minInteligencia) {
			btnQuitarInteligencia.setEnabled(true);
		}
		if (Start.character.getAtributes().getPerception() > minPercepcion) {
			btnQuitarPercepcion.setEnabled(true);
		}
		if (Start.character.getAtributes().getCharisma() > minCarisma) {
			btnQuitarCarisma.setEnabled(true);
		}
		if (Start.character.getAtributes().getStrength() < 20) {
			btnAadirF.setEnabled(true);
		}
		if (Start.character.getAtributes().getDexterity() < 20) {
			btnAadirD.setEnabled(true);
		}
		if (Start.character.getAtributes().getResistance() < 20) {
			btnAadirResistencia.setEnabled(true);
		}
		if (Start.character.getAtributes().getMagicres() < 20) {
			btnAadirResistenciaM.setEnabled(true);
		}
		if (Start.character.getAtributes().getIntelligence() < 20) {
			btnAadirInteligencia.setEnabled(true);
		}
		if (Start.character.getAtributes().getPerception() < 20) {
			btnAadirPercepcion.setEnabled(true);
		}
		if (Start.character.getAtributes().getCharisma() < 20) {
			btnAadirCarisma.setEnabled(true);
		}
		if (Start.character.getAtributes().getStrength() == minFuerza) {
			btnQuitarFuerza.setEnabled(false);
		}
		if (Start.character.getAtributes().getDexterity() == minDestreza) {
			btnQuitarDestreza.setEnabled(false);
		}
		if (Start.character.getAtributes().getResistance() == minResistencia) {
			btnQuitarResistencia.setEnabled(false);
		}
		if (Start.character.getAtributes().getMagicres() == minResistenciaM) {
			btnQuitarResistenciaM.setEnabled(false);
		}
		if (Start.character.getAtributes().getIntelligence() == minInteligencia) {
			btnQuitarInteligencia.setEnabled(false);
		}
		if (Start.character.getAtributes().getPerception() == minPercepcion) {
			btnQuitarPercepcion.setEnabled(false);
		}
		if (Start.character.getAtributes().getCharisma() == minCarisma) {
			btnQuitarCarisma.setEnabled(false);
		}
		if (Start.character.getAtributes().getStrength() == 20) {
			btnAadirF.setEnabled(false);
		}
		if (Start.character.getAtributes().getDexterity() == 20) {
			btnAadirD.setEnabled(false);
		}
		if (Start.character.getAtributes().getResistance() == 20) {
			btnAadirResistencia.setEnabled(false);
		}
		if (Start.character.getAtributes().getMagicres() == 20) {
			btnAadirResistenciaM.setEnabled(false);
		}
		if (Start.character.getAtributes().getIntelligence() == 20) {
			btnAadirInteligencia.setEnabled(false);
		}
		if (Start.character.getAtributes().getPerception() == 20) {
			btnAadirPercepcion.setEnabled(false);
		}
		if (Start.character.getAtributes().getCharisma() < 20) {
			btnAadirCarisma.setEnabled(true);
		}
	}
}
