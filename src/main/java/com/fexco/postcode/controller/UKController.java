package com.fexco.postcode.controller;

import com.fexco.postcode.service.EircodeService;
import com.fexco.postcode.service.UKService;
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
public class UKController {


    @Autowired
    private UKService ukService;

    @RequestMapping(value = Constants.ADDRESS_UK+"{query}", method = RequestMethod.GET)
    public ResponseEntity<?> getAddressUk(@PathVariable String query, @RequestParam Map<String, String> params) {
        return new ResponseEntity<>(ukService.getAddressUk(query, params), HttpStatus.OK );
    }

}
