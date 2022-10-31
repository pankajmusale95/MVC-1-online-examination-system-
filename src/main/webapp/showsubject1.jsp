<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Examination System</title>
<style>
.styled-table {
    border-collapse: collapse;
     border-radius: 10px;
     overflow: hidden;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 15);
    text-align: center;
}

.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}

.styled-table th,
.styled-table td {
    padding: 20px 25px;
    text-align: center;
    
}

.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}

.styled-table tbody tr.active-row {
    font-weight: bold;
    color: #009879;
}
.center {
  margin-left: auto;
  margin-right: auto;
}
button {
        background-color: #000;
        border: .5px solid crimson;
        border-radius: 10px;
        color: #fff;
        padding: 8px;
        box-shadow: 0 0 30px 0 #009879,
                    0 0 30px 0 #009879,
                    0 0 10px 0 #009879 inset;
      }
      
      * {
	margin: 0;
	padding: 0;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
}

body {
	background: #F0F0F0;
	font-size: 15px;
	color: #666;
	font-family: 'Roboto', sans-serif;
}

.content {
	height: 200px;
}

a {
	text-decoration: none;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
	width: 100%;
}

.nav-fostrap {
	display: block;
	margin-bottom: 15px 0;
	background: #03A9F4;
	-webkit-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	-moz-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	-ms-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	-o-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	border-radius: 3px;
}

.nav-fostrap ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	display: block;
}

.nav-fostrap li {
	list-style-type: none;
	margin: 0;
	padding: 0;
	display: inline-block;
	position: relative;
	font-size: 14;
	color: #def1f0;
}

.nav-fostrap li a {
	padding: 15px 20px;
	font-size: 14;
	color: #def1f0;
	display: inline-block;
	outline: 0;
	font-weight: 400;
}

.nav-fostrap li:hover ul.dropdown {
	display: block;
}

.nav-fostrap li ul.dropdown {
	position: absolute;
	display: none;
	width: 200px;
	background: #2980B9;
	-webkit-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	-moz-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	-ms-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	-o-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	padding-top: 0;
}

.nav-fostrap li ul.dropdown li {
	display: block;
	list-style-type: none;
}

.nav-fostrap li ul.dropdown li a {
	padding: 15px 20px;
	font-size: 15px;
	color: #fff;
	display: block;
	font-weight: 400;
}

.nav-fostrap li ul.dropdown li:last-child a {
	border-bottom: none;
}

.nav-fostrap li:hover a {
	background: #2980B9;
	color: #fff !important;
}

.nav-fostrap li:first-child:hover a {
	border-radius: 3px 0 0 3px;
}

.nav-fostrap li ul.dropdown li:hover a {
	background: rgba(0, 0, 0, .1);
}

.nav-fostrap li ul.dropdown li:first-child:hover a {
	border-radius: 0;
}

.nav-fostrap li:hover .arrow-down {
	border-top: 5px solid #fff;
}

.arrow-down {
	width: 0;
	height: 0;
	border-left: 5px solid transparent;
	border-right: 5px solid transparent;
	border-top: 5px solid #def1f0;
	position: relative;
	top: 15px;
	right: -5px;
	content: '';
}

.title-mobile {
	display: none;
}

@media only screen and (max-width:900px) {
	.nav-fostrap {
		background: #fff;
		width: 200px;
		height: 100%;
		display: block;
		position: fixed;
		left: -200px;
		top: 0px;
		-webkit-transition: left 0.25s ease;
		-moz-transition: left 0.25s ease;
		-ms-transition: left 0.25s ease;
		-o-transition: left 0.25s ease;
		transition: left 0.25s ease;
		margin: 0;
		border: 0;
		border-radius: 0;
		overflow-y: auto;
		overflow-x: hidden;
		height: 100%;
	}
	.title-mobile {
		position: fixed;
		display: block;
		top: 10px;
		font-size: 20px;
		left: 100px;
		right: 100px;
		text-align: center;
		color: #FFF;
	}
	.nav-fostrap.visible {
		left: 0px;
		-webkit-transition: left 0.25s ease;
		-moz-transition: left 0.25s ease;
		-ms-transition: left 0.25s ease;
		-o-transition: left 0.25s ease;
		transition: left 0.25s ease;
	}
	.nav-bg-fostrap {
		display: inline-block;
		vertical-align: middle;
		width: 100%;
		height: 50px;
		margin: 0;
		position: absolute;
		top: 0px;
		left: 0px;
		background: #03A9F4;
		padding: 12px 0 0 10px;
		-webkit-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
		-moz-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
		-ms-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
		-o-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
		box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
	}
	.navbar-fostrap {
		display: inline-block;
		vertical-align: middle;
		height: 50px;
		cursor: pointer;
		margin: 0;
		position: absolute;
		top: 0;
		left: 0;
		padding: 12px;
	}
	.navbar-fostrap span {
		height: 2px;
		background: #fff;
		margin: 5px;
		display: block;
		width: 20px;
	}
	.navbar-fostrap span:nth-child(2) {
		width: 20px;
	}
	.navbar-fostrap span:nth-child(3) {
		width: 20px;
	}
	.nav-fostrap ul {
		padding-top: 50px;
	}
	.nav-fostrap li {
		display: block;
	}
	.nav-fostrap li a {
		display: block;
		color: #505050;
		font-weight: 600;
	}
	.nav-fostrap li:first-child:hover a {
		border-radius: 0;
	}
	.nav-fostrap li ul.dropdown {
		position: relative;
	}
	.nav-fostrap li ul.dropdown li a {
		background: #2980B9 !important;
		border-bottom: none;
		color: #fff !important;
	}
	.nav-fostrap li:hover a {
		background: #03A9F4;
		color: #fff !important;
	}
	.nav-fostrap li ul.dropdown li:hover a {
		/* background: rgba(0,0,0,.1); !important; */
		color: #fff !important;
	}
	.nav-fostrap li ul.dropdown li a {
		padding: 10px 10px 10px 30px;
	}
	.nav-fostrap li:hover .arrow-down {
		border-top: 5px solid #fff;
	}
	.arrow-down {
		border-top: 5px solid #505050;
		position: absolute;
		top: 20px;
		right: 10px;
	}
	.cover-bg {
		background: rgba(0, 0, 0, 0.5);
		position: fixed;
		top: 0;
		bottom: 0;
		left: 0;
		right: 0;
	}
}

@media only screen and (max-width:1199px) {
	.container {
		width: 96%;
	}
}

.fixed-top {
	position: fixed;
	top: 0;
	right: 0;
	left: 0;
}

</style>
</head>
<body>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost/batch11"  user="root" password=""/>
<sql:query dataSource="${db}"   var="rs">
select * from question2;
</sql:query>
<marquee>
		<h1>Admin Section</h1>
	</marquee>
	<div id="main">
		<div class="container">
			<div
				style="margin-top: 10px; margin-bottom: 30px; text-align: center;">
				<img src="resources//img//logo.jfif"
					style="width: 100px; margin-bottom: 15px">
				<h2>Online Examination System</h2>
			</div>
			<nav>
				<div class="nav-fostrap">
					<ul>
						<li style="margin-left:260px;"><a href="index.html">Home</a></li>
						<li><a href="#">Student<span
								class="arrow-down"></span></a>
							<ul class="dropdown">
								<li><a href="addstudent.html">Add student</a></li>
								<li><a href="showstudetails.jsp">Show Student Details </a></li>
								</ul></li>
								
						<li><a href="javascript:void(0)">Staff<span
								class="arrow-down"></span></a>
							<ul class="dropdown">
								<li><a href="addstaff.html">Add Staff</a></li>
								<li><a href="showstaffdetails.jsp">Show Staff Details</a></li>
							</ul></li>
						<li><a href="javascript:void(0)">Question Paper<span
								class="arrow-down"></span></a>
							<ul class="dropdown">
								<li><a href="showsubject1.jsp">Java</a></li>
								<li><a href="showsubject2.jsp">HTML</a></li>
							</ul></li>
							<li><a href="javascript:void(0)">Result<span
								class="arrow-down"></span></a>
							<ul class="dropdown">
								<li><a href="showresult1.jsp">Java</a></li>
								<li><a href="showresult2.jsp">HTML</a></li>
							</ul></li>
						
						<li><a href="logout.jsp"><span style="color: black;">Logout</span></a></li>
					</ul>

				</div>
				
			</nav>
			</div>
			</div>
<table class="styled-table center">

 <thead>
        <tr>
            <th>Question No.</th>
            <th>Answer</th>
                        
                       
                        
           </tr>
    </thead>
 <tbody>   
<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.question}"/></td>
<td><c:out value="${table.ans}"/></td>

</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>

