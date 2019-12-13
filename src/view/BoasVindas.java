package view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * Tela de Boas vindas, onde o usu�rio escolhe entrar com uma conta existente ou cadastrar uma nova conta.
 * @author Maicon Souza
 */
public class BoasVindas {

	private void proximajanela(JButton botao, JFrame frameAtual, String proximoFrame) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (proximoFrame.equals("Cadastro")) {
					new Cadastro().composeScreen();
				} else if (proximoFrame.equals("Entrada")){
					new Entrada().composeEntrada();
				}

				frameAtual.dispose();
				
			}
		});
	}
	
	
	public void composeBoasVindas() {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		
		JPanel painel = new JPanel();
		painel.setSize(400, 600);
		painel.setLayout(null);
		painel.setBackground(new Color(20, 162, 251));
		frame.setContentPane(painel);
		
		// LOGOTIPO JASK
		JLabel iconJask = new JLabel();
		iconJask.setIcon(new ImageIcon("logo/crop-blue.png"));
		iconJask.setBounds(125, 80, 300, 300);
		painel.add(iconJask);
		
		// BOT�O DE ENTRAR
		JButton btnEntrar = new JButton("Entre");
		btnEntrar.setFont(new Font("Calibri", Font.BOLD, 14));
		//definindo cor da fonte:
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(46,204,113));
		//setBounds: positionX, positionY, width, height.
		btnEntrar.setBounds(100, 350, 200, 35);
		btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		painel.add(btnEntrar);
		
		// BOT�O DE CADASTRO
		JButton btnCadastro = new JButton("Cadastre-se");
		btnCadastro.setFont(new Font("Calibri", Font.BOLD, 14));
		//definindo cor da fonte:
		btnCadastro.setForeground(new Color(255, 255, 255));
		//setBounds: positionX, positionY, width, height:
		btnCadastro.setBackground(new Color(231,76,60));
		//setBounds: positionX, positionY, width, height.
		btnCadastro.setBounds(100, 395, 200, 35);
		painel.add(btnCadastro);
		
		//<---------------------Acao de bot�es--------------------->//
		proximajanela(btnEntrar, frame, "Entrada");
		proximajanela(btnCadastro, frame, "Cadastro");
		//<------------------------------------------------------------>//
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new BoasVindas().composeBoasVindas();
	}
	
}