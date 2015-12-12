package Package_Peace;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//je fais un test !

public class Peace implements Joueur{
	static char c;
	Scanner scan;
	int role;
	String name = "Peace";

	public Peace(){
		scan = new Scanner(System.in);
	}
	@Override
	public Domino joue() {
		System.out.println("entrez l'extremite du domino");
		String l = scan.nextLine();
		String[] s = l.split(" ");
		int i = Integer.parseInt(s[0]);
		int j = Integer.parseInt(s[1]);
		if (role == Jeu.LIGNE)
			return new Domino(new Case(i,j), new Case(i+1,j));
		else
			return new Domino(new Case(i,j), new Case(i,j+1));
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
		// TODO Auto-generated method stub	
	}
	
	public int Max(boolean libre[][], int profondeur){
		int max = -1000;
		int i, j, tmp;
		if (Jeu.estTermine(libre, role)|| profondeur == 0){
			return eval(libre);
		}
		for (i=0; i<8;i++){
			for (j=0; j<8; j++){
				if(libre[i][j]){
					role = Jeu.LIGNE;
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
		for (i=0; i<8;i++){
			for (j=0; j<8; j++){
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
		int gagnant, nbreCaseLigne, nbreCaseColonne;
		return role;
		
		
	}

}
