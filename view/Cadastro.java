package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

/**
 * Tela de cadastro de uma nova conta
 * 
 * @author Maicon Souza
 * @version 2.0
 * @since 1.0
 *
 */

public class Cadastro extends JFrame {

	/**
	 * Atributo de composição de tela, utilizado para adiconar elementos à exibição
	 */
	private JPanel contentPane;
	private JTextField txtNomeCompleto;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblApelido;
	private JTextField textField_3;
	private JLabel lblSenha;
	private JTextField textField_4;
	private JTextField txtFile;
	
	
	//<-------------------------------- COMPORTAMENTO(métodos) ------------------------------------------->\\
	/**
	 * Abre janela de seleção de imagens, recebe um objeto do tipo JButton.
	 */
	public static void selectImg(JButton botao, JTextField campoDetexto) {
		botao.addActionListener(new ActionListener() {
			/**
			 * variavel utilizada posteriormente para capturar o retorno de seleção (seja ele: selecionado alguma coisa OU não)
			 */
			private int retorno;

			public void actionPerformed(ActionEvent e) {
				//Instância do JFileChooser
				JFileChooser jfc = new JFileChooser();
				
				//Definindo título da barra superior:
				jfc.setDialogTitle("Selecionar imagem");
				
				//Restrição de tipo de arquivo (filtro de extensões, oculta arquivos com outras extensões, permitindo somente a seleção daquelas predefinidas):
				jfc.setFileFilter(new FileNameExtensionFilter("Imagem", "jpg", "jpeg", "png"));
				
				//Restrição para seleção de arquivos ao invés de diretórios completos:
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				//Abrir menu de contexto de seleção de arquivos:
				retorno = jfc.showOpenDialog(jfc);
				
				//Alteração do campo "nada selecionado ainda..." de acordo com ter selecionado ou não alguma coisa
				if (retorno == JFileChooser.APPROVE_OPTION) {
					/**
					 * Captura o arquivo selecionado
					 */
					File file = jfc.getSelectedFile();
					campoDetexto.setText(file.getPath());
				}
			}});
	}
	
	//<-------------------------------- --------------------------------------->\\
	
	/**
	 * Iniciando a aplicação
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
					Cadastro janela = new Cadastro();
					/**
					 * Exibindo a janela de cadastro
					 */
					janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Janela de cadastro
	 */
	public Cadastro() {
		/**
		 * Configurações da janela
		 */
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
		btnBack.setIcon(new ImageIcon(Cadastro.class.getResource("/view/img/icons/arrowBack.png")));
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
		button.setIcon(new ImageIcon(Cadastro.class.getResource("/view/img/icons/arrowFoward.png")));
		button.setForeground(Color.WHITE);
		button.setBorderPainted(false);
		button.setBackground(Color.WHITE);
		button.setBounds(320, 26, 45, 45);
		contentPane.add(button);
		
		
		//icone abelha do jask
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Cadastro.class.getResource("/view/img/logos/logo_bee_v1.png")));
		label.setBounds(100, 90, 200, 85);
		contentPane.add(label);
		
		
		//elementos de formulário
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
		
		/**
		 * Label do campo do apelido
		 */
		lblApelido = new JLabel("Apelido:");
		lblApelido.setBounds(100, 353, 55, 16);
		contentPane.add(lblApelido);
		
		/**
		 * Campo de texto do apelido
		 */
		textField_3 = new JTextField();
		textField_3.setBounds(100, 371, 200, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		/**
		 * Botao de verificacao de apelido existente
		 */
		JButton btnVerificaApelido = new JButton();
		btnVerificaApelido.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVerificaApelido.setText("Verificar");
		btnVerificaApelido.setForeground(Color.BLACK);
		btnVerificaApelido.setBackground(Color.WHITE);
		btnVerificaApelido.setBounds(305, 371, 77, 20);
		contentPane.add(btnVerificaApelido);
		
		/**
		 * Label do campo de senha
		 */
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(100, 408, 55, 16);
		contentPane.add(lblSenha);
		
		/**
		 * Campo de texto de inserção da senha
		 */
		textField_4 = new JTextField();
		textField_4.setBounds(100, 425, 200, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		/**
		 * Botão de seleção de imagem
		 */
		JButton btnSelectImg = new JButton("");
		btnSelectImg.setIcon(new ImageIcon(Cadastro.class.getResource("/view/img/icons/addImage.png")));
		btnSelectImg.setForeground(Color.WHITE);
		btnSelectImg.setBackground(Color.WHITE);
		btnSelectImg.setBorderPainted(false);
		btnSelectImg.setBounds(100, 468, 40, 45);
		contentPane.add(btnSelectImg);
		
		/**
		 * Campo de texto de informação (imagem selecionada)
		 */
		txtFile = new JTextField();
		txtFile.setText("Nada selecionado ainda...");
		txtFile.setBounds(150, 482, 150, 20);
		contentPane.add(txtFile);
		txtFile.setColumns(10);
		
		//<------------------------  AÇÕES DE BOTÕES  ---------------------------->\\
		
		/**
		 * Selecionar imagem
		 */
		selectImg(btnSelectImg, txtFile);
		
	}
}
