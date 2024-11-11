package com.freelance.bitcoin.utils.request.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.freelance.bitcoin.model.Bill;
import com.freelance.bitcoin.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {
    private String sku;
    private String content;
    private Boolean isConfirm = false;
    private User user;
    private Bill ewallet;
    private List<Bill> bills_;
    private Page<Bill> pageBills_;
}
