
public class Space {
	private final String CoordCode;
	private String peiceID;
	
	Space(String coords, String p)
	{
		this.CoordCode = coords;
		this.setPeiceID(p);
	}

	/**
	 * @return the coordCode
	 */
	public String getCoordCode() {
		return CoordCode;
	}

	/**
	 * @return the peiceID
	 */
	public String getPeiceID() {
		return peiceID;
	}

	/**
	 * @param peiceID the peiceID to set
	 */
	public void setPeiceID(String peiceID) {
		this.peiceID = peiceID;
	}
}
