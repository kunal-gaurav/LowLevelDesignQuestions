package TextEditor;

import java.util.ArrayList;
import java.util.List;

public class TextEditorSolution {

	private List<TextRow> textRows;
	private FlyweightCharacterFactory factory;

	public TextEditorSolution() {
		this.textRows = new ArrayList<>();
		this.factory = new FlyweightCharacterFactory();
	}

	public void addCharacter(int row, int column, char character, String fontName, int fontSize, boolean isBold,
			boolean isItalic) {
		if (row < 0) {
			return;
		}
		while(row >= textRows.size()) {
			textRows.add(new TextRow());
		}
		FlyweightChar flyweightChar = factory.createStyle(character, fontName, fontSize, isBold, isItalic);
		textRows.get(row).addCharacter(column, flyweightChar);
	}

	public boolean deleteCharacter(int row, int column) {
		if (row < 0 || row >= textRows.size()) {
			return false;
		}
		return textRows.get(row).deleteCharacter(column);
	}

	public String getStyle(int row, int column) {
		if (row < 0 || row >= textRows.size()) {
			return "";
		}
		FlyweightChar flyweightChar = textRows.get(row).getFlyweightChar(column);
		if (null == flyweightChar) {
			return "";
		}
		return flyweightChar.getCharAndStyle();
	}

	public String readLine(int row) {
		if (row < 0 || row >= textRows.size()) {
			return "";
		}
		List<FlyweightChar> line = textRows.get(row).readLine();
		char[] flyweightCharArray = new char[line.size()];
		for(int i=0; i<line.size(); i++) {
			flyweightCharArray[i] = line.get(i).getCharacter();
		}
		return flyweightCharArray.toString();
	}

}
