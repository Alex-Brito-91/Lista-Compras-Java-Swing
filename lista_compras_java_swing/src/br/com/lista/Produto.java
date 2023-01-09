package br.com.lista;

import java.math.BigDecimal;

public class Produto {

	private int id;
	private String nome;
	private int quant;
	private BigDecimal valorUn;
	private BigDecimal valorTotal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public BigDecimal getValorUn() {
		return valorUn;
	}

	public void setValorUn(BigDecimal valorUn) {
		this.valorUn = valorUn;
	}

	public BigDecimal getValorTotal() {
		return this.valorUn.multiply(BigDecimal.valueOf(this.quant));
	}

}
