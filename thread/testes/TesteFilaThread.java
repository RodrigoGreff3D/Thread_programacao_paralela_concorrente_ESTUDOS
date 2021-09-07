package br.cursojava.thread.testes;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import br.cursojava.thread.model.ObjetoFilaThread;

public class TesteFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha.add(objetoFilaThread);
	}

	@Override
	public void run() {

		Iterator iteracao = pilha.iterator();

		synchronized (iteracao) { //bloquear o acesso  a está lista por outro processo
			
			while (iteracao.hasNext()) { // enquanto conter dados na lista ira processar

				ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();

				/* Processando algo demorado */
				
				System.out.println("=================================");
				System.out.println(processar.getEmail());

				iteracao.remove();

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
