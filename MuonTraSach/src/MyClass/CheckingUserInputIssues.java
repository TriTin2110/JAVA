package MyClass;

public class CheckingUserInputIssues {
	public static boolean checkingLackInformation(String[] incomeString) {
		for (String tester : incomeString) {
			if (tester.isEmpty())
				// Trả về false nếu bất kỳ trường nào bị nhập thiếu
				return false;
		}
		return true;
	}

	public static boolean checkingPhoneAndAge(String age, String phone) {
		if (Integer.parseInt(age) > 100 || Integer.parseInt(age) < 1 || phone.length() > 10 || phone.length() < 5)
			return false;
		return true;
	}
}
