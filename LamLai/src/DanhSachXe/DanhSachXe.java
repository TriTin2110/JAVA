package DanhSachXe;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class DanhSachXe {
	LinkedList<Xe> ds = new LinkedList<Xe>();

	public DanhSachXe() {
	}

	void themXe(Xe x) {
		boolean check = false;
		for (Xe xe : ds) {
			if (xe.getMaXe().compareTo(x.getMaXe()) == 0) {
				check = true;
			}
		}
		if (check) {
			System.out.println("Mã xe nhập vào trùng nhau!");
		} else {
			ds.add(x);
		}
	}

	void tinhThue() {

		ds.stream().forEach(xe -> {
			if (xe.getDungTich() <= 100) {
				xe.setGiaThue((xe.getGiaXe() * 1) / 100);
			} else if (xe.getDungTich() <= 200) {
				xe.setGiaThue((xe.getGiaXe() * 3) / 100);
			} else {
				xe.setGiaThue((xe.getGiaXe() * 5) / 100);
			}
		});
	}

	void inThue() {
		ds.forEach(xe -> {
			System.out.println(xe.getGiaThue());
		});
	}

	void tinhTienXeSauThue() {
		ds.forEach(xe -> {
			xe.setGiaXe(xe.getGiaXe() + xe.getGiaThue());
		});
	}

	void inThongTinXe() {
		sapXepTheoMaSo();
		ds.forEach(xe -> {
			System.out.println(xe);
		});
	}

	void sapXepTheoMaSo() {
		Collections.sort(ds, new Comparator<Xe>() {

			@Override
			public int compare(Xe o1, Xe o2) {
				// TODO Auto-generated method stub
				if (o1.getMaXe().compareTo(o2.getMaXe()) == 1) {
					return 1;
				} else if (o1.getMaXe().compareTo(o2.getMaXe()) == -1) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}
}
