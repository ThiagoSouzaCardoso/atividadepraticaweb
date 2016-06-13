package br.com.amigosecreto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 2927146768339266249L;

	private String nome;
	private String cpf;
	private Date data;
	private Usuario amigosSorteado;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getAmigosSorteado() {
		return amigosSorteado;
	}

	public void setAmigosSorteado(Usuario amigosSorteado) {
		this.amigosSorteado = amigosSorteado;
	}

}
