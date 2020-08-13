package org.generation.blogPessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id //avisando que e um Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // avisando que e uma chave primaria
	private long id;
	
	@NotNull // nao pode ser vazio
	private String nome;
	
	@NotNull
	private String usuario;
	
	
	@NotNull
	private String senha;
	
	
	//metodos especiais
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
