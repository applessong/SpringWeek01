package shop.applesong.springweek01.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.applesong.springweek01.domain.Course;
import shop.applesong.springweek01.domain.CourseRepository;
import shop.applesong.springweek01.domain.CourseRequestDto;

import javax.transaction.Transactional;
@RequiredArgsConstructor    //꼭 필요한 멤버변수를 만들 때 필요한 생성자를 자동으로 만들어줌!!
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CourseService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final CourseRepository courseRepository;

    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌

//    public CourseService(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }             //요거 생성잔데 9행에서 쓴거때메 없어도댐!!


    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, CourseRequestDto requestDto) {
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        course1.update(requestDto);
        return course1.getId();
    }
}