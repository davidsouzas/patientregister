package com.devtest.patientregister.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_paciente")
public class Patient {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cpf;
	private Date data_nasc;
	private Double peso;
	private Double altura;
	private String uf;
	
	public Patient() {
		
	}

	public Patient(String nome, String cpf, Date data_nasc, Double peso, Double altura, String uf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.data_nasc = data_nasc;
		this.peso = peso;
		this.altura = altura;
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
