package es.thesinsprods.zagastales.jugar.online.server;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;
import es.thesinsprods.zagastales.juegozagas.inicio.Loader;
import es.thesinsprods.zagastales.juegozagas.jugar.CrearPartida;
import es.thesinsprods.zagastales.juegozagas.jugar.master.JugarOnline;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SystemServer {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	final ConexionDBOnline con = new ConexionDBOnline();
	final Connection p = con.accederDB();
	final Statement tabla=p.createStatement();
	ArrayList clientOutputStreams;
	   ArrayList<String> users;
		JTextArea textArea = new JTextArea();
	   
	   public class ClientHandler implements Runnable	
	   {
	       BufferedReader reader;
	       Socket sock;
	       PrintWriter client;

	       public ClientHandler(Socket clientSocket, PrintWriter user) 
	       {
	            client = user;
	            try 
	            {
	                sock = clientSocket;
	                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
	                reader = new BufferedReader(isReader);
	            }
	            catch (Exception ex) 
	            {
	                textArea.append("Unexpected error... \n");
	            }

	       }

	       @Override
	       public void run() 
	       {
	            String message,darHab="darHab",darExp="darExp" ,darAtr="darAtr",modificarSEM="ModificarSEM" ,alterarE= "Alterar",cerrar="Cerrar", cargar="Cargar", connect = "Connect", disconnect = "Desconectado", chat = "Chat" , limpiar="LimpiaLista" , kick="Kick",
	            		quitarArm="QuitarArm",darArm="DarArm",quitarWeap1="QuitarWeap1",darWeap1="DarWeap1", quitarObj1="QuitarObj1", darObj1="DarObj1"
        				,quitarWeap2="QuitarWeap2",darWeap2="DarWeap2", quitarObj2="QuitarObj2", darObj2="DarObj2"
        						,quitarWeap3="QuitarWeap3",darWeap3="DarWeap3", quitarObj3="QuitarObj3", darObj3="DarObj3"
        								,quitarWeap4="QuitarWeap4",darWeap4="DarWeap4", quitarObj4="QuitarObj4", darObj4="DarObj4";
	            String[] data;

	            try 
	            {
	                while ((message = reader.readLine()) != null) 
	                {
	                    textArea.append("Recibido: " + message + "\n");
	                    data = message.split(":");
	                    
	                    for (String token:data) 
	                    {
	                        textArea.append(token + "\n");
	                    }
	                    if(data[2].equals(cargar)){
	                    	tellEveryone((data[0] + ":" + data[1] + ":" + cargar));
	                    	
	                    }
	                    else if(data[2].equals(darArm)){
	                    	
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + darArm+":"+data[3]+":"+data[4]));
	                    }
	                    
	                    
	                    else if(data[2].equals(darObj1)){
	                    	
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + darObj1+":"+data[3]+":"+data[4]));
	                    }

	                    
	                    else if(data[2].equals(darObj2)){
	                    	
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + darObj2+":"+data[3]+":"+data[4]));
	                    }

	                    
	                    else if(data[2].equals(darObj3)){
	                    	
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + darObj3+":"+data[3]+":"+data[4]));
	                    }


	                    
	                    else if(data[2].equals(darObj4)){
	                    	
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + darObj4+":"+data[3]+":"+data[4]));
	                    }
	                    
	                    else if(data[2].equals(darWeap1)){
	                    	
	                    	tellEveryone((data[0]+":"+data[1]+":"+ darWeap1 + ":" + data[3]+":"+ data[4] +":"+ data[5]+":"+data[6]));
	                    }
	                    
	                    else if(data[2].equals(darWeap2)){
	                    	
	                    	tellEveryone((data[0]+":"+data[1]+":"+ darWeap2 + ":" + data[3]+":"+ data[4] +":"+ data[5]+":"+data[6]));
	                    }
	                    
	                    else if(data[2].equals(darWeap3)){
	                    	
	                    	tellEveryone((data[0]+":"+data[1]+":"+ darWeap3 + ":" + data[3]+":"+ data[4] +":"+ data[5]+":"+data[6]));
	                    }
	                    
	                    else if(data[2].equals(darWeap4)){
	                    	
	                    	tellEveryone((data[0]+":"+data[1]+":"+ darWeap4 + ":" + data[3]+":"+ data[4] +":"+ data[5]+":"+data[6]));
	                    }
	                    
	                    else if(data[2].equals(quitarWeap1)){
	                    	
	                    	tellEveryone((data[0]+ ":"+ data[1] +":"+ quitarWeap1));
	                    }
	                    
	                    else if(data[2].equals(quitarWeap2)){
	                    	
	                    	tellEveryone((data[0]+ ":"+ data[1] +":"+ quitarWeap2));
	                    }
	                    
	                    else if(data[2].equals(quitarWeap3)){
	
	                    	tellEveryone((data[0]+ ":"+ data[1] +":"+ quitarWeap3));
	                    }
	                    
	                    else if(data[2].equals(quitarWeap4)){
	                    	
	                    	tellEveryone((data[0]+ ":"+ data[1] +":"+ quitarWeap4));
	                    }
	                    
	                    else if(data[2].equals(quitarObj1)){
	                    	
	                    	tellEveryone((data[0]+ ":"+ data[1] +":"+ quitarObj1));
	                    }
	                    
	                    else if(data[2].equals(quitarObj2)){
	                    	
	                    	tellEveryone((data[0]+ ":"+ data[1] +":"+ quitarObj2));
	                    }
	                    
	                    else if(data[2].equals(quitarObj3)){
	
	                    	tellEveryone((data[0]+ ":"+ data[1] +":"+ quitarObj3));
	                    }
	                    
	                    else if(data[2].equals(quitarObj4)){
	                    	
	                    	tellEveryone((data[0]+ ":"+ data[1] +":"+ quitarObj4));
	                    }
	                    
	                    else if(data[2].equals(quitarArm)){
	                    	
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + quitarArm));
	                    }

	                    else if(data[2].equals(quitarObj1)){
	                    	
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + quitarObj1));
	                    }
	                    

	                    else if(data[2].equals(quitarObj2)){
	                    	
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + quitarObj2));
	                    }

	                    else if(data[2].equals(quitarObj3)){
	                    	
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + quitarObj3));
	                    }

	                    else if(data[2].equals(quitarObj4)){
	                    	
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + quitarObj4));
	                    }
	                    
	                    
	                    
	                    else if(data[2].equals(alterarE)){
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + alterarE));
	                    	
	                    }
	                    else if(data[2].equals(darExp)){
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + darExp));
	                    	
	                    }
	                    else if(data[2].equals(darHab)){
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + darHab + ":"+ data[3] + ":" + data[4]));
	                    	
	                    }
	                    else if(data[2].equals(darAtr)){
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + darAtr + ":"+ data[3]));
	                    	
	                    }
	                    else if(data[2].equals(kick)){
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + kick));}
	                    
	                    else if(data[2].equals(modificarSEM)){
	                    	tellEveryone((data[0] + ":" + data[1]+ ":" + modificarSEM + ":" + data[3]));
	                    }
	                    else if(data[2].equals(limpiar)){
	                    	
	                    	tellEveryone ((data[0]+":"+data[1]+":"+limpiar));
	                    }
	                    
	                    else if (data[2].equals(cerrar)){
	                    		System.out.println("Cerrando");
         						tellEveryone("Server:ssdfsdjfsd:Cerrar");
	         			        tellEveryone("Server:El servidor se está cerrando, todos los usuarios serán desconectados.:Chat");
	         			        textArea.append("Detiendo servidor... \n");
	         			        tabla.executeQuery("DELETE FROM PARTIDAS WHERE USUARIO='"+Loader.usuario+"'");
	         		            frame.dispose();
	         		            JugarOnline.frmHistoriasDeZagas.dispose();
	     
	                    }
	                    else if (data[2].equals(connect)) 
	                    {
	                        tellEveryone((data[0] + ":" + data[1] + ":" + chat));
	                        userAdd(data[0]);
	                    } 
	                    else if (data[2].equals(disconnect)) 
	                    {
	                        tellEveryone((data[0] + ": Se ha desconectado." + ":" + chat));
	                        userRemove(data[0]);
	                    } 
	                    else if (data[2].equals(chat)) 
	                    {
	                        tellEveryone(message);
	                    } 
	                    else 
	                    {
	                        textArea.append("No Conditions were met. \n");
	                    }
	                } 
	             } 
	             catch (Exception ex) 
	             {
	                textArea.append("Lost a connection. \n");
	                ex.printStackTrace();
	                clientOutputStreams.remove(client);
	             } 
		} 
	    }
	   
	   public class ServerStart implements Runnable 
	    {
	        @Override
	        public void run() 
	        {
	            clientOutputStreams = new ArrayList();
	            users = new ArrayList();  

	            try 
	            {
	                ServerSocket serverSock = new ServerSocket(2222);

	                while (true) 
	                {
					Socket clientSock = serverSock.accept();
					PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
					clientOutputStreams.add(writer);

					Thread listener = new Thread(new ClientHandler(clientSock, writer));
					listener.start();
					textArea.append("Got a connection. \n");
	                }
	            }
	            catch (Exception ex)
	            {
	                textArea.append("Error making a connection. \n");
	            }
	        }
	    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemServer window = new SystemServer();
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
	public SystemServer() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, SQLException {
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		Arrancar();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 205);
		frame.getContentPane().add(scrollPane);
		

		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Usuarios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 textArea.append("\n Usuarios Conectados : \n");
			        for (String current_user : users)
			        {
			            textArea.append(current_user);
			            textArea.append("\n");
			        }    
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		        try 
		        {
					tellEveryone("Server:ssdfsdjfsd:Cerrar");
			        tellEveryone("Server:El servidor se está cerrando, todos los usuarios serán desconectados.:Chat");
			        textArea.append("Detiendo servidor... \n");
			        tabla.executeQuery("DELETE FROM PARTIDAS WHERE USUARIO='"+Loader.usuario+"'");
		            frame.dispose();
		            JugarOnline.frmHistoriasDeZagas.dispose();
		     
		        } 
		        catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
	
		        
		
		    
				
			}
		});
		btnCerrar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnCerrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnLimpiar.setBounds(169, 227, 89, 23);
		frame.getContentPane().add(btnLimpiar);

		
	}
	
	  public void userAdd (String data) 
	    {
	        String message, add = ": :Connect", done = "Server: :Done", name = data;
	        users.add(name);
	        String[] tempList = new String[(users.size())];
	        users.toArray(tempList);

	        for (String token:tempList) 
	        {
	            message = (token + add);
	            tellEveryone(message);
	        }
	        tellEveryone(done);
	    }
	    
	    public void userRemove (String data) 
	    {
	        String message, add = ": :Connect", done = "Server: :Done", name = data;
	        users.remove(name);
	        String[] tempList = new String[(users.size())];
	        users.toArray(tempList);

	        for (String token:tempList) 
	        {
	            message = (token + add);
	            tellEveryone(message);
	        }
	        tellEveryone(done);
	    }
	    
	    public void tellEveryone(String message) 
	    {
		Iterator it = clientOutputStreams.iterator();

	        while (it.hasNext()) 
	        {
	            try 
	            {
	                PrintWriter writer = (PrintWriter) it.next();
			writer.println(message);
			textArea.append("Enviando: " + message + "\n");
	                writer.flush();
	                textArea.setCaretPosition(textArea.getDocument().getLength());

	            } 
	            catch (Exception ex) 
	            {
			textArea.append("Error enviando mensaje. \n");
	            }
	        } 
	    }
	    
	    public void Arrancar (){
	    	
	    	 Thread starter = new Thread(new ServerStart());
	         starter.start();
	         
	         textArea.append("Servidor arrancado con éxito\n");
	    	
	    }
}
