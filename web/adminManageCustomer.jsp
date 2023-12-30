<% request.setAttribute("pageTitle", "Manage Customer - MyShop");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="_adminHeader.jsp" %>
<h1 class="mb-5">View Customers</h1>
<table class="table mt-3">
    <thead>
        <tr>
            <th scope="col">Customer ID</th>
            <th scope="col">Full Name</th>
            <th scope="col">Address</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
        </tr>
    </thead>
    <tbody>

        <c:forEach items="${requestScope.customerList}" var="customer">
            <tr>
                <td>${customer.customerID}</td>
                <td>${customer.fullName}</td>
                <td>${customer.address}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
            </tr>
        </c:forEach>


    </tbody>
</table>

<%@ include file="_adminFooter.jsp" %>
