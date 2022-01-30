package com.texalaassigment.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.texalaassigment.main.FolderNamingData;

public class Service {
	private String UrlAuthoriesName;

	public String readHtml(String requrl) throws IOException {
		String urlData = " ";

		URL url = new URL(requrl);

		Scanner scanner = new Scanner(url.openStream());
		setUrlAuthoriesName(url.getAuthority());
		StringBuffer buffer = new StringBuffer();

		while (scanner.hasNext()) {

			buffer = buffer.append(scanner.next());
		}

		urlData = buffer.toString();
		System.out.println(urlData);

		return urlData;
	}

	private void setUrlAuthoriesName(String authority) {

		this.UrlAuthoriesName = authority;

	}

	public String getUrlAuthoriesName() {
		return UrlAuthoriesName;
	}

	public boolean storeInMachine(String htmlData, String filePath) throws IOException {
		boolean folderCreated = createFolders(filePath);
		boolean Stored = false;
		
		String folderLoaction = filePath+"\\"+FolderNamingData.filePathSubFolder+"\\"+FolderNamingData.filePathHtmlFolder;
		if (folderCreated) {
		 Stored = storeHtmlData(folderLoaction, htmlData);
		
		}
		return Stored;
	}

	private boolean storeHtmlData(String folderLoaction, String htmlData) throws IOException {
	
		boolean writeData = false;

		File file = new File(folderLoaction);
		if (!(file.exists())) 
			{
				file.mkdir();
			}
			if (file.exists()) {
				
				File htmlFiles = new File(folderLoaction +"\\" + getUrlAuthoriesName() + FolderNamingData.readedFileExtention);
				 htmlFiles.createNewFile();
				if (htmlFiles.exists()) {
					
					FileWriter fileWriter = new FileWriter(htmlFiles);
					PrintWriter printWriter = new PrintWriter(fileWriter);
					printWriter.print(htmlData);
					printWriter.close();

					writeData = true;
					
				}

			}

		
		return writeData;
	}

	public boolean createFolders(String filePath) {
		boolean flag = false;
		File subFolder ;
		
		File mainfolder = new File(filePath);
		
		if (!(mainfolder.exists())) {
			mainfolder.mkdir();
			
			subFolder = new File(filePath + FolderNamingData.filePathSubFolder);
			subFolder.mkdir();
			if(subFolder.exists())
			{
				
				flag = true;
			}
			
		}
		else {
			flag = true;
		}
		return flag;
		
		
	}

}
