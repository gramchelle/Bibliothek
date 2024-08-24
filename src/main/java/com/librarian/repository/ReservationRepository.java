package com.librarian.repository;

import com.librarian.dto.responseDto.ReservationGetResponseDto;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import com.librarian.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStatusContainingIgnoreCase(String status);
    List<ReservationGetResponseDto> getReservationsByMemberId(Long memberId);
//    List<Reservation> findByMemberOrderByReservationDateDesc(Member member);
    List<Reservation> findByStatus(ReservationStatus status);
    @Query("SELECT r FROM Reservation r WHERE LOWER(r.status) = LOWER(:status)")
    List<Reservation> findByStatusIgnoreCase(@Param("status") String status);
}
