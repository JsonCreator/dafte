package dafte.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Requester {

    private final String name;
    private final LocalDate requestedOn;

    public Requester(String name) {
        this.name = name;
        this.requestedOn = LocalDate.now();
    }
}
