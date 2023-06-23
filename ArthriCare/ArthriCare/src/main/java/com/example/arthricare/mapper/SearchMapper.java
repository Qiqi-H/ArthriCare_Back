package com.example.arthricare.mapper;

import com.example.arthricare.bean.drugName;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchMapper extends ElasticsearchRepository<drugName,String> {
}
