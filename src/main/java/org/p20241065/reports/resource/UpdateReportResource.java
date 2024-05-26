package org.p20241065.reports.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.awt.*;

@Setter
@Getter
public class UpdateReportResource {

    private Long id;

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
