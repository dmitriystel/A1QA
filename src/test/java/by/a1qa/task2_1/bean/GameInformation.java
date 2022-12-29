package by.a1qa.task2_1.bean;

import lombok.*;

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