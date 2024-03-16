package Thread;

public class Account implements Runnable {
        private String ten;
        private long soTien, a;

        public Account(String ten, long soTien, long a) {
                this.ten = ten;
                this.soTien = soTien;
                this.a = a;
        }

        public String getTen() {
                return ten;
        }

        public void setTen(String ten) {
                this.ten = ten;
        }

        public long getSoTien() {
                return soTien;
        }

        public void setSoTien(long soTien) {
                this.soTien = soTien;
        }

        public long getA() {
                return a;
        }

        public void setA(long a) {
                this.a = a;
        }

        // synchronized có ý nghĩa sẽ ngăn không cho 2 thread chạy phương thức cùng lúc
        @Override
        public synchronized void run() {
                // TODO Auto-generated method stub
                if (this.getSoTien() >= this.getA()) {
                        try {
                                Thread.sleep(1000);
                                this.setSoTien(soTien - this.getA());
                                System.out.println(this.getSoTien());
                        } catch (Exception e) {
                                // TODO: handle exception
                                e.printStackTrace();
                        }
                } else
                        System.out.println("Không đủ tiền!");
        }

}