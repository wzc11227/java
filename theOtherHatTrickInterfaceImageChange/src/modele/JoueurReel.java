package modele;


public class JoueurReel extends Joueur {
	public JoueurReel(){
		super("", 0);
	}
	public JoueurReel(String prenom, int age){
		super(prenom, age);
	}
	public boolean choisirUnTruc(Jeu jeu){//choisir un truc
		setChanged();
		notifyObservers("choisirUnTruc");
		return jeu.getBool();
	}
	public boolean choisirUnJoueur(Jeu jeu){//false=gauche true=droite
		setChanged();
		notifyObservers("choisirUnJoueur");
		return jeu.getBool();
	}
	public int choisirUneCarteEchanger(Jeu jeu){
		setChanged();
		notifyObservers("choisirUneCarteEchanger1");
		return jeu.getInt1();
	}
	public int choisirUneCarteEchanger(Joueur j, Jeu jeu){
		setChanged();
		notifyObservers(j);
		return jeu.getInt1();
	}
	public boolean effectuer(Jeu jeu){
		setChanged();
		notifyObservers("effectuer");
		return jeu.getBool();
	}
	public int[] nouvellesCartes(Jeu jeu){
		int[] index = new int[2];
		setChanged();
		notifyObservers("nouvellesCartes");
		index[0] = jeu.getInt1();
		index[1] = jeu.getInt2();
		return index;
	}
	public int choisirUneCarteTourner(Jeu jeu){
		setChanged();
		notifyObservers("choisirUneCarteTourner");
		return jeu.getInt1();
	}
}
