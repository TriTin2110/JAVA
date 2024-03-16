package vn.nguyentritin.Employee.test;

import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;

import vn.nguyentritin.Employee.HibernateUtil.HibernateUtil;
import vn.nguyentritin.Employee.pojo.Department;
import vn.nguyentritin.Employee.pojo.EmployeeModel;

public class test {
	static Scanner sc = new Scanner(System.in);
	static boolean kiemTra = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int luaChon = 0;
		do {
			try {
				System.out.println("Hãy nhập lựa chọn của bạn: ");
				System.out.println("1. Thêm nhân viên");
				System.out.println("2. Liệt kê danh sách nhân viên");
				System.out.println("3. Tìm nhân viên theo mã số");
				System.out.println("4. Chỉnh sửa thông tin nhân viên");
				System.out.println("5. Xóa nhân viên");
				System.out.println("0. Thoát");
				System.out.print("==> ");
				luaChon = sc.nextInt();
				kiemTra = true;
			} catch (Exception e) {
				// TODO: handle exception
				kiemTra = false;
				System.out.println("Lỗi nhập liệu");
			}
			sc.nextLine();
			xuLyLuaChon(luaChon);
			System.out.println("\n");
		} while (luaChon != 0 || !kiemTra);

	}

	public static void xuLyLuaChon(int luaChon) {
		switch (luaChon) {
		case 1: {
			String ten = "";
			int ngaySinh = 0;
			int thangSinh = 0;
			int namSinh = 0;
			int luong = 0;
			int maPhongBan = 0;
			do {
				try {
					System.out.println("Hãy nhập tên nhân viên: ");
					ten = sc.nextLine();
					System.out.println("Hãy nhập ngày sinh: ");
					ngaySinh = sc.nextInt();
					System.out.println("Hãy nhập tháng sinh: ");
					thangSinh = sc.nextInt();
					System.out.println("Hãy nhập năm sinh: ");
					namSinh = sc.nextInt();
					System.out.println("Hãy nhập mức lương của nhân viên: ");
					luong = sc.nextInt();
					System.out.println("Hãy nhập mã phòng ban của nhân viên: ");
					maPhongBan = sc.nextInt();
					kiemTra = true;
				} catch (Exception e) {
					// TODO: handle exception
					kiemTra = false;
					System.out.println("Lỗi nhập liệu!");
				}
				sc.nextLine();
			} while (!kiemTra);

			Date date = new Date(namSinh - 1900, thangSinh - 1, ngaySinh);
			EmployeeModel employeeModel = new EmployeeModel(ten, date, luong);
			themNhanVien(employeeModel, maPhongBan);
			break;
		}

		case 2: {
			lietKeDanhSachNhanVien();
			break;
		}

		case 3: {
			System.out.println("hãy nhập mã nhân viên: ");
			int id = sc.nextInt();
			EmployeeModel employeeModel = new EmployeeModel(id);
			xuatNhanVienTheoMa(employeeModel);
			break;
		}

		case 4: {
			EmployeeModel employeeModel = null;
			int id = 0;
			do {
				try {
					System.out.println("Hãy nhập mã nhân viên: ");
					id = sc.nextInt();
					employeeModel = new EmployeeModel(id);
					kiemTra = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lỗi nhập liệu!");
					kiemTra = false;
				}
				sc.nextLine();
			} while (!kiemTra);
			if (timKiemNhanVien(employeeModel)) {
				String ten = "";
				int ngaySinh = 0;
				int thangSinh = 0;
				int namSinh = 0;
				int luong = 0;
				do {
					try {
						System.out.println("Hãy nhập tên nhân viên: ");
						ten = sc.nextLine();
						System.out.println("Hãy nhập ngày sinh: ");
						ngaySinh = sc.nextInt();
						System.out.println("Hãy nhập tháng sinh: ");
						thangSinh = sc.nextInt();
						System.out.println("Hãy nhập năm sinh: ");
						namSinh = sc.nextInt();
						System.out.println("Hãy nhập mức lương của nhân viên: ");
						luong = sc.nextInt();
						kiemTra = true;
					} catch (Exception e) {
						// TODO: handle exception
						kiemTra = false;
						System.out.println("Lỗi nhập liệu!");
					}
					sc.nextLine();
				} while (!kiemTra);

				Date date = new Date(namSinh - 1900, thangSinh - 1, ngaySinh);
				employeeModel = new EmployeeModel(ten, date, luong);
				chinhSuaThongTinNhanVien(employeeModel, id);
			}

			break;
		}
		case 5: {
			EmployeeModel employeeModel = null;
			do {
				try {
					System.out.println("Hãy nhập mã nhân viên: ");
					int id = sc.nextInt();
					employeeModel = new EmployeeModel(id);
					kiemTra = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lỗi nhập liệu!");
					kiemTra = false;
				}
				sc.nextLine();
			} while (!kiemTra);
			if (timKiemNhanVien(employeeModel)) {
				System.out.println("Hãy nhập mã nhân viên: ");
				xoaNhanVien(employeeModel);
			}
			break;
		}
		}
	}

	public static void themNhanVien(EmployeeModel employeeModel, int maPhongBan) {
		Session session = createSession();
		Department department = session.get(Department.class, maPhongBan);
		employeeModel.setPhongBan(department);
		try {
			session.save(employeeModel);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Phòng ban không tồn tại trong danh sách!");
		} finally {
			session.close();
		}
	}

	public static void xoaNhanVien(EmployeeModel employeeModel) {
		Session session = createSession();
		session.getTransaction().begin();
		// Lấy dữ liệu của nhân viên có mã là ??
		employeeModel = session.get(EmployeeModel.class, employeeModel.getId());
		// Xóa nhân viên
		session.delete(employeeModel);
		session.getTransaction().commit();
		session.close();
	}

	public static void lietKeDanhSachNhanVien() {
		Session session = createSession();
		Query query = session.createQuery("From EmployeeModel");
		List<EmployeeModel> list = query.getResultList();

		list.forEach(nv -> {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String ngaySinh = simpleDateFormat.format(nv.getNgaySinh());
			System.out.println(
					nv.getId() + " " + nv.getTenNhanVien() + " " + ngaySinh + " " + formatNumber(nv.getLuong()));
		});
		session.close();
	}

	public static void chinhSuaThongTinNhanVien(EmployeeModel employeeModel, int id) {
		Session session = createSession();
		session.getTransaction().begin();
		// Cập nhật đối tượng mới thông qua đối tượng truyền vào
		EmployeeModel employeeModelUpdate = session.get(EmployeeModel.class, id);
		employeeModelUpdate.setTenNhanVien(employeeModel.getTenNhanVien());
		employeeModelUpdate.setNgaySinh(employeeModel.getNgaySinh());
		employeeModelUpdate.setLuong(employeeModel.getLuong());
		session.save(employeeModelUpdate);
		session.getTransaction().commit();
		session.close();
	}

	public static void xuatNhanVienTheoMa(EmployeeModel employeeModel) {
		if (timKiemNhanVien(employeeModel)) {
			Session session = createSession();
			employeeModel = session.get(EmployeeModel.class, employeeModel.getId());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String ngaySinh = simpleDateFormat.format(employeeModel.getNgaySinh());
			System.out.println(employeeModel.getId() + " " + employeeModel.getTenNhanVien() + " " + ngaySinh + " "
					+ formatNumber(employeeModel.getLuong()));
		}
	}

	public static boolean timKiemNhanVien(EmployeeModel employeeModel) {
		Session session = createSession();
		employeeModel = session.get(EmployeeModel.class, employeeModel.getId());
		if (employeeModel == null) {
			System.out.println("Đối tượng không tồn tại trong danh sách!");
			return false;
		}
		session.close();
		return true;
	}

	public static Session createSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}

	public static String formatNumber(int number) {
		Locale locale = new Locale("vi", "vn");
		NumberFormat numf = NumberFormat.getInstance(locale);
		return numf.format(number) + "đ";
	}
}
