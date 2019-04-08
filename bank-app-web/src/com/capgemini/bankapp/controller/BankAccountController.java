package com.capgemini.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.bankapp.exception.BankAccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.impl.BankAccountServiceImpl;

@WebServlet(urlPatterns = { "*.do" }, loadOnStartup = 1)
public class BankAccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BankAccountService bankService;

	public BankAccountController() {
		bankService = new BankAccountServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String path =request.getServletPath();
		System.out.println(path);
	
		if(path.equals("/addNewBankAccount.do")) {
			String accountHolderName = request.getParameter("name");
			String accountType = request.getParameter("account");
			double balance = Double.parseDouble(request.getParameter("balance"));
		
		BankAccount account = new BankAccount(accountHolderName,accountType,balance);
		if(bankService.addNewBankAccount(account)) {
			out.println("<h2>Bank Account Created Successfully....</h2");
			out.println("<h2><a href='index.html'>|Home|</h2>");
			out.close();
		}
		
		if (path.equals("/withdrawAmount.do")) {
			double accountBalance = 0;
			int accountNumber = Integer.parseInt(request.getParameter("accountno"));
			double amount = Double.parseDouble(request.getParameter("amount"));

			try {
				accountBalance = bankService.withdraw(accountNumber, amount);
				out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");

				out.println("<h2>Withdraw amount " + accountBalance + " successfully");

			} catch (LowBalanceException e) {
				out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");

				out.println("<h2>Insufficient fund</h2>");
				// e.printStackTrace();
			} catch (BankAccountNotFoundException e) {
				out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");

				out.println("<h2>Bank account is not found</h2>");
				// e.printStackTrace();
			}

			out.close();
		}
		if(path.equals("/deleteAccount.do")) {

			int accountNumber = Integer.parseInt(request.getParameter("accountno"));

			boolean accountResult;
			try {
				accountResult = bankService.deleteBankAccount(accountNumber);
				out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");
				out.println("<h2>Your account is deleted");
			} catch (BankAccountNotFoundException e) {
				out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");
				out.println("<h2>bank account is not found");
				//e.printStackTrace();
			}
		}
		if (path.equals("/depositAmount.do")) {

			int accountNumber = Integer.parseInt(request.getParameter("accountno"));
			double amount = Double.parseDouble(request.getParameter("amount"));

			double accountBalance = 0;
			try {
				balance = bankService.deposit(accountNumber, amount);
				out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");
				out.println("<h2>Deposit amount " + accountBalance + " successfully");
			} catch (BankAccountNotFoundException e) {
				out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");
				out.println("<h2>bank account is not found");
				//e.printStackTrace();
			}

			out.close();

		}

		 if (path.equals("/fundTransfer.do")) {

			int fromAccount = Integer.parseInt(request.getParameter("FromAccount"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			int toAccount = Integer.parseInt(request.getParameter("ToAccount"));

			double accountBalance = 0;
			try {
				balance = bankService.fundTransfer(fromAccount, toAccount, amount);
				out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");
				out.println("<h2>Transcation successful");

			} catch (LowBalanceException e) {

				out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");
				out.println("<h2>You have insufficient fund");
			} catch (BankAccountNotFoundException e) {

				// e.printStackTrace();
				
				out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");
				out.println("<h2>bank account is not found");
			}

			out.close();

		}
		
		  if (path.equals("/checkBalance.do")) {

				int accountNumber = Integer.parseInt(request.getParameter("accountno"));

				double accountBalance = 0;
				try {
					accountBalance = bankService.checkBalance(accountNumber);
					out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");
					out.println("<h2>Your balance is  " + accountBalance);
				} catch (BankAccountNotFoundException e) {
					out.println("<br><h2><a href='main_index.html'>|Home|</a></h2><br>");
					out.println("<h2>bank account is not found");
					//e.printStackTrace();
				}

				out.close();

			}

		}
	}
}
