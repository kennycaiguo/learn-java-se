package cr.kenny.one2many;

import java.util.ArrayList;
import java.util.List;

 

//单方
public class Grade {
	
  
   private Integer id;
   private String name;
   private List<Student> studentList=new ArrayList<Student>();//关联属性
   
   public Grade(){}
   
   public Grade(Integer id, String name, List<Student> studentList) {
	 
	this.id = id;
	this.name = name;
	this.studentList = studentList;
}


public Grade(Integer id, String name) {
 
	this.id = id;
	this.name = name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public List<Student> getStudentList() {
	return studentList;
}
public void setStudentList(List<Student> studentList) {
	this.studentList = studentList;
}
@Override
public String toString() {
	return "Grade [id=" + id + ", name=" + name + "]";
}
 

}
