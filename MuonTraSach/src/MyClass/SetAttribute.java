package MyClass;

import java.awt.Color;

public class SetAttribute {
	public static Color setColor(String str) {
		switch (str) {
		case "Chưa trả", "Hết hạn", "Hết sách":
			return Color.red;

		case "Đã trả", "Còn hạn", "Còn sách":
			return Color.GREEN;
		}
		return null;
	}
}
