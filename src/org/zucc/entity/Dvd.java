package org.zucc.entity;

import java.util.Date;

public class Dvd implements Comparable<Dvd>{
	private String name;
	private int state;// 1 ½è³ö 0Î´½è³ö
	private int id;
	private Date borrowdate;
	private Date returndate;
	private int count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return ""+ id + "\t\t" + state +  "\t\t" + name + "\t\t"  +count;
	}
	public int getCount() {
		return count;
	}
	@Override
	public int compareTo(Dvd o) {
		
		// TODO Auto-generated method stub
		return o.getCount() -this.getCount();
	}
	
}
