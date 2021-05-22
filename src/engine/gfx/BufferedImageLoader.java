package engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	public static BufferedImage loadImage(String path) { 
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(BufferedImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	public static BufferedImage crop(BufferedImage source, int x, int y, int width, int height) {
		return source.getSubimage(x, y, width, height);
	}
}
