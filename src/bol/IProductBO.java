package bol;

import java.util.List;
import domain.Products;

public interface IProductBO {
	public List<Products> getAll() throws Exception;
	public Products getById(int id) throws Exception;
	public void addNew(Products entity) throws Exception;
	public void update(Products entity) throws Exception;
	public void delete(Products entity) throws Exception;
}
