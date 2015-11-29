package Package_Peace;
import java.util.Scanner;

//je fais un test !

public class Peace implements Joueur{
	Scanner scan;
	int role;
	String name = "Peace";

	public Peace(){
		scan = new Scanner(Scanner.in);
	}

	public String getNom(){
		return this.name;	
	}
	public void setRole(int r){
		this.role = r;
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
