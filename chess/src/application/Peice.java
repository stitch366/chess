package application;

public class Peice {

	String id;
	String location;
	PeiceColor color;
	PeiceType type;
	boolean hasMoved;
	
	public Peice(String i, String l, PeiceColor c, PeiceType t, boolean h)
	{
		this.id = i;
		this.location = l;
		this.color = c;
		this.type = t;
		this.hasMoved = h;
	}
	
	public void setID(String i)
	{
		this.id = i;
	}
	public String getID()
	{
		return id;
	}
	
	public void setLocation(String l)
	{
		this.location = l;
	}
	public String getLocation()
	{
		return location;
	}
	
	public void setColor(PeiceColor c)
	{
		this.color = c;
	}
	public PeiceColor getColor()
	{
		return color;
	}
	
	public void setType(PeiceType t)
	{
		this.type = t;
	}
	public PeiceType getType()
	{
		return type;
	}
	public void setHasMoved(boolean h)
	{
		this.hasMoved = h;
	}
	public boolean isHasMoved()
	{
		return hasMoved;
	}
}
