package es.thesinsprods.zagastales.juegozagas.inicio;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.Color;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.creadorpnjs.Armas;
import es.thesinsprods.zagastales.perfil.Perfil;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;











import java.sql.Statement;

import es.thesinsprods.resources.crypter.StringMD;
import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.db.ConexionEmbeddedDB;
import es.thesinsprods.resources.font.MorpheusFont;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Loader {

	private JFrame frmHistoriasDeZagas;

	public JFrame getFrmHistoriasDeZagas() {
		return frmHistoriasDeZagas;
	}

	public void setFrmHistoriasDeZagas(JFrame frmHistoriasDeZagas) {
		this.frmHistoriasDeZagas = frmHistoriasDeZagas;
	}
	public static String crear = "";
	MorpheusFont mf = new MorpheusFont();
	private JTextField textField;
	private JPasswordField passwordField;
	public static String usuario = "";
	private String password;
	public static int admin=0;
	public static Statement tabla;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loader window = new Loader();
					window.frmHistoriasDeZagas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @wbp.parser.entryPoint
	 */
	public Loader() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		UIManager UI = new UIManager();
		UIDefaults defaults = new UIDefaults();
		UI.put("OptionPane.background", new Color(81, 40, 9));
		UI.put("Panel.background", new Color(81, 40, 9));
		UI.put("OptionPane.messageForeground", Color.WHITE);
		UI.put("OptionPane.messageFont", mf.MyFont(0, 13));
		UI.put("Button.background", new Color(39, 25, 22));
		UI.put("Button.font", mf.MyFont(0, 11));
		UI.put("Button.foreground", Color.WHITE);
		UI.put("Label.foreground", Color.WHITE);
		Connection conOff;
		ConexionEmbeddedDB pOff=new ConexionEmbeddedDB();
		conOff=pOff.accederDB();
		tabla=conOff.createStatement();
		final ConexionDBOnline con = new ConexionDBOnline();
		final Connection p = con.accederDB();
		if(con.accederDB()!=null){
			final java.sql.Statement tabla;
			
			String versionDB="";
			
			ResultSet buscaV;
			tabla = p.createStatement();
			buscaV= tabla
					
				
					.executeQuery("SELECT * FROM VERSION");
			while(buscaV.next()){
				
				versionDB=buscaV.getString("NUMERO");
			}
			
			

			File vers=new File("./version/version");
			FileReader fr = new FileReader(vers);
			BufferedReader br = new BufferedReader(fr);
			String version=br.readLine();
			
			frmHistoriasDeZagas = new JFrame();
			frmHistoriasDeZagas.setTitle("Historias de Zagas");
			frmHistoriasDeZagas.setBackground(Color.WHITE);
			frmHistoriasDeZagas
					.setIconImage(Toolkit
							.getDefaultToolkit()
							.getImage(
									Armas.class
											.getResource("/images/Historias de Zagas, logo.png")));
			frmHistoriasDeZagas.setBounds(100, 100, 439, 462);
			frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmHistoriasDeZagas.setLocationRelativeTo(null);
			frmHistoriasDeZagas.setResizable(false);
			frmHistoriasDeZagas.getContentPane().setLayout(null);
			
			JLabel lblInicioDeSesin = new JLabel("Inicio de Sesi\u00F3n:");
			lblInicioDeSesin.setHorizontalAlignment(SwingConstants.LEFT);
			lblInicioDeSesin.setForeground(Color.WHITE);
			lblInicioDeSesin.setFont(mf.MyFont(0, 18));
			lblInicioDeSesin.setBounds(10, 241, 272, 23);
			frmHistoriasDeZagas.getContentPane().add(lblInicioDeSesin);
			
			JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
			lblNombreDeUsuario.setForeground(Color.WHITE);
			lblNombreDeUsuario.setFont(mf.MyFont(0, 11));
			lblNombreDeUsuario.setBounds(10, 275, 102, 14);
			frmHistoriasDeZagas.getContentPane().add(lblNombreDeUsuario);
			
			textField = new JTextField();
			textField.setFont(mf.MyFont(0, 12));
			textField.setColumns(10);
			textField.setBounds(122, 275, 131, 20);
			
			frmHistoriasDeZagas.getContentPane().add(textField);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setForeground(Color.WHITE);
			lblContrasea.setFont(mf.MyFont(0, 11));
			lblContrasea.setBounds(10, 306, 102, 14);
			frmHistoriasDeZagas.getContentPane().add(lblContrasea);
			
			passwordField = new JPasswordField();
			passwordField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {

					if (e.getKeyCode() == KeyEvent.VK_ENTER) {

						usuario = textField.getText();
						String pass=passwordField.getText();
						password = StringMD.getStringMessageDigest(pass, StringMD.MD5);
						String contraComp = "";
						try {
							String bloqueado = "";
							String motivo = "";
							ResultSet rs;
							rs = tabla
									.executeQuery("SELECT * FROM BLOQUEOS WHERE NOMBRE_DE_USUARIO='"
											+ usuario + "'");
							while (rs.next()) {

								bloqueado = rs.getString("NOMBRE_DE_USUARIO");
								motivo = rs.getString("MOTIVO");

							}
							if (bloqueado.equals(usuario)) {

								int seleccion = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
										"Este usuario se encuentra bloqueado actualmente. Motivo:"
												+ motivo,
										"Error de Inicio de Sesión",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, "opcion 1");
							} else {
								rs = tabla
										.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE_DE_USUARIO='"
												+ usuario + "'");
								while (rs.next()) {
									contraComp = rs.getString("CONTRASEÑA");
									admin=rs.getInt("ADMIN");
								}
								{
									if (contraComp.equals(password)
											&& usuario.length() != 0
											&& password.length() != 0) {
										con.cerrarCon();
										frmHistoriasDeZagas.dispose();
										Inicio window = new Inicio();
										window.getFrmHistoriasDeZagas().setVisible(
												true);

									} else {
										int seleccion = JOptionPane
												.showOptionDialog(
														frmHistoriasDeZagas,
														"Contraseña o nombre de usuario incorrectos.",
														"¡Error!",
														JOptionPane.OK_OPTION,
														JOptionPane.PLAIN_MESSAGE,
														null,
														new Object[] { "Aceptar" },
														"opcion 1");

									}
								}
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			});
			passwordField.setBounds(122, 306, 131, 20);
			
			frmHistoriasDeZagas.getContentPane().add(passwordField);
			
			JLabel lblolvidasteTuContrasea = new JLabel("\u00BFOlvidaste tu contrase\u00F1a?");
			lblolvidasteTuContrasea.setForeground(Color.WHITE);
			lblolvidasteTuContrasea.setFont(mf.MyFont(0, 11));
			lblolvidasteTuContrasea.setBounds(10, 337, 125, 14);
			frmHistoriasDeZagas.getContentPane().add(lblolvidasteTuContrasea);
			
			final JButton btnRecuperar = new JButton("Restaurar");
			btnRecuperar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String seleccion = JOptionPane.showInputDialog(
								frmHistoriasDeZagas, "Introduce tu usuario.", "",
								JOptionPane.PLAIN_MESSAGE);
						String pregunta = "";
						String respuesta = "";
						String contra = "";

						ResultSet rs = tabla
								.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE_DE_USUARIO='"
										+ seleccion + "'");
						while (rs.next()) {
							pregunta = rs.getString("PREGUNTA_DE_SEGURIDAD");
							respuesta = rs.getString("RESPUESTA_PREGUNTA");
							contra = rs.getString("CONTRASEÑA");

						}
						if (pregunta.length() == 0) {
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"No se encuentra el usuario.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");

						} else {

							String respuestaComp = JOptionPane.showInputDialog(
									frmHistoriasDeZagas, pregunta, "",
									JOptionPane.PLAIN_MESSAGE);

							if (respuestaComp.equals(respuesta)) {
								String nuevaContra = JOptionPane.showInputDialog(
										frmHistoriasDeZagas, "¡Respuesta correcta! Introduce una nueva contraseña:", "",
										JOptionPane.PLAIN_MESSAGE);
								
								if(nuevaContra.length()==0){
									int solucion = JOptionPane.showOptionDialog(
											frmHistoriasDeZagas,
											"Contraseña no valida",
											"Restaurar contraseña",
											JOptionPane.OK_OPTION,
											JOptionPane.PLAIN_MESSAGE, null,
											new Object[] { "Aceptar" }, "opcion 1");
								}
								else{
									
									String nuevaContraConf = JOptionPane.showInputDialog(
											frmHistoriasDeZagas, "Confirma tu nueva contraseña:", "",
											JOptionPane.PLAIN_MESSAGE);
									if(nuevaContraConf.length()==0 || !nuevaContraConf.equals(nuevaContra)){
										int solucion = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
												"La confirmación no coincide con la contraseña",
												"Restaurar contraseña",
												JOptionPane.OK_OPTION,
												JOptionPane.PLAIN_MESSAGE, null,
												new Object[] { "Aceptar" }, "opcion 1");
									}
									else{
										
										String pass=StringMD.getStringMessageDigest(nuevaContra, StringMD.MD5);;
										
										tabla
										.executeQuery("UPDATE USUARIOS SET CONTRASEÑA='"+pass +"' WHERE NOMBRE_DE_USUARIO='"
												+ seleccion + "'");
										
										int solucion = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
												"Contraseña cambiada con éxito",
												"Restaurar contraseña",
												JOptionPane.OK_OPTION,
												JOptionPane.PLAIN_MESSAGE, null,
												new Object[] { "Aceptar" }, "opcion 1");
									}
								
								
								}

							} else {
								int solucion = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
										"La respuesta a la pregunta es erronea",
										"Restaurar contraseña",
										JOptionPane.OK_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, "opcion 1");

							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				
				}
			});
			
			btnRecuperar.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					btnRecuperar.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton recuperar2.png")));
				}

				public void mouseReleased(MouseEvent arg0) {
					btnRecuperar.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton recuperar.png")));
				}
			});
			btnRecuperar.setIcon(new ImageIcon(Loader.class.getResource("/images/boton recuperar.png")));
			btnRecuperar.setOpaque(false);
			btnRecuperar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnRecuperar.setForeground(Color.WHITE);
			btnRecuperar.setFont(mf.MyFont(0, 10));
			btnRecuperar.setFocusPainted(false);
			btnRecuperar.setContentAreaFilled(false);
			btnRecuperar.setBorderPainted(false);
			btnRecuperar.setBounds(145, 333, 89, 23);
			frmHistoriasDeZagas.getContentPane().add(btnRecuperar);
			
			final JButton btnEntrar = new JButton("Entrar");
			
			btnEntrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if(btnEntrar.getText().equals("Actualizar")){
					
					try {
						File server=new File("./conexion/server");
						FileReader fr = new FileReader(server);
						BufferedReader br = new BufferedReader(fr);
						String ip=br.readLine();
						Runtime.getRuntime().exec( "rundll32 url.dll,FileProtocolHandler http://"+ip+"/setup.exe" );
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				else{
					

					usuario = textField.getText();
					String pass=passwordField.getText();
					password = StringMD.getStringMessageDigest(pass, StringMD.MD5);
					String contraComp = "";
					try {
						ResultSet rs = tabla
								.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE_DE_USUARIO='"
										+ usuario + "'");
						while (rs.next()) {
							contraComp = rs.getString("CONTRASEÑA");
							admin= rs.getInt("ADMIN");
				
							
							
							
							

						}
						if (contraComp.equals(password) && usuario.length() != 0
								&& password.length() != 0) {
							con.cerrarCon();;
							
							frmHistoriasDeZagas.dispose();
							Inicio window = new Inicio();
							window.getFrmHistoriasDeZagas().setVisible(true);

						} else {
							int seleccion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Contraseña o nombre de usuario incorrectos.",
									"¡Error!", JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				
					
				}
				
				}
			});
			btnEntrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnEntrar.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton entrarnuevo2.png")));
				}

				public void mouseReleased(MouseEvent e) {
					btnEntrar.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton entrarnuevo.png")));
				}
			});
			btnEntrar.setIcon(new ImageIcon(Loader.class.getResource("/images/boton entrarnuevo.png")));
			btnEntrar.setOpaque(false);
			btnEntrar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnEntrar.setForeground(Color.WHITE);
			btnEntrar.setFont(mf.MyFont(0, 20));
			btnEntrar.setFocusPainted(false);
			btnEntrar.setContentAreaFilled(false);
			btnEntrar.setBorderPainted(false);
			btnEntrar.setBounds(263, 271, 160, 60);
			if (con.accederDB()==null ){
				btnEntrar.setEnabled(false);
				
			}
			if(!versionDB.equals(version)){
				
				btnEntrar.setText("Actualizar");
			}
			frmHistoriasDeZagas.getContentPane().add(btnEntrar);
			
			JLabel lblnoTienesUna = new JLabel("\u00BFNo tienes una cuenta?");
			lblnoTienesUna.setForeground(Color.WHITE);
			lblnoTienesUna.setFont(mf.MyFont(0, 11));
			lblnoTienesUna.setBounds(10, 366, 125, 14);
			frmHistoriasDeZagas.getContentPane().add(lblnoTienesUna);
			
			final JButton btnRegistrate = new JButton("Registrate");
			btnRegistrate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

					try {
						con.cerrarCon();;
						frmHistoriasDeZagas.dispose();
						CrearCuenta window;
						try {
							window = new CrearCuenta();
							window.getFrmHistoriasDeZagas().setVisible(true);
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (InstantiationException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						} catch (IllegalAccessException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} catch (SQLException e5) {
						// TODO Auto-generated catch block
						e5.printStackTrace();
					}
				
				}
			});
			btnRegistrate.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					btnRegistrate.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton recuperar2.png")));
				}

				public void mouseReleased(MouseEvent arg0) {
					btnRegistrate.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton recuperar.png")));
				}
				
			});
			btnRegistrate.setIcon(new ImageIcon(Loader.class.getResource("/images/boton recuperar.png")));
			btnRegistrate.setOpaque(false);
		
			btnRegistrate.setHorizontalTextPosition(SwingConstants.CENTER);
			btnRegistrate.setForeground(Color.WHITE);
			btnRegistrate.setFont(mf.MyFont(0, 10));
			btnRegistrate.setFocusPainted(false);
			btnRegistrate.setContentAreaFilled(false);
			btnRegistrate.setBorderPainted(false);
			btnRegistrate.setBounds(145, 362, 89, 23);
			frmHistoriasDeZagas.getContentPane().add(btnRegistrate);
			
			JLabel lblEntrarSinConexin = new JLabel("Entrar sin Conexi\u00F3n:");
			lblEntrarSinConexin.setHorizontalAlignment(SwingConstants.CENTER);
			lblEntrarSinConexin.setForeground(Color.WHITE);
			lblEntrarSinConexin.setFont(mf.MyFont(0, 11));
			lblEntrarSinConexin.setBounds(263, 338, 160, 14);
			frmHistoriasDeZagas.getContentPane().add(lblEntrarSinConexin);
			
			final JButton btnEntrar2 = new JButton("Entrar");
			btnEntrar2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {


					frmHistoriasDeZagas.dispose();
					Inicio window = new Inicio();
					usuario = "";
					window.getFrmHistoriasDeZagas().setVisible(true);

				
				}
			});
			btnEntrar2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnEntrar2.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton entrarnuevo2.png")));
				}

				public void mouseReleased(MouseEvent e) {
					btnEntrar2.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton entrarnuevo.png")));
				}
			});
			btnEntrar2.setIcon(new ImageIcon(Loader.class.getResource("/images/boton entrarnuevo.png")));
			btnEntrar2.setOpaque(false);
			btnEntrar2.setHorizontalTextPosition(SwingConstants.CENTER);
			btnEntrar2.setForeground(Color.WHITE);
			btnEntrar2.setFont(mf.MyFont(0, 20));
			btnEntrar2.setFocusPainted(false);
			btnEntrar2.setContentAreaFilled(false);
			btnEntrar2.setBorderPainted(false);
			btnEntrar2.setBounds(263, 363, 160, 60);
			frmHistoriasDeZagas.getContentPane().add(btnEntrar2);
			
			final JButton lblVersin = new JButton("Versi\u00F3n: "+version);
			lblVersin.setForeground(Color.WHITE);
			lblVersin.setOpaque(false);
			lblVersin.setHorizontalTextPosition(SwingConstants.CENTER);
			lblVersin.setFocusPainted(false);
			lblVersin.setContentAreaFilled(false);
			lblVersin.setBorderPainted(false);
			lblVersin.setFont(mf.MyFont(0, 11));
			lblVersin.setBounds(10, 409, 125, 14);
			lblVersin.setIcon(new ImageIcon(Loader.class.getResource("/images/boton version.png")));
			lblVersin.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					lblVersin.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton version2.png")));
				}

				public void mouseReleased(MouseEvent e) {
					lblVersin.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton version.png")));
				}
			});
			
			lblVersin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {



					
					try {
						File server=new File("./conexion/server");
						FileReader fr = new FileReader(server);
						BufferedReader br = new BufferedReader(fr);
						String ip=br.readLine();
						Runtime.getRuntime().exec( "rundll32 url.dll,FileProtocolHandler http://"+ip+"/log-actualizaciones.html" );
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				

				
				}
			});
			frmHistoriasDeZagas.getContentPane().add(lblVersin);
		
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Loader.class.getResource("/images/Historias de Zagas, logo.png")));
			lblNewLabel.setBounds(10, 11, 413, 220);
			frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
			
			JLabel label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon(Loader.class.getResource("/images/background-inicio.jpg")));
			label_5.setBounds(0, 0, 433, 434);
			frmHistoriasDeZagas.getContentPane().add(label_5);
			
			if(con.accederDB()!=null && !version.equals(versionDB)){
				
				int confirmacion = JOptionPane
						.showOptionDialog(
								frmHistoriasDeZagas,
								"Actualmente dispones de una versión antigua del programa por lo que no podrás acceder al modo "
								+ "online hasta que lo actualices.",
								"Error de Versión",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE,
								null,
								new Object[] { "Aceptar" },
								"opcion 1");

			}
			if (con.accederDB()==null || !versionDB.equals(version) ){
				textField.setEnabled(false);
				btnRegistrate.setEnabled(false);
				btnRecuperar.setEnabled(false);
				passwordField.setEnabled(false);
				
			}
			
		}
		
		else{
			
			
					
			
			
			

			File vers=new File("./version/version");
			FileReader fr = new FileReader(vers);
			BufferedReader br = new BufferedReader(fr);
			String version=br.readLine();
			
			frmHistoriasDeZagas = new JFrame();
			frmHistoriasDeZagas.setTitle("Historias de Zagas");
			frmHistoriasDeZagas.setBackground(Color.WHITE);
			frmHistoriasDeZagas
					.setIconImage(Toolkit
							.getDefaultToolkit()
							.getImage(
									Armas.class
											.getResource("/images/Historias de Zagas, logo.png")));
			frmHistoriasDeZagas.setBounds(100, 100, 439, 462);
			frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmHistoriasDeZagas.setLocationRelativeTo(null);
			frmHistoriasDeZagas.setResizable(false);
			frmHistoriasDeZagas.getContentPane().setLayout(null);
			
			JLabel lblInicioDeSesin = new JLabel("Inicio de Sesi\u00F3n:");
			lblInicioDeSesin.setHorizontalAlignment(SwingConstants.LEFT);
			lblInicioDeSesin.setForeground(Color.WHITE);
			lblInicioDeSesin.setFont(mf.MyFont(0, 18));
			lblInicioDeSesin.setBounds(10, 241, 272, 23);
			frmHistoriasDeZagas.getContentPane().add(lblInicioDeSesin);
			
			JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
			lblNombreDeUsuario.setForeground(Color.WHITE);
			lblNombreDeUsuario.setFont(mf.MyFont(0, 11));
			lblNombreDeUsuario.setBounds(10, 275, 102, 14);
			frmHistoriasDeZagas.getContentPane().add(lblNombreDeUsuario);
			
			textField = new JTextField();
			textField.setEnabled(false);
			textField.setFont(mf.MyFont(0, 12));
			textField.setColumns(10);
			textField.setBounds(122, 275, 131, 20);
			
			frmHistoriasDeZagas.getContentPane().add(textField);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setForeground(Color.WHITE);
			lblContrasea.setFont(mf.MyFont(0, 11));
			lblContrasea.setBounds(10, 306, 102, 14);
			frmHistoriasDeZagas.getContentPane().add(lblContrasea);
			
			passwordField = new JPasswordField();
			passwordField.setEnabled(false);
			passwordField.setBounds(122, 306, 131, 20);
			
			frmHistoriasDeZagas.getContentPane().add(passwordField);
			
			JLabel lblolvidasteTuContrasea = new JLabel("\u00BFOlvidaste tu contrase\u00F1a?");
			lblolvidasteTuContrasea.setForeground(Color.WHITE);
			lblolvidasteTuContrasea.setFont(mf.MyFont(0, 11));
			lblolvidasteTuContrasea.setBounds(10, 337, 125, 14);
			frmHistoriasDeZagas.getContentPane().add(lblolvidasteTuContrasea);
			
			final JButton btnRecuperar = new JButton("Restaurar");
			btnRecuperar.setEnabled(false);
			btnRecuperar.setIcon(new ImageIcon(Loader.class.getResource("/images/boton recuperar.png")));
			btnRecuperar.setOpaque(false);
			btnRecuperar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnRecuperar.setForeground(Color.WHITE);
			btnRecuperar.setFont(mf.MyFont(0, 10));
			btnRecuperar.setFocusPainted(false);
			btnRecuperar.setContentAreaFilled(false);
			btnRecuperar.setBorderPainted(false);
			btnRecuperar.setBounds(145, 333, 89, 23);
			frmHistoriasDeZagas.getContentPane().add(btnRecuperar);
			
			final JButton btnEntrar = new JButton("Entrar");
			frmHistoriasDeZagas.getContentPane().add(btnEntrar);
			btnEntrar.setIcon(new ImageIcon(Loader.class.getResource("/images/boton entrarnuevo.png")));
			btnEntrar.setOpaque(false);
			btnEntrar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnEntrar.setForeground(Color.WHITE);
			btnEntrar.setFont(mf.MyFont(0, 20));
			btnEntrar.setFocusPainted(false);
			btnEntrar.setContentAreaFilled(false);
			btnEntrar.setBorderPainted(false);
			btnEntrar.setBounds(263, 271, 160, 60);
			btnEntrar.setEnabled(false);
				
			
			
			
			JLabel lblnoTienesUna = new JLabel("\u00BFNo tienes una cuenta?");
			lblnoTienesUna.setForeground(Color.WHITE);
			lblnoTienesUna.setFont(mf.MyFont(0, 11));
			lblnoTienesUna.setBounds(10, 366, 125, 14);
			frmHistoriasDeZagas.getContentPane().add(lblnoTienesUna);
			
			final JButton btnRegistrate = new JButton("Registrate");
			btnRegistrate.setEnabled(false);
			btnRegistrate.setIcon(new ImageIcon(Loader.class.getResource("/images/boton recuperar.png")));
			btnRegistrate.setOpaque(false);
		
			btnRegistrate.setHorizontalTextPosition(SwingConstants.CENTER);
			btnRegistrate.setForeground(Color.WHITE);
			btnRegistrate.setFont(mf.MyFont(0, 10));
			btnRegistrate.setFocusPainted(false);
			btnRegistrate.setContentAreaFilled(false);
			btnRegistrate.setBorderPainted(false);
			btnRegistrate.setBounds(145, 362, 89, 23);
			frmHistoriasDeZagas.getContentPane().add(btnRegistrate);
			
			JLabel lblEntrarSinConexin = new JLabel("Entrar sin Conexi\u00F3n:");
			lblEntrarSinConexin.setHorizontalAlignment(SwingConstants.CENTER);
			lblEntrarSinConexin.setForeground(Color.WHITE);
			lblEntrarSinConexin.setFont(mf.MyFont(0, 11));
			lblEntrarSinConexin.setBounds(263, 338, 160, 14);
			frmHistoriasDeZagas.getContentPane().add(lblEntrarSinConexin);
			
			final JButton btnEntrar2 = new JButton("Entrar");
			btnEntrar2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {


					frmHistoriasDeZagas.dispose();
					Inicio window = new Inicio();
					usuario = "";
					window.getFrmHistoriasDeZagas().setVisible(true);

				
				}
			});
			btnEntrar2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnEntrar2.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton entrarnuevo2.png")));
				}

				public void mouseReleased(MouseEvent e) {
					btnEntrar2.setIcon(new ImageIcon(Loader.class
							.getResource("/images/boton entrarnuevo.png")));
				}
			});
			btnEntrar2.setIcon(new ImageIcon(Loader.class.getResource("/images/boton entrarnuevo.png")));
			btnEntrar2.setOpaque(false);
			btnEntrar2.setHorizontalTextPosition(SwingConstants.CENTER);
			btnEntrar2.setForeground(Color.WHITE);
			btnEntrar2.setFont(mf.MyFont(0, 20));
			btnEntrar2.setFocusPainted(false);
			btnEntrar2.setContentAreaFilled(false);
			btnEntrar2.setBorderPainted(false);
			btnEntrar2.setBounds(263, 363, 160, 60);
			frmHistoriasDeZagas.getContentPane().add(btnEntrar2);
			
			JLabel lblVersin = new JLabel("Versi\u00F3n: "+version);
			lblVersin.setForeground(Color.WHITE);
			lblVersin.setFont(mf.MyFont(0, 11));
			lblVersin.setBounds(10, 409, 125, 14);
			frmHistoriasDeZagas.getContentPane().add(lblVersin);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Loader.class.getResource("/images/Historias de Zagas, logo.png")));
			lblNewLabel.setBounds(10, 11, 413, 220);
			frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
			
			JLabel label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon(Loader.class.getResource("/images/background-inicio.jpg")));
			label_5.setBounds(0, 0, 433, 434);
			frmHistoriasDeZagas.getContentPane().add(label_5);
			
		
			
		}
	
	}
}
