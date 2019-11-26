package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelos.Mensagem;

/**
 * Classe DAO para troca de mensagens
 * 
 * @author Maicon Souza
 * @version 1.0
 * @since 1.0
 *
 */
public class MensagemDao {

private Connection conexao;
	
	public MensagemDao (Connection conexao) {
		this.conexao = conexao;
	}
	//<----------------------------------->//
	
	//caractere separador de mensagens '%%'
	public void armazenaNovaMensagem(Mensagem mensagem) {
		String novaMensagem = "INSERT INTO Mensagem"
				+ "(id_mensagem, fk_apelido_destinatario, fk_apelido_remetente, "
				+ "texto, data_hora_envio, data_hora_visualizacao, estado_visualizacao) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		
		/**
		 * Objeto de execucao de comando SQL
		 */
		try (PreparedStatement pst = conexao.prepareStatement(novaMensagem)) {
			
			pst.setInt(1,	 mensagem.getId());
			pst.setString(2,	 mensagem.getApelidoDestinatario());
			pst.setString(3,	 mensagem.getApelidoRemetente());
			pst.setString(4,	 mensagem.getTexto());
			pst.setString(5,	 mensagem.getDhEnvio());
			pst.setString(6,	 mensagem.getDhVisualizacao());
			pst.setBoolean(7,	 mensagem.getEstadoVisualizacao());
			
			//ATE AQUI SO FOI CRIADA a STRING da linha cadastrarUsuario
			
			/**
			 * Comando para executar a String no banco de dados
			 */
			pst.execute();
			
		} catch (SQLException ex) {
			
			/**
			 * Tratando as excessoes
			 */
			ex.printStackTrace();
		}
	
	
	
	}
	
}
