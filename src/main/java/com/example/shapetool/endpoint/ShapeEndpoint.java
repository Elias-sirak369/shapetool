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
            throw new IllegalArgumentException("Radius cannot be negative");
        }

        CircleAreaResponse response = new CircleAreaResponse();
        response.setArea(Math.PI * radius * radius);

        return response;
    }

    // ================= SQUARE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "squareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse squareArea(@RequestPayload SquareAreaRequest request) {

        double side = request.getSide();

        if (side < 0) {
            throw new IllegalArgumentException("Side cannot be negative");
        }

        SquareAreaResponse response = new SquareAreaResponse();
        response.setArea(side * side);

        return response;
    }

    // ================= RECTANGLE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "rectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse rectangleArea(@RequestPayload RectangleAreaRequest request) {

        double length = request.getLength();
        double width = request.getWidth();

        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and Width must be non-negative");
        }

        RectangleAreaResponse response = new RectangleAreaResponse();
        response.setArea(length * width);

        return response;
    }

    // ================= TRIANGLE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "triangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse triangleArea(@RequestPayload TriangleAreaRequest request) {

        double base = request.getBase();
        double height = request.getHeight();

        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Base and Height must be non-negative");
        }

        TriangleAreaResponse response = new TriangleAreaResponse();
        response.setArea(0.5 * base * height);

        return response;
    }

    // ================= PARALLELOGRAM =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "parallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse parallelogramArea(@RequestPayload ParallelogramAreaRequest request) {

        double base = request.getBase();
        double height = request.getHeight();

        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Base and Height must be non-negative");
        }

        ParallelogramAreaResponse response = new ParallelogramAreaResponse();
        response.setArea(base * height);

        return response;
    }
}