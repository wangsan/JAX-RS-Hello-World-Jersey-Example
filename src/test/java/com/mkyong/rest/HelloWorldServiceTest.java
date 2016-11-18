package com.mkyong.rest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.mkyong.rest.model.SimpleJSONResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.apache4.ApacheHttpClient4;

/**
 * HelloWorldServiceTest
 *
 * @author wangsan
 * @date 2016/11/18
 */
public class HelloWorldServiceTest {

    @Test
    public void test() {
        WebResource resource = Client.create().resource("http://localhost:8080/rest/hello/simpleJSONReturn");
        ClientResponse response = resource.type(MediaType.APPLICATION_FORM_URLENCODED).get(ClientResponse.class);
        System.out.println(response.getStatus());
        SimpleJSONResponse entity = response.getEntity(SimpleJSONResponse.class);
        System.err.println(entity);
    }

    /**
     * eureka use this default
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ApacheHttpClient4 jerseyClient = new ApacheHttpClient4();

        Future<SimpleJSONResponse> future =
                jerseyClient.asyncResource("http://localhost:8080/rest/hello/simpleJSONReturn")
                        .get(SimpleJSONResponse.class);
        System.err.println(future.get());
    }
}