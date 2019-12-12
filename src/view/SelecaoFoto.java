package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.Conexao;
import dao.UsuarioDao;
import modelos.Usuario;
import view.VisaoGeral;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SelecaoFoto {
	UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
	Usuario resultado = userDao.consultarUsuario("Bike");
	
	
	private void toVisaoGeral(JButton botao, JFrame frameAtual) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frameAtual.dispose();
				new VisaoGeral().composeVisaoGeral();
				
			}
		});
	}
	
	public void composeSelecaoFoto() {
		
		JFrame janela = new JFrame();
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setBounds(100, 100, 400, 600);
		
		JPanel painel = new JPanel();
		painel.setBackground(new Color(255, 255, 255));
		painel.setLayout(null);
		painel.setBackground(new Color(20, 162, 251));
		janela.setContentPane(painel);
		
		JLabel lblNext = new JLabel();
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNext.setText("Avan�ar");
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
		
		JLabel lblAviso = new JLabel("Clique depois de inserido para modificar.");
		lblAviso.setBounds(75, 180, 250, 20);
		painel.add(lblAviso);
		
		JButton btnSelectImg = new JButton();
		btnSelectImg.setIcon(new ImageIcon("icons/addImage.png"));
		btnSelectImg.setForeground(Color.WHITE);
		btnSelectImg.setBackground(Color.WHITE);
		btnSelectImg.setText("");
		btnSelectImg.setBorderPainted(false);
		btnSelectImg.setBounds(75, 200, 250, 250);
		painel.add(btnSelectImg);
		
		
		JTextField txtFile = new JTextField();
		txtFile.setText("Nada selecionado ainda...");
		txtFile.setBorder(new LineBorder(Color.WHITE));
		txtFile.setBounds(75, 460, 250, 20);
		painel.add(txtFile);
		
		// SET VISIBLE JFRAME
		janela.setVisible(true);
		
		//<------------------------  A��ES DE BOT�ES  ---------------------------->\\
		//Selecionar imagem:
		selectImg(btnSelectImg, txtFile, userDao, resultado);
		
		// avan�ar para a tela de vis�o geral:
		toVisaoGeral(btnAvancar, janela);
	}
	
	//<-------------------------------- COMPORTAMENTO(m�todos) ------------------------------------------->\\
	/**
	 * Abre janela de sele��o de imagens, recebe um objeto do tipo JButton.
	 */
	public static void selectImg(JButton botao, JTextField campoDetexto, UsuarioDao u, Usuario user) {
		botao.addActionListener(new ActionListener() {
			/**
			 * variavel utilizada posteriormente para capturar o retorno de sele��o (seja ele: selecionado OU n�o)
			 */
			private int retorno;

			public void actionPerformed(ActionEvent e) {
				//Inst�ncia do JFileChooser
				JFileChooser jfc = new JFileChooser();
				
				//Definindo t�tulo da barra superior:
				jfc.setDialogTitle("Selecionar imagem");
				
				//Restri��o de tipo de arquivo (filtro de extens�es, oculta arquivos com outras extens�es, permitindo somente a sele��o daquelas predefinidas):
				jfc.setFileFilter(new FileNameExtensionFilter("Imagem", "jpg", "jpeg", "png"));
				
				//Restri��o para sele��o de arquivos ao inv�s de diret�rios completos:
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				//Abrir menu de contexto de sele��o de arquivos:
				retorno = jfc.showOpenDialog(jfc);
				
				//Altera��o do campo "nada selecionado ainda..." de acordo com ter selecionado ou n�o alguma coisa
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
	
	public static void main(String args []) {
		
		//Look and feel:
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		//Chamar m�todo de composi��o de tela:
		new SelecaoFoto().composeSelecaoFoto();
		
	}
	
	
	
	
}
