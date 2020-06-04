<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>DESAFIO Estágio</title>
<body>
	<h2>Lista de Usuários</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${userDetail != null}">
			<h3>Lista de Usuários</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>Data de Nascimento</th>
						<th>Cargo</th>
						<th>Perfil</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${userDetail}">
						<tr>
							<td>${user.id}</td>
							<td>${user.name}</td>
							<td>${user.cpf}</td>
							<td>${user.birthDate}</td>
							<td>${user.role}</td>
							<td>${user.profile}</td>
							<td><a
								href="<%=request.getContextPath()%>/update/user/${user.id}">Update</a>
								  <a
								href="<%=request.getContextPath()%>/delete/user/${user.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        Sem usuários no Banco de Dados!
        </c:otherwise>
	</c:choose>
</body>
</html>