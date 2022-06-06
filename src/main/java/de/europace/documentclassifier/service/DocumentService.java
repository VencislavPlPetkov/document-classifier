package de.europace.documentclassifier.service;

import de.europace.documentclassifier.domain.Document;
import de.europace.documentclassifier.domain.DocumentsMetadata;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DocumentService {

    DocumentsMetadata setDocumentsMetadata(List<Document> documentList);

    List<Document> filterByCategories(List<Document> documentList, List<String> categories);
}
