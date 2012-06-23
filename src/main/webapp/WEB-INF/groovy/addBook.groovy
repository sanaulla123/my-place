import com.google.appengine.api.datastore.Entity
/**
 * Created by IntelliJ IDEA.
 * User: mohamed
 * Date: 23/6/12
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
def entity = new Entity("book")
entity << params
entity.save()
request.operation = "saved"
request.savedTitle = params.title

forward '/WEB-INF/pages/success.gtpl'