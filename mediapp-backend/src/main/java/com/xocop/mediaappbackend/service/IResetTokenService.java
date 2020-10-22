package com.xocop.mediaappbackend.service;

import com.xocop.mediaappbackend.model.ResetToken;

public interface IResetTokenService {
    ResetToken findByToken(String token);
    void guardar(ResetToken token);
    void elimimnar(ResetToken token);

}
