package modele;

public class MobileA implements IMobile {
	Position position;
	
	double ma = 0.0D;
	double vit = 0.015D;
	int rayon = 250;

	public MobileA(double ma, Position position) {
		
		this.ma = ma;
		this.position = position;
		
	}

	@Override
	public void deplacer() {
		ma += vit;
		int x = 600 + (int) (rayon*1.5 * Math.cos(ma));
		int y = 250 + (int) (0.9D * (rayon * Math.sin(ma*2)));
		position.setXpix(x);
		position.setYpix(y);
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
