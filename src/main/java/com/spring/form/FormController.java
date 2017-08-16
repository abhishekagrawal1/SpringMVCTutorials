package com.spring.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {

    private Map<Integer,Student> storage = new HashMap<Integer, Student>();

    @RequestMapping(value="/student", method= RequestMethod.GET)
    public ModelAndView student(){
        return new ModelAndView("student","command",new Student());
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public String save(@ModelAttribute("springWeb")Student student, ModelMap model){
        storage.put(student.getRollno(), student);
        model.addAttribute("rollno",student.getRollno());
        model.addAttribute("name",student.getName());
        model.addAttribute("address",student.getAddress());
        return "detail";
    }

}
