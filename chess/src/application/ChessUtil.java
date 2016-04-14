package application;

import java.util.ArrayList;

public class ChessUtil {
	public String[] whiteID = new String[16];
	public String[] blackID = new String[16];
	public Peice[] white = new Peice[16];
	public Peice[] black = new Peice[16];
	public Board board;
	
	public ChessUtil()
	{
		for(int x = 0; x < 16; x++)
		{
			this.whiteID[x] ="w"+(x+1);
			this.blackID[x] ="b"+(x+1);
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
	
	private void setBoard()
	{
		String id;
		String location;
		for(int x = 0; x< 16; x++)
		{
			id = white[x].getID();
			location = white[x].getLocation();
			this.board.setSpacePiece(location, id);
			id = black[x].getID();
			location = black[x].getLocation();
			this.board.setSpacePiece(location, id);
		}
	}
	public ArrayList<String> findPeiceMoves(String id)
	{
		int pIndex = findPeiceIndex(id);
		Peice p = id.charAt(0) == 'w' ? white[pIndex] : black[pIndex];
		ArrayList<String> moves = new ArrayList<String>();
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
				if(getMove(-1, 0, p) != "NA")
				{
					t = getMove(-1, 0, p);
					temp.add(t);
				}
				if(!p.isHasMoved())
				{
					if(getMove(-2, 0, p) != "NA")
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
				if(getMove(1, 0, p) != "NA")
				{
					t = getMove(1, 0, p);
					temp.add(t);
				}
				if(!p.isHasMoved())
				{
					if(getMove(2, 0, p) != "NA")
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
	private boolean checkForPeice(String checkLocation)
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