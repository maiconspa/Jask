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
		String inserir = "INSERT INTO Tarefa()"
				+ "VALUES (?)";
		
		/**Objeto de execucao de comando SQL para **/
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setString(1,"! Alguma coisa aqui!");
			
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
