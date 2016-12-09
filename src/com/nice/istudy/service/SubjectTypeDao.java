package com.nice.istudy.service;

import java.util.List;

import com.nice.istudy.entity.SubjectType;

public interface SubjectTypeDao {
	
	public boolean addSubjectType(SubjectType subjectType);
	
	public boolean deleteSubjectType(int id);
	
	public boolean updateSubjectType(SubjectType subjectType);
	
	public List<SubjectType> selectAllSubjectType();
	
	public SubjectType selectSubjectTypeById(int id);
	
}
