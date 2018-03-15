package controleur;

import java.util.ArrayList;
import modele.IMobile;
import modele.MobileTirE;
import modele.Position;
import processing.core.PApplet;
import processing.core.PImage;
import vaisseauxGraphiques.AVaisseau;
import vaisseauxGraphiques.Vaisseau;
import vue.IVue;
import vue.SpriteA;
import vue.SpriteB;
import vue.SpriteC;
import vue.SpriteTir;
import vue.SpriteTirE;

public class FenetreControleur extends PApplet {
	PImage fond;
	Vaisseau joueur;
	ArrayList<AVaisseau> vaisseaux = new ArrayList<AVaisseau>();
	ArrayList<AVaisseau> tirs_ennemis = new ArrayList<AVaisseau>();
	ArrayList<AVaisseau> tirs_joueur = new ArrayList<AVaisseau>();


	int XEnnemi = 400;
	int YEnnemi = 200;
	int Xjoueur = 600;
	int Yjoueur = 750;
	int XTir = Xjoueur;
	int YTir = Yjoueur;
	boolean joueurVie = true;


	public void settings() {
		size(1200, 800);
	}

	public void setup() {
		// fenetre
		frameRate(60);
		fond = loadImage("./images/universFond.jpg");



		/**** Vaisseaux Ennemis ****/

		for (int i = 0; i <= 15; i++) {
			IMobile imA = new modele.MobileA(i, new Position(XEnnemi, YEnnemi));
			if (i % 2 == 0) {
				vaisseaux.add(new Vaisseau(imA, new SpriteA(this, imA, i ))); 
			}else{
				vaisseaux.add(new Vaisseau(imA, new SpriteB(this, imA, i)));  
			}
		}
		for (int i = 0; i <= 15; i++) {
			IMobile imB = new modele.MobileB(i, new Position(XEnnemi, YEnnemi));
			if (i % 2 == 0) {
				vaisseaux.add(new Vaisseau(imB, new SpriteA(this, imB, i )));
			}else{
				vaisseaux.add(new Vaisseau(imB, new SpriteB(this, imB, i)));
			}
		}


		/**** Vaisseau joueur ****/

		IMobile imJoueur = new modele.MobileC(new Position(Xjoueur, Yjoueur), this);
		joueur = new Vaisseau(imJoueur, new SpriteC(this, imJoueur));


	}

	/***** Gestion des tirs ennemis ****/
	public void TirEnnemi(){

		int tirer = (int) (Math.random() * 10);

		if (tirer == 0){
			int tir= (int) (Math.random() * (vaisseaux.size()));
			AVaisseau tireur = vaisseaux.get(tir);
			Position TirEnnemiPosition = new Position(tireur.getPosition().getXpix(), tireur.getPosition().getYpix());
			IMobile TirEnnemiMobile = new MobileTirE (TirEnnemiPosition);
			IVue TirEnnemiVue = new SpriteTirE(this, TirEnnemiMobile);
			AVaisseau TirEnnemi = new Vaisseau(TirEnnemiMobile, TirEnnemiVue);
			tirs_ennemis.add(TirEnnemi);
		}
	}

	/***** Gestion de tir du joueur ****/

	public void ControlTir() {
		if (keyPressed && key == ' ') {
			IMobile joueurTir = new modele.MobileTir(new Position(XTir, YTir), this);
			tirs_joueur.add(new Vaisseau(joueurTir, new SpriteTir(this, joueurTir)));
		}
		if (keyPressed && key == 'q') {
			XTir -= 5;
		}
		if (keyPressed && key == 'd') {
			XTir += 5;
		}
	}

	public void draw() {
		// fond
		image(fond, 0, 0);

		if(vaisseaux.size() != 0 && joueurVie == true){

			// vaisseaux ennemis : deplacement et dessin
			for (AVaisseau v : vaisseaux) {
				v.deplacer();
				v.dessiner();
			}
			for (AVaisseau te : tirs_ennemis) {
				int ye = te.getPosition().getYpix();
				te.deplacer();
				te.dessiner();
				if ( ye > 790){
					tirs_ennemis.remove(te);
					break;
				}
			}

			// Tir ennemi : joueur touché 
			for (AVaisseau t : tirs_ennemis){
				if (collision(t.getPosition().getXpix(), t.getPosition().getYpix(), joueur.getPosition().getXpix(), joueur.getPosition().getYpix()) == true){
					tirs_ennemis.remove(t);
					joueurVie = false;
					return;
				}
			}


			// vaisseau joueur : deplacement et dessin
			joueur.deplacer();
			joueur.dessiner();
			ControlTir();

			// vaisseau joueur : gestion du tir
			for (AVaisseau tj : tirs_joueur) {
				int yj = tj.getPosition().getYpix();
				tj.deplacer();
				tj.dessiner();
				if ( yj < 10){
					tirs_joueur.remove(tj);
					break;
				}
			}

			// vaisseaux ennemis : gestion du tir
			if (vaisseaux.size() > 1)
				TirEnnemi();

			// Tir joueur : ennemis touchés
			for (AVaisseau t : tirs_joueur){
				for (AVaisseau v : vaisseaux){
					if (collision(t.getPosition().getXpix(), t.getPosition().getYpix() , v.getPosition().getXpix(), v.getPosition().getYpix()) == true){
						tirs_joueur.remove(t);
						vaisseaux.remove(v);
						return;
					}
				}
			}
		}

		// tous les vaisseaux ennemis sont détruits
		if (vaisseaux.size() == 0){
			joueur.dessiner();
			textSize(100);
			fill(0,250,100);
			text("GAGNE !!!", 350,400);
		}

		//  le joueur est touché
		if (joueurVie == false){
			for (AVaisseau v : vaisseaux) {
				v.dessiner();
			}
			textSize(80);
			fill(255,0,0);
			text("PERDU !!!", 400,450);
		}

	}

	public boolean collision(int xTir,int yTir,int xEnnemi,int yEnnemi){
		int colX = xTir - xEnnemi;
		int colY = yTir - yEnnemi;
		if (colX < 15 && colX > -15 && colY > -15  && colY < 15){ //  && colX > -10 && colY > -10
			return true;
		}
		else{
			return false;
		}
	}

	public static void main(String[] args) {
		PApplet.main("controleur.FenetreControleur");
	}

}
