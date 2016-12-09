package com.nice.istudy.test;

import java.util.List;

import com.nice.istudy.entity.ProblemType;
import com.nice.istudy.service.ProblemTypeDao;
import com.nice.istudy.service.impl.ProblemTypeDaoImpl;



public class ProblemTypeTest {
	
	ProblemTypeDao problemTypeDao = new ProblemTypeDaoImpl();
	
	public void addproblemType(){
		ProblemType problemType=new ProblemType();
        
    	problemType.setName("admin");
    	problemType.setModifyUser(666);
    	   
    	System.out.println(problemTypeDao.addProblemType(problemType));
	}
	
	public void deleteproblemType(){
		System.out.println(problemTypeDao.deleteProblemType(1));
	}
	
	public void updateproblemType(){
		ProblemType problemType=new ProblemType();
        problemType.setId(1);
    	problemType.setName("admin1");
    	problemType.setModifyUser(888);
    	System.out.println(problemTypeDao.updateProblemType(problemType));
	}
	
	public void selectAllproblemType(){
		List<ProblemType> list =problemTypeDao.SelectAllProblemType();
		
		System.out.println(list.size());
		
		for(ProblemType b:list){
			System.out.println(b.toString());
		}	
	}
	
	public void selectproblemTypeById(){
		ProblemType problemType = problemTypeDao.selectProblemTypeById(1);
		System.out.println(problemType.toString());
	}
	
	public static void main(String[] args) {
		ProblemTypeTest problemTypeTest=new ProblemTypeTest();
	//	problemTypeTest.addproblemType();
	//	problemTypeTest.deleteproblemType();
	//	problemTypeTest.updateproblemType();
	//	problemTypeTest.selectAllproblemType();
		problemTypeTest.selectproblemTypeById();
	}
}
