package bol;

import java.util.List;

import domain.*;
import dao.*;

public class UserBO implements IUserBO{

    private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
    public boolean checkLogin(Users entity) {
        return userDAO.checkLogin(entity);
    }

    public List<Users> getAll() throws Exception {
        List<Users> l = null;
        try {
            l = userDAO.getAll();
            return l;
        } catch (Exception e) {
            throw new Exception("Display error: " + e.getMessage());
        } 
    }

    public Users getById(int id) throws Exception {
        Users u = new Users();
        try {
            u = userDAO.getById(id);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
        return u;
    }

    public void addNew(Users entity) throws Exception {
        try {
            userDAO.addNew(entity);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
    }

    public void update(Users entity) throws Exception {
        try {
            userDAO.update(entity);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
    }

    public void delete(Users entity) throws Exception {
        try {
            userDAO.delete(entity);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
    }
}
