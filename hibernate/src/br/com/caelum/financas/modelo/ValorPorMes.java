package br.com.caelum.financas.modelo;

import java.math.BigDecimal;

public class ValorPorMes {
	private int mes;
	private BigDecimal valor;
		
	public ValorPorMes(int mes, BigDecimal valor) {
		this.mes = mes;
		this.valor = valor;
	}
	public int getMes() {
		return mes;
	}
	public BigDecimal getValor() {
		return valor;
	}
	
}
