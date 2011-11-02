package bol;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;
import domain.Products;
import dao.ProductDAO;

public class ProductBO extends HibernateDaoSupport implements IProductBO{
	private ProductDAO productDAO;

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public List<Products> getAll() throws Exception {
        List<Products> l = null;
        try {
            l = productDAO.getAll();
            return l;
        } catch (Exception e) {
            throw new Exception("Display error: " + e.getMessage());
        } 
    }

    public Products getById(int id) throws Exception {
        Products u = new Products();
        try {
            u = productDAO.getById(id);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
        return u;
    }

    public void addNew(Products entity) throws Exception {
        try {
            productDAO.addNew(entity);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
    }

    public void update(Products entity) throws Exception {
        try {
            productDAO.update(entity);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
    }

    public void delete(Products entity) throws Exception {
        try {
            productDAO.delete(entity);
        } catch (Exception ex) {
            throw new Exception("Display error: " + ex.getMessage());
        }
    }
}
