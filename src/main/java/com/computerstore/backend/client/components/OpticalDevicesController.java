package com.computerstore.backend.client.components;

import com.computerstore.backend.domain.components.OpticalDevices;
import com.computerstore.backend.services.components.OpticalDevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aiden on 2016/10/23.
 */
@RestController
public class OpticalDevicesController {

    @Autowired
    private OpticalDevicesService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/opticalDevices/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<OpticalDevices> createOpticalDevices(@RequestBody OpticalDevices OpticalDevices) {
        service.create(OpticalDevices);
        return new ResponseEntity<OpticalDevices>(OpticalDevices, HttpStatus.CREATED);
    }

    /*
        READ SINGLE opticalDevices
    * */
    @RequestMapping(value = "/opticalDevices/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<OpticalDevices> readOpticalDevicesByID(@PathVariable("id") long id) {
        OpticalDevices opticalDevices = service.readById(id);
        if (opticalDevices == null) {
            return new ResponseEntity<OpticalDevices>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<OpticalDevices>(opticalDevices, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/OpticalDevices_s/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<OpticalDevices>> findAllOpticalDevices() {
        Iterable<OpticalDevices> opticalDevices = service.readAll();
        if (opticalDevices == null) {
            return new ResponseEntity<Iterable<OpticalDevices>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<OpticalDevices>>(opticalDevices, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/opticalDevices/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<OpticalDevices> updateOpticalDevices(@PathVariable("id") long id, @RequestBody OpticalDevices opticalDevices)
    {
        OpticalDevices currentopticalDevices = service.readById(id);
        if(currentopticalDevices == null)
        {
            return new ResponseEntity<OpticalDevices>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        OpticalDevices update = new OpticalDevices.Builder()
                .copy(currentopticalDevices)
                .name(opticalDevices.getName())
                .description(opticalDevices.getDescription())
                .stock(opticalDevices.getStock())
                .price(opticalDevices.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<OpticalDevices>(update,HttpStatus.OK);
    }

    /*
        DELETE opticalDevices
    * */
    @RequestMapping(value = "/opticalDevices/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<OpticalDevices> deleteOpticalDevices(@PathVariable("id") long id)
    {
        OpticalDevices opticalDevices = service.readById(id);
        if(opticalDevices == null)
        {
            return new ResponseEntity<OpticalDevices>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(opticalDevices);
        return new ResponseEntity<OpticalDevices>(HttpStatus.NO_CONTENT);
    }
}
