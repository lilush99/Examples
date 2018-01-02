package Spring_JDBC_MySQL.dao;

import Spring_JDBC_MySQL.Model.Customer;

public interface CustomerDAO
{
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
    public void CreateCustomerTable();
}
