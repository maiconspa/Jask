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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCompleto;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblApelido;
	private JTextField textField_3;
	private JLabel lblSenha;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
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
		btnBack.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/arrowBack.png")));
		btnBack.setBounds(22, 26, 45, 45);
		btnBack.setBorderPainted(false); //m�todo para retirar as bordas do JButton e deixar somente a imagem.
		contentPane.add(btnBack);		
		
		
		//label do botao de avan�ar
		JLabel lblNext = new JLabel("Avan�ar");
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNext.setBounds(320, 12, 45, 16);
		contentPane.add(lblNext);
		//botao de avan�ar
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/arrowFoward.png")));
		button.setForeground(Color.WHITE);
		button.setBorderPainted(false);
		button.setBackground(Color.WHITE);
		button.setBounds(320, 26, 45, 45);
		contentPane.add(button);
		
		
		//icone abelha do jask
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Cadastro.class.getResource("/view/logo_bee_v1.png")));
		label.setBounds(100, 90, 200, 85);
		contentPane.add(label);
		
		
		//elementos de formul�rio
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(100, 193, 55, 16);
		contentPane.add(lblNome);
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(100, 209, 200, 25);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);
		
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(100, 246, 55, 16);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 263, 200, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(100, 300, 55, 16);
		contentPane.add(lblTelefone);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 318, 200, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		lblApelido = new JLabel("Apelido:");
		lblApelido.setBounds(100, 353, 55, 16);
		contentPane.add(lblApelido);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 371, 200, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(100, 408, 55, 16);
		contentPane.add(lblSenha);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 425, 200, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		JButton btnSelectImg = new JButton("");
		btnSelectImg.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
		});
		
		btnSelectImg.setIcon(new ImageIcon(Cadastro.class.getResource("/view/icons/addImage.png")));
		btnSelectImg.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSelectImg.setForeground(new Color(255, 255, 255));
		btnSelectImg.setBackground(Color.WHITE);
		btnSelectImg.setBorderPainted(false);
		btnSelectImg.setBounds(100, 468, 40, 45);
		contentPane.add(btnSelectImg);
		
		JLabel lblSelectionState = new JLabel("nada selecionado ainda...");
		lblSelectionState.setForeground(Color.DARK_GRAY);
		lblSelectionState.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionState.setBounds(140, 495, 160, 16);
		contentPane.add(lblSelectionState);
		
	}
}