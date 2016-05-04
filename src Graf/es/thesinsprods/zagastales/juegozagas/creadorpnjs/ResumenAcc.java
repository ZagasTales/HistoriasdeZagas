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

public class ResumenAcc {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField textDescripcion;
	private JTextField textField_1;
	private JTextField txtTipoDeAccesorio_3;
	private JTextField txtTipoDeAccesorio_2;
	private JTextField txtTipoDeAccesorio_1;
	private JTextField txtTipoDeAccesorio;
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
					ResumenAcc window = new ResumenAcc();
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
	public ResumenAcc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ResumenAcc.class
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
				tabbedPane.addTab(Equipo.accesories1.getAccesory(), panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(135, 51, 221, 99);
				panel.add(scrollPane);

				JTextArea textArea = new JTextArea();
				textArea.setBackground(Color.WHITE);
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				textArea.setText(Equipo.accesories1.getDescription());
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (Equipo.accesories1.isPosesion() == true) {

					ArrayList<String> pos = Equipo.accesories1.getPossesion()
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

				txtTipoDeAccesorio_3 = new JTextField();
				txtTipoDeAccesorio_3.setText("Tipo de Accesorio:");
				txtTipoDeAccesorio_3.setOpaque(false);
				txtTipoDeAccesorio_3.setForeground(Color.WHITE);
				txtTipoDeAccesorio_3.setFont(mf.MyFont(0, 13));
				txtTipoDeAccesorio_3.setEditable(false);
				txtTipoDeAccesorio_3.setColumns(10);
				txtTipoDeAccesorio_3.setBorder(null);
				txtTipoDeAccesorio_3.setBackground(new Color(205, 133, 63));
				txtTipoDeAccesorio_3.setBounds(10, 20, 115, 20);
				panel.add(txtTipoDeAccesorio_3);

				textField = new JTextField();
				textField.setFont(mf.MyFont(0, 13));
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBackground(Color.WHITE);
				textField.setBounds(10, 51, 115, 20);
				panel.add(textField);
				if (Equipo.accesories1.getClass().getSimpleName()
						.equals("Cloak")) {
					textField.setText("Capa");
				}
				if (Equipo.accesories1.getClass().getSimpleName()
						.equals("Earrings")) {
					textField.setText("Pendientes");
				}
				if (Equipo.accesories1.getClass().getSimpleName()
						.equals("Necklace")) {
					textField.setText("Colgante");
				}
				if (Equipo.accesories1.getClass().getSimpleName()
						.equals("Rings")) {
					textField.setText("Anillos");
				}

				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(ResumenAcc.class
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

				textField_5 = new JTextField();
				textField_5.setText("\u00BFPosesi\u00F3n?");
				textField_5.setOpaque(false);
				textField_5.setForeground(Color.WHITE);
				textField_5.setFont(mf.MyFont(0, 13));
				textField_5.setEditable(false);
				textField_5.setColumns(10);
				textField_5.setBorder(null);
				textField_5.setBackground(new Color(205, 133, 63));
				textField_5.setBounds(10, 82, 90, 20);
				panel.add(textField_5);

				textField_4 = new JTextField();
				textField_4.setFont(mf.MyFont(0, 11));
				textField_4.setEditable(false);
				textField_4.setColumns(10);
				textField_4.setBackground(Color.WHITE);
				textField_4.setBounds(10, 113, 115, 20);
				panel.add(textField_4);
				if (Equipo.accesories1.isPosesion() == true) {
					textField_4.setText("Posesión");
				}
				if (Equipo.accesories1.isPosesion() == false) {
					textField_4.setText("Normal");
				}
				if (Equipo.accesories1.isLegendaria() == true) {
					textField_4.setText("Legendario");
				}
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(ResumenAcc.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel.add(label);
			}

			JPanel panel_1 = new JPanel();
			tabbedPane.addTab(Equipo.accesories2.getAccesory(), null, panel_1,
					null);
			panel_1.setLayout(null);
			{
				{
					panel_1.setLayout(null);

					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(135, 51, 221, 99);
					panel_1.add(scrollPane);

					JTextArea textArea = new JTextArea();
					textArea.setBackground(Color.WHITE);
					textArea.setWrapStyleWord(true);
					textArea.setLineWrap(true);
					textArea.setText(Equipo.accesories2.getDescription());
					textArea.setEditable(false);
					scrollPane.setViewportView(textArea);

					JScrollPane scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(135, 153, 221, 99);
					panel_1.add(scrollPane_1);

					JTextArea textArea_1 = new JTextArea();
					textArea_1.setBackground(Color.WHITE);
					textArea_1.setWrapStyleWord(true);
					textArea_1.setLineWrap(true);
					if (Equipo.accesories2.isPosesion() == true) {

						ArrayList<String> pos = Equipo.accesories2
								.getPossesion().getPos();
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

					txtTipoDeAccesorio_3 = new JTextField();
					txtTipoDeAccesorio_3.setText("Tipo de Accesorio:");
					txtTipoDeAccesorio_3.setOpaque(false);
					txtTipoDeAccesorio_3.setForeground(Color.WHITE);
					txtTipoDeAccesorio_3.setFont(mf.MyFont(0, 13));
					txtTipoDeAccesorio_3.setEditable(false);
					txtTipoDeAccesorio_3.setColumns(10);
					txtTipoDeAccesorio_3.setBorder(null);
					txtTipoDeAccesorio_3.setBackground(new Color(205, 133, 63));
					txtTipoDeAccesorio_3.setBounds(10, 20, 115, 20);
					panel_1.add(txtTipoDeAccesorio_3);

					textField = new JTextField();
					textField.setFont(mf.MyFont(0, 13));
					textField.setEditable(false);
					textField.setColumns(10);
					textField.setBackground(Color.WHITE);
					textField.setBounds(10, 51, 115, 20);
					panel_1.add(textField);
					if (Equipo.accesories2.getClass().getSimpleName()
							.equals("Cloak")) {
						textField.setText("Capa");
					}
					if (Equipo.accesories2.getClass().getSimpleName()
							.equals("Earrings")) {
						textField.setText("Pendientes");
					}
					if (Equipo.accesories2.getClass().getSimpleName()
							.equals("Necklace")) {
						textField.setText("Colgante");
					}
					if (Equipo.accesories2.getClass().getSimpleName()
							.equals("Rings")) {
						textField.setText("Anillos");
					}

					JButton button = new JButton("");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
						}
					});
					button.setIcon(new ImageIcon(ResumenAcc.class
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

					textField_5 = new JTextField();
					textField_5.setText("\u00BFPosesi\u00F3n?");
					textField_5.setOpaque(false);
					textField_5.setForeground(Color.WHITE);
					textField_5.setFont(mf.MyFont(0, 13));
					textField_5.setEditable(false);
					textField_5.setColumns(10);
					textField_5.setBorder(null);
					textField_5.setBackground(new Color(205, 133, 63));
					textField_5.setBounds(10, 82, 90, 20);
					panel_1.add(textField_5);

					textField_4 = new JTextField();
					textField_4.setFont(mf.MyFont(0, 11));
					textField_4.setEditable(false);
					textField_4.setColumns(10);
					textField_4.setBackground(Color.WHITE);
					textField_4.setBounds(10, 113, 115, 20);
					panel_1.add(textField_4);
					if (Equipo.accesories2.isPosesion() == true) {
						textField_4.setText("Posesión");
					}
					if (Equipo.accesories2.isPosesion() == false) {
						textField_4.setText("Normal");
					}
					if (Equipo.accesories2.isLegendaria() == true) {
						textField_4.setText("Legendario");
					}
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon(ResumenAcc.class
							.getResource("/images/background-infos.jpg")));
					label.setBounds(0, 0, 369, 279);
					panel_1.add(label);
				}

			}

			JPanel panel_2 = new JPanel();
			tabbedPane.addTab(Equipo.accesories3.getAccesory(), null, panel_2,
					null);
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
				textArea.setText(Equipo.accesories3.getDescription());
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_2.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (Equipo.accesories3.isPosesion() == true) {

					ArrayList<String> pos = Equipo.accesories3.getPossesion()
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

				txtTipoDeAccesorio_3 = new JTextField();
				txtTipoDeAccesorio_3.setText("Tipo de Accesorio:");
				txtTipoDeAccesorio_3.setOpaque(false);
				txtTipoDeAccesorio_3.setForeground(Color.WHITE);
				txtTipoDeAccesorio_3.setFont(mf.MyFont(0, 13));
				txtTipoDeAccesorio_3.setEditable(false);
				txtTipoDeAccesorio_3.setColumns(10);
				txtTipoDeAccesorio_3.setBorder(null);
				txtTipoDeAccesorio_3.setBackground(new Color(205, 133, 63));
				txtTipoDeAccesorio_3.setBounds(10, 20, 115, 20);
				panel_2.add(txtTipoDeAccesorio_3);

				textField = new JTextField();
				textField.setFont(mf.MyFont(0, 13));
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBackground(Color.WHITE);
				textField.setBounds(10, 51, 115, 20);
				panel_2.add(textField);
				if (Equipo.accesories3.getClass().getSimpleName()
						.equals("Cloak")) {
					textField.setText("Capa");
				}
				if (Equipo.accesories3.getClass().getSimpleName()
						.equals("Earrings")) {
					textField.setText("Pendientes");
				}
				if (Equipo.accesories3.getClass().getSimpleName()
						.equals("Necklace")) {
					textField.setText("Colgante");
				}
				if (Equipo.accesories3.getClass().getSimpleName()
						.equals("Rings")) {
					textField.setText("Anillos");
				}

				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(ResumenAcc.class
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

				textField_5 = new JTextField();
				textField_5.setText("\u00BFPosesi\u00F3n?");
				textField_5.setOpaque(false);
				textField_5.setForeground(Color.WHITE);
				textField_5.setFont(mf.MyFont(0, 13));
				textField_5.setEditable(false);
				textField_5.setColumns(10);
				textField_5.setBorder(null);
				textField_5.setBackground(new Color(205, 133, 63));
				textField_5.setBounds(10, 82, 90, 20);
				panel_2.add(textField_5);

				textField_4 = new JTextField();
				textField_4.setFont(mf.MyFont(0, 11));
				textField_4.setEditable(false);
				textField_4.setColumns(10);
				textField_4.setBackground(Color.WHITE);
				textField_4.setBounds(10, 113, 115, 20);
				panel_2.add(textField_4);
				if (Equipo.accesories3.isPosesion() == true) {
					textField_4.setText("Posesión");
				}
				if (Equipo.accesories3.isPosesion() == false) {
					textField_4.setText("Normal");
				}
				if (Equipo.accesories3.isLegendaria() == true) {
					textField_4.setText("Legendario");
				}
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(ResumenAcc.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_2.add(label);
			}
			JPanel panel_3 = new JPanel();
			tabbedPane.addTab(Equipo.accesories4.getAccesory(), null, panel_3,
					null);
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
				textArea.setText(Equipo.accesories4.getDescription());
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_3.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (Equipo.accesories4.isPosesion() == true) {

					ArrayList<String> pos = Equipo.accesories4.getPossesion()
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

				txtTipoDeAccesorio_3 = new JTextField();
				txtTipoDeAccesorio_3.setText("Tipo de Accesorio:");
				txtTipoDeAccesorio_3.setOpaque(false);
				txtTipoDeAccesorio_3.setForeground(Color.WHITE);
				txtTipoDeAccesorio_3.setFont(mf.MyFont(0, 13));
				txtTipoDeAccesorio_3.setEditable(false);
				txtTipoDeAccesorio_3.setColumns(10);
				txtTipoDeAccesorio_3.setBorder(null);
				txtTipoDeAccesorio_3.setBackground(new Color(205, 133, 63));
				txtTipoDeAccesorio_3.setBounds(10, 20, 115, 20);
				panel_3.add(txtTipoDeAccesorio_3);

				textField = new JTextField();
				textField.setFont(mf.MyFont(0, 13));
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBackground(Color.WHITE);
				textField.setBounds(10, 51, 115, 20);
				panel_3.add(textField);
				if (Equipo.accesories4.getClass().getSimpleName()
						.equals("Cloak")) {
					textField.setText("Capa");
				}
				if (Equipo.accesories4.getClass().getSimpleName()
						.equals("Earrings")) {
					textField.setText("Pendientes");
				}
				if (Equipo.accesories4.getClass().getSimpleName()
						.equals("Necklace")) {
					textField.setText("Colgante");
				}
				if (Equipo.accesories4.getClass().getSimpleName()
						.equals("Rings")) {
					textField.setText("Anillos");
				}

				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(ResumenAcc.class
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

				textField_5 = new JTextField();
				textField_5.setText("\u00BFPosesi\u00F3n?");
				textField_5.setOpaque(false);
				textField_5.setForeground(Color.WHITE);
				textField_5.setFont(mf.MyFont(0, 13));
				textField_5.setEditable(false);
				textField_5.setColumns(10);
				textField_5.setBorder(null);
				textField_5.setBackground(new Color(205, 133, 63));
				textField_5.setBounds(10, 82, 90, 20);
				panel_3.add(textField_5);

				textField_4 = new JTextField();
				textField_4.setFont(mf.MyFont(0, 11));
				textField_4.setEditable(false);
				textField_4.setColumns(10);
				textField_4.setBackground(Color.WHITE);
				textField_4.setBounds(10, 113, 115, 20);
				panel_3.add(textField_4);
				if (Equipo.accesories4.isPosesion() == true) {
					textField_4.setText("Posesión");
				}
				if (Equipo.accesories4.isPosesion() == false) {
					textField_4.setText("Normal");
				}
				if (Equipo.accesories4.isLegendaria() == true) {
					textField_4.setText("Legendario");
				}
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(ResumenAcc.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_3.add(label);
			}

		}

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ResumenAcc.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 374, 307);
		frame.getContentPane().add(lblNewLabel);
	}

}
