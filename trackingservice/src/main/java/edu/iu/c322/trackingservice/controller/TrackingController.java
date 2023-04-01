package edu.iu.c322.trackingservice.controller;

import edu.iu.c322.trackingservice.model.Invoice;
import edu.iu.c322.trackingservice.model.StatusUpdate;
import edu.iu.c322.trackingservice.model.Tracking;
import edu.iu.c322.trackingservice.repository.TrackingRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trackings")
public class TrackingController {

    private TrackingRepository repository;

    // this is bad it is binding this class the customerRepository so instead we use spring dependency injection
    /*
    public CustomerController() {
        this.repository = new CustomerRepository();
    }
     */

    //this is dpeendency injection
    public TrackingController(TrackingRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/{id}/{iid}")
    public Tracking findByOrderId(@Valid @PathVariable int id, @Valid @PathVariable int iid){

        return repository.findByOrder(id, iid);

    }

    //@valid tells spring to ensure validations are checked, our validation is currently in the customer class
    @PostMapping
    public int create(@Valid @RequestBody Invoice invoice){
        return repository.create(invoice);
    }

    // PUT lcoalhost:8080.customers/2
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody StatusUpdate update, @PathVariable int id){
        repository.update(update, id);
    }




}