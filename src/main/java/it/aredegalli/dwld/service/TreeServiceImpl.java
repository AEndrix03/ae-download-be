package it.aredegalli.dwld.service;

import it.aredegalli.dwld.dto.tree.CategoriaTreeDto;
import it.aredegalli.dwld.model.DwldCat;
import it.aredegalli.dwld.model.DwldCatFileLnk;
import it.aredegalli.dwld.model.DwldFile;
import it.aredegalli.dwld.repository.CategoriaFileLinkRepository;
import it.aredegalli.dwld.repository.CategoriaRepository;
import it.aredegalli.dwld.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaFileLinkRepository categoriaFileLinkRepository;

    @Autowired
    private FileRepository fileRepository;

    @Override
    public List<CategoriaTreeDto> getCategorieTree(Long userId) {
        List<DwldCat> categorieUtente = this.categoriaRepository.findAllByUserIdOrderByOrder(userId);

        List<CategoriaTreeDto> tree = new ArrayList<>();

        for (DwldCat cat : categorieUtente) {
            this.getCategorieAssociate(userId, cat, tree);
        }

        return tree;
    }

    private void getCategorieAssociate(Long userId, DwldCat cat, List<CategoriaTreeDto> tree) {
        List<DwldCat> children = this.categoriaRepository.findAllByUserIdAndAndDwldCatPdrIdOrderByOrder(userId, cat.getId());
        if (!children.isEmpty()) {
            CategoriaTreeDto parent = tree.stream().filter(c -> c.getId().equals(cat.getId())).findFirst().orElse(null);
            if (parent != null) {
                for (DwldCat child : children) {
                    CategoriaTreeDto newChild = new CategoriaTreeDto(child.getId(), child.getName(), child.getDescription());
                    newChild.setFiles(this.categoriaFileLinkRepository.findAllDwldCatFileLinkByDwldCatIdAndUserIdOrderByOrder(child.getId(), userId)
                            .stream()
                            .map(DwldCatFileLnk::getDwldFile)
                            .map(DwldFile::toDto)
                            .toList());
                    parent.getTree().add(newChild);
                    this.getCategorieAssociate(userId, child, parent.getTree());
                }
            }
        }
    }

}
