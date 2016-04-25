import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChessUtil chess = new ChessUtil();
		ChessUtil chess2 = new ChessUtil("TestGame.txt");
		chess2.OutPutboard();
		String Temp = "Hello";
		ArrayList<String> test = chess2.getPeiceMoves("b1");
		
		System.out.print("Pawn b1 Moves: ");
		System.out.println(test);
		test = chess.getPeiceMoves("b10");
		
		System.out.print("Pawn b10 Moves: ");
		System.out.println(test);
	}

}
