package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {
//    @NotNull // null을 허용하지 않음
//    @NotEmpty // null, ""을 허용하지 않음
//    @NotBlank // null, "", " " 모두 허용하지 않음.
    private String name;
    private String nickName;

    @YearMonth
    private String birthDate;

    @Size(min = 1, max = 12) // password 길이를 1~12로 지정
    @NotBlank
    private String password;

    @Min(1)
    @Max(100) // 1살부터 100살까지 허용
    @NotNull // 문자가 아니므로 NotBlank 사용 불가
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.") // 휴대전화 정규식 적용
    private String phoneNumber;

    @FutureOrPresent // 미래 혹은 지금
    private LocalDateTime registerAt;

    @AssertTrue(message = "name과 nickName 둘 중 하나 이상은 존재해야 합니다.")
    public boolean isNameDuplicated() { // @AssertTrue는 is로 시작하고 boolean을 반환하는 메소드를 작성해야 한다 !!

        if (!name.isBlank() && Objects.nonNull(name)) { // name이 존재하거나
            return true;
        }

        if (!nickName.isBlank() && Objects.nonNull(nickName)) { // nickName이 존재하면 true
            return true;
        }

        return false;
    }
}
