package com.op.flow.manage.util.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CsvUtil {
	public static String split = "|";

	/**
	 * 初始化函數
	 */
	public static void init() {
//		path_file = ExcelState.path_file + ".csv";
//		header = ExcelState.headerNames;
	}

	/**
	 * 通过类型转化
	 * 
	 * @param reSet
	 *            返回集加工后结果
	 */
	public static void doCsv(ArrayList<ArrayList<String>> reSet,ArrayList<String> header,String path_file) {
		StringBuffer sb = new StringBuffer();
		for (String head : header) {
			sb.append(head);
			sb.append(split);
		}
		if (sb.length() > split.length())
			sb.setLength(sb.length() - split.length());
		appendContent(sb.toString(),path_file);
		sb.setLength(0);
		for (ArrayList<String> rs : reSet) {
			for (String col : rs) {
				String column = col.substring(0, col.length() - 2);
				String type = col.substring(col.length() - 1).toUpperCase();
				sb.append(column);
				sb.append(split);
			}
			if (sb.length() > split.length())
				sb.setLength(sb.length() - split.length());
			appendContent(sb.toString(),path_file);
			sb.setLength(0);
		}
	}

	public static void doCsv(ResultSet rs, ArrayList<String> columName,ArrayList<String> header,String path_file) {
		try {
			System.out.println("do csv use rs and columName");
			StringBuffer sb = new StringBuffer();
			for (String head : header) {
				sb.append(head);
				sb.append(split);
			}
			if (sb.length() > split.length())
				sb.setLength(sb.length() - split.length());
			if(sb.length()>0)
				appendContent(sb.toString(),path_file);
			sb.setLength(0);
			while (rs.next()) {
				for(String cName : columName){
					String column = cName.substring(0, cName.length()-2);
					String content = rs.getString(column);
					sb.append(content).append(split);
				}
				if (sb.length() > split.length())
					sb.setLength(sb.length() - split.length());
				appendContent(sb.toString(),path_file);
				sb.setLength(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void appendContent(String content,String path_file) {
		try {
			// 文件是否存在，不存在新建
			File file = new File(path_file);
			if (!file.exists())
				file.createNewFile();
			// FileWriter writer = new FileWriter(file, true);
			OutputStreamWriter writer = new OutputStreamWriter(
					new FileOutputStream(file, true), "UTF-8");
			writer.write(content);
			writer.write("\r\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getSplit() {
		return split;
	}

	public static void setSplit(String split) {
		CsvUtil.split = split;
	}

}
