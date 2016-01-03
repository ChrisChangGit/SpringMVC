package website.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import website.dao.ProductDAO;

@Service(value = "productDAO")
public class ProdcutDAOImpl implements ProductDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String SELECT_ALL = "SELECT PRODUCT_ID AS 'ID', PRODUCT_NAME AS 'Name' FROM PRODUCT";
	private static final String SELECT_PRODUCT_BY_PAGE = "SELECT PRODUCT_ID AS 'id', PRODUCT_NAME AS 'name' FROM (SELECT ROW_NUMBER() OVER(ORDER BY %s %s) AS 'ROW_NO',* FROM PRODUCT) AS P WHERE ROW_NO BETWEEN ? AND ?";
	private static final String SELECT_PRODUCT_COUNT = "SELECT COUNT(*) COUNT FROM PRODUCT";
	
	@Override
	public List<Map<String, Object>> getAll() {
		return jdbcTemplate.queryForList(SELECT_ALL);
	}
	
	@Override
	public List<Map<String, Object>> queryProductByPage(Map<String, Object> param) {
		
		String query = String.format(SELECT_PRODUCT_BY_PAGE, param.get("sidx").toString(), param.get("sord").toString());
		
    	int page = Integer.parseInt((String) param.get("page"));
    	int rows = Integer.parseInt((String) param.get("rows"));
    	
    	List<Object> condition = new ArrayList<Object>();
    	condition.add(((page - 1) * rows) + 1);
    	condition.add(page * rows);
 
		return jdbcTemplate.queryForList(query, condition.toArray());
	}
	
	@Override
	public int getProductCount() {
    	List<Map<String, Object>> result = jdbcTemplate.queryForList(SELECT_PRODUCT_COUNT);
    	
    	return (int)result.get(0).get("COUNT");
	}
	
}
