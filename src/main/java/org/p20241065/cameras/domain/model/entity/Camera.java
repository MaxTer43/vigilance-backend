package org.p20241065.cameras.domain.model.entity;

import org.p20241065.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cameras")
public class Camera extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String location;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Integer unit;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Long cameraId;
}
