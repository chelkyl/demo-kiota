# Demonstrate kiota support for trailing slashes in paths

## Report

<table>
  <thead>
    <tr>
      <th>Test URI Paths</th>
      <th>TS kiota main Results</th>
      <th>Python kiota main Results</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td valign="top">
        <p>
          File:&nbsp;<a href="tests/1.yaml">1.yaml</a><br>
          /foo/<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/1.yaml">out/main/typescript/1.yaml</a>
├── apiSdk.ts       # main entry point
│                   #   has `get foo()`
└── foo             
    └── index.ts    # FooRequestBuilderUriTemplate = "{+baseurl}/foo/"
                    # RequestBuilder has the standard methods
                    # no NavigationMetadata constant
                    # FooRequestBuilderRequestsMetadata has
                    #   `get` using `FooRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/1.yaml">out/main/python/1.yaml</a>
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
          File:&nbsp;<a href="tests/2.yaml">2.yaml</a><br>
          /foo/bar/<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/2.yaml">out/main/typescript/2.yaml</a>
├── apiSdk.ts           # main entry point
│                       #   has `get foo()`
└── foo                 
    ├── index.ts        # FooRequestBuilderUriTemplate = "{+baseurl}/foo"
    │                   # RequestBuilder has `get bar()`
    │                   # FooRequestBuilderNavigationMetadata has
    │                   #   `bar` using `BarRequestBuilderRequestsMetadata`
    │                   # no RequestsMetadata constant
    └── bar             
        └── index.ts    # BarRequestBuilderUriTemplate = "{+baseurl}/foo/bar/"
                        # RequestBuilder has the standard methods
                        # no NavigationMetadata constant
                        # BarRequestBuilderRequestsMetadata has
                        #   `get` using `BarRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/2.yaml">out/main/python/2.yaml</a>
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
          File:&nbsp;<a href="tests/3.yaml">3.yaml</a><br>
          /{path}/<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/3.yaml">out/main/typescript/3.yaml</a>
├── apiSdk.ts       # main entry point
│                   #   has `withPath()`
└── item            
    └── index.ts    # WithPathRequestBuilderUriTemplate = "{+baseurl}/{path}/"
                    # RequestBuilder has the standard methods
                    # no NavigationMetadata constant
                    # WithPathRequestBuilderRequestsMetadata has
                    #   `get` using `WithPathRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/3.yaml">out/main/python/3.yaml</a>
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
          File:&nbsp;<a href="tests/4.yaml">4.yaml</a><br>
          /{path}/{id}/<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/4.yaml">out/main/typescript/4.yaml</a>
├── apiSdk.ts           # main entry point
│                       #   has `byPath(path: string)`
└── item                
    ├── index.ts        # WithPathItemRequestBuilderUriTemplate = "{+baseurl}/{path}"
    │                   # RequestBuilder has `withId()`
    │                   # WithPathItemRequestBuilderNavigationMetadata has
    │                   #   `withId` using `WithIdRequestBuilderRequestsMetadata`
    │                   # no RequestsMetadata constant
    └── item            
        └── index.ts    # WithIdRequestBuilderUriTemplate = "{+baseurl}/{path}/{id}/"
                        # RequestBuilder has the standard methods
                        # no NavigationMetadata constant
                        # WithIdRequestBuilderRequestsMetadata has
                        #   `get` using `WithIdRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/4.yaml">out/main/python/4.yaml</a>
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
          File:&nbsp;<a href="tests/5.yaml">5.yaml</a><br>
          /{path}/bar<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/5.yaml">out/main/typescript/5.yaml</a>
├── apiSdk.ts           # main entry point
│                       #   has `byPath(path: string)`
└── item                
    ├── index.ts        # WithPathItemRequestBuilderUriTemplate = "{+baseurl}/{path}"
    │                   # RequestBuilder has `get bar()`
    │                   # WithPathItemRequestBuilderNavigationMetadata has
    │                   #   `bar` using `BarRequestBuilderRequestsMetadata`
    │                   # no RequestsMetadata constant
    └── bar             
        └── index.ts    # BarRequestBuilderUriTemplate = "{+baseurl}/{path}/bar"
                        # RequestBuilder has the standard methods
                        # no NavigationMetadata constant
                        # BarRequestBuilderRequestsMetadata has
                        #   `get` using `BarRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/5.yaml">out/main/python/5.yaml</a>
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
          File:&nbsp;<a href="tests/6.yaml">6.yaml</a><br>
          /foo<br>
          /foo/<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/6.yaml">out/main/typescript/6.yaml</a>
├── apiSdk.ts       # main entry point
│                   #   has `get foo()`
└── foo             
    └── index.ts    # FooRequestBuilderUriTemplate = "{+baseurl}/foo/"
                    # RequestBuilder has the standard methods
                    # no NavigationMetadata constant
                    # FooRequestBuilderRequestsMetadata has
                    #   `get` using `FooRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/6.yaml">out/main/python/6.yaml</a>
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
          File:&nbsp;<a href="tests/7.yaml">7.yaml</a><br>
          /foo/<br>
          /foo<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/7.yaml">out/main/typescript/7.yaml</a>
├── apiSdk.ts       # main entry point
│                   #   has `get foo()`
└── foo             
    └── index.ts    # FooRequestBuilderUriTemplate = "{+baseurl}/foo/"
                    # RequestBuilder has the standard methods
                    # no NavigationMetadata constant
                    # FooRequestBuilderRequestsMetadata has
                    #   `get` using `FooRequestBuilderUriTemplate` twice
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/7.yaml">out/main/python/7.yaml</a>
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
          File:&nbsp;<a href="tests/8.yaml">8.yaml</a><br>
          /foo/<br>
          /foo/bar<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/8.yaml">out/main/typescript/8.yaml</a>
├── apiSdk.ts           # main entry point
│                       #   has `get foo()`
└── foo                 
    ├── index.ts        # FooRequestBuilderUriTemplate = "{+baseurl}/foo"
    │                   # RequestBuilder has the standard methods
    │                   #   and `get bar()`
    │                   # FooRequestBuilderNavigationMetadata has
    │                   #   `bar` using `BarRequestBuilderRequestsMetadata`
    │                   # FooRequestBuilderRequestsMetadata has
    │                   #   `get` using `FooRequestBuilderUriTemplate`
    └── bar             
        └── index.ts    # BarRequestBuilderUriTemplate = "{+baseurl}/foo/bar"
                        # RequestBuilder has the standard methods
                        # no NavigationMetadata constant
                        # BarRequestBuilderRequestsMetadata has
                        #   `get` using `BarRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/8.yaml">out/main/python/8.yaml</a>
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
          File:&nbsp;<a href="tests/9.yaml">9.yaml</a><br>
          /foo/<br>
          /foo/bar/<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/9.yaml">out/main/typescript/9.yaml</a>
├── apiSdk.ts           # main entry point
│                       #   has `get foo()`
└── foo                 
    ├── index.ts        # FooRequestBuilderUriTemplate = "{+baseurl}/foo"
    │                   # RequestBuilder has the standard methods
    │                   #   and `get bar()`
    │                   # FooRequestBuilderNavigationMetadata has
    │                   #   `bar` using `BarRequestBuilderRequestsMetadata`
    │                   # FooRequestBuilderRequestsMetadata has
    │                   #   `get` using `FooRequestBuilderUriTemplate`
    └── bar             
        └── index.ts    # BarRequestBuilderUriTemplate = "{+baseurl}/foo/bar/"
                        # RequestBuilder has the standard methods
                        # no NavigationMetadata constant
                        # BarRequestBuilderRequestsMetadata has
                        #   `get` using `BarRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/9.yaml">out/main/python/9.yaml</a>
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
          File:&nbsp;<a href="tests/10.yaml">10.yaml</a><br>
          /foo<br>
          /{path}<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/10.yaml">out/main/typescript/10.yaml</a>
├── apiSdk.ts       # main entry point
│                   #   has `get foo()`
│                   #   and `byPath(path: string)`
├── foo             
│   └── index.ts    # FooRequestBuilderUriTemplate = "{+baseurl}/foo"
│                   # RequestBuilder has the standard methods
│                   # no NavigationMetadata constant
│                   # FooRequestBuilderRequestsMetadata has
│                   #   `get` using `FooRequestBuilderUriTemplate`
└── item            
    └── index.ts    # WithPathItemRequestBuilderUriTemplate = "{+baseurl}/{path}"
                    # RequestBuilder has the standard methods
                    # no NavigationMetadata constant
                    # WithPathItemRequestBuilderRequestsMetadata has
                    #   `get` using `WithPathItemRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/10.yaml">out/main/python/10.yaml</a>
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
          File:&nbsp;<a href="tests/11.yaml">11.yaml</a><br>
          /foo<br>
          /{path}/<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/11.yaml">out/main/typescript/11.yaml</a>
├── apiSdk.ts       # main entry point
│                   #   has `get foo()`
│                   #   and `withPath()`
├── foo             
│   └── index.ts    # FooRequestBuilderUriTemplate = "{+baseurl}/foo"
│                   # RequestBuilder has the standard methods
│                   # no NavigationMetadata constant
│                   # FooRequestBuilderRequestsMetadata has
│                   #   `get` using `FooRequestBuilderUriTemplate`
└── item            
    └── index.ts    # WithPathRequestBuilderUriTemplate = "{+baseurl}/{path}/"
                    # RequestBuilder has the standard methods
                    # no NavigationMetadata constant
                    # WithPathRequestBuilderRequestsMetadata has
                    #   `get` using `WithPathRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/11.yaml">out/main/python/11.yaml</a>
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
          File:&nbsp;<a href="tests/12.yaml">12.yaml</a><br>
          /foo/<br>
          /{path}<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/12.yaml">out/main/typescript/12.yaml</a>
├── apiSdk.ts       # main entry point
│                   #   has `get foo()`
│                   #   and `byPath(path: string)`
├── foo             
│   └── index.ts    # FooRequestBuilderUriTemplate = "{+baseurl}/foo/"
│                   # RequestBuilder has the standard methods
│                   # no NavigationMetadata constant
│                   # FooRequestBuilderRequestsMetadata has
│                   #   `get` using `FooRequestBuilderUriTemplate`
└── item            
    └── index.ts    # WithPathItemRequestBuilderUriTemplate = "{+baseurl}/{path}"
                    # RequestBuilder has the standard methods
                    # no NavigationMetadata constant
                    # WithPathItemRequestBuilderRequestsMetadata has
                    #   `get` using `WithPathItemRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/12.yaml">out/main/python/12.yaml</a>
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
          File:&nbsp;<a href="tests/13.yaml">13.yaml</a><br>
          /foo/<br>
          /{path}/<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/13.yaml">out/main/typescript/13.yaml</a>
├── apiSdk.ts       # main entry point
│                   #   has `get foo()`
│                   #   and `withPath()`
├── foo             
│   └── index.ts    # FooRequestBuilderUriTemplate = "{+baseurl}/foo/"
│                   # RequestBuilder has the standard methods
│                   # no NavigationMetadata constant
│                   # FooRequestBuilderRequestsMetadata has
│                   #   `get` using `FooRequestBuilderUriTemplate`
└── item            
    └── index.ts    # WithPathRequestBuilderUriTemplate = "{+baseurl}/{path}/"
                    # RequestBuilder has the standard methods
                    # no NavigationMetadata constant
                    # WithPathRequestBuilderRequestsMetadata has
                    #   `get` using `WithPathRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/13.yaml">out/main/python/13.yaml</a>
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
          File:&nbsp;<a href="tests/14.yaml">14.yaml</a><br>
          /{path}<br>
          /{path}/<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/14.yaml">out/main/typescript/14.yaml</a>
├── apiSdk.ts       # main entry point
│                   #   has `byPath(path: string)`
│                   #   and `withPath()`
└── item            
    └── index.ts    # WithPathItemRequestBuilderUriTemplate = "{+baseurl}/{path}"
                    # RequestBuilder has the standard methods
                    # no NavigationMetadata constant
                    # WithPathItemRequestBuilderRequestsMetadata has
                    #   `get` using `WithPathItemRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/14.yaml">out/main/python/14.yaml</a>
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
          File:&nbsp;<a href="tests/15.yaml">15.yaml</a><br>
          /{path}/<br>
          /{path}<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/15.yaml">out/main/typescript/15.yaml</a>
├── apiSdk.ts       # main entry point
│                   #   has `byPath(path: string)`
│                   #   and `withPath()`
└── item            
    └── index.ts    # WithPathItemRequestBuilderUriTemplate = "{+baseurl}/{path}"
                    # RequestBuilder has the standard methods
                    # no NavigationMetadata constant
                    # WithPathItemRequestBuilderRequestsMetadata has
                    #   `get` using `WithPathItemRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/15.yaml">out/main/python/15.yaml</a>
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
          File:&nbsp;<a href="tests/16.yaml">16.yaml</a><br>
          /{path}<br>
          /{path}/{id}<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/16.yaml">out/main/typescript/16.yaml</a>
├── apiSdk.ts           # main entry point
│                       #   has `byPath(path: string)`
└── item                
    ├── index.ts        # WithPathItemRequestBuilderUriTemplate = "{+baseurl}/{path}"
    │                   # RequestBuilder has the standard methods
    │                   #   and `byId(id: string)`
    │                   # WithPathItemRequestBuilderNavigationMetadata has
    │                   #   `byId` using `PathItemRequestBuilderRequestsMetadata`
    │                   # WithPathItemRequestBuilderRequestsMetadata has
    │                   #   `get` using `WithPathItemRequestBuilderUriTemplate`
    └── item            
        └── index.ts    # PathItemRequestBuilderUriTemplate = "{+baseurl}/{path}/{id}"
                        # RequestBuilder has the standard methods
                        # no NavigationMetadata constant
                        # PathItemRequestBuilderRequestsMetadata has
                        #   `get` using `PathItemRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/16.yaml">out/main/python/16.yaml</a>
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
          File:&nbsp;<a href="tests/17.yaml">17.yaml</a><br>
          /{path}/<br>
          /{path}/{id}<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/17.yaml">out/main/typescript/17.yaml</a>
├── apiSdk.ts           # main entry point
│                       #   has `byPath(path: string)`
│                       #   and `withPath()`
└── item                
    ├── index.ts        # WithPathItemRequestBuilderUriTemplate = "{+baseurl}/{path}"
    │                   # RequestBuilder has `byId(id: string)`
    │                   # WithPathItemRequestBuilderNavigationMetadata has
    │                   #   `byId` using `PathItemRequestBuilderRequestsMetadata`
    │                   # no RequestsMetadata constant
    └── item            
        └── index.ts    # PathItemRequestBuilderUriTemplate = "{+baseurl}/{path}/{id}"
                        # RequestBuilder has the standard methods
                        # no NavigationMetadata constant
                        # PathItemRequestBuilderRequestsMetadata has
                        #   `get` using `PathItemRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/17.yaml">out/main/python/17.yaml</a>
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
          File:&nbsp;<a href="tests/18.yaml">18.yaml</a><br>
          /foo/bar/<br>
          /foo/{id}<br>
        </p>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/typescript/18.yaml">out/main/typescript/18.yaml</a>
├── apiSdk.ts           # main entry point
│                       #   has `get foo()`
└── foo                 
    ├── index.ts        # FooRequestBuilderUriTemplate = "{+baseurl}/foo"
    │                   # RequestBuilder has `get bar()`
    │                   #   and `byId(id: string)`
    │                   # FooRequestBuilderNavigationMetadata has
    │                   #   `byId` using `FooItemRequestBuilderRequestsMetadata`
    │                   #   `bar` using `BarRequestBuilderRequestsMetadata`
    │                   # no RequestsMetadata constant
    ├── bar             
    │   └── index.ts    # BarRequestBuilderUriTemplate = "{+baseurl}/foo/bar/"
    │                   # RequestBuilder has the standard methods
    │                   # no NavigationMetadata constant
    │                   # BarRequestBuilderRequestsMetadata has
    │                   #   `get` using `BarRequestBuilderUriTemplate`
    └── item            
        └── index.ts    # FooItemRequestBuilderUriTemplate = "{+baseurl}/foo/{id}"
                        # RequestBuilder has the standard methods
                        # no NavigationMetadata constant
                        # FooItemRequestBuilderRequestsMetadata has
                        #   `get` using `FooItemRequestBuilderUriTemplate`
</pre>
      </td>
      <td valign="top">
        <p>Result:&nbsp;</p>
        <pre>
<a href="out/main/python/18.yaml">out/main/python/18.yaml</a>
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
