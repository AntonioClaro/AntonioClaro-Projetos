package Extras;

import utils.Imagem;

public class Extras{
	
	public static Imagem drawMand(int w, int h) {
		Imagem img = new Imagem(w,h);
		img.getP(801,700);
		float cr;
		float ci;
		float xmin = -2.5f;
		float xmax = 1.f;
		float ymin = -((xmax-xmin)*img.getH()/(float)img.getW())/2.0f;
		float ymax = -ymin;
		float width = img.getW();
		float height = img.getH();
		for(int j = 0; j < height; j++) {
			for(int i = 0; i < width; i++) {
				cr = i*(xmax-xmin)/width+xmin;
				ci = j*(ymax-ymin)/height+ymax;
				float zr = cr;
				float zi = ci;
				boolean is = true;
				int k;
				for(k = 0; k < 1000; k++) {
					if(zr*zr+zi*zi>4) {
						is = false;
						break;
					}
					float tmp = zr*zr-zi*zi + cr;
					zi = 2*zr*zi + ci;
					zr = tmp;
				}
				if(!is) {
					int color = k > 255? 255:k;
					img.setP(i,j,color<<16 | color<<8 | color);
				}
			}
		}
		
		return img;
	}
	
//	public static Imagem histogram(Imagem a) {
//		Imagem result = new Imagem(256,150);
//		int[] cor = new int[256];
//		int max = 0;
//		int linhaCor = 255 << 16 | 255 << 8 | 255;
//		
//		for(int j = 0; j<a.getH();j++) {
//			for(int i = 0; i<a.getW(); i++) {
//				int pixel = red(a.getP(i, j));
//				cor[pixel]++;
//				if(cor[pixel]>max) {
//					max = cor[pixel;]
//				}
//				for(int x = 0; x<result.getW(); x++) {
//					int mapVar = map(cor[x],max,150);
//					result.setP(x, mapVar, linhaCor);
//					for(int y = mapVar;y<result.getH();y++) {
//						result.setP(x, y, linhaCor);
//					}
//				}
//			}
//		}
//		return result;
//	}
}

