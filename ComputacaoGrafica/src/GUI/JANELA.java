package GUI;

import javax.swing.JFrame;
import utils.Imagem;

public class JANELA {
	public void FRAME(Imagem r) {
		JFrame frame = new JFrame("Teste Multim�dia");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,1300,730);
		frame.add(r);
		frame.setVisible(true);
	}
}
