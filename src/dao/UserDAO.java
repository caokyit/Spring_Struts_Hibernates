package dao;

import java.util.List;
import domain.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDAO extends HibernateDaoSupport implements IDAO<Users> {

    public UserDAO() throws Exception {
    }

    public boolean checkLogin(Users entity) {
        boolean flag = false;
        try {
            List<Users> l = null;
            String queryString = "from Users where username='" + entity.getUsername() + "'"
                    + "and password='" + entity.getPassword() + "'";

            l = getHibernateTemplate().find(queryString);
            if (l != null) {
                if (l.size() > 0) {
                    flag = true;
                }
            }
        } catch (Exception ex) {
            ex.toString();
            flag = false;
        }
        return flag;
    }

    public List<Users> getAll() throws Exception {
        List<Users> list = null;
        try {
            list = getHibernateTemplate().find("from Users");
            return list;
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public Users getById(int id) throws Exception {
        Users u = new Users();
        try {
        	List<Users> list = null;
        	list = getHibernateTemplate().find("from Users where id='"+id+"'");
        	u = list.get(0);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
        return u;
    }

    public void addNew(Users entity) throws Exception {
        try {
            getHibernateTemplate().save(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void update(Users entity) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdate(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void delete(Users entity) throws Exception {

        try {
            getHibernateTemplate().delete(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }
}
