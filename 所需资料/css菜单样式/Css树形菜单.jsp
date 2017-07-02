<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
	<style type="text/css">
		/* 修改页面的背景颜色 */
		body {
			background-color: #ffdee0;
		}
		/* 设置div盒子的宽度, 和相应的字体信息 */
		#navigation {
			width: 200px;
			font-family: Arial, Helvetica, sans-serif;
		}
		/* 设置盒子里面的 ul */
		#navigation ul {
			list-style-type: none;
			margin: 0px;
			padding: 0px;
		}
		/* 设置ul 里面每个li的样式 */
		#navigation li {
			border-bottom: 1px solid #ed9f9f;
		}
		/* 设置 a标签的初始样式,对a标签的伪类样式都有效 */
		#navigation li a {
			display: block;
			padding: 5px 5px 5px 0.5em;
			text-decoration: none;
			border-left: 12px solid #711515;
		}
		/* 重新设置  a:link a:visited样式 */
		#navigation li a:link,#navigation li a:visited {
			background-color: #c11136;
			color: #ffffff;
		}
	</style>
</head>

<body>
	<div id="navigation">
		<ul>
			<li><a href="#">首页 </a></li>
			<li><a href="#">关于 </a></li>
			<li><a href="#"> 日志 </a></li>
			<li><a href="#"> 相册 </a></li>
			<li><a href="#"> 留言版 </a></li>
			<li><a href="#"> 联系我 </a></li>
		</ul>
	</div>
</body>
</html>
