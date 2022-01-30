package com.texalaassigment.main;

import java.io.IOException;
import java.util.Scanner;

import com.texalaassigment.service.Service;

public class TexalaAssig1 {

	public static void main(String[] args) throws IOException {
		TexalaAssig1 assig1 = new TexalaAssig1();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Complete url of page");
		String url_path = sc.next();
		assig1.startTask(url_path);
		
	}

	public boolean startTask(String url_path) throws IOException {
		
		String htmlData = " ";
		String filePath =FolderNamingData.filePathFolder;
		boolean done = false;
		Service service = new Service();
		htmlData=service.readHtml(url_path);
		done=service.storeInMachine(htmlData,filePath);
		if(done)
		{
			System.out.println("task completed");
		}
		return done;
		
	}
		

}
