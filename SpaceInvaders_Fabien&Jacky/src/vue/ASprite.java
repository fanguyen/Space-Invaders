package vue;

import processing.core.PApplet;
import processing.core.PImage;
import modele.IMobile;
import modele.Position;

public abstract class ASprite implements IVue {
	protected IMobile mobile;
	protected PApplet fenetre;
	PImage sprite;

	
	public ASprite(PApplet fenetre, IMobile mobile){
		this.fenetre=fenetre;
		this.mobile=mobile;
	}
	
	public void dessiner() {
		
		Position position = mobile.getPosition();
	    int x = position.getXpix();
	    int y = position.getYpix();
	    fenetre.image(sprite, x - sprite.width / 2, y - sprite.height / 2);
	}
	
}
