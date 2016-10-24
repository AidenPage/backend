package com.computerstore.backend.client.components;

import com.computerstore.backend.domain.components.PowerSupply;
import com.computerstore.backend.services.components.PowerSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aiden on 2016/10/23.
 */
@RestController
public class PowerSupplyController {

    @Autowired
    private PowerSupplyService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/powerSupply/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<PowerSupply> createPowerSupply(@RequestBody PowerSupply PowerSupply) {
        service.create(PowerSupply);
        return new ResponseEntity<PowerSupply>(PowerSupply, HttpStatus.CREATED);
    }

    /*
        READ SINGLE powerSupply
    * */
    @RequestMapping(value = "/powerSupply/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PowerSupply> readPowerSupplyByID(@PathVariable("id") long id) {
        PowerSupply powerSupply = service.readById(id);
        if (powerSupply == null) {
            return new ResponseEntity<PowerSupply>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<PowerSupply>(powerSupply, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/PowerSupplies/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<PowerSupply>> findAllPowerSupply() {
        Iterable<PowerSupply> powerSupply = service.readAll();
        if (powerSupply == null) {
            return new ResponseEntity<Iterable<PowerSupply>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<PowerSupply>>(powerSupply, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/powerSupply/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<PowerSupply> updatePowerSupply(@PathVariable("id") long id, @RequestBody PowerSupply powerSupply)
    {
        PowerSupply currentpowerSupply = service.readById(id);
        if(currentpowerSupply == null)
        {
            return new ResponseEntity<PowerSupply>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        PowerSupply update = new PowerSupply.Builder()
                .copy(currentpowerSupply)
                .name(powerSupply.getName())
                .description(powerSupply.getDescription())
                .stock(powerSupply.getStock())
                .price(powerSupply.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<PowerSupply>(update,HttpStatus.OK);
    }

    /*
        DELETE powerSupply
    * */
    @RequestMapping(value = "/powerSupply/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<PowerSupply> deletePowerSupply(@PathVariable("id") long id)
    {
        PowerSupply powerSupply = service.readById(id);
        if(powerSupply == null)
        {
            return new ResponseEntity<PowerSupply>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(powerSupply);
        return new ResponseEntity<PowerSupply>(HttpStatus.NO_CONTENT);
    }
}
