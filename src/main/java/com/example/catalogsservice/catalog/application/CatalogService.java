package com.example.catalogsservice.catalog.application;

import com.example.catalogsservice.catalog.domain.entity.CatalogEntity;
import com.example.catalogsservice.catalog.infrastructure.CatalogRepository;
import com.example.catalogsservice.catalog.presentation.dto.CatalogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CatalogRepository catalogRepository;

    public List<CatalogDto.Response> getAllCatalogs() {
        List<CatalogEntity> catalogEntityList = catalogRepository.findAll();

        return CatalogDto.Response.of(catalogEntityList);
    }
}
