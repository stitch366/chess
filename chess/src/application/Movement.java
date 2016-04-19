package application;

public class Movement {
	Movement()
	{
	}
	public double getPxLocation(String row)
	{
		switch(row)
		{
			case "a":
			case "1":
				return 0;
			case "b":
			case "2":
				return 80;
			case "c":
			case "3":
				return 160;
			case "d":
			case "4":
				return 240;
			case "e":
			case "5":
				return 320;
			case "f":
			case "6":
				return 400;
			case "g":
			case "7":
				return 480;
			case "h":
			case "8":
				return 560;
			default:
				return 0;
		}
	}
	
	public int convertLetterToNum (String l)
	{
		switch(l)
		{
			case "a":
				return 1;
			case "b":
				return 2;
			case "c":
				return 3;
			case "d":
				return 4;
			case "e":
				return 5;
			case "f":
				return 6;
			case "g":
				return 7;
			case "h":
				return 8;
			default:
				return 1;
		}
	}
	public String convertNumToLetter (int l)
	{
		switch(l)
		{
			case 1:
				return "a";
			case 2:
				return "b";
			case 3:
				return "c";
			case 4:
				return "d";
			case 5:
				return "e";
			case 6:
				return "f";
			case 7:
				return "g";
			case 8:
				return "h";
			default:
				return "a";
		}
	}
	
	public String genNewLocationID(int rMove, int cMove, Peice p)
	{
		Movement m = new Movement();
		int cRow = m.convertLetterToNum(p.location.split("-")[0]);
		int cCol = Integer.parseInt(p.location.split("-")[1]);
		String moveTo;
		if((cRow + rMove <= 8) && (cCol + cMove <= 8) && (cRow + rMove >= 1) && (cCol + cMove >= 1))
		{
			moveTo = m.convertNumToLetter(cRow + rMove) + "-" + (cCol + cMove);
			return moveTo;
		}
		else
		{
			return "NA";
		}
	}
}
