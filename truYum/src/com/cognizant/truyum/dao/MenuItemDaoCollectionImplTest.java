package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {
	public static void main(String[] args) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
	}

	public static void testGetMenuItemListAdmin(){
		MenuItemDao obj = new MenuItemDaoCollectionImpl();
		List<MenuItem> list = obj.getMenuItemListAdmin();
		for (MenuItem i: list)
		{
			System.out.println(i.toString());
		}
	}
	
	public static void testGetMenuItemListCustomer(){
		MenuItemDao obj = new MenuItemDaoCollectionImpl();
		List<MenuItem> list = obj.getMenuItemListCustomer();
		for (MenuItem i: list)
		{
			System.out.println(i.toString());
		}
	}
	
	public static void testModifyMenuItem(){
		
	}
	
	public static void testGetMenuItem(){
		
	}
	
	
}
