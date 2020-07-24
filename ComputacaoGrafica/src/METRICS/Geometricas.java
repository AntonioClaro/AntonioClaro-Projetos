package METRICS;

import utils.Imagem;

public class Geometricas{
	public static Imagem translacao(Imagem a, int tx, int ty) {
		Imagem result = new Imagem(a.getW() + Math.abs(tx), a.getH()+Math.abs(ty));
		
		for(int j=0;j<a.getH();j++) {
			for(int i = 0;i<a.getW();i++) {
				result.setP(i+tx, j+ty, a.getP(i, j));
			}
		}
		return result;
	}
	
	

	public static Imagem rotacao(Imagem a, int alpha, int cx, int cy) {
		Imagem result = null;
		double radians = Math.toRadians(alpha);
		result = new Imagem(a.getW(), a.getH());
		for(int j = 0; j<a.getH();j++) {
			for(int i= 0;i<a.getW();i++) {
				
				int ni = i - cx;
				int nj = j - cy;
				int x = (int) Math.round(ni*Math.cos(radians) + nj*Math.sin(radians));
				int y = (int) Math.round(-ni*Math.sin(radians)+ nj*Math.cos(radians));
				
				int nx = x + cx;
				int ny = y + cy;
				
				result.setP(nx,  ny,  a.getP(i, j));
			}
		}
		return result;
	}

	public static Imagem escala (Imagem a, float s) {
		return escala(a,s,s);
	}
	
	public static Imagem escala (Imagem a, float sx, float sy) {
		Imagem result = null;
		
		// Definir tamanho da resultante
		// Definir onde as cores da original cairão na resultante
		// Preencher os pixels intermediarios usando interpolação ou
		// cópia
		
		return result;
	}
}