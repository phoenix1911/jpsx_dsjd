package service;

import bean.Address;

import java.util.List;

/**
 * Created by Tjl on 2018/9/3 16:26.
 */
public interface AddressService {
    public List<Address> findallAddress();

    public void insertAddress(int userid,String name,String phone,String info);

    public void updateAddress();

    public void deleteAddress(int id);

}
