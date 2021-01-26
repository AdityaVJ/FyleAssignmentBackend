package com.fyle.assignment.repository;

import com.fyle.assignment.model.Branch;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface BranchRepository extends PagingAndSortingRepository<Branch, Integer> {

    @Query("SELECT b FROM branches b where b.bankBranch like %:keyword% ORDER BY b.bankIFSC ASC")
    Slice<Branch> autocompleteBranchName(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT b FROM branches b where concat(b.bankIFSC, b.bankCity, b.bankBranch, b.bankAddress, b.bankDistrict, b.bankState) like %:keyword% ORDER BY b.bankIFSC ASC")
    Slice<Branch> searchBanks(@Param("keyword") String keyword, Pageable pageable);
}
