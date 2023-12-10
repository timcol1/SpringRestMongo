package avlyakulov.timur.SpringRestMongo.controller;

import avlyakulov.timur.SpringRestMongo.model.Catalogue;
import avlyakulov.timur.SpringRestMongo.service.CatalogueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/catalogue")
public class CatalogueController {
    private final CatalogueService catalogueService;

    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping
    public ResponseEntity<List<Catalogue>> getAllFromCatalogue() {
        return ResponseEntity.ok(catalogueService.getAll());
    }
}
