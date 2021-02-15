package timetracker.demo.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User implements Cloneable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Required not blank field.")
    @Column(name = "first_name", length = 20)
    private String firstName;
    @NotBlank(message = "Required not blank field.")
    @Column(name = "sur_name", length = 20)
    private String surName;
    @NotBlank(message = "Required not blank field.")
    @Length(min = 3, message = "Required min 3 symbols!")
    @Column(name = "login", length = 20)
    private String login;
    @NotBlank(message = "Required not blank field.")
    @Column(name = "password", length = 20)
    private String password;
    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;
    @Column(name = "request_add", length = 20)
    private Boolean requestAdd;

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
