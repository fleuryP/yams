import java.util.Arrays;


public class Score {
	public String [][] grille;
    Combinaisons combin;

	public Score(int nbJoueur) {
		grille = new String [18][nbJoueur+1];
		grille[0][0]="YAMS";
		for (int i=1; i<7;i++) {
				grille[i][0]="Total de "+i;
			}
		grille[7][0]="Bonus si > à 62 [35]";
		grille[8][0]="Total supérieur";
		grille[9][0]="Brelan (3 id.) [total]";
		grille[10][0]="Carré (4 id.) [total]";
		grille[11][0]="Full House [25]";
		grille[12][0]="Petite suite [30]";
		grille[13][0]="Grande suite [40]";
		grille[14][0]="5 identiques [50]";
		grille[15][0]="Chance [total]";
		grille[16][0]="Total inférieur";
		grille[17][0]="Total";
	}
	
	public void nomJoueur(String nom) {
		for (int i=1; i<6;i++) {
			if (grille[0][i]==null) {
				grille[0][i]=nom;
				break;
			}
		}
	}
	
	public void afficherScore() {
		for (String[] tab: grille) {
		     for (String s: tab) {
		         System.out.print(s + "\t");
		     }
		     System.out.println("\n");
		  }
	}
	

	public void modifierScore(int ligne, int colonne, String valeur) {
		if(casDispo(ligne, colonne)) {
			grille[ligne][colonne]=valeur;
		}
		else {
			System.out.println("La case est déjà pleine");
		}
	}
	
	//
	public boolean casDispo (int ligne, int colonne) {
		if(grille[ligne][colonne]==null) {
			return true;
		}
		else return false;
	}
	
	
	//a ajouter
	public void barrerCase (int ligne, int colonne) {
		if(casDispo(ligne, colonne)) {
			grille[ligne][colonne]="0";
		}
		else {
			System.out.println("La case est déjà pleine");
		}
	}
	
	//a ajouter
	public int calculTotalJoueur () {
		return 0;
	}

}

	
}
