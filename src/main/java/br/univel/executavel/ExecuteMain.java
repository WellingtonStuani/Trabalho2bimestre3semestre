package br.univel.executavel;

import java.awt.EventQueue;

import br.univel.paineis.TelaPrincipal;



public class ExecuteMain {
	
	public static void main(String[] args) {
		
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				TelaPrincipal frame = new TelaPrincipal();
				frame.setVisible(true);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

}
