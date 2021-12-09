
public class UpperFirst {
	int numJoueur;
	String[][] grille;
	
	public UpperFirst(int numJoueur, String[][] grille) {
		this.numJoueur=numJoueur;
		this.grille=grille;
	}
	
	public int[] countUp(De[] des){
    	int[]tab= {0,0,0,0,0,0};
    	for(int i=0; i<5; i++) {
    		if(des[i].getValeur()==i+1)
    			tab[i]++;
    	}
    	return tab;		
    }
	
	public int maxdeValeur(De[]des) {
		int[]tab=countUp(des);
		int valeur=1;
		int[]tabLibre= new int[6];
		for(int i=1; i<6; i++) {
			if (grille[i][numJoueur]==null) {
				tabLibre[i]=tab[i];
			}
			else
				tabLibre[i]=-1;
				
		}
		for(int i=1; i<6; i++) {
			if(tabLibre[i]>tabLibre[i-1]) {
				valeur++;
			}
		}
		return valeur;		
	}
	
	public int[] desArelancer(De[]des) {
		int [] tab = {0,0,0,0,0};
		int valeur=maxdeValeur(des);
		int j=0;
		for(int i=0; i<des.length;i++) {
			if(des[i].getValeur()!=valeur) {
				tab[j]=i+1;
				j++;
			}
		}
		int[]res= new int[j];
		for(int i=0; i<j; i++) {
			res[i]=tab[i];
		}
		return res;	
	}
	
	/*public int[][] selectionnerCase(De[]des){
		int valeur= maxdeValeur(des);
		
		
	}*/
	
	public static void main(String[] args) {
		Score score= new Score(1);
		UpperFirst up= new UpperFirst(1,score.getGrille());
		TourCourant tc=new TourCourant();
		De[]des=tc.getDes();
		int[]tab=up.desArelancer(des);
		for(int i=0; i<tab.length;i++) {
			System.out.println(tab[i]);
		}
		
	}

}
