package com.listen.service.impl;

import com.listen.dao.*;
import com.listen.domain.*;
import com.listen.service.StudentService;
import com.listen.utils.MakeSubject;
import net.sf.json.JSON;

import java.util.List;
import java.util.PrimitiveIterator;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    private VocabularyDao vocabularyDao;

    private LibraryPoolDao libraryPoolDao;

    private LibraryDao libraryDao;

    private SubjectDao subjectDao;

    @Override
    public void saveStudent(Student student) {
        Student existS = studentDao.getByStudentAccount(student.getAccount());
        if (existS != null) {
            throw new RuntimeException("用户名已存在");
        }
        studentDao.save(student);
    }

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

    @Override
    public void findStudentByAccount(String account) {
        if (studentDao.findByStudentAccount(account)) {
            throw new RuntimeException("该账号已存在");
        } else {
            throw new RuntimeException("该账号可以使用");
        }
    }

    @Override
    public JSON initGradetest() {
        List<Vocabulary> list1 = vocabularyDao.getVocs(1, 20);

        JSON initTest = MakeSubject.initTestJson(list1);
        return initTest;
//        return initTest;
    }

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

    @Override
    public void openNewCheckPoint(Student s, String checkcount) {
        studentDao.findByStudentIdAndGrade(s.getId(), s.getGrade());

    }

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

    /**
     * @param grade   等级
     * @param checkId 关数
     * @param score   分数
     */
    @Override
    public void saveScore(Integer grade, Integer checkId, Integer score, Student student) {
        LibraryPool lp = libraryPoolDao.getLpIdByGradeAndCheckId(1, 1);
        Integer count = studentDao.countThisCheckId(student.getAccount(), 1);
//        做题次数
        count += 1;
        studentDao.saveScore(score, count, 0, student.getId(), lp.getId());
        if (score > lp.getScore()) {
//            pass
            student.setCurrentCheck(student.getCurrentCheck() + 1);
            if (checkId < 25 && student.getCurrentCheck() == checkId) {
                student.setCurrentCheck(student.getCurrentCheck() + 1);
            } else {
                student.setCurrentCheck(1);
                student.setGrade(student.getGrade() + 1);
            }
            studentDao.updateStudent(student);
        }
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
