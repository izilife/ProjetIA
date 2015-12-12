package Package_Peace;
import java.util.Scanner;

//je fais un test !

public class Peace implements Joueur{
	static char c;
	boolean libre[][];
	Scanner scan;
	int role;
	String name = "Peace";
	
	public Peace(){}

	@Override
	public Domino joue() {
		int i = 0;
		int j = 0;
		Domino d =null;
		for(i=0; i<=7; i++){
			for (j = 0; j<=7; j++){
		if (role == Jeu.LIGNE)
			return new Domino(new Case(i,j), new Case(i+1,j));
		else
			return new Domino(new Case(i,j), new Case(i,j+1));
	}
  }
		return d;
}

	@Override
	public void update(Domino l) {
		  
		
	}

	@Override
	public void setRole(int direction) {
		role = direction;
		
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void reset() {
		for( int i=0; i<=7;i++){
			for(int j=0; j<=7; j++){
				libre[i][j] = true;
			}
		}
	}
	
	public int Max(boolean libre[][], int profondeur){
		int max = -1000;
		int i, j, tmp;
		if (Jeu.estTermine(libre, role)|| profondeur == 0){
			return eval(libre);
		}
		
		for (i=0; i<=7;i++){
			for (j=0; j<=7; j++){
				if(libre[i][j]){
					role = Jeu.LIGNE;
					joue();
					tmp = Min(libre, profondeur - 1);
					if(tmp > max){
						max = tmp;
					}
					break;
				}
			}
		}
		return max;
	}
	public int Min(boolean libre[][], int profondeur){
		int min = 1000;
		int i, j, tmp;
		if (Jeu.estTermine(libre, role)|| profondeur == 0){
			return eval(libre);
		}
		for (i=0; i<=7;i++){
			for (j=0; j<=7; j++){
				if(libre[i][j]){
					role = Jeu.COLONNE;
					tmp = Max(libre, profondeur - 1);
					if(tmp < min){
						min = tmp;
					}
					break;
				}
			}
		}
		return min;
	}
	
	public int eval(boolean libre[][]){
		int nbreCaseLigne = 0;
		int	nbreCaseColonne = 0;
		int i,j;
		for (i=0;i<8;i++){
			for(j=0;j<8;j++){
				if(libre[i][j] && role == Jeu.LIGNE){
					nbreCaseLigne++;
				}
			else{
				if(libre[i][j] && role == Jeu.COLONNE){
					nbreCaseColonne++;
				}
			 }
			}
		}	
		if(nbreCaseColonne>nbreCaseLigne){
			return nbreCaseColonne -nbreCaseLigne;
		}else
		{
		return nbreCaseLigne-nbreCaseColonne;
		}
	}

}

