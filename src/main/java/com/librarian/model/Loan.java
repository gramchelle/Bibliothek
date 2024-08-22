package com.librarian.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @Column
    private LocalDate loanDate;

    @Column
    private LocalDate dueDate;

    @Column
    private LocalDate returnDate;

    @Column
    private String status;

    public static LoanBuilder builder() {
        return new LoanBuilder();
    }

    public static class LoanBuilder {
        private Long id;
        private Book book;
        private Member member;
        private LocalDate loanDate;
        private LocalDate dueDate;
        private LocalDate returnDate;
        private String status;

        public LoanBuilder book(Book book) {
            this.book = book;
            return this;
        }

        public LoanBuilder member(Member member) {
            this.member = member;
            return this;
        }

        public LoanBuilder loanDate(LocalDate loanDate) {
            this.loanDate = loanDate;
            return this;
        }

        public LoanBuilder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public LoanBuilder returnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public LoanBuilder status(String status) {
            this.status = status;
            return this;
        }

        public Loan build() {
            Loan loan = new Loan();
            loan.book = this.book;
            loan.member = this.member;
            loan.loanDate = this.loanDate;
            loan.dueDate = this.dueDate;
            loan.returnDate = this.returnDate;
            loan.status = this.status;
            return loan;
        }
    }
}
