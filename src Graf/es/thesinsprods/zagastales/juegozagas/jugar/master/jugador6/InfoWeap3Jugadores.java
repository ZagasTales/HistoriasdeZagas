package es.thesinsprods.zagastales.juegozagas.jugar.master.jugador6;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.jugar.master.JugarOnline;

public class InfoWeap3Jugadores {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescripcin;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField txtesArrojadiza;
	private JTextField textField_3;
	private JTextField txtposesin;
	private JTextField textField_4;
	private JLabel lblNewLabel;

	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoWeap3Jugadores window = new InfoWeap3Jugadores();
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
	public InfoWeap3Jugadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205, 133, 63));
		frame.setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						Personaje6.class
								.getResource("/images/Historias de Zagas, logo.png")));
		frame.setTitle("Historias de Zagas");
		frame.setBounds(100, 100, 380, 301);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 51, 221, 99);
		frame.getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setFont(mf.MyFont(0, 13));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(135, 153, 221, 99);
		frame.getContentPane().add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setText("");
		textArea_1.setLineWrap(true);
		textArea_1.setFont(mf.MyFont(0, 13));
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);

		if (JugarOnline.personaje6.getWeapon3().isPosesion() == true) {

			ArrayList<String> pos = JugarOnline.personaje6.getWeapon3().getPossesion().getPos();
			for (int i = 0; i < pos.size(); i++) {
				if (pos.get(i) != ("-Propiedad-")) {
					if(!pos.get(i).equals("null")){
					textArea_1.append(pos.get(i) + "\n");
					}
				}

			}

		}

		txtDescripcin = new JTextField();
		txtDescripcin.setOpaque(false);
		txtDescripcin.setForeground(Color.WHITE);
		txtDescripcin.setBackground(new Color(205, 133, 63));
		txtDescripcin.setText("Descripci\u00F3n:");
		txtDescripcin.setFont(mf.MyFont(0, 13));
		txtDescripcin.setEditable(false);
		txtDescripcin.setColumns(10);
		txtDescripcin.setBorder(null);
		txtDescripcin.setBounds(135, 20, 90, 20);
		frame.getContentPane().add(txtDescripcin);

		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(new Color(205, 133, 63));
		textField_1.setText("Tipo de Arma:");
		textField_1.setFont(mf.MyFont(0, 13));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(10, 20, 90, 20);
		frame.getContentPane().add(textField_1);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setFont(mf.MyFont(0, 11));
		textField.setColumns(10);
		textField.setBounds(10, 51, 115, 20);
		frame.getContentPane().add(textField);

		final JButton btnVolver = new JButton("");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(Personaje6.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(Personaje6.class
						.getResource("/images/boton atras.png")));

			}
		});
		btnVolver.setIcon(new ImageIcon(InfoWeap3Jugadores.class
				.getResource("/images/boton atras.png")));
		btnVolver.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(139, 69, 19));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolver.setFont(mf.MyFont(0, 15));
		btnVolver.setBounds(10, 206, 99, 45);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		frame.getContentPane().add(btnVolver);

		txtesArrojadiza = new JTextField();
		txtesArrojadiza.setOpaque(false);
		txtesArrojadiza.setForeground(Color.WHITE);
		txtesArrojadiza.setBackground(new Color(205, 133, 63));
		txtesArrojadiza.setText("Subclase:");
		txtesArrojadiza.setFont(mf.MyFont(0, 13));
		txtesArrojadiza.setEditable(false);
		txtesArrojadiza.setColumns(10);
		txtesArrojadiza.setBorder(null);
		txtesArrojadiza.setBounds(10, 82, 90, 20);
		frame.getContentPane().add(txtesArrojadiza);

		textField_3 = new JTextField();
		textField_3.setBackground(Color.WHITE);
		textField_3.setFont(mf.MyFont(0, 11));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(10, 113, 115, 20);
		textField_3.setText(JugarOnline.personaje6.getWeapon3().getTipo());
		frame.getContentPane().add(textField_3);
		if (JugarOnline.personaje6.getWeapon3().getClass().getSimpleName().equals("OneHanded")) {
			textField.setText("Arma de una mano");
		}
		if (JugarOnline.personaje6.getWeapon3().getClass().getSimpleName().equals("TwoHanded")) {
			textField.setText("Arma de dos manos");
		}
		if (JugarOnline.personaje6.getWeapon3().getClass().getSimpleName().equals("Pole")) {
			textField.setText("Arma de asta");
		}
		if (JugarOnline.personaje6.getWeapon3().getClass().getSimpleName().equals("Ranged")) {
			textField.setText("Arma a Distancia");
			
		}
		if (JugarOnline.personaje6.getWeapon3().getClass().getSimpleName().equals("Shields")) {
			textField.setText("Escudo");
		}
		if(!JugarOnline.personaje6.getWeapon3().getDescription().equals("null")){
		textArea.setText(JugarOnline.personaje6.getWeapon3().getDescription());
		}
		txtposesin = new JTextField();
		txtposesin.setOpaque(false);
		txtposesin.setForeground(Color.WHITE);
		txtposesin.setBackground(new Color(205, 133, 63));
		txtposesin.setText("\u00BFPosesi\u00F3n?");
		txtposesin.setFont(mf.MyFont(0, 13));
		txtposesin.setEditable(false);
		txtposesin.setColumns(10);
		txtposesin.setBorder(null);
		txtposesin.setBounds(10, 144, 90, 20);
		frame.getContentPane().add(txtposesin);

		textField_4 = new JTextField();
		textField_4.setBackground(Color.WHITE);
		textField_4.setFont(mf.MyFont(0, 11));
		if (JugarOnline.personaje6.getWeapon3().isPosesion() == true) {
			textField_4.setText("Posesión");
		}
		if (JugarOnline.personaje6.getWeapon3().isPosesion() == false) {
			textField_4.setText("Normal");
		}
		if (JugarOnline.personaje6.getWeapon3().isLegendaria() == true) {
			textField_4.setText("Legendario");
		}
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 175, 115, 20);
		frame.getContentPane().add(textField_4);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InfoWeap3Jugadores.class
				.getResource("/images/background-infos.jpg")));
		lblNewLabel.setBounds(0, 0, 374, 273);
		frame.getContentPane().add(lblNewLabel);
	}

}