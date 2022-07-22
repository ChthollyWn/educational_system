package edu.md.exam.controllers;


import edu.md.exam.mapper.QuestionMapper;
import edu.md.exam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionMapper questionMapper;

    @RequestMapping("/list")
    @ResponseBody
    public List<Question> list(){
        List<Question> all = questionMapper.selectList(null);
        return all;
    }

    @RequestMapping("/doDelete")
    @ResponseBody
    public int doDelete(int id){
        int a = questionMapper.deleteById(id);
        return a;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public int doAdd(Question question){
        int a = questionMapper.insert(question);
        return a;
    }

    @RequestMapping("/getone")
    @ResponseBody
    public Question getone(int id){
        Question question = questionMapper.selectById(id);
        return  question;
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public int doUpdate(Question question){
        int a = questionMapper.updateById(question);
        return a;
    }

    @RequestMapping("/getQuestions")
    @ResponseBody
    public List<Question> getQuestions(int paperid){
        List<Question> qs = questionMapper.findByPaperId(paperid);
        return qs;
    }

}
