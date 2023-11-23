package dev.patika.restapi.business.concrete;

import dev.patika.restapi.Entities.Category;
import dev.patika.restapi.Entities.Publisher;
import dev.patika.restapi.business.abs.IPublisherService;
import dev.patika.restapi.dao.CategoryRepo;
import dev.patika.restapi.dao.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PublisherManager implements IPublisherService {
    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public Publisher getByID(int id) {
        return this.publisherRepo.findById(id).orElseThrow();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public void delete(int id) {
        this.publisherRepo.delete(getByID(id));
    }

    @Override
    public Publisher update(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public List<Publisher> findAll() {
        return this.publisherRepo.findAll();
    }
}
