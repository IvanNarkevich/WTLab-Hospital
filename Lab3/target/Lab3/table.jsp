<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 16.12.2019
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hospital</title>
</head>
<body>
<table>
    <caption>Departments</caption>
    <tr>
        <th align="center" width="100">ID</th>
        <th align="center" width="100">Name</th>
    </tr>
    <c:forEach var="department" items="${departments}" >
        <tr>
            <td>${department.ID}</td>
            <td>${department.name}</td>
        </tr>
    </c:forEach>
</table>
<br />
<table>
    <caption>Doctors</caption>
    <tr>
        <th align="center" width="100">ID</th>
        <th align="center" width="100">Name</th>
        <th align="center" width="100">Birth Date</th>
        <th align="center" width="100">Department ID</th>
    </tr>
    <c:forEach items="${doctors}" var="doctor">
        <tr>
            <td>${doctor.ID}</td>
            <td>${doctor.name}</td>
            <td>${doctor.birthDate}</td>
            <td>${doctor.departmentID}</td>
        </tr>
    </c:forEach>
</table>
<br />
<table>
    <caption>Nurses</caption>
    <tr>
        <th align="center" width="100">ID</th>
        <th align="center" width="100">Name</th>
        <th align="center" width="100">Birth Date</th>
        <th align="center" width="100">Department ID</th>
    </tr>
    <c:forEach items="${nurses}" var="nurse">
        <tr>
            <td>${nurse.ID}</td>
            <td>${nurse.name}</td>
            <td>${nurse.birthDate}</td>
            <td>${nurse.departmentID}</td>
        </tr>
    </c:forEach>
</table>
<table>
    <caption>Patients</caption>
    <tr>
        <th align="center" width="100">ID</th>
        <th align="center" width="100">Name</th>
        <th align="center" width="100">Birth Date</th>
        <th align="center" width="100">Admission Date</th>
        <th align="center" width="100">Diagnosis</th>
        <th align="center" width="100">Treatment</th>
        <th align="center" width="100">Doctor ID</th>
        <th align="center" width="100">Department ID</th>
    </tr>
    <c:forEach items="${patients}" var="patient">
        <tr>
            <td><c:out value="${patient.ID}"/></td>
            <td><c:out value="${patient.name}"/></td>
            <td><c:out value="${patient.birthDate}"/></td>
            <td><c:out value="${patient.admissionDate}"/></td>
            <td><c:out value="${patient.diagnosis}"/></td>
            <td><c:out value="${patient.treatment}"/></td>
            <td><c:out value="${patient.doctorID}"/></td>
            <td><c:out value="${patient.departmentID}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
