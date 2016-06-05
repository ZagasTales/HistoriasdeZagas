package es.thesinsprods.zagastales.juegozagas.inicio;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import es.thesinsprods.resources.crypter.StringMD;
import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.font.MorpheusFont;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class CrearCuenta {

	private JFrame frmHistoriasDeZagas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;

	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}

	private JLabel lblNewLabel_1;
	private JButton btnCancelar;
	MorpheusFont mf = new MorpheusFont();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	ConexionDBOnline p = new ConexionDBOnline();
	private JLabel lblPreguntaDeSeguridad;
	private JTextArea textArea;
	private JLabel lblRespuestaDeLa;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCuenta window = new CrearCuenta();
					window.frmHistoriasDeZagas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws IOException 
	 */
	public CrearCuenta() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws IOException 
	 */
	private void initialize() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(
				CrearCuenta.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setBounds(100, 100, 560, 400);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		final Connection con = p.accederDB();
		JLabel lblNewLabel = new JLabel("Creaci\u00F3n de Cuenta");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(mf.MyFont(0, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 542, 52);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(mf.MyFont(0, 11));
		lblNombre.setBounds(20, 90, 50, 19);
		frmHistoriasDeZagas.getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(mf.MyFont(0, 11));
		lblApellidos.setBounds(270, 90, 50, 19);
		frmHistoriasDeZagas.getContentPane().add(lblApellidos);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setForeground(Color.WHITE);
		lblNombreDeUsuario.setFont(mf.MyFont(0, 11));
		lblNombreDeUsuario.setBounds(20, 140, 109, 19);
		frmHistoriasDeZagas.getContentPane().add(lblNombreDeUsuario);

		JLabel lblDireccinDeCorreo = new JLabel(
				"Direcci\u00F3n de Correo Electr\u00F3nico:");
		lblDireccinDeCorreo.setForeground(Color.WHITE);
		lblDireccinDeCorreo.setFont(mf.MyFont(0, 11));
		lblDireccinDeCorreo.setBounds(270, 140, 162, 19);
		frmHistoriasDeZagas.getContentPane().add(lblDireccinDeCorreo);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(20, 190, 109, 19);
		lblContrasea.setFont(mf.MyFont(0, 11));
		frmHistoriasDeZagas.getContentPane().add(lblContrasea);

		JLabel lblConfirmacinDeContrasea = new JLabel(
				"Confirmaci\u00F3n de Contrase\u00F1a:");
		lblConfirmacinDeContrasea.setForeground(Color.WHITE);
		lblConfirmacinDeContrasea.setBounds(270, 190, 162, 19);
		lblConfirmacinDeContrasea.setFont(mf.MyFont(0, 11));
		frmHistoriasDeZagas.getContentPane().add(lblConfirmacinDeContrasea);

		textField = new JTextField();
		textField.setBounds(139, 90, 111, 20);
		textField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		frmHistoriasDeZagas.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 140, 111, 20);
		textField_1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		frmHistoriasDeZagas.getContentPane().add(textField_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(430, 90, 111, 20);
		textField_3.setFont(new Font("Monospaced", Font.PLAIN, 12));
		frmHistoriasDeZagas.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(430, 140, 111, 20);
		textField_4.setFont(new Font("Monospaced", Font.PLAIN, 12));
		frmHistoriasDeZagas.getContentPane().add(textField_4);

		btnNewButton = new JButton("Crear Cuenta");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(CrearCuenta.class
						.getResource("/images/boton confirmar cuenta2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(CrearCuenta.class
						.getResource("/images/boton confirmar cuenta.png")));

			}
		});
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(CrearCuenta.class
				.getResource("/images/boton confirmar cuenta.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				String usuario = textField_1.getText();
				String apellidos = textField_3.getText();
				String contraseña = StringMD.getStringMessageDigest(passwordField.getText(), StringMD.MD5);
				String correo = textField_4.getText();
				String pregunta = textArea.getText();
				String respuesta = textArea_1.getText();
				if (nombre.length() != 0 && usuario.length() != 0
						&& apellidos.length() != 0 && contraseña.length() != 0
						&& correo.length() != 0 && pregunta.length() != 0
						&& respuesta.length() != 0) {
					if (contraseña.equals(StringMD.getStringMessageDigest(passwordField_1.getText(), StringMD.MD5))) {

						try {
							String usuarioComp = "";
							Statement tabla = con.createStatement();
							ResultSet rs = tabla
									.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE_DE_USUARIO='"
											+ usuario + "'");
							while (rs.next()) {
								usuarioComp = rs.getString("NOMBRE_DE_USUARIO");
							}

							if (usuarioComp.equals(usuario)) {
								int seleccion = JOptionPane
										.showOptionDialog(
												frmHistoriasDeZagas,
												"El nombre de usuario: "
														+ usuario
														+ " ya se encuentra registrado.",
												"¡Error!",
												JOptionPane.OK_OPTION,
												JOptionPane.PLAIN_MESSAGE,
												null,
												new Object[] { "Aceptar" },
												"opcion 1");

							} else {
								String correoComp = "";
								rs = tabla
										.executeQuery("SELECT * FROM USUARIOS WHERE EMAIL='"
												+ correo + "'");
								while (rs.next()) {
									correoComp = rs.getString("E-MAIL");
								}

								if (correoComp.equals(correo)) {
									int seleccion = JOptionPane
											.showOptionDialog(
													frmHistoriasDeZagas,
													"La dirección de correo: "
															+ correo
															+ " ya se encuentra registrada.",
													"¡Error!",
													JOptionPane.OK_OPTION,
													JOptionPane.PLAIN_MESSAGE,
													null,
													new Object[] { "Aceptar" },
													"opcion 1");

								} else {
									int seleccion = JOptionPane
											.showOptionDialog(
													frmHistoriasDeZagas,
													"¿Estás seguro de querer crear una cuenta con esos datos?",
													"Crear Cuenta",
													JOptionPane.YES_NO_OPTION,
													JOptionPane.WARNING_MESSAGE,
													null, new Object[] { "Si",
															"No" }, "opcion 1");
									if (JOptionPane.YES_OPTION == seleccion) {
										tabla.executeQuery("INSERT INTO USUARIOS VALUES('"
												+ usuario
												+ "','"
												+ nombre
												+ "','"
												+ apellidos
												+ "','"
												+ contraseña
												+ "','"
												+ correo
												+ "','"
												+ pregunta
												+ "','"
												+ respuesta + "',0)");

										int confirmacion = JOptionPane
												.showOptionDialog(
														frmHistoriasDeZagas,
														"Cuenta creada con éxito.",
														"Crear Cuenta",
														JOptionPane.OK_OPTION,
														JOptionPane.PLAIN_MESSAGE,
														null,
														new Object[] { "Aceptar" },
														"opcion 1");

										if (JOptionPane.OK_OPTION == confirmacion) {
											frmHistoriasDeZagas.dispose();
											Loader window;
											try {
												window = new Loader();
												window.getFrmHistoriasDeZagas()
														.setVisible(true);
												con.close();
											} catch (ClassNotFoundException e1) {

												e1.printStackTrace();
											} catch (InstantiationException e1) {

												e1.printStackTrace();
											} catch (IllegalAccessException e1) {

												e1.printStackTrace();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
									}
								}

							}

						} catch (SQLException e1) {

							e1.printStackTrace();
						}

					} else {

						int seleccion = JOptionPane
								.showOptionDialog(
										frmHistoriasDeZagas,
										"La Contraseña no coincide con la Confirmación.",
										"¡Error!", JOptionPane.OK_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, "opcion 1");

					}
				} else {
					int seleccion = JOptionPane
							.showOptionDialog(
									frmHistoriasDeZagas,
									"Debes rellenar todos los campos antes de poder crear una cuenta.",
									"¡Faltan Datos!", JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");

				}
			}
		});
		btnNewButton.setBounds(122, 331, 150, 30);
		btnNewButton.setFont(mf.MyFont(0, 13));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHistoriasDeZagas.dispose();
				Loader window;
				try {
					window = new Loader();
					window.getFrmHistoriasDeZagas().setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCancelar.setIcon(new ImageIcon(CrearCuenta.class
						.getResource("/images/boton confirmar cuenta2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnCancelar.setIcon(new ImageIcon(CrearCuenta.class
						.getResource("/images/boton confirmar cuenta.png")));

			}
		});
		btnCancelar.setIcon(new ImageIcon(CrearCuenta.class
				.getResource("/images/boton confirmar cuenta.png")));
		btnCancelar.setOpaque(false);
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBounds(282, 331, 150, 30);
		btnCancelar.setFont(mf.MyFont(0, 13));
		frmHistoriasDeZagas.getContentPane().add(btnCancelar);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		passwordField.setBounds(139, 190, 111, 20);
		frmHistoriasDeZagas.getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		passwordField_1.setBounds(430, 190, 111, 20);
		frmHistoriasDeZagas.getContentPane().add(passwordField_1);

		lblPreguntaDeSeguridad = new JLabel("Pregunta de Seguridad:");
		lblPreguntaDeSeguridad.setForeground(Color.WHITE);
		lblPreguntaDeSeguridad.setFont(new Font("Morpheus", Font.PLAIN, 11));
		lblPreguntaDeSeguridad.setBounds(20, 240, 162, 19);
		frmHistoriasDeZagas.getContentPane().add(lblPreguntaDeSeguridad);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(20, 270, 230, 52);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		frmHistoriasDeZagas.getContentPane().add(textArea);

		lblRespuestaDeLa = new JLabel("Respuesta de la Pregunta de Seguridad:");
		lblRespuestaDeLa.setForeground(Color.WHITE);
		lblRespuestaDeLa.setFont(new Font("Morpheus", Font.PLAIN, 11));
		lblRespuestaDeLa.setBounds(270, 240, 197, 19);
		frmHistoriasDeZagas.getContentPane().add(lblRespuestaDeLa);

		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setBounds(270, 270, 230, 52);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		frmHistoriasDeZagas.getContentPane().add(textArea_1);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CrearCuenta.class
				.getResource("/images/background-crearcuenta.jpg")));
		lblNewLabel_1.setBounds(0, 0, 552, 372);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel_1);
	}
}
