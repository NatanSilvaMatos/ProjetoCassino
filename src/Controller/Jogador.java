package Controller;

import java.util.Random;

public class Jogador extends Thread {
	private static int ContadorVitorias;
	private int dado1, dado2, numeroThread, numeroVencedores;
	Random aleatorio = new Random();

	public Jogador(int numeroThread) {
		start();
		this.numeroThread = numeroThread;
	}

	public void run() {
		checaDados();
	}

	public void checaDados() {
		int pontoGanho = 0;
		do {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				System.err.println("Thread interrompida!");
			}
			dado1 = aleatorio.nextInt(6) + 1;
			dado2 = aleatorio.nextInt(6) + 1;
			if(dado1 + dado2 == 7 || dado1 + dado2 == 11) {
				pontoGanho++;
			}
		} while(pontoGanho != 5);
		ContadorVitorias++;
		if(ContadorVitorias < 4) {
			switch(ContadorVitorias) {
			case 1:
				System.out.println("Jogador #" + numeroThread + " ficou em primeiro e ganhou 5000 reais!");
				break;
			case 2:
				System.out.println("Jogador #" + numeroThread + " ficou em segundo e ganhou 4000 reais!");
				break;
			case 3:
				System.out.println("Jogador #" + numeroThread + " ficou em terceiro e ganhou 3000 reais!");
				break;
			}

		}

	}
}







