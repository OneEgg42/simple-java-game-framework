package engine.screens;

public class ScreenManager {
	private static Screen activeScreen;
	
	public static void setActiveScreen(Screen s) {
		activeScreen = s;
	}
	public static Screen getActiveScreen() {
		return activeScreen;
	}
}
