package product;

import java.util.ArrayList;
import java.util.List;

import common.DBConnPool;

public class ProductDAO extends DBConnPool{
	private final String getNewProd = "SELECT * FROM PRODUCT WHERE PRODUCT_NEW = 1";
	private final String getBestProd = "SELECT * FROM PRODUCT WHERE PRODUCT_BEST = 1";
	private final String getCateProd = "SELECT * FROM PRODUCT WHERE PRODUCT_CATE = ?";
	
	public List<ProductDTO> getNewProducts(){
		// 신상품 가져오는 메서드
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		try {
			pstmt = conn.prepareStatement(getNewProd);
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				ProductDTO product = new ProductDTO();
				product.setId(rs.getInt("product_id"));
				product.setName(rs.getString("product_name"));
				product.setBrand(rs.getString("product_brand"));
				product.setCate(rs.getString("product_cate"));
				product.setPrice(rs.getInt("product_price"));
				product.setMain_img(rs.getString("product_main_img"));
				product.setSub_img_f(rs.getString("product_sub_img_f"));
				product.setSub_img_s(rs.getString("product_sub_img_s"));
				product.setSub_img_t(rs.getString("product_sub_img_t"));
				product.setProd_new(rs.getInt("product_new"));
				product.setProd_best(rs.getInt("product_best"));
				System.out.println("객체 하나 가져옴");
				products.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	public List<ProductDTO> getBestProducts(){
		// 베스트상품 가져오는 메서드
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		try {
			pstmt = conn.prepareStatement(getBestProd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setId(rs.getInt("product_id"));
				product.setName(rs.getString("product_name"));
				product.setBrand(rs.getString("product_brand"));
				product.setCate(rs.getString("product_cate"));
				product.setPrice(rs.getInt("product_price"));
				product.setMain_img(rs.getString("product_main_img"));
				product.setSub_img_f(rs.getString("product_sub_img_f"));
				product.setSub_img_s(rs.getString("product_sub_img_s"));
				product.setSub_img_t(rs.getString("product_sub_img_t"));
				product.setProd_new(rs.getInt("product_new"));
				product.setProd_best(rs.getInt("product_best"));
				products.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
