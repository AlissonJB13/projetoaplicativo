package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inimigo extends Rectangle {
	//fazendo a parte de inteligencia artificial
	public int spd = 2, right= 1, up= 0, down= 0, left= 0;
	
	//variaveis para animação do movimento
	public int curAnimation = 0, curFrames = 0, targetFrames = 15, dir =1;
	
	//criando sistema para tiros
	public static List<Bala> balas = new ArrayList<Bala>();
	
	public boolean shoot = false;
	
	public Inimigo(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void perseguirPlayer() {
		//inteligencia artificial sendo utilizada para inimigo perseguir o player
		player p = gameMain.player;
		if(x <p.x && World.isFree(x+spd, y)) {
			//new random é utilizado nesse caso para o inimigo se movimentar de maneira aleatoria 
			if(new Random().nextInt(100) < 50)
			x+=spd;
		}else if(x>p.x && World.isFree(x-spd, y)) {
			if(new Random().nextInt(100) < 50)
			x-=spd;
		}
		
		if(y <p.y && World.isFree(x, y+spd)) {
			if(new Random().nextInt(100) < 50)
			y+=spd;
		}else if(y>p.y && World.isFree(x, y-spd)) {
			if(new Random().nextInt(100) < 50)
			y-=spd;
		}
		
	}
	public void tick() {
		boolean seMover = true;
		
		perseguirPlayer();
		
		//if(right == 1 && World.isFree(x+1, y)) {
		//	x++;
		//}
		
		//adicionando as animações ao movimento ao jogador
		if(seMover) {
		curFrames ++;
		if(curFrames == targetFrames) {
			curFrames = 0;
			curAnimation++;
			if(curAnimation == Spritesheet.inimigo_front.length) {
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
		g.drawImage(Spritesheet.inimigo_front[curAnimation], x, y, 32, 32, null);
		for(int i= 0; i <balas.size(); i ++) {
			balas.get(i).render(g);
		}
	}
}
