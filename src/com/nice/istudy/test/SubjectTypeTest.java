package com.nice.istudy.test;

import java.util.List;

import com.nice.istudy.entity.SubjectType;
import com.nice.istudy.service.SubjectTypeDao;
import com.nice.istudy.service.impl.SubjectTypeDaoImpl;



public class SubjectTypeTest {
	
	SubjectTypeDao subjectTypeDao = new SubjectTypeDaoImpl();
	
	public void addBookType(){
		SubjectType subjectType=new SubjectType();
        
    	subjectType.setName("admin");
    	subjectType.setModifyUser(666);
    	   
    	System.out.println(subjectTypeDao.addSubjectType(subjectType));
	}
	
	public void deleteBookType(){
		System.out.println(subjectTypeDao.deleteSubjectType(1));
	}
	
	public void updateBookType(){
		SubjectType subjectType=new SubjectType();
        subjectType.setId(1);
    	subjectType.setName("admin1");
    	subjectType.setModifyUser(888);
    	System.out.println(subjectTypeDao.updateSubjectType(subjectType));
	}
	
	public void selectAllBookType(){
		List<SubjectType> list =subjectTypeDao.selectAllSubjectType();
		
		System.out.println(list.size());
		
		for(SubjectType b:list){
			System.out.println(b.toString());
		}	
	}
	
	public void selectBookTypeById(){
		SubjectType subjectType = subjectTypeDao.selectSubjectTypeById(2);
		System.out.println(subjectType);
	}
	
	public static void main(String[] args) {
		SubjectTypeTest subjectTypeTest=new SubjectTypeTest();
	//	subjectTypeTest.addBookType();
	//	subjectTypeTest.deleteBookType();
	//	subjectTypeTest.updateBookType();
	//	subjectTypeTest.selectAllBookType();
		subjectTypeTest.selectBookTypeById();
	}
}
