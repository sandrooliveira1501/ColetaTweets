package br.ufc.cpbr8.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "buscas")
public class Busca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String descricao;
	@Column(name="valor_busca")
	private String valorBusca;
	@Column(name = "data_criacao")
	private Date dataCriacao;
	@Column(name="tempo_busca")
	private long tempoBusca;
	private int quantidade;
	@Column(name="num_buscas")
	private int numBuscas;
	private boolean status;
	@OneToMany(mappedBy="busca")
	private List<Tweet> tweets;
	
	public Busca(){
		
	}
	
	public Busca(String descricao, String valorBusca) {
		this.descricao = descricao;
		this.valorBusca = valorBusca;
		this.status = true;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public int getNumBuscas() {
		return numBuscas;
	}

	public void setNumBuscas(int numBuscas) {
		this.numBuscas = numBuscas;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getValorBusca() {
		return valorBusca;
	}
	
	public void setValorBusca(String valorBusca) {
		this.valorBusca = valorBusca;
	}
		
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getTempoBusca() {
		return tempoBusca;
	}

	public void setTempoBusca(long tempoBusca) {
		this.tempoBusca = tempoBusca;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	
}
