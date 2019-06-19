package modele;

import java.util.HashSet;
import java.util.Set;

public class JoueurVirtuel extends Joueur {
	private static int nombre = 0;
	public JoueurVirtuel (){
		super("JoueurVirtuel"+(++nombre), 10+(int)(Math.random()*30));
	}
	public boolean choisirUnTruc(Jeu jeu){
		if(Math.random()<0.5)
			return true;
		else
			return false;
	}
	public boolean choisirUnJoueur(Jeu jeu){
		if(Math.random()<0.5)
			return true;
		else
			return false;
	}
	public int choisirUneCarteEchanger(Jeu jeu){
		return (int) Math.round(Math.random());
	}
	public int choisirUneCarteEchanger(Joueur j, Jeu jeu){
		return choisirUneCarteEchanger(jeu);
	}
	public boolean effectuer(Jeu jeu){
		return true;
	}
	public int[] nouvellesCartes(Jeu jeu){
		Set<Integer> set = new HashSet<Integer>();
		while(set.size()<2){
			set.add((int)Math.round(Math.random()));
		}
		int[] index = new int[2];
		index[0] = set.toArray(new Integer[0])[0];
		index[1] = set.toArray(new Integer[0])[1];
		return index;
	}
	public int choisirUneCarteTourner(Jeu jeu){
		if(this.getCarte()[0].estTourne()&&!this.getCarte()[1].estTourne())
			return 1;
		else if(!this.getCarte()[0].estTourne()&&this.getCarte()[1].estTourne())
			return 0;
		else if(!this.getCarte()[0].estTourne()&&!this.getCarte()[1].estTourne())
			return (int)Math.round(Math.random());
		else
			return -1;
	}

}
