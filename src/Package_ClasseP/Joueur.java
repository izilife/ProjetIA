package Package_ClasseP;
public interface Joueur {
	
	/*
	  Appeler pour placer un domino si ya possibilité de jouer un coup
		On retourne domino pour joué*/
	public Domino joue();
	
	/*
	 * Permet de communiquer le domino placé 
	 * grace a l'appel de Update*/
	public void update(Domino l);
	/*Role du joueur
	 Direction prend la valeur Jeu.ligne et Jeu.colonne*/
	
	public void setRole(int direction);
	
	//Retourne le nom du joueur
	public String getName();
	
	//Methode d'initialisation avant de débuté une partie
	public void reset();
}
