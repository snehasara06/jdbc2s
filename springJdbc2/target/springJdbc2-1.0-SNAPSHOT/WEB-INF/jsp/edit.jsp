<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <h1>Edit </h1>
        <form:form method="POST" action="/edit">
            <table>
                <tr>
                    <td></td>
                    <td>
                        <form:hidden path="id" />
                    </td>
                </tr>
                <tr>
                    <td>Name : </td>
                    <td>
                        <form:input path="name" />
                    </td>
                </tr>
                <tr>
                    <td>Type :</td>
                    <td>
                        <form:input path="type" />
                    </td>
                </tr>
                <tr>
                    <td>Fuel :</td>
                    <td>
                        <form:input path="fuel" />
                    </td>
                </tr>
                <tr>
                    <td>Price :</td>
                    <td>
                        <form:input path="price" />
                    </td>
                </tr>
                <tr>
                    <td>Seater :</td>
                    <td>
                        <form:input path="seater" />
                    </td>
                </tr>
                <tr>
                    <td> </td>
                    <td><input type="submit" value="Edit" /></td>
                </tr>
            </table>
        </form:form>