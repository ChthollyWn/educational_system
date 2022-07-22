package edu.md.exam.controllers;

import edu.md.exam.mapper.ClazzMapper;
import edu.md.exam.mapper.StudentMapper;
import edu.md.exam.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/list")
    @ResponseBody
    public List<Student> list(){
        List<Student> all = studentMapper.selectList(null);
        return all;
    }

    @RequestMapping("/doDelete")
    @ResponseBody
    public int doDelete(int id){
        int a = studentMapper.deleteById(id);
        return a;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public int doAdd(Student student){
        int a = studentMapper.insert(student);
        return a;
    }

    @RequestMapping("/getone")
    @ResponseBody
    public Student getone(int id){
        Student student = studentMapper.selectById(id);
        return  student;
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public int doUpdate(Student student){
        int a = studentMapper.updateById(student);
        return a;
    }


}
