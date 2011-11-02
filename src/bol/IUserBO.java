package bol;

import java.util.List;
import domain.Users;

public interface IUserBO {
	public boolean checkLogin(Users entity);
	public List<Users> getAll() throws Exception;
	public Users getById(int id) throws Exception;
	public void addNew(Users entity) throws Exception;
	public void update(Users entity) throws Exception;
	public void delete(Users entity) throws Exception;
}