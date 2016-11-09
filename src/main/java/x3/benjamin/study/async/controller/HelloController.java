package x3.benjamin.study.async.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by benjamin on 2016. 11. 4..
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @ResponseBody
    @RequestMapping(value = "/{param}", method = {RequestMethod.GET})
    public String hello(@PathVariable(name = "param") String param) {
        return "hello world! " + param;
    }
}
