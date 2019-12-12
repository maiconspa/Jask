package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPasswordField;

import view.BoasVindas;
import dao.UsuarioDao;
import modelos.Usuario;
import dao.Conexao;

/**
 * Tela de Entrada de um usuário já cadastrado
 * 
 * @author Maicon Souza
 * @version 2.0
 * @since 1.0
 *
 */
public class Entrada{

	private void proximajanela(JButton botao, JFrame frameAtual, String outroFrame, JTextField txtApelido, JTextField txtSenha) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frameAtual.dispose();
				
				if (outroFrame.equals("Voltar")) {
					new BoasVindas().composeBoasVindas();
				} else if (outroFrame.equals("Proximo")) {
					
					if(verificacaoApelido(txtApelido)) {
						System.out.println("tem esse usuario");
						if(verificacaoSenha(txtApelido, txtSenha)) {
							VisaoGeral vg = new VisaoGeral(txtApelido.getText());
							System.out.println("entrou");
							vg.composeVisaoGeral();
						}
					}
					
					//se a verificacao for bem sucedida:    new Entrada().composeEntrada();

				}
				
			}
		});
	}
	
	private boolean verificacaoApelido (JTextField txt) {
		boolean controle = false;
		
		UsuarioDao uDao = new UsuarioDao(Conexao.conectar());
		Usuario user = uDao.consultarUsuario(txt.getText());
		
		if (user.getApelido().equals(txt.getText())) {
			controle = true;
		}
		
		return controle;
	}
	
	private boolean verificacaoSenha (JTextField txtApelido, JTextField txtSenha) {
		boolean controle = false;
		
		UsuarioDao uDao = new UsuarioDao(Conexao.conectar());
		Usuario user = uDao.consultarUsuario(txtApelido.getText());
		
		if (user.getSenha().equals(txtSenha.getText())) {
			controle = true;
		}
		
		return controle;
	}	
	
	
	public void composeEntrada() {
		
		JFrame janela = new JFrame();
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 600);
		janela.setLocationRelativeTo(null);
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(255, 255, 255));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelPrincipal.setLayout(null);
		painelPrincipal.setBackground(new Color(20, 162, 251));
		janela.setContentPane(painelPrincipal);
		
		//label do botao de voltar
		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoltar.setFont(new Font("Dialog", Font.BOLD, 10));
		lblVoltar.setBounds(22, 12, 45, 16);
		painelPrincipal.add(lblVoltar);
		
		//Botao de voltar
		JButton btnBack = new JButton("");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.WHITE);
		btnBack.setIcon(new ImageIcon("icons/arrowBack.png"));
		btnBack.setBounds(22, 26, 45, 45);
		btnBack.setBorderPainted(false); //método para retirar as bordas do JButton e deixar somente a imagem.
		painelPrincipal.add(btnBack);		
		
		//label do botao de avançar
		JLabel lblNext = new JLabel("Avançar");
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNext.setBounds(320, 12, 45, 16);
		painelPrincipal.add(lblNext);
		//botao de avançar
		JButton btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon("icons/arrowFoward.png"));
		btnNext.setForeground(Color.WHITE);
		btnNext.setBorderPainted(false);
		btnNext.setBackground(Color.WHITE);
		btnNext.setBounds(320, 26, 45, 45);
		painelPrincipal.add(btnNext);
		
		
		//icone abelha do jask
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("logo/crop-blue.png"));
		label.setBounds(120, 40, 250, 300);
		painelPrincipal.add(label);
		
		
		//elementos de formulário
		JLabel lblNickname = new JLabel("Apelido:");
		lblNickname.setBounds(100, 223, 100, 16);
		painelPrincipal.add(lblNickname);
		
		JTextField txtApelido = new JTextField();
		txtApelido.setBounds(100, 239, 200, 25);
		txtApelido.setBorder(new LineBorder(Color.WHITE));
		painelPrincipal.add(txtApelido);
		
		
		JLabel lblSenhaEntrada = new JLabel("Senha:");
		lblSenhaEntrada.setBounds(100, 276, 55, 16);
		painelPrincipal.add(lblSenhaEntrada);
		
		JPasswordField campoSenha = new JPasswordField();
		campoSenha.setBounds(100, 293, 200, 25);
		campoSenha.setBorder(new LineBorder(Color.WHITE));
		painelPrincipal.add(campoSenha);
		
		
		janela.setVisible(true);
		
		
		// ACOES DE BOTOES:
		proximajanela(btnBack, janela, "Voltar", null, null);
		proximajanela(btnNext, janela, "Proximo", txtApelido, campoSenha);
	}
	
	
	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		new Entrada().composeEntrada();
	}
	
}
