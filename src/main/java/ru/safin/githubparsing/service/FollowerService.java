package ru.safin.githubparsing.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.safin.githubparsing.model.Follower;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowerService {
    private final ModelMapper mapper;
    private final RestTemplate restTemplate;

    @Autowired
    public FollowerService(ModelMapper mapper, RestTemplate restTemplate) {
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    public List<Follower> getFollowers(String query) {
        String url = "https://api.github.com/users/" + query + "/followers";
        ResponseEntity<Follower[]> response = restTemplate.getForEntity(url, Follower[].class);
        Follower[] followers = response.getBody();
        if (followers != null)
            return Arrays.stream(followers).map(follower -> mapper.map(follower, Follower.class)).collect(Collectors.toList());
        else
            return Collections.emptyList();
    }
}
