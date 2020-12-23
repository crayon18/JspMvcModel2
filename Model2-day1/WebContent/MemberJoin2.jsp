<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<center>
	<h2>회원가입</h2>
	<form action="Mproc2" method="post">
	<table width="400" border="1">
		<tr height="40">
			<td align="center" width="150">아이디</td>
			<td align="center" width="250"><input type="text" name="id"></td>
		</tr>
		<tr height="40">
			<td align="center" width="150">패스워드</td>
			<td align="center" width="250"><input type="password" name="password"></td>
		</tr>
		<tr height="40">
			<td align="center" width="150">이메일</td>
			<td align="center" width="250"><input type="email" name="email"></td>
		</tr>
		<tr height="40">
			<td align="center" width="150">전화번호</td>
			<td align="center" width="250"><input type="tel" name="tel"></td>
		</tr>
		<tr height="40">
			<td align="center" width="150">주소</td>
			<td align="center" width="250"><input type="text" name="address"></td>
		</tr>
		<tr height="40">
			<td colspan="2" align="center"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
	</form>
	</center>

</body>
</html>