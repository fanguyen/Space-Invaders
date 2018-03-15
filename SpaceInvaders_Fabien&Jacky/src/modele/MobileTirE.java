package modele;

public class MobileTirE implements IMobile {
	Position position;

	public MobileTirE(Position position) { 
		this.position = position;
		
	}

	@Override
	public void deplacer() {
		
		int y = this.position.getYpix();
		y+=5;
		this.position.setYpix(y);
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
