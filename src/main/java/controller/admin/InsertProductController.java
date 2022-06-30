package controller.admin;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.ProductDAO;
import product.ProductDTO;

@WebServlet("/insertProduct.do")
public class InsertProductController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDTO dto = new ProductDTO();
		ProductDAO dao = new ProductDAO();
		
		String saveDirectory = "C:/Users/82109/eclipse-workspace/PerfumeWebProj/src/main/webapp/Images/product_img";
		int maxPostSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		System.out.println(saveDirectory);
		try {
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
			String fileName = "";
			Enumeration fileNames = mr.getFileNames();
			
			if(fileNames.hasMoreElements()) {
				// main
				String parameter = (String) fileNames.nextElement();
				fileName = mr.getOriginalFileName(parameter);
				if(fileName != null) {
					String fileSrc = "/Images/product_img/"+fileName;
					dto.setMain_img(fileSrc);					
				}
			}
			if(fileNames.hasMoreElements()) {
				// sub_1
				String parameter = (String) fileNames.nextElement();
				fileName = mr.getOriginalFileName(parameter);
				if(fileName != null) {
					String fileSrc = "/Images/product_img/"+fileName;
					dto.setSub_img_f(fileSrc);
				}
			}
			if(fileNames.hasMoreElements()) {
				// sub_2
				String parameter = (String) fileNames.nextElement();
				fileName = mr.getOriginalFileName(parameter);
				if(fileName != null) {
					String fileSrc = "/Images/product_img/"+fileName;
					dto.setSub_img_s(fileSrc);
				}
			}
			if(fileNames.hasMoreElements()) {
				// sub_3
				String parameter = (String) fileNames.nextElement();
				fileName = mr.getOriginalFileName(parameter);
				if(fileName != null) {
					String fileSrc = "/Images/product_img/"+fileName;
					dto.setSub_img_t(fileSrc);
				}
			}
			if(fileNames.hasMoreElements()) {
				// detail
				String parameter = (String) fileNames.nextElement();
				fileName = mr.getOriginalFileName(parameter);
				if(fileName != null) {
					String fileSrc = "/Images/product_img/"+fileName;
					dto.setDetail_img(fileSrc);
				}
			}

			String product_name = mr.getParameter("product_name");
			String product_brand = mr.getParameter("product_brand");
			String product_cate = mr.getParameter("product_cate");
			String product_price = mr.getParameter("product_price");
			String product_new = mr.getParameter("product_new");
			String product_best = mr.getParameter("product_best");
			
			dto.setName(product_name);
			dto.setBrand(product_brand);
			dto.setCate(product_cate);
			dto.setPrice(Integer.parseInt(product_price));
			if(product_new == null||product_new.equals("")) {
				dto.setProd_new(0);
			}else {
				dto.setProd_new(Integer.parseInt(product_new));				
			}
			if(product_best == null||product_best.equals("")) {
				dto.setProd_best(0);
			}else {
				dto.setProd_best(Integer.parseInt(product_best));				
			}
			dao.insertProduct(dto);
			dao = new ProductDAO();
			dao.insertProductDetail(dto);
			System.out.println("업로드 성공");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("업로드 실패");
		}
		
	
	}
}
