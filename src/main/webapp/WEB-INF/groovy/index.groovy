import groovy.json.JsonSlurper
import com.google.appengine.api.memcache.Expiration

/**
 * Created by IntelliJ IDEA.
 * User: mohamed
 * Date: 5/6/12
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */

def myIp = request.remoteAddr
if(myIp.equals("127.0.0.1")){
    myIp = "117.192.179.241"
}

log.info "My IP: ${myIp}"
def api_key = api.ApiKey.LOCATION_KEY
def ipUrl = "http://api.ipinfodb.com/v3/ip-city/?key=${api_key}&ip=${myIp}&format=json"
def jsonSlurper = new JsonSlurper()
def locationInformation = null
if (memcache[myIp] != null){
    locationInformation = memcache[myIp]
}
else{
    locationInformation = jsonSlurper.parseText(new URL(ipUrl).text)
    memcache[myIp] = locationInformation
}
request.ipAddress = locationInformation.ipAddress
request.country = locationInformation.countryName
request.region = locationInformation.regionName
request.city = locationInformation.cityName
request.latitude = locationInformation.latitude
request.longitude = locationInformation.longitude
request.timezone = locationInformation.timeZone

//Fetch the weather information
def weatherKey= api.ApiKey.WEATHER_KEY

def weatherUrl = "http://api.wunderground.com/api/${weatherKey}/conditions/q/${locationInformation.cityName}.json"
def xmlSlurper = new XmlSlurper()
def weatherInformation = null
if (memcache[locationInformation.cityName] != null){
    log.info("weather from cache")
    weatherInformation = memcache[locationInformation.cityName]
}
else{
    weatherInformation = jsonSlurper.parseText(new URL(weatherUrl).text)
    //caching the weather for each hour
    memcache.put(locationInformation.cityName,weatherInformation,Expiration.byDeltaSeconds(3599))
}

def currentObservation = weatherInformation.current_observation
request.forecastDate = currentObservation.observation_time_rfc822
request.weather = currentObservation.weather
request.temperature = currentObservation.temperature_string
request.wind = currentObservation.wind_string
request.relativeHumidity = currentObservation.relative_humidity
request.moreUrl = currentObservation.ob_url
request.icon = currentObservation.icon_url
request.iconDesc = currentObservation.icon

//Fetch places around
def placesKey = "AIzaSyAgYZVjw15TQWGxAMFv0ayA8OlAtVFkyx0"
def placesUrl = "http://maps.googleapis.com/maps/api/place/search/json?key=${placesKey}&location=${locationInformation.latitude},${locationInformation.longitude}&radius=10000&sensor=false"
def placesList = null
if (memcache[locationInformation.ipAddress] != null){
    placesList = memcache[locationInformation.ipAddress]
}else{
    placesList = jsonSlurper.parseText(new URL(placesUrl).text)

    memcache[locationInformation.ipAddress] = placesList
}
log.info placesList.toString

forward '/WEB-INF/pages/index.gtpl'
