package website.dao;

import java.util.List;
import java.util.Map;

public interface ProductDAO {
	public abstract List<Map<String, Object>> getAll();

	public abstract List<Map<String, Object>> queryProductByPage(Map<String, Object> obejct);

	public abstract int getProductCount();
}
