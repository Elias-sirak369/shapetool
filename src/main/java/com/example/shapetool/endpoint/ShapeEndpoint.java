package com.example.shapetool.endpoint;

import org.springframework.ws.server.endpoint.annotation.*;
import com.example.shapetool.*;

@Endpoint
public class ShapeEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/shapetool";

    // ================= CIRCLE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "circleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse circleArea(@RequestPayload CircleAreaRequest request) {

        double radius = request.getRadius();

        if (radius < 0) {
            throw new RuntimeException("Radius cannot be negative");
        }

        CircleAreaResponse response = new CircleAreaResponse();
        response.setArea(Math.PI * radius * radius);

        return response;
    }

    // ================= SQUARE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "squareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse squareArea(@RequestPayload SquareAreaRequest request) {

        SquareAreaResponse response = new SquareAreaResponse();
        response.setArea(request.getSide() * request.getSide());

        return response;
    }

    // ================= RECTANGLE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "rectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse rectangleArea(@RequestPayload RectangleAreaRequest request) {

        RectangleAreaResponse response = new RectangleAreaResponse();
        response.setArea(request.getLength() * request.getWidth());

        return response;
    }

    // ================= TRIANGLE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "triangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse triangleArea(@RequestPayload TriangleAreaRequest request) {

        TriangleAreaResponse response = new TriangleAreaResponse();
        response.setArea(0.5 * request.getBase() * request.getHeight());

        return response;
    }

    // ================= PARALLELOGRAM =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "parallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse parallelogramArea(@RequestPayload ParallelogramAreaRequest request) {

        ParallelogramAreaResponse response = new ParallelogramAreaResponse();
        response.setArea(request.getBase() * request.getHeight());

        return response;
    }
}