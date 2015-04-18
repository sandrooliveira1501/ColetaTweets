package br.ufc.cpbr8.model;

import java.io.Serializable;
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
public class Tweet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	
	public Busca getBusca() {
		return busca;
	}

	public void setBusca(Busca busca) {
		this.busca = busca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busca == null) ? 0 : busca.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((hashTags == null) ? 0 : hashTags.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((mencionados == null) ? 0 : mencionados.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		if (busca == null) {
			if (other.busca != null)
				return false;
		} else if (!busca.equals(other.busca))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (hashTags == null) {
			if (other.hashTags != null)
				return false;
		} else if (!hashTags.equals(other.hashTags))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		if (mencionados == null) {
			if (other.mencionados != null)
				return false;
		} else if (!mencionados.equals(other.mencionados))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}