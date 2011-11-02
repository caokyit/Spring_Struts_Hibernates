package dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import domain.*;

import java.util.List;

public class ProductTypeDAO extends HibernateDaoSupport implements IDAO<Producttype> {
	public ProductTypeDAO(){
		
	}
	
	public List<Producttype> getAll() throws Exception {
        List<Producttype> list = null;
        try {
            list = getHibernateTemplate().find("from Producttype");
            return list;
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }

    }

    public Producttype getById(int id) throws Exception {
        Producttype u = new Producttype();
        try {
        	List<Producttype> list = null;
        	list = getHibernateTemplate().find("from Producttype where id='"+id+"'");
        	u = list.get(0);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
        return u;
    }

    public void addNew(Producttype entity) throws Exception {
        try {
            getHibernateTemplate().save(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void update(Producttype entity) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdate(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void delete(Producttype entity) throws Exception {

        try {
            getHibernateTemplate().delete(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }
}
