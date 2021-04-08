package com.huang.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author Cucumber
 * @Description
 * @Date Created in 2021-04-06 14:52
 */
@ApiModel("用户实体类")//放在方法体上
public class User {

    @ApiModelProperty("用户名")
    public String username;
    @ApiModelProperty("密码")
    public String password;

}
