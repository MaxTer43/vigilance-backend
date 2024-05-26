package org.p20241065.reports.resource;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReportResource {
    private Long id;
    private String dateTime;
    private String address;
    private String trackingLink;
    private Image image;
}
