package com.feverteam.graphql.support;

import graphql.servlet.GraphQLContext;

/**
 * Enhance a GraphQL context with additional supporting information.
 * @author Joseph Terzieva
 */
public interface GraphQLContextEnhancer {

    void enhance(GraphQLContext context);

}
