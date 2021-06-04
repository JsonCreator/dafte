package dafte.template.components;

import com.google.common.collect.ImmutableList;

public class Redirection extends AdviceComponent {

    private static final ImmutableList<String> REDIRECTIONS = ImmutableList.of(
            "then perhaps it's better",
            "listen to the voice telling you",
            "avoid the desire",
            "plan accordingly",
            "give others space",
            "allow someone else an opportunity",
            "then delegate the responsibility",
            "revisit the decision",
            "ignore the impulse",
            "consider this a sign",
            "then direct your vigor",
            "instead harness the passion");

    @Override
    protected ImmutableList<String> getValues() {
        return REDIRECTIONS;
    }
}
