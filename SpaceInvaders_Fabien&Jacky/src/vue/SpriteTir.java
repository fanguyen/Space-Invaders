package vue;

import modele.IMobile;
import modele.Position;
import processing.core.PApplet;
import processing.core.PImage;

public class SpriteTir extends ASprite {

	public SpriteTir(PApplet fenetre, IMobile mobile) {
		super(fenetre, mobile);
		sprite = fenetre.loadImage("./images/greenLaserRay.png");
		sprite.resize(6,0);
		
	}

}
