package com.BankingApplicationForSoumya.bank.controller;

import com.BankingApplicationForSoumya.bank.Service.BankUserDetailsService;
import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/bankuserdetails")
public class BankController {

    private final BankUserDetailsService bankUserDetailsService;

    public BankController(BankUserDetailsService bankUserDetailsService) {
        this.bankUserDetailsService = bankUserDetailsService;
    }

    @Operation(summary = "Create a new bank account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankUsersdetailsDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/create")
    public ResponseEntity<BankUsersdetailsDTO> addAccount(@RequestBody BankUsersdetailsDTO bankUsersdetailsDTO) {
        BankUsersdetailsDTO createdAccount = bankUserDetailsService.CreateAccountBank(bankUsersdetailsDTO);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @Operation(summary = "Search for a bank account by user ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankUsersdetailsDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @GetMapping("/search/{userId}")
    public ResponseEntity<BankUsersdetailsDTO> searchAccountByID(@PathVariable int userId) {
        BankUsersdetailsDTO bankUsersdetailsDTO = bankUserDetailsService.getBankDetailsbyId(userId);
        return ResponseEntity.ok(bankUsersdetailsDTO);
    }

    @Operation(summary = "Deposit money into a bank account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Money deposited",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankUsersdetailsDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/deposit/{userId}")
    public ResponseEntity<BankUsersdetailsDTO> depositMoneyToBank(@RequestBody Map<String, Double> request, @PathVariable int userId) {
        Double amount = request.get("amount");
        BankUsersdetailsDTO bankUsersdetailsDTO = bankUserDetailsService.depositMoney(amount, userId);
        return ResponseEntity.ok(bankUsersdetailsDTO);
    }

    @Operation(summary = "Delete a bank account by user ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankUsersdetailsDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<BankUsersdetailsDTO> deleteBankAccountById(@PathVariable int userId) {
        BankUsersdetailsDTO bankUsersdetailsDTO = bankUserDetailsService.deleteBankDetailsbyID(userId);
        return ResponseEntity.ok(bankUsersdetailsDTO);
    }
}
