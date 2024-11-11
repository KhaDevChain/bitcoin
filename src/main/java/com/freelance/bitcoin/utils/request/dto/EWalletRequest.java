package com.freelance.bitcoin.utils.request.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.freelance.bitcoin.model.EWallet;
import com.freelance.bitcoin.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EWalletRequest {
    private String uniqueId;
    private double usdt = 0;
    private User user;
    private EWallet ewallet;
    private List<EWallet> eWallets_;
    private Page<EWallet> pageEWallet_;
}
