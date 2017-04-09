# Postcode Search

This is a Java application that consumes a third-party service in order to cache the results avoiding extra charge.

## How to start environment

###### Pre-Requisites

 * [Install Docker](https://docs.docker.com/engine/installation/linux/)
 * [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)


###### Execute Tests and Build java App

      $ ./gradlew build

###### Build Docker Image

      $ ./gradlew buildDocker

###### Start Container

      $ docker run -p 8080:8080 -t com.fexco/postcode-search:1.0-SNAPSHOT

      or

      $ docker run -p 8080:8080 -it com.fexco/postcode-search:1.0-SNAPSHOT

      in order to allocate a pseudo-TTY connected to the container’s stdin;


## How to interact with the Application

### REST API

#### Irish Service

__Irish address lookup__

    http://{host}:8080/address/ie/[eircode-or-address-fragment


__Irish address and coordinate lookup__

    http://{host}:8080/addressgeo/ie/[eircode-or-address-fragment

__Coordinate lookup__

    http://{host}:8080/position/ie/[eircode-or-address-fragment

__Reverse geocode coordinates to an Irish addres__

    http://{host}:8080/rgeo/ie/[latitude]/[longitude]?distance=[distance-in-metres]

__Request parameters__

You may append any of the following parameters to the querystring of your request.

Format: ?key1=value1&key2=value2

    lines -	The number of lines over which to split each address
    include -	Include extra address fields within the address lines returned (see above)
    exclude -	Exclude address fields within the address lines returned (see above)
    format -	xml | json (default unless header of application/xml is detected)
    identifier -	Identify your lookups to make debugging and reviewing stats easier
    callback -	Use to specify the name of your JSONP callback function
    page -	For use with searches that return more than 100 results; first page is 0



#### UK Service

__UK address lookup__

    http://{host}:8080/address/uk/[postcode-or-address-fragment]

__Optional parameters__

    lines -	The number of lines over which to split each address
    include -	Include extra address fields within the address lines returned (see above)
    exclude -	Exclude address fields within the address lines returned (see above)
    format	xml | json (default unless header of application/xml is detected)
    addtags	Add extra address fields such as UDPRN to the return
    identifier -	Identify your lookups to make debugging and reviewing stats easier
    callback -	Use to specify the name of your JSONP callback function
    page	For use with searches that return more than 100 results (first page is 0)
    postcodeonly -	Use ?postcodeonly=true to limit your search to just the postcode field.
    alias -	Use ?alias=true to include alternative names for addresses known to and accepted by Royal Mail
