package wolox.training.models;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Professor extends User {
    @Getter @Setter private String subject;
}
