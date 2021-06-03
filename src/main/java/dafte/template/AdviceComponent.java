package dafte.template;

import com.google.common.collect.ImmutableList;

import java.util.Random;

public enum AdviceComponent {

    PONDER(ImmutableList.of(
            "Consider",
            "Reflect on the possibility",
            "Some days we realize")),
    DIRECTION(ImmutableList.of(
            "today might not be the day to",
            "occasionally one must simply")),
    ACTION(ImmutableList.of(
            "release to prod",
            "push to main",
            "schedule a meeting"));

    public static final String NEVER_FAIL_FALLBACK_STRING = "oh noes";

    ImmutableList<String> values;

    AdviceComponent(ImmutableList<String> values) {
        this.values = values;
    }


    public String getComponentValue(Random randomSeed) {
        if (this.values.isEmpty()) {
            return NEVER_FAIL_FALLBACK_STRING;
        }

        return values.get(randomSeed.nextInt(values.size()));
    }
}
