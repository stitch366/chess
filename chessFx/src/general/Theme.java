package general;

public enum Theme {
	CLASSIC("classic.css", "Classic"), SAKURA("sakura.css", "Sakura"), ORIENTAL("oriental.css", "Oriental");
	
	private final String stylesheet;
	private final String comboString;
	private Theme(String stylesheet, String c) {
		this.stylesheet = stylesheet;
		this.comboString =c;
	}

	/**
	 * @return the stylesheet
	 */
	public String getStylesheet() {
		return stylesheet;
	}

	/**
	 * @return the comboString
	 */
	public String getComboString() {
		return comboString;
	}
}
