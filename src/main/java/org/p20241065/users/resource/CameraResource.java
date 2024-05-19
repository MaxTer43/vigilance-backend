package org.p20241065.users.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Long id;
    private String textQuery;
    private Integer initialSamples;
    private Long authorId;
}
