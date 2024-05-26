package org.p20241065.reports.domain.model.entity;

import lombok.*;
import org.p20241065.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.awt.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reports")
public class Report extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
