package com.sy.io.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteFile {
	public static void main(String[] args) throws IOException {
		File file = isDirctory("D://hehe");
		if(file != null) {
//			deleteFiles(file); //调用方法删除目录下的所有文件
			copyFiles(file); //文件的复制
		}
	}
	/**
	 * 文件的复制
	 * @throws IOException 
	 * */
	public static void copyFiles(File dir) throws IOException {
		//1.获取当前文件下的所有子文件或者子目录
		File[] files = dir.listFiles();
		//2.遍历数组
		for (File f : files) { //f D://hehe/123.txt
			//3.判断是否为一个标准文件，如果是则复制
			if(f.isFile()) { //表示是一个标准文件
				//获取当前文件的文件名和后缀名
				String fileName = f.getName();
				System.out.println(fileName);
				//创建一个输入和输出流对象
				FileReader fr = new FileReader(f);
				String path = "D://123" + File.separator + fileName;
				FileWriter fw = new FileWriter(path); //D://123/123.txt
				//定义一个数组用于存放读取数据
				char[] ch = new char[1024];
				int len;//表示每次读取数据的长度
				while((len = fr.read(ch)) != -1) {
					fw.write(ch); //从数组中获取数据，并写入到指定目录下的文件中
				}
				//刷新
				fw.flush();
//				fw.close();
//				fr.close();
			}
		}
	}
	
	/**
	 * 删除指定目录下的所有文件
	 * @param File dir 表示需要删除文件的父目录
	 * */
	public static void deleteFiles(File dir) {
		//1.获取当前目录下的所有子目录或者子文件
		File[] files = dir.listFiles();
		//2.遍历数组
		for (File f : files) {
//			System.out.println(f);
			//3.判断当前是否为一个子文件，如果是则删除。否则递归
			if(f.isFile()) {//表示为一个标准文件
				//删除文件
				f.delete();
			}else {//表示为一个目录 递归
				deleteFiles(f);
			}
		}
	}
	
	/**
	 * 判断文件目录是否存在,如果该募存在则返回，不存在或者不是一个目录返回null
	 * */
	public static File isDirctory(String path) {
		//1.创建File类型的对象
		File file = new File(path);
		//2.判断给定的 路径是否存在
		if(!file.exists()) {
			System.out.println("给定的目录不存在，请重新输入....");
			return null;
		}
		//3.判断是否为一个文件
		if(!file.isDirectory()) {
			System.out.println("你给定不是一个目录，而是一个标准文件，请重新输入....");
			return null;
		}
		return file;
	}
	
	
}
