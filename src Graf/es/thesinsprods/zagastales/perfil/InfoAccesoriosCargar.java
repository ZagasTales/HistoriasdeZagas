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

public class InfoAccesoriosCargar {

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
					InfoAccesoriosCargar window = new InfoAccesoriosCargar();
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
	public InfoAccesoriosCargar() {
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
				InfoAccesoriosCargar.class
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
				tabbedPane.addTab(CargarPersonaje.acc1, panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(135, 51, 221, 99);
				panel.add(scrollPane);

				JTextArea textArea = new JTextArea();
				textArea.setBackground(Color.WHITE);
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				textArea.setText(CargarPersonaje.descripcionAcc1);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (CargarPersonaje.prop1Acc1 != null) {
					textArea_1.append(CargarPersonaje.prop1Acc1);
				}
				if (CargarPersonaje.prop2Acc1 != null) {
					textArea_1.append(CargarPersonaje.prop2Acc1);
				}
				if (CargarPersonaje.prop3Acc1 != null) {
					textArea_1.append(CargarPersonaje.prop3Acc1);
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
				if (CargarPersonaje.tipoAcc1 != null) {
					if (CargarPersonaje.tipoAcc1.equals("Cloak")) {
						textField.setText("Capa");
					}
					if (CargarPersonaje.tipoAcc1.equals("Earrings")) {
						textField.setText("Pendientes");
					}
					if (CargarPersonaje.tipoAcc1.equals("Necklace")) {
						textField.setText("Colgante");
					}
					if (CargarPersonaje.tipoAcc1.equals("Rings")) {
						textField.setText("Anillos");
					}
				}
				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(InfoAccesoriosCargar.class
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
				textField_4.setText(CargarPersonaje.posesionAcc1);
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(InfoAccesoriosCargar.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel.add(label);
			}

			JPanel panel_1 = new JPanel();
			tabbedPane.addTab(CargarPersonaje.acc2, null, panel_1, null);
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
					textArea.setText(CargarPersonaje.descripcionAcc2);
					textArea.setEditable(false);
					scrollPane.setViewportView(textArea);

					JScrollPane scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(135, 153, 221, 99);
					panel_1.add(scrollPane_1);

					JTextArea textArea_1 = new JTextArea();
					textArea_1.setBackground(Color.WHITE);
					textArea_1.setWrapStyleWord(true);
					textArea_1.setLineWrap(true);
					if (CargarPersonaje.prop1Acc2 != null) {
						textArea_1.append(CargarPersonaje.prop1Acc2);
					}
					if (CargarPersonaje.prop2Acc2 != null) {
						textArea_1.append(CargarPersonaje.prop2Acc2);
					}
					if (CargarPersonaje.prop3Acc2 != null) {
						textArea_1.append(CargarPersonaje.prop3Acc2);
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
					if (CargarPersonaje.tipoAcc2 != null) {
						if (CargarPersonaje.tipoAcc2.equals("Cloak")) {
							textField.setText("Capa");
						}
						if (CargarPersonaje.tipoAcc2.equals("Earrings")) {
							textField.setText("Pendientes");
						}
						if (CargarPersonaje.tipoAcc2.equals("Necklace")) {
							textField.setText("Colgante");
						}
						if (CargarPersonaje.tipoAcc2.equals("Rings")) {
							textField.setText("Anillos");
						}
					}
					JButton button = new JButton("");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
						}
					});
					button.setIcon(new ImageIcon(InfoAccesoriosCargar.class
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
					textField_4.setText(CargarPersonaje.posesionAcc2);
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon(InfoAccesoriosCargar.class
							.getResource("/images/background-infos.jpg")));
					label.setBounds(0, 0, 369, 279);
					panel_1.add(label);
				}

			}

			JPanel panel_2 = new JPanel();
			tabbedPane.addTab(CargarPersonaje.acc3, null, panel_2, null);
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
				textArea.setText(CargarPersonaje.descripcionAcc3);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_2.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (CargarPersonaje.prop1Acc3 != null) {
					textArea_1.append(CargarPersonaje.prop1Acc3);
				}
				if (CargarPersonaje.prop2Acc3 != null) {
					textArea_1.append(CargarPersonaje.prop2Acc3);
				}
				if (CargarPersonaje.prop3Acc3 != null) {
					textArea_1.append(CargarPersonaje.prop3Acc3);
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
				if (CargarPersonaje.tipoAcc3 != null) {
					if (CargarPersonaje.tipoAcc3.equals("Cloak")) {
						textField.setText("Capa");
					}
					if (CargarPersonaje.tipoAcc3.equals("Earrings")) {
						textField.setText("Pendientes");
					}
					if (CargarPersonaje.tipoAcc3.equals("Necklace")) {
						textField.setText("Colgante");
					}
					if (CargarPersonaje.tipoAcc3.equals("Rings")) {
						textField.setText("Anillos");
					}
				}
				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(InfoAccesoriosCargar.class
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
				textField_4.setText(CargarPersonaje.posesionAcc3);
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(InfoAccesoriosCargar.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_2.add(label);
			}
			JPanel panel_3 = new JPanel();
			tabbedPane.addTab(CargarPersonaje.acc4, null, panel_3, null);
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
				textArea.setText(CargarPersonaje.descripcionAcc4);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_3.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (CargarPersonaje.prop1Acc4 != null) {
					textArea_1.append(CargarPersonaje.prop1Acc4);
				}
				if (CargarPersonaje.prop2Acc4 != null) {
					textArea_1.append(CargarPersonaje.prop2Acc4);
				}
				if (CargarPersonaje.prop3Acc4 != null) {
					textArea_1.append(CargarPersonaje.prop3Acc4);
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
				if (CargarPersonaje.tipoAcc4 != null) {
					if (CargarPersonaje.tipoAcc4.equals("Cloak")) {
						textField.setText("Capa");
					}
					if (CargarPersonaje.tipoAcc4.equals("Earrings")) {
						textField.setText("Pendientes");
					}
					if (CargarPersonaje.tipoAcc4.equals("Necklace")) {
						textField.setText("Colgante");
					}
					if (CargarPersonaje.tipoAcc4.equals("Rings")) {
						textField.setText("Anillos");
					}
				}
				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				button.setIcon(new ImageIcon(InfoAccesoriosCargar.class
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
				textField_4.setText(CargarPersonaje.posesionAcc4);
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(InfoAccesoriosCargar.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_3.add(label);
			}

		}

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(InfoAccesoriosCargar.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 374, 307);
		frame.getContentPane().add(lblNewLabel);
	}

}
