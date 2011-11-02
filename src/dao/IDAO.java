package dao;

import java.util.List;

public interface IDAO <T>{
	public List<T> getAll() throws Exception;
	public T getById(int id) throws Exception;
	public void addNew(T entity) throws Exception;
	public void update(T entity) throws Exception;
	public void delete(T entity) throws Exception;
}
