package com.nice.istudy.action;



import com.nice.istudy.entity.User;
import com.nice.istudy.service.UserDao;
import com.nice.istudy.service.impl.UserDaoImpl;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends SuperAction implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	User user = new User();
	
	
	
	public String login(){
		UserDao udao =new UserDaoImpl();
		
		if(udao.userLogin(user)){
		//	session.setAttribute("loginUserName", user.getUsername());
		//	request.setAttribute("loginUserName", user.getUsername());
			System.out.println(user.getStudentNo());
			return "login_success";
		}else return "login_failure";
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
	
	
}
