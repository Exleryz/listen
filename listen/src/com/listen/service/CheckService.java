package com.listen.service;

import com.listen.domain.LibraryPool;

public interface CheckService {
    void setLibraryPool(LibraryPool libraryPool);

    void saveLibToLibPool(int lpId, int libId);

    void deleteLibByLibPool(int lpId, int libId);
}
