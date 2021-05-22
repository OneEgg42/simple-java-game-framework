package engine.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import engine.input.Keyboard;
import engine.input.Mouse;
import engine.screens.ScreenManager;

public class Engine implements Runnable{

	private Thread mainThread;
	private boolean isRunning = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private Window window;
	private Keyboard keyboard;
	private Mouse mouse;
	
	public Engine() {
		window = new Window(1080, 720, "");
		window.getCanvas().setBackground(Color.black);
		keyboard = new Keyboard(window.getCanvas());
		mouse = new Mouse(window.getCanvas());
	}
	
	public Window window() {return window;}
	public Mouse mouse() {return mouse;}
	public Keyboard keyboard() {return keyboard;}
	
	public synchronized void start() {
		if (isRunning) return;
		
		isRunning = true;
		mainThread = new Thread(this);
		mainThread.start();
	}
	public synchronized void stop() {
		if (!isRunning) return;
		
		isRunning = false;
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		long ticks = 0;
		
		while (isRunning) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				render();
				delta--;
				ticks++;
			}
			
			if (timer >= 1000000000) {
				System.out.println(ticks + "fps");
				timer = 0;
				ticks = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		window.update();
		mouse.update();
		if (ScreenManager.getActiveScreen() != null)
			ScreenManager.getActiveScreen().tick();
	}
	
	private void render() {
		bs = window.getCanvas().getBufferStrategy();
		if (bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, Window.getWindowSize()[0], Window.getWindowSize()[1]);
		//
		if (ScreenManager.getActiveScreen() != null)
			ScreenManager.getActiveScreen().render(g);
		//
		g.dispose();
		bs.show();
	}
	
}
