package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.DBClose;
import db.DBConnection;
import dto.AccountBookDto;

public class AccontBookDao {

private static AccontBookDao abd = null;
	
	private AccontBookDao() {

	}
	
	public static AccontBookDao getInstance() {
		if(abd == null) {
			abd = new AccontBookDao();
		}
		return abd;
	}
	
	public boolean insert(AccountBookDto dto) {
		String sql = " insert into accountbook(date, money, title, memo, classify) "
				+ "		values('" + dto.getDate() + "'," 
									    + dto.getMoney() + ",'"
									    + dto.getTitle() + "','"
									    + dto.getMemo() + "','"
									    + dto.getClassify() + "')";
		
		Connection conn = null;
		Statement stmt =null;
		
		int count = 0;
		
		
		try {
			conn = DBConnection.getConnection();
			
			stmt = conn.createStatement();
			
			count = stmt.executeUpdate(sql);
			
			System.out.println("정상처리되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, stmt, null);
		}
		return count > 0;
	}
	
	public boolean delete(int seq) {
		String sql = " delete from accountbook "
				+ " 	where seq = " + seq + "";
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
		int count = 0;
		
		try {
			stmt = conn.createStatement();  
			
		    count =	stmt.executeUpdate(sql);  
		    
		    System.out.println("정상적으로 처리되었습니다");
		    
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally {
			
			DBClose.close(conn, stmt, null);
		}
		return count > 0;
	}
	
	public boolean update(int seq, AccountBookDto updatedDto) {
        String sql = "update accountbook set "
                + "date = '" + updatedDto.getDate() + "', "
                + "money = " + updatedDto.getMoney() + ", "
                + "title = '" + updatedDto.getTitle() + "', "
                + "memo = '" + updatedDto.getMemo() + "', "
                + "classify = '" + updatedDto.getClassify() + "' "
                + "where seq = " + seq;

        Connection conn = null;
        Statement stmt = null;
        
        int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			
			stmt = conn.createStatement();
			
			count = stmt.executeUpdate(sql);
			
			System.out.println("정상 처리되었습니다");
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, null);
		}
		
		return count>0;
	}
	
	
	public List<AccountBookDto> dateSelect(String date) {
		String sql = " select * from accountbook where date like '" + date + "%'";
        List<AccountBookDto> list = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                AccountBookDto dto = new AccountBookDto();
                dto.setDate(rs.getString("date"));
                dto.setMoney(rs.getInt("money"));
                dto.setTitle(rs.getString("title"));
                dto.setMemo(rs.getString("memo"));
                dto.setClassify(rs.getString("classify"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, stmt, rs);
        }

        return list;
    }
		
	 public List<AccountBookDto> titleSelect(String title) {
		        String sql = " select * from accountbook where title like '%" + title + "%'";
		        List<AccountBookDto> list = new ArrayList<>();

		        Connection conn = null;
		        Statement stmt = null;
		        ResultSet rs = null;

		        try {
		            conn = DBConnection.getConnection();
		            stmt = conn.createStatement();
		            rs = stmt.executeQuery(sql);

		            while (rs.next()) {
		                AccountBookDto dto = new AccountBookDto();
		                dto.setDate(rs.getString("date"));
		                dto.setMoney(rs.getInt("money"));
		                dto.setTitle(rs.getString("title"));
		                dto.setMemo(rs.getString("memo"));
		                dto.setClassify(rs.getString("classify"));
		                list.add(dto);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            DBClose.close(conn, stmt, rs);
		        }

		        return list;
		    }
		
	 public List<AccountBookDto> memoSelect(String memo) {
	        String sql = " select * from accountbook where memo like '%" + memo + "%'";
	        List<AccountBookDto> list = new ArrayList<>();

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = DBConnection.getConnection();
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                AccountBookDto dto = new AccountBookDto();
	                dto.setDate(rs.getString("date"));
	                dto.setMoney(rs.getInt("money"));
	                dto.setTitle(rs.getString("title"));
	                dto.setMemo(rs.getString("memo"));
	                dto.setClassify(rs.getString("classify"));
	                list.add(dto);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBClose.close(conn, stmt, rs);
	        }

	        return list;
	    }
	
	 public List<AccountBookDto> periodSelect(String startDate, String endDate, String transaction) {
	        String sql = " select * from accountbook where date between '" + startDate + "' and '" + endDate + "' and classify = '" + transaction + "'";
	        List<AccountBookDto> list = new ArrayList<>();

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = DBConnection.getConnection();
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                AccountBookDto dto = new AccountBookDto();
	                dto.setDate(rs.getString("date"));
	                dto.setMoney(rs.getInt("money"));
	                dto.setTitle(rs.getString("title"));
	                dto.setMemo(rs.getString("memo"));
	                dto.setClassify(rs.getString("classify"));
	                list.add(dto);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBClose.close(conn, stmt, rs);
	        }

	        return list;
	    }

	   public List<AccountBookDto> monthBalance(String yearMonth) {
	        String sql = " select substring(date, 1, 5) as month, "
	                + "sum(case when classify = '수입' then money else -money end) as balance "
	                + "from accountbook "
	                + "where substring(date, 1, 5) = '" + yearMonth + "' "
	                + "group by substring(date, 1, 5)";

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        List<AccountBookDto> list = new ArrayList<>();

	        try {
	            conn = DBConnection.getConnection();
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                AccountBookDto dto = new AccountBookDto();
	                dto.setDate(rs.getString("month"));
	                dto.setMoney(rs.getInt("balance")); 
	                list.add(dto);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            DBClose.close(conn, stmt, rs);
	        }

	        return list;
	    }
	   
	   public int[] totalMoney() {
		    int[] result = new int[2]; // 수입은 인덱스 0, 지출은 인덱스 1

		    String sql = "select sum(case when classify = '수입' then money else 0 end) as inc, " +
		                 "             sum(case when classify = '지출' then money else 0 end) as exp " +
		                 "from accountbook";

		    try (Connection conn = DBConnection.getConnection();
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(sql)) {

		        if (rs.next()) {
		            result[0] = rs.getInt("inc");
		            result[1] = rs.getInt("exp");
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return result;
		}
	   
	}
	 

	 
	 

		

	


