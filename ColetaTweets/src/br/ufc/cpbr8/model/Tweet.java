package br.ufc.cpbr8.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tweets")
public class Tweet {
	
	@Id
	private long id;
	private String texto;
	@ElementCollection
	@CollectionTable (name = "mencionados_tweets", joinColumns = @JoinColumn(name = "tweet_id"))
	@Column (name="mencionado")
	private Collection<String> mencionados;
	@ElementCollection
	@CollectionTable (name="hash_tags_tweets", joinColumns = @JoinColumn(name = "tweet_id"))
	@Column (name="hash_tag")
	private Collection<String> hashTags;
	private Date data;
	private double latitude;
	private double longitude;
	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="busca_id")
	private Busca busca;
	
	public Tweet(){
		
	}
	
	public Tweet(long id, String texto, Collection<String> mencionados,
			Collection<String> hashTags, Date data, double latitude,
			double longitude, Usuario usuario) {
		super();
		this.id = id;
		this.texto = texto;
		this.mencionados = mencionados;
		this.hashTags = hashTags;
		this.data = data;
		this.latitude = latitude;
		this.longitude = longitude;
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Collection<String> getMencionados() {
		return mencionados;
	}

	public void setMencionados(Collection<String> mencionados) {
		this.mencionados = mencionados;
	}

	public Collection<String> getHashTags() {
		return hashTags;
	}


	public void setHashTags(Collection<String> hashTags) {
		this.hashTags = hashTags;
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}