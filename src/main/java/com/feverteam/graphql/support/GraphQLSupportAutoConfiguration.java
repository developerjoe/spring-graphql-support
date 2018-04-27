package com.feverteam.graphql.support;

import graphql.servlet.GraphQLContextBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Optional;

/**
 * AutoConfiguration class for GraphQL support. Scans the class path and configures beans if needed.
 */
@ComponentScan
public class GraphQLSupportAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(GraphQLContextProvider.class)
    public GraphQLContextProvider graphQLContextProvider() {
        return new SimpleGraphQLContextProvider();
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    @Bean
    @ConditionalOnMissingBean(GraphQLContextBuilder.class)
    public GraphQLContextBuilder graphQLContextBuilder(Optional<List<GraphQLContextEnhancer>> enhancers,
                                                       GraphQLContextProvider provider) {
        return new EnhancingGraphQLContextBuilder(enhancers, provider);
    }


}
