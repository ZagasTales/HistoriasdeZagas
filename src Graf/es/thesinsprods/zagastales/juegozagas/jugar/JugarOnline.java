package es.thesinsprods.zagastales.juegozagas.jugar;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.ImageIcon;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.Characters;
import es.thesinsprods.zagastales.characters.OutOfPointsException;
import es.thesinsprods.zagastales.characters.atributes.AtributeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.atributes.AtributePoints;
import es.thesinsprods.zagastales.characters.atributes.Atributes;
import es.thesinsprods.zagastales.characters.blessings.Blessing;
import es.thesinsprods.zagastales.characters.equipment.Accesories;
import es.thesinsprods.zagastales.characters.equipment.Armor;
import es.thesinsprods.zagastales.characters.equipment.Cloak;
import es.thesinsprods.zagastales.characters.equipment.Earrings;
import es.thesinsprods.zagastales.characters.equipment.Equipment;
import es.thesinsprods.zagastales.characters.equipment.Misc;
import es.thesinsprods.zagastales.characters.equipment.Necklace;
import es.thesinsprods.zagastales.characters.equipment.OneHanded;
import es.thesinsprods.zagastales.characters.equipment.Pole;
import es.thesinsprods.zagastales.characters.equipment.Possesions;
import es.thesinsprods.zagastales.characters.equipment.Ranged;
import es.thesinsprods.zagastales.characters.equipment.Rings;
import es.thesinsprods.zagastales.characters.equipment.Shields;
import es.thesinsprods.zagastales.characters.equipment.TwoHanded;
import es.thesinsprods.zagastales.characters.equipment.Weapons;
import es.thesinsprods.zagastales.characters.privileges.PrivilegeOutOfBoundsException;
import es.thesinsprods.zagastales.characters.privileges.Privileges;
import es.thesinsprods.zagastales.characters.privileges.Setbacks;
import es.thesinsprods.zagastales.characters.race.Race;
import es.thesinsprods.zagastales.characters.skills.CombatSkills;
import es.thesinsprods.zagastales.characters.skills.KnowHowSkills;
import es.thesinsprods.zagastales.characters.skills.KnowledgeSkills;
import es.thesinsprods.zagastales.characters.skills.MagicSkills;
import es.thesinsprods.zagastales.characters.skills.SkillOutOfBoundsException;
import es.thesinsprods.zagastales.characters.skills.SkillPoints;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;
import es.thesinsprods.zagastales.juegozagas.jugar.VentanaJugadores.IncomingReader;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JToggleButton;
import java.awt.Canvas;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JugarOnline {

	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	public static JFrame frmHistoriasDeZagas;
	 String username, address = "";
	    ArrayList<String> users = new ArrayList();
	    int port = 2222;
	    Boolean isConnected = false;
	    
	    Socket sock;
	    BufferedReader reader;
	    PrintWriter writer;
		final JTextArea textArea = new JTextArea();
	MorpheusFont mf=new MorpheusFont();
	public static Characters personaje1=null;
	public static Characters personaje2=null;
	public static Characters personaje3=null;
	public static Characters personaje4=null;
	public static Characters personaje5=null;
	public static Characters personaje6=null;
	public static Characters personaje7=null;
	public static Characters personaje8=null;
	public static Characters personaje9=null;
	public static Characters personaje10=null;
	public static Characters npc1=null;
	public static Characters npc2=null;
	public static Characters npc3=null;
	public static Characters npc4=null;
	public static Characters npc5=null;
	public static Characters npc6=null;
	public static Characters npc7=null;
	public static Characters npc8=null;
	public static Characters npc9=null;
	public static Characters npc10=null;
	private JTextField textField;
	private JTextField textField_1;
	
	
	  public class IncomingReader implements Runnable
	    {
	        @Override
	        public void run() 
	        {
	            String[] data;
	            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

	            try 
	            {
	                while ((stream = reader.readLine()) != null) 
	                {
	                     data = stream.split(":");

	                     if (data[2].equals(chat)) 
	                     {
	                        textArea.append(data[0] + ": " + data[1] + "\n");
	                        textArea.setCaretPosition(textArea.getDocument().getLength());
	                     } 
	                     else if (data[2].equals(connect))
	                     {
	                        textArea.removeAll();
	                        userAdd(data[0]);
	                     } 
	                     else if (data[2].equals(disconnect)) 
	                     {
	                         userRemove(data[0]);
	                     } 
	                     else if (data[2].equals(done)) 
	                     {
	                        //users.setText("");
	                        writeUsers();
	                        users.clear();
	                     }
	                }
	           }catch(Exception ex) { }
	        }
	    }
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JugarOnline window = new JugarOnline();
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
	 */
	public JugarOnline() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
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
		frmHistoriasDeZagas = new JFrame();
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(JugarOnline.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setBounds(100, 100, 900, 720);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
	
		final ConexionDBOnline con = new ConexionDBOnline();
		final Connection p = con.accederDB();
		final Statement tabla=p.createStatement();
		
		InetAddress thisIp;
		thisIp = InetAddress.getLocalHost();
		address = thisIp.getHostAddress().toString();
		
		Conectar();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 894, 26);
		frmHistoriasDeZagas.getContentPane().add(menuBar);
		
		JMenu mnCargar = new JMenu("Cargar");
		menuBar.add(mnCargar);
		
		JMenuItem mntmPersonaje = new JMenuItem("Personaje");
		
		mnCargar.add(mntmPersonaje);
		
		JMenuItem mntmNpc = new JMenuItem("NPC");
		
		mnCargar.add(mntmNpc);
		
		JMenuItem mntmNpcGenrico = new JMenuItem("NPC Gen\u00E9rico");
		mnCargar.add(mntmNpcGenrico);
		
		JMenuItem mntmNpcAleatorio = new JMenuItem("NPC Aleatorio");
		mnCargar.add(mntmNpcAleatorio);
		
		JButton button_30 = new JButton("");
		button_30.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/botonayudajugar1.png")));
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(button_30);
		button_30.setBorderPainted(false);
		button_30.setContentAreaFilled(false);
		button_30.setFocusPainted(false);
		button_30.setOpaque(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(618, 22, 276, 669);
		frmHistoriasDeZagas.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Personajes", null, panel, null);
		panel.setLayout(null);
	
		final JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button.setOpaque(false);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBounds(46, 11, 179, 32);
		panel.add(button);
		
		final JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_1.setOpaque(false);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBounds(46, 61, 179, 32);
		panel.add(button_1);
		
		final JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_2.setOpaque(false);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		button_2.setBounds(46, 111, 179, 32);
		panel.add(button_2);
		
		final JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_3.setOpaque(false);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_3.setContentAreaFilled(false);
		button_3.setBorder(null);
		button_3.setBounds(46, 161, 179, 32);
		panel.add(button_3);
		
		final JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_4.setOpaque(false);
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_4.setContentAreaFilled(false);
		button_4.setBorder(null);
		button_4.setBounds(46, 211, 179, 32);
		panel.add(button_4);
		
		final JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_5.setOpaque(false);
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_5.setContentAreaFilled(false);
		button_5.setBorder(null);
		button_5.setBounds(46, 261, 179, 32);
		panel.add(button_5);
		
		final JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_6.setOpaque(false);
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_6.setContentAreaFilled(false);
		button_6.setBorder(null);
		button_6.setBounds(46, 311, 179, 32);
		panel.add(button_6);
		
		final JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_7.setOpaque(false);
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_7.setContentAreaFilled(false);
		button_7.setBorder(null);
		button_7.setBounds(46, 361, 179, 32);
		panel.add(button_7);
		
		final JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_8.setOpaque(false);
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_8.setContentAreaFilled(false);
		button_8.setBorder(null);
		button_8.setBounds(46, 411, 179, 32);
		panel.add(button_8);
		
		final JButton button_9 = new JButton("");
		button_9.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_9.setOpaque(false);
		button_9.setHorizontalTextPosition(SwingConstants.CENTER);
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_9.setContentAreaFilled(false);
		button_9.setBorder(null);
		button_9.setBounds(46, 461, 179, 32);
		panel.add(button_9);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("NPC's", null, panel_1, null);
		panel_1.setLayout(null);
		
		final JButton button_10 = new JButton("");
		button_10.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_10.setOpaque(false);
		button_10.setHorizontalTextPosition(SwingConstants.CENTER);
		button_10.setForeground(Color.WHITE);
		button_10.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_10.setContentAreaFilled(false);
		button_10.setBorder(null);
		button_10.setBounds(46, 11, 179, 32);
		panel_1.add(button_10);
		
		final JButton button_11 = new JButton("");
		button_11.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_11.setOpaque(false);
		button_11.setHorizontalTextPosition(SwingConstants.CENTER);
		button_11.setForeground(Color.WHITE);
		button_11.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_11.setContentAreaFilled(false);
		button_11.setBorder(null);
		button_11.setBounds(46, 61, 179, 32);
		panel_1.add(button_11);
		
		final JButton button_12 = new JButton("");
		button_12.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_12.setOpaque(false);
		button_12.setHorizontalTextPosition(SwingConstants.CENTER);
		button_12.setForeground(Color.WHITE);
		button_12.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_12.setContentAreaFilled(false);
		button_12.setBorder(null);
		button_12.setBounds(46, 111, 179, 32);
		panel_1.add(button_12);
		
		final JButton button_13 = new JButton("");
		button_13.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_13.setOpaque(false);
		button_13.setHorizontalTextPosition(SwingConstants.CENTER);
		button_13.setForeground(Color.WHITE);
		button_13.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_13.setContentAreaFilled(false);
		button_13.setBorder(null);
		button_13.setBounds(46, 161, 179, 32);
		panel_1.add(button_13);
		
		final JButton button_14 = new JButton("");
		button_14.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_14.setOpaque(false);
		button_14.setHorizontalTextPosition(SwingConstants.CENTER);
		button_14.setForeground(Color.WHITE);
		button_14.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_14.setContentAreaFilled(false);
		button_14.setBorder(null);
		button_14.setBounds(46, 211, 179, 32);
		panel_1.add(button_14);
		
		final JButton button_15 = new JButton("");
		button_15.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_15.setOpaque(false);
		button_15.setHorizontalTextPosition(SwingConstants.CENTER);
		button_15.setForeground(Color.WHITE);
		button_15.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_15.setContentAreaFilled(false);
		button_15.setBorder(null);
		button_15.setBounds(46, 261, 179, 32);
		panel_1.add(button_15);
		
		final JButton button_16 = new JButton("");
		button_16.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_16.setOpaque(false);
		button_16.setHorizontalTextPosition(SwingConstants.CENTER);
		button_16.setForeground(Color.WHITE);
		button_16.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_16.setContentAreaFilled(false);
		button_16.setBorder(null);
		button_16.setBounds(46, 311, 179, 32);
		panel_1.add(button_16);
		
		final JButton button_17 = new JButton("");
		button_17.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_17.setOpaque(false);
		button_17.setHorizontalTextPosition(SwingConstants.CENTER);
		button_17.setForeground(Color.WHITE);
		button_17.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_17.setContentAreaFilled(false);
		button_17.setBorder(null);
		button_17.setBounds(46, 361, 179, 32);
		panel_1.add(button_17);
		
		final JButton button_18 = new JButton("");
		button_18.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_18.setOpaque(false);
		button_18.setHorizontalTextPosition(SwingConstants.CENTER);
		button_18.setForeground(Color.WHITE);
		button_18.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_18.setContentAreaFilled(false);
		button_18.setBorder(null);
		button_18.setBounds(46, 411, 179, 32);
		panel_1.add(button_18);
		
		final JButton button_19 = new JButton("");
		button_19.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_19.setOpaque(false);
		button_19.setHorizontalTextPosition(SwingConstants.CENTER);
		button_19.setForeground(Color.WHITE);
		button_19.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_19.setContentAreaFilled(false);
		button_19.setBorder(null);
		button_19.setBounds(46, 461, 179, 32);
		panel_1.add(button_19);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("NPC's Genéricos", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton button_20 = new JButton("");
		button_20.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_20.setOpaque(false);
		button_20.setHorizontalTextPosition(SwingConstants.CENTER);
		button_20.setForeground(Color.WHITE);
		button_20.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_20.setContentAreaFilled(false);
		button_20.setBorder(null);
		button_20.setBounds(46, 11, 179, 32);
		panel_2.add(button_20);
		
		JButton button_21 = new JButton("");
		button_21.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_21.setOpaque(false);
		button_21.setHorizontalTextPosition(SwingConstants.CENTER);
		button_21.setForeground(Color.WHITE);
		button_21.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_21.setContentAreaFilled(false);
		button_21.setBorder(null);
		button_21.setBounds(46, 61, 179, 32);
		panel_2.add(button_21);
		
		JButton button_22 = new JButton("");
		button_22.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_22.setOpaque(false);
		button_22.setHorizontalTextPosition(SwingConstants.CENTER);
		button_22.setForeground(Color.WHITE);
		button_22.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_22.setContentAreaFilled(false);
		button_22.setBorder(null);
		button_22.setBounds(46, 111, 179, 32);
		panel_2.add(button_22);
		
		JButton button_23 = new JButton("");
		button_23.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_23.setOpaque(false);
		button_23.setHorizontalTextPosition(SwingConstants.CENTER);
		button_23.setForeground(Color.WHITE);
		button_23.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_23.setContentAreaFilled(false);
		button_23.setBorder(null);
		button_23.setBounds(46, 161, 179, 32);
		panel_2.add(button_23);
		
		JButton button_24 = new JButton("");
		button_24.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_24.setOpaque(false);
		button_24.setHorizontalTextPosition(SwingConstants.CENTER);
		button_24.setForeground(Color.WHITE);
		button_24.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_24.setContentAreaFilled(false);
		button_24.setBorder(null);
		button_24.setBounds(46, 211, 179, 32);
		panel_2.add(button_24);
		
		JButton button_25 = new JButton("");
		button_25.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_25.setOpaque(false);
		button_25.setHorizontalTextPosition(SwingConstants.CENTER);
		button_25.setForeground(Color.WHITE);
		button_25.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_25.setContentAreaFilled(false);
		button_25.setBorder(null);
		button_25.setBounds(46, 261, 179, 32);
		panel_2.add(button_25);
		
		JButton button_26 = new JButton("");
		button_26.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_26.setOpaque(false);
		button_26.setHorizontalTextPosition(SwingConstants.CENTER);
		button_26.setForeground(Color.WHITE);
		button_26.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_26.setContentAreaFilled(false);
		button_26.setBorder(null);
		button_26.setBounds(46, 311, 179, 32);
		panel_2.add(button_26);
		
		JButton button_27 = new JButton("");
		button_27.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_27.setOpaque(false);
		button_27.setHorizontalTextPosition(SwingConstants.CENTER);
		button_27.setForeground(Color.WHITE);
		button_27.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_27.setContentAreaFilled(false);
		button_27.setBorder(null);
		button_27.setBounds(46, 361, 179, 32);
		panel_2.add(button_27);
		
		JButton button_28 = new JButton("");
		button_28.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_28.setOpaque(false);
		button_28.setHorizontalTextPosition(SwingConstants.CENTER);
		button_28.setForeground(Color.WHITE);
		button_28.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_28.setContentAreaFilled(false);
		button_28.setBorder(null);
		button_28.setBounds(46, 411, 179, 32);
		panel_2.add(button_28);
		
		JButton button_29 = new JButton("");
		button_29.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_29.setOpaque(false);
		button_29.setHorizontalTextPosition(SwingConstants.CENTER);
		button_29.setForeground(Color.WHITE);
		button_29.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_29.setContentAreaFilled(false);
		button_29.setBorder(null);
		button_29.setBounds(46, 461, 179, 32);
		panel_2.add(button_29);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 320, 621, 371);
		frmHistoriasDeZagas.getContentPane().add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("General", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 613, 310);
		panel_3.add(scrollPane);
		

		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					

					

					//GEN-FIRST:event_b_sendActionPerformed
			        String nothing = "";
			        if ((textField.getText()).equals(nothing)) {
			            textField.setText("");
			            textField.requestFocus();
			        } else {
			            try {
			               writer.println(username + ":" + textField.getText() + ":" + "Chat");
			               writer.flush(); // flushes the buffer
			            } catch (Exception ex) {
			                textArea.append("Mensaje no enviado. \n");
			            }
			            textField.setText("");
			            textField.requestFocus();
			        }

			        textField.setText("");
			        textField.requestFocus();
			    
				
				
					
				}
				
			}
		});
		textField.setBounds(0, 310, 444, 35);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				//GEN-FIRST:event_b_sendActionPerformed
		        String nothing = "";
		        if ((textField.getText()).equals(nothing)) {
		            textField.setText("");
		            textField.requestFocus();
		        } else {
		            try {
		               writer.println(username + ":" + textField.getText() + ":" + "Chat");
		               writer.flush(); // flushes the buffer
		            } catch (Exception ex) {
		                textArea.append("Mensaje no enviado. \n");
		            }
		            textField.setText("");
		            textField.requestFocus();
		        }

		        textField.setText("");
		        textField.requestFocus();
		    
			
			}
		});
		btnNewButton.setBounds(443, 310, 86, 35);
		panel_3.add(btnNewButton);
		
		JButton btnConfig = new JButton("Config");
		btnConfig.setBounds(527, 310, 86, 35);
		panel_3.add(btnConfig);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Sistema", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 613, 310);
		panel_4.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(0, 310, 444, 35);
		panel_4.add(textField_1);
		
		JButton button_31 = new JButton("Enviar");
		button_31.setBounds(443, 310, 86, 35);
		panel_4.add(button_31);
		
		JButton button_32 = new JButton("Config");
		button_32.setBounds(527, 310, 86, 35);
		panel_4.add(button_32);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 26, 207, 283);
		frmHistoriasDeZagas.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tiradas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 207, 46);
		panel_5.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Tiradas Enfrentadas");
		btnNewButton_1.setBounds(10, 70, 187, 31);
		panel_5.add(btnNewButton_1);
		
		JButton btnTiradasAleatorias = new JButton("Tiradas Aleatorias");
		btnTiradasAleatorias.setBounds(10, 130, 187, 31);
		panel_5.add(btnTiradasAleatorias);
		
		JButton btnTiradasDeImpacto = new JButton("Tiradas de Impacto");
		btnTiradasDeImpacto.setBounds(10, 190, 187, 31);
		panel_5.add(btnTiradasDeImpacto);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(205, 26, 207, 283);
		frmHistoriasDeZagas.getContentPane().add(panel_6);
		
		JLabel lblEstatus = new JLabel("Estatus");
		lblEstatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstatus.setBounds(0, 0, 207, 46);
		panel_6.add(lblEstatus);
		
		JButton btnModificarSem = new JButton("Modificar S/E/M");
		btnModificarSem.setBounds(10, 70, 187, 31);
		panel_6.add(btnModificarSem);
		
		JButton btnAlterarEstado = new JButton("Alterar Estado");
		btnAlterarEstado.setBounds(10, 130, 187, 31);
		panel_6.add(btnAlterarEstado);
		
		JButton btnModificarEquipo = new JButton("Modificar Equipo");
		btnModificarEquipo.setBounds(10, 190, 187, 31);
		panel_6.add(btnModificarEquipo);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(414, 26, 207, 283);
		frmHistoriasDeZagas.getContentPane().add(panel_7);
		
		JLabel label_1 = new JLabel("???");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 0, 207, 46);
		panel_7.add(label_1);
		
		JButton btnDarExperiencia = new JButton("Dar Experiencia");
		btnDarExperiencia.setBounds(10, 70, 187, 31);
		panel_7.add(btnDarExperiencia);
		
		JButton btnDarAtributos = new JButton("Dar Atributos");
		btnDarAtributos.setBounds(10, 130, 187, 31);
		panel_7.add(btnDarAtributos);
		
		JButton btnDarHabilidades = new JButton("Dar Habilidades");
		btnDarHabilidades.setBounds(10, 190, 187, 31);
		panel_7.add(btnDarHabilidades);
		
	
		mntmPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				try {
					ResultSet rs = tabla.executeQuery("SELECT * FROM PERSONAJE");
					ArrayList <Object> personajes=new ArrayList<Object>();
					while (rs.next()){
						
						personajes.add(rs.getString("NOMBRE"));
						
					}
					
					Object[] personaje=personajes.toArray();
					Object seleccion = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Seleccione opcion",
							"Cargar Personaje", JOptionPane.PLAIN_MESSAGE,
							null,personaje,null);
					
					rs=tabla.executeQuery("SELECT * FROM PERSONAJE WHERE NOMBRE='"+seleccion+"'");
					Armor armor = null;
					Weapons weapon1 = null;
					Weapons weapon2 = null;
					Weapons weapon3= null;
					Weapons weapon4= null;
					Misc misc1 = null;
					Misc misc2= null;
					Misc misc3= null;
					Misc misc4= null;
					Accesories accesorie1= null;
					Accesories accesorie2= null;
					Accesories accesorie3= null;
					Accesories accesorie4= null;
					
					String armadura = "";
					 String descripcionArm = "";
					 String posesionArm = "";
					 String prop1Arm = "";
					 String prop2Arm = "";
					 String prop3Arm = "";
					 String weap1 = "";
					 String descripcionWeap1 = "";
					 String posesionWeap1 = "";
					 String prop1Weap1 = "";
					 String prop2Weap1 = "";
					 String prop3Weap1 = "";
					 String weap2 = "";
					 String descripcionWeap2 = "";
					 String posesionWeap2 = "";
					 String prop1Weap2 = "";
					 String prop2Weap2 = "";
					 String prop3Weap2 = "";
					 String weap3 = "";
					 String descripcionWeap3 = "";
					 String posesionWeap3 = "";
					 String prop1Weap3 = "";
					 String prop2Weap3 = "";
					 String prop3Weap3 = "";
					 String weap4 = "";
					 String descripcionWeap4 = "";
					 String posesionWeap4 = "";
					 String prop1Weap4 = "";
					 String prop2Weap4 = "";
					 String prop3Weap4 = "";
					 String obj1 = "";
					 String descripcionObj1 = "";
					 String posesionObj1 = "";
					 String prop1Obj1 = "";
					 String prop2Obj1 = "";
					 String prop3Obj1 = "";
					 String obj2 = "";
					 String descripcionObj2 = "";
					 String posesionObj2 = "";
					 String prop1Obj2 = "";
					 String prop2Obj2 = "";
					 String prop3Obj2 = "";
					 String obj3 = "";
					 String descripcionObj3 = "";
					 String posesionObj3 = "";
					 String prop1Obj3 = "";
					 String prop2Obj3 = "";
					 String prop3Obj3 = "";
					 String obj4 = "";
					 String descripcionObj4 = "";
					 String posesionObj4 = "";
					 String prop1Obj4 = "";
					 String prop2Obj4 = "";
					 String prop3Obj4 = "";
					 String acc1 = "";
					 String descripcionAcc1 = "";
					 String posesionAcc1 = "";
					 String prop1Acc1 = "";
					 String prop2Acc1 = "";
					 String prop3Acc1 = "";
					 String acc2 = "";
					 String descripcionAcc2 = "";
					 String posesionAcc2 = "";
					 String prop1Acc2 = "";
					 String prop2Acc2 = "";
					 String prop3Acc2 = "";
					 String acc3 = "";
					 String descripcionAcc3 = "";
					 String posesionAcc3 = "";
					 String prop1Acc3 = "";
					 String prop2Acc3 = "";
					 String prop3Acc3 = "";
					 String acc4 = "";
					 String descripcionAcc4 = "";
					 String posesionAcc4 = "";
					 String prop1Acc4 = "";
					 String prop2Acc4 = "";
					 String prop3Acc4 = "";
					 String tipoWeap1 = "";
					 String tipoWeap2 = "";
					 String tipoWeap3 = "";
					 String tipoWeap4 = "";
					 String tipoAcc1 = "";
					 String tipoAcc2 = "";
					 String tipoAcc3 = "";
					 String tipoAcc4 = "";
					 String arrojadizaWeap1 = "";
					 String arrojadizaWeap2 = "";
					 String arrojadizaWeap3 = "";
					 String arrojadizaWeap4 = "";
					
					 String poderes="";
					 String extras= "";
					 String modificadores="";
					 String nombre = "";
						int edad = 0;
						String raza = "";
						String descripcionF = "";
						String bendicion = "";
						String privilegio1 = "";
						String privilegio2 = "";
						String privilegio3 = "";
						String privilegio4 = "";
						String privilegio5 = "";
						String reves1 = "";
						String reves2 = "";
						String reves3 = "";
						String reves4 = "";
						int fuerza = 0;
						int destreza = 0;
						int resistencia = 0;
						int resistenciaM = 0;
						int inteligencia = 0;
						int percepcion = 0;
						int carisma = 0;
						int unamano = 0;
						int dosmanos = 0;
						int asta = 0;
						int distancia = 0;
						int esquivar = 0;
						int bloquear = 0;
						int arteGuerra = 0;
						int diplomacia = 0;
						int etiqueta = 0;
						int medicina = 0;
						int ocultismo = 0;
						int investigacion = 0;
						int negociacion = 0;
						int cSecretos = 0;
						int fuego = 0;
						int agua = 0;
						int tierra = 0;
						int viento = 0;
						int druidica = 0;
						int blanca = 0;
						int negra = 0;
						int arcana = 0;
						int atletismo = 0;
						int supervivencia = 0;
						int equitacion = 0;
						int trampas = 0;
						int sigilo = 0;

						int salud = 0;
						int mana = 0;
						int energia = 0;
						int experiencia = 0;
						int sino = 0;
						int nivel = 0;

						extras="";
						int dinero = 0;
						modificadores="";
						poderes="";
						int exptotal=0;
						int campeon = 0;
						
								while (rs.next()) {
							nombre = rs.getString("NOMBRE");
							edad = rs.getInt("EDAD");
							raza = rs.getString("RAZA");
							descripcionF = rs.getString("DESCRIPCION_FISICA");
							;
							bendicion = rs.getString("BENDICION");
							privilegio1 = rs.getString("PRIVILEGIO1");
							privilegio2 = rs.getString("PRIVILEGIO2");
							privilegio3 = rs.getString("PRIVILEGIO3");
							privilegio4 = rs.getString("PRIVILEGIO4");
							privilegio5 = rs.getString("PRIVILEGIO5");
							reves1 = rs.getString("REVES1");
							reves2 = rs.getString("REVES2");
							reves3 = rs.getString("REVES3");
							reves4 = rs.getString("REVES4");
							fuerza = rs.getInt("FUERZA");
							destreza = rs.getInt("DESTREZA");
							resistencia = rs.getInt("RESISTENCIA");
							resistenciaM = rs.getInt("RESISTENCIA_MAGICA");
							inteligencia = rs.getInt("INTELIGENCIA");
							percepcion = rs.getInt("PERCEPCION");
							carisma = rs.getInt("CARISMA");
							unamano = rs.getInt("ARMAS_DE_UNA_MANO");
							dosmanos = rs.getInt("ARMAS_DE_DOS_MANOS");
							asta = rs.getInt("ARMAS_DE_ASTA");
							distancia = rs.getInt("ARMAS_A_DISTANCIA");
							esquivar = rs.getInt("ESQUIVAR");
							bloquear = rs.getInt("BLOQUEAR");
							arteGuerra = rs.getInt("ARTE_DE_LA_GUERRA");
							diplomacia = rs.getInt("DIPLOMACIA");
							etiqueta = rs.getInt("ETIQUETA");
							medicina = rs.getInt("MEDICINA");
							ocultismo = rs.getInt("OCULTISMO");
							investigacion = rs.getInt("INVESTIGACION");
							negociacion = rs.getInt("NEGOCIACION");
							cSecretos = rs.getInt("CONOCIMIENTOS_SECRETOS");
							fuego = rs.getInt("FUEGO");
							agua = rs.getInt("AGUA");
							tierra = rs.getInt("TIERRA");
							viento = rs.getInt("VIENTO");
							druidica = rs.getInt("DRUIDICA");
							blanca = rs.getInt("BLANCA");
							negra = rs.getInt("NEGRA");
							arcana = rs.getInt("ARCANA");
							atletismo = rs.getInt("ATLETISMO");
							supervivencia = rs.getInt("SUPERVIVENCIA");
							equitacion = rs.getInt("EQUITACION");
							trampas = rs.getInt("TRAMPAS");
							sigilo = rs.getInt("SIGILO");
							armadura = rs.getString("ARMADURA");
							descripcionArm = rs.getString("DESCRIPCION_ARMADURA");
							posesionArm = rs.getString("POSESION_ARMADURA");
							prop1Arm = rs.getString("PROPIEDAD1_ARMADURA");
							prop2Arm = rs.getString("PROPIEDAD2_ARMADURA");
							prop3Arm = rs.getString("PROPIEDAD3_ARMADURA");
							weap1 = rs.getString("ARMA1");
							descripcionWeap1 = rs.getString("DESCRIPCION_ARMA1");
							posesionWeap1 = rs.getString("POSESION_ARMA1");
							prop1Weap1 = rs.getString("PROPIEDAD1_ARMA1");
							prop2Weap1 = rs.getString("PROPIEDAD2_ARMA1");
							prop3Weap1 = rs.getString("PROPIEDAD3_ARMA1");
							weap2 = rs.getString("ARMA2");
							descripcionWeap2 = rs.getString("DESCRIPCION_ARMA2");
							posesionWeap2 = rs.getString("POSESION_ARMA2");
							prop1Weap2 = rs.getString("PROPIEDAD1_ARMA2");
							prop2Weap2 = rs.getString("PROPIEDAD2_ARMA2");
							prop3Weap2 = rs.getString("PROPIEDAD3_ARMA2");
							weap3 = rs.getString("ARMA3");
							descripcionWeap3 = rs.getString("DESCRIPCION_ARMA3");
							posesionWeap3 = rs.getString("POSESION_ARMA3");
							prop1Weap3 = rs.getString("PROPIEDAD1_ARMA3");
							prop2Weap3 = rs.getString("PROPIEDAD2_ARMA3");
							prop3Weap3 = rs.getString("PROPIEDAD3_ARMA3");
							weap4 = rs.getString("ARMA4");
							descripcionWeap4 = rs.getString("DESCRIPCION_ARMA4");
							posesionWeap4 = rs.getString("POSESION_ARMA4");
							prop1Weap4 = rs.getString("PROPIEDAD1_ARMA4");
							prop2Weap4 = rs.getString("PROPIEDAD2_ARMA4");
							prop3Weap4 = rs.getString("PROPIEDAD3_ARMA4");
							obj1 = rs.getString("OBJETO1");
							descripcionObj1 = rs.getString("DESCRIPCION_OBJETO1");
							posesionObj1 = rs.getString("POSESION_OBJETO1");
							prop1Obj1 = rs.getString("PROPIEDAD1_OBJETO1");
							prop2Obj1 = rs.getString("PROPIEDAD2_OBJETO1");
							prop3Obj1 = rs.getString("PROPIEDAD3_OBJETO1");
							obj2 = rs.getString("OBJETO2");
							descripcionObj2 = rs.getString("DESCRIPCION_OBJETO2");
							posesionObj2 = rs.getString("POSESION_OBJETO2");
							prop1Obj2 = rs.getString("PROPIEDAD1_OBJETO2");
							prop2Obj2 = rs.getString("PROPIEDAD2_OBJETO2");
							prop3Obj2 = rs.getString("PROPIEDAD3_OBJETO2");
							obj3 = rs.getString("OBJETO3");
							descripcionObj3 = rs.getString("DESCRIPCION_OBJETO3");
							posesionObj3 = rs.getString("POSESION_OBJETO3");
							prop1Obj3 = rs.getString("PROPIEDAD1_OBJETO3");
							prop2Obj3 = rs.getString("PROPIEDAD2_OBJETO3");
							prop3Obj3 = rs.getString("PROPIEDAD3_OBJETO3");
							obj4 = rs.getString("OBJETO4");
							descripcionObj4 = rs.getString("DESCRIPCION_OBJETO4");
							posesionObj4 = rs.getString("POSESION_OBJETO4");
							prop1Obj4 = rs.getString("PROPIEDAD1_OBJETO4");
							prop2Obj4 = rs.getString("PROPIEDAD2_OBJETO4");
							prop3Obj4 = rs.getString("PROPIEDAD3_OBJETO4");
							acc1 = rs.getString("ACCESORIO1");
							descripcionAcc1 = rs.getString("DESCRIPCION_ACCESORIO1");
							posesionAcc1 = rs.getString("POSESION_ACCESORIO1");
							prop1Acc1 = rs.getString("PROPIEDAD1_ACCESORIO1");
							prop2Acc1 = rs.getString("PROPIEDAD2_ACCESORIO1");
							prop3Acc1 = rs.getString("PROPIEDAD3_ACCESORIO1");
							acc2 = rs.getString("ACCESORIO2");
							descripcionAcc2 = rs.getString("DESCRIPCION_ACCESORIO2");
							posesionAcc2 = rs.getString("POSESION_ACCESORIO2");
							prop1Acc2 = rs.getString("PROPIEDAD1_ACCESORIO2");
							prop2Acc2 = rs.getString("PROPIEDAD2_ACCESORIO2");
							prop3Acc2 = rs.getString("PROPIEDAD3_ACCESORIO2");
							acc3 = rs.getString("ACCESORIO3");
							descripcionAcc3 = rs.getString("DESCRIPCION_ACCESORIO3");
							posesionAcc3 = rs.getString("POSESION_ACCESORIO3");
							prop1Acc3 = rs.getString("PROPIEDAD1_ACCESORIO3");
							prop2Acc3 = rs.getString("PROPIEDAD2_ACCESORIO3");
							prop3Acc3 = rs.getString("PROPIEDAD3_ACCESORIO3");
							acc4 = rs.getString("ACCESORIO4");
							descripcionAcc4 = rs.getString("DESCRIPCION_ACCESORIO4");
							posesionAcc4 = rs.getString("POSESION_ACCESORIO4");
							prop1Acc4 = rs.getString("PROPIEDAD1_ACCESORIO4");
							prop2Acc4 = rs.getString("PROPIEDAD2_ACCESORIO4");
							prop3Acc4 = rs.getString("PROPIEDAD3_ACCESORIO4");
							tipoWeap1 = rs.getString("TIPOARMA1");
							tipoWeap2 = rs.getString("TIPOARMA2");
							tipoWeap3 = rs.getString("TIPOARMA3");
							tipoWeap4 = rs.getString("TIPOARMA4");
							tipoAcc1 = rs.getString("TIPOACC1");
							tipoAcc2 = rs.getString("TIPOACC2");
							tipoAcc3 = rs.getString("TIPOACC3");
							tipoAcc4 = rs.getString("TIPOACC4");
							arrojadizaWeap1 = rs.getString("SUBCLASE_ARMA1");
							arrojadizaWeap2 = rs.getString("SUBCLASE_ARMA2");
							arrojadizaWeap3 = rs.getString("SUBCLASE_ARMA3");
							arrojadizaWeap4 = rs.getString("SUBCLASE_ARMA4");
							salud = rs.getInt("SALUD");
							mana = rs.getInt("MANA");
							energia = rs.getInt("ENERGIA");
							experiencia = rs.getInt("EXPERIENCIA");
							sino = rs.getInt("SINO");
							nivel = rs.getInt("NIVEL");
							extras=rs.getString("EXTRAS");
							dinero=rs.getInt("DINERO");
							modificadores=rs.getString("MODIFICADORES");
							poderes=rs.getString("PODERES");
							exptotal=rs.getInt("EXPTOTAL");
							campeon=rs.getInt("CAMPEON");
							

						}
								if(tipoWeap1.equals("OneHanded")){
									if(posesionWeap1.equals("Normal")){
									
									weapon1=new OneHanded(weap1,descripcionWeap1,false,false,null,arrojadizaWeap1);
									}
									
									if(posesionWeap1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new OneHanded(weap1,descripcionWeap1,true,false,poss,arrojadizaWeap1);
										}
									
									if(posesionWeap1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new OneHanded(weap1,descripcionWeap1,false,true,poss,arrojadizaWeap1);
										}
								}
								
								if(tipoWeap1.equals("TwoHanded")){
									if(posesionWeap1.equals("Normal")){
									
									weapon1=new TwoHanded(weap1,descripcionWeap1,false,false,null,arrojadizaWeap1);
									}
									
									if(posesionWeap1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new TwoHanded(weap1,descripcionWeap1,true,false,poss,arrojadizaWeap1);
										}
									
									if(posesionWeap1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new TwoHanded(weap1,descripcionWeap1,false,true,poss,arrojadizaWeap1);
										}
								}
								
								if(tipoWeap1.equals("Pole")){
									if(posesionWeap1.equals("Normal")){
									
									weapon1=new Pole(weap1,descripcionWeap1,false,false,null,arrojadizaWeap1);
									}
									
									if(posesionWeap1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Pole(weap1,descripcionWeap1,true,false,poss,arrojadizaWeap1);
										}
									
									if(posesionWeap1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Pole(weap1,descripcionWeap1,false,true,poss,arrojadizaWeap1);
										}
								}
								
								if(tipoWeap1.equals("Ranged")){
									if(posesionWeap1.equals("Normal")){
									
									weapon1=new Ranged(weap1,descripcionWeap1,false,false,null,arrojadizaWeap1);
									}
									
									if(posesionWeap1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Ranged(weap1,descripcionWeap1,true,false,poss,arrojadizaWeap1);
										}
									
									if(posesionWeap1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Ranged(weap1,descripcionWeap1,false,true,poss,arrojadizaWeap1);
										}
								}
								
								if(tipoWeap1.equals("Shields")){
									if(posesionWeap1.equals("Normal")){
									
									weapon1=new Shields(weap1,descripcionWeap1,false,false,null,arrojadizaWeap1);
									}
									
									if(posesionWeap1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Shields(weap1,descripcionWeap1,true,false,poss,arrojadizaWeap1);
										}
									
									if(posesionWeap1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Shields(weap1,descripcionWeap1,false,true,poss,arrojadizaWeap1);
										}
								}
								
								if(tipoWeap2.equals("OneHanded")){
									if(posesionWeap2.equals("Normal")){
									
									weapon2=new OneHanded(weap2,descripcionWeap1,false,false,null,arrojadizaWeap2);
									}
									
									if(posesionWeap2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new OneHanded(weap2,descripcionWeap1,true,false,poss,arrojadizaWeap2);
										}
									
									if(posesionWeap2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new OneHanded(weap2,descripcionWeap1,false,true,poss,arrojadizaWeap2);
										}
								}
								
								if(tipoWeap2.equals("TwoHanded")){
									if(posesionWeap2.equals("Normal")){
									
									weapon2=new TwoHanded(weap2,descripcionWeap1,false,false,null,arrojadizaWeap2);
									}
									
									if(posesionWeap2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new TwoHanded(weap2,descripcionWeap1,true,false,poss,arrojadizaWeap2);
										}
									
									if(posesionWeap2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new TwoHanded(weap2,descripcionWeap1,false,true,poss,arrojadizaWeap2);
										}
								}
								
								if(tipoWeap2.equals("Pole")){
									if(posesionWeap2.equals("Normal")){
									
									weapon2=new Pole(weap2,descripcionWeap1,false,false,null,arrojadizaWeap2);
									}
									
									if(posesionWeap2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Pole(weap2,descripcionWeap1,true,false,poss,arrojadizaWeap2);
										}
									
									if(posesionWeap2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Pole(weap2,descripcionWeap1,false,true,poss,arrojadizaWeap2);
										}
								}
								
								if(tipoWeap2.equals("Ranged")){
									if(posesionWeap2.equals("Normal")){
									
									weapon2=new Ranged(weap2,descripcionWeap1,false,false,null,arrojadizaWeap2);
									}
									
									if(posesionWeap2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Ranged(weap2,descripcionWeap1,true,false,poss,arrojadizaWeap2);
										}
									
									if(posesionWeap2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Ranged(weap2,descripcionWeap1,false,true,poss,arrojadizaWeap2);
										}
								}
								
								if(tipoWeap2.equals("Shields")){
									if(posesionWeap2.equals("Normal")){
									
									weapon2=new Shields(weap2,descripcionWeap1,false,false,null,arrojadizaWeap2);
									}
									
									if(posesionWeap2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Shields(weap2,descripcionWeap1,true,false,poss,arrojadizaWeap2);
										}
									
									if(posesionWeap2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Shields(weap2,descripcionWeap1,false,true,poss,arrojadizaWeap2);
										}
								}
								
								
								if(tipoWeap3.equals("OneHanded")){
									if(posesionWeap3.equals("Normal")){
									
									weapon3=new OneHanded(weap3,descripcionWeap1,false,false,null,arrojadizaWeap3);
									}
									
									if(posesionWeap3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new OneHanded(weap3,descripcionWeap1,true,false,poss,arrojadizaWeap3);
										}
									
									if(posesionWeap3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new OneHanded(weap3,descripcionWeap1,false,true,poss,arrojadizaWeap3);
										}
								}
								
								if(tipoWeap3.equals("TwoHanded")){
									if(posesionWeap3.equals("Normal")){
									
									weapon3=new TwoHanded(weap3,descripcionWeap1,false,false,null,arrojadizaWeap3);
									}
									
									if(posesionWeap3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new TwoHanded(weap3,descripcionWeap1,true,false,poss,arrojadizaWeap3);
										}
									
									if(posesionWeap3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new TwoHanded(weap3,descripcionWeap1,false,true,poss,arrojadizaWeap3);
										}
								}
								
								if(tipoWeap3.equals("Pole")){
									if(posesionWeap3.equals("Normal")){
									
									weapon3=new Pole(weap3,descripcionWeap1,false,false,null,arrojadizaWeap3);
									}
									
									if(posesionWeap3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Pole(weap3,descripcionWeap1,true,false,poss,arrojadizaWeap3);
										}
									
									if(posesionWeap3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Pole(weap3,descripcionWeap1,false,true,poss,arrojadizaWeap3);
										}
								}
								
								if(tipoWeap3.equals("Ranged")){
									if(posesionWeap3.equals("Normal")){
									
									weapon3=new Ranged(weap3,descripcionWeap1,false,false,null,arrojadizaWeap3);
									}
									
									if(posesionWeap3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Ranged(weap3,descripcionWeap1,true,false,poss,arrojadizaWeap3);
										}
									
									if(posesionWeap3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Ranged(weap3,descripcionWeap1,false,true,poss,arrojadizaWeap3);
										}
								}
								
								if(tipoWeap3.equals("Shields")){
									if(posesionWeap3.equals("Normal")){
									
									weapon3=new Shields(weap3,descripcionWeap1,false,false,null,arrojadizaWeap3);
									}
									
									if(posesionWeap3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Shields(weap3,descripcionWeap1,true,false,poss,arrojadizaWeap3);
										}
									
									if(posesionWeap3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Shields(weap3,descripcionWeap1,false,true,poss,arrojadizaWeap3);
										}
								}
								
								if(tipoWeap4.equals("OneHanded")){
									if(posesionWeap4.equals("Normal")){
									
									weapon4=new OneHanded(weap4,descripcionWeap1,false,false,null,arrojadizaWeap4);
									}
									
									if(posesionWeap4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new OneHanded(weap4,descripcionWeap1,true,false,poss,arrojadizaWeap4);
										}
									
									if(posesionWeap4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new OneHanded(weap4,descripcionWeap1,false,true,poss,arrojadizaWeap4);
										}
								}
								
								if(tipoWeap4.equals("TwoHanded")){
									if(posesionWeap4.equals("Normal")){
									
									weapon4=new TwoHanded(weap4,descripcionWeap1,false,false,null,arrojadizaWeap4);
									}
									
									if(posesionWeap4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new TwoHanded(weap4,descripcionWeap1,true,false,poss,arrojadizaWeap4);
										}
									
									if(posesionWeap4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new TwoHanded(weap4,descripcionWeap1,false,true,poss,arrojadizaWeap4);
										}
								}
								
								if(tipoWeap4.equals("Pole")){
									if(posesionWeap4.equals("Normal")){
									
									weapon4=new Pole(weap4,descripcionWeap1,false,false,null,arrojadizaWeap4);
									}
									
									if(posesionWeap4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Pole(weap4,descripcionWeap1,true,false,poss,arrojadizaWeap4);
										}
									
									if(posesionWeap4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Pole(weap4,descripcionWeap1,false,true,poss,arrojadizaWeap4);
										}
								}
								
								if(tipoWeap4.equals("Ranged")){
									if(posesionWeap4.equals("Normal")){
									
									weapon4=new Ranged(weap4,descripcionWeap1,false,false,null,arrojadizaWeap4);
									}
									
									if(posesionWeap4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Ranged(weap4,descripcionWeap1,true,false,poss,arrojadizaWeap4);
										}
									
									if(posesionWeap4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Ranged(weap4,descripcionWeap1,false,true,poss,arrojadizaWeap4);
										}
								}
								
								if(tipoWeap4.equals("Shields")){
									if(posesionWeap4.equals("Normal")){
									
									weapon4=new Shields(weap4,descripcionWeap1,false,false,null,arrojadizaWeap4);
									}
									
									if(posesionWeap4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Shields(weap4,descripcionWeap1,true,false,poss,arrojadizaWeap4);
										}
									
									if(posesionWeap4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Shields(weap4,descripcionWeap1,false,true,poss,arrojadizaWeap4);
										}
								}
								
								if(posesionObj1.equals("Normal")){
									
									misc1=new Misc(obj1,descripcionObj1,false,false,null);
								}
								if(posesionObj1.equals("Posesión")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj1);
									pos.add(prop2Obj1);
									pos.add(prop3Obj1);
									Possesions poss=new Possesions(pos);
									misc1=new Misc(obj1,descripcionObj1,true,false,poss);
								}
								if(posesionObj1.equals("Legendario")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj1);
									pos.add(prop2Obj1);
									pos.add(prop3Obj1);
									Possesions poss=new Possesions(pos);
									misc1=new Misc(obj1,descripcionObj1,false,true,poss);
								}
								
								if(posesionObj2.equals("Normal")){
									
									misc2=new Misc(obj2,descripcionObj2,false,false,null);
								}
								if(posesionObj2.equals("Posesión")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj2);
									pos.add(prop2Obj2);
									pos.add(prop3Obj2);
									Possesions poss=new Possesions(pos);
									misc2=new Misc(obj2,descripcionObj2,true,false,poss);
								}
								if(posesionObj2.equals("Legendario")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj2);
									pos.add(prop2Obj2);
									pos.add(prop3Obj2);
									Possesions poss=new Possesions(pos);
									misc2=new Misc(obj2,descripcionObj2,false,true,poss);
								}
								
								if(posesionObj3.equals("Normal")){
									
									misc3=new Misc(obj3,descripcionObj3,false,false,null);
								}
								if(posesionObj3.equals("Posesión")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj3);
									pos.add(prop2Obj3);
									pos.add(prop3Obj3);
									Possesions poss=new Possesions(pos);
									misc3=new Misc(obj3,descripcionObj3,true,false,poss);
								}
								if(posesionObj3.equals("Legendario")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj3);
									pos.add(prop2Obj3);
									pos.add(prop3Obj3);
									Possesions poss=new Possesions(pos);
									misc3=new Misc(obj3,descripcionObj3,false,true,poss);
								}
								if(posesionObj4.equals("Normal")){
									
									misc4=new Misc(obj4,descripcionObj4,false,false,null);
								}
								if(posesionObj4.equals("Posesión")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj4);
									pos.add(prop2Obj4);
									pos.add(prop3Obj4);
									Possesions poss=new Possesions(pos);
									misc4=new Misc(obj4,descripcionObj4,true,false,poss);
								}
								if(posesionObj4.equals("Legendario")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj4);
									pos.add(prop2Obj4);
									pos.add(prop3Obj4);
									Possesions poss=new Possesions(pos);
									misc4=new Misc(obj4,descripcionObj4,false,true,poss);
								}
								
								if(tipoAcc1.equals("Cloak")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Cloak(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								
								
								if(tipoAcc1.equals("Earrings")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Cloak(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc1.equals("Necklace")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Cloak(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc1.equals("Rings")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Cloak(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc1.equals("Cloak")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Cloak(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								
								
								if(tipoAcc1.equals("Earrings")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Earrings(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Earrings(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Earrings(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc1.equals("Necklace")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Necklace(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Necklace(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Necklace(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc1.equals("Rings")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Rings(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Rings(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Rings(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc2.equals("Cloak")){
									if(posesionAcc2.equals("Normal")){
									
									accesorie2=new Cloak(acc2,descripcionAcc2,false,false,null);
									}
									
									if(posesionAcc2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Cloak(acc2,descripcionAcc2,true,false,poss);
										}
									
									if(posesionAcc2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Cloak(acc2,descripcionAcc2,false,true,poss);
										}
								}
								
								
								
								if(tipoAcc2.equals("Earrings")){
									if(posesionAcc2.equals("Normal")){
									
									accesorie2=new Earrings(acc2,descripcionAcc2,false,false,null);
									}
									
									if(posesionAcc2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Earrings(acc2,descripcionAcc2,true,false,poss);
										}
									
									if(posesionAcc2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Earrings(acc2,descripcionAcc2,false,true,poss);
										}
								}
								
								if(tipoAcc2.equals("Necklace")){
									if(posesionAcc2.equals("Normal")){
									
									accesorie2=new Necklace(acc2,descripcionAcc2,false,false,null);
									}
									
									if(posesionAcc2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Necklace(acc2,descripcionAcc2,true,false,poss);
										}
									
									if(posesionAcc2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Necklace(acc2,descripcionAcc2,false,true,poss);
										}
								}
								
								if(tipoAcc2.equals("Rings")){
									if(posesionAcc2.equals("Normal")){
									
									accesorie2=new Rings(acc2,descripcionAcc2,false,false,null);
									}
									
									if(posesionAcc2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Rings(acc2,descripcionAcc2,true,false,poss);
										}
									
									if(posesionAcc2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Rings(acc2,descripcionAcc2,false,true,poss);
										}
								}
								
								if(tipoAcc3.equals("Cloak")){
									if(posesionAcc3.equals("Normal")){
									
									accesorie3=new Cloak(acc3,descripcionAcc3,false,false,null);
									}
									
									if(posesionAcc3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Cloak(acc3,descripcionAcc3,true,false,poss);
										}
									
									if(posesionAcc3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Cloak(acc3,descripcionAcc3,false,true,poss);
										}
								}
								
								
								
								if(tipoAcc3.equals("Earrings")){
									if(posesionAcc3.equals("Normal")){
									
									accesorie3=new Earrings(acc3,descripcionAcc3,false,false,null);
									}
									
									if(posesionAcc3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Earrings(acc3,descripcionAcc3,true,false,poss);
										}
									
									if(posesionAcc3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Earrings(acc3,descripcionAcc3,false,true,poss);
										}
								}
								
								if(tipoAcc3.equals("Necklace")){
									if(posesionAcc3.equals("Normal")){
									
									accesorie3=new Necklace(acc3,descripcionAcc3,false,false,null);
									}
									
									if(posesionAcc3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Necklace(acc3,descripcionAcc3,true,false,poss);
										}
									
									if(posesionAcc3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Necklace(acc3,descripcionAcc3,false,true,poss);
										}
								}
								
								if(tipoAcc3.equals("Rings")){
									if(posesionAcc3.equals("Normal")){
									
									accesorie3=new Rings(acc3,descripcionAcc3,false,false,null);
									}
									
									if(posesionAcc3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Rings(acc3,descripcionAcc3,true,false,poss);
										}
									
									if(posesionAcc3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Rings(acc3,descripcionAcc3,false,true,poss);
										}
								}
								
								if(tipoAcc4.equals("Cloak")){
									if(posesionAcc4.equals("Normal")){
									
									accesorie4=new Cloak(acc4,descripcionAcc4,false,false,null);
									}
									
									if(posesionAcc4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Cloak(acc4,descripcionAcc4,true,false,poss);
										}
									
									if(posesionAcc4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Cloak(acc4,descripcionAcc4,false,true,poss);
										}
								}
								
								
								
								if(tipoAcc4.equals("Earrings")){
									if(posesionAcc4.equals("Normal")){
									
									accesorie4=new Earrings(acc4,descripcionAcc4,false,false,null);
									}
									
									if(posesionAcc4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Earrings(acc4,descripcionAcc4,true,false,poss);
										}
									
									if(posesionAcc4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Earrings(acc4,descripcionAcc4,false,true,poss);
										}
								}
								
								if(tipoAcc4.equals("Necklace")){
									if(posesionAcc4.equals("Normal")){
									
									accesorie4=new Necklace(acc4,descripcionAcc4,false,false,null);
									}
									
									if(posesionAcc4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Necklace(acc4,descripcionAcc4,true,false,poss);
										}
									
									if(posesionAcc4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Necklace(acc4,descripcionAcc4,false,true,poss);
										}
								}
								
								if(tipoAcc4.equals("Rings")){
									if(posesionAcc4.equals("Normal")){
									
									accesorie4=new Rings(acc4,descripcionAcc4,false,false,null);
									}
									
									if(posesionAcc4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Rings(acc4,descripcionAcc4,true,false,poss);
										}
									
									if(posesionAcc4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Rings(acc4,descripcionAcc4,false,true,poss);
										}
								}
								
								if(posesionArm.equals("Normal")){
									
									armor=new Armor(armadura,descripcionArm,false,false,null);
								}
								if(posesionArm.equals("Posesión")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Arm);
									pos.add(prop2Arm);
									pos.add(prop3Arm);
									Possesions poss=new Possesions(pos);
									armor=new Armor(armadura,descripcionArm,true,false,poss);
								}
								
								if(posesionArm.equals("Legendario")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Arm);
									pos.add(prop2Arm);
									pos.add(prop3Arm);
									Possesions poss=new Possesions(pos);
									armor=new Armor(armadura,descripcionArm,false,true,poss);
								}
								Race race=new Race(raza);
								AtributePoints puntosAtrib=new AtributePoints();
								puntosAtrib.setPoints(0);
								Atributes atributos=new Atributes(puntosAtrib);
								atributos.setCharisma(carisma);
								atributos.setDexterity(destreza);
								atributos.setIntelligence(inteligencia);
								atributos.setMagicres(resistenciaM);
								atributos.setResistance(resistencia);
								atributos.setPerception(percepcion);
								atributos.setStrength(fuerza);
								SkillPoints puntosSkill=new SkillPoints();
								puntosSkill.setPoints(0);
								CombatSkills combate=new CombatSkills(puntosSkill);
								combate.setBlock(bloquear);
								combate.setDodge(esquivar);
								combate.setOneHanded(unamano);
								combate.setPole(asta);
								combate.setRanged(distancia);
								combate.setTwoHanded(dosmanos);
								KnowledgeSkills conocimiento=new KnowledgeSkills(puntosSkill);
								conocimiento.setArtofWar(arteGuerra);
								conocimiento.setDiplomacy(diplomacia);
								conocimiento.setEtiquette(etiqueta);
								conocimiento.setMedicine(medicina);
								conocimiento.setNegotiation(negociacion);
								conocimiento.setOccultism(ocultismo);
								conocimiento.setResearch(investigacion);
								conocimiento.setSecretKnowledge(cSecretos);
								MagicSkills magia=new MagicSkills(puntosSkill);
								magia.setArcane(arcana);
								magia.setBlack(negra);
								magia.setDruidic(druidica);
								magia.setEarth(tierra);
								magia.setFire(fuego);
								magia.setWater(agua);
								magia.setWhite(blanca);
								magia.setWind(viento);
								KnowHowSkills destrezas= new KnowHowSkills (puntosSkill);
								destrezas.setAthletics(atletismo);
								destrezas.setEquitation(equitacion);
								destrezas.setStealth(sigilo);
								destrezas.setSurvival(supervivencia);
								destrezas.setTraps(trampas);
								Blessing blessing=new Blessing(bendicion);
								Privileges privs=new Privileges();
								if(privilegio1!=null){
								privs.add(privilegio1);}
								if(privilegio2!=null){
									privs.add(privilegio2);}
								if(privilegio3!=null){
									privs.add(privilegio3);}
								if(privilegio4!=null){
									privs.add(privilegio4);}
								if(privilegio5!=null){
									privs.add(privilegio5);}
								Setbacks reves=new Setbacks();
								if(reves1!=null){
								reves.add(reves1);}
								if(reves2!=null){
								reves.add(reves2);}
								if(reves3!=null){
									reves.add(reves3);
								}
								if(reves4!=null){
								reves.add(reves4);}
								boolean camp=false;
								if(campeon==1){
									camp=true;
								}
								Equipment equipment=new Equipment();
								Characters intermedio=new Characters(nombre,race,descripcionF,edad,sino,salud,energia,mana,
										atributos,combate,conocimiento,magia,destrezas,blessing,privs,reves,camp,armor,equipment,weapon1,weapon2,weapon3,weapon4,
										misc1,misc2,misc3,misc4,accesorie1,accesorie2,accesorie3,accesorie4,experiencia,nivel,dinero,extras,modificadores,poderes);
					if(button.getText().equals("")){
					
						button.setText(seleccion.toString());
						personaje1=intermedio;
					}
					else{ if(button_1.getText().equals("")){
					
						button_1.setText(seleccion.toString());
						personaje2=intermedio;
					}
					else{
						if(button_2.getText().equals("")){
							
							button_2.setText(seleccion.toString());
							personaje3=intermedio;
						}
					
						else{if(button_3.getText().equals("")){
							
							button_3.setText(seleccion.toString());
							personaje4=intermedio;
						}
						else{if(button_4.getText().equals("")){
							
							button_4.setText(seleccion.toString());
							personaje5=intermedio;
						}
						else{if(button_5.getText().equals("")){
							
							button_5.setText(seleccion.toString());
							personaje6=intermedio;
						}
						else{if(button_6.getText().equals("")){
							
							button_6.setText(seleccion.toString());
							personaje7=intermedio;
						}
						
						else{if(button_7.getText().equals("")){
							
							button_7.setText(seleccion.toString());
							personaje8=intermedio;
						}
						else{if(button_8.getText().equals("")){
							
							button_8.setText(seleccion.toString());
							personaje9=intermedio;
						}
						
						else{if(button_9.getText().equals("")){
							
							button_9.setText(seleccion.toString());
							personaje10=intermedio;
						}}
						}
						
						}
						}
						
						}
						}
						}
					}
					
					}
			
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (OutOfPointsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SkillOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (PrivilegeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
				
			}
		});
		
		mntmNpc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				try {
					ResultSet rs = tabla.executeQuery("SELECT * FROM NPC");
					ArrayList <Object> personajes=new ArrayList<Object>();
					while (rs.next()){
						
						personajes.add(rs.getString("NOMBRE"));
						
					}
					
					Object[] personaje=personajes.toArray();
					Object seleccion = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Seleccione opcion",
							"Cargar Personaje", JOptionPane.PLAIN_MESSAGE,
							null,personaje,null);
					
					rs=tabla.executeQuery("SELECT * FROM NPC WHERE NOMBRE='"+seleccion+"'");
					Armor armor = null;
					Weapons weapon1 = null;
					Weapons weapon2 = null;
					Weapons weapon3= null;
					Weapons weapon4= null;
					Misc misc1 = null;
					Misc misc2= null;
					Misc misc3= null;
					Misc misc4= null;
					Accesories accesorie1= null;
					Accesories accesorie2= null;
					Accesories accesorie3= null;
					Accesories accesorie4= null;
					
					String armadura = "";
					 String descripcionArm = "";
					 String posesionArm = "";
					 String prop1Arm = "";
					 String prop2Arm = "";
					 String prop3Arm = "";
					 String weap1 = "";
					 String descripcionWeap1 = "";
					 String posesionWeap1 = "";
					 String prop1Weap1 = "";
					 String prop2Weap1 = "";
					 String prop3Weap1 = "";
					 String weap2 = "";
					 String descripcionWeap2 = "";
					 String posesionWeap2 = "";
					 String prop1Weap2 = "";
					 String prop2Weap2 = "";
					 String prop3Weap2 = "";
					 String weap3 = "";
					 String descripcionWeap3 = "";
					 String posesionWeap3 = "";
					 String prop1Weap3 = "";
					 String prop2Weap3 = "";
					 String prop3Weap3 = "";
					 String weap4 = "";
					 String descripcionWeap4 = "";
					 String posesionWeap4 = "";
					 String prop1Weap4 = "";
					 String prop2Weap4 = "";
					 String prop3Weap4 = "";
					 String obj1 = "";
					 String descripcionObj1 = "";
					 String posesionObj1 = "";
					 String prop1Obj1 = "";
					 String prop2Obj1 = "";
					 String prop3Obj1 = "";
					 String obj2 = "";
					 String descripcionObj2 = "";
					 String posesionObj2 = "";
					 String prop1Obj2 = "";
					 String prop2Obj2 = "";
					 String prop3Obj2 = "";
					 String obj3 = "";
					 String descripcionObj3 = "";
					 String posesionObj3 = "";
					 String prop1Obj3 = "";
					 String prop2Obj3 = "";
					 String prop3Obj3 = "";
					 String obj4 = "";
					 String descripcionObj4 = "";
					 String posesionObj4 = "";
					 String prop1Obj4 = "";
					 String prop2Obj4 = "";
					 String prop3Obj4 = "";
					 String acc1 = "";
					 String descripcionAcc1 = "";
					 String posesionAcc1 = "";
					 String prop1Acc1 = "";
					 String prop2Acc1 = "";
					 String prop3Acc1 = "";
					 String acc2 = "";
					 String descripcionAcc2 = "";
					 String posesionAcc2 = "";
					 String prop1Acc2 = "";
					 String prop2Acc2 = "";
					 String prop3Acc2 = "";
					 String acc3 = "";
					 String descripcionAcc3 = "";
					 String posesionAcc3 = "";
					 String prop1Acc3 = "";
					 String prop2Acc3 = "";
					 String prop3Acc3 = "";
					 String acc4 = "";
					 String descripcionAcc4 = "";
					 String posesionAcc4 = "";
					 String prop1Acc4 = "";
					 String prop2Acc4 = "";
					 String prop3Acc4 = "";
					 String tipoWeap1 = "";
					 String tipoWeap2 = "";
					 String tipoWeap3 = "";
					 String tipoWeap4 = "";
					 String tipoAcc1 = "";
					 String tipoAcc2 = "";
					 String tipoAcc3 = "";
					 String tipoAcc4 = "";
					 String arrojadizaWeap1 = "";
					 String arrojadizaWeap2 = "";
					 String arrojadizaWeap3 = "";
					 String arrojadizaWeap4 = "";
					
					 String poderes="";
					 String extras= "";
					 String modificadores="";
					 String nombre = "";
						int edad = 0;
						String raza = "";
						String descripcionF = "";
						String bendicion = "";
						String privilegio1 = "";
						String privilegio2 = "";
						String privilegio3 = "";
						String privilegio4 = "";
						String privilegio5 = "";
						String reves1 = "";
						String reves2 = "";
						String reves3 = "";
						String reves4 = "";
						int fuerza = 0;
						int destreza = 0;
						int resistencia = 0;
						int resistenciaM = 0;
						int inteligencia = 0;
						int percepcion = 0;
						int carisma = 0;
						int unamano = 0;
						int dosmanos = 0;
						int asta = 0;
						int distancia = 0;
						int esquivar = 0;
						int bloquear = 0;
						int arteGuerra = 0;
						int diplomacia = 0;
						int etiqueta = 0;
						int medicina = 0;
						int ocultismo = 0;
						int investigacion = 0;
						int negociacion = 0;
						int cSecretos = 0;
						int fuego = 0;
						int agua = 0;
						int tierra = 0;
						int viento = 0;
						int druidica = 0;
						int blanca = 0;
						int negra = 0;
						int arcana = 0;
						int atletismo = 0;
						int supervivencia = 0;
						int equitacion = 0;
						int trampas = 0;
						int sigilo = 0;

						int salud = 0;
						int mana = 0;
						int energia = 0;
						int experiencia = 0;
						int sino = 0;
						int nivel = 0;

						extras="";
						int dinero = 0;
						modificadores="";
						poderes="";
						int exptotal=0;
						int campeon = 0;
						
								while (rs.next()) {
							nombre = rs.getString("NOMBRE");
							edad = rs.getInt("EDAD");
							raza = rs.getString("RAZA");
							descripcionF = rs.getString("DESCRIPCION_FISICA");
							;
							bendicion = rs.getString("BENDICION");
							privilegio1 = rs.getString("PRIVILEGIO1");
							privilegio2 = rs.getString("PRIVILEGIO2");
							privilegio3 = rs.getString("PRIVILEGIO3");
							privilegio4 = rs.getString("PRIVILEGIO4");
							privilegio5 = rs.getString("PRIVILEGIO5");
							reves1 = rs.getString("REVES1");
							reves2 = rs.getString("REVES2");
							reves3 = rs.getString("REVES3");
							reves4 = rs.getString("REVES4");
							fuerza = rs.getInt("FUERZA");
							destreza = rs.getInt("DESTREZA");
							resistencia = rs.getInt("RESISTENCIA");
							resistenciaM = rs.getInt("RESISTENCIA_MAGICA");
							inteligencia = rs.getInt("INTELIGENCIA");
							percepcion = rs.getInt("PERCEPCION");
							carisma = rs.getInt("CARISMA");
							unamano = rs.getInt("ARMAS_DE_UNA_MANO");
							dosmanos = rs.getInt("ARMAS_DE_DOS_MANOS");
							asta = rs.getInt("ARMAS_DE_ASTA");
							distancia = rs.getInt("ARMAS_A_DISTANCIA");
							esquivar = rs.getInt("ESQUIVAR");
							bloquear = rs.getInt("BLOQUEAR");
							arteGuerra = rs.getInt("ARTE_DE_LA_GUERRA");
							diplomacia = rs.getInt("DIPLOMACIA");
							etiqueta = rs.getInt("ETIQUETA");
							medicina = rs.getInt("MEDICINA");
							ocultismo = rs.getInt("OCULTISMO");
							investigacion = rs.getInt("INVESTIGACION");
							negociacion = rs.getInt("NEGOCIACION");
							cSecretos = rs.getInt("CONOCIMIENTOS_SECRETOS");
							fuego = rs.getInt("FUEGO");
							agua = rs.getInt("AGUA");
							tierra = rs.getInt("TIERRA");
							viento = rs.getInt("VIENTO");
							druidica = rs.getInt("DRUIDICA");
							blanca = rs.getInt("BLANCA");
							negra = rs.getInt("NEGRA");
							arcana = rs.getInt("ARCANA");
							atletismo = rs.getInt("ATLETISMO");
							supervivencia = rs.getInt("SUPERVIVENCIA");
							equitacion = rs.getInt("EQUITACION");
							trampas = rs.getInt("TRAMPAS");
							sigilo = rs.getInt("SIGILO");
							armadura = rs.getString("ARMADURA");
							descripcionArm = rs.getString("DESCRIPCION_ARMADURA");
							posesionArm = rs.getString("POSESION_ARMADURA");
							prop1Arm = rs.getString("PROPIEDAD1_ARMADURA");
							prop2Arm = rs.getString("PROPIEDAD2_ARMADURA");
							prop3Arm = rs.getString("PROPIEDAD3_ARMADURA");
							weap1 = rs.getString("ARMA1");
							descripcionWeap1 = rs.getString("DESCRIPCION_ARMA1");
							posesionWeap1 = rs.getString("POSESION_ARMA1");
							prop1Weap1 = rs.getString("PROPIEDAD1_ARMA1");
							prop2Weap1 = rs.getString("PROPIEDAD2_ARMA1");
							prop3Weap1 = rs.getString("PROPIEDAD3_ARMA1");
							weap2 = rs.getString("ARMA2");
							descripcionWeap2 = rs.getString("DESCRIPCION_ARMA2");
							posesionWeap2 = rs.getString("POSESION_ARMA2");
							prop1Weap2 = rs.getString("PROPIEDAD1_ARMA2");
							prop2Weap2 = rs.getString("PROPIEDAD2_ARMA2");
							prop3Weap2 = rs.getString("PROPIEDAD3_ARMA2");
							weap3 = rs.getString("ARMA3");
							descripcionWeap3 = rs.getString("DESCRIPCION_ARMA3");
							posesionWeap3 = rs.getString("POSESION_ARMA3");
							prop1Weap3 = rs.getString("PROPIEDAD1_ARMA3");
							prop2Weap3 = rs.getString("PROPIEDAD2_ARMA3");
							prop3Weap3 = rs.getString("PROPIEDAD3_ARMA3");
							weap4 = rs.getString("ARMA4");
							descripcionWeap4 = rs.getString("DESCRIPCION_ARMA4");
							posesionWeap4 = rs.getString("POSESION_ARMA4");
							prop1Weap4 = rs.getString("PROPIEDAD1_ARMA4");
							prop2Weap4 = rs.getString("PROPIEDAD2_ARMA4");
							prop3Weap4 = rs.getString("PROPIEDAD3_ARMA4");
							obj1 = rs.getString("OBJETO1");
							descripcionObj1 = rs.getString("DESCRIPCION_OBJETO1");
							posesionObj1 = rs.getString("POSESION_OBJETO1");
							prop1Obj1 = rs.getString("PROPIEDAD1_OBJETO1");
							prop2Obj1 = rs.getString("PROPIEDAD2_OBJETO1");
							prop3Obj1 = rs.getString("PROPIEDAD3_OBJETO1");
							obj2 = rs.getString("OBJETO2");
							descripcionObj2 = rs.getString("DESCRIPCION_OBJETO2");
							posesionObj2 = rs.getString("POSESION_OBJETO2");
							prop1Obj2 = rs.getString("PROPIEDAD1_OBJETO2");
							prop2Obj2 = rs.getString("PROPIEDAD2_OBJETO2");
							prop3Obj2 = rs.getString("PROPIEDAD3_OBJETO2");
							obj3 = rs.getString("OBJETO3");
							descripcionObj3 = rs.getString("DESCRIPCION_OBJETO3");
							posesionObj3 = rs.getString("POSESION_OBJETO3");
							prop1Obj3 = rs.getString("PROPIEDAD1_OBJETO3");
							prop2Obj3 = rs.getString("PROPIEDAD2_OBJETO3");
							prop3Obj3 = rs.getString("PROPIEDAD3_OBJETO3");
							obj4 = rs.getString("OBJETO4");
							descripcionObj4 = rs.getString("DESCRIPCION_OBJETO4");
							posesionObj4 = rs.getString("POSESION_OBJETO4");
							prop1Obj4 = rs.getString("PROPIEDAD1_OBJETO4");
							prop2Obj4 = rs.getString("PROPIEDAD2_OBJETO4");
							prop3Obj4 = rs.getString("PROPIEDAD3_OBJETO4");
							acc1 = rs.getString("ACCESORIO1");
							descripcionAcc1 = rs.getString("DESCRIPCION_ACCESORIO1");
							posesionAcc1 = rs.getString("POSESION_ACCESORIO1");
							prop1Acc1 = rs.getString("PROPIEDAD1_ACCESORIO1");
							prop2Acc1 = rs.getString("PROPIEDAD2_ACCESORIO1");
							prop3Acc1 = rs.getString("PROPIEDAD3_ACCESORIO1");
							acc2 = rs.getString("ACCESORIO2");
							descripcionAcc2 = rs.getString("DESCRIPCION_ACCESORIO2");
							posesionAcc2 = rs.getString("POSESION_ACCESORIO2");
							prop1Acc2 = rs.getString("PROPIEDAD1_ACCESORIO2");
							prop2Acc2 = rs.getString("PROPIEDAD2_ACCESORIO2");
							prop3Acc2 = rs.getString("PROPIEDAD3_ACCESORIO2");
							acc3 = rs.getString("ACCESORIO3");
							descripcionAcc3 = rs.getString("DESCRIPCION_ACCESORIO3");
							posesionAcc3 = rs.getString("POSESION_ACCESORIO3");
							prop1Acc3 = rs.getString("PROPIEDAD1_ACCESORIO3");
							prop2Acc3 = rs.getString("PROPIEDAD2_ACCESORIO3");
							prop3Acc3 = rs.getString("PROPIEDAD3_ACCESORIO3");
							acc4 = rs.getString("ACCESORIO4");
							descripcionAcc4 = rs.getString("DESCRIPCION_ACCESORIO4");
							posesionAcc4 = rs.getString("POSESION_ACCESORIO4");
							prop1Acc4 = rs.getString("PROPIEDAD1_ACCESORIO4");
							prop2Acc4 = rs.getString("PROPIEDAD2_ACCESORIO4");
							prop3Acc4 = rs.getString("PROPIEDAD3_ACCESORIO4");
							tipoWeap1 = rs.getString("TIPOARMA1");
							tipoWeap2 = rs.getString("TIPOARMA2");
							tipoWeap3 = rs.getString("TIPOARMA3");
							tipoWeap4 = rs.getString("TIPOARMA4");
							tipoAcc1 = rs.getString("TIPOACC1");
							tipoAcc2 = rs.getString("TIPOACC2");
							tipoAcc3 = rs.getString("TIPOACC3");
							tipoAcc4 = rs.getString("TIPOACC4");
							arrojadizaWeap1 = rs.getString("SUBCLASE_ARMA1");
							arrojadizaWeap2 = rs.getString("SUBCLASE_ARMA2");
							arrojadizaWeap3 = rs.getString("SUBCLASE_ARMA3");
							arrojadizaWeap4 = rs.getString("SUBCLASE_ARMA4");
							salud = rs.getInt("SALUD");
							mana = rs.getInt("MANA");
							energia = rs.getInt("ENERGIA");
							experiencia = rs.getInt("EXPERIENCIA");
							sino = rs.getInt("SINO");
							nivel = rs.getInt("NIVEL");
							extras=rs.getString("EXTRAS");
							dinero=rs.getInt("DINERO");
							modificadores=rs.getString("MODIFICADORES");
							poderes=rs.getString("PODERES");
							exptotal=rs.getInt("EXPTOTAL");
							campeon=rs.getInt("CAMPEON");
							

						}
								if(tipoWeap1.equals("OneHanded")){
									if(posesionWeap1.equals("Normal")){
									
									weapon1=new OneHanded(weap1,descripcionWeap1,false,false,null,arrojadizaWeap1);
									}
									
									if(posesionWeap1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new OneHanded(weap1,descripcionWeap1,true,false,poss,arrojadizaWeap1);
										}
									
									if(posesionWeap1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new OneHanded(weap1,descripcionWeap1,false,true,poss,arrojadizaWeap1);
										}
								}
								
								if(tipoWeap1.equals("TwoHanded")){
									if(posesionWeap1.equals("Normal")){
									
									weapon1=new TwoHanded(weap1,descripcionWeap1,false,false,null,arrojadizaWeap1);
									}
									
									if(posesionWeap1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new TwoHanded(weap1,descripcionWeap1,true,false,poss,arrojadizaWeap1);
										}
									
									if(posesionWeap1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new TwoHanded(weap1,descripcionWeap1,false,true,poss,arrojadizaWeap1);
										}
								}
								
								if(tipoWeap1.equals("Pole")){
									if(posesionWeap1.equals("Normal")){
									
									weapon1=new Pole(weap1,descripcionWeap1,false,false,null,arrojadizaWeap1);
									}
									
									if(posesionWeap1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Pole(weap1,descripcionWeap1,true,false,poss,arrojadizaWeap1);
										}
									
									if(posesionWeap1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Pole(weap1,descripcionWeap1,false,true,poss,arrojadizaWeap1);
										}
								}
								
								if(tipoWeap1.equals("Ranged")){
									if(posesionWeap1.equals("Normal")){
									
									weapon1=new Ranged(weap1,descripcionWeap1,false,false,null,arrojadizaWeap1);
									}
									
									if(posesionWeap1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Ranged(weap1,descripcionWeap1,true,false,poss,arrojadizaWeap1);
										}
									
									if(posesionWeap1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Ranged(weap1,descripcionWeap1,false,true,poss,arrojadizaWeap1);
										}
								}
								
								if(tipoWeap1.equals("Shields")){
									if(posesionWeap1.equals("Normal")){
									
									weapon1=new Shields(weap1,descripcionWeap1,false,false,null,arrojadizaWeap1);
									}
									
									if(posesionWeap1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Shields(weap1,descripcionWeap1,true,false,poss,arrojadizaWeap1);
										}
									
									if(posesionWeap1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap1);
										pos.add(prop2Weap1);
										pos.add(prop3Weap1);
										Possesions poss=new Possesions(pos);
										weapon1=new Shields(weap1,descripcionWeap1,false,true,poss,arrojadizaWeap1);
										}
								}
								
								if(tipoWeap2.equals("OneHanded")){
									if(posesionWeap2.equals("Normal")){
									
									weapon2=new OneHanded(weap2,descripcionWeap1,false,false,null,arrojadizaWeap2);
									}
									
									if(posesionWeap2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new OneHanded(weap2,descripcionWeap1,true,false,poss,arrojadizaWeap2);
										}
									
									if(posesionWeap2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new OneHanded(weap2,descripcionWeap1,false,true,poss,arrojadizaWeap2);
										}
								}
								
								if(tipoWeap2.equals("TwoHanded")){
									if(posesionWeap2.equals("Normal")){
									
									weapon2=new TwoHanded(weap2,descripcionWeap1,false,false,null,arrojadizaWeap2);
									}
									
									if(posesionWeap2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new TwoHanded(weap2,descripcionWeap1,true,false,poss,arrojadizaWeap2);
										}
									
									if(posesionWeap2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new TwoHanded(weap2,descripcionWeap1,false,true,poss,arrojadizaWeap2);
										}
								}
								
								if(tipoWeap2.equals("Pole")){
									if(posesionWeap2.equals("Normal")){
									
									weapon2=new Pole(weap2,descripcionWeap1,false,false,null,arrojadizaWeap2);
									}
									
									if(posesionWeap2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Pole(weap2,descripcionWeap1,true,false,poss,arrojadizaWeap2);
										}
									
									if(posesionWeap2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Pole(weap2,descripcionWeap1,false,true,poss,arrojadizaWeap2);
										}
								}
								
								if(tipoWeap2.equals("Ranged")){
									if(posesionWeap2.equals("Normal")){
									
									weapon2=new Ranged(weap2,descripcionWeap1,false,false,null,arrojadizaWeap2);
									}
									
									if(posesionWeap2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Ranged(weap2,descripcionWeap1,true,false,poss,arrojadizaWeap2);
										}
									
									if(posesionWeap2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Ranged(weap2,descripcionWeap1,false,true,poss,arrojadizaWeap2);
										}
								}
								
								if(tipoWeap2.equals("Shields")){
									if(posesionWeap2.equals("Normal")){
									
									weapon2=new Shields(weap2,descripcionWeap1,false,false,null,arrojadizaWeap2);
									}
									
									if(posesionWeap2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Shields(weap2,descripcionWeap1,true,false,poss,arrojadizaWeap2);
										}
									
									if(posesionWeap2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap2);
										pos.add(prop2Weap2);
										pos.add(prop3Weap2);
										Possesions poss=new Possesions(pos);
										weapon2=new Shields(weap2,descripcionWeap1,false,true,poss,arrojadizaWeap2);
										}
								}
								
								
								if(tipoWeap3.equals("OneHanded")){
									if(posesionWeap3.equals("Normal")){
									
									weapon3=new OneHanded(weap3,descripcionWeap1,false,false,null,arrojadizaWeap3);
									}
									
									if(posesionWeap3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new OneHanded(weap3,descripcionWeap1,true,false,poss,arrojadizaWeap3);
										}
									
									if(posesionWeap3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new OneHanded(weap3,descripcionWeap1,false,true,poss,arrojadizaWeap3);
										}
								}
								
								if(tipoWeap3.equals("TwoHanded")){
									if(posesionWeap3.equals("Normal")){
									
									weapon3=new TwoHanded(weap3,descripcionWeap1,false,false,null,arrojadizaWeap3);
									}
									
									if(posesionWeap3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new TwoHanded(weap3,descripcionWeap1,true,false,poss,arrojadizaWeap3);
										}
									
									if(posesionWeap3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new TwoHanded(weap3,descripcionWeap1,false,true,poss,arrojadizaWeap3);
										}
								}
								
								if(tipoWeap3.equals("Pole")){
									if(posesionWeap3.equals("Normal")){
									
									weapon3=new Pole(weap3,descripcionWeap1,false,false,null,arrojadizaWeap3);
									}
									
									if(posesionWeap3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Pole(weap3,descripcionWeap1,true,false,poss,arrojadizaWeap3);
										}
									
									if(posesionWeap3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Pole(weap3,descripcionWeap1,false,true,poss,arrojadizaWeap3);
										}
								}
								
								if(tipoWeap3.equals("Ranged")){
									if(posesionWeap3.equals("Normal")){
									
									weapon3=new Ranged(weap3,descripcionWeap1,false,false,null,arrojadizaWeap3);
									}
									
									if(posesionWeap3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Ranged(weap3,descripcionWeap1,true,false,poss,arrojadizaWeap3);
										}
									
									if(posesionWeap3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Ranged(weap3,descripcionWeap1,false,true,poss,arrojadizaWeap3);
										}
								}
								
								if(tipoWeap3.equals("Shields")){
									if(posesionWeap3.equals("Normal")){
									
									weapon3=new Shields(weap3,descripcionWeap1,false,false,null,arrojadizaWeap3);
									}
									
									if(posesionWeap3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Shields(weap3,descripcionWeap1,true,false,poss,arrojadizaWeap3);
										}
									
									if(posesionWeap3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap3);
										pos.add(prop2Weap3);
										pos.add(prop3Weap3);
										Possesions poss=new Possesions(pos);
										weapon3=new Shields(weap3,descripcionWeap1,false,true,poss,arrojadizaWeap3);
										}
								}
								
								if(tipoWeap4.equals("OneHanded")){
									if(posesionWeap4.equals("Normal")){
									
									weapon4=new OneHanded(weap4,descripcionWeap1,false,false,null,arrojadizaWeap4);
									}
									
									if(posesionWeap4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new OneHanded(weap4,descripcionWeap1,true,false,poss,arrojadizaWeap4);
										}
									
									if(posesionWeap4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new OneHanded(weap4,descripcionWeap1,false,true,poss,arrojadizaWeap4);
										}
								}
								
								if(tipoWeap4.equals("TwoHanded")){
									if(posesionWeap4.equals("Normal")){
									
									weapon4=new TwoHanded(weap4,descripcionWeap1,false,false,null,arrojadizaWeap4);
									}
									
									if(posesionWeap4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new TwoHanded(weap4,descripcionWeap1,true,false,poss,arrojadizaWeap4);
										}
									
									if(posesionWeap4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new TwoHanded(weap4,descripcionWeap1,false,true,poss,arrojadizaWeap4);
										}
								}
								
								if(tipoWeap4.equals("Pole")){
									if(posesionWeap4.equals("Normal")){
									
									weapon4=new Pole(weap4,descripcionWeap1,false,false,null,arrojadizaWeap4);
									}
									
									if(posesionWeap4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Pole(weap4,descripcionWeap1,true,false,poss,arrojadizaWeap4);
										}
									
									if(posesionWeap4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Pole(weap4,descripcionWeap1,false,true,poss,arrojadizaWeap4);
										}
								}
								
								if(tipoWeap4.equals("Ranged")){
									if(posesionWeap4.equals("Normal")){
									
									weapon4=new Ranged(weap4,descripcionWeap1,false,false,null,arrojadizaWeap4);
									}
									
									if(posesionWeap4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Ranged(weap4,descripcionWeap1,true,false,poss,arrojadizaWeap4);
										}
									
									if(posesionWeap4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Ranged(weap4,descripcionWeap1,false,true,poss,arrojadizaWeap4);
										}
								}
								
								if(tipoWeap4.equals("Shields")){
									if(posesionWeap4.equals("Normal")){
									
									weapon4=new Shields(weap4,descripcionWeap1,false,false,null,arrojadizaWeap4);
									}
									
									if(posesionWeap4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Shields(weap4,descripcionWeap1,true,false,poss,arrojadizaWeap4);
										}
									
									if(posesionWeap4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Weap4);
										pos.add(prop2Weap4);
										pos.add(prop3Weap4);
										Possesions poss=new Possesions(pos);
										weapon4=new Shields(weap4,descripcionWeap1,false,true,poss,arrojadizaWeap4);
										}
								}
								
								if(posesionObj1.equals("Normal")){
									
									misc1=new Misc(obj1,descripcionObj1,false,false,null);
								}
								if(posesionObj1.equals("Posesión")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj1);
									pos.add(prop2Obj1);
									pos.add(prop3Obj1);
									Possesions poss=new Possesions(pos);
									misc1=new Misc(obj1,descripcionObj1,true,false,poss);
								}
								if(posesionObj1.equals("Legendario")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj1);
									pos.add(prop2Obj1);
									pos.add(prop3Obj1);
									Possesions poss=new Possesions(pos);
									misc1=new Misc(obj1,descripcionObj1,false,true,poss);
								}
								
								if(posesionObj2.equals("Normal")){
									
									misc2=new Misc(obj2,descripcionObj2,false,false,null);
								}
								if(posesionObj2.equals("Posesión")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj2);
									pos.add(prop2Obj2);
									pos.add(prop3Obj2);
									Possesions poss=new Possesions(pos);
									misc2=new Misc(obj2,descripcionObj2,true,false,poss);
								}
								if(posesionObj2.equals("Legendario")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj2);
									pos.add(prop2Obj2);
									pos.add(prop3Obj2);
									Possesions poss=new Possesions(pos);
									misc2=new Misc(obj2,descripcionObj2,false,true,poss);
								}
								
								if(posesionObj3.equals("Normal")){
									
									misc3=new Misc(obj3,descripcionObj3,false,false,null);
								}
								if(posesionObj3.equals("Posesión")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj3);
									pos.add(prop2Obj3);
									pos.add(prop3Obj3);
									Possesions poss=new Possesions(pos);
									misc3=new Misc(obj3,descripcionObj3,true,false,poss);
								}
								if(posesionObj3.equals("Legendario")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj3);
									pos.add(prop2Obj3);
									pos.add(prop3Obj3);
									Possesions poss=new Possesions(pos);
									misc3=new Misc(obj3,descripcionObj3,false,true,poss);
								}
								if(posesionObj4.equals("Normal")){
									
									misc4=new Misc(obj4,descripcionObj4,false,false,null);
								}
								if(posesionObj4.equals("Posesión")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj4);
									pos.add(prop2Obj4);
									pos.add(prop3Obj4);
									Possesions poss=new Possesions(pos);
									misc4=new Misc(obj4,descripcionObj4,true,false,poss);
								}
								if(posesionObj4.equals("Legendario")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Obj4);
									pos.add(prop2Obj4);
									pos.add(prop3Obj4);
									Possesions poss=new Possesions(pos);
									misc4=new Misc(obj4,descripcionObj4,false,true,poss);
								}
								
								if(tipoAcc1.equals("Cloak")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Cloak(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								
								
								if(tipoAcc1.equals("Earrings")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Cloak(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc1.equals("Necklace")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Cloak(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc1.equals("Rings")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Cloak(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc1.equals("Cloak")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Cloak(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Cloak(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								
								
								if(tipoAcc1.equals("Earrings")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Earrings(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Earrings(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Earrings(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc1.equals("Necklace")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Necklace(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Necklace(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Necklace(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc1.equals("Rings")){
									if(posesionAcc1.equals("Normal")){
									
									accesorie1=new Rings(acc1,descripcionAcc1,false,false,null);
									}
									
									if(posesionAcc1.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Rings(acc1,descripcionAcc1,true,false,poss);
										}
									
									if(posesionAcc1.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc1);
										pos.add(prop2Acc1);
										pos.add(prop3Acc1);
										Possesions poss=new Possesions(pos);
										accesorie1=new Rings(acc1,descripcionAcc1,false,true,poss);
										}
								}
								
								if(tipoAcc2.equals("Cloak")){
									if(posesionAcc2.equals("Normal")){
									
									accesorie2=new Cloak(acc2,descripcionAcc2,false,false,null);
									}
									
									if(posesionAcc2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Cloak(acc2,descripcionAcc2,true,false,poss);
										}
									
									if(posesionAcc2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Cloak(acc2,descripcionAcc2,false,true,poss);
										}
								}
								
								
								
								if(tipoAcc2.equals("Earrings")){
									if(posesionAcc2.equals("Normal")){
									
									accesorie2=new Earrings(acc2,descripcionAcc2,false,false,null);
									}
									
									if(posesionAcc2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Earrings(acc2,descripcionAcc2,true,false,poss);
										}
									
									if(posesionAcc2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Earrings(acc2,descripcionAcc2,false,true,poss);
										}
								}
								
								if(tipoAcc2.equals("Necklace")){
									if(posesionAcc2.equals("Normal")){
									
									accesorie2=new Necklace(acc2,descripcionAcc2,false,false,null);
									}
									
									if(posesionAcc2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Necklace(acc2,descripcionAcc2,true,false,poss);
										}
									
									if(posesionAcc2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Necklace(acc2,descripcionAcc2,false,true,poss);
										}
								}
								
								if(tipoAcc2.equals("Rings")){
									if(posesionAcc2.equals("Normal")){
									
									accesorie2=new Rings(acc2,descripcionAcc2,false,false,null);
									}
									
									if(posesionAcc2.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Rings(acc2,descripcionAcc2,true,false,poss);
										}
									
									if(posesionAcc2.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc2);
										pos.add(prop2Acc2);
										pos.add(prop3Acc2);
										Possesions poss=new Possesions(pos);
										accesorie2=new Rings(acc2,descripcionAcc2,false,true,poss);
										}
								}
								
								if(tipoAcc3.equals("Cloak")){
									if(posesionAcc3.equals("Normal")){
									
									accesorie3=new Cloak(acc3,descripcionAcc3,false,false,null);
									}
									
									if(posesionAcc3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Cloak(acc3,descripcionAcc3,true,false,poss);
										}
									
									if(posesionAcc3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Cloak(acc3,descripcionAcc3,false,true,poss);
										}
								}
								
								
								
								if(tipoAcc3.equals("Earrings")){
									if(posesionAcc3.equals("Normal")){
									
									accesorie3=new Earrings(acc3,descripcionAcc3,false,false,null);
									}
									
									if(posesionAcc3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Earrings(acc3,descripcionAcc3,true,false,poss);
										}
									
									if(posesionAcc3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Earrings(acc3,descripcionAcc3,false,true,poss);
										}
								}
								
								if(tipoAcc3.equals("Necklace")){
									if(posesionAcc3.equals("Normal")){
									
									accesorie3=new Necklace(acc3,descripcionAcc3,false,false,null);
									}
									
									if(posesionAcc3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Necklace(acc3,descripcionAcc3,true,false,poss);
										}
									
									if(posesionAcc3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Necklace(acc3,descripcionAcc3,false,true,poss);
										}
								}
								
								if(tipoAcc3.equals("Rings")){
									if(posesionAcc3.equals("Normal")){
									
									accesorie3=new Rings(acc3,descripcionAcc3,false,false,null);
									}
									
									if(posesionAcc3.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Rings(acc3,descripcionAcc3,true,false,poss);
										}
									
									if(posesionAcc3.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc3);
										pos.add(prop2Acc3);
										pos.add(prop3Acc3);
										Possesions poss=new Possesions(pos);
										accesorie3=new Rings(acc3,descripcionAcc3,false,true,poss);
										}
								}
								
								if(tipoAcc4.equals("Cloak")){
									if(posesionAcc4.equals("Normal")){
									
									accesorie4=new Cloak(acc4,descripcionAcc4,false,false,null);
									}
									
									if(posesionAcc4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Cloak(acc4,descripcionAcc4,true,false,poss);
										}
									
									if(posesionAcc4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Cloak(acc4,descripcionAcc4,false,true,poss);
										}
								}
								
								
								
								if(tipoAcc4.equals("Earrings")){
									if(posesionAcc4.equals("Normal")){
									
									accesorie4=new Earrings(acc4,descripcionAcc4,false,false,null);
									}
									
									if(posesionAcc4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Earrings(acc4,descripcionAcc4,true,false,poss);
										}
									
									if(posesionAcc4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Earrings(acc4,descripcionAcc4,false,true,poss);
										}
								}
								
								if(tipoAcc4.equals("Necklace")){
									if(posesionAcc4.equals("Normal")){
									
									accesorie4=new Necklace(acc4,descripcionAcc4,false,false,null);
									}
									
									if(posesionAcc4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Necklace(acc4,descripcionAcc4,true,false,poss);
										}
									
									if(posesionAcc4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Necklace(acc4,descripcionAcc4,false,true,poss);
										}
								}
								
								if(tipoAcc4.equals("Rings")){
									if(posesionAcc4.equals("Normal")){
									
									accesorie4=new Rings(acc4,descripcionAcc4,false,false,null);
									}
									
									if(posesionAcc4.equals("Posesión")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Rings(acc4,descripcionAcc4,true,false,poss);
										}
									
									if(posesionAcc4.equals("Legendario")){
										ArrayList<String> pos=new ArrayList<String>();
										pos.add(prop1Acc4);
										pos.add(prop2Acc4);
										pos.add(prop3Acc4);
										Possesions poss=new Possesions(pos);
										accesorie4=new Rings(acc4,descripcionAcc4,false,true,poss);
										}
								}
								
								if(posesionArm.equals("Normal")){
									
									armor=new Armor(armadura,descripcionArm,false,false,null);
								}
								if(posesionArm.equals("Posesión")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Arm);
									pos.add(prop2Arm);
									pos.add(prop3Arm);
									Possesions poss=new Possesions(pos);
									armor=new Armor(armadura,descripcionArm,true,false,poss);
								}
								
								if(posesionArm.equals("Legendario")){
									ArrayList<String> pos=new ArrayList<String>();
									pos.add(prop1Arm);
									pos.add(prop2Arm);
									pos.add(prop3Arm);
									Possesions poss=new Possesions(pos);
									armor=new Armor(armadura,descripcionArm,false,true,poss);
								}
								Race race=new Race(raza);
								AtributePoints puntosAtrib=new AtributePoints();
								puntosAtrib.setPoints(0);
								Atributes atributos=new Atributes(puntosAtrib);
								atributos.setCharisma(carisma);
								atributos.setDexterity(destreza);
								atributos.setIntelligence(inteligencia);
								atributos.setMagicres(resistenciaM);
								atributos.setResistance(resistencia);
								atributos.setPerception(percepcion);
								atributos.setStrength(fuerza);
								SkillPoints puntosSkill=new SkillPoints();
								puntosSkill.setPoints(0);
								CombatSkills combate=new CombatSkills(puntosSkill);
								combate.setBlock(bloquear);
								combate.setDodge(esquivar);
								combate.setOneHanded(unamano);
								combate.setPole(asta);
								combate.setRanged(distancia);
								combate.setTwoHanded(dosmanos);
								KnowledgeSkills conocimiento=new KnowledgeSkills(puntosSkill);
								conocimiento.setArtofWar(arteGuerra);
								conocimiento.setDiplomacy(diplomacia);
								conocimiento.setEtiquette(etiqueta);
								conocimiento.setMedicine(medicina);
								conocimiento.setNegotiation(negociacion);
								conocimiento.setOccultism(ocultismo);
								conocimiento.setResearch(investigacion);
								conocimiento.setSecretKnowledge(cSecretos);
								MagicSkills magia=new MagicSkills(puntosSkill);
								magia.setArcane(arcana);
								magia.setBlack(negra);
								magia.setDruidic(druidica);
								magia.setEarth(tierra);
								magia.setFire(fuego);
								magia.setWater(agua);
								magia.setWhite(blanca);
								magia.setWind(viento);
								KnowHowSkills destrezas= new KnowHowSkills (puntosSkill);
								destrezas.setAthletics(atletismo);
								destrezas.setEquitation(equitacion);
								destrezas.setStealth(sigilo);
								destrezas.setSurvival(supervivencia);
								destrezas.setTraps(trampas);
								Blessing blessing=new Blessing(bendicion);
								Privileges privs=new Privileges();
								if(privilegio1!=null){
								privs.add(privilegio1);}
								if(privilegio2!=null){
									privs.add(privilegio2);}
								if(privilegio3!=null){
									privs.add(privilegio3);}
								if(privilegio4!=null){
									privs.add(privilegio4);}
								if(privilegio5!=null){
									privs.add(privilegio5);}
								Setbacks reves=new Setbacks();
								if(reves1!=null){
								reves.add(reves1);}
								if(reves2!=null){
								reves.add(reves2);}
								if(reves3!=null){
									reves.add(reves3);
								}
								if(reves4!=null){
								reves.add(reves4);}
								boolean camp=false;
								if(campeon==1){
									camp=true;
								}
								Equipment equipment=new Equipment();
								Characters intermedio=new Characters(nombre,race,descripcionF,edad,sino,salud,energia,mana,
										atributos,combate,conocimiento,magia,destrezas,blessing,privs,reves,camp,armor,equipment,weapon1,weapon2,weapon3,weapon4,
										misc1,misc2,misc3,misc4,accesorie1,accesorie2,accesorie3,accesorie4,experiencia,nivel,dinero,extras,modificadores,poderes);
					if(button_10.getText().equals("")){
					
						button_10.setText(seleccion.toString());
						npc1=intermedio;
					}
					else{ if(button_11.getText().equals("")){
					
						button_11.setText(seleccion.toString());
						npc2=intermedio;
					}
					else{
						if(button_12.getText().equals("")){
							
							button_12.setText(seleccion.toString());
							npc3=intermedio;
						}
					
						else{if(button_13.getText().equals("")){
							
							button_13.setText(seleccion.toString());
							npc4=intermedio;
						}
						else{if(button_14.getText().equals("")){
							
							button_14.setText(seleccion.toString());
							npc5=intermedio;
						}
						else{if(button_15.getText().equals("")){
							
							button_15.setText(seleccion.toString());
							npc6=intermedio;
						}
						else{if(button_16.getText().equals("")){
							
							button_16.setText(seleccion.toString());
							npc7=intermedio;
						}
						
						else{if(button_17.getText().equals("")){
							
							button_17.setText(seleccion.toString());
							npc8=intermedio;
						}
						else{if(button_18.getText().equals("")){
							
							button_18.setText(seleccion.toString());
							npc9=intermedio;
						}
						
						else{if(button_19.getText().equals("")){
							
							button_19.setText(seleccion.toString());
							npc10=intermedio;
						}}
						}
						
						}
						}
						
						}
						}
						}
					}
					
					}
			
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (OutOfPointsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AtributeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SkillOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (PrivilegeOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
				
			
				
			}
		});
		
}
	
	  public void ListenThread() 
	    {
	         Thread IncomingReader = new Thread(new IncomingReader());
	         IncomingReader.start();
	    }
	    
	    //--------------------------//
	    
	    public void userAdd(String data) 
	    {
	         users.add(data);
	    }
	    
	    //--------------------------//
	    
	    public void userRemove(String data) 
	    {
	         textArea.append(data + " está offline.\n");
	    }
	    
	    //--------------------------//
	    
	    public void writeUsers() 
	    {
	         String[] tempList = new String[(users.size())];
	         users.toArray(tempList);
	         for (String token:tempList) 
	         {
	             //users.append(token + "\n");
	         }
	    }
	    
	    //--------------------------//
	    
	    public void sendDisconnect() 
	    {
	        String bye = (username + ": :Desconectado");
	        try
	        {
	            writer.println(bye); 
	            writer.flush(); 
	        } catch (Exception e) 
	        {
	            textArea.append("No se pudo enviar mensaje de desconexión.\n");
	        }
	    }

	    //--------------------------//
	    
	    public void Disconnect() 
	    {
	        try 
	        {
	            textArea.append("Desconectado.\n");
	            sock.close();
	        } catch(Exception ex) {
	            textArea.append("Fallo al desconectar. \n");
	        }
	        isConnected = false;

	    }
	    
	    public void Conectar(){
	    	
	    	//GEN-FIRST:event_b_connectActionPerformed
	        if (isConnected == false) 
	        {
	            username = Loader.usuario;
	          

	            try 
	            {
	                sock = new Socket(address, port);
	                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
	                reader = new BufferedReader(streamreader);
	                writer = new PrintWriter(sock.getOutputStream());
	                writer.println(username + ":se ha conectado.:Connect");
	                writer.flush(); 
	                isConnected = true; 
	            } 
	            catch (Exception ex) 
	            {
	                textArea.append("No se pudo conectar vuelva a intentarlo. \n");

	            }
	            
	            ListenThread();
	            
	        } else if (isConnected == true) 
	        {
	            textArea.append("Ya estas conectado. \n");
	        }
	    
	    }
}
