package apisdk.foo;

import apisdk.foo.bar.BarRequestBuilder;
import apisdk.foo.item.FooItemRequestBuilder;
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
     * Gets an item from the apiSdk.foo.item collection
     * @param id Unique identifier of the item
     * @return a {@link FooItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public FooItemRequestBuilder byId(@jakarta.annotation.Nonnull final String id) {
        Objects.requireNonNull(id);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("id", id);
        return new FooItemRequestBuilder(urlTplParams, requestAdapter);
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
