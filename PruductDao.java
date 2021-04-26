package productcrudapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;
import productcrudapp.model.Product;

@Component
public class PruductDao {
	
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	//create
	@Transactional
	public void createProduct(Product product) {
		
		this.hibernateTemplate.save(product);
		
	}
	//get all products
	
	public List getProducts()
	{
		List products = (List) this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	@Transactional
	public void deleteProduct(int pid)
	{
	Product p =	this.hibernateTemplate.load(Product.class, pid);
	this.hibernateTemplate.delete(p);
	}
	
	// get the single product
	
	public Product getProduct(int pid)
	{
		return this.hibernateTemplate.get(Product.class, pid);
	}
}
