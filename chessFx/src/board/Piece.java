package board;
import java.util.ArrayList;

public class Piece {

	public String location;
	public PieceColor color;
	public PieceType type;
	public boolean hasMoved;
	public ArrayList<String> range;
	public ArrayList<String> moves;
	
	public ArrayList<String> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<String> moves) {
		this.moves = moves;
	}

	public Piece(String l, PieceColor c, PieceType t, boolean h)
	{
		this.location = l;
		this.color = c;
		this.type = t;
		this.hasMoved = h;
	}
	public Piece(Piece p)
	{
		this.location = p.getLocation();
		this.color = p.getColor();
		this.type = p.getType();
		this.hasMoved = p.isHasMoved();
	}
	public void setLocation(String l)
	{
		this.location = l;
	}
	public void setRange(ArrayList<String> range) {
		this.range = range;
	}

	public String getLocation()
	{
		return location;
	}
	
	
	public Offset[] convertToBPawn(Offset[] o)
	{
		Offset[] off = {new Offset(o[0].getRow()*-1, o[0].getCol()), new Offset(o[1].getRow()*-1, o[1].getCol()), new Offset(o[2].getRow()*-1, o[2].getCol()), new Offset(o[3].getRow()*-1, o[3].getCol())};
		return off;
	}
	public void setColor(PieceColor c)
	{
		this.color = c;
	}
	public PieceColor getColor()
	{
		return color;
	}
	
	public void setType(PieceType t)
	{
		this.type = t;
	}
	public PieceType getType()
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
	public ArrayList<String> getRange()
	{
		return this.range;
	} 
}
