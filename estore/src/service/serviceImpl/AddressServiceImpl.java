package service.serviceImpl;

import bean.Address;
import common.util.SqlSessionFactoryUtil;
import dao.AddressDaoMapper;
import service.AddressService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tjl on 2018/9/3 16:30.
 */
public class AddressServiceImpl implements AddressService {
    private AddressDaoMapper addressDaoMapper;
    {
        addressDaoMapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(AddressDaoMapper.class);
    }

    @Override
    public List<Address> findallAddress() {
        List<Address> allAddress = addressDaoMapper.findAllAddress();
        return allAddress;
    }

    @Override
    public List<Address> findAddressById(int id) {
        return addressDaoMapper.findAddressById(id);
    }

    @Override
    public void insertAddress(int userId,String name, String phone, String info) {
        Address address = new Address(userId, name, phone, info);
        addressDaoMapper.insertAddress(address);
    }


    @Override
    public void updateAddress() {

    }

    @Override
    public void deleteAddress(int id) {
        addressDaoMapper.deleteAddress(id);
    }


}
