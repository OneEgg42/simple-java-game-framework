package com.egg.game.states;

import java.awt.Graphics;

import com.egg.game.GameHandler;

public abstract class State {
	protected GameHandler handler;
	public State(GameHandler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
