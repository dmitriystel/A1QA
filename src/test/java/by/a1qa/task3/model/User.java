package by.a1qa.task3.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;
}
