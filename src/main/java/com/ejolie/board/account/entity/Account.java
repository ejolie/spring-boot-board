package com.ejolie.board.account.entity;

import com.ejolie.board.article.entity.Article;
import com.ejolie.board.common.entity.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @ToString
@Table(name = "account")
@Entity
public class Account extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "author")
    private List<Article> articles = new ArrayList<>();

    private LocalDateTime lastLoginAt;

    @Builder
    public Account(String userName, String userId, String password, String email, String phone) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    /**
     * 궁금점: DTO로 받을지? 필드별로 받을지? Entity에서 update메서드를?
     * cf. 역할과 책임의 문제 / DDD
     * 엔티티가 DTO와 dependency문제..
     * update 종류별로 메서드명
     */
    public void update(String userName, String password, String email, String phone) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
