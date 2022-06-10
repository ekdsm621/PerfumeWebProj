package member;

import common.DBConnPool;

public class MemberDAO extends DBConnPool{
	
	private final String insertMem = "INSERT INTO MEMBER VALUES(mem_seq.nextval, ?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String confirmId = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID = ?";
	public void insertMember(MemberDTO dto) {
		try {
			pstmt = conn.prepareStatement(insertMem);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirth());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.getPhone());
			pstmt.setInt(7, dto.getPhone_agree());
			pstmt.setString(8, dto.getEmail());
			pstmt.setInt(9, dto.getEmail_agree());
			pstmt.setString(10, dto.getPost());
			pstmt.setString(11, dto.getAddress());
			pstmt.setInt(12, 4);
			pstmt.executeUpdate();
			System.out.println("회원 등록이 완료되었습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int confirmID(String id) {
		
		int check = 0;
		try {
			pstmt = conn.prepareStatement(confirmId);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = 1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}
	
}
