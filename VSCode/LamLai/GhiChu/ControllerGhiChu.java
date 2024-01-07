package GhiChu;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

// Tạo các đối tượng để lưu nội dung
public class ControllerGhiChu implements ActionListener {
        ViewGhiChu viewGhiChu;
        int coChu = 14;
        ArrayList<Setting> setting = new ArrayList<Setting>();
        ArrayList<NoiDung> nd = new ArrayList<NoiDung>();
        String fontChu = "Arial";
        String thietLap = "";
        String mauNen = "Sáng";
        File fileThietLap = new File("D:\\Code\\JAVA\\VSCode\\LamLai\\GhiChu\\Setting.data");
        File fileNoiDung = new File("D:\\Code\\JAVA\\VSCode\\LamLai\\GhiChu\\NoiDung.data");
        File fileTieuDe = new File("D:\\Code\\JAVA\\VSCode\\LamLai\\GhiChu\\TieuDe.data");
        File fileFont = new File("D:\\Code\\JAVA\\VSCode\\LamLai\\GhiChu\\Font.data");
        Setting settings = new Setting("", "", "");
        NoiDung noiDung = new NoiDung("");

        public ControllerGhiChu(ViewGhiChu viewGhiChu) {
                this.viewGhiChu = viewGhiChu;
                taoFile();
        }

        /**
         * setFontKhiChay()
         */
        public void setFontKhiChay() {
                this.viewGhiChu.jTextArea.setFont(new Font(fontChu, Font.PLAIN, coChu));

        }

        /**
         * taoFile
         */
        public void taoFile() {
                if (!fileThietLap.exists()) {
                        try {
                                fileThietLap.createNewFile();
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }
                if (!fileNoiDung.exists()) {
                        try {
                                fileNoiDung.createNewFile();
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }
        }

        /**
         * luuThietLap()
         */
        public void luuThietLap(ArrayList<Setting> setting) {
                if (setting.size() == 0) {
                        System.exit(0);
                } else {
                        try {
                                OutputStream os = new FileOutputStream(fileThietLap);
                                ObjectOutputStream ois = new ObjectOutputStream(os);
                                // Ghi từng đối tượng vào fileThietLap
                                for (Setting setting2 : setting) {
                                        ois.writeObject(setting2);
                                }
                                ois.flush();
                                ois.close();
                        } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }

        }

        /**
         * docThietLap()
         */
        public void docThietLap() {
                Setting tl = null;
                try {
                        InputStream is = new FileInputStream(fileThietLap);
                        ObjectInputStream ois = new ObjectInputStream(is);
                        while (true) {
                                Object object = ois.readObject();
                                tl = (Setting) object;
                                if (tl == null) {
                                        break;
                                } else {
                                        setting.add(tl);
                                }
                        }
                        ois.close();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                }

                String[] ketQua = tl.toString().split(";");
                fontChu = ketQua[1];
                coChu = Integer.parseInt(ketQua[2]);
                mauNen = ketQua[0];
                thayDoiMauNen(ketQua[0]);
                setFontKhiChay();

        }

        /**
         * docFileNoiDung()
         */
        // public void docFileNoiDung() {
        // NoiDung ndDoc = null;
        // try {
        // InputStream is = new FileInputStream(fileNoiDung);
        // ObjectInputStream ois = new ObjectInputStream(is);
        // while (true) {
        // Object object = ois.readObject();
        // ndDoc = (NoiDung) object;
        // if (ndDoc == null) {
        // break;
        // }
        // }
        // ois.close();
        // } catch (IOException | ClassNotFoundException e) {
        // // TODO Auto-generated catch block
        // }

        // this.viewGhiChu.jTextArea.setText(ndDoc.getNoiDung());
        // }

        @Override
        public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String luaChon = e.getActionCommand();
                switch (luaChon) {
                        // Tăng kích thước font chữ
                        case "+":
                                coChu += 2;
                                setFontKhiChay();
                                this.viewGhiChu.jLabelHienThiKichCoFontChu.setText(coChu + "");
                                break;

                        // Giảm kích thước font chữ
                        case "-":
                                coChu -= 2;
                                setFontKhiChay();
                                this.viewGhiChu.jLabelHienThiKichCoFontChu.setText(coChu + "");
                                break;

                        case "Arial":
                                fontChu = luaChon;
                                setFontKhiChay();
                                break;
                        case "Times new roman":
                                fontChu = luaChon;
                                setFontKhiChay();
                                break;
                        case "Calibri":
                                fontChu = luaChon;
                                setFontKhiChay();

                                break;
                        case "Thoát":
                                luuTieuDe(this.viewGhiChu.jTextField.getText());
                                thietLapCaiDatTruocKhiLuu();
                                // Thêm đối tượng đã được điều chỉnh vào ArrayList settting
                                setting.add(settings);
                                // Tiến hành lưu thiết lập
                                luuThietLap(setting);
                                xuLyMoVaLuu("Lưu tệp tin");
                                System.exit(0);
                                break;
                        case "Sáng":
                                mauNen = luaChon;
                                thayDoiMauNen(luaChon);
                                break;
                        case "Tối":
                                mauNen = luaChon;
                                thayDoiMauNen(luaChon);
                                break;
                        case "Mở tệp tin":
                                xuLyMoVaLuu(luaChon);
                                break;
                }
        }

        /**
         * thietLapCaiDatTruocKhiLuu()
         */
        public void thietLapCaiDatTruocKhiLuu() {
                settings.setCoChu(coChu + "");
                settings.setLoaiPhong(fontChu);
                settings.setMauChuDe(mauNen);
        }

        /**
         * xuLyMoVaLuu()
         */
        public void xuLyMoVaLuu(String luaChon) {
                JFileChooser jFileChooser = new JFileChooser();
                switch (luaChon) {
                        case "Mở tệp tin":
                                int returnChoosen = jFileChooser.showOpenDialog(this.viewGhiChu);
                                if (returnChoosen == JFileChooser.APPROVE_OPTION) {
                                        File file = jFileChooser.getSelectedFile();
                                        this.viewGhiChu.modelGhiChu.setDuongDan(file.getAbsolutePath());
                                        docNoiDung(file);
                                }
                                break;

                        case "Lưu tệp tin":
                                File file;
                                if (this.viewGhiChu.modelGhiChu.getDuongDan().length() > 0) {
                                        file = new File(this.viewGhiChu.modelGhiChu.getDuongDan());
                                        luuNoiDung(file);
                                } else {
                                        int returnChosen = jFileChooser.showSaveDialog(this.viewGhiChu);
                                        if (returnChosen == JFileChooser.APPROVE_OPTION) {
                                                file = jFileChooser.getSelectedFile();
                                                luuNoiDung(file);
                                        }
                                }
                                break;

                }

        }

        /**
         * docNoiDung()
         */
        public void docNoiDung(File file) {
                String noiDung = "";
                try {
                        ArrayList<String> ketQuaDoc = (ArrayList<String>) Files
                                        .readAllLines(file.toPath());

                        for (String string : ketQuaDoc) {
                                noiDung += string;
                                noiDung += "\n";
                        }

                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                this.viewGhiChu.jTextArea.setText(noiDung);
        }

        /**
         * luuNoiDung()
         */
        public void luuNoiDung(File file) {
                try {
                        PrintWriter pw = new PrintWriter(file);
                        pw.write(this.viewGhiChu.jTextArea.getText());
                        pw.flush();
                        pw.close();
                } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        JOptionPane.showMessageDialog(this.viewGhiChu, "Không thể lưu tệp tin", "Lỗi!!!",
                                        JOptionPane.ERROR_MESSAGE);
                }

        }

        public void luuTieuDe(String tieuDe) {
                if (!fileTieuDe.exists()) {
                        try {
                                fileTieuDe.createNewFile();
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }
                try {
                        PrintWriter printWriter = new PrintWriter(fileTieuDe, "UTF-8");
                        printWriter.write(tieuDe);
                        printWriter.flush();
                        printWriter.close();
                } catch (FileNotFoundException | UnsupportedEncodingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }

        public void thayDoiMauNen(String luaChon) {
                if (luaChon.equals("Sáng")) {
                        this.viewGhiChu.jPanelTextField.setBackground(new Color(252, 223, 141));
                        this.viewGhiChu.jPanelTextField.setOpaque(true);
                        this.viewGhiChu.jPanelTextField.setForeground(Color.black);

                        this.viewGhiChu.jPanelButton.setBackground(new Color(252, 223, 141));
                        this.viewGhiChu.jPanelButton.setOpaque(true);
                        this.viewGhiChu.jPanelButton.setForeground(Color.black);

                        this.viewGhiChu.jTextArea.setBackground(new Color(252, 223, 141));
                        this.viewGhiChu.jTextArea.setOpaque(true);
                        this.viewGhiChu.jTextArea.setForeground(Color.black);
                        this.viewGhiChu.jLabelHienThiKichCoFontChu.setForeground(Color.black);
                } else if (luaChon.equals("Tối")) {
                        this.viewGhiChu.jPanelTextField.setBackground(new Color(27, 26, 34));
                        this.viewGhiChu.jPanelTextField.setOpaque(true);
                        this.viewGhiChu.jPanelTextField.setForeground(Color.white);

                        this.viewGhiChu.jPanelButton.setBackground(new Color(27, 26, 34));
                        this.viewGhiChu.jPanelButton.setOpaque(true);
                        this.viewGhiChu.jPanelButton.setForeground(Color.white);

                        this.viewGhiChu.jTextArea.setBackground(new Color(27, 26, 34));
                        this.viewGhiChu.jTextArea.setOpaque(true);
                        this.viewGhiChu.jTextArea.setForeground(Color.white);
                        this.viewGhiChu.jLabelHienThiKichCoFontChu.setForeground(Color.white);
                }
        }
}
