package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.Tarefa;
import modelos.Usuario;

/**
 * Classe DAO para uma Tarefa
 * 
 * @author Davi Fonseca
 * @version 1.0
 * @since 6.0 -> desde qual versão esta classe está no projeto
 *
 */

public class TarefaDao {
	
	private Connection conexao;
	
	public TarefaDao (Connection conexao) {
		this.conexao = conexao;
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Metodo de criacao de uma Tarefa
	 * @param tarefa
	 */
	public void cadastrarTarefa(Tarefa tarefa) {
		String inserir = "INSERT INTO Tarefa(id_tarefa, fk_id_projeto, fk_apelido_proprietario, estado, titulo, descricao)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		/**Objeto de execucao de comando SQL para **/
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setInt(1,	 tarefa.getIdTarefa());
			pst.setInt(2,	 tarefa.getIdProjeto());
			pst.setString(3, tarefa.getApelidoProprietario());
			pst.setString(4, tarefa.getEstado());
			pst.setString(5, tarefa.getTitulo());
			pst.setString(6, tarefa.getDescricao());
			
			
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
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
}
