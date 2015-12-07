package Package_Peace;
import java.util.Scanner;

//je fais un test !

public class Peace implements Joueur{
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRole(int direction) {
		role = direction;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub	
	}
	
	public void MinMax(){
		
	}
		
	public void AlphaBeta(){
		
	}
	
}
