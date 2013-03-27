package com.luna.console.resteasy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class SimpleMockWebService extends Application {

    private static Set services = new HashSet();

    public SimpleMockWebService() {

        // initialize restful services
        services.add(new Index());
    }

    @Override
    public Set getSingletons() {

        return services;
    }

    public static Set getServices() {

        return services;
    }
}
