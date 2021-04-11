package com.egg.game.states;

public class StateManager {
	private static State activeState = null;
	
	public static void setActiveState(State newState) {
		StateManager.activeState = newState;
	}
	public static State getActiveState() {
		return StateManager.activeState;
	}
}
