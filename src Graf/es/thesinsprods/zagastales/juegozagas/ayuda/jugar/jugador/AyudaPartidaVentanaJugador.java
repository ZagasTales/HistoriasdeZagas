package es.thesinsprods.zagastales.juegozagas.ayuda.jugar.jugador;

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
import es.thesinsprods.zagastales.juegozagas.ayuda.AyudaPrincipal;
import es.thesinsprods.zagastales.juegozagas.ayuda.jugar.AyudaPartidaJugar;
import es.thesinsprods.zagastales.juegozagas.ayuda.jugar.AyudaPartidaJugarCrearPartida;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaCreacionPNJ;
import java.awt.Font;

public class AyudaPartidaVentanaJugador {

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
					AyudaPartidaVentanaJugador window = new AyudaPartidaVentanaJugador();
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
	public AyudaPartidaVentanaJugador() {
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
		frame.setBounds(100, 100, 439, 300);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblAspectosGeneralesDel = new JLabel(
				"Ventana de Jugadores");
		lblAspectosGeneralesDel.setForeground(Color.WHITE);
		lblAspectosGeneralesDel.setFont(mf.MyFont(1, 17));
		lblAspectosGeneralesDel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAspectosGeneralesDel.setBounds(10, 13, 414, 63);
		contentPanel.add(lblAspectosGeneralesDel);

		final JButton btnNewButton = new JButton("\u00CDndice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaPartidaVentanaJugador.class
						.getResource("/images/boton añadir2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaPartidaVentanaJugador.class
						.getResource("/images/boton añadir.png")));

			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPartidaJugar window = new AyudaPartidaJugar();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(mf.MyFont(0, 13));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(AyudaPartidaVentanaJugador.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(157, 218, 120, 34);
		contentPanel.add(btnNewButton);
		
		final JButton btnStats = new JButton("Stats");
		btnStats.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			btnStats.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio2.png")));

		}

		public void mouseReleased(MouseEvent arg0) {
			btnStats.setIcon(new ImageIcon(AyudaPartidaJugar.class
					.getResource("/images/botonSelecionDiosesInicio.png")));

		}
	});
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPartidaVentanaJugadorStats window = new AyudaPartidaVentanaJugadorStats();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnStats.setIcon(new ImageIcon(AyudaPartidaVentanaJugador.class.getResource("/images/botonSelecionDiosesInicio.png")));
		btnStats.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStats.setForeground(Color.WHITE);
		btnStats.setFont(mf.MyFont(0, 13));
		btnStats.setFocusPainted(false);
		btnStats.setContentAreaFilled(false);
		btnStats.setBorderPainted(false);
		btnStats.setBorder(null);
		btnStats.setBounds(56, 87, 325, 37);
		contentPanel.add(btnStats);
		
		final JButton btnChat = new JButton("Chat");
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
				AyudaPartidaVentanaJugadorChat window = new AyudaPartidaVentanaJugadorChat();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnChat.setIcon(new ImageIcon(AyudaPartidaVentanaJugador.class.getResource("/images/botonSelecionDiosesInicio.png")));
		btnChat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnChat.setForeground(Color.WHITE);
		btnChat.setFont(mf.MyFont(0, 13));
		btnChat.setFocusPainted(false);
		btnChat.setContentAreaFilled(false);
		btnChat.setBorderPainted(false);
		btnChat.setBorder(null);
		btnChat.setBounds(56, 147, 325, 37);
		contentPanel.add(btnChat);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AyudaPartidaVentanaJugador.class
				.getResource("/images/background-inicio.jpg")));
		label.setBounds(0, 0, 434, 265);
		contentPanel.add(label);
	}

}
