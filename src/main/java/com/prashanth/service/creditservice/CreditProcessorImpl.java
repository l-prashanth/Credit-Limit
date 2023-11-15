package com.prashanth.service.creditservice;

import com.prashanth.exceptionhandler.exceptionhandler.CreditException;
import com.prashanth.exceptionhandler.exceptionhandler.JWTException;
import com.prashanth.model.credit.CreditResponse;
import com.prashanth.model.customer.Customer;
import com.prashanth.repository.CreditRepository;
import com.prashanth.repository.CustomerRepository;
import com.prashanth.service.customerservice.CustomerProcessorImpl;
import com.prashanth.utils.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.prashanth.exceptionhandler.CreditErrorCode.CUSTOMER_MISSING;
@Service
@AllArgsConstructor
@Slf4j
public class CreditProcessorImpl implements CreditProcessor {

    private CommonUtils commonUtils;
    private CustomerProcessorImpl customerProcessor;
    private CreditRepository creditRepository;


    @Override
    public CreditResponse credit(int id, String token) {
        commonUtils.validateToken(token);
        if (customerProcessor.getCustomerById(id, token).isPresent()) {
            Customer customer = customerProcessor.getCustomerById(id, token).get();
            int customerId = customer.getCustomerId();
            String name = customer.getName();
            int age = customer.getAge();
            int creditScore = customer.getCreditScore();
            long salary = customer.getSalary();
            boolean existingCustomer = customer.isExistingCustomer();
            double monthlySalary = (double) salary / 12;
            if (age > 18 && age < 60) {
                int creditLimit = (int) (((creditScoreCalc(creditScore) * monthlySalary) + (monthlySalary * 0.5)) * existingCustomerCalc(existingCustomer));
                CreditResponse creditResponse = new CreditResponse();
                creditResponse.setCustomerId(customerId);
                creditResponse.setName(name);
                creditResponse.setAge(age);
                creditResponse.setCreditScore(creditScore);
                creditResponse.setSalary(salary);
                creditResponse.setExistingCustomer(existingCustomer);
                creditResponse.setCreditLimit(creditLimit);
                return creditRepository.save(creditResponse);
            }
        }
        throw CreditException.builder()
                .errorCode(CUSTOMER_MISSING.errorCode)
                .errorMessage(CUSTOMER_MISSING.errorMessage)
                .status(CUSTOMER_MISSING.httpStatus).build();
    }
    @Override
    public List<CreditResponse> getAllCustomerCredit(String token) {
        commonUtils.validateToken(token);
        return creditRepository.findAll();
    }

    @Override
    public Optional<CreditResponse> getCustomerCreditById(int id, String token) {
        commonUtils.validateToken(token);
        return creditRepository.findById(id);
    }

    @Override
    public String deleteCustomerCredit(int id, String token) {
        commonUtils.validateToken(token);
        creditRepository.deleteById(id);
        return "Customer deleted successfully";
    }

    public double existingCustomerCalc(boolean existingCustomer) {
        if (existingCustomer) {
            return 1.25;
        }
        return 0.75;
    }

    public double creditScoreCalc(int score) {
        int minScore = 300;
        int level1Score = 450;
        int level2Score = 600;
        int level3Score = 700;
        int level4Score = 800;
        int maxScore = 900;

        if (score > minScore) {
            if (score < level1Score) {
                return 0.25;
            } else if (score < level2Score) {
                return 0.4;
            } else if (score < level3Score) {
                return 0.5;
            } else if (score < level4Score) {
                return 0.6;
            } else if (score < maxScore) {
                return 0.7;
            }
        }
        return 0;
    }
}
