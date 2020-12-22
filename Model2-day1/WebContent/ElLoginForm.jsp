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
		<h2>로그인</h2>
		<form action="ElLoginProc.jsp" method="post">
			<table width="300" border="1">
				<tr height="40">
					<td width="120">아이디</td>
					<td width="180"><input type="text" name="id"></td>
				</tr>
				<tr height="40">
					<td width="120">비밀번호</td>
					<td width="180"><input type="password" name="pass"></td>
				</tr>
				<tr height="40">
					<td align="center" colspan="2">
					<input type="submit" value="login">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>