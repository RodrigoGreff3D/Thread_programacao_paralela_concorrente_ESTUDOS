package br.cursojava.thread.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTempoThread extends JDialog {

	private JPanel jpanel = new JPanel(new GridBagLayout());/* Painel de componentes */

	private JLabel descricao = new JLabel("Tempo thread 1");
	private JTextField mostrarTempo = new JTextField();

	private JLabel descricao2 = new JLabel("Tempo thread 2");
	private JTextField mostrarTempo2 = new JTextField();

	private JButton jButtonStart = new JButton("Start");
	private JButton jButtonStop = new JButton("Stop	");

	private Runnable thread1 = new Runnable() {

		@Override
		public void run() {
			while (true) {
				mostrarTempo
						.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss")
						.format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	private Runnable thread2 = new Runnable() {

		@Override
		public void run() {
			while (true) {
				mostrarTempo2
						.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
						.format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	private Thread threadTime1;
	private Thread threadTime2;

	public TelaTempoThread() {
		setTitle("Tele de time com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();/* Controla posicionamento dos componentes */
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		descricao.setPreferredSize(new Dimension(200, 25));
		jpanel.add(descricao, gridBagConstraints);

		mostrarTempo.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		mostrarTempo.setEditable(false);
		jpanel.add(mostrarTempo, gridBagConstraints);

		descricao2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(descricao2, gridBagConstraints);

		mostrarTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		mostrarTempo2.setEditable(false);
		jpanel.add(mostrarTempo2, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;

		jButtonStart.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jpanel.add(jButtonStart, gridBagConstraints);

		jButtonStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jpanel.add(jButtonStop, gridBagConstraints);
		
		jButtonStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				threadTime1 = new Thread(thread1);
				threadTime1.start();
				
				threadTime2 = new Thread(thread2);
				threadTime2.start();
				
				
				
				
			}
		});
		
		jButtonStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				threadTime1.stop();
				threadTime2.stop();
				
				
			}
		});
		
		

		add(jpanel, BorderLayout.WEST);
		setVisible(true);/* Torna tela visível ao usuario */
	}
}
