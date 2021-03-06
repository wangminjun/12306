<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>
<link href="static/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<script src="static/jquery.js"></script>
<script src="static/bootstrap.min.js"></script>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3>
				${uuser.name}的订单
			</h3>
			<table class="table">
				<thead>
					<tr>
						<th>
							订单编号
						</th>
						<th>
							订单状态
						</th>
						<th>
							购买时间
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="orders" items="${ordersListFormService}">
					<tr>
						<td>${orders.id}</td>
						<td>${orders.status==1?"已支付":"未支付"}</td>
						<td>${orders.maketime}</td>
						<td>
							<a href='${pageContext.request.contextPath}/orders_delete.action?id=${orders.id}'
							onclick="return confirm('确定要删除吗?')">
							删除订单</a><br/>
							<a href="${pageContext.request.contextPath}/orders_findByInfo.action?id=${orders.id}">
							查看详情</a>
						</td>
					</tr>
				</c:forEach>
					<tr>
						<td colspan="4">
							<a href="${pageContext.request.contextPath}/index.jsp" 
							class="btn btn-primary btn-large" type="button">继续购票</a>
						</td>
					</tr>
				</tbody>
			</table>
			<ul class="pagination pagination-lg">
				<li>
					 <a href="#">Prev</a>
				</li>
				<li>
					 <a href="#">1</a>
				</li>
				<li>
					 <a href="#">2</a>
				</li>
				<li>
					 <a href="#">3</a>
				</li>
				<li>
					 <a href="#">4</a>
				</li>
				<li>
					 <a href="#">5</a>
				</li>
				<li>
					 <a href="#">Next</a>
				</li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>