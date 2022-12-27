package by.a1qa.task2_1.bean;

import lombok.*;

/*
Code review 23.12.2022
1st comment: Class fields must have access modifiers. To limit the scope properly
fixed: fields are private

2nd comment: constructor and some of the getters/setters are not used anywhere.
You don't want to clog the project with unused code. For convenient work with models, I recommend using lombok
fixed:lombok used
*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class GameInformation {
    private String title;
    private Platform platform;
    private String releaseDate;
    private String reviewSummaryResult;
    private String price;
}