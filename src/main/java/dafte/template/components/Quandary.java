package dafte.template.components;

import com.google.common.collect.ImmutableList;

public class Quandary extends AdviceComponent {

    private static final ImmutableList<String> QUANDARIES = ImmutableList.of(
            "Consider",
            "Reflect on the possibility",
            "Some days we realize",
            "May you notice",
            "Accept",
            "Your peers agree",
            "Empower yourself to believe",
            "Mistakes can teach us",
            "Yesterday's accomplishments remind us",
            "Silence won't erase the fact",
            "Embrace the magic in admitting",
            "Reject the notion");

    @Override
    protected ImmutableList<String> getValues() {
        return QUANDARIES;
    }
}
