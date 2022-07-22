package edu.md.exam.controllers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.md.exam.mapper.PaperMapper;
import edu.md.exam.mapper.QuestionMapper;
import edu.md.exam.model.Paper;
import edu.md.exam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("paper")
public class PaperController {

    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private QuestionMapper questionMapper;

    @RequestMapping("/list")
    @ResponseBody
    public List<Paper> list(){
        List<Paper> all = paperMapper.selectList(null);
        return  all;
    }

    @RequestMapping("/doDelete")
    @ResponseBody
    public int doDelete(int id){
        int a = paperMapper.deleteById(id);
        return a;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public int doAdd(Paper paper){

        //java获取当前系统时间（字符串）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strDate = sdf.format( new Date() );

        //调整考试时间的格式
//        2022-07-17T09:13 --->   2022/07/17 09:13
//        p.setExamTime(p.getExamTime().replace("-","/").replace("T"," "));

        paper.setCreatedtime(strDate);

        int a = paperMapper.insert(paper);
        return a;
    }

    @RequestMapping("/getone")
    @ResponseBody
    public Paper getone(int id){
        Paper paper = paperMapper.selectById(id);
        return paper;
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public int doUpdate(Paper paper){
        int a = paperMapper.updateById(paper);
        return a;
    }

    @RequestMapping("/linkQuestion")
    @ResponseBody
    public int linkQuestion(Integer id){
        Paper paper = paperMapper.selectById(id);
        int aid = paper.getAid();
        QueryWrapper<Question> qw = new QueryWrapper<>();
        qw.eq("aid",aid);
        List<Question> questions = questionMapper.selectList(qw);
        int num = paper.getQuestionNum();
        if(questions.size()<num){
            return 0;
        }
        List<Question> qs = new ArrayList<>();
        for(int i=0;i<num;i++){
            int index = new Random().nextInt(questions.size());
            Question q = questions.get(index);
            qs.add(q);
        }
        int count = 0;
        for(Question q:qs){
            int a = paperMapper.linkpq(paper.getId(),q.getId());
            count= count+a;
        }
        paper.setStatus(1);
        paperMapper.updateById(paper);
        return count;
    }

    @RequestMapping("/publish")
    @ResponseBody
    public int publish(Integer id){
        Paper paper = paperMapper.selectById(id);
        paper.setStatus(2);

        int a =paperMapper.updateById(paper);
        return a;
    }

}
