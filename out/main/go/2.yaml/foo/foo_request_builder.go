package foo

import (
    i2ae4187f7daee263371cb1c977df639813ab50ffa529013b7437480d1ec0158f "github.com/microsoft/kiota-abstractions-go"
)

// FooRequestBuilder builds and executes requests for operations under \foo
type FooRequestBuilder struct {
    i2ae4187f7daee263371cb1c977df639813ab50ffa529013b7437480d1ec0158f.BaseRequestBuilder
}
// Bar the bar property
// returns a *BarRequestBuilder when successful
func (m *FooRequestBuilder) Bar()(*BarRequestBuilder) {
    return NewBarRequestBuilderInternal(m.BaseRequestBuilder.PathParameters, m.BaseRequestBuilder.RequestAdapter)
}
// NewFooRequestBuilderInternal instantiates a new FooRequestBuilder and sets the default values.
func NewFooRequestBuilderInternal(pathParameters map[string]string, requestAdapter i2ae4187f7daee263371cb1c977df639813ab50ffa529013b7437480d1ec0158f.RequestAdapter)(*FooRequestBuilder) {
    m := &FooRequestBuilder{
        BaseRequestBuilder: *i2ae4187f7daee263371cb1c977df639813ab50ffa529013b7437480d1ec0158f.NewBaseRequestBuilder(requestAdapter, "{+baseurl}/foo", pathParameters),
    }
    return m
}
// NewFooRequestBuilder instantiates a new FooRequestBuilder and sets the default values.
func NewFooRequestBuilder(rawUrl string, requestAdapter i2ae4187f7daee263371cb1c977df639813ab50ffa529013b7437480d1ec0158f.RequestAdapter)(*FooRequestBuilder) {
    urlParams := make(map[string]string)
    urlParams["request-raw-url"] = rawUrl
    return NewFooRequestBuilderInternal(urlParams, requestAdapter)
}
