package com.computerstore.backend.client.components;

import com.computerstore.backend.domain.components.DisplayCard;
import com.computerstore.backend.services.components.DisplayCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aiden on 2016/10/23.
 */
@RestController
public class DisplayCardController {

    @Autowired
    private DisplayCardService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/displayCard/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<DisplayCard> createDisplayCard(@RequestBody DisplayCard DisplayCard) {
        service.create(DisplayCard);
        return new ResponseEntity<DisplayCard>(DisplayCard, HttpStatus.CREATED);
    }

    /*
        READ SINGLE displayCard
    * */
    @RequestMapping(value = "/displayCard/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DisplayCard> readDisplayCardByID(@PathVariable("id") long id) {
        DisplayCard displayCard = service.readById(id);
        if (displayCard == null) {
            return new ResponseEntity<DisplayCard>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<DisplayCard>(displayCard, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/DisplayCards/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<DisplayCard>> findAllDisplayCard() {
        Iterable<DisplayCard> displayCard = service.readAll();
        if (displayCard == null) {
            return new ResponseEntity<Iterable<DisplayCard>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<DisplayCard>>(displayCard, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/displayCard/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<DisplayCard> updateDisplayCard(@PathVariable("id") long id, @RequestBody DisplayCard displayCard)
    {
        DisplayCard currentdisplayCard = service.readById(id);
        if(currentdisplayCard == null)
        {
            return new ResponseEntity<DisplayCard>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        DisplayCard update = new DisplayCard.Builder()
                .copy(currentdisplayCard)
                .name(displayCard.getName())
                .description(displayCard.getDescription())
                .stock(displayCard.getStock())
                .price(displayCard.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<DisplayCard>(update,HttpStatus.OK);
    }

    /*
        DELETE displayCard
    * */
    @RequestMapping(value = "/displayCard/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<DisplayCard> deleteDisplayCard(@PathVariable("id") long id)
    {
        DisplayCard displayCard = service.readById(id);
        if(displayCard == null)
        {
            return new ResponseEntity<DisplayCard>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(displayCard);
        return new ResponseEntity<DisplayCard>(HttpStatus.NO_CONTENT);
    }
}
