package website.model.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import website.dao.ProductDAO;
import website.model.ProductService;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public Map<String, Object> queryProduct(Map<String, Object> param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int page = Integer.parseInt((String) param.get("page"));
		int rows = Integer.parseInt((String) param.get("rows"));
		int count = this.getProductCount();
		
		List<Map<String, Object>> result = productDAO.queryProductByPage(param);
		resultMap.put("rows", result);
		resultMap.put("total", (int) Math.ceil((double)count / (double)rows));
		resultMap.put("records", count);
		resultMap.put("page", page);
				
		return resultMap;
	}

	@Override
	public Map<String, Object> queryProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getProductCount() {
		return productDAO.getProductCount();
	}
	
	@Override
	public boolean editProduct(Map<String, Object> object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
