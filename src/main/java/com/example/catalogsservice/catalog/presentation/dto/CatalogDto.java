package com.example.catalogsservice.catalog.presentation.dto;

import com.example.catalogsservice.catalog.domain.entity.CatalogEntity;
import com.example.catalogsservice.core.util.ModelMapperUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogDto implements Serializable {

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Request {
        private String productId;
        private Integer quantity;
        private Integer unitPrice;
        private Integer totalPrice;
        private String orderId;
        private  String userId;
    }

    @Setter
    @Getter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Response {
        private String productId;
        private String productName;
        private Integer unitPrice;
        private Integer stock;
        private LocalDateTime createAt;

        public static Response of(CatalogEntity catalogEntity) {
            return ModelMapperUtil.modelMapper().map(catalogEntity, Response.class);
        }

        public static List<Response> of(List<CatalogEntity> catalogEntityList) {
            return catalogEntityList.stream()
                    .map(Response::of)
                    .collect(Collectors.toList());
        }
    }
}
