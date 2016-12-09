package com.nice.istudy.test;

import java.util.List;


import com.nice.istudy.entity.CollegeType;

import com.nice.istudy.service.CollegeTypeDao;

import com.nice.istudy.service.impl.CollegeTypeDaoImpl;

public class CollegeTypeTest {
	CollegeTypeDao collegeTypeDao = new CollegeTypeDaoImpl();
	
	public void addCollegeType(){
		CollegeType collegeType=new CollegeType();
        
    	collegeType.setName("admin");
    	collegeType.setModifyUser(666);
    	   
    	System.out.println(collegeTypeDao.addCollegeType(collegeType));
	}
	
	public void deleteCollegeType(){
		System.out.println(collegeTypeDao.deleteCollegeType(1));
	}
	
	public void updateCollegeType(){
		CollegeType collegeType=new CollegeType();
        collegeType.setId(1);
    	collegeType.setName("admin1");
    	collegeType.setModifyUser(888);
    	collegeType.setFather(1);
    	System.out.println(collegeTypeDao.updateCollegeType(collegeType));
	}
	
	public void selectAllCollegeType(){
		List<CollegeType> list =collegeTypeDao.selectAllCollegeType();
		
		System.out.println(list.size());
		
		for(CollegeType b:list){
			System.out.println(b.toString());
		}	
	}
	
	public void selectCollegeTypeById(){
		CollegeType bookType = collegeTypeDao.selectCollegeTypeById(2);
		System.out.println(bookType);
	}
	
	public static void main(String[] args) {
		CollegeTypeTest bookTypeTest=new CollegeTypeTest();
	//	bookTypeTest.addCollegeType();
	//	bookTypeTest.deleteCollegeType();
	//	bookTypeTest.updateCollegeType();
	//	bookTypeTest.selectAllCollegeType();
		bookTypeTest.selectCollegeTypeById();
	}
}
