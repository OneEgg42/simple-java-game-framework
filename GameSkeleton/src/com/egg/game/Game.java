package com.egg.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.egg.game.display.Window;
import com.egg.game.input.Input;
import com.egg.game.states.StateManager;

public class Game implements Runnable{
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private Window window;
	private GameHandler handler;
	
	public Game() {
		window = new Window(1000, 800, "game");
		handler = new GameHandler(new Input(window.getCanvas()));
	}
	public void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void tick() {
		
	}
	private void render() {
		bs = window.getCanvas().getBufferStrategy();
		if (bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, Window.windowWidth, Window.windowHeight);
		window.getCanvas().setBackground(Color.black);
		//
		//
		g.dispose();
		bs.show();
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
		
		while (running) {
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
}
