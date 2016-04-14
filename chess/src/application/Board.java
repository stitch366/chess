package application;

public class Board {
	public String[] rowA = new String[8];
	public String[] rowB = new String[8];
	public String[] rowC = new String[8];
	public String[] rowD = new String[8];
	public String[] rowE = new String[8];
	public String[] rowF = new String[8];
	public String[] rowG = new String[8];
	public String[] rowH = new String[8];
	
	public Board(Peice[] wPeices, Peice[] bPeices)
	{
		String id;
		String row;
		int index;
		for(int x = 0; x < 8; x++)
		{
			this.rowA[x] = "";
			this.rowB[x] = "";
			this.rowC[x] = "";
			this.rowD[x] = "";
			this.rowE[x] = "";
			this.rowF[x] = "";
			this.rowG[x] = "";
			this.rowH[x] = "";
		}
		for(int x = 0; x < 16; x++)
		{
			id = wPeices[x].getID();
			row = wPeices[x].getLocation().split("-")[0];
			index = Integer.parseInt(wPeices[x].getLocation().split("-")[1]) - 1;
			
			switch(row)
			{
				case "a":
					this.rowA[index] = id;
					break;
				case "b":
					this.rowB[index] = id;
					break;
				case "c":
					this.rowC[index] = id;
					break;
				case "d":
					this.rowD[index] = id;
					break;
				case "e":
					this.rowE[index] = id;
					break;
				case "f":
					this.rowF[index] = id;
					break;
				case "g":
					this.rowG[index] = id;
					break;
				case "h":
					this.rowH[index] = id;
					break;
			}
			
		}
		for(int x = 0; x < 16; x++)
		{
			id = bPeices[x].getID();
			row = bPeices[x].getLocation().split("-")[0];
			index = Integer.parseInt(bPeices[x].getLocation().split("-")[1]) - 1;
			
			switch(row)
			{
				case "a":
					this.rowA[index] = id;
					break;
				case "b":
					this.rowB[index] = id;
					break;
				case "c":
					this.rowC[index] = id;
					break;
				case "d":
					this.rowD[index] = id;
					break;
				case "e":
					this.rowE[index] = id;
					break;
				case "f":
					this.rowF[index] = id;
					break;
				case "g":
					this.rowG[index] = id;
					break;
				case "h":
					this.rowH[index] = id;
					break;
			}
			
		}
	}
	
	
	public String getSpacePiece(String l)
	{
		String row = l.split("-")[0];
		int index = Integer.parseInt(l.split("-")[1]) - 1;
		
		switch(row)
		{
			case "a":
				return this.rowA[index];
			case "b":
				return this.rowB[index];
			case "c":
				return this.rowC[index];
			case "d":
				return this.rowD[index];
			case "e":
				return this.rowE[index];
			case "f":
				return this.rowF[index];
			case "g":
				return this.rowG[index];
			case "h":
			default:
				return this.rowH[index];
		}
	}
	
	public void setSpacePiece(String l, String id)
	{
		String row = l.split("-")[0];
		int index = Integer.parseInt(l.split("-")[1]) - 1;
		
		switch(row)
		{
			case "a":
				this.rowA[index] = id;
				break;
			case "b":
				this.rowB[index] = id;
				break;
			case "c":
				this.rowC[index] = id;
				break;
			case "d":
				this.rowD[index] = id;
				break;
			case "e":
				this.rowE[index] = id;
				break;
			case "f":
				this.rowF[index] = id;
				break;
			case "g":
				this.rowG[index] = id;
				break;
			case "h":
				this.rowH[index] = id;
				break;
		}
	}
}
