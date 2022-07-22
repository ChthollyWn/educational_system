package edu.md.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.md.exam.model.Question;

import java.util.List;

public interface QuestionMapper extends BaseMapper<Question> {
    List<Question> findByPaperId(int paperid);
}
