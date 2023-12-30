<% request.setAttribute("pageTitle", "Manage Product - MyShop");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="_adminHeader.jsp" %>
<h1 class="mb-5">Manage Product</h1>
<a href="manage-product/add" class="btn btn-primary">Add Product</a>
<table class="table mt-3">
    <thead>
        <tr>
            <th>Thumbnail</th>
            <th>Name</th>
            <th>Price</th>
            <th>Availability</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${requestScope.productList}" var="product">
            <tr>
                <td><img src="${product.img}" style="width: 100px" /></td>
                <td>${product.name}</td>
                <td>$${product.price}</td>
                <td>${product.availability}</td>
                <td>
                    <a href="../product?id=${product.productID}" class="btn btn-primary" target="_blank">View</a> 
                    <a href="manage-product/edit?id=${product.productID}" class="btn btn-secondary">Edit</a> 
                    <a href="manage-product/delete?id=${product.productID}" class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </tbody>
</table>

<%@ include file="_adminFooter.jsp" %>
