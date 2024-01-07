public class ATM {
        private long soDu, tienGui, tienRut;

        public ATM(long soDu) {
                this.soDu = soDu;
        }

        public long getSoDu() {
                return soDu;
        }

        public void setSoDu(long soDu) {
                this.soDu = soDu;
        }

        public long getTienGui() {
                return tienGui;
        }

        public void setTienGui(long tienGui) {
                this.tienGui = tienGui;
        }

        public long getTienRut() {
                return tienRut;
        }

        public void setTienRut(long tienRut) {
                this.tienRut = tienRut;
        }

        /**
         * tinhSoDuSauKhiRut(long tienRut)
         */
        public long tinhSoDuSauKhiRut(long tienRut) {
                return soDu - tienRut;
        }

        /**
         * tinhSoDuSauKhiGui(long tienGui)
         */
        public long tinhSoDuSauKhiGui(long tienGui) {
                return soDu + tienGui;
        }

        /**
         * kiemTraSoDu()
         */
        public long kiemTraSoDu() {
                return soDu;
        }
}
