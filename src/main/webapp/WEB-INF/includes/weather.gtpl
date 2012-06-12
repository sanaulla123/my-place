<h3>Weather as of ${request.forecastDate}</h3>
<div class="span3">
    <ul>
        <li>
            <strong>Weather</strong>: ${request.weather}
        </li>
        <li>
            <strong>Temperature</strong>: ${request.temperature}
        </li>
        <li>
            <strong>Wind</strong>: ${request.wind}
        </li>
        <li>
            <strong>Relative Humidity</strong>: ${request.relativeHumidity}
        </li>
    </ul>
    More details <a href="${request.moreUrl}" target="_blank">here</a>
</div>
<div class="span2">
    <img src="${request.icon}" alt="${request.iconDesc}" />
</div>
