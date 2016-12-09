package com.nice.istudy.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nice.istudy.entity.User;
import com.nice.istudy.service.UserDao;
import com.nice.istudy.utils.DBHelper;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean userLogin(User u) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "select * from user where studentNo = ? and password = ?"; // SQL
																					// 语句
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getStudentNo());
			stmt.setString(2, u.getPassword());
			rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e) {
					e.printStackTrace();

				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();

				}
			}

		}
	}

	@Override
	public boolean loginByStudentNoAndPassword(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "select * from user where studentNo = ? and password = ?"; // SQL
																					// 语句
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getStudentNo());
			stmt.setString(2, user.getPassword());
			// System.out.println(user.getPassword()+user.getStudentNo());
			rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e) {
					e.printStackTrace();

				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();

				}
			}

		}
	}

	@Override
	public boolean addUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "insert into user (studentNo,password,name,nickName,email,college,role,isForbidden,imgsrc) "
					+ "values (?,?,?,?,?,  ?,?,?,?) "; // SQL 语句
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getStudentNo());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getNickName());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, user.getCollege());
			stmt.setInt(7, user.getRole());
			stmt.setInt(8, user.getIsForbidden());

			stmt.setString(9, user.getImgsrc());

			int i = stmt.executeUpdate();
			if (i == 0) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e) {
					e.printStackTrace();

				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();

				}
			}

		}

		return true;
	}

	@Override
	public boolean deleteUser(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) DBHelper.getConnection();
			String sql = "delete from user where id= ? ";
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int i = preparedStatement.executeUpdate();
			if (i == 0) {
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		return true;
	}

	@Override
	public boolean updateUser(User user) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {

			connection = (Connection) DBHelper.getConnection();

			String sql = "update user set studentNo=?,password=?,name=?,nickName=?,email=?,college=?,role=?,isForbidden=?,imgsrc=? where id=? or studentNo=?";
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, user.getStudentNo());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getNickName());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, user.getCollege());
			stmt.setInt(7, user.getRole());
			stmt.setInt(8, user.getIsForbidden());
			stmt.setString(9, user.getImgsrc());
			stmt.setInt(10, user.getId());
			stmt.setString(11, user.getStudentNo());
			int i = stmt.executeUpdate();
			if (i <= 0) {
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return true;
	}

	@Override
	public List<User> selectAllUsers() {

		List<User> userList = new ArrayList<User>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = (Connection) DBHelper.getConnection();
			String sql = "select * from user";
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet.next());
			while (resultSet.next()) {
				User user = new User();
				int id = resultSet.getInt(1);
				String studentNo = resultSet.getString(2);
				String password = resultSet.getString(3);
				String name = resultSet.getString(4);
				String nickName = resultSet.getString(5);
				int role = resultSet.getInt(6);
				String email = resultSet.getString(7);
				String college = resultSet.getString(8);

				int isForbidden = resultSet.getInt(9);
				String imgsrc = resultSet.getString(10);

				user.setId(id);
				user.setStudentNo(studentNo);
				user.setPassword(password);
				user.setName(name);
				user.setNickName(nickName);
				user.setRole(role);
				user.setEmail(email);
				user.setCollege(college);
				user.setIsForbidden(isForbidden);
				user.setImgsrc(imgsrc);

				userList.add(user);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// System.out.println(userTypeList);
		return userList;
	}

	@Override
	public User selectUserById(int id) {
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = (Connection) DBHelper.getConnection();
			String sql = "select * from user  where id=?";
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);

			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				/*
				 * private int id;
				 * 
				 * private String studentNo; private String password; private
				 * String name; private String nickName; private String email;
				 * private String college; private int role; private int
				 * isForbidden; private String imgsrc;
				 */

				String studentNo = resultSet.getString(2);
				String password = resultSet.getString(3);
				String name = resultSet.getString(4);
				String nickName = resultSet.getString(5);
				int role = resultSet.getInt(6);
				String email = resultSet.getString(7);
				String college = resultSet.getString(8);

				int isForbidden = resultSet.getInt(9);
				String imgsrc = resultSet.getString(10);

				user = new User();

				user.setId(id);
				user.setStudentNo(studentNo);
				user.setPassword(password);
				user.setName(name);
				user.setNickName(nickName);
				user.setRole(role);
				user.setEmail(email);
				user.setCollege(college);
				user.setIsForbidden(isForbidden);
				user.setImgsrc(imgsrc);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return user;
	}

	@Override
	public User selectUserByStudentNo(String studentNo) {
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = (Connection) DBHelper.getConnection();
			String sql = "select * from user  where studentNo=?";
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);

			preparedStatement.setString(1, studentNo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				/*
				 * private int id;
				 * 
				 * private String studentNo; private String password; private
				 * String name; private String nickName; private String email;
				 * private String college; private int role; private int
				 * isForbidden; private String imgsrc;
				 */

				int id = resultSet.getInt(1);
				studentNo = resultSet.getString(2);
				String password = resultSet.getString(3);
				String name = resultSet.getString(4);
				String nickName = resultSet.getString(5);
				int role = resultSet.getInt(6);
				String email = resultSet.getString(7);
				String college = resultSet.getString(8);

				int isForbidden = resultSet.getInt(9);
				String imgsrc = resultSet.getString(10);

				user = new User();

				user.setId(id);
				user.setStudentNo(studentNo);
				user.setPassword(password);
				user.setName(name);
				user.setNickName(nickName);
				user.setRole(role);
				user.setEmail(email);
				user.setCollege(college);
				user.setIsForbidden(isForbidden);
				user.setImgsrc(imgsrc);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return user;
	}

}
