package com.freelance.bitcoin.utils.response.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.freelance.bitcoin.model.Bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillResponse {
    private int status = 500;
    private String message = "";
    private Bill bill = null;
    private List<Bill> bills_ = null;
    private Page<Bill> pageBills_ = null;
}
