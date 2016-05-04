package es.thesinsprods.zagastales.juegozagas.creadorpnjs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.equipment.Accesories;
import es.thesinsprods.zagastales.characters.equipment.Armor;
import es.thesinsprods.zagastales.characters.equipment.Cloak;
import es.thesinsprods.zagastales.characters.equipment.Earrings;
import es.thesinsprods.zagastales.characters.equipment.Misc;
import es.thesinsprods.zagastales.characters.equipment.Necklace;
import es.thesinsprods.zagastales.characters.equipment.OneHanded;
import es.thesinsprods.zagastales.characters.equipment.Pole;
import es.thesinsprods.zagastales.characters.equipment.Possesions;
import es.thesinsprods.zagastales.characters.equipment.Ranged;
import es.thesinsprods.zagastales.characters.equipment.Rings;
import es.thesinsprods.zagastales.characters.equipment.Shields;
import es.thesinsprods.zagastales.characters.equipment.TwoHanded;
import es.thesinsprods.zagastales.characters.equipment.Weapons;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;

public class Posesiones {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private final JPanel contentPanel = new JPanel();
	public static String tipoac;
	public static String tipoarm;
	public static int app = 0;
	public static int exp = 0;
	public static int masp = 0;
	public static Possesions pos;
	public static int ppos = 3;
	public static int[] pgasto = new int[] { 0, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3,
			3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
			3, 3, 1, 1, 1, 1, 1, 1, 1, 3,2,2,2 };
	public static int ppos1 = 0;
	public static int ppos2 = 0;
	public static int ppos3 = 0;
	ArrayList<String> pos1 = new ArrayList<String>();
	private JTextField txtquEsTu;
	private JTextField txtTipoDeArma;
	private JTextField txtTipoDeAccesorio;
	private JTextField txtNombre;
	private JTextField textField;
	private JTextField txtDescripcin_1;
	private JTextField txtPosesionesRestantes;
	private JTextField textField_1;

	private JTextField txtTipoArmadura;
	private JTextField txtField;
	private JTextField txtPuntosDePosesin;
	private JTextField txtPropiedadesPosesin;
	private JTextField textField_3;
	MorpheusFont mf = new MorpheusFont();
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Posesiones window = new Posesiones();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Posesiones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						Armas.class
								.getResource("/images/Historias de Zagas, logo.png")));
		frame.setBounds(100, 100, 469, 562);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		txtquEsTu = new JTextField();
		txtquEsTu.setForeground(Color.WHITE);
		txtquEsTu.setOpaque(false);
		txtquEsTu.setBackground(new Color(205, 133, 63));
		txtquEsTu.setText("\u00BFQu\u00E9 es tu posesi\u00F3n?");
		txtquEsTu.setFont(mf.MyFont(0, 13));
		txtquEsTu.setEditable(false);
		txtquEsTu.setColumns(10);
		txtquEsTu.setBorder(null);
		txtquEsTu.setBounds(10, 59, 114, 20);
		frame.getContentPane().add(txtquEsTu);

		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);

		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"-Posesi\u00F3n-", "Armadura", "Arma", "Objeto", "Accesorio" }));
		comboBox.setFont(mf.MyFont(0, 13));
		comboBox.setBounds(10, 90, 87, 20);
		frame.getContentPane().add(comboBox);

		txtTipoDeArma = new JTextField();
		txtTipoDeArma.setForeground(Color.WHITE);
		txtTipoDeArma.setOpaque(false);
		txtTipoDeArma.setBackground(new Color(205, 133, 63));
		txtTipoDeArma.setVisible(false);
		txtTipoDeArma.setEditable(false);
		txtTipoDeArma.setText("Tipo de Arma");
		txtTipoDeArma.setFont(mf.MyFont(0, 13));
		txtTipoDeArma.setColumns(10);
		txtTipoDeArma.setBorder(null);
		txtTipoDeArma.setBounds(209, 60, 114, 20);
		frame.getContentPane().add(txtTipoDeArma);

		txtTipoDeAccesorio = new JTextField();
		txtTipoDeAccesorio.setForeground(Color.WHITE);
		txtTipoDeAccesorio.setOpaque(false);
		txtTipoDeAccesorio.setBackground(new Color(205, 133, 63));
		txtTipoDeAccesorio.setVisible(false);
		txtTipoDeAccesorio.setText("Tipo de Accesorio");
		txtTipoDeAccesorio.setFont(mf.MyFont(0, 13));
		txtTipoDeAccesorio.setEditable(false);
		txtTipoDeAccesorio.setColumns(10);
		txtTipoDeAccesorio.setBorder(null);
		txtTipoDeAccesorio.setBounds(209, 60, 114, 20);
		frame.getContentPane().add(txtTipoDeAccesorio);

		final JCheckBox chckbxUnaMano = new JCheckBox("Una Mano");
		chckbxUnaMano.setForeground(Color.WHITE);
		chckbxUnaMano.setOpaque(false);
		chckbxUnaMano.setBackground(new Color(205, 133, 63));

		chckbxUnaMano.setVisible(false);
		chckbxUnaMano.setFont(mf.MyFont(0, 11));
		chckbxUnaMano.setBounds(209, 90, 138, 23);
		frame.getContentPane().add(chckbxUnaMano);

		final JCheckBox chckbxDosManos = new JCheckBox("Dos Manos");
		chckbxDosManos.setForeground(Color.WHITE);
		chckbxDosManos.setOpaque(false);
		chckbxDosManos.setBackground(new Color(205, 133, 63));
		chckbxDosManos.setVisible(false);
		chckbxDosManos.setFont(mf.MyFont(0, 11));
		chckbxDosManos.setBounds(209, 116, 138, 23);
		frame.getContentPane().add(chckbxDosManos);

		final JCheckBox chckbxDeAsta = new JCheckBox("De Asta");
		chckbxDeAsta.setForeground(Color.WHITE);
		chckbxDeAsta.setOpaque(false);
		chckbxDeAsta.setBackground(new Color(205, 133, 63));
		chckbxDeAsta.setVisible(false);
		chckbxDeAsta.setFont(mf.MyFont(0, 11));
		chckbxDeAsta.setBounds(209, 142, 138, 23);
		frame.getContentPane().add(chckbxDeAsta);

		final JCheckBox chckbxADistancia = new JCheckBox("A Distancia");
		chckbxADistancia.setForeground(Color.WHITE);
		chckbxADistancia.setOpaque(false);
		chckbxADistancia.setBackground(new Color(205, 133, 63));
		chckbxADistancia.setVisible(false);
		chckbxADistancia.setFont(mf.MyFont(0, 11));
		chckbxADistancia.setBounds(209, 168, 138, 23);
		frame.getContentPane().add(chckbxADistancia);

		final JCheckBox chckbxEscudo = new JCheckBox("Escudo");
		chckbxEscudo.setForeground(Color.WHITE);
		chckbxEscudo.setOpaque(false);
		chckbxEscudo.setBackground(new Color(205, 133, 63));
		chckbxEscudo.setVisible(false);
		chckbxEscudo.setFont(mf.MyFont(0, 11));
		chckbxEscudo.setBounds(209, 194, 138, 23);
		frame.getContentPane().add(chckbxEscudo);

		final JCheckBox chckbxAnillo = new JCheckBox("Anillo");
		chckbxAnillo.setForeground(Color.WHITE);
		chckbxAnillo.setOpaque(false);
		chckbxAnillo.setBackground(new Color(205, 133, 63));
		chckbxAnillo.setVisible(false);
		chckbxAnillo.setFont(mf.MyFont(0, 11));
		chckbxAnillo.setBounds(209, 90, 138, 23);
		frame.getContentPane().add(chckbxAnillo);

		final JCheckBox chckbxColgante = new JCheckBox("Colgante");
		chckbxColgante.setForeground(Color.WHITE);
		chckbxColgante.setOpaque(false);
		chckbxColgante.setBackground(new Color(205, 133, 63));
		chckbxColgante.setVisible(false);
		chckbxColgante.setFont(mf.MyFont(0, 11));
		chckbxColgante.setBounds(209, 116, 138, 23);
		frame.getContentPane().add(chckbxColgante);

		final JCheckBox chckbxPendiente = new JCheckBox("Pendiente");
		chckbxPendiente.setForeground(Color.WHITE);
		chckbxPendiente.setOpaque(false);
		chckbxPendiente.setBackground(new Color(205, 133, 63));
		chckbxPendiente.setVisible(false);
		chckbxPendiente.setFont(mf.MyFont(0, 11));
		chckbxPendiente.setBounds(209, 142, 138, 23);
		frame.getContentPane().add(chckbxPendiente);

		final JCheckBox chckbxCapa = new JCheckBox("Capa");
		chckbxCapa.setForeground(Color.WHITE);
		chckbxCapa.setOpaque(false);
		chckbxCapa.setBackground(new Color(205, 133, 63));
		chckbxCapa.setVisible(false);
		chckbxCapa.setFont(mf.MyFont(0, 11));
		chckbxCapa.setBounds(209, 168, 138, 23);
		frame.getContentPane().add(chckbxCapa);

		txtNombre = new JTextField();
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setOpaque(false);
		txtNombre.setBackground(new Color(205, 133, 63));
		txtNombre.setText("Nombre:");
		txtNombre.setFont(mf.MyFont(0, 11));
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBorder(null);
		txtNombre.setBounds(10, 144, 114, 20);
		frame.getContentPane().add(txtNombre);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setFont(mf.MyFont(0, 11));
		textField.setColumns(10);
		textField.setBounds(10, 175, 138, 20);
		frame.getContentPane().add(textField);

		txtDescripcin_1 = new JTextField();
		txtDescripcin_1.setForeground(Color.WHITE);
		txtDescripcin_1.setOpaque(false);
		txtDescripcin_1.setBackground(new Color(205, 133, 63));
		txtDescripcin_1.setText("Descripci\u00F3n:");
		txtDescripcin_1.setFont(mf.MyFont(0, 13));
		txtDescripcin_1.setEditable(false);
		txtDescripcin_1.setColumns(10);
		txtDescripcin_1.setBorder(null);
		txtDescripcin_1.setBounds(10, 293, 223, 20);
		frame.getContentPane().add(txtDescripcin_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 324, 223, 89);
		frame.getContentPane().add(scrollPane);

		final JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setFont(mf.MyFont(0, 13));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);

		txtPosesionesRestantes = new JTextField();
		txtPosesionesRestantes.setForeground(Color.WHITE);
		txtPosesionesRestantes.setOpaque(false);
		txtPosesionesRestantes.setBackground(new Color(205, 133, 63));
		txtPosesionesRestantes.setText("Posesiones Restantes:");
		txtPosesionesRestantes.setFont(mf.MyFont(0, 13));
		txtPosesionesRestantes.setEditable(false);
		txtPosesionesRestantes.setColumns(10);
		txtPosesionesRestantes.setBorder(null);
		txtPosesionesRestantes.setBounds(10, 11, 120, 20);
		frame.getContentPane().add(txtPosesionesRestantes);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setText("" + Start.contadorPosesion);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(mf.MyFont(0, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(140, 9, 31, 20);
		frame.getContentPane().add(textField_1);
		final JCheckBox chckbxArmaduraLigera = new JCheckBox("Armadura Ligera");
		chckbxArmaduraLigera.setForeground(Color.WHITE);
		chckbxArmaduraLigera.setOpaque(false);
		chckbxArmaduraLigera.setBackground(new Color(205, 133, 63));
		final JCheckBox chckbxArmaduraPesada = new JCheckBox("Armadura Pesada");
		chckbxArmaduraPesada.setForeground(Color.WHITE);
		chckbxArmaduraPesada.setOpaque(false);
		chckbxArmaduraPesada.setBackground(new Color(205, 133, 63));

		final JCheckBox chckbxTela = new JCheckBox("Tela");
		chckbxTela.setForeground(Color.WHITE);
		chckbxTela.setOpaque(false);
		chckbxTela.setBackground(new Color(205, 133, 63));
		final JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadir.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton a\u00F1adir2.png")));
			}

			public void mouseReleased(MouseEvent e) {
				btnAadir.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton a\u00F1adir.png")));
			}
		});
		btnAadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadir.setIcon(new ImageIcon(Posesiones.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnAadir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAadir.setForeground(new Color(255, 255, 255));
		btnAadir.setBackground(new Color(139, 69, 19));
		btnAadir.setBorderPainted(false);
		btnAadir.setContentAreaFilled(false);
		btnAadir.setFocusPainted(false);
		btnAadir.setOpaque(false);
		final JComboBox comboBox_4 = new JComboBox();
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ppos >= 0) {
					Possesions poss = new Possesions(pos1);

					int cont = 0;
					if (comboBox.getSelectedIndex() == 1) {
						if (Equipo.getTextField_12().getText().equals("")) {
							if (chckbxTela.isSelected() == true) {

								Equipo.armor1 = new Armor("Tela", textArea
										.getText(), true,false, poss);
							}
							if (chckbxArmaduraLigera.isSelected() == true
									&& Start.character.getAtributes()
											.getStrength() > 8) {
								Equipo.armor1 = new Armor("Armadura Ligera",
										textArea.getText(), true,false, poss);
							}
							if (chckbxArmaduraLigera.isSelected() == true
									&& Start.character.getAtributes()
											.getStrength() <= 8) {
								int dexN = Start.character.getAtributes()
										.getDexterity();
								try {
									Start.character.getAtributes()
											.setDexterity(dexN - 1);
									Equipo.armor1 = new Armor(
											"Armadura Ligera", textArea
													.getText(), true,false, poss);
								} catch (AtributeOutOfBoundsException e1) {
									JOptionPane
											.showMessageDialog(
													frame.getContentPane(),
													"No puedes equiparte una armadura ligera dado que tendrías una destreza menor de 6",
													"",
													JOptionPane.ERROR_MESSAGE);
									cont = 1;
								}

							}
							if (chckbxArmaduraPesada.isSelected() == true
									&& Start.character.getAtributes()
											.getStrength() > 12
									&& Start.character.getPrivileges().Search(
											"Fornido") == false) {
								int dexN = Start.character.getAtributes()
										.getDexterity();
								try {
									Start.character.getAtributes()
											.setDexterity(dexN - 1);
									Equipo.armor1 = new Armor(
											"Armadura Pesada", textArea
													.getText(), true,false, poss);
								} catch (AtributeOutOfBoundsException e1) {
									JOptionPane
											.showMessageDialog(
													frame.getContentPane(),
													"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
													"",
													JOptionPane.ERROR_MESSAGE);
									cont = 1;
								}

							}
							if (chckbxArmaduraPesada.isSelected() == true
									&& Start.character.getAtributes()
											.getStrength() > 12
									&& Start.character.getPrivileges().Search(
											"Fornido") == true) {
								int dexN = Start.character.getAtributes()
										.getDexterity();
								try {
									Start.character.getAtributes()
											.setDexterity(dexN);
									Equipo.armor1 = new Armor(
											"Armadura Pesada", textArea
													.getText(), true,false, poss);
								} catch (AtributeOutOfBoundsException e1) {
									JOptionPane
											.showMessageDialog(
													frame.getContentPane(),
													"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
													"",
													JOptionPane.ERROR_MESSAGE);
									cont = 1;
								}

							}
							if (chckbxArmaduraPesada.isSelected() == true
									&& Start.character.getAtributes()
											.getStrength() <= 12
									&& Start.character.getAtributes()
											.getStrength() > 10) {
								int dexN = Start.character.getAtributes()
										.getDexterity();
								try {
									Start.character.getAtributes()
											.setDexterity(dexN - 2);
									Equipo.armor1 = new Armor(
											"Armadura Pesada", textArea
													.getText(), true,false, poss);
								} catch (AtributeOutOfBoundsException e1) {
									JOptionPane
											.showMessageDialog(
													frame.getContentPane(),
													"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
													"",
													JOptionPane.ERROR_MESSAGE);
									cont = 1;
								}

							}
							if (chckbxArmaduraPesada.isSelected() == true
									&& Start.character.getAtributes()
											.getStrength() <= 10
									&& Start.character.getAtributes()
											.getStrength() > 8) {
								int dexN = Start.character.getAtributes()
										.getDexterity();
								try {
									Start.character.getAtributes()
											.setDexterity(dexN - 3);
									Equipo.armor1 = new Armor(
											"Armadura Pesada", textArea
													.getText(), true,false, poss);
								} catch (AtributeOutOfBoundsException e1) {
									JOptionPane
											.showMessageDialog(
													frame.getContentPane(),
													"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
													"",
													JOptionPane.ERROR_MESSAGE);
									cont = 1;
								}

							}
							if (chckbxArmaduraPesada.isSelected() == true
									&& Start.character.getAtributes()
											.getStrength() <= 8
									&& Start.character.getAtributes()
											.getStrength() >= 6) {
								int dexN = Start.character.getAtributes()
										.getDexterity();
								try {
									Start.character.getAtributes()
											.setDexterity(dexN - 4);
									Equipo.armor1 = new Armor(
											"Armadura Pesada", textArea
													.getText(), true,false, poss);
								} catch (AtributeOutOfBoundsException e1) {
									JOptionPane
											.showMessageDialog(
													frame.getContentPane(),
													"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
													"",
													JOptionPane.ERROR_MESSAGE);
									cont = 1;
								}

							}
							if (cont == 0) {
								int cont2 = 0;
								try {
									poss.CalculoPosesion(Start.character);
								} catch (AtributeOutOfBoundsException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (SkillOutOfBoundsException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								if (app == 1) {
									app = 0;
									cont2 = 1;
									JOptionPane
											.showMessageDialog(
													frame.getContentPane(),
													"No puedes tener esa propiedad de posesión dado que tienes el reves aprendiz y no puedes subir a más de nivel dos las habilidades.",
													"",
													JOptionPane.ERROR_MESSAGE);
									Equipo.armor1 = new Armor("", "", false,false,
											null);
								}
								if (exp == 1) {
									exp = 0;
									cont2 = 1;
									JOptionPane
											.showMessageDialog(
													frame.getContentPane(),
													"No puedes tener esa propiedad de posesión dado que no tienes el privilegio experto y no puedes subir a más de nivel tres las habilidades.",
													"",
													JOptionPane.ERROR_MESSAGE);
									Equipo.armor1 = new Armor("", "", false,false,
											null);
								}
								if (masp == 1) {
									masp = 0;
									cont2 = 1;
									JOptionPane
											.showMessageDialog(
													frame.getContentPane(),
													"No puedes tener esa propiedad de posesión dado que no tienes el privilegio maestro y no puedes subir a más de nivel cuatro las habilidades.",
													"",
													JOptionPane.ERROR_MESSAGE);
									Equipo.armor1 = new Armor("", "", false,false,
											null);
								}
								if (cont2 == 0) {
									Start.contadorPosesion -= 1;
									Equipo.getTextField_12().setText(
											Equipo.armor1.getArmor());
									frame.dispose();
								}
							}

						} else {
							JOptionPane.showMessageDialog(frame.getContentPane(),
									"No puedes llevar más armaduras.", "",
									JOptionPane.ERROR_MESSAGE);

						}
					}
					if (comboBox.getSelectedIndex() == 2) {
						int added = 0;
						if(comboBox_4.getSelectedItem().toString().equals("-Clase de Arma-")){
							int seleccion = JOptionPane.showOptionDialog(
									null,
									"Debes seleccionar una clase de arma.",
									"¡Atención!", JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
											 }, // null para YES, NO y CANCEL
									"opcion 1");
							cont++;
						}
						if (Armas.tipow.equals("Una Mano")) {
							OneHanded arma = new OneHanded(textField.getText(),
									textArea.getText(),
									true,false, poss,comboBox_4.getSelectedItem().toString());
							if (Equipo.getTextField().getText().equals("")
									&& Equipo.pweap >= 1) {
								added = 1;
								Equipo.weapon1 = arma;
								Equipo.weapon1.setPossesion(poss);	
								Equipo.getTextField().setText(
										Equipo.weapon1.getWeapon());
							} else {
								if (Equipo.getTextField_1().getText()
										.equals("")
										&& Equipo.pweap >= 2) {
									added = 2;
									Equipo.weapon2 = arma;
									Equipo.weapon2.setPossesion(poss);
									Equipo.getTextField_1().setText(
											Equipo.weapon2.getWeapon());
								} else {
									if (Equipo.getTextField_2().getText()
											.equals("")
											&& Equipo.pweap >= 3) {
										added = 3;
										Equipo.weapon3 = arma;
										Equipo.weapon3.setPossesion(poss);
										Equipo.getTextField_2().setText(
												Equipo.weapon3.getWeapon());
									} else {
										if (Equipo.getTextField_3().getText()
												.equals("")
												&& Equipo.pweap >= 4) {
											added = 4;
											Equipo.weapon4 = arma;
											Equipo.weapon4.setPossesion(poss);
											Equipo.getTextField_3().setText(
													Equipo.weapon4.getWeapon());
										} else {
											added = 0;
											JOptionPane
													.showMessageDialog(
															frame.getContentPane(),
															"No puedes llevar más armas.",
															"",
															JOptionPane.ERROR_MESSAGE);
											cont = 1;

										}

									}

								}

							}

						}
						if (Armas.tipow.equals("Dos Manos")) {
							
							if(comboBox_4.getSelectedItem().toString().equals("Espadón") && Start.character.getAtributes().getStrength()<10){
								
								int seleccion = JOptionPane.showOptionDialog(
										null,
										"Para poder llevar un espadón necesitas al menos 10 de Fuerza",
										"¡Atención!", JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
												 }, // null para YES, NO y CANCEL
										"opcion 1");
								
								cont++;
								
								
							}
							else if(comboBox_4.getSelectedItem().toString().equals("Hacha de Guerra") && Start.character.getAtributes().getStrength()<10){
								
								int seleccion = JOptionPane.showOptionDialog(
										null,
										"Para poder llevar un hacha de guerra necesitas al menos 10 de Fuerza",
										"¡Atención!", JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
												 }, // null para YES, NO y CANCEL
										"opcion 1");
								cont++;
								
							}
							else if(comboBox_4.getSelectedItem().toString().equals("Martillo de Guerra") && Start.character.getAtributes().getStrength()<12){
								
								int seleccion = JOptionPane.showOptionDialog(
										null,
										"Para poder llevar un martillo de guerra necesitas al menos 12 de Fuerza",
										"¡Atención!", JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
												 }, // null para YES, NO y CANCEL
										"opcion 1");
								
								cont++;
							}
							else if(comboBox_4.getSelectedItem().toString().equals("Ultra-Espadón") && Start.character.getAtributes().getStrength()<15){
								
								int seleccion = JOptionPane.showOptionDialog(
										null,
										"Para poder llevar un ultra-espadón necesitas al menos 15 de Fuerza",
										"¡Atención!", JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
												 }, // null para YES, NO y CANCEL
										"opcion 1");
								
								cont++;
							}
							else{
							TwoHanded arma = new TwoHanded(textField.getText(),
									textArea.getText(), true, false, poss,comboBox_4.getSelectedItem().toString());
							if (Equipo.getTextField().getText().equals("")
									&& Equipo.pweap >= 1) {
								added = 1;
								Equipo.weapon1 = arma;
								Equipo.weapon1.setPossesion(poss);
								Equipo.getTextField().setText(
										Equipo.weapon1.getWeapon());
							} else {
								if (Equipo.getTextField_1().getText()
										.equals("")
										&& Equipo.pweap >= 2) {
									added = 2;
									Equipo.weapon2 = arma;
									Equipo.weapon2.setPossesion(poss);
									Equipo.getTextField_1().setText(
											Equipo.weapon2.getWeapon());
								} else {
									if (Equipo.getTextField_2().getText()
											.equals("")
											&& Equipo.pweap >= 3) {
										added = 3;
										Equipo.weapon3 = arma;
										Equipo.weapon3.setPossesion(poss);
										Equipo.getTextField_2().setText(
												Equipo.weapon3.getWeapon());
									} else {
										if (Equipo.getTextField_3().getText()
												.equals("")
												&& Equipo.pweap >= 4) {
											added = 4;
											Equipo.weapon4 = arma;
											Equipo.weapon4.setPossesion(poss);
											Equipo.getTextField_3().setText(
													Equipo.weapon4.getWeapon());
										} else {
											added = 0;
											JOptionPane
													.showMessageDialog(
															frame.getContentPane(),
															"No puedes llevar más armas.",
															"",
															JOptionPane.ERROR_MESSAGE);
											cont = 1;
										}

									}

								}

							}

						}}
						if (Armas.tipow.equals("De Asta")) {
							Pole arma = new Pole(textField.getText(), textArea
									.getText(),true,false,
									poss,comboBox_4.getSelectedItem().toString());
							if (Equipo.getTextField().getText().equals("")
									&& Equipo.pweap >= 1) {
								added = 1;
								Equipo.weapon1 = arma;
								Equipo.weapon1.setPossesion(poss);
								Equipo.getTextField().setText(
										Equipo.weapon1.getWeapon());
							} else {
								if (Equipo.getTextField_1().getText()
										.equals("")
										&& Equipo.pweap >= 2) {
									added = 2;
									Equipo.weapon2 = arma;
									Equipo.weapon2.setPossesion(poss);
									Equipo.getTextField_1().setText(
											Equipo.weapon2.getWeapon());
								} else {
									if (Equipo.getTextField_2().getText()
											.equals("")
											&& Equipo.pweap >= 3) {
										added = 3;
										Equipo.weapon3 = arma;
										Equipo.weapon3.setPossesion(poss);
										Equipo.getTextField_2().setText(
												Equipo.weapon3.getWeapon());
									} else {
										if (Equipo.getTextField_3().getText()
												.equals("")
												&& Equipo.pweap >= 4) {
											added = 4;
											Equipo.weapon4 = arma;
											Equipo.weapon4.setPossesion(poss);
											Equipo.getTextField_3().setText(
													Equipo.weapon4.getWeapon());
										} else {
											added = 0;
											JOptionPane
													.showMessageDialog(
															frame.getContentPane(),
															"No puedes llevar más armas.",
															"",
															JOptionPane.ERROR_MESSAGE);
											cont = 1;
										}

									}

								}

							}

						}
						if (Armas.tipow.equals("A Distancia")) {
							if(comboBox_4.getSelectedItem().toString().equals("Arma de Fuego") && Start.character.getKnowledgeSkills().getSecretKnowledge()<2){
								
								int seleccion = JOptionPane.showOptionDialog(
										null,
										"Para poder llevar un arma de fuego necesitas al menos nivel 2 en Conocimientos Secretos",
										"¡Atención!", JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
												 }, // null para YES, NO y CANCEL
										"opcion 1");

								cont++;
							}
							
							else{
							
							Ranged arma = new Ranged(textField.getText(),
									textArea.getText(),
									true,false, poss,comboBox_4.getSelectedItem().toString());
							if (Equipo.getTextField().getText().equals("")
									&& Equipo.pweap >= 1) {
								added = 1;
								Equipo.weapon1 = arma;
								Equipo.weapon1.setPossesion(poss);
								Equipo.getTextField().setText(
										Equipo.weapon1.getWeapon());
							} else {
								if (Equipo.getTextField_1().getText()
										.equals("")
										&& Equipo.pweap >= 2) {
									added = 2;
									Equipo.weapon2 = arma;
									Equipo.weapon2.setPossesion(poss);
									Equipo.getTextField_1().setText(
											Equipo.weapon2.getWeapon());
								} else {
									if (Equipo.getTextField_2().getText()
											.equals("")
											&& Equipo.pweap >= 3) {
										added = 3;
										Equipo.weapon3 = arma;
										Equipo.weapon3.setPossesion(poss);
										Equipo.getTextField_2().setText(
												Equipo.weapon3.getWeapon());
									} else {
										if (Equipo.getTextField_3().getText()
												.equals("")
												&& Equipo.pweap >= 4) {
											added = 4;
											Equipo.weapon4 = arma;
											Equipo.weapon4.setPossesion(poss);
											Equipo.getTextField_3().setText(
													Equipo.weapon4.getWeapon());
										} else {
											added = 0;
											JOptionPane
													.showMessageDialog(
															frame.getContentPane(),
															"No puedes llevar más armas.",
															"",
															JOptionPane.ERROR_MESSAGE);
											cont = 1;
										}

									}

								}

							}

						}}
						int cont1 = 0;
						if (Armas.tipow.equals("Escudo")) {
							
							if(comboBox.getSelectedItem().toString().equals("Escudo Medio") && Start.character.getAtributes().getStrength()<10){
								
								int seleccion = JOptionPane.showOptionDialog(
										null,
										"Para poder llevar un escudo medio necesitas al menos 10 de Fuerza",
										"¡Atención!", JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
												 }, // null para YES, NO y CANCEL
										"opcion 1");
								cont++;
								
							}
							else if(comboBox.getSelectedItem().toString().equals("Escudo de Torre") && Start.character.getAtributes().getStrength()<15){
								
								int seleccion = JOptionPane.showOptionDialog(
										null,
										"Para poder llevar un escudo de torre necesitas al menos 15 de Fuerza",
										"¡Atención!", JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
												 }, // null para YES, NO y CANCEL
										"opcion 1");
								
								cont++;
							}
							
							else{
							
							Shields arma = new Shields(textField.getText(),
									textArea.getText(),true,false, poss,comboBox_4.getSelectedItem().toString());
							if (Equipo.getTextField().getText().equals("")
									&& Equipo.pweap >= 1) {
								added = 1;
								Equipo.weapon1 = arma;
								Equipo.weapon1.setPossesion(poss);
								Equipo.getTextField().setText(
										Equipo.weapon1.getWeapon());
							} else {
								if (Equipo.getTextField_1().getText()
										.equals("")
										&& Equipo.pweap >= 2) {
									added = 2;
									Equipo.weapon2 = arma;
									Equipo.weapon2.setPossesion(poss);
									Equipo.getTextField_1().setText(
											Equipo.weapon2.getWeapon());
								} else {
									if (Equipo.getTextField_2().getText()
											.equals("")
											&& Equipo.pweap >= 3) {
										added = 3;
										Equipo.weapon3 = arma;
										Equipo.weapon3.setPossesion(poss);
										Equipo.getTextField_2().setText(
												Equipo.weapon3.getWeapon());
									} else {
										if (Equipo.getTextField_3().getText()
												.equals("")
												&& Equipo.pweap >= 4) {
											added = 4;
											Equipo.weapon4 = arma;
											Equipo.weapon4.setPossesion(poss);
											Equipo.getTextField_3().setText(
													Equipo.weapon4.getWeapon());
										} else {
											added = 0;
											JOptionPane
													.showMessageDialog(
															frame.getContentPane(),
															"No puedes llevar más armas.",
															"",
															JOptionPane.ERROR_MESSAGE);
											cont = 1;
										}

									}

								}

							}

						}}
						if (cont1 == 0 && cont == 0) {
							int cont2 = 0;
							try {
								poss.CalculoPosesion(Start.character);
							} catch (AtributeOutOfBoundsException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (SkillOutOfBoundsException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							if (app == 1) {
								app = 0;
								cont2 = 1;
								if (added == 1) {
									Equipo.weapon1 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField().setText("");
								}
								if (added == 2) {
									Equipo.weapon2 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField_1().setText("");
								}
								if (added == 3) {
									Equipo.weapon3 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField_2().setText("");
								}
								if (added == 4) {
									Equipo.weapon4 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField_3().setText("");
								}
								JOptionPane
										.showMessageDialog(
												frame.getContentPane(),
												"No puedes tener esa propiedad de posesión dado que tienes el reves aprendiz y no puedes subir a más de nivel dos las habilidades.",
												"", JOptionPane.ERROR_MESSAGE);

							}
							if (exp == 1) {
								exp = 0;
								cont2 = 1;
								if (added == 1) {
									Equipo.weapon1 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField().setText("");
								}
								if (added == 2) {
									Equipo.weapon2 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField_1().setText("");
								}
								if (added == 3) {
									Equipo.weapon3 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField_2().setText("");
								}
								if (added == 4) {
									Equipo.weapon4 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField_3().setText("");
								}
								JOptionPane
										.showMessageDialog(
												frame.getContentPane(),
												"No puedes tener esa propiedad de posesión dado que no tienes el privilegio experto y no puedes subir a más de nivel tres las habilidades.",
												"", JOptionPane.ERROR_MESSAGE);

							}
							if (masp == 1) {
								masp = 0;
								cont2 = 1;
								if (added == 1) {
									Equipo.weapon1 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField().setText("");
								}
								if (added == 2) {
									Equipo.weapon2 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField_1().setText("");
								}
								if (added == 3) {
									Equipo.weapon3 = new Weapons("", "",
											false,false, null,"");
									Equipo.getTextField_2().setText("");
								}
								if (added == 4) {
									Equipo.weapon4 = new Weapons("","",false,false, null,"");
									Equipo.getTextField_3().setText("");
								}
								JOptionPane
										.showMessageDialog(
												frame.getContentPane(),
												"No puedes tener esa propiedad de posesión dado que no tienes el privilegio maestro y no puedes subir a más de nivel cuatro las habilidades.",
												"", JOptionPane.ERROR_MESSAGE);

							}
							if (cont2 == 0) {
								Start.contadorPosesion -= 1;
								frame.dispose();
							}
						}

					}
					if (comboBox.getSelectedIndex() == 3) {
						int added = 0;
						Misc objeto = new Misc(textField.getText(), textArea
								.getText(), true,false, poss);
						if (Equipo.getTextField_4().getText().equals("")
								&& Equipo.pmisc >= 1) {
							added = 1;
							Equipo.misc1 = objeto;
							Equipo.getTextField_4().setText(
									"" + Equipo.misc1.getMisc());
						} else {
							if (Equipo.getTextField_5().getText().equals("")
									&& Equipo.pmisc >= 2) {
								added = 2;
								Equipo.misc2 = objeto;
								Equipo.getTextField_5().setText(
										"" + Equipo.misc2.getMisc());
							} else {
								if (Equipo.getTextField_6().getText()
										.equals("")
										&& Equipo.pmisc >= 3) {
									added = 3;
									Equipo.misc3 = objeto;
									Equipo.getTextField_6().setText(
											"" + Equipo.misc3.getMisc());
								} else {
									if (Equipo.getTextField_7().getText()
											.equals("")
											&& Equipo.pmisc >= 4) {
										added = 4;
										Equipo.misc4 = objeto;
										Equipo.getTextField_7().setText(
												"" + Equipo.misc4.getMisc());
									} else {
										added = 0;
										JOptionPane
												.showMessageDialog(
														frame.getContentPane(),
														"No puedes llevar más objetos.",
														"",
														JOptionPane.ERROR_MESSAGE);

										cont = 1;
									}
								}
							}

						}

						if (cont == 0) {
							try {
								poss.CalculoPosesion(Start.character);
							} catch (AtributeOutOfBoundsException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (SkillOutOfBoundsException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							int cont2 = 0;
							if (app == 1) {
								app = 0;
								cont2 = 1;
								if (added == 1) {
									Equipo.misc1 = new Misc("", "", false,false, null);
									Equipo.getTextField_4().setText("");
								}
								if (added == 2) {
									Equipo.misc2 = new Misc("", "", false,false, null);
									Equipo.getTextField_5().setText("");
								}
								if (added == 3) {
									Equipo.misc3 = new Misc("", "", false,false, null);
									Equipo.getTextField_6().setText("");
								}
								if (added == 4) {
									Equipo.misc4 = new Misc("", "", false,false, null);
									Equipo.getTextField_7().setText("");
								}
								JOptionPane
										.showMessageDialog(
												frame.getContentPane(),
												"No puedes tener esa propiedad de posesión dado que tienes el reves aprendiz y no puedes subir a más de nivel dos las habilidades.",
												"", JOptionPane.ERROR_MESSAGE);

							}
							if (exp == 1) {
								exp = 0;
								cont2 = 1;
								if (added == 1) {
									Equipo.misc1 = new Misc("", "", false,false, null);
									Equipo.getTextField_4().setText("");
								}
								if (added == 2) {
									Equipo.misc2 = new Misc("", "", false,false, null);
									Equipo.getTextField_5().setText("");
								}
								if (added == 3) {
									Equipo.misc3 = new Misc("", "", false,false, null);
									Equipo.getTextField_6().setText("");
								}
								if (added == 4) {
									Equipo.misc4 = new Misc("", "", false,false, null);
									Equipo.getTextField_7().setText("");
								}
								JOptionPane
										.showMessageDialog(
												frame.getContentPane(),
												"No puedes tener esa propiedad de posesión dado que no tienes el privilegio experto y no puedes subir a más de nivel tres las habilidades.",
												"", JOptionPane.ERROR_MESSAGE);

							}
							if (masp == 1) {
								masp = 0;
								cont2 = 1;
								if (added == 1) {
									Equipo.misc1 = new Misc("", "", false,false, null);
									Equipo.getTextField_4().setText("");
								}
								if (added == 2) {
									Equipo.misc2 = new Misc("", "", false,false, null);
									Equipo.getTextField_5().setText("");
								}
								if (added == 3) {
									Equipo.misc3 = new Misc("", "", false,false, null);
									Equipo.getTextField_6().setText("");
								}
								if (added == 4) {
									Equipo.misc4 = new Misc("", "", false,false, null);
									Equipo.getTextField_7().setText("");
								}
								JOptionPane
										.showMessageDialog(
												frame.getContentPane(),
												"No puedes tener esa propiedad de posesión dado que no tienes el privilegio maestro y no puedes subir a más de nivel cuatro las habilidades.",
												"", JOptionPane.ERROR_MESSAGE);

							}
							if (cont2 == 0) {
								Start.contadorPosesion -= 1;
								frame.dispose();
							}
						}
					}
					if (comboBox.getSelectedIndex() == 4) {
						int added = 0;
						if (tipoac.equals("Capa")) {
							Cloak acc = new Cloak(textField.getText(), textArea
									.getText(), true,false, poss);
							if (Equipo.getTextField_8().getText().equals("")) {
								added = 1;
								Equipo.accesories1 = acc;
								Equipo.getTextField_8().setText(
										Equipo.accesories1.getAccesory());
							} else {
								if (Equipo.getTextField_9().getText()
										.equals("")) {
									added = 2;
									Equipo.accesories2 = acc;
									Equipo.getTextField_9().setText(
											Equipo.accesories2.getAccesory());
								} else {
									if (Equipo.getTextField_10().getText()
											.equals("")) {
										added = 3;
										Equipo.accesories3 = acc;
										Equipo.getTextField_10().setText(
												Equipo.accesories3
														.getAccesory());
									} else {
										if (Equipo.getTextField_11().getText()
												.equals("")) {
											added = 4;
											Equipo.accesories4 = acc;
											Equipo.getTextField_11().setText(
													Equipo.accesories4
															.getAccesory());
										} else {
											added = 0;
											JOptionPane
													.showMessageDialog(
															frame.getContentPane(),
															"No puedes llevar más accesorios.",
															"",
															JOptionPane.ERROR_MESSAGE);
											cont = 1;
										}

									}

								}

							}

						}
						if (tipoac.equals("Colgante")) {
							Necklace acc = new Necklace(textField.getText(),
									textArea.getText(), true,false, poss);
							if (Equipo.getTextField_8().getText().equals("")) {
								added = 1;
								Equipo.accesories1 = acc;
								Equipo.getTextField_8().setText(
										Equipo.accesories1.getAccesory());
							} else {
								if (Equipo.getTextField_9().getText()
										.equals("")) {
									added = 2;
									Equipo.accesories2 = acc;
									Equipo.getTextField_9().setText(
											Equipo.accesories2.getAccesory());
								} else {
									if (Equipo.getTextField_10().getText()
											.equals("")) {
										added = 3;
										Equipo.accesories3 = acc;
										Equipo.getTextField_10().setText(
												Equipo.accesories3
														.getAccesory());
									} else {
										if (Equipo.getTextField_11().getText()
												.equals("")) {
											added = 4;
											Equipo.accesories4 = acc;
											Equipo.getTextField_11().setText(
													Equipo.accesories4
															.getAccesory());
										} else {
											added = 0;
											JOptionPane
													.showMessageDialog(
															frame.getContentPane(),
															"No puedes llevar más accesorios.",
															"",
															JOptionPane.ERROR_MESSAGE);
											cont = 1;
										}

									}

								}

							}

						}
						if (tipoac.equals("Pendiente")) {
							Earrings acc = new Earrings(textField.getText(),
									textArea.getText(), true,false, poss);
							if (Equipo.getTextField_8().getText().equals("")) {
								added = 1;
								Equipo.accesories1 = acc;
								Equipo.getTextField_8().setText(
										Equipo.accesories1.getAccesory());
							} else {
								if (Equipo.getTextField_9().getText()
										.equals("")) {
									added = 2;
									Equipo.accesories2 = acc;
									Equipo.getTextField_9().setText(
											Equipo.accesories2.getAccesory());
								} else {
									if (Equipo.getTextField_10().getText()
											.equals("")) {
										added = 3;
										Equipo.accesories3 = acc;
										Equipo.getTextField_10().setText(
												Equipo.accesories3
														.getAccesory());
									} else {
										if (Equipo.getTextField_11().getText()
												.equals("")) {
											added = 4;
											Equipo.accesories4 = acc;
											Equipo.getTextField_11().setText(
													Equipo.accesories4
															.getAccesory());
										} else {
											added = 0;
											JOptionPane
													.showMessageDialog(
															frame.getContentPane(),
															"No puedes llevar más accesorios.",
															"",
															JOptionPane.ERROR_MESSAGE);
											cont = 1;
										}

									}

								}

							}

						}
						if (tipoac.equals("Anillo")) {
							Rings acc = new Rings(textField.getText(), textArea
									.getText(), true,false, poss);
							if (Equipo.getTextField_8().getText().equals("")) {
								added = 1;
								Equipo.accesories1 = acc;
								Equipo.getTextField_8().setText(
										Equipo.accesories1.getAccesory());
							} else {
								if (Equipo.getTextField_9().getText()
										.equals("")) {
									added = 2;
									Equipo.accesories2 = acc;
									Equipo.getTextField_9().setText(
											Equipo.accesories2.getAccesory());
								} else {
									if (Equipo.getTextField_10().getText()
											.equals("")) {
										added = 3;
										Equipo.accesories3 = acc;
										Equipo.getTextField_10().setText(
												Equipo.accesories3
														.getAccesory());
									} else {
										if (Equipo.getTextField_11().getText()
												.equals("")) {
											added = 4;
											Equipo.accesories4 = acc;
											Equipo.getTextField_11().setText(
													Equipo.accesories4
															.getAccesory());
										} else {
											added = 0;
											JOptionPane
													.showMessageDialog(
															frame.getContentPane(),
															"No puedes llevar más accesorios.",
															"",
															JOptionPane.ERROR_MESSAGE);
											cont = 1;
										}

									}

								}

							}

						}
						if (cont == 0) {
							try {
								poss.CalculoPosesion(Start.character);
							} catch (AtributeOutOfBoundsException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (SkillOutOfBoundsException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							int cont2 = 0;
							if (app == 1) {
								app = 0;
								cont2 = 1;
								if (added == 1) {
									Equipo.accesories1 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_8().setText("");
								}
								if (added == 2) {
									Equipo.accesories2 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_9().setText("");
								}
								if (added == 3) {
									Equipo.accesories3 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_10().setText("");
								}
								if (added == 4) {
									Equipo.accesories4 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_11().setText("");
								}
								JOptionPane
										.showMessageDialog(
												frame.getContentPane(),
												"No puedes tener esa propiedad de posesión dado que tienes el reves aprendiz y no puedes subir a más de nivel dos las habilidades.",
												"", JOptionPane.ERROR_MESSAGE);

							}
							if (exp == 1) {
								exp = 0;
								cont2 = 1;
								if (added == 1) {
									Equipo.accesories1 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_8().setText("");
								}
								if (added == 2) {
									Equipo.accesories2 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_9().setText("");
								}
								if (added == 3) {
									Equipo.accesories3 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_10().setText("");
								}
								if (added == 4) {
									Equipo.accesories4 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_11().setText("");
								}
								JOptionPane
										.showMessageDialog(
												frame.getContentPane(),
												"No puedes tener esa propiedad de posesión dado que no tienes el privilegio experto y no puedes subir a más de nivel tres las habilidades.",
												"", JOptionPane.ERROR_MESSAGE);

							}
							if (masp == 1) {
								masp = 0;
								cont2 = 1;
								if (added == 1) {
									Equipo.accesories1 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_8().setText("");
								}
								if (added == 2) {
									Equipo.accesories2 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_9().setText("");
								}
								if (added == 3) {
									Equipo.accesories3 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_10().setText("");
								}
								if (added == 4) {
									Equipo.accesories4 = new Accesories("", "",
											false,false, null);
									Equipo.getTextField_11().setText("");
								}
								JOptionPane
										.showMessageDialog(
												frame.getContentPane(),
												"No puedes tener esa propiedad de posesión dado que no tienes el privilegio maestro y no puedes subir a más de nivel cuatro las habilidades.",
												"", JOptionPane.ERROR_MESSAGE);

							}
							if (cont2 == 0) {
								Start.contadorPosesion -= 1;
								Equipo.posPuestas++;
								frame.dispose();
							}
						}
					}
				} else {
					JOptionPane
							.showMessageDialog(
									frame.getContentPane(),
									"Llevas demasiadas propiedades en tu posesión. No puedes tener menos de 0 puntos de posesión.",
									"", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnAadir.setFont(mf.MyFont(0, 13));
		btnAadir.setBounds(315, 466, 128, 38);
		frame.getContentPane().add(btnAadir);

		final JButton btnVolver = new JButton("");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton atras.png")));

			}
		});
		btnVolver.setIcon(new ImageIcon(Posesiones.class
				.getResource("/images/boton atras.png")));
		btnVolver.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(139, 69, 19));
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolver.setFont(mf.MyFont(0, 13));
		btnVolver.setBounds(10, 466, 99, 47);
		frame.getContentPane().add(btnVolver);

		txtTipoArmadura = new JTextField();
		txtTipoArmadura.setForeground(Color.WHITE);
		txtTipoArmadura.setOpaque(false);
		txtTipoArmadura.setBackground(new Color(205, 133, 63));
		txtTipoArmadura.setVisible(false);
		txtTipoArmadura.setText("Tipo de Armadura:");
		txtTipoArmadura.setFont(mf.MyFont(0, 13));
		txtTipoArmadura.setEditable(false);
		txtTipoArmadura.setColumns(10);
		txtTipoArmadura.setBorder(null);
		txtTipoArmadura.setBounds(209, 59, 128, 20);
		frame.getContentPane().add(txtTipoArmadura);

		chckbxTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxTela.isSelected() == true) {
					Posesiones.tipoarm = "Tela";
					chckbxUnaMano.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);

				} else {
					Posesiones.tipoarm = "";
					chckbxUnaMano.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);

				}
			}
		});
		chckbxArmaduraLigera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxArmaduraLigera.isSelected() == true) {
					Posesiones.tipoarm = "Armadura Ligera";
					chckbxUnaMano.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(false);

				} else {
					Posesiones.tipoarm = "";
					chckbxUnaMano.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);

				}
			}
		});
		chckbxArmaduraPesada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxArmaduraPesada.isSelected() == true) {
					Posesiones.tipoarm = "Armadura Pesada";
					chckbxUnaMano.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(true);

				} else {
					Posesiones.tipoarm = "";
					chckbxUnaMano.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);

				}
			}
		});
		chckbxTela.setVisible(false);
		chckbxTela.setFont(mf.MyFont(0, 11));
		chckbxTela.setBounds(209, 86, 117, 23);
		frame.getContentPane().add(chckbxTela);

		chckbxArmaduraLigera.setVisible(false);
		chckbxArmaduraLigera.setFont(mf.MyFont(0, 11));
		chckbxArmaduraLigera.setBounds(209, 125, 117, 23);
		frame.getContentPane().add(chckbxArmaduraLigera);

		chckbxArmaduraPesada.setVisible(false);
		chckbxArmaduraPesada.setFont(mf.MyFont(0, 11));
		chckbxArmaduraPesada.setBounds(209, 167, 117, 23);
		frame.getContentPane().add(chckbxArmaduraPesada);

		txtField = new JTextField();
		txtField.setForeground(Color.WHITE);
		txtField.setOpaque(false);
		txtField.setBackground(new Color(205, 133, 63));
		txtField.setText("Puntos de Posesi\u00F3n:");
		txtField.setFont(mf.MyFont(0, 13));
		txtField.setEditable(false);
		txtField.setColumns(10);
		txtField.setBorder(null);
		txtField.setBounds(293, 11, 114, 20);
		frame.getContentPane().add(txtField);

		txtPuntosDePosesin = new JTextField();
		txtPuntosDePosesin.setBackground(Color.WHITE);
		txtPuntosDePosesin.setText("" + ppos);
		txtPuntosDePosesin.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntosDePosesin.setFont(mf.MyFont(0, 15));
		txtPuntosDePosesin.setEditable(false);
		txtPuntosDePosesin.setColumns(10);
		txtPuntosDePosesin.setBounds(412, 11, 31, 20);
		frame.getContentPane().add(txtPuntosDePosesin);

		txtPropiedadesPosesin = new JTextField();
		txtPropiedadesPosesin.setForeground(Color.WHITE);
		txtPropiedadesPosesin.setOpaque(false);
		txtPropiedadesPosesin.setBackground(new Color(205, 133, 63));
		txtPropiedadesPosesin.setText("Propiedades de Posesi\u00F3n:");
		txtPropiedadesPosesin.setFont(mf.MyFont(0, 13));
		txtPropiedadesPosesin.setEditable(false);
		txtPropiedadesPosesin.setColumns(10);
		txtPropiedadesPosesin.setBorder(null);
		txtPropiedadesPosesin.setBounds(243, 293, 146, 20);
		frame.getContentPane().add(txtPropiedadesPosesin);
		textField_3 = new JTextField();
		textField_3.setBackground(Color.WHITE);
		textField_3.setVisible(false);
		textField_3.setFont(mf.MyFont(0, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(10, 422, 223, 20);
		frame.getContentPane().add(textField_3);
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(Color.WHITE);
		final JButton button_3 = new JButton("+");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_3.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_3.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setIcon(new ImageIcon(Posesiones.class
				.getResource("/images/boton +-.png")));
		button_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(new Color(139, 69, 19));
		button_3.setBorderPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setFocusPainted(false);
		button_3.setOpaque(false);
		final JButton button_4 = new JButton("-");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_4.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton +-2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button_4.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setIcon(new ImageIcon(Posesiones.class
				.getResource("/images/boton +-.png")));
		button_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_4.setForeground(new Color(255, 255, 255));
		button_4.setBackground(new Color(139, 69, 19));
		button_4.setBorderPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setFocusPainted(false);
		button_4.setOpaque(false);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.setEnabled(true);
				comboBox_2.setEnabled(true);
				comboBox_3.setEnabled(true);
				textField_3.setText("");
				textField_3.setEditable(true);
				btnAadir.setEnabled(false);
				button_3.setEnabled(true);
			}
		});
		button_4.setVisible(false);
		button_4.setFont(mf.MyFont(0, 13));
		button_4.setBounds(350, 421, 93, 21);
		frame.getContentPane().add(button_4);

		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cont = 0;
				if (comboBox_1.getSelectedIndex() == 42 && cont == 0) {
					comboBox_1.setEnabled(false);
					cont = 1;
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, textField_3.getText());
					} else {
						pos1.add(0, textField_3.getText());
					}
					button_3.setEnabled(false);

				}
				if (comboBox_2.getSelectedIndex() == 42 && cont == 0) {
					comboBox_2.setEnabled(false);
					cont = 1;
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, textField_3.getText());
					} else {
						pos1.add(1, textField_3.getText());
					}
					button_3.setEnabled(false);

				}
				if (comboBox_3.getSelectedIndex() == 42 && cont == 0) {
					comboBox_3.setEnabled(false);
					cont = 1;
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, textField_3.getText());
					} else {
						pos1.add(2, textField_3.getText());
					}

					button_3.setEnabled(false);
				}
				btnAadir.setEnabled(true);
				textField_3.setEditable(false);
			}
		});
		button_3.setVisible(false);
		button_3.setFont(mf.MyFont(0, 13));
		button_3.setBounds(243, 422, 93, 20);
		frame.getContentPane().add(button_3);

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox_1.getSelectedIndex() == 0) {
					ppos += ppos1;
					ppos1 = pgasto[0];
					ppos -= pgasto[0];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 1) {
					ppos += ppos1;
					ppos1 = pgasto[1];
					ppos -= pgasto[1];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 2) {
					ppos += ppos1;
					ppos1 = pgasto[2];
					ppos -= pgasto[2];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 3) {
					ppos += ppos1;
					ppos1 = pgasto[3];
					ppos -= pgasto[3];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 4) {
					ppos += ppos1;
					ppos1 = pgasto[4];
					ppos -= pgasto[4];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 5) {
					ppos += ppos1;
					ppos1 = pgasto[5];
					ppos -= pgasto[5];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 6) {
					ppos += ppos1;
					ppos1 = pgasto[6];
					ppos -= pgasto[6];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 7) {
					ppos += ppos1;
					ppos1 = pgasto[7];
					ppos -= pgasto[7];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 8) {
					ppos += ppos1;
					ppos1 = pgasto[8];
					ppos -= pgasto[8];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 9) {
					ppos += ppos1;
					ppos1 = pgasto[9];
					ppos -= pgasto[9];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 10) {
					ppos += ppos1;
					ppos1 = pgasto[10];
					ppos -= pgasto[10];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 11) {
					ppos += ppos1;
					ppos1 = pgasto[11];
					ppos -= pgasto[11];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 12) {
					ppos += ppos1;
					ppos1 = pgasto[12];
					ppos -= pgasto[12];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 13) {
					ppos += ppos1;
					ppos1 = pgasto[13];
					ppos -= pgasto[13];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 14) {
					ppos += ppos1;
					ppos1 = pgasto[14];
					ppos -= pgasto[14];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 15) {
					ppos += ppos1;
					ppos1 = pgasto[15];
					ppos -= pgasto[15];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 16) {
					ppos += ppos1;
					ppos1 = pgasto[16];
					ppos -= pgasto[16];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 17) {
					ppos += ppos1;
					ppos1 = pgasto[17];
					ppos -= pgasto[17];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 18) {
					ppos += ppos1;
					ppos1 = pgasto[18];
					ppos -= pgasto[18];
					txtPuntosDePosesin.setText("" + ppos);

					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 19) {
					ppos += ppos1;
					ppos1 = pgasto[19];
					ppos -= pgasto[19];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 20) {
					ppos += ppos1;
					ppos1 = pgasto[20];
					ppos -= pgasto[20];
					txtPuntosDePosesin.setText("" + ppos);

					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 21) {
					ppos += ppos1;
					ppos1 = pgasto[21];
					ppos -= pgasto[21];
					txtPuntosDePosesin.setText("" + ppos);

					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 22) {
					ppos += ppos1;
					ppos1 = pgasto[22];
					ppos -= pgasto[22];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 23) {
					ppos += ppos1;
					ppos1 = pgasto[23];
					ppos -= pgasto[23];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 24) {
					ppos += ppos1;
					ppos1 = pgasto[24];
					ppos -= pgasto[24];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 25) {
					ppos += ppos1;
					ppos1 = pgasto[25];
					ppos -= pgasto[25];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 26) {
					ppos += ppos1;
					ppos1 = pgasto[26];
					ppos -= pgasto[26];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 27) {
					ppos += ppos1;
					ppos1 = pgasto[27];
					ppos -= pgasto[27];
					txtPuntosDePosesin.setText("" + ppos);

					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 28) {
					ppos += ppos1;
					ppos1 = pgasto[28];
					ppos -= pgasto[28];
					txtPuntosDePosesin.setText("" + ppos);

					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 29) {
					ppos += ppos1;
					ppos1 = pgasto[29];
					ppos -= pgasto[29];
					txtPuntosDePosesin.setText("" + ppos);

					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 30) {
					ppos += ppos1;
					ppos1 = pgasto[30];
					ppos -= pgasto[30];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 31) {
					ppos += ppos1;
					ppos1 = pgasto[31];
					ppos -= pgasto[31];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 32) {
					ppos += ppos1;
					ppos1 = pgasto[32];
					ppos -= pgasto[32];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 33) {
					ppos += ppos1;
					ppos1 = pgasto[33];
					ppos -= pgasto[33];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 34) {
					ppos += ppos1;
					ppos1 = pgasto[34];
					ppos -= pgasto[34];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 35) {
					ppos += ppos1;
					ppos1 = pgasto[35];
					ppos -= pgasto[35];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 36) {
					ppos += ppos1;
					ppos1 = pgasto[36];
					ppos -= pgasto[36];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 37) {
					ppos += ppos1;
					ppos1 = pgasto[37];
					ppos -= pgasto[37];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 38) {
					ppos += ppos1;
					ppos1 = pgasto[38];
					ppos -= pgasto[38];
					txtPuntosDePosesin.setText("" + ppos);

					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 39) {
					ppos += ppos1;
					ppos1 = pgasto[39];
					ppos -= pgasto[39];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 40) {
					ppos += ppos1;
					ppos1 = pgasto[40];
					ppos -= pgasto[40];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 41) {
					ppos += ppos1;
					ppos1 = pgasto[41];
					ppos -= pgasto[41];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
				}
				if (comboBox_1.getSelectedIndex() == 42) {
					ppos += ppos1;
					ppos1 = pgasto[42];
					ppos -= pgasto[42];
					txtPuntosDePosesin.setText("" + ppos);
					textField_3.setVisible(true);
					button_3.setVisible(true);
					button_4.setVisible(true);
					btnAadir.setEnabled(false);

				}
				if (comboBox_1.getSelectedIndex() == 43) {ppos += ppos1;
				ppos1 = pgasto[44];
				ppos -= pgasto[44];
				txtPuntosDePosesin.setText("" + ppos);
				if (pos1.size() > 0) {
					pos1.remove(0);
					pos1.add(0, (String) comboBox_1.getSelectedItem());
				} else {
					pos1.add(0, (String) comboBox_1.getSelectedItem());
				}
				}
				if(comboBox_1.getSelectedIndex()== 44){
					
					ppos += ppos1;
					ppos1 = pgasto[44];
					ppos -= pgasto[44];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
					
				}
				if(comboBox_1.getSelectedIndex()== 45){
					
					ppos += ppos1;
					ppos1 = pgasto[44];
					ppos -= pgasto[44];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					} else {
						pos1.add(0, (String) comboBox_1.getSelectedItem());
					}
					
				}
			
				if (comboBox_1.getSelectedIndex() != 42) {
					textField_3.setVisible(false);
					button_3.setVisible(false);
					button_4.setVisible(false);
					btnAadir.setEnabled(true);

				}

			}
		});

		comboBox_1.setFont(mf.MyFont(0, 11));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-Propiedad-", "+1 Fuerza", "+1 Destreza", "+1 Resistencia", "+1 Resistencia M\u00E1gica", "+1 Inteligencia", "+1 Percepci\u00F3n", "+1 Carisma", "+1 Armas de Una Mano", "+1 Armas de Dos Manos", "+1 Armas de Asta", "+1 Armas a Distancia", "+1 Esquivar", "+1 Bloquear", "+1 Arte de la Guerra", "+1 Diplomacia", "+1 Etiqueta", "+1 Medicina", "+1 Ocultismo", "+1 Investigacion", "+1 Negociaci\u00F3n", "+1 Conocimientos Secretos", "+1 Magia Fuego", "+1 Magia Agua", "+1 Magia Tierra", "+1 Magia Viento", "+1 Magia Blanca", "+1 Magia Negra", "+1 Magia Druidica", "+1 Magia Arcana", "+1 Atletismo", "+1 Supervivencia", "+1 Equitaci\u00F3n", "+1 Trampas", "+1 Sigilo", "Da\u00F1o Elemental de Fuego", "Da\u00F1o Elemental de Agua", "Da\u00F1o Elemental de Tierra", "Da\u00F1o Elemental de Viento", "Da\u00F1o Elemental Arcano", "Da\u00F1o Elemental Oscuro", "Da\u00F1o Elemental Sagrado", "Otro(escribir en el nuevo panel)", "+3 Salud", "+5 Energ\u00EDa", "+5 Man\u00E1"}));
		comboBox_1.setBounds(243, 324, 200, 20);
		frame.getContentPane().add(comboBox_1);

		comboBox_2.setVisible(false);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBox_2.getSelectedIndex() == 0) {
					ppos += ppos2;
					ppos2 = pgasto[0];
					ppos -= pgasto[0];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
				}
				if (comboBox_2.getSelectedIndex() == 1) {
					ppos += ppos2;
					ppos2 = pgasto[1];
					ppos -= pgasto[1];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
				}
				if (comboBox_2.getSelectedIndex() == 2) {
					ppos += ppos2;
					ppos2 = pgasto[2];
					ppos -= pgasto[2];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 3) {
					ppos += ppos2;
					ppos2 = pgasto[3];
					ppos -= pgasto[3];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 4) {
					ppos += ppos2;
					ppos2 = pgasto[4];
					ppos -= pgasto[4];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 5) {
					ppos += ppos2;
					ppos2 = pgasto[5];
					ppos -= pgasto[5];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 6) {
					ppos += ppos2;
					ppos2 = pgasto[6];
					ppos -= pgasto[6];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 7) {
					ppos += ppos2;
					ppos2 = pgasto[7];
					ppos -= pgasto[7];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 8) {
					ppos += ppos2;
					ppos2 = pgasto[8];
					ppos -= pgasto[8];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 9) {
					ppos += ppos2;
					ppos2 = pgasto[9];
					ppos -= pgasto[9];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 10) {
					ppos += ppos2;
					ppos2 = pgasto[10];
					ppos -= pgasto[10];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 11) {
					ppos += ppos2;
					ppos2 = pgasto[11];
					ppos -= pgasto[11];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 12) {
					ppos += ppos2;
					ppos2 = pgasto[12];
					ppos -= pgasto[12];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 13) {
					ppos += ppos2;
					ppos2 = pgasto[13];
					ppos -= pgasto[13];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 14) {
					ppos += ppos2;
					ppos2 = pgasto[14];
					ppos -= pgasto[14];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 15) {
					ppos += ppos2;
					ppos2 = pgasto[15];
					ppos -= pgasto[15];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 16) {
					ppos += ppos2;
					ppos2 = pgasto[16];
					ppos -= pgasto[16];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 17) {
					ppos += ppos2;
					ppos2 = pgasto[17];
					ppos -= pgasto[17];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 18) {
					ppos += ppos2;
					ppos2 = pgasto[18];
					ppos -= pgasto[18];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 19) {
					ppos += ppos2;
					ppos2 = pgasto[19];
					ppos -= pgasto[19];
					if (pos1.size() > 0) {
						pos1.remove(0);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 20) {
					ppos += ppos2;
					ppos2 = pgasto[20];
					ppos -= pgasto[20];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 21) {
					ppos += ppos2;
					ppos2 = pgasto[21];
					ppos -= pgasto[21];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 22) {
					ppos += ppos2;
					ppos2 = pgasto[22];
					ppos -= pgasto[22];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 23) {
					ppos += ppos2;
					ppos2 = pgasto[23];
					ppos -= pgasto[23];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 24) {
					ppos += ppos2;
					ppos2 = pgasto[24];
					ppos -= pgasto[24];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 25) {
					ppos += ppos2;
					ppos2 = pgasto[25];
					ppos -= pgasto[25];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 26) {
					ppos += ppos2;
					ppos2 = pgasto[26];
					ppos -= pgasto[26];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 27) {
					ppos += ppos2;
					ppos2 = pgasto[27];
					ppos -= pgasto[27];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add((String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 28) {
					ppos += ppos2;
					ppos2 = pgasto[28];
					ppos -= pgasto[28];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add((String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 29) {
					ppos += ppos2;
					ppos2 = pgasto[29];
					ppos -= pgasto[29];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add((String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 30) {
					ppos += ppos2;
					ppos2 = pgasto[30];
					ppos -= pgasto[30];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add((String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 31) {
					ppos += ppos2;
					ppos2 = pgasto[31];
					ppos -= pgasto[31];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 32) {
					ppos += ppos2;
					ppos2 = pgasto[32];
					ppos -= pgasto[32];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 33) {
					ppos += ppos2;
					ppos2 = pgasto[33];
					ppos -= pgasto[33];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 34) {
					ppos += ppos2;
					ppos2 = pgasto[34];
					ppos -= pgasto[34];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 35) {
					ppos += ppos2;
					ppos2 = pgasto[35];
					ppos -= pgasto[35];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 36) {
					ppos += ppos2;
					ppos2 = pgasto[36];
					ppos -= pgasto[36];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 37) {
					ppos += ppos2;
					ppos2 = pgasto[37];
					ppos -= pgasto[37];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 38) {
					ppos += ppos2;
					ppos2 = pgasto[38];
					ppos -= pgasto[38];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 39) {
					ppos += ppos2;
					ppos2 = pgasto[39];
					ppos -= pgasto[39];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 40) {
					ppos += ppos2;
					ppos2 = pgasto[40];
					ppos -= pgasto[40];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				if (comboBox_2.getSelectedIndex() == 41) {
					ppos += ppos2;
					ppos2 = pgasto[41];
					ppos -= pgasto[41];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}
				
				if(comboBox_2.getSelectedIndex()== 42){
					
					ppos += ppos2;
					ppos2 = pgasto[44];
					ppos -= pgasto[44];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
					
				}
				if(comboBox_2.getSelectedIndex()== 43){
					
					ppos += ppos2;
					ppos2 = pgasto[44];
					ppos -= pgasto[44];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
					
				}
				if(comboBox_2.getSelectedIndex()== 44){
					
					ppos += ppos2;
					ppos2 = pgasto[44];
					ppos -= pgasto[44];
					if (pos1.size() > 1) {
						pos1.remove(1);
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					} else {
						pos1.add(1, (String) comboBox_2.getSelectedItem());
					}
					txtPuntosDePosesin.setText("" + ppos);
				}

			}
		});
		comboBox_2.setFont(mf.MyFont(0, 11));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"-Propiedad-", "+1 Fuerza", "+1 Destreza", "+1 Resistencia", "+1 Resistencia M\u00E1gica", "+1 Inteligencia", "+1 Percepci\u00F3n", "+1 Carisma", "+1 Armas de Una Mano", "+1 Armas de Dos Manos", "+1 Armas de Asta", "+1 Armas a Distancia", "+1 Esquivar", "+1 Bloquear", "+1 Arte de la Guerra", "+1 Diplomacia", "+1 Etiqueta", "+1 Medicina", "+1 Ocultismo", "+1 Investigacion", "+1 Negociaci\u00F3n", "+1 Conocimientos Secretos", "+1 Magia Fuego", "+1 Magia Agua", "+1 Magia Tierra", "+1 Magia Viento", "+1 Magia Blanca", "+1 Magia Negra", "+1 Magia Druidica", "+1 Magia Arcana", "+1 Atletismo", "+1 Supervivencia", "+1 Equitaci\u00F3n", "+1 Trampas", "+1 Sigilo", "Da\u00F1o Elemental de Fuego", "Da\u00F1o Elemental de Agua", "Da\u00F1o Elemental de Tierra", "Da\u00F1o Elemental de Viento", "Da\u00F1o Elemental Arcano", "Da\u00F1o Elemental Oscuro", "Da\u00F1o Elemental Sagrado", "+3 Salud", "+5 Energ\u00EDa", "+5 Man\u00E1"}));
		comboBox_2.setBounds(243, 355, 200, 23);
		frame.getContentPane().add(comboBox_2);

		comboBox_3.setVisible(false);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBox_3.getSelectedIndex() == 0) {
					ppos += ppos3;
					ppos3 = pgasto[0];
					ppos -= pgasto[0];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 1) {
					ppos += ppos3;
					ppos3 = pgasto[1];
					ppos -= pgasto[1];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 2) {
					ppos += ppos3;
					ppos3 = pgasto[2];
					ppos -= pgasto[2];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 3) {
					ppos += ppos3;
					ppos3 = pgasto[3];
					ppos -= pgasto[3];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 4) {
					ppos += ppos3;
					ppos3 = pgasto[4];
					ppos -= pgasto[4];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add((String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 5) {
					ppos += ppos3;
					ppos3 = pgasto[5];
					ppos -= pgasto[5];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 6) {
					ppos += ppos3;
					ppos3 = pgasto[6];
					ppos -= pgasto[6];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 7) {
					ppos += ppos3;
					ppos3 = pgasto[7];
					ppos -= pgasto[7];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 8) {
					ppos += ppos3;
					ppos3 = pgasto[8];
					ppos -= pgasto[8];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 9) {
					ppos += ppos3;
					ppos3 = pgasto[9];
					ppos -= pgasto[9];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 10) {
					ppos += ppos3;
					ppos3 = pgasto[10];
					ppos -= pgasto[10];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 11) {
					ppos += ppos3;
					ppos3 = pgasto[11];
					ppos -= pgasto[11];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 12) {
					ppos += ppos3;
					ppos3 = pgasto[12];
					ppos -= pgasto[12];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 13) {
					ppos += ppos3;
					ppos3 = pgasto[13];
					ppos -= pgasto[13];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 14) {
					ppos += ppos3;
					ppos3 = pgasto[14];
					ppos -= pgasto[14];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 15) {
					ppos += ppos3;
					ppos3 = pgasto[15];
					ppos -= pgasto[15];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 16) {
					ppos += ppos3;
					ppos3 = pgasto[16];
					ppos -= pgasto[16];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 17) {
					ppos += ppos3;
					ppos3 = pgasto[17];
					ppos -= pgasto[17];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 18) {
					ppos += ppos3;
					ppos3 = pgasto[18];
					ppos -= pgasto[18];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 19) {
					ppos += ppos3;
					ppos3 = pgasto[19];
					ppos -= pgasto[19];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 20) {
					ppos += ppos3;
					ppos3 = pgasto[20];
					ppos -= pgasto[20];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 21) {
					ppos += ppos3;
					ppos3 = pgasto[21];
					ppos -= pgasto[21];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 22) {
					ppos += ppos3;
					ppos3 = pgasto[22];
					ppos -= pgasto[22];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 23) {
					ppos += ppos3;
					ppos3 = pgasto[23];
					ppos -= pgasto[23];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 24) {
					ppos += ppos3;
					ppos3 = pgasto[24];
					ppos -= pgasto[24];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 25) {
					ppos += ppos3;
					ppos3 = pgasto[25];
					ppos -= pgasto[25];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {

					}
				}
				if (comboBox_3.getSelectedIndex() == 26) {
					ppos += ppos3;
					ppos3 = pgasto[26];
					ppos -= pgasto[26];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 27) {
					ppos += ppos3;
					ppos3 = pgasto[27];
					ppos -= pgasto[27];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 28) {
					ppos += ppos3;
					ppos3 = pgasto[28];
					ppos -= pgasto[28];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 29) {
					ppos += ppos3;
					ppos3 = pgasto[29];
					ppos -= pgasto[29];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 30) {
					ppos += ppos3;
					ppos3 = pgasto[30];
					ppos -= pgasto[30];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 31) {
					ppos += ppos3;
					ppos3 = pgasto[31];
					ppos -= pgasto[31];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 32) {
					ppos += ppos3;
					ppos3 = pgasto[32];
					ppos -= pgasto[32];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 33) {
					ppos += ppos3;
					ppos3 = pgasto[33];
					ppos -= pgasto[33];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 34) {
					ppos += ppos3;
					ppos3 = pgasto[34];
					ppos -= pgasto[34];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 35) {
					ppos += ppos3;
					ppos3 = pgasto[35];
					ppos -= pgasto[35];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 36) {
					ppos += ppos3;
					ppos3 = pgasto[36];
					ppos -= pgasto[36];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 37) {
					ppos += ppos3;
					ppos3 = pgasto[37];
					ppos -= pgasto[37];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 38) {
					ppos += ppos3;
					ppos3 = pgasto[38];
					ppos -= pgasto[38];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 39) {
					ppos += ppos3;
					ppos3 = pgasto[39];
					ppos -= pgasto[39];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 40) {
					ppos += ppos3;
					ppos3 = pgasto[40];
					ppos -= pgasto[40];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if (comboBox_3.getSelectedIndex() == 41) {
					ppos += ppos3;
					ppos3 = pgasto[41];
					ppos -= pgasto[41];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
		if(comboBox_3.getSelectedIndex()== 42){
			ppos += ppos3;
			ppos3 = pgasto[44];
			ppos -= pgasto[44];
			txtPuntosDePosesin.setText("" + ppos);
			if (pos1.size() > 2) {
				pos1.remove(2);
				pos1.add(2, (String) comboBox_3.getSelectedItem());
			} else {
				pos1.add(2, (String) comboBox_3.getSelectedItem());
			}
		}
				if(comboBox_3.getSelectedIndex()== 43){
					ppos += ppos3;
					ppos3 = pgasto[44];
					ppos -= pgasto[44];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}
				if(comboBox_3.getSelectedIndex()== 44){
					ppos += ppos3;
					ppos3 = pgasto[44];
					ppos -= pgasto[44];
					txtPuntosDePosesin.setText("" + ppos);
					if (pos1.size() > 2) {
						pos1.remove(2);
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					} else {
						pos1.add(2, (String) comboBox_3.getSelectedItem());
					}
				}

			}
		});

		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"-Propiedad-", "+1 Fuerza", "+1 Destreza", "+1 Resistencia", "+1 Resistencia M\u00E1gica", "+1 Inteligencia", "+1 Percepci\u00F3n", "+1 Carisma", "+1 Armas de Una Mano", "+1 Armas de Dos Manos", "+1 Armas de Asta", "+1 Armas a Distancia", "+1 Esquivar", "+1 Bloquear", "+1 Arte de la Guerra", "+1 Diplomacia", "+1 Etiqueta", "+1 Medicina", "+1 Ocultismo", "+1 Investigacion", "+1 Negociaci\u00F3n", "+1 Conocimientos Secretos", "+1 Magia Fuego", "+1 Magia Agua", "+1 Magia Tierra", "+1 Magia Viento", "+1 Magia Blanca", "+1 Magia Negra", "+1 Magia Druidica", "+1 Magia Arcana", "+1 Atletismo", "+1 Supervivencia", "+1 Equitaci\u00F3n", "+1 Trampas", "+1 Sigilo", "Da\u00F1o Elemental de Fuego", "Da\u00F1o Elemental de Agua", "Da\u00F1o Elemental de Tierra", "Da\u00F1o Elemental de Viento", "Da\u00F1o Elemental Arcano", "Da\u00F1o Elemental Oscuro", "Da\u00F1o Elemental Sagrado", "+3 Salud", "+5 Energ\u00EDa", "+5 Man\u00E1"}));
		comboBox_3.setFont(mf.MyFont(0, 11));
		comboBox_3.setBounds(243, 389, 200, 24);
		frame.getContentPane().add(comboBox_3);
		final JButton button_2 = new JButton("+");
		button_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				button_2.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton +-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_2.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setIcon(new ImageIcon(Posesiones.class
				.getResource("/images/boton +-.png")));
		button_2.setBorderPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setFocusPainted(false);
		button_2.setOpaque(false);
		final JButton button_1 = new JButton("+");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_1.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton +-2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(Posesiones.class
						.getResource("/images/boton +-.png")));

			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setIcon(new ImageIcon(Posesiones.class
				.getResource("/images/boton +-.png")));
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.setOpaque(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_2.setVisible(true);
				button_2.setVisible(true);
				button_1.setVisible(false);
			}
		});
		button_1.setFont(mf.MyFont(0, 13));
		button_1.setBounds(296, 355, 93, 20);
		frame.getContentPane().add(button_1);

		button_2.setVisible(false);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_3.setVisible(true);
				button_2.setVisible(false);
			}
		});
		button_2.setFont(mf.MyFont(0, 13));
		button_2.setBounds(296, 389, 93, 20);
		frame.getContentPane().add(button_2);
		
		textField_4 = new JTextField();
		textField_4.setVisible(false);
		textField_4.setText("Clase de Arma:");
		textField_4.setOpaque(false);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(mf.MyFont(0, 11));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(new Color(205, 133, 63));
		textField_4.setBounds(345, 59, 90, 20);
		frame.getContentPane().add(textField_4);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(mf.MyFont(0, 11));
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		
	
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String arma=comboBox_4.getSelectedItem().toString();
				if(comboBox_4.getSelectedIndex()!=0){
				if(chckbxEscudo.isSelected()){
				try {
					ResultSet rs=Loader.tabla.executeQuery("SELECT * FROM ESCUDOS WHERE TIPO='"+arma+"'");
					while(rs.next()){
						textField_6.setText(rs.getString("ATRIBUTO"));
						textField_8.setText(rs.getString("REQUISITOS"));
						textArea_1.setText(rs.getString("EFECTO"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				if(chckbxUnaMano.isSelected()){
					try {
						ResultSet rs=Loader.tabla.executeQuery("SELECT * FROM UNAMANO WHERE TIPO='"+arma+"'");
						while(rs.next()){
							textField_6.setText(rs.getString("ATRIBUTO"));
							textField_8.setText(rs.getString("REQUISITOS"));
							textArea_1.setText(rs.getString("EFECTO"));
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
				if(chckbxDosManos.isSelected()){
					try {
						
						ResultSet rs=Loader.tabla.executeQuery("SELECT * FROM DOSMANOS WHERE TIPO='"+arma+"'");
						while(rs.next()){
							textField_6.setText(rs.getString("ATRIBUTO"));
							textField_8.setText(rs.getString("REQUISITOS"));
							textArea_1.setText(rs.getString("EFECTO"));
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
				if(chckbxDeAsta.isSelected()){
					try {
						ResultSet rs=Loader.tabla.executeQuery("SELECT * FROM ASTA WHERE TIPO='"+arma+"'");
					
						while(rs.next()){
							textField_6.setText(rs.getString("ATRIBUTO"));
							textField_8.setText(rs.getString("REQUISITOS"));
							textArea_1.setText(rs.getString("EFECTO"));
							
						}} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
				if(chckbxADistancia.isSelected()){
					try {
						ResultSet rs=Loader.tabla.executeQuery("SELECT * FROM DISTANCIA WHERE TIPO='"+arma+"'");
					
						while(rs.next()){
							textField_6.setText(rs.getString("ATRIBUTO"));
							textField_8.setText(rs.getString("REQUISITOS"));
							textArea_1.setText(rs.getString("EFECTO"));
							
						}} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
			}
			
				
			}
		});
		comboBox_4.setVisible(false);
		comboBox_4.setFont(mf.MyFont(0, 13));
		comboBox_4.setBounds(315, 90, 138, 20);
		frame.getContentPane().add(comboBox_4);
		
		textField_5 = new JTextField();
		textField_5.setVisible(false);
		textField_5.setText("Atributo Utilizado:");
		textField_5.setOpaque(false);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(mf.MyFont(0, 11));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(new Color(205, 133, 63));
		textField_5.setBounds(10, 231, 109, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setVisible(false);
		textField_6.setSelectionColor(SystemColor.textHighlight);
		textField_6.setForeground(Color.BLACK);
		textField_6.setFont(mf.MyFont(0, 11));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(10, 262, 138, 20);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setVisible(false);
		textField_7.setText("Requisitos:");
		textField_7.setOpaque(false);
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(mf.MyFont(0, 11));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(new Color(205, 133, 63));
		textField_7.setBounds(209, 231, 109, 20);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setVisible(false);
		textField_8.setSelectionColor(SystemColor.textHighlight);
		textField_8.setForeground(Color.BLACK);
		textField_8.setFont(mf.MyFont(0, 11));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(209, 262, 138, 20);
		frame.getContentPane().add(textField_8);
		
		textField_2 = new JTextField();
		textField_2.setVisible(false);
		textField_2.setText("Efectos:");
		textField_2.setOpaque(false);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(mf.MyFont(0, 13));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(205, 133, 63));
		textField_2.setBounds(326, 129, 117, 20);
		frame.getContentPane().add(textField_2);
		
		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVisible(false);
		scrollPane_1.setBounds(326, 158, 117, 93);
		frame.getContentPane().add(scrollPane_1);
		
		
		textArea_1.setVisible(false);
		scrollPane_1.setViewportView(textArea_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Posesiones.class
				.getResource("/images/background-posesiones.jpg")));
		label.setBounds(0, 0, 463, 534);
		frame.getContentPane().add(label);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedIndex() == 0) {
					txtTipoDeArma.setVisible(false);
					txtTipoDeAccesorio.setVisible(false);
					chckbxUnaMano.setVisible(false);
					chckbxDosManos.setVisible(false);
					chckbxDeAsta.setVisible(false);
					chckbxADistancia.setVisible(false);
					chckbxEscudo.setVisible(false);
					textField_2.setVisible(false);
					chckbxAnillo.setVisible(false);
					chckbxColgante.setVisible(false);
					chckbxPendiente.setVisible(false);
					chckbxCapa.setVisible(false);
					chckbxTela.setVisible(false);
					chckbxArmaduraLigera.setVisible(false);
					chckbxArmaduraPesada.setVisible(false);
					txtTipoArmadura.setVisible(false);
					txtNombre.setVisible(false);
					textField.setVisible(false);
					textField_4.setVisible(false);
					comboBox_4.setVisible(false);
					textField_5.setVisible(false);
					textField_6.setVisible(false);
					textField_7.setVisible(false);
					textField_8.setVisible(false);
					textField_2.setVisible(false);
					scrollPane_1.setVisible(false);
					textArea_1.setVisible(false);
					
				}

				if (comboBox.getSelectedIndex() == 1) {
					txtTipoDeArma.setVisible(false);
					txtTipoDeAccesorio.setVisible(false);
					chckbxUnaMano.setVisible(false);
					chckbxDosManos.setVisible(false);
					chckbxDeAsta.setVisible(false);
					chckbxADistancia.setVisible(false);
					chckbxEscudo.setVisible(false);
					textField_2.setVisible(false);
					chckbxAnillo.setVisible(false);
					chckbxColgante.setVisible(false);
					chckbxPendiente.setVisible(false);
					chckbxCapa.setVisible(false);
					chckbxTela.setVisible(true);
					chckbxArmaduraLigera.setVisible(true);
					chckbxArmaduraPesada.setVisible(true);
					txtTipoArmadura.setVisible(true);
					txtNombre.setVisible(false);
					textField.setVisible(false);
					textField_4.setVisible(false);
					comboBox_4.setVisible(false);
					textField_5.setVisible(false);
					textField_6.setVisible(false);
					textField_7.setVisible(false);
					textField_8.setVisible(false);
					textField_2.setVisible(false);
					scrollPane_1.setVisible(false);
					textArea_1.setVisible(false);

				}
				if (comboBox.getSelectedIndex() == 2) {
					txtTipoDeArma.setVisible(true);
					txtTipoDeAccesorio.setVisible(false);
					chckbxUnaMano.setVisible(true);
					chckbxDosManos.setVisible(true);
					chckbxDeAsta.setVisible(true);
					chckbxADistancia.setVisible(true);
					chckbxEscudo.setVisible(true);
					textField_2.setVisible(true);
					chckbxAnillo.setVisible(false);
					chckbxColgante.setVisible(false);
					chckbxPendiente.setVisible(false);
					chckbxCapa.setVisible(false);
					chckbxTela.setVisible(false);
					chckbxArmaduraLigera.setVisible(false);
					chckbxArmaduraPesada.setVisible(false);
					txtTipoArmadura.setVisible(false);
					txtNombre.setVisible(true);
					textField.setVisible(true);
					textField_4.setVisible(true);
					comboBox_4.setVisible(true);
					textField_5.setVisible(true);
					textField_6.setVisible(true);
					textField_7.setVisible(true);
					textField_8.setVisible(true);
					textField_2.setVisible(true);
					scrollPane_1.setVisible(true);
					textArea_1.setVisible(true);

				}
				if (comboBox.getSelectedIndex() == 3) {
					txtTipoDeArma.setVisible(false);
					txtTipoDeAccesorio.setVisible(false);
					chckbxAnillo.setVisible(false);
					chckbxColgante.setVisible(false);
					chckbxPendiente.setVisible(false);
					chckbxCapa.setVisible(false);
					chckbxUnaMano.setVisible(false);
					chckbxDosManos.setVisible(false);
					chckbxDeAsta.setVisible(false);
					chckbxADistancia.setVisible(false);
					chckbxEscudo.setVisible(false);
					textField_2.setVisible(false);
					chckbxTela.setVisible(false);
					chckbxArmaduraLigera.setVisible(false);
					chckbxArmaduraPesada.setVisible(false);
					txtTipoArmadura.setVisible(false);
					txtNombre.setVisible(true);
					textField.setVisible(true);
					textField_4.setVisible(false);
					comboBox_4.setVisible(false);
					textField_5.setVisible(false);
					textField_6.setVisible(false);
					textField_7.setVisible(false);
					textField_8.setVisible(false);
					textField_2.setVisible(false);
					scrollPane_1.setVisible(false);
					textArea_1.setVisible(false);

				}
				if (comboBox.getSelectedIndex() == 4) {
					txtTipoDeArma.setVisible(false);
					txtTipoDeAccesorio.setVisible(true);
					chckbxAnillo.setVisible(true);
					chckbxColgante.setVisible(true);
					chckbxPendiente.setVisible(true);
					chckbxCapa.setVisible(true);
					chckbxUnaMano.setVisible(false);
					chckbxDosManos.setVisible(false);
					chckbxDeAsta.setVisible(false);
					chckbxADistancia.setVisible(false);
					chckbxEscudo.setVisible(false);
					textField_2.setVisible(false);
					chckbxTela.setVisible(false);
					chckbxArmaduraLigera.setVisible(false);
					chckbxArmaduraPesada.setVisible(false);
					txtTipoArmadura.setVisible(false);
					txtNombre.setVisible(true);
					textField.setVisible(true);
					textField_4.setVisible(false);
					comboBox_4.setVisible(false);
					textField_5.setVisible(false);
					textField_6.setVisible(false);
					textField_7.setVisible(false);
					textField_8.setVisible(false);
					textField_2.setVisible(false);
					scrollPane_1.setVisible(false);
					textArea_1.setVisible(false);

				}

			}
		});
		chckbxUnaMano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxUnaMano.isSelected() == true) {
					Armas.tipow = "Una Mano";
					chckbxAnillo.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxEscudo.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);
					
					try{
						
						ResultSet rs;
						rs=Loader.tabla.executeQuery("SELECT * FROM UNAMANO");
						ArrayList<Object>clase=new ArrayList();
						clase.add("-Clase de Arma-");
						while(rs.next()){
							
							clase.add(rs.getString("TIPO"));
						}
						Object[] subtipo=clase.toArray();
						comboBox_4.setModel(new DefaultComboBoxModel(subtipo));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				} else {
					Armas.tipow = "";
					chckbxAnillo.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxEscudo.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);
					comboBox_4.setModel(new DefaultComboBoxModel());
				}
			}
		});
		chckbxDosManos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxDosManos.isSelected() == true) {
					Armas.tipow = "Dos Manos";
					chckbxAnillo.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxEscudo.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);
					
					try{
						
						ResultSet rs;
						rs=Loader.tabla.executeQuery("SELECT * FROM DOSMANOS");
						ArrayList<Object>clase=new ArrayList();
						clase.add("-Clase de Arma-");
						while(rs.next()){
							
							clase.add(rs.getString("TIPO"));
						}
						Object[] subtipo=clase.toArray();
						comboBox_4.setModel(new DefaultComboBoxModel(subtipo));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				} else {
					Armas.tipow = "";
					chckbxAnillo.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxEscudo.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);
					comboBox_4.setModel(new DefaultComboBoxModel());

				}
			}
		});
		chckbxDeAsta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxDeAsta.isSelected() == true) {
					Armas.tipow = "De Asta";
					chckbxAnillo.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxEscudo.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);
					
					try{
						
						ResultSet rs;
						rs=Loader.tabla.executeQuery("SELECT * FROM ASTA");
						ArrayList<Object>clase=new ArrayList();
						clase.add("-Clase de Arma-");
						while(rs.next()){
							
							clase.add(rs.getString("TIPO"));
						}
						Object[] subtipo=clase.toArray();
						comboBox_4.setModel(new DefaultComboBoxModel(subtipo));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				} else {
					Armas.tipow = "";
					chckbxAnillo.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxEscudo.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);
					comboBox_4.setModel(new DefaultComboBoxModel());
				}
			}
		});
		chckbxADistancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxADistancia.isSelected() == true) {
					Armas.tipow = "A Distancia";
					chckbxAnillo.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxEscudo.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);
					try{
						
						ResultSet rs;
						rs=Loader.tabla.executeQuery("SELECT * FROM DISTANCIA");
						ArrayList<Object>clase=new ArrayList();
						clase.add("-Clase de Arma-");
						while(rs.next()){
							
							clase.add(rs.getString("TIPO"));
						}
						Object[] subtipo=clase.toArray();
						comboBox_4.setModel(new DefaultComboBoxModel(subtipo));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					

				} else {
					Armas.tipow = "";
					chckbxAnillo.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxEscudo.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);
					comboBox_4.setModel(new DefaultComboBoxModel());
					
				}
			}
		});
		chckbxEscudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxEscudo.isSelected() == true) {
					Armas.tipow = "Escudo";
					chckbxAnillo.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);
					
					try{
						
						ResultSet rs;
						rs=Loader.tabla.executeQuery("SELECT * FROM ESCUDOS");
						ArrayList<Object>clase=new ArrayList();
						clase.add("-Clase de Arma-");
						while(rs.next()){
							
							clase.add(rs.getString("TIPO"));
						}
						Object[] subtipo=clase.toArray();
						comboBox_4.setModel(new DefaultComboBoxModel(subtipo));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				} else {
					Armas.tipow = "";
					chckbxAnillo.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);
					comboBox_4.setModel(new DefaultComboBoxModel());

				}
			}
		});
		chckbxAnillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxAnillo.isSelected() == true) {
					Posesiones.tipoac = "Anillo";
					chckbxUnaMano.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);

				} else {
					Posesiones.tipoac = "";
					chckbxUnaMano.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);
				}
			}
		});
		chckbxColgante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxColgante.isSelected() == true) {
					Posesiones.tipoac = "Colgante";
					chckbxUnaMano.setEnabled(false);
					chckbxAnillo.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);

				} else {
					Posesiones.tipoac = "";
					chckbxUnaMano.setEnabled(true);
					chckbxAnillo.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);
				}
			}
		});
		chckbxPendiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxPendiente.isSelected() == true) {
					Posesiones.tipoac = "Colgante";
					chckbxUnaMano.setEnabled(false);
					chckbxAnillo.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxCapa.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);

				} else {
					Posesiones.tipoac = "";
					chckbxUnaMano.setEnabled(true);
					chckbxAnillo.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxCapa.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);

				}
			}
		});
		chckbxCapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxCapa.isSelected() == true) {
					Posesiones.tipoac = "Colgante";
					chckbxUnaMano.setEnabled(false);
					chckbxAnillo.setEnabled(false);
					chckbxColgante.setEnabled(false);
					chckbxPendiente.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxUnaMano.setEnabled(false);
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);

				} else {
					Posesiones.tipoac = "";
					chckbxUnaMano.setEnabled(true);
					chckbxAnillo.setEnabled(true);
					chckbxColgante.setEnabled(true);
					chckbxPendiente.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxUnaMano.setEnabled(true);
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);
				}
			}
		});
	}

}
