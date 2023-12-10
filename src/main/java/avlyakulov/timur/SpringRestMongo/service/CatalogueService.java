package avlyakulov.timur.SpringRestMongo.service;

import avlyakulov.timur.SpringRestMongo.model.Catalogue;
import avlyakulov.timur.SpringRestMongo.repository.CatalogueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {
    private final CatalogueRepository catalogueRepository;

    public CatalogueService(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public List<Catalogue> getAll() {
        return catalogueRepository.findAll();
    }
}