package dafte.template.components;

import com.google.common.collect.ImmutableList;

public class Reaction extends AdviceComponent {

    private static final ImmutableList<String> REACTIONS = ImmutableList.of(
            "makes you squeamish",
            "tickles your fancy",
            "emboldens you",
            "causes discomfort",
            "perpetuates the mood in the room",
            "complicates the simple things",
            "breaks the build",
            "obfuscates the obvious",
            "abstracts the problem",
            "derives no pleasure",
            "weakens your constitution",
            "harms the profit margins");

    @Override
    protected ImmutableList<String> getValues() {
        return REACTIONS;
    }
}
