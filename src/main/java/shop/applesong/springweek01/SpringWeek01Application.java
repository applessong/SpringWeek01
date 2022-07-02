package shop.applesong.springweek01;

import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import shop.applesong.springweek01.domain.Course;
import shop.applesong.springweek01.domain.CourseRepository;
import shop.applesong.springweek01.domain.CourseRequestDto;
import shop.applesong.springweek01.service.CourseService;

import java.util.List;
@EnableJpaAuditing
@SpringBootApplication
@NoArgsConstructor
public class SpringWeek01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringWeek01Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            CourseRequestDto requestDto = new CourseRequestDto("호두쿵야의 봄, Applesong", "김송이");
            courseService.update(1L, requestDto);
            courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
//            courseRepository.deleteAll();    데이터 삭제하는 메소드
        };
    }



    // Week02Application.java 의 main 함수 아래에 붙여주세요.
//    @Bean
//    public CommandLineRunner demo(CourseRepository repository) {
//        return (args) -> {
//            // 데이터 저장하기
//            repository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));
//
//// 데이터 전부 조회하기
//            List<Course> courseList = repository.findAll();
//            for (int i=0; i<courseList.size(); i++) {
//                Course course = courseList.get(i);
//                System.out.println(course.getId());
//                System.out.println(course.getTitle());
//                System.out.println(course.getTutor());
//            }
//
//// 데이터 하나 조회하기                          //long타입이라서L... 롱타입 데이터가 한가지가 아니면 어떡하죵?
//            Course course = repository.findById(2L).orElseThrow(    //해당 인덱스에 데이터가 없을 때 처리 방법 괄호안에 메소드를 만들어줌
//                    () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
//            );
//        };
//    }
}
