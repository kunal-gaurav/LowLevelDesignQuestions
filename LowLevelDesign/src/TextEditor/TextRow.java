package TextEditor;

import java.util.ArrayList;
import java.util.List;

public class TextRow {

	private List<FlyweightChar> textRow;

	public TextRow() {
		textRow = new ArrayList<>();
	}

	public void addCharacter(int column, FlyweightChar flyweightChar) {
		if (column > textRow.size()) {
			textRow.add(flyweightChar);
		} else {
			textRow.add(column, flyweightChar);
		}
	}

	public FlyweightChar getFlyweightChar(int column) {
		if (column >= textRow.size()) {
			return null;
		}
		return textRow.get(column);
	}

	public List<FlyweightChar> readLine() {
		return textRow;
	}

	public boolean deleteCharacter(int column) {
		if (column >= textRow.size()) {
			return false;
		}
		textRow.remove(column);
		return true;
	}

}
