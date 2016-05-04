package es.thesinsprods.juegozagas.administracion;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.ImageIcon;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Armas;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class RestoreDB {

	private JFrame frmHistoriasDeZagas;
	private JTextField textField;
	private JTextField textField_1;

	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestoreDB window = new RestoreDB();
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
	public RestoreDB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(
				RestoreDB.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 386, 274);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.getContentPane().setLayout(null);

		JLabel lblUbicacinDelArchivo = new JLabel(
				"Ubicaci\u00F3n del Archivo de Copia de Seguridad:");
		lblUbicacinDelArchivo.setForeground(Color.WHITE);
		lblUbicacinDelArchivo.setFont(mf.MyFont(0, 15));
		lblUbicacinDelArchivo.setBounds(10, 31, 360, 26);
		frmHistoriasDeZagas.getContentPane().add(lblUbicacinDelArchivo);

		JLabel lblUbicacinDelArchivo_1 = new JLabel(
				"Ubicaci\u00F3n del Archivo Log:");
		lblUbicacinDelArchivo_1.setFont(mf.MyFont(0, 15));
		lblUbicacinDelArchivo_1.setForeground(Color.WHITE);
		lblUbicacinDelArchivo_1.setBounds(10, 99, 360, 26);
		frmHistoriasDeZagas.getContentPane().add(lblUbicacinDelArchivo_1);

		textField = new JTextField();
		textField.setBounds(10, 68, 279, 20);
		frmHistoriasDeZagas.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 136, 279, 20);
		frmHistoriasDeZagas.getContentPane().add(textField_1);

		final JButton btnNewButton = new JButton("...");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(RestoreDB.class
						.getResource("/images/boton datos2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(RestoreDB.class
						.getResource("/images/boton datos.png")));

			}
		});
		btnNewButton.setIcon(new ImageIcon(RestoreDB.class
				.getResource("/images/boton datos.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				int seleccion = fileChooser.showOpenDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					String backup = fileChooser.getSelectedFile().toString();
					textField.setText(backup);
				}
			}
		});
		btnNewButton.setBounds(299, 66, 63, 23);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton);

		final JButton button = new JButton("...");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button.setIcon(new ImageIcon(RestoreDB.class
						.getResource("/images/boton datos2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				button.setIcon(new ImageIcon(RestoreDB.class
						.getResource("/images/boton datos.png")));

			}
		});
		button.setIcon(new ImageIcon(RestoreDB.class
				.getResource("/images/boton datos.png")));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int seleccion = fileChooser.showSaveDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					String log = fileChooser.getSelectedFile().toString();
					textField_1.setText(log);
				}
			}
		});
		button.setBounds(299, 134, 63, 23);
		frmHistoriasDeZagas.getContentPane().add(button);

		final JButton btnNewButton_1 = new JButton("Restaurar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton_1.setIcon(new ImageIcon(RestoreDB.class
						.getResource("/images/botones panteon2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton_1.setIcon(new ImageIcon(RestoreDB.class
						.getResource("/images/botones panteon.png")));

			}
		});
		btnNewButton_1.setIcon(new ImageIcon(RestoreDB.class
				.getResource("/images/botones panteon.png")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setFont(mf.MyFont(0, 13));
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int seleccion = JOptionPane
							.showOptionDialog(
									null,
									"Para restaurar una copia de seguridad se debe de cerrar el programa. ¿Desea continuar?",
									"¡Atención!", JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Si", "No" }, // null para
																	// YES, NO y
																	// CANCEL
									"opcion 1");
					if (JOptionPane.YES_OPTION == seleccion) {

						Process p = Runtime
								.getRuntime()
								.exec("cmd /C imp ZAGASROOT/putospk2 file="
										+ textField.getText()
										+ " log="
										+ textField_1.getText()
										+ ".log FROMUSER=ZAGASROOT TOUSER=ZAGASROOT");
						System.exit(0);
					}

				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(179, 201, 183, 33);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton_1);

		final JButton btnVolver = new JButton("");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frmHistoriasDeZagas.dispose();
				AdministracionPrinc window = new AdministracionPrinc();
				window.getFrame().setVisible(true);
			}
		});
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(Armas.class
						.getResource("/images/boton atras2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(Armas.class
						.getResource("/images/boton atras.png")));
			}
		});
		btnVolver.setIcon(new ImageIcon(RestoreDB.class
				.getResource("/images/boton atras.png")));
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.setBounds(10, 201, 99, 34);
		frmHistoriasDeZagas.getContentPane().add(btnVolver);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RestoreDB.class
				.getResource("/images/background-crearcuenta.jpg")));
		lblNewLabel.setBounds(0, 0, 380, 246);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
	}
}
