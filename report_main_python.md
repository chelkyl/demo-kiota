<table>
  <thead>
    <tr>
      <th>Test URI Paths</th>
      <th>Python kiota main Results</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/1.yaml">1.yaml</a><br>
          /foo/<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          preserves trailing slash on single static route<br>
        </p>
        <pre>
./out/main/python/1.yaml          
├── api_sdk.py                    # main entry point
│                                 #   has `foo(self) -> FooRequestBuilder`
└── foo                           
    └── foo_request_builder.py    # UriTemplate = "{+baseurl}/foo/"
                                  # RequestBuilder has the standard methods
                                  #   and `with_url(self,raw_url: str) -> FooRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/2.yaml">2.yaml</a><br>
          /foo/bar/<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          preserves trailing slash on single static nested route<br>
        </p>
        <pre>
./out/main/python/2.yaml              
├── api_sdk.py                        # main entry point
│                                     #   has `foo(self) -> FooRequestBuilder`
└── foo                               
    ├── foo_request_builder.py        # UriTemplate = "{+baseurl}/foo"
    │                                 # RequestBuilder has `bar(self) -> BarRequestBuilder`
    └── bar                           
        └── bar_request_builder.py    # UriTemplate = "{+baseurl}/foo/bar/"
                                      # RequestBuilder has the standard methods
                                      #   and `with_url(self,raw_url: str) -> BarRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/3.yaml">3.yaml</a><br>
          /{path}/<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          preserves trailing slash on single dynamic route<br>
        </p>
        <pre>
./out/main/python/3.yaml                
├── api_sdk.py                          # main entry point
│                                       #   has 
└── item                                
    └── with_path_request_builder.py    # UriTemplate = "{+baseurl}/{path}/"
                                        # RequestBuilder has the standard methods
                                        #   and `with_url(self,raw_url: str) -> WithPathRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/4.yaml">4.yaml</a><br>
          /{path}/{id}/<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          preserves trailing slash on single dynamic nested route<br>
        </p>
        <pre>
./out/main/python/4.yaml                     
├── api_sdk.py                               # main entry point
│                                            #   has 
└── item                                     
    ├── with_path_item_request_builder.py    # UriTemplate = "{+baseurl}/{path}"
    │                                        # RequestBuilder has `with_id(self,) -> WithIdRequestBuilder`
    └── item                                 
        └── with_id_request_builder.py       # UriTemplate = "{+baseurl}/{path}/{id}/"
                                             # RequestBuilder has the standard methods
                                             #   and `with_url(self,raw_url: str) -> WithIdRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/5.yaml">5.yaml</a><br>
          /{path}/bar<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          supports single dynamic with nested static route<br>
        </p>
        <pre>
./out/main/python/5.yaml                     
├── api_sdk.py                               # main entry point
│                                            #   has 
└── item                                     
    ├── with_path_item_request_builder.py    # UriTemplate = "{+baseurl}/{path}"
    │                                        # RequestBuilder has `bar(self) -> BarRequestBuilder`
    └── bar                                  
        └── bar_request_builder.py           # UriTemplate = "{+baseurl}/{path}/bar"
                                             # RequestBuilder has the standard methods
                                             #   and `with_url(self,raw_url: str) -> BarRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/6.yaml">6.yaml</a><br>
          /foo<br>
          /foo/<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;🚫<br>
          missing /foo<br>
        </p>
        <pre>
./out/main/python/6.yaml          
├── api_sdk.py                    # main entry point
│                                 #   has `foo(self) -> FooRequestBuilder`
└── foo                           
    └── foo_request_builder.py    # UriTemplate = "{+baseurl}/foo/"
                                  # RequestBuilder has the standard methods
                                  #   and `Get`
                                  #   and `with_url(self,raw_url: str) -> FooRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/7.yaml">7.yaml</a><br>
          /foo/<br>
          /foo<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;🚫<br>
          missing /foo/<br>
          help doc references /foo/<br>
        </p>
        <pre>
./out/main/python/7.yaml          
├── api_sdk.py                    # main entry point
│                                 #   has `foo(self) -> FooRequestBuilder`
└── foo                           
    └── foo_request_builder.py    # UriTemplate = "{+baseurl}/foo"
                                  # RequestBuilder has the standard methods
                                  #   and `Get`
                                  #   and `with_url(self,raw_url: str) -> FooRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/8.yaml">8.yaml</a><br>
          /foo/<br>
          /foo/bar<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;🚫<br>
          missing /foo/<br>
        </p>
        <pre>
./out/main/python/8.yaml              
├── api_sdk.py                        # main entry point
│                                     #   has `foo(self) -> FooRequestBuilder`
└── foo                               
    ├── foo_request_builder.py        # UriTemplate = "{+baseurl}/foo"
    │                                 # RequestBuilder has the standard methods
    │                                 #   and `with_url(self,raw_url: str) -> FooRequestBuilder`
    │                                 #   and `bar(self) -> BarRequestBuilder`
    └── bar                           
        └── bar_request_builder.py    # UriTemplate = "{+baseurl}/foo/bar"
                                      # RequestBuilder has the standard methods
                                      #   and `with_url(self,raw_url: str) -> BarRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/9.yaml">9.yaml</a><br>
          /foo/<br>
          /foo/bar/<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;🚫<br>
          same as 8<br>
          missing /foo/<br>
        </p>
        <pre>
./out/main/python/9.yaml              
├── api_sdk.py                        # main entry point
│                                     #   has `foo(self) -> FooRequestBuilder`
└── foo                               
    ├── foo_request_builder.py        # UriTemplate = "{+baseurl}/foo"
    │                                 # RequestBuilder has the standard methods
    │                                 #   and `with_url(self,raw_url: str) -> FooRequestBuilder`
    │                                 #   and `bar(self) -> BarRequestBuilder`
    └── bar                           
        └── bar_request_builder.py    # UriTemplate = "{+baseurl}/foo/bar/"
                                      # RequestBuilder has the standard methods
                                      #   and `with_url(self,raw_url: str) -> BarRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/10.yaml">10.yaml</a><br>
          /foo<br>
          /{path}<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          /foo is handled separately from /{path}<br>
        </p>
        <pre>
./out/main/python/10.yaml                    
├── api_sdk.py                               # main entry point
│                                            #   has `foo(self) -> FooRequestBuilder`
├── foo                                      
│   └── foo_request_builder.py               # UriTemplate = "{+baseurl}/foo"
│                                            # RequestBuilder has the standard methods
│                                            #   and `with_url(self,raw_url: str) -> FooRequestBuilder`
└── item                                     
    └── with_path_item_request_builder.py    # UriTemplate = "{+baseurl}/{path}"
                                             # RequestBuilder has the standard methods
                                             #   and `with_url(self,raw_url: str) -> WithPathItemRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/11.yaml">11.yaml</a><br>
          /foo<br>
          /{path}/<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          /foo is handled separately from /{path}/<br>
          so same as 3<br>
        </p>
        <pre>
./out/main/python/11.yaml               
├── api_sdk.py                          # main entry point
│                                       #   has `foo(self) -> FooRequestBuilder`
├── foo                                 
│   └── foo_request_builder.py          # UriTemplate = "{+baseurl}/foo"
│                                       # RequestBuilder has the standard methods
│                                       #   and `with_url(self,raw_url: str) -> FooRequestBuilder`
└── item                                
    └── with_path_request_builder.py    # UriTemplate = "{+baseurl}/{path}/"
                                        # RequestBuilder has the standard methods
                                        #   and `with_url(self,raw_url: str) -> WithPathRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/12.yaml">12.yaml</a><br>
          /foo/<br>
          /{path}<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          /foo/ is handled separately from /{path}<br>
          so same as 1<br>
        </p>
        <pre>
./out/main/python/12.yaml                    
├── api_sdk.py                               # main entry point
│                                            #   has `foo(self) -> FooRequestBuilder`
├── foo                                      
│   └── foo_request_builder.py               # UriTemplate = "{+baseurl}/foo/"
│                                            # RequestBuilder has the standard methods
│                                            #   and `with_url(self,raw_url: str) -> FooRequestBuilder`
└── item                                     
    └── with_path_item_request_builder.py    # UriTemplate = "{+baseurl}/{path}"
                                             # RequestBuilder has the standard methods
                                             #   and `with_url(self,raw_url: str) -> WithPathItemRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/13.yaml">13.yaml</a><br>
          /foo/<br>
          /{path}/<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          /foo/ is handled separately from /{path}/<br>
          so same as 1 and 3<br>
        </p>
        <pre>
./out/main/python/13.yaml               
├── api_sdk.py                          # main entry point
│                                       #   has `foo(self) -> FooRequestBuilder`
├── foo                                 
│   └── foo_request_builder.py          # UriTemplate = "{+baseurl}/foo/"
│                                       # RequestBuilder has the standard methods
│                                       #   and `with_url(self,raw_url: str) -> FooRequestBuilder`
└── item                                
    └── with_path_request_builder.py    # UriTemplate = "{+baseurl}/{path}/"
                                        # RequestBuilder has the standard methods
                                        #   and `with_url(self,raw_url: str) -> WithPathRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/14.yaml">14.yaml</a><br>
          /{path}<br>
          /{path}/<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          /{path} and /{path}/ are handled separately<br>
        </p>
        <pre>
./out/main/python/14.yaml                    
├── api_sdk.py                               # main entry point
│                                            #   has 
└── item                                     
    ├── with_path_item_request_builder.py    # UriTemplate = "{+baseurl}/{path}"
    │                                        # RequestBuilder has the standard methods
    │                                        #   and `with_url(self,raw_url: str) -> WithPathItemRequestBuilder`
    └── with_path_request_builder.py         # UriTemplate = "{+baseurl}/{path}/"
                                             # RequestBuilder has the standard methods
                                             #   and `with_url(self,raw_url: str) -> WithPathRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/15.yaml">15.yaml</a><br>
          /{path}/<br>
          /{path}<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          same as 14<br>
        </p>
        <pre>
./out/main/python/15.yaml                    
├── api_sdk.py                               # main entry point
│                                            #   has 
└── item                                     
    ├── with_path_item_request_builder.py    # UriTemplate = "{+baseurl}/{path}"
    │                                        # RequestBuilder has the standard methods
    │                                        #   and `with_url(self,raw_url: str) -> WithPathItemRequestBuilder`
    └── with_path_request_builder.py         # UriTemplate = "{+baseurl}/{path}/"
                                             # RequestBuilder has the standard methods
                                             #   and `with_url(self,raw_url: str) -> WithPathRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/16.yaml">16.yaml</a><br>
          /{path}<br>
          /{path}/{id}<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          1 nested dynamic route with the same dynamic piece as another route<br>
        </p>
        <pre>
./out/main/python/16.yaml                    
├── api_sdk.py                               # main entry point
│                                            #   has 
└── item                                     
    ├── with_path_item_request_builder.py    # UriTemplate = "{+baseurl}/{path}"
    │                                        # RequestBuilder has the standard methods
    │                                        #   and `by_id(self,id: str) -> PathItemRequestBuilder`
    │                                        #   and `with_url(self,raw_url: str) -> WithPathItemRequestBuilder`
    └── item                                 
        └── path_item_request_builder.py     # UriTemplate = "{+baseurl}/{path}/{id}"
                                             # RequestBuilder has the standard methods
                                             #   and `with_url(self,raw_url: str) -> PathItemRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/17.yaml">17.yaml</a><br>
          /{path}/<br>
          /{path}/{id}<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          1 nested dynamic route with the same dynamic piece as another route (albeit with a trailing slash)<br>
        </p>
        <pre>
./out/main/python/17.yaml                    
├── api_sdk.py                               # main entry point
│                                            #   has 
└── item                                     
    ├── with_path_item_request_builder.py    # UriTemplate = "{+baseurl}/{path}"
    │                                        # RequestBuilder has `by_id(self,id: str) -> PathItemRequestBuilder`
    ├── with_path_request_builder.py         # UriTemplate = "{+baseurl}/{path}/"
    │                                        # RequestBuilder has the standard methods
    │                                        #   and `with_url(self,raw_url: str) -> WithPathRequestBuilder`
    └── item                                 
        └── path_item_request_builder.py     # UriTemplate = "{+baseurl}/{path}/{id}"
                                             # RequestBuilder has the standard methods
                                             #   and `with_url(self,raw_url: str) -> PathItemRequestBuilder`
</pre>
      </td>
    </tr>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="./tests/18.yaml">18.yaml</a><br>
          /foo/bar/<br>
          /foo/{id}<br>
        </p>
      </td>
      <td valign="top">
        <p>
          Result:&nbsp;✅<br>
          /bar/ is handled separately from /{id}/<br>
          so same as 1 and 3<br>
        </p>
        <pre>
./out/main/python/18.yaml                  
├── api_sdk.py                             # main entry point
│                                          #   has `foo(self) -> FooRequestBuilder`
└── foo                                    
    ├── foo_request_builder.py             # UriTemplate = "{+baseurl}/foo"
    │                                      # RequestBuilder has `by_id(self,id: str) -> FooItemRequestBuilder`
    │                                      #   and `bar(self) -> BarRequestBuilder`
    ├── bar                                
    │   └── bar_request_builder.py         # UriTemplate = "{+baseurl}/foo/bar/"
    │                                      # RequestBuilder has the standard methods
    │                                      #   and `with_url(self,raw_url: str) -> BarRequestBuilder`
    └── item                               
        └── foo_item_request_builder.py    # UriTemplate = "{+baseurl}/foo/{id}"
                                           # RequestBuilder has the standard methods
                                           #   and `with_url(self,raw_url: str) -> FooItemRequestBuilder`
</pre>
      </td>
    </tr>
  </tbody>
</table>
