package com.benpencil.fpioneer.service;


import com.benpencil.fpioneer.bean.Result;
import com.benpencil.fpioneer.bean.UmsMember;
import com.benpencil.fpioneer.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

    Result getResult(String username , String password );
}
