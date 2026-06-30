package com.ratnesh.linkedinproject.connectionsservice.service;

import com.ratnesh.linkedinproject.connectionsservice.entity.Person;

import java.util.List;

public interface ConnectionService {

    List<Person> getFirstDegreeConnections(Long userId);

}
