package org.p20241065.cameras.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CameraResource {
    private Long id;
    private String textQuery;
    private Integer initialSamples;
    private Long authorId;
}
