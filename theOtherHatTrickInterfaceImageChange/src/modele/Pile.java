package modele;
import java.util.Observable;
import java.util.Stack;

public class Pile extends Observable{
	//attributs
	private Stack<Truc> cartesDePile;
	//methodes
	public Pile(){
		this.cartesDePile = new Stack<Truc>();
	}
	public Stack<Truc> getPile(){ return this.cartesDePile;}
	public synchronized Truc pop() {
		Truc t = cartesDePile.pop();
		setChanged();
		notifyObservers();
		return t;
	}
	
	public synchronized void push(Truc t) {
		cartesDePile.push(t);
		setChanged();
		notifyObservers();
	}
}
