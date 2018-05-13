package com.listen.service;

import com.listen.domain.Library;
import com.listen.domain.LibraryPool;
import net.sf.json.JSONObject;

import java.util.List;

public interface AdminService {

    JSONObject getCurrentCheckScoreSet(int currentCheck, int currentGrade);

    LibraryPool getSetByGAndC(int currentCheck, int currentGrade);

    Library getLibraryDetails(Integer id);
}
