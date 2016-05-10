package application;

import java.util.ArrayList;

public class CastleMove {
	public String KingID;
	public String moveKingTo;
	public String RookID;
	public String moveRookTo;
	public ArrayList<String> spacesToCheck = new ArrayList<String>();
	public ArrayList<String> spacesMovedonByKing = new ArrayList<String>();
	public CastleMove(String color, Castle c)
	{
		if(color == "White")
		{
			this.KingID = "w1";
			switch(c)
			{
				case KING_SIDE:
					this.moveKingTo = "8-7";
					this.RookID = "w8";
					this.moveRookTo = "8-6";
					this.spacesToCheck.add("8-6");
					this.spacesToCheck.add("8-7");
					this.spacesMovedonByKing.add("8-6");
					this.spacesMovedonByKing.add("8-7");
					break;
				case QUEEN_SIDE:
					this.moveKingTo = "8-3";
					this.RookID = "w7";
					this.moveRookTo = "8-4";
					this.spacesToCheck.add("8-2");
					this.spacesToCheck.add("8-3");
					this.spacesToCheck.add("8-4");
					this.spacesMovedonByKing.add("8-4");
					this.spacesMovedonByKing.add("8-3");
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
					this.moveKingTo = "1-7";
					this.RookID = "b8";
					this.moveRookTo = "1-6";
					this.spacesToCheck.add("1-6");
					this.spacesToCheck.add("1-7");
					this.spacesMovedonByKing.add("1-6");
					this.spacesMovedonByKing.add("1-7");
					break;
				case QUEEN_SIDE:
					this.moveKingTo = "1-3";
					this.RookID = "b7";
					this.moveRookTo = "1-4";
					this.spacesToCheck.add("1-2");
					this.spacesToCheck.add("1-3");
					this.spacesToCheck.add("1-4");
					this.spacesMovedonByKing.add("1-4");
					this.spacesMovedonByKing.add("1-3");
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
	public ArrayList<String> getSpacesKingToches()
	{
		return spacesMovedonByKing;
	}
}
