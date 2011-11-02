package bol;
import java.util.List;
import domain.Producttype;

public interface IProductTypeBO {
	public List<Producttype> getAll() throws Exception;
	public Producttype getById(int id) throws Exception;
	public void addNew(Producttype entity) throws Exception;
	public void update(Producttype entity) throws Exception;
	public void delete(Producttype entity) throws Exception;
}
