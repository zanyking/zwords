<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ZWords - remember more difficult words and have fun!</title>
		<z:zkhead/>
		<style type="text/css">
			<%@include file="/resource/messageboard.css" %>
		</style>
	</head>
	<body>
		<div class="container">
			<div class="header"><!-- ********** Header ********** -->
				<h1 id="zk-logo">
					<img src="./resource/top_zk_logo.png" title="ZK Logo" alt="ZK Logo">
				</h1>
				<h1 id="topic">ZWords - remember more difficult words and have fun!</h1>
			</div>
			
			<div class="messages main-block"><!-- ********** left block ********** -->
				 <div class="messageboard-container">
				 	<z:page><!-- ********** Attendees Panel View Ctrl **********-->
					
				 	</z:page>
				 </div>
			</div>
			<div class="users main-block" ><!-- ********** right block ********** -->
				 <z:page><!-- ********** Attendees Panel View Ctrl **********-->
					
				 </z:page>
			</div>
		</div>
	</body>
</html>


