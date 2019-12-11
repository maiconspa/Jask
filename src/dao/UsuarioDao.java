package dao;

import modelos.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * Classe DAO para o usuario
 * 
 * @author Davi Fonseca
 * @version 5.0
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
		String inserir = "INSERT INTO Usuario(nome,email,telefone,apelido,senha)"
				+ "VALUES (?, ?, ?, ?, ?)";
		
		/**Objeto de execucao de comando SQL para **/
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			
			pst.setString(1,usuario.getNome());
			pst.setString(2,usuario.getEmail());
			pst.setString(3,usuario.getTelefone());
			pst.setString(4,usuario.getApelido());
			pst.setString(5,usuario.getSenha());
			
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
	
	//<----------------------------------------------------------------------->//
		/**
		 * Metodos de consultas
		 * @param apelido
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
				 * // /!\ ---------------------- Perguntar ao professor o motivo desta instancia  ------------------------------------
				 */
				Usuario usuario = null;
				
				if (resultado.next()) {
					usuario = new Usuario();
					String nome = resultado.getString("nome");
					String email = resultado.getString("email");
					String telefone = resultado.getString("telefone");
					String apelidoUsuario = resultado.getString("apelido");
					String senha = resultado.getString("senha");
					File foto = recuperarImagem(apelido);
					
					usuario.setApelido(apelidoUsuario);
					usuario.setNome(nome);
					usuario.setEmail(email);
					usuario.setTelefone(telefone);
					usuario.setSenha(senha);
					usuario.setFoto(foto); 
					
					
					return usuario;
					
				}
				
			} catch (SQLException ex) {
				//Imprimindo a pilha de erros
				ex.printStackTrace();
			}
			
			return null;
			
		}
		
		//<----------------------------------------------------------------------->//
	
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
	
	//<----------------------------------------------------------------------->//
	
	/**
	 * M�todo para recuperar imagem do banco de dados de acordo com o apelido.
	 * @param usuario
	 */
	public File recuperarImagem(String apelido) {
		//
        // Criando o SQL de consulta:
		String selectImg = "select foto from Usuario where apelido = ?";
		PreparedStatement pst = null; // inicializa��o
		// Pegar uma conex�o com o banco de dados:
		this.conexao = Conexao.conectar();
		
		try {
			
			pst = conexao.prepareStatement(selectImg);
			pst.setString(1, apelido);
			
			ResultSet resultado = pst.executeQuery();
			// Arquivo onde a imagem ser� armazenada no disco:
			File file = new File(apelido +".jpg");
			// Objeto para tratar sa�da de dados para um arquivo:
			FileOutputStream output = new FileOutputStream(file);
			
			// Verificando se encontrou registro para o select:
			if (resultado.next()) {
				// Pegando o campo do tipo blob, chamado "foto":
				InputStream input = resultado.getBinaryStream("foto");
				// Preparando um vetor de bytes para enviar para o arquivo:
		        byte[] buffer = new byte[1024];
		        // Enquanto existir conte�do no fluxo de dados, continua:
		        while (input.read(buffer) > 0) {
		        	// Escreve o conte�do no arquivo de destino no disco:
		            output.write(buffer);
		        }
				// Fechando a entrada:
		        input.close();
			}
			// Encerra a sa�da:
			output.close();
			resultado.close();
			return file;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * M�todo para atualizar a classe no banco
	 * @param usuario
	 * @throws SQLException 
	 */
	public void atualizarUsuario(String apelido) throws SQLException {
		
		/**
		 * Criando a String de atualiza��o
		 */
		String atualizar = "UPDATE Usuario WHERE apelido = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(atualizar)) {
			
			pst.setString(1, apelido);
			
			//quando precisa de retorno do banco "ResultSet"//
			ResultSet resultado = pst.executeQuery();
			
		}
	}
	
	public void imagemRandomica() {
		
		UsuarioDao userDao = new UsuarioDao(Conexao.conectar());
		Usuario resultado = userDao.consultarUsuario("Bike");
		
		//inst�ncia um objeto da classe Random usando o construtor padr�o
        Random gerador = new Random();
        
        gerador.nextInt(3);
        String numero = ""+gerador;

		armazenarImagens(new File("imgDefault/default" +numero +".png"), resultado.getApelido());
	}
		
}
	