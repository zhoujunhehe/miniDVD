package org.zucc.service;


import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.zucc.dao.Dvddao;
import org.zucc.entity.Dvd;


public class DvdManager {
	
	Dvddao dm = new Dvddao();
	
	public void borrowDvd(int id){
		
		Dvd dvd = dm.findDvd(id);			
		if(dvd.getState()==1){
			System.out.println("dvd�Ѿ����");
		}else{
			dvd.setBorrowdate(new Date());
			dvd.setState(1);
			dvd.setReturndate(null);
			dvd.setCount(dvd.getCount()+1);
			dm.updateDvd(dvd);
			System.out.println("�ɹ����");
		}
		
	} 
	
	public void returnDvd(int id){
		Dvd dvd = dm.findDvd(id);
		if(dvd.getState()==0){
			System.out.println("Dvdδ���");
		}else{
		dvd.setReturndate(new Date());
		dvd.setState(0);		
		long day = (dvd.getReturndate().getTime()- dvd.getBorrowdate().getTime())/(3600*1000*24);
		System.out.println("����Ľ��Ϊ"+day);
		dvd.setBorrowdate(null);	
		
		dm.updateDvd(dvd);
		}
		
	}
	
	public void show() {
		System.out.println("����\t\t״̬\t\t����\t\t�������");
		for (Dvd s : dm.selectDvd()) {
			System.out.println(s);
		}
	}
	
	public void top(){

		
		List<Dvd> list = dm.selectDvd();
		
		Collections.sort(list);
		System.out.println("--------Dvd�������а�--------");
		System.out.println("����\t\t״̬\t\t����\t\t�������");
		for(Dvd s :list ){
			System.out.println(s);
		}
	}
	
	public void add(){

		dm.addDvd();
	}	
	
	public void del(){
		dm.deleteDvd();
	}
}
