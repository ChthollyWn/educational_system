package edu.md.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.md.exam.model.Academy;

import java.util.List;

public interface AcademyMapper extends BaseMapper<Academy> {
    List<Academy> findAll();

    int update(Academy academy);
}
