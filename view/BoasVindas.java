package view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.*;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * Tela de Boas vindas, onde o usuário escolhe entrar com uma conta existente ou cadastrar uma nova conta.
 * @author Maicon Souza
 */
public class BoasVindas {

	private void composeBoasVindas() {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// LOGOTIPO JASK
		JLabel iconJask = new JLabel("");
		iconJask.setIcon(new ImageIcon(BoasVindas.class.getResource("/view/img/logos/workingBee-CROP-blue-Jask_by_Miglena_Spasova.png")));
		iconJask.setBounds(53, 39, 300, 300);
		frame.setContentPane(iconJask);
		
		// BOTÃO DE ENTRAR
		JButton btnEntrar = new JButton("Entre");
		btnEntrar.setFont(new Font("Calibri", Font.BOLD, 14));
		//definindo cor da fonte:
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(46,204,113));
		//setBounds: positionX, positionY, width, height.
		btnEntrar.setBounds(100, 350, 200, 35);
		frame.getContentPane().add(btnEntrar);
		
		// BOTÃO DE CADASTRO
		JButton btnCadastro = new JButton("Cadastre-se");
		btnCadastro.setFont(new Font("Calibri", Font.BOLD, 14));
		//definindo cor da fonte:
		btnCadastro.setForeground(new Color(255, 255, 255));
		//setBounds: positionX, positionY, width, height:
		btnCadastro.setBackground(new Color(231,76,60));
		//setBounds: positionX, positionY, width, height.
		btnCadastro.setBounds(100, 395, 200, 35);
		frame.getContentPane().add(btnCadastro);
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
		
		new BoasVindas().composeBoasVindas();
	}
	
}