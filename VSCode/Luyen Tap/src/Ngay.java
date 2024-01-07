public class Ngay {
        private int day, month, year;

        public Ngay(int day, int month, int year) {
                this.day = day;
                this.month = month;
                this.year = year;
        }

        public int getDay() {
                return day;
        }

        public void setDay(int day) {
                this.day = day;
        }

        public int getMonth() {
                return month;
        }

        public void setMonth(int month) {
                this.month = month;
        }

        public int getYear() {
                return year;
        }

        public void setYear(int year) {
                this.year = year;
        }

        public String toString() {
                return this.day + "/" + this.month + "/" + this.year;
        }
}