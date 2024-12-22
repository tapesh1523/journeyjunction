package com.journeyjunction.journey_junction.mapper;

import com.journeyjunction.journey_junction.dto.PointDto;
import org.locationtech.jts.geom.Point;

public class PointMapper {
    // Convert Point to PointDto
    public static PointDto toPointDto(Point point) {
        if (point != null) {
            return new PointDto(new double[]{point.getX(), point.getY()});
        }
        return null;  // Return null if the Point is null
    }

    // Convert PointDto to Point
    public static Point toPoint(PointDto pointDto) {
        if (pointDto != null && pointDto.getCoordinates() != null && pointDto.getCoordinates().length == 2) {
            // Create a new Point from the coordinates (longitude, latitude)
            return new org.locationtech.jts.geom.GeometryFactory().createPoint(
                    new org.locationtech.jts.geom.Coordinate(pointDto.getCoordinates()[0], pointDto.getCoordinates()[1])
            );
        }
        return null;  // Return null if the PointDto is invalid
    }
}
