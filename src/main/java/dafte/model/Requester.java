package dafte.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Requester {

    private String name;
    private LocalDate requestedOn;
}
