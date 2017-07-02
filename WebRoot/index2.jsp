<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
  </head>
  
  <body>
  	<table width="700" border="0" cellspacing="0" cellpadding="0">
  	<c:forEach items="${applicationScope.bigList}" var="list">
  		<tr>
  			<td colspan="4">${list[0].category.type}</td>
  		</tr>
  		<tr>
  			<td>
  				<table width="100%" border="0" cellspacing="0" cellpadding="0">
  					<tr>
  						<c:forEach items="${list}" var="product">
  						<td>
  							<table width="100%" border="0" cellspacing="0" cellpadding="0">
  								<tr>
  									<td>
  										<img src="${shop}/image/${product.pic}" />
  									</td>
  								</tr>
  								<tr>
  									<td>
  										商品名称：${product.name}
  									</td>
  								</tr>
  								<tr>
  									<td>
  										价格：${product.price}
  									</td>
  								</tr>
  							</table>
  						</td>
  						</c:forEach>
  					</tr>
  					
  				</table>
  			</td>
  		</tr>
  	</c:forEach>
  	</table>
  </body>
</html>
