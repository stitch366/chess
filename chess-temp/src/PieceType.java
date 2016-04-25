

public enum PieceType {
	KING("King", "K"), QUEEN("Queen", "Q"), BISHOP("Bishop", "B"), KNIGHT("Knight", "N"), ROOK("Rook", "R"), PAWN("Pawn", "P");
	private final String val;
	private final String alt;
	PieceType(String t, String a)
	{
		this.val = t;
		this.alt = a;
	}
	public Offset[] getMoveOffsets(PieceColor c)
	{

		switch(this)
		{
			case BISHOP:
				Offset[] off = {new Offset(1, 1), new Offset(1, -1), new Offset(-1, -1), new Offset(-1, 1)};
				return off;
			case KING:
				Offset[] off2 = {new Offset(1, 1), new Offset(1, 0), new Offset(1, -1), new Offset(0, -1), new Offset(-1, -1), new Offset(-1, 0), new Offset(-1, 1), new Offset(0, 1)};
				return off2;
			case KNIGHT:
				Offset[] off3 = {new Offset(-2, -1), new Offset(-2, 1), new Offset(2, -1), new Offset(2, 1), new Offset(-1, -2), new Offset(-1, 2), new Offset(1, -2), new Offset(1, 2)};
				return off3;
			case PAWN:
				if(c == PieceColor.WHITE)
				{
					Offset[] off4 = {new Offset(-1, 0), new Offset(-1, -1), new Offset (-1, 1), new Offset(-2,0)};
					return off4;
				}
				else
				{
					Offset[] off4 = {new Offset(1, 0), new Offset(1, -1), new Offset (1, 1), new Offset(2,0)};
					return off4;
				}
			case QUEEN:
				Offset[] off5 = {new Offset(1, 1), new Offset(1, 0), new Offset(1, -1), new Offset(0, -1), new Offset(-1, -1), new Offset(-1, 0), new Offset(-1, 1), new Offset(0, 1)};
				return off5;
			case ROOK:
				Offset[] off6 = {new Offset(0, 1), new Offset(1, 0), new Offset(0, -1), new Offset(-1, 0)};
				return off6;
			default:
				break;
		}
		return new Offset[1];
	}
	/**
	 * @return the val
	 */
	public String getVal() {
		return val;
	}
	/**
	 * @return the alt
	 */
	public String getAlt() {
		return alt;
	}
}
