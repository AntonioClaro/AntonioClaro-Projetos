package METRICS;
import utils.Imagem;
import utils.Utils;

public class Aritmetica{
	public static Imagem soma (Imagem a, Imagem b) {
		Imagem result = new Imagem (Math.max(a.getW(), b.getW()), Math.max(a.getH(), b.getH()));
		
		for(int j = 0; j < result.getH();j++) {
			for(int i = 0; i < result.getW();i++) {
				int cora = a.getP(i,j);
				int ra = Utils.red(cora);
				int ga = Utils.green(cora);
				int ba = Utils.blue(cora);
				
				int corb = b.getP(i,j);
				int rb = Utils.red(corb);
				int gb = Utils.green(corb);
				int bb = Utils.blue(corb);
				
				int corResult = Utils.somaAritmetica(ra, rb, ga, gb, ba, bb);
				result.setP(i,j,corResult);				
			}
		}
		return result;
	}
		
		public static Imagem somaCor(Imagem a, int cor) {
			Imagem result = new Imagem(a.getW(), a.getH());
			int r = cor>>16 & 0xff;
			int g = cor >> 8 & 0xff;
			int b = cor & 0xff;
			for(int j = 0; j<result.getH(); j++) {
				for(int i = 0; i<result.getW(); i++) {
					int cora = a.getP(i,j);
					int ra = cora>>16 & 0xff;
					int ga = cora>>8 & 0xff;
					int ba = cora & 0xff;
					
					int resR = ra + r >255? 255 : ra+r;
					int resG = ga + g >255? 255 : ga+g;
					int resB = ba + b >255? 255 : ba+b;
					
					int corResult = resR<<16 | resG<<8 | resB;
					result.setP(i,j,corResult);
				}
			}
			return result;
		}


public static Imagem subtracao (Imagem a, Imagem b) {
	Imagem result = new Imagem (Math.max(a.getW(), b.getW()), Math.max(a.getH(), b.getH()));
	
	for(int j = 0; j < result.getH();j++) {
		for(int i = 0; i < result.getW();i++) {
			int cora = a.getP(i,j);
			int ra = Utils.red(cora);
			int ga = Utils.green(cora);
			int ba = Utils.blue(cora);
			
			int corb = b.getP(i,j);
			int rb = Utils.red(corb);
			int gb = Utils.green(corb);
			int bb = Utils.blue(corb);
			
			
			int corResult = Utils.subtracaoAritmetica(ra, rb, ga, gb, ba, bb);
			result.setP(i,j,corResult);				
		}
	}
	return result;
}

public static Imagem subtracaoCor(Imagem a, int cor) {
	Imagem result = new Imagem(a.getW(), a.getH());
	int r = cor>>16 & 0xff;
	int g = cor >> 8 & 0xff;
	int b = cor & 0xff;
	for(int j = 0; j<result.getH(); j++) {
		for(int i = 0; i<result.getW(); i++) {
			int cora = a.getP(i,j);
			int ra = cora>>16 & 0xff;
			int ga = cora>>8 & 0xff;
			int ba = cora & 0xff;
			
			int resR = ra - r >255? 255 : ra-r;
			int resG = ga - g >255? 255 : ga-g;
			int resB = ba - b >255? 255 : ba-b;
			
			int corResult = resR<<16 | resG<<8 | resB;
			result.setP(i,j,corResult);
		}
	}
	return result;
}

public static Imagem multiplicacao (Imagem a, Imagem b) {
	Imagem result = new Imagem (Math.max(a.getW(), b.getW()), Math.max(a.getH(), b.getH()));
	
	for(int j = 0; j < result.getH();j++) {
		for(int i = 0; i < result.getW();i++) {
			int cora = a.getP(i,j);
			int ra = Utils.red(cora);
			int ga = Utils.green(cora);
			int ba = Utils.blue(cora);
			
			int corb = b.getP(i,j);
			int rb = Utils.red(corb);
			int gb = Utils.green(corb);
			int bb = Utils.blue(corb);
			
			
			int corResult = Utils.multiplicacaoAritmetica(ra, rb, ga, gb, ba, bb);
			result.setP(i,j,corResult);				
		}
	}
	return result;
}

public static Imagem multiplicacaoCor(Imagem a, int cor) {
	Imagem result = new Imagem(a.getW(), a.getH());
	int r = cor>>16 & 0xff;
	int g = cor >> 8 & 0xff;
	int b = cor & 0xff;
	for(int j = 0; j<result.getH(); j++) {
		for(int i = 0; i<result.getW(); i++) {
			int cora = a.getP(i,j);
			int ra = cora>>16 & 0xff;
			int ga = cora>>8 & 0xff;
			int ba = cora & 0xff;
			
			int resR = ra * r >255? 255 : ra*r;
			int resG = ga * g >255? 255 : ga*g;
			int resB = ba * b >255? 255 : ba*b;
			
			int corResult = resR<<16 | resG<<8 | resB;
			result.setP(i,j,corResult);
		}
	}
	return result;
}

public static Imagem divisao (Imagem a, Imagem b) {
	Imagem result = new Imagem (Math.max(a.getW(), b.getW()), Math.max(a.getH(), b.getH()));
	
	for(int j = 0; j < result.getH();j++) {
		for(int i = 0; i < result.getW();i++) {
			int cora = a.getP(i,j);
			int ra = Utils.red(cora);
			int ga = Utils.green(cora);
			int ba = Utils.blue(cora);
			
			int corb = b.getP(i,j);
			int rb = Utils.red(corb);
			int gb = Utils.green(corb);
			int bb = Utils.blue(corb);
			

			int corResult = Utils.divisaoAritmetica(ra, rb, ga, gb, ba, bb);
			result.setP(i,j,corResult);				
		}
	}
	return result;
}

public static Imagem divisaoCor(Imagem a, int cor) {
	Imagem result = new Imagem(a.getW(), a.getH());
	int r = cor>>16 & 0xff;
	int g = cor >> 8 & 0xff;
	int b = cor & 0xff;
	for(int j = 0; j<result.getH(); j++) {
		for(int i = 0; i<result.getW(); i++) {
			int cora = a.getP(i,j);
			int ra = cora>>16 & 0xff;
			int ga = cora>>8 & 0xff;
			int ba = cora & 0xff;
			
			int resR = r > 0 ? ra/r : ra;
			int resG = g > 0 ? ga/g : ga;
			int resB = b > 0 ? ba/b : ba;
			
			int corResult = resR<<16 | resG<<8 | resB;
			result.setP(i,j,corResult);
		}
	}
	return result;
}

}