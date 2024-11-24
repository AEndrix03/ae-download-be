package it.aredegalli.dwld.controller;

import it.aredegalli.dwld.dto.tree.CategoriaTreeDto;
import it.aredegalli.dwld.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TreeController {

    public static final String ROOT = "/tree";

    @Autowired
    private TreeService treeService;

    @GetMapping(ROOT)
    public List<CategoriaTreeDto> getTree(@RequestParam("userId") Long userId) {
        return this.treeService.getCategorieTree(userId);
    }

}
