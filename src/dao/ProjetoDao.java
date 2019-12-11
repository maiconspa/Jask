package dao;

import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Projeto;
import modelos.Usuario;

/**
 * Classe DAO para o Projeto
 * 
 * @author Henrique Cayoni
 *
 */



public class ProjetoDao {

	private Connection conexao;
	
	public ProjetoDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	
	/**
	 * Método de criação de um projeto
	 *@param projeto
	 * 
	 */
	
	public void cadastrarProjeto(Projeto projeto) {
	
		String inserir = "INSERT INTO Projeto(nomeProjeto, apelidoProprietario)"
				+ "VALUES (?, ?)";
		
		/*Objeto de execucao de comando SQL para */
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setString(1,	projeto.getNomeProjeto());
			pst.setString(2,	projeto.getProprietario().getApelido());
			
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
	 * @param idProjeto
	 */
	
	public Projeto consultarProjeto(int idProjeto) {
		
		/**
		 * Criando a String de consulta
		 */
		
		String consulta = "SELECT * FROM Projeto WHERE id_projeto = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
			
			pst.setInt(1, idProjeto);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			/**
			 * 	Instanciando um objeto com valor nulo para preencimento com
			 *  base no retorno da consulta realizada.
			 */
			Projeto projeto = null;
			
			UsuarioDao userDao =  new UsuarioDao(Conexao.conectar());
			
			if (resultado.next()) {
				projeto = new Projeto();
				int id = resultado.getInt("id_projeto");
				String nome = resultado.getString("nome");
				Usuario proprietario = userDao.consultarUsuario(resultado.getString("fk_apelido_proprietario"));
				
				projeto.setIdProjeto(id);
				projeto.setNomeProjeto(nome);
				projeto.setProprietario(proprietario);
			
				return projeto;
		}
		
	} catch(SQLException ex) {
		
		/**
		 * Tratando as excessoes
		 */
		ex.printStackTrace();
		
	}
		
		return null;
	
	}

	public ArrayList<Usuario> colecaoUsuarios(int idProjeto) {
		
		String consulta = "SELECT * FROM Item_usuario_projeto WHERE id_projeto = ? ";
		
		try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
			
			pst.setInt(1, idProjeto);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			/**
			 * 	Instanciando um objeto com valor nulo para preencimento com
			 *  base no retorno da consulta realizada.
			 */
			Projeto projeto = null;
			
			UsuarioDao userDao =  new UsuarioDao(Conexao.conectar());
			ArrayList<Usuario> colecao = new ArrayList<Usuario>();
			
			
		while (resultado.next()){
			resultado.getString("fk_apelido_usuario");
			Usuario participante = userDao.consultarUsuario(resultado.getString("fk_apelido_proprietario"));
			colecao.add(participante);
		}
		
		return colecao;
		
		} catch(SQLException ex) {
			//Imprimindo a pilha de erros
			ex.printStackTrace();
		}
		
		return null;
	}
	
	//<-------------------------------------------------------------------------->//
	
	/**
	* Método para listar os projetos
	* @param titulo
	* @author Davi
	* @throws SQLException
	*/
	public ArrayList<Projeto> listarProjeto(String nome) throws Exception {
		
		String select = "SELECT nome, id_projeto FROM Projeto";
		
		ArrayList<Projeto> colecaProjeto = new ArrayList<>();
		
		PreparedStatement pst = Conexao.conectar().prepareStatement(select);
		ResultSet resultado = pst.executeQuery();
		
		while(resultado.next()) {
			
			Projeto projeto = new Projeto();
			projeto.setNomeProjeto(resultado.getString("nome"));
			projeto.setIdProjeto(resultado.getInt("id_projeto"));
			
			colecaProjeto.add(projeto);
		}
		
		return colecaProjeto;
	}
	
	
	
	//<-------------------------------------------------------------------------->//
	
	/**
	* Método para alterar o projeto
	* @param nome and idProjeto
	* @author Cayoni
	* @throws SQLException
	*/
	public void atualizarProjeto(String nome, int idProjeto) throws SQLException {
				
		/**
		* Criando a String de atualização
		*/
		String atualizar = "UPDATE Projeto SET nome = ? WHERE id_projeto = ?";
				
		try (PreparedStatement pst = conexao.prepareStatement(atualizar)) {
					
			pst.setString(1, nome);
			pst.setInt(2, idProjeto);					
					
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
					
		}
				
	}
	
	//<-------------------------------------------------------------------------->//
	
	/**
	 * Método para deletar o projeto
	 * @author Cayoni
	 * @param idProjeto
	 */
	public void deletarProjeto(int idProjeto) {
		
		//Preparando a String para atualização:
		String deletar = "DELETE FROM Projeto where id_projeto = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(deletar)) {
			
			pst.setInt(1, idProjeto);
			
			//Enviando um comando para o MySQL
			pst.execute();
			
		} catch (Exception e) {
			//Imprimido a pilha de erros:
			e.printStackTrace();
		}
		
	}

}