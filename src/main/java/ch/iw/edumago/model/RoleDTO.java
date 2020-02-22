package ch.iw.edumago.model;

import ch.iw.edumago.persistency.entity.ERole;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Long id;
    private ERole name;
}
