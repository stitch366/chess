package application;

import java.util.ArrayList;

public class MoveInfo {
	public String peiceId;
	public ArrayList<String> allOpts;
	
	public MoveInfo()
	{
		this.peiceId = "";
		this.allOpts = new ArrayList<String>();
	}
	public void setPeiceId(String id)
	{
		this.peiceId = id;
	}
	public String getPeiceId()
	{
		return peiceId;
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
