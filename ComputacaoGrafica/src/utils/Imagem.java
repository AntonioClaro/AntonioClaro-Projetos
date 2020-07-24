package utils;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Imagem extends Component{
	
	
	private static final long serialVersionUID = 3421234L;

	BufferedImage img;
	
	public Imagem() {
		img = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
	}
	
	public Imagem(int width,int height) {
		img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	}
	
	public Imagem(java.io.File f) throws IOException{
		img = ImageIO.read(f);
	}
	
	public Imagem(int width,int height,int color) {
		this(width,height);		
		for(int j = 0; j < height ; j++) {
			for(int i = 0; i < width; i++) {
				img.setRGB(i,j, color);
			}
		}
	}
	
	public int getP(int x, int y) {
		if(x >= 0 && x < img.getWidth() && y >= 0 & y < img.getHeight()) {
			return img.getRGB(x,y);}
		return 0;
	}
	
	public void setP(int x, int y, int color) {
		if(x >= 0 && x < img.getWidth() && y >= y & y < img.getHeight()) {
			img.setRGB(x,y,color);
		}
	}
	
	public int getW() {
		return img.getWidth();
	}
	
	public int getH() {
		return img.getHeight();
	}

	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}                                                                                                                                                                                                                                                                                                                                                                                                                              