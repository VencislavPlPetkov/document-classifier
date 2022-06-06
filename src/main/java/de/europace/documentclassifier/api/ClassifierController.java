package de.europace.documentclassifier.api;

import de.europace.documentclassifier.dataaccess.document.DocumentClient;
import de.europace.documentclassifier.request.CategoriesRequest;
import de.europace.documentclassifier.domain.Document;
import de.europace.documentclassifier.domain.DocumentsMetadata;
import de.europace.documentclassifier.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/documents")
public class ClassifierController {

    private final DocumentClient documentClient;
    private final DocumentService documentService;

    @GetMapping ("/metadata")
    public ResponseEntity<DocumentsMetadata> getDocumentsMetadata() {

        List<Document> documentList = documentClient.getData();

        DocumentsMetadata metadata = documentService.setDocumentsMetadata(documentList);

        return ResponseEntity.ok(metadata);
    }

    @PostMapping ("/filter/categories")
    public ResponseEntity<List<Document>> filterByCategory(@RequestBody CategoriesRequest filterCategories) {

        List<Document> documentList = documentClient.getData();

        List<Document> filtered = documentService.filterByCategories(documentList, filterCategories.getCategories());

        return ResponseEntity.ok(filtered);
    }


}
