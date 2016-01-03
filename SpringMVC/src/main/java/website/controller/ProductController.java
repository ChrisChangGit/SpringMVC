package website.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import website.dao.ProductDAO;
import website.model.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController extends BaseController{
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public ModelAndView productList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("product/productList");
	}
	
	@RequestMapping(value = "/productListTable", method = RequestMethod.GET)
	public ModelAndView productListTable(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestMap = convertRequerstToMap(request);
		if(requestMap.get("page") == null) {
			requestMap.put("page", "1");
		}
		
		if(requestMap.get("rows") == null) {
			requestMap.put("rows", "10");
		}
		
		if(requestMap.get("sidx") == null) {
			requestMap.put("sidx", "PRODUCT_ID");
		}
		
		if(requestMap.get("sord") == null) {
			requestMap.put("sord", "asc");
		}
		
		Map<String, Object> result = productService.queryProduct(requestMap);
		return new ModelAndView("product/productListTable", result);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, Object> requestMap = convertRequerstToMap(request);
		Map<String, Object> result = productService.queryProduct(requestMap);
		JSONObject jsonObject = new JSONObject(result);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonObject);
	}
}
