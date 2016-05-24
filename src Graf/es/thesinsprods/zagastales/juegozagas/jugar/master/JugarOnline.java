package es.thesinsprods.zagastales.juegozagas.jugar.master;

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
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;
import es.thesinsprods.zagastales.juegozagas.jugar.jugador.VentanaJugadores.IncomingReader;
import es.thesinsprods.zagastales.juegozagas.jugar.master.jugador1.Personaje1;
import es.thesinsprods.zagastales.jugar.online.server.SystemServer;

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
	final ConexionDBOnline con = new ConexionDBOnline();
	final Connection p = con.accederDB();
	final Statement tabla=p.createStatement();
	final JButton button = new JButton("");
	final JButton button_1 = new JButton("");
	final JButton button_2 = new JButton("");
	final JButton button_3 = new JButton("");
	final JButton button_4 = new JButton("");
	final JButton button_5 = new JButton("");
	final JButton button_6 = new JButton("");
	final JButton button_7 = new JButton("");
	final JButton button_8 = new JButton("");
	public static Characters personaje1=null;
	public static Characters personaje2=null;
	public static Characters personaje3=null;
	public static Characters personaje4=null;
	public static Characters personaje5=null;
	public static Characters personaje6=null;
	public static Characters personaje7=null;
	public static Characters personaje8=null;
	public static Characters personaje9=null;
	public static Characters npc1=null;
	public static Characters npc2=null;
	public static Characters npc3=null;
	public static Characters npc4=null;
	public static Characters npc5=null;
	public static Characters npc6=null;
	public static Characters npc7=null;
	public static Characters npc8=null;
	public static Characters npc9=null;
	private JTextField textField;
	ArrayList<String> jugadores = new ArrayList<String>();
	ArrayList<String> npcs = new ArrayList<String>();
	ArrayList<String> npcGenerico = new ArrayList<String>();
	
	
	  public class IncomingReader implements Runnable
	    {
	        @Override
	        public void run() 
	        {
	            String[] data;
	            String stream, cargar = "Cargar", done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat" , limpiar="LimpiaLista";

	            try 
	            {
	                while ((stream = reader.readLine()) != null) 
	                {
	                     data = stream.split(":");
	                     
	                     if (data[2].equals(cargar)){
	                    	 System.out.println(data[1]);
	                    	 try {

	         					ResultSet rs=tabla.executeQuery("SELECT * FROM PERSONAJE WHERE NOMBRE='"+data[1]+"'");
	         					Armor armor = new Armor ("", "",false,false, null);
	         					Weapons weapon1 = new Weapons("", "", false, false, null, "");
	         					Weapons weapon2 = new Weapons("", "", false, false, null, "");
	         					Weapons weapon3= new Weapons("", "", false, false, null, "");
	         					Weapons weapon4= new Weapons("", "", false, false, null, "");
	         					Misc misc1 = new Misc("","",false,false,null);
	         					Misc misc2= new Misc("","",false,false,null);
	         					Misc misc3= new Misc("","",false,false,null);
	         					Misc misc4= new Misc("","",false,false,null);
	         					Accesories accesorie1= new Accesories("","",false,false,null);
	         					Accesories accesorie2= new Accesories("","",false,false,null);
	         					Accesories accesorie3= new Accesories("","",false,false,null);
	         					Accesories accesorie4= new Accesories("","",false,false,null);
	         					
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
	         							nombre = ""+rs.getString("NOMBRE");
	         							edad = rs.getInt("EDAD");
	         							raza = ""+rs.getString("RAZA");
	         							descripcionF = ""+rs.getString("DESCRIPCION_FISICA");
	         							;
	         							bendicion = ""+rs.getString("BENDICION");
	         							privilegio1 = ""+rs.getString("PRIVILEGIO1");
	         							privilegio2 = ""+rs.getString("PRIVILEGIO2");
	         							privilegio3 = ""+rs.getString("PRIVILEGIO3");
	         							privilegio4 = ""+rs.getString("PRIVILEGIO4");
	         							privilegio5 = ""+rs.getString("PRIVILEGIO5");
	         							reves1 = ""+rs.getString("REVES1");
	         							reves2 = ""+rs.getString("REVES2");
	         							reves3 = ""+rs.getString("REVES3");
	         							reves4 = ""+rs.getString("REVES4");
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
	         							armadura = ""+rs.getString("ARMADURA");
	         							descripcionArm = ""+rs.getString("DESCRIPCION_ARMADURA");
	         							posesionArm = ""+rs.getString("POSESION_ARMADURA");
	         							prop1Arm = ""+rs.getString("PROPIEDAD1_ARMADURA");
	         							prop2Arm = ""+rs.getString("PROPIEDAD2_ARMADURA");
	         							prop3Arm = ""+rs.getString("PROPIEDAD3_ARMADURA");
	         							weap1 = ""+rs.getString("ARMA1");
	         							descripcionWeap1 = ""+rs.getString("DESCRIPCION_ARMA1");
	         							posesionWeap1 = ""+rs.getString("POSESION_ARMA1");
	         							prop1Weap1 = ""+rs.getString("PROPIEDAD1_ARMA1");
	         							prop2Weap1 = ""+rs.getString("PROPIEDAD2_ARMA1");
	         							prop3Weap1 = ""+rs.getString("PROPIEDAD3_ARMA1");
	         							weap2 = ""+rs.getString("ARMA2");
	         							descripcionWeap2 = ""+rs.getString("DESCRIPCION_ARMA2");
	         							posesionWeap2 = ""+rs.getString("POSESION_ARMA2");
	         							prop1Weap2 = ""+rs.getString("PROPIEDAD1_ARMA2");
	         							prop2Weap2 = ""+rs.getString("PROPIEDAD2_ARMA2");
	         							prop3Weap2 = ""+rs.getString("PROPIEDAD3_ARMA2");
	         							weap3 = ""+rs.getString("ARMA3");
	         							descripcionWeap3 = ""+rs.getString("DESCRIPCION_ARMA3");
	         							posesionWeap3 = ""+rs.getString("POSESION_ARMA3");
	         							prop1Weap3 = ""+rs.getString("PROPIEDAD1_ARMA3");
	         							prop2Weap3 = ""+rs.getString("PROPIEDAD2_ARMA3");
	         							prop3Weap3 = ""+rs.getString("PROPIEDAD3_ARMA3");
	         							weap4 = ""+rs.getString("ARMA4");
	         							descripcionWeap4 = ""+rs.getString("DESCRIPCION_ARMA4");
	         							posesionWeap4 = ""+rs.getString("POSESION_ARMA4");
	         							prop1Weap4 = ""+rs.getString("PROPIEDAD1_ARMA4");
	         							prop2Weap4 = ""+rs.getString("PROPIEDAD2_ARMA4");
	         							prop3Weap4 = ""+rs.getString("PROPIEDAD3_ARMA4");
	         							obj1 = ""+rs.getString("OBJETO1");
	         							descripcionObj1 = ""+rs.getString("DESCRIPCION_OBJETO1");
	         							posesionObj1 = ""+rs.getString("POSESION_OBJETO1");
	         							prop1Obj1 = ""+rs.getString("PROPIEDAD1_OBJETO1");
	         							prop2Obj1 = ""+rs.getString("PROPIEDAD2_OBJETO1");
	         							prop3Obj1 = ""+rs.getString("PROPIEDAD3_OBJETO1");
	         							obj2 = ""+rs.getString("OBJETO2");
	         							descripcionObj2 = ""+rs.getString("DESCRIPCION_OBJETO2");
	         							posesionObj2 = ""+rs.getString("POSESION_OBJETO2");
	         							prop1Obj2 = ""+rs.getString("PROPIEDAD1_OBJETO2");
	         							prop2Obj2 = ""+rs.getString("PROPIEDAD2_OBJETO2");
	         							prop3Obj2 = ""+rs.getString("PROPIEDAD3_OBJETO2");
	         							obj3 = ""+rs.getString("OBJETO3");
	         							descripcionObj3 = ""+rs.getString("DESCRIPCION_OBJETO3");
	         							posesionObj3 = ""+rs.getString("POSESION_OBJETO3");
	         							prop1Obj3 = ""+rs.getString("PROPIEDAD1_OBJETO3");
	         							prop2Obj3 = ""+rs.getString("PROPIEDAD2_OBJETO3");
	         							prop3Obj3 = ""+rs.getString("PROPIEDAD3_OBJETO3");
	         							obj4 = ""+rs.getString("OBJETO4");
	         							descripcionObj4 = ""+rs.getString("DESCRIPCION_OBJETO4");
	         							posesionObj4 = ""+rs.getString("POSESION_OBJETO4");
	         							prop1Obj4 = ""+rs.getString("PROPIEDAD1_OBJETO4");
	         							prop2Obj4 = ""+rs.getString("PROPIEDAD2_OBJETO4");
	         							prop3Obj4 = ""+rs.getString("PROPIEDAD3_OBJETO4");
	         							acc1 = ""+rs.getString("ACCESORIO1");
	         							descripcionAcc1 = ""+rs.getString("DESCRIPCION_ACCESORIO1");
	         							posesionAcc1 = ""+rs.getString("POSESION_ACCESORIO1");
	         							prop1Acc1 = ""+rs.getString("PROPIEDAD1_ACCESORIO1");
	         							prop2Acc1 = ""+rs.getString("PROPIEDAD2_ACCESORIO1");
	         							prop3Acc1 = ""+rs.getString("PROPIEDAD3_ACCESORIO1");
	         							acc2 = ""+rs.getString("ACCESORIO2");
	         							descripcionAcc2 = ""+rs.getString("DESCRIPCION_ACCESORIO2");
	         							posesionAcc2 = ""+rs.getString("POSESION_ACCESORIO2");
	         							prop1Acc2 = ""+rs.getString("PROPIEDAD1_ACCESORIO2");
	         							prop2Acc2 = ""+rs.getString("PROPIEDAD2_ACCESORIO2");
	         							prop3Acc2 = ""+rs.getString("PROPIEDAD3_ACCESORIO2");
	         							acc3 = ""+rs.getString("ACCESORIO3");
	         							descripcionAcc3 = ""+rs.getString("DESCRIPCION_ACCESORIO3");
	         							posesionAcc3 = ""+rs.getString("POSESION_ACCESORIO3");
	         							prop1Acc3 = ""+rs.getString("PROPIEDAD1_ACCESORIO3");
	         							prop2Acc3 = ""+rs.getString("PROPIEDAD2_ACCESORIO3");
	         							prop3Acc3 = ""+rs.getString("PROPIEDAD3_ACCESORIO3");
	         							acc4 = ""+rs.getString("ACCESORIO4");
	         							descripcionAcc4 = ""+rs.getString("DESCRIPCION_ACCESORIO4");
	         							posesionAcc4 = ""+rs.getString("POSESION_ACCESORIO4");
	         							prop1Acc4 = ""+rs.getString("PROPIEDAD1_ACCESORIO4");
	         							prop2Acc4 = ""+rs.getString("PROPIEDAD2_ACCESORIO4");
	         							prop3Acc4 = ""+rs.getString("PROPIEDAD3_ACCESORIO4");
	         							tipoWeap1 = ""+rs.getString("TIPOARMA1");
	         							tipoWeap2 = ""+rs.getString("TIPOARMA2");
	         							tipoWeap3 = ""+rs.getString("TIPOARMA3");
	         							tipoWeap4 = ""+rs.getString("TIPOARMA4");
	         							tipoAcc1 = ""+rs.getString("TIPOACC1");
	         							tipoAcc2 = ""+rs.getString("TIPOACC2");
	         							tipoAcc3 = ""+rs.getString("TIPOACC3");
	         							tipoAcc4 = ""+rs.getString("TIPOACC4");
	         							arrojadizaWeap1 = ""+rs.getString("SUBCLASE_ARMA1");
	         							arrojadizaWeap2 = ""+rs.getString("SUBCLASE_ARMA2");
	         							arrojadizaWeap3 = ""+rs.getString("SUBCLASE_ARMA3");
	         							arrojadizaWeap4 = ""+rs.getString("SUBCLASE_ARMA4");
	         							salud = rs.getInt("SALUD");
	         							mana = rs.getInt("MANA");
	         							energia = rs.getInt("ENERGIA");
	         							experiencia = rs.getInt("EXPERIENCIA");
	         							sino = rs.getInt("SINO");
	         							nivel = rs.getInt("NIVEL");
	         							extras=""+rs.getString("EXTRAS");
	         							dinero=rs.getInt("DINERO");
	         							modificadores=""+rs.getString("MODIFICADORES");
	         							poderes=""+rs.getString("PODERES");
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
	         					
	         						button.setText(data[1]);
	         						personaje1=intermedio;
	         						jugadores.add(personaje1.getName());
	         					}
	         					else{ if(button_1.getText().equals("")){
	         					
	         						button_1.setText(data[1]);
	         						personaje2=intermedio;
	         						jugadores.add(personaje2.getName());
	         						
	         					}
	         					else{
	         						if(button_2.getText().equals("")){
	         							
	         							button_2.setText(data[1]);
	         							personaje3=intermedio;
	         							jugadores.add(personaje3.getName());
	         						}
	         					
	         						else{if(button_3.getText().equals("")){
	         							
	         							button_3.setText(data[1]);
	         							personaje4=intermedio;
	         							jugadores.add(personaje4.getName());
	         						}
	         						else{if(button_4.getText().equals("")){
	         							
	         							button_4.setText(data[1]);
	         							personaje5=intermedio;
	         							jugadores.add(personaje5.getName());
	         						}
	         						else{if(button_5.getText().equals("")){
	         							
	         							button_5.setText(data[1]);
	         							personaje6=intermedio;
	         							jugadores.add(personaje6.getName());
	         						}
	         						else{if(button_6.getText().equals("")){
	         							
	         							button_6.setText(data[1]);
	         							personaje7=intermedio;
	         							jugadores.add(personaje7.getName());
	         						}
	         						
	         						else{if(button_7.getText().equals("")){
	         							
	         							button_7.setText(data[1]);
	         							personaje8=intermedio;
	         							jugadores.add(personaje8.getName());
	         						}
	         						else{if(button_8.getText().equals("")){
	         							
	         							button_8.setText(data[1]);
	         							personaje9=intermedio;
	         							jugadores.add(personaje9.getName());
	         						}
	         						
	         						else{}
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

	                     else if (data[2].equals(chat)) 
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
	                     else if(data[2].equals(limpiar)){
	                    	 
	                    	for(int i=0; i<jugadores.size();i++){
	                    		
	                    		if(jugadores.get(i).equals(data[1])){
	                    			
	                    			jugadores.remove(i);
	                    		}
	                    		
	                    	}
	                    	if(data[1].equals(button.getText())){
	                    		button.setText("");
	                    		personaje1=null;
	                    		
	                    		
	                    	}
	                    	else if(data[1].equals(button_1.getText())){
	                    		button_1.setText("");
	                    		personaje2=null;
	                    		
	                    		
	                    	}
	                    	else if(data[1].equals(button_3.getText())){
	                    		button_2.setText("");
	                    		personaje3=null;
	                    		
	                    		
	                    	}
	                    	else if(data[1].equals(button_3.getText())){
	                    		button_3.setText("");
	                    		personaje4=null;
	                    		
	                    		
	                    	}
	                    	else if(data[1].equals(button_4.getText())){
	                    		button_4.setText("");
	                    		personaje5=null;
	                    		
	                    		
	                    	}
	                    	else if(data[1].equals(button_5.getText())){
	                    		button_5.setText("");
	                    		personaje6=null;
	                    		
	                    		
	                    	}
	                    	else if(data[1].equals(button_6.getText())){
	                    		button_6.setText("");
	                    		personaje7=null;
	                    		
	                    		
	                    	}
	                    	else if(data[1].equals(button_7.getText())){
	                    		button_7.setText("");
	                    		personaje8=null;
	                    		
	                    		
	                    	}
	                    	else if(data[1].equals(button_8.getText())){
	                    		button_8.setText("");
	                    		personaje9=null;
	                    		
	                    		
	                    	}
	                    	
	                    	
	                    	 
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
		
	

		
		InetAddress thisIp;
		thisIp = InetAddress.getLocalHost();
		address = thisIp.getHostAddress().toString();
		
		Conectar();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 894, 26);
		frmHistoriasDeZagas.getContentPane().add(menuBar);
		
		JMenu mnCargar = new JMenu("Cargar");
		menuBar.add(mnCargar);
		
		JMenuItem mntmNpc = new JMenuItem("NPC");
		
		mnCargar.add(mntmNpc);
		
		JMenuItem mntmNpcGenrico = new JMenuItem("NPC Gen\u00E9rico");
		mntmNpcGenrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnCargar.add(mntmNpcGenrico);
		
		JButton button_30 = new JButton("");
		button_30.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/botonayudajugar1.png")));
		
		JMenu mnEliminar = new JMenu("Eliminar");
		menuBar.add(mnEliminar);
		
		JMenuItem mntmJugador = new JMenuItem("Jugador");
		mnEliminar.add(mntmJugador);
		
		JMenuItem menuItem = new JMenuItem("NPC");
		mnEliminar.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("NPC Gen\u00E9rico");
		mnEliminar.add(menuItem_1);
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Personaje1 window;
				try {
					window = new Personaje1();
					window.getFrame().setVisible(true);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
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
		
		button_1.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_1.setOpaque(false);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBounds(46, 61, 179, 32);
		panel.add(button_1);

		button_2.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_2.setOpaque(false);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		button_2.setBounds(46, 111, 179, 32);
		panel.add(button_2);
		
		button_3.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_3.setOpaque(false);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_3.setContentAreaFilled(false);
		button_3.setBorder(null);
		button_3.setBounds(46, 161, 179, 32);
		panel.add(button_3);
		
		button_4.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_4.setOpaque(false);
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_4.setContentAreaFilled(false);
		button_4.setBorder(null);
		button_4.setBounds(46, 211, 179, 32);
		panel.add(button_4);
		
		button_5.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_5.setOpaque(false);
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_5.setContentAreaFilled(false);
		button_5.setBorder(null);
		button_5.setBounds(46, 261, 179, 32);
		panel.add(button_5);
		
		button_6.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_6.setOpaque(false);
		button_6.setHorizontalTextPosition(SwingConstants.CENTER);
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_6.setContentAreaFilled(false);
		button_6.setBorder(null);
		button_6.setBounds(46, 311, 179, 32);
		panel.add(button_6);
		
		button_7.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_7.setOpaque(false);
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_7.setContentAreaFilled(false);
		button_7.setBorder(null);
		button_7.setBounds(46, 361, 179, 32);
		panel.add(button_7);
		
		button_8.setIcon(new ImageIcon(JugarOnline.class.getResource("/images/boton personajes jugar.png")));
		button_8.setOpaque(false);
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Morpheus", Font.PLAIN, 15));
		button_8.setContentAreaFilled(false);
		button_8.setBorder(null);
		button_8.setBounds(46, 411, 179, 32);
		panel.add(button_8);
		
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
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 320, 621, 371);
		frmHistoriasDeZagas.getContentPane().add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Chat", null, panel_3, null);
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
		
		JButton btnConfig = new JButton("Cerrar");
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHistoriasDeZagas.dispose();
				Inicio window = new Inicio();
				writer.println("Server:ssdfsdjfsd:Cerrar");
				writer.flush();
				writer.println("Server:El servidor se está cerrando, todos los usuarios serán desconectados.:Chat");
				writer.flush();
				 try {
					tabla.executeQuery("DELETE FROM PARTIDAS WHERE USUARIO='"+Loader.usuario+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.getFrmHistoriasDeZagas().setVisible(true);
			}
		});
		btnConfig.setBounds(527, 310, 86, 35);
		panel_3.add(btnConfig);
		
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
		btnModificarSem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer.println(/*Usuario escogido*/":"/*Cantidad escogida*/+":ModificarSEM:"/*Salud-Energia-Mana*/);
				writer.flush();
			}
		});
		btnModificarSem.setBounds(10, 70, 187, 31);
		panel_6.add(btnModificarSem);
		
		JButton btnAlterarEstado = new JButton("Alterar Estado");
		btnAlterarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] personaje={"Jugador","NPC","NPC Genérico"};
				Object seleccion = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Seleccione una opcion",
						"Alterar Estado", JOptionPane.PLAIN_MESSAGE,
						null,personaje,null);
				seleccion=seleccion+"";
				if(seleccion.equals("Jugador")){
					
					Object [] personajes= jugadores.toArray();
					Object jugador = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Seleccione el personaje al que cambiar el estado.",
							"Alterar Estado", JOptionPane.PLAIN_MESSAGE,
							null,personajes,null);
					jugador=jugador+"";
					String estado = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Introduce el nuevo estado.", "",
							JOptionPane.PLAIN_MESSAGE);
					if(personaje1.getName().equals(jugador)){
						
						personaje1.setEstado(estado);
						
					}
					else	if(personaje2.getName().equals(jugador)){
						
						personaje2.setEstado(estado);
						
					}
					else	if(personaje3.getName().equals(jugador)){
		
						personaje3.setEstado(estado);
		
					}
					else	if(personaje4.getName().equals(jugador)){
						
						personaje4.setEstado(estado);
		
					}
					else	if(personaje5.getName().equals(jugador)){
						
						personaje5.setEstado(estado);
		
					}
					else	if(personaje6.getName().equals(jugador)){
						
						personaje6.setEstado(estado);
		
					}
					else	if(personaje7.getName().equals(jugador)){
						
						personaje7.setEstado(estado);
		
					}
					else	if(personaje8.getName().equals(jugador)){
						
						personaje8.setEstado(estado);
		
					}
					else	if(personaje9.getName().equals(jugador)){
						
						personaje9.setEstado(estado);
		
					}

				
					
					writer.println(jugador+":"+estado+":Alterar");
					writer.flush();
					writer.println("Información: Se ha alterado el estado de "+jugador+ "a "+estado+":Chat");
					writer.flush();
				}
				else if(seleccion.equals("NPC")){
					
					Object [] personajes= npcs.toArray();
					Object jugador = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Seleccione el personaje al que cambiar el estado.",
							"Alterar Estado", JOptionPane.PLAIN_MESSAGE,
							null,personajes,null);
					jugador=jugador+"";
					String estado = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Introduce el nuevo estado.", "",
							JOptionPane.PLAIN_MESSAGE);
if(npc1.getName().equals(jugador)){
						
						npc1.setEstado(estado);
						
					}
					else	if(npc2.getName().equals(jugador)){
						
						npc2.setEstado(estado);
						
					}
					else	if(npc3.getName().equals(jugador)){
		
						npc3.setEstado(estado);
		
					}
					else	if(npc4.getName().equals(jugador)){
						
						npc4.setEstado(estado);
		
					}
					else	if(npc5.getName().equals(jugador)){
						
						npc5.setEstado(estado);
		
					}
					else	if(npc6.getName().equals(jugador)){
						
						npc6.setEstado(estado);
		
					}
					else	if(npc7.getName().equals(jugador)){
						
						npc7.setEstado(estado);
		
					}
					else	if(npc8.getName().equals(jugador)){
						
						npc8.setEstado(estado);
		
					}
					else	if(npc9.getName().equals(jugador)){
						
						npc9.setEstado(estado);
		
					}

					
					writer.println(jugador+":"+estado+":Alterar");
					writer.flush();
					writer.println("Información: Se ha alterado el estado de "+jugador+ "a "+estado+":Chat");
					writer.flush();
				}
			else if(seleccion.equals("NPC Genérico")){
					
					Object [] personajes= npcGenerico.toArray();
					Object jugador = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Seleccione el personaje al que cambiar el estado.",
							"Alterar Estado", JOptionPane.PLAIN_MESSAGE,
							null,personajes,null);
					jugador=jugador+"";
					String estado = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Introduce el nuevo estado.", "",
							JOptionPane.PLAIN_MESSAGE);
					
					writer.println(jugador+":"+estado+":Alterar");
					writer.flush();
				}
				//writer.println(/*Usuario escogido*/":"/*Nuevo Estado escogida*/+":Alterar");
				//writer.flush();
			}
		});
		btnAlterarEstado.setBounds(10, 130, 187, 31);
		panel_6.add(btnAlterarEstado);
		
		JButton btnModificarEquipo = new JButton("Modificar Equipo");
		btnModificarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificarEquipo.setBounds(10, 190, 187, 31);
		panel_6.add(btnModificarEquipo);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(414, 26, 207, 283);
		frmHistoriasDeZagas.getContentPane().add(panel_7);
		
		JLabel lblRecompensas = new JLabel("Recompensas");
		lblRecompensas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecompensas.setBounds(0, 0, 207, 46);
		panel_7.add(lblRecompensas);
	
		
		JButton btnDarExperiencia = new JButton("Dar Experiencia");
		btnDarExperiencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object [] personajes= jugadores.toArray();
				Object jugador = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Seleccione el personaje al que dar experiencia.",
						"Modicar Experiencia", JOptionPane.PLAIN_MESSAGE,
						null,personajes,null);
				jugador=jugador+"";
				String exp = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Introduce la cantidad de experiencia a otorgar.", "",
						JOptionPane.PLAIN_MESSAGE);
				int experiencia= Integer.parseInt(exp);
				if(experiencia>0){
					if(personaje1.getName().equals(jugador)){
						
						personaje1.setExperience(personaje1.getExperience()+experiencia);
						
					}
					else	if(personaje2.getName().equals(jugador)){
						
						personaje2.setExperience(personaje2.getExperience()+experiencia);
						
					}
					else	if(personaje3.getName().equals(jugador)){
		
						personaje3.setExperience(personaje3.getExperience()+experiencia);
		
					}
					else	if(personaje4.getName().equals(jugador)){
						
						personaje4.setExperience(personaje4.getExperience()+experiencia);
		
					}
					else	if(personaje5.getName().equals(jugador)){
						
						personaje5.setExperience(personaje5.getExperience()+experiencia);
		
					}
					else	if(personaje6.getName().equals(jugador)){
						
						personaje6.setExperience(personaje6.getExperience()+experiencia);
		
					}
					else	if(personaje7.getName().equals(jugador)){
						
						personaje7.setExperience(personaje7.getExperience()+experiencia);
		
					}
					else	if(personaje8.getName().equals(jugador)){
						
						personaje8.setExperience(personaje8.getExperience()+experiencia);
		
					}
					else	if(personaje9.getName().equals(jugador)){
						
						personaje9.setExperience(personaje9.getExperience()+experiencia);
		
					}

					
					
					
				writer.println(jugador+":"+exp+":darExp");
				writer.flush();
				writer.println("Información: Se ha añadido"+exp +" de experiencia a "+jugador+":Chat");
				writer.flush();
				
				}
				else{
					int solucion = JOptionPane.showOptionDialog(
							frmHistoriasDeZagas,
							"No se pueden usar valores negativos", "¡Error!",
							JOptionPane.OK_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							new Object[] { "Aceptar" }, "opcion 1");
				}
				//writer.println(/*Usuario escogido*/":"/*Cantidad escogida*/+":darExp");
				//writer.flush();
			}
		});
		btnDarExperiencia.setBounds(10, 70, 187, 31);
		panel_7.add(btnDarExperiencia);
		
		JButton btnDarAtributos = new JButton("Dar Atributos");
		btnDarAtributos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Object [] personajes= jugadores.toArray();
				Object jugador = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Seleccione el personaje al que modificar los atributos.",
						"Modificar Atributos", JOptionPane.PLAIN_MESSAGE,
						null,personajes,null);
				jugador=jugador+"";
				Object [] atributos={"Fuerza","Destreza","Resistencia","Resistencia Mágica","Inteligencia","Percepción","Carisma"};
				Object atributo = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Seleccione el atributo a modificar.",
						"Modificar Atributos", JOptionPane.PLAIN_MESSAGE,
						null,atributos,null);
				atributo=atributo+"";
				String cant = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Introduce la cantidad a otorgar.", "",
						JOptionPane.PLAIN_MESSAGE);
	
				if(personaje1.getName().equals(jugador)){
					
					if(atributo.equals("Fuerza")){
						
						if(personaje1.getAtributes().getStrength()+Integer.parseInt(cant)<6 || personaje1.getAtributes().getStrength()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje1.getAtributes().setStrength(personaje1.getAtributes().getStrength()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(atributo.equals("Destreza")){
						
						if(personaje1.getAtributes().getDexterity()+Integer.parseInt(cant)<6 || personaje1.getAtributes().getDexterity()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje1.getAtributes().setDexterity(personaje1.getAtributes().getDexterity()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia")){
						
						if(personaje1.getAtributes().getResistance()+Integer.parseInt(cant)<6 || personaje1.getAtributes().getResistance()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje1.getAtributes().setResistance(personaje1.getAtributes().getResistance()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia Mágica")){
						
						if(personaje1.getAtributes().getMagicres()+Integer.parseInt(cant)<6 || personaje1.getAtributes().getMagicres()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje1.getAtributes().setMagicres(personaje1.getAtributes().getMagicres()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}


					else if(atributo.equals("Inteligencia")){
						
						if(personaje1.getAtributes().getIntelligence()+Integer.parseInt(cant)<6 || personaje1.getAtributes().getIntelligence()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje1.getAtributes().setIntelligence(personaje1.getAtributes().getIntelligence()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}	else if(atributo.equals("Percepción")){
						
						if(personaje1.getAtributes().getPerception()+Integer.parseInt(cant)<6 || personaje1.getAtributes().getPerception()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje1.getAtributes().setPerception(personaje1.getAtributes().getPerception()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
						else if(atributo.equals("Carisma")){
						
						if(personaje1.getAtributes().getCharisma()+Integer.parseInt(cant)<6 || personaje1.getAtributes().getCharisma()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje1.getAtributes().setCharisma(personaje1.getAtributes().getCharisma()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					
				}
				else	if(personaje2.getName().equals(jugador)){
					
					
					
					if(atributo.equals("Fuerza")){
						
						if(personaje2.getAtributes().getStrength()+Integer.parseInt(cant)<6 || personaje2.getAtributes().getStrength()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje2.getAtributes().setStrength(personaje2.getAtributes().getStrength()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(atributo.equals("Destreza")){
						
						if(personaje2.getAtributes().getDexterity()+Integer.parseInt(cant)<6 || personaje2.getAtributes().getDexterity()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje2.getAtributes().setDexterity(personaje2.getAtributes().getDexterity()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia")){
						
						if(personaje2.getAtributes().getResistance()+Integer.parseInt(cant)<6 || personaje2.getAtributes().getResistance()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje2.getAtributes().setResistance(personaje2.getAtributes().getResistance()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia Mágica")){
						
						if(personaje2.getAtributes().getMagicres()+Integer.parseInt(cant)<6 || personaje2.getAtributes().getMagicres()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getAtributes().setMagicres(personaje2.getAtributes().getMagicres()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}


					else if(atributo.equals("Inteligencia")){
						
						if(personaje2.getAtributes().getIntelligence()+Integer.parseInt(cant)<6 || personaje2.getAtributes().getIntelligence()+Integer.parseInt(cant)>20){}
						else{
							try {
								personaje2.getAtributes().setIntelligence(personaje2.getAtributes().getIntelligence()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}	else if(atributo.equals("Percepción")){
						
						if(personaje2.getAtributes().getPerception()+Integer.parseInt(cant)<6 || personaje2.getAtributes().getPerception()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje2.getAtributes().setPerception(personaje2.getAtributes().getPerception()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
						else if(atributo.equals("Carisma")){
						
						if(personaje2.getAtributes().getCharisma()+Integer.parseInt(cant)<6 || personaje2.getAtributes().getCharisma()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje2.getAtributes().setCharisma(personaje2.getAtributes().getCharisma()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					
					
				}
				else	if(personaje3.getName().equals(jugador)){
	
					
					
					if(atributo.equals("Fuerza")){
						
						if(personaje3.getAtributes().getStrength()+Integer.parseInt(cant)<6 || personaje3.getAtributes().getStrength()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje3.getAtributes().setStrength(personaje3.getAtributes().getStrength()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(atributo.equals("Destreza")){
						
						if(personaje3.getAtributes().getDexterity()+Integer.parseInt(cant)<6 || personaje3.getAtributes().getDexterity()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje3.getAtributes().setDexterity(personaje3.getAtributes().getDexterity()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia")){
						
						if(personaje3.getAtributes().getResistance()+Integer.parseInt(cant)<6 || personaje3.getAtributes().getResistance()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje3.getAtributes().setResistance(personaje3.getAtributes().getResistance()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia Mágica")){
						
						if(personaje3.getAtributes().getMagicres()+Integer.parseInt(cant)<6 || personaje3.getAtributes().getMagicres()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje3.getAtributes().setMagicres(personaje3.getAtributes().getMagicres()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}


					else if(atributo.equals("Inteligencia")){
						
						if(personaje3.getAtributes().getIntelligence()+Integer.parseInt(cant)<6 || personaje3.getAtributes().getIntelligence()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje3.getAtributes().setIntelligence(personaje3.getAtributes().getIntelligence()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}	else if(atributo.equals("Percepción")){
						
						if(personaje3.getAtributes().getPerception()+Integer.parseInt(cant)<6 || personaje3.getAtributes().getPerception()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje3.getAtributes().setPerception(personaje3.getAtributes().getPerception()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
						else if(atributo.equals("Carisma")){
						
						if(personaje3.getAtributes().getCharisma()+Integer.parseInt(cant)<6 || personaje3.getAtributes().getCharisma()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje3.getAtributes().setCharisma(personaje3.getAtributes().getCharisma()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					
				
	
				}
				else	if(personaje4.getName().equals(jugador)){
					
					
					
					if(atributo.equals("Fuerza")){
						
						if(personaje4.getAtributes().getStrength()+Integer.parseInt(cant)<6 || personaje4.getAtributes().getStrength()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje4.getAtributes().setStrength(personaje4.getAtributes().getStrength()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(atributo.equals("Destreza")){
						
						if(personaje4.getAtributes().getDexterity()+Integer.parseInt(cant)<6 || personaje4.getAtributes().getDexterity()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje4.getAtributes().setDexterity(personaje4.getAtributes().getDexterity()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia")){
						
						if(personaje4.getAtributes().getResistance()+Integer.parseInt(cant)<6 || personaje4.getAtributes().getResistance()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje4.getAtributes().setResistance(personaje4.getAtributes().getResistance()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia Mágica")){
						
						if(personaje4.getAtributes().getMagicres()+Integer.parseInt(cant)<6 || personaje4.getAtributes().getMagicres()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje4.getAtributes().setMagicres(personaje4.getAtributes().getMagicres()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}


					else if(atributo.equals("Inteligencia")){
						
						if(personaje4.getAtributes().getIntelligence()+Integer.parseInt(cant)<6 || personaje4.getAtributes().getIntelligence()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje4.getAtributes().setIntelligence(personaje4.getAtributes().getIntelligence()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}	else if(atributo.equals("Percepción")){
						
						if(personaje4.getAtributes().getPerception()+Integer.parseInt(cant)<6 || personaje4.getAtributes().getPerception()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje4.getAtributes().setPerception(personaje4.getAtributes().getPerception()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
						else if(atributo.equals("Carisma")){
						
						if(personaje4.getAtributes().getCharisma()+Integer.parseInt(cant)<6 || personaje4.getAtributes().getCharisma()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje4.getAtributes().setCharisma(personaje4.getAtributes().getCharisma()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					
				
	
				}
				else	if(personaje5.getName().equals(jugador)){
					
					
					
					if(atributo.equals("Fuerza")){
						
						if(personaje5.getAtributes().getStrength()+Integer.parseInt(cant)<6 || personaje5.getAtributes().getStrength()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje5.getAtributes().setStrength(personaje5.getAtributes().getStrength()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(atributo.equals("Destreza")){
						
						if(personaje5.getAtributes().getDexterity()+Integer.parseInt(cant)<6 || personaje5.getAtributes().getDexterity()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje5.getAtributes().setDexterity(personaje5.getAtributes().getDexterity()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia")){
						
						if(personaje5.getAtributes().getResistance()+Integer.parseInt(cant)<6 || personaje5.getAtributes().getResistance()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje5.getAtributes().setResistance(personaje5.getAtributes().getResistance()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia Mágica")){
						
						if(personaje5.getAtributes().getMagicres()+Integer.parseInt(cant)<6 || personaje5.getAtributes().getMagicres()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje5.getAtributes().setMagicres(personaje5.getAtributes().getMagicres()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}


					else if(atributo.equals("Inteligencia")){
						
						if(personaje5.getAtributes().getIntelligence()+Integer.parseInt(cant)<6 || personaje5.getAtributes().getIntelligence()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje5.getAtributes().setIntelligence(personaje5.getAtributes().getIntelligence()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}	else if(atributo.equals("Percepción")){
						
						if(personaje5.getAtributes().getPerception()+Integer.parseInt(cant)<6 || personaje5.getAtributes().getPerception()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje5.getAtributes().setPerception(personaje5.getAtributes().getPerception()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
						else if(atributo.equals("Carisma")){
						
						if(personaje5.getAtributes().getCharisma()+Integer.parseInt(cant)<6 || personaje5.getAtributes().getCharisma()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje5.getAtributes().setCharisma(personaje5.getAtributes().getCharisma()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					
				
	
				}
				else	if(personaje6.getName().equals(jugador)){
					
					
					
					if(atributo.equals("Fuerza")){
						
						if(personaje6.getAtributes().getStrength()+Integer.parseInt(cant)<6 || personaje6.getAtributes().getStrength()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje6.getAtributes().setStrength(personaje6.getAtributes().getStrength()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(atributo.equals("Destreza")){
						
						if(personaje6.getAtributes().getDexterity()+Integer.parseInt(cant)<6 || personaje6.getAtributes().getDexterity()+Integer.parseInt(cant)>20){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Atributo inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje6.getAtributes().setDexterity(personaje6.getAtributes().getDexterity()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia")){
						
						if(personaje6.getAtributes().getResistance()+Integer.parseInt(cant)<6 || personaje6.getAtributes().getResistance()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getAtributes().setResistance(personaje6.getAtributes().getResistance()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia Mágica")){
						
						if(personaje6.getAtributes().getMagicres()+Integer.parseInt(cant)<6 || personaje6.getAtributes().getMagicres()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getAtributes().setMagicres(personaje6.getAtributes().getMagicres()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}


					else if(atributo.equals("Inteligencia")){
						
						if(personaje6.getAtributes().getIntelligence()+Integer.parseInt(cant)<6 || personaje6.getAtributes().getIntelligence()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getAtributes().setIntelligence(personaje6.getAtributes().getIntelligence()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}	else if(atributo.equals("Percepción")){
						
						if(personaje6.getAtributes().getPerception()+Integer.parseInt(cant)<6 || personaje6.getAtributes().getPerception()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getAtributes().setPerception(personaje6.getAtributes().getPerception()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
						else if(atributo.equals("Carisma")){
						
						if(personaje6.getAtributes().getCharisma()+Integer.parseInt(cant)<6 || personaje6.getAtributes().getCharisma()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getAtributes().setCharisma(personaje6.getAtributes().getCharisma()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					
				
	
				}
				else	if(personaje7.getName().equals(jugador)){
					
					
					
					if(atributo.equals("Fuerza")){
						
						if(personaje7.getAtributes().getStrength()+Integer.parseInt(cant)<6 || personaje7.getAtributes().getStrength()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getAtributes().setStrength(personaje7.getAtributes().getStrength()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(atributo.equals("Destreza")){
						
						if(personaje7.getAtributes().getDexterity()+Integer.parseInt(cant)<6 || personaje7.getAtributes().getDexterity()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getAtributes().setDexterity(personaje7.getAtributes().getDexterity()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia")){
						
						if(personaje7.getAtributes().getResistance()+Integer.parseInt(cant)<6 || personaje7.getAtributes().getResistance()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getAtributes().setResistance(personaje7.getAtributes().getResistance()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia Mágica")){
						
						if(personaje7.getAtributes().getMagicres()+Integer.parseInt(cant)<6 || personaje7.getAtributes().getMagicres()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getAtributes().setMagicres(personaje7.getAtributes().getMagicres()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}


					else if(atributo.equals("Inteligencia")){
						
						if(personaje7.getAtributes().getIntelligence()+Integer.parseInt(cant)<6 || personaje7.getAtributes().getIntelligence()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getAtributes().setIntelligence(personaje7.getAtributes().getIntelligence()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}	else if(atributo.equals("Percepción")){
						
						if(personaje7.getAtributes().getPerception()+Integer.parseInt(cant)<6 || personaje7.getAtributes().getPerception()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getAtributes().setPerception(personaje7.getAtributes().getPerception()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
						else if(atributo.equals("Carisma")){
						
						if(personaje7.getAtributes().getCharisma()+Integer.parseInt(cant)<6 || personaje7.getAtributes().getCharisma()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getAtributes().setCharisma(personaje7.getAtributes().getCharisma()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					
				
	
				}
				else	if(personaje8.getName().equals(jugador)){
					
					
					
					if(atributo.equals("Fuerza")){
						
						if(personaje8.getAtributes().getStrength()+Integer.parseInt(cant)<6 || personaje8.getAtributes().getStrength()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getAtributes().setStrength(personaje8.getAtributes().getStrength()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(atributo.equals("Destreza")){
						
						if(personaje8.getAtributes().getDexterity()+Integer.parseInt(cant)<6 || personaje8.getAtributes().getDexterity()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getAtributes().setDexterity(personaje8.getAtributes().getDexterity()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia")){
						
						if(personaje8.getAtributes().getResistance()+Integer.parseInt(cant)<6 || personaje8.getAtributes().getResistance()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getAtributes().setResistance(personaje8.getAtributes().getResistance()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia Mágica")){
						
						if(personaje8.getAtributes().getMagicres()+Integer.parseInt(cant)<6 || personaje8.getAtributes().getMagicres()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getAtributes().setMagicres(personaje8.getAtributes().getMagicres()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}


					else if(atributo.equals("Inteligencia")){
						
						if(personaje8.getAtributes().getIntelligence()+Integer.parseInt(cant)<6 || personaje8.getAtributes().getIntelligence()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getAtributes().setIntelligence(personaje8.getAtributes().getIntelligence()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}	else if(atributo.equals("Percepción")){
						
						if(personaje8.getAtributes().getPerception()+Integer.parseInt(cant)<6 || personaje8.getAtributes().getPerception()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getAtributes().setPerception(personaje8.getAtributes().getPerception()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
						else if(atributo.equals("Carisma")){
						
						if(personaje8.getAtributes().getCharisma()+Integer.parseInt(cant)<6 || personaje8.getAtributes().getCharisma()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getAtributes().setCharisma(personaje8.getAtributes().getCharisma()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					
				
	
				}
				else	if(personaje9.getName().equals(jugador)){
					
					
					
					if(atributo.equals("Fuerza")){
						
						if(personaje9.getAtributes().getStrength()+Integer.parseInt(cant)<6 || personaje9.getAtributes().getStrength()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getAtributes().setStrength(personaje9.getAtributes().getStrength()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(atributo.equals("Destreza")){
						
						if(personaje9.getAtributes().getDexterity()+Integer.parseInt(cant)<6 || personaje9.getAtributes().getDexterity()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getAtributes().setDexterity(personaje9.getAtributes().getDexterity()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia")){
						
						if(personaje9.getAtributes().getResistance()+Integer.parseInt(cant)<6 || personaje9.getAtributes().getResistance()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getAtributes().setResistance(personaje9.getAtributes().getResistance()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}

					else if(atributo.equals("Resistencia Mágica")){
						
						if(personaje9.getAtributes().getMagicres()+Integer.parseInt(cant)<6 || personaje9.getAtributes().getMagicres()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getAtributes().setMagicres(personaje9.getAtributes().getMagicres()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}


					else if(atributo.equals("Inteligencia")){
						
						if(personaje9.getAtributes().getIntelligence()+Integer.parseInt(cant)<6 || personaje9.getAtributes().getIntelligence()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getAtributes().setIntelligence(personaje9.getAtributes().getIntelligence()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}	else if(atributo.equals("Percepción")){
						
						if(personaje9.getAtributes().getPerception()+Integer.parseInt(cant)<6 || personaje9.getAtributes().getPerception()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getAtributes().setPerception(personaje9.getAtributes().getPerception()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
						else if(atributo.equals("Carisma")){
						
						if(personaje9.getAtributes().getCharisma()+Integer.parseInt(cant)<6 || personaje9.getAtributes().getCharisma()+Integer.parseInt(cant)>20){		int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Atributo inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getAtributes().setCharisma(personaje9.getAtributes().getCharisma()+Integer.parseInt(cant));
							} catch (NumberFormatException | AtributeOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darAtr:"+atributo);
							writer.flush();
							writer.println("Información: Se ha modificado el atributo "+atributo+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					
				
	
				}

			
				
			
				
			
				//writer.println(/*Usuario escogido*/":"/*Cantidad escogida*/+":darAtr:"/*Atributo escogido*/);
				//writer.flush();
			}
		});
		btnDarAtributos.setBounds(10, 130, 187, 31);
		panel_7.add(btnDarAtributos);
		
		JButton btnDarHabilidades = new JButton("Dar Habilidades");
		btnDarHabilidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object [] personajes= jugadores.toArray();
				Object jugador = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Seleccione el personaje al que modificar las habilidades.",
						"Modificar Habilidades", JOptionPane.PLAIN_MESSAGE,
						null,personajes,null);
				jugador=jugador+"";
				Object [] habilidades={"Combate","Conocimientos","Magia","Destrezas"};
				Object rama = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Seleccione la rama de habilidades a modificar .",
						"Modificar Habilidades", JOptionPane.PLAIN_MESSAGE,
						null,habilidades,null);
				rama=rama+"";
				
				
				if(rama.equals("Combate")){
					Object [] conjunto={"Armas de Una Mano","Armas de Dos Manos","Armas de Asta","Armas a Distancia","Esquivar","Bloquear"};
					Object habilidad = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Seleccione la habilidad a modificar .",
							"Modificar Habilidades", JOptionPane.PLAIN_MESSAGE,
							null,conjunto,null);
					habilidad=habilidad+"";
					
				String cant = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Introduce la cantidad a otorgar.", "",
						JOptionPane.PLAIN_MESSAGE);
				
				if(personaje1.getName().equals(jugador)){

				if(habilidad.equals("Armas de Una Mano")){
					
					if(personaje1.getCombatSkills().getOneHanded()+Integer.parseInt(cant)>6 || personaje1.getCombatSkills().getOneHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
							frmHistoriasDeZagas,
							"Valor de Habilidad inválido.", "¡Error!",
							JOptionPane.OK_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							new Object[] { "Aceptar" }, "opcion 1");}
					else{
						try {
							personaje1.getCombatSkills().setOneHanded(personaje1.getCombatSkills().getOneHanded()+Integer.parseInt(cant));
						} catch (NumberFormatException | SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
						writer.flush();
						writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
						writer.flush();
					}
				}
				else if(habilidad.equals("Armas de Dos Manos")){
					
					if(personaje1.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)>6 || personaje1.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
							frmHistoriasDeZagas,
							"Valor de Habilidad inválido.", "¡Error!",
							JOptionPane.OK_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							new Object[] { "Aceptar" }, "opcion 1");}
					else{
						try {
							personaje1.getCombatSkills().setTwoHanded(personaje1.getCombatSkills().getTwoHanded()+Integer.parseInt(cant));
						} catch (NumberFormatException | SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
						writer.flush();
						writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
						writer.flush();
					}
				}
				else if(habilidad.equals("Armas de Asta")){
					
					if(personaje1.getCombatSkills().getPole()+Integer.parseInt(cant)>6 || personaje1.getCombatSkills().getPole()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
							frmHistoriasDeZagas,
							"Valor de Habilidad inválido.", "¡Error!",
							JOptionPane.OK_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							new Object[] { "Aceptar" }, "opcion 1");}
					else{
						try {
							personaje1.getCombatSkills().setPole(personaje1.getCombatSkills().getPole()+Integer.parseInt(cant));
						} catch (NumberFormatException | SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
						writer.flush();
						writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
						writer.flush();
					}
				}
				else if(habilidad.equals("Armas a Distancia")){
					
					if(personaje1.getCombatSkills().getRanged()+Integer.parseInt(cant)>6 || personaje1.getCombatSkills().getRanged()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
							frmHistoriasDeZagas,
							"Valor de Habilidad inválido.", "¡Error!",
							JOptionPane.OK_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							new Object[] { "Aceptar" }, "opcion 1");}
					else{
						try {
							personaje1.getCombatSkills().setRanged(personaje1.getCombatSkills().getRanged()+Integer.parseInt(cant));
						} catch (NumberFormatException | SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
						writer.flush();
						writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
						writer.flush();
					}
				}
				else if(habilidad.equals("Bloquear")){
					
					if(personaje1.getCombatSkills().getBlock()+Integer.parseInt(cant)>6 || personaje1.getCombatSkills().getBlock()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
							frmHistoriasDeZagas,
							"Valor de Habilidad inválido.", "¡Error!",
							JOptionPane.OK_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							new Object[] { "Aceptar" }, "opcion 1");}
					else{
						try {
							personaje1.getCombatSkills().setBlock(personaje1.getCombatSkills().getBlock()+Integer.parseInt(cant));
						} catch (NumberFormatException | SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
						writer.flush();
						writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
						writer.flush();
					}
				}
				else if(habilidad.equals("Esquivar")){
					
					if(personaje1.getCombatSkills().getDodge()+Integer.parseInt(cant)>6 || personaje1.getCombatSkills().getDodge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
							frmHistoriasDeZagas,
							"Valor de Habilidad inválido.", "¡Error!",
							JOptionPane.OK_OPTION,
							JOptionPane.PLAIN_MESSAGE, null,
							new Object[] { "Aceptar" }, "opcion 1");}
					else{
						try {
							personaje1.getCombatSkills().setDodge(personaje1.getCombatSkills().getDodge()+Integer.parseInt(cant));
						} catch (NumberFormatException | SkillOutOfBoundsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
						writer.flush();
						writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
						writer.flush();
					}
				}
			}
				
				else if(personaje2.getName().equals(jugador)){

					if(habilidad.equals("Armas de Una Mano")){
						
						if(personaje2.getCombatSkills().getOneHanded()+Integer.parseInt(cant)>6 || personaje2.getCombatSkills().getOneHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getCombatSkills().setOneHanded(personaje2.getCombatSkills().getOneHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Dos Manos")){
						
						if(personaje2.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)>6 || personaje2.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getCombatSkills().setTwoHanded(personaje2.getCombatSkills().getTwoHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Asta")){
						
						if(personaje2.getCombatSkills().getPole()+Integer.parseInt(cant)>6 || personaje2.getCombatSkills().getPole()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getCombatSkills().setPole(personaje2.getCombatSkills().getPole()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas a Distancia")){
						
						if(personaje2.getCombatSkills().getRanged()+Integer.parseInt(cant)>6 || personaje2.getCombatSkills().getRanged()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getCombatSkills().setRanged(personaje2.getCombatSkills().getRanged()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Bloquear")){
						
						if(personaje2.getCombatSkills().getBlock()+Integer.parseInt(cant)>6 || personaje2.getCombatSkills().getBlock()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getCombatSkills().setBlock(personaje2.getCombatSkills().getBlock()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Esquivar")){
						
						if(personaje2.getCombatSkills().getDodge()+Integer.parseInt(cant)>6 || personaje2.getCombatSkills().getDodge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getCombatSkills().setDodge(personaje2.getCombatSkills().getDodge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje3.getName().equals(jugador)){

					if(habilidad.equals("Armas de Una Mano")){
						
						if(personaje3.getCombatSkills().getOneHanded()+Integer.parseInt(cant)>6 || personaje3.getCombatSkills().getOneHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getCombatSkills().setOneHanded(personaje3.getCombatSkills().getOneHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Dos Manos")){
						
						if(personaje3.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)>6 || personaje3.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getCombatSkills().setTwoHanded(personaje3.getCombatSkills().getTwoHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Asta")){
						
						if(personaje3.getCombatSkills().getPole()+Integer.parseInt(cant)>6 || personaje3.getCombatSkills().getPole()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getCombatSkills().setPole(personaje3.getCombatSkills().getPole()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas a Distancia")){
						
						if(personaje3.getCombatSkills().getRanged()+Integer.parseInt(cant)>6 || personaje3.getCombatSkills().getRanged()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getCombatSkills().setRanged(personaje3.getCombatSkills().getRanged()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Bloquear")){
						
						if(personaje3.getCombatSkills().getBlock()+Integer.parseInt(cant)>6 || personaje3.getCombatSkills().getBlock()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getCombatSkills().setBlock(personaje3.getCombatSkills().getBlock()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Esquivar")){
						
						if(personaje3.getCombatSkills().getDodge()+Integer.parseInt(cant)>6 || personaje3.getCombatSkills().getDodge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getCombatSkills().setDodge(personaje3.getCombatSkills().getDodge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje4.getName().equals(jugador)){

					if(habilidad.equals("Armas de Una Mano")){
						
						if(personaje4.getCombatSkills().getOneHanded()+Integer.parseInt(cant)>6 || personaje4.getCombatSkills().getOneHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getCombatSkills().setOneHanded(personaje4.getCombatSkills().getOneHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Dos Manos")){
						
						if(personaje4.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)>6 || personaje4.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getCombatSkills().setTwoHanded(personaje4.getCombatSkills().getTwoHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Asta")){
						
						if(personaje4.getCombatSkills().getPole()+Integer.parseInt(cant)>6 || personaje4.getCombatSkills().getPole()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getCombatSkills().setPole(personaje4.getCombatSkills().getPole()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas a Distancia")){
						
						if(personaje4.getCombatSkills().getRanged()+Integer.parseInt(cant)>6 || personaje4.getCombatSkills().getRanged()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getCombatSkills().setRanged(personaje4.getCombatSkills().getRanged()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Bloquear")){
						
						if(personaje4.getCombatSkills().getBlock()+Integer.parseInt(cant)>6 || personaje4.getCombatSkills().getBlock()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getCombatSkills().setBlock(personaje4.getCombatSkills().getBlock()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Esquivar")){
						
						if(personaje4.getCombatSkills().getDodge()+Integer.parseInt(cant)>6 || personaje4.getCombatSkills().getDodge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getCombatSkills().setDodge(personaje4.getCombatSkills().getDodge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				else if(personaje5.getName().equals(jugador)){

					if(habilidad.equals("Armas de Una Mano")){
						
						if(personaje5.getCombatSkills().getOneHanded()+Integer.parseInt(cant)>6 || personaje5.getCombatSkills().getOneHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getCombatSkills().setOneHanded(personaje5.getCombatSkills().getOneHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Dos Manos")){
						
						if(personaje5.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)>6 || personaje5.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getCombatSkills().setTwoHanded(personaje5.getCombatSkills().getTwoHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Asta")){
						
						if(personaje5.getCombatSkills().getPole()+Integer.parseInt(cant)>6 || personaje5.getCombatSkills().getPole()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getCombatSkills().setPole(personaje5.getCombatSkills().getPole()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas a Distancia")){
						
						if(personaje5.getCombatSkills().getRanged()+Integer.parseInt(cant)>6 || personaje5.getCombatSkills().getRanged()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getCombatSkills().setRanged(personaje5.getCombatSkills().getRanged()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Bloquear")){
						
						if(personaje5.getCombatSkills().getBlock()+Integer.parseInt(cant)>6 || personaje5.getCombatSkills().getBlock()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getCombatSkills().setBlock(personaje5.getCombatSkills().getBlock()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Esquivar")){
						
						if(personaje5.getCombatSkills().getDodge()+Integer.parseInt(cant)>6 || personaje5.getCombatSkills().getDodge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getCombatSkills().setDodge(personaje5.getCombatSkills().getDodge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				else	if(personaje6.getName().equals(jugador)){

					if(habilidad.equals("Armas de Una Mano")){
						
						if(personaje6.getCombatSkills().getOneHanded()+Integer.parseInt(cant)>6 || personaje6.getCombatSkills().getOneHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getCombatSkills().setOneHanded(personaje6.getCombatSkills().getOneHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Dos Manos")){
						
						if(personaje6.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)>6 || personaje6.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getCombatSkills().setTwoHanded(personaje6.getCombatSkills().getTwoHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Asta")){
						
						if(personaje6.getCombatSkills().getPole()+Integer.parseInt(cant)>6 || personaje6.getCombatSkills().getPole()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getCombatSkills().setPole(personaje6.getCombatSkills().getPole()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas a Distancia")){
						
						if(personaje6.getCombatSkills().getRanged()+Integer.parseInt(cant)>6 || personaje6.getCombatSkills().getRanged()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getCombatSkills().setRanged(personaje6.getCombatSkills().getRanged()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Bloquear")){
						
						if(personaje6.getCombatSkills().getBlock()+Integer.parseInt(cant)>6 || personaje6.getCombatSkills().getBlock()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getCombatSkills().setBlock(personaje6.getCombatSkills().getBlock()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Esquivar")){
						
						if(personaje6.getCombatSkills().getDodge()+Integer.parseInt(cant)>6 || personaje6.getCombatSkills().getDodge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getCombatSkills().setDodge(personaje6.getCombatSkills().getDodge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				else if(personaje7.getName().equals(jugador)){

					if(habilidad.equals("Armas de Una Mano")){
						
						if(personaje7.getCombatSkills().getOneHanded()+Integer.parseInt(cant)>6 || personaje7.getCombatSkills().getOneHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getCombatSkills().setOneHanded(personaje7.getCombatSkills().getOneHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Dos Manos")){
						
						if(personaje7.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)>6 || personaje7.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getCombatSkills().setTwoHanded(personaje7.getCombatSkills().getTwoHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Asta")){
						
						if(personaje7.getCombatSkills().getPole()+Integer.parseInt(cant)>6 || personaje7.getCombatSkills().getPole()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getCombatSkills().setPole(personaje7.getCombatSkills().getPole()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas a Distancia")){
						
						if(personaje7.getCombatSkills().getRanged()+Integer.parseInt(cant)>6 || personaje7.getCombatSkills().getRanged()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getCombatSkills().setRanged(personaje7.getCombatSkills().getRanged()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Bloquear")){
						
						if(personaje7.getCombatSkills().getBlock()+Integer.parseInt(cant)>6 || personaje7.getCombatSkills().getBlock()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getCombatSkills().setBlock(personaje7.getCombatSkills().getBlock()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Esquivar")){
						
						if(personaje7.getCombatSkills().getDodge()+Integer.parseInt(cant)>6 || personaje7.getCombatSkills().getDodge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getCombatSkills().setDodge(personaje7.getCombatSkills().getDodge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				else if(personaje8.getName().equals(jugador)){

					if(habilidad.equals("Armas de Una Mano")){
						
						if(personaje8.getCombatSkills().getOneHanded()+Integer.parseInt(cant)>6 || personaje8.getCombatSkills().getOneHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getCombatSkills().setOneHanded(personaje8.getCombatSkills().getOneHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Dos Manos")){
						
						if(personaje8.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)>6 || personaje8.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getCombatSkills().setTwoHanded(personaje8.getCombatSkills().getTwoHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Asta")){
						
						if(personaje8.getCombatSkills().getPole()+Integer.parseInt(cant)>6 || personaje8.getCombatSkills().getPole()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getCombatSkills().setPole(personaje8.getCombatSkills().getPole()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas a Distancia")){
						
						if(personaje8.getCombatSkills().getRanged()+Integer.parseInt(cant)>6 || personaje8.getCombatSkills().getRanged()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getCombatSkills().setRanged(personaje8.getCombatSkills().getRanged()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Bloquear")){
						
						if(personaje8.getCombatSkills().getBlock()+Integer.parseInt(cant)>6 || personaje8.getCombatSkills().getBlock()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getCombatSkills().setBlock(personaje8.getCombatSkills().getBlock()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Esquivar")){
						
						if(personaje8.getCombatSkills().getDodge()+Integer.parseInt(cant)>6 || personaje8.getCombatSkills().getDodge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getCombatSkills().setDodge(personaje8.getCombatSkills().getDodge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				else	if(personaje9.getName().equals(jugador)){

					if(habilidad.equals("Armas de Una Mano")){
						
						if(personaje9.getCombatSkills().getOneHanded()+Integer.parseInt(cant)>6 || personaje9.getCombatSkills().getOneHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getCombatSkills().setOneHanded(personaje9.getCombatSkills().getOneHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Dos Manos")){
						
						if(personaje9.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)>6 || personaje9.getCombatSkills().getTwoHanded()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getCombatSkills().setTwoHanded(personaje9.getCombatSkills().getTwoHanded()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas de Asta")){
						
						if(personaje9.getCombatSkills().getPole()+Integer.parseInt(cant)>6 || personaje9.getCombatSkills().getPole()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getCombatSkills().setPole(personaje9.getCombatSkills().getPole()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Armas a Distancia")){
						
						if(personaje9.getCombatSkills().getRanged()+Integer.parseInt(cant)>6 || personaje9.getCombatSkills().getRanged()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getCombatSkills().setRanged(personaje9.getCombatSkills().getRanged()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Bloquear")){
						
						if(personaje9.getCombatSkills().getBlock()+Integer.parseInt(cant)>6 || personaje9.getCombatSkills().getBlock()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getCombatSkills().setBlock(personaje9.getCombatSkills().getBlock()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Esquivar")){
						
						if(personaje9.getCombatSkills().getDodge()+Integer.parseInt(cant)>6 || personaje9.getCombatSkills().getDodge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getCombatSkills().setDodge(personaje9.getCombatSkills().getDodge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				}
				if(rama.equals("Conocimientos")){
					Object [] conjunto={"Arte de la Guerra","Diplomacia","Etiqueta","Medicina","Ocultismo","Investigación","Negociación","Conocimientos Secretos"};
					Object habilidad = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Seleccione la habilidad a modificar .",
							"Modificar Habilidades", JOptionPane.PLAIN_MESSAGE,
							null,conjunto,null);
					habilidad=habilidad+"";
					
				String cant = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Introduce la cantidad a otorgar.", "",
						JOptionPane.PLAIN_MESSAGE);
				
				if(personaje1.getName().equals(jugador)){

					if(habilidad.equals("Arte de la Guerra")){
						
						if(personaje1.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)>6 || personaje1.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowledgeSkills().setArtofWar(personaje1.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Diplomacia")){
						
						if(personaje1.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)>6 || personaje1.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowledgeSkills().setDiplomacy(personaje1.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Etiqueta")){
						
						if(personaje1.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)>6 || personaje1.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowledgeSkills().setEtiquette(personaje1.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Medicina")){
						
						if(personaje1.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)>6 || personaje1.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowledgeSkills().setMedicine(personaje1.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Ocultismo")){
						
						if(personaje1.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)>6 || personaje1.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowledgeSkills().setOccultism(personaje1.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Investigación")){
						
						if(personaje1.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)>6 || personaje1.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowledgeSkills().setResearch(personaje1.getKnowledgeSkills().getResearch()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negociación")){
						
						if(personaje1.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)>6 || personaje1.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowledgeSkills().setNegotiation(personaje1.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Conocimientos Secretos")){
						
						if(personaje1.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)>6 || personaje1.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowledgeSkills().setSecretKnowledge(personaje1.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje2.getName().equals(jugador)){

					if(habilidad.equals("Arte de la Guerra")){
						
						if(personaje2.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)>6 || personaje2.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowledgeSkills().setArtofWar(personaje2.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Diplomacia")){
						
						if(personaje2.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)>6 || personaje2.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowledgeSkills().setDiplomacy(personaje2.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Etiqueta")){
						
						if(personaje2.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)>6 || personaje2.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowledgeSkills().setEtiquette(personaje2.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Medicina")){
						
						if(personaje2.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)>6 || personaje2.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowledgeSkills().setMedicine(personaje2.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Ocultismo")){
						
						if(personaje2.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)>6 || personaje2.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowledgeSkills().setOccultism(personaje2.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Investigación")){
						
						if(personaje2.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)>6 || personaje2.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowledgeSkills().setResearch(personaje2.getKnowledgeSkills().getResearch()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negociación")){
						
						if(personaje2.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)>6 || personaje2.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowledgeSkills().setNegotiation(personaje2.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Conocimientos Secretos")){
						
						if(personaje2.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)>6 || personaje2.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowledgeSkills().setSecretKnowledge(personaje2.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje3.getName().equals(jugador)){

					if(habilidad.equals("Arte de la Guerra")){
						
						if(personaje3.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)>6 || personaje3.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowledgeSkills().setArtofWar(personaje3.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Diplomacia")){
						
						if(personaje3.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)>6 || personaje3.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowledgeSkills().setDiplomacy(personaje3.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Etiqueta")){
						
						if(personaje3.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)>6 || personaje3.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowledgeSkills().setEtiquette(personaje3.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Medicina")){
						
						if(personaje3.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)>6 || personaje3.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowledgeSkills().setMedicine(personaje3.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Ocultismo")){
						
						if(personaje3.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)>6 || personaje3.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowledgeSkills().setOccultism(personaje3.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Investigación")){
						
						if(personaje3.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)>6 || personaje3.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowledgeSkills().setResearch(personaje3.getKnowledgeSkills().getResearch()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negociación")){
						
						if(personaje3.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)>6 || personaje3.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowledgeSkills().setNegotiation(personaje3.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Conocimientos Secretos")){
						
						if(personaje3.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)>6 || personaje3.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowledgeSkills().setSecretKnowledge(personaje3.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje4.getName().equals(jugador)){

					if(habilidad.equals("Arte de la Guerra")){
						
						if(personaje4.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)>6 || personaje4.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowledgeSkills().setArtofWar(personaje4.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Diplomacia")){
						
						if(personaje4.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)>6 || personaje4.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowledgeSkills().setDiplomacy(personaje4.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Etiqueta")){
						
						if(personaje4.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)>6 || personaje4.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowledgeSkills().setEtiquette(personaje4.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Medicina")){
						
						if(personaje4.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)>6 || personaje4.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowledgeSkills().setMedicine(personaje4.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Ocultismo")){
						
						if(personaje4.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)>6 || personaje4.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowledgeSkills().setOccultism(personaje4.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Investigación")){
						
						if(personaje4.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)>6 || personaje4.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowledgeSkills().setResearch(personaje4.getKnowledgeSkills().getResearch()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negociación")){
						
						if(personaje4.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)>6 || personaje4.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowledgeSkills().setNegotiation(personaje4.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Conocimientos Secretos")){
						
						if(personaje4.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)>6 || personaje4.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowledgeSkills().setSecretKnowledge(personaje4.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje5.getName().equals(jugador)){

					if(habilidad.equals("Arte de la Guerra")){
						
						if(personaje5.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)>6 || personaje5.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowledgeSkills().setArtofWar(personaje5.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Diplomacia")){
						
						if(personaje5.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)>6 || personaje5.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowledgeSkills().setDiplomacy(personaje5.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Etiqueta")){
						
						if(personaje5.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)>6 || personaje5.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowledgeSkills().setEtiquette(personaje5.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Medicina")){
						
						if(personaje5.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)>6 || personaje5.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowledgeSkills().setMedicine(personaje5.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Ocultismo")){
						
						if(personaje5.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)>6 || personaje5.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowledgeSkills().setOccultism(personaje5.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Investigación")){
						
						if(personaje5.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)>6 || personaje5.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowledgeSkills().setResearch(personaje5.getKnowledgeSkills().getResearch()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negociación")){
						
						if(personaje5.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)>6 || personaje5.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowledgeSkills().setNegotiation(personaje5.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Conocimientos Secretos")){
						
						if(personaje5.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)>6 || personaje5.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowledgeSkills().setSecretKnowledge(personaje5.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje6.getName().equals(jugador)){

					if(habilidad.equals("Arte de la Guerra")){
						
						if(personaje6.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)>6 || personaje6.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowledgeSkills().setArtofWar(personaje6.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Diplomacia")){
						
						if(personaje6.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)>6 || personaje6.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowledgeSkills().setDiplomacy(personaje6.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Etiqueta")){
						
						if(personaje6.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)>6 || personaje6.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowledgeSkills().setEtiquette(personaje6.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Medicina")){
						
						if(personaje6.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)>6 || personaje6.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowledgeSkills().setMedicine(personaje6.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Ocultismo")){
						
						if(personaje6.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)>6 || personaje6.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowledgeSkills().setOccultism(personaje6.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Investigación")){
						
						if(personaje6.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)>6 || personaje6.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowledgeSkills().setResearch(personaje6.getKnowledgeSkills().getResearch()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negociación")){
						
						if(personaje6.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)>6 || personaje6.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowledgeSkills().setNegotiation(personaje6.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Conocimientos Secretos")){
						
						if(personaje6.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)>6 || personaje6.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowledgeSkills().setSecretKnowledge(personaje6.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje7.getName().equals(jugador)){

					if(habilidad.equals("Arte de la Guerra")){
						
						if(personaje7.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)>6 || personaje7.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowledgeSkills().setArtofWar(personaje7.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Diplomacia")){
						
						if(personaje7.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)>6 || personaje7.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowledgeSkills().setDiplomacy(personaje7.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Etiqueta")){
						
						if(personaje7.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)>6 || personaje7.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowledgeSkills().setEtiquette(personaje7.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Medicina")){
						
						if(personaje7.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)>6 || personaje7.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowledgeSkills().setMedicine(personaje7.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Ocultismo")){
						
						if(personaje7.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)>6 || personaje7.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowledgeSkills().setOccultism(personaje7.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Investigación")){
						
						if(personaje7.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)>6 || personaje7.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowledgeSkills().setResearch(personaje7.getKnowledgeSkills().getResearch()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negociación")){
						
						if(personaje7.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)>6 || personaje7.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowledgeSkills().setNegotiation(personaje7.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Conocimientos Secretos")){
						
						if(personaje7.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)>6 || personaje7.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowledgeSkills().setSecretKnowledge(personaje7.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje8.getName().equals(jugador)){

					if(habilidad.equals("Arte de la Guerra")){
						
						if(personaje8.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)>6 || personaje8.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowledgeSkills().setArtofWar(personaje8.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Diplomacia")){
						
						if(personaje8.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)>6 || personaje8.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowledgeSkills().setDiplomacy(personaje8.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Etiqueta")){
						
						if(personaje8.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)>6 || personaje8.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowledgeSkills().setEtiquette(personaje8.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Medicina")){
						
						if(personaje8.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)>6 || personaje8.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowledgeSkills().setMedicine(personaje8.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Ocultismo")){
						
						if(personaje8.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)>6 || personaje8.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowledgeSkills().setOccultism(personaje8.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Investigación")){
						
						if(personaje8.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)>6 || personaje8.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowledgeSkills().setResearch(personaje8.getKnowledgeSkills().getResearch()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negociación")){
						
						if(personaje8.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)>6 || personaje8.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowledgeSkills().setNegotiation(personaje8.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Conocimientos Secretos")){
						
						if(personaje8.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)>6 || personaje8.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowledgeSkills().setSecretKnowledge(personaje8.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje9.getName().equals(jugador)){

					if(habilidad.equals("Arte de la Guerra")){
						
						if(personaje9.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)>6 || personaje9.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowledgeSkills().setArtofWar(personaje9.getKnowledgeSkills().getArtofWar()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Diplomacia")){
						
						if(personaje9.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)>6 || personaje9.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowledgeSkills().setDiplomacy(personaje9.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Etiqueta")){
						
						if(personaje9.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)>6 || personaje9.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowledgeSkills().setEtiquette(personaje9.getKnowledgeSkills().getEtiquette()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Medicina")){
						
						if(personaje9.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)>6 || personaje9.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowledgeSkills().setMedicine(personaje9.getKnowledgeSkills().getMedicine()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Ocultismo")){
						
						if(personaje9.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)>6 || personaje9.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowledgeSkills().setOccultism(personaje9.getKnowledgeSkills().getOccultism()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Investigación")){
						
						if(personaje9.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)>6 || personaje9.getKnowledgeSkills().getResearch()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowledgeSkills().setResearch(personaje9.getKnowledgeSkills().getResearch()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negociación")){
						
						if(personaje9.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)>6 || personaje9.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowledgeSkills().setNegotiation(personaje9.getKnowledgeSkills().getNegotiation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Conocimientos Secretos")){
						
						if(personaje9.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)>6 || personaje9.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowledgeSkills().setSecretKnowledge(personaje9.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
			}
				if(rama.equals("Magia")){
					Object [] conjunto={"Fuego","Agua","Tierra","Viento","Druídica","Blanca","Negra","Arcana"};
					Object habilidad = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Seleccione la habilidad a modificar .",
							"Modificar Habilidades", JOptionPane.PLAIN_MESSAGE,
							null,conjunto,null);
					habilidad=habilidad+"";
					
				String cant = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Introduce la cantidad a otorgar.", "",
						JOptionPane.PLAIN_MESSAGE);
				
				if(personaje1.getName().equals(jugador)){

					if(habilidad.equals("Fuego")){
						
						if(personaje1.getMagicSkills().getFire()+Integer.parseInt(cant)>6 || personaje1.getMagicSkills().getFire()+Integer.parseInt(cant)<0){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Habilidad inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje1.getMagicSkills().setFire(personaje1.getMagicSkills().getFire()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Agua")){
						
						if(personaje1.getMagicSkills().getWater()+Integer.parseInt(cant)>6 || personaje1.getMagicSkills().getWater()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getMagicSkills().setWater(personaje1.getMagicSkills().getWater()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Tierra")){
						
						if(personaje1.getMagicSkills().getEarth()+Integer.parseInt(cant)>6 || personaje1.getMagicSkills().getEarth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getMagicSkills().setEarth(personaje1.getMagicSkills().getEarth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Viento")){
						
						if(personaje1.getMagicSkills().getWind()+Integer.parseInt(cant)>6 || personaje1.getMagicSkills().getWind()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getMagicSkills().setWind(personaje1.getMagicSkills().getWind()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Druídica")){
						
						if(personaje1.getMagicSkills().getDruidic()+Integer.parseInt(cant)>6 || personaje1.getMagicSkills().getDruidic()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getMagicSkills().setDruidic(personaje1.getMagicSkills().getDruidic()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Blanca")){
						
						if(personaje1.getMagicSkills().getWhite()+Integer.parseInt(cant)>6 || personaje1.getMagicSkills().getWhite()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getMagicSkills().setWhite(personaje1.getMagicSkills().getWhite()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negra")){
						
						if(personaje1.getMagicSkills().getBlack()+Integer.parseInt(cant)>6 || personaje1.getMagicSkills().getBlack()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getMagicSkills().setBlack(personaje1.getMagicSkills().getBlack()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Arcana")){
						
						if(personaje1.getMagicSkills().getArcane()+Integer.parseInt(cant)>6 || personaje1.getMagicSkills().getArcane()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getMagicSkills().setArcane(personaje1.getMagicSkills().getArcane()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje2.getName().equals(jugador)){

					if(habilidad.equals("Fuego")){
						
						if(personaje2.getMagicSkills().getFire()+Integer.parseInt(cant)>6 || personaje2.getMagicSkills().getFire()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getMagicSkills().setFire(personaje2.getMagicSkills().getFire()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Agua")){
						
						if(personaje2.getMagicSkills().getWater()+Integer.parseInt(cant)>6 || personaje2.getMagicSkills().getWater()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getMagicSkills().setWater(personaje2.getMagicSkills().getWater()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Tierra")){
						
						if(personaje2.getMagicSkills().getEarth()+Integer.parseInt(cant)>6 || personaje2.getMagicSkills().getEarth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getMagicSkills().setEarth(personaje2.getMagicSkills().getEarth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Viento")){
						
						if(personaje2.getMagicSkills().getWind()+Integer.parseInt(cant)>6 || personaje2.getMagicSkills().getWind()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getMagicSkills().setWind(personaje2.getMagicSkills().getWind()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Druídica")){
						
						if(personaje2.getMagicSkills().getDruidic()+Integer.parseInt(cant)>6 || personaje2.getMagicSkills().getDruidic()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getMagicSkills().setDruidic(personaje2.getMagicSkills().getDruidic()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Blanca")){
						
						if(personaje2.getMagicSkills().getWhite()+Integer.parseInt(cant)>6 || personaje2.getMagicSkills().getWhite()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getMagicSkills().setWhite(personaje2.getMagicSkills().getWhite()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negra")){
						
						if(personaje2.getMagicSkills().getBlack()+Integer.parseInt(cant)>6 || personaje2.getMagicSkills().getBlack()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getMagicSkills().setBlack(personaje2.getMagicSkills().getBlack()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Arcana")){
						
						if(personaje2.getMagicSkills().getArcane()+Integer.parseInt(cant)>6 || personaje2.getMagicSkills().getArcane()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getMagicSkills().setArcane(personaje2.getMagicSkills().getArcane()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje3.getName().equals(jugador)){

					if(habilidad.equals("Fuego")){
						
						if(personaje3.getMagicSkills().getFire()+Integer.parseInt(cant)>6 || personaje3.getMagicSkills().getFire()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getMagicSkills().setFire(personaje3.getMagicSkills().getFire()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Agua")){
						
						if(personaje3.getMagicSkills().getWater()+Integer.parseInt(cant)>6 || personaje3.getMagicSkills().getWater()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getMagicSkills().setWater(personaje3.getMagicSkills().getWater()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Tierra")){
						
						if(personaje3.getMagicSkills().getEarth()+Integer.parseInt(cant)>6 || personaje3.getMagicSkills().getEarth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getMagicSkills().setEarth(personaje3.getMagicSkills().getEarth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Viento")){
						
						if(personaje3.getMagicSkills().getWind()+Integer.parseInt(cant)>6 || personaje3.getMagicSkills().getWind()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getMagicSkills().setWind(personaje3.getMagicSkills().getWind()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Druídica")){
						
						if(personaje3.getMagicSkills().getDruidic()+Integer.parseInt(cant)>6 || personaje3.getMagicSkills().getDruidic()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getMagicSkills().setDruidic(personaje3.getMagicSkills().getDruidic()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Blanca")){
						
						if(personaje3.getMagicSkills().getWhite()+Integer.parseInt(cant)>6 || personaje3.getMagicSkills().getWhite()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getMagicSkills().setWhite(personaje3.getMagicSkills().getWhite()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negra")){
						
						if(personaje3.getMagicSkills().getBlack()+Integer.parseInt(cant)>6 || personaje3.getMagicSkills().getBlack()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getMagicSkills().setBlack(personaje3.getMagicSkills().getBlack()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Arcana")){
						
						if(personaje3.getMagicSkills().getArcane()+Integer.parseInt(cant)>6 || personaje3.getMagicSkills().getArcane()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getMagicSkills().setArcane(personaje3.getMagicSkills().getArcane()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
	
				
				else if(personaje4.getName().equals(jugador)){

					if(habilidad.equals("Fuego")){
						
						if(personaje4.getMagicSkills().getFire()+Integer.parseInt(cant)>6 || personaje4.getMagicSkills().getFire()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getMagicSkills().setFire(personaje4.getMagicSkills().getFire()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Agua")){
						
						if(personaje4.getMagicSkills().getWater()+Integer.parseInt(cant)>6 || personaje4.getMagicSkills().getWater()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getMagicSkills().setWater(personaje4.getMagicSkills().getWater()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Tierra")){
						
						if(personaje4.getMagicSkills().getEarth()+Integer.parseInt(cant)>6 || personaje4.getMagicSkills().getEarth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getMagicSkills().setEarth(personaje4.getMagicSkills().getEarth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Viento")){
						
						if(personaje4.getMagicSkills().getWind()+Integer.parseInt(cant)>6 || personaje4.getMagicSkills().getWind()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getMagicSkills().setWind(personaje4.getMagicSkills().getWind()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Druídica")){
						
						if(personaje4.getMagicSkills().getDruidic()+Integer.parseInt(cant)>6 || personaje4.getMagicSkills().getDruidic()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getMagicSkills().setDruidic(personaje4.getMagicSkills().getDruidic()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Blanca")){
						
						if(personaje4.getMagicSkills().getWhite()+Integer.parseInt(cant)>6 || personaje4.getMagicSkills().getWhite()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getMagicSkills().setWhite(personaje4.getMagicSkills().getWhite()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negra")){
						
						if(personaje4.getMagicSkills().getBlack()+Integer.parseInt(cant)>6 || personaje4.getMagicSkills().getBlack()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getMagicSkills().setBlack(personaje4.getMagicSkills().getBlack()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Arcana")){
						
						if(personaje4.getMagicSkills().getArcane()+Integer.parseInt(cant)>6 || personaje4.getMagicSkills().getArcane()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getMagicSkills().setArcane(personaje4.getMagicSkills().getArcane()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje5.getName().equals(jugador)){

					if(habilidad.equals("Fuego")){
						
						if(personaje5.getMagicSkills().getFire()+Integer.parseInt(cant)>6 || personaje5.getMagicSkills().getFire()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getMagicSkills().setFire(personaje5.getMagicSkills().getFire()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Agua")){
						
						if(personaje5.getMagicSkills().getWater()+Integer.parseInt(cant)>6 || personaje5.getMagicSkills().getWater()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getMagicSkills().setWater(personaje5.getMagicSkills().getWater()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Tierra")){
						
						if(personaje5.getMagicSkills().getEarth()+Integer.parseInt(cant)>6 || personaje5.getMagicSkills().getEarth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getMagicSkills().setEarth(personaje5.getMagicSkills().getEarth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Viento")){
						
						if(personaje5.getMagicSkills().getWind()+Integer.parseInt(cant)>6 || personaje5.getMagicSkills().getWind()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getMagicSkills().setWind(personaje5.getMagicSkills().getWind()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Druídica")){
						
						if(personaje5.getMagicSkills().getDruidic()+Integer.parseInt(cant)>6 || personaje5.getMagicSkills().getDruidic()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getMagicSkills().setDruidic(personaje5.getMagicSkills().getDruidic()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Blanca")){
						
						if(personaje5.getMagicSkills().getWhite()+Integer.parseInt(cant)>6 || personaje5.getMagicSkills().getWhite()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getMagicSkills().setWhite(personaje5.getMagicSkills().getWhite()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negra")){
						
						if(personaje5.getMagicSkills().getBlack()+Integer.parseInt(cant)>6 || personaje5.getMagicSkills().getBlack()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getMagicSkills().setBlack(personaje5.getMagicSkills().getBlack()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Arcana")){
						
						if(personaje5.getMagicSkills().getArcane()+Integer.parseInt(cant)>6 || personaje5.getMagicSkills().getArcane()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getMagicSkills().setArcane(personaje5.getMagicSkills().getArcane()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje6.getName().equals(jugador)){

					if(habilidad.equals("Fuego")){
						
						if(personaje6.getMagicSkills().getFire()+Integer.parseInt(cant)>6 || personaje6.getMagicSkills().getFire()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getMagicSkills().setFire(personaje6.getMagicSkills().getFire()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Agua")){
						
						if(personaje6.getMagicSkills().getWater()+Integer.parseInt(cant)>6 || personaje6.getMagicSkills().getWater()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getMagicSkills().setWater(personaje6.getMagicSkills().getWater()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Tierra")){
						
						if(personaje6.getMagicSkills().getEarth()+Integer.parseInt(cant)>6 || personaje6.getMagicSkills().getEarth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getMagicSkills().setEarth(personaje6.getMagicSkills().getEarth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Viento")){
						
						if(personaje6.getMagicSkills().getWind()+Integer.parseInt(cant)>6 || personaje6.getMagicSkills().getWind()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getMagicSkills().setWind(personaje6.getMagicSkills().getWind()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Druídica")){
						
						if(personaje6.getMagicSkills().getDruidic()+Integer.parseInt(cant)>6 || personaje6.getMagicSkills().getDruidic()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getMagicSkills().setDruidic(personaje6.getMagicSkills().getDruidic()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Blanca")){
						
						if(personaje6.getMagicSkills().getWhite()+Integer.parseInt(cant)>6 || personaje6.getMagicSkills().getWhite()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getMagicSkills().setWhite(personaje6.getMagicSkills().getWhite()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negra")){
						
						if(personaje6.getMagicSkills().getBlack()+Integer.parseInt(cant)>6 || personaje6.getMagicSkills().getBlack()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getMagicSkills().setBlack(personaje6.getMagicSkills().getBlack()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Arcana")){
						
						if(personaje6.getMagicSkills().getArcane()+Integer.parseInt(cant)>6 || personaje6.getMagicSkills().getArcane()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getMagicSkills().setArcane(personaje6.getMagicSkills().getArcane()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje7.getName().equals(jugador)){

					if(habilidad.equals("Fuego")){
						
						if(personaje7.getMagicSkills().getFire()+Integer.parseInt(cant)>6 || personaje7.getMagicSkills().getFire()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getMagicSkills().setFire(personaje7.getMagicSkills().getFire()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Agua")){
						
						if(personaje7.getMagicSkills().getWater()+Integer.parseInt(cant)>6 || personaje7.getMagicSkills().getWater()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getMagicSkills().setWater(personaje7.getMagicSkills().getWater()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Tierra")){
						
						if(personaje7.getMagicSkills().getEarth()+Integer.parseInt(cant)>6 || personaje7.getMagicSkills().getEarth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getMagicSkills().setEarth(personaje7.getMagicSkills().getEarth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Viento")){
						
						if(personaje7.getMagicSkills().getWind()+Integer.parseInt(cant)>6 || personaje7.getMagicSkills().getWind()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getMagicSkills().setWind(personaje7.getMagicSkills().getWind()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Druídica")){
						
						if(personaje7.getMagicSkills().getDruidic()+Integer.parseInt(cant)>6 || personaje7.getMagicSkills().getDruidic()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getMagicSkills().setDruidic(personaje7.getMagicSkills().getDruidic()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Blanca")){
						
						if(personaje7.getMagicSkills().getWhite()+Integer.parseInt(cant)>6 || personaje7.getMagicSkills().getWhite()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getMagicSkills().setWhite(personaje7.getMagicSkills().getWhite()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negra")){
						
						if(personaje7.getMagicSkills().getBlack()+Integer.parseInt(cant)>6 || personaje7.getMagicSkills().getBlack()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getMagicSkills().setBlack(personaje7.getMagicSkills().getBlack()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Arcana")){
						
						if(personaje7.getMagicSkills().getArcane()+Integer.parseInt(cant)>6 || personaje7.getMagicSkills().getArcane()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getMagicSkills().setArcane(personaje7.getMagicSkills().getArcane()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje8.getName().equals(jugador)){

					if(habilidad.equals("Fuego")){
						
						if(personaje8.getMagicSkills().getFire()+Integer.parseInt(cant)>6 || personaje8.getMagicSkills().getFire()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getMagicSkills().setFire(personaje8.getMagicSkills().getFire()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Agua")){
						
						if(personaje8.getMagicSkills().getWater()+Integer.parseInt(cant)>6 || personaje8.getMagicSkills().getWater()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getMagicSkills().setWater(personaje8.getMagicSkills().getWater()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Tierra")){
						
						if(personaje8.getMagicSkills().getEarth()+Integer.parseInt(cant)>6 || personaje8.getMagicSkills().getEarth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getMagicSkills().setEarth(personaje8.getMagicSkills().getEarth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Viento")){
						
						if(personaje8.getMagicSkills().getWind()+Integer.parseInt(cant)>6 || personaje8.getMagicSkills().getWind()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getMagicSkills().setWind(personaje8.getMagicSkills().getWind()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Druídica")){
						
						if(personaje8.getMagicSkills().getDruidic()+Integer.parseInt(cant)>6 || personaje8.getMagicSkills().getDruidic()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getMagicSkills().setDruidic(personaje8.getMagicSkills().getDruidic()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Blanca")){
						
						if(personaje8.getMagicSkills().getWhite()+Integer.parseInt(cant)>6 || personaje8.getMagicSkills().getWhite()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getMagicSkills().setWhite(personaje8.getMagicSkills().getWhite()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negra")){
						
						if(personaje8.getMagicSkills().getBlack()+Integer.parseInt(cant)>6 || personaje8.getMagicSkills().getBlack()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getMagicSkills().setBlack(personaje8.getMagicSkills().getBlack()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Arcana")){
						
						if(personaje8.getMagicSkills().getArcane()+Integer.parseInt(cant)>6 || personaje8.getMagicSkills().getArcane()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getMagicSkills().setArcane(personaje8.getMagicSkills().getArcane()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje9.getName().equals(jugador)){

					if(habilidad.equals("Fuego")){
						
						if(personaje9.getMagicSkills().getFire()+Integer.parseInt(cant)>6 || personaje9.getMagicSkills().getFire()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getMagicSkills().setFire(personaje9.getMagicSkills().getFire()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Agua")){
						
						if(personaje9.getMagicSkills().getWater()+Integer.parseInt(cant)>6 || personaje9.getMagicSkills().getWater()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getMagicSkills().setWater(personaje9.getMagicSkills().getWater()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Tierra")){
						
						if(personaje9.getMagicSkills().getEarth()+Integer.parseInt(cant)>6 || personaje9.getMagicSkills().getEarth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getMagicSkills().setEarth(personaje9.getMagicSkills().getEarth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Viento")){
						
						if(personaje9.getMagicSkills().getWind()+Integer.parseInt(cant)>6 || personaje9.getMagicSkills().getWind()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getMagicSkills().setWind(personaje9.getMagicSkills().getWind()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Druídica")){
						
						if(personaje9.getMagicSkills().getDruidic()+Integer.parseInt(cant)>6 || personaje9.getMagicSkills().getDruidic()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getMagicSkills().setDruidic(personaje9.getMagicSkills().getDruidic()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Blanca")){
						
						if(personaje9.getMagicSkills().getWhite()+Integer.parseInt(cant)>6 || personaje9.getMagicSkills().getWhite()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getMagicSkills().setWhite(personaje9.getMagicSkills().getWhite()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Negra")){
						
						if(personaje9.getMagicSkills().getBlack()+Integer.parseInt(cant)>6 || personaje9.getMagicSkills().getBlack()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getMagicSkills().setBlack(personaje9.getMagicSkills().getBlack()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Arcana")){
						
						if(personaje9.getMagicSkills().getArcane()+Integer.parseInt(cant)>6 || personaje9.getMagicSkills().getArcane()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getMagicSkills().setArcane(personaje9.getMagicSkills().getArcane()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				}
				
				if(rama.equals("Destrezas")){
					Object [] conjunto={"Atletismo","Supervivencia","Equitación","Trampas","Sigilo"};
					Object habilidad = JOptionPane.showInputDialog(
							frmHistoriasDeZagas, "Seleccione la habilidad a modificar .",
							"Modificar Habilidades", JOptionPane.PLAIN_MESSAGE,
							null,conjunto,null);
					habilidad=habilidad+"";
					
				String cant = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Introduce la cantidad a otorgar.", "",
						JOptionPane.PLAIN_MESSAGE);
	
				if(personaje1.getName().equals(jugador)){

					if(habilidad.equals("Atletismo")){
						
						if(personaje1.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)>6 || personaje1.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowhowSkills().setAthletics(personaje1.getKnowhowSkills().getAthletics()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Supervivencia")){
						
						if(personaje1.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)>6 || personaje1.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowhowSkills().setSurvival(personaje1.getKnowhowSkills().getSurvival()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Equitación")){
						
						if(personaje1.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)>6 || personaje1.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowhowSkills().setEquitation(personaje1.getKnowhowSkills().getEquitation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Trampas")){
						
						if(personaje1.getKnowhowSkills().getTraps()+Integer.parseInt(cant)>6 || personaje1.getKnowhowSkills().getTraps()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowhowSkills().setTraps(personaje1.getKnowhowSkills().getTraps()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Sigilo")){
						
						if(personaje1.getKnowhowSkills().getStealth()+Integer.parseInt(cant)>6 || personaje1.getKnowhowSkills().getStealth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje1.getKnowhowSkills().setStealth(personaje1.getKnowhowSkills().getStealth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje2.getName().equals(jugador)){

					if(habilidad.equals("Atletismo")){
						
						if(personaje2.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)>6 || personaje2.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowhowSkills().setAthletics(personaje2.getKnowhowSkills().getAthletics()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Supervivencia")){
						
						if(personaje2.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)>6 || personaje2.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowhowSkills().setSurvival(personaje2.getKnowhowSkills().getSurvival()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Equitación")){
						
						if(personaje2.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)>6 || personaje2.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowhowSkills().setEquitation(personaje2.getKnowhowSkills().getEquitation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Trampas")){
						
						if(personaje2.getKnowhowSkills().getTraps()+Integer.parseInt(cant)>6 || personaje2.getKnowhowSkills().getTraps()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowhowSkills().setTraps(personaje2.getKnowhowSkills().getTraps()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Sigilo")){
						
						if(personaje2.getKnowhowSkills().getStealth()+Integer.parseInt(cant)>6 || personaje2.getKnowhowSkills().getStealth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje2.getKnowhowSkills().setStealth(personaje2.getKnowhowSkills().getStealth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje3.getName().equals(jugador)){

					if(habilidad.equals("Atletismo")){
						
						if(personaje3.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)>6 || personaje3.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowhowSkills().setAthletics(personaje3.getKnowhowSkills().getAthletics()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Supervivencia")){
						
						if(personaje3.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)>6 || personaje3.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowhowSkills().setSurvival(personaje3.getKnowhowSkills().getSurvival()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Equitación")){
						
						if(personaje3.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)>6 || personaje3.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowhowSkills().setEquitation(personaje3.getKnowhowSkills().getEquitation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Trampas")){
						
						if(personaje3.getKnowhowSkills().getTraps()+Integer.parseInt(cant)>6 || personaje3.getKnowhowSkills().getTraps()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowhowSkills().setTraps(personaje3.getKnowhowSkills().getTraps()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Sigilo")){
						
						if(personaje3.getKnowhowSkills().getStealth()+Integer.parseInt(cant)>6 || personaje3.getKnowhowSkills().getStealth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje3.getKnowhowSkills().setStealth(personaje3.getKnowhowSkills().getStealth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje4.getName().equals(jugador)){

					if(habilidad.equals("Atletismo")){
						
						if(personaje4.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)>6 || personaje4.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowhowSkills().setAthletics(personaje4.getKnowhowSkills().getAthletics()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Supervivencia")){
						
						if(personaje4.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)>6 || personaje4.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowhowSkills().setSurvival(personaje4.getKnowhowSkills().getSurvival()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Equitación")){
						
						if(personaje4.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)>6 || personaje4.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowhowSkills().setEquitation(personaje4.getKnowhowSkills().getEquitation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Trampas")){
						
						if(personaje4.getKnowhowSkills().getTraps()+Integer.parseInt(cant)>6 || personaje4.getKnowhowSkills().getTraps()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowhowSkills().setTraps(personaje4.getKnowhowSkills().getTraps()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Sigilo")){
						
						if(personaje4.getKnowhowSkills().getStealth()+Integer.parseInt(cant)>6 || personaje4.getKnowhowSkills().getStealth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje4.getKnowhowSkills().setStealth(personaje4.getKnowhowSkills().getStealth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje5.getName().equals(jugador)){

					if(habilidad.equals("Atletismo")){
						
						if(personaje5.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)>6 || personaje5.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowhowSkills().setAthletics(personaje5.getKnowhowSkills().getAthletics()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Supervivencia")){
						
						if(personaje5.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)>6 || personaje5.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowhowSkills().setSurvival(personaje5.getKnowhowSkills().getSurvival()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Equitación")){
						
						if(personaje5.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)>6 || personaje5.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowhowSkills().setEquitation(personaje5.getKnowhowSkills().getEquitation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Trampas")){
						
						if(personaje5.getKnowhowSkills().getTraps()+Integer.parseInt(cant)>6 || personaje5.getKnowhowSkills().getTraps()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowhowSkills().setTraps(personaje5.getKnowhowSkills().getTraps()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Sigilo")){
						
						if(personaje5.getKnowhowSkills().getStealth()+Integer.parseInt(cant)>6 || personaje5.getKnowhowSkills().getStealth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje5.getKnowhowSkills().setStealth(personaje5.getKnowhowSkills().getStealth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje6.getName().equals(jugador)){

					if(habilidad.equals("Atletismo")){
						
						if(personaje6.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)>6 || personaje6.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowhowSkills().setAthletics(personaje6.getKnowhowSkills().getAthletics()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Supervivencia")){
						
						if(personaje6.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)>6 || personaje6.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowhowSkills().setSurvival(personaje6.getKnowhowSkills().getSurvival()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Equitación")){
						
						if(personaje6.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)>6 || personaje6.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowhowSkills().setEquitation(personaje6.getKnowhowSkills().getEquitation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Trampas")){
						
						if(personaje6.getKnowhowSkills().getTraps()+Integer.parseInt(cant)>6 || personaje6.getKnowhowSkills().getTraps()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowhowSkills().setTraps(personaje6.getKnowhowSkills().getTraps()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Sigilo")){
						
						if(personaje6.getKnowhowSkills().getStealth()+Integer.parseInt(cant)>6 || personaje6.getKnowhowSkills().getStealth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje6.getKnowhowSkills().setStealth(personaje6.getKnowhowSkills().getStealth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje7.getName().equals(jugador)){

					if(habilidad.equals("Atletismo")){
						
						if(personaje7.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)>6 || personaje7.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowhowSkills().setAthletics(personaje7.getKnowhowSkills().getAthletics()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Supervivencia")){
						
						if(personaje7.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)>6 || personaje7.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowhowSkills().setSurvival(personaje7.getKnowhowSkills().getSurvival()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Equitación")){
						
						if(personaje7.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)>6 || personaje7.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowhowSkills().setEquitation(personaje7.getKnowhowSkills().getEquitation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Trampas")){
						
						if(personaje7.getKnowhowSkills().getTraps()+Integer.parseInt(cant)>6 || personaje7.getKnowhowSkills().getTraps()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowhowSkills().setTraps(personaje7.getKnowhowSkills().getTraps()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Sigilo")){
						
						if(personaje7.getKnowhowSkills().getStealth()+Integer.parseInt(cant)>6 || personaje7.getKnowhowSkills().getStealth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje7.getKnowhowSkills().setStealth(personaje7.getKnowhowSkills().getStealth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje8.getName().equals(jugador)){

					if(habilidad.equals("Atletismo")){
						
						if(personaje8.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)>6 || personaje8.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowhowSkills().setAthletics(personaje8.getKnowhowSkills().getAthletics()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Supervivencia")){
						
						if(personaje8.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)>6 || personaje8.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowhowSkills().setSurvival(personaje8.getKnowhowSkills().getSurvival()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Equitación")){
						
						if(personaje8.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)>6 || personaje8.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowhowSkills().setEquitation(personaje8.getKnowhowSkills().getEquitation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Trampas")){
						
						if(personaje8.getKnowhowSkills().getTraps()+Integer.parseInt(cant)>6 || personaje8.getKnowhowSkills().getTraps()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowhowSkills().setTraps(personaje8.getKnowhowSkills().getTraps()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Sigilo")){
						
						if(personaje8.getKnowhowSkills().getStealth()+Integer.parseInt(cant)>6 || personaje8.getKnowhowSkills().getStealth()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje8.getKnowhowSkills().setStealth(personaje8.getKnowhowSkills().getStealth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				else if(personaje9.getName().equals(jugador)){

					if(habilidad.equals("Atletismo")){
						
						if(personaje9.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)>6 || personaje9.getKnowhowSkills().getAthletics()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowhowSkills().setAthletics(personaje9.getKnowhowSkills().getAthletics()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Supervivencia")){
						
						if(personaje9.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)>6 || personaje9.getKnowhowSkills().getSurvival()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowhowSkills().setSurvival(personaje9.getKnowhowSkills().getSurvival()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Equitación")){
						
						if(personaje9.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)>6 || personaje9.getKnowhowSkills().getEquitation()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowhowSkills().setEquitation(personaje9.getKnowhowSkills().getEquitation()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Trampas")){
						
						if(personaje9.getKnowhowSkills().getTraps()+Integer.parseInt(cant)>6 || personaje9.getKnowhowSkills().getTraps()+Integer.parseInt(cant)<0){int solucion = JOptionPane.showOptionDialog(
								frmHistoriasDeZagas,
								"Valor de Habilidad inválido.", "¡Error!",
								JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null,
								new Object[] { "Aceptar" }, "opcion 1");}
						else{
							try {
								personaje9.getKnowhowSkills().setTraps(personaje9.getKnowhowSkills().getTraps()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
					else if(habilidad.equals("Sigilo")){
						
						if(personaje9.getKnowhowSkills().getStealth()+Integer.parseInt(cant)>6 || personaje9.getKnowhowSkills().getStealth()+Integer.parseInt(cant)<0){
							int solucion = JOptionPane.showOptionDialog(
									frmHistoriasDeZagas,
									"Valor de Habilidad inválido.", "¡Error!",
									JOptionPane.OK_OPTION,
									JOptionPane.PLAIN_MESSAGE, null,
									new Object[] { "Aceptar" }, "opcion 1");
						}
						else{
							try {
								personaje9.getKnowhowSkills().setStealth(personaje9.getKnowhowSkills().getStealth()+Integer.parseInt(cant));
							} catch (NumberFormatException | SkillOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							writer.println(jugador+":"+cant+":darHab:"+rama+":"+habilidad);
							writer.flush();
							writer.println("Información: Se ha modificado la habilidad "+habilidad+" del personaje "+jugador+" en "+cant+ " puntos :Chat");
							writer.flush();
						}
					}
				}
				
				}
				
				//writer.println(/*Usuario escogido*/":"/*Cantidad escogida*/+":darHab:"/*Tipo de Habilidad*/+":"/*Habilidad Concreta*/);
				//writer.flush();
			}
		});
		btnDarHabilidades.setBounds(10, 190, 187, 31);
		panel_7.add(btnDarHabilidades);
		
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
					Armor armor = new Armor ("", "",false,false, null);
 					Weapons weapon1 = new Weapons("", "", false, false, null, "");
 					Weapons weapon2 = new Weapons("", "", false, false, null, "");
 					Weapons weapon3= new Weapons("", "", false, false, null, "");
 					Weapons weapon4= new Weapons("", "", false, false, null, "");
 					Misc misc1 = new Misc("","",false,false,null);
 					Misc misc2= new Misc("","",false,false,null);
 					Misc misc3= new Misc("","",false,false,null);
 					Misc misc4= new Misc("","",false,false,null);
 					Accesories accesorie1= new Accesories("","",false,false,null);
 					Accesories accesorie2= new Accesories("","",false,false,null);
 					Accesories accesorie3= new Accesories("","",false,false,null);
 					Accesories accesorie4= new Accesories("","",false,false,null);
 					
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
 							nombre = ""+rs.getString("NOMBRE");
 							edad = rs.getInt("EDAD");
 							raza = ""+rs.getString("RAZA");
 							descripcionF = ""+rs.getString("DESCRIPCION_FISICA");
 							;
 							bendicion = ""+rs.getString("BENDICION");
 							privilegio1 = ""+rs.getString("PRIVILEGIO1");
 							privilegio2 = ""+rs.getString("PRIVILEGIO2");
 							privilegio3 = ""+rs.getString("PRIVILEGIO3");
 							privilegio4 = ""+rs.getString("PRIVILEGIO4");
 							privilegio5 = ""+rs.getString("PRIVILEGIO5");
 							reves1 = ""+rs.getString("REVES1");
 							reves2 = ""+rs.getString("REVES2");
 							reves3 = ""+rs.getString("REVES3");
 							reves4 = ""+rs.getString("REVES4");
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
 							armadura = ""+rs.getString("ARMADURA");
 							descripcionArm = ""+rs.getString("DESCRIPCION_ARMADURA");
 							posesionArm = ""+rs.getString("POSESION_ARMADURA");
 							prop1Arm = ""+rs.getString("PROPIEDAD1_ARMADURA");
 							prop2Arm = ""+rs.getString("PROPIEDAD2_ARMADURA");
 							prop3Arm = ""+rs.getString("PROPIEDAD3_ARMADURA");
 							weap1 = ""+rs.getString("ARMA1");
 							descripcionWeap1 = ""+rs.getString("DESCRIPCION_ARMA1");
 							posesionWeap1 = ""+rs.getString("POSESION_ARMA1");
 							prop1Weap1 = ""+rs.getString("PROPIEDAD1_ARMA1");
 							prop2Weap1 = ""+rs.getString("PROPIEDAD2_ARMA1");
 							prop3Weap1 = ""+rs.getString("PROPIEDAD3_ARMA1");
 							weap2 = ""+rs.getString("ARMA2");
 							descripcionWeap2 = ""+rs.getString("DESCRIPCION_ARMA2");
 							posesionWeap2 = ""+rs.getString("POSESION_ARMA2");
 							prop1Weap2 = ""+rs.getString("PROPIEDAD1_ARMA2");
 							prop2Weap2 = ""+rs.getString("PROPIEDAD2_ARMA2");
 							prop3Weap2 = ""+rs.getString("PROPIEDAD3_ARMA2");
 							weap3 = ""+rs.getString("ARMA3");
 							descripcionWeap3 = ""+rs.getString("DESCRIPCION_ARMA3");
 							posesionWeap3 = ""+rs.getString("POSESION_ARMA3");
 							prop1Weap3 = ""+rs.getString("PROPIEDAD1_ARMA3");
 							prop2Weap3 = ""+rs.getString("PROPIEDAD2_ARMA3");
 							prop3Weap3 = ""+rs.getString("PROPIEDAD3_ARMA3");
 							weap4 = ""+rs.getString("ARMA4");
 							descripcionWeap4 = ""+rs.getString("DESCRIPCION_ARMA4");
 							posesionWeap4 = ""+rs.getString("POSESION_ARMA4");
 							prop1Weap4 = ""+rs.getString("PROPIEDAD1_ARMA4");
 							prop2Weap4 = ""+rs.getString("PROPIEDAD2_ARMA4");
 							prop3Weap4 = ""+rs.getString("PROPIEDAD3_ARMA4");
 							obj1 = ""+rs.getString("OBJETO1");
 							descripcionObj1 = ""+rs.getString("DESCRIPCION_OBJETO1");
 							posesionObj1 = ""+rs.getString("POSESION_OBJETO1");
 							prop1Obj1 = ""+rs.getString("PROPIEDAD1_OBJETO1");
 							prop2Obj1 = ""+rs.getString("PROPIEDAD2_OBJETO1");
 							prop3Obj1 = ""+rs.getString("PROPIEDAD3_OBJETO1");
 							obj2 = ""+rs.getString("OBJETO2");
 							descripcionObj2 = ""+rs.getString("DESCRIPCION_OBJETO2");
 							posesionObj2 = ""+rs.getString("POSESION_OBJETO2");
 							prop1Obj2 = ""+rs.getString("PROPIEDAD1_OBJETO2");
 							prop2Obj2 = ""+rs.getString("PROPIEDAD2_OBJETO2");
 							prop3Obj2 = ""+rs.getString("PROPIEDAD3_OBJETO2");
 							obj3 = ""+rs.getString("OBJETO3");
 							descripcionObj3 = ""+rs.getString("DESCRIPCION_OBJETO3");
 							posesionObj3 = ""+rs.getString("POSESION_OBJETO3");
 							prop1Obj3 = ""+rs.getString("PROPIEDAD1_OBJETO3");
 							prop2Obj3 = ""+rs.getString("PROPIEDAD2_OBJETO3");
 							prop3Obj3 = ""+rs.getString("PROPIEDAD3_OBJETO3");
 							obj4 = ""+rs.getString("OBJETO4");
 							descripcionObj4 = ""+rs.getString("DESCRIPCION_OBJETO4");
 							posesionObj4 = ""+rs.getString("POSESION_OBJETO4");
 							prop1Obj4 = ""+rs.getString("PROPIEDAD1_OBJETO4");
 							prop2Obj4 = ""+rs.getString("PROPIEDAD2_OBJETO4");
 							prop3Obj4 = ""+rs.getString("PROPIEDAD3_OBJETO4");
 							acc1 = ""+rs.getString("ACCESORIO1");
 							descripcionAcc1 = ""+rs.getString("DESCRIPCION_ACCESORIO1");
 							posesionAcc1 = ""+rs.getString("POSESION_ACCESORIO1");
 							prop1Acc1 = ""+rs.getString("PROPIEDAD1_ACCESORIO1");
 							prop2Acc1 = ""+rs.getString("PROPIEDAD2_ACCESORIO1");
 							prop3Acc1 = ""+rs.getString("PROPIEDAD3_ACCESORIO1");
 							acc2 = ""+rs.getString("ACCESORIO2");
 							descripcionAcc2 = ""+rs.getString("DESCRIPCION_ACCESORIO2");
 							posesionAcc2 = ""+rs.getString("POSESION_ACCESORIO2");
 							prop1Acc2 = ""+rs.getString("PROPIEDAD1_ACCESORIO2");
 							prop2Acc2 = ""+rs.getString("PROPIEDAD2_ACCESORIO2");
 							prop3Acc2 = ""+rs.getString("PROPIEDAD3_ACCESORIO2");
 							acc3 = ""+rs.getString("ACCESORIO3");
 							descripcionAcc3 = ""+rs.getString("DESCRIPCION_ACCESORIO3");
 							posesionAcc3 = ""+rs.getString("POSESION_ACCESORIO3");
 							prop1Acc3 = ""+rs.getString("PROPIEDAD1_ACCESORIO3");
 							prop2Acc3 = ""+rs.getString("PROPIEDAD2_ACCESORIO3");
 							prop3Acc3 = ""+rs.getString("PROPIEDAD3_ACCESORIO3");
 							acc4 = ""+rs.getString("ACCESORIO4");
 							descripcionAcc4 = ""+rs.getString("DESCRIPCION_ACCESORIO4");
 							posesionAcc4 = ""+rs.getString("POSESION_ACCESORIO4");
 							prop1Acc4 = ""+rs.getString("PROPIEDAD1_ACCESORIO4");
 							prop2Acc4 = ""+rs.getString("PROPIEDAD2_ACCESORIO4");
 							prop3Acc4 = ""+rs.getString("PROPIEDAD3_ACCESORIO4");
 							tipoWeap1 = ""+rs.getString("TIPOARMA1");
 							tipoWeap2 = ""+rs.getString("TIPOARMA2");
 							tipoWeap3 = ""+rs.getString("TIPOARMA3");
 							tipoWeap4 = ""+rs.getString("TIPOARMA4");
 							tipoAcc1 = ""+rs.getString("TIPOACC1");
 							tipoAcc2 = ""+rs.getString("TIPOACC2");
 							tipoAcc3 = ""+rs.getString("TIPOACC3");
 							tipoAcc4 = ""+rs.getString("TIPOACC4");
 							arrojadizaWeap1 = ""+rs.getString("SUBCLASE_ARMA1");
 							arrojadizaWeap2 = ""+rs.getString("SUBCLASE_ARMA2");
 							arrojadizaWeap3 = ""+rs.getString("SUBCLASE_ARMA3");
 							arrojadizaWeap4 = ""+rs.getString("SUBCLASE_ARMA4");
 							salud = rs.getInt("SALUD");
 							mana = rs.getInt("MANA");
 							energia = rs.getInt("ENERGIA");
 							experiencia = rs.getInt("EXPERIENCIA");
 							sino = rs.getInt("SINO");
 							nivel = rs.getInt("NIVEL");
 							extras=""+rs.getString("EXTRAS");
 							dinero=rs.getInt("DINERO");
 							modificadores=""+rs.getString("MODIFICADORES");
 							poderes=""+rs.getString("PODERES");
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
						npcs.add(npc1.getName());
					}
					else{ if(button_11.getText().equals("")){
					
						button_11.setText(seleccion.toString());
						npc2=intermedio;
						npcs.add(npc2.getName());
					}
					else{
						if(button_12.getText().equals("")){
							
							button_12.setText(seleccion.toString());
							npc3=intermedio;
							npcs.add(npc3.getName());
						}
					
						else{if(button_13.getText().equals("")){
							
							button_13.setText(seleccion.toString());
							npc4=intermedio;
							npcs.add(npc4.getName());
						}
						else{if(button_14.getText().equals("")){
							
							button_14.setText(seleccion.toString());
							npc5=intermedio;
							npcs.add(npc5.getName());
						}
						else{if(button_15.getText().equals("")){
							
							button_15.setText(seleccion.toString());
							npc6=intermedio;
							npcs.add(npc6.getName());
						}
						else{if(button_16.getText().equals("")){
							
							button_16.setText(seleccion.toString());
							npc7=intermedio;
							npcs.add(npc7.getName());
						}
						
						else{if(button_17.getText().equals("")){
							
							button_17.setText(seleccion.toString());
							npc8=intermedio;
							npcs.add(npc8.getName());
						}
						else{if(button_18.getText().equals("")){
							
							button_18.setText(seleccion.toString());
							npc9=intermedio;
							npcs.add(npc9.getName());
						}
						
						else{}
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
