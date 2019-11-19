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
//			deleteFiles(file); //���÷���ɾ��Ŀ¼�µ������ļ�
			copyFiles(file); //�ļ��ĸ���
		}
	}
	/**
	 * �ļ��ĸ���
	 * @throws IOException 
	 * */
	public static void copyFiles(File dir) throws IOException {
		//1.��ȡ��ǰ�ļ��µ��������ļ�������Ŀ¼
		File[] files = dir.listFiles();
		//2.��������
		for (File f : files) { //f D://hehe/123.txt
			//3.�ж��Ƿ�Ϊһ����׼�ļ������������
			if(f.isFile()) { //��ʾ��һ����׼�ļ�
				//��ȡ��ǰ�ļ����ļ����ͺ�׺��
				String fileName = f.getName();
				System.out.println(fileName);
				//����һ����������������
				FileReader fr = new FileReader(f);
				String path = "D://123" + File.separator + fileName;
				FileWriter fw = new FileWriter(path); //D://123/123.txt
				//����һ���������ڴ�Ŷ�ȡ����
				char[] ch = new char[1024];
				int len;//��ʾÿ�ζ�ȡ���ݵĳ���
				while((len = fr.read(ch)) != -1) {
					fw.write(ch); //�������л�ȡ���ݣ���д�뵽ָ��Ŀ¼�µ��ļ���
				}
				//ˢ��
				fw.flush();
//				fw.close();
//				fr.close();
			}
		}
	}
	
	/**
	 * ɾ��ָ��Ŀ¼�µ������ļ�
	 * @param File dir ��ʾ��Ҫɾ���ļ��ĸ�Ŀ¼
	 * */
	public static void deleteFiles(File dir) {
		//1.��ȡ��ǰĿ¼�µ�������Ŀ¼�������ļ�
		File[] files = dir.listFiles();
		//2.��������
		for (File f : files) {
//			System.out.println(f);
			//3.�жϵ�ǰ�Ƿ�Ϊһ�����ļ����������ɾ��������ݹ�
			if(f.isFile()) {//��ʾΪһ����׼�ļ�
				//ɾ���ļ�
				f.delete();
			}else {//��ʾΪһ��Ŀ¼ �ݹ�
				deleteFiles(f);
			}
		}
	}
	
	/**
	 * �ж��ļ�Ŀ¼�Ƿ����,�����ļ�����򷵻أ������ڻ��߲���һ��Ŀ¼����null
	 * */
	public static File isDirctory(String path) {
		//1.����File���͵Ķ���
		File file = new File(path);
		//2.�жϸ����� ·���Ƿ����
		if(!file.exists()) {
			System.out.println("������Ŀ¼�����ڣ�����������....");
			return null;
		}
		//3.�ж��Ƿ�Ϊһ���ļ�
		if(!file.isDirectory()) {
			System.out.println("���������һ��Ŀ¼������һ����׼�ļ�������������....");
			return null;
		}
		return file;
	}
	
	
}
