package modelos;

import modelos.Usuario;

/**
 * Classe que representa uma tarefa dentro do projeto
 * 
 * @author Davi Fonseca
 * @version 3.0
 * @since 2.0 -> desde qual versão esta classe está no projeto
 *
 */

//<---------------------------------------------------------------------------------------------------------------------------->//

public class Tarefa {
	
	/**
	 * Atributo do tipo int para armazenar o id					 da Tarefa
	 */
	private int idTarefa;
	
	/**
	 * Atributo do tipo int para armazenar o id					 do Projeto que compreende a tarefa
	 */
	private int idProjeto;
	
	/**
	 * Atributo do tipo Usuario para armazenar o proprietario	 da Tarefa
	 */
	private Usuario proprietario;
	
	/**
	 * Atributo do tipo String para armazenar o estado			  da Tarefa
	 */
	private String estado;
	
	/**
	 * Atributo do tipo String para armazenar o titulo			  da Tarefa
	 */
	private String titulo;
	
	/**
	 *  Atributo do tipo String para armazenar a descricao		  da Tarefa
	 */
	private String descricao;
	
	/**
	 *  Atributo do tipo String para armazenar a prioridade		  da Tarefa
	 */
	private String prioridade;
	
	//<---------------------------------------------------------------------------------------------------------------------------->//

	/**
	 * Criacao de um construtor vazio:
	 */
	public Tarefa() {}
		
	//<---------------------------------------------------------------------------------------------------------------------------->//

	/**
	 * Criacao de um contrutor cheio
	 * @param idTarefa				Armazena o id da 		Tarefa
	 * @param idProjeto				Armazena o id do Porjeto que está tarefa pertence
	 * @param apelidoProprietario	Armazena o apelido do proprietario da Tarefa
	 * @param estado				Armazena o estado da 	Tarefa (do, to do, concluida)
	 * @param titulo				Armazena o titulo da 	Tarefa
	 * @param descricao				Armazena a descricao da Tarefa
	 */
	public Tarefa(int idTarefa, int idProjeto, Usuario proprietario, String estado, String titulo, String descricao, String prioridade) {	
		this.idTarefa = idTarefa;
		this.proprietario = proprietario;
		this.estado = estado;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criação de retornos de consulta	(get)
	 *
	 */
	
	/**
	 * Retorna o ID			da Tarefa
	 * @return	this.idTarefa
	 */
	public int getIdTarefa() {
		return this.idTarefa;
	}
	
	/**
	 * Retorna o ID			do Projeto que compreende a tarefa
	 * @return	this.idTarefa
	 */
	public int getIidProjeto() {
		return this.idProjeto;
	}
	
	/**
	 * Retorna o apelido do proprietario		da Tarefa
	 * @return	this.proprietario
	 */
	public Usuario getProprietario() {
		return this.proprietario;
	}
	
	/**
	 * Retorna o estado		da Tarefa
	 * @return	this.estado
	 */
	public String getEstado() {
		return this.estado;
	}
	
	/**
	 * Retorna o titulo		da Tarefa
	 * @return	this.titulo
	 */
	public String getTitulo() {
		return this.titulo;
	}
	
	/**
	 * Retorna o descricao 	da Tarefa
	 * @return	this.descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}
	
	/**
	 * Retorna o prioridade 	da Tarefa
	 * @return	this.prioridade
	 */
	public String getPrioridade() {
		return this.prioridade;
	}

	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Criação de metodos de alteracao	(set)
	 *
	 */
	
	/**
	 * Altera o ID da Tarefa
	 * @param idTarefa
	 */
	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}
	
	/**
	 * Altera o ID da Tarefa
	 * @param idTarefa
	 */
	public void setIidProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}
	
	/**
	 * Altera o Apelido do proprietario da Tarefa
	 * @param Proprietario
	 */
	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}
	
	/**
	 * Altera o estado da Tarefa
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * Altera o titulo da Tarefa
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Altera a descricao da Tarefa
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Altera a prioridade da Tarefa
	 * @param prioridade
	 */
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	
	//<---------------------------------------------------------------------------------------------------------------------------->//
	
	/**
	 * Sobescrevendo o metodo toString:
	 */
	@Override
	public String toString() {
		return "Tarefa{Id Tarefa:"			+ this.idTarefa
				+ ", Proprietario:{"		+ this.proprietario.toString()
				+ ", Estado:"				+ this.estado
				+ ", Titulo:"				+ this.titulo
			   +"}";
	}
	
}

	
	
	
	
