package board;
import java.util.ArrayList;
import java.util.HashMap;

public class AttackBoard {
	private boolean board[][] = new boolean[8][8];
	
	public AttackBoard(ArrayList<String> enemyId, HashMap<String, Piece> enemy)
	{
		for(int x = 0; x < 8; x++)
		{
			for (int y = 0; y < 8; y++)
			{
				this.board[x][y]= true;
			}
		}
		int row;
		int col;
		ArrayList<String> spaces;
		for(int x = 0; x < enemyId.size(); x++)
		{
			if(enemyId.get(x) != null)
			{
				spaces = enemy.get(enemyId.get(x)).getRange();
				if(spaces.size() > 0)
				{
					for (int y = 0; y < spaces.size(); y++)
					{
						row = Integer.parseInt(spaces.get(y).split("-")[0]) -1;
						col = Integer.parseInt(spaces.get(y).split("-")[1]) -1;
						this.board[row][col]= false;
					}
				}
			}
		}
	}
	
	public boolean isKingSafeAt(String l)
	{
		int row = Integer.parseInt(l.split("-")[0]) -1;
		int col = Integer.parseInt(l.split("-")[1]) -1;
		
		return this.board[row][col];
	}
	
	
}
