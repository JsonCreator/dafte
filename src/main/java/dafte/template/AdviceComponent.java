package dafte.template;

import com.google.common.collect.ImmutableList;

import java.util.Random;

public enum AdviceComponent {

    PONDER(ImmutableList.of(
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
            "Reject the notion")),
    DIRECTION(ImmutableList.of(
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
            "overthinking the possibilities is no way to")),
    ACTION(ImmutableList.of(
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
            "touch some grass",
            "make lunch",
            "delete that email",
            "talk to HR",
            "solve a theoretical problem")),
    IMPETUOUS(ImmutableList.of(
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
            "animosity")),
    REACTION(ImmutableList.of(
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
            "harms the profit margins")),
    ALTERNATE(ImmutableList.of(
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
            "instead harness the passion to"));

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
