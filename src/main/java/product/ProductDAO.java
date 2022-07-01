package product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.DBConnPool;
import common.Paging;

public class ProductDAO extends DBConnPool{
	private final String getNewProd = "SELECT * FROM PRODUCT WHERE PRODUCT_NEW = 1";
	private final String getBestProd = "SELECT * FROM PRODUCT WHERE PRODUCT_BEST = 1";
	private final String getCateProd = "SELECT * FROM (SELECT ROWNUM RNUM, P.* FROM PRODUCT P WHERE PRODUCT_CATE = LOWER(?)) WHERE RNUM BETWEEN ? AND ?";
	private final String totalCateProd = "SELECT COUNT(*) FROM PRODUCT WHERE PRODUCT_CATE = LOWER(?)";
	private final String getProdDetail = "SELECT P.PRODUCT_ID ID, P.PRODUCT_NAME NAME ,P.PRODUCT_PRICE PRICE, D.PRODUCT_SUB_IMG_F IMG_F, D.PRODUCT_SUB_IMG_S IMG_S, D.PRODUCT_SUB_IMG_T IMG_T, D.PRODUCT_DETAIL_IMG DETAIL FROM PRODUCT P INNER JOIN PRODUCT_DETAIL D ON P.PRODUCT_ID = D.PRODUCT_ID WHERE P.PRODUCT_ID = ?";
	private final String getCartItem = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";
	private final String insertProd = "INSERT INTO PRODUCT "
			+ "VALUES((SELECT NVL(MAX(PRODUCT_ID), 0) + 1 FROM PRODUCT), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String insertProdDetail = "INSERT INTO PRODUCT_DETAIL(PRODUCT_ID,PRODUCT_SUB_IMG_F,PRODUCT_SUB_IMG_S,PRODUCT_SUB_IMG_T,PRODUCT_DETAIL_IMG)"
			+" VALUES((SELECT NVL(MAX(PRODUCT_ID), 0) FROM PRODUCT), ?, ?, ?, ?)";
	private final String getProductList = "SELECT * FROM PRODUCT";
	private final String deleteProduct = "DELETE PRODUCT WHERE PRODUCT_ID=?";

	
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
	
	public ProductDTO getProdDetail(int id) {
		ProductDTO dto = null;
		try {
			pstmt = conn.prepareStatement(getProdDetail);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setSub_img_f(rs.getNString("img_f"));
				dto.setSub_img_s(rs.getNString("img_s"));
				dto.setSub_img_t(rs.getNString("img_t"));
				dto.setDetail_img(rs.getString("detail"));
			}
			System.out.println(dto.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public ProductDTO getCartItem(String id) {
		ProductDTO dto = null;
		try {
			pstmt = conn.prepareStatement(getCartItem);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new ProductDTO();
				dto.setId(rs.getInt("product_id"));
				dto.setName(rs.getString("product_name"));
				dto.setPrice(rs.getInt("product_price"));
				dto.setMain_img(rs.getString("product_main_img"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public void insertProduct(ProductDTO dto) {
		try {
			pstmt = conn.prepareStatement(insertProd);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBrand());
			pstmt.setString(3, dto.getCate());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setString(5, dto.getMain_img());
			pstmt.setString(6, "");
			pstmt.setString(7, "");
			pstmt.setString(8, "");
			pstmt.setInt(9, dto.getProd_new());
			pstmt.setInt(10, dto.getProd_best());
			pstmt.executeQuery();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertProductDetail(ProductDTO dto) {
		try {
			pstmt = conn.prepareStatement(insertProdDetail);
			pstmt.setString(1, dto.getSub_img_f());
			pstmt.setString(2, dto.getSub_img_s());
			pstmt.setString(3, dto.getSub_img_t());
			pstmt.setString(4, dto.getDetail_img());
			pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<ProductDTO> getProductList() {
		List<ProductDTO> products = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(getProductList);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setId(rs.getInt("product_id"));
				product.setName(rs.getString("product_name"));
				product.setBrand(rs.getString("product_brand"));
				product.setCate(rs.getString("product_cate"));
				product.setPrice(rs.getInt("product_price"));
				product.setProd_new(rs.getInt("product_new"));
				product.setProd_best(rs.getInt("product_best"));
				products.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return products;
		
	}
	public void deleteProduct(String id) {
		try {
			pstmt = conn.prepareStatement(deleteProduct);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
