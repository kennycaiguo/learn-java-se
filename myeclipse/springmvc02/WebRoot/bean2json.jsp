<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    
    <title>将JavaBean转换为json返回到浏览器</title>
    <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
  
   <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
  
   <script type="text/javascript" src="js/jquery.min.js"></script>
  
  
   <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  
   <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	 
  </head>
  
  <body>
     <input type="button" value="Emp2json"/><p>
     <input type="button" value="List<Emp>转json"/><p>
     <input type="button" value="Map<String,Object>转json"/><p>
           
       <!-- Map<Emp>2json --> 
  <script type="text/javascript">
    $(":button:eq(2)").click(function(){
         var url="${pageContext.request.contextPath}/emp/map2json.action";
         var sendData=null;
         $.post(url,sendData,function(backData,textStatus,ajax){
              
              alert(ajax.responseText);
           });
    });
  </script>
           
       <!-- List<Emp>2json --> 
  <script type="text/javascript">
    $(":button:eq(1)").click(function(){
         var url="${pageContext.request.contextPath}/emp/listbean2json.action";
         var sendData=null;
         $.post(url,sendData,function(backData,textStatus,ajax){
              
              alert(ajax.responseText);
           });
    });
  </script>
  <!-- Emp2json -->
  <script type="text/javascript">
    $(":button:first").click(function(){
         var url="${pageContext.request.contextPath}/emp/bean2json.action";
         var sendData=null;
         $.post(url,sendData,function(backData,textStatus,ajax){
              //alert(ajax.responseText);
              var hiredate=backData.hiredate;
              var date=new Date(hiredate);
              alert(date.getFullYear()+"年"+(date.getMonth()+1)+"月"+(date.getDate())+"日");
           });
    });
  </script>
  </body>
</html>
