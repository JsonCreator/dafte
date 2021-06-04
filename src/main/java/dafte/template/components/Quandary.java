package dafte.template.components;

import com.google.common.collect.ImmutableList;

public class Quandary extends AdviceComponent {

    private static final ImmutableList<String> QUANDARIES = ImmutableList.of(
            "consider",
            "reflect on the possibility",
            "some days we realize",
            "may you notice",
            "accept",
            "your peers agree",
            "empower yourself to believe",
            "mistakes can teach us",
            "yesterday's accomplishments remind us",
            "silence won't erase the fact",
            "embrace the magic in admitting",
            "reject the notion");

    @Override
    protected ImmutableList<String> getValues() {
        return QUANDARIES;
    }
}
