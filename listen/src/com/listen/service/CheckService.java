package com.listen.service;

import com.listen.domain.LibraryPool;

public interface CheckService {
    void setLibraryPool(LibraryPool libraryPool);

    void saveLibToLibPool(int lpId, Integer[] libIds);

    void deleteLibByLibPool(int lpId, int libId);

    LibraryPool getLPByLPId(Integer lpId);
}
