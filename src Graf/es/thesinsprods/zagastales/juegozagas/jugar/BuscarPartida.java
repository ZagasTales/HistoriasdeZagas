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
import es.thesinsprods.resources.font.MorpheusFont;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class BuscarPartida {

	private JFrame frmHistoriasDeZagas;
public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

public static int partidas=9;
public static String nombrePart;
public static String ip;
public static String master;
MorpheusFont mf = new MorpheusFont();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarPartida window = new BuscarPartida();
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
		final ArrayList<String> masters = new ArrayList<String>();
		ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS");
		final JTextArea textArea = new JTextArea();
		textArea.setFont(mf.MyFont(0,12));
		while(rs.next()){
			
			nombre.add(rs.getString("NOMBRE"));
			masters.add(rs.getString("USUARIO"));
			
		}
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarPartida.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 892, 590);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(mf.MyFont(0,12));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 11, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(lblNombre);
		
		final JLabel label = new JLabel("---");
		label.setFont(mf.MyFont(0,12));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 53, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label);
		
		final JLabel label_1 = new JLabel("---");
		label_1.setFont(mf.MyFont(0,12));
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 95, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_1);
		
		final JLabel label_2 = new JLabel("---");
		label_2.setFont(mf.MyFont(0,12));
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 137, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_2);
		
		final JLabel label_3 = new JLabel("---");
		label_3.setFont(mf.MyFont(0,12));
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(10, 179, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_3);
		
		final JLabel label_4 = new JLabel("---");
		label_4.setFont(mf.MyFont(0,12));
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(10, 221, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_4);
		
		final JLabel label_5 = new JLabel("---");
		label_5.setFont(mf.MyFont(0,12));
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(10, 263, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_5);
		
		final JLabel label_6 = new JLabel("---");
		label_6.setFont(mf.MyFont(0,12));
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(10, 305, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_6);
		
		final JLabel label_7 = new JLabel("---");
		label_7.setFont(mf.MyFont(0,12));
		label_7.setForeground(Color.WHITE);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(10, 347, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_7);
		
		final JLabel label_8 = new JLabel("---");
		label_8.setFont(mf.MyFont(0,12));
		label_8.setForeground(Color.WHITE);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(10, 389, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_8);
		
		final JLabel label_9 = new JLabel("---");
		label_9.setFont(mf.MyFont(0,12));
		label_9.setForeground(Color.WHITE);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(10, 431, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_9);
		

		 final JLabel label_11 = new JLabel("---");
		 label_11.setFont(mf.MyFont(0,12));
		 label_11.setForeground(Color.WHITE);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(146, 53, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_11);
		
		final JLabel label_12 = new JLabel("---");
		label_12.setFont(mf.MyFont(0,12));
		label_12.setForeground(Color.WHITE);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(146, 95, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_12);
		
		final JLabel label_13 = new JLabel("---");
		label_13.setFont(mf.MyFont(0,12));
		label_13.setForeground(Color.WHITE);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(146, 137, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_13);
		
		final JLabel label_14 = new JLabel("---");
		label_14.setFont(mf.MyFont(0,12));
		label_14.setForeground(Color.WHITE);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(146, 179, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_14);
		
		final JLabel label_15 = new JLabel("---");
		label_15.setFont(mf.MyFont(0,12));
		label_15.setForeground(Color.WHITE);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(146, 221, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_15);
		
		final JLabel label_16 = new JLabel("---");
		label_16.setFont(mf.MyFont(0,12));
		label_16.setForeground(Color.WHITE);
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(146, 263, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_16);
		
		final JLabel label_17 = new JLabel("---");
		label_17.setFont(mf.MyFont(0,12));
		label_17.setForeground(Color.WHITE);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(146, 305, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_17);
		
		final JLabel label_18 = new JLabel("---");
		label_18.setFont(mf.MyFont(0,12));
		label_18.setForeground(Color.WHITE);
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBounds(146, 347, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_18);
		
		final JLabel label_19 = new JLabel("---");
		label_19.setFont(mf.MyFont(0,12));
		label_19.setForeground(Color.WHITE);
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(146, 389, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_19);
		
		final JLabel label_20 = new JLabel("---");
		label_20.setFont(mf.MyFont(0,12));
		label_20.setForeground(Color.WHITE);
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBounds(146, 431, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(label_20);
		
		final JButton btnNewButton = new JButton("Descripci\u00F3n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnNewButton.setFont(mf.MyFont(0,12));
		btnNewButton.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String descripcion="";
					ResultSet rs = tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label.getText()+"' AND USUARIO='"+label_11.getText()+"'");
					
					while (rs.next()){
					
						descripcion= rs.getString("DESCRIPCION");
						
						
					}
					
					textArea.setText(descripcion);
					
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(288, 53, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton);
		
		final JButton button = new JButton("Descripci\u00F3n");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		button.setFont(mf.MyFont(0,12));
		button.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setForeground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				try {
					String descripcion="";
					ResultSet rs = tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_1.getText()+"' AND USUARIO='"+label_12.getText()+"'");
					
					while (rs.next()){
					
						descripcion= rs.getString("DESCRIPCION");
						
						
					}
					
					textArea.setText(descripcion);
					
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			}
		});
		button.setBounds(288, 95, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button);
		
		final JButton button_1 = new JButton("Descripci\u00F3n");
		button_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		button_1.setFont(mf.MyFont(0,12));
		button_1.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setForeground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				try {
					String descripcion="";
					ResultSet rs = tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_2.getText()+"' AND USUARIO='"+label_13.getText()+"'");
					
					while (rs.next()){
					
						descripcion= rs.getString("DESCRIPCION");
						
						
					}
					
					textArea.setText(descripcion);
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				
			}
		});
		button_1.setBounds(288, 137, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button_1);
		
		final JButton button_2 = new JButton("Descripci\u00F3n");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_2.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_2.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		button_2.setFont(mf.MyFont(0,12));
		button_2.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setForeground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				try {
					String descripcion="";
					ResultSet rs = tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_3.getText()+"' AND USUARIO='"+label_14.getText()+"'");
					
					while (rs.next()){
					
						descripcion= rs.getString("DESCRIPCION");
						
						
					}
					
					textArea.setText(descripcion);
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		button_2.setBounds(288, 179, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button_2);
		
		final JButton button_3 = new JButton("Descripci\u00F3n");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_3.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_3.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		button_3.setFont(mf.MyFont(0,12));
		button_3.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setForeground(Color.WHITE);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				try {
					String descripcion="";
					ResultSet rs = tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_4.getText()+"' AND USUARIO='"+label_15.getText()+"'");
					
					while (rs.next()){
					
						descripcion= rs.getString("DESCRIPCION");
						
						
					}
					
					textArea.setText(descripcion);
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			
			}
		});
		button_3.setBounds(288, 221, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button_3);
		
		final JButton button_4 = new JButton("Descripci\u00F3n");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_4.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_4.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		button_4.setFont(mf.MyFont(0,12));
		button_4.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setForeground(Color.WHITE);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				try {
					String descripcion="";
					ResultSet rs = tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_5.getText()+"' AND USUARIO='"+label_16.getText()+"'");
					
					while (rs.next()){
					
						descripcion= rs.getString("DESCRIPCION");
						
						
					}
					
					textArea.setText(descripcion);
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			
			}
		});
		button_4.setBounds(288, 263, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button_4);
		
		final JButton button_5 = new JButton("Descripci\u00F3n");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_5.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_5.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		button_5.setFont(mf.MyFont(0,12));
		button_5.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.setForeground(Color.WHITE);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				try {
					String descripcion="";
					ResultSet rs = tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_6.getText()+"' AND USUARIO='"+label_17.getText()+"'");
					
					while (rs.next()){
					
						descripcion= rs.getString("DESCRIPCION");
						
						
					}
					
					textArea.setText(descripcion);
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			
			}
		});
		button_5.setBounds(288, 305, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button_5);
		
		final JButton button_6 = new JButton("Descripci\u00F3n");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_6.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_6.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		button_6.setFont(mf.MyFont(0,12));
		button_6.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.setContentAreaFilled(false);
		button_6.setBorderPainted(false);
		button_6.setForeground(Color.WHITE);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				try {
					String descripcion="";
					ResultSet rs = tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_7.getText()+"' AND USUARIO='"+label_18.getText()+"'");
					
					while (rs.next()){
					
						descripcion= rs.getString("DESCRIPCION");
						
						
					}
					
					textArea.setText(descripcion);
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			
			}
		});
		button_6.setBounds(288, 347, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button_6);
		
		final JButton button_7 = new JButton("Descripci\u00F3n");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_7.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_7.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		button_7.setFont(mf.MyFont(0,12));
		button_7.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setContentAreaFilled(false);
		button_7.setBorderPainted(false);
		button_7.setForeground(Color.WHITE);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				


				
				try {
					String descripcion="";
					ResultSet rs = tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_8.getText()+"' AND USUARIO='"+label_19.getText()+"'");
					
					while (rs.next()){
					
						descripcion= rs.getString("DESCRIPCION");
						
						
					}
					
					textArea.setText(descripcion);
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			
				
			}
		});
		button_7.setBounds(288, 389, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button_7);
		
		final JButton button_8 = new JButton("Descripci\u00F3n");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_8.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_8.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		button_8.setFont(mf.MyFont(0,12));
		button_8.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.setContentAreaFilled(false);
		button_8.setBorderPainted(false);
		button_8.setForeground(Color.WHITE);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				


				
				try {
					String descripcion="";
					ResultSet rs = tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_9.getText()+"' AND USUARIO='"+label_20.getText()+"'");
					
					while (rs.next()){
					
						descripcion= rs.getString("DESCRIPCION");
						
						
					}
					
					textArea.setText(descripcion);
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			
				
			}
		});
		button_8.setBounds(288, 431, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button_8);
		
		final JButton btnConexin = new JButton("Conexi\u00F3n");
		btnConexin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConexin.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnConexin.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnConexin.setFont(mf.MyFont(0,12));
		btnConexin.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnConexin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConexin.setContentAreaFilled(false);
		btnConexin.setBorderPainted(false);
		btnConexin.setForeground(Color.WHITE);
		btnConexin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label.getText()+"' AND USUARIO='"+label_11.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
							
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña","",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label.getText()+"' AND USUARIO='"+label_11.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label.getText()+"' AND USUARIO='"+label_11.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
	if (JOptionPane.NO_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label.getText()+"' AND USUARIO='"+label_11.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_PUBLICA");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña","",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label.getText()+"' AND USUARIO='"+label_11.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label.getText()+"' AND USUARIO='"+label_11.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		nombrePart=label.getText();
				
			}
		});
		btnConexin.setBounds(438, 53, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnConexin);
		
		final JButton btnConexin_1 = new JButton("Conexi\u00F3n");
		btnConexin_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConexin_1.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnConexin_1.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnConexin_1.setFont(mf.MyFont(0,12));
		btnConexin_1.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnConexin_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConexin_1.setContentAreaFilled(false);
		btnConexin_1.setBorderPainted(false);
		btnConexin_1.setForeground(Color.WHITE);
		btnConexin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_1.getText()+"' AND USUARIO='"+label_12.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_1.getText()+"' AND USUARIO='"+label_12.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_1.getText()+"' AND USUARIO='"+label_12.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
	if (JOptionPane.NO_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_1.getText()+"' AND USUARIO='"+label_12.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_PUBLICA");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_1.getText()+"' AND USUARIO='"+label_12.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_1.getText()+"' AND USUARIO='"+label_12.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
	nombrePart=label_1.getText();
			
			}
		});
		btnConexin_1.setBounds(438, 95, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnConexin_1);
		
		final JButton btnConexin_2 = new JButton("Conexi\u00F3n");
		btnConexin_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConexin_2.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnConexin_2.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnConexin_2.setFont(mf.MyFont(0,12));
		btnConexin_2.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnConexin_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConexin_2.setContentAreaFilled(false);
		btnConexin_2.setBorderPainted(false);
		btnConexin_2.setForeground(Color.WHITE);
		btnConexin_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_2.getText()+"' AND USUARIO='"+label_13.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_2.getText()+"' AND USUARIO='"+label_13.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_2.getText()+"' AND USUARIO='"+label_13.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
	if (JOptionPane.NO_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_2.getText()+"' AND USUARIO='"+label_13.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_PUBLICA");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_2.getText()+"' AND USUARIO='"+label_13.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_2.getText()+"' AND USUARIO='"+label_13.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
			
	nombrePart=label_2.getText();
	
			}
		});
		btnConexin_2.setBounds(438, 137, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnConexin_2);
		
		final JButton btnConexin_3 = new JButton("Conexi\u00F3n");
		btnConexin_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConexin_3.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnConexin_3.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnConexin_3.setFont(mf.MyFont(0,12));
		btnConexin_3.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnConexin_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConexin_3.setContentAreaFilled(false);
		btnConexin_3.setBorderPainted(false);
		btnConexin_3.setForeground(Color.WHITE);
		btnConexin_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_3.getText()+"' AND USUARIO='"+label_14.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_3.getText()+"' AND USUARIO='"+label_14.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_3.getText()+"' AND USUARIO='"+label_14.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
	if (JOptionPane.NO_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_3.getText()+"' AND USUARIO='"+label_14.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_PUBLICA");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_3.getText()+"' AND USUARIO='"+label_14.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_3.getText()+"' AND USUARIO='"+label_14.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
	nombrePart=label_3.getText();			
	
			}
		});
		btnConexin_3.setBounds(438, 179, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnConexin_3);
		
		final JButton btnConexin_4 = new JButton("Conexi\u00F3n");
		btnConexin_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConexin_4.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnConexin_4.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnConexin_4.setFont(mf.MyFont(0,12));
		btnConexin_4.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnConexin_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConexin_4.setContentAreaFilled(false);
		btnConexin_4.setBorderPainted(false);
		btnConexin_4.setForeground(Color.WHITE);
		btnConexin_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_4.getText()+"' AND USUARIO='"+label_15.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_4.getText()+"' AND USUARIO='"+label_15.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_4.getText()+"' AND USUARIO='"+label_15.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
	if (JOptionPane.NO_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_4.getText()+"' AND USUARIO='"+label_15.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_PUBLICA");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_4.getText()+"' AND USUARIO='"+label_15.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_4.getText()+"' AND USUARIO='"+label_15.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
	nombrePart=label_4.getText();
				
			}
		});
		btnConexin_4.setBounds(438, 221, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnConexin_4);
		
		final JButton btnConexin_5 = new JButton("Conexi\u00F3n");
		btnConexin_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConexin_5.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnConexin_5.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnConexin_5.setFont(mf.MyFont(0,12));
		btnConexin_5.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnConexin_5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConexin_5.setContentAreaFilled(false);
		btnConexin_5.setBorderPainted(false);
		btnConexin_5.setForeground(Color.WHITE);
		btnConexin_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_5.getText()+"' AND USUARIO='"+label_16.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_5.getText()+"' AND USUARIO='"+label_16.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_5.getText()+"' AND USUARIO='"+label_16.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
	if (JOptionPane.NO_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_5.getText()+"' AND USUARIO='"+label_16.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_PUBLICA");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_5.getText()+"' AND USUARIO='"+label_16.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_5.getText()+"' AND USUARIO='"+label_16.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
				
	nombrePart=label_5.getText();
				
			}
		});
		btnConexin_5.setBounds(438, 263, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnConexin_5);
		
		final JButton btnConexin_6 = new JButton("Conexi\u00F3n");
		btnConexin_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConexin_6.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnConexin_6.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnConexin_6.setFont(mf.MyFont(0,12));
		btnConexin_6.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnConexin_6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConexin_6.setContentAreaFilled(false);
		btnConexin_6.setBorderPainted(false);
		btnConexin_6.setForeground(Color.WHITE);
		btnConexin_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_6.getText()+"' AND USUARIO='"+label_17.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_6.getText()+"' AND USUARIO='"+label_17.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_6.getText()+"' AND USUARIO='"+label_17.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
	if (JOptionPane.NO_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_6.getText()+"' AND USUARIO='"+label_17.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_PUBLICA");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_6.getText()+"' AND USUARIO='"+label_17.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_6.getText()+"' AND USUARIO='"+label_17.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
	nombrePart=label_6.getText();
				
			}
		});
		btnConexin_6.setBounds(438, 305, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnConexin_6);
		
		final JButton btnConexin_7 = new JButton("Conexi\u00F3n");
		btnConexin_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConexin_7.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnConexin_7.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnConexin_7.setFont(mf.MyFont(0,12));
		btnConexin_7.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnConexin_7.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConexin_7.setContentAreaFilled(false);
		btnConexin_7.setBorderPainted(false);
		btnConexin_7.setForeground(Color.WHITE);
		btnConexin_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_7.getText()+"' AND USUARIO='"+label_18.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_7.getText()+"' AND USUARIO='"+label_18.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_7.getText()+"' AND USUARIO='"+label_18.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
	if (JOptionPane.NO_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_7.getText()+"' AND USUARIO='"+label_18.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_PUBLICA");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_7.getText()+"' AND USUARIO='"+label_18.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_7.getText()+"' AND USUARIO='"+label_18.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
	nombrePart=label_7.getText();
			}
		});
		btnConexin_7.setBounds(438, 347, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnConexin_7);
		
		final JButton btnConexin_8 = new JButton("Conexi\u00F3n");
		btnConexin_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConexin_8.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnConexin_8.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnConexin_8.setFont(mf.MyFont(0,12));
		btnConexin_8.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnConexin_8.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConexin_8.setContentAreaFilled(false);
		btnConexin_8.setBorderPainted(false);
		btnConexin_8.setForeground(Color.WHITE);
		btnConexin_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_8.getText()+"' AND USUARIO='"+label_19.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_8.getText()+"' AND USUARIO='"+label_19.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_8.getText()+"' AND USUARIO='"+label_19.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
	if (JOptionPane.NO_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_8.getText()+"' AND USUARIO='"+label_19.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_PUBLICA");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_8.getText()+"' AND USUARIO='"+label_19.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_8.getText()+"' AND USUARIO='"+label_19.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
				
	nombrePart=label_8.getText();		
	
			}
		});
		btnConexin_8.setBounds(438, 389, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnConexin_8);
		
		final JButton btnConexin_9 = new JButton("Conexi\u00F3n");
		btnConexin_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnConexin_9.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnConexin_9.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnConexin_9.setFont(mf.MyFont(0,12));
		btnConexin_9.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnConexin_9.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConexin_9.setContentAreaFilled(false);
		btnConexin_9.setBorderPainted(false);
		btnConexin_9.setForeground(Color.WHITE);
		btnConexin_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				
				int jmax=0;
				int jdentro=0;
				String password="";
				int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"¿Compartes la red con el master?.",
						"¡Atención!", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Si",
								"No" }, // null para YES, NO y CANCEL
						"opcion 1");
				if (JOptionPane.YES_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_9.getText()+"' AND USUARIO='"+label_20.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_LOCAL");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_9.getText()+"' AND USUARIO='"+label_20.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_9.getText()+"' AND USUARIO='"+label_20.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
	if (JOptionPane.NO_OPTION == seleccion) {
					
					try {
						ResultSet rs=tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+label_9.getText()+"' AND USUARIO='"+label_20.getText()+"'");
						while(rs.next()){
							
							ip=rs.getString("IP_PUBLICA");
							jmax=rs.getInt("JUGADORESMAX");
							jdentro=rs.getInt("JUGADORES");
							password=rs.getString("CONTRASEÑA");
						
							if(jdentro<jmax){
								
								if(password != null){
								
									String seleccion3 = JOptionPane.showInputDialog(
									   frmHistoriasDeZagas,
									   "Introduce la contraseña",
									   JOptionPane.PLAIN_MESSAGE);  // el icono sera un iterrogante
								
									if(seleccion3.equals(password)){
										
										VentanaJugadores window=new VentanaJugadores();
										window.getFrame().setVisible(true);
										tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_9.getText()+"' AND USUARIO='"+label_20.getText()+"'");
										frmHistoriasDeZagas.dispose();
										
									}
									else{
										
										int seleccion2 = JOptionPane.showOptionDialog(
												frmHistoriasDeZagas,
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
									tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+jdentro+1+" WHERE NOMBRE='"+label_9.getText()+"' AND USUARIO='"+label_20.getText()+"'");
									frmHistoriasDeZagas.dispose();
									
								}
							}
							else{
								
								int seleccion2 = JOptionPane.showOptionDialog(
										frmHistoriasDeZagas,
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
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
				
	nombrePart=label.getText();
			}
		});
		btnConexin_9.setBounds(438, 431, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnConexin_9);
		
		final JButton button_9 = new JButton("");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_9.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/boton atras2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_9.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/boton atras.png")));
			}
		});
		button_9.setFont(mf.MyFont(0,12));
		button_9.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/boton atras.png")));
		button_9.setContentAreaFilled(false);
		button_9.setBorderPainted(false);
		button_9.setForeground(Color.WHITE);
		button_9.setEnabled(false);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				partidas-=10;
				
				if(partidas-9 < nombre.size() && partidas-9 >= 0){
				label.setText(nombre.get(partidas-9));
				label_11.setText(masters.get(partidas-9));
				}
				else{
					label.setText("");
					label_11.setText("");
				}
				if(partidas-8 < nombre.size() && partidas-8 >= 0){
				label_1.setText(nombre.get(partidas-8));
				label_12.setText(masters.get(partidas-8));}
				else{
					label_1.setText("");
					label_12.setText("");
				}
				if(partidas-7 < nombre.size() && partidas-7 >= 0){
				label_2.setText(nombre.get(partidas-7));
				label_13.setText(masters.get(partidas-7));}
				else{
					label_2.setText("");
					label_13.setText("");
					
				}
				if(partidas-6 < nombre.size() && partidas-6 >= 0){
				label_3.setText(nombre.get(partidas-6));
				label_14.setText(masters.get(partidas-6));}
				else{
					label_3.setText("");
					label_14.setText("");
					
				}
				if(partidas-5 < nombre.size() && partidas-5 >= 0){
				label_4.setText(nombre.get(partidas-5));
				label_15.setText(masters.get(partidas-5));}
				else{
					label_4.setText("");
					label_15.setText("");
				}
				if(partidas-4 < nombre.size() && partidas-4 >= 0){
				label_5.setText(nombre.get(partidas-4));
				label_16.setText(masters.get(partidas-4));}
				else{
					label_5.setText("");
					label_16.setText("");
				}
				if(partidas-3 < nombre.size() && partidas-3 >= 0){
				label_6.setText(nombre.get(partidas-3));
				label_17.setText(masters.get(partidas-3));}
				else{
					label_6.setText("");
					label_17.setText("");
				}
				if(partidas-2 < nombre.size() && partidas-2 >= 0){
				label_7.setText(nombre.get(partidas-2));
				label_18.setText(masters.get(partidas-2));}
				else{
					label_7.setText("");
					label_18.setText("");
				}
				if(partidas-1 < nombre.size() && partidas-1 >= 0){
				label_8.setText(nombre.get(partidas-1));
				label_19.setText(masters.get(partidas-1));}
				else{
					label_8.setText("");
					label_19.setText("");
				}
				if(partidas < nombre.size() && partidas >= 0){
				label_9.setText(nombre.get(partidas));
				label_20.setText(masters.get(partidas));}
				else{
					label_9.setText("");
					label_20.setText("");
				}
			
			if(partidas==9){
				button_9.setEnabled(false);
			}
			
			}
		});
		button_9.setBounds(10, 519, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_9.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/boton continuar2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_9.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/boton continuar.png")));
			}
		});
		button_10.setFont(mf.MyFont(0,12));
		button_10.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/boton continuar.png")));
		button_10.setContentAreaFilled(false);
		button_10.setBorderPainted(false);
		button_10.setForeground(Color.WHITE);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		
					if(partidas+1 < nombre.size()){
					label.setText(nombre.get(partidas+1));
					label_11.setText(masters.get(partidas+1));
					}
					else{
						label.setText("");
						label_11.setText("");
					}
					if(partidas+2 < nombre.size()){
					label_1.setText(nombre.get(partidas+2));
					label_12.setText(masters.get(partidas+2));}
					else{
						label_1.setText("");
						label_12.setText("");
					}
					if(partidas+3 < nombre.size()){
					label_2.setText(nombre.get(partidas+3));
					label_13.setText(masters.get(partidas+3));
					}
					else{
						label_2.setText("");
						label_13.setText("");
					}
					if(partidas+4 < nombre.size()){
					label_3.setText(nombre.get(partidas+4));
					label_14.setText(masters.get(partidas+4));}
					else{
						label_3.setText("");
						label_14.setText("");
						
					}
					if(partidas+5 < nombre.size()){
					label_4.setText(nombre.get(partidas+5));
					label_15.setText(masters.get(partidas+5));}
					else{
						label_4.setText("");
						label_15.setText("");
						
					}
					if(partidas+6 < nombre.size()){
					label_5.setText(nombre.get(partidas+6));
					label_16.setText(masters.get(partidas+6));}
					else{
						label_5.setText("");
						label_16.setText("");
						
					}
					if(partidas+7 < nombre.size()){
					label_6.setText(nombre.get(partidas+7));
					label_17.setText(masters.get(partidas+7));}
					else{
						label_6.setText("");
						label_17.setText("");
					}
					if(partidas+8 < nombre.size()){
					label_7.setText(nombre.get(partidas+8));
					label_18.setText(masters.get(partidas+8));}
					else{
						label_7.setText("");
						label_18.setText("");
						
					}
					if(partidas+9 < nombre.size()){
					label_8.setText(nombre.get(partidas+9));
					label_19.setText(masters.get(partidas+9));}
					else{
						label_8.setText("");
						label_19.setText("");
					}
					if(partidas+10 < nombre.size()){
					label_9.setText(nombre.get(partidas+10));
					label_20.setText(masters.get(partidas+10));}
					else{
						label_9.setText("");
						label_20.setText("");
					}
					partidas+=10;
				
				button_9.setEnabled(true);
			}
		});
		button_10.setBounds(438, 519, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(button_10);
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnVolver.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnVolver.setFont(mf.MyFont(0,12));
		btnVolver.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmHistoriasDeZagas.dispose();
				Jugar window=new Jugar();
				window.getFrmHistoriasDeZagas().setVisible(true);
				
			}
		});
		btnVolver.setBounds(763, 519, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnVolver);
		
		JLabel lblUsuario = new JLabel("Master:");
		lblUsuario.setFont(mf.MyFont(0,12));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(146, 11, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(lblUsuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(593, 53, 281, 455);
		frmHistoriasDeZagas.getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
		
		final JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnActualizar.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnActualizar.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
			}
		});
		btnActualizar.setFont(mf.MyFont(0,12));
		btnActualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnActualizar.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/botones-inicio-ayuda.png")));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setBorderPainted(false);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nombre.clear();
				masters.clear();
				ResultSet rs;
				try {
					rs = tabla.executeQuery("SELECT * FROM PARTIDAS");
					while(rs.next()){
						
						nombre.add(rs.getString("NOMBRE"));
						masters.add(rs.getString("USUARIO"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				partidas=9;
				if(0 < nombre.size()){
					label.setText(nombre.get(0));
					label_11.setText(masters.get(0));
					
					}
					else{
						label.setText("");
						label_11.setText("");
					}
					if(1 < nombre.size()){
					label_1.setText(nombre.get(1));
					label_12.setText(masters.get(1));
					}
					
					else{
						label_1.setText("");
						label_12.setText("");
					}
					if(2 < nombre.size()){
					label_2.setText(nombre.get(2));
					label_13.setText(masters.get(2));
					}
					else{
						label_2.setText("");
						label_13.setText("");
					}
					if(3 < nombre.size()){
					label_3.setText(nombre.get(3));
					label_14.setText(masters.get(3));}
					else{
						label_3.setText("");
						label_14.setText("");
					}
					if(4 < nombre.size()){
					label_4.setText(nombre.get(4));
					label_15.setText(masters.get(4));}
					else{
						label_4.setText("");
						label_15.setText("");
						
					}
					if(5 < nombre.size()){
					label_5.setText(nombre.get(5));
					label_16.setText(masters.get(5));}
					else{
						label_5.setText("");
						label_16.setText("");
					}
					if(6 < nombre.size()){
					label_6.setText(nombre.get(6));
					label_17.setText(masters.get(6));}
					else{
						label_6.setText("");
						label_17.setText("");
					}
					if(7 < nombre.size()){
					label_7.setText(nombre.get(7));
					label_18.setText(masters.get(7));}
					else{
						label_7.setText("");
						label_18.setText("");
					}
					if(8 < nombre.size()){
					label_8.setText(nombre.get(8));
					label_19.setText(masters.get(8));}
					else{
						label_8.setText("");
						label_19.setText("");
					}
					if(9 < nombre.size()){
					label_9.setText(nombre.get(9));
					label_20.setText(masters.get(9));}
					else{
						label_9.setText("");
						label_20.setText("");
					}
				
					button_9.setEnabled(false);
				
			}
		});
		btnActualizar.setBounds(219, 519, 111, 31);
		frmHistoriasDeZagas.getContentPane().add(btnActualizar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BuscarPartida.class.getResource("/images/background-buscarp.jpg")));
		lblNewLabel.setBounds(0, 0, 884, 561);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
		
		
			
		if(0 < nombre.size()){
		label.setText(nombre.get(0));
		label_11.setText(masters.get(0));
		
		}
		else{
			label.setText("");
			label_11.setText("");
		}
		if(1 < nombre.size()){
		label_1.setText(nombre.get(1));
		label_12.setText(masters.get(1));
		}
		
		else{
			label_1.setText("");
			label_12.setText("");
		}
		if(2 < nombre.size()){
		label_2.setText(nombre.get(2));
		label_13.setText(masters.get(2));
		}
		else{
			label_2.setText("");
			label_13.setText("");
		}
		if(3 < nombre.size()){
		label_3.setText(nombre.get(3));
		label_14.setText(masters.get(3));}
		else{
			label_3.setText("");
			label_14.setText("");
		}
		if(4 < nombre.size()){
		label_4.setText(nombre.get(4));
		label_15.setText(masters.get(4));}
		else{
			label_4.setText("");
			label_15.setText("");
			
		}
		if(5 < nombre.size()){
		label_5.setText(nombre.get(5));
		label_16.setText(masters.get(5));}
		else{
			label_5.setText("");
			label_16.setText("");
		}
		if(6 < nombre.size()){
		label_6.setText(nombre.get(6));
		label_17.setText(masters.get(6));}
		else{
			label_6.setText("");
			label_17.setText("");
		}
		if(7 < nombre.size()){
		label_7.setText(nombre.get(7));
		label_18.setText(masters.get(7));}
		else{
			label_7.setText("");
			label_18.setText("");
		}
		if(8 < nombre.size()){
		label_8.setText(nombre.get(8));
		label_19.setText(masters.get(8));}
		else{
			label_8.setText("");
			label_19.setText("");
		}
		if(9 < nombre.size()){
		label_9.setText(nombre.get(9));
		label_20.setText(masters.get(9));}
		else{
			label_9.setText("");
			label_20.setText("");
		}

	}
}
