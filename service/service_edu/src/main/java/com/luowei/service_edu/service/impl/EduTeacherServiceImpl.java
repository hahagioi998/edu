package com.luowei.service_edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luowei.service_edu.entity.EduTeacher;
import com.luowei.service_edu.mapper.EduTeacherMapper;
import com.luowei.service_edu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author luowei
 * @since 2020-08-15
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageParam) {
        //1 分页查询讲师的方法
            QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
            wrapper.orderByDesc("id");
            //把分页数据封装到pageTeacher对象
            baseMapper.selectPage(pageParam, wrapper);

            List<EduTeacher> records = pageParam.getRecords();
            long current = pageParam.getCurrent();
            long pages = pageParam.getPages();
            long size = pageParam.getSize();
            long total = pageParam.getTotal();
            boolean hasNext = pageParam.hasNext();//下一页
            boolean hasPrevious = pageParam.hasPrevious();//上一页

            //把分页数据获取出来，放到map集合
            Map<String, Object> map = new HashMap<>();
            map.put("items", records);
            map.put("current", current);
            map.put("pages", pages);
            map.put("size", size);
            map.put("total", total);
            map.put("hasNext", hasNext);
            map.put("hasPrevious", hasPrevious);

            //map返回
            return map;
        }

}
