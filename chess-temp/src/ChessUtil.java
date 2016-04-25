import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ChessUtil {
	//Space[row][col]
	//CoordsCode = "row-col"
	public Space[][] board = new Space[8][8];
	public ArrayList<String> blackId = new ArrayList<String>(0);
	public ArrayList<String> whiteId = new ArrayList<String>(0);
	public HashMap<String, Piece> white = new HashMap<String, Piece>(0);
	public HashMap<String, Piece> black = new HashMap<String, Piece>(0);
	
	public ChessUtil()
	{
		
		whiteId.add("w1");
		white.put("w1", new Piece("8-5", PieceColor.WHITE, PieceType.KING, false));
		whiteId.add("w2");
		white.put("w2", new Piece("8-4", PieceColor.WHITE, PieceType.QUEEN, false));
		whiteId.add("w3");
		white.put("w3", new Piece("8-3", PieceColor.WHITE, PieceType.BISHOP, false));
		whiteId.add("w4");
		white.put("w4", new Piece("8-6", PieceColor.WHITE, PieceType.BISHOP, false));
		whiteId.add("w5");
		white.put("w5", new Piece("8-2", PieceColor.WHITE, PieceType.KNIGHT, false));
		whiteId.add("w6");
		white.put("w6", new Piece("8-7", PieceColor.WHITE, PieceType.KNIGHT, false));
		whiteId.add("w7");
		white.put("w7", new Piece("8-1", PieceColor.WHITE, PieceType.ROOK, false));
		whiteId.add("w8");
		white.put("w8", new Piece("8-8", PieceColor.WHITE, PieceType.ROOK, false));
		
		for(int x = 1; x < 9; x++)
		{
			whiteId.add("w"+(x+8));
			white.put("w"+(x+8), new Piece(("7-"+x), PieceColor.WHITE, PieceType.PAWN, false));
		}
		
		blackId.add("b1");
		black.put("b1", new Piece("1-5", PieceColor.BLACK, PieceType.KING, false));
		blackId.add("b2");
		black.put("b2", new Piece("1-4", PieceColor.BLACK, PieceType.QUEEN, false));
		blackId.add("b3");
		black.put("b3", new Piece("1-3", PieceColor.BLACK, PieceType.BISHOP, false));
		blackId.add("b4");
		black.put("b4", new Piece("1-6", PieceColor.BLACK, PieceType.BISHOP, false));
		blackId.add("b5");
		black.put("b5", new Piece("1-2", PieceColor.BLACK, PieceType.KNIGHT, false));
		blackId.add("b6");
		black.put("b6", new Piece("1-7", PieceColor.BLACK, PieceType.KNIGHT, false));
		blackId.add("b7");
		black.put("b7", new Piece("1-1", PieceColor.BLACK, PieceType.ROOK, false));
		blackId.add("b8");
		black.put("b8", new Piece("1-8", PieceColor.BLACK, PieceType.ROOK, false));
		
		for(int x = 1; x < 9; x++)
		{
			blackId.add("b"+(x+8));
			black.put("b"+(x+8), new Piece(("2-"+x), PieceColor.BLACK, PieceType.PAWN, false));
		}
		
		//row 1
		board[0][0] = new Space("1-1", "b7");
		board[0][1] = new Space("1-2", "b5");
		board[0][2] = new Space("1-3", "b3");
		board[0][3] = new Space("1-4", "b2");
		board[0][4] = new Space("1-5", "b1");
		board[0][5] = new Space("1-6", "b4");
		board[0][6] = new Space("1-7", "b6");
		board[0][7] = new Space("1-8", "b8");
		
		//row2
		board[1][0] = new Space("2-1", "b9");
		board[1][1] = new Space("2-2", "b10");
		board[1][2] = new Space("2-3", "b11");
		board[1][3] = new Space("2-4", "b12");
		board[1][4] = new Space("2-5", "b13");
		board[1][5] = new Space("2-6", "b14");
		board[1][6] = new Space("2-7", "b15");
		board[1][7] = new Space("2-8", "b16");
		
		//rows 3-6
		for(int x = 2; x < 6; x++)
		{
			board[x][0] = new Space((x+1)+"-1", "");
			board[x][1] = new Space((x+1)+"-2", "");
			board[x][2] = new Space((x+1)+"-3", "");
			board[x][3] = new Space((x+1)+"-4", "");
			board[x][4] = new Space((x+1)+"-5", "");
			board[x][5] = new Space((x+1)+"-6", "");
			board[x][6] = new Space((x+1)+"-7", "");
			board[x][7] = new Space((x+1)+"-8", "");
		}
		
		//row7
		board[6][0] = new Space("7-1", "w9");
		board[6][1] = new Space("7-2", "w10");
		board[6][2] = new Space("7-3", "w11");
		board[6][3] = new Space("7-4", "w12");
		board[6][4] = new Space("7-5", "w13");
		board[6][5] = new Space("7-6", "w14");
		board[6][6] = new Space("7-7", "w15");
		board[6][7] = new Space("7-8", "w16");
		
		//row 1
		board[7][0] = new Space("8-1", "w7");
		board[7][1] = new Space("8-2", "w5");
		board[7][2] = new Space("8-3", "w3");
		board[7][3] = new Space("8-4", "w2");
		board[7][4] = new Space("8-5", "w1");
		board[7][5] = new Space("8-6", "w4");
		board[7][6] = new Space("8-7", "w6");
		board[7][7] = new Space("8-8", "w8");
		setAllRange(blackId);
		setAllRange(whiteId);
		setAllMoves(blackId);
		setAllMoves(whiteId);
		
	}
	public ChessUtil(String fname)
	{
		ArrayList<String> file = getGameFile(fname);
		for(int x = 0; x < 8; x++)
		{
			for (int y = 0; y < 8; y++)
			{
				this.board[x][y]= new Space((x+1)+"-"+(y+1), "");
			}
		}
		String line = "a";
		String id;
		String loc;
		PieceType t;
		int row;
		int col;
		String temp;
		boolean hasmov;
		for(int x = 0; x < file.size(); x++)
		{
			
			while(line != "" && (!line.equals("Black")))
			{
				x= x+1;
				line = file.get(x);
				if(line.equals("Black"))
				{
					line ="";
				}
				else
				{
				id = line.split(",")[0];
				t = convertStrToPeiceType(line.split(",")[1]);
				loc = line.split(",")[2];
				hasmov = (line.split(",")[3] == "true");
				temp =loc.split("-")[0];
				row = Integer.parseInt(temp) -1;
				temp=loc.split("-")[1];
				col = Integer.parseInt(temp) -1;
				this.whiteId.add(id);
				this.white.put(id, new Piece(loc,PieceColor.WHITE, t, hasmov));
				this.board[row][col].setPeiceID(id);
				}
				
			}
			line ="a";
			while(x < file.size()-1)
			{
				x= x+1;
				line = file.get(x);
				id = line.split(",")[0];
				t = convertStrToPeiceType(line.split(",")[1]);
				loc = line.split(",")[2];
				hasmov = (line.split(",")[3] == "true");
				temp =loc.split("-")[0];
				row = Integer.parseInt(temp) -1;
				temp=loc.split("-")[1];
				col = Integer.parseInt(temp) -1;
				this.blackId.add(id);
				this.black.put(id, new Piece(loc,PieceColor.BLACK, t, hasmov));
				this.board[row][col].setPeiceID(id);
			}
		}

		setAllRange(blackId);
		setAllRange(whiteId);
		setAllMoves(blackId);
		setAllMoves(whiteId);
	}
	public void OutPutboard()
	{
		String row;
		String temp;
		String p;
		for(int x =0; x < 8; x++)
		{
			row = "";
			for(int y =0; y < 8; y++)
			{
				temp = board[x][y].getPeiceID();
				if(temp == "")
				{
					row = row + "|    ";
				}
				else
				{
					if(temp.charAt(0)== 'w')
					{
						p = white.get(temp).getColor().getVal()+ white.get(temp).getType().getAlt();
					}
					else
					{
						p = black.get(temp).getColor().getVal()+ black.get(temp).getType().getAlt();
					}
					row = row + "| "+p+" ";
				}
			}
			row = row + "|";
			System.out.println(row);
			System.out.println("________________________________________");
		}
	}
	private PieceType convertStrToPeiceType(String str)
	{
		switch(str)
		{
			case "King":
				return PieceType.KING;
			case "Queen": 
				return PieceType.QUEEN;
			case "Bishop":
				return PieceType.BISHOP;
			case "Knight": 
				return PieceType.KNIGHT;
			case "Rook":
				return PieceType.ROOK;
			case "Pawn":
			default:
				return PieceType.PAWN;
		}
	}
	private ArrayList<String> getGameFile(String filename)
	{
		ArrayList<String> gamefileLines = new ArrayList<String>(0);
		File file = new File("games/"+filename);
	    FileInputStream fis = null;
	   
	      try {
			fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
		  	try {
				while ((line = br.readLine()) != null) {
					gamefileLines.add(line);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return gamefileLines;
	}
	public void removePiece(String id)
	{
		if(id.charAt(0) == 'b')
		{
			this.blackId.remove(id);
			this.black.remove(id);
		}
		else
		{
			this.whiteId.remove(id);
			this.white.remove(id);
		}
	}
	public void setAllMoves(ArrayList<String> keyList)
	{
		for(int x =0; x < keyList.size(); x++)
		{
			setMoves(keyList.get(x));
		}
	}
	public void setAllRange(ArrayList<String> keyList)
	{
		for(int x =0; x < keyList.size(); x++)
		{
			setRange(keyList.get(x));
		}
	}
	
	private void setMoves(String id)
	{
		boolean isWhite = false;
		if(id.charAt(0)== PieceColor.WHITE.getVal())
		{
			isWhite = true;
		}
		ArrayList<String> temp = new ArrayList<String>(0);
		Piece p = isWhite? white.get(id): black.get(id);
		Offset[] offs = p.getType().getMoveOffsets(p.getColor()); 
		switch(p.getType())
		{
			case BISHOP:
				temp.addAll(moveindefinite(offs, p.getLocation(), p.getColor().getVal()));
				break;
			case KING:
				temp.addAll(getKingMoves(movefixed(offs, p.getLocation(), p), p.getColor().getVal()));
				break;
			case KNIGHT:
				temp.addAll(movefixed(offs, p.getLocation(), p));
				break;
			case PAWN:
				temp.addAll(movefixed(offs, p.getLocation(), p));
				break;
			case QUEEN:
				temp.addAll(moveindefinite(offs, p.getLocation(), p.getColor().getVal()));
				break;
			case ROOK:
				temp.addAll(moveindefinite(offs, p.getLocation(), p.getColor().getVal()));
				break;
			default:
				break;
		
		}
		if(isWhite)
		{
			this.white.get(id).setMoves(temp);
		}
		else
		{
			this.black.get(id).setMoves(temp);
		}
		
	}
	private void setRange(String id)
	{
		boolean isWhite = false;
		if(id.charAt(0)== PieceColor.WHITE.getVal())
		{
			isWhite = true;
		}
		ArrayList<String> temp = new ArrayList<String>(0);
		Piece p = isWhite? white.get(id): black.get(id);
		Offset[] offs = p.getType().getMoveOffsets(p.getColor()); 
		switch(p.getType())
		{
			case BISHOP:
				temp.addAll(rangeindefinite(offs, p.getLocation(), p.getColor().getVal()));
				break;
			case KING:
				temp.addAll(rangefixed(offs, p.getLocation(), p));
				break;
			case KNIGHT:
				temp.addAll(rangefixed(offs, p.getLocation(), p));
				break;
			case PAWN:
				temp.addAll(rangefixed(offs, p.getLocation(), p));
				break;
			case QUEEN:
				temp.addAll(rangeindefinite(offs, p.getLocation(), p.getColor().getVal()));
				break;
			case ROOK:
				temp.addAll(rangeindefinite(offs, p.getLocation(), p.getColor().getVal()));
				break;
			default:
				break;
		
		}
		if(isWhite)
		{
			this.white.get(id).setRange(temp);
		}
		else
		{
			this.black.get(id).setRange(temp);
		}
		
	}
	private ArrayList<String> moveindefinite(Offset[] o, String location, char c)
	{
		ArrayList<String> temp = new ArrayList<String>(0);
		int cRow = Integer.parseInt(location.split("-")[0]);
		int cCol = Integer.parseInt(location.split("-")[1]);
		String moveTo = "";
		String pid;
		int count = 1;
		for(int x = 0; x < o.length; x++)
		{
			moveTo = "";
			while(moveTo !="NA")
			{
				if((cRow + (o[x].getRow() * count) <= 8) && (cCol + (o[x].getCol() * count) <= 8) && (cRow + (o[x].getRow() * count) >= 1) && (cCol + (o[x].getCol() * count) >= 1))
				{
					moveTo = (cRow + (o[x].getRow() * count)) + "-" + (cCol + (o[x].getCol() * count));
					pid =board[(cRow + (o[x].getRow() * count))-1][(cCol + (o[x].getCol() * count))-1].getPeiceID();
					if(pid =="")
					{
						temp.add(moveTo);
					}
					else if(pid.charAt(0)== c)
					{
						moveTo="NA";
					}
					else
					{
						temp.add(moveTo);
						moveTo="NA";
					}
				}
				else
				{
					moveTo = "NA";
				}
				count++;
			}
			count = 1;
		}
		return temp;
	}
	private ArrayList<String> movefixed(Offset[] o, String location, Piece c)
	{
		ArrayList<String> temp = new ArrayList<String>(0);
		int cRow = Integer.parseInt(location.split("-")[0]);
		int cCol = Integer.parseInt(location.split("-")[1]);
		String moveTo = "";
		String pid;
		for(int x = 0; x < o.length; x++)
		{
			moveTo = "";
			
			if((x == 3)&&(c.getType() == PieceType.PAWN && c.isHasMoved()))
			{
				
			}
			else if((cRow + o[x].getRow() <= 8) && (cCol + o[x].getCol() <= 8) && (cRow + o[x].getRow() >= 1) && (cCol + o[x].getCol() >= 1))
			{
				pid =board[(cRow + o[x].getRow())-1][(cCol + o[x].getCol())-1].getPeiceID();
				moveTo = (cRow + o[x].getRow()) + "-" + (cCol + o[x].getCol());
				if((x == 2 || x== 1)&&c.getType() == PieceType.PAWN )
				{
					if(pid != "" && pid.charAt(0) != c.getColor().getVal())
					{
						temp.add(moveTo);
					}
				}
				else
				{
					if(pid == "" || pid.charAt(0) != c.getColor().getVal())
					{
						temp.add(moveTo);
					}
				}
				
				
			}
			
		}
		return temp;
	}
	private ArrayList<String> rangeindefinite(Offset[] o, String location, char c)
	{
		ArrayList<String> temp = new ArrayList<String>(0);
		int cRow = Integer.parseInt(location.split("-")[0]);
		int cCol = Integer.parseInt(location.split("-")[1]);
		String moveTo = "";
		String pid;
		int count = 1;
		for(int x = 0; x < o.length; x++)
		{
			moveTo = "";
			while(moveTo !="NA")
			{
				if((cRow + (o[x].getRow() * count) <= 8) && (cCol + (o[x].getCol() * count) <= 8) && (cRow + (o[x].getRow() * count) >= 1) && (cCol + (o[x].getCol() * count) >= 1))
				{
					moveTo = (cRow + (o[x].getRow() * count)) + "-" + (cCol + (o[x].getCol() * count));
					pid =board[(cRow + (o[x].getRow() * count))-1][(cCol + (o[x].getCol() * count))-1].getPeiceID();
					if(pid =="")
					{
						temp.add(moveTo);
					}
					else if(pid.charAt(0)== c)
					{
						temp.add(moveTo);
						moveTo="NA";
					}
					else
					{
						temp.add(moveTo);
						moveTo="NA";
					}
				}
				else
				{
					moveTo = "NA";
				}
				count++;
			}
			count = 1;
		}
		return temp;
	}
	public ArrayList<String> getKingMoves(ArrayList<String> baseMoves, char c)
	{
		AttackBoard enemyAttackboard = (c == PieceColor.WHITE.getVal())? new AttackBoard(blackId, black): new AttackBoard(whiteId, white);
		ArrayList<String> temp = new ArrayList<String>(0);;
		
		for (int x = 0; x < baseMoves.size(); x ++)
		{
			if(enemyAttackboard.isKingSafeAt(baseMoves.get(x)))
			{
				temp.add(baseMoves.get(x));
			}
		}
		
		return temp;
	}
	private ArrayList<String> rangefixed(Offset[] o, String location, Piece c)
	{
		ArrayList<String> temp = new ArrayList<String>(0);
		int cRow = Integer.parseInt(location.split("-")[0]);
		int cCol = Integer.parseInt(location.split("-")[1]);
		String moveTo = "";
		for(int x = 0; x < o.length; x++)
		{
			moveTo = "";
			
			
			if((cRow + o[x].getRow() <= 8) && (cCol + o[x].getCol() <= 8) && (cRow + o[x].getRow() >= 1) && (cCol + o[x].getCol() >= 1))
			{
				moveTo = (cRow + o[x].getRow()) + "-" + (cCol + o[x].getCol());
				if(c.getType() == PieceType.PAWN)
				{
					if((x == 2 || x== 1)&&c.getType() == PieceType.PAWN )
					{
							temp.add(moveTo);
					}
				}
				
				else
				{
					temp.add(moveTo);
				}
				
				
			}
			
		}
		return temp;
	}
	public void doMove(String pId, String newLocation)
	{
		String cLocation;
		boolean MovedBefore;
		if(pId.charAt(0) == 'b')
		{
			cLocation = this.black.get(pId).getLocation();
			MovedBefore = this.black.get(pId).isHasMoved();
		}
		else
		{
			cLocation = this.white.get(pId).getLocation();
			MovedBefore = this.white.get(pId).isHasMoved();
		}
		int cRow = Integer.parseInt(cLocation.split("-")[0]) - 1;
		int cCol = Integer.parseInt(cLocation.split("-")[1]) - 1;
		int row = Integer.parseInt(newLocation.split("-")[0]) - 1;
		int col = Integer.parseInt(newLocation.split("-")[1]) - 1;
		this.board[cRow][cCol].setPeiceID("");
		this.board[row][col].setPeiceID(pId);
		if(pId.charAt(0) == 'b')
		{
			this.black.get(pId).setLocation(newLocation);
			if(!MovedBefore)
			{
				this.black.get(pId).setHasMoved(true);
			}
		}
		else
		{
			this.white.get(pId).setLocation(newLocation);
			if(!MovedBefore)
			{
				this.white.get(pId).setHasMoved(true);
			}
		}
	}
	public ArrayList<String> getPeiceMoves(String id)
	{
		if(id.charAt(0) == PieceColor.WHITE.getVal())
		{
			return white.get(id).getMoves();
		}
		else
		{
			return black.get(id).getMoves();
		}
	}
}
