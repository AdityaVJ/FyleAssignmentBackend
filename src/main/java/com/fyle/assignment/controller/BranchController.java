package com.fyle.assignment.controller;

import com.fyle.assignment.model.Branch;
import com.fyle.assignment.repository.BranchRepository;
import com.fyle.assignment.utils.Lists;
import com.fyle.assignment.utils.OffsetBasedPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin
public class BranchController {

    @Autowired
    private BranchRepository branchRepository;

    @PostMapping("/api/branches")
    public String createBank(@RequestBody Branch branch) {
        branchRepository.save(branch);
        return "Bank added successfully!";
    }

    @GetMapping("/api/branches")
    public HashMap<String, Object> getBranchesByPage(@RequestParam(name = "page") int pageNumber,
                                                     @RequestParam(name = "items") int itemsPerPage) {
        Pageable pageable = PageRequest.of(pageNumber, itemsPerPage, Sort.by("bankIFSC").ascending());
        List<Branch> branchList = Lists.makeList(branchRepository.findAll(pageable));
        Long count = branchRepository.count();

        HashMap<String, Object> response = new HashMap<>();
        response.put("totalCount", count);
        response.put("currentCount", branchList.size());
        response.put("branches", branchList);

        return response;
    }

    @GetMapping("/api/branches/autocomplete")
    public List<Branch> autocompleteBankSearch(@RequestParam(name = "q") String query,
                                               @RequestParam int limit,
                                               @RequestParam int offset) {
        Pageable paging = new OffsetBasedPageRequest(offset, limit);
        return branchRepository.autocompleteBranchName(query.toUpperCase(Locale.ROOT), paging).getContent();
    }

    @GetMapping("/api/branches/search")
    public List<Branch> search(@RequestParam("q") String terms,
                               @RequestParam int limit,
                               @RequestParam int offset) {

        Pageable paging = new OffsetBasedPageRequest(offset, limit);
        return branchRepository.searchBanks(terms.toUpperCase(Locale.ROOT), paging).getContent();
    }
}
