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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setText("Nome completo");
		txtNomeCompleto.setBounds(110, 50, 154, 36);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(110, 87, 55, 16);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 127, 114, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(110, 162, 55, 16);
		contentPane.add(lblTelefone);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 190, 114, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblApelido = new JLabel("Apelido:");
		lblApelido.setBounds(110, 222, 55, 16);
		contentPane.add(lblApelido);
		
		textField_3 = new JTextField();
		textField_3.setBounds(110, 250, 114, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(110, 282, 55, 16);
		contentPane.add(lblSenha);
		
		textField_4 = new JTextField();
		textField_4.setBounds(110, 310, 114, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSelecioneUmaImagem = new JButton("Selecione uma imagem");
		btnSelecioneUmaImagem.setBounds(110, 354, 167, 26);
		contentPane.add(btnSelecioneUmaImagem);
		
		JLabel lblNadaSelecionado = new JLabel("nada selecionado...");
		lblNadaSelecionado.setBounds(115, 392, 109, 16);
		contentPane.add(lblNadaSelecionado);
	}
}
