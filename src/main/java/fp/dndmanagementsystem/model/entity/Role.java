package fp.dndmanagementsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="roles")
public class Role {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public @NotNull RoleEnum getRole() {
        return role;
    }

    public void setRole(@NotNull RoleEnum role) {
        this.role = role;
    }
}
