package es.thesinsprods.zagastales.juegozagas.jugar.offline;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import es.thesinsprods.zagastales.juegozagas.inicio.Loader;
import es.thesinsprods.zagastales.juegozagas.jugar.BuscarPartida;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaJugadores {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField textField;
	JTextArea textArea = new JTextArea();
	 String username, address = BuscarPartida.ip;
	    ArrayList<String> users = new ArrayList();
	    int port = 2222;
	    Boolean isConnected = false;
	    
	    Socket sock;
	    BufferedReader reader;
	    PrintWriter writer;
	
	    
	    
	    
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
					VentanaJugadores window = new VentanaJugadores();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaJugadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Conectar();
		
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
		textField.setBounds(10, 560, 333, 29);
		frame.getContentPane().add(textField);
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
		btnNewButton.setBounds(353, 560, 71, 29);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 221, 414, 328);
		frame.getContentPane().add(scrollPane);
		
	
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
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

