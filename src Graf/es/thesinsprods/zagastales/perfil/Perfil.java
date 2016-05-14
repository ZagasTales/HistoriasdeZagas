package es.thesinsprods.zagastales.perfil;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;

public class Perfil {

	private JFrame frmHistoriasDeZagas;
	private JTextField txtCorreo;

	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}

	final public static JComboBox cmboxPersonajes = new JComboBox();
	public static File fichero;
	public static String nPersonaje = "";
	private JTextField txtApellidos;
	private JTextField txtNombre;
	private JTextField txtNUsuario;
	MorpheusFont mf = new MorpheusFont();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil window = new Perfil();
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
	 * @throws SQLException
	 * @throws IOException 
	 */
	public Perfil() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, SQLException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 */
	private void initialize() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException, IOException {
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Perfil.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 450, 544);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		ConexionDBOnline p = new ConexionDBOnline();
		final Connection con = p.accederDB();
		final Statement tabla = con.createStatement();
		ResultSet datos = tabla
				.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE_DE_USUARIO='"
						+ Loader.usuario + "'");
		String nombre = "";
		String apellidos = "";
		String password = "";
		String correo = "";
		String pregunta = "";
		String respuesta = "";
		ArrayList<String> personajes = new ArrayList<String>();
		personajes.add("-Personaje-");
		personajes.add("-Cargar Personaje-");

		while (datos.next()) {

			nombre = datos.getString("NOMBRE");
			apellidos = datos.getString("APELLIDOS");
			password = datos.getString("CONTRASEÑA");
			correo = datos.getString("EMAIL");
			pregunta = datos.getString("PREGUNTA_DE_SEGURIDAD");
			respuesta = datos.getString("RESPUESTA_PREGUNTA");

		}
		datos = tabla
				.executeQuery("SELECT * FROM PERSONAJE WHERE NOMBRE_DE_USUARIO='"
						+ Loader.usuario + "'");
		while (datos.next()) {
			personajes.add(datos.getString("NOMBRE"));

		}
		JLabel lblNewLabel = new JLabel("Perfil");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(mf.MyFont(1, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 424, 71);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setForeground(Color.WHITE);
		lblNombreDeUsuario.setFont(mf.MyFont(0, 13));
		lblNombreDeUsuario.setBounds(10, 105, 108, 30);
		frmHistoriasDeZagas.getContentPane().add(lblNombreDeUsuario);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(mf.MyFont(0, 13));
		lblNombre.setBounds(10, 146, 108, 30);
		frmHistoriasDeZagas.getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(mf.MyFont(0, 13));
		lblApellidos.setBounds(10, 187, 108, 30);
		frmHistoriasDeZagas.getContentPane().add(lblApellidos);

		JLabel lblDireccinDeCorreo = new JLabel(
				"Direcci\u00F3n de Correo Electr\u00F3nico:");
		lblDireccinDeCorreo.setForeground(Color.WHITE);
		lblDireccinDeCorreo.setBounds(10, 228, 197, 30);
		lblDireccinDeCorreo.setFont(mf.MyFont(0, 13));
		frmHistoriasDeZagas.getContentPane().add(lblDireccinDeCorreo);

		JLabel lblPersonajes = new JLabel("Personajes:");
		lblPersonajes.setForeground(Color.WHITE);
		lblPersonajes.setFont(mf.MyFont(0, 13));
		lblPersonajes.setBounds(10, 269, 167, 30);
		frmHistoriasDeZagas.getContentPane().add(lblPersonajes);

		txtCorreo = new JTextField();
		txtCorreo.setText(correo);
		txtCorreo.setEditable(false);
		txtCorreo.setBounds(205, 233, 229, 20);
		txtCorreo.setFont(mf.MyFont(0, 13));
		frmHistoriasDeZagas.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setText(apellidos);
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(205, 192, 229, 20);
		txtApellidos.setFont(mf.MyFont(0, 13));
		frmHistoriasDeZagas.getContentPane().add(txtApellidos);

		txtNombre = new JTextField();
		txtNombre.setText(nombre);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(205, 151, 229, 20);
		txtNombre.setFont(mf.MyFont(0, 13));
		frmHistoriasDeZagas.getContentPane().add(txtNombre);

		txtNUsuario = new JTextField();
		txtNUsuario.setText(Loader.usuario);
		txtNUsuario.setEditable(false);
		txtNUsuario.setColumns(10);
		txtNUsuario.setBounds(205, 110, 229, 20);
		txtNUsuario.setFont(mf.MyFont(0, 13));
		frmHistoriasDeZagas.getContentPane().add(txtNUsuario);

		final JTextArea txtPregunta = new JTextArea();
		txtPregunta.setText(pregunta);
		txtPregunta.setLineWrap(true);
		txtPregunta.setWrapStyleWord(true);
		txtPregunta.setEditable(false);
		txtPregunta.setBounds(10, 375, 184, 80);
		txtPregunta.setFont(mf.MyFont(0, 13));
		frmHistoriasDeZagas.getContentPane().add(txtPregunta);

		final JTextArea txtRespuesta = new JTextArea();
		txtRespuesta.setText(respuesta);
		txtRespuesta.setLineWrap(true);
		txtRespuesta.setWrapStyleWord(true);
		txtRespuesta.setEditable(false);
		txtRespuesta.setBounds(250, 375, 184, 80);
		txtRespuesta.setFont(mf.MyFont(0, 13));
		frmHistoriasDeZagas.getContentPane().add(txtRespuesta);
		final JButton btnDatos = new JButton("Datos");
		btnDatos.setEnabled(false);
		cmboxPersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmboxPersonajes.getSelectedIndex() == 0) {

					btnDatos.setEnabled(false);

				}

				if (cmboxPersonajes.getSelectedIndex() != 0) {

					btnDatos.setEnabled(true);

				}
				if (cmboxPersonajes.getSelectedIndex() == 1) {

					btnDatos.setText("Cargar");

				}
				if (cmboxPersonajes.getSelectedIndex() != 1) {

					btnDatos.setText("Datos");

				}

			}
		});

		btnDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					if (cmboxPersonajes.getSelectedIndex() == 1) {

						JFileChooser fileChooser = new JFileChooser();
						int seleccion = fileChooser.showOpenDialog(null);
						if (seleccion == JFileChooser.APPROVE_OPTION) {
							fichero = fileChooser.getSelectedFile();
							CargarPersonaje window = new CargarPersonaje();
							window.getFrame().setVisible(true);

						}

					}

					else {
						if (cmboxPersonajes.getSelectedIndex() > 1) {
							nPersonaje = (String) cmboxPersonajes
									.getSelectedItem();
							DatosPersonaje window = new DatosPersonaje();
							window.getFrame().setVisible(true);
						}
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnDatos.setIcon(new ImageIcon(Perfil.class
						.getResource("/images/boton datos2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnDatos.setIcon(new ImageIcon(Perfil.class
						.getResource("/images/boton datos.png")));

			}
		});
		btnDatos.setForeground(Color.WHITE);
		btnDatos.setIcon(new ImageIcon(Perfil.class
				.getResource("/images/boton datos.png")));
		btnDatos.setOpaque(false);
		btnDatos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDatos.setForeground(Color.WHITE);
		btnDatos.setFocusPainted(false);
		btnDatos.setContentAreaFilled(false);
		btnDatos.setBorderPainted(false);
		btnDatos.setFont(mf.MyFont(0, 10));
		btnDatos.setBounds(371, 273, 63, 23);
		frmHistoriasDeZagas.getContentPane().add(btnDatos);

		cmboxPersonajes
				.setModel(new DefaultComboBoxModel(personajes.toArray()));
		cmboxPersonajes.setBounds(205, 274, 160, 20);
		frmHistoriasDeZagas.getContentPane().add(cmboxPersonajes);
		cmboxPersonajes.setFont(mf.MyFont(0, 13));
		final JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnEditar.setIcon(new ImageIcon(Perfil.class
						.getResource("/images/botones-inicio-ayuda2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnEditar.setIcon(new ImageIcon(Perfil.class
						.getResource("/images/botones-inicio-ayuda.png")));

			}
		});

		final JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String correoN = txtCorreo.getText();
				String nombreN = txtNombre.getText();
				String apellidosN = txtApellidos.getText();
				String preguntaN = txtPregunta.getText();
				String respuestaN = txtRespuesta.getText();
				String usuarioN = txtNUsuario.getText();
				int confirmacion = JOptionPane
						.showOptionDialog(
								frmHistoriasDeZagas,
								"¿Deseas guardar los cambios realizados en tu perfil?.",
								"Perfil", JOptionPane.YES_NO_OPTION,
								JOptionPane.PLAIN_MESSAGE, null, new Object[] {
										"Si", "No" }, "opcion 1");

				if (confirmacion == JOptionPane.YES_OPTION) {

					try {
						txtCorreo.setText(correoN);
						txtCorreo.setEditable(false);
						txtNUsuario.setText(usuarioN);
						txtNUsuario.setEditable(false);
						txtNombre.setText(nombreN);
						txtNombre.setEditable(false);
						txtApellidos.setText(apellidosN);
						txtApellidos.setEditable(false);
						txtPregunta.setText(preguntaN);
						txtPregunta.setEditable(false);
						txtRespuesta.setText(respuestaN);
						txtRespuesta.setEditable(false);
						btnFinalizar.setVisible(false);
						btnEditar.setVisible(true);

						tabla.executeQuery("UPDATE USUARIOS SET NOMBRE='"
								+ nombreN + "' WHERE NOMBRE_DE_USUARIO='"
								+ Loader.usuario + "'");
						tabla.executeQuery("UPDATE USUARIOS SET APELLIDOS='"
								+ apellidosN + "' WHERE NOMBRE_DE_USUARIO='"
								+ Loader.usuario + "'");
						
						tabla.executeQuery("UPDATE USUARIOS SET EMAIL='"
								+ correoN + "' WHERE NOMBRE_DE_USUARIO='"
								+ Loader.usuario + "'");
						tabla.executeQuery("UPDATE USUARIOS SET PREGUNTA_DE_SEGURIDAD='"
								+ preguntaN
								+ "' WHERE NOMBRE_DE_USUARIO='"
								+ Loader.usuario + "'");
						tabla.executeQuery("UPDATE USUARIOS SET RESPUESTA_PREGUNTA='"
								+ respuestaN
								+ "' WHERE NOMBRE_DE_USUARIO='"
								+ Loader.usuario + "'");
						tabla.executeQuery("UPDATE USUARIOS SET NOMBRE_DE_USUARIO='"
								+ usuarioN
								+ "' WHERE NOMBRE_DE_USUARIO='"
								+ Loader.usuario + "'");
						tabla.executeQuery("UPDATE PERSONAJE SET NOMBRE_DE_USUARIO='"
								+ usuarioN
								+ "' WHERE NOMBRE_DE_USUARIO='"
								+ Loader.usuario + "'");
						Loader.usuario = usuarioN;

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				if (confirmacion == JOptionPane.NO_OPTION) {
					try {

						String correoS = "";
						String nombreS = "";
						String apellidosS = "";
						String passwordS = "";
						String preguntaS = "";
						String respuestaS = "";

						ResultSet rs = tabla
								.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE_DE_USUARIO='"
										+ Loader.usuario + "'");

						while (rs.next()) {

							correoS = rs.getString("EMAIL");
							nombreS = rs.getString("NOMBRE");
							apellidosS = rs.getString("APELLIDOS");
							passwordS = rs.getString("CONTRASEÑA");
							preguntaS = rs.getString("PREGUNTA_DE_SEGURIDAD");
							respuestaS = rs.getString("RESPUESTA_PREGUNTA");

						}

						txtCorreo.setText(correoS);
						txtCorreo.setEditable(false);
						txtNUsuario.setText(Loader.usuario);
						txtNUsuario.setEditable(false);
						txtNombre.setText(nombreS);
						txtNombre.setEditable(false);
						txtApellidos.setText(apellidosS);
						txtApellidos.setEditable(false);
						txtPregunta.setText(preguntaS);
						txtPregunta.setEditable(false);
						txtRespuesta.setText(respuestaS);
						txtRespuesta.setEditable(false);
						btnFinalizar.setVisible(false);
						btnEditar.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btnFinalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnFinalizar.setIcon(new ImageIcon(Perfil.class
						.getResource("/images/botones-inicio-ayuda2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnFinalizar.setIcon(new ImageIcon(Perfil.class
						.getResource("/images/botones-inicio-ayuda.png")));

			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCorreo.setEditable(true);
				txtNombre.setEditable(true);
				txtNUsuario.setEditable(true);
				txtApellidos.setEditable(true);
				txtPregunta.setEditable(true);
				txtRespuesta.setEditable(true);
				btnEditar.setVisible(false);
				btnFinalizar.setVisible(true);

			}
		});
		final JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnEditar.isVisible()) {

					try {
						frmHistoriasDeZagas.dispose();
						con.close();
						Inicio window = new Inicio();
						window.getFrmHistoriasDeZagas().setVisible(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				else {
					int confirmacion = JOptionPane
							.showOptionDialog(
									frmHistoriasDeZagas,
									"Actualmente te encuentras editando tu perfil, si vuelves atras se perderan todos los cambios no guardados.",
									"Perfil", JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar", "Cancelar" },
									"opcion 1");

					if (confirmacion == JOptionPane.YES_OPTION) {
						try {

							frmHistoriasDeZagas.dispose();
							con.close();
							Inicio window = new Inicio();
							window.getFrmHistoriasDeZagas().setVisible(true);

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}
		});
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAtras.setIcon(new ImageIcon(Perfil.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAtras.setIcon(new ImageIcon(Perfil.class
						.getResource("/images/boton atras.png")));

			}
		});
		btnAtras.setIcon(new ImageIcon(Perfil.class
				.getResource("/images/boton atras.png")));
		btnAtras.setBounds(10, 466, 95, 40);
		btnAtras.setFont(mf.MyFont(0, 13));
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setFocusPainted(false);
		btnAtras.setOpaque(false);
		frmHistoriasDeZagas.getContentPane().add(btnAtras);

		btnEditar.setForeground(Color.WHITE);
		btnEditar.setIcon(new ImageIcon(Perfil.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setBounds(323, 469, 111, 32);
		btnEditar.setFont(mf.MyFont(0, 13));
		btnEditar.setBorderPainted(false);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setFocusPainted(false);
		btnEditar.setOpaque(false);
		frmHistoriasDeZagas.getContentPane().add(btnEditar);

		btnFinalizar.setVisible(false);
		btnFinalizar.setIcon(new ImageIcon(Perfil.class
				.getResource("/images/botones-inicio-ayuda.png")));
		btnFinalizar.setOpaque(false);
		btnFinalizar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setFocusPainted(false);
		btnFinalizar.setContentAreaFilled(false);
		btnFinalizar.setBorderPainted(false);
		btnFinalizar.setBounds(323, 469, 111, 32);
		btnFinalizar.setFont(mf.MyFont(0, 13));
		frmHistoriasDeZagas.getContentPane().add(btnFinalizar);

		JLabel lblPreguntaDeSeguridad = new JLabel("Pregunta de Seguridad:");
		lblPreguntaDeSeguridad.setForeground(Color.WHITE);
		lblPreguntaDeSeguridad.setFont(mf.MyFont(0, 13));
		lblPreguntaDeSeguridad.setBounds(10, 346, 167, 30);
		frmHistoriasDeZagas.getContentPane().add(lblPreguntaDeSeguridad);

		JLabel lblRespuestaDeSeguridad = new JLabel("Respuesta de Seguridad:");
		lblRespuestaDeSeguridad.setToolTipText("");
		lblRespuestaDeSeguridad.setForeground(Color.WHITE);
		lblRespuestaDeSeguridad.setFont(mf.MyFont(0, 13));
		lblRespuestaDeSeguridad.setBounds(250, 346, 167, 30);
		frmHistoriasDeZagas.getContentPane().add(lblRespuestaDeSeguridad);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Perfil.class
				.getResource("/images/background-perfil.jpg")));
		lblNewLabel_1.setBounds(0, 0, 444, 516);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel_1);

	}
}
