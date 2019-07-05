<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>YUEY</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="YUEY">
  <style>
  body,p{
  margin: 0;
  padding:0;
  }
    .ignitionText {
    position: fixed;
    top: 38%;
    width:100%;
		animation: move 2s linear infinite;
		background-image: linear-gradient(to right, #fe8a71, #f6cd61, #3da4ab, #0e9aa7, #fe8a71);
		background-size: 200% auto;
		font-size: 60px;
		letter-spacing: 1px;
		-webkit-background-clip: text;
		-webkit-text-fill-color: transparent;
		text-align: center;
	}
	.ignitionText2 {
	position: fixed;
    top: 43.5%;
    width:100%;
		animation: move 2s linear infinite;
		background-image: linear-gradient(to right, #fe8a71, #f6cd61, #3da4ab, #0e9aa7, #fe8a71);
		background-size: 200% auto;
		line-height: 11;
		-webkit-text-fill-color: transparent;
	}
    @keyframes move {
		/*0%{background-position:0 ;}
		 100%{background-position:-200% ;}*/
		to {
			background-position: 200% center;
			}
	}
  </style>
  </head>
  <body style="background-color:#000;">
        	<div class="ignitionText">
          		yuey.site		  
			</div>
		    	<div>
        	<div class="ignitionText2">
        	&nbsp;
			</div>
		</div>
  </body>
</html>
