package ru.jafix.ct.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.jafix.ct.entity.Responsable;
import ru.jafix.ct.entity.dto.ErrorDto;
import ru.jafix.ct.entity.dto.SuccessDto;
import ru.jafix.ct.entity.dto.UserDto;
import ru.jafix.ct.service.UserService;

import java.util.UUID;

@RequestMapping("/api" )
@RestController
public class UserController {
//    //@RequestMapping(method = RequestMethod.GET,path = "/test" )
//   // @ResponseBody
//    @GetMapping("/test")
////    public void test(@RequestBody User user){
////    public void test(@RequestHeader ("Data") String data){
////        System.out.println(data);
////        return User.builder()
////                .age(25)
////                .id(UUID.randomUUID())
////                .login("iri")
////                .build();
//       // return 2000;
//
//
//  //  }
//    public String test(@RequestParam("search") String search, @RequestParam("category") String category){
//        return search +" "+ category;
//
//    }
//    @GetMapping("/test2")
//    public void test2(){
//        System.out.println("Hello, Iri!");
//
//
//    }
//    @GetMapping("/test3/{var}")
//    public String test(@PathVariable("var") String var){
//        return var;
//
//    }
//    @PostMapping("/test4")
//    public ExampleDto test4(@RequestBody ExampleDto example){
//        example.setField(example.getField() + "1");
//        return example;
//
//    }

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Responsable> createUser(@RequestBody UserDto userDto){
        try{
            return ResponseEntity.ok(userService.createUser(userDto));
        }catch (Exception e){


            return ResponseEntity.badRequest()
                    .body(ErrorDto.builder()
                    .errorMsg(e.getMessage())
                    .build());
    }
}
    @PutMapping("/users")
    public ResponseEntity<Responsable> editeUser(@RequestBody UserDto userDto){
        try{
            return ResponseEntity.ok(userService.editUser(userDto));
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body(ErrorDto.builder()
                            .errorMsg(e.getMessage()).build());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> findByIdOrLogin(@RequestParam(value = "userId", required = false) UUID userId,
                                             @RequestParam(value ="login", required = false) String login){

        try{
            if(userId !=null && login !=null){
                throw new IllegalArgumentException("Ambigous parameters");
            } else if (userId ==null && login ==null) {
                return ResponseEntity.ok(userService.findAllUsers());
            } else if (userId !=null) {
                return ResponseEntity.ok(userService.findUserById(userId));
            } else {
                return ResponseEntity.ok(userService.findUserByLogin(login));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body(ErrorDto.builder()
                            .errorMsg(e.getMessage()).build());
        }
    }
    @DeleteMapping("/users/{id}")
   public ResponseEntity<Responsable> deleteById(@PathVariable("id") UUID id){
        try{
            userService.deleteById(id);
            return ResponseEntity.ok(SuccessDto.builder()
                    .msg(String.format("Запись с id =%s, не найдена", id)).build());
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body(ErrorDto.builder()
                    .errorMsg(e.getMessage())
                    .build());
        }
    }
//    @GetMapping("/users/{login}")
//    public ResponseEntity<?> findByLogin(@PathVariable("login") String login){
//
//        try{
//            return ResponseEntity.ok(userService.findUserByLogin(login));
//        }catch (Exception e){
//            return ResponseEntity.badRequest()
//                    .body(ErrorDto.builder()
//                            .errorMsg(e.getMessage()).build());
//        }
//    }
}
