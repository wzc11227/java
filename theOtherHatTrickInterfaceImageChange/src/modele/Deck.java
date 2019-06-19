package modele;
import java.util.Stack;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.ArrayList;

public class Deck extends Observable{
	//attributs
	private Stack<Truc> cartesDeDeck;
	//methodes
	public Deck(){
		this.cartesDeDeck = new Stack<Truc>();
		List<Truc> list = new ArrayList<Truc>();
		list.add(new Truc(new NomDeCarte[]{NomDeCarte.TheRabbit, NomDeCarte.TheOtherRabbit}
						 ,new NomDeCarte[]{NomDeCarte.Carrots,NomDeCarte.TheLettuce}
						 ,"The Hungry Rabbit"
						 ,1
						 ,1));
		list.add(new Truc(new NomDeCarte[]{NomDeCarte.Carrots}
						 ,new NomDeCarte[]{NomDeCarte.Carrots}
						 ,"The Bunch of Carrots"
						 ,2
						 ,2));
		list.add(new Truc(new NomDeCarte[]{NomDeCarte.Carrots}
						 ,new NomDeCarte[]{NomDeCarte.TheLettuce}
						 ,"The Vegatable Patch"
						 ,3
						 ,3));
		list.add(new Truc(new NomDeCarte[]{NomDeCarte.TheRabbit, NomDeCarte.TheOtherRabbit}
						 ,new NomDeCarte[]{NomDeCarte.TheLettuce}
						 ,"The Rabbit That Didn't Like Carrots"
						 ,4
						 ,4));
		list.add(new Truc(new NomDeCarte[]{NomDeCarte.TheRabbit}
						 ,new NomDeCarte[]{NomDeCarte.TheOtherRabbit}
						 ,"The Pair of Rabbits"
						 ,5
						 ,5));
		list.add(new Truc(new NomDeCarte[]{NomDeCarte.TheHat}
						 ,new NomDeCarte[]{NomDeCarte.TheLettuce, NomDeCarte.Carrots}
						 ,"The Vegatable Hat Trick"
						 ,2
						 ,6));
		list.add(new Truc(new NomDeCarte[]{NomDeCarte.TheHat}
						 ,new NomDeCarte[]{NomDeCarte.Carrots}
		 				 ,"The Carrot Hat Trick"
						 ,3
						 ,7));
		list.add(new Truc(new NomDeCarte[]{NomDeCarte.TheHat}
						 ,new NomDeCarte[]{NomDeCarte.TheRabbit, NomDeCarte.TheOtherRabbit}
						 ,"The Slightly Easier Hat Trick"
						 ,4
						 ,8));
		list.add(new Truc(new NomDeCarte[]{NomDeCarte.TheHat}
						 ,new NomDeCarte[]{NomDeCarte.TheRabbit}
						 ,"The Hat Trick"
						 ,5
						 ,9));
		Collections.shuffle(list);
		cartesDeDeck.push(new Truc(new NomDeCarte[]{NomDeCarte.TheHat}
								  ,new NomDeCarte[]{NomDeCarte.TheOtherRabbit}
								  ,"The Other Hat Trick"
								  ,6
								  ,10));
		cartesDeDeck.addAll(list);
	}
	public Stack<Truc> getDeck(){ return this.cartesDeDeck;}
	public Truc pop() {
		Truc t = cartesDeDeck.pop();
		setChanged();
		notifyObservers();
		return t;
	}
	
}
