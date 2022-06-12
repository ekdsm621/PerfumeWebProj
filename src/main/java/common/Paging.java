package common;

import java.util.HashMap;
import java.util.Map;

public class Paging {
	public static Map<String,Integer> getPaging(int totalProd, String pageStr, String pageGroupStr) {
		Map<String,Integer> paging = new HashMap<>();
		int prodPerPage = 8; // 페이지당 상품수
		int pagePerGroup = 5;// 그룹당 페이지수
		int maxPage = totalProd / prodPerPage + 1;
		int maxPageGroup = maxPage / pagePerGroup + 1;
		
		// 현재페이지, 현재페이지그룹 받아와서 정수형으로
		int page = 1;
		int pageGroup = 1;
		
		if(pageStr != null) {
			page = Integer.parseInt(pageStr);
			pageGroup = (page - 1) / pagePerGroup + 1;
		}
		if(pageGroupStr != null) {
			pageGroup = Integer.parseInt(pageGroupStr);
			page = (pageGroup - 1) * pagePerGroup + 1;
		}
		
		int firstProdOfPage = (page - 1) * prodPerPage + 1; // 해당 페이지의 첫 상품 번호
		int endProdOfPage = page * prodPerPage;		// 해당 페이지의 마지막 상품 번호
		
		int firstPageOfGroup = ((page - 1) / pagePerGroup) * pagePerGroup + 1; // 해당 그룹의 첫 번째 페이지 번호
		int endPageOfGroup = pageGroup * pagePerGroup;
		if(endPageOfGroup > maxPage) {
			endPageOfGroup = maxPage;
		}
		
		int prevPage = page - 1;
		if(page == 1) {
			prevPage = 1;
		}
		int nextPage = page + 1;
		if(page == maxPage) {
			nextPage = maxPage;
		}
		int prevPageGroup = pageGroup - 1;
		if(pageGroup == 1) {
			prevPageGroup = 1;
		}
		int nextPageGroup = pageGroup + 1;
		if(pageGroup == maxPageGroup) {
			nextPageGroup = maxPageGroup;
		}
		
		paging.put("prodPerPage", prodPerPage);
		paging.put("pagePerGroup", pagePerGroup);
		paging.put("page", page);
		paging.put("pageGroup", pageGroup);
		paging.put("firstProdOfPage", firstProdOfPage);
		paging.put("endProdOfPage", endProdOfPage);
		paging.put("firstPageOfGroup", firstPageOfGroup);
		paging.put("endPageOfGroup", endPageOfGroup);
		paging.put("prevPage", prevPage);
		paging.put("nextPage", nextPage);
		paging.put("prevPageGroup", prevPageGroup);
		paging.put("nextPageGroup", nextPageGroup);
		paging.put("maxPage", maxPage);
		
		return paging;
		
	}
}
