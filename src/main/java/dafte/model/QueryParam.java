package dafte.model;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public enum QueryParam {
    NAME,
    SHAPE;

    public String getOneFrom(Map<String, List<String>> queryParameterMap) {
        String variantInUse = findMatchingVariant(queryParameterMap.keySet());

        if (variantInUse != null ) {
            List<String> values = queryParameterMap.get(variantInUse);

            if (values != null && !values.isEmpty()) {
                return values.get(0);
            }
        }

        return null;
    }

    private Set<String> getVariants() {
        return Set.of(
                this.name(), // Uppercase is default
                this.name().toLowerCase());
    }

    private String findMatchingVariant(Set<String> parameters) {
        return CollectionUtils.intersection(parameters, getVariants())
                .stream()
                .findFirst()
                .orElse(null);
    }
}
