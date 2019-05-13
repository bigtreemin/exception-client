package bigtree.home.exception.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bigtree.home.exception.service.SampleService;
import bigtree.home.exception.service.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @RequestMapping(method = RequestMethod.POST, path = "/api/sampleData", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sampleData(@Valid @RequestBody User user) {
        log.debug("Start sampleData .... ");
        String sampleData = sampleService.getSampleData(user);
        log.debug("End sampleData .... ");
        return sampleData;

    }

    @GetMapping(path = "/api/testException")
    public String sampleException() {
        log.debug(" /api/testException .... ");
        sampleService.getSampleData();
        return "sampleException";
    }

}
