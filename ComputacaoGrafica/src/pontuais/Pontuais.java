package pontuais;

import utils.Imagem;

public class Pontuais {
	public static Imagem cinzaMedia(Imagem a){
		Imagem result = new Imagem(a.getW(), a.getH());
		for(int j =0;j<a.getH();j++){
			for(int i=0; i <a.getW();i++) {
				int c = a.getP(i, j);
				int r = c>>16 & 0xff;
				int g = c>>8 & 0xff;
				int b = c & 0xff;
				
				float media = (r+g+b)/3.0f;
				
				int medial = (int) Math.round(media);
				medial = medial<<16 | medial<<8 | medial;
				result.setP(i, j, medial);
			}
		}
		return result;
	}
	
	public static Imagem cinzaNTSC(Imagem a){
		Imagem result = new Imagem(a.getW(), a.getH());
		for(int j =0;j<a.getH();j++){
			for(int i=0; i <a.getW();i++) {
				int c = a.getP(i, j);
				int r = c>>16 & 0xff;
				int g = c>>8 & 0xff;
				int b = c & 0xff;
				
				float corR = (0.299f*r+0.587f*g+0.114f*b)/3.0f;
				
				int corRI = (int) Math.round(corR);
				corRI = corRI<<16 | corRI<<8 | corRI;
				result.setP(i, j, corRI);
			}
		}
		return result;
	}
	
	public static Imagem cinzaHDTV(Imagem a){
		Imagem result = new Imagem(a.getW(), a.getH());
		for(int j =0;j<a.getH();j++){
			for(int i=0; i <a.getW();i++) {
				int c = a.getP(i, j);
				int r = c>>16 & 0xff;
				int g = c>>8 & 0xff;
				int b = c & 0xff;
				
				float corH = (0.2126f*r+0.7152f*g+0.0722f*b)/3.0f;
				
				int corHI = (int) Math.round(corH);
				corHI = corHI<<16 | corHI<<8 | corHI;
				result.setP(i, j, corHI);
			}
		}
		return result;
	}
	
	public static Imagem cinzaHDr(Imagem a){
		Imagem result = new Imagem(a.getW(), a.getH());
		for(int j =0;j<a.getH();j++){
			for(int i=0; i <a.getW();i++) {
				int c = a.getP(i, j);
				int r = c>>16 & 0xff;
				int g = c>>8 & 0xff;
				int b = c & 0xff;
				
				float corHD = (0.2127f*r+0.6780f*g+0.0593f*b)/3.0f;
				
				int corHDI = (int) Math.round(corHD);
				corHDI = corHDI<<16 | corHDI<<8 | corHDI;
				result.setP(i, j, corHDI);
			}
		}
		return result;
	}
}
