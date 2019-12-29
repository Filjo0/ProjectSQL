package Domain;

import blogic.HibernateUtil;
import entity.Address;
import service.AddressService;

import java.sql.SQLException;
import java.util.List;


public class Domain {
    public static void main(String[] args) throws SQLException {

        AddressService addressService = new AddressService();

        System.out.println(addressService.getById(2));

        HibernateUtil.shutdown();
//        List<Address> addressList = addressService.getAll();
//        for (Address e : addressList) {
//            System.out.println(e);
//        }
    }
}
