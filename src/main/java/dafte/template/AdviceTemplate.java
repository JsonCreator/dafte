package dafte.template;

import dafte.template.components.AdviceComponent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AdviceTemplate {

    private final String template;

    private final List<AdviceComponent> components;

    public AdviceTemplate(String template, AdviceComponent... components) {
        this.template = template;
        this.components = Arrays.asList(components);
    }

    public String generate(Random randomSeed) {
        Object[] componentValues = components.stream()
                .map(component -> component.getComponentValue(randomSeed))
                .toArray();

        return String.format(template, componentValues);
    }


}
