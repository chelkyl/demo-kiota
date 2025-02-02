<?php

namespace ApiSdk\Item;

use ApiSdk\Item\Item\WithIdRequestBuilder;
use Microsoft\Kiota\Abstractions\BaseRequestBuilder;
use Microsoft\Kiota\Abstractions\RequestAdapter;

/**
 * Builds and executes requests for operations under /{path}
*/
class WithPathItemRequestBuilder extends BaseRequestBuilder 
{
    /**
     * Instantiates a new WithPathItemRequestBuilder and sets the default values.
     * @param array<string, mixed>|string $pathParametersOrRawUrl Path parameters for the request or a String representing the raw URL.
     * @param RequestAdapter $requestAdapter The request adapter to use to execute the requests.
    */
    public function __construct($pathParametersOrRawUrl, RequestAdapter $requestAdapter) {
        parent::__construct($requestAdapter, [], '{+baseurl}/{path}');
        if (is_array($pathParametersOrRawUrl)) {
            $this->pathParameters = $pathParametersOrRawUrl;
        } else {
            $this->pathParameters = ['request-raw-url' => $pathParametersOrRawUrl];
        }
    }

    /**
     * Builds and executes requests for operations under /{path}/{id}/
     * @return WithIdRequestBuilder
    */
    public function withId(): WithIdRequestBuilder {
        return new WithIdRequestBuilder($this->pathParameters, $this->requestAdapter);
    }

}
