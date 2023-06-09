package study.datajpa.dto;

import lombok.Data;
import study.datajpa.entity.Member;

@Data //Entity에는 @Gettter @Setter 다 들어가 있는 @Data 안쓰는게 좋음
public class MemberDto {

    private Long id;
    private String username;
    private String teamName;

    public MemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }

    public MemberDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
    }
}
