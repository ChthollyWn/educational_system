package edu.md.exam.controllers;

import edu.md.exam.mapper.AcademyMapper;
import edu.md.exam.model.Academy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/aca")

public class AcademyController {
    @Autowired
    private AcademyMapper academyMapper;

    @RequestMapping("/t1")
    public @ResponseBody String test1(){
        return "hello";
    }


    @RequestMapping("/list")
    @ResponseBody
    public List<Academy> List(){
        List<Academy> all =academyMapper.findAll();
        return all;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public int doAdd(String name){
        Academy aca = new Academy();
        aca.setName(name);
        int a = academyMapper.insert(aca);
        return a;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(int id){
        int a = academyMapper.deleteById(id);
        return a;
    }

    @RequestMapping("/getone")
    @ResponseBody
    public Academy getOne(Integer id){
        Academy academy = academyMapper.selectById(id);
        return academy;
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public int doUpdate(Academy academy){
        int a = academyMapper.updateById(academy);
        return a;
    }

    @RequestMapping("/doUpdatetest")
    @ResponseBody
    public int doUpdatetest(Academy academy){
        int a = academyMapper.updateById(academy);
        return a;
    }

}
