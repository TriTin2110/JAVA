package vn.nguyentritin.Employee.test;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;

import vn.nguyentritin.Employee.HibernateUtil.HibernateUtil;
import vn.nguyentritin.Employee.pojo.Department;
import vn.nguyentritin.Employee.pojo.EmployeeModel;

public class testPhongBan {
	static Scanner sc = new Scanner(System.in);
	static boolean check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int luaChon = 0;
		do {
			try {
				System.out.println("Hãy nhập lựa chọn của bạn: ");
				System.out.println("1. Thêm phòng ban");
				System.out.println("2. Liệt kê danh sách phòng ban");
				System.out.println("3. Chỉnh sửa phòng ban");
				System.out.println("4. Hiển thị số lượng và nhân viên của phòng ban");
				System.out.println("5. Xóa phòng ban");
				System.out.print("==> ");
				luaChon = sc.nextInt();
				check = true;
			} catch (Exception e) {
				System.out.println("Lỗi nhập liệu!");
				check = false;
			}
			sc.nextLine();
			xuLyLuaChon(luaChon);
		} while (luaChon != 0 || !check);
	}

	public static void xuLyLuaChon(int luaChon) {
		switch (luaChon) {
		case 1: {
			String tenPhongBan = "";
			String moTaPhongBan = "";
			System.out.println("Hãy nhập tên phòng ban: ");
			tenPhongBan = sc.nextLine();
			System.out.println("Hãy nhập mô tả phòng ban: ");
			moTaPhongBan = sc.nextLine();

			Department department = new Department(tenPhongBan, moTaPhongBan);
			taoPhongBan(department);
			break;
		}

		case 2: {
			lietKeDanhSachPhongBan();
			break;
		}

		case 3: {
			int maPhongBan = 0;
			do {
				try {
					System.out.println("Nhập mã phòng ban: ");
					maPhongBan = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lỗi nhập liệu!");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			Department department = new Department(maPhongBan);
			if (timKiemPhongBan(department)) {
				String tenPhongBan = "", moTaPhongBan = "";
				System.out.println("Hãy nhập tên phòng ban: ");
				tenPhongBan = sc.nextLine();
				System.out.println("Hãy nhập mô tả phòng ban: ");
				moTaPhongBan = sc.nextLine();
				department = new Department(tenPhongBan, moTaPhongBan);
				capNhatPhongBan(department, maPhongBan);
			}

			break;
		}

		case 4: {
			int maPhongBan = 0;
			do {
				try {
					System.out.println("Nhập mã phòng ban: ");
					maPhongBan = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lỗi nhập liệu!");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			Department department = new Department(maPhongBan);
			if (timKiemPhongBan(department)) {
				hienThiNhanVien(department);
			}

			break;
		}

		case 5: {
			int maPhongBan = 0;
			do {
				try {
					System.out.println("Nhập mã phòng ban: ");
					maPhongBan = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lỗi nhập liệu!");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			Department department = new Department(maPhongBan);
			if (timKiemPhongBan(department)) {
				xoaPhongBan(department);
			}

			break;
		}
		}
	}

	public static void taoPhongBan(Department department) {
		Session session = taoSession();
		session.save(department);
		session.close();
	}

	public static void lietKeDanhSachPhongBan() {
		Session session = taoSession();
		Query query = session.createQuery("from Department");
		List<Department> list = query.getResultList();
		list.forEach(
				li -> System.out.println(li.getMaPhongBan() + " " + li.getTenPhongBan() + " " + li.getMoTaPhongBan()));
		session.close();
	}

	public static void capNhatPhongBan(Department department, int maPhongBan) {
		Session session = taoSession();
		String tenPhongBan = department.getTenPhongBan();
		String moTaPhongBan = department.getMoTaPhongBan();
		department = session.get(Department.class, maPhongBan);
		department.setTenPhongBan(tenPhongBan);
		department.setMoTaPhongBan(moTaPhongBan);
		session.getTransaction().begin();
		session.save(department);
		session.getTransaction().commit();
		session.close();
	}

	public static void hienThiNhanVien(Department department) {
		Session session = taoSession();
		department = session.get(Department.class, department.getMaPhongBan());
		Set<EmployeeModel> list = department.getListEmployee();
		list.forEach(li -> System.out.println(
				li.getId() + " " + li.getTenNhanVien() + " " + li.getNgaySinh() + " " + formatNumber(li.getLuong())));
		System.out.println("Số lượng nhân viên trong " + department.getTenPhongBan() + " là: " + list.size());
	}

	public static void xoaPhongBan(Department department) {
		Session session = taoSession();
		session.getTransaction().begin();
		department = session.get(Department.class, department.getMaPhongBan());
		session.delete(department);
		session.getTransaction().commit();
		session.close();
	}

	public static boolean timKiemPhongBan(Department department) {
		Session session = taoSession();
		department = session.get(Department.class, department.getMaPhongBan());
		if (department == null) {
			System.out.println("Phòng ban không tồn tại trong danh sách!");
			return false;
		}
		session.close();
		return true;
	}

	public static Session taoSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session;
	}

	public static String formatNumber(int number) {
		Locale locale = new Locale("vi", "vn");
		NumberFormat numf = NumberFormat.getInstance(locale);
		return numf.format(number) + "đ";
	}
}
