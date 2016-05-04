package es.thesinsprods.zagastales.perfil;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class InfoAccesoriosPerfil {

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
					InfoAccesoriosPerfil window = new InfoAccesoriosPerfil();
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
	public InfoAccesoriosPerfil() {
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
				InfoAccesoriosPerfil.class
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
				tabbedPane.addTab(DatosPersonaje.acc1, panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(135, 51, 221, 99);
				panel.add(scrollPane);

				JTextArea textArea = new JTextArea();
				textArea.setBackground(Color.WHITE);
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				textArea.setText(DatosPersonaje.descripcionAcc1);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (DatosPersonaje.prop1Acc1 != null) {
					textArea_1.append(DatosPersonaje.prop1Acc1);
				}
				if (DatosPersonaje.prop2Acc1 != null) {
					textArea_1.append(DatosPersonaje.prop2Acc1);
				}
				if (DatosPersonaje.prop3Acc1 != null) {
					textArea_1.append(DatosPersonaje.prop3Acc1);
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
				if (DatosPersonaje.tipoAcc1 != null) {
					if (DatosPersonaje.tipoAcc1.equals("Cloak")) {
						textField.setText("Capa");
					}
					if (DatosPersonaje.tipoAcc1.equals("Earrings")) {
						textField.setText("Pendientes");
					}
					if (DatosPersonaje.tipoAcc1.equals("Necklace")) {
						textField.setText("Colgante");
					}
					if (DatosPersonaje.tipoAcc1.equals("Rings")) {
						textField.setText("Anillos");
					}
				}
				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(InfoAccesoriosPerfil.class
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
				textField_4.setText(DatosPersonaje.posesionAcc1);
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(InfoAccesoriosPerfil.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel.add(label);
			}

			JPanel panel_1 = new JPanel();
			tabbedPane.addTab(DatosPersonaje.acc2, null, panel_1, null);
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
					textArea.setText(DatosPersonaje.descripcionAcc2);
					textArea.setEditable(false);
					scrollPane.setViewportView(textArea);

					JScrollPane scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(135, 153, 221, 99);
					panel_1.add(scrollPane_1);

					JTextArea textArea_1 = new JTextArea();
					textArea_1.setBackground(Color.WHITE);
					textArea_1.setWrapStyleWord(true);
					textArea_1.setLineWrap(true);
					if (DatosPersonaje.prop1Acc2 != null) {
						textArea_1.append(DatosPersonaje.prop1Acc2);
					}
					if (DatosPersonaje.prop2Acc2 != null) {
						textArea_1.append(DatosPersonaje.prop2Acc2);
					}
					if (DatosPersonaje.prop3Acc2 != null) {
						textArea_1.append(DatosPersonaje.prop3Acc2);
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
					if (DatosPersonaje.tipoAcc2 != null) {
						if (DatosPersonaje.tipoAcc2.equals("Cloak")) {
							textField.setText("Capa");
						}
						if (DatosPersonaje.tipoAcc2.equals("Earrings")) {
							textField.setText("Pendientes");
						}
						if (DatosPersonaje.tipoAcc2.equals("Necklace")) {
							textField.setText("Colgante");
						}
						if (DatosPersonaje.tipoAcc2.equals("Rings")) {
							textField.setText("Anillos");
						}
					}
					JButton button = new JButton("");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
						}
					});
					button.setIcon(new ImageIcon(InfoAccesoriosPerfil.class
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
					textField_4.setText(DatosPersonaje.posesionAcc2);
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon(InfoAccesoriosPerfil.class
							.getResource("/images/background-infos.jpg")));
					label.setBounds(0, 0, 369, 279);
					panel_1.add(label);
				}

			}

			JPanel panel_2 = new JPanel();
			tabbedPane.addTab(DatosPersonaje.acc3, null, panel_2, null);
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
				textArea.setText(DatosPersonaje.descripcionAcc3);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_2.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (DatosPersonaje.prop1Acc3 != null) {
					textArea_1.append(DatosPersonaje.prop1Acc3);
				}
				if (DatosPersonaje.prop2Acc3 != null) {
					textArea_1.append(DatosPersonaje.prop2Acc3);
				}
				if (DatosPersonaje.prop3Acc3 != null) {
					textArea_1.append(DatosPersonaje.prop3Acc3);
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
				if (DatosPersonaje.tipoAcc3 != null) {
					if (DatosPersonaje.tipoAcc3.equals("Cloak")) {
						textField.setText("Capa");
					}
					if (DatosPersonaje.tipoAcc3.equals("Earrings")) {
						textField.setText("Pendientes");
					}
					if (DatosPersonaje.tipoAcc3.equals("Necklace")) {
						textField.setText("Colgante");
					}
					if (DatosPersonaje.tipoAcc3.equals("Rings")) {
						textField.setText("Anillos");
					}
				}
				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(InfoAccesoriosPerfil.class
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
				textField_4.setText(DatosPersonaje.posesionAcc3);
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(InfoAccesoriosPerfil.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_2.add(label);
			}
			JPanel panel_3 = new JPanel();
			tabbedPane.addTab(DatosPersonaje.acc4, null, panel_3, null);
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
				textArea.setText(DatosPersonaje.descripcionAcc4);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_3.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (DatosPersonaje.prop1Acc4 != null) {
					textArea_1.append(DatosPersonaje.prop1Acc4);
				}
				if (DatosPersonaje.prop2Acc4 != null) {
					textArea_1.append(DatosPersonaje.prop2Acc4);
				}
				if (DatosPersonaje.prop3Acc4 != null) {
					textArea_1.append(DatosPersonaje.prop3Acc4);
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
				if (DatosPersonaje.tipoAcc4 != null) {
					if (DatosPersonaje.tipoAcc4.equals("Cloak")) {
						textField.setText("Capa");
					}
					if (DatosPersonaje.tipoAcc4.equals("Earrings")) {
						textField.setText("Pendientes");
					}
					if (DatosPersonaje.tipoAcc4.equals("Necklace")) {
						textField.setText("Colgante");
					}
					if (DatosPersonaje.tipoAcc4.equals("Rings")) {
						textField.setText("Anillos");
					}
				}
				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(InfoAccesoriosPerfil.class
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
				textField_4.setText(DatosPersonaje.posesionAcc4);
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(InfoAccesoriosPerfil.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_3.add(label);
			}

		}

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(InfoAccesoriosPerfil.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 374, 307);
		frame.getContentPane().add(lblNewLabel);
	}

}
