package es.thesinsprods.zagastales.juegozagas.jugar.master;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.characters.equipment.Misc;

public class ObjetosNPC {

	private JFrame frame;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField txtObjeto;
	private JTextField txtDescripcin;
	MorpheusFont mf = new MorpheusFont();
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObjetosNPC window = new ObjetosNPC();
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
	public ObjetosNPC() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
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
		frame = new JFrame();
		frame.setTitle("Historias de Zagas");

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArmasNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setBounds(100, 100, 416, 257);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		final ConexionDBOnline con = new ConexionDBOnline();
		final Connection p = con.accederDB();
		final Statement tabla=p.createStatement();
		
		
		final JButton btnAadir = new JButton("A\u00F1adir");
		textField = new JTextField();
		if (textField.getText().equals("")) {
			btnAadir.setEnabled(false);

		}
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (textField.getText().equals("")) {
					btnAadir.setEnabled(false);
				} else {
					btnAadir.setEnabled(true);
				}
			}

		});
		textField.setBackground(Color.WHITE);
		textField.setBounds(10, 42, 183, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setFont(mf.MyFont(0, 11));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(210, 42, 183, 114);
		frame.getContentPane().add(scrollPane);

		final JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		textArea.setFont(mf.MyFont(0, 11));

		btnAadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAadir.setIcon(new ImageIcon(ObjetosNPC.class
						.getResource("/images/boton a\u00F1adir2.png")));

			}

			public void mouseReleased(MouseEvent e) {
				btnAadir.setIcon(new ImageIcon(ObjetosNPC.class
						.getResource("/images/boton a\u00F1adir.png")));

			}
		});
		btnAadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAadir.setIcon(new ImageIcon(ObjetosNPC.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnAadir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnAadir.setForeground(new Color(255, 255, 255));
		btnAadir.setBackground(new Color(139, 69, 19));
		btnAadir.setBorderPainted(false);
		btnAadir.setContentAreaFilled(false);
		btnAadir.setFocusPainted(false);
		btnAadir.setOpaque(false);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Misc objeto = new Misc(textField.getText(), textArea.getText(),
						false, false,ModificarEquipo.posss);
				if (ModificarEquipo.getTextField_4().getText().equals("")
						&& ModificarEquipo.pmisc >= 1) {
					ModificarEquipo.misc1 = objeto;
					try {
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET OBJETO1='"+ModificarEquipo.misc1.getMisc()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_OBJETO1='"+ModificarEquipo.misc1.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_OBJETO1='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_OBJETO1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_OBJETO1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_OBJETO1='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
					
						if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje1.getName())){
							
							JugarOnline.personaje1.setMisc1(ModificarEquipo.misc1);
							}
						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje2.getName())){
							
							JugarOnline.personaje2.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje3.getName())){
							
							JugarOnline.personaje3.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje4.getName())){
							
							JugarOnline.personaje4.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje5.getName())){
							
							JugarOnline.personaje5.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje6.getName())){
							
							JugarOnline.personaje6.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje7.getName())){
							
							JugarOnline.personaje7.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje8.getName())){
							
							JugarOnline.personaje8.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje9.getName())){
							
							JugarOnline.personaje9.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc1.getName())){
							
							JugarOnline.npc1.setMisc1(ModificarEquipo.misc1);
							}


						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc2.getName())){
							
							JugarOnline.npc2.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc3.getName())){
							
							JugarOnline.npc3.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc4.getName())){
							
							JugarOnline.npc4.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc5.getName())){
							
							JugarOnline.npc5.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc6.getName())){
							
							JugarOnline.npc6.setMisc1(ModificarEquipo.misc1);
							}


						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc7.getName())){
							
							JugarOnline.npc7.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc8.getName())){
							
							JugarOnline.npc8.setMisc1(ModificarEquipo.misc1);
							}

						else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc9.getName())){
							
							JugarOnline.npc9.setMisc1(ModificarEquipo.misc1);
							}
		
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ModificarEquipo.getTextField_4().setText(
							"" + ModificarEquipo.misc1.getMisc());
				} else {
					if (ModificarEquipo.getTextField_5().getText().equals("")
							&& ModificarEquipo.pmisc >= 2) {
						ModificarEquipo.misc2 = objeto;
						try {
							tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET OBJETO2='"+ModificarEquipo.misc2.getMisc()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
							tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_OBJETO2='"+ModificarEquipo.misc2.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
							tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_OBJETO2='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
							tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_OBJETO2='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
							tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_OBJETO2='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
							tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_OBJETO2='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
						
							if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje1.getName())){
								
								JugarOnline.personaje1.setMisc2(ModificarEquipo.misc2);
								}
							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje2.getName())){
								
								JugarOnline.personaje2.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje3.getName())){
								
								JugarOnline.personaje3.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje4.getName())){
								
								JugarOnline.personaje4.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje5.getName())){
								
								JugarOnline.personaje5.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje6.getName())){
								
								JugarOnline.personaje6.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje7.getName())){
								
								JugarOnline.personaje7.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje8.getName())){
								
								JugarOnline.personaje8.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje9.getName())){
								
								JugarOnline.personaje9.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc1.getName())){
								
								JugarOnline.npc1.setMisc2(ModificarEquipo.misc2);
								}


							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc2.getName())){
								
								JugarOnline.npc2.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc3.getName())){
								
								JugarOnline.npc3.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc4.getName())){
								
								JugarOnline.npc4.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc5.getName())){
								
								JugarOnline.npc5.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc6.getName())){
								
								JugarOnline.npc6.setMisc2(ModificarEquipo.misc2);
								}


							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc7.getName())){
								
								JugarOnline.npc7.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc8.getName())){
								
								JugarOnline.npc8.setMisc2(ModificarEquipo.misc2);
								}

							else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc9.getName())){
								
								JugarOnline.npc9.setMisc2(ModificarEquipo.misc2);
								}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ModificarEquipo.getTextField_5().setText(
								"" + ModificarEquipo.misc2.getMisc());
					} else {
						if (ModificarEquipo.getTextField_6().getText().equals("")
								&& ModificarEquipo.pmisc >= 3) {
							ModificarEquipo.misc3 = objeto;
							try {
								tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET OBJETO3='"+ModificarEquipo.misc3.getMisc()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
								tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_OBJETO3='"+ModificarEquipo.misc3.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
								tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_OBJETO3='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
								tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_OBJETO3='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
								tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_OBJETO3='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
								tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_OBJETO3='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
							
								if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje1.getName())){
									
									JugarOnline.personaje1.setMisc3(ModificarEquipo.misc3);
									}
								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje2.getName())){
									
									JugarOnline.personaje2.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje3.getName())){
									
									JugarOnline.personaje3.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje4.getName())){
									
									JugarOnline.personaje4.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje5.getName())){
									
									JugarOnline.personaje5.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje6.getName())){
									
									JugarOnline.personaje6.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje7.getName())){
									
									JugarOnline.personaje7.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje8.getName())){
									
									JugarOnline.personaje8.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje9.getName())){
									
									JugarOnline.personaje9.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc1.getName())){
									
									JugarOnline.npc1.setMisc3(ModificarEquipo.misc3);
									}


								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc2.getName())){
									
									JugarOnline.npc2.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc3.getName())){
									
									JugarOnline.npc3.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc4.getName())){
									
									JugarOnline.npc4.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc5.getName())){
									
									JugarOnline.npc5.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc6.getName())){
									
									JugarOnline.npc6.setMisc3(ModificarEquipo.misc3);
									}


								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc7.getName())){
									
									JugarOnline.npc7.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc8.getName())){
									
									JugarOnline.npc8.setMisc3(ModificarEquipo.misc3);
									}

								else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc9.getName())){
									
									JugarOnline.npc9.setMisc3(ModificarEquipo.misc3);
									}
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ModificarEquipo.getTextField_6().setText(
									"" + ModificarEquipo.misc3.getMisc());
						} else {
							if (ModificarEquipo.getTextField_7().getText().equals("")
									&& ModificarEquipo.pmisc >= 4) {
								ModificarEquipo.misc4 = objeto;
								try {
									tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET OBJETO4='"+ModificarEquipo.misc4.getMisc()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
									tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET DESCRIPCION_OBJETO4='"+ModificarEquipo.misc4.getDescription()+"' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
									tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET POSESION_OBJETO4='Normal' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
									tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD1_OBJETO4='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
									tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD2_OBJETO4='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
									tabla.executeQuery("UPDATE "+ModificarEquipo.tipopj+" SET PROPIEDAD3_OBJETO4='' WHERE NOMBRE='"+ModificarEquipo.personaje.getName()+"'");
								
									if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje1.getName())){
										
										JugarOnline.personaje1.setMisc4(ModificarEquipo.misc4);
										}
									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje2.getName())){
										
										JugarOnline.personaje2.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje3.getName())){
										
										JugarOnline.personaje3.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje4.getName())){
										
										JugarOnline.personaje4.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje5.getName())){
										
										JugarOnline.personaje5.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje6.getName())){
										
										JugarOnline.personaje6.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje7.getName())){
										
										JugarOnline.personaje7.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje8.getName())){
										
										JugarOnline.personaje8.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.personaje9.getName())){
										
										JugarOnline.personaje9.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc1.getName())){
										
										JugarOnline.npc1.setMisc4(ModificarEquipo.misc4);
										}


									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc2.getName())){
										
										JugarOnline.npc2.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc3.getName())){
										
										JugarOnline.npc3.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc4.getName())){
										
										JugarOnline.npc4.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc5.getName())){
										
										JugarOnline.npc5.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc6.getName())){
										
										JugarOnline.npc6.setMisc4(ModificarEquipo.misc4);
										}


									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc7.getName())){
										
										JugarOnline.npc7.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc8.getName())){
										
										JugarOnline.npc8.setMisc4(ModificarEquipo.misc4);
										}

									else if(ModificarEquipo.personaje.getName().equals(JugarOnline.npc9.getName())){
										
										JugarOnline.npc9.setMisc4(ModificarEquipo.misc4);
										}
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								ModificarEquipo.getTextField_7().setText(
										"" + ModificarEquipo.misc4.getMisc());
							} else {
								JOptionPane.showMessageDialog(frame.getContentPane(),
										"No puedes llevar más objetos.", "",
										JOptionPane.ERROR_MESSAGE);

							}
						}
					}

				}
				frame.dispose();
			}
		});
		btnAadir.setFont(mf.MyFont(0, 13));
		btnAadir.setBounds(233, 167, 124, 38);
		frame.getContentPane().add(btnAadir);

		final JButton btnVolver = new JButton("");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(ObjetosNPC.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(ObjetosNPC.class
						.getResource("/images/boton atras.png")));

			}
		});
		btnVolver.setIcon(new ImageIcon(ObjetosNPC.class
				.getResource("/images/boton atras.png")));
		btnVolver.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(139, 69, 19));
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVolver.setFont(mf.MyFont(0, 13));
		btnVolver.setBounds(10, 167, 99, 44);
		frame.getContentPane().add(btnVolver);

		txtObjeto = new JTextField();
		txtObjeto.setOpaque(false);
		txtObjeto.setForeground(Color.WHITE);
		txtObjeto.setBackground(new Color(205, 133, 63));
		txtObjeto.setText("Objeto:");
		txtObjeto.setFont(mf.MyFont(0, 13));
		txtObjeto.setEditable(false);
		txtObjeto.setColumns(10);
		txtObjeto.setBorder(null);
		txtObjeto.setBounds(10, 11, 90, 20);
		frame.getContentPane().add(txtObjeto);

		txtDescripcin = new JTextField();
		txtDescripcin.setOpaque(false);
		txtDescripcin.setForeground(Color.WHITE);
		txtDescripcin.setBackground(new Color(205, 133, 63));
		txtDescripcin.setText("Descripci\u00F3n:");
		txtDescripcin.setFont(mf.MyFont(0, 13));
		txtDescripcin.setEditable(false);
		txtDescripcin.setColumns(10);
		txtDescripcin.setBorder(null);
		txtDescripcin.setBounds(210, 11, 90, 20);
		frame.getContentPane().add(txtDescripcin);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ObjetosNPC.class
				.getResource("/images/background-objetos.jpg")));
		label.setBounds(0, 0, 410, 229);
		frame.getContentPane().add(label);
	}

}
