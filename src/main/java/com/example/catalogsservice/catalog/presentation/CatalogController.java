package com.example.catalogsservice.catalog.presentation;

import com.example.catalogsservice.catalog.application.CatalogService;
import com.example.catalogsservice.catalog.presentation.dto.CatalogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
@RequiredArgsConstructor
public class CatalogController {

    private final Environment environment;
    private final CatalogService catalogService;

    @GetMapping("/health_check")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok(String.format("It's Working in Catalogs Service on PORT %s", environment.getProperty("local.server.port")));
    }

    @GetMapping
    public ResponseEntity<List<CatalogDto.Response>> getAllCatalogs() {
        List<CatalogDto.Response> catalogList = catalogService.getAllCatalogs();

        return ResponseEntity.ok(catalogList);
    }
}
