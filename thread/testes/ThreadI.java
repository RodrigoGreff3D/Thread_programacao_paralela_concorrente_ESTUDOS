package br.cursojava.thread.testes;

import javax.swing.JOptionPane;

public class ThreadI {

	public static void main(String[] args) throws InterruptedException {

		Thread theadEmail = new Thread(thread1);
		theadEmail.start();

		JOptionPane.showInputDialog(null, "Sistema continua executando pra o usuario");

		Thread theadNota = new Thread(thread2);
		theadNota.start();

		JOptionPane.showInputDialog(null, "Sistema continua executando pra o usuario");

	}

	private static Runnable thread1 = new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("Rotina qualquer");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	private static Runnable thread2 = new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("Rotina qualquer 2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
}
