package com.egg.game.display;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	public static int windowWidth;
	public static int windowHeight;
	
	private JFrame frame;
	private Canvas canvas;
	
	public Window(int width, int height, String title) {
		windowWidth = width;
		windowHeight = height;
	
		createWindow(title);
	}
	
	private void createWindow(String title) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
		canvas.setMaximumSize(new Dimension(windowWidth, windowHeight));
		canvas.setMinimumSize(new Dimension(windowWidth, windowHeight));
		canvas.setFocusable(true);
		
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
}
