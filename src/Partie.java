
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

		Joueur j=new Joueur("Pierre",1);
		score.nomJoueur(j.getNom());

		Joueur j2=new Joueur("Célia",2);
		score.nomJoueur(j2.getNom());

		Joueur j3=new Joueur("Marine",3);
		score.nomJoueur(j3.getNom());

		score.afficherScore();

		System.out.println(tC.toString());

		for(int numJoueur=1; numJoueur <= numJoueur*13; numJoueur++) {
			boolean premierLance=true;

				//on récupère les valeurs des dés


				//on paramètre les combinaisons possibles
				combi.setUn(tC.des);
				combi.setDeux(tC.des);
				combi.setTrois(tC.des);
				combi.setQuatre(tC.des);
				combi.setCinq(tC.des);

				combi.setBrelan(tC.des);
				combi.setCarre(tC.des);
				combi.setFull(tC.des);
				combi.setPsuite(tC.des);
				combi.setGsuite(tC.des);
				combi.setYam(tC.des);

				//on écrit ici le choix de la stratégie, exemple
				if (combi.aBrelan && score.casDispo(8, j.getPosition())) {//problème car on peut pas avoir j1, j2 ...
					//ligne = numero de la ligne des brelan et colonne = nomjoueur

					score.barrerCase(8, j.getPosition());
					}
				else if (combi.aCarre && score.casDispo(9, j.getPosition())) {//problème car on peut pas avoir j1, j2 ...
					//ligne = numero de la ligne des brelan et colonne = nomjoueur

					score.barrerCase(9, j.getPosition());
					}
				else if (combi.aFull && score.casDispo(10, j.getPosition())) {//problème car on peut pas avoir j1, j2 ...
					//ligne = numero de la ligne des brelan et colonne = nomjoueur

					score.barrerCase(10, j.getPosition());
					}
				else if (combi.aPetiteSuite && score.casDispo(11, j.getPosition())) {//problème car on peut pas avoir j1, j2 ...
					//ligne = numero de la ligne des brelan et colonne = nomjoueur

					score.barrerCase(11, j.getPosition());
					}
				else if (combi.aGrandeSuite && score.casDispo(12, j.getPosition())) {//problème car on peut pas avoir j1, j2 ...
					//ligne = numero de la ligne des brelan et colonne = nomjoueur

					score.barrerCase(12, j.getPosition());
					}
				else if (combi.aYam && score.casDispo(13, j.getPosition())) {//problème car on peut pas avoir j1, j2 ...
					//ligne = numero de la ligne des brelan et colonne = nomjoueur

					score.barrerCase(13, j.getPosition());
					}
				
				
				//en dernier recours il veut relancer
				else { 
					//tC.relancer( {1,1,1,1,1} ); //il choisit de relancer x dés, 5 ici
					numJoueur=numJoueur-1; //puisqu'il relance on décrémente i
					premierLance=false; //ça devient le 2ème lancé
				}
			}

			//choix de la case ou relancer des dés
			score.barrerCase(1, 0);

		}

		//relancer
		//choix dans la grille (pas si il a déjà choisi avant, obligé sinon)
		//il faut barrer dans le tableau une case
		//calcul score actuel total du joueur

		//Joueur suivant

		//si plusieurs combinaisons sont vrais il faut implémenter une stratégie


	}

