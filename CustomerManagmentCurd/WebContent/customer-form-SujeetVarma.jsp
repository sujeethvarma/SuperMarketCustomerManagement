<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

<header style="color:white">
	
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="Customer_list">Customer Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Customer_list">customer</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
	
</header>
<br><br><br>

<div class="container" style="width:50%">

<c:if test="${customer == null}">
	
	<form action="insert" method="post">

	<h2 align="center">Insert Customer</h2>
	<hr>
	

</c:if>

<c:if test="${customer != null}">

	<form action="update" method="post">

	<h2 align="center">Edit Customer</h2>	
	<hr>

</c:if>




<div class="mb-3" hidden>
  <input type="text" value="<c:out value="${customer.id}"></c:out>" class="form-control" id="exampleFormControlInput1" name="tbId">
</div>

<div class="input-group input-group-sm mb-3">
  <span class="input-group-text" id="inputGroup-sizing-sm">NAME</span>
  <input type="text" value="<c:out value="${customer.name}"></c:out>" class="form-control" placeholder="Enter Your Name"  aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="tbName" required>
</div>

<div class="input-group input-group-sm mb-3">
  <span class="input-group-text" id="inputGroup-sizing-sm">EMAIL</span>
  <input type="email" value="<c:out value="${customer.email}"></c:out>" class="form-control" placeholder="Enter Your Email"  aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="tbEmail" required>
</div>

<div class="input-group input-group-sm mb-3">
  <span class="input-group-text" id="inputGroup-sizing-sm">MOBILE</span>
  <input type="text" value="<c:out value="${customer.mobile}"></c:out>" class="form-control" placeholder="Enter Your Mobile No" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="tbMobile" required>
</div>

<div>
	<button class="btn btn-outline-info">Save</button>
</div>

</form>

</div>

</body>
</html>