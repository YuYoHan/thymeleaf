//package com.example.mvc.controller.v1;
//
//import lombok.Data;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/api/v1/basic")
//public class BasicController {
//    @GetMapping("/text-basic")
//    public String basic(Model model) {
//        model.addAttribute("data", "Hello");
//        return "basic/text-basic";
//    }
//
//    @GetMapping("/text-unescaped")
//    public String unescaped(Model model) {
//        model.addAttribute("data", "Hello <b>Spring!</b>");
//        return "basic/text-unescaped";
//    }
//
//    @GetMapping("/variable")
//    public String variable(Model model) {
//        User userA = new User("userA", 10);
//        User userB = new User("userB", 10);
//
//        List<User> list = new ArrayList<>();
//        list.add(userA);
//        list.add(userB);
//
//        Map<String, User> map = new HashMap<>();
//        map.put("userA", userA);
//        map.put("userB", userB);
//
//        model.addAttribute("user", userA);
//        model.addAttribute("users", list);
//        model.addAttribute("userMap", map);
//
//        return "basic/variable";
//    }
//
//    @Data
//    static class  User{
//        private String userName;
//        private int age;
//
//        public User(String userName, int age) {
//            this.userName = userName;
//            this.age = age;
//        }
//    }
//
//    @GetMapping("/basic-objects")
//    public String basicObjects(HttpSession session) {
//        session.setAttribute("sessionData", "Hello Session");
//        return "basic/basic-objects";
//    }
//
//    @Component("helloBean")
//    static class HelloBean {
//        public String hello(String data) {
//            return "Hello " + data;
//        }
//    }
//}
