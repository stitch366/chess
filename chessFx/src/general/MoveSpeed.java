package general;

public enum MoveSpeed {
	MED(1000, "Medium"), SLOW(1500, "Slow"), FAST(500, "Fast");
	private MoveSpeed(int millisec, String r) {
		this.setMillisec(millisec);
		this.setRadioText(r);
	}

	/**
	 * @return the millisec
	 */
	public int getMillisec() {
		return millisec;
	}
	private String radioText;
	/**
	 * @param millisec the millisec to set
	 */
	private void setMillisec(int millisec) {
		this.millisec = millisec;
	}

	/**
	 * @return the radioText
	 */
	public String getRadioText() {
		return radioText;
	}

	/**
	 * @param radioText the radioText to set
	 */
	public void setRadioText(String radioText) {
		this.radioText = radioText;
	}
	private int millisec;
}
