package functions.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Advice {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final String preparedFor;

    private final LocalDate date;

    private final String advice;
}
