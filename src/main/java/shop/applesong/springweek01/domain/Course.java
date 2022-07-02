package shop.applesong.springweek01.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter     //게터를 자동으로 생성해줌
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Course extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;
//
//    public Long getId(){ return this.id; }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public String getTutor() {
//        return this.tutor;
//    }
////      세터 없는이유 리포지토리에서 자동으로 해줌
////      id는 데이터베이스가 쓰는거라서 id는 게터/세터 설정X
    public  Course (CourseRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public void update(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
}