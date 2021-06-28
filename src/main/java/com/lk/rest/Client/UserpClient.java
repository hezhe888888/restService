package com.lk.rest.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "email", url = "http://localhost:8090")
public interface UserpClient {

    @RequestMapping(method = RequestMethod.GET, value = "/email/getMail")
    public String getMailById(@RequestParam(value = "id") int id);

}
