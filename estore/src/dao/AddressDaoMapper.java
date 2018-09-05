package dao;

import bean.Address;

import java.util.List;

/**
 * Created by Tjl on 2018/9/3 16:30.
 */
public interface AddressDaoMapper {
    public List<Address> findAllAddress();

    public List<Address> findAddressById(int userid);

    public void insertAddress(Address address);

    public void deleteAddress(int id);
}
