package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.*;
import utils.EstadoTarefa;

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
		String inserir = "INSERT INTO Tarefa(id_tarefa, fk_id_projeto, fk_apelido_proprietario, estado, titulo, descricao, prioridade)"
				+ "VALUES (null, ?, ?, ?, ?, ?, ?)";
		
		/*Objeto de execucao de comando SQL para */
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setInt(1,	 idProjeto);
			pst.setString(2, tarefa.getProprietario().getApelido());
			pst.setInt(3, tarefa.getEstado().estadoTarefa);
			pst.setString(4, tarefa.getTitulo());
			pst.setString(5, tarefa.getDescricao());
			pst.setInt(6, tarefa.getPrioridade().nivelPrioridade);
			
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
				int estado = resultado.getInt("estado");
				String titulo = resultado.getString("titulo");
				String descricao = resultado.getString("descricao");
				
				UsuarioDao user = new UsuarioDao(conexao);
				
				if (estado == 1) {
					tarefa.setEstado(EstadoTarefa.Pendente);
				}
				if (estado == 2) {
					tarefa.setEstado(EstadoTarefa.Realizando);
				}
				if (estado == 3) {
					tarefa.setEstado(EstadoTarefa.Finalizado);
				}
				
				
				tarefa.setIdTarefa(idTarefa);
				tarefa.setProprietario(user.consultarUsuario(apelidoProprietario));
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
	
	//<---------------------------------------------------------------------------------------------------------------------------->//

	/**
	* Método para alterar a tarefa
	* @param titulo
	* @author Cayoni
	* @throws SQLException
	*/
	public void atualizarTarefa(String estado, String titulo, String descricao, int prioridade, String apelido) throws SQLException {
				
		/**
		* Criando a String de atualização
		*/
		String atualizar = "UPDATE Tarefa SET estado = ?, titulo = ?, descricao = ?, prioridade = ? WHERE apelido = ?";
				
		try (PreparedStatement pst = conexao.prepareStatement(atualizar)) {
					
			pst.setString(1, estado);
			pst.setString(2, titulo);
			pst.setString(3, descricao);
			pst.setInt(4, prioridade);
			pst.setString(5, apelido);
					
					
					
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
					
		}
				
	}
		
	//<---------------------------------------------------------------------------------------------------------------------------->//
		
	/**
	 * Método de deletar tarefa
	 * @param id
	 * @author Cayoni
	 * @throws MySQLException
	 */
	public void deletarTarefa(int id) {
			
		//Preparando a String para deletar:
		String deletar = "DELETE FROM Tarefa where id_tarefa = ?";
				
		try (PreparedStatement pst = conexao.prepareStatement(deletar)) {
						
			// /!\ Verificar como pegar o getIdTarefa() e atribuir ao int id do método
			pst.setInt(1, id);
						
			//Enviando um comando para o MySQL
			pst.execute();
					
		} catch (Exception e) {
				//Imprimido a pilha de erros:
				e.printStackTrace();
		}
	}
	
	
	
	
	//listar TAREFAS
	public ArrayList<Tarefa> listarTarefas() throws Exception {
		System.out.println("TO NO METODO DE LISTAR");
		String select = "SELECT titulo, id_tarefa FROM Tarefa";
		
		ArrayList<Tarefa> colecaoTarefa = new ArrayList<>();
		
		PreparedStatement pst = Conexao.conectar().prepareStatement(select);
		ResultSet resultado = pst.executeQuery();
		
		while(resultado.next()) {
			
			Tarefa tarefa = new Tarefa();
			tarefa.setTitulo((resultado.getString("titulo")));
			tarefa.setIdTarefa(resultado.getInt("id_tarefa"));
			
			colecaoTarefa.add(tarefa);
		}
		
		return colecaoTarefa;
	}
	
	
}