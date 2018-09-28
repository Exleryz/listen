package com.listen.controller;

import com.listen.common.utils.ListenResult;
import com.listen.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Exler
 */

@Controller
@RequestMapping("/vocabulary")
public class VocabularyController {

    @Autowired
    private VocabularyService vocabularyService;

    /**
     * ajax 加载词汇
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/initGrade")
    @ResponseBody
    public ListenResult initGrade() throws Exception {
        ListenResult result = vocabularyService.initGradetest();
        return result;
    }
}
