package org.zucc.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.zucc.entity.Dvd;


public class Dvddao {

	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	Scanner sc = new Scanner(System.in);

	public void Myclose() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭失败");
			e.printStackTrace();
		}

	}

	public Dvddao() {

		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}

	}

	public void addDvd() {

		Dvd newdvd = new Dvd();
		System.out.println("请输入新增Dvd的名字");
		newdvd.setName(sc.next());
		try {

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");

			String st = new String("insert into dvd(name) value (?)");
			psmt = conn.prepareStatement(st);
			psmt.setString(1, newdvd.getName());
			psmt.execute();

			System.out.println("增加DVD成功");
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("链接失败");
			e.printStackTrace();

		} finally {
			Myclose();
		}

	}

	public void deleteDvd() {
		int id;
		System.out.println("请输入删除DVD的ID");
		id = sc.nextInt();
		try {

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");

			String st = new String("delete from dvd where id =? ");
			psmt = conn.prepareStatement(st);
			psmt.setInt(1, id);

			psmt.execute();

			System.out.println("删除成功");

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("链接失败");
			e.printStackTrace();
		} finally {
			Myclose();
		}

	}

	public List<Dvd> findByName(String name) {
		List<Dvd> dvdl = new ArrayList<Dvd>();
		try {

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String st = new String("select * from dvd where name= ?");
			psmt = conn.prepareStatement(st);
			psmt.setString(1, name);

			psmt.execute();

			rs = psmt.executeQuery(st);

			while (rs.next()) {

				Dvd dvd = new Dvd();
				dvd.setName(rs.getString("name"));
				dvd.setId(rs.getInt("id"));
				dvd.setState(rs.getInt("state"));
				dvd.setBorrowdate(rs.getDate("borrowdate"));
				dvd.setReturndate(rs.getDate("returndate"));
				dvd.setCount(rs.getInt("borrowcount"));
				dvdl.add(dvd);

			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		} finally {
			Myclose();
		}
		return dvdl;
	}

	public Dvd findDvd(int id) {

		Dvd dvd = new Dvd();
		try {

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String st = new String("select * from dvd where id = ?");
			psmt = conn.prepareStatement(st);
			psmt.setInt(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				dvd.setName(rs.getString("name"));
				dvd.setId(rs.getInt("id"));
				dvd.setState(rs.getInt("state"));
				dvd.setBorrowdate(rs.getDate("borrowdate"));
				dvd.setReturndate(rs.getDate("returndate"));
				dvd.setCount(rs.getInt("borrowcount"));
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("链接失败");
			e.printStackTrace();
		} finally {
			Myclose();
		}
		return dvd;
	}

	public List<Dvd> selectDvd() {
		List<Dvd> dl = new ArrayList<Dvd>();
		try {

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String st = new String("select * from dvd ");

			psmt = conn.prepareStatement(st);
			psmt.execute();
			rs = psmt.executeQuery(st);
			while (rs.next()) {
				Dvd dvd = new Dvd();
				dvd.setName(rs.getString("name"));
				dvd.setId(rs.getInt("id"));
				dvd.setState(rs.getInt("state"));
				dvd.setBorrowdate(rs.getDate("borrowdate"));
				dvd.setReturndate(rs.getDate("returndate"));
				dvd.setCount(rs.getInt("borrowcount"));
				dl.add(dvd);
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("链接失败");
			e.printStackTrace();
		} finally {
			Myclose();
		}

		return dl;
	}

	public void updateDvd(Dvd newdvd) {

		try {

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/minidvd", "root", "root");

			String st = new String(
					"update dvd set name=?,state=?,borrowdate=?,returndate=?,borrowcount=? where id =?");
			psmt = conn.prepareStatement(st);
			psmt.setString(1, newdvd.getName());
			psmt.setInt(2, newdvd.getState());
			java.sql.Date sqlborrow = newdvd.getBorrowdate() == null ? null
					: new java.sql.Date(newdvd.getBorrowdate().getTime());
			psmt.setDate(3, sqlborrow);
			java.sql.Date sqlreturn = newdvd.getReturndate() == null ? null
					: new java.sql.Date(newdvd.getReturndate().getTime());
			psmt.setDate(4, sqlreturn);
			psmt.setInt(5, newdvd.getCount());
			psmt.setInt(6, newdvd.getId());
			psmt.execute();

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("链接失败");
			e.printStackTrace();
		} finally {
			Myclose();
		}
	}
}

// public void lend() throws ParseException{
// Dvd newdvd = new Dvd();
// System.out.println("请输入要借出书的ID");
// newdvd.setId(sc.nextInt());
// System.out.println("请输入借出时间");
// String time = sc.next();
// SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
// Date time1 = sf.parse(time);
// java.sql.Date time2 = new java.sql.Date (time1.getTime());
// newdvd.setBorrowdate(time2);
// try {
//
// conn = DriverManager.getConnection(
// "jdbc:mysql://localhost:3306/minidvd", "root", "root");
//			
// String st = new String("update dvd set state=1,borrowdate=? where id =?");
// psmt = conn.prepareStatement(st);
//		
//			
// java.sql.Date sqlborrow = newdvd.getBorrowdate()==null?null:new
// java.sql.Date(newdvd.getBorrowdate().getTime());
// psmt.setDate(1, sqlborrow);
//			
// psmt.setInt(2, newdvd.getId());
// psmt.execute();
//
// }
//
// catch (SQLException e) {
// // TODO Auto-generated catch block
// System.out.println("链接失败");
// e.printStackTrace();
// } finally {
// Myclose();
// }
//	
//		
// }
// public void returndvd() throws ParseException{
// Dvd newdvd = new Dvd();
// System.out.println("请输入归还书的ID");
// newdvd.setId(sc.nextInt());
// System.out.println("请输入归还时间");
// String time = sc.next();
// SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
// Date time1 = sf.parse(time);
// java.sql.Date time2 = new java.sql.Date (time1.getTime());
// newdvd.setReturndate(time2);
// try {
//
// conn = DriverManager.getConnection(
// "jdbc:mysql://localhost:3306/minidvd", "root", "root");
// String st = new String("update dvd set state=0,returndate=? where id =?");
// psmt = conn.prepareStatement(st);
// java.sql.Date sqlreturn = newdvd.getReturndate()==null?null:new
// java.sql.Date(newdvd.getReturndate().getTime());
// psmt.setDate(1, sqlreturn);
// psmt.setInt(2, newdvd.getId());
// psmt.execute();
// String st2 = "select * from dvd where id =?";
// psmt = conn.prepareStatement(st2);
// psmt.setInt(1, newdvd.getId());
// rs = psmt.executeQuery();
// rs.next();
// long day
// =(newdvd.getReturndate().getTime()-rs.getDate("borrowdate").getTime())/(3600*1000*24);
// System.out.println("需要支付"+day);
// }
//
// catch (SQLException e) {
// // TODO Auto-generated catch block
// System.out.println("链接失败");
// e.printStackTrace();
// } finally {
// Myclose();
// }
// }

