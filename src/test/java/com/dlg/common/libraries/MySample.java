package com.dlg.common.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MySample {

	public static void main(String[] args) {
		File envFile = new File("./Resources/Temp/tempdata.txt");
		FileInputStream envFileIS;
		try {
			envFileIS = new FileInputStream(envFile);		
			byte[] data = new byte[(int) envFile.length()];
			envFileIS.read(data);
			envFileIS.close();
			String fileData = new String(data, "UTF-8");
			fileData=fileData.replace("\n", "");
			fileData=fileData.replace("\r", "");
			envFile=new File("report.json");
			envFile.renameTo(new File(fileData+"/JSON/" + envFile.getName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
