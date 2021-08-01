package com.devtest.patientregister.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_token")
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String token;
	private Date validade;
	private Date expiration;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_enfermeiro")
	private Enfermeiro enfermeiro;
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_medico")
	private Medico medico;
	
	
	
	public Token() {
		
	}

	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public Date getValidade() {
		return validade;
	}



	public void setValidade(Date validade) {
		this.validade = validade;
	}



	public Date getExpiration() {
		return expiration;
	}



	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Enfermeiro getEnfermeiro() {
		return enfermeiro;
	}

	public void setEnfermeiro(Enfermeiro enfermeiro) {
		this.enfermeiro = enfermeiro;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Boolean expirado() {
		Date dataAtual = new Date();
		if (dataAtual.after(this.expiration)) {
			return true;
		}
		return false;
	}
}
