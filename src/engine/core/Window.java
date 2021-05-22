package engine.core;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	private static int windowWidth;
	private static int windowHeight;
	
	public boolean hasFocus;
	
	private JFrame frame;
	private Canvas canvas;
	
	public Window(int width, int height, String title) {
		windowWidth = width;
		windowHeight = height;
		
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setPreferredSize(new Dimension(width, height));
		
		frame.add(canvas);
		frame.pack();
	}
	
	public void update() {
		hasFocus = canvas.hasFocus();
	}
	
	public static int[] getWindowSize() {
		//int[] size = {windowWidth, windowHeight};
		return new int[] {windowWidth, windowHeight};
	}
	
	public Canvas getCanvas() {return canvas;}
	public void setTitle(String title) {frame.setTitle(title);}
	public void setResizable(boolean state) {frame.setResizable(state);}
}
