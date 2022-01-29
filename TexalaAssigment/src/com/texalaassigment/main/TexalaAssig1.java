package com.texalaassigment.main;

import java.io.IOException;
import java.util.Scanner;

import com.texalaassigment.service.Service;

public class TexalaAssig1 {

	public static void main(String[] args) throws IOException {
		TexalaAssig1 assig1 = new TexalaAssig1();
		assig1.startTask();
		
	}

	public void startTask() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Complete url of page");
		String url_path = sc.next();
		String htmlData = " ";
		String filePath =FolderNamingData.filePathFolder;
		boolean done = false;
		Service service = new Service();
		htmlData=service.readHtml(url_path);
		done=service.storeInMachine(htmlData,filePath);
		
	}
		

}
