package com.example.sweater.contoller;

import com.example.sweater.domain.Location;
import com.example.sweater.repos.LocationDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/locationManipulator/post")
public class LocationManipulatorController{
    @Autowired
    private LocationDAO locationDAO;

    @GetMapping("{id}")
    public String getLocation(@PathVariable("id") Long locationId) throws JsonProcessingException {
        Location location = locationDAO.findByLocationId(locationId);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(location);
    }

    @GetMapping
    public String getLocations() throws IOException {
        List <Location> list = locationDAO.findAll();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, list);
        return out.toString();
    }

    @PostMapping
    public void saveLocation(@RequestBody Map<String, String> location) throws JsonProcessingException {
        Gson gson = new Gson();
        String json = gson.toJson(location);
        ObjectMapper mapper = new ObjectMapper();
        Location location1 = mapper.readValue(json, Location.class);
        locationDAO.save(location1);
    }
}
