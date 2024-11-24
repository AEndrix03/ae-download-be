package it.aredegalli.dwld.dto.tree;

import it.aredegalli.dwld.dto.CategoriaDto;
import it.aredegalli.dwld.dto.FileDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoriaTreeDto extends CategoriaDto {

    private List<CategoriaTreeDto> tree;
    private List<FileDto> files;

    public CategoriaTreeDto(Long id, String name, String description) {
        this(id, name, description, new ArrayList<>(), new ArrayList<>());
    }

    public CategoriaTreeDto(Long id, String name, String description, List<CategoriaTreeDto> tree, List<FileDto> files) {
        super(id, name, description);
        this.tree = tree;
        this.files = files;
    }

}
