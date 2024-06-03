package productegTest;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class ProductServiceTest {
	Map<String, ProductTest> products = new HashMap();
	
	public ProductServiceTest() {
		ProductTest p = new ProductTest("101", "딥러닝", "신구문화사", 2000, "2022.4.2");
		products.put("101" , p);
		p = new ProductTest("102", "텐서플로", "ai출판사", 1999, "2022.4.2");
		products.put("102", p);
		p = new ProductTest("103", "빅데이터", "사이언스", 2222, "2022.4.2");
		products.put("103", p);
	
		
	}
	
	public List<ProductTest> findAll() {
		return new ArrayList<>(products.values());
	}

	public ProductTest findById(String id) {
		return products.get(id);
	}
}	
