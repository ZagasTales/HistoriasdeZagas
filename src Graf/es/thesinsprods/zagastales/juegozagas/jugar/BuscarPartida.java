package es.thesinsprods.zagastales.juegozagas.jugar;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.zagastales.juegozagas.jugar.offline.VentanaJugadores;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarPartida {

	private JFrame frame;
public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

public static int partidas=9;
public static String nombrePart;
public static String ip;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarPartida window = new BuscarPartida();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public BuscarPartida() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		final ConexionDBOnline con = new ConexionDBOnline();
		final Connection p = con.accederDB();
		final Statement tabla=p.createStatement();
		final ArrayList<String> nombre = new ArrayList<String>();
		ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS");
	
		while(rs.next()){
			
			nombre.add(rs.getString("NOMBRE"));
			
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 11, 166, 31);
		frame.getContentPane().add(lblNombre);
		
		final JLabel label = new JLabel("---");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 53, 166, 31);
		frame.getContentPane().add(label);
		
		final JLabel label_1 = new JLabel("---");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 95, 166, 31);
		frame.getContentPane().add(label_1);
		
		final JLabel label_2 = new JLabel("---");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 137, 166, 31);
		frame.getContentPane().add(label_2);
		
		final JLabel label_3 = new JLabel("---");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(10, 179, 166, 31);
		frame.getContentPane().add(label_3);
		
		final JLabel label_4 = new JLabel("---");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(10, 221, 166, 31);
		frame.getContentPane().add(label_4);
		
		final JLabel label_5 = new JLabel("---");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(10, 263, 166, 31);
		frame.getContentPane().add(label_5);
		
		final JLabel label_6 = new JLabel("---");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(10, 305, 166, 31);
		frame.getContentPane().add(label_6);
		
		final JLabel label_7 = new JLabel("---");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(10, 347, 166, 31);
		frame.getContentPane().add(label_7);
		
		final JLabel label_8 = new JLabel("---");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(10, 389, 166, 31);
		frame.getContentPane().add(label_8);
		
		final JLabel label_9 = new JLabel("---");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(10, 431, 166, 31);
		frame.getContentPane().add(label_9);
		
		JButton btnNewButton = new JButton("Descripci\u00F3n");
		btnNewButton.setBounds(191, 53, 119, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Descripci\u00F3n");
		button.setBounds(191, 95, 119, 31);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Descripci\u00F3n");
		button_1.setBounds(191, 137, 119, 31);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Descripci\u00F3n");
		button_2.setBounds(191, 179, 119, 31);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Descripci\u00F3n");
		button_3.setBounds(191, 221, 119, 31);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Descripci\u00F3n");
		button_4.setBounds(191, 263, 119, 31);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Descripci\u00F3n");
		button_5.setBounds(191, 305, 119, 31);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("Descripci\u00F3n");
		button_6.setBounds(191, 347, 119, 31);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("Descripci\u00F3n");
		button_7.setBounds(191, 389, 119, 31);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("Descripci\u00F3n");
		button_8.setBounds(191, 431, 119, 31);
		frame.getContentPane().add(button_8);
		
		JButton btnConexin = new JButton("Conexi\u00F3n");
		btnConexin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frame,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frame,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										frame.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frame,
												"Contraseña Incorrecta",
												"Error de Conexión",
												JOptionPane.YES_NO_OPTION,
												JOptionPane.PLAIN_MESSAGE, null,
												new Object[] { "Aceptar" }, "opcion 1");
									}
								}
								else{
									
									VentanaJugadores window=new VentanaJugadores();
									window.getFrame().setVisible(true);
									frame.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frame,
										"Partida completa",
										"Error de Conexión",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, null,
										new Object[] { "Aceptar" }, "opcion 1");
							}
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
				
			}
		});
		btnConexin.setBounds(341, 53, 119, 31);
		frame.getContentPane().add(btnConexin);
		
		JButton btnConexin_1 = new JButton("Conexi\u00F3n");
		btnConexin_1.setBounds(341, 95, 119, 31);
		frame.getContentPane().add(btnConexin_1);
		
		JButton btnConexin_2 = new JButton("Conexi\u00F3n");
		btnConexin_2.setBounds(341, 137, 119, 31);
		frame.getContentPane().add(btnConexin_2);
		
		JButton btnConexin_3 = new JButton("Conexi\u00F3n");
		btnConexin_3.setBounds(341, 179, 119, 31);
		frame.getContentPane().add(btnConexin_3);
		
		JButton btnConexin_4 = new JButton("Conexi\u00F3n");
		btnConexin_4.setBounds(341, 221, 119, 31);
		frame.getContentPane().add(btnConexin_4);
		
		JButton btnConexin_5 = new JButton("Conexi\u00F3n");
		btnConexin_5.setBounds(341, 263, 119, 31);
		frame.getContentPane().add(btnConexin_5);
		
		JButton btnConexin_6 = new JButton("Conexi\u00F3n");
		btnConexin_6.setBounds(341, 305, 119, 31);
		frame.getContentPane().add(btnConexin_6);
		
		JButton btnConexin_7 = new JButton("Conexi\u00F3n");
		btnConexin_7.setBounds(341, 347, 119, 31);
		frame.getContentPane().add(btnConexin_7);
		
		JButton btnConexin_8 = new JButton("Conexi\u00F3n");
		btnConexin_8.setBounds(341, 389, 119, 31);
		frame.getContentPane().add(btnConexin_8);
		
		JButton btnConexin_9 = new JButton("Conexi\u00F3n");
		btnConexin_9.setBounds(341, 431, 119, 31);
		frame.getContentPane().add(btnConexin_9);
		
		final JButton button_9 = new JButton("");
		button_9.setEnabled(false);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				partidas-=10;
				
				if(partidas-9 < nombre.size() && partidas-9 >= 0){
				label.setText(nombre.get(partidas-9));
				}
				else{
					label.setText("");
				}
				if(partidas-8 < nombre.size() && partidas-8 >= 0){
				label_1.setText(nombre.get(partidas-8));}
				else{
					label_1.setText("");
				}
				if(partidas-7 < nombre.size() && partidas-7 >= 0){
				label_2.setText(nombre.get(partidas-7));}
				else{
					label_2.setText("");
					
				}
				if(partidas-6 < nombre.size() && partidas-6 >= 0){
				label_3.setText(nombre.get(partidas-6));}
				else{
					label_3.setText("");
					
				}
				if(partidas-5 < nombre.size() && partidas-5 >= 0){
				label_4.setText(nombre.get(partidas-5));}
				else{
					label_4.setText("");
					
				}
				if(partidas-4 < nombre.size() && partidas-4 >= 0){
				label_5.setText(nombre.get(partidas-4));}
				else{
					label_5.setText("");
					
				}
				if(partidas-3 < nombre.size() && partidas-3 >= 0){
				label_6.setText(nombre.get(partidas-3));}
				else{
					label_6.setText("");
					
				}
				if(partidas-2 < nombre.size() && partidas-2 >= 0){
				label_7.setText(nombre.get(partidas-2));}
				else{
					label_7.setText("");
					
				}
				if(partidas-1 < nombre.size() && partidas-1 >= 0){
				label_8.setText(nombre.get(partidas-1));}
				else{
					label_8.setText("");
					
				}
				if(partidas < nombre.size() && partidas >= 0){
				label_9.setText(nombre.get(partidas));}
				else{
					label_9.setText("");
					
				}
			
			if(partidas==9){
				button_9.setEnabled(false);
			}
			
			}
		});
		button_9.setBounds(10, 519, 119, 31);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		
					if(partidas+1 < nombre.size()){
					label.setText(nombre.get(partidas+1));
					}
					else{
						label.setText("");
					}
					if(partidas+2 < nombre.size()){
					label_1.setText(nombre.get(partidas+2));}
					else{
						label_1.setText("");
					}
					if(partidas+3 < nombre.size()){
					label_2.setText(nombre.get(partidas+3));}
					else{
						label_2.setText("");
						
					}
					if(partidas+4 < nombre.size()){
					label_3.setText(nombre.get(partidas+4));}
					else{
						label_3.setText("");
						
					}
					if(partidas+5 < nombre.size()){
					label_4.setText(nombre.get(partidas+5));}
					else{
						label_4.setText("");
						
					}
					if(partidas+6 < nombre.size()){
					label_5.setText(nombre.get(partidas+6));}
					else{
						label_5.setText("");
						
					}
					if(partidas+7 < nombre.size()){
					label_6.setText(nombre.get(partidas+7));}
					else{
						label_6.setText("");
						
					}
					if(partidas+8 < nombre.size()){
					label_7.setText(nombre.get(partidas+8));}
					else{
						label_7.setText("");
						
					}
					if(partidas+9 < nombre.size()){
					label_8.setText(nombre.get(partidas+9));}
					else{
						label_8.setText("");
						
					}
					if(partidas+10 < nombre.size()){
					label_9.setText(nombre.get(partidas+10));}
					else{
						label_9.setText("");
						
					}
					partidas+=10;
				
				button_9.setEnabled(true);
			}
		});
		button_10.setBounds(355, 519, 119, 31);
		frame.getContentPane().add(button_10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(172, 519, 138, 31);
		frame.getContentPane().add(btnVolver);
		
			
		if(0 < nombre.size()){
		label.setText(nombre.get(0));
		}
		else{
			label.setText("");
		}
		if(1 < nombre.size()){
		label_1.setText(nombre.get(1));}
		else{
			label_1.setText("");
		}
		if(2 < nombre.size()){
		label_2.setText(nombre.get(2));}
		else{
			label_2.setText("");
			
		}
		if(3 < nombre.size()){
		label_3.setText(nombre.get(3));}
		else{
			label_3.setText("");
			
		}
		if(4 < nombre.size()){
		label_4.setText(nombre.get(4));}
		else{
			label_4.setText("");
			
		}
		if(5 < nombre.size()){
		label_5.setText(nombre.get(5));}
		else{
			label_5.setText("");
			
		}
		if(6 < nombre.size()){
		label_6.setText(nombre.get(6));}
		else{
			label_6.setText("");
			
		}
		if(7 < nombre.size()){
		label_7.setText(nombre.get(7));}
		else{
			label_7.setText("");
			
		}
		if(8 < nombre.size()){
		label_8.setText(nombre.get(8));}
		else{
			label_8.setText("");
			
		}
		if(9 < nombre.size()){
		label_9.setText(nombre.get(9));}
		else{
			label_9.setText("");
			
		}

	}
}
