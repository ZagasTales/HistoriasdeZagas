package es.thesinsprods.zagastales.juegozagas.jugar.offline;

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

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OfflineConCon {

	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	private JFrame frmHistoriasDeZagas;
	
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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfflineConCon window = new OfflineConCon();
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
	public OfflineConCon() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
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
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(OfflineConCon.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setTitle("Historias de Zagas");
		frmHistoriasDeZagas.setBounds(100, 100, 700, 700);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHistoriasDeZagas.setLocationRelativeTo(null);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		
		final ConexionDBOnline con = new ConexionDBOnline();
		final Connection p = con.accederDB();
		final Statement tabla=p.createStatement();
		
		final JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FichaPersonaje1 window=new FichaPersonaje1();
				window.getFrame().setVisible(true);
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
				
			}
			
		});
		button.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
		button.setOpaque(false);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBounds(505, 100, 179, 32);
		frmHistoriasDeZagas.getContentPane().add(button);
		
		final JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_1.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_1.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
				
			}
		});
		button_1.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
		button_1.setOpaque(false);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBounds(505, 150, 179, 32);
		frmHistoriasDeZagas.getContentPane().add(button_1);
		
		final JButton button_2 = new JButton("");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_2.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_2.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
				
			}
		});
		button_2.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
		button_2.setOpaque(false);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		button_2.setBounds(505, 200, 179, 32);
		frmHistoriasDeZagas.getContentPane().add(button_2);
		
		final JButton button_3 = new JButton("");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_3.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_3.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
				
			}
		});
		button_3.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
		button_3.setOpaque(false);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_3.setContentAreaFilled(false);
		button_3.setBorder(null);
		button_3.setBounds(505, 250, 179, 32);
		frmHistoriasDeZagas.getContentPane().add(button_3);
		
		final JButton button_4 = new JButton("");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_4.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_4.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
				
			}
		});
		button_4.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
		button_4.setOpaque(false);
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_4.setContentAreaFilled(false);
		button_4.setBorder(null);
		button_4.setBounds(505, 300, 179, 32);
		frmHistoriasDeZagas.getContentPane().add(button_4);
		
		final JButton button_5 = new JButton("");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_5.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_5.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
				
			}
		});
		button_5.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
		button_5.setOpaque(false);
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_5.setContentAreaFilled(false);
		button_5.setBorder(null);
		button_5.setBounds(505, 350, 179, 32);
		frmHistoriasDeZagas.getContentPane().add(button_5);
		
		final JButton button_6 = new JButton("");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_6.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_6.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
				
			}
		});
		button_6.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
		button_6.setOpaque(false);
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_6.setContentAreaFilled(false);
		button_6.setBorder(null);
		button_6.setBounds(505, 400, 179, 32);
		frmHistoriasDeZagas.getContentPane().add(button_6);
		
		final JButton button_7 = new JButton("");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_7.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_7.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
				
			}
		});
		button_7.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
		button_7.setOpaque(false);
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_7.setContentAreaFilled(false);
		button_7.setBorder(null);
		button_7.setBounds(505, 450, 179, 32);
		frmHistoriasDeZagas.getContentPane().add(button_7);
		
		final JButton button_8 = new JButton("");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_8.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_8.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
				
			}
		});
		button_8.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
		button_8.setOpaque(false);
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_8.setContentAreaFilled(false);
		button_8.setBorder(null);
		button_8.setBounds(505, 500, 179, 32);
		frmHistoriasDeZagas.getContentPane().add(button_8);
		
		final JButton button_9 = new JButton("");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_9.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_9.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
				
			}
		});
		button_9.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/boton personajes jugar.png")));
		button_9.setOpaque(false);
		button_9.setHorizontalTextPosition(SwingConstants.CENTER);
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_9.setContentAreaFilled(false);
		button_9.setBorder(null);
		button_9.setBounds(505, 550, 179, 32);
		frmHistoriasDeZagas.getContentPane().add(button_9);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 694, 26);
		frmHistoriasDeZagas.getContentPane().add(menuBar);
		
		JMenu mnCargar = new JMenu("Cargar");
		menuBar.add(mnCargar);
		
		JMenuItem mntmPersonaje = new JMenuItem("Personaje");
		mntmPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		mnCargar.add(mntmPersonaje);
		
		JMenuItem mntmNpc = new JMenuItem("NPC");
		mnCargar.add(mntmNpc);
		
		JMenuItem mntmNpcGenrico = new JMenuItem("NPC Gen\u00E9rico");
		mnCargar.add(mntmNpcGenrico);
		
		JLabel lblPersonajes = new JLabel("PERSONAJES");
		lblPersonajes.setForeground(Color.WHITE);
		lblPersonajes.setFont(mf.MyFont(0, 15));
		lblPersonajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonajes.setBounds(505, 33, 179, 44);
		frmHistoriasDeZagas.getContentPane().add(lblPersonajes);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(57, 33, 16));
		panel.setBounds(479, 21, 16, 651);
		frmHistoriasDeZagas.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(57, 33, 16));
		panel_1.setBounds(479, 595, 215, 16);
		frmHistoriasDeZagas.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(new Color(57, 33, 16));
		panel_2.setBounds(479, 25, 215, 16);
		frmHistoriasDeZagas.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBackground(new Color(57, 33, 16));
		panel_3.setBounds(479, 69, 215, 16);
		frmHistoriasDeZagas.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBackground(new Color(57, 33, 16));
		panel_4.setBounds(479, 656, 215, 16);
		frmHistoriasDeZagas.getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBackground(new Color(57, 33, 16));
		panel_5.setBounds(0, 656, 495, 16);
		frmHistoriasDeZagas.getContentPane().add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBackground(new Color(57, 33, 16));
		panel_6.setBounds(0, 25, 495, 16);
		frmHistoriasDeZagas.getContentPane().add(panel_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OfflineConCon.class.getResource("/images/background-jugar.jpg")));
		lblNewLabel.setBounds(0, 21, 694, 651);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
	}
}
