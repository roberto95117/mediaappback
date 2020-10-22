package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.model.ResetToken;
import com.xocop.mediaappbackend.repo.IResetToken;
import com.xocop.mediaappbackend.service.IResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl implements IResetTokenService {

    @Autowired
    private IResetToken repo;

    @Override
    public ResetToken findByToken(String token) {
        return  this.repo.findByToken(token);
    }

    @Override
    public void guardar(ResetToken token) {
        this.repo.save(token);
    }

    @Override
    public void elimimnar(ResetToken token) {
        this.repo.delete(token);
    }
}
