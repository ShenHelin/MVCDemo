<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>显示所有商品</title>
</head>
<body>
	<h3>Welcome ${sessionScope.username }!</h3>

	<h3>商品列表如下：</h3>

	<table border="1">
		<tr>
			<td>员工编号</td>
			<td>员工姓名</td>
			<td>岗位</td>
			<td>入职日期</td>
			<td>直接领导</td>
			<td>工资</td>
			<td>奖金</td>
			<td>部门</td>
		</tr>
		<c:forEach items="${empListFromServer}" var="emp">
		<tr>
			<td>${emp.empno }</td>
			<td>${emp.ename }</td>
			<td>${emp.job }</td>
			<td>${emp.hiredate }</td>
			<td>${emp.mgr }</td>
			<td>${emp.sal }</td>
			<td>${emp.comm }</td>
			<td>${emp.deptno }</td>
			<td>
			<a href="${pageContext.request.contextPath }/emp_delete.action?empno=${emp.empno }" onClick="return confirm('确认删除吗？');">删除</a>
			<a href="${pageContext.request.contextPath }/emp_find_findById.action?empno=${emp.empno}&option=update">修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<br/>
	<br/>
	<a href="${pageContext.request.contextPath }/emp_save.jsp">增加新商品</a>
	<br/>
	<br/>
	<form method="post" action="${pageContext.request.contextPath }/emp_find_findById.action">
	员工编号:<input type="number" name="empno" value="1">
	<input type="submit" value="精确查询">
	</form>
	<br/>
	<br/>
	<form method="post" action="${pageContext.request.contextPath }/emp_find_findByName.action">
	员工姓名:<input type="text" name="ename" value="F">
	<input type="submit" value="模糊查询">
	</form>
</body>
</html>