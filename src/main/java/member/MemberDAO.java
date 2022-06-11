package member;

import common.DBConnPool;

public class MemberDAO extends DBConnPool{
	
	private final String insertMem = "INSERT INTO MEMBER VALUES((SELECT NVL(MAX(MEMBER_CODE),0)+1 FROM MEMBER), ?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String confirmId = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID = ?";
	private final String getMem = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW=?";
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

	public MemberDTO getMember(MemberDTO dto) {
		// id pw일치하면 user 돌려줌
		MemberDTO user = null;
		try {
			pstmt = conn.prepareStatement(getMem);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new MemberDTO();
				user.setId(rs.getString("member_id"));
				user.setPw(rs.getString("member_pw"));
				user.setName(rs.getString("member_name"));
				user.setBirth(rs.getString("member_birth"));
				user.setGender(rs.getString("member_gender"));
				user.setPhone(rs.getString("member_phone"));
				user.setPhone_agree(rs.getInt("member_phone_agree"));
				user.setEmail(rs.getString("member_email"));
				user.setEmail_agree(rs.getInt("member_email_agree"));
				user.setAddress(rs.getString("member_address"));
				user.setGrade(rs.getInt("member_grade"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
}
