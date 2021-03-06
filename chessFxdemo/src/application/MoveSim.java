package application;
import java.util.ArrayList;
import java.util.HashMap;

public class MoveSim {
	public HashMap<String, Piece> ally = new HashMap<String, Piece>(0);
	public HashMap<String, Piece> enemy = new HashMap<String, Piece>(0);
	public ArrayList<String> enemyId = new ArrayList<String>(0);
	public Space[][] SimBoard = new Space[8][8];
	public String kingId;
	public AttackBoard enemyAttackBoard;
	
	MoveSim(HashMap<String, Piece> a,  ArrayList<String> aId, HashMap<String, Piece> e, ArrayList<String> eId, Space[][] sb, String kId, String mpId, String mpto)
	{
		for(int x = 0; x < aId.size(); x++)
		{
			this.ally.put(aId.get(x), new Piece(a.get(aId.get(x))));
		}
		for(int x = 0; x < eId.size(); x++)
		{
			this.enemyId.add(eId.get(x));
		}
		for(int x = 0; x < enemyId.size(); x++)
		{
			this.enemy.put(enemyId.get(x), new Piece(e.get(enemyId.get(x))));
		}
		for(int x = 0; x < 8; x++)
		{
			for (int y = 0; y < 8; y++)
			{
				this.SimBoard[x][y]= new Space(sb[x][y]);
			}
		}
		this.kingId = kId;
		doMove(mpId, mpto);
		setAllEnemyRange(enemyId);
		this.enemyAttackBoard = new AttackBoard(enemyId, enemy);
	}
	private void doMove(String pId, String newLocation)
	{
        String cLocation = this.ally.get(pId).getLocation();
		boolean	MovedBefore = this.ally.get(pId).isHasMoved();
		
		int cRow = Integer.parseInt(cLocation.split("-")[0]) - 1;
		int cCol = Integer.parseInt(cLocation.split("-")[1]) - 1;
		int row = Integer.parseInt(newLocation.split("-")[0]) - 1;
		int col = Integer.parseInt(newLocation.split("-")[1]) - 1;
		String cPiece = SimBoard[row][col].getPeiceID();
		if(cPiece != "")
		{
			removePiece(cPiece);
		}
		this.SimBoard[cRow][cCol].setPeiceID("");
		this.SimBoard[row][col].setPeiceID(pId);
		this.ally.get(pId).setLocation(newLocation);
		if(!MovedBefore)
		{
			this.ally.get(pId).setHasMoved(true);
		}
	}
	private void setAllEnemyRange(ArrayList<String> keyList)
	{
		for(int x =0; x < keyList.size(); x++)
		{
			setEnemyRange(keyList.get(x));
		}
	}
	private void setEnemyRange(String id)
	{
		ArrayList<String> temp = new ArrayList<String>(0);
		Piece p = enemy.get(id);
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
		this.enemy.get(id).setRange(temp);
		
	}
	private void removePiece(String id)
	{
		enemyId.remove(id);
		enemy.remove(id);
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
					pid =SimBoard[(cRow + (o[x].getRow() * count))-1][(cCol + (o[x].getCol() * count))-1].getPeiceID();
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
	public boolean willKingBeSafe()
	{
		String KingLocation = ally.get(kingId).getLocation();
		return this.enemyAttackBoard.isKingSafeAt(KingLocation);
	}
	
	
}
