package cn.bd.impdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bd.dao.BM;
import cn.bd.dao.BaseDao;
import cn.bd.entity.BookManage;

public class BookManageDao extends BaseDao implements BM{

	public List<BookManage> searchAll() {
		List<BookManage> list=new ArrayList<BookManage>();
		
		String sql="select * from BookManage";
		Object [] parm={};
		ResultSet rs=executeQuery(sql, parm);
		try {
			while(rs.next()){
				BookManage b=new BookManage();
				b.setB_id(rs.getInt(1));
				b.setB_name(rs.getString(2));
				b.setB_author(rs.getString(3));
				b.setB_time(rs.getDate(4));
				b.setB_bype(rs.getInt(5));
				list.add(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int addBook(BookManage b) {
		int result=0;
		String sql="insert BookManage values (?,?,?,?) ";
		Object [] parm={b.getB_name(),b.getB_author(),b.getB_time(),b.getB_bype()};
		result=executeUpdate(sql, parm);
		return result;
	}

	public int deleteBook(int id) {
		int result=0;
		String sql="delete BookManage where b_id=? ";
		Object [] parm={id};
		result=executeUpdate(sql, parm);
		return result;
	}

}
