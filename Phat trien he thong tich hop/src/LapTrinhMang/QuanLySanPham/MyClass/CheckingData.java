package LapTrinhMang.QuanLySanPham.MyClass;

import LapTrinhMang.QuanLySanPham.Implement.MainImplement;
import LapTrinhMang.QuanLySanPham.Interface.MainInterface;
import LapTrinhMang.QuanLySanPham.Model.ModelCompany;
import LapTrinhMang.QuanLySanPham.Model.ModelProduct;

public class CheckingData {
	public static boolean checkingPrimary(Object object) {
		if (object instanceof ModelCompany) {
			ModelCompany modelCompany = (ModelCompany) object;
			MainInterface mainInterface = new MainImplement();
			if (mainInterface.searching(modelCompany) == null)
				return true;
		} else {
			ModelProduct modelProduct = (ModelProduct) object;
			MainInterface mainInterface = new MainImplement();
			if (mainInterface.searching(modelProduct) == null)
				return true;
		}

		return false;
	}
}
