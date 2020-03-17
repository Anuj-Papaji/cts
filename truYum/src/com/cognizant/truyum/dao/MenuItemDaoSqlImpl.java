package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		List<MenuItem> list=new ArrayList<>();
		
		
		try {
			Connection connection = ConnectionHandler.getConnection();
			String sql = "select * from menuItem";
			PreparedStatement ps=connection.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				 long menuItemId=rs.getLong(1);
				 String name=rs.getString(2);
				 float price=rs.getFloat(3);
				 boolean active=rs.getBoolean(4);
				 Date dateOfLaunch=rs.getDate(5);
				 String category=rs.getString(6);
				 boolean freeDelivery=rs.getBoolean(7);
				 
				 MenuItem f=new MenuItem(menuItemId,name,price,active, dateOfLaunch,category,freeDelivery);
				 list.add(f);
			}
			

		} catch (SQLException e) {
			list =null;
		}
		
		return list;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> list=new ArrayList<>();
		
		
		try {
			Connection connection = ConnectionHandler.getConnection();
			String sql = "select * from menuItem where active=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setBoolean(1, true);
			
			ResultSet rs=ps.executeQuery();
			Date d = new Date();
			while(rs.next()){
				if (rs.getDate(5).getTime()< d.getTime())
				{
				 long menuItemId=rs.getLong(1);
				 String name=rs.getString(2);
				 float price=rs.getFloat(3);
				 boolean active=rs.getBoolean(4);
				 Date dateOfLaunch=rs.getDate(5);
				 String category=rs.getString(6);
				 boolean freeDelivery=rs.getBoolean(7);
				 
				 MenuItem f=new MenuItem(menuItemId,name,price,active, dateOfLaunch,category,freeDelivery);
				 list.add(f);
				}
			}
			

		} catch (SQLException e) {
			list =null;
		}
		
		return list;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		
		try {
			Connection connection = ConnectionHandler.getConnection();
			String sql = "update menuItem set name=?, price=?, active =?, dateOfLaunch=?, category=?, freeDelivery=? where menuItemId=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setBoolean(3, menuItem.isActive());
			ps.setDate(4,new java.sql.Date( menuItem.getDateOfLaunch().getTime()));
			ps.setString(5, menuItem.getCategory());
			ps.setBoolean(6, menuItem.isFreeDelivery());
			ps.setLong(7, menuItem.getId());
			
			int rs=ps.executeUpdate();
			
					 	

		} catch (SQLException e) {
			
		}
		
	
	}

	@Override
	public List<MenuItem> getMenuItem(long menuItemId) {
		List<MenuItem> list=new ArrayList<>();
		
		
		try {
			Connection connection = ConnectionHandler.getConnection();
			String sql = "select * from menuItem where menuItemId=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setLong(1, menuItemId);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				 long itemId=rs.getLong(1);
				 String name=rs.getString(2);
				 float price=rs.getFloat(3);
				 boolean active=rs.getBoolean(4);
				 Date dateOfLaunch=rs.getDate(5);
				 String category=rs.getString(6);
				 boolean freeDelivery=rs.getBoolean(7);
				 
				 MenuItem f=new MenuItem(itemId,name,price,active, dateOfLaunch,category,freeDelivery);
				 list.add(f);
			}
			

		} catch (SQLException e) {
			list =null;
		}
		
		return list;
	}

}
