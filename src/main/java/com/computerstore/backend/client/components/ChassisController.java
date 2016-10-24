package com.computerstore.backend.client.components;

import com.computerstore.backend.domain.components.Chassis;
import com.computerstore.backend.services.components.ChassisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aiden on 2016/10/23.
 */
@RestController
public class ChassisController {

    @Autowired
    private ChassisService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/chassis/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Chassis> createChassis(@RequestBody Chassis Chassis) {
        service.create(Chassis);
        return new ResponseEntity<Chassis>(Chassis, HttpStatus.CREATED);
    }

    /*
        READ SINGLE chassis
    * */
    @RequestMapping(value = "/chassis/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Chassis> readChassisByID(@PathVariable("id") long id) {
        Chassis chassis = service.readById(id);
        if (chassis == null) {
            return new ResponseEntity<Chassis>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Chassis>(chassis, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/chassis_s/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Chassis>> findAllChassis() {
        Iterable<Chassis> chassis = service.readAll();
        if (chassis == null) {
            return new ResponseEntity<Iterable<Chassis>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Chassis>>(chassis, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/chassis/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Chassis> updateChassis(@PathVariable("id") long id, @RequestBody Chassis chassis)
    {
        Chassis currentchassis = service.readById(id);
        if(currentchassis == null)
        {
            return new ResponseEntity<Chassis>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Chassis update = new Chassis.Builder()
                .copy(currentchassis)
                .name(chassis.getName())
                .description(chassis.getDescription())
                .stock(chassis.getStock())
                .price(chassis.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<Chassis>(update,HttpStatus.OK);
    }

    /*
        DELETE chassis
    * */
    @RequestMapping(value = "/chassis/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Chassis> deleteChassis(@PathVariable("id") long id)
    {
        Chassis chassis = service.readById(id);
        if(chassis == null)
        {
            return new ResponseEntity<Chassis>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(chassis);
        return new ResponseEntity<Chassis>(HttpStatus.NO_CONTENT);
    }
}
