package utils;

public class Utils {
	
	public static int red(int cor) {
		return cor>>16 & 0xff;
	}
	
	public static int green(int cor) {
		return cor>>8 & 0xff;
	}
	
	public static int blue(int cor) {
		return cor & 0xff;
	}
	
	public static int somaAritmetica(int ra, int rb, int ga, int gb, int ba, int bb) {
		int resR = (ra + rb) > 255 ? 255:ra+rb;
		int resG = ga+gb;
		if(resG > 255)
			resG = 255;
		int resB = (ba + bb) > 255 ? 255:ba+bb;
		return resR<<16|resG<<8|resB;
	}
	
	public static int subtracaoAritmetica(int ra, int rb, int ga, int gb, int ba, int bb) {
		int resR = (ra - rb) > 255 ? 255:ra-rb;
		int resG = (ga - gb) > 255 ? 255:ga-gb;
		int resB = (ba - bb) > 255 ? 255:ba-bb;
		return resR<<16|resG<<8|resB;
	}
	
	public static int multiplicacaoAritmetica(int ra, int rb, int ga, int gb, int ba, int bb) {
		int resR = (ra * rb) > 255 ? 255:ra*rb;
		int resG = (ga * gb) > 255 ? 255:ga*gb;
		int resB = (ba * bb) > 255 ? 255:ba*bb;
		return resR<<16|resG<<8|resB;
	}
	
	public static int divisaoAritmetica(int ra, int rb, int ga, int gb, int ba, int bb) {
		int resR = rb > 0 ? ra/rb : ra;
		int resG = gb > 0 ? ga/gb : ga;			
		int resB = bb > 0 ? ba/bb : ba;
		return resR<<16|resG<<8|resB;
	}
	
	public static int andLogica(int ra, int rb, int ga, int gb, int ba, int bb) {
		int resR = ra&rb;
		int resG = ga&gb;
		int resB = ba&bb;
		return resR<<16|resG<<8|resB;
		}
		
	public static int notLogica(int cor) {
		cor = -cor;
		return cor;
	}
	
	public static int orLogica(int ra, int rb, int ga, int gb, int ba, int bb) {
		int resR = ra|rb;
		int resG = ga|gb;
		int resB = ba|bb;
		return resR<<16|resG<<8|resB;
	}
	
	public static int xorLogica(int ra, int rb, int ga, int gb, int ba, int bb) {
		int resR = ra^rb;
		int resG = ga^gb;
		int resB = ba^bb;
		return resR<<16|resG<<8|resB;
	}
	
}
