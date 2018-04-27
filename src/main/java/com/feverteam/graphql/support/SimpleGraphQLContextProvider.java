package com.feverteam.graphql.support;

import graphql.servlet.GraphQLContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Created by Joseph Terzieva on 4/26/18.
 */
public class SimpleGraphQLContextProvider implements GraphQLContextProvider {

    @Override
    public GraphQLContext getContext(Optional<HttpServletRequest> req, Optional<HttpServletResponse> resp) {
        return new GraphQLContext(req, resp);
    }

}
