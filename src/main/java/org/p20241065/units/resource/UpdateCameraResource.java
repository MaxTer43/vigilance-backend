package org.p20241065.units.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class UpdateUnitResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String textQuery;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Integer initialSamples;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Long authorId;
}
