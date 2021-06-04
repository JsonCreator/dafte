package dafte.template.components;

import com.google.common.collect.ImmutableList;

public class Pairing extends AdviceComponent {

    private static final ImmutableList<String> PAIRINGS = ImmutableList.of(
            "but do not",
            "yet neglect to",
            "while pretending to",
            "without deciding to",
            "and also",
            "instead of trying to");

    @Override
    protected ImmutableList<String> getValues() {
        return PAIRINGS;
    }
}
