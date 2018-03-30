package com.dlg.common.libraries;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public class DataHandler {
	private static final String FILE_NAME = "./Resources/TestData/B4C_TestData.xlsx";
	public List<Map<String , String>> getData(String sheetName, String sprint, List<String> tags, int scnIter) {
		Workbook workbook;
		Cell currentCell, sprintCell, featureCell, testExecutionIdCell, scenarioIdCell, iterationCell;
		Row currentRow;
		Iterator<Row> iterator;
		Iterator<Cell> cellIterator;
	    
	    List<Map<String , String>> DataRowsList  = new ArrayList<Map<String,String>>();
	    ArrayList objectsArray = new ArrayList();
	    
		try{
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheet(sheetName);
            iterator = datatypeSheet.iterator();
            int cellCounter=1, rowCounter=1, mapsCounter=0;
            while (iterator.hasNext()) {

                currentRow = iterator.next();
                cellIterator = currentRow.iterator();
                Map<String,String> DataMap = new HashMap<String, String>();
                if(rowCounter==1){
                    while (cellIterator.hasNext()) {
                    	currentCell=cellIterator.next();
                    	if(cellCounter>5){
                    		DataMap.put(currentCell.getStringCellValue(), "");
                    		objectsArray.add(currentCell.getStringCellValue());
                    	}
                    	cellCounter++;
                    }
                	
                } else{
  
                    sprintCell = cellIterator.next();
                    featureCell = cellIterator.next();
                    testExecutionIdCell = cellIterator.next();
                    scenarioIdCell = cellIterator.next();
                    iterationCell=cellIterator.next();
                    int dataCellCounter=0;
                    
                    if(sprint.equalsIgnoreCase(sprintCell.getStringCellValue()) && tags.contains(testExecutionIdCell.getStringCellValue()) && tags.contains(scenarioIdCell.getStringCellValue()) && scnIter==iterationCell.getNumericCellValue()){
                    	while (cellIterator.hasNext()) {
    	                	currentCell=cellIterator.next();	                		                	
	  	                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
    	                        DataMap.put(objectsArray.get(dataCellCounter).toString(), currentCell.getStringCellValue());
    	                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
    	                    	DataMap.put(objectsArray.get(dataCellCounter).toString(), Double.toString(currentCell.getNumericCellValue()) );
    	                    }	                			                	
    	                	dataCellCounter++;
                    	}
                        DataRowsList.add(mapsCounter, DataMap);
                        mapsCounter++;                	
                    }
                   
                }
                
                rowCounter++;
            } 
            workbook.close();
            
		} 
		catch(FileNotFoundException fnfe){
			System.out.println("fnfe excpetion "+fnfe.getMessage());
		}
		catch(IOException ioe){
			System.out.println("ioe exception" + ioe.getMessage());
		}
		return DataRowsList;
	}

}
