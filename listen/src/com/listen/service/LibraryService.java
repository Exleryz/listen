package com.listen.service;

import com.listen.domain.Library;
import com.listen.domain.Subject;

import java.util.List;

public interface LibraryService {
    void saveLibrary(Library library, List<Subject> subjectList);
}
