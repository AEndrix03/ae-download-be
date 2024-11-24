package it.aredegalli.dwld.service;

import it.aredegalli.dwld.dto.tree.CategoriaTreeDto;

import java.util.List;

public interface TreeService {
    List<CategoriaTreeDto> getCategorieTree(Long userId);
}
