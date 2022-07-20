package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bala extends Rectangle{
	
	public int dir= 1, speed= 8, frames= 0;
	
	public Bala(int x, int y, int dir) {
		//tamanho da bala
		// x+16 e y+16 faz com que as balas saiam no centro do personagem
		super(x+16,y+16,10,10);
		this.dir = dir;
	}
	
	public void tick() {
		//direcionando
		x+= speed*dir;
		//destruição das balas depois de 1 segundo
		frames ++;
		if(frames == 60) {
			player.balas.remove(this);
			return ;
		}
	}
	
	public void render(Graphics g) {
		//setando cor e forma
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}
}
