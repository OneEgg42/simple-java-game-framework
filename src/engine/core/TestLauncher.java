package engine.core;

// delete this file if you use the engine as this is just to test if it works

public class TestLauncher {
	public static void main(String[] args) {
		Engine e = new Engine();
		e.start();
		e.window().setTitle("game!");
	}
}
