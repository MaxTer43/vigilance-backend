package org.p20241065.users.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreationUserResource {

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
