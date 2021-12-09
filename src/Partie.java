package version1;


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

		/*
		 * Joueur j=new Joueur("			Pierre",1); score.nomJoueur(j.getNom());
		 * 
		 * Joueur j2=new Joueur("Célia",2); score.nomJoueur(j2.getNom());
		 * 
		 * Joueur j3=new Joueur("Marine",3); score.nomJoueur(j3.getNom());
		 */


		Joueur [] tabJoueur = {new Joueur("pp",1),new Joueur("pp2",2),new Joueur("pp3",3)}; 
		for(int i=0; i<tabJoueur.length; i++) {
			score.nomJoueur(tabJoueur[i].getNom());
		}


		System.out.println(tC.toString());

		for(int numJoueur=0; numJoueur < 14; numJoueur++) {

			for(int i=0; i<tabJoueur.length; i++) {
				boolean premierLance=true;
				boolean deuxiemeLance=true;



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


				if (combi.un!=0 && score.casDispo(1, tabJoueur[i].getPosition())) {
					score.barrerCase(1, tabJoueur[i].getPosition(),combi.un);
				}
				else if (combi.deux!=0 && score.casDispo(2, tabJoueur[i].getPosition())) {
					score.barrerCase(2, tabJoueur[i].getPosition(),combi.deux);
				}
				else if (combi.trois!=0 && score.casDispo(3, tabJoueur[i].getPosition())) {
					score.barrerCase(3, tabJoueur[i].getPosition(),combi.trois);
				}
				else if (combi.quatre!=0 && score.casDispo(4, tabJoueur[i].getPosition())) {
					score.barrerCase(4, tabJoueur[i].getPosition(),combi.quatre);
				}
				else if (combi.cinq!=0 && score.casDispo(5, tabJoueur[i].getPosition())) {
					score.barrerCase(5, tabJoueur[i].getPosition(),combi.cinq);
				}
				else if (combi.six!=0 && score.casDispo(6, tabJoueur[i].getPosition())) {
					score.barrerCase(6, tabJoueur[i].getPosition(),combi.six);
				}
				else if (combi.aBrelan && score.casDispo(9, tabJoueur[i].getPosition())) {
					score.barrerCase(9, tabJoueur[i].getPosition(),somme);
				}
				else if (combi.aCarre && score.casDispo(10, tabJoueur[i].getPosition())) {
					score.barrerCase(10, tabJoueur[i].getPosition(),somme);
				}
				else if (combi.aFull && score.casDispo(11, tabJoueur[i].getPosition())) {
					score.barrerCase(11, tabJoueur[i].getPosition(),25);
				}
				else if (combi.aPetiteSuite && score.casDispo(12, tabJoueur[i].getPosition())) {
					score.barrerCase(12, tabJoueur[i].getPosition(),30);
				}
				else if (combi.aGrandeSuite && score.casDispo(13, tabJoueur[i].getPosition())) {
					score.barrerCase(13, tabJoueur[i].getPosition(),40);
				}
				else if (combi.aYam && score.casDispo(14, tabJoueur[i].getPosition())) {
					score.barrerCase(14, tabJoueur[i].getPosition(),50);
				}
				else if (score.casDispo(15, tabJoueur[i].getPosition())) {
					score.barrerCase(15, tabJoueur[i].getPosition(),somme);
				}



				//relance


				/*
				 * else if (deuxiemeLance) { numJoueur=numJoueur-1; //puisqu'il relance on
				 * décrémente i i=i-1; if(!premierLance) { deuxiemeLance=false;
				 * premierLance=true; } else premierLance=false;
				 * 
				 * 
				 * //choix d'heuristique pour le choix des dés int []tab= {0,1,2,3,4};
				 * tC.relancer(tab); }
				 */

				//ajouter un événement "clic" pour faire le remplissage étape par étape

				//if(!deuxiemeLance) {
				//int []tab= {0,1,2,3,4};
				//tC.relancer(tab);

				//}


				//barrer une case si aucun cas choisi
				else {
					for(int j=1;j<17;j++) {
						if(score.casDispo(j, tabJoueur[i].getPosition()) ) {
							score.barrerCase(j, tabJoueur[i].getPosition(),0);
							break;
						}
					}
				}
				
				if(score.calculTotalSup(tabJoueur[i].getPosition())>62) {
					score.grille[7][tabJoueur[i].getPosition()]="35";
				}

				int []tab= {0,1,2,3,4};
				tC.relancer(tab);

				score.calculTotalInf(i+1);
				score.calculTotalSup(i+1);
				score.calculTotal(i+1);
			}


		}

		score.afficherScore();
	}

}

