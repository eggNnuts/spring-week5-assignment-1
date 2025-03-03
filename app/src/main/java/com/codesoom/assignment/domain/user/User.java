package com.codesoom.assignment.domain.user;

import com.codesoom.assignment.domain.AbstractEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 사용자
 */
@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends AbstractEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    private String userName;
    private String email;
    private String password;

    @Builder
    public User(
       String userName,
       String email,
       String password
    ) {
        this.userName=userName;
        this.email=email;
        this.password=password;
    }
}
