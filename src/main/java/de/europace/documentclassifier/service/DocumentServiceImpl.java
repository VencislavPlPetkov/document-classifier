package de.europace.documentclassifier.service;

import de.europace.documentclassifier.domain.Document;
import de.europace.documentclassifier.domain.DocumentsMetadata;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class DocumentServiceImpl implements DocumentService {

    @Override
    public DocumentsMetadata setDocumentsMetadata(List<Document> documentList) {

        int deletedDocuments = 0;
        BigInteger totalSizeOfDocuments = BigInteger.valueOf(0);
        int totalNumberOfDocuments = documentList.size();

        for (Document document : documentList) {

            // Get size of document
            BigInteger sizeOfDocument = BigInteger.valueOf(document.getSize());
            totalSizeOfDocuments = totalSizeOfDocuments.add(sizeOfDocument);

            // Check if document is deleted
            if (document.getDeleted()) {
                deletedDocuments++;
            }

        }

        DocumentsMetadata metadata = new DocumentsMetadata();

        metadata.setTotalNumberOfDocuments(totalNumberOfDocuments);
        metadata.setNumberOfDeletedDocuments(deletedDocuments);
        metadata.setTotalSize(totalSizeOfDocuments);
        metadata.setAverageSizeOfDocuments(getAverageSizeOfDocuments(totalNumberOfDocuments, totalSizeOfDocuments));

        return metadata;
    }

    @Override
    public List<Document> filterByCategories(List<Document> documentList, List<String> filterCategories) {

        List<Document> filtered = new ArrayList<>();

        for (Document document : documentList) {
            boolean matchesFilter = false;

            for (String category:document.getCategories()) {

                if (filterCategories.contains(category)){
                    matchesFilter = true;
                } else {
                    matchesFilter = false;
                    break;
                }
            }
            if (matchesFilter) {
                filtered.add(document);
            }
        }

        return filtered;
    }

    private BigInteger getAverageSizeOfDocuments(int totalNumberOfDocuments, BigInteger totalSizeOfDocuments) {

        BigInteger totalNumberOfDocs = BigInteger.valueOf(totalNumberOfDocuments);

        return totalSizeOfDocuments.divide(totalNumberOfDocs);
    }

}
