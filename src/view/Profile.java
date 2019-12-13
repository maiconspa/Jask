package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.filechooser.FileNameExtensionFilter;


import dao.Conexao;
import dao.UsuarioDao;
import modelos.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;

/**
 * Tela de troca de mensagens entre usuários
 * @author Maicon Souza
 */
public class Profile{
	
	private String apelido;
	int bgNav [] = {63, 111, 163};
	int bg [] = {212, 220, 229};
	
	//CONSTRUTORES:
	public Profile() {}
	
	public Profile(String apelido) {
		this.apelido = apelido;
	}
	
	
	

	//GET APELIDO:
	public String getApelido() {
		return this.apelido;
	}
	
	UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
	Usuario resultado = userDao.consultarUsuario(getApelido());
	
	
	
	//retorna nome
	public String retornaNome(String apelido) {
		UsuarioDao uDao = new UsuarioDao(Conexao.conectar());
		Usuario u = uDao.consultarUsuario(apelido);
		
		String nome = u.getNome();
		return nome;
	}
	//retorna email
	public String retornaEmail(String apelido) {
		UsuarioDao uDao = new UsuarioDao(Conexao.conectar());
		Usuario u = uDao.consultarUsuario(apelido);
		
		String email = u.getEmail();
		return email;
	}
	//retorna telefone
	public String retornaTelefone(String apelido) {
		UsuarioDao uDao = new UsuarioDao(Conexao.conectar());
		Usuario u = uDao.consultarUsuario(apelido);
		
		String tel = u.getTelefone();
		return tel;
	}
	//retorna senha
	public String retornaSenha(String apelido) {
		UsuarioDao uDao = new UsuarioDao(Conexao.conectar());
		Usuario u = uDao.consultarUsuario(apelido);
		
		String s = u.getSenha();
		return s;
	}
	
	public void alteraDados(JFrame frameAtual, JButton botao, JTextField txtNome, JTextField txtEmail, JTextField txtTelefone, JTextField txtSenha, String apelido) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("ENTROU NO METODO DE ALTERAR PEFIL");
				UsuarioDao uDao = new UsuarioDao(Conexao.conectar());
				try {
					uDao.atualizarUsuario(txtNome.getText(), txtEmail.getText(), txtTelefone.getText(), txtSenha.getText(), apelido);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(frameAtual, "Alterado com sucesso! :)");
			}
		});
	}
	
	public void chamarImagem(JPanel painel, JTextField txtFile, String apelido) {
		
		UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
		Usuario resultado = userDao.consultarUsuario(apelido);
		
		
		//FOTO DO USUARIO:
		JButton btnFotoUsuario = new JButton();
		btnFotoUsuario.setBackground(null);
		//coleta da foto:
		try {
			if (resultado.getFoto() != null) {
				System.out.println("TEM IMAGEM");
				btnFotoUsuario.setIcon(
					new ImageIcon(
						ImageIO.read(
							resultado.getFoto()
							)
						)
					);
			} else {
				//Caso o usuário não tenha imagem, é definido uma padrão:
				userDao.imagemRandomica(apelido);
				System.out.println("NAO TEM IMAGEM");
				btnFotoUsuario.setIcon(
					new ImageIcon(
						ImageIO.read(
							resultado.getFoto()
							)
						)
					);
			}
			System.out.println("IMAGEM:" +btnFotoUsuario.getIcon());
		} catch (SecurityException ex) {
			System.out.println("ERRO DE SecurityException");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("ERRO DE IOException");
			ex.printStackTrace();
		}
		//restante do botão:
		btnFotoUsuario.setBounds(75, 75, 250, 250);
		painel.add(btnFotoUsuario);
		
		//Selecionar imagem:
		selectImg(btnFotoUsuario, txtFile, userDao, resultado);
	}
	
	
	//COMPOR TELA:
	public void composeProfile() {
		JFrame janelaChat = new JFrame();
		janelaChat.setResizable(false);
		janelaChat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaChat.setSize(400, 600);
		janelaChat.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(bg[0], bg[1], bg[2]));
		panel.setSize(400, 600);
		panel.setLayout(null);
		janelaChat.setContentPane(panel);
		
		JPanel painelNome = new JPanel();
		painelNome.setBackground(new Color(bgNav[0], bgNav[1], bgNav[2]));
		painelNome.setBounds(0, 0, 400, 40);
		painelNome.setLayout(null);
		panel.add(painelNome);
		
		//botao fica nessa parte (para o layout, apenas)
		JTextField txtFile = new JTextField();
		txtFile.setText("Imagem inalterada");
		txtFile.setEnabled(false);
		txtFile.setBounds(75, 330, 250, 20);
		panel.add(txtFile);
		
		JLabel lblMensagens = new JLabel("Perfil de " +getApelido());
		lblMensagens.setBounds(10, 0, 400, 40);
		lblMensagens.setBackground(new Color(bgNav[0], bgNav[1], bgNav[2]));
		lblMensagens.setForeground(Color.WHITE);
		lblMensagens.setFont(new Font("Tahoma", Font.BOLD, 25));
		painelNome.add(lblMensagens);
		
		JLabel lblAvisoAltImagem = new JLabel("Clique na imagem para alterar");
		lblAvisoAltImagem.setBounds(10, 40, 160, 37);
		lblAvisoAltImagem.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblAvisoAltImagem);
		
		
		
		//ALTERACAO DE DADOS
		JLabel lblNome = new JLabel();
		lblNome.setText(getApelido());
		lblNome.setBounds(20, 370, 100, 20);
		lblNome.setText(retornaNome(getApelido()));
		panel.add(lblNome);
		
		JTextField txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(130, 370, 200, 25);
		txtNomeCompleto.setBorder(new LineBorder(Color.WHITE));
		panel.add(txtNomeCompleto);
		
		
		JLabel lblEmail = new JLabel();
		lblEmail.setBounds(20, 400, 100, 20);
		lblEmail.setText(retornaEmail(apelido));
		panel.add(lblEmail);
		
		
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(130, 400, 200, 25);
		txtEmail.setBorder(new LineBorder(Color.WHITE));
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		JLabel lblTelefone = new JLabel();
		lblTelefone.setBounds(20, 430, 100, 20);
		lblTelefone.setText(retornaTelefone(apelido));
		panel.add(lblTelefone);
		
		
		JTextField txtTelefone = new JTextField();
		txtTelefone.setBounds(130, 430, 200, 25);
		txtTelefone.setBorder(new LineBorder(Color.WHITE));
		panel.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		
		JLabel lblSenha = new JLabel();
		lblSenha.setBounds(20, 460, 100, 20);
		lblSenha.setText(retornaSenha(apelido));
		panel.add(lblSenha);
		
		
		JPasswordField txtSenha = new JPasswordField();
		txtSenha.setBounds(130, 460, 200, 25);
		txtSenha.setBorder(new LineBorder(Color.WHITE));
		txtSenha.setColumns(10);
		panel.add(txtSenha);
		
		
		//btnAleterar dados
		JButton btnAlterar = new JButton();
		btnAlterar.setToolTipText("Confirmar alteração de dados");
		btnAlterar.setText("Confirmar");
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBackground(null);
		btnAlterar.setBounds(160, 495, 70, 20);
		btnAlterar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.add(btnAlterar);
		
		
		
		janelaChat.setVisible(true);
		//<------------------------  AÇÕES DE BOTÕES  ---------------------------->\\
		alteraDados(janelaChat, btnAlterar, txtNomeCompleto, txtEmail, txtTelefone, txtSenha, getApelido());
		
		//<------------------------  CHAMANDO DO BANCO  ---------------------------->\\
		chamarImagem(panel, txtFile, getApelido());
	}
	
	
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        // Tenta capturar o look and feel 'Metal'
		    	if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		
		//CHAMANDO COMPOSIÇAÕ DE TELA:
		Profile p = new Profile();
		p.composeProfile();
	}
	
	
	/**
	 * Abre janela de seleção de imagens, recebe um objeto do tipo JButton.
	 */
	public static void selectImg(JButton botao, JTextField campoDetexto, UsuarioDao u, Usuario user) {
		
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
					
					try {
						botao.setIcon(
							new ImageIcon(
								ImageIO.read(
									file
									)
								)
							);
						
						u.armazenarImagens(file, user.getApelido());
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
}