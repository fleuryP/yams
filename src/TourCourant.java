
import java.util.*;

public class TourCourant {
	
	private De[] des;
    private int[] count;
    Score score;
    
    public TourCourant(){
        des = new De[5];
        for(int i = 0; i < 5; i++)
            des[i] = new De();
        lancerDes(); 
        count = new int[6];
        updateCount();
    }
   
    
    public int getDe(int numDe) {
    	return des[numDe-1].getValeur();
    	
    }
    
    public String toString() {
		//affiche le score au joueur afin qu'il selectionne les des à rejouer
		String res="";
		for(int i=0; i<5; i++) {
			res+="de "+(int)(i+1)+" = "+des[i]+"\n" ;
		}
		return res;
		
	}
	public void relancer(int[] tab) { 
		System.out.println("aaaa"+Arrays.toString(tab)+"la longueur: "+tab.length);
		for (int i=0;i<tab.length;i++) { 
			if(!(tab[i]-1==0)){ // si tab[i]-1 n'est pas égal à -1, soit si il a pas été modifier 
				des[tab[i]-1].setValeur(des[tab[i]-1].lancer()); // on relance le dé a la position donnée
				// ne fonctionne pas correctement a voir pourquoi 
			}
		}
	}
	// mettre a -1
	
	public int[] reponse(String s) {
		int [] tab = {0,0,0,0,0}; // tableau de 5 valeurs car 5 des
		for(int i=0; i<s.length(); i++) { // tant que l'on a pas regarder tout les caractères de la chaine
			tab[i]=Character.getNumericValue(s.charAt(i)); // on stock chaque caractère dans un tableau
			System.out.println(Arrays.toString(tab));
		}
		return tab;
	}
	
