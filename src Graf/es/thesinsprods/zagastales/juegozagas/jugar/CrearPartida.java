package es.thesinsprods.zagastales.juegozagas.jugar;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.omg.CORBA.portable.InputStream;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;
import es.thesinsprods.zagastales.juegozagas.jugar.master.JugarOnline;
import es.thesinsprods.zagastales.jugar.online.server.SystemServer;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;

public class CrearPartida {
	MorpheusFont mf=new MorpheusFont();
	private JFrame frmHistoriasDeZagas;
	public static String nombre="";
	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}
	private JTextField textField_1;
	private JPasswordField passwordField;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPartida window = new CrearPartida();
					window.frmHistoriasDeZagas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public CrearPartida() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
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
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
		final ConexionDBOnline con = new ConexionDBOnline();
		final Connection p = con.accederDB();
		final Statement tabla=p.createStatement();
		
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(CrearPartida.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setBounds(100, 100, 464, 315);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(mf.MyFont(0, 12));
		lblNombre.setBounds(10, 11, 84, 14);
		frmHistoriasDeZagas.getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(mf.MyFont(0, 12));
		lblContrasea.setBounds(10, 36, 84, 14);
		frmHistoriasDeZagas.getContentPane().add(lblContrasea);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(mf.MyFont(0, 12));
		lblDescripcin.setForeground(Color.WHITE);
		lblDescripcin.setBounds(10, 86, 84, 14);
		frmHistoriasDeZagas.getContentPane().add(lblDescripcin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 8, 140, 20);
		frmHistoriasDeZagas.getContentPane().add(textField_1);
		textField_1.setFont(mf.MyFont(0, 12));
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 35, 140, 20);
		frmHistoriasDeZagas.getContentPane().add(passwordField);
		
		
		JLabel lblJugadoresMximos = new JLabel("M\u00E1ximo de Jugadores:");
		lblJugadoresMximos.setFont(mf.MyFont(0,12));
		lblJugadoresMximos.setForeground(Color.WHITE);
		lblJugadoresMximos.setBounds(10, 61, 151, 14);
		frmHistoriasDeZagas.getContentPane().add(lblJugadoresMximos);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(10);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(144, 60, 46, 17);
		frmHistoriasDeZagas.getContentPane().add(comboBox);
		final JTextArea textArea = new JTextArea();
		final JButton btnNewButton = new JButton("Crear");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btnNewButton.setIcon(new ImageIcon(CrearPartida.class.getResource("/images/boton crear partida2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btnNewButton.setIcon(new ImageIcon(CrearPartida.class.getResource("/images/boton crear partida1.png")));
			}
		});
		 btnNewButton.setOpaque(false);
		 btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		 btnNewButton.setForeground(Color.WHITE);
		 btnNewButton.setFont(mf.MyFont(0, 15));
		 btnNewButton.setContentAreaFilled(false);
		 btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(CrearPartida.class.getResource("/images/boton crear partida1.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre=textField_1.getText();
				CrearPartida.nombre=nombre;
				String contrasena=passwordField.getText();
				String descripcion=textArea.getText();
				String ip_publica=getIP();
				int maxj=Integer.parseInt(comboBox.getSelectedItem().toString());
				InetAddress thisIp;
				try {
					thisIp = InetAddress.getLocalHost();
					  String ip_local = thisIp.getHostAddress().toString();
						try {
							tabla.executeQuery("INSERT INTO PARTIDAS VALUES('"+nombre+"','"+contrasena+"','"+descripcion+"',"+maxj+",0,'"+ip_publica+"','"+ip_local+"','"+Loader.usuario+"')");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
						frmHistoriasDeZagas.dispose();
						SystemServer window2=new SystemServer();
						window2.getFrame().setVisible(false);
						JugarOnline window= new JugarOnline();
						window.getFrame().setVisible(true);
					
						
				
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          
				
			}
		});
		btnNewButton.setBounds(250, 11, 199, 89);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 439, 120);
		frmHistoriasDeZagas.getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
		textArea.setFont(mf.MyFont(0, 12));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		final JButton button = new JButton("Volver");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button.setIcon(new ImageIcon(CrearPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button.setIcon(new ImageIcon(CrearPartida.class.getResource("/images/botones-inicio-ayuda.png")));
				
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHistoriasDeZagas.dispose();
				Jugar window= new Jugar();
				window.getFrmHistoriasDeZagas().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(CrearPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setFont(mf.MyFont(0, 12));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(172, 244, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CrearPartida.class.getResource("/images/background-start.jpg")));
		label.setBounds(0, 0, 469, 294);
		frmHistoriasDeZagas.getContentPane().add(label);

	}
	
	 public String getIP() {
			String ip="";
		 try {
	    	
	    		
			 URL whatismyip = new URL("http://checkip.amazonaws.com");
			  BufferedReader in = new BufferedReader(new InputStreamReader(
			                  whatismyip.openStream()));

			       ip = in.readLine(); 
	 
	 
	        } catch (Exception ex) {
	                ip="No";
	          }
	 
	       return ip;
	    }
}


