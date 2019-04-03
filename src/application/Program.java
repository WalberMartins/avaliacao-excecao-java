package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Aluno;
import entities.Nota;
import exceptions.NotaInvalidaException;
import exceptions.PesoInvalidoException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o nome do aluno: ");
		String nome = sc.nextLine();
		Aluno aluno = new Aluno(nome);
		
		for(int i = 1; i <= 2; i++) {
			try {
				System.out.println();
				System.out.println(i+"°"+" BIMESTRE");
				System.out.print("Digite a nota: ");
				double nota = sc.nextDouble();
				System.out.print("Digite o peso do Bimestre: ");
				double peso = sc.nextDouble();
				aluno.addNota(new Nota(nota, peso));
				
			}
			catch(InputMismatchException e) {
				System.out.println("Erro na leitura do valor, tente novamente: ");
				i--;
				sc.nextLine();
			}
			catch(NotaInvalidaException | PesoInvalidoException e) {
				System.out.println(e.getMessage() + ", tente novamente: ");
				i--;
			}
			
		}
		System.out.println();
		System.out.println(aluno);
		
		sc.close();
	}
	
}
