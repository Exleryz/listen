package com.listen.service.impl;

import com.listen.dao.LibraryDao;
import com.listen.dao.LibraryPoolDao;
import com.listen.dao.SysStudentLibraryPoolDao;
import com.listen.domain.Library;
import com.listen.domain.LibraryPool;
import com.listen.domain.vo.QuerySysStudentLibraryPoolVo;
import com.listen.domain.SysStudentLibraryPool;
import com.listen.domain.vo.SysStudentLibraryPoolVo;
import com.listen.service.AdminService;
import com.listen.utils.PageBean;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName AdminServiceImpl
 *
 * @author Exler
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
    public PageBean getQueryRecords(int currentPage, int pageSize, QuerySysStudentLibraryPoolVo vo) {
        StringBuffer sb = new StringBuffer();
        sb = getQueryCondition(sb, vo);
        int totalCount = sysStudentLibraryPoolDao.getQueryCount(getQueryCountSQL(sb), vo);
//        int totalCount = 10;
        PageBean pb = new PageBean(currentPage, totalCount, 20);
        List<SysStudentLibraryPool> list = sysStudentLibraryPoolDao.getQueryList(pb, sb, vo);
        List<SysStudentLibraryPoolVo> voList = new ArrayList<SysStudentLibraryPoolVo>();
        if (list != null) {
            for (SysStudentLibraryPool sysStudentLibraryPool : list) {
                SysStudentLibraryPoolVo sysVo = new SysStudentLibraryPoolVo();
                sysVo.setId(sysStudentLibraryPool.getId());
                sysVo.setId(sysStudentLibraryPool.getId());
                sysVo.setScore(sysStudentLibraryPool.getScore());
                sysVo.setTime(sysStudentLibraryPool.getTime());
                sysVo.setClassify(sysStudentLibraryPool.getClassify());
                sysVo.setStuId(sysStudentLibraryPool.getStu().getId().toString());
                sysVo.setLpId(sysStudentLibraryPool.getLp().getId().toString());
                sysVo.setStudentName(sysStudentLibraryPool.getStu().getName());
                voList.add(sysVo);
            }
        }
        pb.setList(voList);
        return pb;
    }

    /**
     * max(score) as score,\n 可变 score
     * @param sb
     * @return
     */
    private StringBuffer getQueryCountSQL(StringBuffer sb) {
        StringBuffer countSB = new StringBuffer();
        countSB.append("select\n" +
                "  count(*)\n" +
                "from (\n" +
                "       select\n" +
                "         sys.id,\n" +
                "         max(score) as score,\n" +
                "         time,\n" +
                "         count,\n" +
                "         classify,\n" +
                "         stuId,\n" +
                "         lpId\n" +
                "       from SysStudentLibraryPool sys where 1 = 1  and stuId in (select distinct (stuId)\n" +
                "                                                             from SysStudentLibraryPool\n" +
                "                                                             where 1 = 1)\n" +
                "       group by lpId, stuId\n" +
                "       order by lpId\n" +
                "     ) t;");
        return countSB;
    }

    /**
     * select
     * id,
     * max(score) as score,
     * time,
     * count,
     * classify,
     * stuId,
     * lpId
     * from SysStudentLibraryPool
     * where 1 = 1 and stuId in (select distinct (stuId)
     * from SysStudentLibraryPool
     * where 1 = 1)
     * group by lpId, stuId 分组可去
     * order by score desc;
     */
    private StringBuffer getQueryCondition(StringBuffer sb, QuerySysStudentLibraryPoolVo vo) {
        // 正常查询 查询全部去重 // todo 查询未分页
        sb.append("select\n" +
                "  id,\n" +
                "  max(score) as score,\n" +
                "  time,\n" +
                "  count,\n" +
                "  classify,\n" +
                "  stuId,\n" +
                "  lpId\n" +
                " from SysStudentLibraryPool");
        sb.append(" where 1 = 1 ");
        if (StringUtils.isNotEmpty(vo.getTimeStart())) {
            // 查询时间区间
            sb.append(" and time between ? and ?");
        }
        sb.append(" and stuId in (select distinct (stuId)\n" +
                "                          from SysStudentLibraryPool\n" +
                "                          where 1 = 1)\n" +
                "group by lpId, stuId\n" +
                "order by lpId");
        return sb;
    }
}
