package com.luna.console.resteasy;

import java.io.File;
import java.net.URISyntaxException;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;

@Path("/")
public class Index {

    @GET
    @Produces("text/html")
    public Response index() throws URISyntaxException {

        File f = new File(System.getProperty("user.dir") + "/index.html");
        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f, mt).build();
    }

    @GET
    @Path("/hello")
    public Response helloGet() {

        System.out.println("get hello");

        JSONObject json = new JSONObject();
        json.put("name", "Kevin");
        json.put("age", "20");
        json.put("sign", "this is signature");

        return Response.ok(json).build();
    }

    @POST
    @Path("/hello")
    public Response helloPost() {

        System.out.println("post hello");
        JSONObject json = new JSONObject();
        json.put("name", "Kevin");
        json.put("age", "20");
        json.put("sign", "this is signature");

        return Response.ok(json).build();
    }
}
