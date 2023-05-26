        <%@ include file="common/header.jspf" %>
        <%@ include file="common/navigation.jspf" %>
    
        <div class="container">
      
            <h1>Enter Todo Details</h1>
            <form:form method="post" modelAttribute = "todo">
                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" path="description" required="required"/> 
                    <form:errors path="description" cssClass = "text-warning"/>
                    
                </fieldset>
                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="date" path="targetDate" required="required"/> 
                    <form:errors path="targetDate" cssClass = "text-warning"/>
                    
                </fieldset>
                <form:input type="hidden" path="done"/> 
                <form:input type="hidden" path="id" /> 
                <input type="submit" class="btn btn-success"/>
            </form:form>
   
            <%@ include file="common/footer.jspf" %>