package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.sql.Date;
import modelos.Mensagem;

/**
 * Data Acess Object para troca de mensagens
 * 
 * @author Maicon Souza
 * @version 3.0
 * @since 1.0
 */
public class MensagemDao {

	private Connection conexao;
	
	public MensagemDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	/**
	 * 
	 * @param mensagem objeto de manipulacao de elementos da classe
	 */
	public void armazenaNovaMensagem(Mensagem mensagem) {
		String novaMensagem = "INSERT INTO Mensagem"
				+ "(null, fk_apelido_destinatario, fk_apelido_remetente, "
				+ "texto, data_hora_envio, data_hora_visualizacao, estado_visualizacao) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		//Objeto de execucao de comando SQL
		try (PreparedStatement pst = conexao.prepareStatement(novaMensagem)) {
			
			// /!\ verificar como utilizar 'compareTo' para comparar datas
			pst.setString(1, mensagem.getApelidoDestinatario());
			pst.setString(2, mensagem.getApelidoRemetente());
			pst.setString(3, mensagem.getTexto());
			
			java.sql.Date dataEnvio = new Date(GregorianCalendar.getInstance().getTimeInMillis());
			pst.setDate(4, dataEnvio);
			
			java.sql.Date dataVisualizacao = new Date(GregorianCalendar.getInstance().getTimeInMillis());
			pst.setDate(5, dataVisualizacao);
			
			pst.setString(6, mensagem.getEstadoVisualizacao());
			
			// /!\ ATE AQUI SO FOI CRIADA a STRING da linha cadastrarUsuario
			
			//Comando para executar a String no banco de dados
			pst.execute();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param id utilizado para condicionar a consulta
	 * @return
	 */
	public Mensagem consultarMensagem(int id) {
		
		/**
		 * String de consulta
		 */
		String consulta = "SELECT * FROM Mensagem WHERE id_mensagem = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
			
			pst.setInt(1, id);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			Mensagem mensagem = null;
			
			if (resultado.next()) {
				mensagem = new Mensagem();
				int idMensagem = resultado.getInt("id_mensagem");
				String apelidoDestino = resultado.getString("fk_apelido_destinatario");
				String apelidoRemete = resultado.getString("fk_apelido_remetente");
				String texto = resultado.getString("texto");
				java.sql.Date dhEnvio = resultado.getDate("data_hora_envio");
				java.sql.Date dhVisualizacao = resultado.getDate("data_hora_visualizacao");
				String estadoVisualizacao = resultado.getString("estado_visualizacao");
				
				
				mensagem.setId(idMensagem);
				mensagem.setApelidoDestinatario(apelidoDestino);
				mensagem.setApelidoRemetente(apelidoRemete);
				mensagem.setTexto(texto);
				mensagem.setDhEnvio(mensagem.toGregorian(dhEnvio));
				mensagem.setDhVisualizacao(mensagem.toGregorian(dhVisualizacao));
				mensagem.setEstadoVisualizacao(estadoVisualizacao);
				
				return mensagem;
			}
		} catch (SQLException ex) {	
			//Imprimindo a pilha de erros
			ex.printStackTrace();
		}
		
		return null;
	}
	
}