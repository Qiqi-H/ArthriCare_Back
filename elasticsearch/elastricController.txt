package com.example.arthricare.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("suggestSearch")
public class SearchController {

    private final RestClient restClient;
    @Autowired
    public SearchController(RestClient restClient) {
        this.restClient = restClient;
    }

    //cd D:\elasticsearch\elasticsearch-7.17.10\bin
    //elasticsearch.bat
    //cd D:\elasticsearch\kibana-7.17.10-windows-x86_64\bin
    //kibana.bat
    //http://localhost:8080/suggestSearch?prefix=i
    //根据药物作用查找药物
    @GetMapping
    public List<String> autocomplete(String prefix) throws IOException {
        Request request = new Request("POST", "/" + "drug_name" + "/_search");
        String field = "Medication Name";
        request.setJsonEntity(
                "{" +
                        "\"suggest\": {" +
                        "\"title_suggest\": {" +
                        "\"prefix\": \"" + prefix + "\"," +
                        "\"completion\": {" +
                        "\"field\": \"" + field + "\"," +
                        "\"size\": 10" +
                        "}" +
                        "}" +
                        "}" +
                        "}"
        );

        Response response = restClient.performRequest(request);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String responseContent = reader.lines().collect(Collectors.joining("\n"));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseContent);
        JsonNode suggestNodes = root.path("suggest").path("title_suggest").get(0).path("options");

        List<String> suggestions = new ArrayList<>();
        for (JsonNode suggestNode : suggestNodes) {
            String suggestion = suggestNode.path("text").asText();
            suggestions.add(suggestion);
        }

        return suggestions;

    }
}
