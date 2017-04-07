package com.fexco.postcode.controller;

import com.fexco.postcode.service.EircodeService;
import com.fexco.postcode.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * Controller that provides access to the Eircode API.
 *
 * @author flavio
 */

@RestController
public class EircodeController {


    @Autowired
    private EircodeService eircodeService;

    @RequestMapping(value = Constants.ADDRESS_IE+"{query}", method = RequestMethod.GET)
    public ResponseEntity<?> getAddressIe(@PathVariable String query, @RequestParam Map<String, String> params) {
        return new ResponseEntity<>(eircodeService.getAddressIe(query, params), HttpStatus.OK );
    }

    @RequestMapping(value = Constants.ADDRESS_GEO+"{query}", method = RequestMethod.GET)
    public ResponseEntity<?> getAddressGeo(@PathVariable String query, @RequestParam Map<String, String> params) {
        return new ResponseEntity<>(eircodeService.getAddressGeo(query, params), HttpStatus.OK );
    }

    @RequestMapping(value = Constants.POSITON_IE+"{query}", method = RequestMethod.GET)
    public ResponseEntity<?> getPositionIe(@PathVariable String query, @RequestParam Map<String, String> params) {
        return new ResponseEntity<>(eircodeService.getPositionIe(query, params), HttpStatus.OK );
    }
    @RequestMapping(value = Constants.RGEO_IE+"{lat}/{lon}", method = RequestMethod.GET)
    public ResponseEntity<?> getRgeoIe(@PathVariable double lat, @PathVariable double lon , @RequestParam Map<String, String> params) {
        return new ResponseEntity<>(eircodeService.getRgeoIe(lat, lon, params), HttpStatus.OK );
    }
}
