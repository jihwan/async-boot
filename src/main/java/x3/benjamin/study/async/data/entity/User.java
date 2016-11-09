package x3.benjamin.study.async.data.entity;

import lombok.*;
import x3.benjamin.study.async.data.Sex;

/**
 * Created by benjamin on 2016. 11. 4..
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int age;
    private String name;
    private String phoneNumber;
    private Sex sex;
}