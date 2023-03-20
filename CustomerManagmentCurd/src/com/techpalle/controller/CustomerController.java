package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.CustomerDao;
import com.techpalle.model.Customer;


@WebServlet("/")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath();
		
		switch(path)
		{
		case "insertForm":
			getInsertForm(request, response);
			break;
		case "/add":
			addCustomer(request, response);
			break;
			default:
				getStartUpPage(request, response);
				break;
		}
	}

	
	private void getInsertForm(HttpServletRequest request, HttpServletResponse response) 
	{
	try {
		RequestDispatcher rd = request.getRequestDispatcher("customer-form.jsp");
		rd.forward(request, response);
	}
	catch (ServletException e) {
		e.printStackTrace();
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
	}
 

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		
		// Reading data from Customer-form page
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		long m = Long.parseLong(request.getParameter("tbMobile"));
		
		// Store the admin given data into model/ Object		
		Customer c = new Customer(n, e, m);
		
		// Insert customer data to db		
		CustomerDao.addCustomer(c);
		
		//Redirect Admin to HomePage(Customer)
		getStartUpPage(request, response);


    		
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			ArrayList<Customer> alCustomer = CustomerDao.getAllCustomers();
			
			RequestDispatcher rd = request.getRequestDispatcher("Customer_list.jsp");
			request.setAttribute("al", alCustomer);
			rd.forward(request, response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}