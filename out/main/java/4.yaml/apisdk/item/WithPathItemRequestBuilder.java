package apisdk.item;

import apisdk.item.item.WithIdRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /{path}
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class WithPathItemRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new {@link WithPathItemRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public WithPathItemRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/{path}", pathParameters);
    }
    /**
     * Instantiates a new {@link WithPathItemRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public WithPathItemRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/{path}", rawUrl);
    }
    /**
     * Builds and executes requests for operations under /{path}/{id}/
     * @return a {@link WithIdRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithIdRequestBuilder withId() {
        return new WithIdRequestBuilder(pathParameters, requestAdapter);
    }
}
