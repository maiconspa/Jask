package src.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Tela de troca de mensagens entre usuários
 * @author Maicon Souza
 */
public class Chat{

	
	
	public void composeChat() {
		JFrame janelaChat = new JFrame();
		janelaChat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaChat.setBounds(100, 100, 400, 600);
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBackground(Color.WHITE);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelPrincipal.setLayout(null);
		janelaChat.setContentPane(painelPrincipal);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 364, 539);
		painelPrincipal.add(panel);
		panel.setLayout(null);
		
		JLabel lblMensagens = new JLabel("Mensagens");
		lblMensagens.setBounds(10, 11, 150, 37);
		lblMensagens.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblMensagens);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 60, 297, 468);
		panel.add(scrollPane);
		
		janelaChat.setVisible(true);
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
		
		new Chat().composeChat();
		
	}
}
