/* tslint:disable */
/* eslint-disable */
// Generated by Microsoft Kiota
// @ts-ignore
import { type WithIdRequestBuilder, WithIdRequestBuilderRequestsMetadata } from './item/index.js';
// @ts-ignore
import { type BaseRequestBuilder, type KeysToExcludeForNavigationMetadata, type NavigationMetadata } from '@microsoft/kiota-abstractions';

/**
 * Builds and executes requests for operations under /{path}
 */
export interface WithPathItemRequestBuilder extends BaseRequestBuilder<WithPathItemRequestBuilder> {
    /**
     * Builds and executes requests for operations under /{path}/{id}/
     * @returns {WithIdRequestBuilder}
     */
     withId() : WithIdRequestBuilder;
}
/**
 * Uri template for the request builder.
 */
export const WithPathItemRequestBuilderUriTemplate = "{+baseurl}/{path}";
/**
 * Metadata for all the navigation properties in the request builder.
 */
export const WithPathItemRequestBuilderNavigationMetadata: Record<Exclude<keyof WithPathItemRequestBuilder, KeysToExcludeForNavigationMetadata>, NavigationMetadata> = {
    withId: {
        requestsMetadata: WithIdRequestBuilderRequestsMetadata,
    },
};
/* tslint:enable */
/* eslint-enable */
