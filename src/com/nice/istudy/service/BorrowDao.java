package com.nice.istudy.service;

import com.nice.istudy.entity.Borrow;

public interface BorrowDao {
	
	public boolean addBorrow(Borrow borrow);
	
	public boolean deleteBorrow(Borrow borrow);
	
	public boolean updateBorrow(Borrow borrow);
	
}
