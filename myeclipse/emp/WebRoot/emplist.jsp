<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>员工列表</title>
	 <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
  
     <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
  
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
  
  </head>
         
  <body>
      <table id="dg"></table>
      <script type="text/javascript">
       $("#dg").datagrid({
              url:"${pageContext.request.contextPath}/emp/findAll.do?time="+new Date().getTime(),
               columns:[[    
					        {field:'empno',title:'编号',width:100},    
					        {field:'ename',title:'姓名',width:100},    
					        {field:'job',title:'职位',width:100},    
					        {field:'mgr',title:'上司',width:100},    
					        {field:'hiredate',title:'入职日期',width:100,
					            formatter: function (value, row, index) {
                                return formatterdate(value, row);
                             }
					        },    
					        {field:'sal',title:'月薪',width:100},    
					        {field:'comm',title:'佣金',width:100,
					           formatter:function(value){
					              if(value==null){
					                 return 0;
					              }else{
					                 return value;
					              }
					           }
					        
					        }, 
					        
					        
					           
					        {field:'deptno',title:'部门',width:100}   
					         
			    ]],
			    fitColumns:true,
			    singleSelect:true,
			    pagination:true,
			    pageNumber:1,
			    pageSize:9,
			    pageList:[5,9,10],
			    fit:true
       });
       
        function formatterdate(val, row) {
           // alert(val);
		    if (val==null)
		        return '';
		    var format = 'yyyy-MM-dd';
		    var date = new Date(val);
		    Y = date.getFullYear() + '-';
			M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
			D = date.getDate() + ' ';
			newdate=Y+M+D;
			//alert(newdate);
		    return newdate;
    }
      </script>
  </body>
</html>
