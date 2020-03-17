package com.dao;

import com.model.Package;
import com.util.ConnectionHandler;

import java.util.ArrayList;

public class PackageDaoImplTest {
	public static void main(String[] args) throws Exception
	{
		PackageDaoImpl a = new PackageDaoImpl();
		ArrayList<Package> list = a.readFileData();
		for(Package p : list)
			System.out.println(p);
		ConnectionHandler con = new ConnectionHandler();
		a.Insert(con.handleConnection(), list);
	}
}
