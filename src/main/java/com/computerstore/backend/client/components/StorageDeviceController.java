package com.computerstore.backend.client.components;

import com.computerstore.backend.domain.components.StorageDevice;
import com.computerstore.backend.services.components.StorageDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aiden on 2016/10/23.
 */
@RestController
public class StorageDeviceController {

    @Autowired
    private StorageDeviceService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/storageDevice/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<StorageDevice> createStorageDevice(@RequestBody StorageDevice StorageDevice) {
        service.create(StorageDevice);
        return new ResponseEntity<StorageDevice>(StorageDevice, HttpStatus.CREATED);
    }

    /*
        READ SINGLE storageDevice
    * */
    @RequestMapping(value = "/storageDevice/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StorageDevice> readStorageDeviceByID(@PathVariable("id") long id) {
        StorageDevice storageDevice = service.readById(id);
        if (storageDevice == null) {
            return new ResponseEntity<StorageDevice>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<StorageDevice>(storageDevice, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/StorageDevices/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<StorageDevice>> findAllStorageDevice() {
        Iterable<StorageDevice> storageDevice = service.readAll();
        if (storageDevice == null) {
            return new ResponseEntity<Iterable<StorageDevice>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<StorageDevice>>(storageDevice, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/storageDevice/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<StorageDevice> updateStorageDevice(@PathVariable("id") long id, @RequestBody StorageDevice storageDevice)
    {
        StorageDevice currentstorageDevice = service.readById(id);
        if(currentstorageDevice == null)
        {
            return new ResponseEntity<StorageDevice>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        StorageDevice update = new StorageDevice.Builder()
                .copy(currentstorageDevice)
                .name(storageDevice.getName())
                .description(storageDevice.getDescription())
                .stock(storageDevice.getStock())
                .price(storageDevice.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<StorageDevice>(update,HttpStatus.OK);
    }

    /*
        DELETE storageDevice
    * */
    @RequestMapping(value = "/storageDevice/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<StorageDevice> deletestorageDevice(@PathVariable("id") long id)
    {
        StorageDevice storageDevice = service.readById(id);
        if(storageDevice == null)
        {
            return new ResponseEntity<StorageDevice>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(storageDevice);
        return new ResponseEntity<StorageDevice>(HttpStatus.NO_CONTENT);
    }
}
