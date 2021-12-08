

public class Partie {
	int nbJoueurs=6;
	int nbTours=13; //le nombre de tour total
	TourCourant tC;
	Strategie strat;
	Combinaisons combi;

	public Partie(String [] tableauDeJoueurs) {
		combi = new Combinaisons();
		tC = new TourCourant();
		Score score = new Score(tableauDeJoueurs.length);
		Joueur [] tabJoueur = null;
		for(int i=0;i<tableauDeJoueurs.length;i++) {
			tabJoueur[i].nom=tableauDeJoueurs[i];
			score.grille[0][i+1]=tableauDeJoueurs[i];
		}
	}

	public static void main (String [] args) {
		Combinaisons combi = new Combinaisons();
		TourCourant tC = new TourCourant();
		Score score = new Score(3);

		//on va probablement devoir utiliser un tableu de joueur

		Joueur j=new Joueur("			Pierre",1);
		score.nomJoueur(j.getNom());

		Joueur j2=new Joueur("Célia",2);
		score.nomJoueur(j2.getNom());

		Joueur j3=new Joueur("Marine",3);
		score.nomJoueur(j3.getNom());

		score.afficherScore();

		System.out.println(tC.toString());

		for(int numJoueur=1; numJoueur <= 3000; numJoueur++) {
			boolean premierLance=true;



			//total des dés
			int somme=tC.totalDes(tC.des);

			//on paramètre les combinaisons possibles
			combi.setUn(tC.des);
			combi.setDeux(tC.des);
			combi.setTrois(tC.des);
			combi.setQuatre(tC.des);
			combi.setCinq(tC.des);
			combi.setSix(tC.des);

			combi.setBrelan(tC.des);
			combi.setCarre(tC.des);
			combi.setFull(tC.des);
			combi.setPsuite(tC.des);
			combi.setGsuite(tC.des);
			combi.setYam(tC.des);

			//on écrit ici le choix de la stratégie, exemple


			if (combi.un!=0 && score.casDispo(1, j.getPosition())) {
				score.barrerCase(1, j.getPosition(),combi.un);
			}
			else if (combi.deux!=0 && score.casDispo(2, j.getPosition())) {
				score.barrerCase(2, j.getPosition(),combi.deux);
			}
			else if (combi.trois!=0 && score.casDispo(3, j.getPosition())) {
				score.barrerCase(3, j.getPosition(),combi.trois);
			}
			else if (combi.quatre!=0 && score.casDispo(4, j.getPosition())) {
				score.barrerCase(4, j.getPosition(),combi.quatre);
			}
			else if (combi.cinq!=0 && score.casDispo(5, j.getPosition())) {
				score.barrerCase(5, j.getPosition(),combi.cinq);
			}
			else if (combi.six!=0 && score.casDispo(6, j.getPosition())) {
				score.barrerCase(6, j.getPosition(),combi.six);
			}
			if (combi.aBrelan && score.casDispo(9, j.getPosition())) {
				score.barrerCase(9, j.getPosition(),somme);
			}
			else if (combi.aCarre && score.casDispo(10, j.getPosition())) {
				score.barrerCase(10, j.getPosition(),somme);
			}
			else if (combi.aFull && score.casDispo(11, j.getPosition())) {
				score.barrerCase(11, j.getPosition(),25);
			}
			else if (combi.aPetiteSuite && score.casDispo(12, j.getPosition())) {
				score.barrerCase(12, j.getPosition(),30);
			}
			else if (combi.aGrandeSuite && score.casDispo(13, j.getPosition())) {
				score.barrerCase(13, j.getPosition(),40);
			}
			else if (combi.aYam && score.casDispo(14, j.getPosition())) {
				score.barrerCase(14, j.getPosition(),50);
			}
			else if (score.casDispo(15, j.getPosition())) {
				score.barrerCase(15, j.getPosition(),somme);
			}


			//en dernier recours il veut relancer
			/*
			 * else { //tC.relancer( {1,1,1,1,1} ); //il choisit de relancer x dés, 5 ici
			 * numJoueur=numJoueur-1; //puisqu'il relance on décrémente i
			 * premierLance=false; //ça devient le 2ème lancé score.barrerCase(1,
			 * j.getPosition(), 0); }
			 */
			
			
			//ajouter un événement "clic" pour faire le remplissage étape par étape
			
			int []tab= {0,1,2,3,4};
			tC.relancer(tab);
		}
		
		
		score.calculTotalInf(1);
		score.calculTotalSup(1);
		score.calculTotal(1);
		score.afficherScore();


	}


	//relancer
	//choix dans la grille (pas si il a déjà choisi avant, obligé sinon)
	//il faut barrer dans le tableau une case
	//calcul score actuel total du joueur

	//Joueur suivant

	//si plusieurs combinaisons sont vrais il faut implémenter une stratégie


}

