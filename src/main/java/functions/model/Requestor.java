package functions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Requestor {

    private String name;
    private LocalDate requestedOn;
}
