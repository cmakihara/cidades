package com.maki.citiesapi.services;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.maki.citiesapi.model.Cidade;
import com.maki.citiesapi.repositories.CidadeRepository;

@Service
public class DistanceService {

  private final CidadeRepository cidadeRepository;
  Logger log = LoggerFactory.getLogger(DistanceService.class);

  public DistanceService(final CidadeRepository cidadeRepository) {
    this.cidadeRepository = cidadeRepository;
  }


  public Double distanceByPointsInMiles(final Long city1, final Long city2) {
    log.info("nativePostgresInMiles({}, {})", city1, city2);
    return cidadeRepository.distanceByPoints(city1, city2);
  }

  public Double distanceByCubeInMeters(Long city1, Long city2) {
    log.info("distanceByCubeInMeters({}, {})", city1, city2);
    final List<Cidade> cities = cidadeRepository.findAllById((Arrays.asList(city1, city2)));

    Point p1 = cities.get(0).getLocation();
    Point p2 = cities.get(1).getLocation();

    return cidadeRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
  }

}
