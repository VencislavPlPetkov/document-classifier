package de.europace.documentclassifier.domain;

import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocumentsMetadata {
    private int totalNumberOfDocuments;
    private int numberOfDeletedDocuments;
    private BigInteger totalSize;
    private BigInteger averageSizeOfDocuments;
}
