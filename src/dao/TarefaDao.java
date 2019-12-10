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
 * @version 4.0
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
	public void cadastrarTarefa(Tarefa tarefa, int idProjeto) {
		String inserir = "INSERT INTO Tarefa(null, fk_id_projeto, fk_apelido_proprietario, estado, titulo, descricao)"
				+ "VALUES (null, ?, ?, ?, ?, ?)";
		
		/**Objeto de execucao de comando SQL para **/
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setInt(1,	 idProjeto);
			pst.setString(2, tarefa.getProprietario().getApelido());
			pst.setString(3, tarefa.getEstado());
			pst.setString(4, tarefa.getTitulo());
			pst.setString(5, tarefa.getDescricao());
			
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
	
	/**
	 * Metodos de consultas
	 * @param apelido
	 */
	public Tarefa consultarTarefa(int id) {
		
		/**
		 * Criando a String de consulta
		 */
		String consulta = "SELECT * FROM Tarefa WHERE id_tarefa = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(consulta)){
			
			pst.setInt(1, id);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			/*	Instanciando um objeto com valor nulo para preencimento com
			    base no retorno da consulta realizada.  */
			Tarefa tarefa = null;
			
			// Verifica se há um resultado para a consulta relizada.
			if (resultado.next()) {
				tarefa = new Tarefa();
				int idTarefa = resultado.getInt("id_tarefa");
				int idProjeto = resultado.getInt("fk_id_projeto"); // /!\ ---> Como vamos exibir as tarefas no lugar correto se não existir este atributo ?
				String apelidoProprietario = resultado.getString("fk_apelido_proprietario");
				String estado = resultado.getString("estado");
				String titulo = resultado.getString("titulo");
				String descricao = resultado.getString("descricao");
				
				UsuarioDao user = new UsuarioDao(conexao);
				
				tarefa.setIdTarefa(idTarefa);
				tarefa.setProprietario(user.consultarUsuario(apelidoProprietario));
				tarefa.setEstado(estado);
				tarefa.setTitulo(titulo);
				tarefa.setDescricao(descricao);
				
				return tarefa;
				
			}
			
		} catch (SQLException ex){
			
			/**
			 * Tratando as excessoes
			 */
			ex.printStackTrace();
			
		}
		
		return null;
		
	}
}
