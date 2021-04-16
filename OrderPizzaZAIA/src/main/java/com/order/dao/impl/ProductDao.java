package com.order.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.xiangmu.dinner.entity.Product;
import com.order.entity.T_Product;
import com.order.util.DBUtil_pool;



public class ProductDao {
	//��ȡ���ݿ�����
	private static Connection conn = null;
	private PreparedStatement stat = null;
	private ResultSet rs = null;
	//ʵ����
	//��ȡ�û�����,���뵽ʵ����
	public static List<T_Product> GetProductList(){
		//ʵ���༯��
		List<T_Product> listProduct = new ArrayList<T_Product>();
		// 1����ȡ���ݿ�����
		conn = DBUtil_pool.getConnection();
		//2���ݿ�sql���
		String sql = "select * from order_menu";
		//3���ݿ����
		 //a ͨ��׼������һ�����ݿ��������
		PreparedStatement pre = null;
		try {
			//�����Ӷ�������ǵ�׼����������
			pre =  conn.prepareStatement(sql);
			//�������ִ�в�ѯ,�����浽ResultSet�����������
			ResultSet rs  = pre.executeQuery();
			//��������н��������nextΪ���������ݣ���Ҫ����ѭ�����
			while(rs.next()){
				System.out.print(rs.getString(1));
				System.out.print(rs.getString(2));
				System.out.print(rs.getString(3));
				System.out.print(rs.getString(4));
				System.out.print(rs.getString(5));
				System.out.print(rs.getString(6));
				//���浽ʵ������
				T_Product t = new T_Product();
				t.setMenuId(rs.getString(1));
				t.setMenuPhoto(rs.getString(2));
				t.setMenuName(rs.getString(3));
				t.setMenulntroduction(rs.getString(5));
				t.setMenuRetail(rs.getString(4));
				t.setMenuTypeld(rs.getString(6));
				
				listProduct.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProduct;
		
	}
	
	
	//ģ����ѯ
	public List<T_Product> GetProductList(String values){
		
		//�洢��������
		List<T_Product> list = new ArrayList<T_Product>();
		//��ȡ���ݿ�����
		conn = DBUtil_pool.getConnection();
		//SELECT * FROM T_user WHERE password LIKE '%1%'
		
		String sql = "SELECT * FROM order_menu WHERE MenuId LIKE ? OR MenuPhoto LIKE ? OR MenuName LIKE ? OR MenuRetail LIKE ? OR MenuIntroduction LIKE ? \r\n" + 
				"OR  MenuTypeId LIke ?";
		//��ȡ��������
		try {
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, "%"+values+"%");
		pre.setString(2, "%"+values+"%");
		pre.setString(3, "%"+values+"%");
		pre.setString(4, "%"+values+"%");
		pre.setString(5, "%"+values+"%");
		pre.setString(6, "%"+values+"%");
		
		ResultSet rs = pre.executeQuery();
		
		//ֱ��ѭ����ȡ����
		while(rs.next()) {
			//����һ��ʵ���������ֵ
			T_Product t = new T_Product();
			t.setMenuId(rs.getString(1));
			t.setMenuPhoto(rs.getString(2));
			t.setMenuName(rs.getString(3));
			t.setMenuRetail(rs.getString(4));
			t.setMenulntroduction(rs.getString(5));
			t.setMenuTypeld(rs.getString(6));
			
			list.add(t);
		}
		
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	//�޸�
	public boolean UserUpdateById(String MenuId,String MenuPhoto,String MenuName,String MenuRetail,String MenuIntroduction,String MenuTypeId) {
		//��ȡ����
		conn = DBUtil_pool.getConnection();
				//����sql���
				String sql = "update order_menu set MenuTypeId='"+MenuTypeId+"',MenuPhoto='"+MenuPhoto+"',MenuName='"+MenuName+"',MenuRetail='"+MenuRetail+"',MenuIntroduction='"+MenuIntroduction+"' "+"where MenuId=?";
				
				try {
					PreparedStatement pre = conn.prepareStatement(sql);
					pre.setString(1, MenuId);
									
					int i = pre.executeUpdate();
//					pre.close();
//					conn.close();
					if(i>0) {
						return true;
					}
					
				}catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return false;
	}
	
	
	//ͨ��pid������Ʒ��Ϣ����
	public boolean addUserByid(String MenuId,String MenuPhoto,String MenuName,String MenuRetail,String MenuIntroduction,String MenuTypeId){
		//��ȡ����
		conn = DBUtil_pool.getConnection();
		
		String sql = "insert into order_menu (MenuId,MenuPhoto,MenuName,MenuRetail,MenuIntroduction,MenuTypeId) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, MenuId);
			pre.setString(2, MenuPhoto);
			pre.setString(3, MenuName);
			pre.setString(4, MenuRetail);
			pre.setString(5, MenuIntroduction);
			pre.setString(6, MenuTypeId);
			
			int i = pre.executeUpdate();
			if(i>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	
	//ͨ��uidɾ���û���Ϣ����
	public boolean deleteUserByid(String MenuId) {
		//��ȡ����
		conn = DBUtil_pool.getConnection();
		
		String sql = "delete from order_menu where MenuId=?";
		
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, MenuId);
			
			int i = pre.executeUpdate();
			if(i>0) {
				return true;
			}
			
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
