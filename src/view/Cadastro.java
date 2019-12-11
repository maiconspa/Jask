package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
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
 * @author Maicon Souza
 */

public class Cadastro{
	/*
	private void proximajanela(JButton botao, JFrame frameAtual, String outroFrame, JTextField txtNome, JTextField txtEmail, JTextField txtEmail, JTextField txtEmail,) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frameAtual.dispose();
				
				if (outroFrame.equals("Voltar")) {
					new BoasVindas().composeBoasVindas();
				} else if (outroFrame.equals("Proximo")) {
					//
					if(verificacaoApelido(txtApelido)) {
						System.out.println("tem esse usuario ou email");
						if(verificacaoSenha(txtApelido, txtSenha)) {
							new VisaoGeral().composeVisaoGeral();
						} 
						
					}
					
					//se a verificacao for bem sucedida:    new Entrada().composeEntrada();

				}
				
			}
		});
	}
	
	*/
	
	
	
	public void composeScreen() {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 600);
		
		
		JPanel painel = new JPanel();
		painel.setBackground(new Color(20, 162, 251));
		painel.setLayout(null);
		frame.setContentPane(painel);
		
		
		JLabel lblVoltar = new JLabel();
		lblVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoltar.setFont(new Font("Dialog", Font.BOLD, 10));
		lblVoltar.setText("Voltar");
		lblVoltar.setBounds(22, 12, 45, 16);
		painel.add(lblVoltar);
		
		
		JButton btnBack = new JButton();
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.WHITE);
		btnBack.setText("");
		btnBack.setIcon(new ImageIcon("icons/arrowBack.png"));
		btnBack.setBounds(22, 26, 45, 45);
		btnBack.setBorderPainted(false); //método para retirar as bordas do JButton e deixar somente a imagem.
		painel.add(btnBack);		
		
		
		JLabel lblNext = new JLabel();
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNext.setText("Avançar");
		lblNext.setBounds(320, 12, 45, 16);
		painel.add(lblNext);
		
		
		JButton btnAvancar = new JButton();
		btnAvancar.setIcon(new ImageIcon("icons/arrowFoward.png"));
		btnAvancar.setForeground(Color.WHITE);
		btnAvancar.setText("");
		btnAvancar.setBorderPainted(false);
		btnAvancar.setBackground(Color.WHITE);
		btnAvancar.setBounds(320, 26, 45, 45);
		painel.add(btnAvancar);
		
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon("logo/crop-blue.png"));
		lblLogo.setBounds(125, 40, 250, 300);
		painel.add(lblLogo);
		
		
		JLabel lblNome = new JLabel();
		lblNome.setBounds(100, 193, 55, 16);
		lblNome.setText("Nome:");
		painel.add(lblNome);
		
		
		JTextField txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(100, 209, 200, 25);
		txtNomeCompleto.setBorder(new LineBorder(Color.WHITE));
		painel.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);
		
		
		JLabel lblEmail = new JLabel();
		lblEmail.setBounds(100, 246, 55, 16);
		lblEmail.setText("E-mail:");
		painel.add(lblEmail);
		
		
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(100, 263, 200, 25);
		txtEmail.setBorder(new LineBorder(Color.WHITE));
		painel.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		JLabel lblTelefone = new JLabel();
		lblTelefone.setBounds(100, 300, 55, 16);
		lblTelefone.setText("Telefone:");
		painel.add(lblTelefone);
		
		
		JTextField txtTelefone = new JTextField();
		txtTelefone.setBounds(100, 318, 200, 25);
		txtTelefone.setBorder(new LineBorder(Color.WHITE));
		painel.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		
		JLabel lblApelido = new JLabel();
		lblApelido.setBounds(100, 353, 55, 16);
		lblApelido.setText("Apelido:");
		painel.add(lblApelido);
		
		
		JTextField txtApelido = new JTextField();
		txtApelido.setBounds(100, 371, 200, 25);
		txtApelido.setBorder(new LineBorder(Color.WHITE));
		painel.add(txtApelido);
		txtApelido.setColumns(10);
		
		
		JButton btnVerificaApelido = new JButton();
		btnVerificaApelido.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVerificaApelido.setIcon(new ImageIcon("icons/search.png"));
		btnVerificaApelido.setForeground(Color.BLACK);
		btnVerificaApelido.setBackground(Color.WHITE);
		btnVerificaApelido.setBounds(305, 371, 30, 30);
		painel.add(btnVerificaApelido);
		
		
		JLabel lblSenha = new JLabel();
		lblSenha.setBounds(100, 408, 55, 16);
		lblSenha.setText("Senha:");
		painel.add(lblSenha);
		
		
		JTextField txtSenha = new JTextField();
		txtSenha.setBounds(100, 425, 200, 25);
		txtSenha.setBorder(new LineBorder(Color.WHITE));
		txtSenha.setColumns(10);
		painel.add(txtSenha);
		
		
		JButton btnSelectImg = new JButton();
		btnSelectImg.setIcon(new ImageIcon("icons/addImage.png"));
		btnSelectImg.setForeground(Color.WHITE);
		btnSelectImg.setBackground(Color.WHITE);
		btnSelectImg.setText("");
		btnSelectImg.setBorderPainted(false);
		btnSelectImg.setBounds(100, 468, 40, 45);
		painel.add(btnSelectImg);
		
		
		JTextField txtFile = new JTextField();
		txtFile.setText("Nada selecionado ainda...");
		txtFile.setBorder(new LineBorder(Color.WHITE));
		txtFile.setBounds(150, 482, 150, 20);
		painel.add(txtFile);
		txtFile.setColumns(10);
		
		frame.setVisible(true);
		//<------------------------  AÇÕES DE BOTÕES  ---------------------------->\\
		//Selecionar imagem:
		selectImg(btnSelectImg, txtFile);
		
	}
	
	//<-------------------------------- COMPORTAMENTO(métodos) ------------------------------------------->\\
	/**
	 * Abre janela de seleção de imagens, recebe um objeto do tipo JButton.
	 */
	public static void selectImg(JButton botao, JTextField campoDetexto) {
		botao.addActionListener(new ActionListener() {
			/**
			 * variavel utilizada posteriormente para capturar o retorno de seleção (seja ele: selecionado OU não)
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
					//Captura arquivo selecionado:
					File file = jfc.getSelectedFile();
					campoDetexto.setText(file.getPath());
				}
				
				
			}
		});
	}
	
	//<-------------------------------- --------------------------------------->\\
	
	public static void main(String[] args) {
		
		//Look and feel:
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		//Chamar método de composição de tela:
		new Cadastro().composeScreen();
	}
}
