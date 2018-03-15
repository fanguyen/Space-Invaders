package modele;


import modele.Position;
import processing.core.PApplet;

public class MobileC implements modele.IMobile
{
  Position position;
  PApplet fenetre;
 /* private long dateDernierTir = 0L;
  private long intervalleTir = 100L;*/
  
  public MobileC(Position position, PApplet fenetre){
      this.position = position;
      this.fenetre=fenetre;
  }
  
  
  public void deplacer() {
      if (fenetre.keyPressed && fenetre.key == 'q'){
    	 position.setXpix(position.getXpix() - 5);
      }
      if (fenetre.keyPressed && fenetre.key == 'd'){
    	  position.setXpix(position.getXpix() + 5);
      }  
  }
  
  public Position getPosition()
  {
    return position;
  }
}