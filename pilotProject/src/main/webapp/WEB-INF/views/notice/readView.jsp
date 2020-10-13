<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시판</title>
</head>

<script type="text/javascript">

</script>

<body>

	<div id="root">
		<header>
			<h1>공지사항</h1>
		</header>
		<hr />

		<div>
			<%@include file="nav.jsp"%>
		</div>
		<hr />

		<section id="container">
			<form name="readForm" method="post">
				<input type="hidden" id="n_seq" name="n_seq" value="${selectOne.n_seq}" />
			</form>
			<table>
				<tbody>
					<tr>
						<td><label for="n_title">제목</label><input type="text"
							id="n_title" name="n_title" value="${selectOne.n_title}"
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td><label for="content">내용</label> <textarea id="content"
								name="c_content" readonly="readonly"><c:out
									value="${selectOne.n_content}" /></textarea></td>
					</tr>
					<tr>
						<td><label for="writer">작성자</label><input type="text"
							id="writer" name="w_id" value="${selectOne.id}"
							readonly="readonly" /></td>
					</tr>


					<tr>
						<td><label for="sysdate">작성날짜</label> <fmt:formatDate
								value="${selectOne.n_date}" pattern="yyyy-MM-dd" /></td>
					</tr>
				</tbody>
			</table>


		</section>
		<hr />
	</div>
</body>
</html>

