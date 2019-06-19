package modele;
import java.util.*;


public class Jeu extends Observable{
	//Attributs
	private Pile pile;
	private int count;
	private Deck deck;
	private Joueur[] joueurs;
	private Accessoire septieme;
	private boolean termine;
	private int joueurActuel;
	private boolean choisirBool;
	private int choisirInt1;
	private int choisirInt2;
	//Methodes
	public boolean getBool(){ return choisirBool; }
	public int getInt1(){ return choisirInt1; }
	public int getInt2(){ return choisirInt2; }
	public void setBool(boolean bool){ 
		choisirBool = bool; 
		setChanged();
		notifyObservers("bool");
	}
	public void setInt1(int i){ 
		choisirInt1 = i; 
		setChanged();
		notifyObservers("int1");
	}
	public void setInt1NoNotify(int i){ choisirInt1 = i; }
	public void setInt2(int i){ 
		choisirInt2 = i; 
		setChanged();
		notifyObservers("int2");
	}
	public Jeu(Joueur joueur1, Joueur joueur2, Joueur joueur3){
		this.count=0;
		this.termine = false;
		this.joueurActuel = 0;
		this.pile = new Pile();
		this.deck = new Deck();
		this.joueurs = new Joueur[3];
		if (joueur1.getAge() <= joueur2.getAge() && joueur1.getAge() <= joueur3.getAge())
		{
			this.joueurs[0] = joueur1;
			if (joueur2.getAge() <= joueur3.getAge()){ this.joueurs[1] = joueur2; this.joueurs[2] = joueur3;}
			else{ this.joueurs[1] = joueur3; this.joueurs[2] = joueur2;}
		}
		else if (joueur2.getAge() <= joueur1.getAge() && joueur2.getAge() <= joueur3.getAge())
		{
			this.joueurs[0] = joueur2;
			if (joueur1.getAge() <= joueur3.getAge()){ this.joueurs[1] = joueur1; this.joueurs[2] = joueur3;}
			else{ this.joueurs[1] = joueur3; this.joueurs[2] = joueur1;}
		}
		else if (joueur3.getAge() <= joueur1.getAge() && joueur3.getAge() <= joueur2.getAge())
		{
			this.joueurs[0] = joueur3;
			if (joueur1.getAge() <= joueur2.getAge()){ this.joueurs[1] = joueur1; this.joueurs[2] = joueur2;}
			else{ this.joueurs[1] = joueur2; this.joueurs[2] = joueur1;}
		}
		List<Accessoire> list = new ArrayList<Accessoire>();
		list.add(new Accessoire(NomDeCarte.Carrots));
		list.add(new Accessoire(NomDeCarte.Carrots));
		list.add(new Accessoire(NomDeCarte.Carrots));
		list.add(new Accessoire(NomDeCarte.TheHat));
		list.add(new Accessoire(NomDeCarte.TheLettuce));
		list.add(new Accessoire(NomDeCarte.TheOtherRabbit));
		list.add(new Accessoire(NomDeCarte.TheRabbit));
		Collections.shuffle(list);
		for (int i=0; i<3; i++)
			for (int j=0; j<2; j++)
				joueurs[i].getCarte()[j] = list.remove(0);
		this.septieme = list.remove(0);
	}
	public Pile getPile(){ return this.pile;}
	public Deck getDeck(){ return this.deck;}
	public Accessoire getSeptieme(){ return this.septieme;}
	public Joueur[] getJoueurs(){ return this.joueurs;}
	public boolean estTermine(){ return this.termine;}
	public int getJoueurActuel(){ return this.joueurActuel;}
	public void terminer(){ this.termine = true;	}
	public void setSeptieme(Accessoire a){ 
		this.septieme = a;
	}
	public int getCount(){ return this.count;}
	public void addCount(){ this.count++;}
	public int getNum(Joueur j){
		for(int i=0;i<3;i++)
			if(joueurs[i] == j)
				return i;
		return -1;
	}
	public void tour(int j)throws Exception{
		{//echanger
			boolean bool, joueurEchanger;
			int carte1, carte2;
			Joueur joueurE;
			setChanged();
			notifyObservers();
			if (pile.getPile().isEmpty())
				pile.push(deck.pop());
			bool = joueurs[j].choisirUnTruc(this);
			if( !(bool||deck.getDeck().isEmpty()))
				pile.push(deck.pop());
			joueurEchanger = joueurs[j].choisirUnJoueur(this);
			joueurE = joueurEchanger?joueurs[(j+1)%3]:joueurs[(j+2)%3];
			carte1 = joueurs[j].choisirUneCarteEchanger(this);
			carte2 = joueurs[j].choisirUneCarteEchanger(joueurE, this);
			joueurs[j].swap(joueurE, carte1, carte2);
		}
		{//perform
			Joueur jj = joueurs[j];
			Truc trucChoisi = pile.getPile().peek();
			boolean choisir;
			if(trucChoisi.exist(jj.getCarte()[0].getNom(), 1)) {//第一部分匹配
				if(trucChoisi.exist(jj.getCarte()[1].getNom(), 2)){
					choisir = jj.effectuer(this);
					if( choisir)
						jj.success(this);
					else
						jj.echec(this);
				}
				else{
					jj.echec(this);
				}
			}
			else{//第一部分不匹配
				if(trucChoisi.exist(jj.getCarte()[0].getNom(), 2)){
					if(trucChoisi.exist(jj.getCarte()[1].getNom(), 1)){
						choisir = jj.effectuer(this);
						if( choisir)
							jj.success(this);
						else
							jj.echec(this);
					}
					else{
						jj.echec(this);
					}
				}
				else{
					jj.echec(this);
				}
			}
		}

	}
	public void game() throws Exception{
		while(!estTermine()){
			tour(joueurActuel);
			joueurActuel = (joueurActuel+1)%3;
		}
	}
}
