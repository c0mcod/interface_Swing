package primeiroTeste;
import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MinhaJanela {

	public static void main(String[] args) {
		JFrame janela = new JFrame();
		janela.setSize(500,200);
		janela.setTitle("TESTE MINHA JANELA");
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		
		JTextField campoDeTexto = new JTextField(20);
		JButton btn = new JButton("Buscar");
		janela.setLayout(new FlowLayout());
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn, "nome digitado: " + campoDeTexto.getText());
				
			}
		});
		
		janela.add(campoDeTexto);
		janela.add(btn);
		
		janela.setVisible(true);
		
	}

}
