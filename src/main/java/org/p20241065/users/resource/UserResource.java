package org.p20241065.users.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String headquarters;
}
