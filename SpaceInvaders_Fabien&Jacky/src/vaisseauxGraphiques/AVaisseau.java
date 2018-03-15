package vaisseauxGraphiques;

import modele.IMobile;
import modele.Position;
import vue.IVue;

public abstract class AVaisseau implements IVue, IMobile {

	@Override
	public abstract void deplacer();

	@Override
	public abstract void dessiner();
	
}
