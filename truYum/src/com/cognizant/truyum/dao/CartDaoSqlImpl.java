package com.cognizant.truyum.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;


public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {

		Connection con = ConnectionHandler.getConnection();

		try {
			String sql = "INSERT INTO cart values(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1, userId);
			pst.setLong(2, menuItemId);
			int res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {

		Connection con = ConnectionHandler.getConnection();
		
		List<MenuItem> menuItem = new ArrayList<MenuItem>();
		double sum = 0;
		Cart cart = new Cart(menuItem, 0.0);
		try {
			PreparedStatement pst = con.prepareStatement("select * from menu_item where menuItemId IN (select menuItemId from cart where userId = ?)");
			pst.setLong(1, userId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				menuItem.add(new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4),rs.getDate(5), rs.getString(6), rs.getBoolean(7)));
				sum += rs.getFloat(3);
			}
			cart.setMenuItemList(menuItem);
			cart.setTotal(sum);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return menuItem;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {

		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("delete from cart where userId=? and menuItemId=?");
			pst.setLong(1, userId);
			pst.setLong(2, menuItemId);
			int res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
