package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	public static void main(String[] args) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
		//testModifyMenuItem();
	}
	
	public static void testGetMenuItemListAdmin() {
		MenuItemDaoSqlImpl obj = new MenuItemDaoSqlImpl();
		System.out.println(obj.getMenuItemListAdmin());
	}
	
	public static void testGetMenuItemListCustomer() {
		MenuItemDaoSqlImpl obj = new MenuItemDaoSqlImpl();
		System.out.println(obj.getMenuItemListCustomer());
	}
	
	public static void testModifyMenuItem() {
		MenuItemDaoSqlImpl obj = new MenuItemDaoSqlImpl();
		MenuItem menuItem = new MenuItem(3,"Samosa",5.0f,true,DateUtil.convertToDate("31/12/2017"),"Starters",false);
		obj.modifyMenuItem(menuItem);
	}
	
	public static void testGetMenuItem() {

		MenuItemDaoSqlImpl obj = new MenuItemDaoSqlImpl();
		System.out.println(obj.getMenuItem(3));
	}
}
