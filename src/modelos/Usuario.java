package modelos;

//import java.awt.Image;
//import java.awt.image.BufferedImage;


import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Usuario {
	
	private String nome;
	private String email;
	private String telefone;
	private String apelido;
	private String senha;
	private BufferedImage imagem = ImageIO.read(new File("imagem.extensao"));
	
	public Usuario () {}
	
	/**
	 * Criacao do contrutor cheio:
	 * @param nome - Armazena o nome do usuario
	 * @param email - Armazena o e-mail do usuario
	 * @param telefone - Armazena o telefone do usuario
	 * @param apelido - Armazena o apelido do usuario
	 * @param senha - Armazena a senha do usuario
	 * @param foto - Armazena a foto do usuario
	 */
	public Usuario (String nome, String email, String telefone, String apelido, String senha, Image foto) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.apelido = apelido;
		this.senha = senha;
		this.foto = foto;
	}


	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getApelido() {
		return this.apelido;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public Image getFoto() {
		return this.foto;
	}

	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setFoto(Image foto) {
		this.foto = foto;
	}
	
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
