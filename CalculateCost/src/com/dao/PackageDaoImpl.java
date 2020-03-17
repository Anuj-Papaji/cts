package com.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.model.Package;

public class PackageDaoImpl implements PackageDao {

	@Override
	public void Insert(Connection con, ArrayList<Package> p) {
		String sql = "insert into package values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			for(Package pkg:p){
				ps.setString(1, pkg.getPackageId());
				ps.setString(2, pkg.getSource());
				ps.setString(3, pkg.getDestination());
				ps.setDouble(4, pkg.getBasicFare());
				ps.setInt(5, pkg.getNoOFDays());
				ps.setDouble(6, pkg.getPackage_cost());
				ps.addBatch();
			}
			ps.executeBatch();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	
	public ArrayList<Package> readFileData() throws Exception{
		FileReader in=null;
		Package obj = null;
		ArrayList<Package> list = null;
		try {
			in=new FileReader("C:/Users/851451/Desktop/package.txt");
			BufferedReader br = new BufferedReader(in);
			String line=null;
			list = new ArrayList<>();
			while ((line=br.readLine())!=null){
				String []arr = line.split(",");
				if (Pattern.compile("[0-9]{3}/[A-Za-z]{3}").matcher(arr[0]).matches())
				{
					int arr4 = Integer.parseInt(arr[4]);
					double arr3 = Double.parseDouble(arr[3]);
					double pc = 0;
					if (arr4 <= 5)
						pc=arr3;
					else if (arr4 <= 8)
						pc=arr3*0.97;
					else if (arr4 <= 10)
						pc=arr3*0.95;
					else 
						pc=arr3*0.93;
					obj = new Package(arr[0],arr[1],arr[2],arr3,arr4,pc);
					list.add(obj);
				}
				else
				{
					throw new Exception("Invalid Input");
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
}
