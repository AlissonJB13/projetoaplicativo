package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class player extends Rectangle {
	
	public int spd = 4;
	public boolean right, up, down, left;
	
	//variaveis para animação do movimento
	public int curAnimation = 0, curFrames = 0, targetFrames = 15, dir =1;
	
	//criando sistema para tiros
	public static List<Bala> balas = new ArrayList<Bala>();
	
	public boolean shoot = false;
	
	public player(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() {
		boolean seMover = false;
		if(right && World.isFree(x+spd, y)) {
			x+= spd;
			seMover = true;
			dir = 1;
		}else if(left && World.isFree(x-spd, y)) {
			x-=spd;
			seMover = true;
			dir = -1;
		}
		
		if(up && World.isFree(x, y-spd)) {
			y-= spd;
			seMover = true;
		}else if(down && World.isFree(x, y+spd)) {
			y+=spd;
			seMover = true;
		}
		
		//adicionando as animações ao movimento ao jogador
		if(seMover) {
		curFrames ++;
		if(curFrames == targetFrames) {
			curFrames = 0;
			curAnimation++;
			if(curAnimation == Spritesheet.player_front.length) {
				curAnimation = 0;
			}
		}
		}
		
		if(shoot) {
			shoot = false;
			//dir no final define a direção que o tiro é realizado
			balas.add(new Bala(x, y, dir));
		}
		
		for(int i= 0; i <balas.size(); i ++) {
			balas.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(x, y, width, height);
		//pegando imagem do player front da spritesheet e passando curAnimation como tamanho do vetor
		g.drawImage(Spritesheet.player_front[curAnimation], x, y, 32, 32, null);
		for(int i= 0; i <balas.size(); i ++) {
			balas.get(i).render(g);
		}
	}
}

