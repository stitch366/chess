package board;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;





public class ChessGameData {
	public String CurrentTurn;
	public String GameFileName ="";
	public Space[][] board = new Space[8][8];
	public ArrayList<String> blackId = new ArrayList<String>(0);
	public ArrayList<String> whiteId = new ArrayList<String>(0);
	public HashMap<String, Piece> white = new HashMap<String, Piece>(0);
	public HashMap<String, Piece> black = new HashMap<String, Piece>(0);
	
	
	public ChessGameData(String currentTurn, String gameFileName, Space[][] board, ArrayList<String> blackId,
			ArrayList<String> whiteId, HashMap<String, Piece> white, HashMap<String, Piece> black) {
		this.CurrentTurn = currentTurn;
		this.GameFileName = gameFileName;
		this.board = board;
		this.blackId = blackId;
		this.whiteId = whiteId;
		this.white = white;
		this.black = black;
	}

	//for New Game 
	ChessGameData()
	{
		this.CurrentTurn = "White";
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
		whiteId.add("w9");
		white.put("w9", new Piece("7-1", PieceColor.WHITE, PieceType.PAWN, false));
		whiteId.add("w10");
		white.put("w10", new Piece("7-2", PieceColor.WHITE, PieceType.PAWN, false));
		whiteId.add("w11");
		white.put("w11", new Piece("7-3", PieceColor.WHITE, PieceType.PAWN, false));
		whiteId.add("w12");
		white.put("w12", new Piece("7-4", PieceColor.WHITE, PieceType.PAWN, false));
		whiteId.add("w13");
		white.put("w13", new Piece("7-5", PieceColor.WHITE, PieceType.PAWN, false));
		whiteId.add("w14");
		white.put("w14", new Piece("7-6", PieceColor.WHITE, PieceType.PAWN, false));
		whiteId.add("w15");
		white.put("w15", new Piece("7-7", PieceColor.WHITE, PieceType.PAWN, false));
		whiteId.add("w16");
		white.put("w16", new Piece("7-8", PieceColor.WHITE, PieceType.PAWN, false));
		
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
		
		blackId.add("b9");
		black.put("b9", new Piece("2-1", PieceColor.BLACK, PieceType.PAWN, false));
		blackId.add("b10");
		black.put("b10", new Piece("2-2", PieceColor.BLACK, PieceType.PAWN, false));
		blackId.add("b11");
		black.put("b11", new Piece("2-3", PieceColor.BLACK, PieceType.PAWN, false));
		blackId.add("b12");
		black.put("b12", new Piece("2-4", PieceColor.BLACK, PieceType.PAWN, false));
		blackId.add("b13");
		black.put("b13", new Piece("2-5", PieceColor.BLACK, PieceType.PAWN, false));
		blackId.add("b14");
		black.put("b14", new Piece("2-6", PieceColor.BLACK, PieceType.PAWN, false));
		blackId.add("b15");
		black.put("b15", new Piece("2-7", PieceColor.BLACK, PieceType.PAWN, false));
		blackId.add("b16");
		black.put("b16", new Piece("2-8", PieceColor.BLACK, PieceType.PAWN, false));
		
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
	}
	
	//for loading saved games
	ChessGameData(String fname)
	{
		this.GameFileName = fname;
		ArrayList<String> file = getGameFile(fname);
		this.CurrentTurn = file.get(0).split("=")[1];
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
		for(int x = 1; x < file.size(); x++)
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
	}
	private ArrayList<String> getGameFile(String filename)
	{
		ArrayList<String> gamefileLines = new ArrayList<String>(0);
		File file = new File("C:/ChessFX/games/"+filename);
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
	public void saveData()
	{
		ArrayList<String> fileLines = makeFileLines();
		File file = new File("C:/ChessFX/games/"+GameFileName);
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
				
			try {
				for (int i = 0; i < fileLines.size(); i++) 
				{
					bw.write(fileLines.get(i));
					bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private ArrayList<String> makeFileLines() {
		ArrayList<String> lines = new ArrayList<String>(0);
		lines.add("currentTurn="+ CurrentTurn);
		lines.add("White");
		String line;
		String cid;
		for(int x =0; x < whiteId.size(); x++)
		{
			cid = whiteId.get(x);
			line = whiteId.get(x)+","+ white.get(cid).type.getVal()+","+ white.get(cid).getLocation()+","+Boolean.toString(white.get(cid).hasMoved);
			lines.add(line);
		}
		lines.add("Black");
		for(int x =0; x < blackId.size(); x++)
		{
			cid = blackId.get(x);
			line = blackId.get(x)+","+ black.get(cid).type.getVal()+","+ black.get(cid).getLocation()+","+Boolean.toString(black.get(cid).hasMoved);
			lines.add(line);
		}
		return lines;
	}

	public String getCurrentTurn() {
		return CurrentTurn;
	}

	public void setCurrentTurn(String currentTurn) {
		CurrentTurn = currentTurn;
	}

	public String getGameFileName() {
		return GameFileName;
	}

	public void setGameFileName(String gameFileName) {
		GameFileName = gameFileName;
	}

	public Space[][] getBoard() {
		return board;
	}

	public void setBoard(Space[][] board) {
		this.board = board;
	}

	public ArrayList<String> getBlackId() {
		return blackId;
	}

	public void setBlackId(ArrayList<String> blackId) {
		this.blackId = blackId;
	}

	public ArrayList<String> getWhiteId() {
		return whiteId;
	}

	public void setWhiteId(ArrayList<String> whiteId) {
		this.whiteId = whiteId;
	}

	public HashMap<String, Piece> getWhite() {
		return white;
	}

	public void setWhite(HashMap<String, Piece> white) {
		this.white = white;
	}

	public HashMap<String, Piece> getBlack() {
		return black;
	}

	public void setBlack(HashMap<String, Piece> black) {
		this.black = black;
	}
}
