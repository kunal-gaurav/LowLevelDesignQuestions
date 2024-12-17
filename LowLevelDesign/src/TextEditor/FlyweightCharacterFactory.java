package TextEditor;

import java.util.HashMap;
import java.util.Map;

public class FlyweightCharacterFactory {
	
	private Map<String, FlyweightChar> cache;
	
	
	public FlyweightCharacterFactory() {
		this.cache = new HashMap<>();
	}


	FlyweightChar createStyle(char ch, String fontName, int fontSize, boolean isBold, boolean isItalic){
		String style = ch + "-" + fontName + "-" + fontSize + "-" + (isBold ? 'b' : "") + "-" + (isItalic ? 'i' : ""); 
		if(cache.containsKey(style)) {
			return cache.get(style);
		}
		FlyweightChar flyweightChar = new FlyweightChar(ch, fontName, fontSize, isBold, isItalic, style);
		cache.put(style, flyweightChar);
		return flyweightChar;
	}

}
