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
	
	public Domino move(Domino l) 
	{
	    int alpha = -10000;
	    int beta = 10000;
	    int meilleurScore = -Integer.MAX_VALUE;
	    int plyProf;
	    Peace arbrePeace = new Peace();
	    Domino meilleurCoup = null;
	    for(arbrePeace child: arbrePeace.getChildren())
	    {
	        if(meilleurCoup == null)
	        {
	        	meilleurCoup = child.getState();
	        }
	        alpha = Math.max(alpha, miniMax(child, plyProf - 1, alpha, beta));
	        if(alpha > meilleurCoup)
	        {
	        	meilleurCoup = child.getState();
	            meilleurScore = alpha;
	        }
	    }
	    return meilleurCoup;
	}
	public int miniMax(Domino noeudCourant, int profondeur, int alpha, int beta) 
	{
	    if(profondeur <= 0 || terminalNoeud(noeudCourant.getState())) 
	    {
	        return getHeuristic(noeudCourant.getState());
	    }
	    if(noeudCourant.getState().getCurrentPlayer().equals(selfColor))
	    {
	        for(arbrePeace child: noeudCourant.getChildren())
	        {
	            alpha = Math.max(alpha, miniMax(child, profondeur - 1, alpha, beta));

	            if(alpha >= beta)
	            {
	                return beta;
	            }
	        }
	        return alpha;
	    }
	    else
	    {
	        for(arbrePeace child: noeudCourant.getChildren())
	        {
	            beta = Math.min(beta, miniMax(child, profondeur - 1, alpha, beta));

	            if(alpha >= beta)
	            {
	                return alpha;
	            }
	        }
	        return beta;
	    }
	}
}
