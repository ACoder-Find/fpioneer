package com.benpencil.fpioneer.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;

import com.benpencil.fpioneer.bean.Result;
import com.benpencil.fpioneer.bean.UmsMember;
import com.benpencil.fpioneer.bean.UmsMemberReceiveAddress;
import com.benpencil.fpioneer.service.UserService;
import com.benpencil.fpioneer.user.mapper.UmsMemberReceiveAddressMapper;
import com.benpencil.fpioneer.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMembers = userMapper.selectAll();//userMapper.selectAllUser();

        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {

        // 封装的参数对象
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);


//       Example example = new Example(UmsMemberReceiveAddress.class);
//       example.createCriteria().andEqualTo("memberId",memberId);
//       List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(example);

        return umsMemberReceiveAddresses;
    }

    @Override
    public  Result getResult(String username ,String password) {
       UmsMember umsMember = new UmsMember();
       umsMember.setUsername(username);
       List<UmsMember> umsMemberList = userMapper.select(umsMember);
       if(umsMemberList.size()==0){
           umsMember.setPassword(password);
           userMapper.insert(umsMember);
           Result result  = new Result();

           result.setMessage("注册成功");
           result.setSucceed(true);
           return result ;
       }

       else{
           if (umsMemberList.get(0).getPassword().equals(password)){
               Result result = new Result()  ;

               result.setMessage("登录成功");
               result.setSucceed(true);
               return result ;
           }
           else{
               Result  result  = new Result();


               result.setMessage("密码输入错误或者账号已存在");
               result.setSucceed(false);
               return result ;
           }

       }

    }
}
