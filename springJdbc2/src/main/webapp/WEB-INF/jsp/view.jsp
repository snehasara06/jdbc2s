<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <h1>Morris Garage List</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Type</th>
                <th>Fuel</th>
                <th>Price</th>
                <th>Seater</th>
            </tr>
            <c:forEach var="car" items="${carList}">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.name}</td>
                    <td>${car.type}</td>
                    <td>${car.fuel}</td>
                    <td>${car.price}</td>
                    <td>${car.seater}</td>


                    <td><a href="edit/${car.id}">Edit</a></td>
                    <td><a href="delete/${car.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br />
        <a href="add">Add New Laptop</a>