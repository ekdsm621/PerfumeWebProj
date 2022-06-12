package common;

import java.util.HashMap;
import java.util.Map;

public class Paging {
	public static Map<String,Integer> getPaging(int totalProd, String pageStr, String pageGroupStr) {
		Map<String,Integer> paging = new HashMap<>();
		int prodPerPage = 8; // �������� ��ǰ��
		int pagePerGroup = 5;// �׷�� ��������
		int maxPage = totalProd / prodPerPage + 1;
		int maxPageGroup = maxPage / pagePerGroup + 1;
		
		// ����������, �����������׷� �޾ƿͼ� ����������
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
		
		int firstProdOfPage = (page - 1) * prodPerPage + 1; // �ش� �������� ù ��ǰ ��ȣ
		int endProdOfPage = page * prodPerPage;		// �ش� �������� ������ ��ǰ ��ȣ
		
		int firstPageOfGroup = ((page - 1) / pagePerGroup) * pagePerGroup + 1; // �ش� �׷��� ù ��° ������ ��ȣ
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
