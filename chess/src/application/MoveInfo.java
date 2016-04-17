package application;

import java.util.ArrayList;

public class MoveInfo {
	public String peiceId;
	public ArrayList<String> allOpts;
	public String capturedPeice;
	public String location;
	
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
