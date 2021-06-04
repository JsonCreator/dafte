package dafte.template.components;

import com.google.common.collect.ImmutableList;

public class Impetus extends AdviceComponent {

    private static final ImmutableList<String> IMPETUSES = ImmutableList.of(
            "need",
            "desire",
            "motivation",
            "determination",
            "compulsion",
            "emotional investment",
            "peer pressure",
            "social impetuous",
            "level of commitment",
            "passion",
            "driving force",
            "animosity");

    @Override
    protected ImmutableList<String> getValues() {
        return IMPETUSES;
    }
}
