<% include '/WEB-INF/includes/header.gtpl' %>
<div class="row">
    <div class="span1">
        <h4>ISBN</h4>
    </div>
    <div class="span3">
        <h4>Title</h4>
    </div>
    <div class="span3">
        <h4>Authors</h4>
    </div>
    <div class="span2">
        <h4>Publisher</h4>
    </div>
</div>
<%
    request.books.each{
        book ->
%>
    <div class="row">
        <div class="span1">
            <%= book.isbn %>
        </div>
        <div class="span3">
            <%= book.title %>
        </div>
        <div class="span3">
            <%= book.authors %>
        </div>
        <div class="span2">
            <%= book.publisher %>
        </div>
        <div class="span2">
            <a href="/book/edit/<%= book.key as String %>">Edit</a>
            <a href="/book/delete/<%= book.key as String %>">Delete</a>
        </div>

    </div>
<%
    }
%>
<% include '/WEB-INF/includes/footer.gtpl' %>

