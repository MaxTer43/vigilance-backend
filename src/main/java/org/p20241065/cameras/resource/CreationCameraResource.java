package org.p20241065.cameras.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreationCameraResource {

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String location;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Long unit;
}
