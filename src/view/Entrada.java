package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPasswordField;

/**
 * Tela de Entrada de um usuário já cadastrado
 * 
 * @author Maicon Souza
 * @version 2.0
 * @since 1.0
 *
 */
public class Entrada extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCompleto;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/**
		 * Look and feel
		 */
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrada frame = new Entrada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Entrada() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label do botao de voltar
		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoltar.setFont(new Font("Dialog", Font.BOLD, 10));
		lblVoltar.setBounds(22, 12, 45, 16);
		contentPane.add(lblVoltar);
		//Botao de voltar
		JButton btnBack = new JButton("");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.WHITE);
		btnBack.setIcon(new ImageIcon(Entrada.class.getResource("/view/img/icons/arrowBack.png")));
		btnBack.setBounds(22, 26, 45, 45);
		btnBack.setBorderPainted(false); //método para retirar as bordas do JButton e deixar somente a imagem.
		contentPane.add(btnBack);		
		
		
		//label do botao de avançar
		JLabel lblNext = new JLabel("Avançar");
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNext.setBounds(320, 12, 45, 16);
		contentPane.add(lblNext);
		//botao de avançar
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Entrada.class.getResource("/view/img/icons/arrowFoward.png")));
		button.setForeground(Color.WHITE);
		button.setBorderPainted(false);
		button.setBackground(Color.WHITE);
		button.setBounds(320, 26, 45, 45);
		contentPane.add(button);
		
		
		//icone abelha do jask
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Entrada.class.getResource("/view/img/logos/workingBee-orange-Jask_by_Miglena_Spasova.png")));
		label.setBounds(100, 90, 200, 85);
		contentPane.add(label);
		
		
		//elementos de formulário
		JLabel lblNickname = new JLabel("Apelido ou E-mail:");
		lblNickname.setBounds(100, 193, 100, 16);
		contentPane.add(lblNickname);
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(100, 209, 200, 25);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);
		
		
		JLabel lblSenhaEntrada = new JLabel("Senha:");
		lblSenhaEntrada.setBounds(100, 246, 55, 16);
		contentPane.add(lblSenhaEntrada);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 263, 200, 25);
		contentPane.add(passwordField);
		
		
		
		
		
	}
}
