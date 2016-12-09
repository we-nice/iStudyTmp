package com.nice.istudy.service;

import java.util.List;

import com.nice.istudy.entity.File;

public interface FileDao {
	public boolean addFile(File file) ; 
    
    
    public boolean deleteFile(int id) ;
    
  // public boolean  updateFile(File  File)  ;
   
  
   public List<File> selectAllFiles();
   
   public List<File> selectFileByCollegeId(int collegeId);
 
   public List<File> selectFileBySubjectId(int subjectId);
   
   public List<File> selectFileByName(String name);
}
