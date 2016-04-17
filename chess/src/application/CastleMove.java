package application;

import java.util.ArrayList;

public class CastleMove {
	public String KingID;
	public String moveKingTo;
	public String RookID;
	public String moveRookTo;
	public ArrayList<String> spacesToCheck = new ArrayList<String>();
	public CastleMove(String color, Castle c)
	{
		if(color == "White")
		{
			this.KingID = "w1";
			switch(c)
			{
				case KING_SIDE:
					this.moveKingTo = "h-7";
					this.RookID = "w8";
					this.moveRookTo = "h-6";
					this.spacesToCheck.add("h-6");
					this.spacesToCheck.add("h-7");
					break;
				case QUEEN_SIDE:
					this.moveKingTo = "h-3";
					this.RookID = "w7";
					this.moveRookTo = "h-4";
					this.spacesToCheck.add("h-2");
					this.spacesToCheck.add("h-3");
					this.spacesToCheck.add("h-4");
					break;
				default:
					break;
			
			}
		}
		else
		{
			this.KingID = "b1";
			switch(c)
			{
				case KING_SIDE:
					this.moveKingTo = "a-7";
					this.RookID = "b8";
					this.moveRookTo = "a-6";
					this.spacesToCheck.add("a-6");
					this.spacesToCheck.add("a-7");
					break;
				case QUEEN_SIDE:
					this.moveKingTo = "a-3";
					this.RookID = "b7";
					this.moveRookTo = "a-4";
					this.spacesToCheck.add("a-2");
					this.spacesToCheck.add("a-3");
					this.spacesToCheck.add("a-4");
					break;
				default:
					break;
			
			}
		}
	}
	
	public String getKingId()
	{
		return this.KingID;
	}
	public String getSpaceToMoveKing()
	{
		return this.moveKingTo;
	}
	
	public String getRookId()
	{
		return this.RookID;
	}
	public String getSpaceToMoveRook()
	{
		return this.moveRookTo;
	}
	public ArrayList<String> getSpacesToCheck()
	{
		return spacesToCheck;
	}
}
