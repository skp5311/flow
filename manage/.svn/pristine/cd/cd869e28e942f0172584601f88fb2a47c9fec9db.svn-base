package com.op.flow.manage.util.excel;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class XlsUtil {
	public static String path_file = "";
	public static String sheetName = "";
	public static ArrayList<String> header = new ArrayList();
	
	/**
	 * 	初始化函數
	 */
	public static void init(){
//		path_file = ExcelState.path_file+".xls";
//		sheetName = ExcelState.sheetName;
//		header = ExcelState.headerNames;
	}
	/**
	 *  
	 * @param reSet  reSet,是结果集解析后数据集合，外层是每条数据，内层是没个字段的数据与数据类型用"_"连接的拼接
	 */
	public static void doXls(ArrayList<ArrayList<String>> reSet){
		try {
			WritableWorkbook createXls = XlsUtil.createXls(path_file);
			WritableSheet createXlsSheet = XlsUtil.createXlsSheet(createXls, sheetName);
			XlsUtil.setHeader(createXlsSheet, header);
			XlsUtil.setContent(createXlsSheet, reSet, createXls);
			
			createXls.write();
			createXls.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *  通过路径和文件名生成Xls
	 * @param pathfile
	 * @return
	 * @throws IOException 
	 */
	public static WritableWorkbook createXls(String pathfile) throws IOException{
		WritableWorkbook oWritableBK=null;
		
        File file = new File(pathfile);
        if (!file.exists()) {
			file.createNewFile();
        }
        oWritableBK = Workbook.createWorkbook(file);
        return oWritableBK;
	}
	/**
	 *  返回Xls的sheet
	 * @param oWritableBK xls文件
	 * @param sheetName  sheet名称
	 * @param sheetCount  sheet序列号
	 * @return
	 */
	public static int sheetCount=1;
	public static WritableSheet createXlsSheet(WritableWorkbook oWritableBK, String sheetName){
		WritableSheet oWritableSheet = oWritableBK.createSheet(sheetName, sheetCount);
		sheetCount++;
		return oWritableSheet;
	}
	/**
	 *  通过字段名生成sheet表头
	 * @param sheet 
	 * @param xlsColumnName 列名
	 * @throws WriteException 
	 * @throws RowsExceededException 
	 */
	public static void setHeader(WritableSheet sheet, ArrayList<String> xlsColumnName) throws RowsExceededException, WriteException{
		WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 13, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
                jxl.format.Colour.BLACK);
        WritableCellFormat headerFormat = new WritableCellFormat(headerFont);
        for(int i=0;i<xlsColumnName.size();i++){
        	Label label = new Label(i, 0, xlsColumnName.get(i), headerFormat);
			sheet.addCell(label);
        }
	}
	/**
	 *  用rs数据插入到sheet中，
	 * @param sheet 
	 * @param rs 返回集合，next之前传入
	 * @param columnName 字段名称（后面带一个字符）
	 * @throws SQLException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void setContent(WritableSheet sheet, ResultSet rs, ArrayList<String> columnName, WritableWorkbook createXls) throws SQLException, RowsExceededException, WriteException{
		int currentRow = 1;
		Number number = null;
		Label label = null;
		int j=2;
		while(rs.next()){
			for(int i=0;i<columnName.size();i++){
				String cName = columnName.get(i);
				String type = cName.substring(cName.length()-1).toUpperCase();
				String column = cName.substring(0,cName.length()-1);
				if("L".equals(type)){
					number = new Number(i, currentRow, rs.getLong(column));
					sheet.addCell(number);
				}
				else if("I".equals(type)){
					number = new Number(i, currentRow, rs.getInt(column));
					sheet.addCell(number);
				}
				else if("D".equals(type)){
					double con = rs.getDouble(column);
					BigDecimal b = new BigDecimal(con);
					con = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					number = new Number(i, currentRow, con);
					sheet.addCell(number);
				}
				else if("F".equals(type)){
					number = new Number(i, currentRow, rs.getFloat(column));
					sheet.addCell(number);
				}
				else if("S".equals(type)){
					label = new Label(i, currentRow, rs.getString(column));
					sheet.addCell(label);
				}
				else if("B".equals(type)){
					label = new Label(i, currentRow, rs.getString(column));
					sheet.addCell(label);
				}
				else{
					label = new Label(i, currentRow, rs.getString(column));
					sheet.addCell(label);
				}
			}
			if(currentRow==60000){
				WritableSheet createSheet = createXls.createSheet(sheetName+j, j);
				XlsUtil.setHeader(createSheet, header);
				j++;
				currentRow=0;
				sheet = createSheet;
			}
			currentRow++;
		}
	}

	/**
	 * 用rsSet数据插入到sheet中，
	 * @param sheet
	 * @param reSet 内容集合与数据类型的拼接
	 * @param createXls
     */
	public static void setContent(WritableSheet sheet,ArrayList<ArrayList<String>> reSet, WritableWorkbook createXls) {
		try {
			int currentRow = 1;
			Number number = null;
			Label label = null;
			int j=2;
			for(int k=0;k<reSet.size();k++){
				ArrayList<String> array = reSet.get(k);
				for(int i=0;i<array.size();i++){
					String con = array.get(i);
					String upRow = "";
//					if(k>0){
//						upRow = reSet.get(k-1).get(i);
//					}
//					if(false){
////					if(con!=null&&con.equals(upRow)){
//						sheet.mergeCells(k-1, i, k, i);
//					}else{
					String type = con.substring(con.length()-1).toUpperCase();
					String column = con.substring(0,con.length()-2);
					if("L".equals(type)){
						number = new Number(i, currentRow, Long.parseLong(column));
						sheet.addCell(number);
					}
					else if("I".equals(type)){
						number = new Number(i, currentRow, Integer.parseInt(column));
						sheet.addCell(number);
					}
					else if("D".equals(type)){
						double con2 = Double.valueOf(column);
						BigDecimal b = new BigDecimal(con);
						con2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
						number = new Number(i, currentRow, con2);
						sheet.addCell(number);
					}
					else if("F".equals(type)){
						number = new Number(i, currentRow, Float.parseFloat(column));
						sheet.addCell(number);
					}
					else if("S".equals(type)){
						label = new Label(i, currentRow, column);
						sheet.addCell(label);
					}
					else if("B".equals(type)){
						label = new Label(i, currentRow, column);
						sheet.addCell(label);
					}
					else{
						label = new Label(i, currentRow, column);
						sheet.addCell(label);
					}
				}
				if(currentRow==60000){
					WritableSheet createSheet = createXls.createSheet(sheetName+j, j);
					XlsUtil.setHeader(createSheet, header);
					j++;
					currentRow=0;
					sheet = createSheet;
				}
				currentRow++;
			}
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void appendLog(String content) {
        // 定时任务log目录
        try {
            // 文件是否存在，不存在新建
            File file = new File( "E:\\scan_log.csv");
            if (!file.exists())
                file.createNewFile();
            FileWriter writer = new FileWriter(file, true);
            writer.write(content);
            writer.write("\r\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static String getPath_file() {
		return path_file;
	}
	public static void setPath_file(String path_file) {
		XlsUtil.path_file = path_file+".xls";
	}
	public static String getSheetName() {
		return sheetName;
	}
	public static void setSheetName(String sheetName) {
		XlsUtil.sheetName = sheetName;
	}
	public static ArrayList<String> getHeader() {
		return header;
	}
	public static void setHeader(ArrayList<String> header) {
		XlsUtil.header = header;
	}
	public static int getSheetCount() {
		return sheetCount;
	}
	public static void setSheetCount(int sheetCount) {
		XlsUtil.sheetCount = sheetCount;
	}
	
}
