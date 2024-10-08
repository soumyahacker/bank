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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

@RestController
@RequestMapping("/api/bankuserdetails")
public class BankController {

    private static final Logger logger = LoggerFactory.getLogger(BankController.class);
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
        logger.info("Received request to create a new bank account for user: {}", bankUsersdetailsDTO.getUserId());
        BankUsersdetailsDTO createdAccount = bankUserDetailsService.CreateAccountBank(bankUsersdetailsDTO);
        logger.info("Bank account successfully created for user: {}", bankUsersdetailsDTO.getUserId());
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
        logger.info("Searching for bank account with userId: {}", userId);
        BankUsersdetailsDTO bankUsersdetailsDTO = bankUserDetailsService.getBankDetailsbyId(userId);
        logger.info("Account found for userId: {}", userId);
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
        logger.info("Deposit request for userId: {} with amount: {}", userId, amount);
        BankUsersdetailsDTO bankUsersdetailsDTO = bankUserDetailsService.depositMoney(amount, userId);
        logger.info("Amount {} successfully deposited to account of userId: {}", amount, userId);
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
        logger.info("Request to delete account for userId: {}", userId);
        BankUsersdetailsDTO bankUsersdetailsDTO = bankUserDetailsService.deleteBankDetailsbyID(userId);
        logger.info("Bank account with userId: {} successfully deleted", userId);
        return ResponseEntity.ok(bankUsersdetailsDTO);
    }
}
