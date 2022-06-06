package de.europace.documentclassifier.request;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesRequest {
    private List<String> categories;
}
