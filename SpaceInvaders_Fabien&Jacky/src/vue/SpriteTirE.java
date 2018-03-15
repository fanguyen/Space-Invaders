package vue;

import modele.IMobile;
import modele.Position;
import processing.core.PApplet;


public class SpriteTirE extends ASprite {
	
	public SpriteTirE(PApplet fenetre, IMobile mobile) {
		super(fenetre, mobile);
		sprite = fenetre.loadImage("./images/redLaserRay.png");
		sprite.resize(10,0);
	}
	
	@Override
	public void dessiner() {
		int x = mobile.getPosition().getXpix();
		int y = mobile.getPosition().getYpix();
		fenetre.image (sprite, x, y);
	}
}
