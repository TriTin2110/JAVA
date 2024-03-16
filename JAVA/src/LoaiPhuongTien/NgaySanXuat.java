package LoaiPhuongTien;

class NgaySanXuat {
	protected int day, month, year;

	public NgaySanXuat(int day, int month, int year) {
		switch (month) {
		case 1:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
		case 3: {
			this.day = (day > 0 && day <= 32) ? day : 1;
			break;
		}
		case 4:
		case 6:
		case 9:
		case 11: {
			this.day = (day > 0 && day < 31) ? day : 1;
			break;
		}
		case 2: {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				this.day = (day > 0 && day < 30) ? day : 1;
				break;
			} else {
				this.day = (day > 0 && day < 29) ? day : 1;
				break;
			}
		}
		default: {
			this.day = 1;
		}
		}

		this.month = (month > 0 && month < 13) ? month : 1;
		this.year = (year > 0) ? year : 1;
	}

	int getDay() {
		return day;
	}

	void setDay(int day) {
		this.day = day;
	}

	int getMonth() {
		return month;
	}

	void setMonth(int month) {
		this.month = month;
	}

	int getYear() {
		return year;
	}

	void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return day + "/" + month + "/" + year;
	}
}
