package modele;

import processing.core.PApplet;

public class MobileTir implements modele.IMobile
{
  Position position;
  PApplet fenetre;

  
  public MobileTir(Position position, PApplet fenetre) {
    this.position = position;
    this.fenetre = fenetre;
  } 
  
  @Override
  public void deplacer()
  { 
    position.setYpix(position.getYpix() - 5);
  }
  
  @Override
  public Position getPosition()
  {
    return position;
  }
  
  
  public modele.IMobile tir()
  {
    return null;
  }
}

