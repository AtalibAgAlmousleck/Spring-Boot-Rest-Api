package com.codinglevel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;

    private Long age = 0L;

    @NotBlank(message = "Location is required")
    private String location;

    @Email(message = "Enter valid email")
    private String email;

    @NotBlank(message = "Department is required")
    private String department;

    @JsonIgnore
    @NotBlank(message = "Password is required")
    private String password;

    @CreationTimestamp
    @Column(
            name = "create_date", nullable = false, updatable = false
    )
    private Date createAt;

    @UpdateTimestamp
    @Column(
            name = "update_date", nullable = false, updatable = false
    )
    private Date updateAt;
}
