package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
//@Setter // 가급적 @Setter 보다는 의미있는 네이밍의 method 사용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"}) // 연관관계 필드는 toString 안하는게 좋음
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id") // DB 테이블명을 id에 붙여주는 것이 좋음
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeUsername(String username) {
        this.username = username;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this); // 엔티티 안에 이 로직이 들어와 있는 거 확인
    }
}