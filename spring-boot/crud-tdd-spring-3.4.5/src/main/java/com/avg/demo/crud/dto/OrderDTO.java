package com.avg.demo.crud.dto;

import java.util.List;

public record OrderDTO(Long id, String code, List<ProductDTO> products) {}
