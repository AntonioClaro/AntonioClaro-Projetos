package filtros;

import utils.Imagem;
import utils.Utils;

import static utils.Utils.red;
import static utils.Utils.green;
import static utils.Utils.blue;

public class Filtros {
	
	public static Imagem media4(Imagem a) {
		
		Imagem result = new Imagem(a.getW(),a.getH());
		for(int j=0;j<a.getH();j++) {
			for(int i=0;i<a.getW();i++) {
				int acumR = red(a.getP(i,j-1)) + red(a.getP(i, j)) + red(a.getP(i, j+1)) + red(a.getP(i-1, j)) + red(a.getP(i+1,j));
				int acumG = green(a.getP(i,j-1)) + green(a.getP(i, j)) + green(a.getP(i, j+1)) + green(a.getP(i-1, j)) + green(a.getP(i+1,j));
				int acumB = blue(a.getP(i,j-1)) + blue(a.getP(i, j)) + blue(a.getP(i, j+1)) + blue(a.getP(i-1, j)) + blue(a.getP(i+1,j));
				acumR /= 5;
				acumG /= 5;
				acumB /= 5;
				
				result.setP(i,j, acumR<<16|acumG<<8|acumB);
				
			}
		}
		
		return result;
	}
	
	public static Imagem mediaR(Imagem a, int r) {
		Imagem result = null;
		for(int j=0;j<a.getH();j++) {
			for(int i=0;i<a.getW();i++) {
				
				
			}
		} return result;

	}
	
	public static Imagem mediana(Imagem a, int r) {
		Imagem result = null;
		for(int j=0;j<a.getH();j++) {
			for(int i=0;i<a.getW();i++) {
				
				
			}
			
		} return result;
	}
	
	public static Imagem convolve(Imagem A, Kernel k) {
		Imagem result = null;
		for(int a = 0; a < A.getH(); a++) {
			for(int b = 0; b < A.getW(); b++) {
				float aRed = 0;
				float aGreen = 0;
				float aBlue = 0;
		for(int m = 0; m < a; m++) {
			for(int n = 0; n < A.getW(); n++) {
				int Cor = A.getP(n - k.x + m, m - k.y + m);
				int red = Utils.red(Cor);
				int green = Utils.green(Cor);
				int blue = Utils.blue(Cor);
				aRed = aRed + k.k[a][b] * red;
				aGreen = aGreen + k.k[a][b] * green;
				aBlue = aBlue + k.k[a][b] * blue;
				}
			}
		int roundR = Math.round(aRed);
		int roundG = Math.round(aGreen);
		int roundB = Math.round(aBlue);
		roundR = roundR > 255 ? 255:roundR;
		roundG = roundG > 255 ? 255:roundG;
		roundB = roundB > 255 ? 255:roundB;
		
		int corR = roundR << 16| roundG << 8 | roundB;
		result.setP(b, a, corR);
		}
	}
		return result;
}
	
	public static Imagem gaussianBlur(Imagem a, int r, float sigma, float amp) {
		Kernel k = new Kernel(2*r+1, 2*r+1, (2*r+1)/2, (2*r+1)/2);
		
		Imagem result = convolve(a,k);
		return result;
	}
}

class Kernel{
	
	float[][] k;
	int x;
	int y;
	
	public Kernel(int w, int h, int x, int y) {
		k = new float[h][w];
		this.x =x;
		this.y = y;
	}
	
}