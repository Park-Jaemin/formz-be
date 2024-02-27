package ForMZ.Server.domain.user.entity;

import ForMZ.Server.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Email
    @Column(nullable = false)
    private String email;

    @Valid
    @Column(nullable = false)
    private String password;

    @Column
    private String nickName;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private SignType signType;

    public enum Role{
        USER,
        ADMIN
    }

    public enum SignType{
        USUAL,
        GOOGLE,
        KAKAO
    }
}