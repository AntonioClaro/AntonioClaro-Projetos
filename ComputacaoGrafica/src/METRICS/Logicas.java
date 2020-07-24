package METRICS;

import utils.Imagem;
import utils.Utils;

public class Logicas{
	
	public static Imagem and(Imagem a, Imagem b) {
		Imagem result = new Imagem(Math.max(a.getW(), b.getW()), Math.max(a.getH(), b.getH()));
		for(int j = 0; j < result.getH(); j++){
			for(int i = 0; i < result.getW(); i++) {
				int cora = a.getP(i,j);
				int ra = Utils.red(cora);
				int ga = Utils.green(cora);
				int ba = Utils.blue(cora);
				
				int corb = b.getP(i,j);
				int rb = Utils.red(corb);
				int gb = Utils.green(corb);
				int bb = Utils.blue(corb);
	
				int corR = Utils.andLogica(ra, rb, ga, gb, ba, bb);
				result.setP(i, j, corR);
			}
		}
		return result;
	}
	
	public static Imagem not(Imagem a) {
		Imagem result = new Imagem(a.getW(), a.getH());
		for(int j =0; j < result.getH(); j++) {
			for(int i = 0; i < result.getW(); i++) {
				int cor = a.getP(i, j);
				
				int corR = Utils.notLogica(cor);
				result.setP(i,  j,  corR);
			}
		}
		return result;
	}
	
	public static Imagem or(Imagem a, Imagem b) {
		Imagem result = new Imagem(Math.max(a.getW(), b.getW()), Math.max(a.getH(), b.getH()));
		for(int j = 0; j < result.getH(); j++){
			for(int i = 0; i < result.getW(); i++) {
				int cora = a.getP(i,j);
				int ra = Utils.red(cora);
				int ga = Utils.green(cora);
				int ba = Utils.blue(cora);
				
				int corb = b.getP(i,j);
				int rb = Utils.red(corb);
				int gb = Utils.green(corb);
				int bb = Utils.blue(corb);
				
				int corR = Utils.orLogica(ra, rb, ga, gb, ba, bb);
				result.setP(i, j, corR);
			}
		}
		return result;
	}
	
	public static Imagem xor(Imagem a, Imagem b) {
		Imagem result = new Imagem(Math.max(a.getW(), b.getW()), Math.max(a.getH(), b.getH()));
		for(int j = 0; j < result.getH(); j++){
			for(int i = 0; i < result.getW(); i++) {
				int cora = a.getP(i,j);
				int ra = Utils.red(cora);
				int ga = Utils.green(cora);
				int ba = Utils.blue(cora);
				
				int corb = b.getP(i,j);
				int rb = Utils.red(corb);
				int gb = Utils.green(corb);
				int bb = Utils.blue(corb);
								
				int corR = Utils.xorLogica(ra, rb, ga, gb, ba, bb);
				result.setP(i, j, corR);
			}
		}
		return result;
	}
}