package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;

public class World {

	public static List<Blocks> blocos = new ArrayList<Blocks>();
	
	public World() {
		for(int xx = 0; xx < 30; xx ++) {
			blocos.add(new Blocks(xx*32, 0));
		} 
		for(int xx = 0; xx < 30; xx ++) {
			blocos.add(new Blocks(xx*32, 480-32));
		}
		for(int yy = 0; yy < 30; yy++) {
			blocos.add(new Blocks(0, yy*32));
		} 
		
		for(int yy = 0; yy < 30; yy ++) {
			blocos.add(new Blocks(640-32, yy*32));
		} 
		
		//criando um bloco para testar a colisão do inimigo
		blocos.add(new Blocks(320,90));
		blocos.add(new Blocks(180,100));
		//blocos.add(new Blocks(160,70));
		//blocos.add(new Blocks(70,30));
		//blocos.add(new Blocks(70,60));
		blocos.add(new Blocks(98,90));
		blocos.add(new Blocks(98,120));
		blocos.add(new Blocks(98,150));
		blocos.add(new Blocks(98,180));
		blocos.add(new Blocks(98,210));
		blocos.add(new Blocks(200,30));
		blocos.add(new Blocks(270,360));
		blocos.add(new Blocks(530,320));
		blocos.add(new Blocks(352,270));
		blocos.add(new Blocks(70,300));
		
	}
	
	public static boolean isFree(int x, int y) {
		for(int i = 0; i<blocos.size(); i ++ ) {
			Blocks blocoAtual = blocos.get(i);
			if(blocoAtual.intersects(new Rectangle(x, y, 32, 32))) {
				return false;
			}
		} return true;
	}
	
	public void render(Graphics g) {
		for(int i = 0; i<blocos.size(); i ++ ) {
			blocos.get(i).render(g);
		}
	}
}
