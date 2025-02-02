<?php

namespace ApiSdk\Foo;

use ApiSdk\Foo\Bar\BarRequestBuilder;
use ApiSdk\Foo\Item\FooItemRequestBuilder;
use Microsoft\Kiota\Abstractions\BaseRequestBuilder;
use Microsoft\Kiota\Abstractions\RequestAdapter;

/**
 * Builds and executes requests for operations under /foo
*/
class FooRequestBuilder extends BaseRequestBuilder 
{
    /**
     * The bar property
    */
    public function bar(): BarRequestBuilder {
        return new BarRequestBuilder($this->pathParameters, $this->requestAdapter);
    }
    
    /**
     * Gets an item from the apiSdk.foo.item collection
     * @param string $id Unique identifier of the item
     * @return FooItemRequestBuilder
    */
    public function byId(string $id): FooItemRequestBuilder {
        $urlTplParams = $this->pathParameters;
        $urlTplParams['id'] = $id;
        return new FooItemRequestBuilder($urlTplParams, $this->requestAdapter);
    }

    /**
     * Instantiates a new FooRequestBuilder and sets the default values.
     * @param array<string, mixed>|string $pathParametersOrRawUrl Path parameters for the request or a String representing the raw URL.
     * @param RequestAdapter $requestAdapter The request adapter to use to execute the requests.
    */
    public function __construct($pathParametersOrRawUrl, RequestAdapter $requestAdapter) {
        parent::__construct($requestAdapter, [], '{+baseurl}/foo');
        if (is_array($pathParametersOrRawUrl)) {
            $this->pathParameters = $pathParametersOrRawUrl;
        } else {
            $this->pathParameters = ['request-raw-url' => $pathParametersOrRawUrl];
        }
    }

}
