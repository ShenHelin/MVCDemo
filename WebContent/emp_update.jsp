<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>产品数据更新</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/emp_update.action"
		method="post">
		<table>
			<tr>
				<td>员工编号</td>
				<td>${empFromServer.empno}<!-- 隐藏域 --> <input type="hidden"
					name="empno" value="${empFromServer.empno}"></td>
			</tr>
			<tr>
				<td>员工姓名</td>
				<td><input type="text" name="ename"
					value="${empFromServer.ename}"></td>
			</tr>
			<tr>
				<td>岗位</td>
				<td><input type="text" name="job" value="${empFromServer.job}"></td>
			</tr>
			<tr>
				<td>入职时间</td>
				<td><input type="date" name="hiredate"
					value="${empFromServer.hiredate}"></td>
			</tr>
			<tr>
				<td>上级</td>
				<td><input type="text" name="mgr" value="${empFromServer.mgr}"></td>
			</tr>
			<tr>
				<td>工资</td>
				<td><input type="text" name="sal" value="${empFromServer.sal}"></td>
			</tr>
			<tr>
				<td>奖金</td>
				<td><input type="text" name="comm"
					value="${empFromServer.comm}"></td>
			</tr>
			<tr>
				<td>部门编号</td>
				<td><input type="text" name="deptno"
					value="${empFromServer.deptno}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="更新"></td>
				<td><input type="reset" value="重置" /></td>
			</tr>
		</table>

	</form>
</body>
</html>