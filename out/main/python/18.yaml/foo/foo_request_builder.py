from __future__ import annotations
from kiota_abstractions.base_request_builder import BaseRequestBuilder
from kiota_abstractions.get_path_parameters import get_path_parameters
from kiota_abstractions.request_adapter import RequestAdapter
from typing import Any, Callable, Dict, List, Optional, TYPE_CHECKING, Union

if TYPE_CHECKING:
    from .bar.bar_request_builder import BarRequestBuilder
    from .item.foo_item_request_builder import FooItemRequestBuilder

class FooRequestBuilder(BaseRequestBuilder):
    """
    Builds and executes requests for operations under /foo
    """
    def __init__(self,request_adapter: RequestAdapter, path_parameters: Union[str, Dict[str, Any]]) -> None:
        """
        Instantiates a new FooRequestBuilder and sets the default values.
        param path_parameters: The raw url or the url-template parameters for the request.
        param request_adapter: The request adapter to use to execute the requests.
        Returns: None
        """
        super().__init__(request_adapter, "{+baseurl}/foo", path_parameters)
    
    def by_id(self,id: str) -> FooItemRequestBuilder:
        """
        Gets an item from the apiSdk.foo.item collection
        param id: Unique identifier of the item
        Returns: FooItemRequestBuilder
        """
        if id is None:
            raise TypeError("id cannot be null.")
        from .item.foo_item_request_builder import FooItemRequestBuilder

        url_tpl_params = get_path_parameters(self.path_parameters)
        url_tpl_params["id"] = id
        return FooItemRequestBuilder(self.request_adapter, url_tpl_params)
    
    @property
    def bar(self) -> BarRequestBuilder:
        """
        The bar property
        """
        from .bar.bar_request_builder import BarRequestBuilder

        return BarRequestBuilder(self.request_adapter, self.path_parameters)
    

