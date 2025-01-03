package com.journeyjunction.journey_junction.services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {
    double calculateDistance(Point a, Point b);
}
