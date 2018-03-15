package vaisseauxGraphiques;

import vue.IVue;
import modele.IMobile;
import modele.Position;

public class Vaisseau extends AVaisseau {
	IMobile mobile;
	IVue vue;

	public Vaisseau(IMobile mobile, IVue vue){
		this.mobile=mobile;
		this.vue=vue;
	}
	
	@Override
	public void deplacer() {
		mobile.deplacer();
	}

	@Override
	public void dessiner() {
		vue.dessiner();
	}

	@Override
	public Position getPosition() {
		return mobile.getPosition();
	}

}
