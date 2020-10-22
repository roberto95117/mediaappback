package com.xocop.mediaappbackend.repo;

import com.xocop.mediaappbackend.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResetToken extends JpaRepository<ResetToken, Integer> {
    ResetToken findByToken(String token);
}
