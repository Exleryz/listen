package com.listen.service.impl;

import com.listen.dao.*;
import com.listen.domain.*;
import com.listen.service.StudentService;
import com.listen.utils.MakeSubject;
import com.listen.utils.PageBean;
import net.sf.json.JSON;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    private VocabularyDao vocabularyDao;

    private LibraryPoolDao libraryPoolDao;

    private LibraryDao libraryDao;

    private SubjectDao subjectDao;

    /**
     * 根据学生账号 查找学生是否存在
     * @param student
     */
    @Override
    public void saveStudent(Student student) {
        Student existS = studentDao.getByStudentAccount(student.getAccount());
        if (existS != null) {
            throw new RuntimeException("用户名已存在");
        }
        studentDao.save(student);
    }

    /**
     * 根据学生账号校验登录密码
     * @param student
     * @return
     */
    @Override
    public Student findStudentById(Student student) {
        Student existS = studentDao.getByStudentAccount(student.getAccount());
        if (existS == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!existS.getPassword().equals(student.getPassword())) {
            throw new RuntimeException("登录密码错误");
        }
        return existS;
    }

    /**
     * 查找账号是否可用
     * @param account
     */
    @Override
    public void findStudentByAccount(String account) {
        if (studentDao.findByStudentAccount(account)) {
            throw new RuntimeException("该账号已存在");
        } else {
            throw new RuntimeException("该账号可以使用");
        }
    }

    /**
     * 制作学生定级单词 随机 试卷
     * @return
     */
    @Override
    public JSON initGradetest() {
        List<Vocabulary> list1 = vocabularyDao.getVocs(1, 20);

        JSON initTest = MakeSubject.initTestJson(list1);
        return initTest;
//        return initTest;
    }

    /**
     * 初始化学生等级
     * @param s
     * @param score
     */
    @Override
    public void initGradeCode(Student s, Integer score) {
        s.setCurrentCheck(0);
        if (score <= 70) {
            s.setGrade(1);
            studentDao.updateGrade(s);
        } else if (score <= 90) {
            s.setGrade(2);
            studentDao.updateGrade(s);
        } else {
            s.setGrade(3);
            studentDao.updateGrade(s);
        }
    }

    /**
     *
     * @param s
     * @param checkcount
     */
    @Override
    public void openNewCheckPoint(Student s, String checkcount) {
        studentDao.findByStudentIdAndGrade(s.getId(), s.getGrade());
    }

    /**
     *
     * @param grade
     * @param checkId
     * @return
     */
    @Override
    public String getCurrentCheckPool(Integer grade, Integer checkId) {
        // get LibraryPool currentCheck id
        Integer lpId = libraryPoolDao.findLibIdUseCurrentCheckId(grade, checkId);
        // use id get sys_subject_librarypool 题库id
        List<Integer> libIdList = libraryPoolDao.findLibIdUseLpId(lpId);
        // 使用题库id 从 Library获得 标题 资源路径
        List<Library> libraries = libraryDao.findLibUseLibId(libIdList);
        // 利用题库id 从 Sbuject表中寻找题目
        List<Subject> subjects = subjectDao.findSubUseLibId(libIdList);
        System.out.println("\n");
        String jsonString = MakeSubject.initSubject(libraries, subjects);
        return jsonString;
    }

    /** 保存当次闯关分数
     * @param grade   等级
     * @param checkId 关数
     * @param score   分数
     */
    @Override
    public void saveScore(Integer grade, Integer checkId, Integer score, Student student) {
        LibraryPool lp = libraryPoolDao.getLpIdByGradeAndCheckId(grade, checkId);
        Integer count = studentDao.countThisCheckId(student, lp.getId());
//        做题次数
        count += 1;
        studentDao.saveScore(score, count, 0, student.getId(), lp.getId());
        if (score > lp.getScore()) {    // 分数大于规定分数
//            pass
            if (checkId == student.getCurrentCheck() + 1) {    // 做的是该闯的关
                if (checkId < 25) {    // 关数大于总关数
                    student.setCurrentCheck(student.getCurrentCheck() + 1);
                } else {
                    student.setCurrentCheck(0);
                    student.setGrade(student.getGrade() + 1);
                }
                // 更新学生状态
                studentDao.updateStudent(student);
            }
        }

    }

    @Override
    public List<SysStudentLibraryPool> getlist(Student stu) {
        List<SysStudentLibraryPool> list = studentDao.getAllCheckList(stu);
        return list;
    }

    @Override
    public PageBean getPageBean(Student student, Integer currentPage, Integer pageSize) {
        //
        int totalCount = studentDao.getTotalCount(student);
        // 创建PageBean对象
        pageSize = 5;
        PageBean pb = new PageBean(currentPage, totalCount, pageSize);
        List<SysStudentLibraryPool> list = studentDao.getPageList(student, pb.getStart(), pb.getPageSize());
        pb.setList(list);
        return pb;
    }

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public LibraryDao getLibraryDao() {
        return libraryDao;
    }

    public void setLibraryDao(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    public LibraryPoolDao getLibraryPoolDao() {
        return libraryPoolDao;
    }

    public void setLibraryPoolDao(LibraryPoolDao libraryPoolDao) {
        this.libraryPoolDao = libraryPoolDao;
    }

    public VocabularyDao getVocabularyDao() {
        return vocabularyDao;
    }

    public void setVocabularyDao(VocabularyDao vocabularyDao) {
        this.vocabularyDao = vocabularyDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

}
