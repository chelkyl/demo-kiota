package item

import (
    i2ae4187f7daee263371cb1c977df639813ab50ffa529013b7437480d1ec0158f "github.com/microsoft/kiota-abstractions-go"
)

// WithPathItemRequestBuilder builds and executes requests for operations under \{path}
type WithPathItemRequestBuilder struct {
    i2ae4187f7daee263371cb1c977df639813ab50ffa529013b7437480d1ec0158f.BaseRequestBuilder
}
// NewWithPathItemRequestBuilderInternal instantiates a new WithPathItemRequestBuilder and sets the default values.
func NewWithPathItemRequestBuilderInternal(pathParameters map[string]string, requestAdapter i2ae4187f7daee263371cb1c977df639813ab50ffa529013b7437480d1ec0158f.RequestAdapter)(*WithPathItemRequestBuilder) {
    m := &WithPathItemRequestBuilder{
        BaseRequestBuilder: *i2ae4187f7daee263371cb1c977df639813ab50ffa529013b7437480d1ec0158f.NewBaseRequestBuilder(requestAdapter, "{+baseurl}/{path}", pathParameters),
    }
    return m
}
// NewWithPathItemRequestBuilder instantiates a new WithPathItemRequestBuilder and sets the default values.
func NewWithPathItemRequestBuilder(rawUrl string, requestAdapter i2ae4187f7daee263371cb1c977df639813ab50ffa529013b7437480d1ec0158f.RequestAdapter)(*WithPathItemRequestBuilder) {
    urlParams := make(map[string]string)
    urlParams["request-raw-url"] = rawUrl
    return NewWithPathItemRequestBuilderInternal(urlParams, requestAdapter)
}
// WithId builds and executes requests for operations under \{path}\{id}\
// returns a *ItemWithIdRequestBuilder when successful
func (m *WithPathItemRequestBuilder) WithId()(*ItemWithIdRequestBuilder) {
    return NewItemWithIdRequestBuilderInternal(m.BaseRequestBuilder.PathParameters, m.BaseRequestBuilder.RequestAdapter)
}
