package entities;

import java.util.ArrayList;
import java.util.List;

import exceptions.NotaInvalidaException;
import exceptions.PesoInvalidoException;

public class Aluno {

	private String nome;
	private List<Nota> notas = new ArrayList<>(3);
	
	public Aluno() {};
	
	public Aluno(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Nota> getNotas() {
		return notas;
	}
	
	public void addNota(Nota nota) throws PesoInvalidoException, NotaInvalidaException{
		notas.add(nota);
		if(notas.size() == 2) {
			calculaNotaFinal();
		}
	}

	private void calculaNotaFinal() throws PesoInvalidoException, NotaInvalidaException {
		double somaPeso = notas.stream()
				.mapToDouble(Nota::getPeso)
				.sum();
		if(!(somaPeso == 1.0)) {
			throw new PesoInvalidoException("a soma dos pesos é diferente de 1.0");
		}
		
		double somaNotas = 0;
		for(Nota nota: notas) {
			somaNotas += nota.getValor() * nota.getPeso();
		}

		notas.add(new Nota(somaNotas, somaPeso));
	}
	
	public void removeNota(double notaValor) throws NotaInvalidaException, PesoInvalidoException {                   
		notas.remove(new Nota(notaValor, 0.0));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Aluno: " + nome).append("\n");
		if(notas.size() == 0) {
			return sb.append("Nenhuma nota adicionada!").toString();
		}
		sb.append("nota 1: " + notas.get(0)).append("\n");
		if(notas.size() == 1) {
			return sb.toString();
		}
		sb.append("nota 2: " + notas.get(1)).append("\n");
		sb.append("nota final: " + notas.get(2)).append("\n\n");
		sb.append(notas.get(2).mensagem());
		return sb.toString(); 
	}
	
}
