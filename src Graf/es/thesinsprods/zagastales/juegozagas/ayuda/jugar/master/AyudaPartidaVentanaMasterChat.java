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
import es.thesinsprods.zagastales.juegozagas.ayuda.jugar.jugador.AyudaPartidaVentanaJugador;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaCreacionPNJ;
import java.awt.Font;

public class AyudaPartidaVentanaMasterChat {

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
					AyudaPartidaVentanaMasterChat window = new AyudaPartidaVentanaMasterChat();
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
	public AyudaPartidaVentanaMasterChat() {
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
		frame.setBounds(100, 100, 439, 242);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblAspectosGeneralesDel = new JLabel(
				"Ventana de chat");
		lblAspectosGeneralesDel.setForeground(Color.WHITE);
		lblAspectosGeneralesDel.setFont(mf.MyFont(1, 17));
		lblAspectosGeneralesDel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAspectosGeneralesDel.setBounds(10, 13, 414, 63);
		contentPanel.add(lblAspectosGeneralesDel);

		JTextArea txtrLoPrimeroQue = new JTextArea();
		txtrLoPrimeroQue.setForeground(Color.WHITE);
		txtrLoPrimeroQue.setEditable(false);
		txtrLoPrimeroQue
				.setText("La ventana de chat es la que se utiliza para comunicarse con el resto de jugadores. En ella se mostrar\u00E1n todos los mensajes de los participantes de la partida adem\u00E1s de los del sistema.");
		txtrLoPrimeroQue.setLineWrap(true);
		txtrLoPrimeroQue.setOpaque(false);
		txtrLoPrimeroQue.setWrapStyleWord(true);
		txtrLoPrimeroQue.setFont(mf.MyFont(0, 12));
		txtrLoPrimeroQue.setBounds(10, 74, 414, 72);
		contentPanel.add(txtrLoPrimeroQue);

		final JButton btnNewButton = new JButton("\u00CDndice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaPartidaVentanaMasterChat.class
						.getResource("/images/boton a�adir2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaPartidaVentanaMasterChat.class
						.getResource("/images/boton a�adir.png")));

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
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(mf.MyFont(0, 13));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(AyudaPartidaVentanaMasterChat.class
				.getResource("/images/boton a\u00F1adir.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(153, 159, 120, 34);
		contentPanel.add(btnNewButton);

		final JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(AyudaPartidaVentanaMasterChat.class
						.getResource("/images/boton continuar2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				button_1.setIcon(new ImageIcon(AyudaPartidaVentanaMasterChat.class
						.getResource("/images/boton continuar.png")));

			}
		});
		button_1.setFocusPainted(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPartidaVentanaMasterPartida window = new AyudaPartidaVentanaMasterPartida();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		button_1.setIcon(new ImageIcon(AyudaPartidaVentanaMasterChat.class.getResource("/images/boton continuar.png")));
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.WHITE);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBounds(311, 157, 99, 38);
		contentPanel.add(button_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AyudaPartidaVentanaMasterChat.class
				.getResource("/images/background-inicio.jpg")));
		label.setBounds(0, 0, 434, 207);
		contentPanel.add(label);
	}

}
