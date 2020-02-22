package ch.iw.edumago.persistency.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class UserEntity {

    public UserEntity(Long id, String firstName, String lastName,
                      String registerId, Timestamp registerDate, Timestamp lastUpdatedDate, Set<RoleEntity> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName =lastName;
        this.registerId = registerId;
        this.registerDate = registerDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min=3)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min=3)
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "register_id")
    private String registerId;

    @CreationTimestamp
    @Column(name = "register_date", insertable = false, updatable = false)
    private Timestamp registerDate;

    @UpdateTimestamp
    @Column(name = "register_date", insertable = false)
    private Timestamp lastUpdatedDate;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();
}
