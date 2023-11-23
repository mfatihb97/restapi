package dev.patika.restapi.api;

import dev.patika.restapi.Entities.Publisher;
import dev.patika.restapi.business.abs.IPublisherService;
import dev.patika.restapi.dto.PublisherRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/publisher")
public class PublisherController {
    @Autowired
    private IPublisherService publisherService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    @ResponseStatus()
    public List<PublisherRequest> findAll(){
        List<PublisherRequest> publisherRequestList = this.publisherService.findAll().stream().map(
                publisher -> this.modelMapper.map(publisher,PublisherRequest.class)
        ).collect(Collectors.toList());
        return publisherRequestList;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher save(@RequestBody Publisher publisher){
        return this.publisherService.save(publisher);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Publisher update(@RequestBody Publisher publisher){
        Publisher updatedPublisher = this.publisherService.getByID(publisher.getId());
        updatedPublisher.setName(publisher.getName());
        updatedPublisher.setAddress(publisher.getAddress());
        updatedPublisher.setYear(publisher.getYear());
        return this.publisherService.save(updatedPublisher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        this.publisherService.delete(id);
    }

}
