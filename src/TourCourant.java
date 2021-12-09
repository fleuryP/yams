package version2avecRelance;
import java.util.*;

public class TourCourant {
	
    De[] des;
    Score score;
    
    public TourCourant(){
        des = new De[5];
        for(int i = 0; i < 5; i++) {
            des[i] = new De();
        	des[i].setValeur(des[i].lancer());
        }
    }

    
    public int totalDes(De[] tabDe) {
    	int somme=0;
    	for(int i=0;i<tabDe.length;i++) {
    		somme+=tabDe[i].getValeur();
    	}
    	return somme;
    }
   
    
    public int getDe(int numDe) {
    	return des[numDe-1].getValeur();
    	
    }
    
    //à ajouter
    public int getIndice(De [] tableau, int numDe) {
    	return Arrays.asList(tableau).indexOf(numDe);
    	
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
		for (int i=0;i<tab.length;i++) { 
			if(!(tab[i]==0)){ 
				des[tab[i]-1].setValeur(des[tab[i]-1].lancer()); // on relance le dé a la position donnée			
				}
		}
	}
	
	
	public int[] reponse(String s) {
		int [] tab = {0,0,0,0,0}; // tableau de 5 valeurs car 5 des
		for(int i=0; i<s.length(); i++) { // tant que l'on a pas regarder tout les caractères de la chaine
			tab[i]=Character.getNumericValue(s.charAt(i)); // on stock chaque caractère dans un tableau
		}
		return tab;
	}
	
	public int [] getOccurence (int [] tab) {
        int [] count = new int[7];
        /* i : compteur, tmp : stock tmporairement la valeur 
        à un certain index du tableau tab[]*/
        int i,tmp = 0;
        /* tmp agira comme une valeur d'index pour le tableau count 
        et gardera une trace du nombre d'occurrences de chaque nombre*/
        for(i = 0; i < tab.length; i++){
                tmp = tab[i];
                count[tmp]++;
        }
        return count;
	}
	

	
}
