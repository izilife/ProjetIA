package Package_Peace;

public class PeaceElagage implements Joueur{
int role;
	
	
	public int Max(boolean libre[][], int profondeur, int alpha, int beta){
		int max = -1000;
		int i, j;
		if (Jeu.estTermine(libre, role)|| profondeur == 0){
			return evalALphaBeta(libre);
		}
		
		for (i=0; i<=7;i++){
			for (j=0; j<=7; j++){
				if(libre[i][j]){
					role = Jeu.LIGNE;
					joue();
					alpha = Min(libre, profondeur - 1, alpha, beta);
					if(beta <= alpha){
						return max;
					}
					reset();
				}
			}
		}
		return alpha;
	}
	
	public int Min(boolean libre[][], int profondeur, int alpha, int beta){
		int min = 1000;
		int i, j;
		if (Jeu.estTermine(libre, role)|| profondeur == 0){
			return evalALphaBeta(libre);
		}
		
		for (i=0; i<=7;i++){
			for (j=0; j<=7; j++){
				if(libre[i][j]){
					role = Jeu.LIGNE;
					joue();
					beta = Max(libre, profondeur - 1, alpha, beta);
					if(beta <= min){
						return min;
					}
					reset();
				}
			}
		}
		return beta;
	}
	
	public int evalALphaBeta(boolean libre[][]){
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
	
	@Override
	public Domino joue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Domino l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRole(int direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
