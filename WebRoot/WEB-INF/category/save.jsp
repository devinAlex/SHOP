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
			$("input[name=type]").validatebox({
				required:true,
				missingMessage:'请输入类别名称'
			});
			$("#ff").form("disableValidation");
			$("#btn").click(function(){
				$("#ff").form("enableValidation");
				if($("#ff").form("validate")){
					$("#ff").form('submit',{
						url:'category_save.action',
						success: function(){
							parent.$("#win").window("close");
							//浏览器兼容性问题 无法正常执行  dom-->jquery-->easyui
							//parent.$("iframe[title='类别管理']").contents().find("#dg").datagrid("reload");
							parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg").datagrid("reload");
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
   	 <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add' ">添加</a>   
	</div>
	</form>  
  </body>
</html>
