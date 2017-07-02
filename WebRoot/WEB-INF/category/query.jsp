<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<%@ include file="/public/head.jspf" %>
 	<style type="text/css">
 		body{
 			margin: 1px;
 		}
 		.searchbox{
 			margin: -3;
 		}
 	</style>
 	<script type="text/javascript">
 		$(function(){
 			$('#dg').datagrid({    
 			    url:'category_queryJoinAccount.action', 
 			    loadMsg:'请等待',
 			    queryParams:{type:''},
 			    idField:'id',
 			   	striped:true,
 			  	nowrap:true,
 			  	fitColumns:true,
 			  	pagination:true,
 			  	pageSize:5,
 			  	pageList:[5,10,15,20],
 			  	toolbar: [{
 					iconCls: 'icon-add',
 					text:'添加类别',
 					handler: function(){
						parent.$("#win").window({
							title:'添加类别',
							width:400,
							height:300,
							content:'<iframe src="send_category_save.action" frameborder="0" width="100%" height="100%" />'
						});
 					}
 				},'-',{
 					iconCls: 'icon-edit',
 					text:'更新类别',
 					handler: function(){
 						var rows=$("#dg").datagrid("getSelections");
 						if(rows.length!=1){
							$.messager.show({
								title:'错误提示',
								msg:'只能更新一条记录',
								timeout:2000,
								showType:'slide'
							});							
						}else{
							parent.$("#win").window({
								title:'更新类别',
								width:320,
								height:250,
								content:'<iframe src="send_category_update.action" frameborder="0" width="100%" height="100%" />'
							});
						}
					}
 				},'-',{
 					iconCls: 'icon-remove',
 					text:'删除类别',
 					handler: function(){
						var rows=$("#dg").datagrid("getSelections");
						if(rows.length==0){
							$.messager.show({
								title:'错误提示',
								msg:'至少选择一条记录',
								timeout:2000,
								showType:'slide'
							});							
						}else{
							$.messager.confirm('删除确认对话框', '你确定要删除选中记录吗？', function(r){
								if (r){
								   var ids="";
								   for(var i=0;i<rows.length;i++){
										ids += rows[i].id+",";
									}
									ids = ids.substring(0,ids.lastIndexOf(","));
									$.post("category_deleteByIds.action",{ids:ids},function(result){
										if(result=="true"){
											$("#dg").datagrid("uncheckAll");
											$("#dg").datagrid("reload");
										}else{
											$.messager.show({
												title:'删除失败',
												msg:'请检查删除操作',
												timeout:2000,
												showType:'slide'
											});		
										}
									},"text")
								}
							});
						}
 					}
 				},'-',{
 					text:"<input id='ss' name='search' />"
 				}],
 			  	frozenColumns:[[
 					{field:'xyz',checkbox:true},
 					{field:'id',title:'编号',width:100}
 		 		]],		  	  
 			    columns:[[    
 			   
 			        {field:'type',title:'类别名称',width:100,
						formatter: function(value,row,index){
							return "<span title="+value+">"+value+"</span>";
						}
 	 			     },    
 			        {field:'hot',title:'热点',width:100,align:'right',
 	 			    	formatter: function(value,row,index){
							if(value){
								return "<input type='checkbox' checked='checked' disabled='true' />";
							}else{
								return "<input type='checkbox' disabled='true' />";
							}
						}
  	 			     },
 			       	{field:'account.login',title:'所属管理员',width:100,
 	 			       	formatter: function(value,row,index){
							if(row.account!=null && row.account.login!=null){
								return row.account.login;
							}
						}
					}   
 			    ]]    
 			}); 
 			$('#ss').searchbox({
				searcher:function(value,name){
	 				$('#dg').datagrid('load',{type: value});
				},
				prompt:'变形金刚'
 	 		});
 	 	});
 	</script>
  </head>
  
  <body>
   	<table id="dg"></table>
  </body>
</html>
