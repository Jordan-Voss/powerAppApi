//package com.jordan.powerApp.models;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "user-exercise",
//        uniqueConstraints = { @UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email") })
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserExercise {
//
//    @Id
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinTable( name = "Answer", joinColumns = @JoinColumn ( name = "question_id"), inverseJoinColumns = @JoinColumn( name = "option_id"))
//    private Long userId;
//
//    private List<Exercise> exerciseList;
//}
