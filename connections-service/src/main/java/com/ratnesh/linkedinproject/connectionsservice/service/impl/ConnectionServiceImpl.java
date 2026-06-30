package com.ratnesh.linkedinproject.connectionsservice.service.impl;

import com.ratnesh.linkedinproject.connectionsservice.entity.Person;
import com.ratnesh.linkedinproject.connectionsservice.repository.PersonRepository;
import com.ratnesh.linkedinproject.connectionsservice.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> getFirstDegreeConnections(Long userId) {
        return personRepository.getFirstDegreeConnections(userId);
    }
}
