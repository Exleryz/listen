package com.listen.service;

import com.listen.domain.Student;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

public interface StudentService {

    /**
     * 根据学生账号 查找学生是否存在
     *
     * @param student
     */
    void saveStudent(Student student);

    /**
     * 根据学生账号校验登录密码
     *
     * @param student
     * @return
     */
    Student findStudentById(Student student);

    /**
     * 查找账号是否可用
     *
     * @param account
     */
    void findStudentByAccount(String account);

    /**
     * 制作学生定级单词 随机 试卷
     *
     * @return
     */
    JSON initGradetest();

    /**
     * 初始化学生等级
     *
     * @param s
     * @param score
     */
    void initGradeCode(Student s, float score);

    void openNewCheckPoint(Student s, String checkcount);

    /**
     * 获得当前关卡的题库池(每个题目)
     * 未完成(随机)
     *
     * @param grade
     * @param checkId
     * @return
     */
    String getCurrentCheckPool(Integer grade, Integer checkId);

    /**
     * 保存当次闯关分数
     *
     * @param grade   等级
     * @param checkId 关数
     * @param score   分数
     */
    void saveScore(Integer grade, Integer checkId, Integer score, Student student);

    // 分页业务方法

    /**
     * 所有关数的历史做题记录 分页
     *
     * @param student
     * @param currentPage
     * @param pageSize
     * @return
     */
    JSONObject getPageBean(Student student, Integer currentPage, Integer pageSize);

    /**
     * 当前关数的历史做题记录 分页
     *
     * @param stu
     * @param currentPage
     * @param checkPoint
     * @param pageSize
     * @return
     */
    JSONObject getCurrentPageBean(Student stu, Integer currentPage, Integer checkPoint, int pageSize);
}
