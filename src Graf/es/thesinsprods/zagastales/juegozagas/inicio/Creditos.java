package es.thesinsprods.zagastales.juegozagas.inicio;

import java.awt.EventQueue;

import javax.swing.JFrame;

import es.thesinsprods.resources.font.MorpheusFont;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Creditos {

	private JFrame frmHistoriasDeZagas;

	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	MorpheusFont mf = new MorpheusFont();
	private JTextField txtTheSinsProds;
	private JTextField txtZagastales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creditos window = new Creditos();
					window.frmHistoriasDeZagas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Creditos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.getContentPane().setBackground(
				new Color(205, 133, 63));
		frmHistoriasDeZagas.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(57, 33, 16));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		panel_1.setBounds(0, 0, 434, 15);
		frmHistoriasDeZagas.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(57, 33, 16));
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		panel_2.setBounds(0, 577, 434, 15);
		frmHistoriasDeZagas.getContentPane().add(panel_2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 33, 16));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		panel.setBounds(210, 11, 15, 571);
		frmHistoriasDeZagas.getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 56, 210, 526);
		frmHistoriasDeZagas.getContentPane().add(scrollPane);
		String credTheSinsProds = " Director de Proyecto:\n Borja Gay Flores\n\n Programadores:\n -Codigo:\n Borja Gay Flores\n Marc del Valle Martinez\n Pablo Fernandez Moreno\n -Interfaz Gráfico:\n Borja Gay Flores\n\n Diseño:\n Borja Gay Flores\n Marc del Valle Martinez\n Pablo Fernández Moreno\n\n Testers:\n Borja Gay Flores\n Pablo Fernández Moreno\n Mara Leorza Carballo\n\n ©The Sins Prods. Todos los derechos  reservados.\n";
		String credZagasTales = " Desarrollo:\n\n Normas:\n Borja Gay Flores\n Eduardo Ibáñez Lera\n Mara Leorza Carballo\n Pablo Fernandez Moreno\n\n Historia:\n Borja Gay Flores\n Eduardo Ibáñez Lera\n Mara Leorza Carballo\n Pablo Fernandez Moreno\n\n Diseño:\n Borja Gay Flores\n Eduardo Ibáñez Lera\n Mara Leorza Carballo\n\n ©ZagasTales. Todos los derechos \n reservados.\n";
		JTextArea textArea = new JTextArea();
		textArea.setFont(mf.MyFont(0, 13));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBackground(new Color(211, 211, 211));
		scrollPane.setViewportView(textArea);
		textArea.setText(credTheSinsProds);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(224, 56, 210, 526);
		frmHistoriasDeZagas.getContentPane().add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(mf.MyFont(0, 13));
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setText(credZagasTales);
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(211, 211, 211));
		scrollPane_1.setViewportView(textArea_1);

		txtTheSinsProds = new JTextField();
		txtTheSinsProds.setForeground(Color.WHITE);
		txtTheSinsProds.setOpaque(false);
		txtTheSinsProds.setDisabledTextColor(new Color(0, 0, 0));
		txtTheSinsProds.setEditable(false);
		txtTheSinsProds.setHorizontalAlignment(SwingConstants.CENTER);
		txtTheSinsProds.setFont(mf.MyFont(0, 14));
		txtTheSinsProds.setText("The Sins Prods");
		txtTheSinsProds.setBackground(new Color(205, 133, 63));
		txtTheSinsProds.setBorder(null);
		txtTheSinsProds.setBounds(0, 21, 210, 34);
		frmHistoriasDeZagas.getContentPane().add(txtTheSinsProds);
		txtTheSinsProds.setColumns(10);

		txtZagastales = new JTextField();
		txtZagastales.setForeground(Color.WHITE);
		txtZagastales.setOpaque(false);
		txtZagastales.setDisabledTextColor(new Color(0, 0, 0));
		txtZagastales.setEditable(false);
		txtZagastales.setText("ZagasTales");
		txtZagastales.setHorizontalAlignment(SwingConstants.CENTER);
		txtZagastales.setFont(mf.MyFont(0, 14));
		txtZagastales.setBackground(new Color(205, 133, 63));
		txtZagastales.setBorder(null);
		txtZagastales.setColumns(10);
		txtZagastales.setBounds(224, 21, 210, 34);
		frmHistoriasDeZagas.getContentPane().add(txtZagastales);
		
		final JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHistoriasDeZagas.dispose();
				Inicio window= new Inicio();
				window.getFrmHistoriasDeZagas().setVisible(true);
			}
		});
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(Creditos.class.getResource("/images/botonesInicio2.png")));
			}
			public void mouseReleased(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(Creditos.class.getResource("/images/botonesInicio.png")));
			}
		});
		btnVolver.setIcon(new ImageIcon(Creditos.class.getResource("/images/botonesInicio.png")));
		btnVolver.setOpaque(false);
		btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(mf.MyFont(0, 17));
		btnVolver.setFocusPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
						null));
		btnVolver.setBackground(new Color(139, 69, 19));
		btnVolver.setBounds(7, 603, 414, 34);
		frmHistoriasDeZagas.getContentPane().add(btnVolver);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Creditos.class.getResource("/images/background-creditos.jpg")));
		label.setBounds(0, 11, 434, 634);
		frmHistoriasDeZagas.getContentPane().add(label);
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Creditos.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setBounds(100, 100, 434, 674);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
