package org.kenny.app2_09;

import java.util.Date;
import java.util.List; 

import oracle.net.aso.b;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 

@Controller
@RequestMapping(value="/emp")
public class EmpAction{
	
	  public EmpAction(){}
	  
	  @RequestMapping(value="/find")
	  public String findEmpById(int id,Model model) throws Exception{
		   System.out.println("查询"+id+"号员工信息"); 
		   //转发到EmpAction的另外一个方法中去，即再发一次请求
		  //return "forward:/emp/update.action";
		   //重定向EmpAction的另外一个方法中去，即再发一次请求 
		   //注意：重定向请必须将id设置到model对象，否则报错！！！
		   model.addAttribute("id", id);
		return "redirect:/emp/update.action";
		
	}
	  @RequestMapping(value="/update")
	  public String updateEmpById(int id,Model model) throws Exception{
		  System.out.println("更新"+id+"号员工信息"); 
		  model.addAttribute("message", "更新员工成功");
		  return "/jsp/addsuccess.jsp";
		  
	  }
      
  }
    

