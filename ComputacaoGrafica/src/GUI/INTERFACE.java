package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import METRICS.Aritmetica;
import METRICS.Geometricas;
import METRICS.Logicas;
import pontuais.Pontuais;
import utils.Imagem;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

public class INTERFACE extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TXTimagem1;
	private JTextField TXTimagem2;
	Imagem A = null;
	Imagem B = null;
	Imagem r = null;
	JANELA window = new JANELA();
	private JFormattedTextField TXTcordX;
	private JFormattedTextField TXTcordY;
	private JFormattedTextField TXTcor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INTERFACE frame = new INTERFACE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public INTERFACE() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 5, 615, 466);
		panel.setBackground(SystemColor.desktop);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Coordenada X:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(124, 73, 80, 14);
		panel.add(lblNewLabel);
		
		TXTimagem1 = new JTextField();
		TXTimagem1.setBackground(Color.YELLOW);
		TXTimagem1.setText("Imagem 1");
		TXTimagem1.setBounds(139, 11, 300, 20);
		panel.add(TXTimagem1);
		TXTimagem1.setColumns(10);
		
		JButton BTNbuscaA = new JButton("Buscar");
		BTNbuscaA.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		BTNbuscaA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser searchA = new JFileChooser();
				searchA.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int x = searchA.showSaveDialog(null);
				if(x == 1) {
					TXTimagem1.setText("");
				}
				else {
					File A = searchA.getSelectedFile();
					TXTimagem1.setText(A.getPath());
				}
			}
		});
		BTNbuscaA.setBounds(449, 10, 89, 23);
		panel.add(BTNbuscaA);
		
		JButton BTNsoma = new JButton("Soma");
		BTNsoma.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNsoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					B = new Imagem(new File(TXTimagem2.getText()));
					r = Aritmetica.soma(A,B);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNsoma.setBounds(44, 129, 116, 56);
		panel.add(BTNsoma);
		
		JButton BTNsubtracao = new JButton("Subtra\u00E7\u00E3o");
		BTNsubtracao.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNsubtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					B = new Imagem(new File(TXTimagem2.getText()));
					r = Aritmetica.subtracao(A,B);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNsubtracao.setBounds(170, 129, 116, 56);
		panel.add(BTNsubtracao);
		
		JButton BTNmultiplicacao = new JButton("Multiplica\u00E7\u00E3o");
		BTNmultiplicacao.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNmultiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					B = new Imagem(new File(TXTimagem2.getText()));
					r = Aritmetica.multiplicacao(A,B);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNmultiplicacao.setBounds(44, 196, 116, 56);
		panel.add(BTNmultiplicacao);
		
		JButton BTNdivisao = new JButton("Divis\u00E3o");
		BTNdivisao.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNdivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					B = new Imagem(new File(TXTimagem2.getText()));
					r = Aritmetica.divisao(A,B);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNdivisao.setBounds(170, 196, 116, 56);
		panel.add(BTNdivisao);
		
		JButton BTNand = new JButton("AND");
		BTNand.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					B = new Imagem(new File(TXTimagem2.getText()));
					r = Logicas.and(A,B);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNand.setBounds(323, 129, 116, 56);
		panel.add(BTNand);
		
		JButton BTNor = new JButton("OR");
		BTNor.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					B = new Imagem(new File(TXTimagem2.getText()));
					r = Logicas.or(A,B);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNor.setBounds(323, 196, 116, 56);
		panel.add(BTNor);
		
		JButton BTNnot = new JButton("NOT");
		BTNnot.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNnot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					r = Logicas.not(A);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNnot.setBounds(449, 129, 116, 56);
		panel.add(BTNnot);
		
		JButton BTNxor = new JButton("XOR");
		BTNxor.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNxor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					B = new Imagem(new File(TXTimagem2.getText()));
					r = Logicas.xor(A,B);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNxor.setBounds(449, 196, 116, 56);
		panel.add(BTNxor);
		
		JButton BTNcinzaMedia = new JButton("Cinza M\u00E9dia");
		BTNcinzaMedia.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNcinzaMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					r = Pontuais.cinzaMedia(A);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNcinzaMedia.setBounds(44, 291, 116, 59);
		panel.add(BTNcinzaMedia);
		
		JButton BTNcinzaNTSC = new JButton("Cinza NTSC");
		BTNcinzaNTSC.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNcinzaNTSC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					r = Pontuais.cinzaNTSC(A);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNcinzaNTSC.setBounds(170, 291, 116, 59);
		panel.add(BTNcinzaNTSC);
		
		JButton BTNcinzaHDTV = new JButton("Cinza HDTV");
		BTNcinzaHDTV.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNcinzaHDTV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					r = Pontuais.cinzaHDTV(A);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNcinzaHDTV.setBounds(44, 361, 116, 60);
		panel.add(BTNcinzaHDTV);
		
		JButton BTNcinzaHDr = new JButton("Cinza HDr");
		BTNcinzaHDr.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNcinzaHDr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					r = Pontuais.cinzaHDr(A);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNcinzaHDr.setBounds(170, 361, 116, 59);
		panel.add(BTNcinzaHDr);
		
		TXTimagem2 = new JTextField();
		TXTimagem2.setBackground(Color.YELLOW);
		TXTimagem2.setText("Imagem 2");
		TXTimagem2.setBounds(139, 42, 300, 20);
		panel.add(TXTimagem2);
		TXTimagem2.setColumns(10);
		
		JButton BTNbuscaB = new JButton("Buscar");
		BTNbuscaB.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		BTNbuscaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser searchB = new JFileChooser();
				searchB.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int y = searchB.showSaveDialog(null);
				if(y == 1) {
					TXTimagem2.setText("");
				}
				else {
					File B = searchB.getSelectedFile();
					TXTimagem2.setText(B.getPath());
				}
			}
		});
		BTNbuscaB.setBounds(449, 44, 89, 23);
		panel.add(BTNbuscaB);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(427, 363, -58, -58);
		panel.add(desktopPane);
		
		JButton BTNtranslacao = new JButton("Transla\u00E7\u00E3o");
		BTNtranslacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					r = Geometricas.translacao(A,Integer.parseInt(TXTcordX.getText()),Integer.parseInt(TXTcordY.getText()));
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNtranslacao.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		BTNtranslacao.setBounds(508, 70, 97, 20);
		panel.add(BTNtranslacao);
		
		TXTcordX = new JFormattedTextField();
		TXTcordX.setBackground(Color.YELLOW);
		TXTcordX.setSelectionColor(Color.LIGHT_GRAY);
		TXTcordX.setSelectedTextColor(Color.YELLOW);
		TXTcordX.setBounds(211, 70, 86, 20);
		panel.add(TXTcordX);
		TXTcordX.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Coordenada Y:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(323, 73, 89, 14);
		panel.add(lblNewLabel_1);
		
		TXTcordY = new JFormattedTextField();
		TXTcordY.setSelectedTextColor(Color.DARK_GRAY);
		TXTcordY.setBackground(Color.YELLOW);
		TXTcordY.setBounds(411, 70, 86, 20);
		panel.add(TXTcordY);
		TXTcordY.setColumns(10);
		
		JButton BTNsomaCor = new JButton("Soma Cor");
		BTNsomaCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					int cor = Integer.parseInt(TXTcor.getText());
					r = Aritmetica.somaCor(A,cor);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNsomaCor.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNsomaCor.setBounds(323, 291, 116, 59);
		panel.add(BTNsomaCor);
		
		JButton BTNsubtracaoCor = new JButton("Subtra\u00E7\u00E3o Cor");
		BTNsubtracaoCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					int cor = Integer.parseInt(TXTcor.getText());
					r = Aritmetica.subtracaoCor(A,cor);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNsubtracaoCor.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNsubtracaoCor.setBounds(449, 291, 116, 59);
		panel.add(BTNsubtracaoCor);
		
		JButton BTNmultiplicacaoCor = new JButton("Multiplica\u00E7\u00E3o Cor");
		BTNmultiplicacaoCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					int cor = Integer.parseInt(TXTcor.getText());
					r = Aritmetica.multiplicacaoCor(A,cor);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNmultiplicacaoCor.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNmultiplicacaoCor.setBounds(323, 361, 116, 60);
		panel.add(BTNmultiplicacaoCor);
		
		JButton BTNdivisaoCor = new JButton("Divis\u00E3o Cor");
		BTNdivisaoCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A = new Imagem(new File(TXTimagem1.getText()));
					int cor = Integer.parseInt(TXTcor.getText());
					r = Aritmetica.divisaoCor(A,cor);
					window.FRAME(r);
				} catch (IOException e1) {
					System.out.println("LOADING ERROR\n\n");
					e1.printStackTrace();
				}
			}
		});
		BTNdivisaoCor.setFont(new Font("Arial", Font.PLAIN, 11));
		BTNdivisaoCor.setBounds(449, 361, 116, 60);
		panel.add(BTNdivisaoCor);
		
		JLabel lblCorEmNumero = new JLabel("Numero da Cor:");
		lblCorEmNumero.setForeground(Color.YELLOW);
		lblCorEmNumero.setFont(new Font("Arial", Font.BOLD, 11));
		lblCorEmNumero.setBackground(Color.WHITE);
		lblCorEmNumero.setBounds(115, 101, 89, 14);
		panel.add(lblCorEmNumero);
		
		TXTcor = new JFormattedTextField();
		TXTcor.setSelectionColor(Color.LIGHT_GRAY);
		TXTcor.setSelectedTextColor(Color.YELLOW);
		TXTcor.setBackground(Color.YELLOW);
		TXTcor.setBounds(211, 98, 86, 20);
		panel.add(TXTcor);
		TXTcor.setColumns(10);
	}
}
