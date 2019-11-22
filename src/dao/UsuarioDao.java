package dao;

import modelos.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe DAO para o usuario
 * 
 * @author Davi Fonseca
 * @version 4.0
 * @since 1.0 -> desde qual vers�o esta classe est� no projeto
 *
 */

public class UsuarioDao {
	
	private Connection conexao;
	
	public UsuarioDao (Connection conexao) {
		this.conexao = conexao;
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Metodo de criacao
	 * @param usuario
	 */
	
	public void cadastrarUsuario(Usuario usuario) {
		String inserir = "INSERT INTO Usuario(nome,email,telefone,apelido,senha,foto)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		/**Objeto de execucao de comando SQL para **/
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setString(1,usuario.getNome());
			pst.setString(2,usuario.getEmail());
			pst.setString(3,usuario.getTelefone());
			pst.setString(4,usuario.getApelido());
			pst.setString(5,usuario.getSenha());
			//pst.setImage(6,usuario.getFoto()); // /!\ --------------------------------------------> Verificar como fazer isso.
			
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
	 * Metodo para altera��o de imagem:
	 * @param foto
	 */
	
	public void armazenarImagens(File foto, String apelido) {
			
		//Preparando a String para insecao:
		String inserir = "Update Usuario SET foto ="
				+ "? WHERE apelido = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			//criando fluxo de manipulacao de arquivo
			FileInputStream inputStream = new FileInputStream(foto);
			
			pst.setBinaryStream(1, ///posi��o do Sql
					(InputStream) inputStream, //Fluxo de informacao
					(int) (foto.length()) //Quantidade de bytes
					);
			pst.setString(2, apelido);
			
			//Enviando um comando para o MySQL
			pst.execute();
			
		} catch (Exception e) {
			//Imprimido a pilha de erros:
			e.printStackTrace();
		}
			
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Metodos de consultas
	 * @param apelido
	 * @return apelido do Usuario
	 */
	
	
	public Usuario consultarUsuario(String apelido) {
		
		/**
		 * Criando a String de consulta
		 */
		
		String consulta = "SELECT * FROM Usuario WHERE apelido = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
			
			pst.setString(1, apelido);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
			/**
			 *---------------------- Perguntar ao professor o motivo desta instancia  ------------------------------------
			 */
			Usuario usuario = null;
			
			if (resultado.next()) {
				usuario = new Usuario();
				String nome = resultado.getString("nome");
				String email = resultado.getString("email");
				String telefone = resultado.getString("telefone");
				String apelidoUsuario = resultado.getString("apelido");
				String senha = resultado.getString("senha");
				//File foto = resultado.getFile("foto"); // /!\ --------------------------------------------> Verificar como fazer isso. seria um int ?
				
				usuario.setApelido(apelidoUsuario);
				usuario.setNome(nome);
				usuario.setEmail(email);
				usuario.setTelefone(telefone);
				usuario.setSenha(senha);
				//usuario.setFoto(foto); // /!\ --------------------------------------------> Verificar como fazer isso.
				
				
				return usuario;
				
			}
			
		} catch (SQLException ex) {
			//Imprimindo a pilha de erros
			ex.printStackTrace();
		}
		
		return null;
		
	}
		
}
