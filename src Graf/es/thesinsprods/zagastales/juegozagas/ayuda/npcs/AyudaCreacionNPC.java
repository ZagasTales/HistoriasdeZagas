package es.thesinsprods.zagastales.juegozagas.ayuda.npcs;

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
import es.thesinsprods.zagastales.juegozagas.ayuda.AyudaPrincipal;
import java.awt.Font;

public class AyudaCreacionNPC {

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
					AyudaCreacionNPC window = new AyudaCreacionNPC();
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
	public AyudaCreacionNPC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Historias de Zagas");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				AyudaCreacionNPC.class
						.getResource("/images/Historias de Zagas, logo.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 438, 437);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblAspectosGeneralesDel = new JLabel(
				"Creaci\u00F3n de NPC's");
		lblAspectosGeneralesDel.setForeground(Color.WHITE);
		lblAspectosGeneralesDel.setFont(mf.MyFont(1, 17));
		lblAspectosGeneralesDel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAspectosGeneralesDel.setBounds(10, -9, 414, 63);
		contentPanel.add(lblAspectosGeneralesDel);

		final JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaBendicionNPC.class
						.getResource("/images/boton atras2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(AyudaBendicionNPC.class
						.getResource("/images/boton atras.png")));

			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPrincipal window = new AyudaPrincipal();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(mf.MyFont(0, 13));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(AyudaCreacionNPC.class
				.getResource("/images/boton atras.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(10, 359, 99, 38);
		contentPanel.add(btnNewButton);

		final JButton btnNewButton_1 = new JButton("Aspectos Generales");
		btnNewButton_1.setFont(mf.MyFont(0, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaStartNPC window = new AyudaStartNPC();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnNewButton_1.setIcon(new ImageIcon(AyudaCreacionNPC.class
						.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnNewButton_1.setIcon(new ImageIcon(AyudaCreacionNPC.class
						.getResource("/images/botonesInicio.png")));

			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AyudaCreacionNPC.class
				.getResource("/images/botonesInicio.png")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBounds(10, 44, 414, 34);
		contentPanel.add(btnNewButton_1);

		final JButton btnSeleccinDeBendicin = new JButton(
				"Selecci\u00F3n de Bendici\u00F3n");
		btnSeleccinDeBendicin.setFont(mf.MyFont(0, 13));
		btnSeleccinDeBendicin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaBendicionNPC window = new AyudaBendicionNPC();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnSeleccinDeBendicin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnSeleccinDeBendicin.setIcon(new ImageIcon(
						AyudaCreacionNPC.class
								.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnSeleccinDeBendicin.setIcon(new ImageIcon(
						AyudaCreacionNPC.class
								.getResource("/images/botonesInicio.png")));

			}
		});
		btnSeleccinDeBendicin.setIcon(new ImageIcon(AyudaCreacionNPC.class
				.getResource("/images/botonesInicio.png")));
		btnSeleccinDeBendicin.setForeground(Color.WHITE);
		btnSeleccinDeBendicin.setBorder(null);
		btnSeleccinDeBendicin.setContentAreaFilled(false);
		btnSeleccinDeBendicin.setFocusPainted(false);
		btnSeleccinDeBendicin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSeleccinDeBendicin.setOpaque(false);
		btnSeleccinDeBendicin.setBounds(10, 89, 414, 34);
		contentPanel.add(btnSeleccinDeBendicin);

		final JButton btnSeleccinDePrivilegios = new JButton(
				"Selecci\u00F3n de Privilegios y Reveses");
		btnSeleccinDePrivilegios.setFont(mf.MyFont(0, 13));
		btnSeleccinDePrivilegios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaPrivilegiosNPC window = new AyudaPrivilegiosNPC();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnSeleccinDePrivilegios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnSeleccinDePrivilegios.setIcon(new ImageIcon(
						AyudaCreacionNPC.class
								.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnSeleccinDePrivilegios.setIcon(new ImageIcon(
						AyudaCreacionNPC.class
								.getResource("/images/botonesInicio.png")));

			}
		});
		btnSeleccinDePrivilegios.setIcon(new ImageIcon(AyudaCreacionNPC.class
				.getResource("/images/botonesInicio.png")));
		btnSeleccinDePrivilegios.setForeground(Color.WHITE);
		btnSeleccinDePrivilegios.setBorder(null);
		btnSeleccinDePrivilegios.setContentAreaFilled(false);
		btnSeleccinDePrivilegios.setFocusPainted(false);
		btnSeleccinDePrivilegios
				.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSeleccinDePrivilegios.setOpaque(false);
		btnSeleccinDePrivilegios.setBounds(10, 134, 414, 34);
		contentPanel.add(btnSeleccinDePrivilegios);

		final JButton btnAsignacinDeAtributos = new JButton(
				"Asignaci\u00F3n de Atributos");
		btnAsignacinDeAtributos.setFont(mf.MyFont(0, 13));
		btnAsignacinDeAtributos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAsignacinDeAtributos.setIcon(new ImageIcon(
						AyudaCreacionNPC.class
								.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAsignacinDeAtributos.setIcon(new ImageIcon(
						AyudaCreacionNPC.class
								.getResource("/images/botonesInicio.png")));

			}
		});
		btnAsignacinDeAtributos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaAtributosNPC window = new AyudaAtributosNPC();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnAsignacinDeAtributos.setIcon(new ImageIcon(AyudaCreacionNPC.class
				.getResource("/images/botonesInicio.png")));
		btnAsignacinDeAtributos.setForeground(Color.WHITE);
		btnAsignacinDeAtributos.setBorder(null);
		btnAsignacinDeAtributos.setContentAreaFilled(false);
		btnAsignacinDeAtributos.setFocusPainted(false);
		btnAsignacinDeAtributos
				.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAsignacinDeAtributos.setOpaque(false);
		btnAsignacinDeAtributos.setBounds(10, 179, 414, 34);
		contentPanel.add(btnAsignacinDeAtributos);

		final JButton btnAsignacinDeHabilidades = new JButton(
				"Asignaci\u00F3n de Habilidades");
		btnAsignacinDeHabilidades.setFont(mf.MyFont(0, 13));
		btnAsignacinDeHabilidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaHabilidadesNPC window = new AyudaHabilidadesNPC();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnAsignacinDeHabilidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAsignacinDeHabilidades.setIcon(new ImageIcon(
						AyudaCreacionNPC.class
								.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAsignacinDeHabilidades.setIcon(new ImageIcon(
						AyudaCreacionNPC.class
								.getResource("/images/botonesInicio.png")));

			}
		});
		btnAsignacinDeHabilidades.setIcon(new ImageIcon(AyudaCreacionNPC.class
				.getResource("/images/botonesInicio.png")));
		btnAsignacinDeHabilidades.setForeground(Color.WHITE);
		btnAsignacinDeHabilidades.setBorder(null);
		btnAsignacinDeHabilidades.setContentAreaFilled(false);
		btnAsignacinDeHabilidades.setFocusPainted(false);
		btnAsignacinDeHabilidades
				.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAsignacinDeHabilidades.setOpaque(false);
		btnAsignacinDeHabilidades.setBounds(10, 224, 414, 34);
		contentPanel.add(btnAsignacinDeHabilidades);

		final JButton btnAsignacinDeEquip = new JButton(
				"Asignaci\u00F3n de Equipo");
		btnAsignacinDeEquip.setFont(mf.MyFont(0, 13));
		btnAsignacinDeEquip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AyudaEquipoNPC window = new AyudaEquipoNPC();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnAsignacinDeEquip.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnAsignacinDeEquip.setIcon(new ImageIcon(
						AyudaCreacionNPC.class
								.getResource("/images/botonesInicio2.png")));

			}

			public void mouseReleased(MouseEvent arg0) {
				btnAsignacinDeEquip.setIcon(new ImageIcon(
						AyudaCreacionNPC.class
								.getResource("/images/botonesInicio.png")));

			}
		});
		btnAsignacinDeEquip.setIcon(new ImageIcon(AyudaCreacionNPC.class
				.getResource("/images/botonesInicio.png")));
		btnAsignacinDeEquip.setForeground(Color.WHITE);
		btnAsignacinDeEquip.setBorder(null);
		btnAsignacinDeEquip.setContentAreaFilled(false);
		btnAsignacinDeEquip.setFocusPainted(false);
		btnAsignacinDeEquip.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAsignacinDeEquip.setOpaque(false);
		btnAsignacinDeEquip.setBounds(10, 269, 414, 34);
		contentPanel.add(btnAsignacinDeEquip);
		
		final JButton btnPoderesExtrasModifcadores = new JButton("Poderes Extras Modifcadores");
		btnPoderesExtrasModifcadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnPoderesExtrasModifcadores.setIcon(new ImageIcon(AyudaCreacionNPC.class.getResource("/images/botonesInicio2.png")));
			}
			public void mouseReleased(MouseEvent arg0) {
				btnPoderesExtrasModifcadores.setIcon(new ImageIcon(AyudaCreacionNPC.class.getResource("/images/botonesInicio.png")));
			}
		});
		btnPoderesExtrasModifcadores.setIcon(new ImageIcon(AyudaCreacionNPC.class.getResource("/images/botonesInicio.png")));
		btnPoderesExtrasModifcadores.setOpaque(false);
		btnPoderesExtrasModifcadores.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPoderesExtrasModifcadores.setForeground(Color.WHITE);
		btnPoderesExtrasModifcadores.setFont(new Font("Morpheus", Font.PLAIN, 13));
		btnPoderesExtrasModifcadores.setFocusPainted(false);
		btnPoderesExtrasModifcadores.setContentAreaFilled(false);
		btnPoderesExtrasModifcadores.setBorder(null);
		btnPoderesExtrasModifcadores.setBounds(10, 314, 414, 34);
		contentPanel.add(btnPoderesExtrasModifcadores);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AyudaCreacionNPC.class
				.getResource("/images/background-creadornpcs.jpg")));
		label.setBounds(0, 0, 434, 423);
		contentPanel.add(label);
	}

}
