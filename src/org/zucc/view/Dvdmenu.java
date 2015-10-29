package org.zucc.view;

import java.text.ParseException;
import java.util.Scanner;
import org.zucc.service.DvdManager;
public class Dvdmenu {

	
	DvdManager dm = new DvdManager();
	Scanner sc = new Scanner(System.in);
	public void Dvdmain() throws ParseException{
		System.out.println("欢迎使用迷你DVD管理器");
		System.out.println("--------------------------------------");
		System.out.println("1.新增DVD");
		System.out.println("2.查看DVD");
		System.out.println("3.删除DVD");
		System.out.println("4.借出DVD");
		System.out.println("5.归还DVD");
		System.out.println("6.热门DVD");	
		System.out.println("7.退出");	
		System.out.println("请选择：");
		switch(sc.nextInt()){
			case 1:
				
				
				System.out.println("--->新增DVD");
				dm.add();
				System.out.println("输入0返回");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 2:
				System.out.println("--->查看DVD");
				dm.show();
				System.out.println("输入0返回");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 3:
				System.out.println("--->删除DVD");
				dm.del();
				System.out.println("输入0返回");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 4:
				System.out.println("--->借出DVD");
				System.out.println("请输入要借出的dvd的ID");				
				dm.borrowDvd(sc.nextInt());
				System.out.println("输入0返回");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 5:
				System.out.println("--->归还DVD");
				System.out.println("请输入要归还的dvd的ID");	
				dm.returnDvd(sc.nextInt());
				System.out.println("输入0返回");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 6:
				System.out.println("--->热门DVD");
				dm.top();
				System.out.println("输入0返回");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 7:
				System.out.println("谢谢使用！");
				break;
				
			default:
				System.out.println("输入错误");
				break;
			
		}
	}
}
