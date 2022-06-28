package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import category.CategoryDAO;
public class CategoryViewFilter extends HttpFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		// 네비게이션 카테고리 던지기
				CategoryDAO cateDao = new CategoryDAO();
				Map<String, List<String>> allCate = cateDao.getAllCategory();
				request.setAttribute("allCate", allCate);
		chain.doFilter(request, response);
	}
}
