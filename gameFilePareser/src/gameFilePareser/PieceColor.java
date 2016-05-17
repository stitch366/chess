package gameFilePareser;


public enum PieceColor {
	WHITE('w'), BLACK('b');
	private final char val;
	PieceColor(char t)
	{
		this.val = t;
	}
	/**
	 * @return the val
	 */
	public char getVal() {
		return val;
	}
}
