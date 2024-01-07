package Bai3.database;

import java.util.ArrayList;

public interface databaseAccess<T> {
	public int insert(T t);

	public int delete(T t);

	public int update(T t);

	public ArrayList<T> selectAll();

	public T selectByID(T t);
}
