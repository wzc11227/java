package vue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JFrame;

import modele.Deck;
import modele.Jeu;
import modele.Joueur;
import modele.JoueurReel;
import modele.Pile;
import modele.Truc;

public class VueTexte implements Observer, Runnable{
	public static String QUITTER = "Quit";
    public static String PROMPT = ">";
    public static boolean OPENED1 = false;
    public static boolean OPENED2 = false;
    public static boolean OPENED3 = false;
    public static String MODE1;
    public static String MODE2;
    public static String MODE3;
    
    private Jeu jeu;
    public VueTexte(Jeu jeu) {
    	this.jeu = jeu;

    	for (int i = 0; i < 3; i++) {
    	    this.jeu.getJoueurs()[i].addObserver(this);
    	}
    	jeu.getPile().addObserver(this);
    	jeu.getDeck().addObserver(this);
    	jeu.addObserver(this);
    	Thread t = new Thread(this);
    	t.start();
    }
    

    
    public void run() {

    	String saisie = null;
    	boolean quitter = false;

    	System.out.println("Taper " + VueTexte.QUITTER + " pour quitter.");

    	do {
    	    saisie = this.lireChaine();
    	    if (VueTexte.MODE1 == "int2")	VueTexte.OPENED1 = true;
    	    if (VueTexte.MODE2 == "int2")	VueTexte.OPENED2 = true;
    	    if (VueTexte.MODE3 == "int2")	VueTexte.OPENED3 = true;
    	    if (saisie != null) {
    	    	if (saisie.equals(VueTexte.QUITTER) == true) {
    	    		quitter = true;		    
    	    	} 
    	    	else if ((saisie.equals("1") == true) && VueTexte.OPENED1) {
    	    		if (MODE1 == "boolean"){
    	    			jeu.setBool(true);
    	    		}	
    	    		else if (MODE1 == "boolean'"){
    	    			jeu.setBool(false);
    	    		}
    	    		else if (MODE1 == "int"){
    	    			jeu.setInt1(0);
    	    		}
    	    		else if (MODE1 == "int1"){
    	    			jeu.setInt1NoNotify(0);
    	    			MODE2 = "int2";
    	    			MODE3 = "int2";
    	    		}
    	    		else if (MODE1 == "int2"){
    	    			jeu.setInt2(0);
    	    			MODE1 = "";
    	    			MODE2 = "";
    	    			MODE3 = "";
    	    		}
    	    		VueTexte.OPENED1 = false;
    	    	    VueTexte.OPENED2 = false;
    	    	    VueTexte.OPENED3 = false;
    	    	}
    	    	else if ((saisie.equals("2") == true) && VueTexte.OPENED2) {
    	    		if (MODE2 == "boolean"){
    	    			jeu.setBool(false);
    	    		}	
    	    		else if (MODE2 == "boolean'"){
    	    			jeu.setBool(true);
    	    		}
    	    		else if (MODE2 == "int"){
    	    			jeu.setInt1(1);
    	    		}
    	    		else if (MODE2 == "int1"){
    	    			jeu.setInt1NoNotify(1);
    	    			MODE1 = "int2";
    	    			MODE3 = "int2";
    	    		}
    	    		else if (MODE2 == "int2"){
    	    			jeu.setInt2(1);
    	    			MODE1 = "";
    	    			MODE2 = "";
    	    			MODE3 = "";
    	    		}
    	    		VueTexte.OPENED1 = false;
    	    	    VueTexte.OPENED2 = false;
    	    	    VueTexte.OPENED3 = false;
    	    	}
    	    	else if ((saisie.equals("3") == true) && VueTexte.OPENED3) {
    	    		if (MODE3 == "int1"){
    	    			jeu.setInt1NoNotify(2);
    	    			MODE1 = "int2";
    	    			MODE2 = "int2";
    	    		}
    	    		else if (MODE3 == "int2"){
    	    			jeu.setInt2(2);
    	    			MODE1 = "";
    	    			MODE2 = "";
    	    			MODE3 = "";
    	    		}
    	    		VueTexte.OPENED1 = false;
    	    	    VueTexte.OPENED2 = false;
    	    	    VueTexte.OPENED3 = false;
    	    	}
    	    	else {
    	    		System.out.println("Commande non reconnue...");
    			}		
    	    }
    	    
    	} while (quitter == false);
    	System.exit(0);
    }
    
    public void print(){
    	System.out.println("Nom:" + jeu.getJoueurs()[jeu.getJoueurActuel()].getPrenom());
    	System.out.println("Note:" + jeu.getJoueurs()[jeu.getJoueurActuel()].getNote());
    	if (jeu.getJoueurs()[jeu.getJoueurActuel()] instanceof JoueurReel ||
    		jeu.getJoueurs()[jeu.getJoueurActuel()].getCarte()[0].estTourne())
    		System.out.println("Carte1:" + jeu.getJoueurs()[jeu.getJoueurActuel()].getCarte()[0].getNom());
    	else
    		System.out.println("Carte1:invisible");
    	if (jeu.getJoueurs()[jeu.getJoueurActuel()] instanceof JoueurReel ||
        	jeu.getJoueurs()[jeu.getJoueurActuel()].getCarte()[1].estTourne())
        	System.out.println("Carte2:" + jeu.getJoueurs()[jeu.getJoueurActuel()].getCarte()[1].getNom());
        else
        	System.out.println("Carte2:invisible");
    	
    	System.out.println("Nom:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getPrenom());
    	System.out.println("Note:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getNote());
    	if (jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getCarte()[0].estTourne())
    		System.out.println("Carte1:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getCarte()[0].getNom());
    	else
    		System.out.println("Carte1:invisible");
    	if (jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getCarte()[1].estTourne())
    		System.out.println("Carte1:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getCarte()[1].getNom());
    	else
    		System.out.println("Carte1:invisible");
    	
    	System.out.println("Nom:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+2)%3].getPrenom());
    	System.out.println("Note:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+2)%3].getNote());
    	if (jeu.getJoueurs()[(jeu.getJoueurActuel()+2)%3].getCarte()[0].estTourne())
    		System.out.println("Carte1:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getCarte()[0].getNom());
    	else
    		System.out.println("Carte1:invisible");
    	if (jeu.getJoueurs()[(jeu.getJoueurActuel()+2)%3].getCarte()[1].estTourne())
    		System.out.println("Carte1:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getCarte()[1].getNom());
    	else
    		System.out.println("Carte1:invisible");
    	
    	if (!jeu.getPile().getPile().isEmpty()){
	    	System.out.println("Pile:" + jeu.getPile().getPile().peek().getNom());
	    	System.out.println(jeu.getPile().getPile().peek().getMethode());
    	}
    	else
    		System.out.println("Pile:vide");
    	
    	
    	System.out.println();
    	
    }
    
    private String lireChaine() {
    	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    	String resultat = null;
    	try {
    	    System.out.print(VueTexte.PROMPT);
    	    resultat = br.readLine();
    	} catch (IOException e) {
    	    System.err.println(e.getMessage());
    	}
    	return resultat;	
    }
    
    public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if( arg0 instanceof Joueur){
			if(arg1 == "choisirUnTruc"){
				System.out.println("Tu veux choisir ce truc?");
				System.out.println(jeu.getPile().getPile().peek().getNom());
				System.out.println(jeu.getPile().getPile().peek().getMethode());
				System.out.println("1.Oui 2.Non");
				System.out.print(VueTexte.PROMPT);
				VueTexte.OPENED1 = true;
				VueTexte.OPENED2 = true;
				VueTexte.MODE1 = "boolean";
				VueTexte.MODE2 = "boolean";
			}
			else if(arg1 == "choisirUnJoueur"){
				int num = jeu.getNum((Joueur)arg0);
				Joueur joueur1 = jeu.getJoueurs()[(num+2)%3];
				Joueur joueur2 = jeu.getJoueurs()[(num+1)%3];
				System.out.println("Choisir un joueur");
				System.out.println("1." + joueur1.getPrenom() + "\n2." + joueur2.getPrenom());
				System.out.print(VueTexte.PROMPT);
				VueTexte.OPENED1 = true;
				VueTexte.OPENED2 = true;
				VueTexte.MODE1 = "boolean'";
				VueTexte.MODE2 = "boolean'";
			}
			else if(arg1 == "choisirUneCarteEchanger1"){
				System.out.println("Choisir une de tes cartes");
				System.out.println("1."+((Joueur)arg0).getCarte()[0].getNom() +
								   "\n2."+((Joueur)arg0).getCarte()[1].getNom());
				System.out.print(VueTexte.PROMPT);
				VueTexte.OPENED1 = true;
				VueTexte.OPENED2 = true;
				VueTexte.MODE1 = "int";
				VueTexte.MODE2 = "int";
			}
			else if(arg1 instanceof Joueur){
				System.out.println("Choisir une de ses cartes");
				if(((Joueur)arg1).getCarte()[0].estTourne())
					System.out.println("1."+((Joueur)arg1).getCarte()[0].getNom());
				else
					System.out.println("1.invisible");
				if(((Joueur)arg1).getCarte()[1].estTourne())
					System.out.println("2."+((Joueur)arg1).getCarte()[1].getNom());
				else
					System.out.println("2.invisible");
				System.out.print(VueTexte.PROMPT);
				VueTexte.OPENED1 = true;
				VueTexte.OPENED2 = true;
				VueTexte.MODE1 = "int";
				VueTexte.MODE2 = "int";
			}
			else if(arg1 == "effectuer"){
				System.out.println("Tu peux effectuer, veux-tu?");
				System.out.println("1.Oui 2.Non");
				System.out.print(VueTexte.PROMPT);
				VueTexte.OPENED1 = true;
				VueTexte.OPENED2 = true;
				VueTexte.MODE1 = "boolean";
				VueTexte.MODE2 = "boolean";
			}
			else if(arg1 == "nouvellesCartes"){
				System.out.println("Choisir 2 des carte que tu veux");
				System.out.println("1."+((Joueur)arg0).getCarte()[0].getNom() +
				   		   		   "\n2."+((Joueur)arg0).getCarte()[1].getNom());
				System.out.println("3." + jeu.getSeptieme().getNom());
				System.out.print(VueTexte.PROMPT);
				VueTexte.OPENED1 = true;
				VueTexte.OPENED2 = true;
				VueTexte.OPENED3 = true;
				VueTexte.MODE1 = "int1";
				VueTexte.MODE2 = "int1";
				VueTexte.MODE3 = "int1";
			}
			else if(arg1 == "choisirUneCarteTourner"){
				if(((Joueur)arg0).getCarte()[0].estTourne()&&((Joueur)arg0).getCarte()[1].estTourne()){
					
				}
				else{
					System.out.println("Choisir une de tes cartes a tourner");
					if(((Joueur)arg0).getCarte()[0].estTourne()&&!((Joueur)arg0).getCarte()[1].estTourne())
						System.out.println("2." + ((Joueur)arg0).getCarte()[1].getNom());
					else if(!((Joueur)arg0).getCarte()[0].estTourne()&&((Joueur)arg0).getCarte()[1].estTourne())
						System.out.println("1." + ((Joueur)arg0).getCarte()[0].getNom());
					else{
						System.out.println("1." + ((Joueur)arg0).getCarte()[0].getNom());
						System.out.println("2." + ((Joueur)arg0).getCarte()[1].getNom());
					}
					System.out.print(VueTexte.PROMPT);
					VueTexte.OPENED1 = true;
					VueTexte.OPENED2 = true;
					VueTexte.MODE1 = "int";
					VueTexte.MODE2 = "int";
				}
			}
			else if(arg1 instanceof int[]){
				if(((int[])arg1)[0] == -1){}
				else{
					System.out.println(jeu.getJoueurs()[((int[])arg1)[0]].getPrenom());
					if (((int[])arg1)[1] != -1)
						System.out.println(jeu.getJoueurs()[((int[])arg1)[1]].getPrenom());
					if (((int[])arg1)[2] != -1)
						System.out.println(jeu.getJoueurs()[((int[])arg1)[2]].getPrenom());
					System.out.println("Win!");
				}
			}
			else if(arg1 instanceof Truc){
				System.out.println(jeu.getJoueurs()[jeu.getJoueurActuel()].getPrenom()+" a reussi de effectuer ce truc:" + ((Truc)arg1).getNom());
				System.out.println("1.Oui");
				System.out.print(VueTexte.PROMPT);
				VueTexte.OPENED1 = true;
				VueTexte.MODE1 = "boolean";
			}
			else if(arg1 == "echec"){
				System.out.println(jeu.getJoueurs()[jeu.getJoueurActuel()].getPrenom()+" a echoue de effectuer ce truc:" + jeu.getPile().getPile().peek().getNom());
				System.out.println("1.Oui");
				System.out.print(VueTexte.PROMPT);
				VueTexte.OPENED1 = true;
				VueTexte.MODE1 = "boolean";
			}
			else{
				print();
			}
				
			
			
		}
		else if( arg0 instanceof Jeu){
			print();
		}
		else if( arg0 instanceof Pile){
			print();
		}
	}
    

}
