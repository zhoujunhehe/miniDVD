package org.zucc.view;

import java.text.ParseException;
import java.util.Scanner;
import org.zucc.service.DvdManager;
public class Dvdmenu {

	
	DvdManager dm = new DvdManager();
	Scanner sc = new Scanner(System.in);
	public void Dvdmain() throws ParseException{
		System.out.println("��ӭʹ������DVD������");
		System.out.println("--------------------------------------");
		System.out.println("1.����DVD");
		System.out.println("2.�鿴DVD");
		System.out.println("3.ɾ��DVD");
		System.out.println("4.���DVD");
		System.out.println("5.�黹DVD");
		System.out.println("6.����DVD");	
		System.out.println("7.�˳�");	
		System.out.println("��ѡ��");
		switch(sc.nextInt()){
			case 1:
				
				
				System.out.println("--->����DVD");
				dm.add();
				System.out.println("����0����");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 2:
				System.out.println("--->�鿴DVD");
				dm.show();
				System.out.println("����0����");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 3:
				System.out.println("--->ɾ��DVD");
				dm.del();
				System.out.println("����0����");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 4:
				System.out.println("--->���DVD");
				System.out.println("������Ҫ�����dvd��ID");				
				dm.borrowDvd(sc.nextInt());
				System.out.println("����0����");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 5:
				System.out.println("--->�黹DVD");
				System.out.println("������Ҫ�黹��dvd��ID");	
				dm.returnDvd(sc.nextInt());
				System.out.println("����0����");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 6:
				System.out.println("--->����DVD");
				dm.top();
				System.out.println("����0����");	
				if(sc.nextInt()==0){
					Dvdmain();
				}
				break;
			case 7:
				System.out.println("ллʹ�ã�");
				break;
				
			default:
				System.out.println("�������");
				break;
			
		}
	}
}
