package com.nice.istudy.service;

import java.util.List;

import com.nice.istudy.entity.ProblemType;

public interface ProblemTypeDao {
	
	public boolean addProblemType(ProblemType problemType);
	
	public boolean deleteProblemType(int id);
	
	public boolean updateProblemType(ProblemType problemType);
	
	public List<ProblemType> SelectAllProblemType();
	
	public ProblemType selectProblemTypeById(int id);
	
}
