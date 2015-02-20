package com.mkyong.common.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class DataService {
  Map<String, String> model = new HashMap<String, String>();;

  @PostConstruct
  private void init() {
    Random rand = new Random();
    for (int i = 0; i < 20; i++) {
      model.put(String.valueOf(i), "val" + rand.nextInt(30));
    }

  }

  public Map<String, String> findAll() {
    return model;
  }

  public String findById(String id) {
    return model.get(id);
  }
}
