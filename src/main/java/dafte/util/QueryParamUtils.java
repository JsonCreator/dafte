package dafte.util;

import com.google.cloud.functions.HttpRequest;
import org.apache.commons.collections4.CollectionUtils;
import spark.Request;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QueryParamUtils {

    public enum QueryParam {
        NAME,
        SHAPE;

        public Set<String> getVariants() {
            return Set.of(
                    this.name(), // Uppercase is default
                    this.name().toLowerCase());
        }
    }

    public static String extractSingleParam(QueryParam queryParam, Request request) {
        return extractSingleParam(queryParam, coerceSparkRequest(request));
    }

    public static String extractSingleParam(QueryParam queryParam, HttpRequest request) {
        return extractSingleParam(queryParam, request.getQueryParameters());
    }

    private static String extractSingleParam(QueryParam queryParam, Map<String, List<String>> requestParams) {
        Set<String> paramVariants = queryParam.getVariants();

        String variantInUse = findMatchingVariant(requestParams.keySet(), paramVariants);

        if (variantInUse != null &&
                !requestParams.get(variantInUse).isEmpty()) {
            return requestParams.get(variantInUse).get(0);
        }

        return null;
    }

    private static Map<String, List<String>> coerceSparkRequest(Request request) {
        Map<String, List<String>> convertedMap = new HashMap<>();
        for (Map.Entry<String, String[]> entry : request.queryMap().toMap().entrySet()) {
            convertedMap.put(entry.getKey(), Arrays.asList(entry.getValue()));
        }
        return convertedMap;
    }

    private static String findMatchingVariant(Set<String> parameters, Set<String> paramVariants) {
        Collection<String> matchedVariants = CollectionUtils.intersection(parameters, paramVariants);

        return matchedVariants.stream().findFirst().orElse(null);
    }

}
