package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
public static BufferedImage spriteSheet;
	
	//definindo a variavel do jogador
	//frente do jogador: array para mostrar animação da frente
	public static BufferedImage[] player_front;
	public static BufferedImage[] inimigo_front;
	//blocos estilizados
	public static BufferedImage tileWall;
	public Spritesheet() {
		try {
			spriteSheet = ImageIO.read(getClass().getResource("/aula05-spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//pegar as coordenadas da imagem e tamanho
		player_front = new BufferedImage[2];
		inimigo_front = new BufferedImage[2];
		
		player_front[0] = Spritesheet.getSprite(0, 11, 16, 16);
		player_front[1]= Spritesheet.getSprite(16, 11, 16, 16);
		
		inimigo_front[0] = Spritesheet.getSprite(159, 241, 16, 16);
		inimigo_front[1]= Spritesheet.getSprite(159, 258, 16, 16);
		tileWall = Spritesheet.getSprite(254, 241, 16, 16);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spriteSheet.getSubimage(x, y, width, height);
	}
}