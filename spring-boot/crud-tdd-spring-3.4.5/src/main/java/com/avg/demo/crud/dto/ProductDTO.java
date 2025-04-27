package com.avg.demo.crud.dto;

import java.io.Serializable;

public record ProductDTO(Long id, String name, Double price) implements Serializable {}

