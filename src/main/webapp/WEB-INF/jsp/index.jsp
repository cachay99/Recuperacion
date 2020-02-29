<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>

<title>Insertar datos del personaje o raza</title>
</head>
<body>
	<div class="card-deck">
		<div class="card col-lg-4 col-md-6 col-7">
			<div class="card-body">
				<h4 class="card-title">Insertar personaje</h4>
				<form:form action="insertCharacter" method="post">
					<label>Nombre:</label> <input type="text" name="name"> <br />
					<label>Portador:</label> <select
						class="custom-select col-lg-6 col-md-6 col-6" name="carrier">
						<option value="SI">SI</option>
						<option value="NO">NO</option>
					</select> <br /> <label>Codigo Raza:</label> <input type="text" name="codRace">
					<br />
					<input type="submit" class="btn btn-primary"
						value="Insertar personaje">
				</form:form>
				<br />
				<form action="listcharacters" method="post">
					<input class="btn btn-success" type="submit"
						value="Ver el listado de personajes">
				</form>
			</div>
		</div>

		<div class="card col-lg-4 col-md-6 col-7" style="height: fit-content;">
			<div class="card-body">
				<h4 class="card-title">Insertar raza</h4>
				<form:form action="insertRace" method="post">
					<label>Raza:</label> <input type="text" name="specie"><br />
					<input class="btn btn-primary" type="submit" value="Insertar raza">
				</form:form>
				<br />
				<form action="listraces" method="post">
					<input class="btn btn-success" type="submit"
						value="Ver el listado de razas">
				</form>
			</div>
		</div>
	</div>
</body>
</html>