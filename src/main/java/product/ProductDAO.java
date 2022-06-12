package product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.DBConnPool;
import common.Paging;

public class ProductDAO extends DBConnPool{
	private final String getNewProd = "SELECT * FROM PRODUCT WHERE PRODUCT_NEW = 1";
	private final String getBestProd = "SELECT * FROM PRODUCT WHERE PRODUCT_BEST = 1";
	private final String getCateProd = "SELECT * FROM (SELECT ROWNUM RNUM, P.* FROM PRODUCT P WHERE PRODUCT_CATE = ?) WHERE RNUM BETWEEN ? AND ?";
	private final String totalCateProd = "SELECT COUNT(*) FROM PRODUCT WHERE PRODUCT_CATE = ?";
	
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
	
	public int totalCateProducts(String maincate, String subcate) {
		int totalProd = 0;
		try {
			pstmt = conn.prepareStatement(totalCateProd);
			pstmt.setString(1, maincate);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalProd = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return totalProd;
	}
	
	public List<ProductDTO> getCateProducts(String maincate, String subcate, String page, String pagegroup) {
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		// 페이지네이션 -> 첫 상품과 끝 상품을 가져옴
		int totalProd = totalCateProducts(maincate, subcate);
		Map<String,Integer> paging = Paging.getPaging(totalProd, page, pagegroup);
		int firstProdOfPage = paging.get("firstProdOfPage");
		int endProdOfPage = paging.get("endProdOfPage");
		try {
			pstmt = conn.prepareStatement(getCateProd);
			pstmt.setString(1, maincate);
			pstmt.setInt(2, firstProdOfPage);
			pstmt.setInt(3, endProdOfPage);
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
