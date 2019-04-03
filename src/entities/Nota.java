package entities;

import entities.enums.Mencao;
import exceptions.NotaInvalidaException;
import exceptions.PesoInvalidoException;

public class Nota {
	
	private double valor;
	private Mencao mencao;
	private double peso;
	
	public Nota(double valor, double peso) throws NotaInvalidaException, PesoInvalidoException {
		if(!(valor >= 0 && valor <= 10)) {
			throw new NotaInvalidaException("Valores válidos para nota são de a 0.0 a 10.0");
		}
		this.valor = valor;
		
		if(!(peso >= 0 && peso <= 1)) {
			throw new PesoInvalidoException("Peso válido é entre 0 e 1");
		}
		this.peso = peso;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) throws NotaInvalidaException {
		if(!(valor >= 0 && valor <= 10)) {
			throw new NotaInvalidaException("Valores válidos são de a 0.0 a 10.0");
		}
		this.valor = valor;
	}

	public Mencao getMencao() {
		setMencao();
		return mencao;
	}

	private void setMencao() {
		if(valor == 0.0) {
			mencao = Mencao.SR;
		}
		else if(valor > 0.0 && valor < 3.0) {
			mencao = Mencao.E;
		}
		else if(valor < 5.0) {
			mencao = Mencao.D;
		}
		else if(valor < 7.0) {
			mencao = Mencao.C;
		}
		else if(valor < 9.0) {
			mencao = Mencao.B;
		}
		else {
			mencao = Mencao.A;
		}
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) throws PesoInvalidoException {
		if(!(peso >= 0 && peso <= 1)) {
			throw new PesoInvalidoException("Peso válido é de 0.0 a 1.0");
		}
		this.peso = peso;
	}
	
	public String mensagem() {
		return valor < 5 ? "Infelizmente você não logrou êxito!": "Parabéns você foi aprovado!";
	}
	
	@Override
	public String toString() {
		setMencao();
		return String.format("%.2f", valor) + " menção: " + mencao;
	}
	
}
