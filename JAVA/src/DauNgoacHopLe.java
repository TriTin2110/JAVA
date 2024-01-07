class DauNgoacHopLe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chuoiBanDau = "([]{})";
		GiaTriNgoac ngoacTronMo = GiaTriNgoac.ngoacTronMo;
		GiaTriNgoac ngoacTronDong = GiaTriNgoac.ngoacTronDong;
		GiaTriNgoac ngoacVuongMo = GiaTriNgoac.ngoacVuongMo;
		GiaTriNgoac ngoacVuongDong = GiaTriNgoac.ngoacVuongDong;
		GiaTriNgoac ngoacNhonMo = GiaTriNgoac.ngoacNhonMo;
		GiaTriNgoac ngoacNhonDong = GiaTriNgoac.ngoacNhonDong;
		char[] chuoi = chuoiBanDau.toCharArray();
		boolean check = true;
		for (int i = 0; i < chuoiBanDau.length(); i++) {
			if (chuoiBanDau.charAt(i) == '(') {
				if (chuoiBanDau.charAt(i + 1) == ')') {
					ngoacTronMo.setGiaTri(ngoacTronMo.getGiaTri() + 1);
					ngoacTronDong.setGiaTri(ngoacTronDong.getGiaTri() + 1);
					i++;
				} else {
					ngoacTronMo.setGiaTri(ngoacTronDong.getGiaTri() + 1);
				}
			} else if (chuoiBanDau.charAt(i) == '[') {
				if (chuoiBanDau.charAt(i + 1) == ']') {
					ngoacVuongMo.setGiaTri(ngoacVuongMo.getGiaTri() + 1);
					ngoacVuongDong.setGiaTri(ngoacVuongDong.getGiaTri() + 1);
					i++;
				} else {
					ngoacVuongMo.setGiaTri(ngoacVuongDong.getGiaTri() + 1);
				}
			} else if (chuoiBanDau.charAt(i) == '{') {
				if (chuoiBanDau.charAt(i + 1) == '}') {
					ngoacNhonMo.setGiaTri(ngoacNhonMo.getGiaTri() + 1);
					ngoacNhonDong.setGiaTri(ngoacNhonDong.getGiaTri() + 1);
					i++;
				} else {
					ngoacNhonMo.setGiaTri(ngoacNhonDong.getGiaTri() + 1);
				}
			} else {
				switch (chuoiBanDau.charAt(i)) {
				case '}':
					ngoacNhonDong.setGiaTri(ngoacNhonDong.getGiaTri() + 1);
					break;

				case ')':
					ngoacTronDong.setGiaTri(ngoacTronDong.getGiaTri() + 1);
					break;
				case ']':
					ngoacVuongDong.setGiaTri(ngoacVuongDong.getGiaTri() + 1);
					break;
				}
			}
		}
		if (ngoacNhonDong.getGiaTri() == ngoacNhonMo.getGiaTri() && ngoacTronMo.getGiaTri() == ngoacTronDong.getGiaTri()
				&& ngoacVuongDong.getGiaTri() == ngoacVuongMo.getGiaTri() && check == true) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

}
