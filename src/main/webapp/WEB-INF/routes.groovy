
get "/", forward: "/index.groovy"

get "/book/new", forward: "/WEB-INF/pages/newBook.gtpl"

get "/book/all", forward: "/listBooks.groovy"
get "/book/edit/@key", forward: "/editBook.groovy?key=@key"
get "/book/delete/@key", forward: "/deleteBook.groovy?key=@key"

post "/book", forward: "/addBook.groovy"
get "/datetime", forward: "/datetime.groovy"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"
