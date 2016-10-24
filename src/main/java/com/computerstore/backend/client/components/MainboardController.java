package com.computerstore.backend.client.components;

import com.computerstore.backend.domain.components.Mainboard;
import com.computerstore.backend.services.components.MainboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aiden on 2016/10/23.
 */
@RestController
public class MainboardController {

    @Autowired
    private MainboardService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/mainboard/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Mainboard> createMainboard(@RequestBody Mainboard Mainboard) {
        service.create(Mainboard);
        return new ResponseEntity<Mainboard>(Mainboard, HttpStatus.CREATED);
    }

    /*
        READ SINGLE mainboard
    * */
    @RequestMapping(value = "/mainboard/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Mainboard> readMainboardByID(@PathVariable("id") long id) {
        Mainboard mainboard = service.readById(id);
        if (mainboard == null) {
            return new ResponseEntity<Mainboard>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Mainboard>(mainboard, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/Mainboards/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Mainboard>> findAllMainboard() {
        Iterable<Mainboard> mainboard = service.readAll();
        if (mainboard == null) {
            return new ResponseEntity<Iterable<Mainboard>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Mainboard>>(mainboard, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/mainboard/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Mainboard> updateMainboard(@PathVariable("id") long id, @RequestBody Mainboard mainboard)
    {
        Mainboard currentmainboard = service.readById(id);
        if(currentmainboard == null)
        {
            return new ResponseEntity<Mainboard>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Mainboard update = new Mainboard.Builder()
                .copy(currentmainboard)
                .name(mainboard.getName())
                .description(mainboard.getDescription())
                .stock(mainboard.getStock())
                .price(mainboard.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<Mainboard>(update,HttpStatus.OK);
    }

    /*
        DELETE mainboard
    * */
    @RequestMapping(value = "/mainboard/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Mainboard> deleteMainboard(@PathVariable("id") long id)
    {
        Mainboard mainboard = service.readById(id);
        if(mainboard == null)
        {
            return new ResponseEntity<Mainboard>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(mainboard);
        return new ResponseEntity<Mainboard>(HttpStatus.NO_CONTENT);
    }
}
