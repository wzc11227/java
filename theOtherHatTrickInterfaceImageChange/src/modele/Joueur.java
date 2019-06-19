package modele;

import java.util.*;
public abstract class Joueur extends Observable {
	private String prenom;
	private int age;
	private Accessoire[] cartes;
	private int note;
	public Joueur(String prenom, int age){
		this.prenom = prenom;
		this.age = age;
		this.note = 0;
		this.cartes = new Accessoire[2];
	}
	public String getPrenom(){ return this.prenom;}
	public int getAge(){ return this.age;}
	public int getNote(){ return this.note;}
	public Accessoire[] getCarte(){ return this.cartes;}
	public void setPrenom(String prenom){ this.prenom=prenom;}
	public void setAge(int age){ this.age=age;}
	public void setNote(int note){ 
		this.note = note;
		setChanged();
		notifyObservers();
	}
	public void addNote(int note){ 
		this.note += note;
		setChanged();
		notifyObservers();
	}
	public void setCarte(int index, Accessoire carte){ 
		this.cartes[index] = carte;
		setChanged();
		notifyObservers();
	}
	public abstract boolean choisirUnTruc(Jeu jeu);
	public abstract boolean choisirUnJoueur(Jeu jeu);
	public abstract int choisirUneCarteEchanger(Jeu jeu);
	public abstract int choisirUneCarteEchanger(Joueur j, Jeu jeu);
	public void swap(Joueur j, int index_this, int index_j){
		Accessoire a = this.getCarte()[index_this];
		this.getCarte()[index_this] = j.getCarte()[index_j];
		j.getCarte()[index_j] = a;
		setChanged();
		notifyObservers();
	}
	public abstract boolean effectuer(Jeu jeu);
	public void success(Jeu jeu) throws Exception{
		Truc t = jeu.getPile().pop();
		setChanged();
		notifyObservers(t);
		this.addNote(t.getNote()); //加分
		this.terminerApresSuccess(jeu);
		if(!jeu.estTermine()){
			int[] index = this.nouvellesCartes(jeu);
			this.swap7(jeu, index[0], index[1]);
		}
	}
	public abstract int[] nouvellesCartes(Jeu jeu);
	public void terminerApresSuccess(Jeu jeu){
		//是否为最后一张戏法牌
		int[] resultat = new int[3];
		if(jeu.getDeck().getDeck().isEmpty()) {
			jeu.terminer();
			int max=-1;
			int joueurGagnant1=-10;
			int joueurGagnant2=-1;
			int joueurGagnant3=-1;
			for(int x=0;x<3;x++) {
				if(jeu.getJoueurs()[x].getNote() > max){
					max=jeu.getJoueurs()[x].getNote();
					joueurGagnant1=x;
					joueurGagnant2=-1;
					joueurGagnant3=-1;
				}
				else if(jeu.getJoueurs()[x].getNote() == max){
					if(joueurGagnant2>=0)
						joueurGagnant3=x;
					else
						joueurGagnant2=x;
				}
					
			}
			resultat[0] = joueurGagnant1;
			resultat[1] = joueurGagnant2;
			resultat[2] = joueurGagnant3;
		}
		else{
			resultat[0] = -1;
			resultat[1] = -1;
			resultat[2] = -1;
		}
		
		setChanged();
		notifyObservers(resultat);
	}
	public void swap7(Jeu jeu, int index1, int index2){
		//和第七张牌交换
		Accessoire[] a = new Accessoire[3];
		a[0]=this.getCarte()[0];
		a[1]=this.getCarte()[1];
		a[2]=jeu.getSeptieme();
		for(int i=0; i<3; i++)
			if(a[i].estTourne())
				a[i].tourner();
		this.setCarte(0, a[index1]);
		this.setCarte(1, a[index2]);
		jeu.setSeptieme(a[3-index1-index2]);
		setChanged();
		notifyObservers();
	}
	public void echec(Jeu jeu) throws Exception{
		terminerApresEchec(jeu);
		if(!jeu.estTermine()){
			tourner(choisirUneCarteTourner(jeu));
		}
		setChanged();
		notifyObservers("echec");
	}
	public abstract int choisirUneCarteTourner(Jeu jeu);
	public void terminerApresEchec(Jeu jeu){
		int[] resultat = new int[3];
		if(jeu.getDeck().getDeck().isEmpty()){
			jeu.addCount();
			if(jeu.getCount()==3) {
				jeu.terminer();
				for(int i=0;i<3;i++) 
					for(int a=0;a<2;a++) 
						if(jeu.getJoueurs()[i].getCarte()[a].getNom()==NomDeCarte.TheHat
						|| jeu.getJoueurs()[i].getCarte()[a].getNom()==NomDeCarte.TheOtherRabbit)
							jeu.getJoueurs()[i].addNote(-3);
				int max=-1;
				int joueurGagnant1=-10;
				int joueurGagnant2=-1;
				int joueurGagnant3=-1;
				for(int x=0;x<3;x++) {
					if(jeu.getJoueurs()[x].getNote() > max){
						max=jeu.getJoueurs()[x].getNote();
						joueurGagnant1=x;
						joueurGagnant2=-1;
						joueurGagnant3=-1;
					}
					else if(jeu.getJoueurs()[x].getNote() == max){
						if(joueurGagnant2>=0)
							joueurGagnant3=x;
						else
							joueurGagnant2=x;
					}		
				}
				resultat[0] = joueurGagnant1;
				resultat[1] = joueurGagnant2;
				resultat[2] = joueurGagnant3;
			}else{
				resultat[0] = -1;
				resultat[1] = -1;
				resultat[2] = -1;
			}
		}else{
			resultat[0] = -1;
			resultat[1] = -1;
			resultat[2] = -1;
		}
		setChanged();
		notifyObservers(resultat);
	}
	public void tourner(int index){
		if(index != -1)
			this.getCarte()[index].tourner();
		setChanged();
		notifyObservers();
	}
}
