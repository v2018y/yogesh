package com.vany.repositeroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vany.model.OpenSateBar;

public interface OpenStateRepo extends JpaRepository<OpenSateBar, Integer> {
//	Page<OpenSateBar> findByBarId(Integer id, Pageable pageable);	
//    Optional<OpenSateBar> findByIdAndBarId(Integer id, Integer postId);
}
