package es.thesinsprods.zagastales.juegozagas.jugar.jugador;

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

public class VentanaJugadores {
	public static Characters personaje=null;
	MorpheusFont mf = new MorpheusFont();
	final ConexionDBOnline con = new ConexionDBOnline();
	final Connection p = con.accederDB();
	final Statement tabla=p.createStatement();
	private JFrame frmHistoriasDeZagas;
	JProgressBar progressBar = new JProgressBar();
	JProgressBar progressBar_2 = new JProgressBar();
	JProgressBar progressBar_1 = new JProgressBar();
	public JFrame getFrame() {
		return frmHistoriasDeZagas;
	}

	public void setFrame(JFrame frame) {
		this.frmHistoriasDeZagas = frame;
	}

	private JTextField textField;
	JTextArea textArea = new JTextArea();
	 String username, address = BuscarPartida.ip;
	    ArrayList<String> users = new ArrayList();
	    int port = 2222;
	    public static boolean isConnected = false;
	    
	    Socket sock;
	    BufferedReader reader;
	    PrintWriter writer;
	    private JTextField textField_1;
	
	    
	    
	    
	    public class IncomingReader implements Runnable
	    {
	        @Override
	        public void run() 
	        {
	            String[] data;
	            String stream, darHab="darHab",darExp="darExp" ,darAtr="darAtr",modificarEq = "ModificarEq",modificarSEM="ModificarSEM" ,alterarE= "Alterar",done = "Done", connect = "Connect", disconnect = "Desconectado", chat = "Chat", cerrar= "Cerrar" ,kick="Kick";

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
	                     
	                     else if(data[2].equals(kick)){
	                    	 System.out.println("Entra");
	                    	 if(data[1].equals(personaje.getName())){
	                    		 
	                             textArea.append("Desconectado.\n");
	                             sock.close();
	                             JOptionPane
	             				.showMessageDialog(
	             						frmHistoriasDeZagas,
	             						"El master te ha echado. ",
	             						"", JOptionPane.PLAIN_MESSAGE);
	                             frmHistoriasDeZagas.dispose();
	                             Inicio window = new Inicio();
	                             window.getFrmHistoriasDeZagas().setVisible(true);
	                    		 
	                    	 }
	                    	 
	                     }
	                     
	                     else if (data[2].equals(connect))
	                     {
	                        textArea.removeAll();
	                        userAdd(data[0]);
	                     } 
	                     else if (data[2].equals(alterarE))
	                     {
	                        if(data[0].equals(VentanaJugadores.personaje.getName())){
	                        	VentanaJugadores.personaje.setEstado(data[1]);
	           
	                        }
	                     } 
	                     else if (data[2].equals(darExp))
	                     {
	                        if(data[0].equals(personaje.getName())){
	                        	int cantidad=personaje.getExperience()+Integer.parseInt(data[1]);
								tabla.executeQuery("UPDATE PERSONAJE SET EXPERIENCIA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
     							personaje.setExperience(cantidad);
     							textField_1.setText(cantidad+"");
	                        }
	                     } 
	                     else if (data[2].equals(darAtr))
	                     {
	                        if(data[0].equals(personaje.getName())){
	                        	if(data[3].equals("Fuerza")){
	                        		int cantidad=personaje.getAtributes().getStrength()+Integer.parseInt(data[1]);
								tabla.executeQuery("UPDATE PERSONAJE SET FUERZA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
     							personaje.getAtributes().setStrength(cantidad);
								}
	                        	else if(data[3].equals("Carisma")){	  
	                        		int cantidad=personaje.getAtributes().getCharisma()+Integer.parseInt(data[1]);
								tabla.executeQuery("UPDATE PERSONAJE SET CARISMA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
     							personaje.getAtributes().setCharisma(cantidad);
	                        	}
	                        	else if(data[3].equals("Resistencia")){	        
	                        		int cantidad=personaje.getAtributes().getResistance()+Integer.parseInt(data[1]);
								tabla.executeQuery("UPDATE PERSONAJE SET RESISTENCIA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
     							personaje.getAtributes().setResistance(cantidad);
	                        	}
	                        	else if(data[3].equals("Percepción")){	   
	                        		int cantidad=personaje.getAtributes().getPerception()+Integer.parseInt(data[1]);
								tabla.executeQuery("UPDATE PERSONAJE SET PERCEPCION="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
								personaje.getAtributes().setPerception(cantidad);
	                        	}
	                        	else if(data[3].equals("Inteligencia")){	
	                        		int cantidad=personaje.getAtributes().getIntelligence()+Integer.parseInt(data[1]);
								tabla.executeQuery("UPDATE PERSONAJE SET INTELIGENCIA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
								personaje.getAtributes().setIntelligence(cantidad);
	                        	}
	                        	else if(data[3].equals("Destreza")){	
	                        		int cantidad=personaje.getAtributes().getDexterity()+Integer.parseInt(data[1]);
								tabla.executeQuery("UPDATE PERSONAJE SET DESTREZA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
								personaje.getAtributes().setDexterity(cantidad);
								}
	                        	else if(data[3].equals("Resistencia Mágica")){	
	                        		int cantidad=personaje.getAtributes().getMagicres()+Integer.parseInt(data[1]);
								tabla.executeQuery("UPDATE PERSONAJE SET RESISTENCIA_MAGICA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
								personaje.getAtributes().setMagicres(cantidad);
	                        	}
	                        }
	                     }
	                     else if (data[2].equals(darHab))
	                     {
	                    	 if(data[0].equals(personaje.getName())){
		                        	if(data[3].equals("Combate")){
		                        		if(data[4].equals("Armas de Una Mano")){int cantidad=personaje.getCombatSkills().getOneHanded()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET ARMAS_DE_UNA_MANO="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getCombatSkills().setOneHanded(cantidad);
		                        		}
		                        		else if(data[4].equals("Armas de Dos Manos")){int cantidad=personaje.getCombatSkills().getTwoHanded()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET ARMAS_DE_DOS_MANOS="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getCombatSkills().setTwoHanded(cantidad);
										}
		                        		else if(data[4].equals("Armas de Asta")){int cantidad=personaje.getCombatSkills().getPole()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET ARMAS_DE_ASTA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getCombatSkills().setPole(cantidad);
										}
		                        		else if(data[4].equals("Armas a Distancia")){int cantidad=personaje.getCombatSkills().getRanged()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET ARMAS_A_DISTANCIA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getCombatSkills().setRanged(cantidad);
										}
		                        		else if(data[4].equals("Bloquear")){int cantidad=personaje.getCombatSkills().getBlock()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET BLOQUEAR="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getCombatSkills().setBlock(cantidad);
										}
		                        		else if(data[4].equals("Esquivar")){int cantidad=personaje.getCombatSkills().getDodge()+Integer.parseInt(data[1]);
		    							tabla.executeQuery("UPDATE PERSONAJE SET ESQUIVAR="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
		    							personaje.getCombatSkills().setDodge(cantidad);
		                        		}
									}
		                        	else if(data[3].equals("Conocimientos")){
		                        		if(data[4].equals("Arte de la Guerra")){int cantidad=personaje.getKnowledgeSkills().getArtofWar()+Integer.parseInt(data[1]);
		    							tabla.executeQuery("UPDATE PERSONAJE SET ARTE_DE_LA_GUERRA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
		    							personaje.getKnowledgeSkills().setArtofWar(cantidad);
		                        		}
		                        		else if(data[4].equals("Diplomacia")){int cantidad=personaje.getKnowledgeSkills().getDiplomacy()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET DIPLOMACIA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowledgeSkills().setDiplomacy(cantidad);
		                        		}
		                        		else if(data[4].equals("Etiqueta")){int cantidad=personaje.getKnowledgeSkills().getEtiquette()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET ETIQUETA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowledgeSkills().setEtiquette(cantidad);
		                        		}
		                        		else if(data[4].equals("Medicina")){int cantidad=personaje.getKnowledgeSkills().getMedicine()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET MEDICINA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowledgeSkills().setMedicine(cantidad);
		                        		}
		                        		else if(data[4].equals("Ocultismo")){int cantidad=personaje.getKnowledgeSkills().getOccultism()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET OCULTISMO="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowledgeSkills().setOccultism(cantidad);
										}
		                        		else if(data[4].equals("Investigación")){int cantidad=personaje.getKnowledgeSkills().getResearch()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET INVESTIGACION="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowledgeSkills().setResearch(cantidad);
										}
		                        		else if(data[4].equals("Negociación")){int cantidad=personaje.getKnowledgeSkills().getNegotiation()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET NEGOCIACION="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowledgeSkills().setNegotiation(cantidad);
										}
		                        		else if(data[4].equals("Conocimientos Secretos")){int cantidad=personaje.getKnowledgeSkills().getSecretKnowledge()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET CONOCIMIENTOS_SECRETOS="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowledgeSkills().setSecretKnowledge(cantidad);
										}
		                        	}
		                        	else if(data[3].equals("Magia")){
		                        		if(data[4].equals("Fuego")){int cantidad=personaje.getMagicSkills().getFire()+Integer.parseInt(data[1]);
		    							tabla.executeQuery("UPDATE PERSONAJE SET FUEGO="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
		    							personaje.getMagicSkills().setFire(cantidad);
		                        		}
		                        		else if(data[4].equals("Agua")){int cantidad=personaje.getMagicSkills().getWater()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET AGUA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getMagicSkills().setWater(cantidad);
		                        		}
		                        		else if(data[4].equals("Tierra")){int cantidad=personaje.getMagicSkills().getEarth()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET TIERRA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getMagicSkills().setEarth(cantidad);
		                        		}
		                        		else if(data[4].equals("Viento")){int cantidad=personaje.getMagicSkills().getWind()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET VIENTO="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getMagicSkills().setWind(cantidad);
		                        		}
		                        		else if(data[4].equals("Druídica")){int cantidad=personaje.getMagicSkills().getDruidic()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET DRUIDICA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getMagicSkills().setDruidic(cantidad);
										}
		                        		else if(data[4].equals("Blanca")){int cantidad=personaje.getMagicSkills().getWhite()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET BLANCA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getMagicSkills().setWhite(cantidad);
										}
		                        		else if(data[4].equals("Negra")){int cantidad=personaje.getMagicSkills().getBlack()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET NEGRA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getMagicSkills().setBlack(cantidad);
										}
		                        		else if(data[4].equals("Arcana")){int cantidad=personaje.getMagicSkills().getArcane()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET ARCANA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getMagicSkills().setArcane(cantidad);
										}
		                        	}
		                        	else if(data[3].equals("Destrezas")){
		                        		if(data[4].equals("Atletismo")){int cantidad=personaje.getKnowhowSkills().getAthletics()+Integer.parseInt(data[1]);
		    							tabla.executeQuery("UPDATE PERSONAJE SET ATLETISMO="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
		    							personaje.getKnowhowSkills().setAthletics(cantidad);
		                        		}
		                        		else if(data[4].equals("Supervivencia")){int cantidad=personaje.getKnowhowSkills().getSurvival()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET SUPERVIVENCIA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowhowSkills().setSurvival(cantidad);
		                        		}
		                        		else if(data[4].equals("Equitación")){int cantidad=personaje.getKnowhowSkills().getEquitation()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET EQUITACION="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowhowSkills().setEquitation(cantidad);
		                        		}
		                        		else if(data[4].equals("Trampas")){int cantidad=personaje.getKnowhowSkills().getTraps()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET TRAMPAS="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowhowSkills().setTraps(cantidad);
		                        		}
		                        		else if(data[4].equals("Sigilo")){int cantidad=personaje.getKnowhowSkills().getStealth()+Integer.parseInt(data[1]);
										tabla.executeQuery("UPDATE PERSONAJE SET SIGILO="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
										personaje.getKnowhowSkills().setStealth(cantidad);
										}
		                        	}
		                        	
		                        }
	                     }
	                     else if (data[2].equals(modificarSEM))
	                     {
	                        if(data[0].equals(VentanaJugadores.personaje.getName())){
	                        	
	                        	if(data[3].equals("Salud Máxima")){
	                        		int cantidad=progressBar.getMaximum()+Integer.parseInt(data[1]);
    								tabla.executeQuery("UPDATE PERSONAJE SET SALUD="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
    								progressBar.setMaximum(cantidad);
    								progressBar.setString(progressBar.getValue()+"/"+progressBar.getMaximum());
	                        	}
	                        	else if(data[3].equals("Energía Máxima")){int cantidad=progressBar_2.getMaximum()+Integer.parseInt(data[1]);
	                        										tabla.executeQuery("UPDATE PERSONAJE SET ENERGIA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
	                        										progressBar_2.setMaximum(cantidad);
	                        										progressBar_2.setString(progressBar_2.getValue()+"/"+progressBar_2.getMaximum());}
	                        	else if(data[3].equals("Maná Máximo")){int cantidad=progressBar_1.getMaximum()+Integer.parseInt(data[1]);
	                        									tabla.executeQuery("UPDATE PERSONAJE SET MANA="+cantidad+" WHERE NOMBRE='"+data[0]+"'");
	                        									progressBar_1.setMaximum(cantidad);
	                        									progressBar_1.setString(progressBar_1.getValue()+"/"+progressBar_1.getMaximum());}
	                        	else if(data[3].equals("Salud")){int cantidad=personaje.getLife()+Integer.parseInt(data[1]);
	                        	personaje.setLife(cantidad);
	                        	progressBar.setValue(cantidad);
	                        	progressBar.setString(progressBar.getValue()+"/"+progressBar.getMaximum());}
	                        	else if(data[3].equals("Energía")){int cantidad=personaje.getEndurance()+Integer.parseInt(data[1]);
	                        	personaje.setEndurance(cantidad);
	                        	progressBar_2.setValue(cantidad);
	                        	progressBar_2.setString(progressBar_2.getValue()+"/"+progressBar_2.getMaximum());
	                        	}
	                        	else if(data[3].equals("Maná")){int cantidad=personaje.getMana()+Integer.parseInt(data[1]);
	                        	personaje.setMana(cantidad);
	                        	progressBar_1.setValue(cantidad);
	                        	progressBar_1.setString(progressBar_1.getValue()+"/"+progressBar_1.getMaximum());
	                        	}
	                        }
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
	                     else if (data[2].equals(cerrar)){
	                    	 JOptionPane
								.showMessageDialog(
										frmHistoriasDeZagas,
										"El master ha finalizado la partida.",
										"", JOptionPane.PLAIN_MESSAGE);
	                    	 

	         				
	         				try {
	         					int jugadores=0;
	         				ResultSet rs =	tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+BuscarPartida.nombrePart+"'");
	         				
	         				while (rs.next()){
	         					
	         					jugadores=rs.getInt("JUGADORES");
	         					
	         				}
	         				tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+(jugadores-1)+"");
	         				sendDisconnect();
	         				Disconnect();
	         				frmHistoriasDeZagas.dispose();
	         				Inicio window = new Inicio();
	         				window.getFrmHistoriasDeZagas().setVisible(true);
	         					
	         				} catch (SQLException e1) {
	         					// TODO Auto-generated catch block
	         					e1.printStackTrace();
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
			
					VentanaJugadores window = new VentanaJugadores();
					
					
					window.frmHistoriasDeZagas.setVisible(true);
					
				
					
				
				
				}
					
				catch (Exception e) {
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
	public VentanaJugadores() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
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
		frmHistoriasDeZagas.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaJugadores.class.getResource("/images/Historias de Zagas, logo.png")));
		frmHistoriasDeZagas.setResizable(false);
		frmHistoriasDeZagas.setBounds(100, 100, 590, 683);
		frmHistoriasDeZagas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHistoriasDeZagas.getContentPane().setLayout(null);
		Conectar();

		if(isConnected==true){
		
		try {
			tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+BuscarPartida.jdentro+1+" WHERE NOMBRE='"+BuscarPartida.nombrePart+"' AND USUARIO='"+BuscarPartida.master+"'");
			ResultSet rs = tabla.executeQuery("SELECT * FROM PERSONAJE WHERE NOMBRE_DE_USUARIO='"+Loader.usuario+"'");
			
			ArrayList <Object> personajes=new ArrayList<Object>();
			while (rs.next()){
				
				personajes.add(""+rs.getString("NOMBRE"));
				
			}
			
			Object[] personaje=personajes.toArray();
			Object seleccion = JOptionPane.showInputDialog(
					frmHistoriasDeZagas, "Seleccione opcion",
					"Cargar Personaje", JOptionPane.PLAIN_MESSAGE,
					null,personaje,null);
			
			rs=tabla.executeQuery("SELECT * FROM PERSONAJE WHERE NOMBRE='"+seleccion+"'");
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
						VentanaJugadores.personaje=intermedio;
						Cargar(VentanaJugadores.personaje.getName());
		}
		catch (SQLException e1) {
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
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					

					

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
		textField.setBounds(10, 610, 402, 29);
		frmHistoriasDeZagas.getContentPane().add(textField);
		textField.setColumns(10);
		
		final JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones chat2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones chat.png")));
				
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones chat.png")));
		btnNewButton.setFont(new Font("Morpheus", Font.PLAIN, 11));
		btnNewButton.setForeground(Color.WHITE);
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
		btnNewButton.setBounds(422, 610, 71, 29);
		frmHistoriasDeZagas.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 564, 270);
		frmHistoriasDeZagas.getContentPane().add(scrollPane);
		textArea.setEditable(false);
		
	
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		final JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCerrar.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones chat2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnCerrar.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones chat.png")));
				
			}
		});
		btnCerrar.setFocusPainted(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrar.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones chat.png")));
		btnCerrar.setFont(new Font("Morpheus", Font.PLAIN, 11));
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int jugadores=0;
				ResultSet rs =	tabla.executeQuery("SELECT * FROM PARTIDAS WHERE NOMBRE='"+BuscarPartida.nombrePart+"'");
				
				while (rs.next()){
					
					jugadores=rs.getInt("JUGADORES");
					
				}
				tabla.executeQuery("UPDATE PARTIDAS SET JUGADORES="+(jugadores-1)+"");
				writer.println("Hola:"+personaje.getName()+":LimpiaLista");
				writer.flush();
				sendDisconnect();
				Disconnect();
				frmHistoriasDeZagas.dispose();
				Inicio window = new Inicio();
				window.getFrmHistoriasDeZagas().setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCerrar.setBounds(503, 610, 71, 29);
		frmHistoriasDeZagas.getContentPane().add(btnCerrar);
		
		JLabel label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText(personaje.getName());
		label.setForeground(Color.WHITE);
		label.setFont(mf.MyFont(0, 32));
		label.setBounds(25, 11, 549, 53);
		frmHistoriasDeZagas.getContentPane().add(label);
		
		JLabel label_1 = new JLabel((String) null);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setText(personaje.getRace().getRace());
		label_1.setForeground(Color.WHITE);
		label_1.setFont(mf.MyFont(0, 20));
		label_1.setBounds(25, 75, 256, 26);
		frmHistoriasDeZagas.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Nivel: "+personaje.getNivel());
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
		
		JLabel label_6 = new JLabel("Edad: "+personaje.getAge());
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
		textField_1.setText(""+personaje.getExperience());
		textField_1.setColumns(10);
		textField_1.setBounds(102, 220, 60, 20);
		frmHistoriasDeZagas.getContentPane().add(textField_1);
		
		

		progressBar.setForeground(Color.RED);
		progressBar.setMaximum(personaje.getLife());
		progressBar.setValue(personaje.getLife());
		progressBar.setString(progressBar.getValue()+"/"+progressBar.getMaximum());
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(85, 120, 200, 14);
		frmHistoriasDeZagas.getContentPane().add(progressBar);
	
		progressBar_2.setValue(personaje.getEndurance());
		progressBar_2.setStringPainted(true);
		progressBar_2.setMaximum(personaje.getEndurance());
		progressBar_2.setString(progressBar_2.getValue()+"/"+progressBar_2.getMaximum());
		progressBar_2.setForeground(new Color(0, 128, 0));
		progressBar_2.setBackground(Color.WHITE);
		progressBar_2.setBounds(85, 145, 200, 14);
		frmHistoriasDeZagas.getContentPane().add(progressBar_2);
		

		progressBar_1.setValue(personaje.getMana());
		progressBar_1.setStringPainted(true);
		progressBar_1.setMaximum(personaje.getMana());
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
				button.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button.setFont(mf.MyFont(0,11));
		button.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
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
				button_1.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_1.setFont(mf.MyFont(0,11));
		button_1.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
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
				button_2.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_2.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_2.setFont(mf.MyFont(0,11));
		button_2.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
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
				button_3.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_3.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_3.setFont(mf.MyFont(0,11));
		button_3.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
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
				button_4.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_4.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_4.setFont(mf.MyFont(0,11));
		button_4.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
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
				button_5.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_5.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_5.setFont(mf.MyFont(0,11));
		button_5.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
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
						"El estado del personaje es: "+VentanaJugadores.personaje.getEstado(),
						"", JOptionPane.PLAIN_MESSAGE);
			}
		});
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_6.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_6.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_6.setFont(mf.MyFont(0,11));
		button_6.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
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
				button_7.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				button_7.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
			}
		});
		button_7.setFont(mf.MyFont(0,11));
		button_7.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/boton fichas pj1.png")));
		button_7.setFocusPainted(false);
		button_7.setContentAreaFilled(false);
		button_7.setBorderPainted(false);
		button_7.setHorizontalTextPosition(SwingConstants.CENTER);
		button_7.setForeground(Color.WHITE);
		button_7.setBounds(451, 220, 123, 23);
		frmHistoriasDeZagas.getContentPane().add(button_7);
		
		final JButton btnInformacin = new JButton("Informaci\u00F3n");
		btnInformacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] personaje={"Habilidades y sus Atributos","Armería","Conocimientos Mágicos","Tiradas Enfrentadas"};
				Object seleccion = JOptionPane.showInputDialog(
						frmHistoriasDeZagas, "Seleccione opcion",
						"Cargar Personaje", JOptionPane.PLAIN_MESSAGE,
						null,personaje,null);
				seleccion=seleccion+"";
				if(seleccion.equals("Habilidades y sus Atributos")){
					

					
					File habilidades= new File("./htmls/Habilidades y Atributos.html");
					try {
						Desktop.getDesktop().open(habilidades);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				}
				if(seleccion.equals("Armería")){
					File armeria= new File("./htmls/Armeria.html");
					try {
						Desktop.getDesktop().open(armeria);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(seleccion.equals("Conocimientos Mágicos")){
					File habilidades= new File("./htmls/Conocimientosmagicos.html");
					try {
						Desktop.getDesktop().open(habilidades);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}
				if(seleccion.equals("Tiradas Enfrentadas")){
					File habilidades= new File("./htmls/Tiradas Enfrentada.html");
					try {
						Desktop.getDesktop().open(habilidades);
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					
				}
			}
		});
		btnInformacin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnInformacin.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones info-ayuda2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnInformacin.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones info-ayuda.png")));
				
			}
		});
		btnInformacin.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones info-ayuda.png")));
		btnInformacin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInformacin.setForeground(Color.WHITE);
		btnInformacin.setFont(mf.MyFont(0, 26));
		btnInformacin.setFocusPainted(false);
		btnInformacin.setContentAreaFilled(false);
		btnInformacin.setBorderPainted(false);
		btnInformacin.setBounds(10, 251, 271, 67);
		frmHistoriasDeZagas.getContentPane().add(btnInformacin);
		
		final JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				btnAyuda.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones info-ayuda2.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnAyuda.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones info-ayuda.png")));
				
			}
			
		});
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAyuda.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/botones info-ayuda.png")));
		btnAyuda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setFont(mf.MyFont(0, 26));
		btnAyuda.setFocusPainted(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBounds(303, 254, 271, 67);
		frmHistoriasDeZagas.getContentPane().add(btnAyuda);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaJugadores.class.getResource("/images/background-ventanajugadores.jpg")));
		lblNewLabel.setBounds(0, 0, 584, 708);
		frmHistoriasDeZagas.getContentPane().add(lblNewLabel);
		}
		else{
			System.out.println("Llega");
			isConnected = false;
			
			
		}
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
    
    public void Conectar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException{
    	
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
            	int seleccion = JOptionPane.showOptionDialog(
						frmHistoriasDeZagas,
						"No se ha podido establecer la conexón con la partida",
						"Error al realizar una conexión",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null,
						new Object[] { "Aceptar" }, "opcion 1");
         
            		isConnected= false;
            }
            
            ListenThread();
            
        } else if (isConnected == true) 
        {
            textArea.append("Ya estas conectado. \n");
        }
    
    }
    
    public void Cargar(String nombre){
        String cargar = (username+ ":"+ nombre+ ":Cargar");
        try{
          writer.println(cargar);
          writer.flush();
        } catch (Exception e){
        }
        }
}

