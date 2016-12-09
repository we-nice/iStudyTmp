package com.nice.istudy.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nice.istudy.entity.UserType;
import com.nice.istudy.utils.DBHelper;

public class UserTypeDaoImpl {

	public boolean addUserType(UserType userType) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = (Connection) DBHelper.getConnection();
			String sql = "insert into userType (name,modifyUser) values (?,?) ";
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);
			preparedStatement.setString(1, userType.getName());
			preparedStatement.setInt(2, userType.getModifyUser());
			int i = preparedStatement.executeUpdate();
			if (i == 0) {
				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

		return true;
	}

	public boolean deleteUserType(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = (Connection) DBHelper.getConnection();
			String sql = "delete from userType where id= ? ";
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

	public boolean updateUserType(UserType userType) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = (Connection) DBHelper.getConnection();

			String sql = "update userType set name=?,modifyUser=? where id=?";
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);
			preparedStatement.setString(1, userType.getName());
			preparedStatement.setInt(2, userType.getModifyUser());
			preparedStatement.setInt(3, userType.getId());
			int i = preparedStatement.executeUpdate();
			if (i <= 0) {
				return false;
			}

		} catch (SQLException e) {
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

	public List<UserType> SelectAllUserType() {
		List<UserType> userTypeList = new ArrayList<UserType>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = (Connection) DBHelper.getConnection();
			String sql = "select * from userType";
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet.next());
			while (resultSet.next()) {
				UserType userType = new UserType();
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int modifyUser = resultSet.getInt(3);

				userType.setId(id);
				userType.setName(name);
				userType.setModifyUser(modifyUser);
				// System.out.println(userType.toString());
				userTypeList.add(userType);

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
		return userTypeList;
	}

	public UserType selectUserTypeById(int id) {
		UserType userType = new UserType();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = (Connection) DBHelper.getConnection();
			String sql = "select * from userType where id=?";
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);

			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				String name = resultSet.getString(2);
				int modifyUser = resultSet.getInt(3);

				userType.setId(id);
				userType.setName(name);
				userType.setModifyUser(modifyUser);

			} else
				return null;
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

		return userType;

	}

}
