package vue;

import modele.IMobile;
import modele.Position;
import processing.core.PApplet;
import processing.core.PImage;

public class SpriteB extends ASprite {

	public SpriteB(PApplet fenetre, IMobile mobile, int mb) {
		super(fenetre, mobile);
		sprite = fenetre.loadImage("./images/pluto.png");
		sprite.resize(50,0);
	}
	

}
