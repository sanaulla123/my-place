<% include '/WEB-INF/includes/header.gtpl' %>
<div class="row">
    <p>Successfully <%=  request.operation %> the book <%= request.savedTitle %></p>
    <p><a href="/book/new">Add another book</a></p>
</div>

<% include '/WEB-INF/includes/footer.gtpl' %>