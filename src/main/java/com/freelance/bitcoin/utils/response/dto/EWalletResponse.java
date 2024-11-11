package com.freelance.bitcoin.utils.response.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.freelance.bitcoin.model.EWallet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EWalletResponse {
    private int status = 500;
    private String message = "";
    private EWallet ewallet = null;
    private List<EWallet> ewallets_ = null;
    private Page<EWallet> pageEwallets_ = null;
}
