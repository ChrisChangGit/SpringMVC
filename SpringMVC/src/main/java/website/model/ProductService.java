package website.model;

import java.util.Map;

import org.json.JSONObject;

public interface ProductService {
	
	public abstract Map<String, Object> queryProduct(Map<String, Object> object);
	
	public abstract Map<String, Object> queryProductById(int id);
	
	public abstract int getProductCount();
	
	public abstract boolean editProduct(Map<String, Object> object);
	
	public abstract boolean deleteProduct(int id);}
