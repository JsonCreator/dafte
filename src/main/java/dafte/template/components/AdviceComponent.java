package dafte.template.components;

import com.google.common.collect.ImmutableList;

import java.util.Random;

public abstract class AdviceComponent {

    protected static final String FALLBACK_STRING = "oh noes";

    protected abstract ImmutableList<String> getValues();

    public String getComponentValue(Random randomSeed) {
        ImmutableList<String> values = getValues();
        if (values.isEmpty()) {
            return FALLBACK_STRING;
        }

        return values.get(randomSeed.nextInt(values.size()));
    }
}
