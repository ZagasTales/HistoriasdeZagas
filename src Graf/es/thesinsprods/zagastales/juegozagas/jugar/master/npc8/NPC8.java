package es.thesinsprods.zagastales.juegozagas.jugar.master.npc8;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

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
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;
import es.thesinsprods.zagastales.juegozagas.jugar.BuscarPartida;
import es.thesinsprods.zagastales.juegozagas.jugar.master.JugarOnline;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;

public class NPC8 {

	MorpheusFont mf = new MorpheusFont();
	final ConexionDBOnline con = new ConexionDBOnline();
	final Connection p = con.accederDB();
	final Statement tabla=p.createStatement();
	private JFrame frmHistoriasDeZagas;
	public static int saludM;
	public static int energiaM;
	public static int manaM;
	
	JProgressBar progressBar = new JProgressBar();
	JProgressBar progressBar_2 = new JProgressBar();
	JProgressBar progressBar_1 = new JProgressBar();
	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	    private JTextField textField_1;
	
	    
	    
	    
	   

	    
	    
	    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NPC8 window = new NPC8();
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
	public NPC8() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
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
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(NPC8.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 590, 346);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
	

		
		JLabel label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText(JugarOnline.npc8.getName());
		label.setForeground(Color.WHITE);
		label.setFont(mf.MyFont(0, 32));
		label.setBounds(25, 11, 549, 53);
		frmHistoriasDeZagas.getContentPane().add(label);
		
		JLabel label_1 = new JLabel((String) null);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setText(JugarOnline.npc8.getRace().getRace());
		label_1.setForeground(Color.WHITE);
		label_1.setFont(mf.MyFont(0, 20));
		label_1.setBounds(25, 75, 256, 26);
		frmHistoriasDeZagas.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Nivel: "+JugarOnline.npc8.getNivel());
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(mf.MyFont(0, 20));
		label_2.setBounds(318, 75, 256, 26);
		frmHistoriasDeZagas.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Salud:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(mf.MyFont(0, 16));
		label_3.setBounds(10, 120, 46, 14);
		frmHistoriasDeZagas.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Energ\u00EDa:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(mf.MyFont(0, 16));
		label_4.setBounds(10, 145, 66, 14);
		frmHistoriasDeZagas.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Man\u00E1:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(mf.MyFont(0, 16));
		label_5.setBounds(10, 170, 46, 14);
		frmHistoriasDeZagas.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Edad: "+JugarOnline.npc8.getAge());
		label_6.setForeground(Color.WHITE);
		label_6.setFont(mf.MyFont(0, 16));
		label_6.setBounds(10, 195, 105, 14);
		frmHistoriasDeZagas.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Experiencia:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(mf.MyFont(0, 16));
		label_7.setBounds(10, 223, 105, 14);
		frmHistoriasDeZagas.getContentPane().add(label_7);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(""+JugarOnline.npc8.getExperience());
		textField_1.setColumns(10);
		textField_1.setBounds(102, 220, 60, 20);
		frmHistoriasDeZagas.getContentPane().add(textField_1);
		
		

		progressBar.setForeground(Color.RED);
		progressBar.setMaximum(saludM);
		progressBar.setValue(JugarOnline.npc8.getLife());
		progressBar.setString(progressBar.getValue()+"/"+progressBar.getMaximum());
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(85, 120, 200, 14);
		frmHistoriasDeZagas.getContentPane().add(progressBar);
	
		progressBar_2.setValue(JugarOnline.npc8.getEndurance());
		progressBar_2.setStringPainted(true);
		progressBar_2.setMaximum(energiaM);
		progressBar_2.setString(progressBar_2.getValue()+"/"+progressBar_2.getMaximum());
		progressBar_2.setForeground(new Color(0, 128, 0));
		progressBar_2.setBackground(Color.WHITE);
		progressBar_2.setBounds(85, 145, 200, 14);
		frmHistoriasDeZagas.getContentPane().add(progressBar_2);
		

		progressBar_1.setValue(JugarOnline.npc8.getMana());
		progressBar_1.setStringPainted(true);
		progressBar_1.setMaximum(manaM);
		progressBar_1.setString(progressBar_1.getValue()+"/"+progressBar_1.getMaximum());
		progressBar_1.setForeground(Color.BLUE);
		progressBar_1.setBackground(Color.WHITE);
		progressBar_1.setBounds(85, 170, 200, 14);
		frmHistoriasDeZagas.getContentPane().add(progressBar_1);
		
		final JButton button = new JButton("Atributos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AtributosJugadores window = new AtributosJugadores();
				window.getFrame().setVisible(true);
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button.setFont(mf.MyFont(0,11));
		button.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setBounds(318, 120, 123, 23);
		frmHistoriasDeZagas.getContentPane().add(button);
		
		final JButton button_1 = new JButton("Extras");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExtrasJugadores window = new ExtrasJugadores();
				window.getFrmHistoriasDeZagas().setVisible(true);
				
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_1.setFont(mf.MyFont(0,11));
		button_1.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.WHITE);
		button_1.setBounds(451, 120, 123, 23);
		frmHistoriasDeZagas.getContentPane().add(button_1);
		
		final JButton button_2 = new JButton("Habilidades");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] personaje={"Combate","Conocimientos","Magia","Destrezas"};
				Object seleccion = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Seleccione una opcion",
						"Ver Habilidades", JOptionPane.PLAIN_MESSAGE,
						null,personaje,null);
				seleccion=seleccion+"";
				if(seleccion.equals("Combate")){
					
					CombateJugadores window = new CombateJugadores();
					window.getFrame().setVisible(true);
				}
				if(seleccion.equals("Conocimientos")){
					
					ConocimientosJugadores window = new ConocimientosJugadores();
					window.getFrmHistoriasDeZagas().setVisible(true);
				}
				if(seleccion.equals("Magia")){
					
					MagiaJugadores window = new MagiaJugadores();
					window.getFrmHistoriasDeZagas().setVisible(true);
				}
				if(seleccion.equals("Destrezas")){
					
					DestrezasJugadores window = new DestrezasJugadores();
					window.getFrame().setVisible(true);
				}
				
				
				
			}
		});
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_2.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_2.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_2.setFont(mf.MyFont(0,11));
		button_2.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setForeground(Color.WHITE);
		button_2.setBounds(318, 152, 123, 23);
		frmHistoriasDeZagas.getContentPane().add(button_2);
		
		final JButton button_3 = new JButton("Privilegios");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PrivilegiosJugadores window = new PrivilegiosJugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_3.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_3.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_3.setFont(mf.MyFont(0,11));
		button_3.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
		button_3.setFocusPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setForeground(Color.WHITE);
		button_3.setBounds(451, 152, 123, 23);
		frmHistoriasDeZagas.getContentPane().add(button_3);
		
		final JButton button_4 = new JButton("Equipo");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				EquipoJugadores window = new EquipoJugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_4.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_4.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_4.setFont(mf.MyFont(0,11));
		button_4.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
		button_4.setFocusPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setForeground(Color.WHITE);
		button_4.setBounds(318, 186, 123, 23);
		frmHistoriasDeZagas.getContentPane().add(button_4);
		
		final JButton button_5 = new JButton("Reveses");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RevesesJugadores window = new RevesesJugadores();
				window.getFrame().setVisible(true);
			}
		});
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_5.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_5.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_5.setFont(mf.MyFont(0,11));
		button_5.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
		button_5.setFocusPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setForeground(Color.WHITE);
		button_5.setBounds(451, 186, 123, 23);
		frmHistoriasDeZagas.getContentPane().add(button_5);
		
		final JButton button_6 = new JButton("Estado");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane
				.showMessageDialog(
						frmHistoriasDeZagas,
						"El estado del personaje es: "+JugarOnline.npc8.getEstado(),
						"", JOptionPane.PLAIN_MESSAGE);
			}
		});
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_6.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_6.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_6.setFont(mf.MyFont(0,11));
		button_6.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
		button_6.setFocusPainted(false);
		button_6.setContentAreaFilled(false);
		button_6.setBorderPainted(false);
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.setForeground(Color.WHITE);
		button_6.setBounds(318, 220, 123, 23);
		frmHistoriasDeZagas.getContentPane().add(button_6);
		
		final JButton button_7 = new JButton("Descripci\u00F3n");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DescripcionJugadores window = new DescripcionJugadores();
				window.getFrame().setVisible(true);
				
			}
		});
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_7.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_7.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_7.setFont(mf.MyFont(0,11));
		button_7.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton fichas pj1.png")));
		button_7.setFocusPainted(false);
		button_7.setContentAreaFilled(false);
		button_7.setBorderPainted(false);
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setForeground(Color.WHITE);
		button_7.setBounds(451, 220, 123, 23);
		frmHistoriasDeZagas.getContentPane().add(button_7);
		
		final JButton button_8 = new JButton("");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_8.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton atras2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_8.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton atras.png")));
			}
		});
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHistoriasDeZagas.dispose();
			}
		});
		button_8.setIcon(new ImageIcon(NPC8.class.getResource("/images/boton atras.png")));
		button_8.setOpaque(false);
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_8.setFocusPainted(false);
		button_8.setContentAreaFilled(false);
		button_8.setBorderPainted(false);
		button_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

						null, null));
		button_8.setBackground(new Color(139, 69, 19));
		button_8.setBounds(10, 261, 99, 45);
		frmHistoriasDeZagas.getContentPane().add(button_8);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NPC8.class.getResource("/images/background-ventanajugadores.jpg")));
		lblNewLabel.setBounds(0, 0, 584, 708);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
	
	}
	
	
  
    
   
 
}

