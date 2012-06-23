import groovyx.gaelyk.datastore.Key
import com.google.appengine.api.datastore.KeyFactory
/**
 * Created by IntelliJ IDEA.
 * User: mohamed
 * Date: 23/6/12
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */

def key = KeyFactory.stringToKey(params.key)

def entity = key.get()
request.book = entity
forward "/WEB-INF/pages/editBook.gtpl"