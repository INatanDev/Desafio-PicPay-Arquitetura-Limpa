package br.com.inatandev.infrastruture.entity;

import br.com.inatandev.core.domain.enums.UserTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity {

    @Column(name = "Id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Email", nullable = false,  unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "TaxNumber", nullable = false,   unique = true)
    private String taxNumber;

    @Column(name = "Fullname", nullable = false)
    private String fullName;

    @Column(name = "Type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum type;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

}
