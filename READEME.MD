https://github.com/splunk/splunk-demo-collector-for-analyticsjs#appendix-how-to-use-spjs-analytics-javascript-library

https://github.com/angulartics/angulartics/blob/master/src/angulartics-splunk.js


HEC ENABLING:
http://docs.splunk.com/Documentation/SplunkCloud/6.6.0/Data/UsetheHTTPEventCollector

SPLUNK HEC:
http://docs.splunk.com/Documentation/SplunkCloud/6.6.0/Data/UsetheHTTPEventCollector#Configure_HTTP_Event_Collector_on_Splunk_Enterprise

HEC AUTH TYPES:
http://dev.splunk.com/view/event-collector/SP-CAAAE7G


JAVA LOGGING:
http://dev.splunk.com/view/splunk-logging-java/SP-CAAAE2K

HEC with JS:
http://dev.splunk.com/view/splunk-logging-javascript/SP-CAAAE6U
https://github.com/splunk/splunk-javascript-logging

SPLUNK SLF4J:
https://mvnrepository.com/artifact/com.splunk.logging/splunk-library-javalogging/1.5.2


Дарова, Димас.
Что мне нужно.
Мне нужно собрать стрингу похожую на следующие строки:
157.55.39.251 - - [01/Apr/2016:05:54:09 +0100] \"GET /images/content/social_youtube.png HTTP/1.1\" 200 3094 \"-\" \"Mozilla/5.0 (compatible; bingbot/2.0; +http://www.bing.com/bingbot.htm)\"
193.14.82.119 - - [01/Apr/2016:00:04:00 +0100] "GET /js/scripts.js HTTP/1.1" 200 5158 "http://www.sampleapachesite.com/Kontakt" "Mozilla/5.0 (iPhone; CPU iPhone OS 8_1 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/8.0 Mobile/12B411 Safari/600.1.4"
107.178.200.222 - - [01/Apr/2016:00:04:04 +0100] "GET /images/content/on-ramp-sessions-150px.jpg HTTP/1.1" 200 7400 "-" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/23.0.912.77 Safari/535.7 AppEngine-Google; (+http://code.google.com/appengine; appid: s~feedly-nikon3)"
54.237.198.72 - - [01/Apr/2016:00:04:14 +0100] "GET /Blogg/2014-05-29-Nyhetgallandemedlemskappasampleapachesite HTTP/1.1" 200 21125 "-" "Mozilla/5.0 (compatible; linkdexbot/2.0; +http://www.linkdex.com/bots/)"

и отправить ajax-post-ом в следующем виде:
{
"event": "157.55.39.251 - - [01/Apr/2016:05:54:09 +0100] \"GET /images/content/social_youtube.png HTTP/1.1\" 200 3094 \"-\" \"Mozilla/5.0 (compatible; bingbot/2.0; +http://www.bing.com/bingbot.htm)\""
}

на адресс:
http://192.168.1.137:8088/services/collector/event

и добавить в запрос хедер типа:
"Authorization": "Splunk 97F766E2-AC06-44A8-8263-93E31E17B71F"

Данные надо собирать на ходу.
ссылка строится следующим образом:
~User IP~(127.0.0.1) - - [~DATE~(01/Apr/2016:22:26:09 +0100)] "GET ~ADDR~ (/images/Logo-2014.png) ~version~(HTTP/1.1)" ~STATUS~(200) ~BYTES которыми ответил сервак~(17246) ~HTTP_REFERER~(http:/samle.com/) ~HTTP_USER_AGENT~(Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53)

Мне, по факту, важны следующие данные: куда мы идём, откуда идём, время именно в этом формате и каков ответ от сервера.
https://en.wikipedia.org/wiki/Common_Log_Format