package vue;

import modele.IMobile;
import modele.Position;
import processing.core.PApplet;
import processing.core.PImage;

public class SpriteA extends ASprite {
	
	public SpriteA(PApplet fenetre, IMobile mobile, int ma) {
		super(fenetre, mobile);
		sprite = fenetre.loadImage("./images/star_trek.png");
		sprite.resize(50,0);
	}

}
