package voidX.project.hrMan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import voidX.project.hrMan.model.audit.DateAudit;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "USER")
public class User extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Size(max = 50)
    private String mobile;

    @NotNull
    private LocalDate dob;

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    @JsonIgnore
    @Column(nullable = false, length = 60)
    private String password;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "adminid",referencedColumnName = "admin_id")
    private Admin admin;

    @ManyToMany
    @JoinTable(
            name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
