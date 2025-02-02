package apisdk.foo;

import apisdk.foo.bar.BarRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /foo
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class FooRequestBuilder extends BaseRequestBuilder {
    /**
     * The bar property
     * @return a {@link BarRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public BarRequestBuilder bar() {
        return new BarRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Instantiates a new {@link FooRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public FooRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/foo", pathParameters);
    }
    /**
     * Instantiates a new {@link FooRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public FooRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/foo", rawUrl);
    }
}
