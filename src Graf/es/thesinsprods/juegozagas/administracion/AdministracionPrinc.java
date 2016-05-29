package es.thesinsprods.juegozagas.administracion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import es.thesinsprods.resources.db.ConexionDBOnline;
import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.inicio.Inicio;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdministracionPrinc {

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */

	public static String usuario = "";
	MorpheusFont mf = new MorpheusFont();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministracionPrinc window = new AdministracionPrinc();
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
	public AdministracionPrinc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				AdministracionPrinc.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setBounds(100, 100, 450, 234);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		{
			final JButton btnGestionDeUsuarios = new JButton(
					"Gesti\u00F3n de Usuarios");
			btnGestionDeUsuarios.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {

					btnGestionDeUsuarios.setIcon(new ImageIcon(
							AdministracionPrinc.class
									.getResource("/images/botonesInicio2.png")));

				}

				public void mouseReleased(MouseEvent e) {

					btnGestionDeUsuarios.setIcon(new ImageIcon(
							AdministracionPrinc.class
									.getResource("/images/botonesInicio.png")));

				}
			});
			btnGestionDeUsuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						ConexionDBOnline bd = new ConexionDBOnline();
						Connection con;
						con = bd.accederDB();
						Statement tabla = con.createStatement();
						ArrayList<String> usuarios = new ArrayList<String>();
						usuarios.add("-Usuario-");
						ResultSet datos = tabla
								.executeQuery("SELECT * FROM USUARIOS");
						while (datos.next()) {
							usuarios.add(datos.getString("NOMBRE_DE_USUARIO"));

						}
						Object seleccion = JOptionPane.showInputDialog(
								btnGestionDeUsuarios, "Seleccione un usuario",
								"Selector de Usuarios",
								JOptionPane.PLAIN_MESSAGE, null, //
								usuarios.toArray(), "opcion 1");

						if(!seleccion.equals(null)){
						
							if (seleccion.equals("")
								|| seleccion.equals("-Usuario-")) {
						} else {
							usuario = (String) seleccion;
							frame.dispose();
							PerfilesUsuarios window = new PerfilesUsuarios();
							window.getFrmHistoriasDeZagas().setVisible(true);
						}}
					} catch (ClassNotFoundException e1) {

						e1.printStackTrace();
					} catch (InstantiationException e1) {

						e1.printStackTrace();
					} catch (IllegalAccessException e1) {

						e1.printStackTrace();
					} catch (SQLException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			btnGestionDeUsuarios.setIcon(new ImageIcon(
					AdministracionPrinc.class
							.getResource("/images/botonesInicio.png")));
			btnGestionDeUsuarios.setOpaque(false);
			btnGestionDeUsuarios
					.setHorizontalTextPosition(SwingConstants.CENTER);
			btnGestionDeUsuarios.setForeground(Color.WHITE);
			btnGestionDeUsuarios.setFont(mf.MyFont(0, 17));
			btnGestionDeUsuarios.setFocusPainted(false);
			btnGestionDeUsuarios.setContentAreaFilled(false);
			btnGestionDeUsuarios.setBorderPainted(false);
			btnGestionDeUsuarios.setBorder(new BevelBorder(BevelBorder.RAISED,
					null, null,

					null, null));
			btnGestionDeUsuarios.setBackground(new Color(139, 69, 19));
			btnGestionDeUsuarios.setBounds(10, 11, 414, 34);
			frame.getContentPane().add(btnGestionDeUsuarios);
		}
		{
			final JButton btnCrearCopiaDe = new JButton(
					"Crear Copia de Seguridad de la Base de Datos");
			btnCrearCopiaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					BackupDB window = new BackupDB();
					window.getFrame().setVisible(true);
					frame.dispose();

				}
			});
			btnCrearCopiaDe.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {

					btnCrearCopiaDe.setIcon(new ImageIcon(
							AdministracionPrinc.class
									.getResource("/images/botonesInicio2.png")));

				}

				public void mouseReleased(MouseEvent e) {

					btnCrearCopiaDe.setIcon(new ImageIcon(
							AdministracionPrinc.class
									.getResource("/images/botonesInicio.png")));

				}
			});
			btnCrearCopiaDe.setIcon(new ImageIcon(AdministracionPrinc.class
					.getResource("/images/botonesInicio.png")));
			btnCrearCopiaDe.setOpaque(false);
			btnCrearCopiaDe.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCrearCopiaDe.setForeground(Color.WHITE);
			btnCrearCopiaDe.setFont(mf.MyFont(0, 17));
			btnCrearCopiaDe.setFocusPainted(false);
			btnCrearCopiaDe.setContentAreaFilled(false);
			btnCrearCopiaDe.setBorderPainted(false);
			btnCrearCopiaDe.setBorder(new BevelBorder(BevelBorder.RAISED, null,
					null,

					null, null));
			btnCrearCopiaDe.setBackground(new Color(139, 69, 19));
			btnCrearCopiaDe.setBounds(10, 56, 414, 34);
			frame.getContentPane().add(btnCrearCopiaDe);
		}
		{
			final JButton btnRestaurarLaBase = new JButton(
					"Restaurar la Base de Datos");
			btnRestaurarLaBase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frame.dispose();
					RestoreDB window = new RestoreDB();
					window.getFrame().setVisible(true);
				}
			});
			btnRestaurarLaBase.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {

					btnRestaurarLaBase.setIcon(new ImageIcon(
							AdministracionPrinc.class
									.getResource("/images/botonesInicio2.png")));

				}

				public void mouseReleased(MouseEvent e) {

					btnRestaurarLaBase.setIcon(new ImageIcon(
							AdministracionPrinc.class
									.getResource("/images/botonesInicio.png")));

				}
			});
			btnRestaurarLaBase.setIcon(new ImageIcon(AdministracionPrinc.class
					.getResource("/images/botonesInicio.png")));
			btnRestaurarLaBase.setOpaque(false);
			btnRestaurarLaBase.setHorizontalTextPosition(SwingConstants.CENTER);
			btnRestaurarLaBase.setForeground(Color.WHITE);
			btnRestaurarLaBase.setFont(mf.MyFont(0, 17));
			btnRestaurarLaBase.setFocusPainted(false);
			btnRestaurarLaBase.setContentAreaFilled(false);
			btnRestaurarLaBase.setBorderPainted(false);
			btnRestaurarLaBase.setBorder(new BevelBorder(BevelBorder.RAISED,
					null, null,

					null, null));
			btnRestaurarLaBase.setBackground(new Color(139, 69, 19));
			btnRestaurarLaBase.setBounds(10, 101, 414, 34);
			frame.getContentPane().add(btnRestaurarLaBase);
		}

		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Inicio window = new Inicio();
				window.getFrmHistoriasDeZagas().setVisible(true);

			}
		});
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(AdministracionPrinc.class
						.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnVolver.setIcon(new ImageIcon(AdministracionPrinc.class
						.getResource("/images/botonesInicio.png")));

			}
		});
		btnVolver.setIcon(new ImageIcon(AdministracionPrinc.class
				.getResource("/images/botonesInicio.png")));
		btnVolver.setOpaque(false);
		btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(mf.MyFont(0, 17));
		btnVolver.setFocusPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

		null, null));
		btnVolver.setBackground(new Color(139, 69, 19));
		btnVolver.setBounds(10, 146, 414, 34);
		frame.getContentPane().add(btnVolver);
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(AdministracionPrinc.class
					.getResource("/images/background-inicio.jpg")));
			label.setBounds(0, 0, 444, 206);
			frame.getContentPane().add(label);
		}
	}
}
