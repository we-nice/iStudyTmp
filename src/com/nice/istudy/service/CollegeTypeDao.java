package com.nice.istudy.service;

import java.util.List;

import com.nice.istudy.entity.CollegeType;

public interface CollegeTypeDao {
	
	public boolean addCollegeType(CollegeType collegeType);
	
	public boolean deleteCollegeType(int id);
	
	public boolean updateCollegeType(CollegeType collegeType);
	
	public List<CollegeType> selectAllCollegeType();
	
	public CollegeType selectCollegeTypeById(int id);
	
}
