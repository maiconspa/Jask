package modelos;

import java.io.*;

	/**
	 * Classe que representa um usuario dentro do projeto
	 * 
	 * @author Davi Fonseca
	 * @version 2.0
	 * @since 1.0 -> desde qual versão esta classe está no projeto
	 *
	 */

public class Usuario {
	
	/**
	 * Atributo do tipo String para armazenar o nome		do Usuario
	 */
	private String nome;
	
	/**
	 * Atributo do tipo String para armazenar o e-mail		do Usuario
	 */
	private String email;
	
	/**
	 * Atributo do tipo String para armazenar o telefone	do Usuario
	 */
	private String telefone;
	
	/**
	 * Atributo do tipo String para armazenar o apelido		do Usuario, primarykey
	 */
	private String apelido;
	
	/**
	 * Atributo do tipo String para armazenar a senha		do Usuario
	 */
	private String senha;
	
	/**
	 * Atributo do tipo ??? para armazenar a foto			do Usuario
	 */
	private File foto; // /!\ --------------------------------------------> Verificar como fazer isso.
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criacao de um construtor vazio:
	 */
	public Usuario () {}
	
	/**
	 * Criacao do contrutor cheio:
	 * 
	 * @param nome		Armazena o nome		do Usuario
	 * @param email		Armazena o e-mail	do Usuario
	 * @param telefone	Armazena o telefone do Usuario
	 * @param apelido	Armazena o apelido	do Usuario
	 * @param senha		Armazena a senha	do Usuario
	 * @param foto		Armazena a foto		do Usuario
	 */
	public Usuario (String nome, String email, String telefone, String apelido, String senha) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.apelido = apelido;
		this.senha = senha;
		//this.foto = foto; // /!\ --------------------------------------------> Verificar como fazer isso.
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criação de retornos de consulta	(get)
	 *
	 */
	
	/**
	 * Retorna o nome do Usuario
	 * @return	 this.nome
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o email do Usuario
	 * @return	this.email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Retorna o telefone do Usuario
	 * @return	this.telefone
	 */
	public String getTelefone() {
		return this.telefone;
	}
	
	/**
	 * Retorna o apelido do Usuario
	 * @return	this.apelido
	 */
	public String getApelido() {
		return this.apelido;
	}
	
	/**
	 * Retorna a senha do Usuario
	 * @return	this.senha
	 */
	public String getSenha() {
		return this.senha;
	}
	
	/**
	 * Retorna a foto do Usuario
	 * @return	this.foto
	 */
	public File getFoto() {
		return this.foto;
	} // /!\ --------------------------------------------> Verificar como fazer isso.

	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criacao de metodos de alteracao	(set)
	 * 
	 */
	
	/**
	 * Altera o nome do Usuario
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Altera o email do Usuario
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Altera o telefone do Usuario
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * Altera o apelido do Usuario
	 * @param apelido
	 */
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	/**
	 * Altera a senha do Usuario
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Altera a foto do Usuario
	 * @param foto
	 */
	public void setFoto(File foto) {
		this.foto = foto;
	} // /!\ --------------------------------------------> Verificar como fazer isso.
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Sobescrevendo o metodo toString:
	 */
	@Override
	public String toString() {
		return "Usuario{Nome: "+this.nome
			   +", E-mail: "+this.email
			   +", Telefone: "+this.telefone
			   +", Apelido: "+this.apelido
			   +", Senha: "+this.senha
			   +", Foto: "+this.foto
			   +"}";
	}
	
	
}
