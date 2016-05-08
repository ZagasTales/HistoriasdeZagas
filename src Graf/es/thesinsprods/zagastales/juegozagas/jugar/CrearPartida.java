package es.thesinsprods.zagastales.juegozagas.jugar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.omg.CORBA.portable.InputStream;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.jugar.offline.JugarOnline;
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

public class CrearPartida {
	MorpheusFont mf=new MorpheusFont();
	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField textField;
	private JTextField textField_1;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPartida window = new CrearPartida();
					window.frame.setVisible(true);
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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 446, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 36, 84, 14);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 86, 84, 14);
		frame.getContentPane().add(lblDescripcin);
		
		textField = new JTextField();
		textField.setBounds(75, 33, 140, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 5, 140, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(10, 111, 414, 164);
		frame.getContentPane().add(textArea);
		
		
		JLabel lblJugadoresMximos = new JLabel("M\u00E1ximo de Jugadores:");
		lblJugadoresMximos.setBounds(10, 61, 151, 14);
		frame.getContentPane().add(lblJugadoresMximos);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(10);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(144, 60, 46, 17);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre=textField_1.getText();
				String contrasena=textField.getText();
				String descripcion=textArea.getText();
				String ip_publica=getIP();
				int maxj=Integer.parseInt(comboBox.getSelectedItem().toString());
				InetAddress thisIp;
				try {
					thisIp = InetAddress.getLocalHost();
					  String ip_local = thisIp.getHostAddress().toString();
						try {
							tabla.executeQuery("INSERT INTO PARTIDAS VALUES('"+nombre+"','"+contrasena+"','"+descripcion+"',"+maxj+",0,'"+ip_publica+"','"+ip_local+"')");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
						frame.dispose();
						SystemServer window2=new SystemServer();
						window2.getFrame().setVisible(true);
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
		btnNewButton.setBounds(225, 11, 199, 89);
		frame.getContentPane().add(btnNewButton);

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


