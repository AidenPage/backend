package com.computerstore.backend.client.peripherals;

import com.computerstore.backend.domain.peripherals.Speaker;
import com.computerstore.backend.services.peripherals.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aiden on 2016/10/23.
 */
@RestController
public class SpeakerController {

    @Autowired
    private SpeakerService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/speaker/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Speaker> createspeaker(@RequestBody Speaker Speaker) {
        service.create(Speaker);
        return new ResponseEntity<Speaker>(Speaker, HttpStatus.CREATED);
    }

    /*
        READ SINGLE speaker
    * */
    @RequestMapping(value = "/speaker/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Speaker> readspeakerByID(@PathVariable("id") long id) {
        Speaker speaker = service.readById(id);
        if (speaker == null) {
            return new ResponseEntity<Speaker>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Speaker>(speaker, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/speakers/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Speaker>> findAllSpeaker() {
        Iterable<Speaker> speaker = service.readAll();
        if (speaker == null) {
            return new ResponseEntity<Iterable<Speaker>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Speaker>>(speaker, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/speaker/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Speaker> updatesSpeaker(@PathVariable("id") long id, @RequestBody Speaker speaker)
    {
        Speaker currentspeaker = service.readById(id);
        if(currentspeaker == null)
        {
            return new ResponseEntity<Speaker>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Speaker update = new Speaker.Builder()
                .copy(currentspeaker)
                .name(speaker.getName())
                .description(speaker.getDescription())
                .stock(speaker.getStock())
                .price(speaker.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<Speaker>(update,HttpStatus.OK);
    }

    /*
        DELETE speaker
    * */
    @RequestMapping(value = "/speaker/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Speaker> deletespeaker(@PathVariable("id") long id)
    {
        Speaker speaker = service.readById(id);
        if(speaker == null)
        {
            return new ResponseEntity<Speaker>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(speaker);
        return new ResponseEntity<Speaker>(HttpStatus.NO_CONTENT);
    }
}
