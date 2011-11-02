/**
 * 
 */
package dao;

import domain.*;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author namvt
 *
 */
public class ProductDAO extends HibernateDaoSupport implements IDAO<Products>{
	
	public ProductDAO() throws Exception {
    }
	
	public List<Products> getAll() throws Exception {
        List<Products> list = null;
        try {
            list = getHibernateTemplate().find("from Products");
            return list;
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }

    }

    public Products getById(int id) throws Exception {
        Products u = new Products();
        try {
        	List<Products> list = null;
        	list = getHibernateTemplate().find("from Products where id='"+id+"'");
        	u = list.get(0);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
        return u;
    }

    public void addNew(Products entity) throws Exception {
        try {
            getHibernateTemplate().save(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void update(Products entity) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdate(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void delete(Products entity) throws Exception {

        try {
            getHibernateTemplate().delete(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }
}
