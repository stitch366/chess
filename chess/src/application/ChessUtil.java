package application;

import java.util.ArrayList;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class ChessUtil {
	public ArrayList<String> whiteID = new ArrayList<String>();
	public ArrayList<String>  blackID = new ArrayList<String>();
	public String[] spaceID = new String[64];
	public Peice[] white = new Peice[16];
	public Peice[] black = new Peice[16];
	public Board board;
	public CastleMove KingSide;
	public CastleMove QueenSide;
	public ChessUtil()
	{
		this.KingSide = new CastleMove("White", Castle.KING_SIDE);
		this.QueenSide = new CastleMove("White", Castle.QUEEN_SIDE);
		for(int x = 0; x < 8; x ++)
		{
			this.spaceID[x] = "a-"+ (x+1);
			this.spaceID[x + 8] = "b-"+ (x+1);
			this.spaceID[x + 16] = "c-"+ (x+1);
			this.spaceID[x + 24] = "d-"+ (x+1);
			this.spaceID[x + 32] = "e-"+ (x+1);
			this.spaceID[x + 40] = "f-"+ (x+1);
			this.spaceID[x + 48] = "g-"+ (x+1);
			this.spaceID[x + 56] = "h-"+ (x+1);
		}
		
		for(int x = 0; x < 16; x++)
		{
			this.whiteID.add("w"+(x+1));
			this.blackID.add("b"+(x+1));
		}
		this.white[0]= new Peice("w1", "h-5", PeiceColor.WHITE, PeiceType.KING, false);
		this.white[1]= new Peice("w2", "h-4", PeiceColor.WHITE, PeiceType.QUEEN, false);
		this.white[2]= new Peice("w3", "h-3", PeiceColor.WHITE, PeiceType.BISHOP, false);
		this.white[3]= new Peice("w4", "h-6", PeiceColor.WHITE, PeiceType.BISHOP, false);
		this.white[4]= new Peice("w5", "h-2", PeiceColor.WHITE, PeiceType.KNIGHT, false);
		this.white[5]= new Peice("w6", "h-7", PeiceColor.WHITE, PeiceType.KNIGHT, false);
		this.white[6]= new Peice("w7", "h-1", PeiceColor.WHITE, PeiceType.ROOK, false);
		this.white[7]= new Peice("w8", "h-8", PeiceColor.WHITE, PeiceType.ROOK, false);
		this.white[8]= new Peice("w9", "g-1", PeiceColor.WHITE, PeiceType.PAWN, false);
		this.white[9]= new Peice("w10", "g-2", PeiceColor.WHITE, PeiceType.PAWN, false);
		this.white[10]= new Peice("w11", "g-3", PeiceColor.WHITE, PeiceType.PAWN, false);
		this.white[11]= new Peice("w12", "g-4", PeiceColor.WHITE, PeiceType.PAWN, false);
		this.white[12]= new Peice("w13", "g-5", PeiceColor.WHITE, PeiceType.PAWN, false);
		this.white[13]= new Peice("w14", "g-6", PeiceColor.WHITE, PeiceType.PAWN, false);
		this.white[14]= new Peice("w15", "g-7", PeiceColor.WHITE, PeiceType.PAWN, false);
		this.white[15]= new Peice("w16", "g-8", PeiceColor.WHITE, PeiceType.PAWN, false);
		
		this.black[0]= new Peice("b1", "a-5", PeiceColor.BLACK, PeiceType.KING, false);
		this.black[1]= new Peice("b2", "a-4", PeiceColor.BLACK, PeiceType.QUEEN, false);
		this.black[2]= new Peice("b3", "a-3", PeiceColor.BLACK, PeiceType.BISHOP, false);
		this.black[3]= new Peice("b4", "a-6", PeiceColor.BLACK, PeiceType.BISHOP, false);
		this.black[4]= new Peice("b5", "a-2", PeiceColor.BLACK, PeiceType.KNIGHT, false);
		this.black[5]= new Peice("b6", "a-7", PeiceColor.BLACK, PeiceType.KNIGHT, false);
		this.black[6]= new Peice("b7", "a-1", PeiceColor.BLACK, PeiceType.ROOK, false);
		this.black[7]= new Peice("b8", "a-8", PeiceColor.BLACK, PeiceType.ROOK, false);
		this.black[8]= new Peice("b9", "b-1", PeiceColor.BLACK, PeiceType.PAWN, false);
		this.black[9]= new Peice("b10", "b-2", PeiceColor.BLACK, PeiceType.PAWN, false);
		this.black[10]= new Peice("b11", "b-3", PeiceColor.BLACK, PeiceType.PAWN, false);
		this.black[11]= new Peice("b12", "b-4", PeiceColor.BLACK, PeiceType.PAWN, false);
		this.black[12]= new Peice("b13", "b-5", PeiceColor.BLACK, PeiceType.PAWN, false);
		this.black[13]= new Peice("b14", "b-6", PeiceColor.BLACK, PeiceType.PAWN, false);
		this.black[14]= new Peice("b15", "b-7", PeiceColor.BLACK, PeiceType.PAWN, false);
		this.black[15]= new Peice("b16", "b-8", PeiceColor.BLACK, PeiceType.PAWN, false);
		
		this.board = new Board(white, black);
	}
	public void removeCapturedPeice(String id)
	{
		if(id.charAt(0) == 'b')
		{
			this.blackID.remove(id);
		}
		else
		{
			this.whiteID.remove(id);
		}
	}
	public boolean isMate(String color)
	{
		String KingID = (color == "White")? "w1" : "b1";
		ArrayList<String> moves = findPeiceMoves(KingID);
		if(moves.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public ArrayList<String> findPeiceMoves(String id)
	{
		int pIndex = findPeiceIndex(id);
		Peice p = id.charAt(0) == 'w' ? white[pIndex] : black[pIndex];
		ArrayList<String> moves = new ArrayList<String>();
		String EnemyKingId = id.charAt(0) == 'w' ? "b1" : "w1";
		Peice EnemyKing = getPeice(EnemyKingId);
		ArrayList<String> EKmoves = new ArrayList<String>();
		switch(p.getType())
		{
			case BISHOP:
				moves = getBishopMoves(p);
				break;
			case KING:
				moves = getKingMoves(p);
				break;
			case KNIGHT:
				moves = getKnightMoves(p);
				EKmoves = getKnightMoves(EnemyKing);
				moves.removeAll(EKmoves);
				break;
			case PAWN:
				moves = getPawnMoves(p);
				break;
			case QUEEN:
				moves = getQueenMoves(p);
				break;
			case ROOK:
				moves = getRookMoves(p);
				break;
			default:
				break;
		}
		return moves;
	}
	public void setCastleMoves(String color)
	{
		this.KingSide = new CastleMove(color, Castle.KING_SIDE);
		this.QueenSide = new CastleMove(color, Castle.QUEEN_SIDE);
	}
	public boolean canKingSideCastle(){
		Peice king = getPeice(KingSide.getKingId());
		Peice rook = getPeice(KingSide.getRookId());
		boolean isRookCaptured = hasRookBeenCaptured(KingSide.getRookId());
		boolean areSpacesEmpty = areSpacesEmpty(KingSide.getSpacesToCheck());
		
		if((!rook.hasMoved) && (!king.hasMoved) && (!isRookCaptured) && areSpacesEmpty)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean canQueenSideCastle(){
		Peice king = getPeice(QueenSide.getKingId());
		Peice rook = getPeice(QueenSide.getRookId());
		boolean isRookCaptured = hasRookBeenCaptured(QueenSide.getRookId());
		boolean areSpacesEmpty = areSpacesEmpty(QueenSide.getSpacesToCheck());
		
		if((!rook.hasMoved) && (!king.hasMoved) && (!isRookCaptured) && areSpacesEmpty)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String getKingSideKID()
	{
		return this.KingSide.getKingId();
	}
	public String getKingSideRID()
	{
		return this.KingSide.getRookId();
	}
	public String getKingSideKMoveTo()
	{
		return this.KingSide.getSpaceToMoveKing();
	}
	public String getKingSideRMoveTo()
	{
		return this.KingSide.getSpaceToMoveRook();
	}
	public String getQueenSideKID()
	{
		return this.QueenSide.getKingId();
	}
	public String getQueenSideRID()
	{
		return this.QueenSide.getRookId();
	}
	public String getQueenSideKMoveTo()
	{
		return this.QueenSide.getSpaceToMoveKing();
	}
	public String getQueenSideRMoveTo()
	{
		return this.QueenSide.getSpaceToMoveRook();
	}
	public boolean areSpacesEmpty(ArrayList<String> spaces)
	{
		String spacePeice;
		for(int x = 0; x < spaces.size(); x++)
		{
			spacePeice = getSpacePeice(spaces.get(x));
			if(spacePeice != "")
			{
				return false;
			}
		}
		return true;
	}
	public boolean hasRookBeenCaptured(String id)
	{
		if(id.charAt(0) == 'w')
		{
			for(int x = 0; x < whiteID.size(); x++)
			{
				if(whiteID.get(x).equals(id))
				{
					return false;
				}
			}
		}
		else
		{
			for(int x = 0; x < blackID.size(); x++)
			{
				if(blackID.get(x).equals(id))
				{
					return false;
				}
			}
		}
		return true;
	}
	private ArrayList<String> getQueenMoves(Peice p)
	{
		ArrayList<String> temp = new ArrayList<String>();
		temp.addAll(getBishopMoves(p));
		temp.addAll(getRookMoves(p));
		
		return temp;
	}
	private ArrayList<String> getBishopMoves(Peice p)
	{
		ArrayList<String> temp = new ArrayList<String>();
		String t;
		int neg = 0;
		for(int x = 1; x > 0; x++)
		{
			if(getMove(x, x, p) != "NA")
			{
				t = getMove(x, x, p);
				temp.add(t);
				if(checkForEnemy(p.getColor(), t))
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		for(int x = 1; x > 0; x++)
		{
			neg = x * -1;
			if(getMove(x, neg, p) != "NA")
			{
				t = getMove(x, neg, p);
				temp.add(t);
				if(checkForEnemy(p.getColor(), t))
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		neg = 0;
		for(int x = 1; x > 0; x++)
		{
			neg = x * -1;
			if(getMove(neg, x, p) != "NA")
			{
				t = getMove(neg, x, p);
				temp.add(t);
				if(checkForEnemy(p.getColor(), t))
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		neg = 0;
		for(int x = 1; x > 0; x++)
		{
			neg = x * -1;
			if(getMove(neg, neg, p) != "NA")
			{
				t = getMove(neg, neg, p);
				temp.add(t);
				if(checkForEnemy(p.getColor(), t))
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		return temp;
	}
	private ArrayList<String> getKingMoves(Peice p)
	{
		ArrayList<String> temp = new ArrayList<String>();
		String t;
		if(getMove(-1, -1, p) != "NA")
		{
			t = getMove(-1, -1, p);
			temp.add(t);
			
		}
		if(getMove(-1, 1, p) != "NA")
		{
			t = getMove(-1, 1, p);
			temp.add(t);
		}
		if(getMove(1, -1, p) != "NA")
		{
			t = getMove(1, -1, p);
			temp.add(t);
		}
		if(getMove(1, 1, p) != "NA")
		{
			t = getMove(1, 1, p);
			temp.add(t);
		}
		if(getMove(-1, 0, p) != "NA")
		{
			t = getMove(-1, 0, p);
			temp.add(t);
		}
		if(getMove(0, 1, p) != "NA")
		{
			t = getMove(0, 1, p);
			temp.add(t);
		}
		if(getMove(0, -1, p) != "NA")
		{
			t = getMove(0, -1, p);
			temp.add(t);
		}
		if(getMove(1, 0, p) != "NA")
		{
			t = getMove(1, 0, p);
			temp.add(t);
		}
		temp.removeAll(GetPossEnemyMoves(p.getColor()));
		return temp;
	}
	private ArrayList<String> getRookMoves(Peice p)
	{
		ArrayList<String> temp = new ArrayList<String>();
		String t;
		int neg = 0;
		for(int x = 1; x > 0; x++)
		{
			if(getMove(x, 0, p) != "NA")
			{
				t = getMove(x, 0, p);
				temp.add(t);
				if(checkForEnemy(p.getColor(), t))
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		for(int x = 1; x > 0; x++)
		{
			neg = x * -1;
			if(getMove(neg, 0, p) != "NA")
			{
				t = getMove(neg, 0, p);
				temp.add(t);
				if(checkForEnemy(p.getColor(), t))
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		neg = 0;
		for(int x = 1; x > 0; x++)
		{
			if(getMove(0, x, p) != "NA")
			{
				t = getMove(0, x, p);
				temp.add(t);
				if(checkForEnemy(p.getColor(), t))
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		for(int x = 1; x > 0; x++)
		{
			neg = x * -1;
			if(getMove(0, neg, p) != "NA")
			{
				t = getMove(0, neg, p);
				temp.add(t);
				if(checkForEnemy(p.getColor(), t))
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		return temp;
	}
	private ArrayList<String> getPawnMoves(Peice p)
	{
		ArrayList<String> temp = new ArrayList<String>();
		String t;
		
		switch(p.getColor())
		{
			case WHITE:
				if(getMove(-1, -1, p) != "NA" && checkForEnemy(p.getColor(), getMove(-1, -1, p)) )
				{
					t = getMove(-1, -1, p);
					temp.add(t);
				}
				if(getMove(-1, 1, p) != "NA" && checkForEnemy(p.getColor(), getMove(-1, 1, p)) )
				{
					t = getMove(-1, 1, p);
					temp.add(t);
				}
				if(getMove(-1, 0, p) != "NA" && (!checkForEnemy(p.getColor(), getMove(-1, 0, p))))
				{
					t = getMove(-1, 0, p);
					temp.add(t);
				}
				if(!p.isHasMoved())
				{
					if(getMove(-2, 0, p) != "NA" && (!checkForEnemy(p.getColor(), getMove(-2, 0, p))))
					{
						t = getMove(-2, 0, p);
						temp.add(t);
					}
				}
				break;
			case BLACK:
				if(getMove(1, -1, p) != "NA" && checkForEnemy(p.getColor(), getMove(1, -1, p)) )
				{
					t = getMove(1, -1, p);
					temp.add(t);
				}
				if(getMove(1, 1, p) != "NA" && checkForEnemy(p.getColor(), getMove(1, 1, p)) )
				{
					t = getMove(1, 1, p);
					temp.add(t);
				}
				if(getMove(1, 0, p) != "NA" && (!checkForEnemy(p.getColor(), getMove(1, 0, p)) ))
				{
					t = getMove(1, 0, p);
					temp.add(t);
				}
				if(!p.isHasMoved())
				{
					if(getMove(2, 0, p) != "NA" && (!checkForEnemy(p.getColor(), getMove(2, 0, p))))
					{
						t = getMove(2, 0, p);
						temp.add(t);
					}
				}
				break;
		}
		
		return temp;
	}
	private String getMove(int rMove, int cMove, Peice p)
	{
		Movement m = new Movement();
		int cRow = m.convertLetterToNum(p.location.split("-")[0]);
		int cCol = Integer.parseInt(p.location.split("-")[1]);
		String moveTo;
		if((cRow + rMove <= 8) && (cCol + cMove <= 8) && (cRow + rMove >= 1) && (cCol + cMove >= 1))
		{
			moveTo = m.convertNumToLetter(cRow + rMove) + "-" + (cCol + cMove);
			return checkForAlly(p.getColor(), moveTo) ? "NA" : moveTo;
		}
		else
		{
			return "NA";
		}
	}
	private boolean checkForEnemy(PeiceColor allyColor, String checkLocation)
	{
		String pAtLocation = board.getSpacePiece(checkLocation);
		if(pAtLocation != "")
		{
			if(allyColor == PeiceColor.WHITE)
			{
				return pAtLocation.charAt(0) == 'b';
			}
			else
			{
				return pAtLocation.charAt(0) == 'w';
			}
		}
		else
		{
			return false;
		}
	}
	private boolean checkForAlly(PeiceColor allyColor, String checkLocation)
	{
		String pAtLocation = board.getSpacePiece(checkLocation);
		if(pAtLocation != "")
		{
			if(allyColor == PeiceColor.WHITE)
			{
				return pAtLocation.charAt(0) == 'w';
			}
			else
			{
				return pAtLocation.charAt(0) == 'b';
			}
		}
		else
		{
			return false;
		}
	}
	private ArrayList<String> getKnightMoves(Peice p)
	{
		ArrayList<String> temp = new ArrayList<String>();
		String t;
		if(getMove(-2, -1, p) != "NA")
		{
			t = getMove(-2, -1, p);
			temp.add(t);
			
		}
		if(getMove(-2, 1, p) != "NA")
		{
			t = getMove(-2, 1, p);
			temp.add(t);
		}
		if(getMove(2, -1, p) != "NA")
		{
			t = getMove(2, -1, p);
			temp.add(t);
		}
		if(getMove(2, 1, p) != "NA")
		{
			t = getMove(2, 1, p);
			temp.add(t);
		}
		if(getMove(-1, -2, p) != "NA")
		{
			t = getMove(-1, -2, p);
			temp.add(t);
		}
		if(getMove(-1, 2, p) != "NA")
		{
			t = getMove(-1, 2, p);
			temp.add(t);
		}
		if(getMove(1, -2, p) != "NA")
		{
			t = getMove(1, -2, p);
			temp.add(t);
		}
		if(getMove(1, 2, p) != "NA")
		{
			t = getMove(1, 2, p);
			temp.add(t);
		}
		
		return temp;
	}
	public String getPeiceLocation(String pId)
	{
		int pIndex = findPeiceIndex(pId);
		String loc;
		if(pId.charAt(0) == 'b')
		{
			loc = this.black[pIndex].getLocation();
		}
		else
		{
			loc = this.white[pIndex].getLocation();
		}
		return loc;
	}
	public void setPeiceType(String pId, PeiceType t)
	{
		int pIndex = findPeiceIndex(pId);
		if(pId.charAt(0) == 'b')
		{
			this.black[pIndex].setType(t);
		}
		else
		{
			this.white[pIndex].setType(t);
		}
	}
	public PeiceType getPeiceType(String pId)
	{
		int pIndex = findPeiceIndex(pId);
		PeiceType t;
		if(pId.charAt(0) == 'b')
		{
			t = this.black[pIndex].getType();
		}
		else
		{
			t = this.white[pIndex].getType();
		}
		return t;
	}
	public boolean checkForPeice(String checkLocation)
	{
		String pAtLocation = board.getSpacePiece(checkLocation);
		if(pAtLocation != "")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String getSpacePeice(String Location)
	{
		return this.board.getSpacePiece(Location);
	}
	public void doMove(String pId, String newLocation)
	{
		int pIndex = findPeiceIndex(pId);
		String cLocation;
		boolean MovedBefore;
		if(pId.charAt(0) == 'b')
		{
			cLocation = this.black[pIndex].getLocation();
			MovedBefore = this.black[pIndex].isHasMoved();
		}
		else
		{
			cLocation = this.white[pIndex].getLocation();
			MovedBefore = this.white[pIndex].isHasMoved();
		}
		
		this.board.setSpacePiece(newLocation, pId);
		this.board.setSpacePiece(cLocation, "");
		if(pId.charAt(0) == 'b')
		{
			this.black[pIndex].setLocation(newLocation);
			if(!MovedBefore)
			{
				this.black[pIndex].setHasMoved(true);
			}
		}
		else
		{
			this.white[pIndex].setLocation(newLocation);
			if(!MovedBefore)
			{
				this.white[pIndex].setHasMoved(true);
			}
		}
	}
	public Peice getPeice(String id)
	{
		int peiceIndex = findPeiceIndex(id);
		if(id.charAt(0) == 'b')
		{
			return this.black[peiceIndex];
		}
		else
		{
			return this.white[peiceIndex];
		}
	}
	public boolean isInCheck(String color)
	{
		ArrayList<String> EnemyMoves = (color == "White")? GetPossEnemyMoves(PeiceColor.WHITE): GetPossEnemyMoves(PeiceColor.BLACK);
		String KingID = (color == "White")? "w1" : "b1";
		String KingLoc = getPeice(KingID).getLocation();
		for(int x = 0; x < EnemyMoves.size(); x++)
		{
			if(EnemyMoves.get(x).equals(KingLoc))
			{
				return true;
			}
		}
		return false;
	}
	private ArrayList<String> GetPossEnemyMoves(PeiceColor p)
	{
		ArrayList<String> temp = new ArrayList<String>();
		
		if(p == PeiceColor.BLACK)
		{
			for(int x = 1; x < whiteID.size(); x++)
			{
				temp.addAll(findPeiceMoves(whiteID.get(x)));
			}
			
		}
		else
		{
			for(int x = 1; x < blackID.size(); x++)
			{
				temp.addAll(findPeiceMoves(blackID.get(x)));
			}
		}
		return temp;
	};
	public Path getPath(String peiceId, String locationId)
	{
		Path path = new Path();
		int index = findPeiceIndex(peiceId);
		String current;
		PeiceType t;
		Movement m = new Movement();
		if(peiceId.charAt(0) == 'b')
		{
			current = this.black[index].getLocation();
			t = this.black[index].getType();
		}
		else
		{
			current = this.white[index].getLocation();
			t = this.black[index].getType();
		}
		double pY = m.getPxLocation(current.split("-")[0]);
		double pX = m.getPxLocation(current.split("-")[1]);
		double lY = m.getPxLocation(locationId.split("-")[0]);
		double lX = m.getPxLocation(locationId.split("-")[1]); 
		if(t == PeiceType.KNIGHT)
		{
			path = MakePathKinght(pX, pY, lX, lY);
		}
		else
		{
			path = MakePath(pX, pY, lX, lY);
		}
		return path;
	}
	private Path MakePath(double px, double py, double x, double y)
	{
		Path path = new Path();
		path.getElements().add(new MoveTo((px +40), (py+40)));
		path.getElements().add(new LineTo((x+40), (y+40)));
		
		return path;
	}
	private Path MakePathKinght(double px, double py, double x, double y)
	{
		Path path = new Path();
		path.getElements().add(new MoveTo((px +40), (py+40)));
		path.getElements().add(new LineTo((px+40), (y+40)));
		path.getElements().add(new LineTo((x+40), (y+40)));
		
		return path;
	}
	private int findPeiceIndex(String id)
	{
		int index = 0;
		for(int x = 0; x < 16; x++)
		{
			if(id.charAt(0) == 'b')
			{
				if(id.equals(black[x].getID()))
				{
					index = x;
					break;
				}
			}
			else
			{
				if(id.equals(white[x].getID()))
				{
					index = x;
					break;
				}
			}
			
		}
		return index;
	}
}
