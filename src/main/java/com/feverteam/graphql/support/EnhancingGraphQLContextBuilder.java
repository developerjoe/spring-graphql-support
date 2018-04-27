package com.feverteam.graphql.support;

import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLContextBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * GraphQLContextBuilder which utilizes the {@link GraphQLContextProvider} to provide the context and zero or more
 * {@link GraphQLContextEnhancer}s to add additional information to the context.
 */
public class EnhancingGraphQLContextBuilder implements GraphQLContextBuilder {

    private final List<GraphQLContextEnhancer> enhancers;

    private final GraphQLContextProvider provider;

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public EnhancingGraphQLContextBuilder(Optional<List<GraphQLContextEnhancer>> enhancers, GraphQLContextProvider provider) {
        this.enhancers = enhancers.orElseGet(ArrayList::new);
        this.provider = provider;
    }

    public GraphQLContext build(Optional<HttpServletRequest> req, Optional<HttpServletResponse> resp) {

        GraphQLContext context = provider.getContext(req, resp);

        enhancers.forEach(e -> e.enhance(context));

        return context;
    }

}
