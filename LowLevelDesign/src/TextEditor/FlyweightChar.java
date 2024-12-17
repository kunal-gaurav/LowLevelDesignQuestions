package TextEditor;

public class FlyweightChar {

	private char character;
	private String fontName;
	private int fontSize;
	private boolean isBold;
	private boolean isItalic;
	private String style;

	public FlyweightChar(char character, String fontName, int fontSize, boolean isBold, boolean isItalic, String style) {
		this.character = character;
		this.fontName = fontName;
		this.fontSize = fontSize;
		this.isBold = isBold;
		this.isItalic = isItalic;
		this.style = style;
	}
	
	public char getCharacter() {
		return this.character;
	}

	public String getCharAndStyle() {
		return this.style;
	}
}
