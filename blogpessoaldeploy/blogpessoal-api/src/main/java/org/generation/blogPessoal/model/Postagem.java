package org.generation.blogPessoal.model;

import java.util.Date;   //p passar a data

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

//parametros passados por cima da classe para definir tipos de comportamento

@Entity	//esse parametro indica que essa classe sera um entidade do JPA hibernate					
@Table(name = "Postagem") //esse parametro avisa que essa entidade vai virar uma tabela dentro do banco de dados, com nome POSTAGEM.

public class Postagem {
	
	@Id //avisando que o ID daqui e um ID na tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) //avisando que esse ID e uma chave primaria na tabela, definindo auto increment
	private long id;
	
	@NotNull  //avisando que nao pode conter titulo vazio.
	private String titulo;
	
	@NotNull  //avisando que nao pode conter titulo vazio.
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP) //qual tipo de tempo.
	private Date date = new java.sql.Date(System.currentTimeMillis()); //pegar a data exatamente no dia e hora que foi criado
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
