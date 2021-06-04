package dafte.template.components;

import com.google.common.collect.ImmutableList;

public class Facilitator extends AdviceComponent {

    private static final ImmutableList<String> FACILITATORS = ImmutableList.of(
            "today might not be the day to",
            "occasionally one must simply",
            "the risk is unusually high to",
            "tomorrow may be more agreeable to",
            "the outcome is too unpredictable to",
            "the future cannot ensure your ability to",
            "a modicum of humility can empower you to",
            "your attention to detail permits you to",
            "admitting your mistakes can lead you to",
            "re-framing you predicament will allow us to",
            "embracing your art will free you to",
            "overthinking the possibilities is no way to");

    @Override
    protected ImmutableList<String> getValues() {
        return FACILITATORS;
    }
}
