
public class Partie {
	int nbJoueurs=6;
	int nbTours;
	TourCourant tc;
	Strategie strat;
	
	public static void main (String [] args) {
		TourCourant tC = new TourCourant();
		Score score = new Score(3);
		
		Joueur j=new Joueur("Pierre");
		score.nomJoueur(j.getNom());
		
		Joueur j2=new Joueur("Célia");
		score.nomJoueur(j2.getNom());
		
		Joueur j3=new Joueur("Marine");
		score.nomJoueur(j3.getNom());
		
		//score.afficherScore();
		
		System.out.println(tC.toString());
		
		
	}
	
}
