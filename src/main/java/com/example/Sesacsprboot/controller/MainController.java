package com.example.Sesacsprboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/api")
    public String getApi() {
        return "request";
    }
    // 1) get : ?key=value
    // 검색 / 해시태그
    // /get/response1?name=abc

    @GetMapping("/get/response1")
    public String getResponse1(@RequestParam(value = "name") String name, Model model) {
        // @Requestparam: 요청의 파라미터를 매개변수로 받을 때 적는 어노테이션
        // value= ? 뒤에 넘어온 key
        // required 값을 설정할 수 있다 = true/false -> 기본값은 true
        // required가 true로 되어있으면 ?뒤에

        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping("/get/response2")
    public String getResponse2(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }


    ////////실습
    @GetMapping("/introduce/{name}")
    public String getIntroduce1(@PathVariable String name, Model model){
            model.addAttribute("name",name);
            return "response";
        }

    @GetMapping("/introduce2")
    public String getIntroduce2(@PathVariable String name, int age, Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "response";
    }
    @PostMapping("/postPr")
    public String postPr(@RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "gender", required = false) Integer age,
                         @RequestParam(value = "year", required = false) String gender,
                         @RequestParam(value = "interest", required = false) String hobby,Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("gender",gender);
        model.addAttribute("hobby",hobby);

        return "postPr";
    }

}