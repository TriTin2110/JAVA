package BaiTapQuanLySinhVien;

interface Functional<T> {
	public void addPerson(T t);

	public void deletePerson(T t);

	public void updatePerson(T t);

	public void printList();

	public T findingPerson(T t);
}
