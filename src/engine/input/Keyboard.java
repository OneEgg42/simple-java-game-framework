package engine.input;

import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	public static boolean q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n,m;
	
	public Keyboard(Canvas c) {
		c.addKeyListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		setState(e, true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		setState(e, false);
	}
	
//  yes, i know this may not be the best way of doing this...
	private void setState(KeyEvent ev, boolean state) {
		switch (ev.getKeyCode()) {
		case KeyEvent.VK_Q:
			q=state;
			break;
		case KeyEvent.VK_W:
			w=state;
			break;
		case KeyEvent.VK_E:
			e=state;
			break;
		case KeyEvent.VK_T:
			t=state;
			break;
		case KeyEvent.VK_Y:
			y=state;
			break;
		case KeyEvent.VK_U:
			u=state;
			break;
		case KeyEvent.VK_I:
			i=state;
			break;
		case KeyEvent.VK_O:
			o=state;
			break;
		case KeyEvent.VK_P:
			p=state;
			break;
		case KeyEvent.VK_A:
			a=state;
			break;
		case KeyEvent.VK_S:
			s=state;
			break;
		case KeyEvent.VK_D:
			d=state;
			break;
		case KeyEvent.VK_F:
			f=state;
			break;
		case KeyEvent.VK_G:
			g=state;
			break;
		case KeyEvent.VK_H:
			h=state;
			break;
		case KeyEvent.VK_J:
			j=state;
			break;
		case KeyEvent.VK_K:
			k=state;
			break;
		case KeyEvent.VK_L:
			l=state;
			break;
		case KeyEvent.VK_Z:
			z=state;
			break;
		case KeyEvent.VK_X:
			x=state;
			break;
		case KeyEvent.VK_C:
			c=state;
			break;
		case KeyEvent.VK_V:
			v=state;
			break;
		case KeyEvent.VK_B:
			b=state;
			break;
		case KeyEvent.VK_N:
			n=state;
			break;
		case KeyEvent.VK_M:
			m=state;
			break;
		}
	}

}
