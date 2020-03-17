package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.MenuListener;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;
	public MenuItemDaoCollectionImpl() {
		if (menuItemList==null)
		{
			menuItemList = new ArrayList<MenuItem>();
			MenuItem menuItem = new MenuItem(1, "Sandwich", 99.00F, true, DateUtil.convertToDate("15/03/2017"), "Mian Course", true);
			menuItemList.add(menuItem);
			menuItem = new MenuItem(2, "Burger", 129.00F, true, DateUtil.convertToDate("23/12/2017"), "Mian Course", false);
			menuItemList.add(menuItem);
			menuItem = new MenuItem(3, "Pizza", 149.00F, true, DateUtil.convertToDate("21/08/2017"), "Mian Course", false);
			menuItemList.add(menuItem);
		}
	}
	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}
	
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> list = new ArrayList<>();
		for (MenuItem m : menuItemList)
		{
			if (m.isActive()==true && (new Date().getTime()>m.getDateOfLaunch().getTime()))
			{
				list.add(m);
			}
		}
		return list;
	}
	
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<MenuItem> getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
