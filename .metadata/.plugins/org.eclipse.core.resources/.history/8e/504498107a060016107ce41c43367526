package application;

import java.util.ArrayList;
import java.util.HashMap;

public class TurnInfo {
	HashMap<String,String[]> EnemyMoves = new HashMap<String,String[]>();
	HashMap<String,String[]> EPeicesProtectedFromKing = new HashMap<String,String[]>();
	HashMap<String,String[]> EmptySpacesAttackableByEPawn = new HashMap<String,String[]>();
	HashMap<String,String[]> AllyMoves = new HashMap<String,String[]>();
	String EnemyCheckingKing = "";
	
	public void addToEnemyMoves(String EnemyPeice, ArrayList<String> EPmoves)
	{
		int arrlen = EPmoves.size();
		String[] moves = new String[arrlen];
		for(int x = 0; x< arrlen; x ++)
		{
			moves[x] = EPmoves.get(x);
		}
		EnemyMoves.put(EnemyPeice, moves);
	}
	public void addToProtected(String EnemyPeice, ArrayList<String> PeicesProtected)
	{
		int arrlen = PeicesProtected.size();
		String[] moves = new String[arrlen];
		for(int x = 0; x< arrlen; x ++)
		{
			moves[x] = PeicesProtected.get(x);
		}
		EPeicesProtectedFromKing.put(EnemyPeice, moves);
	}
	public void addToPawnAttackable(String EnemyPeice, ArrayList<String> attackable)
	{
		int arrlen = attackable.size();
		String[] moves = new String[arrlen];
		for(int x = 0; x< arrlen; x ++)
		{
			moves[x] = attackable.get(x);
		}
		EmptySpacesAttackableByEPawn.put(EnemyPeice, moves);
	}
	public void addToAllyMoves(String AllyPeice, ArrayList<String> APmoves)
	{
		int arrlen = APmoves.size();
		String[] moves = new String[arrlen];
		for(int x = 0; x< arrlen; x ++)
		{
			moves[x] = APmoves.get(x);
		}
		EnemyMoves.put(AllyPeice, moves);
	}
	
	public boolean checkEnemyMovesForKingLocation(String KingLocation, ArrayList<String> EnemyList)
	{
		String[] peiceMoves;
		for(int x = 0; x < EnemyList.size(); x++)
		{
			peiceMoves = EnemyMoves.get(EnemyList.get(x));
			for(int y = 0; y < peiceMoves.length; y++)
			{
				if(peiceMoves[y].equals(KingLocation))
				{
					this.EnemyCheckingKing = EnemyList.get(x);
					return true;
				}
			}
		}
		return false;
	}
	
	public String getEnemyCheckingKing()
	{
		return EnemyCheckingKing;
	}
	
	
}
