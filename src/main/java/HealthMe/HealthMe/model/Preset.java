package HealthMe.HealthMe.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @Getter : 객체의 속성(property) 값을 반환하는 메서드를 어노테이션으로 지원 (lombok)
 * @Setter : 객체의 속성 값을 설정, 변경하는 메서드를 어노테이션으로 지원 (lombok)
 * @Entity : JPA에서 지원하는 어노테이션으로, DB에서 Table을 생성
 * @Entity(name = value) : name = 속성 사용시 해당 Table의 이름을 클래스 명이 아닌 value로 지정가능
 * @ID : 해당 필드를 Primary key로 설정하는 어노테이션
 * @Column(name = value) : 해당 컬럼의 이름을 value로 지정해주는 어노테이션의 속성
 * @CreationTimestamp : 타임스테프를 찍기 위한 어노테이션
 * @OneToOne : 1:1 매핑방식 (JPA 매핑 전략 참고) 부모와 자식을 1:1로 매핑시켜줌
 * @ManyToOne : N:1 매핑방식 외래키(자식)을 N으로, 부모를 1로 지정하고 매핑시켜줌
 * ex) team과 member의 경우 1팀에(one) 여러 member들(many)이 있을 수 있음.
 *      이때 menber와 team을 ManyToOne으로 mapping
 *      앞 단어가 주체가 됨. (ManyToOne -> Many가 주체)
 * @OneToMany, @ManyToMany : 잘 안씀
 * @JoinColumn(name = value) : 해당 value와 mapping을 도와주는 어노테이션
 */
@Getter
@Setter
@Entity(name = "PRESET")
public class Preset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRESET_ID")
    private Long id;    // pk를 위한 id

    private String email;   // user 구분을 위한 email

    private Long presetNumber;  // 프리셋 번호

    private String exerciseName;    // 운동 명
    private Double weight;  // 무게

    private Integer setCount;   // 세트 수

    private Integer repetitionCount;    // 반복 횟수

    private Integer restTime;   // 쉬는 시간 (나중에 시간 자료형으로 변경 계획 있음)

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}