package com.example.catalogsservice.catalog.infrastructure;

import com.example.catalogsservice.catalog.domain.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {

    CatalogEntity findByProductId(String productId);
}
