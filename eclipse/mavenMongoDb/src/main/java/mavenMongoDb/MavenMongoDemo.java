package mavenMongoDb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MavenMongoDemo {
   
	 public static void insertOneData() {
	    	// 创建mongo客户端
	          MongoClient cl=new MongoClient("127.0.0.1",27017);
	         MongoDatabase company=cl.getDatabase("company");
	       //插入一条数据
	         MongoCollection<Document> col=company.getCollection("EMP2");
	         Document doc =new Document();
	         
	         doc.append("EMPNO", 6677);
	         doc.append("ENAME","KENcat");
	         doc.append("JOB", "CLERK");
	         doc.append("MGR", "7788");
	         doc.append("HIREDATE", "1982-03-02");	
	         doc.append("SAL", 1000);
	         doc.append("COMM", 0);
	         doc.append("DEPTNO", 20);
	         col.insertOne(doc);
	         
	     }
	     
	     public static void insertManyDatas() {
	     	// 创建mongo客户端
	           MongoClient cl=new MongoClient("127.0.0.1",27017);
	          MongoDatabase company=cl.getDatabase("company");
	        //   //获取集合
	          MongoCollection<Document> col=company.getCollection("EMP2");
	          Document doc    =new Document();
	          Document doc2  =new Document();
	          Document doc3  =new Document();
	          Document doc4  =new Document();
	          Document doc5 =new Document();
	          Document doc6  =new Document();
	          Document doc7  =new Document();
	          Document doc8  =new Document();
	          Document doc9 =new Document();
	          List<Document> listdoc=new ArrayList<Document>();
	          doc.append("EMPNO", 6000).append("ENAME","KEN").append("JOB", "CLERK").append("MGR", "7788").append("HIREDATE", "1982-03-02").append("SAL", 1000).append("COMM", 0).append("DEPTNO", 20);
	          listdoc.add(doc);
	          
	          doc2.append("EMPNO", 6001).append("ENAME","KURSLEY").append("JOB", "CLERK").append("MGR", "7788").append("HIREDATE", "1982-01-02").append("SAL", 900).append("COMM", 50).append("DEPTNO", 20);
	          listdoc.add(doc2);
	          
	          doc3.append("EMPNO", 6002).append("ENAME","ASHLY").append("JOB", "CLEANER").append("MGR", "7788").append("HIREDATE", "1982-03-12").append("SAL", 1100).append("COMM", 0).append("DEPTNO", 20);
	          listdoc.add(doc3);
	   
	          doc4.append("EMPNO", 6003).append("ENAME","KENDALL").append("JOB", "CLERK").append("MGR", "7788").append("HIREDATE", "1982-03-02").append("SAL", 1000).append("COMM", 0).append("DEPTNO", 20);
	          listdoc.add(doc4);
	          
	          doc5.append("EMPNO", 6004).append("ENAME","BENSON").append("JOB", "CLERK").append("MGR", "7788").append("HIREDATE", "1982-03-02").append("SAL", 1000).append("COMM", 0).append("DEPTNO", 20);
	          listdoc.add(doc5);
	          doc6.append("EMPNO", 6005).append("ENAME","SCOTT").append("JOB", "CLERK").append("MGR", "7788").append("HIREDATE", "1982-01-02").append("SAL", 900).append("COMM", 50).append("DEPTNO", 20);
	          listdoc.add(doc6);
	          
	          doc7.append("EMPNO", 6006).append("ENAME","RICKY").append("JOB", "CLEANER").append("MGR", "7788").append("HIREDATE", "1982-03-12").append("SAL", 1100).append("COMM", 0).append("DEPTNO", 20);
	          listdoc.add(doc7);
	   
	          doc8.append("EMPNO", 6007).append("ENAME","RANDALL").append("JOB", "CLERK").append("MGR", "7788").append("HIREDATE", "1982-03-02").append("SAL", 1000).append("COMM", 0).append("DEPTNO", 20);
	          listdoc.add(doc8);
	          
	          doc9.append("EMPNO", 6008).append("ENAME","WENSON").append("JOB", "CLERK").append("MGR", "7788").append("HIREDATE", "1982-03-02").append("SAL", 1000).append("COMM", 0).append("DEPTNO", 20);
	          listdoc.add(doc9);
	          
	          col.insertMany(listdoc);
	          
	      }
	     
	     public static void UpdateData() {
	     	// 创建mongo客户端
	           MongoClient cl=new MongoClient("127.0.0.1",27017);
	          MongoDatabase company=cl.getDatabase("company");
	        //   //获取集合
	          MongoCollection<Document> col=company.getCollection("EMP2");
	          Document doc =new Document();
	           //doc.append("ENAME", "KINGSLEY");
	          doc.append("EMPNO", 6001).append("ENAME","KINGSLEY").append("JOB", "CLERK").append("MGR", "7788").append("HIREDATE", "1982-03-02").append("SAL", 1000).append("COMM", 0).append("DEPTNO", 20);
	          
	          //修改第二条数据的ENAME为“Kingsley”
	           
	          col.updateOne(Filters.eq("EMPNO", 6001), new Document("$set",  doc));
	          
	      }
	     public static void delData() {
	      	// 创建mongo客户端
	            MongoClient cl=new MongoClient("127.0.0.1",27017);
	           MongoDatabase company=cl.getDatabase("company");
	         //获取集合
	           MongoCollection<Document> col=company.getCollection("EMP2");
	           col.deleteOne(Filters.eq("EMPNO",6677));
	           
	     }
	     
	     public static void findAll() {
	    		// 创建mongo客户端
	         MongoClient cl=new MongoClient("127.0.0.1",27017);
	        MongoDatabase company=cl.getDatabase("company");
	      //获取集合
	        MongoCollection<Document> col=company.getCollection("EMP2");
	    	 FindIterable<Document> docs = col.find();
	    	 MongoCursor<Document> iterator = docs.iterator();
	    	 while(iterator.hasNext()) {
	    		 
	    		 Document d=iterator.next();
	    		 System.out.println(d.get("EMPNO") + " : => >>" +d.get("ENAME"));
	    	 }
	     }
	     
	     public static void findByNum(int num) {
	 		// 创建mongo客户端
	      MongoClient cl=new MongoClient("127.0.0.1",27017);
	     MongoDatabase company=cl.getDatabase("company");
	   //获取集合
	     MongoCollection<Document> col=company.getCollection("EMP2");
	     
	 	 FindIterable<Document> docs = col.find(Filters.eq("EMPNO",num));
	 	 MongoCursor<Document> iterator = docs.iterator();
	 	 while(iterator.hasNext()) {
	 		 
	 		 Document d=iterator.next();
	 		 System.out.println(d.get("EMPNO") + " : => >>" +d.get("ENAME"));
	 	 }
	 	 
	  }
	     
}
