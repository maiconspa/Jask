package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import dao.Conexao;
import dao.UsuarioDao;
import modelos.Usuario;
import view.SelecaoFoto;

public class DecisaoInserirImagem {
	
	private String apelido;
	
	public DecisaoInserirImagem (String apelido) {
		this.apelido = apelido;
	}
	
	public void switchJanela(JButton botao, JFrame frameAtual, String opcao, String apelido) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
				Usuario user = userDao.consultarUsuario(apelido);
				
				
				if (opcao.equals("não")) {
					userDao.imagemRandomica(user.getApelido());
					new VisaoGeral().composeVisaoGeral();
					frameAtual.dispose();
				} else if (opcao.equals("sim")) {
					new SelecaoFoto().composeSelecaoFoto();
					frameAtual.dispose();
				}
			}
		});
	}
	
	public void composeDecisao(String apelido) {
		
		
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
		
		JLabel lblAviso = new JLabel("Deseja inserir uma foto no seu perfil?");
		lblAviso.setForeground(Color.WHITE);
		
		lblAviso.setBounds(95, 230, 250, 45);
		painel.add(lblAviso);
		
		//
		// SIM
		JButton btnSim = new JButton("SIM");
		btnSim.setFont(new Font("Calibri", Font.BOLD, 14));
		//definindo cor da fonte:
		btnSim.setForeground(new Color(255, 255, 255));
		btnSim.setBackground(new Color(46,204,113));
		//setBounds: positionX, positionY, width, height.
		btnSim.setBounds(90, 300, 100, 45);
		painel.add(btnSim);
		
		// NÃO
		JButton btnNao = new JButton("NÃO");
		btnNao.setFont(new Font("Calibri", Font.BOLD, 14));
		//definindo cor da fonte:
		btnNao.setForeground(new Color(255, 255, 255));
		//setBounds: positionX, positionY, width, height:
		btnNao.setBackground(new Color(231,76,60));
		//setBounds: positionX, positionY, width, height.
		btnNao.setBounds(210, 300, 100, 45);
		painel.add(btnNao);
		
		
		// SET VISIBLE
		janela.setVisible(true);
		
		
		// ACAO DE BOTOES
		switchJanela(btnNao, janela, "não", apelido);
		switchJanela(btnSim, janela, "sim", apelido);
		
		System.out.println(apelido);
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
		
		//Chamar método de composição de tela:
		new DecisaoInserirImagem(null).composeDecisao(null); //resolver
		
	}
	
	
	
	
	
	
	
}
