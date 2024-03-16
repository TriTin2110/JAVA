package File;

class kiemTraDuLieuNhapVao<T> {
	T duLieuNhapVao;

	public kiemTraDuLieuNhapVao(T duLieuNhapVao) {
		this.duLieuNhapVao = duLieuNhapVao;
	}

	boolean kiemTraDuLieu() {
		if (this.duLieuNhapVao == (String) this.duLieuNhapVao) {
			return false;
		} else if ((Integer) this.duLieuNhapVao == 0 || (Float) this.duLieuNhapVao == 0) {
			return false;
		} else {
			return true;
		}
	}

}
