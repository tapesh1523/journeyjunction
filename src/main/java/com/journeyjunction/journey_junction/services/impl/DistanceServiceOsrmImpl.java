package com.journeyjunction.journey_junction.services.impl;

import com.journeyjunction.journey_junction.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceOsrmImpl implements DistanceService {
    private static final String OSRM_API_BASE_URL = "https://router.project-osrm.org/route/v1/driving/";
    @Override
    public double calculateDistance(Point a, Point b) {
        try{
            String uri = a.getX() + "," + a.getY() + ";" + b.getX() + "," + b.getY();
            OSRMResponseDto responseDto = RestClient.builder()
                    .baseUrl(OSRM_API_BASE_URL)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMResponseDto.class);

            assert responseDto != null;
            return responseDto.getRoutes().getFirst().getDistance() / 1000.0;
        }
        catch (Exception e){
            throw new RuntimeException("Failed to calculate distance", e);
        }
    }
}
@Data
class OSRMResponseDto {
    private List<OSRMRoute> routes;
}

@Data
class OSRMRoute {
    private Double distance;
}
