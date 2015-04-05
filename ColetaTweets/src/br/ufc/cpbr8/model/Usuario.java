package br.ufc.cpbr8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	private long id;
	private String nome;
	@Column(name="user_name")
	private String userName;
	private String localizacao;
	
	public Usuario(){
		
	}
	
	public Usuario(long id, String nome, String userName, String localizacao) {
		this.id = id;
		this.nome = nome;
		this.userName = userName;
		this.localizacao = localizacao;
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
}
