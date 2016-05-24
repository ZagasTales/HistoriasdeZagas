package es.thesinsprods.zagastales.juegozagas.jugar.master.jugador7;

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

public class InfoMisc3Jugadores {

	private JFrame frame;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescripcin;
	private JTextField txtNombreDelObjeto;
	private JTextField textField;
	MorpheusFont mf = new MorpheusFont();
	private JTextField txtposesin;
	private JTextField textField_4;
	private JLabel label;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoMisc3Jugadores window = new InfoMisc3Jugadores();
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
	public InfoMisc3Jugadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						Personaje7.class
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

		textArea.setFont(mf.MyFont(0, 13));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(135, 153, 221, 99);
		frame.getContentPane().add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();

		textArea_1.setWrapStyleWord(true);
		textArea_1.setText("");
		textArea_1.setLineWrap(true);
		textArea_1.setFont(mf.MyFont(0, 13));
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);

		if (JugarOnline.personaje7.getMisc3().isPosesion() == true) {

			ArrayList<String> pos = JugarOnline.personaje7.getMisc3().getPossesion().getPos();
			for (int i = 0; i < pos.size(); i++) {
				if (pos.get(i) != ("-Propiedad-")) {
					if(!pos.get(i).equals("null")){
					textArea_1.append(pos.get(i) + "\n");
					}
				}

			}

		}

		txtNombreDelObjeto = new JTextField();
		txtNombreDelObjeto.setOpaque(false);
		txtNombreDelObjeto.setForeground(Color.WHITE);

		txtNombreDelObjeto.setText("Nombre del Objeto:");
		txtNombreDelObjeto.setFont(mf.MyFont(0, 13));
		txtNombreDelObjeto.setEditable(false);
		txtNombreDelObjeto.setColumns(10);
		txtNombreDelObjeto.setBorder(null);
		txtNombreDelObjeto.setBounds(10, 20, 115, 20);
		frame.getContentPane().add(txtNombreDelObjeto);

		textField = new JTextField();

		textField.setEditable(false);
		textField.setFont(mf.MyFont(0, 11));
		textField.setColumns(10);
		textField.setBounds(10, 51, 115, 20);
		frame.getContentPane().add(textField);

		final JButton btnVolver = new JButton("");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(Personaje7.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(Personaje7.class
						.getResource("/images/boton atras.png")));

			}
		});

		btnVolver.setIcon(new ImageIcon(InfoMisc3Jugadores.class
				.getResource("/images/boton atras.png")));
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolver.setFont(mf.MyFont(0, 15));
		btnVolver.setBounds(10, 206, 99, 45);
		frame.getContentPane().add(btnVolver);

		textField.setText(JugarOnline.personaje7.getMisc3().getMisc());
		if(!JugarOnline.personaje7.getMisc3().getDescription().equals("null")){
		textArea.setText(JugarOnline.personaje7.getMisc3().getDescription());
		}
		txtposesin = new JTextField();
		txtposesin.setOpaque(false);
		txtposesin.setForeground(Color.WHITE);

		txtposesin.setText("\u00BFPosesi\u00F3n?");
		txtposesin.setFont(mf.MyFont(0, 13));
		txtposesin.setEditable(false);
		txtposesin.setColumns(10);
		txtposesin.setBorder(null);
		txtposesin.setBounds(10, 82, 90, 20);
		frame.getContentPane().add(txtposesin);

		textField_4 = new JTextField();

		textField_4.setFont(mf.MyFont(0, 11));
		if (JugarOnline.personaje7.getMisc3().isPosesion() == true) {
			textField_4.setText("Posesión");
		}
		if (JugarOnline.personaje7.getMisc3().isPosesion() == false) {
			textField_4.setText("Normal");
		}
		if (JugarOnline.personaje7.getMisc3().isLegendaria() == true) {
			textField_4.setText("Legendario");
		}
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 113, 115, 20);
		frame.getContentPane().add(textField_4);
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
		textArea.setBackground(Color.WHITE);
		textArea_1.setBackground(Color.WHITE);
		txtNombreDelObjeto.setBackground(new Color(205, 133, 63));
		textField.setBackground(Color.WHITE);
		textField_4.setBackground(Color.WHITE);
		btnVolver.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(139, 69, 19));
		frame.getContentPane().setBackground(new Color(205, 133, 63));
		txtposesin.setBackground(new Color(205, 133, 63));

		label = new JLabel("");
		label.setIcon(new ImageIcon(InfoMisc3Jugadores.class
				.getResource("/images/background-infos.jpg")));
		label.setBounds(0, 0, 374, 273);
		frame.getContentPane().add(label);

	}

}