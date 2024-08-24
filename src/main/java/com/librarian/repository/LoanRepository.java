package com.librarian.repository;

import com.librarian.model.Loan;
import com.librarian.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByMemberId(Long memberId);
    List<Loan> findByMemberOrderByLoanDateDesc(Member member);

}

