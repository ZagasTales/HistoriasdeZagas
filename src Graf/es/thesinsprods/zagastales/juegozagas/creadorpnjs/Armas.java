package es.thesinsprods.zagastales.juegozagas.creadorpnjs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.equipment.OneHanded;
import es.thesinsprods.zagastales.characters.equipment.Pole;
import es.thesinsprods.zagastales.characters.equipment.Ranged;
import es.thesinsprods.zagastales.characters.equipment.Shields;
import es.thesinsprods.zagastales.characters.equipment.TwoHanded;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;

public class Armas {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTipoDeArma;
	private JTextField txtNombreArma;
	private JTextField textField;
	private JTextField txtDescripcinArma;
	public static String tipow;
	public static String descripcionw;
	public static boolean arrojadiza;
	MorpheusFont mf = new MorpheusFont();
	private JTextField txtClaseDeArma;
	private JTextField txtEfectos;
	private JTextField txtAtributoUtilizado;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField txtRequisitos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Armas window = new Armas();
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
	public Armas() {
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
		frame.setBounds(100, 100, 405, 347);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);

		frame.getContentPane().setLayout(null);

		txtTipoDeArma = new JTextField();
		txtTipoDeArma.setOpaque(false);
		txtTipoDeArma.setForeground(Color.WHITE);
		txtTipoDeArma.setBackground(new Color(205, 133, 63));
		txtTipoDeArma.setText("Tipo de Arma:");
		txtTipoDeArma.setFont(mf.MyFont(0, 13));
		txtTipoDeArma.setEditable(false);
		txtTipoDeArma.setColumns(10);
		txtTipoDeArma.setBorder(null);
		txtTipoDeArma.setBounds(10, 11, 90, 20);
		frame.getContentPane().add(txtTipoDeArma);
		final JComboBox comboBox = new JComboBox();
		final JCheckBox chckbxUnaMano = new JCheckBox("Una Mano");
		final JCheckBox chckbxDosManos = new JCheckBox("Dos Manos");
		final JCheckBox chckbxDeAsta = new JCheckBox("De Asta");
		final JCheckBox chckbxADistancia = new JCheckBox("A Distancia");
		final JCheckBox chckbxEscudo = new JCheckBox("Escudo");
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setFont(mf.MyFont(0, 11));
		textArea_1.setWrapStyleWord(true);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String arma=comboBox.getSelectedItem().toString();
				if(comboBox.getSelectedIndex()!=0){
				if(chckbxEscudo.isSelected()){
				try {
					ResultSet rs=Loader.tabla.executeQuery("SELECT * FROM ESCUDOS WHERE TIPO='"+arma+"'");
					while(rs.next()){
						textField_2.setText(rs.getString("ATRIBUTO"));
						textField_1.setText(rs.getString("REQUISITOS"));
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
							textField_2.setText(rs.getString("ATRIBUTO"));
							textField_1.setText(rs.getString("REQUISITOS"));
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
							textField_2.setText(rs.getString("ATRIBUTO"));
							textField_1.setText(rs.getString("REQUISITOS"));
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
							textField_2.setText(rs.getString("ATRIBUTO"));
							textField_1.setText(rs.getString("REQUISITOS"));
							textArea_1.setText(rs.getString("EFECTO"));
							
						}} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
				if(chckbxADistancia.isSelected()){
					try {
						ResultSet rs=Loader.tabla.executeQuery("SELECT * FROM DISTANCIA WHERE TIPO='"+arma+"'");
					
						while(rs.next()){
							textField_2.setText(rs.getString("ATRIBUTO"));
							textField_1.setText(rs.getString("REQUISITOS"));
							textArea_1.setText(rs.getString("EFECTO"));
							
						}} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
			}
			}});
		comboBox.setFont(mf.MyFont(0, 13));
		textField_2 = new JTextField();
		textField_1 = new JTextField();
		
		
		chckbxUnaMano.setOpaque(false);
		chckbxUnaMano.setForeground(Color.WHITE);
		chckbxUnaMano.setBackground(new Color(205, 133, 63));

		chckbxDosManos.setOpaque(false);
		chckbxDosManos.setForeground(Color.WHITE);
		chckbxDosManos.setBackground(new Color(205, 133, 63));


		chckbxDeAsta.setOpaque(false);
		chckbxDeAsta.setForeground(Color.WHITE);
		chckbxDeAsta.setBackground(new Color(205, 133, 63));
		chckbxADistancia.setOpaque(false);
		chckbxADistancia.setForeground(Color.WHITE);
		chckbxADistancia.setBackground(new Color(205, 133, 63));
		chckbxEscudo.setOpaque(false);
		chckbxEscudo.setForeground(Color.WHITE);
		chckbxEscudo.setBackground(new Color(205, 133, 63));
		chckbxUnaMano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxUnaMano.isSelected() == true) {
					tipow = "Una Mano";
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxEscudo.setEnabled(false);
					
					try{
					
					ResultSet rs;
					rs=Loader.tabla.executeQuery("SELECT * FROM UNAMANO");
					ArrayList<Object>clase=new ArrayList();
					clase.add("-Clase de Arma-");
					while(rs.next()){
						
						clase.add(rs.getString("TIPO"));
					}
					Object[] subtipo=clase.toArray();
					comboBox.setModel(new DefaultComboBoxModel(subtipo));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					tipow = "";
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxEscudo.setEnabled(true);
					comboBox.setModel(new DefaultComboBoxModel());

				}
			}
		});
		chckbxDosManos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxDosManos.isSelected() == true) {
					tipow = "Dos Manos";
					chckbxUnaMano.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxEscudo.setEnabled(false);
				
					try{
					ResultSet rs;
					rs=Loader.tabla.executeQuery("SELECT * FROM DOSMANOS");
					ArrayList<Object>clase=new ArrayList();
					clase.add("-Clase de Arma-");
					while(rs.next()){
						
						clase.add(rs.getString("TIPO"));
					}
					Object[] subtipo=clase.toArray();
					comboBox.setModel(new DefaultComboBoxModel(subtipo));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				} else {
					tipow = "";
					chckbxUnaMano.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxEscudo.setEnabled(true);
					comboBox.setModel(new DefaultComboBoxModel());

				}

			}
		});
		chckbxDeAsta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxDeAsta.isSelected() == true) {
					tipow = "De Asta";
					chckbxUnaMano.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					chckbxEscudo.setEnabled(false);
					
					try{
						ResultSet rs;
						rs=Loader.tabla.executeQuery("SELECT * FROM ASTA");
					ArrayList<Object>clase=new ArrayList();
					clase.add("-Clase de Arma-");
					while(rs.next()){
						
						clase.add(rs.getString("TIPO"));
					}
					Object[] subtipo=clase.toArray();
					comboBox.setModel(new DefaultComboBoxModel(subtipo));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} else {
					tipow = "";
					chckbxUnaMano.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					chckbxEscudo.setEnabled(true);
					comboBox.setModel(new DefaultComboBoxModel());

				}

			}
		});
		chckbxADistancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxADistancia.isSelected() == true) {
					tipow = "A Distancia";
					chckbxUnaMano.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxEscudo.setEnabled(false);
					try{
						ResultSet rs;
						rs=Loader.tabla.executeQuery("SELECT * FROM DISTANCIA");
					ArrayList<Object>clase=new ArrayList();
					clase.add("-Clase de Arma-");
					while(rs.next()){
						
						clase.add(rs.getString("TIPO"));
					}
					Object[] subtipo=clase.toArray();
					comboBox.setModel(new DefaultComboBoxModel(subtipo));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					tipow = "";
					chckbxUnaMano.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxEscudo.setEnabled(true);
					comboBox.setModel(new DefaultComboBoxModel());

				}

			}
		});
		chckbxEscudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxEscudo.isSelected() == true) {
					tipow = "Escudo";
					chckbxUnaMano.setEnabled(false);
					chckbxDosManos.setEnabled(false);
					chckbxDeAsta.setEnabled(false);
					chckbxADistancia.setEnabled(false);
					try{
						ResultSet rs;
						rs=Loader.tabla.executeQuery("SELECT * FROM ESCUDOS");
					ArrayList<Object>clase=new ArrayList();
					clase.add("-Clase de Arma-");
					while(rs.next()){
						
						clase.add(rs.getString("TIPO"));
					}
					Object[] subtipo=clase.toArray();
					comboBox.setModel(new DefaultComboBoxModel(subtipo));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					tipow = "";
					chckbxUnaMano.setEnabled(true);
					chckbxDosManos.setEnabled(true);
					chckbxDeAsta.setEnabled(true);
					chckbxADistancia.setEnabled(true);
					comboBox.setModel(new DefaultComboBoxModel());

				}

			}
		});
		chckbxUnaMano.setFont(mf.MyFont(0, 11));
		chckbxUnaMano.setBounds(10, 68, 138, 23);
		frame.getContentPane().add(chckbxUnaMano);

		chckbxDosManos.setFont(mf.MyFont(0, 11));
		chckbxDosManos.setBounds(10, 101, 138, 23);
		frame.getContentPane().add(chckbxDosManos);

		chckbxDeAsta.setFont(mf.MyFont(0, 11));
		chckbxDeAsta.setBounds(10, 136, 138, 23);
		frame.getContentPane().add(chckbxDeAsta);

		chckbxADistancia.setFont(mf.MyFont(0, 11));
		chckbxADistancia.setBounds(10, 168, 138, 23);
		frame.getContentPane().add(chckbxADistancia);

		chckbxEscudo.setFont(mf.MyFont(0, 11));
		chckbxEscudo.setBounds(10, 207, 138, 23);
		frame.getContentPane().add(chckbxEscudo);

		txtNombreArma = new JTextField();
		txtNombreArma.setOpaque(false);
		txtNombreArma.setForeground(Color.WHITE);
		txtNombreArma.setBackground(new Color(205, 133, 63));
		txtNombreArma.setText("Nombre Arma:");
		txtNombreArma.setFont(mf.MyFont(0, 11));
		txtNombreArma.setEditable(false);
		txtNombreArma.setColumns(10);
		txtNombreArma.setBorder(null);
		txtNombreArma.setBounds(108, 71, 90, 20);
		frame.getContentPane().add(txtNombreArma);
		final JButton btnAadir = new JButton("A\u00F1adir");
		textField = new JTextField();
		if (textField.getText().equals("")) {
			btnAadir.setEnabled(false);
		}
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (textField.getText().equals("")) {
					btnAadir.setEnabled(false);
				} else {
					btnAadir.setEnabled(true);
				}
			}
		});
		textField.setSelectionColor(UIManager.getColor("textHighlight"));
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(Color.WHITE);
		textField.setFont(mf.MyFont(0, 11));
		textField.setBounds(108, 102, 138, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		txtDescripcinArma = new JTextField();
		txtDescripcinArma.setOpaque(false);
		txtDescripcinArma.setForeground(Color.WHITE);
		txtDescripcinArma.setBackground(new Color(205, 133, 63));
		txtDescripcinArma.setText("Descripci\u00F3n Arma:");
		txtDescripcinArma.setFont(mf.MyFont(0, 13));
		txtDescripcinArma.setEditable(false);
		txtDescripcinArma.setColumns(10);
		txtDescripcinArma.setBorder(null);
		txtDescripcinArma.setBounds(272, 11, 117, 20);
		frame.getContentPane().add(txtDescripcinArma);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(272, 40, 117, 93);
		frame.getContentPane().add(scrollPane);

		final JTextArea textArea = new JTextArea();
		textArea.setSelectionColor(UIManager.getColor("textHighlight"));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(Color.WHITE);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(mf.MyFont(0, 11));
		scrollPane.setViewportView(textArea);

		btnAadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadir.setIcon(new ImageIcon(Armas.class
						.getResource("/images/boton a\u00F1adir2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnAadir.setIcon(new ImageIcon(Armas.class
						.getResource("/images/boton a\u00F1adir.png")));
			}
		});
		btnAadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadir.setIcon(new ImageIcon(Armas.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnAadir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAadir.setBackground(new Color(139, 69, 19));
		btnAadir.setBorderPainted(false);
		btnAadir.setContentAreaFilled(false);
		btnAadir.setFocusPainted(false);
		btnAadir.setOpaque(false);
		btnAadir.setForeground(new Color(255, 255, 255));
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cont=0;
				if(comboBox.getSelectedItem().toString().equals("-Clase de Arma-")){
					int seleccion = JOptionPane.showOptionDialog(
							null,
							"Debes seleccionar una clase de arma.",
							"¡Atención!", JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
									 }, // null para YES, NO y CANCEL
							"opcion 1");
					cont++;
				}
				if (tipow.equals("Una Mano")) {
					OneHanded arma = new OneHanded(textField.getText(),
							textArea.getText(), false,false,
							Equipo.posss,comboBox.getSelectedItem().toString());
					if (Equipo.getTextField().getText().equals("")
							&& Equipo.pweap >= 1) {
						Equipo.weapon1 = arma;
						Equipo.getTextField().setText(
								Equipo.weapon1.getWeapon());
					} else {
						if (Equipo.getTextField_1().getText().equals("")
								&& Equipo.pweap >= 2) {
							Equipo.weapon2 = arma;
							Equipo.getTextField_1().setText(
									Equipo.weapon2.getWeapon());
						} else {
							if (Equipo.getTextField_2().getText().equals("")
									&& Equipo.pweap >= 3) {
								Equipo.weapon3 = arma;
								Equipo.getTextField_2().setText(
										Equipo.weapon3.getWeapon());
							} else {
								if (Equipo.getTextField_3().getText()
										.equals("")
										&& Equipo.pweap >= 4) {
									Equipo.weapon4 = arma;
									Equipo.getTextField_3().setText(
											Equipo.weapon4.getWeapon());
								} else {
									JOptionPane.showMessageDialog(
											frame.getContentPane(),
											"No puedes llevar más armas.", "",
											JOptionPane.ERROR_MESSAGE);

								}

							}

						}

					}

				}
				if (tipow.equals("Dos Manos")) {
					if(comboBox.getSelectedItem().toString().equals("Espadón") && Start.character.getAtributes().getStrength()<10){
						
						int seleccion = JOptionPane.showOptionDialog(
								null,
								"Para poder llevar un espadón necesitas al menos 10 de Fuerza",
								"¡Atención!", JOptionPane.YES_NO_OPTION,
								JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
										 }, // null para YES, NO y CANCEL
								"opcion 1");
						
						cont++;
					}
					else if(comboBox.getSelectedItem().toString().equals("Hacha de Guerra") && Start.character.getAtributes().getStrength()<10){
						
						int seleccion = JOptionPane.showOptionDialog(
								null,
								"Para poder llevar un hacha de guerra necesitas al menos 10 de Fuerza",
								"¡Atención!", JOptionPane.YES_NO_OPTION,
								JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
										 }, // null para YES, NO y CANCEL
								"opcion 1");
						
						cont++;
					}
					else if(comboBox.getSelectedItem().toString().equals("Martillo de Guerra") && Start.character.getAtributes().getStrength()<12){
						
						int seleccion = JOptionPane.showOptionDialog(
								null,
								"Para poder llevar un martillo de guerra necesitas al menos 12 de Fuerza",
								"¡Atención!", JOptionPane.YES_NO_OPTION,
								JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Aceptar"
										 }, // null para YES, NO y CANCEL
								"opcion 1");
						
						cont++;
					}
					else if(comboBox.getSelectedItem().toString().equals("Ultra-Espadón") && Start.character.getAtributes().getStrength()<15){
						
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
							textArea.getText(), false,false,
							Equipo.posss,comboBox.getSelectedItem().toString());
					if (Equipo.getTextField().getText().equals("")
							&& Equipo.pweap >= 1) {
						Equipo.weapon1 = arma;
						Equipo.getTextField().setText(
								Equipo.weapon1.getWeapon());
					} else {
						if (Equipo.getTextField_1().getText().equals("")
								&& Equipo.pweap >= 2) {
							Equipo.weapon2 = arma;
							Equipo.getTextField_1().setText(
									Equipo.weapon2.getWeapon());
						} else {
							if (Equipo.getTextField_2().getText().equals("")
									&& Equipo.pweap >= 3) {
								Equipo.weapon3 = arma;
								Equipo.getTextField_2().setText(
										Equipo.weapon3.getWeapon());
							} else {
								if (Equipo.getTextField_3().getText()
										.equals("")
										&& Equipo.pweap >= 4) {
									Equipo.weapon4 = arma;
									Equipo.getTextField_3().setText(
											Equipo.weapon4.getWeapon());
								} else {
									JOptionPane.showMessageDialog(
											frame.getContentPane(),
											"No puedes llevar más armas.", "",
											JOptionPane.ERROR_MESSAGE);

								}

							}

						}

					}

				}
				}
				if (tipow.equals("De Asta")) {
					Pole arma = new Pole(textField.getText(), textArea
							.getText(), false,false,
							Equipo.posss,comboBox.getSelectedItem().toString());
					if (Equipo.getTextField().getText().equals("")
							&& Equipo.pweap >= 1) {
						Equipo.weapon1 = arma;
						Equipo.getTextField().setText(
								Equipo.weapon1.getWeapon());
					} else {
						if (Equipo.getTextField_1().getText().equals("")
								&& Equipo.pweap >= 2) {
							Equipo.weapon2 = arma;
							Equipo.getTextField_1().setText(
									Equipo.weapon2.getWeapon());
						} else {
							if (Equipo.getTextField_2().getText().equals("")
									&& Equipo.pweap >= 3) {
								Equipo.weapon3 = arma;
								Equipo.getTextField_2().setText(
										Equipo.weapon3.getWeapon());
							} else {
								if (Equipo.getTextField_3().getText()
										.equals("")
										&& Equipo.pweap >= 4) {
									Equipo.weapon4 = arma;
									Equipo.getTextField_3().setText(
											Equipo.weapon4.getWeapon());
								} else {
									JOptionPane.showMessageDialog(
											frame.getContentPane(),
											"No puedes llevar más armas.", "",
											JOptionPane.ERROR_MESSAGE);

								}

							}

						}

					}

				}
				if (tipow.equals("A Distancia")) {
					if(comboBox.getSelectedItem().toString().equals("Arma de Fuego") && Start.character.getKnowledgeSkills().getSecretKnowledge()<2){
						
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
					
					Ranged arma = new Ranged(textField.getText(), textArea
							.getText(), false,false,
							Equipo.posss,comboBox.getSelectedItem().toString());
					if (Equipo.getTextField().getText().equals("")
							&& Equipo.pweap >= 1) {
						Equipo.weapon1 = arma;
						Equipo.getTextField().setText(
								Equipo.weapon1.getWeapon());
					} else {
						if (Equipo.getTextField_1().getText().equals("")
								&& Equipo.pweap >= 2) {
							Equipo.weapon2 = arma;
							Equipo.getTextField_1().setText(
									Equipo.weapon2.getWeapon());
						} else {
							if (Equipo.getTextField_2().getText().equals("")
									&& Equipo.pweap >= 3) {
								Equipo.weapon3 = arma;
								Equipo.getTextField_2().setText(
										Equipo.weapon3.getWeapon());
							} else {
								if (Equipo.getTextField_3().getText()
										.equals("")
										&& Equipo.pweap >= 4) {
									Equipo.weapon4 = arma;
									Equipo.getTextField_3().setText(
											Equipo.weapon4.getWeapon());
								} else {
									JOptionPane.showMessageDialog(
											frame.getContentPane(),
											"No puedes llevar más armas.", "",
											JOptionPane.ERROR_MESSAGE);

								}

							}

						}

					}
					
				}

				}
				if (tipow.equals("Escudo")) {
					
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
					Shields arma = new Shields(textField.getText(), textArea
							.getText(), false,false,
							Equipo.posss,comboBox.getSelectedItem().toString());
					if (Equipo.getTextField().getText().equals("")
							&& Equipo.pweap >= 1) {
						Equipo.weapon1 = arma;
						Equipo.getTextField().setText(
								Equipo.weapon1.getWeapon());
					} else {
						if (Equipo.getTextField_1().getText().equals("")
								&& Equipo.pweap >= 2) {
							Equipo.weapon2 = arma;
							Equipo.getTextField_1().setText(
									Equipo.weapon2.getWeapon());
						} else {
							if (Equipo.getTextField_2().getText().equals("")
									&& Equipo.pweap >= 3) {
								Equipo.weapon3 = arma;
								Equipo.getTextField_2().setText(
										Equipo.weapon3.getWeapon());
							} else {
								if (Equipo.getTextField_3().getText()
										.equals("")
										&& Equipo.pweap >= 4) {
									Equipo.weapon4 = arma;
									Equipo.getTextField_3().setText(
											Equipo.weapon4.getWeapon());
								} else {
									JOptionPane.showMessageDialog(
											frame.getContentPane(),
											"No puedes llevar más armas.", "",
											JOptionPane.ERROR_MESSAGE);

								}

							}

						}

					}
				}

				}
			if(cont==0){
					Equipo.armasPuestas++;
					frame.dispose();}
				
			}
		});
		btnAadir.setFont(mf.MyFont(0, 13));
		btnAadir.setBounds(269, 272, 120, 34);
		frame.getContentPane().add(btnAadir);

		final JButton btnVolver = new JButton("");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(Armas.class
						.getResource("/images/boton atras2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(Armas.class
						.getResource("/images/boton atras.png")));
			}
		});
		btnVolver.setIcon(new ImageIcon(Armas.class
				.getResource("/images/boton atras.png")));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnVolver.setBackground(new Color(139, 69, 19));
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnVolver.setFont(mf.MyFont(0, 13));
		btnVolver.setBounds(10, 272, 99, 34);
		frame.getContentPane().add(btnVolver);
		
	
		comboBox.setBounds(108, 42, 138, 20);
		frame.getContentPane().add(comboBox);
		
		txtClaseDeArma = new JTextField();
		txtClaseDeArma.setText("Clase de Arma:");
		txtClaseDeArma.setOpaque(false);
		txtClaseDeArma.setForeground(Color.WHITE);
		txtClaseDeArma.setFont(mf.MyFont(0,11));
		txtClaseDeArma.setEditable(false);
		txtClaseDeArma.setColumns(10);
		txtClaseDeArma.setBorder(null);
		txtClaseDeArma.setBackground(new Color(205, 133, 63));
		txtClaseDeArma.setBounds(138, 11, 90, 20);
		frame.getContentPane().add(txtClaseDeArma);
		
		txtEfectos = new JTextField();
		txtEfectos.setText("Efectos:");
		txtEfectos.setOpaque(false);
		txtEfectos.setForeground(Color.WHITE);
		txtEfectos.setFont(mf.MyFont(0,13));
		txtEfectos.setEditable(false);
		txtEfectos.setColumns(10);
		txtEfectos.setBorder(null);
		txtEfectos.setBackground(new Color(205, 133, 63));
		txtEfectos.setBounds(272, 137, 117, 20);
		frame.getContentPane().add(txtEfectos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(272, 166, 117, 93);
		frame.getContentPane().add(scrollPane_1);
		
	
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
		
		txtAtributoUtilizado = new JTextField();
		txtAtributoUtilizado.setText("Atributo Utilizado:");
		txtAtributoUtilizado.setOpaque(false);
		txtAtributoUtilizado.setForeground(Color.WHITE);
		txtAtributoUtilizado.setFont(mf.MyFont(0,11));
		txtAtributoUtilizado.setEditable(false);
		txtAtributoUtilizado.setColumns(10);
		txtAtributoUtilizado.setBorder(null);
		txtAtributoUtilizado.setBackground(new Color(205, 133, 63));
		txtAtributoUtilizado.setBounds(108, 135, 109, 20);
		frame.getContentPane().add(txtAtributoUtilizado);
		
		
		textField_2.setEditable(false);
		textField_2.setSelectionColor(SystemColor.textHighlight);
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(mf.MyFont(0,11));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(108, 166, 138, 20);
		frame.getContentPane().add(textField_2);
		
	
		textField_1.setSelectionColor(SystemColor.textHighlight);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(mf.MyFont(0,11));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(108, 228, 138, 20);
		frame.getContentPane().add(textField_1);
		
		txtRequisitos = new JTextField();
		txtRequisitos.setText("Requisitos:");
		txtRequisitos.setOpaque(false);
		txtRequisitos.setForeground(Color.WHITE);
		txtRequisitos.setFont(mf.MyFont(0,11));
		txtRequisitos.setEditable(false);
		txtRequisitos.setColumns(10);
		txtRequisitos.setBorder(null);
		txtRequisitos.setBackground(new Color(205, 133, 63));
		txtRequisitos.setBounds(108, 197, 109, 20);
		frame.getContentPane().add(txtRequisitos);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Armas.class.getResource("/images/background-habilidades2.jpg")));
		label.setBounds(0, 0, 399, 319);
		frame.getContentPane().add(label);
	}

}
