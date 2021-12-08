
public class Joueur {
	
	String nom;
	private int score;
	
	//permet de savoir à quelle place il est dans le tableau des score 
	// car on a besoin de savoir sa colonne
	private int position;
	
	public Joueur(String nom, int position) {
		this.nom=nom;
		this.score=0;
		this.position=position;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void ajouterPoints(int nbPoints) {
		this.score+=+nbPoints;
	}

}
