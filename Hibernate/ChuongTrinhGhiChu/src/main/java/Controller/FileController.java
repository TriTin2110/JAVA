package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.hibernate.Session;

import HibernateUtil.HibernateUtil;
import View.ViewGhiChu;
import model.modelFile;
import model.modelGhiChu;
import model.modelTaiKhoan;

public class FileController {
	modelFile modelFileDangChon;

	public String luuFile(modelGhiChu modelGhiChu, ViewGhiChu viewGhiChu) {
		File duongDanNguon = new File("");
		Path duongDan = Paths
				.get(duongDanNguon.getAbsolutePath() + "\\File\\" + modelGhiChu.getTaiKhoan().getTaiKhoan());
		System.out.println(duongDan);
		//Tạo thư mục chứa file
		if (!Files.exists(duongDan)) {
			try {
				Files.createDirectories(duongDan);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		String path = duongDan + "\\" + modelGhiChu.getId() + ".txt";
		File file = new File(path);
		
		//Tạo file
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(viewGhiChu, "Không thể tạo file", "Lỗi", 0);
			}
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(viewGhiChu.textAreaNoiDung.getText());
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(viewGhiChu, "Lưu file không thành công!");
			return null;
		}
		JOptionPane.showMessageDialog(viewGhiChu, "Lưu file thành công!");
		viewGhiChu.lblTrangThai.setText("Trạng thái: Đã lưu");
		return path;
	}

	public void luuFileVaoDB(String path, modelGhiChu modelGhiChu, modelTaiKhoan modelTaiKhoan) {
//		Lưu thông tin của file vào trong db
//		nội dung của file vẫn sẽ tồn tại trong db kể cả khi file đã bị xóa
		modelFile modelFile = new modelFile();
		if(modelFile.getTrangThai() == null)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			modelFile.setDuongDan(path);
			modelFile.setTrangThai("Còn tồn tại");
			modelFile.setNgayTao(new Date(System.currentTimeMillis()));
			modelFile.setNgayXoa(null);
			modelFile.setNgayKhoiPhuc(null);
			modelFile.setModelGhiChu(modelGhiChu);
			modelFile.setModelTaiKhoan(modelTaiKhoan);
			session.beginTransaction();
			session.save(modelFile);
			session.getTransaction().commit();
			session.close();
			
		}
		

	}

	// Khi người dùng di chuyển file thì chương trình sẽ gặp lỗi
	public void docFile(modelGhiChu modelGhiChu, ViewGhiChu viewGhiChu, modelTaiKhoan modelTaiKhoanDangTruyCap) {
		JFileChooser jFileChooser = new JFileChooser();
		int result = jFileChooser.showOpenDialog(viewGhiChu);
		if (result == JFileChooser.APPROVE_OPTION) {
			String path = jFileChooser.getSelectedFile().getAbsolutePath();
			File file = new File(path);

//			Không cho phép đọc file nếu ko phải là chủ sở hữu của file đó
			layFileDangChon(file);

			if (!kiemTraChuSoHuuFile(file, modelTaiKhoanDangTruyCap, viewGhiChu) || this.modelFileDangChon == null) {
				JOptionPane.showMessageDialog(viewGhiChu, "Bạn không có quyền đọc file này!");
			} else {
				String noiDung = null;
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					while (true) {
						noiDung = (String) ois.readObject();
						if (noiDung == null)
							break;
					}
					ois.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				viewGhiChu.textAreaNoiDung.setText(noiDung);
				modelGhiChu.setChayLanDau(false);
			}
		}
	}

	public void luaChonXoaFile(ViewGhiChu viewGhiChu, modelGhiChu modelGhiChu, modelTaiKhoan modelTaiKhoanDangTruyCap) {
		JFileChooser jFileChooser = new JFileChooser();
		int result = jFileChooser.showOpenDialog(viewGhiChu);
		if (result == JFileChooser.APPROVE_OPTION) {
			File fileDuocChon = jFileChooser.getSelectedFile();
			// Đặt fileDangChon thông qua phương thức layFileDangChon(fileDuocChon)
			layFileDangChon(fileDuocChon);
			// Nếu trong danh sách file có fle có cùng đường dẫn thì modelFile = file trong
			// danh sách
			result = JOptionPane.showConfirmDialog(viewGhiChu,
					"Bạn có chắc là muốn xóa file/folder" + fileDuocChon.getName() + " không?");
			if (result == JOptionPane.OK_OPTION) {
				// kiểm tra chủ sở hữu của file
				if (kiemTraChuSoHuuFile(fileDuocChon, modelTaiKhoanDangTruyCap, viewGhiChu))
					xoaFileVaCapNhatTrangThai(fileDuocChon, viewGhiChu, modelGhiChu);
				else {
					JOptionPane.showMessageDialog(viewGhiChu, "Bạn không có quyền xóa file này!", "Lỗi!!!", 0);
				}
			}
		}
	}

	public void xoaFileVaCapNhatTrangThai(File fileDuocChon, ViewGhiChu viewGhiChu, modelGhiChu modelGhiChu) {
		xoaFile(fileDuocChon);
		viewGhiChu.textAreaNoiDung.setText("");
		viewGhiChu.textFieldTieuDe.setText("");
//		Sử dụng HQL để cập nhật ngày xóa 
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("update modelFile set ngayXoa = :ngayXoa, trangThai = :trangThai where id_GhiChu = :id");
		query.setParameter("ngayXoa", new Date(System.currentTimeMillis()));
		query.setParameter("id", modelGhiChu.getId());
		query.setParameter("trangThai", "Đã xóa");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		JOptionPane.showMessageDialog(viewGhiChu, "Đã xóa file/folder " + fileDuocChon.getName() + " thành công!");
	}

	public void xoaFile(File file) {
		try {
			if (file.isDirectory()) {
				for (File f : file.listFiles()) {
					xoaFile(f);
				}
			} else {
				file.delete();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void layFileDangChon(File file) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from modelFile");
		List<modelFile> list = query.getResultList();
		for (modelFile modelFile : list) {
			if (modelFile.getDuongDan().equals(file.getAbsolutePath()))
				this.modelFileDangChon = modelFile;
		}
	}

	// Chỉ có chủ sở hữu file mới được phép xóa file
//	từ taiKhoan trong modelFile so vs taiKhoan trong modelTaiKhoan
//	nếu taiKhoan trong modelFile khác vs taiKhoan trong modelTaiKhoan ko cho phép xóa
	public boolean kiemTraChuSoHuuFile(File file, modelTaiKhoan modelTaiKhoanDangTruyCap, ViewGhiChu viewGhiChu) {
		// lấy modelfile
		// từ modelFile lấy tài khoản sở hữu file
		// so sánh tài khoản sở hữu file vs tài khoản hiện tại
		modelTaiKhoan modelTaiKhoanSoHuu = layTaiKhoanSoHuuFile(viewGhiChu);
		if (modelTaiKhoanSoHuu == null)
			return false;
		else {
			if (modelTaiKhoanDangTruyCap.getTaiKhoan().equals(layTaiKhoanSoHuuFile(viewGhiChu).getTaiKhoan())) {
				return true;
			}
		}
		return false;
	}

	// Trả về tài khoản là chủ sở hữu của file
	public modelTaiKhoan layTaiKhoanSoHuuFile(ViewGhiChu viewGhiChu) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from modelTaiKhoan");
		List<modelTaiKhoan> list = query.getResultList();

		out: for (modelTaiKhoan modelTaiKhoan : list) {
			if (modelFileDangChon == null) {
				JOptionPane.showMessageDialog(viewGhiChu, "File/Folder này nằm ngoài phạm vi truy cập!", "Lỗi!!", 0);
				break out;
			} else if (modelTaiKhoan.getTaiKhoan().equals(modelFileDangChon.getModelTaiKhoan().getTaiKhoan()))
				return modelTaiKhoan;
		}
		return null;
	}

}
