<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
  <head>
 	<%@ include file="/public/head.jspf" %>
 	<style type="text/css">
 		form div{
 			margin: 5px;
 		}
 	</style>
 	<script type="text/javascript">
 		$(function(){
 	 		var dg = parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");

 	 		$('#cc').combobox({    
 	 		    url:'account_query.action',    
 	 		    valueField:'id',    
 	 		    textField:'login',
 	 		    panelHeight:'auto',
 	 		    panelWidth:120,
 	 		    width:120,
 	 		    editable:false  
 	 		});  
 	 		 	 		
 	 		var rows = dg.datagrid("getSelections");
 	 		$('#ff').form('load',{
 	 			id:rows[0].id,
 	 			type:rows[0].type,
 	 			hot:rows[0].hot,
 	 			'account.id':rows[0].account.id
 	 		});

 	 		 	 		
			$("input[name=type]").validatebox({
				required:true,
				missingMessage:'请输入类别名称'
			});
			$("#ff").form("disableValidation");
			$("#btn").click(function(){
				$("#ff").form("enableValidation");
				if($("#ff").form("validate")){
					$("#ff").form('submit',{
						url:'category_update.action',
						success: function(){
							parent.$("#win").window("close");
							dg.datagrid("reload");
						}
					});
				}
				
			});
 	 	});
 	</script>
  </head>
  
  <body>
   	<form id="ff" method="post">   
    <div>   
        <label for="type">类别名称:</label>   
        <input class="easyui-validatebox" type="text" name="type" />   
    </div>   
    <div>   
        <label for="hot">热点:</label>  
		       <input type="radio" name="hot" value="true" /> 热点
		        <input type="radio" name="hot" value="false" checked="checked" /> 非热点
    </div> 
    <div>
    	<label for="type">所属管理员:</label>
    	<input id="cc" name="account.id" /> 
    	  
    </div>
    <div>
   	 <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit' ">更新</a>   
	 <input type="hidden" name="id" />
	</div>
	</form>  
  </body>
</html>
