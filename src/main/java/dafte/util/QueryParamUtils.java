package dafte.util;

import com.google.cloud.functions.HttpRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
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

    public static String extractSingleParam(QueryParam queryParam, HttpRequest request) {
        Set<String> paramVariants = queryParam.getVariants();

        String variantInUse = findMatchingVariant(request.getQueryParameters().keySet(), paramVariants);

        if (variantInUse != null &&
                !request.getQueryParameters().get(variantInUse).isEmpty()) {
            return request.getQueryParameters().get(variantInUse).get(0);
        }

        return null;
    }

    private static String findMatchingVariant(Set<String> parameters, Set<String> paramVariants) {
        Collection<String> matchedVariants = CollectionUtils.intersection(parameters, paramVariants);

        return matchedVariants.stream().findFirst().orElse(null);
    }

}
