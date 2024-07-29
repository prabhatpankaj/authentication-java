package com.techbellys.authentication.controller;

import com.techbellys.authentication.envers.AuditEnversInfo;
import com.techbellys.authentication.model.Product;
import com.techbellys.authentication.repository.ProductRevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.data.history.RevisionMetadata;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products-history")
public class ProductHistoryController {

    @Autowired
    private ProductRevisionRepository productRevisionRepository;

    @GetMapping("/revisions/{id}")
    public List<Product> GetProductRevisions(@PathVariable Integer id) {
        return productRevisionRepository.findRevisions(id).stream().map(Revision::getEntity).toList();
    }

    @GetMapping("/creater/{id}")
    public String getCreatorUsername(@PathVariable Integer id) {
        Revision<Integer, Product> revision = productRevisionRepository.findRevision(id,1).orElseThrow();
        RevisionMetadata<Integer> metadata = revision.getMetadata();
        AuditEnversInfo auditEnversInfo = metadata.getDelegate();
        return auditEnversInfo.getUsername();
    }

}
