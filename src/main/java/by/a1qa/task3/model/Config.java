package by.a1qa.task3.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Config {
    private String browserName;
    private String url;
    private String waitDuration;
    private String options;

}
