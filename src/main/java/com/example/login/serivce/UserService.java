package com.example.login.serivce;

import com.example.login.bean.CodeConstant;
import com.example.login.bean.Result;
import com.example.login.bean.User;
import com.example.login.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {

    @Autowired
    private UserMapper userMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private Result<User> mResult = new Result<>();

    /**
     * 注册
     *
     * @param user 参数封装
     * @return Result
     */
    public Result<User> register(User user) {
        restart();
        User selectUser = selectUser(user);

        if (selectUser == null) {
            int insert = userMapper.insert(user);
            if (insert >= 1) {
                mResult.setCode(CodeConstant.SUCCESS);
                mResult.setMsg("账号注册成功");
                mResult.setDetail(selectUser(user));
            }
        } else {
            mResult.setCode(-1);
            mResult.setMsg("账号已经注册");
            mResult.setDetail(selectUser(user));
        }
        return mResult;
    }

    /**
     * 登录
     *
     * @param user 用户名和密码
     * @return Result
     */
    public Result<User> login(User user) {
        restart();
        User selectUser = selectUser(user);

        // 判断账号是否为满足要求
        if (selectUser != null
                && user.getAccountNumber().equals(selectUser.getAccountNumber())
                && user.getPassword().equals(selectUser.getPassword())) {

            mResult.setCode(CodeConstant.SUCCESS);
            mResult.setMsg("登录成功");
            mResult.setDetail(selectUser(user));
        } else {
            mResult.setCode(CodeConstant.FAIL);
            mResult.setMsg("登录失败");
            mResult.setDetail(selectUser(user));
        }
        return mResult;
    }

    // 重置返回的Result
    private void restart() {
        mResult.setCode(-1);
        mResult.setMsg("");
        mResult.setDetail(null);
    }

    // 查询数据库是否存在该用户
    private User selectUser(User user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("account_number", user.getAccountNumber());
        List<User> users = userMapper.selectByMap(map);
        if (users.size() == 0) {
            return null;
        }
        logger.info("register user: " + users.toString());
        return users.get(0);
    }
}
