package br.com.teste.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contatos", schema = "dbo")
public class Contato extends AbstractModel<Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	
	private Integer idade;
	
	private String endereco;
	
	private String cpf;
	
	@Column(name = "imagem", columnDefinition = "image")
	private byte[] imagem;
	
	@Column(name = "image64", columnDefinition = "ntext")
	private String image64;

	private String nomeImagem;
	
	private Long tamanhoImagem;
	
	private String tipoImagem;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public Long getTamanhoImagem() {
		return tamanhoImagem;
	}

	public void setTamanhoImagem(Long tamanhoImagem) {
		this.tamanhoImagem = tamanhoImagem;
	}

	public String getTipoImagem() {
		return tipoImagem;
	}

	public void setTipoImagem(String tipoImagem) {
		this.tipoImagem = tipoImagem;
	}

	public String getImage64() {
		return image64;
	}

	public void setImage64(String image64) {
		this.image64 = image64;
	}
	
}
