package bol;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;
import dao.ProductTypeDAO;
import domain.Producttype;


public class ProductTypeBO extends HibernateDaoSupport implements IProductTypeBO{
	private ProductTypeDAO ProductTypeDAO;

	public ProductTypeDAO getProductTypeDAO() {
		return ProductTypeDAO;
	}

	public void setProductTypeDAO(ProductTypeDAO ProductTypeDAO) {
		this.ProductTypeDAO = ProductTypeDAO;
	}
	
	public List<Producttype> getAll() throws Exception {
        List<Producttype> l = null;
        try {
            l = ProductTypeDAO.getAll();
            return l;
        } catch (Exception e) {
            throw new Exception("Display error: " + e.getMessage());
        } 
    }

    public Producttype getById(int id) throws Exception {
        Producttype u = new Producttype();
        try {
            u = ProductTypeDAO.getById(id);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
        return u;
    }

    public void addNew(Producttype entity) throws Exception {
        try {
            ProductTypeDAO.addNew(entity);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
    }

    public void update(Producttype entity) throws Exception {
        try {
            ProductTypeDAO.update(entity);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
    }

    public void delete(Producttype entity) throws Exception {
        try {
            ProductTypeDAO.delete(entity);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
    }
}
