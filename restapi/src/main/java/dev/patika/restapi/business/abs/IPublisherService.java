package dev.patika.restapi.business.abs;

import dev.patika.restapi.Entities.Category;
import dev.patika.restapi.Entities.Publisher;

import java.util.List;

public interface IPublisherService {
    Publisher getByID(int id);
    Publisher save(Publisher publisher);
    void delete(int id);
    Publisher update(Publisher publisher);
    List<Publisher> findAll();
}
