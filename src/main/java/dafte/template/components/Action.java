package dafte.template.components;

import com.google.common.collect.ImmutableList;

public class Action extends AdviceComponent {

    private static final ImmutableList<String> ACTIONS = ImmutableList.of(
            "release to prod",
            "push directly to main",
            "schedule a meeting",
            "review that PR",
            "rebase develop",
            "call a parent",
            "take your PTO",
            "emotionally divest from your work",
            "find yourself on-call",
            "give peer feedback",
            "re-write the world",
            "re-invent an established library",
            "submit a support request",
            "mind your damn business",
            "go afk for a little while",
            "skip the meeting",
            "squash a bug",
            "report it upstream",
            "consult an adult",
            "touch grass",
            "make lunch",
            "delete that email",
            "talk to HR",
            "solve a theoretical problem");

    @Override
    protected ImmutableList<String> getValues() {
        return ACTIONS;
    }
}
