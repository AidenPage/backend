package com.computerstore.backend.client.peripherals;

import com.computerstore.backend.domain.peripherals.Printer;
import com.computerstore.backend.services.peripherals.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aiden on 2016/10/23.
 */
@RestController
public class PrinterController {

    @Autowired
    private PrinterService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/printer/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Printer> createPrinter(@RequestBody Printer Printer) {
        service.create(Printer);
        return new ResponseEntity<Printer>(Printer, HttpStatus.CREATED);
    }

    /*
        READ SINGLE printer
    * */
    @RequestMapping(value = "/printer/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Printer> readPrinterByID(@PathVariable("id") long id) {
        Printer printer = service.readById(id);
        if (printer == null) {
            return new ResponseEntity<Printer>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Printer>(printer, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/printers/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Printer>> findAllPrinter() {
        Iterable<Printer> printer = service.readAll();
        if (printer == null) {
            return new ResponseEntity<Iterable<Printer>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Printer>>(printer, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/printer/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Printer> updatePrinter(@PathVariable("id") long id, @RequestBody Printer printer)
    {
        Printer currentprinter = service.readById(id);
        if(currentprinter == null)
        {
            return new ResponseEntity<Printer>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Printer update = new Printer.Builder()
                .copy(currentprinter)
                .name(printer.getName())
                .description(printer.getDescription())
                .stock(printer.getStock())
                .price(printer.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<Printer>(update,HttpStatus.OK);
    }

    /*
        DELETE printer
    * */
    @RequestMapping(value = "/printer/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Printer> deletePrinter(@PathVariable("id") long id)
    {
        Printer printer = service.readById(id);
        if(printer == null)
        {
            return new ResponseEntity<Printer>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(printer);
        return new ResponseEntity<Printer>(HttpStatus.NO_CONTENT);
    }
}
