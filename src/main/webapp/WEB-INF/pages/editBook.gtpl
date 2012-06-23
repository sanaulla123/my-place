<% include '/WEB-INF/includes/header.gtpl' %>
<h3>Edit Book</h3>
<form action="/book" method="PUT">
    <div class="row">
        <div class="span5">
            <label for="isbn"/>ISBN</label>
            <input id="isbn" type="text" name="isbn"
                   value="<%= request.book?.isbn %>"/>

            <label for="title"/>Title</label>
            <input id="title" type="text" name="title"
                   value="<%= request.book?.title %>"/>

            <label for="authors"/>Author(s)</label>
            <input id="authors" type="text" name="authors"
                   value="<%= request.book?.authors %>"/>

            <label for="publisher"/>Publisher</label>
            <input id="publisher" type="text" name="publisher"
                   value="<%= request.book?.publisher %>"/>

            <label for="numberOfPages"/>Number of Pages</label>
            <input id="numberOfPages" type="text" name="numberOfPages"
                   value="<%= request.book?.numberOfPages %>"/>
        </div>
    </div>
    <div class="row">
        <div class="span4">
            <input type="submit" value="Save">
            <input type="reset" value="Reset">
        </div>
    </div>
</form>
<% include '/WEB-INF/includes/footer.gtpl' %>

