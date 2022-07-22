package edu.md.exam.controllers;


import edu.md.exam.mapper.ClazzMapper;
import edu.md.exam.model.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    private ClazzMapper clazzMapper;

    @RequestMapping("/list")
    @ResponseBody
    public List<Clazz> list(){
        List<Clazz> all = clazzMapper.selectList(null);
        return all;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public int doAdd(Clazz clazz){
        int a = clazzMapper.insert(clazz);
        return a;
    }

    @RequestMapping("/doDelete")
    @ResponseBody
    public int doDelete(int id){
        int a = clazzMapper.deleteById(id);
        return a;
    }

    @RequestMapping("/getone")
    @ResponseBody
    public Clazz getone(int id){
        Clazz clazz = clazzMapper.selectById(id);
        return clazz;
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public int doUpdate(Clazz clazz){
        int a = clazzMapper.updateById(clazz);
        return a;
    }


}
