package com.journeyjunction.journey_junction.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Coordinate;
import java.io.IOException;

public class PointDeserializer extends JsonDeserializer<Point> {

    @Override
    public Point deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // Read the nested envelope structure
        // For example, assuming the nested JSON looks like this:
        // {
        //   "envelope": {
        //     "envelope": {
        //       "coordinates": [longitude, latitude]
        //     }
        //   }
        // }

        // First, let's access the nested structure and retrieve the coordinates
        String json = p.getText();  // Read the entire JSON structure
        String coordinatesStr = extractCoordinates(json); // Method to extract coordinates from the nested envelope

        // Coordinates are expected to be in a string like: "[longitude, latitude]"
        coordinatesStr = coordinatesStr.replace("[", "").replace("]", "");
        String[] coords = coordinatesStr.split(",");

        // Parse longitude and latitude
        double longitude = Double.parseDouble(coords[0].trim());
        double latitude = Double.parseDouble(coords[1].trim());

        // Create a Point object
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(longitude, latitude);
        Point point = geometryFactory.createPoint(coordinate);

        return point;
    }

    // Method to extract coordinates from the nested JSON envelope structure
    private String extractCoordinates(String json) {
        // For now, just return a simple mock for testing purposes
        // You'll need to implement actual parsing for your specific envelope structure
        // Example: Find the coordinates within the nested envelope
        int startIndex = json.indexOf("[");
        int endIndex = json.indexOf("]");
        return json.substring(startIndex, endIndex + 1);  // Return the coordinates part
    }
}
