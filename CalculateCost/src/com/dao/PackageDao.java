package com.dao;

import com.model.Package;
import java.sql.Connection;
import java.util.ArrayList;

public interface PackageDao {
	public void Insert(Connection con, ArrayList<Package> p);
}
