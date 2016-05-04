package es.thesinsprods.zagastales.juegozagas.ayuda;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.thesinsprods.resources.font.MorpheusFont;
import es.thesinsprods.zagastales.juegozagas.ayuda.npcs.AyudaCreacionNPC;
import es.thesinsprods.zagastales.juegozagas.ayuda.pnjs.AyudaCreacionPNJ;
import java.awt.Font;

public class AyudaPrincipal {

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
					AyudaPrincipal window = new AyudaPrincipal();
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
	public AyudaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				AyudaCreacionPNJ.class
						.getResource("/images/Historias de Zagas, logo.png")));

		frame.setResizable(false);
		frame.setBounds(100, 100, 438, 273);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		JLabel lblAspectosGeneralesDel = new JLabel("AYUDA");
		lblAspectosGeneralesDel.setForeground(Color.WHITE);
		lblAspectosGeneralesDel.setFont(mf.MyFont(1, 17));
		lblAspectosGeneralesDel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAspectosGeneralesDel.setBounds(10, 0, 414, 63);
		contentPanel.add(lblAspectosGeneralesDel);

		final JButton btnNewButton_1 = new JButton("JUGAR");
		btnNewButton_1.setFont(mf.MyFont(0, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton_1.setIcon(new ImageIcon(AyudaPrincipal.class
						.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton_1.setIcon(new ImageIcon(AyudaPrincipal.class
						.getResource("/images/botonesInicio.png")));

			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AyudaPrincipal.class
				.getResource("/images/botonesInicio.png")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBounds(10, 65, 414, 34);
		contentPanel.add(btnNewButton_1);

		final JButton btnSeleccinDeBendicin = new JButton(
				"CREACI\u00D3N DE NPC'S");
		btnSeleccinDeBendicin.setFont(mf.MyFont(0, 13));
		btnSeleccinDeBendicin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaCreacionNPC window = new AyudaCreacionNPC();
				window.getFrame().setVisible (true);
				frame.dispose();

			}
		});
		btnSeleccinDeBendicin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnSeleccinDeBendicin.setIcon(new ImageIcon(
						AyudaPrincipal.class
								.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnSeleccinDeBendicin.setIcon(new ImageIcon(
						AyudaPrincipal.class
								.getResource("/images/botonesInicio.png")));

			}
		});
		
		JButton btnGestorDeJuego = new JButton("GESTOR DE JUEGO");
		btnGestorDeJuego.setIcon(new ImageIcon(AyudaPrincipal.class.getResource("/images/botonesInicio.png")));
		btnGestorDeJuego.setOpaque(false);
		btnGestorDeJuego.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGestorDeJuego.setForeground(Color.WHITE);
		btnGestorDeJuego.setFont(new Font("Morpheus", Font.PLAIN, 13));
		btnGestorDeJuego.setFocusPainted(false);
		btnGestorDeJuego.setContentAreaFilled(false);
		btnGestorDeJuego.setBorder(null);
		btnGestorDeJuego.setBounds(10, 109, 414, 34);
		contentPanel.add(btnGestorDeJuego);
		btnSeleccinDeBendicin.setIcon(new ImageIcon(AyudaPrincipal.class
				.getResource("/images/botonesInicio.png")));
		btnSeleccinDeBendicin.setForeground(Color.WHITE);
		btnSeleccinDeBendicin.setBorder(null);
		btnSeleccinDeBendicin.setContentAreaFilled(false);
		btnSeleccinDeBendicin.setFocusPainted(false);
		btnSeleccinDeBendicin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSeleccinDeBendicin.setOpaque(false);
		btnSeleccinDeBendicin.setBounds(10, 154, 414, 34);
		contentPanel.add(btnSeleccinDeBendicin);

		final JButton btnSeleccinDePrivilegios = new JButton(
				"CREACI\u00D3N DE PERSONAJES");
		btnSeleccinDePrivilegios.setFont(mf.MyFont(0, 13));
		btnSeleccinDePrivilegios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaCreacionPNJ window = new AyudaCreacionPNJ();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnSeleccinDePrivilegios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnSeleccinDePrivilegios.setIcon(new ImageIcon(
						AyudaPrincipal.class
								.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnSeleccinDePrivilegios.setIcon(new ImageIcon(
						AyudaPrincipal.class
								.getResource("/images/botonesInicio.png")));

			}
		});
		btnSeleccinDePrivilegios.setIcon(new ImageIcon(AyudaPrincipal.class
				.getResource("/images/botonesInicio.png")));
		btnSeleccinDePrivilegios.setForeground(Color.WHITE);
		btnSeleccinDePrivilegios.setBorder(null);
		btnSeleccinDePrivilegios.setContentAreaFilled(false);
		btnSeleccinDePrivilegios.setFocusPainted(false);
		btnSeleccinDePrivilegios
				.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSeleccinDePrivilegios.setOpaque(false);
		btnSeleccinDePrivilegios.setBounds(10, 199, 414, 34);
		contentPanel.add(btnSeleccinDePrivilegios);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AyudaPrincipal.class
				.getResource("/images/background-creadornpcs.jpg")));
		label.setBounds(0, 0, 434, 248);
		contentPanel.add(label);
	}

}
