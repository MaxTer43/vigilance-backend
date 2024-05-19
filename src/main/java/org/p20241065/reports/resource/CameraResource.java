package org.p20241065.reports.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReportResource {
    private Long id;
    private String textQuery;
    private Integer initialSamples;
    private Long authorId;
}
