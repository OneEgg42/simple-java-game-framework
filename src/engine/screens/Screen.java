package engine.screens;

import java.awt.Graphics;

public abstract class Screen {
	
	public Screen() {
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
