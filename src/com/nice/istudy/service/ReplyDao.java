package com.nice.istudy.service;


import java.util.List;

import com.nice.istudy.entity.Reply;
 




public interface  ReplyDao {

 
	 public boolean addReply(Reply  reply) ; 
	    
      
     public boolean deleteReply(int id) ;
      
 
     public List<Reply> selectAllReplys();
     
     public Reply selectReplyById(int id);
    
     public List<Reply> selectReplyByProblemId(int problemId);
}