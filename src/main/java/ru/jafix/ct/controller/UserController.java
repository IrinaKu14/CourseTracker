package ru.jafix.ct.controller;

import org.springframework.web.bind.annotation.*;
import ru.jafix.ct.entity.User;
import ru.jafix.ct.entity.dto.ExampleDto;

import java.util.UUID;

@RequestMapping("/api" )
@RestController
public class UserController {
    //@RequestMapping(method = RequestMethod.GET,path = "/test" )
   // @ResponseBody
    @GetMapping("/test")
//    public void test(@RequestBody User user){
//    public void test(@RequestHeader ("Data") String data){
//        System.out.println(data);
//        return User.builder()
//                .age(25)
//                .id(UUID.randomUUID())
//                .login("iri")
//                .build();
       // return 2000;


  //  }
    public String test(@RequestParam("search") String search, @RequestParam("category") String category){
        return search +" "+ category;

    }
    @GetMapping("/test2")
    public void test2(){
        System.out.println("Hello, Iri!");


    }
    @GetMapping("/test3/{var}")
    public String test(@PathVariable("var") String var){
        return var;

    }
    @PostMapping("/test4")
    public ExampleDto test4(@RequestBody ExampleDto example){
        example.setField(example.getField() + "1");
        return example;

    }
}
