package com.nice.istudy.service;


import java.util.List;

import com.nice.istudy.entity.Problem;




public interface  ProblemDao {

 
	 public boolean addProblem(Problem  problem) ; 
	    
      
     public boolean deleteProblem(int id) ;
      
 
     public List<Problem> selectAllProblems();
     
     public Problem selectProblemById(int id);
    
     public List<Problem> selectProblemByProblemTypeId(int problemTypeId);
}