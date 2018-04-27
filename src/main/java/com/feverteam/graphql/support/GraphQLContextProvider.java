package com.feverteam.graphql.support;

import graphql.servlet.GraphQLContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Provides a GraphQLContext. This interface can be used to provide an specialized {@link GraphQLContext}. The
 * {@link EnhancingGraphQLContextBuilder} uses this provider.
 * @author Joseph Terzieva
 */
public interface GraphQLContextProvider {

    /**
     * @return a GraphQLContext
     */
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    GraphQLContext getContext(Optional<HttpServletRequest> req, Optional<HttpServletResponse> resp);

}
