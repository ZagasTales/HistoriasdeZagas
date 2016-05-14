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
import es.thesinsprods.zagastales.juegozagas.jugar.CrearPartida;
import es.thesinsprods.zagastales.juegozagas.jugar.offline.JugarOnline;

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
	            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat" ;
	            String[] data;

	            try 
	            {
	                while ((message = reader.readLine()) != null) 
	                {
	                    textArea.append("Received: " + message + "\n");
	                    data = message.split(":");
	                    
	                    for (String token:data) 
	                    {
	                        textArea.append(token + "\n");
	                    }

	                    if (data[2].equals(connect)) 
	                    {
	                        tellEveryone((data[0] + ":" + data[1] + ":" + chat));
	                        userAdd(data[0]);
	                    } 
	                    else if (data[2].equals(disconnect)) 
	                    {
	                        tellEveryone((data[0] + ":has disconnected." + ":" + chat));
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
		
		final ConexionDBOnline con = new ConexionDBOnline();
		final Connection p = con.accederDB();
		final Statement tabla=p.createStatement();
		
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
			        tellEveryone("El servidor se está cerrando, todos los usuarios serán desconectados.\n:Chat");
			        textArea.append("Detiendo servidor... \n");
			        tabla.executeQuery("DELETE FROM PARTIDAS WHERE NOMBRE='"+CrearPartida.nombre+"'");
		            Thread.sleep(3000);   
		            frame.dispose();
		            JugarOnline.frmHistoriasDeZagas.dispose();
		            Inicio window= new Inicio ();
		            window.getFrmHistoriasDeZagas().setVisible(true);
		        } 
		        catch(InterruptedException ex) {Thread.currentThread().interrupt();} catch (SQLException e1) {
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
