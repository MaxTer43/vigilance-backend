package org.p20241065.reports.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.awt.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreationReportResource {

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String dateTime;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String trackingLink;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Image image;
}
