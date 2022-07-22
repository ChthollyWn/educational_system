package edu.md.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.md.exam.model.Paper;
import org.apache.ibatis.annotations.Param;

public interface PaperMapper extends BaseMapper<Paper> {

    int linkpq(@Param("pid") int pid,@Param("qid") int qid);

}
