package es.thesinsprods.zagastales.juegozagas.jugar.master;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.equipment.Armor;

public class ArmaduraNPC {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField txtTipoDeArmadura;
	private JTextField textField;
	private JTextField txtDescripcin;
	public static Armor armor;
	
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArmaduraNPC window = new ArmaduraNPC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public ArmaduraNPC() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
		final ConexionDBOnline con = new ConexionDBOnline();
		final Connection p = con.accederDB();
		final Statement tabla=p.createStatement();
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArmaduraNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setTitle("Historias de Zagas");
		frame.setBounds(100, 100, 338, 325);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		txtTipoDeArmadura = new JTextField();
		txtTipoDeArmadura.setForeground(Color.WHITE);
		txtTipoDeArmadura.setOpaque(false);
		txtTipoDeArmadura.setBackground(new Color(205, 133, 63));
		txtTipoDeArmadura.setText("Tipo de Armadura:");
		txtTipoDeArmadura.setFont(mf.MyFont(0, 13));
		txtTipoDeArmadura.setEditable(false);
		txtTipoDeArmadura.setColumns(10);
		txtTipoDeArmadura.setBorder(null);
		txtTipoDeArmadura.setBounds(6, 11, 128, 20);
		frame.getContentPane().add(txtTipoDeArmadura);

		final JCheckBox chckbxTela = new JCheckBox("Tela");
		chckbxTela.setForeground(Color.WHITE);
		chckbxTela.setOpaque(false);
		chckbxTela.setBackground(new Color(205, 133, 63));
		chckbxTela.setFont(mf.MyFont(0, 11));
		chckbxTela.setBounds(6, 38, 117, 23);
		frame.getContentPane().add(chckbxTela);

		final JCheckBox chckbxArmaduraLigera = new JCheckBox("Armadura Ligera");
		chckbxArmaduraLigera.setForeground(Color.WHITE);
		chckbxArmaduraLigera.setOpaque(false);
		chckbxArmaduraLigera.setBackground(new Color(205, 133, 63));
		chckbxArmaduraLigera.setFont(mf.MyFont(0, 11));
		chckbxArmaduraLigera.setBounds(6, 77, 117, 23);
		frame.getContentPane().add(chckbxArmaduraLigera);

		final JCheckBox chckbxArmaduraPesada = new JCheckBox("Armadura Pesada");
		chckbxArmaduraPesada.setForeground(Color.WHITE);
		chckbxArmaduraPesada.setOpaque(false);
		chckbxArmaduraPesada.setBackground(new Color(205, 133, 63));
		chckbxArmaduraPesada.setFont(mf.MyFont(0, 11));
		chckbxArmaduraPesada.setBounds(6, 119, 117, 23);
		frame.getContentPane().add(chckbxArmaduraPesada);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setOpaque(false);
		textField.setBackground(new Color(205, 133, 63));
		textField.setText("Requisitos:");
		textField.setFont(mf.MyFont(0, 13));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(164, 11, 183, 20);
		frame.getContentPane().add(textField);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 38, 148, 100);
		frame.getContentPane().add(scrollPane);

		final JTextArea textArea = new JTextArea();
		textArea.setSelectionColor(UIManager.getColor("textHighlight"));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(Color.WHITE);
		textArea.setFont(mf.MyFont(0, 13));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		txtDescripcin = new JTextField();
		txtDescripcin.setForeground(Color.WHITE);
		txtDescripcin.setOpaque(false);
		txtDescripcin.setBackground(new Color(205, 133, 63));
		txtDescripcin.setText("Descripci\u00F3n");
		txtDescripcin.setFont(mf.MyFont(0, 13));
		txtDescripcin.setEditable(false);
		txtDescripcin.setColumns(10);
		txtDescripcin.setBorder(null);
		txtDescripcin.setBounds(164, 149, 183, 20);
		frame.getContentPane().add(txtDescripcin);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(164, 176, 148, 100);
		frame.getContentPane().add(scrollPane_1);

		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setSelectionColor(UIManager.getColor("textHighlight"));
		textArea_1.setForeground(new Color(0, 0, 0));
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setFont(mf.MyFont(0, 13));
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		scrollPane_1.setViewportView(textArea_1);

		final JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAadir.setIcon(new ImageIcon(ArmaduraNPC.class
						.getResource("/images/boton a\u00F1adir2.png")));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnAadir.setIcon(new ImageIcon(ArmaduraNPC.class
						.getResource("/images/boton a\u00F1adir.png")));

			}
		});
		btnAadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadir.setIcon(new ImageIcon(ArmaduraNPC.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnAadir.setForeground(new Color(255, 255, 255));
		btnAadir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAadir.setBorderPainted(false);
		btnAadir.setContentAreaFilled(false);
		btnAadir.setFocusPainted(false);
		btnAadir.setOpaque(false);
		btnAadir.setBackground(Color.WHITE);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ModificarEquipo.getTextField_12().getText().equals("")) {
					int cont = 0;
					if (chckbxTela.isSelected() == true) {
						ModificarEquipo.armor1 = new Armor("Tela", textArea_1
								.getText(), false,false, ModificarEquipo.posss);
					}
					if (chckbxArmaduraLigera.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() > 8) {
						ModificarEquipo.armor1 = new Armor("Armadura Ligera",
								textArea_1.getText(), false,false, ModificarEquipo.posss);
					}
					if (chckbxArmaduraLigera.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() <= 8) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 1);
							ModificarEquipo.armor1 = new Armor("Armadura Ligera",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura ligera dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraPesada.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() > 12
							&& ModificarEquipo.personaje.getPrivileges().Search(
									"Fornido") == false) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 1);
							ModificarEquipo.armor1 = new Armor("Armadura Pesada",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraPesada.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() > 12
							&& ModificarEquipo.personaje.getPrivileges().Search(
									"Fornido") == true) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes()
									.setDexterity(dexN);
							ModificarEquipo.armor1 = new Armor("Armadura Pesada",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraPesada.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() <= 12
							&& ModificarEquipo.personaje.getAtributes().getStrength() > 10) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 2);
							ModificarEquipo.armor1 = new Armor("Armadura Pesada",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraPesada.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() <= 10
							&& ModificarEquipo.personaje.getAtributes().getStrength() > 8) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 3);
							ModificarEquipo.armor1 = new Armor("Armadura Pesada",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraPesada.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() <= 8
							&& ModificarEquipo.personaje.getAtributes().getStrength() >= 6) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 4);
							ModificarEquipo.armor1 = new Armor("Armadura Pesada",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraLigera.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() > 8
							&& ModificarEquipo.personaje.getSetbacks().Search(
									"Debilidad") == true) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 1);
							ModificarEquipo.armor1 = new Armor("Armadura Ligera",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura Ligera dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraLigera.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() <= 8
							&& ModificarEquipo.personaje.getSetbacks().Search(
									"Debilidad") == true) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 2);
							ModificarEquipo.armor1 = new Armor("Armadura Ligera",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura ligera dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraPesada.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() > 12
							&& ModificarEquipo.personaje.getPrivileges().Search(
									"Fornido") == false
							&& ModificarEquipo.personaje.getSetbacks().Search(
									"Debilidad") == true) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 2);
							ModificarEquipo.armor1 = new Armor("Armadura Pesada",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraPesada.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() > 12
							&& ModificarEquipo.personaje.getPrivileges().Search(
									"Fornido") == true) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes()
									.setDexterity(dexN);
							ModificarEquipo.armor1 = new Armor("Armadura Pesada",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraPesada.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() <= 12
							&& ModificarEquipo.personaje.getAtributes().getStrength() > 10
							&& ModificarEquipo.personaje.getSetbacks().Search(
									"Debilidad") == true) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 4);
							ModificarEquipo.armor1 = new Armor("Armadura Pesada",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraPesada.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() <= 10
							&& ModificarEquipo.personaje.getAtributes().getStrength() > 8
							&& ModificarEquipo.personaje.getSetbacks().Search(
									"Debilidad") == true) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 6);
							ModificarEquipo.armor1 = new Armor("Armadura Pesada",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (chckbxArmaduraPesada.isSelected() == true
							&& ModificarEquipo.personaje.getAtributes().getStrength() <= 8
							&& ModificarEquipo.personaje.getAtributes().getStrength() >= 6
							&& ModificarEquipo.personaje.getSetbacks().Search(
									"Debilidad") == true) {
						int dexN = ModificarEquipo.personaje.getAtributes()
								.getDexterity();
						try {
							ModificarEquipo.personaje.getAtributes().setDexterity(
									dexN - 8);
							ModificarEquipo.armor1 = new Armor("Armadura Pesada",
									textArea_1.getText(), false,false,
									ModificarEquipo.posss);
						} catch (AtributeOutOfBoundsException e1) {
							JOptionPane
									.showMessageDialog(
											frame.getContentPane(),
											"No puedes equiparte una armadura pesada dado que tendrías una destreza menor de 6",
											"", JOptionPane.ERROR_MESSAGE);
							cont = 1;
						}

					}
					if (cont == 0) {
						ModificarEquipo.getTextField_12().setText(
								ModificarEquipo.armor1.getArmor());
						frame.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"No puedes llevar más armaduras.", "",
							JOptionPane.ERROR_MESSAGE);
				}
			
			
				try {
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET ARMADURA='"+ModificarEquipo.armor1.getArmor()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_ARMADURA='"+ModificarEquipo.armor1.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_ARMADURA='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_ARMADURA='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_ARMADURA='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_ARMADURA='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					
					if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje1.getName())){
						
						JugarOnline.personaje1.setArmor(ModificarEquipo.armor1);
						}
					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje2.getName())){
						
						JugarOnline.personaje2.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje3.getName())){
						
						JugarOnline.personaje3.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje4.getName())){
						
						JugarOnline.personaje4.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje5.getName())){
						
						JugarOnline.personaje5.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje6.getName())){
						
						JugarOnline.personaje6.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje7.getName())){
						
						JugarOnline.personaje7.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje8.getName())){
						
						JugarOnline.personaje8.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje9.getName())){
						
						JugarOnline.personaje9.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc1.getName())){
						
						JugarOnline.npc1.setArmor(ModificarEquipo.armor1);
						}


					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc2.getName())){
						
						JugarOnline.npc2.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc3.getName())){
						
						JugarOnline.npc3.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc4.getName())){
						
						JugarOnline.npc4.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc5.getName())){
						
						JugarOnline.npc5.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc6.getName())){
						
						JugarOnline.npc6.setArmor(ModificarEquipo.armor1);
						}


					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc7.getName())){
						
						JugarOnline.npc7.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc8.getName())){
						
						JugarOnline.npc8.setArmor(ModificarEquipo.armor1);
						}

					else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc9.getName())){
						
						JugarOnline.npc9.setArmor(ModificarEquipo.armor1);
						}
				
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnAadir.setFont(mf.MyFont(0, 13));
		btnAadir.setBounds(17, 165, 117, 38);
		frame.getContentPane().add(btnAadir);

		final JButton btnVolver = new JButton("");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(ArmaduraNPC.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(ArmaduraNPC.class
						.getResource("/images/boton atras.png")));

			}
		});
		btnVolver.setIcon(new ImageIcon(ArmaduraNPC.class
				.getResource("/images/boton atras.png")));
		btnVolver.setBackground(new Color(139, 69, 19));
		btnVolver.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnVolver.setForeground(new Color(255, 255, 255));
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
		btnVolver.setBounds(24, 249, 110, 27);
		frame.getContentPane().add(btnVolver);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ArmaduraNPC.class
				.getResource("/images/background-armadura.jpg")));
		lblNewLabel.setBounds(0, 0, 332, 297);
		frame.getContentPane().add(lblNewLabel);
		chckbxArmaduraPesada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxArmaduraPesada.isSelected() == true) {
					chckbxTela.setEnabled(false);
					chckbxArmaduraLigera.setEnabled(false);
					textArea.setText("Fuerza > 12 \n Este tipo de armaduras resta -1 a la Destreza.\n Se puede equipar igualmente con una penalización de -1 de Destreza por cada 2 puntos de Fuerza restantes para el mínimo necesario. ");
				} else {
					chckbxTela.setEnabled(true);
					chckbxArmaduraLigera.setEnabled(true);
					textArea.setText("");
				}
			}
		});
		chckbxArmaduraLigera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxArmaduraLigera.isSelected() == true) {
					chckbxTela.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);
					textArea.setText("Fuerza > 8\n De no ser así se puede equipar igualmente con una penalización de -1 de Destreza.");
				} else {

					chckbxTela.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);
					textArea.setText("");

				}
			}
		});

		chckbxTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxTela.isSelected() == true) {
					chckbxArmaduraLigera.setEnabled(false);
					chckbxArmaduraPesada.setEnabled(false);
					textArea.setText("Ninguno");
				} else {
					chckbxArmaduraLigera.setEnabled(true);
					chckbxArmaduraPesada.setEnabled(true);
					textArea.setText("");
				}
			}
		});
	}

}
