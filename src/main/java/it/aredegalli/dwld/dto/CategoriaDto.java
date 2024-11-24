package it.aredegalli.dwld.dto;

import it.aredegalli.dwld.model.DwldCat;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriaDto {

    private Long id;
    private String name;
    private String description;

    public CategoriaDto(DwldCat dwldCat) {
        this.id = dwldCat.getId();
        this.name = dwldCat.getName();
        this.description = dwldCat.getDescription();
    }

}
