package com.listen.service.impl;

import com.listen.dao.LibraryDao;
import com.listen.dao.LibraryPoolDao;
import com.listen.dao.SysStudentLibraryPoolDao;
import com.listen.domain.Library;
import com.listen.domain.LibraryPool;
import com.listen.domain.SysStudentLibraryPoolVo;
import com.listen.service.AdminService;
import com.listen.utils.PageBean;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * FileName AdminServiceImpl
 * Created by Exler
 * Time 2018-08-30 14:20
 * Description: 管理员service
 */

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private LibraryPoolDao libraryPoolDao;
    @Autowired
    private LibraryDao libraryDao;
    @Autowired
    private SysStudentLibraryPoolDao sysStudentLibraryPoolDao;

    /**
     * 获得当前关卡的设置信息
     *
     * @param currentCheck
     * @param currentGrade
     * @return Json
     */
    @Override
    public JSONObject getCurrentCheckScoreSet(int currentCheck, int currentGrade) {
        LibraryPool lp = libraryPoolDao.getLpByGradeAndCheck(currentGrade, currentCheck);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"teacher", "libraryPoolSet"});
        JSONObject jsonObject = JSONObject.fromObject(lp, jsonConfig);
        return jsonObject;
    }

    /**
     * 获得当前关卡的设置信息 用于回显数据
     *
     * @param currentCheck
     * @param currentGrade
     * @return
     */
    @Override
    public LibraryPool getSetByGAndC(int currentCheck, int currentGrade) {
        LibraryPool lp = libraryPoolDao.getLpByGradeAndCheck(currentGrade, currentCheck);
        return lp;
    }

    /**
     * 获得单题数据 回显
     *
     * @param id
     * @return
     */
    @Override
    public Library getLibraryDetails(Integer id) {
        System.out.println(id);
        Library l = libraryDao.findById(id);
        return l;
    }

    /**
     * 查询根据条件查询学生记录
     *
     * @param currentPage
     * @param pageSize
     * @param vo
     * @return
     */
    @Override
    public PageBean getQueryRecords(int currentPage, int pageSize, SysStudentLibraryPoolVo vo) {
        StringBuffer sb = new StringBuffer();
        // 正常查询 查询全部 // todo 查询未分页
        sb.append("select\n" +
                "  id,\n" +
                "  max(score) as score,\n" +
                "  time,\n" +
                "  count,\n" +
                "  classify,\n" +
                "  stuId,\n" +
                "  lpId\n" +
                "from sysstudentlibrarypool");
        // 正常查询 查询全部
        sb.append("where 1 = 1 ");
        if (StringUtils.isNotEmpty(vo.getTimeStart())) {
            // 查询时间区间
            sb.append(" and time between '" + vo.getTimeStart() + "' and '" + vo.getTimeEnd() + "'");
        }
        sb.append(" and stuId in (select distinct (stuId)\n" +
                "                          from sysstudentlibrarypool\n" +
                "                          where 1 = 1)\n" +
                "group by lpId, stuId\n" +
                "order by lpId;");
        // 学生姓名
//        List<SysStudentLibraryPoolVo> list = sysStudentLibraryPoolDao.queryList(sb);
        /**
         * select
         *   id,
         *   max(score) as score,
         *   time,
         *   count,
         *   classify,
         *   stuId,
         *   lpId
         * from sysstudentlibrarypool
         * where 1 = 1 and stuId in (select distinct (stuId)
         *                           from sysstudentlibrarypool
         *                           where 1 = 1)
         * group by lpId, stuId
         * order by score desc;
         */
        return null;
    }
}
