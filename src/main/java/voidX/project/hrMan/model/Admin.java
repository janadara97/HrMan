package voidX.project.hrMan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int adminId;



    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName ="userId")
    private User user;

}