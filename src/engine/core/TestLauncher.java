package engine.core;

public class TestLauncher {
	public static void main(String[] args) {
		Engine e = new Engine();
		e.start();
		e.window().setTitle("game!");
	}
}
