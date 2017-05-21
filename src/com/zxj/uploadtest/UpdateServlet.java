package com.zxj.uploadtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UpdateServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;  
	 
	 /** 
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
	     */  
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	        request.setCharacterEncoding("utf-8");  
	        response.setCharacterEncoding("utf-8");  
	        //1������һ��DiskFileItemFactory����  
	        DiskFileItemFactory factory = new DiskFileItemFactory();  
	        //2������һ���ļ��ϴ�������  
	        ServletFileUpload upload = new ServletFileUpload(factory);  
	        //����ϴ��ļ�������������  
	        upload.setHeaderEncoding("UTF-8");   
	        factory.setSizeThreshold(1024 * 500);//�����ڴ���ٽ�ֵΪ500K  
	        File linshi = new File("E:\\linshi");//������500K��ʱ�򣬴浽һ����ʱ�ļ�����  
	        factory.setRepository(linshi);  
	        upload.setSizeMax(1024 * 1024 * 5);//�����ϴ����ļ��ܵĴ�С���ܳ���5M  
	        try {  
	            // 1. �õ� FileItem �ļ��� items  
	            List<FileItem> /* FileItem */items = upload.parseRequest(request);  
	  
	            // 2. ���� items:  
	            for (FileItem item : items) {  
	                // ����һ��һ��ı���, ��ӡ��Ϣ  
	                if (item.isFormField()) {  
	                    String name = item.getFieldName();  
	                    String value = item.getString("utf-8");  
	  
	                    System.out.println(name + ": " + value);  
	                      
	                      
	                }  
	                // �����ļ�������ļ����浽 e:\\files Ŀ¼��.  
	                else {  
	                    String fileName = item.getName();  
	                    long sizeInBytes = item.getSize();  
	                    System.out.println(fileName);  
	                    System.out.println(sizeInBytes);  
	  
	                    InputStream in = item.getInputStream();  
	                    byte[] buffer = new byte[1024];  
	                    int len = 0;  
	  
	                    fileName = "e:\\file\\" + fileName;//�ļ������ϴ���λ��  
	                    System.out.println(fileName);  
	                    OutputStream out = new FileOutputStream(fileName);  
	  
	                    while ((len = in.read(buffer)) != -1) {  
	                        out.write(buffer, 0, len);  
	                    }
	                    request.setAttribute("url", fileName);
	  
	                    out.close();  
	                    in.close();  
	                    
	                    request.getRequestDispatcher("/upload.jsp").forward(request, response);
	                }  
	            }  
	  
	        } catch (FileUploadException e) {  
	            e.printStackTrace();  
	        }  
	  
	    }  
}
