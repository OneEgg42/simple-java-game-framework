package engine.input;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{

	public static boolean mouseClicked = false;
	public static boolean leftDown, rightDown, wheelDown;
	
	public static int mouseX = 0, mouseY = 0;
	
	private Canvas c;
	
	public Mouse(Canvas c) {
		c.addMouseListener(this);
		this.c=c;
	}
	
	public void update() {
		try {
			mouseX = c.getMousePosition().x;
			mouseY = c.getMousePosition().y;
		}catch(Exception e) {}
	}
	
	private void setState(MouseEvent ev, boolean state) {
		switch(ev.getButton()) {
		case MouseEvent.BUTTON1:
			leftDown = state;
			break;
		case MouseEvent.BUTTON2:
			wheelDown = state;
			break;
		case MouseEvent.BUTTON3:
			rightDown = state;
			break;
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		setState(e, true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseClicked = false;
		setState(e, false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

}
