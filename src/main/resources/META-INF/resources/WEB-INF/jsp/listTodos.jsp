
        <%@ include file="common/header.jspf" %>
       <%@ include file="common/navigation.jspf" %>
        <div class="container">
      
    <table class="table">
        <thead> 
            <tr>
                
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
       <c:forEach items="${todos}" var="todo">
            <tr>
               
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href ="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
            </tr>
       </c:forEach>
    </table>
        <a href="add-todo" class="btn btn-success">Add Todo</a>
        <%@ include file="common/footer.jspf" %>