package vue;

import modele.IMobile;
import modele.Position;
import processing.core.PApplet;
import processing.core.PImage;

public class SpriteC extends ASprite {

	public SpriteC(PApplet fenetre, IMobile mobile) {
		super(fenetre, mobile);
		sprite = fenetre.loadImage("./images/X-wing.png");
		sprite.resize(80,0);
		
	}

}
