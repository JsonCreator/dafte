package dafte.template.components;

import com.google.common.collect.ImmutableList;

public class Redirection extends AdviceComponent {

    private static final ImmutableList<String> REDIRECTIONS = ImmutableList.of(
            "then perhaps it's better to",
            "listen to the voice telling you to",
            "avoid the desire to",
            "plan accordingly to",
            "give others space to",
            "allow someone else an opportunity to",
            "then delegate the responsibility to",
            "revisit the decision to",
            "ignore the impulse to",
            "consider this a sign to",
            "then direct your vigor to",
            "instead harness the passion to");

    @Override
    protected ImmutableList<String> getValues() {
        return REDIRECTIONS;
    }
}
