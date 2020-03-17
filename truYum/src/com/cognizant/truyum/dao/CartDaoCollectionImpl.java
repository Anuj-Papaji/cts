package com.cognizant.truyum.dao;

import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private HashMap<Long, Cart> userCarts;
	public CartDaoCollectionImpl() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		
	}

	
}
