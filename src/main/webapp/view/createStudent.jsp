<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <!-- Font Awesome -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
  <!-- MDB -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet" />
  <style>
    body {
      background-color: #fbfbfb;
    }

    @media (min-width: 991.98px) {
      main {
        padding-left: 240px;
      }
    }

    /* Sidebar */
    .sidebar {
      position: fixed;
      top: 0;
      bottom: 0;
      left: 0;
      padding: 58px 0 0;
      /* Height of navbar */
      box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
      width: 240px;
      z-index: 600;
    }

    @media (max-width: 991.98px) {
      .sidebar {
        width: 100%;
      }
    }

    .sidebar .active {
      border-radius: 5px;
      box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
    }

    .sidebar-sticky {
      position: relative;
      top: 0;
      height: calc(100vh - 48px);
      padding-top: 0.5rem;
      overflow-x: hidden;
      overflow-y: auto;
      /* Scrollable contents if viewport is shorter than content. */
    }

    .hiddenDate {
      visibility: hidden;
    }
  </style>
</head>

<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <!-- Container wrapper -->
  <div class="container">
    <!-- Navbar brand -->
    <a class="navbar-brand me-2" href="https://mdbgo.com/">
      <img src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp" height="16" alt="MDB Logo"
           loading="lazy" style="margin-top: -1px;" />
    </a>

    <!-- Toggle button -->
    <button class="navbar-toggler" type="button" data-mdb-toggle="collapse"
            data-mdb-target="#navbarButtonsExample" aria-controls="navbarButtonsExample" aria-expanded="false"
            aria-label="Toggle navigation">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarButtonsExample">
      <!-- Left links -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="#">Ticket Booking</a>
        </li>
      </ul>
      <!-- Left links -->

      <div class="d-flex align-items-center">
        <a href="/login" type="button" class="btn btn-link px-3 me-2">
          Login
        </a>
        <a href="/register" type="button" class="btn btn-primary me-3">
          Sign up for free
        </a>

      </div>
    </div>
    <!-- Collapsible wrapper -->
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->
<div class="container mt-5 py-5">
  <div class="row justify-content-center p-5 bg-body shadow rounded border-info border">
    <div class="mb-4 text-center"><a href="/student?action=view" class="btn btn-primary col-2">List Student</a></div>
    <h3 class="text-center my-4">New Student</h3>
    <c:if test="${success}">
      <c:choose>
        <c:when test="${success == true}">
          <div class="alert alert-success p-2 m-0" id="mesenger" role="alert">
            Create student success
          </div>
          <script>
            var clearMesenger = setTimeout(() => {
              var mesenger = document.getElementById("mesenger");
              mesenger.style.visibility = "hidden"
            }, 1000)
          </script>
        </c:when>
        <c:otherwise>
          <div class="alert alert-warning p-2 m-0" id="mesenger" role="alert">
            Name char 50, phone <= 10, Address <=100, Email <= 50
          </div>
          <script>
            var clearMesenger = setTimeout(() => {
              var mesenger = document.getElementById("mesenger");
              mesenger.style.visibility = "hidden"
            }, 1000)
          </script>
        </c:otherwise>
      </c:choose>
    </c:if>
    <div class="col-8">
      <form action="/student?action=create" method="post">
        <div class="form-outline mt-3">
          <input type="text" id="name" name="name" class="form-control"/>
          <label class="form-label" for="name">Name</label>
        </div>
        <div class="form-outline mt-3">
          <input type="date" id="dateOfBirth" name="dateOfBirth" class="form-control"/>
          <label class="form-label" for="dateOfBirth">Date of birth</label>
        </div>
        <div class="form-outline mt-3">
          <input type="text" id="address" name="address" class="form-control"/>
          <label class="form-label" for="address">Address</label>
        </div>
        <div class="form-outline mt-3">
          <input type="text" id="phoneNumber" name="phoneNumber" class="form-control"/>
          <label class="form-label" for="phoneNumber">Phone Number</label>
        </div>
        <div class="form-outline mt-3">
          <input type="text" id="email" name="email" class="form-control"/>
          <label class="form-label" for="email">Email</label>
        </div>
        <select class="form-select mt-3" aria-label="Default select example" name="cId">
          <c:forEach items="${elementListMin}" var="element">
            <option value="${element.getId()}">${element.getName()}</option>
          </c:forEach>
        </select>
        <div class="button-submit text-center mt-3">
          <button type="submit" class="btn btn-primary btn-rounded mt-3 ">Create</button>
        </div>
      </form>
    </div>

  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<!-- MDB -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>

</html>