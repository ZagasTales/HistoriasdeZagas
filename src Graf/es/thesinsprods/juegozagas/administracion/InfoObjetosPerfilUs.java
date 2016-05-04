package es.thesinsprods.juegozagas.administracion;

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

public class InfoObjetosPerfilUs {

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
					InfoObjetosPerfilUs window = new InfoObjetosPerfilUs();
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
	public InfoObjetosPerfilUs() {
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
				InfoObjetosPerfilUs.class
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
				tabbedPane.addTab(DatosPersonajesUsuario.obj1, panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(135, 51, 221, 99);
				panel.add(scrollPane);

				JTextArea textArea = new JTextArea();
				textArea.setBackground(Color.WHITE);
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				textArea.setText(DatosPersonajesUsuario.descripcionObj1);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (DatosPersonajesUsuario.prop1Obj1 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop1Obj1);
				}
				if (DatosPersonajesUsuario.prop2Obj1 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop2Obj1);
				}
				if (DatosPersonajesUsuario.prop3Obj1 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop3Obj1);
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
				button.setIcon(new ImageIcon(InfoObjetosPerfilUs.class
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
				textField.setText(DatosPersonajesUsuario.posesionObj1);
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(InfoObjetosPerfilUs.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel.add(label);
			}

			JPanel panel_1 = new JPanel();
			tabbedPane.addTab(DatosPersonajesUsuario.obj2, null, panel_1, null);
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
				textArea.setText(DatosPersonajesUsuario.descripcionObj2);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_1.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (DatosPersonajesUsuario.prop1Obj2 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop1Obj2);
				}
				if (DatosPersonajesUsuario.prop2Obj2 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop2Obj2);
				}
				if (DatosPersonajesUsuario.prop3Obj2 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop3Obj2);
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
				button.setIcon(new ImageIcon(InfoObjetosPerfilUs.class
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
				textField.setText(DatosPersonajesUsuario.posesionObj2);
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(InfoObjetosPerfilUs.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_1.add(label);
			}

			JPanel panel_2 = new JPanel();
			tabbedPane.addTab(DatosPersonajesUsuario.obj3, null, panel_2, null);
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
				textArea.setText(DatosPersonajesUsuario.descripcionObj3);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_2.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (DatosPersonajesUsuario.prop1Obj3 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop1Obj3);
				}
				if (DatosPersonajesUsuario.prop2Obj3 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop2Obj3);
				}
				if (DatosPersonajesUsuario.prop3Obj3 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop3Obj3);
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
				button.setIcon(new ImageIcon(InfoObjetosPerfilUs.class
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
				textField.setText(DatosPersonajesUsuario.posesionObj3);
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(InfoObjetosPerfilUs.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_2.add(label);
			}
			JPanel panel_3 = new JPanel();
			tabbedPane.addTab(DatosPersonajesUsuario.obj4, null, panel_3, null);
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
				textArea.setText(DatosPersonajesUsuario.descripcionObj4);
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(135, 153, 221, 99);
				panel_3.add(scrollPane_1);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBackground(Color.WHITE);
				textArea_1.setWrapStyleWord(true);
				textArea_1.setLineWrap(true);
				if (DatosPersonajesUsuario.prop1Obj4 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop1Obj4);
				}
				if (DatosPersonajesUsuario.prop2Obj4 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop2Obj4);
				}
				if (DatosPersonajesUsuario.prop3Obj4 != null) {
					textArea_1.append(DatosPersonajesUsuario.prop3Obj4);
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
				button.setIcon(new ImageIcon(InfoObjetosPerfilUs.class
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
				textField.setText(DatosPersonajesUsuario.posesionObj4);
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(InfoObjetosPerfilUs.class
						.getResource("/images/background-infos.jpg")));
				label.setBounds(0, 0, 369, 279);
				panel_3.add(label);
			}

		}

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(InfoObjetosPerfilUs.class
				.getResource("/images/background-creadornpcs.jpg")));
		lblNewLabel.setBounds(0, 0, 374, 307);
		frame.getContentPane().add(lblNewLabel);
	}

}
