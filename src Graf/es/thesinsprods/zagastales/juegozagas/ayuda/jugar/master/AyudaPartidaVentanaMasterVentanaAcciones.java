package es.thesinsprods.zagastales.juegozagas.ayuda.jugar.master;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.ayuda.jugar.AyudaPartidaJugar;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaCreacionPNJ;
import java.awt.Font;

public class AyudaPartidaVentanaMasterVentanaAcciones {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private final JPanel contentPanel = new JPanel();
	MorpheusFont mf = new MorpheusFont();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AyudaPartidaVentanaMasterVentanaAcciones window = new AyudaPartidaVentanaMasterVentanaAcciones();
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
	public AyudaPartidaVentanaMasterVentanaAcciones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				AyudaCreacionPNJ.class
						.getResource("/images/Historias de Zagas, logo.png")));

		frame.setResizable(false);
		frame.setBounds(100, 100, 439, 381);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblAspectosGeneralesDel = new JLabel(
				"Ventana de acciones");
		lblAspectosGeneralesDel.setForeground(Color.WHITE);
		lblAspectosGeneralesDel.setFont(mf.MyFont(1, 17));
		lblAspectosGeneralesDel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAspectosGeneralesDel.setBounds(10, 13, 414, 63);
		contentPanel.add(lblAspectosGeneralesDel);

		JTextArea txtrLoPrimeroQue = new JTextArea();
		txtrLoPrimeroQue.setForeground(Color.WHITE);
		txtrLoPrimeroQue.setEditable(false);
		txtrLoPrimeroQue
				.setText("Esta secci\u00F3n de la ventana de partidas es en la que se gestionan todas las acciones que el administrador puede realizar sobre los personajes de la partida y sobre los NPCs. Se agrupan en tres conjuntos:\r\n");
		txtrLoPrimeroQue.setLineWrap(true);
		txtrLoPrimeroQue.setOpaque(false);
		txtrLoPrimeroQue.setWrapStyleWord(true);
		txtrLoPrimeroQue.setFont(mf.MyFont(0, 12));
		txtrLoPrimeroQue.setBounds(20, 74, 414, 72);
		contentPanel.add(txtrLoPrimeroQue);

		final JButton btnNewButton = new JButton("\u00CDndice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaPartidaVentanaMasterVentanaAcciones.class
						.getResource("/images/boton añadir2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaPartidaVentanaMasterVentanaAcciones.class
						.getResource("/images/boton añadir.png")));

			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPartidaVentanaMaster window = new AyudaPartidaVentanaMaster();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		
		final JButton btnChat = new JButton("Tiradas");
		btnChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			btnChat.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio2.png")));

		}

		public void mouseReleased(MouseEvent arg0) {
			btnChat.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio.png")));

		}
	});
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AyudaPartidaVentanaMasterVentanaAccionesTiradas window = new AyudaPartidaVentanaMasterVentanaAccionesTiradas();
				window.getFrame().setVisible(true);
				frame.dispose();
			
			
			}
		});
		btnChat.setIcon(new ImageIcon(AyudaPartidaVentanaMasterVentanaAcciones.class.getResource("/images/botonSelecionDiosesInicio.png")));
		btnChat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnChat.setForeground(Color.WHITE);
		btnChat.setFont(mf.MyFont(0, 13));
		btnChat.setFocusPainted(false);
		btnChat.setContentAreaFilled(false);
		btnChat.setBorderPainted(false);
		btnChat.setBorder(null);
		btnChat.setBounds(72, 146, 325, 37);
		contentPanel.add(btnChat);
		
		final JButton btnPartida = new JButton("Recompensas");
		btnPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			btnPartida.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio2.png")));

		}

		public void mouseReleased(MouseEvent arg0) {
			btnPartida.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio.png")));

		}
	});
		btnPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AyudaPartidaVentanaMasterVentanaAccionesRecompensas window = new AyudaPartidaVentanaMasterVentanaAccionesRecompensas();
				window.getFrame().setVisible(true);
				frame.dispose();
			
			
			}
		});
		btnPartida.setIcon(new ImageIcon(AyudaPartidaVentanaMasterVentanaAcciones.class.getResource("/images/botonSelecionDiosesInicio.png")));
		btnPartida.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPartida.setForeground(Color.WHITE);
		btnPartida.setFont(mf.MyFont(0, 13));
		btnPartida.setFocusPainted(false);
		btnPartida.setContentAreaFilled(false);
		btnPartida.setBorderPainted(false);
		btnPartida.setBorder(null);
		btnPartida.setBounds(72, 242, 325, 37);
		contentPanel.add(btnPartida);
		
		final JButton btnAcciones = new JButton("Estatus");
		btnAcciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			btnAcciones.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio2.png")));

		}

		public void mouseReleased(MouseEvent arg0) {
			btnAcciones.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio.png")));

		}
	});
		btnAcciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AyudaPartidaVentanaMasterVentanaAccionesEstatus window = new AyudaPartidaVentanaMasterVentanaAccionesEstatus();
				window.getFrame().setVisible(true);
				frame.dispose();
			
			
			}
		});
		btnAcciones.setIcon(new ImageIcon(AyudaPartidaVentanaMasterVentanaAcciones.class.getResource("/images/botonSelecionDiosesInicio.png")));
		btnAcciones.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAcciones.setForeground(Color.WHITE);
		btnAcciones.setFont(mf.MyFont(0, 13));
		btnAcciones.setFocusPainted(false);
		btnAcciones.setContentAreaFilled(false);
		btnAcciones.setBorderPainted(false);
		btnAcciones.setBorder(null);
		btnAcciones.setBounds(72, 194, 325, 37);
		contentPanel.add(btnAcciones);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(mf.MyFont(0, 13));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(AyudaPartidaVentanaMasterVentanaAcciones.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(168, 296, 120, 34);
		contentPanel.add(btnNewButton);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AyudaPartidaVentanaMasterVentanaAcciones.class
				.getResource("/images/background-inicio.jpg")));
		label.setBounds(0, 0, 434, 346);
		contentPanel.add(label);
	}

}
