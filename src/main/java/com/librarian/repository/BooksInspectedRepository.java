package com.librarian.repository;

import com.librarian.model.BooksInspected;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksInspectedRepository extends CrudRepository<BooksInspected, Long> {

    /* Belirli bir kitabı denetleyen tüm kayıtları bulur
    List<BooksInspected> findAllByBookId(Long bookId);

    // Belirli bir üye tarafından denetlenen tüm kitapları bulur
    List<BooksInspected> findAllByMemberId(Long memberId);

    // Belirli bir tarihte denetlenen tüm kitapları bulur
    List<BooksInspected> findAllByInspectionDate(String inspectionDate);

     */
}
