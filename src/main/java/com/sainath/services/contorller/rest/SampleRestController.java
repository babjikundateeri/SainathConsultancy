package com.sainath.services.contorller.rest;

import com.sainath.services.beens.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by babjik on 19/4/16.
 */

@RestController
public class SampleRestController {

    @RequestMapping(value = "/hello/{name}/cont/{content}")
    public Message message(@PathVariable(value = "name") String name,
                           @PathVariable(value = "content") String content) {
        Message message = new Message(name, content);
        return message;
    }

    @RequestMapping(value = "/add/{val1}/{val2}")
    public Integer add(@PathVariable("val1") int x,
                        @PathVariable("val2") int y) {
            return x +y;
    }

    @RequestMapping(value = "/sub/{val1}/{val2}")
    public Integer sub(@PathVariable("val1") int val1,
                        @PathVariable("val2") int val2) {
        return val1 - val2;
    }
}
