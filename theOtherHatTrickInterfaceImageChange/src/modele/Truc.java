package modele;

public class Truc {
	//attributs
	private NomDeCarte[] carte1;
	private NomDeCarte[] carte2;
	private String nom;
	private int note;
	private int numero;
	//methods
	public Truc(NomDeCarte[] carte1, NomDeCarte[] carte2, String nom, int note, int numero){
		this.carte1 = carte1;
		this.carte2 = carte2;
		this.note = note;
		this.nom = nom;
		this.numero = numero;
	}
	public NomDeCarte[] getCarte1(){ return this.carte1;}
	public NomDeCarte[] getCarte2(){ return this.carte2;}
	public int getNote(){ return this.note;}
	public String getNom(){ return this.nom;}
	public int getNumero(){ return this.numero;}
	public String getMethode(){
		String s = "";
		s += carte1[0].toString();
		if (carte1.length == 2){
			s += "/";
			s += carte1[1].toString();
		}
		s += "+";
		s += carte2[0].toString();
		if (carte2.length == 2){
			s += "/";
			s += carte2[1].toString();
		}
		return s;
	}
	public boolean exist(NomDeCarte nom, int partie){
		if (partie == 1)
			for ( NomDeCarte nomdc:this.carte1)
				if (nomdc == nom)
					return true; else{}
		else
			for ( NomDeCarte nomdc:this.carte2)
				if (nomdc == nom)
					return true; else{}
		return false;
	}
	public void printInfo(){
		System.out.println("Le nom du Truc:" + nom);
		for (int i=0; i<this.carte1.length; i++){
			System.out.print(this.carte1[i]);
			if (i<this.carte1.length-1)
				System.out.print("/");
		}
		System.out.print("\n");
		for (int i=0; i<this.carte2.length; i++){
			System.out.print(this.carte2[i]);
			if (i<this.carte2.length-1)
				System.out.print("/");
		}
		System.out.print("\n\n");
	}
	
	
}
