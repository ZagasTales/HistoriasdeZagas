package es.thesinsprods.zagastales.juegozagas.creadornpcs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import es.thesinsprods.zagastales.characters.equipment.Misc;

public class ObjetosNPC {

	private JFrame frame;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField txtObjeto;
	private JTextField txtDescripcin;
	MorpheusFont mf = new MorpheusFont();
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
					ObjetosNPC window = new ObjetosNPC();
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
	public ObjetosNPC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Historias de Zagas");

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArmasNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setBounds(100, 100, 416, 257);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		final JButton btnAadir = new JButton("A\u00F1adir");
		textField = new JTextField();
		if (textField.getText().equals("")) {
			btnAadir.setEnabled(false);

		}
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (textField.getText().equals("")) {
					btnAadir.setEnabled(false);
				} else {
					btnAadir.setEnabled(true);
				}
			}

		});
		textField.setBackground(Color.WHITE);
		textField.setBounds(10, 42, 183, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setFont(mf.MyFont(0, 11));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(210, 42, 183, 114);
		frame.getContentPane().add(scrollPane);

		final JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		textArea.setFont(mf.MyFont(0, 11));

		btnAadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadir.setIcon(new ImageIcon(ObjetosNPC.class
						.getResource("/images/boton a\u00F1adir2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnAadir.setIcon(new ImageIcon(ObjetosNPC.class
						.getResource("/images/boton a\u00F1adir.png")));

			}
		});
		btnAadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadir.setIcon(new ImageIcon(ObjetosNPC.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnAadir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAadir.setForeground(new Color(255, 255, 255));
		btnAadir.setBackground(new Color(139, 69, 19));
		btnAadir.setBorderPainted(false);
		btnAadir.setContentAreaFilled(false);
		btnAadir.setFocusPainted(false);
		btnAadir.setOpaque(false);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Misc objeto = new Misc(textField.getText(), textArea.getText(),
						false, false,EquipoNPC.posss);
				if (EquipoNPC.getTextField_4().getText().equals("")
						&& EquipoNPC.pmisc >= 1) {
					EquipoNPC.misc1 = objeto;
					EquipoNPC.getTextField_4().setText(
							"" + EquipoNPC.misc1.getMisc());
				} else {
					if (EquipoNPC.getTextField_5().getText().equals("")
							&& EquipoNPC.pmisc >= 2) {
						EquipoNPC.misc2 = objeto;
						EquipoNPC.getTextField_5().setText(
								"" + EquipoNPC.misc2.getMisc());
					} else {
						if (EquipoNPC.getTextField_6().getText().equals("")
								&& EquipoNPC.pmisc >= 3) {
							EquipoNPC.misc3 = objeto;
							EquipoNPC.getTextField_6().setText(
									"" + EquipoNPC.misc3.getMisc());
						} else {
							if (EquipoNPC.getTextField_7().getText().equals("")
									&& EquipoNPC.pmisc >= 4) {
								EquipoNPC.misc4 = objeto;
								EquipoNPC.getTextField_7().setText(
										"" + EquipoNPC.misc4.getMisc());
							} else {
								JOptionPane.showMessageDialog(frame.getContentPane(),
										"No puedes llevar más objetos.", "",
										JOptionPane.ERROR_MESSAGE);

							}
						}
					}

				}
				frame.dispose();
			}
		});
		btnAadir.setFont(mf.MyFont(0, 13));
		btnAadir.setBounds(233, 167, 124, 38);
		frame.getContentPane().add(btnAadir);

		final JButton btnVolver = new JButton("");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(ObjetosNPC.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(ObjetosNPC.class
						.getResource("/images/boton atras.png")));

			}
		});
		btnVolver.setIcon(new ImageIcon(ObjetosNPC.class
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
		btnVolver.setBounds(10, 167, 99, 44);
		frame.getContentPane().add(btnVolver);

		txtObjeto = new JTextField();
		txtObjeto.setOpaque(false);
		txtObjeto.setForeground(Color.WHITE);
		txtObjeto.setBackground(new Color(205, 133, 63));
		txtObjeto.setText("Objeto:");
		txtObjeto.setFont(mf.MyFont(0, 13));
		txtObjeto.setEditable(false);
		txtObjeto.setColumns(10);
		txtObjeto.setBorder(null);
		txtObjeto.setBounds(10, 11, 90, 20);
		frame.getContentPane().add(txtObjeto);

		txtDescripcin = new JTextField();
		txtDescripcin.setOpaque(false);
		txtDescripcin.setForeground(Color.WHITE);
		txtDescripcin.setBackground(new Color(205, 133, 63));
		txtDescripcin.setText("Descripci\u00F3n:");
		txtDescripcin.setFont(mf.MyFont(0, 13));
		txtDescripcin.setEditable(false);
		txtDescripcin.setColumns(10);
		txtDescripcin.setBorder(null);
		txtDescripcin.setBounds(210, 11, 90, 20);
		frame.getContentPane().add(txtDescripcin);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ObjetosNPC.class
				.getResource("/images/background-objetos.jpg")));
		label.setBounds(0, 0, 410, 229);
		frame.getContentPane().add(label);
	}

}
