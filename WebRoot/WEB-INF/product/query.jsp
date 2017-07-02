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
 			    url:'product_queryJoinCategory.action', 
 			    loadMsg:'请等待',
 			    queryParams:{name:''},
 			    idField:'id',
 			   	striped:true,
 			  	nowrap:true,
 			  	fitColumns:true,
 			  	pagination:true,
 			  	pageSize:5,
 			  	pageList:[5,10,15,20],
 			  	toolbar: [{
 					iconCls: 'icon-add',
 					text:'添加商品',
 					handler: function(){
	 			  		parent.$("#win").window({
							title:'添加商品',
							width:500,
							height:600,
							content:'<iframe src="send_product_save.action" frameborder="0" width="100%" height="100%" />'
						});
 					}
 				},'-',{
 					iconCls: 'icon-edit',
 					text:'更新商品',
 					handler: function(){
					}
 				},'-',{
 					iconCls: 'icon-remove',
 					text:'删除类别',
 					handler: function(){
 					}
 				},'-',{
 					text:"<input id='ss' name='search' />"
 				}],
 			  	frozenColumns:[[
 					{field:'xyz',checkbox:true},
 					{field:'id',title:'商品编号',width:100}
 		 		]],		  	  
 			    columns:[[ 
 			        {field:'name',title:'商品名称',width:200},    
 			        {field:'remark',title:'简单介绍',width:300},
 			       	{field:'category.type',title:'所属类别',width:200,
 	 			       	formatter: function(value,row,index){
							if(row.category!=null && row.category.type!=null){
								return row.category.type;
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
