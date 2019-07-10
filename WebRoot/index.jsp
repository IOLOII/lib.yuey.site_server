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
    margin-top: 7%;
    width:100%;
      font-weight:1000;
		animation: move 2s linear infinite;
		/*background-image: linear-gradient(to right, #fe8a71, #f6cd61, #3da4ab, #0e9aa7, #fe8a71);*/
		background-size: 200% auto;
		font-size: 82px;
		letter-spacing: 1px;
		-webkit-background-clip: text;
		-webkit-text-fill-color: transparent;
		text-align: center;
      background-color: wheat;
	}    
        .ignitionText3 {
   position: fixed;
    /* margin-top:15%;*/
    width:100%;
      font-weight:1000;
		animation: move 2s linear infinite;
		/*background-image: linear-gradient(to right, #fe8a71, #f6cd61, #3da4ab, #0e9aa7, #fe8a71);*/
		background-size: 200% auto;
		font-size: 42px;
		letter-spacing: 1px;
		-webkit-background-clip: text;
		-webkit-text-fill-color: transparent;
		text-align: right;
      background-color: wheat;
	}    
	.ignitionText2 {
	/*position: fixed;
    top: 43.5%;*/
      margin-top:-45px;
    	width:100%;
      	       height: 98%;
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
		    <div>
        	<div class="ignitionText2">                      	<div class="ignitionText">
          		☞&nbsp;lib.yuey.site		  
			</div>
        	&nbsp;
			</div>
                      	<div class="ignitionText3">
          		yuey&nbsp;		  
			</div>
		</div>
  </body>
</html>
