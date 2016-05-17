package board;

import java.util.ArrayList;

public class MoveInfo {
	public String peiceId;
	public ArrayList<String> allOpts;
	public String capturedPeice;
	public String location;
	public String inital;
	
	public String getInital() {
		return inital;
	}
	public void setInital(String inital) {
		this.inital = inital;
	}
	public int spacesMoved;
	public int getSpacesMoved() {
		return spacesMoved;
	}
	public void setSpacesMoved(PieceType peiceType) {
		int initR;
		int initC;
		int newR;
		int newC;
		
		if(peiceType == PieceType.KING)
		{
			this.spacesMoved = 1;
		}
		else if(peiceType == PieceType.KNIGHT)
		{
			this.spacesMoved = 3;
		}
		else
		{
			initR = Integer.parseInt(inital.split("-")[0]);
			initC = Integer.parseInt(inital.split("-")[1]);
			newR = Integer.parseInt(location.split("-")[0]);
			newC = Integer.parseInt(location.split("-")[1]);
			
			if(initR == newR)
			{
				this.spacesMoved = Math.abs(initC - newC);
			}
			else
			{
				this.spacesMoved = Math.abs(initR - newR);
			}
		}
	}
	public MoveInfo()
	{
		this.peiceId = "";
		this.allOpts = new ArrayList<String>();
		this.capturedPeice = "";
		this.location = "";
	}
	public void setPeiceId(String id)
	{
		this.peiceId = id;
	}
	public String getPeiceId()
	{
		return peiceId;
	}
	public void setLocation(String id)
	{
		this.location= id;
	}
	public String getLocation()
	{
		return location;
	}
	public void setCapturedPeice(String id)
	{
		this.capturedPeice = id;
	}
	public String getCapturedPeice()
	{
		return capturedPeice;
	}
	
	public void setOpts(ArrayList<String> opts)
	{
		this.allOpts = opts;
	}
	public ArrayList<String> getOpts()
	{
		return allOpts;
	}
}
