package com.egg.game.input;

import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{

	public boolean w, a, s, d, space;
	
	public Input(Canvas canvas) {
		canvas.addKeyListener(this);
	}
	
	private void gatherInput(boolean state, int keyCode) {
		switch(keyCode) {
		case KeyEvent.VK_A:
			a = state;
			break;
		case KeyEvent.VK_D:
			d = state;
			break;
		case KeyEvent.VK_W:
			w = state;
			break;
		case KeyEvent.VK_S:
			s = state;
			break;
		case KeyEvent.VK_SPACE:
			space = state;
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.gatherInput(true, e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.gatherInput(false, e.getKeyCode());
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
}
