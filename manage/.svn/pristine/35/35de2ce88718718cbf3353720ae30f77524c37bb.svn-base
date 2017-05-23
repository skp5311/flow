package com.op.flow.manage.util.excel;

import java.util.ArrayList;

/**
 * 	文件生成的配置类
 * @author Frank
 *
 */
public class ExcelState {
	//文件类型，目前目前仅支持xls和csv
	public String fileType = "csv";
	//当文件大于60000数据时是否保留xls格式，默认转为csv
	public String mustXls = "false";
	//文件生成路径
	public String path_file = "E:\\";
	//sheet名字
	public String sheetName = "data";
	//执行odps的sql语句
	public String sql = "";
	//文件头
	public ArrayList<String> headerNames = new ArrayList();
	//sql数据返回的数据列名与"_"+数据类型的拼接
	public  ArrayList<String> columNames = new ArrayList();
	
	public static void init(){
		CsvUtil.init();
		XlsUtil.init();
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getMustXls() {
		return mustXls;
	}

	public void setMustXls(String mustXls) {
		this.mustXls = mustXls;
	}

	public String getPath_file() {
		return path_file;
	}

	public void setPath_file(String path_file) {
		this.path_file = path_file;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public ArrayList<String> getHeaderNames() {
		return headerNames;
	}

	public void setHeaderNames(ArrayList<String> headerNames) {
		this.headerNames = headerNames;
	}

	public ArrayList<String> getColumNames() {
		return columNames;
	}

	public void setColumNames(ArrayList<String> columNames) {
		this.columNames = columNames;
	}
	

}
