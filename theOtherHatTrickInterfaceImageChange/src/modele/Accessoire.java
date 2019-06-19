package modele;

public class Accessoire {
	//attributs
	private NomDeCarte nom;
	private boolean face;//1 l'avers visible 0 l'avers invisible
	private int numero;
	//methods
	public Accessoire(NomDeCarte nom){
		this.nom = nom;
		this.face = false;
		if( nom == NomDeCarte.TheRabbit)
			numero = 1;
		else if( nom == NomDeCarte.TheOtherRabbit)
			numero = 2;
		else if( nom == NomDeCarte.Carrots)
			numero = 3;
		else if( nom == NomDeCarte.TheLettuce)
			numero = 4;
		else if( nom == NomDeCarte.TheHat)
			numero = 5;
	}
	public int getNumero(){ return this.numero;}
	public NomDeCarte getNom(){ return this.nom;}
	public boolean estTourne(){ return this.face;}
	public void tourner(){ this.face = (this.face)?false:true;}
	
}
