package com.smart.common.consts;

/**
 * 常量
 *
 * @author xiaobai
 * @date 2017/10/29 14:59
 **/

public class Constant {


    /**
     * 开发时用的超级管理员id
     */
    public static final long SUPER_ADMIN = 1L;

    /**
     * 用户的权限集合在session中的key
     */
    public static final String USER_PERMS = "USER_PERMS";

    /**
     * 当前系统用户在session里面的key
     */
    public static String CURRENT_USER = "CURRENT_USER";

    /**
     * 令牌在header中的key
     */
    public static String TOKEN_KEY = "AUTH-TOKEN";


    /**
     * 权限类型
     *
     * @author xiaobai
     * @date 2017/10/30 10:37
     **/
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        private MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}
