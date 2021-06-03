package dafte.model;

import com.google.cloud.functions.HttpRequest;
import org.apache.commons.collections4.CollectionUtils;
import spark.Request;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DafteRequest {

    public enum QueryParam {
        NAME,
        SHAPE;

        public Set<String> getVariants() {
            return Set.of(
                    this.name(), // Uppercase is default
                    this.name().toLowerCase());
        }
    }

    private final Map<String, List<String>> parameters;

    public DafteRequest(Request request) {
        parameters = coerceSparkRequest(request);
    }

    public DafteRequest(HttpRequest request) {
        parameters = request.getQueryParameters();
    }

    public String getOneParamValue(QueryParam queryParam) {
        String variantInUse = findMatchingVariant(parameters.keySet(), queryParam.getVariants());

        if (variantInUse != null &&
                !parameters.get(variantInUse).isEmpty()) {
            return parameters.get(variantInUse).get(0);
        }

        return null;
    }

    private static String findMatchingVariant(Set<String> parameters, Set<String> paramVariants) {
        Collection<String> matchedVariants = CollectionUtils.intersection(parameters, paramVariants);

        return matchedVariants.stream().findFirst().orElse(null);
    }

    private static Map<String, List<String>> coerceSparkRequest(Request request) {
        Map<String, List<String>> convertedMap = new HashMap<>();
        for (Map.Entry<String, String[]> entry : request.queryMap().toMap().entrySet()) {
            convertedMap.put(entry.getKey(), Arrays.asList(entry.getValue()));
        }
        return convertedMap;
    }
}
