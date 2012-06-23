
/**
 * Created by IntelliJ IDEA.
 * User: mohamed
 * Date: 23/6/12
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */

def books = datastore.execute{
    select all from book
}
request.books = books
forward '/WEB-INF/pages/listBook.gtpl'