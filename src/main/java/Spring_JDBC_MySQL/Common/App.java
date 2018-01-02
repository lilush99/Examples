package Spring_JDBC_MySQL.Common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import Spring_JDBC_MySQL.dao.CustomerDAO;
import Spring_JDBC_MySQL.Model.Customer;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Module.xml");

        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");

        //Creating the customer table if it doesnt exists
        customerDAO.CreateCustomerTable();

        //adding a customer
        Customer customer = new Customer(3, "Eyal",28);
        customerDAO.insert(customer);

        //finding a customer and printing it
        Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println(customer1);

    }
}
