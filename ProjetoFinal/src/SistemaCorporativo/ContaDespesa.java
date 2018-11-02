package SistemaCorporativo;

import java.util.ArrayList;

public class ContaDespesa {
	
	private int despesaId;
	private String despesaData;
	private double despesaValor;
	private String despesaDescricao;
	private int contaId;
	private int categoria;
	
	public ContaDespesa(String data, double valor, String descricao, int categoria) {
		this.despesaData = data;
		this.despesaValor = valor;
		this.despesaDescricao = descricao;
		this.categoria = categoria;
	}
	public ContaDespesa() {
		
	}
	
	public int getDespesaId() {
		return despesaId;
	}
	public void setDespesaId(int despesaId) {
		this.despesaId = despesaId;
	}
	public String getDespesaData() {
		return despesaData;
	}
	public void setDespesaData(String despesaData) {
		this.despesaData = despesaData;
	}
	public double getDespesaValor() {
		return despesaValor;
	}
	public void setDespesaValor(double despesaValor) {
		this.despesaValor = despesaValor;
	}
	public String getDespesaDescricao() {
		return despesaDescricao;
	}
	public void setDespesaDescricao(String despesaDescricao) {
		this.despesaDescricao = despesaDescricao;
	}
	public int getContaId() {
		return contaId;
	}
	public void setContaId(int contaId) {
		this.contaId = contaId;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
}
