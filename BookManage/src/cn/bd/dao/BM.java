package cn.bd.dao;

import java.util.List;

import cn.bd.entity.BookManage;

public interface BM {
	List<BookManage> searchAll();
	
	int addBook(BookManage bookManage);
	int deleteBook(int id);

}
