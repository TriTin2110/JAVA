package GhiChu;

import java.io.Serializable;

public class NoiDung implements Serializable {
        String noiDung;

        public NoiDung(String noiDung) {
                this.noiDung = noiDung;
        }

        public String getNoiDung() {
                return noiDung;
        }

        public void setNoiDung(String noiDung) {
                this.noiDung = noiDung;
        }
}
