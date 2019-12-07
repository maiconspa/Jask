package src.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;


import src.dao.Conexao;
import src.dao.UsuarioDao;
import src.modelos.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Tela de troca de mensagens entre usuários
 * @author Maicon Souza
 */
public class Profile{
	
	UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
	Usuario resultado = userDao.consultarUsuario("Bike");
	

	public void chamarImagem(JPanel painel, JTextField txtFile) {
		
		
		//FOTO DO USUARIO:
		JButton btFotoUsuario = new JButton();
		btFotoUsuario.setBackground(Color.WHITE);
		//coleta da foto:
		try {
			if (resultado.getFoto() != null) {
				System.out.println("TEM IMAGEM");
				btFotoUsuario.setIcon(
					new ImageIcon(
						ImageIO.read(
							resultado.getFoto()
							)
						)
					);
			} else {
				//Caso o usuário não tenha imagem, é definido uma padrão:
				
				userDao.imagemRandomica();
				System.out.println("NAO TEM IMAGEM");
				btFotoUsuario.setIcon(
					new ImageIcon(
						ImageIO.read(
							resultado.getFoto()
							)
						)
					);
			}
		} catch (SecurityException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		//restante da label:
		System.out.println(btFotoUsuario.getIcon());
		btFotoUsuario.setBounds(75, 75, 250, 250);
		painel.add(btFotoUsuario);
		
		//Selecionar imagem:
		selectImg(btFotoUsuario, txtFile, userDao, resultado);
	}
	
	
	
	
	public void composeProfile() {
		JFrame janelaChat = new JFrame();
		janelaChat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaChat.setSize(400, 600);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setSize(400, 600);
		panel.setLayout(null);
		janelaChat.setContentPane(panel);
		
		JLabel lblMensagens = new JLabel("Perfil");
		lblMensagens.setBounds(10, 10, 150, 40);
		lblMensagens.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblMensagens);
		
		JLabel lblAvisoAltImagem = new JLabel("Clique na imagem para alterar");
		lblAvisoAltImagem.setBounds(10, 40, 160, 37);
		lblAvisoAltImagem.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblAvisoAltImagem);
		
		//botao fica nessa parte (para o layout, apenas)
		JTextField txtFile = new JTextField();
		txtFile.setText("Imagem inalterada");
		txtFile.setEnabled(false);
		txtFile.setBounds(75, 330, 250, 20);
		panel.add(txtFile);
		
		
		
		janelaChat.setVisible(true);
		
		
		//<------------------------  AÇÕES DE BOTÕES  ---------------------------->\\
		
		
		
		
		//<------------------------  CHAMANDO DO BANCO  ---------------------------->\\
		chamarImagem(panel, txtFile);
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
		
		new Profile().composeProfile();
		
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