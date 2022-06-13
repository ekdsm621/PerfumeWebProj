package category;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import common.DBConnPool;

public class CategoryDAO extends DBConnPool{
	
	private final String getAllCate = "select s.cate_name sub_name from main_category m inner join sub_category s on m.cate_id = s.main_cate_id where m.cate_name = ?";
	private final String getMainCate = "select cate_name from main_category";
	
	public Map<String, List<String>> getAllCategory() {
		Map<String, List<String>> allCate = new LinkedHashMap<>();
		List<String> mainCates = new ArrayList<>();
		List<String> subCates = null;
		try {
			// ���� ī�װ� �̸��� ����
			pstmt = conn.prepareStatement(getMainCate);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mainCates.add(rs.getNString(1));
			}
			
			// ���� ī�װ� �̸��� List�� ���� -> key=����ī�װ�, value=����ī�װ�list
			for(int i=0; i<mainCates.size(); i++) {
				subCates = new ArrayList<>();
				pstmt = conn.prepareStatement(getAllCate);
				pstmt.setString(1, mainCates.get(i));
				rs = pstmt.executeQuery();
				// ����ī�װ� ����Ʈ ����
				while(rs.next()) {
					subCates.add(rs.getString(1));
				}
				// Map�� ����
				allCate.put(mainCates.get(i), subCates);
				subCates = null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return allCate;
	}
	
}
