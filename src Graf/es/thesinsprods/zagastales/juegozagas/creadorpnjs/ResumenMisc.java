package es.thesinsprods.zagastales.juegozagas.creadorpnjs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.font.MorpheusFont;

public class ResumenMisc {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField textDescripcion;
	private JTextField textField_1;
	private JTextField txtposesin;
	private JTextField textField;
	private JTextField txtesArrojadiza;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_4;
	MorpheusFont mf = new MorpheusFont();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResumenMisc window = new ResumenMisc();
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
	public ResumenMisc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ResumenMisc.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 379, 335);
		frame.getContentPane().setLayout(null);
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBorder(null);
			tabbedPane.setFont(mf.MyFont(0, 13));
			tabbedPane.setBackground(new Color(255, 255, 255));
			tabbedPane.setBounds(0, 0, 374, 307);
			frame.getContentPane().add(tabbedPane);
			{
				JPanel panel = new JPanel();
				tabbedPane.addTab(Equipo.misc1.getMisc(), panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(135, 51, 221, 99);
				panel.add(scrollPane);

				JTextArea textArea = new JTextArea();
				textArea.setBackground(Color.WHITE);
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				textArea.setText(Equipo.misc1.getDescription());
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (Equipo.misc1.isPosesion() == true) {

					ArrayList<String> pos = Equipo.misc1.getPossesion()
							.getPos();
					for (int i = 0; i < pos.size(); i++) {
						if (pos.get(i) != ("-Propiedad-")) {
							textArea_1.append(pos.get(i) + "\n");

						}

					}

				}
				textArea_1.setEditable(false);
				scrollPane_1.setViewportView(textArea_1);

				textDescripcion = new JTextField();
				textDescripcion.setText("Descripci\u00F3n:");
				textDescripcion.setOpaque(false);
				textDescripcion.setForeground(Color.WHITE);
				textDescripcion.setFont(mf.MyFont(0, 13));
				textDescripcion.setEditable(false);
				textDescripcion.setColumns(10);
				textDescripcion.setBorder(null);
				textDescripcion.setBackground(new Color(205, 133, 63));
				textDescripcion.setBounds(135, 20, 90, 20);
				panel.add(textDescripcion);

				txtposesin = new JTextField();
				txtposesin.setText("\u00BFPosesi\u00F3n?");
				txtposesin.setOpaque(false);
				txtposesin.setForeground(Color.WHITE);
				txtposesin.setFont(mf.MyFont(0, 13));
				txtposesin.setEditable(false);
				txtposesin.setColumns(10);
				txtposesin.setBorder(null);
				txtposesin.setBackground(new Color(205, 133, 63));
				txtposesin.setBounds(10, 20, 90, 20);
				panel.add(txtposesin);

				textField = new JTextField();
				textField.setFont(mf.MyFont(0, 13));
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBackground(Color.WHITE);
				textField.setBounds(10, 51, 115, 20);
				panel.add(textField);

				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(ResumenMisc.class
						.getResource("/images/boton atras.png")));
				button.setOpaque(false);
				button.setForeground(Color.WHITE);
				button.setFont(mf.MyFont(0, 15));
				button.setFocusPainted(false);
				button.setContentAreaFilled(false);
				button.setBorderPainted(false);
				button.setBorder(new BevelBorder(BevelBorder.RAISED, null,
						null,

						null, null));
				button.setBackground(new Color(139, 69, 19));
				button.setBounds(10, 206, 99, 45);
				panel.add(button);

				if (Equipo.misc1.isPosesion() == true) {
					textField.setText("Posesión");
				}
				if (Equipo.misc1.isPosesion() == false) {
					textField.setText("Normal");
				}
				if (Equipo.misc1.isLegendaria() == true) {
					textField.setText("Legendario");
				}
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(ResumenMisc.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel.add(label);
			}

			JPanel panel_1 = new JPanel();
			tabbedPane.addTab(Equipo.misc2.getMisc(), null, panel_1, null);
			panel_1.setLayout(null);
			{

				panel_1.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(135, 51, 221, 99);
				panel_1.add(scrollPane);

				JTextArea textArea = new JTextArea();
				textArea.setBackground(Color.WHITE);
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				textArea.setText(Equipo.misc2.getDescription());
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_1.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (Equipo.misc2.isPosesion() == true) {

					ArrayList<String> pos = Equipo.misc2.getPossesion()
							.getPos();
					for (int i = 0; i < pos.size(); i++) {
						if (pos.get(i) != ("-Propiedad-")) {
							textArea_1.append(pos.get(i) + "\n");

						}

					}

				}
				textArea_1.setEditable(false);
				scrollPane_1.setViewportView(textArea_1);

				textDescripcion = new JTextField();
				textDescripcion.setText("Descripci\u00F3n:");
				textDescripcion.setOpaque(false);
				textDescripcion.setForeground(Color.WHITE);
				textDescripcion.setFont(mf.MyFont(0, 13));
				textDescripcion.setEditable(false);
				textDescripcion.setColumns(10);
				textDescripcion.setBorder(null);
				textDescripcion.setBackground(new Color(205, 133, 63));
				textDescripcion.setBounds(135, 20, 90, 20);
				panel_1.add(textDescripcion);

				txtposesin = new JTextField();
				txtposesin.setText("\u00BFPosesi\u00F3n?");
				txtposesin.setOpaque(false);
				txtposesin.setForeground(Color.WHITE);
				txtposesin.setFont(mf.MyFont(0, 13));
				txtposesin.setEditable(false);
				txtposesin.setColumns(10);
				txtposesin.setBorder(null);
				txtposesin.setBackground(new Color(205, 133, 63));
				txtposesin.setBounds(10, 20, 90, 20);
				panel_1.add(txtposesin);

				textField = new JTextField();
				textField.setFont(mf.MyFont(0, 13));
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBackground(Color.WHITE);
				textField.setBounds(10, 51, 115, 20);
				panel_1.add(textField);

				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(ResumenMisc.class
						.getResource("/images/boton atras.png")));
				button.setOpaque(false);
				button.setForeground(Color.WHITE);
				button.setFont(mf.MyFont(0, 15));
				button.setFocusPainted(false);
				button.setContentAreaFilled(false);
				button.setBorderPainted(false);
				button.setBorder(new BevelBorder(BevelBorder.RAISED, null,
						null,

						null, null));
				button.setBackground(new Color(139, 69, 19));
				button.setBounds(10, 206, 99, 45);
				panel_1.add(button);

				if (Equipo.misc2.isPosesion() == true) {
					textField.setText("Posesión");
				}
				if (Equipo.misc2.isPosesion() == false) {
					textField.setText("Normal");
				}
				if (Equipo.misc2.isLegendaria() == true) {
					textField.setText("Legendario");
				}
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(ResumenMisc.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_1.add(label);
			}

			JPanel panel_2 = new JPanel();
			tabbedPane.addTab(Equipo.misc3.getMisc(), null, panel_2, null);
			panel_2.setLayout(null);
			{

				panel_2.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(135, 51, 221, 99);
				panel_2.add(scrollPane);

				JTextArea textArea = new JTextArea();
				textArea.setBackground(Color.WHITE);
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				textArea.setText(Equipo.misc3.getDescription());
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_2.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (Equipo.misc3.isPosesion() == true) {

					ArrayList<String> pos = Equipo.misc3.getPossesion()
							.getPos();
					for (int i = 0; i < pos.size(); i++) {
						if (pos.get(i) != ("-Propiedad-")) {
							textArea_1.append(pos.get(i) + "\n");

						}

					}

				}
				textArea_1.setEditable(false);
				scrollPane_1.setViewportView(textArea_1);

				textDescripcion = new JTextField();
				textDescripcion.setText("Descripci\u00F3n:");
				textDescripcion.setOpaque(false);
				textDescripcion.setForeground(Color.WHITE);
				textDescripcion.setFont(mf.MyFont(0, 13));
				textDescripcion.setEditable(false);
				textDescripcion.setColumns(10);
				textDescripcion.setBorder(null);
				textDescripcion.setBackground(new Color(205, 133, 63));
				textDescripcion.setBounds(135, 20, 90, 20);
				panel_2.add(textDescripcion);

				txtposesin = new JTextField();
				txtposesin.setText("\u00BFPosesi\u00F3n?");
				txtposesin.setOpaque(false);
				txtposesin.setForeground(Color.WHITE);
				txtposesin.setFont(mf.MyFont(0, 13));
				txtposesin.setEditable(false);
				txtposesin.setColumns(10);
				txtposesin.setBorder(null);
				txtposesin.setBackground(new Color(205, 133, 63));
				txtposesin.setBounds(10, 20, 90, 20);
				panel_2.add(txtposesin);

				textField = new JTextField();
				textField.setFont(mf.MyFont(0, 13));
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBackground(Color.WHITE);
				textField.setBounds(10, 51, 115, 20);
				panel_2.add(textField);

				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(ResumenMisc.class
						.getResource("/images/boton atras.png")));
				button.setOpaque(false);
				button.setForeground(Color.WHITE);
				button.setFont(mf.MyFont(0, 15));
				button.setFocusPainted(false);
				button.setContentAreaFilled(false);
				button.setBorderPainted(false);
				button.setBorder(new BevelBorder(BevelBorder.RAISED, null,
						null,

						null, null));
				button.setBackground(new Color(139, 69, 19));
				button.setBounds(10, 206, 99, 45);
				panel_2.add(button);

				if (Equipo.misc3.isPosesion() == true) {
					textField.setText("Posesión");
				}
				if (Equipo.misc3.isPosesion() == false) {
					textField.setText("Normal");
				}
				if (Equipo.misc3.isLegendaria() == true) {
					textField.setText("Legendario");
				}
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(ResumenMisc.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_2.add(label);
			}
			JPanel panel_3 = new JPanel();
			tabbedPane.addTab(Equipo.misc4.getMisc(), null, panel_3, null);
			panel_3.setLayout(null);
			{
				panel_3.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(135, 51, 221, 99);
				panel_3.add(scrollPane);

				JTextArea textArea = new JTextArea();
				textArea.setBackground(Color.WHITE);
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				textArea.setText(Equipo.misc4.getDescription());
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_3.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (Equipo.misc4.isPosesion() == true) {

					ArrayList<String> pos = Equipo.misc4.getPossesion()
							.getPos();
					for (int i = 0; i < pos.size(); i++) {
						if (pos.get(i) != ("-Propiedad-")) {
							textArea_1.append(pos.get(i) + "\n");

						}

					}

				}
				textArea_1.setEditable(false);
				scrollPane_1.setViewportView(textArea_1);

				textDescripcion = new JTextField();
				textDescripcion.setText("Descripci\u00F3n:");
				textDescripcion.setOpaque(false);
				textDescripcion.setForeground(Color.WHITE);
				textDescripcion.setFont(mf.MyFont(0, 13));
				textDescripcion.setEditable(false);
				textDescripcion.setColumns(10);
				textDescripcion.setBorder(null);
				textDescripcion.setBackground(new Color(205, 133, 63));
				textDescripcion.setBounds(135, 20, 90, 20);
				panel_3.add(textDescripcion);

				txtposesin = new JTextField();
				txtposesin.setText("\u00BFPosesi\u00F3n?");
				txtposesin.setOpaque(false);
				txtposesin.setForeground(Color.WHITE);
				txtposesin.setFont(mf.MyFont(0, 13));
				txtposesin.setEditable(false);
				txtposesin.setColumns(10);
				txtposesin.setBorder(null);
				txtposesin.setBackground(new Color(205, 133, 63));
				txtposesin.setBounds(10, 20, 90, 20);
				panel_3.add(txtposesin);

				textField = new JTextField();
				textField.setFont(mf.MyFont(0, 13));
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBackground(Color.WHITE);
				textField.setBounds(10, 51, 115, 20);
				panel_3.add(textField);

				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(ResumenMisc.class
						.getResource("/images/boton atras.png")));
				button.setOpaque(false);
				button.setForeground(Color.WHITE);
				button.setFont(mf.MyFont(0, 15));
				button.setFocusPainted(false);
				button.setContentAreaFilled(false);
				button.setBorderPainted(false);
				button.setBorder(new BevelBorder(BevelBorder.RAISED, null,
						null,

						null, null));
				button.setBackground(new Color(139, 69, 19));
				button.setBounds(10, 206, 99, 45);
				panel_3.add(button);

				if (Equipo.misc4.isPosesion() == true) {
					textField.setText("Posesión");
				}
				if (Equipo.misc4.isPosesion() == false) {
					textField.setText("Normal");
				}
				if (Equipo.misc4.isLegendaria() == true) {
					textField.setText("Legendario");
				}
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(ResumenMisc.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_3.add(label);
			}

		}

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ResumenMisc.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 374, 307);
		frame.getContentPane().add(lblNewLabel);

	}

}
