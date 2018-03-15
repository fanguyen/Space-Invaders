package modele;

public class MobileB implements IMobile {
	Position position;
	
	double mb = 0.0D;
	double vit = 0.02D;
	int rayon = 200;
	
	public MobileB(double mb, Position position){
		this.mb = mb;
		this.position = position;
	}

	@Override
	public void deplacer() {
		  mb += vit;
		    int x = 600 + (int)(rayon*2 * Math.sin(mb));
		    int y = 210 + (int)(rayon * Math.sin(mb/2));
		    position.setXpix(x);
		    position.setYpix(y);
	}
	


	
	@Override
	public Position getPosition() {
		return position;
	}

}
