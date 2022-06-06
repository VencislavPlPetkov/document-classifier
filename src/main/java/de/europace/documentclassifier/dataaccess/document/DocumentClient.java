package de.europace.documentclassifier.dataaccess.document;

import de.europace.documentclassifier.domain.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Array;
import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Component
@RequiredArgsConstructor
public class DocumentClient {

    @Value("${documents.api}")
    private String DOCUMENTS_URL;

    private final RestTemplate restTemplate;

    public List<Document> getData() {

        ResponseEntity<Document[]> responseEntity = restTemplate.getForEntity(DOCUMENTS_URL, Document[].class);
        Document[] objects = responseEntity.getBody();
        List<Document> documents = Arrays.asList(objects);

        return documents;
    }

}
